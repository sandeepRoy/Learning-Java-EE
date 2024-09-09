package dispose_demo.services;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Disposes;
import jakarta.enterprise.inject.Produces;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class DishService {
    @Produces
    public List<String> produceDishes() {
        List<String> dishes = new ArrayList<>();
        dishes.add("Biriyani");
        dishes.add("Pulao");
        dishes.add("Butter Chicken");
        dishes.add("Moussaka");
        dishes.add("Steak");
        dishes.add("Pizza Pepperoni");

        return dishes;
    }

    public void disposeDishes(@Disposes List<String> dishes) {
        dishes = null;
    }
}
