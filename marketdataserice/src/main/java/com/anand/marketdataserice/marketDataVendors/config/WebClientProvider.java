package com.anand.marketdataserice.marketDataVendors.config;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;


//TODO Simplify the design pattern
@Component
public class WebClientProvider {

    private final VantageConfig vantageConfig;
    private final PolygonConfig polygonConfig;

   WebClientProvider(VantageConfig vantageConfig, PolygonConfig polygonConfig) {
        this.vantageConfig = vantageConfig;
        this.polygonConfig = polygonConfig;
    }

    public WebClient getWebClient(String providerType) {
        return switch (providerType.toLowerCase()) {
            case "polygon" -> WebClient.builder()   // Create a WebClient instance for Polygon
                    .baseUrl(polygonConfig.getBaseUrl())
                    .defaultHeader("Content-Type", "application/json")
                    .defaultHeader("Accept", "application/json")
                    .build();
            case "vantage" -> WebClient.builder()   // Create a WebClient instance for Vantage
                    .baseUrl(vantageConfig.getBaseUrl())
                    .build();
            default -> throw new IllegalArgumentException("Unknown provider type: " + providerType);
        };
    }

    public String getApiKey(String providerType) {
        return switch (providerType.toLowerCase()) {
            case "polygon" -> polygonConfig.getApiKey();
            case "vantage" -> vantageConfig.getApiKey();
            default -> throw new IllegalArgumentException("Unknown provider type: " + providerType);
        };
    }

}
