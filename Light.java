public class Light extends SmartDevice {

    public Light(int deviceId) {
        super(deviceId);
    }

    @Override
    public void turnOn() {
        this.status = "on";
        System.out.println("Light " + deviceId + " is turned on.");
    }

    @Override
    public void turnOff() {
        this.status = "off";
        System.out.println("Light " + deviceId + " is turned off.");
    }
}
