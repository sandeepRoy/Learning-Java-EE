package scopes_contexts.scopes_contexts.contexts;

import jakarta.enterprise.context.RequestScoped;

import java.util.ArrayList;
import java.util.List;

// Every HTTP Request creates a Bean, Bean is destroyed once requests ends
@RequestScoped
public class RequestScope {
    private List<Integer> hashCodes;

    public RequestScope() {
        hashCodes = new ArrayList<>();
    }

    public void setHashCode() {
        hashCodes.add(this.hashCode());
    }

    public List<Integer> getHashCodes() {
        return hashCodes;
    }
}
