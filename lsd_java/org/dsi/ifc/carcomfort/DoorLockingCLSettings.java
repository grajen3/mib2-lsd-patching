/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carcomfort;

public class DoorLockingCLSettings {
    public boolean seperateDoor;
    public boolean sideDoors;
    public boolean allDoors;

    public DoorLockingCLSettings() {
        this.seperateDoor = true;
        this.sideDoors = true;
        this.allDoors = true;
    }

    public DoorLockingCLSettings(boolean bl, boolean bl2, boolean bl3) {
        this.seperateDoor = bl;
        this.sideDoors = bl2;
        this.allDoors = bl3;
    }

    public boolean isSeperateDoor() {
        return this.seperateDoor;
    }

    public boolean isSideDoors() {
        return this.sideDoors;
    }

    public boolean isAllDoors() {
        return this.allDoors;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(150);
        stringBuffer.append("DoorLockingCLSettings");
        stringBuffer.append('(');
        stringBuffer.append("seperateDoor");
        stringBuffer.append('=');
        stringBuffer.append(this.seperateDoor);
        stringBuffer.append(',');
        stringBuffer.append("sideDoors");
        stringBuffer.append('=');
        stringBuffer.append(this.sideDoors);
        stringBuffer.append(',');
        stringBuffer.append("allDoors");
        stringBuffer.append('=');
        stringBuffer.append(this.allDoors);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

