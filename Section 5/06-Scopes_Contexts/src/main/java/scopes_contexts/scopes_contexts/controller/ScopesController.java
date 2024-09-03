package scopes_contexts.scopes_contexts.controller;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import scopes_contexts.scopes_contexts.service.BeanScope;

@ApplicationScoped
@Path("/scopes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ScopesController {
    @Inject
    BeanScope beanScope;

    @GET
    @Path("/application")
    public Response getApplicationScope() {
        Response applicationScopeHashCodes = beanScope.getApplicationScopeHashCodes();
        return applicationScopeHashCodes;
    }

    @GET
    @Path("/conversation")
    public Response getConversationScope() {
        Response applicationScopeHashCodes = beanScope.getConversationScopeHashCodes();
        return applicationScopeHashCodes;
    }

    @GET
    @Path("/dependent")
    public Response getDependentScope() {
        Response applicationScopeHashCodes = beanScope.getDependentScopeHashCodes();
        return applicationScopeHashCodes;
    }

    @GET
    @Path("/request")
    public Response getRequestScope() {
        Response applicationScopeHashCodes = beanScope.getRequestScopeHashCodes();
        return applicationScopeHashCodes;
    }

    @GET
    @Path("/session")
    public Response getSessionScope() {
        Response applicationScopeHashCodes = beanScope.getSessionScopeHashCodes();
        return applicationScopeHashCodes;
    }
}