package com.abc.app.mortgage.util;

import com.abc.app.mortgage.dto.SearchDTO;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class SearchCriteriaSpecification {

    public static <T>Specification<T> constructParentCriteria(List<SearchDTO> filterDTOList) {
        return new Specification<T>() {
            @Override
            public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                filterDTOList.forEach(filter -> {
                    Predicate predicate = getPredicate(filter,criteriaBuilder,root);
                    predicates.add(predicate);
                });
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        };
    }

    public static <T> Predicate getPredicate(SearchDTO filter, CriteriaBuilder criteriaBuilder, Root<T> root)  {
        Predicate predicate = null;
        switch (FilterOperatorEnum.valueOf(filter.getFilterOperator())) {
            case EQUALS:
                predicate = criteriaBuilder.equal(root.get(filter.getColumnName()),filter.getColumnValue());
                break;
            case CONTAINS:
                predicate = criteriaBuilder.like(root.get(filter.getColumnName()), "%" + filter.getColumnValue() + "%");
                break;
            default:
                throw new IllegalArgumentException("Operator is not valid");
        }

        return predicate;
    }
}
