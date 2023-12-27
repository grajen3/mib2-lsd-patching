/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carcomfort;

public class BrakeConfiguration {
    public boolean autoHoldLastMode;
    public boolean autoHoldOnOff;
    public boolean escOff;
    public boolean escSport;
    public boolean escTcsOff;
    public boolean escOffroad;
    public boolean systemtype;

    public BrakeConfiguration() {
        this.autoHoldLastMode = false;
        this.autoHoldOnOff = false;
        this.escOff = false;
        this.escSport = false;
        this.escTcsOff = false;
        this.escOffroad = false;
        this.systemtype = false;
    }

    public BrakeConfiguration(boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5) {
        this.autoHoldLastMode = bl;
        this.autoHoldOnOff = bl2;
        this.escOff = bl3;
        this.escSport = bl4;
        this.escTcsOff = bl5;
        this.escOffroad = false;
        this.systemtype = false;
    }

    public BrakeConfiguration(boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6, boolean bl7) {
        this.autoHoldLastMode = bl;
        this.autoHoldOnOff = bl2;
        this.escOff = bl3;
        this.escSport = bl4;
        this.escTcsOff = bl5;
        this.escOffroad = bl6;
        this.systemtype = bl7;
    }

    public boolean isAutoHoldLastMode() {
        return this.autoHoldLastMode;
    }

    public boolean isAutoHoldOnOff() {
        return this.autoHoldOnOff;
    }

    public boolean isEscOff() {
        return this.escOff;
    }

    public boolean isEscSport() {
        return this.escSport;
    }

    public boolean isEscTcsOff() {
        return this.escTcsOff;
    }

    public boolean isEscOffroad() {
        return this.escOffroad;
    }

    public boolean isSystemtype() {
        return this.systemtype;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(300);
        stringBuffer.append("BrakeConfiguration");
        stringBuffer.append('(');
        stringBuffer.append("autoHoldLastMode");
        stringBuffer.append('=');
        stringBuffer.append(this.autoHoldLastMode);
        stringBuffer.append(',');
        stringBuffer.append("autoHoldOnOff");
        stringBuffer.append('=');
        stringBuffer.append(this.autoHoldOnOff);
        stringBuffer.append(',');
        stringBuffer.append("escOff");
        stringBuffer.append('=');
        stringBuffer.append(this.escOff);
        stringBuffer.append(',');
        stringBuffer.append("escSport");
        stringBuffer.append('=');
        stringBuffer.append(this.escSport);
        stringBuffer.append(',');
        stringBuffer.append("escTcsOff");
        stringBuffer.append('=');
        stringBuffer.append(this.escTcsOff);
        stringBuffer.append(',');
        stringBuffer.append("escOffroad");
        stringBuffer.append('=');
        stringBuffer.append(this.escOffroad);
        stringBuffer.append(',');
        stringBuffer.append("systemtype");
        stringBuffer.append('=');
        stringBuffer.append(this.systemtype);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

