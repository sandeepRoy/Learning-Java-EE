package jpacrudsingle.jpacrudsingle.controller;

import jpacrudsingle.jpacrudsingle.dtos.DemoCreateDto;
import jpacrudsingle.jpacrudsingle.service.DemoService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@ApplicationScoped
@Path("/demo")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DemoController {
    @Inject
    DemoService demoService;

    @GET
    @Path("/all")
    public Response getAllDemos() {
        return Response.status(Response.Status.OK).entity(demoService.getDemos()).build();
    }

    @POST
    @Path("/new")
    public Response createDemo(DemoCreateDto demoCreateDto) {
        return Response.status(Response.Status.OK).entity(demoService.createDemo(demoCreateDto)).build();
    }
}
