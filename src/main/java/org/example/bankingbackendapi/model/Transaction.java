package org.example.bankingbackendapi.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Transaction {

    private Long id;
    private Long fromAccountId;
    private Long toAccountId;
    private BigDecimal amount;
    private String currency;
    private String description;
    private String status;
    private LocalDateTime createdAt;

    public Transaction(
            Long id,
            Long fromAccountId,
            Long toAccountId,
            BigDecimal amount,
            String currency,
            String description,
            String status,
            LocalDateTime createdAt
    ) {
        this.id = id;
        this.fromAccountId = fromAccountId;
        this.toAccountId = toAccountId;
        this.amount = amount;
        this.currency = currency;
        this.description = description;
        this.status = status;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }
    public Long fromAccountId() {
        return fromAccountId;
    }
    public Long toAccountId() {
        return toAccountId;
    }
    public BigDecimal amount() {
        return amount;
    }
    public String currency() {
        return currency;
    }
    public String description() {
        return description;
    }
    public String status() {
        return status;
    }
    public LocalDateTime createdAt() {
        return createdAt;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public void setFromAccountId(Long fromAccountId) {
        this.fromAccountId = fromAccountId;
    }
    public void setToAccountId(Long toAccountId) {
        this.toAccountId = toAccountId;
    }
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
    public void setCurrency(String currency) {
        this.currency = currency;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}

