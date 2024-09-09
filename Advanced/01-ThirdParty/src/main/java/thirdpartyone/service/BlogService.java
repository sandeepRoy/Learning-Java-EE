package thirdpartyone.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.GenericType;
import thirdpartyone.endpoints.Endpoints;
import thirdpartyone.responses.User;

import java.util.List;

@ApplicationScoped
public class BlogService {
    @Inject
    private Client blogClient;

    public List<User> getUser() {
        WebTarget webTarget = blogClient
                .target(Endpoints.baseUrl)
                .path("users");

        System.out.println(webTarget.getUri().toString());

        return webTarget
                .request()
                .get()
                .readEntity(new GenericType<List<User>>() {});
    }
}
