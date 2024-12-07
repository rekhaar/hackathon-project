package com.abc.app.mortgage.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import com.abc.app.mortgage.dto.TransferRequest;
import com.abc.app.mortgage.dto.TransferResponse;
import com.abc.app.mortgage.entity.Account;
import com.abc.app.mortgage.entity.TransactionSummary;
import com.abc.app.mortgage.entity.User;
import com.abc.app.mortgage.repository.AccountRepository;
import com.abc.app.mortgage.repository.TransactionRepository;
import com.abc.app.mortgage.repository.UserRepository;
import com.abc.app.mortgage.util.AccountType;

@ExtendWith(MockitoExtension.class)
public class AccountServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private AccountRepository accountRepository;

    @Mock
    private TransactionRepository transactionRepository;

    @InjectMocks
    @Autowired
    private AccountService accountService;

    private User testUser;
    private Account savingsAccount;
    private Account mortgageAccount;
    private TransferRequest transferRequest;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        
        testUser = new User();
        testUser.setId(1L);
        testUser.setUserName("testUser");

        savingsAccount = new Account();
        savingsAccount.setAccountId(1L);
        savingsAccount.setAccountType(AccountType.SAVINGS.getCode());
        savingsAccount.setUserId(testUser.getId());
        savingsAccount.setBalanceAmount(BigDecimal.valueOf(1000));

        mortgageAccount = new Account();
        mortgageAccount.setAccountId(2L);
        mortgageAccount.setAccountType(AccountType.MORTGAGE.getCode());
        mortgageAccount.setUserId(testUser.getId());
        mortgageAccount.setBalanceAmount(BigDecimal.valueOf(500));

        transferRequest = new TransferRequest();
        transferRequest.setFromAccountId(1L);
        transferRequest.setToAccountId(2L);
        transferRequest.setAmount(BigDecimal.valueOf(200));
        transferRequest.setInstructions("Mortgage Payment");
    }

    @Test
    void transferFunds_successfulTransfer() {
        when(userRepository.findByUserName("testUser")).thenReturn(Optional.of(testUser));
        when(accountRepository.findByAccountIdAndAccountTypeAndUserId(1L, AccountType.SAVINGS.getCode(), 1L))
                .thenReturn(Optional.of(savingsAccount));
        when(accountRepository.findByAccountIdAndAccountTypeAndUserId(2L, AccountType.MORTGAGE.getCode(), 1L))
                .thenReturn(Optional.of(mortgageAccount));
        
        TransferResponse response = accountService.transferFunds("testUser", transferRequest);

        assertEquals("Transfer successful", response.getMessage());
        assertEquals(BigDecimal.valueOf(800), response.getRemainingSavingsBalance());
        assertEquals(BigDecimal.valueOf(300), response.getRemainingOutstandingAmount());

        verify(accountRepository, times(2)).save(any(Account.class));
        verify(transactionRepository, times(1)).save(any(TransactionSummary.class));
    }

    @Test
    void transferFunds_insufficientFundsInSavingsAccount() {
        transferRequest.setAmount(BigDecimal.valueOf(1200));

        when(userRepository.findByUserName("testUser")).thenReturn(Optional.of(testUser));
        when(accountRepository.findByAccountIdAndAccountTypeAndUserId(1L, AccountType.SAVINGS.getCode(), 1L))
                .thenReturn(Optional.of(savingsAccount));
        when(accountRepository.findByAccountIdAndAccountTypeAndUserId(2L, AccountType.MORTGAGE.getCode(), 1L))
                .thenReturn(Optional.of(mortgageAccount));

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            accountService.transferFunds("testUser", transferRequest);
        });

        assertEquals("Insufficient funds in savings account", exception.getMessage());
    }

    @Test
    void transferFunds_mortgagePaymentExceedsOutstandingAmount() {
        transferRequest.setAmount(BigDecimal.valueOf(600));

        when(userRepository.findByUserName("testUser")).thenReturn(Optional.of(testUser));
        when(accountRepository.findByAccountIdAndAccountTypeAndUserId(1L, AccountType.SAVINGS.getCode(), 1L))
                .thenReturn(Optional.of(savingsAccount));
        when(accountRepository.findByAccountIdAndAccountTypeAndUserId(2L, AccountType.MORTGAGE.getCode(), 1L))
                .thenReturn(Optional.of(mortgageAccount));

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            accountService.transferFunds("testUser", transferRequest);
        });

        assertEquals("Payment amount exceeds outstanding amount in mortgage account", exception.getMessage());
    }

    @Test
    void transferFunds_userNotFound() {
        when(userRepository.findByUserName("nonExistentUser")).thenReturn(Optional.empty());

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            accountService.transferFunds("nonExistentUser", transferRequest);
        });

        assertEquals("User not found", exception.getMessage());
    }

    @Test
    void transferFunds_accountNotFound() {
        when(userRepository.findByUserName("testUser")).thenReturn(Optional.of(testUser));
        when(accountRepository.findByAccountIdAndAccountTypeAndUserId(1L, AccountType.SAVINGS.getCode(), 1L))
                .thenReturn(Optional.empty());

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            accountService.transferFunds("testUser", transferRequest);
        });

        assertEquals("Savings account not found", exception.getMessage());
    }
}
