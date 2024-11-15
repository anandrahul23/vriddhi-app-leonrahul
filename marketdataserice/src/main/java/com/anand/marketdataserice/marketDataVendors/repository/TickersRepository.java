package com.anand.marketdataserice.marketDataVendors.repository;

import com.anand.marketdataserice.marketDataVendors.entity.TickerDetails;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TickersRepository extends ReactiveCrudRepository<TickerDetails, Long> {

}
