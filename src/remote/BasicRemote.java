package remote;

import device.Device;

public class BasicRemote extends Remote {
    public BasicRemote(String id, Device device) {
        super(id, 30, device);
    }

    @Override
    public String execute() {
        return device.applySettings(true, volumePreset);
    }
}