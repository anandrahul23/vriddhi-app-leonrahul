package com.anand.marketdataserice.marketDataVendors.mapper;

import com.anand.marketdataserice.marketDataVendors.entity.TickerDetails;
import com.anand.marketdataserice.marketDataVendors.services.json.PolygonResponseDto;
import com.anand.marketdataserice.marketDataVendors.services.json.PolygonTickerDetailsDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Set;

public class EntityDtoMapper {



    private static final Logger log = LoggerFactory.getLogger(EntityDtoMapper.class);

     public static TickerDetails mapTickerDetailsToEntity(PolygonTickerDetailsDto dto) {
         log.info("Mapping TickerDetailsDto to TickerDetails: {}", dto);
         TickerDetails tickerDetails = new TickerDetails();
            tickerDetails.setTicker(dto.ticker());
            tickerDetails.setName(dto.name());
            tickerDetails.setMarket(dto.market());
            tickerDetails.setLocale(dto.locale());
            tickerDetails.setPrimaryExchange(dto.primaryExchange());
            tickerDetails.setType(dto.type());
            tickerDetails.setActive(dto.active());
            tickerDetails.setCurrencyName(dto.currencyName());
            tickerDetails.setCik(dto.cik());
            tickerDetails.setCompositeFigi(dto.compositeFigi());
            tickerDetails.setShareClassFigi(dto.shareClassFigi());
            tickerDetails.setLastUpdatedUtc(dto.lastUpdatedUtc());
            log.info("Mapped TickerDetailsDto to TickerDetails: {}", tickerDetails);
            return tickerDetails;
     }



}
