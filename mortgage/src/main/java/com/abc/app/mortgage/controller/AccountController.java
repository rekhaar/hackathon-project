package com.abc.app.mortgage.controller;


import com.abc.app.mortgage.model.Account;
import com.abc.app.mortgage.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/api/accounts/{id}")
    public Account getAccountDetails(@PathVariable("id") String id) {
        return accountService.getAccountDetails(id);
    }
}
