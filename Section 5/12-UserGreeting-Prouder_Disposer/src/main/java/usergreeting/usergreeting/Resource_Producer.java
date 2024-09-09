package usergreeting.usergreeting;

import jakarta.enterprise.inject.Instance;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

@Path("/user")
public class Resource_Producer {

    @Inject
    private User user;

    @Inject
    private Service service;

    @Inject
    private Instance<User> userInstance;

    @GET
    @Path("/produce")
    public Response produceUser() {
        user = service.createUser();
        return Response.ok(user.greet()).build();
    }

    @POST
    @Path("/dispose")
    public Response disposeUser() {

        try {
            // User created using CDI @Producer
            // Manually disposing, through @Disposer
            service.disposeUserManually(user);
            return Response.ok("Disposed").build();
        } catch (Exception e) {
            return Response.serverError().entity("Error Disposing User").build();
        }
    }

    @GET
    @Path("/check")
    public Response checkBeanStatus() {
        if(userInstance.isAmbiguous() || !userInstance.isResolvable()) {
            return Response.ok("User Bean is active").build();
        }
        return Response.ok("User Bean isn't active").build();
    }
}
