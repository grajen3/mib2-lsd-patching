/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.mirrorlink.transformer;

import org.dsi.ifc.mirrorlink.Device;

public final class MirrorLinkDeviceListCollector
implements Comparable {
    private Device _device = null;
    private boolean _connectionStatus = false;

    public String toString() {
        String string = null;
        Device device = this.getDevice();
        if (device != null) {
            string = new StringBuffer().append(device.toString()).append(" ConnectionStatus = ").append(this._connectionStatus).toString();
        }
        return string != null ? string : "";
    }

    public MirrorLinkDeviceListCollector(Device device) {
        this._device = device;
    }

    public Device getDevice() {
        return this._device;
    }

    public int getDeviceID() {
        if (this._device != null) {
            return this._device.getDeviceID();
        }
        return -1;
    }

    public String getDeviceName() {
        if (this._device != null) {
            return this._device.getDeviceName();
        }
        return "";
    }

    public int getConnectionMedium() {
        if (this._device != null) {
            return this._device.getConnectionMedium();
        }
        return 0;
    }

    public boolean isConnected() {
        return this._connectionStatus;
    }

    public boolean setConnectionStatus(boolean bl) {
        if (this._connectionStatus != bl) {
            this._connectionStatus = bl;
            return true;
        }
        return false;
    }

    @Override
    public int compareTo(Object object) {
        MirrorLinkDeviceListCollector mirrorLinkDeviceListCollector = (MirrorLinkDeviceListCollector)object;
        return this._device.getDeviceName().compareTo(mirrorLinkDeviceListCollector.getDeviceName());
    }
}

