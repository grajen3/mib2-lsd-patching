/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.cardrivingcharacteristics;

public class CharismaOperationMode {
    public boolean evMode;
    public boolean hybridMode;
    public boolean sustainingMode;
    public boolean chargingMode;
    public boolean socControlMode;
    public boolean hybridSportMode;

    public CharismaOperationMode() {
        this.evMode = false;
        this.hybridMode = false;
        this.sustainingMode = false;
        this.chargingMode = false;
        this.socControlMode = false;
        this.hybridSportMode = false;
    }

    public CharismaOperationMode(boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6) {
        this.evMode = bl;
        this.hybridMode = bl2;
        this.sustainingMode = bl3;
        this.chargingMode = bl4;
        this.socControlMode = bl5;
        this.hybridSportMode = bl6;
    }

    public boolean isEvMode() {
        return this.evMode;
    }

    public boolean isHybridMode() {
        return this.hybridMode;
    }

    public boolean isSustainingMode() {
        return this.sustainingMode;
    }

    public boolean isChargingMode() {
        return this.chargingMode;
    }

    public boolean isSocControlMode() {
        return this.socControlMode;
    }

    public boolean isHybridSportMode() {
        return this.hybridSportMode;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(300);
        stringBuffer.append("CharismaOperationMode");
        stringBuffer.append('(');
        stringBuffer.append("evMode");
        stringBuffer.append('=');
        stringBuffer.append(this.evMode);
        stringBuffer.append(',');
        stringBuffer.append("hybridMode");
        stringBuffer.append('=');
        stringBuffer.append(this.hybridMode);
        stringBuffer.append(',');
        stringBuffer.append("sustainingMode");
        stringBuffer.append('=');
        stringBuffer.append(this.sustainingMode);
        stringBuffer.append(',');
        stringBuffer.append("chargingMode");
        stringBuffer.append('=');
        stringBuffer.append(this.chargingMode);
        stringBuffer.append(',');
        stringBuffer.append("socControlMode");
        stringBuffer.append('=');
        stringBuffer.append(this.socControlMode);
        stringBuffer.append(',');
        stringBuffer.append("hybridSportMode");
        stringBuffer.append('=');
        stringBuffer.append(this.hybridSportMode);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

