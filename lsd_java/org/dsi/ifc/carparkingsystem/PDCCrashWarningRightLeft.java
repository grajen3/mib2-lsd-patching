/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carparkingsystem;

public class PDCCrashWarningRightLeft {
    public boolean front;
    public boolean frontMiddle;
    public boolean rearMiddle;
    public boolean rear;

    public PDCCrashWarningRightLeft() {
        this.front = false;
        this.frontMiddle = false;
        this.rearMiddle = false;
        this.rear = false;
    }

    public PDCCrashWarningRightLeft(boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        this.front = bl;
        this.frontMiddle = bl2;
        this.rearMiddle = bl3;
        this.rear = bl4;
    }

    public boolean isFront() {
        return this.front;
    }

    public boolean isFrontMiddle() {
        return this.frontMiddle;
    }

    public boolean isRearMiddle() {
        return this.rearMiddle;
    }

    public boolean isRear() {
        return this.rear;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(150);
        stringBuffer.append("PDCCrashWarningRightLeft");
        stringBuffer.append('(');
        stringBuffer.append("front");
        stringBuffer.append('=');
        stringBuffer.append(this.front);
        stringBuffer.append(',');
        stringBuffer.append("frontMiddle");
        stringBuffer.append('=');
        stringBuffer.append(this.frontMiddle);
        stringBuffer.append(',');
        stringBuffer.append("rearMiddle");
        stringBuffer.append('=');
        stringBuffer.append(this.rearMiddle);
        stringBuffer.append(',');
        stringBuffer.append("rear");
        stringBuffer.append('=');
        stringBuffer.append(this.rear);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

