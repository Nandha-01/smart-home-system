public class DeviceFactory {
    public static SmartDevice createDevice(int deviceId, String type, int... extraParams) {
        switch (type.toLowerCase()) {
            case "light":
                return new Light(deviceId);
            case "thermostat":
                return new Thermostat(deviceId, extraParams[0]);
            case "doorlock":
                return new DoorLock(deviceId);
            default:
                throw new IllegalArgumentException("Invalid device type");
        }
    }
}
