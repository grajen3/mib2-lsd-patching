/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carparkingsystem;

public class PDCCrashWarningFrontRear {
    public boolean left;
    public boolean leftMiddle;
    public boolean rightMiddle;
    public boolean right;

    public PDCCrashWarningFrontRear() {
        this.left = false;
        this.leftMiddle = false;
        this.rightMiddle = false;
        this.right = false;
    }

    public PDCCrashWarningFrontRear(boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        this.left = bl;
        this.leftMiddle = bl2;
        this.rightMiddle = bl3;
        this.right = bl4;
    }

    public boolean isLeft() {
        return this.left;
    }

    public boolean isLeftMiddle() {
        return this.leftMiddle;
    }

    public boolean isRightMiddle() {
        return this.rightMiddle;
    }

    public boolean isRight() {
        return this.right;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(150);
        stringBuffer.append("PDCCrashWarningFrontRear");
        stringBuffer.append('(');
        stringBuffer.append("left");
        stringBuffer.append('=');
        stringBuffer.append(this.left);
        stringBuffer.append(',');
        stringBuffer.append("leftMiddle");
        stringBuffer.append('=');
        stringBuffer.append(this.leftMiddle);
        stringBuffer.append(',');
        stringBuffer.append("rightMiddle");
        stringBuffer.append('=');
        stringBuffer.append(this.rightMiddle);
        stringBuffer.append(',');
        stringBuffer.append("right");
        stringBuffer.append('=');
        stringBuffer.append(this.right);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

