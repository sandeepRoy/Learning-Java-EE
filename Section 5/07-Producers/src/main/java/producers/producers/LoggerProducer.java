package producers.producers;

import jakarta.enterprise.inject.Produces;
import jakarta.enterprise.inject.spi.InjectionPoint;

import java.util.logging.Logger;

// This class is where CDI will look for the types of Beans need to be created
// Since, 2 producers - String & Integer, CDI will create bean for each
public class LoggerProducer {

    // Method level bean annotation
    // Scope ? Singleton
    @Produces
    public Logger produceLogger(InjectionPoint injectionPoint) {
        return Logger.getLogger(injectionPoint.getMember().getDeclaringClass().getName());
    }
}
