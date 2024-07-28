public class DoorLock extends SmartDevice {

    public DoorLock(int deviceId) {
        super(deviceId);
        this.status = "locked";
    }

    @Override
    public void turnOn() {
        this.status = "unlocked";
        System.out.println("Door " + deviceId + " is unlocked.");
    }

    @Override
    public void turnOff() {
        this.status = "locked";
        System.out.println("Door " + deviceId + " is locked.");
    }
}
