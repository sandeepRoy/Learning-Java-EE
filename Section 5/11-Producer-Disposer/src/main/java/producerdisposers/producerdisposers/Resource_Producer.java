package producerdisposers.producerdisposers;


import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Path("/data")
public class Resource_Producer {
    @Inject
    private Connection connection;

    @GET
    @Path("/produce")
    @Produces(MediaType.APPLICATION_JSON)
    public Response showDatabases() {
        List<String> databasesList = new ArrayList<>();

        try {

            DatabaseMetaData metaData = connection.getMetaData();
            try(var catalog = metaData.getCatalogs()) {

                while(catalog.next()) {
                    String catalogName = catalog.getString("TABLE_CAT");
                    databasesList.add(catalogName);
                }

            }

            return Response.ok(databasesList).build();

        } catch (SQLException e) {
            return Response.serverError().entity("Error executing SQL statement").build();
        }
    }
}
