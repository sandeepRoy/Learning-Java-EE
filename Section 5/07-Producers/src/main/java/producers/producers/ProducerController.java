package producers.producers;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

import java.util.logging.Logger;

@Path("/producer")
public class ProducerController {

    // Injects the type being Produced by the Producer class, not the Producer class itself
    @Inject
    Logger logger;

    // Injects the type being Produced by the Producer class, not the Producer class itself
    @Inject
    String stringProducer;

    @Inject
    Integer integerProducer;

    @GET
    @Path("/hit-logger")
    // this function will look up for a bean of type Logger being produced by CDI
    // It will find that in LoggerProducer class, there is a @Producer that do produces a Logger, thus fetches the return and saves it.
    public Response hitLoggerProducer() {
        return Response.status(Response.Status.OK).entity(logger.getName()).build();
    }

    @GET
    @Path("/hit-string")
    // this function will look up for a bean of type String being produced by CDI
    // It will find that in AnotherProducer class, there is a @Producer that do produces a String, thus fetches the return and saves it.
    public Response hitStringProducer() {
        return Response.status(Response.Status.OK).entity(stringProducer).build();
    }

    @GET
    @Path("/hit-integer")
    // this function will look up for a bean of type String being produced by CDI
    // It will find that in AnotherProducer class, there is a @Producer that do produces a String, thus fetches the return and saves it.
    public Response hitIntegerProducer() {
        return Response.status(Response.Status.OK).entity(integerProducer).build();
    }


}