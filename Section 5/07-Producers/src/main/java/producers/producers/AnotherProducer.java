package producers.producers;

import jakarta.enterprise.inject.Produces;

// This class is where CDI will look for the types of Beans need to be created
// Since, 2 producers - String & Integer, CDI will create bean for each
public class AnotherProducer {

    // Method level bean annotation : CDI will create bean for type String
    // Scope ? Singleton
    @Produces
    public String produceString() {
        return "I've Produced a String";
    }

    // Method level bean annotation : CDI will create bean for type Integer
    // Scope ? Singleton
    @Produces
    public Integer produceInteger() {
        return 11;
    }
}
