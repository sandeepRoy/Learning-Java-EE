package producerqualifiers.producerqualifiers.producers;

import jakarta.enterprise.context.ApplicationScoped;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import producerqualifiers.producerqualifiers.qualifiers.UserQualifier;

@Data
@AllArgsConstructor
@NoArgsConstructor
@UserQualifier
@ApplicationScoped
public class User implements Greet {
    private String name;

    @Override
    public String greet() {
        return "Hello " + name;
    }
}
