package com.abc.app.mortgage.controller;

import com.abc.app.mortgage.converter.AccountConverter;
import com.abc.app.mortgage.dto.ABCPagedResponse;
import com.abc.app.mortgage.dto.AccountDTO;
import com.abc.app.mortgage.dto.SearchDTO;
import com.abc.app.mortgage.entity.Account;
import com.abc.app.mortgage.service.impl.AccountServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Validated
public class AccountController {

    @Autowired
    private AccountServiceImpl accountService;

    @Autowired
    private AccountConverter accountConverter;
    @RequestMapping("/api/isalive")
    public ResponseEntity<String> isAlive(){
        return new ResponseEntity<>("I am available", HttpStatus.OK);
    }

    /**
     * Purpose: Search the list of user's account based on multiple criteria
     * refer: Mockupscreen image file under src/main/resources
     * @param dtos
     * @param pageNumber
     * @param pageSize
     * @return
     */
    @RequestMapping("/api/accounts/search")
    public ResponseEntity< ABCPagedResponse<AccountDTO>> searchAccounts(@Valid @RequestBody List<SearchDTO> dtos, @RequestParam(name="pageNumber") int pageNumber, @RequestParam(name="pageSize") int pageSize){
        ABCPagedResponse<Account> accountList = accountService.getAccountsBySearchCriteria(dtos, pageNumber, pageSize);
        return new ResponseEntity<>(accountConverter.createFromEntities(accountList),HttpStatus.OK);
    }
}
