package scopes_contexts.scopes_contexts.contexts;

import jakarta.enterprise.context.SessionScoped;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

// A session refers to a continuous communication in between client and server,
// Thus Beans created using SessionScope will process the subsequent requests and will maintain the bean state.
@SessionScoped
public class SessionScope implements Serializable {

    private List<Integer> hashCodes;

    public SessionScope() {
        hashCodes = new ArrayList<>();
    }

    public void setHashCode() {
        hashCodes.add(this.hashCode());
    }

    public List<Integer> getHashCodes() {
        return hashCodes;
    }
}
