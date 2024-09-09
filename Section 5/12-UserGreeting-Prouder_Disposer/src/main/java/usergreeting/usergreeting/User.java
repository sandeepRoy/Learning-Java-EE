package usergreeting.usergreeting;

import jakarta.inject.Named;
import jdk.jfr.DataAmount;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Named("user")
public class User implements Greet {
    private String name;

    @Override
    public String greet() {
        return "Hello " + name;
    }
}
