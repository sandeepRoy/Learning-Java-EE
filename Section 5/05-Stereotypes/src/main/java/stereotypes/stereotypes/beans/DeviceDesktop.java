package stereotypes.stereotypes.beans;

import stereotypes.stereotypes.qualifiers.DeviceQualifier;
import stereotypes.stereotypes.qualifiers.SeteroTypeQualifier;


@SeteroTypeQualifier
@DeviceQualifier(value = DeviceQualifier.DeviceTypes.Device_Desktop)
public class DeviceDesktop implements Device {

    @Override
    public String showDevice(String name) {
        System.out.println("8 : DeviceDesktop");
        return name + " : Desktop";
    }
}
