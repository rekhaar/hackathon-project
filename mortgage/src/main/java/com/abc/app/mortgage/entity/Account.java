package com.abc.app.mortgage.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

//@Entity
//@Table(name = "abc_account")
//@Getter
//@Setter since lombok Getter and setter not getting enabled in Intellij after added plugin also, temporarily commenting
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "account_number")
    private String accountNumber;

    public Account(long id, String accountNumber, String accountName, Long userId, BigDecimal balanceAmount) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.userId = userId;
        this.balanceAmount = balanceAmount;
    }

    @Column(name = "account_name")
    private String accountName;

    @Column(name = "account_type_id") // join column of account type
    private Long accountTypeId;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "user_id") // Join column of User
    private Long userId;

    @Column(name = "created_by") // Join column of User
    private Long createdBy;

    @Column(name = "updated_by") // Join column of User
    private Long updatedBy;

    @Column(name = "balance_amount")
    private BigDecimal balanceAmount;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public Long getAccountTypeId() {
        return accountTypeId;
    }

    public void setAccountTypeId(Long accountTypeId) {
        this.accountTypeId = accountTypeId;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public Long getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(Long updatedBy) {
        this.updatedBy = updatedBy;
    }

    public BigDecimal getBalanceAmount() {
        return balanceAmount;
    }

    public void setBalanceAmount(BigDecimal balanceAmount) {
        this.balanceAmount = balanceAmount;
    }
}
