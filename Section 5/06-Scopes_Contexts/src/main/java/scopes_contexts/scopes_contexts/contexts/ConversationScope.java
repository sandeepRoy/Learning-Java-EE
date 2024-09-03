package scopes_contexts.scopes_contexts.contexts;

import jakarta.enterprise.context.ConversationScoped;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

// Shorter than SessionScope
// Explicitly requires to be removed, else bean is kept alive till the session ends
@ConversationScoped
public class ConversationScope implements Serializable {
    private List<Integer> hashCodes;

    public ConversationScope() {
        hashCodes = new ArrayList<>();
    }

    public void setHashCode() {
        hashCodes.add(this.hashCode());
    }

    public List<Integer> getHashCodes() {
        return hashCodes;
    }
}
