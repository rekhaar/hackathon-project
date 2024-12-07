package com.abc.app.mortgage.service;


import com.abc.app.mortgage.exception.AccountNotFoundException;
import com.abc.app.mortgage.model.Account;
import com.abc.app.mortgage.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public Account getAccountDetails(String id) {
        return accountRepository.findById(id)
                .orElseThrow(() -> new AccountNotFoundException("Account not found for ID: " + id));
    }
}
