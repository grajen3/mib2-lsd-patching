/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.sdars;

public class SignalQuality {
    public int compositeQuality;
    public int satelliteQuality;
    public int terrestrialQuality;

    public SignalQuality() {
        this.compositeQuality = 0;
        this.satelliteQuality = 0;
        this.terrestrialQuality = 0;
    }

    public SignalQuality(int n, int n2, int n3) {
        this.compositeQuality = n;
        this.satelliteQuality = n2;
        this.terrestrialQuality = n3;
    }

    public int getCompositeQuality() {
        return this.compositeQuality;
    }

    public int getSatelliteQuality() {
        return this.satelliteQuality;
    }

    public int getTerrestrialQuality() {
        return this.terrestrialQuality;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(200);
        stringBuffer.append("SignalQuality");
        stringBuffer.append('(');
        stringBuffer.append("compositeQuality");
        stringBuffer.append('=');
        stringBuffer.append(this.compositeQuality);
        stringBuffer.append(',');
        stringBuffer.append("satelliteQuality");
        stringBuffer.append('=');
        stringBuffer.append(this.satelliteQuality);
        stringBuffer.append(',');
        stringBuffer.append("terrestrialQuality");
        stringBuffer.append('=');
        stringBuffer.append(this.terrestrialQuality);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

