package com.abc.app.mortgage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abc.app.mortgage.entity.TransactionSummary;


@Repository
public interface TransactionRepository extends JpaRepository<TransactionSummary, Long> {
}
