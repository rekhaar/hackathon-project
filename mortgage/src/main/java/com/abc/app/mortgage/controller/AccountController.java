package com.abc.app.mortgage.controller;

import com.abc.app.mortgage.exception.AccountNotFoundForThisUser;
import com.abc.app.mortgage.request.AccountRequest;
import com.abc.app.mortgage.response.AccountResponse;
import com.abc.app.mortgage.service.AccountService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api")
public class AccountController {
    private AccountService accountService;

    @Autowired
    public AccountController(final AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/accounts")
    public ResponseEntity<List<AccountResponse>> addEmployee(@Valid @RequestBody AccountRequest accountRequest) throws AccountNotFoundForThisUser {
        return ResponseEntity.ok(accountService.getAccountsByUserId(accountRequest));
    }



}
