/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carlight;

public class ExtLightSensorErrorDetectionState {
    public int sensor;
    public int state;

    public ExtLightSensorErrorDetectionState() {
        this.sensor = 0;
        this.state = 0;
    }

    public ExtLightSensorErrorDetectionState(int n, int n2) {
        this.sensor = n;
        this.state = n2;
    }

    public int getSensor() {
        return this.sensor;
    }

    public int getState() {
        return this.state;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(100);
        stringBuffer.append("ExtLightSensorErrorDetectionState");
        stringBuffer.append('(');
        stringBuffer.append("sensor");
        stringBuffer.append('=');
        stringBuffer.append(this.sensor);
        stringBuffer.append(',');
        stringBuffer.append("state");
        stringBuffer.append('=');
        stringBuffer.append(this.state);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

