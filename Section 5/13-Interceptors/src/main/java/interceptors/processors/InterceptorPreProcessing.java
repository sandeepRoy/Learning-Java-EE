package interceptors.processors;

import interceptors.processor_binding.PreProcessingBinder;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;

@Interceptor
@PreProcessingBinder
public class InterceptorPreProcessing {
    // method to check for permission and move ahead
    @AroundInvoke
    public Object checkPermission(InvocationContext invocationContext) throws Exception {
        boolean hasPermission = true;
        if(!hasPermission) {
            throw new WebApplicationException("Permission Denied", Response.Status.FORBIDDEN);
        }
        return invocationContext.proceed(); // Moves to the REST Endpoint
    }
}
