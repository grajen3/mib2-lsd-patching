/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carparkingsystem;

public class WCVehiclePanelInfo {
    public String software;
    public String hardware;

    public WCVehiclePanelInfo() {
        this.software = null;
        this.hardware = null;
    }

    public WCVehiclePanelInfo(String string, String string2) {
        this.software = string;
        this.hardware = string2;
    }

    public String getSoftware() {
        return this.software;
    }

    public String getHardware() {
        return this.hardware;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(200);
        stringBuffer.append("WCVehiclePanelInfo");
        stringBuffer.append('(');
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
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

