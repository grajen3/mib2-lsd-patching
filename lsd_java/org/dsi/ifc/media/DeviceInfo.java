/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.media;

public class DeviceInfo {
    public long deviceID;
    public int deviceType;
    public int numSlots;
    public int flags;

    public DeviceInfo() {
        this.deviceID = 0L;
        this.deviceType = 0;
        this.numSlots = 0;
        this.flags = 0;
    }

    public DeviceInfo(long l, int n, int n2, int n3) {
        this.deviceID = l;
        this.deviceType = n;
        this.numSlots = n2;
        this.flags = n3;
    }

    public long getDeviceID() {
        return this.deviceID;
    }

    public int getDeviceType() {
        return this.deviceType;
    }

    public int getNumSlots() {
        return this.numSlots;
    }

    public int getFlags() {
        return this.flags;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(250);
        stringBuffer.append("DeviceInfo");
        stringBuffer.append('(');
        stringBuffer.append("deviceID");
        stringBuffer.append('=');
        stringBuffer.append(this.deviceID);
        stringBuffer.append(',');
        stringBuffer.append("deviceType");
        stringBuffer.append('=');
        stringBuffer.append(this.deviceType);
        stringBuffer.append(',');
        stringBuffer.append("numSlots");
        stringBuffer.append('=');
        stringBuffer.append(this.numSlots);
        stringBuffer.append(',');
        stringBuffer.append("flags");
        stringBuffer.append('=');
        stringBuffer.append(this.flags);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

