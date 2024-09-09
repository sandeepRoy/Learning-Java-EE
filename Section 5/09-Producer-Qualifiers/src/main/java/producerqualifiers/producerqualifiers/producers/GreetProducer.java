package producerqualifiers.producerqualifiers.producers;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.Produces;
import producerqualifiers.producerqualifiers.qualifiers.UserQualifier;

@ApplicationScoped
public class GreetProducer {
    @Produces()
    @UserQualifier
    public Greet greetUser(String username) {
        System.out.println("12 : Greet Producer");
        User user = new User();
        user.setName(username);
        return user;
    }


}
