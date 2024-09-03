package stereotypes.stereotypes.qualifiers;

// Single Qualifier annotation to inject as per Type
// Replacement for multiple Qualifier Types

import jakarta.inject.Qualifier;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Qualifier
@Retention(RetentionPolicy.RUNTIME)
public @interface DeviceQualifier {
    DeviceTypes value();

    public enum DeviceTypes {
        Device_Desktop,
        Device_Laptop,
        Device_Phone,
    }
}
