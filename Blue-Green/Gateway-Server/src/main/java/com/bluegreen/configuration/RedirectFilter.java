package com.bluegreen.configuration;

import com.bluegreen.client.SharedClient;
import com.bluegreen.qualifier.SharedClientQualifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;

import java.io.ObjectInputFilter;

@Component
public class RedirectFilter extends AbstractGatewayFilterFactory<RedirectFilter.Config> {


    @Autowired(required = false)
    public SharedClient sharedClient;

    public RedirectFilter() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        return ((exchange, chain) -> {
            String lastUpdated = sharedClient.getUpdatedApp(); // GET current updated App Name
            String path = exchange.getRequest().getURI().getPath(); // GET current path

            // Check if the path matches Green & lastUpdated is Blue
            if(path.startsWith("/green") && "blue".equals(lastUpdated)) {
                // Redirect to Blue-Server
                exchange
                        .getRequest()
                        .mutate()
                        .path("/blue" + path.substring(6)) // whatever after /green was is assigned to /blue
                        .build();
            }
            // Check if the path matches Blue & lastUpdated is Green
            else if(path.startsWith("/blue") && "green".equals(lastUpdated)) {
                // Redirect to Green-Server
                exchange
                        .getRequest()
                        .mutate()
                        .path("/green" + path.substring(6)) // whatever after /blue was is assigned to /green
                        .build();
            }
            return chain.filter(exchange);
        });
    }

    public static class Config {

    }
}
