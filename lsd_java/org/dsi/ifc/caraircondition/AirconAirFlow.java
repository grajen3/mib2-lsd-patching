/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.caraircondition;

public class AirconAirFlow {
    public boolean outletUp;
    public boolean outletBody;
    public boolean outletFootwell;
    public boolean outletIndirect;
    public boolean automaticAirDistribution;
    public boolean outletSide;

    public AirconAirFlow() {
        this.outletUp = false;
        this.outletBody = false;
        this.outletFootwell = false;
        this.outletIndirect = false;
        this.automaticAirDistribution = false;
        this.outletSide = false;
    }

    public AirconAirFlow(boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6) {
        this.outletUp = bl;
        this.outletBody = bl2;
        this.outletFootwell = bl3;
        this.outletIndirect = bl4;
        this.automaticAirDistribution = bl5;
        this.outletSide = bl6;
    }

    public boolean isOutletUp() {
        return this.outletUp;
    }

    public boolean isOutletBody() {
        return this.outletBody;
    }

    public boolean isOutletFootwell() {
        return this.outletFootwell;
    }

    public boolean isOutletIndirect() {
        return this.outletIndirect;
    }

    public boolean isAutomaticAirDistribution() {
        return this.automaticAirDistribution;
    }

    public boolean isOutletSide() {
        return this.outletSide;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(300);
        stringBuffer.append("AirconAirFlow");
        stringBuffer.append('(');
        stringBuffer.append("outletUp");
        stringBuffer.append('=');
        stringBuffer.append(this.outletUp);
        stringBuffer.append(',');
        stringBuffer.append("outletBody");
        stringBuffer.append('=');
        stringBuffer.append(this.outletBody);
        stringBuffer.append(',');
        stringBuffer.append("outletFootwell");
        stringBuffer.append('=');
        stringBuffer.append(this.outletFootwell);
        stringBuffer.append(',');
        stringBuffer.append("outletIndirect");
        stringBuffer.append('=');
        stringBuffer.append(this.outletIndirect);
        stringBuffer.append(',');
        stringBuffer.append("automaticAirDistribution");
        stringBuffer.append('=');
        stringBuffer.append(this.automaticAirDistribution);
        stringBuffer.append(',');
        stringBuffer.append("outletSide");
        stringBuffer.append('=');
        stringBuffer.append(this.outletSide);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

