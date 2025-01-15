package com.sandeep.student.controller;

import com.sandeep.student.ejb.StudentService;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/student")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.TEXT_PLAIN)
@ApplicationScoped
public class StudentController {

    @EJB(mappedName = "java:module/StudentServiceImpl!com.sandeep.student.ejb.StudentService")
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
