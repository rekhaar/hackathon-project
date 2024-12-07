package com.abc.app.mortgage.service;
import com.abc.app.mortgage.entity.Account;
import com.abc.app.mortgage.exception.AccountNotFoundForThisUser;
import com.abc.app.mortgage.repository.AccountRepository;
import com.abc.app.mortgage.request.AccountRequest;
import com.abc.app.mortgage.response.AccountResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class AccountService {

    private final AccountRepository repository;

    @Autowired
    public AccountService(AccountRepository repository) {
        this.repository = repository;
    }
    public List<AccountResponse> getAccountsByUserId(AccountRequest accountRequest) throws AccountNotFoundForThisUser {
        List<Account> accountList = repository.findByUser_UserId(accountRequest.getUserId());
        if(accountList.isEmpty()){
            throw new AccountNotFoundForThisUser("Employee not found with id " + accountRequest.getUserId());
        }
        return accountList.stream().map(i-> AccountResponse.build(i.getAccountId() , i.getAccountName(),
                i.getBalanceAmount(),i.getUpdatedDate())).toList();

    }

}
