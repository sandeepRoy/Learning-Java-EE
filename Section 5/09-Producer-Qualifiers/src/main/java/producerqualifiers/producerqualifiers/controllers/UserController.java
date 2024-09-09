package producerqualifiers.producerqualifiers.controllers;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import producerqualifiers.producerqualifiers.producers.Greet;
import producerqualifiers.producerqualifiers.producers.GreetProducer;
import producerqualifiers.producerqualifiers.producers.User;

@ApplicationScoped
@Path("/user")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserController {
    @Inject
    GreetProducer greetProducer;

    @GET
    @Path("/{username}")
    public Response hitGreetProducer(@PathParam("username") String username) {
        Greet greet = greetProducer.greetUser(username);
        String greet_user = greet.greet();
        return Response.status(Response.Status.OK).entity(greet_user).build();
    }
}
