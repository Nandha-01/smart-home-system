public class Thermostat extends SmartDevice {
    private int temperature;

    public Thermostat(int deviceId, int temperature) {
        super(deviceId);
        this.temperature = temperature;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
        System.out.println("Thermostat " + deviceId + " temperature set to " + temperature + " degrees.");
    }

    @Override
    public void turnOn() {
        this.status = "on";
        System.out.println("Thermostat " + deviceId + " is turned on.");
    }

    @Override
    public void turnOff() {
        this.status = "off";
        System.out.println("Thermostat " + deviceId + " is turned off.");
    }
}
