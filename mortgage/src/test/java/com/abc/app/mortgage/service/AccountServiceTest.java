package com.abc.app.mortgage.service;

import com.abc.app.mortgage.entity.Account;
import com.abc.app.mortgage.exception.AccountNotFoundForThisUser;
import com.abc.app.mortgage.repository.AccountRepository;
import com.abc.app.mortgage.request.AccountRequest;
import com.abc.app.mortgage.response.AccountResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
class AccountServiceTest {

    @Mock
    private AccountRepository accountRepository;

    @InjectMocks
    private AccountService accountService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this); // Initialize the mocks
    }

    @Test
    void testGetAccountsByUserId_WhenAccountsExist() throws AccountNotFoundForThisUser {
        AccountRequest accountRequest = new AccountRequest();
        accountRequest.setUserId("usr123");

        Account account1 = new Account();
        account1.setAccountId(1L);
        account1.setAccountName("Saving Account 1");
        account1.setBalanceAmount(new BigDecimal("1000.00"));
        account1.setUpdatedDate(LocalDate.now().atStartOfDay());

        Account account2 = new Account();
        account2.setAccountId(2L);
        account2.setAccountName("Mortgage Account 1");
        account2.setBalanceAmount(new BigDecimal("50000.00"));
        account2.setUpdatedDate(LocalDate.now().atStartOfDay());

        Mockito.when(accountRepository.findByUser_UserId(accountRequest.getUserId()))
                .thenReturn(Arrays.asList(account1, account2));

        List<AccountResponse> response = accountService.getAccountsByUserId(accountRequest);
        assertNotNull(response);
        assertEquals(2, response.size());
        assertEquals("Saving Account 1", response.get(0).getAccountType());
        assertEquals("Mortgage Account 1", response.get(1).getAccountType());
    }

    @Test
    void testGetAccountsByUserId_WhenNoAccountsExist() {
        AccountRequest accountRequest = new AccountRequest();
        accountRequest.setUserId("usr123");
        Mockito.when(accountRepository.findByUser_UserId(accountRequest.getUserId()))
                .thenReturn(List.of());
        AccountNotFoundForThisUser exception = assertThrows(AccountNotFoundForThisUser.class, () -> {
            accountService.getAccountsByUserId(accountRequest);
        });
        assertEquals("Account not found with id usr123", exception.getMessage());
    }

    @Test
    void testGetAccountsByUserId_WhenUserIdIsNull() {
        AccountRequest accountRequest = new AccountRequest();
        accountRequest.setUserId(null);
        Mockito.when(accountRepository.findByUser_UserId(accountRequest.getUserId()))
                .thenReturn(List.of());
        AccountNotFoundForThisUser exception = assertThrows(AccountNotFoundForThisUser.class, () -> {
            accountService.getAccountsByUserId(accountRequest);
        });

        assertEquals("Account not found with id null", exception.getMessage());
    }
}
