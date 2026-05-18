package org.example.bankingbackendapi.model;

import java.math.BigDecimal;

public class Account {

    private Long id;
    private Long userId;
    private String iban;
    private BigDecimal balance;
    private String currency;

    public Account(
            Long id,
            Long userId,
            String iban,
            BigDecimal balance,
            String currency
    ) {
        this.id = id;
        this.userId = userId;
        this.iban = iban;
        this.balance = balance;
        this.currency = currency;
    }

    public Long getId() {
        return id;
    }
    public Long getUserId() {
        return userId;
    }
    public String getIban() {
        return iban;
    }
    public BigDecimal getBalance() {
        return balance;
    }
    public String getCurrency() {
        return currency;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public void setIban(String iban) {
        this.iban = iban;
    }
    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
    public void setCurrency(String currency) {
        this.currency = currency;
    }


}
