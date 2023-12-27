/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carcomfort;

public class DoorLockingWindowStatus {
    public int windowDriver;
    public int windowCodriver;
    public int windowFondRight;
    public int windowFondLeft;
    public int sunRoof;

    public DoorLockingWindowStatus() {
        this.windowDriver = 0;
        this.windowCodriver = 0;
        this.windowFondRight = 0;
        this.windowFondLeft = 0;
        this.sunRoof = 0;
    }

    public DoorLockingWindowStatus(int n, int n2, int n3, int n4, int n5) {
        this.windowDriver = n;
        this.windowCodriver = n2;
        this.windowFondRight = n3;
        this.windowFondLeft = n4;
        this.sunRoof = n5;
    }

    public int getWindowDriver() {
        return this.windowDriver;
    }

    public int getWindowCodriver() {
        return this.windowCodriver;
    }

    public int getWindowFondRight() {
        return this.windowFondRight;
    }

    public int getWindowFondLeft() {
        return this.windowFondLeft;
    }

    public int getSunRoof() {
        return this.sunRoof;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(300);
        stringBuffer.append("DoorLockingWindowStatus");
        stringBuffer.append('(');
        stringBuffer.append("windowDriver");
        stringBuffer.append('=');
        stringBuffer.append(this.windowDriver);
        stringBuffer.append(',');
        stringBuffer.append("windowCodriver");
        stringBuffer.append('=');
        stringBuffer.append(this.windowCodriver);
        stringBuffer.append(',');
        stringBuffer.append("windowFondRight");
        stringBuffer.append('=');
        stringBuffer.append(this.windowFondRight);
        stringBuffer.append(',');
        stringBuffer.append("windowFondLeft");
        stringBuffer.append('=');
        stringBuffer.append(this.windowFondLeft);
        stringBuffer.append(',');
        stringBuffer.append("sunRoof");
        stringBuffer.append('=');
        stringBuffer.append(this.sunRoof);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

