package com.example.crudtest1.controller;

import com.example.crudtest1.service.StudentService;

import javax.faces.bean.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/student")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.TEXT_PLAIN)
@ApplicationScoped
public class StudentController {
    @Inject
    StudentService studentService;

    @GET
    @Path("/all")
    public Response getAllStudents() {
        return Response.status(Response.Status.OK).entity(studentService.getAllStudents()).build();
    }

    @POST
    @Path("/new")
    public Response createStudent(String student_name) {
        return Response.status(Response.Status.OK).entity(studentService.createStudent(student_name)).build();
    }
}
