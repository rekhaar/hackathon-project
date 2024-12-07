package com.abc.app.mortgage.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abc.app.mortgage.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
	 Optional<Account> findByAccountIdAndAccountTypeAndUserIdAndIsActive(Long accountId, String accountType, Long userId,Boolean isActive);
}