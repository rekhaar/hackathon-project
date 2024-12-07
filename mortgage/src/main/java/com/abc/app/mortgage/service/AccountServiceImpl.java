package com.abc.app.mortgage.service.impl;

import com.abc.app.mortgage.dto.ABCPagedResponse;
import com.abc.app.mortgage.dto.SearchDTO;
import com.abc.app.mortgage.entity.Account;
import com.abc.app.mortgage.handler.ABCCustomException;
import com.abc.app.mortgage.repository.AccountRepository;
import com.abc.app.mortgage.util.SearchCriteriaSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class AccountServiceImpl {

  //  @Autowired
  //  AccountRepository accountRepository;

    public ABCPagedResponse<Account> getAccountsBySearchCriteria(List<SearchDTO> dtoList, int pageNumber, int pageSize) {
        if(dtoList.isEmpty())
        return ABCPagedResponse.<Account>builder()
                .data(List.of())
                .totalItems(0L)
                .totalPages(0L)
                .build();
        Pageable page = PageRequest.of(pageNumber,(pageSize == 0 ? 10 : pageSize), Sort.by(Sort.Direction.DESC,"updated_date"));
    return getAccountsBySearchCriteria(dtoList,page);
    }

    public ABCPagedResponse<Account> getAccountsBySearchCriteria(List<SearchDTO> dtoList, Pageable page) {
        List<Account> results = new ArrayList<>();
        results = List.of(new Account(1L,"ABC-123","USER A ACC 1",1L,new BigDecimal(500)),new Account(2L,"ABC-125","USER A ACC 1",1L,new BigDecimal(600)));
        // Below is real implementation once DB is configured
        //SearchCriteriaSpecification specification = (SearchCriteriaSpecification) SearchCriteriaSpecification.constructParentCriteria(dtoList);
        // results = accountRepository.findAll(specification,page);


        return ABCPagedResponse.<Account>builder()
                .data(results)
                .totalItems(0L)
                .totalPages(0L)
                .build();
    }
}
