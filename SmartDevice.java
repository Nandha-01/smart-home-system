public abstract class SmartDevice {
    protected int deviceId;
    protected String status;

    public SmartDevice(int deviceId) {
        this.deviceId = deviceId;
        this.status = "off";
    }

    public abstract void turnOn();
    public abstract void turnOff();

    public int getDeviceId() {
        return deviceId;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Device " + deviceId + " is " + status;
    }
}
