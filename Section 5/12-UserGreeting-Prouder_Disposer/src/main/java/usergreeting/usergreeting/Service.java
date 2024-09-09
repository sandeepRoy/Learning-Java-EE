package usergreeting.usergreeting;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Disposes;
import jakarta.enterprise.inject.Produces;

import java.util.logging.Logger;

@ApplicationScoped
public class Service {

    private static final Logger LOGGER = Logger.getLogger(Service.class.getName());

    @Produces
    public User createUser() {
        return new User("Sandeep Roy");
    }

    public void disposeUser(@Disposes User user) {
        LOGGER.info("Disposing User: " + user.getName());
    }

    public String disposeUserManually(User user) {
        disposeUser(user);
        return "Disposed";
    }
}
