package dispose_demo.controllers;

import dispose_demo.services.Dining;
import dispose_demo.services.DishService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@ApplicationScoped
@Path("/dish")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DishController {
    @Inject
    Dining dining;

    @GET
    @Path("/all")
    public Response produceDishes() {
        List<String> dishes = dining.getDishes();
        return Response.status(Response.Status.OK).entity(dishes).build();
    }

    @DELETE
    @Path("/dispose")
    public Response disposeDishes() {
        dining.closeDinner();
        return Response.status(Response.Status.OK).entity("Dinner Closed").build();
    }

}
