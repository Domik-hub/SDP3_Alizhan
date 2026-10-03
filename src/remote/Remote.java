package remote;

import device.Device;

public abstract class Remote {
    protected final String id;
    protected final int volumePreset;
    protected Device device;

    public Remote(String id, int volumePreset, Device device) {
        this.id = id;
        this.volumePreset = volumePreset;
        this.device = device;
    }

    public void setImplementation(Device device) {
        this.device = device;
    }

    public String getId() {
        return id;
    }

    public int getVolumePreset() {
        return volumePreset;
    }

    public abstract String execute();
}