package org.example.bankingbackendapi.client;

import org.example.bankingbackendapi.dto.FrankfurterResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class FrankfurterApiClient {
    // Macht den HTTP-Request zur externen API

    private final RestClient restClient;

    public FrankfurterApiClient(RestClient.Builder restClientBuilder) {
        this.restClient = restClientBuilder
                .baseUrl("https://api.frankfurter.dev/v1")
                .build();
    }

    public FrankfurterResponse getLatestResponse(String base, String symbol){
        return restClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/latest")
                        .queryParam("base", base)
                        .queryParam("currencies", symbol)
                        .build())
                .retrieve()
                .body(FrankfurterResponse.class);
    }
}
