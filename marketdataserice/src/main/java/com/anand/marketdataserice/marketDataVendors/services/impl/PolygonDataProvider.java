package com.anand.marketdataserice.marketDataVendors.services.impl;

import com.anand.marketdataserice.marketDataVendors.config.WebClientProvider;
import com.anand.marketdataserice.marketDataVendors.services.interfaces.MarketDataProvider;
import com.anand.marketdataserice.marketDataVendors.services.json.PolygonResponseDto;
import com.anand.marketdataserice.marketDataVendors.services.json.PolygonTickerDetailsDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class PolygonDataProvider implements MarketDataProvider<PolygonResponseDto> {

    private final Logger log = LoggerFactory.getLogger(PolygonDataProvider.class);

    WebClientProvider webClientProvider;

    public PolygonDataProvider(WebClientProvider webClientProvider) {
        this.webClientProvider = webClientProvider;
    }
    @Override
    public Flux<PolygonResponseDto> getAllTickers() {

        return Flux.range(0, 1)
                .map(i -> (char) ('A' + i))
                .flatMap(this::getTickers)
                .doOnNext(ticker -> log.info("Received ticker: {}", ticker))
                .doOnError(throwable -> log.error("Error occurred: {}", throwable.getMessage()));

    }

    private Flux<PolygonResponseDto> getTickers(char tickerStartsWithAlphabet) {
        return webClientProvider
                .getWebClient("polygon")
                .get()
                .uri(uriBuilder -> uriBuilder.path("/v3/reference/tickers")
                        .queryParam("apiKey", webClientProvider.getApiKey("polygon"))
                        .queryParam("active", "true")
                        .queryParam("sort", "ticker")
                        .queryParam("ticker.gte", tickerStartsWithAlphabet)
                        .queryParam("ticker.lte", (char) (tickerStartsWithAlphabet + 1))
                        .build())
                .retrieve().bodyToFlux(PolygonResponseDto.class);
    }

    @Override
    public PolygonResponseDto getTicker(String ticker) {
        return null;
    }


}
