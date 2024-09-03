package managedbeans.managedbeans.beans;

@managedbeans.managedbeans.qualifiers.DevicePhone
public class DevicePhone implements Device {

    @Override
    public String showDevice(String name) {
        return name + " : Phone";
    }
}
