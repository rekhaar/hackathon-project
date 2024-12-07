package com.abc.app.mortgage.repository;


import com.abc.app.mortgage.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, String> {
}
