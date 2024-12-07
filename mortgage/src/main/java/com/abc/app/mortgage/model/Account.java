package com.abc.app.mortgage.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import java.time.LocalDateTime;

@Entity
public class Account {

    @Id
    @NotNull(message = "Account number cannot be null")
    @Size(min = 9, max = 12, message = "Account number must be between 9 and 12 characters")
    private String accountNumber;

    @NotNull(message = "Account type is required")
    @Pattern(regexp = "Savings|Current", message = "Account type must be either 'Savings' or 'Current'")
    private String accountType;

    @NotNull(message = "Available balance is required")
    @PositiveOrZero(message = "Available balance cannot be negative")
    private Double availableBalance;

    @NotNull(message = "Last transaction date is required")
    private LocalDateTime lastTransactionDate;

    // Getters and Setters
}
