package scopes_contexts.scopes_contexts.contexts;

import jakarta.enterprise.context.ApplicationScoped;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

// Single instance of Bean throughout the application lifecycle
@ApplicationScoped
public class ApplicationScope implements Serializable {
    private List<Integer> hashCodes;

    public ApplicationScope() {
        hashCodes = new ArrayList<>();
    }

    public void setHashCode() {
        hashCodes.add(this.hashCode());
    }

    public List<Integer> getHashCodes() {
        return hashCodes;
    }
}
