/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.smartphoneintegration.transformer;

import org.dsi.ifc.smartphoneintegration.Device;

public class SmartPhoneIntegrationDeviceListCollector
implements Comparable {
    private Device device = null;

    public SmartPhoneIntegrationDeviceListCollector(Device device) {
        this.device = device;
    }

    public String toString() {
        String string = null;
        Device device = this.getDevice();
        if (device != null) {
            string = new StringBuffer().append(device.toString()).append(" devicename= = ").append(device.getDeviceName()).toString();
        }
        return string != null ? string : "";
    }

    public Device getDevice() {
        return this.device;
    }

    public boolean compareDevice(Device device) {
        return this.device.getDeviceID() == device.getDeviceID();
    }

    public int getDeviceID() {
        if (this.device != null) {
            return this.device.getDeviceID();
        }
        return -1;
    }

    public String getDeviceName() {
        if (this.device != null) {
            return this.device.getDeviceName();
        }
        return "";
    }

    public String getDeviceAdress() {
        if (this.device != null) {
            return this.device.getDeviceAddress();
        }
        return "";
    }

    public int getDeviceConnectionMethod() {
        if (this.device != null) {
            return this.device.getConnectionMethod();
        }
        return -1;
    }

    public int getDeviceConnectionType() {
        if (this.device != null) {
            return this.device.getConnectionType();
        }
        return -1;
    }

    @Override
    public int compareTo(Object object) {
        SmartPhoneIntegrationDeviceListCollector smartPhoneIntegrationDeviceListCollector = (SmartPhoneIntegrationDeviceListCollector)object;
        return this.device.getDeviceName().compareTo(smartPhoneIntegrationDeviceListCollector.getDeviceName());
    }
}

