/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.telephone;

public class NADTemperatureStruct {
    public short telNADTemperature;
    public int telNADTemperatureLevel;

    public NADTemperatureStruct() {
        this.telNADTemperature = 0;
        this.telNADTemperatureLevel = 0;
    }

    public NADTemperatureStruct(short s, int n) {
        this.telNADTemperature = s;
        this.telNADTemperatureLevel = n;
    }

    public short getTelNADTemperature() {
        return this.telNADTemperature;
    }

    public int getTelNADTemperatureLevel() {
        return this.telNADTemperatureLevel;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(150);
        stringBuffer.append("NADTemperatureStruct");
        stringBuffer.append('(');
        stringBuffer.append("telNADTemperature");
        stringBuffer.append('=');
        stringBuffer.append(this.telNADTemperature);
        stringBuffer.append(',');
        stringBuffer.append("telNADTemperatureLevel");
        stringBuffer.append('=');
        stringBuffer.append(this.telNADTemperatureLevel);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

