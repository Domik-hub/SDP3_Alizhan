package remote;

import device.Device;

public class QuietRemote extends Remote {
    public QuietRemote(String id, Device device) {
        super(id, 5, device);
    }

    @Override
    public String execute() {
        return device.applySettings(true, volumePreset);
    }
}