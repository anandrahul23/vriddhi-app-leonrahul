package com.anand.marketdataserice.marketDataVendors.services.json;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.util.List;

public record PolygonTickerDetailsDto(
        @JsonProperty("ticker") String ticker,
        @JsonProperty("name") String name,
        @JsonProperty("market") String market,
        @JsonProperty("locale") String locale,
        @JsonProperty("primary_exchange") String primaryExchange,
        @JsonProperty("type") String type,
        @JsonProperty("active") boolean active,
        @JsonProperty("currency_name") String currencyName,
        @JsonProperty("cik") String cik,
        @JsonProperty("composite_figi") String compositeFigi,
        @JsonProperty("share_class_figi") String shareClassFigi,
        @JsonProperty("last_updated_utc") LocalDateTime lastUpdatedUtc
) {}

