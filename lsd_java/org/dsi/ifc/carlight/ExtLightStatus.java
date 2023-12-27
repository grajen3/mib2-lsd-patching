/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carlight;

public class ExtLightStatus {
    public boolean headlight;
    public boolean parklightLeft;
    public boolean parklightRight;

    public ExtLightStatus() {
        this.headlight = false;
        this.parklightLeft = false;
        this.parklightRight = false;
    }

    public ExtLightStatus(boolean bl, boolean bl2, boolean bl3) {
        this.headlight = bl;
        this.parklightLeft = bl2;
        this.parklightRight = bl3;
    }

    public boolean isHeadlight() {
        return this.headlight;
    }

    public boolean isParklightLeft() {
        return this.parklightLeft;
    }

    public boolean isParklightRight() {
        return this.parklightRight;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(150);
        stringBuffer.append("ExtLightStatus");
        stringBuffer.append('(');
        stringBuffer.append("headlight");
        stringBuffer.append('=');
        stringBuffer.append(this.headlight);
        stringBuffer.append(',');
        stringBuffer.append("parklightLeft");
        stringBuffer.append('=');
        stringBuffer.append(this.parklightLeft);
        stringBuffer.append(',');
        stringBuffer.append("parklightRight");
        stringBuffer.append('=');
        stringBuffer.append(this.parklightRight);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

