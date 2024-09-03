package qualifiers.qualifiers.beans;

import jakarta.inject.Named;
import qualifiers.qualifiers.qualifiers.DeviceQualifier;

@Named
@DeviceQualifier(value = DeviceQualifier.DeviceTypes.Device_Desktop)
public class DeviceDesktop implements Device {

    @Override
    public String showDevice(String name) {
        System.out.println("8 : DeviceDesktop");
        return name + " : Desktop";
    }
}
