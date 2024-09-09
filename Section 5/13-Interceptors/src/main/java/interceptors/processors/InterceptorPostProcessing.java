package interceptors.processors;

import interceptors.processor_binding.PostProcessingBinder;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;

import java.util.logging.Logger;

@Interceptor
@PostProcessingBinder
public class InterceptorPostProcessing {
    private static final Logger LOGGER = Logger.getLogger(InterceptorPostProcessing.class.getName());

    @AroundInvoke
    public Object intercept(InvocationContext invocationContext) throws Exception {
        Object result = invocationContext.proceed();

        LOGGER.info("Delivery Proceeded Successfully");

        return result;
    }
}
