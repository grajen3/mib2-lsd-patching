/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carcomfort;

public class DoorLockingComfortOpenSettings {
    public boolean driverWindow;
    public boolean codriverWindow;
    public boolean driverRearWindow;
    public boolean codriverRearWindow;
    public boolean sunRoof;
    public boolean rearBlind;

    public DoorLockingComfortOpenSettings() {
        this.driverWindow = false;
        this.codriverWindow = false;
        this.driverRearWindow = false;
        this.codriverRearWindow = false;
        this.sunRoof = false;
        this.rearBlind = false;
    }

    public DoorLockingComfortOpenSettings(boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6) {
        this.driverWindow = bl;
        this.codriverWindow = bl2;
        this.driverRearWindow = bl3;
        this.codriverRearWindow = bl4;
        this.sunRoof = bl5;
        this.rearBlind = bl6;
    }

    public boolean isDriverWindow() {
        return this.driverWindow;
    }

    public boolean isCodriverWindow() {
        return this.codriverWindow;
    }

    public boolean isDriverRearWindow() {
        return this.driverRearWindow;
    }

    public boolean isCodriverRearWindow() {
        return this.codriverRearWindow;
    }

    public boolean isSunRoof() {
        return this.sunRoof;
    }

    public boolean isRearBlind() {
        return this.rearBlind;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(300);
        stringBuffer.append("DoorLockingComfortOpenSettings");
        stringBuffer.append('(');
        stringBuffer.append("driverWindow");
        stringBuffer.append('=');
        stringBuffer.append(this.driverWindow);
        stringBuffer.append(',');
        stringBuffer.append("codriverWindow");
        stringBuffer.append('=');
        stringBuffer.append(this.codriverWindow);
        stringBuffer.append(',');
        stringBuffer.append("driverRearWindow");
        stringBuffer.append('=');
        stringBuffer.append(this.driverRearWindow);
        stringBuffer.append(',');
        stringBuffer.append("codriverRearWindow");
        stringBuffer.append('=');
        stringBuffer.append(this.codriverRearWindow);
        stringBuffer.append(',');
        stringBuffer.append("sunRoof");
        stringBuffer.append('=');
        stringBuffer.append(this.sunRoof);
        stringBuffer.append(',');
        stringBuffer.append("rearBlind");
        stringBuffer.append('=');
        stringBuffer.append(this.rearBlind);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

