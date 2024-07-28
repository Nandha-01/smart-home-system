public class ScheduledTask {
    private int deviceId;
    private String time;
    private String command;

    public ScheduledTask(int deviceId, String time, String command) {
        this.deviceId = deviceId;
        this.time = time;
        this.command = command;
    }

    @Override
    public String toString() {
        return "Scheduled Task: Device " + deviceId + " at " + time + " to " + command;
    }
}
