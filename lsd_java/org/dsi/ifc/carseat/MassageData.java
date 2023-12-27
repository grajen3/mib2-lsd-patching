/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carseat;

public class MassageData {
    public int program;
    public int intensity;
    public int speed;

    public MassageData() {
        this.program = 0;
        this.intensity = 0;
        this.speed = 0;
    }

    public MassageData(int n, int n2, int n3) {
        this.program = n;
        this.intensity = n2;
        this.speed = n3;
    }

    public int getProgram() {
        return this.program;
    }

    public int getIntensity() {
        return this.intensity;
    }

    public int getSpeed() {
        return this.speed;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(150);
        stringBuffer.append("MassageData");
        stringBuffer.append('(');
        stringBuffer.append("program");
        stringBuffer.append('=');
        stringBuffer.append(this.program);
        stringBuffer.append(',');
        stringBuffer.append("intensity");
        stringBuffer.append('=');
        stringBuffer.append(this.intensity);
        stringBuffer.append(',');
        stringBuffer.append("speed");
        stringBuffer.append('=');
        stringBuffer.append(this.speed);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

