package fieldproducers.fieldproducers.controllers;

import fieldproducers.fieldproducers.producers.ListProducer;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@ApplicationScoped
@Path("/producer")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ListProducerController {
    @Inject
    ListProducer listProducer;

    @GET
    @Path("/hit-list")
    public Response hitListProducer() {
        return Response.status(Response.Status.OK).entity(listProducer.produceListOfInteger()).build();
    }
}
