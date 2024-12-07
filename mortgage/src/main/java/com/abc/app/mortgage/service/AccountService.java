package main.java.com.abc.app.mortgage.service;

import main.java.com.abc.app.mortgage.model.Account;
import main.java.com.abc.app.mortgage.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;

    public Account getAccountDetails(String id) {
        return accountRepository.findAccountById(id);
    }
}
