package com.abc.app.mortgage.repository;

import com.abc.app.mortgage.entity.Account;
import com.abc.app.mortgage.entity.User;
import com.abc.app.mortgage.response.AccountResponse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Long> {

    List<Account> findByUser_UserId(String userId);
}
