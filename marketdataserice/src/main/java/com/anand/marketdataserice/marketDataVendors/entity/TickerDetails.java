package com.anand.marketdataserice.marketDataVendors.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Table("ticker_details")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TickerDetails {


    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Id
    @Column("ticker")
    private String ticker;


    @Column("active")
    private Boolean active;

    @Column("cik")
    private String cik;

    @Column("composite_figi")
    private String compositeFigi;

    @Column("currency_name")
    private String currencyName;

    @Column("last_updated_utc")
    private LocalDateTime lastUpdatedUtc;

    @Column("locale")
    private String locale;

    @Column("market")
    private String market;

    @Column("name")
    private String name;

    @Column("primary_exchange")
    private String primaryExchange;

    @Column("share_class_figi")
    private String shareClassFigi;


    @Column("type")
    private String type;

    @Column("last_updated_time")
    private LocalDateTime lastUpdateTime;
}