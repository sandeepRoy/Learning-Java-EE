package managedbeans.managedbeans.beans;

@managedbeans.managedbeans.qualifiers.DeviceLaptop
public class DeviceLaptop implements Device {

    @Override
    public String showDevice(String name) {
        return name + " : Laptop";
    }
}
