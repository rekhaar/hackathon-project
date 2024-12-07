package com.abc.app.mortgage.dto;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class TransferResponse {

	private String status;
	private String message;
	private BigDecimal remainingSavingsBalance;
	private BigDecimal remainingOutstandingAmount;

	public TransferResponse(String status, String message, BigDecimal remainingSavingsBalance,
			BigDecimal remainingOutstandingAmount) {
		super();
		this.status = status;
		this.message = message;
		this.remainingSavingsBalance = remainingSavingsBalance;
		this.remainingOutstandingAmount = remainingOutstandingAmount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public BigDecimal getRemainingSavingsBalance() {
		return remainingSavingsBalance;
	}

	public void setRemainingSavingsBalance(BigDecimal remainingSavingsBalance) {
		this.remainingSavingsBalance = remainingSavingsBalance;
	}

	public BigDecimal getRemainingOutstandingAmount() {
		return remainingOutstandingAmount;
	}

	public void setRemainingOutstandingAmount(BigDecimal remainingOutstandingAmount) {
		this.remainingOutstandingAmount = remainingOutstandingAmount;
	}

}