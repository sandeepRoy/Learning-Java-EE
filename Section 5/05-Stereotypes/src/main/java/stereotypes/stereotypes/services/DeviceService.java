package stereotypes.stereotypes.services;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import stereotypes.stereotypes.beans.Device;
import stereotypes.stereotypes.qualifiers.DeviceQualifier;

@ApplicationScoped
public class DeviceService {

    @Inject
    @DeviceQualifier(value = DeviceQualifier.DeviceTypes.Device_Desktop)
    private Device deviceDesktop;

    @Inject
    @DeviceQualifier(value = DeviceQualifier.DeviceTypes.Device_Laptop)
    private Device deviceLaptop;

    @Inject
    @DeviceQualifier(value = DeviceQualifier.DeviceTypes.Device_Phone)
    private Device devicePhone;

    public String showDesktopData(String name) {
        String device = deviceDesktop.showDevice(name);
        return device;
    }


    public String showLaptopData(String name) {
        String device = deviceLaptop.showDevice(name);
        return device;
    }

    public String showPhoneData(String name) {
        String device = devicePhone.showDevice(name);
        return device;
    }

    /*
     - Here we are trying to inject some beans of our desired types {DeviceDesktop, DeviceLaptop, DevicePhone}
     - But, all of these beans inherit from the same interface : Device
     - This will raise an ambiguity of Type Injection, Precisely which type we want to inject : DeviceLaptop or Device
     - In order to overcome this ambiguity, we go for Qualifier annotation.
*/


}
