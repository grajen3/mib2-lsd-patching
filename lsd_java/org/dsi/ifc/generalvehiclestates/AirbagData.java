/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.generalvehiclestates;

public class AirbagData {
    public int crashIntensity;
    public boolean diagnosis;
    public boolean actuatorTest;

    public AirbagData() {
        this.crashIntensity = 0;
        this.diagnosis = false;
        this.actuatorTest = false;
    }

    public AirbagData(int n, boolean bl, boolean bl2) {
        this.crashIntensity = n;
        this.diagnosis = bl;
        this.actuatorTest = bl2;
    }

    public int getCrashIntensity() {
        return this.crashIntensity;
    }

    public boolean isDiagnosis() {
        return this.diagnosis;
    }

    public boolean isActuatorTest() {
        return this.actuatorTest;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(150);
        stringBuffer.append("AirbagData");
        stringBuffer.append('(');
        stringBuffer.append("crashIntensity");
        stringBuffer.append('=');
        stringBuffer.append(this.crashIntensity);
        stringBuffer.append(',');
        stringBuffer.append("diagnosis");
        stringBuffer.append('=');
        stringBuffer.append(this.diagnosis);
        stringBuffer.append(',');
        stringBuffer.append("actuatorTest");
        stringBuffer.append('=');
        stringBuffer.append(this.actuatorTest);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

