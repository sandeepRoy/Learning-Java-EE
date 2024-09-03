package managedbeans.managedbeans.controllers;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import managedbeans.managedbeans.services.DeviceService;

@Path("/device")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DeviceController {
    @Inject
    DeviceService deviceService;

    @GET
    @Path("/desktop")
    public Response getDesktopData(@QueryParam("name") String name) {
        String response_word = deviceService.showDesktopData(name);
        return Response.status(Response.Status.OK).entity(response_word).build();
    }

    @GET
    @Path("/laptop")
    public Response getLaptopData(@QueryParam("name") String name) {
        String response_word = deviceService.showLaptopData(name);
        return Response.status(Response.Status.OK).entity(response_word).build();
    }

    @GET
    @Path("/phone")
    public Response getPhoneData(@QueryParam("name") String name) {
        String response_word = deviceService.showPhoneData(name);
        return Response.status(Response.Status.OK).entity(response_word).build();
    }
}
