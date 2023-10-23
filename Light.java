
import java.util.List;

class Light extends SmartHomeDevice {
    private int brightness;
    private String color;

    public Light(String name, String location, String activationKey) {
        super(name, location, "Light", activationKey);
        this.brightness = 0; // Default brightness is off
        this.color = "White"; // Default color is white
    }

    public int getBrightness() {
        return brightness;
    }

    public void setBrightness(int brightness) {
        if (getStatus().equals("On")) {
            if (brightness >= 1 && brightness <= 10) {
                this.brightness = brightness;
            }
        }
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        if (getStatus().equals("On")) {
            List<String> validColors = List.of("White", "Red", "Blue", "Green");
            if (validColors.contains(color)) {
                this.color = color;
            }
        }
    }
}