package qualifiers.qualifiers.beans;

import jakarta.inject.Named;
import qualifiers.qualifiers.qualifiers.DeviceQualifier;

@Named
@DeviceQualifier(value = DeviceQualifier.DeviceTypes.Device_Laptop)
public class DeviceLaptop implements Device {

    @Override
    public String showDevice(String name) {
        return name + " : Laptop";
    }
}
