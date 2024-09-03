package scopes_contexts.scopes_contexts.service;

import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import scopes_contexts.scopes_contexts.contexts.*;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;

public class BeanScope implements Serializable {
    @Inject
    private ApplicationScope applicationScope;

    @Inject
    private ConversationScope conversationScope;

    @Inject
    private DependentScope dependentScope;

    @Inject
    private RequestScope requestScope;

    @Inject
    private SessionScope sessionScope;

    public Response getApplicationScopeHashCodes() {
        applicationScope.setHashCode();
        List<Integer> hashCodes = applicationScope.getHashCodes();
        return Response.status(Response.Status.OK).entity(hashCodes).build();
    }

    public Response getConversationScopeHashCodes() {
        conversationScope.setHashCode();
        List<Integer> hashCodes = conversationScope.getHashCodes();
        return Response.status(Response.Status.OK).entity(hashCodes).build();
    }

    public Response getDependentScopeHashCodes() {
        dependentScope.setHashCode();
        List<Integer> hashCodes = dependentScope.getHashCodes();
        return Response.status(Response.Status.OK).entity(hashCodes).build();
    }

    public Response getRequestScopeHashCodes() {
        requestScope.setHashCode();
        List<Integer> hashCodes = requestScope.getHashCodes();
        return Response.status(Response.Status.OK).entity(hashCodes).build();
    }

    public Response getSessionScopeHashCodes() {
        sessionScope.setHashCode();
        List<Integer> hashCodes = sessionScope.getHashCodes();
        return Response.status(Response.Status.OK).entity(hashCodes).build();
    }
}
