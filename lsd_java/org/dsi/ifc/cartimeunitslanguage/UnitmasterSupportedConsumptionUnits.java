/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.cartimeunitslanguage;

public class UnitmasterSupportedConsumptionUnits {
    public boolean kWhPerMiles;
    public boolean milesPerKg;
    public boolean milesPerM3;
    public boolean mpgeUS;

    public UnitmasterSupportedConsumptionUnits() {
        this.kWhPerMiles = false;
        this.milesPerKg = false;
        this.milesPerM3 = false;
        this.mpgeUS = false;
    }

    public UnitmasterSupportedConsumptionUnits(boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        this.kWhPerMiles = bl;
        this.milesPerKg = bl2;
        this.milesPerM3 = bl3;
        this.mpgeUS = bl4;
    }

    public boolean isKWhPerMiles() {
        return this.kWhPerMiles;
    }

    public boolean isMilesPerKg() {
        return this.milesPerKg;
    }

    public boolean isMilesPerM3() {
        return this.milesPerM3;
    }

    public boolean isMpgeUS() {
        return this.mpgeUS;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(200);
        stringBuffer.append("UnitmasterSupportedConsumptionUnits");
        stringBuffer.append('(');
        stringBuffer.append("kWhPerMiles");
        stringBuffer.append('=');
        stringBuffer.append(this.kWhPerMiles);
        stringBuffer.append(',');
        stringBuffer.append("milesPerKg");
        stringBuffer.append('=');
        stringBuffer.append(this.milesPerKg);
        stringBuffer.append(',');
        stringBuffer.append("milesPerM3");
        stringBuffer.append('=');
        stringBuffer.append(this.milesPerM3);
        stringBuffer.append(',');
        stringBuffer.append("mpgeUS");
        stringBuffer.append('=');
        stringBuffer.append(this.mpgeUS);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

