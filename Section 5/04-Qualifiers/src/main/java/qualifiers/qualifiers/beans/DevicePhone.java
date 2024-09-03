package qualifiers.qualifiers.beans;

import jakarta.inject.Named;
import qualifiers.qualifiers.qualifiers.DeviceQualifier;

@Named
@DeviceQualifier(value = DeviceQualifier.DeviceTypes.Device_Phone)
public class DevicePhone implements Device {

    @Override
    public String showDevice(String name) {
        return name + " : Phone";
    }
}
