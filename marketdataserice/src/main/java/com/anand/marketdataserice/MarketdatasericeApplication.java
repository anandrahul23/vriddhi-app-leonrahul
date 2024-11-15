package com.anand.marketdataserice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableR2dbcRepositories
@EnableScheduling
public class MarketdatasericeApplication {

    public static void main(String[] args) {


        SpringApplication.run(MarketdatasericeApplication.class, args);
    }
}
