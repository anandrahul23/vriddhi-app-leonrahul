package com.anand.marketdataserice.marketDataVendors.services;

import com.anand.marketdataserice.marketDataVendors.config.PolygonConfig;
import com.anand.marketdataserice.marketDataVendors.mapper.EntityDtoMapper;
import com.anand.marketdataserice.marketDataVendors.repository.TickersRepository;
import com.anand.marketdataserice.marketDataVendors.services.impl.PolygonDataProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.time.LocalDateTime;
import java.time.ZoneId;

@Service
public class PolygonDataScheduler implements SchedulingConfigurer {
    private static final Logger log = LoggerFactory.getLogger(PolygonDataScheduler.class);

    private final TickersRepository tickersRepository;
    private final PolygonConfig polygonConfig;

    private final PolygonDataProvider polygonDataProvider;

    public PolygonDataScheduler(PolygonDataProvider polygonDataProvider, TickersRepository tickersRepository
            , PolygonConfig polygonConfig) {
        this.polygonDataProvider = polygonDataProvider;
        this.tickersRepository = tickersRepository;
        this.polygonConfig = polygonConfig;
    }

    @Async("threadPoolTaskExecutor")
    @EventListener(ContextRefreshedEvent.class)
    public void onApplicationEvent() {
        if (polygonConfig.getSchedule().isLoad()) {
            fetchPolygonData();
        }
    }


    public void fetchPolygonData() {

        polygonDataProvider.getAllTickers()
                .flatMap(response -> Flux.fromIterable(response.results()))
                .map(EntityDtoMapper::mapTickerDetailsToEntity)
                .map(ticker -> {
                    ticker.setLastUpdateTime(LocalDateTime.now(ZoneId.of("UTC")));
                    return ticker;
                })
                .doOnNext(ticker -> log.info("Processing ticker: {}", ticker))
                .flatMap(ticker -> tickersRepository.findByTicker(ticker.getTicker())
                        .flatMap(existingTicker -> {
                            // Update existing ticker details
                            existingTicker.setName(ticker.getName());
                            existingTicker.setMarket(ticker.getMarket());
                            existingTicker.setLocale(ticker.getLocale());
                            existingTicker.setPrimaryExchange(ticker.getPrimaryExchange());
                            existingTicker.setType(ticker.getType());
                            existingTicker.setActive(ticker.getActive());
                            existingTicker.setCurrencyName(ticker.getCurrencyName());
                            existingTicker.setCik(ticker.getCik());
                            existingTicker.setCompositeFigi(ticker.getCompositeFigi());
                            existingTicker.setShareClassFigi(ticker.getShareClassFigi());
                            existingTicker.setLastUpdateTime(ticker.getLastUpdateTime());
                            return tickersRepository.save(existingTicker);
                        })
                        .switchIfEmpty(tickersRepository.save(ticker)))
                .onErrorContinue((throwable, o) -> log.warn("Error processing {}: {}", o, throwable.getMessage()))
                .subscribe(
                        data -> log.info("Saved ticker: {}", data),
                        error -> log.error("Error occurred: {}", error.getMessage())
                );    }

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        taskRegistrar.addCronTask(this::fetchPolygonData, polygonConfig.getSchedule().getCron());
    }
}
