package com.anand.marketdataserice.marketDataVendors.factory;

import com.anand.marketdataserice.marketDataVendors.services.impl.PolygonDataProvider;
import com.anand.marketdataserice.marketDataVendors.services.impl.VantageDataProvider;
import com.anand.marketdataserice.marketDataVendors.services.interfaces.MarketDataProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DataProviderFactory {
    private final PolygonDataProvider polygonDataProvider;
    private final VantageDataProvider vantageDataProvider;


    @Autowired
    public DataProviderFactory(PolygonDataProvider polygonDataProvider, VantageDataProvider vantageDataProvider) {
        this.polygonDataProvider = polygonDataProvider;
        this.vantageDataProvider = vantageDataProvider;
    }

    public MarketDataProvider<?> getDataProvider(String providerType) {
        return switch (providerType.toLowerCase()) {
            case "polygon" -> polygonDataProvider;
            case "vantage" -> vantageDataProvider;
            default -> throw new IllegalArgumentException("Unknown provider type: " + providerType);
        };
    }
}
