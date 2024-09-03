package qualifiers.qualifiers.qualifiers;

// Single Qualifier annotation to inject as per Type
// Replacement for multiple Qualifier Types

import jakarta.inject.Qualifier;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Qualifier
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.TYPE, ElementType.METHOD})
public @interface DeviceQualifier {
    DeviceTypes value();

    public enum DeviceTypes {
        Device_Desktop,
        Device_Laptop,
        Device_Phone,
    }
}
