/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carparkingsystem;

import org.dsi.ifc.carparkingsystem.WCPanelStates;

public class WCPanelListRecord {
    public int pos = 0;
    public String serialNumber;
    public String name;
    public String pin;
    public String software;
    public String hardware;
    public WCPanelStates state;
    public int info;

    public WCPanelListRecord() {
        this.serialNumber = null;
        this.name = null;
        this.pin = null;
        this.software = null;
        this.hardware = null;
        this.state = null;
        this.info = 0;
    }

    public WCPanelListRecord(int n, String string, String string2, String string3, String string4, String string5, WCPanelStates wCPanelStates, int n2) {
        this.serialNumber = string;
        this.name = string2;
        this.pin = string3;
        this.software = string4;
        this.hardware = string5;
        this.state = wCPanelStates;
        this.info = n2;
    }

    public int getPos() {
        return this.pos;
    }

    public String getSerialNumber() {
        return this.serialNumber;
    }

    public String getName() {
        return this.name;
    }

    public String getPin() {
        return this.pin;
    }

    public String getSoftware() {
        return this.software;
    }

    public String getHardware() {
        return this.hardware;
    }

    public WCPanelStates getState() {
        return this.state;
    }

    public int getInfo() {
        return this.info;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(1500);
        stringBuffer.append("WCPanelListRecord");
        stringBuffer.append('(');
        stringBuffer.append("pos");
        stringBuffer.append('=');
        stringBuffer.append(this.pos);
        stringBuffer.append(',');
        stringBuffer.append("serialNumber");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.serialNumber);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("name");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.name);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("pin");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.pin);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("software");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.software);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("hardware");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.hardware);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("state");
        stringBuffer.append('=');
        stringBuffer.append(this.state);
        stringBuffer.append(',');
        stringBuffer.append("info");
        stringBuffer.append('=');
        stringBuffer.append(this.info);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

