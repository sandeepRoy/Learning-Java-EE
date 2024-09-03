package stereotypes.stereotypes.beans;

import stereotypes.stereotypes.qualifiers.DeviceQualifier;
import stereotypes.stereotypes.qualifiers.SeteroTypeQualifier;

@SeteroTypeQualifier
@DeviceQualifier(value = DeviceQualifier.DeviceTypes.Device_Phone)
public class DevicePhone implements Device {

    @Override
    public String showDevice(String name) {
        return name + " : Phone";
    }
}
