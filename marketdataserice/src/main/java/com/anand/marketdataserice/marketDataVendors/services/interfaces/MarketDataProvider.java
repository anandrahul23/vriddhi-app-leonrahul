package com.anand.marketdataserice.marketDataVendors.services.interfaces;

import reactor.core.publisher.Flux;

public interface MarketDataProvider<T> {
    Flux<T> getAllTickers();
    T getTicker(String ticker);
}
