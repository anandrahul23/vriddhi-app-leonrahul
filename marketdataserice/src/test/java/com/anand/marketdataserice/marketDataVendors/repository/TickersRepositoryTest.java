package com.anand.marketdataserice.marketDataVendors.repository;

import com.anand.marketdataserice.AbstractTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;

class TickersRepositoryTest extends AbstractTest {

    @Autowired
    TickersRepository tickersRepository;
    @Test
    void testDataInTickerDetails() {

        tickersRepository.findByTicker("NCSM")
                .as(StepVerifier::create)
                .assertNext(tickerDetails -> {
                    assertEquals("NCSM", tickerDetails.getTicker());
                })
                .verifyComplete();
    }

}