package scopes_contexts.scopes_contexts.contexts;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class DependentScope implements Serializable {

    private List<Integer> hashCodes;

    public DependentScope() {
        hashCodes = new ArrayList<>();
    }

    public void setHashCode() {
        hashCodes.add(this.hashCode());
    }

    public List<Integer> getHashCodes() {
        return hashCodes;
    }
}
