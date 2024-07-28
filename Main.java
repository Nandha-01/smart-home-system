public class Main {
    public static void main(String[] args) {
        SmartHomeHub hub = new SmartHomeHub();
        hub.registerObserver(new ConcreteObserver("Observer1"));

        SmartDevice light = DeviceFactory.createDevice(1, "light");
        SmartDevice thermostat = DeviceFactory.createDevice(2, "thermostat", 70);
        SmartDevice doorLock = DeviceFactory.createDevice(3, "doorlock");

        hub.addDevice(light);
        hub.addDevice(thermostat);
        hub.addDevice(doorLock);

        hub.turnOnDevice(1);
        hub.setSchedule(2, "06:00", "Turn On");
        hub.addTrigger("temperature > 75", "turnOff(1)");
    }
}
