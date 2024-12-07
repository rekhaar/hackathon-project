package com.abc.app.mortgage.repository;

import com.abc.app.mortgage.entity.Account;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
//@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

   // @EntityGraph(attributePaths = {"accountType","user"})
    Page<Account> findAll(Specification<Account> specification, Pageable pageable);
}
