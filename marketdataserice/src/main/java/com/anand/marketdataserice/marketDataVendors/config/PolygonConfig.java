package com.anand.marketdataserice.marketDataVendors.config;


import com.anand.marketdataserice.marketDataVendors.config.interfaces.ExternalDataProviderConfig;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
@Data
@Configuration
@ConfigurationProperties(prefix = "data-provider.polygon")
public class PolygonConfig implements ExternalDataProviderConfig {
    private String apiKey;
    private String baseUrl;

    @Override
    public String getUri() {
        return null;
    }
}
