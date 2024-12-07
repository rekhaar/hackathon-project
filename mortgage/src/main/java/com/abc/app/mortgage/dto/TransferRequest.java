package com.abc.app.mortgage.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class TransferRequest {

	@NotNull(message = "From Account ID cannot be null")
	@Positive(message = "From Account ID must be a positive number")
	private Long fromAccountId; 
	
	@NotNull(message = "To Account ID cannot be null")
    @Positive(message = "To Account ID must be a positive number")
	private Long toAccountId;
	
	@NotNull(message = "Amount cannot be null")
    @DecimalMin(value = "0.01", inclusive = true, message = "Amount must be greater than or equal to 0.01")
	private BigDecimal amount;
	
	@Size(max = 200, message = "Instructions must not exceed 200 characters")
	private String instructions;

	
	public Long getFromAccountId() {
		return fromAccountId;
	}

	public void setFromAccountId(Long fromAccountId) {
		this.fromAccountId = fromAccountId;
	}

	public Long getToAccountId() {
		return toAccountId;
	}

	public void setToAccountId(Long toAccountId) {
		this.toAccountId = toAccountId;
	}

	public String getInstructions() {
		return instructions;
	}

	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

}
