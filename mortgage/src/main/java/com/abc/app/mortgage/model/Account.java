package com.abc.app.mortgage.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Account {

    @Id
    @NotBlank(message = "Account number cannot be blank")
    @Pattern(regexp = "\\d{9}", message = "Account number must be exactly 9 digits")
    private String accountNumber;

    @NotBlank(message = "Account type cannot be blank")
    @Pattern(regexp = "Savings|Current", message = "Account type must be either 'Savings' or 'Current'")
    private String accountType;

    @NotNull(message = "Available balance is required")
    @DecimalMin(value = "0.0", inclusive = true, message = "Available balance must be non-negative")
    private BigDecimal availableBalance;

    @NotNull(message = "Last transaction date is required")
    private LocalDateTime lastTransactionDate;

    // Getters and Setters
}
