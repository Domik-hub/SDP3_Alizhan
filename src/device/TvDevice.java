package device;

public class TvDevice implements Device {
    @Override
    public String applySettings(boolean power, int volume) {
        String state = power ? "ON" : "OFF";
        return "TV [power=" + state + ", volume=" + volume + "]";
    }
}