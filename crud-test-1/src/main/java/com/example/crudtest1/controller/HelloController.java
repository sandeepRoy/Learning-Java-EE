package com.example.crudtest1.controller;

import com.example.crudtest1.service.HelloService;

import javax.faces.bean.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/hello")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.TEXT_PLAIN)
@ApplicationScoped
public class HelloController {

    @Inject
    HelloService helloService;

    @GET
    @Path("/{name}")
    public String greet(@PathParam("name") String name) {
        return helloService.sayHello(name);
    }
}
