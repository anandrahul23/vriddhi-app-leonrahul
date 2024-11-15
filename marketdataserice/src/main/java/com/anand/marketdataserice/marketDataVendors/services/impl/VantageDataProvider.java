package com.anand.marketdataserice.marketDataVendors.services.impl;

import com.anand.marketdataserice.marketDataVendors.config.WebClientProvider;
import com.anand.marketdataserice.marketDataVendors.services.interfaces.MarketDataProvider;
import com.anand.marketdataserice.marketDataVendors.services.json.VantageDataDto;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class VantageDataProvider implements MarketDataProvider<VantageDataDto> {

    WebClientProvider webClientProvider;

    public VantageDataProvider(WebClientProvider webClientProvider) {
        this.webClientProvider = webClientProvider;
    }
    @Override
    public Flux<VantageDataDto> getAllTickers() {
        return null;
    }

    @Override
    public VantageDataDto getTicker(String ticker) {
        return null;
    }
}
