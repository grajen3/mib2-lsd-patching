/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carcomfort;

public class DoorLockingRearBlind {
    public boolean rearBlindButton;
    public boolean rearBlindSunProtection;
    public boolean rearBlindReverseGear;

    public DoorLockingRearBlind() {
        this.rearBlindButton = false;
        this.rearBlindSunProtection = false;
        this.rearBlindReverseGear = false;
    }

    public DoorLockingRearBlind(boolean bl, boolean bl2, boolean bl3) {
        this.rearBlindButton = bl;
        this.rearBlindSunProtection = bl2;
        this.rearBlindReverseGear = bl3;
    }

    public boolean isRearBlindSunProtection() {
        return this.rearBlindSunProtection;
    }

    public boolean isRearBlindButton() {
        return this.rearBlindButton;
    }

    public boolean isRearBlindReverseGear() {
        return this.rearBlindReverseGear;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(200);
        stringBuffer.append("DoorLockingRearBlind");
        stringBuffer.append('(');
        stringBuffer.append("rearBlindButton");
        stringBuffer.append('=');
        stringBuffer.append(this.rearBlindButton);
        stringBuffer.append(',');
        stringBuffer.append("rearBlindSunProtection");
        stringBuffer.append('=');
        stringBuffer.append(this.rearBlindSunProtection);
        stringBuffer.append(',');
        stringBuffer.append("rearBlindReverseGear");
        stringBuffer.append('=');
        stringBuffer.append(this.rearBlindReverseGear);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

