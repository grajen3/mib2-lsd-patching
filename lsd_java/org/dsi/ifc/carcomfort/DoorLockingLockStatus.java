/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carcomfort;

public class DoorLockingLockStatus {
    public int vehicleLockState;
    public int driverDoor;
    public int codriverDoor;
    public int fondDoorRight;
    public int fondDoorLeft;
    public int hood;
    public int bootlid;
    public int flap;
    public boolean vehicleSafe;

    public DoorLockingLockStatus() {
        this.vehicleLockState = 0;
        this.driverDoor = 0;
        this.codriverDoor = 0;
        this.fondDoorRight = 0;
        this.fondDoorLeft = 0;
        this.hood = 0;
        this.bootlid = 0;
        this.flap = 0;
        this.vehicleSafe = false;
    }

    public DoorLockingLockStatus(int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8, boolean bl) {
        this.vehicleLockState = n;
        this.driverDoor = n2;
        this.codriverDoor = n3;
        this.fondDoorRight = n4;
        this.fondDoorLeft = n5;
        this.hood = n6;
        this.bootlid = n7;
        this.flap = n8;
        this.vehicleSafe = bl;
    }

    public int getVehicleLockState() {
        return this.vehicleLockState;
    }

    public int getDriverDoor() {
        return this.driverDoor;
    }

    public int getCodriverDoor() {
        return this.codriverDoor;
    }

    public int getFondDoorRight() {
        return this.fondDoorRight;
    }

    public int getFondDoorLeft() {
        return this.fondDoorLeft;
    }

    public int getHood() {
        return this.hood;
    }

    public int getBootlid() {
        return this.bootlid;
    }

    public int getFlap() {
        return this.flap;
    }

    public boolean isVehicleSafe() {
        return this.vehicleSafe;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(500);
        stringBuffer.append("DoorLockingLockStatus");
        stringBuffer.append('(');
        stringBuffer.append("vehicleLockState");
        stringBuffer.append('=');
        stringBuffer.append(this.vehicleLockState);
        stringBuffer.append(',');
        stringBuffer.append("driverDoor");
        stringBuffer.append('=');
        stringBuffer.append(this.driverDoor);
        stringBuffer.append(',');
        stringBuffer.append("codriverDoor");
        stringBuffer.append('=');
        stringBuffer.append(this.codriverDoor);
        stringBuffer.append(',');
        stringBuffer.append("fondDoorRight");
        stringBuffer.append('=');
        stringBuffer.append(this.fondDoorRight);
        stringBuffer.append(',');
        stringBuffer.append("fondDoorLeft");
        stringBuffer.append('=');
        stringBuffer.append(this.fondDoorLeft);
        stringBuffer.append(',');
        stringBuffer.append("hood");
        stringBuffer.append('=');
        stringBuffer.append(this.hood);
        stringBuffer.append(',');
        stringBuffer.append("bootlid");
        stringBuffer.append('=');
        stringBuffer.append(this.bootlid);
        stringBuffer.append(',');
        stringBuffer.append("flap");
        stringBuffer.append('=');
        stringBuffer.append(this.flap);
        stringBuffer.append(',');
        stringBuffer.append("vehicleSafe");
        stringBuffer.append('=');
        stringBuffer.append(this.vehicleSafe);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

