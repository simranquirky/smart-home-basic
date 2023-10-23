import java.util.List;

public class App {
    
    public static void main(String[] args) {
        HomeAutomationSystem system = new HomeAutomationSystem();

        // Example commands
        System.out.println(system.addInterfaceDevice("Google Home", "Living Room", "OK Google")); // Added
        System.out.println(system.addInterfaceDevice("Alexa", "Drawing Room", "Alexa")); // Added
        System.out.println(system.addSmartHomeDevice("Light Bulb 1", "Drawing Room", "Light", "Alexa")); // Added
        System.out.println(system.addSmartHomeDevice("Fan 1", "Living Room", "Fan", "OK Google")); // Added

        // Connect a smart home device to an interface
        System.out.println(system.connectSmartHomeDevice("Alexa", "Smart Charger", null)); // Not found
        System.out.println(system.connectSmartHomeDevice("Alexa", "Light Bulb 1", "Drawing Room"));
        
        // Give a command
        System.out.println(system.giveCommand("Alexa", "Light Bulb 1", "Drawing Room", "ON")); // OK, Drawing Room Light Turned On

        // Print connected devices
        List<String> connectedDevices = system.printConnectedDevices("Alexa", "Drawing Room");
        for (String deviceInfo : connectedDevices) {
            System.out.println(deviceInfo);
        }

        // Give a command
        System.out.println(system.giveCommand("OK Google", "Fan 1", "Living Room", "ON")); // OK, Living Room Fan turned on

        // Disconnect a smart home device from an interface
        System.out.println(system.disconnectSmartHomeDevice("Alexa", "Light Bulb 1", "Drawing Room")); // OK, Light Bulb 1 disconnected
    
}

}
