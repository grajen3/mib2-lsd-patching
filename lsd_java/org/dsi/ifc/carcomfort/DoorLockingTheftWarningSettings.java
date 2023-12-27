/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carcomfort;

public class DoorLockingTheftWarningSettings {
    public boolean interior;
    public boolean decline;

    public DoorLockingTheftWarningSettings() {
        this.interior = false;
        this.decline = false;
    }

    public DoorLockingTheftWarningSettings(boolean bl, boolean bl2) {
        this.interior = bl;
        this.decline = bl2;
    }

    public boolean isInterior() {
        return this.interior;
    }

    public boolean isDecline() {
        return this.decline;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(100);
        stringBuffer.append("DoorLockingTheftWarningSettings");
        stringBuffer.append('(');
        stringBuffer.append("interior");
        stringBuffer.append('=');
        stringBuffer.append(this.interior);
        stringBuffer.append(',');
        stringBuffer.append("decline");
        stringBuffer.append('=');
        stringBuffer.append(this.decline);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

