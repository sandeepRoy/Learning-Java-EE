package managedbeans.managedbeans.services;



import jakarta.inject.Inject;
import managedbeans.managedbeans.beans.*;


public class DeviceService {

    @Inject
    @managedbeans.managedbeans.qualifiers.DeviceDesktop
    public DeviceDesktop deviceDesktop;

    @Inject
    @managedbeans.managedbeans.qualifiers.DeviceLaptop
    public DeviceLaptop deviceLaptop;

    @Inject
    @managedbeans.managedbeans.qualifiers.DevicePhone
    public DevicePhone devicePhone;


    public String showDesktopData(String name) {
        String hpWorkstationZ = deviceDesktop.showDevice("Asus ROG Strix G134");
        return hpWorkstationZ;
    }

    public String showLaptopData(String name) {
        String asusVivobook15 = deviceLaptop.showDevice("Asus VivoBook 15");
        return asusVivobook15;
    }

    public String showPhoneData(String name) {
        String asusZenfone3 = devicePhone.showDevice("Asus Zenfone 3");
        return asusZenfone3;
    }

    /*

     - Here we are trying to inject some beans of our desired types {DeviceDesktop, DeviceLaptop, DevicePhone}
     - But, all of these beans inherit from the same interface : Device
     - This will raise an ambiguity of Type Injection, Precisely which type we want to inject : DeviceLaptop or Device
     - In order to overcome this ambiguity, we go for Qualifier annotation.

      */
}
