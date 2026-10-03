package device;

public class ProjectorDevice implements Device {
    @Override
    public String applySettings(boolean power, int volume) {
        String state = power ? "ON" : "OFF";
        return "Projector [power=" + state + ", volume=" + volume + "]";
    }
}