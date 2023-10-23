
import java.util.HashSet;
import java.util.List;

public class SmartHomeDevice {
    private String name;
    private String location;
    private String deviceType;
    private String activationKeyword;
    private String status;
        private HashSet<InterfaceDevice> connectedInterfaces = new HashSet<>();


    public SmartHomeDevice(String name, String location, String deviceType, String activationKeyword) {
        this.name = name;
        this.location = location;
        this.deviceType = deviceType;
        this.activationKeyword = activationKeyword;
        this.status = "Off";
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getDeviceType() {
        return null;
    }

    public void connectToInterface(InterfaceDevice interfaceDevice) {
        connectedInterfaces.add(interfaceDevice);
    }

    public void disconnectFromInterface(InterfaceDevice interfaceDevice) {
        connectedInterfaces.remove(interfaceDevice);
    }

    public HashSet<InterfaceDevice> getConnectedInterfaces() {
        return connectedInterfaces;
    }

    public String executeCommand(String commandValue) {
        if ("ON".equalsIgnoreCase(commandValue)) {
            status = "ON";
            return "OK, " + location + " " + name + " Turned On";
        } else if ("OFF".equalsIgnoreCase(commandValue)) {
            status = "OFF";
            return "OK, " + location + " " + name + " Turned Off";
        } else {
            return "Sorry, Invalid Command: " + name + " does not understand the command.";
        }
    }

}