package com.abc.app.mortgage.controller;


import com.abc.app.mortgage.model.Account;
import com.abc.app.mortgage.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/{id}")
    public ResponseEntity<Account> getAccountDetails(@PathVariable("id") String id) {
        Account account = accountService.getAccountDetails(id);
        return ResponseEntity.ok(account);
    }

    @PostMapping
    public ResponseEntity<Account> createAccount(@Valid @RequestBody Account account) {
        // Logic to save the account (omitted for brevity)
        return new ResponseEntity<>(account, HttpStatus.CREATED);
    }
}
