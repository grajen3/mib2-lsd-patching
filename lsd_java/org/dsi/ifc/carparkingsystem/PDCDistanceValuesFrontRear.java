/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carparkingsystem;

public class PDCDistanceValuesFrontRear {
    public int left;
    public int leftMiddle;
    public int rightMiddle;
    public int right;

    public PDCDistanceValuesFrontRear() {
        this.left = 0;
        this.leftMiddle = 0;
        this.rightMiddle = 0;
        this.right = 0;
    }

    public PDCDistanceValuesFrontRear(int n, int n2, int n3, int n4) {
        this.left = n;
        this.leftMiddle = n2;
        this.rightMiddle = n3;
        this.right = n4;
    }

    public int getLeft() {
        return this.left;
    }

    public int getLeftMiddle() {
        return this.leftMiddle;
    }

    public int getRightMiddle() {
        return this.rightMiddle;
    }

    public int getRight() {
        return this.right;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(200);
        stringBuffer.append("PDCDistanceValuesFrontRear");
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

