package managedbeans.managedbeans.beans;

@managedbeans.managedbeans.qualifiers.DeviceDesktop
public class DeviceDesktop implements Device {

    @Override
    public String showDevice(String name) {
        System.out.println("8 : DeviceDesktop");
        return name + " : Desktop";
    }
}
