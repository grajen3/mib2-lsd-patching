/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.telephone;

public class LockStateStruct {
    public int telLockState;
    public int telRetryCounter;

    public LockStateStruct() {
        this.telLockState = 0;
        this.telRetryCounter = 0;
    }

    public LockStateStruct(int n, int n2) {
        this.telLockState = n;
        this.telRetryCounter = n2;
    }

    public int getTelLockState() {
        return this.telLockState;
    }

    public int getTelRetryCounter() {
        return this.telRetryCounter;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(150);
        stringBuffer.append("LockStateStruct");
        stringBuffer.append('(');
        stringBuffer.append("telLockState");
        stringBuffer.append('=');
        stringBuffer.append(this.telLockState);
        stringBuffer.append(',');
        stringBuffer.append("telRetryCounter");
        stringBuffer.append('=');
        stringBuffer.append(this.telRetryCounter);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

