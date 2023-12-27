/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carlight;

public class MotorwayBlinkingSettings {
    public int time;
    public boolean state;

    public MotorwayBlinkingSettings() {
        this.time = 0;
        this.state = false;
    }

    public MotorwayBlinkingSettings(int n, boolean bl) {
        this.time = n;
        this.state = bl;
    }

    public int getTime() {
        return this.time;
    }

    public boolean isState() {
        return this.state;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(100);
        stringBuffer.append("MotorwayBlinkingSettings");
        stringBuffer.append('(');
        stringBuffer.append("time");
        stringBuffer.append('=');
        stringBuffer.append(this.time);
        stringBuffer.append(',');
        stringBuffer.append("state");
        stringBuffer.append('=');
        stringBuffer.append(this.state);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

