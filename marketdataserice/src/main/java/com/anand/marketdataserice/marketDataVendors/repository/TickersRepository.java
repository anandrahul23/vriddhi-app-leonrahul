package com.anand.marketdataserice.marketDataVendors.repository;

import com.anand.marketdataserice.marketDataVendors.entity.TickerDetails;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface TickersRepository extends ReactiveCrudRepository<TickerDetails, Long> {

    @Query("SELECT t FROM TickerDetails t WHERE t.ticker = :ticker")
    Mono<TickerDetails> findByTicker(String ticker);
}
