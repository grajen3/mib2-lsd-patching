/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.caraircondition;

public class AirconPureAirSetup {
    public boolean systemOnOff;
    public boolean ionisator;
    public boolean fragrance;

    public AirconPureAirSetup() {
        this.systemOnOff = false;
        this.ionisator = false;
        this.fragrance = false;
    }

    public AirconPureAirSetup(boolean bl, boolean bl2, boolean bl3) {
        this.systemOnOff = bl;
        this.ionisator = bl2;
        this.fragrance = bl3;
    }

    public boolean isSystemOnOff() {
        return this.systemOnOff;
    }

    public boolean isIonisator() {
        return this.ionisator;
    }

    public boolean isFragrance() {
        return this.fragrance;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(150);
        stringBuffer.append("AirconPureAirSetup");
        stringBuffer.append('(');
        stringBuffer.append("systemOnOff");
        stringBuffer.append('=');
        stringBuffer.append(this.systemOnOff);
        stringBuffer.append(',');
        stringBuffer.append("ionisator");
        stringBuffer.append('=');
        stringBuffer.append(this.ionisator);
        stringBuffer.append(',');
        stringBuffer.append("fragrance");
        stringBuffer.append('=');
        stringBuffer.append(this.fragrance);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

