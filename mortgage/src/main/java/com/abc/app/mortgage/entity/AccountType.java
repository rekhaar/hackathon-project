package com.abc.app.mortgage.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

//@Entity
//@Table(name = "abc_account_type")
//@Getter
//@Setter since lombok Getter and setter not getting enabled in Intellij after added plugin also, temporarily commenting
public class AccountType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "account_type")
    private String accountType;
    @Column(name = "description")
    private String description;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
