package thirdpartyone.controller;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import thirdpartyone.responses.User;
import thirdpartyone.service.BlogService;

import java.util.List;

@ApplicationScoped
@Path("/blog")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BlogController {

    @Inject
    private BlogService blogService;

    @GET
    @Path("/users")
    public Response getPosts() {
        List<User> users = blogService.getUser();
        return Response.status(Response.Status.OK).entity(users).build();
    }

    // Next: Build other endpoints to create, update & delete
}
