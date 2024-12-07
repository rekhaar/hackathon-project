package main.java.com.abc.app.mortgage.repository;

import main.java.com.abc.app.mortgage.model.Account;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public class AccountRepository {
    public Account findAccountById(String id) {
        // Mock implementation: returning hardcoded data
        if (id.equals("123")) {
            Account account = new Account();
            account.setAccountNumber("123456789");
            account.setAccountType("Savings");
            account.setAvailableBalance(5000.00);
            account.setLastTransactionDate(LocalDateTime.now()); // Use current system time
            return account;
        }
        return null; // No account found for the given id
    }
}
