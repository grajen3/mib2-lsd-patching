/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.smartphoneintegration.common;

import org.dsi.ifc.smartphoneintegration.Device;

public class DeviceASLExtended {
    private Device dsiDevice;
    private int lastConnectionMethod;
    private int selectedConnectionMethod = -1;
    private boolean blacklisted = false;
    private String classname = "DeviceASLExtended";

    public DeviceASLExtended() {
        this.dsiDevice = new Device(-1, "", 0, "", 0);
    }

    public DeviceASLExtended(Device device) {
        this.setDsiDevice(device);
    }

    public Device getDsiDevice() {
        return this.dsiDevice;
    }

    public void setDsiDevice(Device device) {
        if (device == null) {
            this.dsiDevice = new Device(-1, "", 0, "", 0);
        } else {
            Device device2 = new Device();
            device2.connectionMethod = device.getConnectionMethod();
            device2.connectionType = device.getConnectionType();
            device2.deviceAddress = device.getDeviceAddress();
            device2.deviceName = device.getDeviceName();
            device2.deviceID = device.getDeviceID();
            this.dsiDevice = device2;
        }
    }

    public int getLastConnectionMethod() {
        return this.lastConnectionMethod;
    }

    public void setLastConnectionMethod(int n) {
        this.lastConnectionMethod = n == 2 ? 4 : n;
    }

    public String toString() {
        String string = "";
        if (this.dsiDevice != null) {
            if (this.dsiDevice.getDeviceName().length() > 0) {
                string = string.concat("Name:  ");
                string = string.concat(this.dsiDevice.getDeviceName());
            }
            if (this.dsiDevice.getDeviceID() != -1) {
                string = string.concat(" , ID:  ");
                string = string.concat(new StringBuffer().append(this.dsiDevice.getDeviceID()).append("").toString());
            }
            string = string.concat(" , address: ");
            string = string.concat(new StringBuffer().append(this.dsiDevice.getDeviceAddress()).append("").toString());
            string = string.concat(" , LastConn.Method:  ");
            string = string.concat(new StringBuffer().append(this.lastConnectionMethod).append("").toString());
            string = string.concat(" , isblacklisted:  ");
            string = string.concat(new StringBuffer().append(this.isBlacklisted()).append("").toString());
            return string;
        }
        return "empty device";
    }

    public int hashCode() {
        return this.dsiDevice.getDeviceAddress().hashCode();
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (super.getClass() != object.getClass()) {
            return false;
        }
        if (this.dsiDevice == null || this.dsiDevice.getDeviceAddress() == null) {
            return false;
        }
        DeviceASLExtended deviceASLExtended = (DeviceASLExtended)object;
        return this.dsiDevice.getDeviceAddress().equals(deviceASLExtended.dsiDevice.getDeviceAddress());
    }

    public boolean isBlacklisted() {
        return this.blacklisted;
    }

    public void setBlacklisted(boolean bl) {
        this.blacklisted = bl;
    }

    public int getDeviceID() {
        return this.dsiDevice.getDeviceID();
    }

    public String getDeviceAddress() {
        return this.dsiDevice.getDeviceAddress();
    }

    public String getDeviceName() {
        return this.dsiDevice.getDeviceName();
    }

    public int getConnectionMethod() {
        return this.dsiDevice.getConnectionMethod();
    }

    public int getSelectedConnectionMethod() {
        if (this.selectedConnectionMethod == 0) {
            return 8;
        }
        if (this.selectedConnectionMethod == 1) {
            return 1;
        }
        if (this.selectedConnectionMethod == 2) {
            return 4;
        }
        if (this.selectedConnectionMethod == 3) {
            return 32;
        }
        return -1;
    }

    public void setSelectedConnectionMethod(int n) {
        this.selectedConnectionMethod = n;
    }
}

