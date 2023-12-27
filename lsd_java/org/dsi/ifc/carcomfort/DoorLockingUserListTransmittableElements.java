/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carcomfort;

public class DoorLockingUserListTransmittableElements {
    public int ra1;
    public int raF;

    public DoorLockingUserListTransmittableElements() {
        this.ra1 = 0;
        this.raF = 0;
    }

    public DoorLockingUserListTransmittableElements(int n, int n2) {
        this.ra1 = n;
        this.raF = n2;
    }

    public int getRa1() {
        return this.ra1;
    }

    public int getRaF() {
        return this.raF;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(100);
        stringBuffer.append("DoorLockingUserListTransmittableElements");
        stringBuffer.append('(');
        stringBuffer.append("ra1");
        stringBuffer.append('=');
        stringBuffer.append(this.ra1);
        stringBuffer.append(',');
        stringBuffer.append("raF");
        stringBuffer.append('=');
        stringBuffer.append(this.raF);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

