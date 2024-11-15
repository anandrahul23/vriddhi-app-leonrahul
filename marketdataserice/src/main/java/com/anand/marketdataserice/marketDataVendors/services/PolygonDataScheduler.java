package com.anand.marketdataserice.marketDataVendors.services;

import com.anand.marketdataserice.marketDataVendors.entity.TickerDetails;
import com.anand.marketdataserice.marketDataVendors.mapper.EntityDtoMapper;
import com.anand.marketdataserice.marketDataVendors.repository.TickersRepository;
import com.anand.marketdataserice.marketDataVendors.services.impl.PolygonDataProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class PolygonDataScheduler {
    private static final Logger log = LoggerFactory.getLogger(PolygonDataScheduler.class);

    private final TickersRepository tickersRepository;

    private final PolygonDataProvider polygonDataProvider;

    public PolygonDataScheduler(PolygonDataProvider polygonDataProvider, TickersRepository tickersRepository) {
        this.polygonDataProvider = polygonDataProvider;
        this.tickersRepository = tickersRepository;
    }



    @Scheduled(fixedRate = 10000) // Runs every 10 second
    public void fetchPolygonData() {

        polygonDataProvider.getAllTickers()
                .flatMap(response -> Flux.fromIterable(response.results()))
                .map(ticker -> EntityDtoMapper.mapDtoToEntity(ticker, TickerDetails.class))
                .buffer(2)
                .doOnNext(ticker -> log.info("Saved ticker: {}", ticker))
                .flatMap(tickersRepository::saveAll)
                .subscribe(
                        data -> {
                            // Process the data
                        },
                        error -> {
                            // Handle the error
                        }
                );
//                .subscribe(
//                        data -> {
//                            // Process the data
//                        },
//                        error -> {
//                            // Handle the error
//                        }
//                );
    }
}
