/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.careco;

public class BCmEEnergyFlowComfort {
    public boolean climateControlUnitHeater;
    public boolean airConditionCompressor;

    public BCmEEnergyFlowComfort() {
        this.climateControlUnitHeater = false;
        this.airConditionCompressor = false;
    }

    public BCmEEnergyFlowComfort(boolean bl, boolean bl2) {
        this.climateControlUnitHeater = bl;
        this.airConditionCompressor = bl2;
    }

    public boolean isClimateControlUnitHeater() {
        return this.climateControlUnitHeater;
    }

    public boolean isAirConditionCompressor() {
        return this.airConditionCompressor;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(150);
        stringBuffer.append("BCmEEnergyFlowComfort");
        stringBuffer.append('(');
        stringBuffer.append("climateControlUnitHeater");
        stringBuffer.append('=');
        stringBuffer.append(this.climateControlUnitHeater);
        stringBuffer.append(',');
        stringBuffer.append("airConditionCompressor");
        stringBuffer.append('=');
        stringBuffer.append(this.airConditionCompressor);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

