/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carplay;

public class DeviceInfo {
    public String deviceID;
    public String deviceName;
    public String deviceLanguage;
    public String osBuildVersion;
    public String airplayVersion;
    public String sessionID;

    public DeviceInfo() {
        this.deviceID = "";
        this.deviceName = "";
        this.deviceLanguage = "";
        this.osBuildVersion = "";
        this.airplayVersion = "";
        this.sessionID = "";
    }

    public DeviceInfo(String string, String string2, String string3, String string4, String string5, String string6) {
        this.deviceID = string;
        this.deviceName = string2;
        this.deviceLanguage = string3;
        this.osBuildVersion = string4;
        this.airplayVersion = string5;
        this.sessionID = string6;
    }

    public String getDeviceID() {
        return this.deviceID;
    }

    public String getDeviceName() {
        return this.deviceName;
    }

    public String getDeviceLanguage() {
        return this.deviceLanguage;
    }

    public String getOsBuildVersion() {
        return this.osBuildVersion;
    }

    public String getAirplayVersion() {
        return this.airplayVersion;
    }

    public String getSessionID() {
        return this.sessionID;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(500);
        stringBuffer.append("DeviceInfo");
        stringBuffer.append('(');
        stringBuffer.append("deviceID");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.deviceID);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("deviceName");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.deviceName);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("deviceLanguage");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.deviceLanguage);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("osBuildVersion");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.osBuildVersion);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("airplayVersion");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.airplayVersion);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("sessionID");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.sessionID);
        stringBuffer.append('\"');
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

