/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.kombisync2;

public class DisplayStatusFlags {
    public int statusFlags;

    public DisplayStatusFlags() {
        this.statusFlags = 0;
    }

    public DisplayStatusFlags(int n) {
        this.statusFlags = n;
    }

    public boolean isAllFlagsInvalid() {
        return 0 != (this.statusFlags & 0x800000);
    }

    public boolean isUserStage() {
        return 0 != (this.statusFlags & 0x4000);
    }

    public boolean isLVDSLock() {
        return 0 != (this.statusFlags & 0x1000);
    }

    public boolean isLVDSProtocolDMOK() {
        return 0 != (this.statusFlags & 0x800);
    }

    public boolean isLVDSProtocolHMIOK() {
        return 0 != (this.statusFlags & 0x400);
    }

    public boolean isSyncProtocolOK() {
        return 0 != (this.statusFlags & 0x200);
    }

    public boolean isSlowDownActive() {
        return 0 != (this.statusFlags & 0x100);
    }

    public boolean isLeftFlap() {
        return 0 != (this.statusFlags & 0x80);
    }

    public boolean isRightFlap() {
        return 0 != (this.statusFlags & 0x40);
    }

    public boolean isKDKVisible() {
        return 0 != (this.statusFlags & 0x20);
    }

    public boolean isNavBarGraph() {
        return 0 != (this.statusFlags & 0x10);
    }

    public boolean isSecondStatusLine() {
        return 0 != (this.statusFlags & 8);
    }

    public boolean isReducedScreen() {
        return 0 != (this.statusFlags & 4);
    }

    public boolean isEarlyRVC() {
        return 0 != (this.statusFlags & 2);
    }

    public boolean isLVDSDMActive() {
        return 0 != (this.statusFlags & 0x2000);
    }

    public boolean isLVDSHMIActive() {
        return 0 != (this.statusFlags & 0x1000);
    }

    public int getStatusFlags() {
        return this.statusFlags;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(100);
        stringBuffer.append("DisplayStatusFlags");
        stringBuffer.append('(');
        stringBuffer.append("statusFlags");
        stringBuffer.append('=');
        stringBuffer.append(this.statusFlags);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

