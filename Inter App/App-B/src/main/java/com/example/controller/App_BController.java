package com.example.controller;

import com.example.dto.SendMessageDto;
import com.example.service.App_BService;
import com.yourapp.entity.Message;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/messages")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@ApplicationScoped
public class App_BController {

    @Inject
    App_BService appBService;


    @GET
    @Path("/receive")
    public Response getMessage() {
        List<Message> messages = appBService.getMessages();
        return Response.status(Response.Status.OK).entity(messages).build();
    }

    @POST
    @Path("/send")
    public Response sendMessage(SendMessageDto sendMessageDto) {
        String response = appBService.sendMessage(sendMessageDto);
        return Response.status(Response.Status.OK).entity(response).build();
    }
}
