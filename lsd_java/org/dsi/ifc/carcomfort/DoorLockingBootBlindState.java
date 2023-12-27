/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carcomfort;

public class DoorLockingBootBlindState {
    public int control;
    public int motionState;

    public DoorLockingBootBlindState() {
        this.control = 0;
        this.motionState = 0;
    }

    public DoorLockingBootBlindState(int n, int n2) {
        this.control = n;
        this.motionState = n2;
    }

    public int getControl() {
        return this.control;
    }

    public int getMotionState() {
        return this.motionState;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(150);
        stringBuffer.append("DoorLockingBootBlindState");
        stringBuffer.append('(');
        stringBuffer.append("control");
        stringBuffer.append('=');
        stringBuffer.append(this.control);
        stringBuffer.append(',');
        stringBuffer.append("motionState");
        stringBuffer.append('=');
        stringBuffer.append(this.motionState);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

