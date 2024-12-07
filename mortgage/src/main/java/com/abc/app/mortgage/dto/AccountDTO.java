package com.abc.app.mortgage.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public record AccountDTO(
        @JsonProperty("id") Long id,
        @JsonProperty("account_number") String accountNumber,
        @JsonProperty("account_name") String accountName,
        @JsonProperty("user_id") Long userId,
        @JsonProperty("account_balance") BigDecimal accountBalance
) {
}
