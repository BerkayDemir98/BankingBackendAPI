package org.example.bankingbackendapi.dto;

import java.math.BigDecimal;
import java.util.Map;

public class FrankfurterResponse {
    // bildet die JSON-Antwort der API ab
    private BigDecimal amount;
    private String base;
    private String date;
    private Map<String, BigDecimal> rates;

    public BigDecimal getAmount() {
        return amount;
    }

    public String getBase() {
        return base;
    }

    public String getDate() {
        return date;
    }

    public Map<String, BigDecimal> getRates() {
        return rates;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setRates(Map<String, BigDecimal> rates) {
        this.rates = rates;
    }
}
