/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.cardriverassistance;

public class ACCAvailableDrivingPrograms {
    public boolean dynamic;
    public boolean comfort;
    public boolean standard;
    public boolean eco;

    public ACCAvailableDrivingPrograms() {
        this.dynamic = false;
        this.comfort = false;
        this.standard = false;
        this.eco = false;
    }

    public ACCAvailableDrivingPrograms(boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        this.dynamic = bl;
        this.comfort = bl2;
        this.standard = bl3;
        this.eco = bl4;
    }

    public boolean isDynamic() {
        return this.dynamic;
    }

    public boolean isComfort() {
        return this.comfort;
    }

    public boolean isStandard() {
        return this.standard;
    }

    public boolean isEco() {
        return this.eco;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(150);
        stringBuffer.append("ACCAvailableDrivingPrograms");
        stringBuffer.append('(');
        stringBuffer.append("dynamic");
        stringBuffer.append('=');
        stringBuffer.append(this.dynamic);
        stringBuffer.append(',');
        stringBuffer.append("comfort");
        stringBuffer.append('=');
        stringBuffer.append(this.comfort);
        stringBuffer.append(',');
        stringBuffer.append("standard");
        stringBuffer.append('=');
        stringBuffer.append(this.standard);
        stringBuffer.append(',');
        stringBuffer.append("eco");
        stringBuffer.append('=');
        stringBuffer.append(this.eco);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

