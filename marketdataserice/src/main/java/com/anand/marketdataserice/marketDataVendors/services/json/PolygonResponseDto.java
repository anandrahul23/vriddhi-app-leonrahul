package com.anand.marketdataserice.marketDataVendors.services.json;

import java.util.List;

public record PolygonResponseDto(
        List<PolygonTickerDetailsDto> results,
        String status,
        String requestId,
        int count,
        String nextUrl
) {}
