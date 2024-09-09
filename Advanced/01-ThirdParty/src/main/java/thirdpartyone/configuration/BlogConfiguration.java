package thirdpartyone.configuration;

import jakarta.enterprise.inject.Produces;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;

public class BlogConfiguration {
    @Produces
    public Client blogClient() {
        return ClientBuilder.newClient();
    }
}
