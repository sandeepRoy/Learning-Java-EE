package fieldproducers.fieldproducers.producers;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.ws.rs.Produces;

import java.util.List;


@ApplicationScoped
public class ListProducer {

    @Produces
    public List<Integer> produceListOfInteger() {
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6);
        return list;
    }
}
