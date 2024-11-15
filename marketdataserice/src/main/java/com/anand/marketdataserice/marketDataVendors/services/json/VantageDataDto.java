package com.anand.marketdataserice.marketDataVendors.services.json;

public record VantageDataDto(String symbol, String name, String type, String region, String marketOpen,
                             String marketClose, String timezone, String currency, String matchScore) {
}
