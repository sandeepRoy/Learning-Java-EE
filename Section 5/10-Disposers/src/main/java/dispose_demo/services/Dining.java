package dispose_demo.services;

import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.util.List;

@Named
public class Dining {
    @Inject
    private List<String> dishes;

    public List<String> getDishes() {
        return dishes;
    }

    public void closeDinner() {
        dishes.clear();
    }
}
