package org.example.bankingbackendapi.service;

import org.example.bankingbackendapi.client.FrankfurterApiClient;
import org.example.bankingbackendapi.dto.FrankfurterResponse;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class CurrencyService {
    // Enthält die Banking-Logik, z.B. Betrag umrechnen

    private final FrankfurterApiClient frankfurterApiClient;

    public CurrencyService(FrankfurterApiClient frankfurterApiClient) {
        this.frankfurterApiClient = frankfurterApiClient;
    }

    public BigDecimal convert(String from, String to, BigDecimal amount) {
        if (from == null || from.isBlank() || to == null || to.isBlank()) {
            throw new IllegalArgumentException("Currency codes must not be empty");
        }

        if (amount == null || amount.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Amount must not be negative");
        }

        String normalizedFrom = from.trim().toUpperCase();
        String normalizedTo = to.trim().toUpperCase();

        if (normalizedFrom.equals(normalizedTo)) {
            return amount.setScale(2, RoundingMode.HALF_UP);
        }

        FrankfurterResponse response = frankfurterApiClient.getLatestResponse(normalizedFrom, normalizedTo);

        if (response == null || response.getRates() == null) {
            throw new IllegalStateException("Currency rate could not be loaded");
        }

        BigDecimal rate = response.getRates().get(normalizedTo);
        if (rate == null)  {
            throw new IllegalArgumentException("Unsupported target currency: " + normalizedTo);
        }

        return amount.multiply(rate).setScale(2, RoundingMode.HALF_UP);
    }
}
