package com.abc.app.mortgage.service;


import com.abc.app.mortgage.model.Account;
import com.abc.app.mortgage.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public Account getAccountDetails(String id) {
        // Fetch account from the database
        Optional<Account> accountOptional = accountRepository.findById(id);
        return accountOptional.orElseThrow(() -> new RuntimeException("Account not found for ID: " + id));
    }
}
