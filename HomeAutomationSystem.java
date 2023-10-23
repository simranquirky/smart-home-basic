import java.util.ArrayList;
import java.util.List;

public class HomeAutomationSystem {
    private List<InterfaceDevice> interfaceDevices = new ArrayList<>();
    private List<SmartHomeDevice> smartHomeDevices = new ArrayList<>();

    public String addInterfaceDevice(String name, String location, String activationKey) {
        for (InterfaceDevice device : interfaceDevices) {
            if (device.getActivationKey().equals(activationKey)) {
                return "Invalid Input: Activation Keyword already in use.";
            }
        }
        InterfaceDevice newInterface = new InterfaceDevice(name, location, activationKey);
        interfaceDevices.add(newInterface);
        return "Added " + name + " to " + location;
    }

    public String addSmartHomeDevice(String name, String location, String deviceType, String activationKey) {
        if (name != null && location != null) {
            for (SmartHomeDevice device : smartHomeDevices) {
                if (device.getName().equals(name) && device.getLocation().equals(location)) {
                    return "Invalid Input: Device with the same name and location already exists.";
                }
            }
        }

        SmartHomeDevice newDevice = new SmartHomeDevice(name, location, deviceType, activationKey);
        smartHomeDevices.add(newDevice);
        return "Added " + name +" : "+ deviceType + " to "+location;
    }

    public String giveCommand(String activationKey, String deviceName, String deviceLocation, String commandValue) {
        InterfaceDevice interfaceDevice = findInterfaceByActivationKey(activationKey);
        if (interfaceDevice == null) {
            return "Sorry, Invalid Command: Activation Keyword not found.";
        }

        SmartHomeDevice smartHomeDevice = findSmartHomeDevice(deviceName, deviceLocation);
        if (smartHomeDevice == null) {
            return "Sorry, Invalid Command: Device Not Found.";
        }

        return smartHomeDevice.executeCommand(commandValue);
    }

    public List<String> printConnectedDevices(String activationKey, String location) {
        List<String> connectedDevicesInfo = new ArrayList<>();
        InterfaceDevice interfaceDevice = findInterfaceByActivationKey(activationKey);

        if (interfaceDevice == null) {
            connectedDevicesInfo.add("Invalid Input: Activation Keyword not found.");
            return connectedDevicesInfo;
        }

        for (SmartHomeDevice device : smartHomeDevices) {
            if (device.getConnectedInterfaces().contains(interfaceDevice) && device.getLocation().equals(location)) {
                connectedDevicesInfo.add(device.getName() + " " + device.getStatus());
            }
        }
        return connectedDevicesInfo;
    }

    public String connectSmartHomeDevice(String activationKey, String deviceName, String deviceLocation) {
        SmartHomeDevice smartHomeDevice = findSmartHomeDevice(deviceName, deviceLocation);
        if (smartHomeDevice == null) {
            return "Invalid Input: Device " + deviceName+ " Not Found.";
        }

        InterfaceDevice interfaceDevice = findInterfaceByActivationKey(activationKey);
        if (interfaceDevice == null) {
            return "Invalid Input: Activation Keyword not found.";
        }

        smartHomeDevice.connectToInterface(interfaceDevice);
        return "Connected "+ deviceName + " to " + interfaceDevice.getName();
    }

    public String disconnectSmartHomeDevice(String activationKey, String deviceName, String deviceLocation) {
        SmartHomeDevice smartHomeDevice = findSmartHomeDevice(deviceName, deviceLocation);
        if (smartHomeDevice == null) {
            return "Invalid Input: Device Not Found.";
        }

        InterfaceDevice interfaceDevice = findInterfaceByActivationKey(activationKey);
        if (interfaceDevice == null) {
            return "Invalid Input: Activation Keyword not found.";
        }

        smartHomeDevice.disconnectFromInterface(interfaceDevice);
        return "Disconnected " + deviceName + " of " + deviceLocation + " from " + interfaceDevice.getName();
    }

    // Implement the give_special_command method

    private InterfaceDevice findInterfaceByActivationKey(String activationKey) {
        for (InterfaceDevice device : interfaceDevices) {
            if (device.getActivationKey().equals(activationKey)) {
                return device;
            }
        }
        return null;
    }

    private SmartHomeDevice findSmartHomeDevice(String name, String location) {
        for (SmartHomeDevice device : smartHomeDevices) {
            if (device.getName().equals(name) && device.getLocation().equals(location)) {
                return device;
            }
        }
        return null;
    }



}
