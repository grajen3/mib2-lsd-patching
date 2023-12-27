/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carcomfort;

public class UGDOOpenDoor {
    public int doorState;
    public int softkey;

    public UGDOOpenDoor() {
        this.doorState = 0;
        this.softkey = 0;
    }

    public UGDOOpenDoor(int n, int n2) {
        this.doorState = n;
        this.softkey = n2;
    }

    public int getDoorState() {
        return this.doorState;
    }

    public int getSoftkey() {
        return this.softkey;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(100);
        stringBuffer.append("UGDOOpenDoor");
        stringBuffer.append('(');
        stringBuffer.append("doorState");
        stringBuffer.append('=');
        stringBuffer.append(this.doorState);
        stringBuffer.append(',');
        stringBuffer.append("softkey");
        stringBuffer.append('=');
        stringBuffer.append(this.softkey);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

