/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.caraircondition;

public class AirconAirDistributionConfig {
    public boolean autoSupported;
    public boolean downUp;
    public boolean up;
    public boolean upMiddle;
    public boolean middle;
    public boolean downMiddle;
    public boolean down;
    public boolean upMiddleDown;

    public AirconAirDistributionConfig() {
        this.autoSupported = false;
        this.downUp = false;
        this.up = false;
        this.upMiddle = false;
        this.middle = false;
        this.downMiddle = false;
        this.down = false;
        this.upMiddleDown = false;
    }

    public AirconAirDistributionConfig(boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6, boolean bl7, boolean bl8) {
        this.autoSupported = bl;
        this.downUp = bl2;
        this.up = bl3;
        this.upMiddle = bl4;
        this.middle = bl5;
        this.downMiddle = bl6;
        this.down = bl7;
        this.upMiddleDown = bl8;
    }

    public boolean isAutoSupported() {
        return this.autoSupported;
    }

    public boolean isDownUp() {
        return this.downUp;
    }

    public boolean isUp() {
        return this.up;
    }

    public boolean isUpMiddle() {
        return this.upMiddle;
    }

    public boolean isMiddle() {
        return this.middle;
    }

    public boolean isDownMiddle() {
        return this.downMiddle;
    }

    public boolean isDown() {
        return this.down;
    }

    public boolean isUpMiddleDown() {
        return this.upMiddleDown;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(300);
        stringBuffer.append("AirconAirDistributionConfig");
        stringBuffer.append('(');
        stringBuffer.append("autoSupported");
        stringBuffer.append('=');
        stringBuffer.append(this.autoSupported);
        stringBuffer.append(',');
        stringBuffer.append("downUp");
        stringBuffer.append('=');
        stringBuffer.append(this.downUp);
        stringBuffer.append(',');
        stringBuffer.append("up");
        stringBuffer.append('=');
        stringBuffer.append(this.up);
        stringBuffer.append(',');
        stringBuffer.append("upMiddle");
        stringBuffer.append('=');
        stringBuffer.append(this.upMiddle);
        stringBuffer.append(',');
        stringBuffer.append("middle");
        stringBuffer.append('=');
        stringBuffer.append(this.middle);
        stringBuffer.append(',');
        stringBuffer.append("downMiddle");
        stringBuffer.append('=');
        stringBuffer.append(this.downMiddle);
        stringBuffer.append(',');
        stringBuffer.append("down");
        stringBuffer.append('=');
        stringBuffer.append(this.down);
        stringBuffer.append(',');
        stringBuffer.append("upMiddleDown");
        stringBuffer.append('=');
        stringBuffer.append(this.upMiddleDown);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

