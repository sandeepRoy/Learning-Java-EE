package com.sandeep.school.controller;

import com.sandeep.school.service.SchoolService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/school")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.TEXT_PLAIN)
@ApplicationScoped
public class SchoolController {
    @Inject
    SchoolService schoolService;

    @GET
    @Path("/all")
    public Response getAllSchools() {
        return Response.status(Response.Status.OK).entity(schoolService.getAllSchools()).build();
    }

    @GET
    @Path("/{school_name}/assign/{student_name}")
    public Response assignStudentToSchool(@PathParam("school_name") String school_name, @PathParam("student_name") String student_name) {
        return Response.status(Response.Status.OK).entity(schoolService.assignStudentToSchool(school_name, student_name)).build();
    }

    @POST
    @Path("/new")
    public Response createSchool(String school_name) {
        return Response.status(Response.Status.OK).entity(schoolService.createSchool(school_name)).build();
    }
}
