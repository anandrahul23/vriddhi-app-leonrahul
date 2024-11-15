package com.anand.marketdataserice.marketDataVendors.services.json;

import java.time.LocalDateTime;
import java.util.List;

public record PolygonTickerDetailsDto(
        String ticker,
        String name,
        String market,
        String locale,
        String primaryExchange,
        String type,
        boolean active,
        String currencyName,
        String cik,
        String compositeFigi,
        String shareClassFigi,
        LocalDateTime lastUpdatedUtc
) {}


