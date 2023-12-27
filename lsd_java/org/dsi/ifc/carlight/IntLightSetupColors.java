/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carlight;

public class IntLightSetupColors {
    public boolean warmWhite;
    public boolean coldWhite;
    public boolean redWhite;
    public boolean orange;
    public boolean blue;
    public boolean cyan;

    public IntLightSetupColors() {
        this.warmWhite = false;
        this.coldWhite = false;
        this.redWhite = false;
        this.orange = false;
        this.blue = false;
        this.cyan = false;
    }

    public IntLightSetupColors(boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6) {
        this.warmWhite = bl;
        this.coldWhite = bl2;
        this.redWhite = bl3;
        this.orange = bl4;
        this.blue = bl5;
        this.cyan = bl6;
    }

    public boolean isWarmWhite() {
        return this.warmWhite;
    }

    public boolean isColdWhite() {
        return this.coldWhite;
    }

    public boolean isRedWhite() {
        return this.redWhite;
    }

    public boolean isOrange() {
        return this.orange;
    }

    public boolean isBlue() {
        return this.blue;
    }

    public boolean isCyan() {
        return this.cyan;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(250);
        stringBuffer.append("IntLightSetupColors");
        stringBuffer.append('(');
        stringBuffer.append("warmWhite");
        stringBuffer.append('=');
        stringBuffer.append(this.warmWhite);
        stringBuffer.append(',');
        stringBuffer.append("coldWhite");
        stringBuffer.append('=');
        stringBuffer.append(this.coldWhite);
        stringBuffer.append(',');
        stringBuffer.append("redWhite");
        stringBuffer.append('=');
        stringBuffer.append(this.redWhite);
        stringBuffer.append(',');
        stringBuffer.append("orange");
        stringBuffer.append('=');
        stringBuffer.append(this.orange);
        stringBuffer.append(',');
        stringBuffer.append("blue");
        stringBuffer.append('=');
        stringBuffer.append(this.blue);
        stringBuffer.append(',');
        stringBuffer.append("cyan");
        stringBuffer.append('=');
        stringBuffer.append(this.cyan);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

