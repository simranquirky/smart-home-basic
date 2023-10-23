import java.util.ArrayList;
import java.util.List;

public class InterfaceDevice {
    private String name;
    private String location;
    private String activationKey;
    private List<SmartHomeDevice> connectedSmartDevices = new ArrayList<>();

    public InterfaceDevice(String name, String location, String activationKey) {
        this.name = name;
        this.location = location;
        this.activationKey = activationKey;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String getActivationKey() {
        return activationKey;
    }

    public List<SmartHomeDevice> getConnectedSmartDevices() {
        return new ArrayList<>(connectedSmartDevices);
    }

    public void connectSmartDevice(SmartHomeDevice device) {
        connectedSmartDevices.add(device);
    }

    public void disconnectSmartDevice(SmartHomeDevice device) {
        connectedSmartDevices.remove(device);
    }

    @Override
    public String toString() {
        return "InterfaceDevice{" +
                "name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", activationKey='" + activationKey + '\'' +
                ", connectedSmartDevices=" + connectedSmartDevices +
                '}';
    }
}
