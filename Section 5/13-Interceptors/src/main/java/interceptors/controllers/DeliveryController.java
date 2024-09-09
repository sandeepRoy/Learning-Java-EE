package interceptors.controllers;

import interceptors.processor_binding.PostProcessingBinder;
import interceptors.processor_binding.PreProcessingBinder;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

@Path("/delivery")
public class DeliveryController {
    @GET
    @Path("/pick-up")
    @PreProcessingBinder
    public Response pickUp() {
        return Response.status(Response.Status.OK).entity("Picked Up!").build();
    }

    @POST
    @Path("/deliver")
    @PostProcessingBinder
    public Response deliver() {
        return Response.status(Response.Status.OK).entity("Delivered!").build();
    }
}
