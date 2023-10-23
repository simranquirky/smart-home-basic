

class Fan extends SmartHomeDevice {
    private int speed;

    public Fan(String name, String location, String activationKey) {
        super(name, location, "Fan", activationKey);
        this.speed = 0; // Default speed is off
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        if (getStatus().equals("On")) {
            if (speed >= 1 && speed <= 5) {
                this.speed = speed;
            }
        }
    }
}