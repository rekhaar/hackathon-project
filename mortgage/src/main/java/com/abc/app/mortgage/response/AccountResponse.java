package com.abc.app.mortgage.response;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class AccountResponse {
    private Long accountNumber;
    private String accountType;
    private BigDecimal availableBalance;
    private LocalDateTime lastTransactionDate;
}
