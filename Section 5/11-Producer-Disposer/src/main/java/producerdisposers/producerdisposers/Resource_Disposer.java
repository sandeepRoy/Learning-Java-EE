package producerdisposers.producerdisposers;

import jakarta.inject.Inject;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

import java.sql.Connection;
import java.sql.SQLException;

@Path("/resource")
public class Resource_Disposer {
    @Inject
    private Service service;

    @POST
    @Path("/dispose")
    public Response disposeConnection() {
        Connection connection = null;

        try {

            connection = service.produceConnection();
            service.disposeConnectionManually(connection);
            return Response.ok("Connection Disposed").build();

        } catch (SQLException e) {
            return Response.serverError().entity("Error Disposing Connection").build();
        }
    }
}
