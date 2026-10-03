package device;

public class RadioDevice implements Device {
    @Override
    public String applySettings(boolean power, int volume) {
        String state = power ? "ON" : "OFF";
        return "Radio [power=" + state + ", volume=" + volume + "]";
    }
}