import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class SmartHomeHub implements Subject {
    private Map<Integer, SmartDevice> devices;
    private List<Observer> observers;
    private List<ScheduledTask> scheduledTasks;
    private List<Trigger> triggers;

    public SmartHomeHub() {
        devices = new HashMap<>();
        observers = new ArrayList<>();
        scheduledTasks = new ArrayList<>();
        triggers = new ArrayList<>();
    }

    public void addDevice(SmartDevice device) {
        devices.put(device.getDeviceId(), device);
        notifyObservers("Device " + device.getDeviceId() + " added.");
    }

    public void removeDevice(int deviceId) {
        devices.remove(deviceId);
        notifyObservers("Device " + deviceId + " removed.");
    }

    public void turnOnDevice(int deviceId) {
        SmartDevice device = devices.get(deviceId);
        if (device != null) {
            device.turnOn();
            checkTriggers();
            notifyObservers("Device " + deviceId + " turned on.");
        }
    }

    public void turnOffDevice(int deviceId) {
        SmartDevice device = devices.get(deviceId);
        if (device != null) {
            device.turnOff();
            checkTriggers();
            notifyObservers("Device " + deviceId + " turned off.");
        }
    }

    public void setSchedule(int deviceId, String time, String command) {
        scheduledTasks.add(new ScheduledTask(deviceId, time, command));
        notifyObservers("Scheduled task for device " + deviceId + " at " + time + " to " + command + ".");
        scheduleTask(deviceId, time, command);
    }

    private void scheduleTask(int deviceId, String time, String command) {
        String[] parts = time.split(":");
        int hour = Integer.parseInt(parts[0]);
        int minute = Integer.parseInt(parts[1]);

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (command.equalsIgnoreCase("Turn On")) {
                    turnOnDevice(deviceId);
                } else if (command.equalsIgnoreCase("Turn Off")) {
                    turnOffDevice(deviceId);
                }
            }
        }, getTimeUntil(hour, minute));
    }

    private long getTimeUntil(int hour, int minute) {
        // Calculate the delay time in milliseconds
        long currentMillis = System.currentTimeMillis();
        long targetMillis = currentMillis + (hour * 3600 + minute * 60) * 1000;
        return targetMillis - currentMillis;
    }

    public void addTrigger(String condition, String action) {
        triggers.add(new Trigger(condition, action));
        notifyObservers("Trigger added: " + condition + " -> " + action);
    }

    private void checkTriggers() {
        for (Trigger trigger : triggers) {
            // Evaluate the condition and perform the action if the condition is met
        }
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }
}
