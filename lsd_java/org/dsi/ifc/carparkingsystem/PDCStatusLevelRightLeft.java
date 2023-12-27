/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carparkingsystem;

public class PDCStatusLevelRightLeft {
    public int front;
    public int frontMiddle;
    public int rearMiddle;
    public int rear;

    public PDCStatusLevelRightLeft() {
        this.front = 0;
        this.frontMiddle = 0;
        this.rearMiddle = 0;
        this.rear = 0;
    }

    public PDCStatusLevelRightLeft(int n, int n2, int n3, int n4) {
        this.front = n;
        this.frontMiddle = n2;
        this.rearMiddle = n3;
        this.rear = n4;
    }

    public int getFront() {
        return this.front;
    }

    public int getFrontMiddle() {
        return this.frontMiddle;
    }

    public int getRearMiddle() {
        return this.rearMiddle;
    }

    public int getRear() {
        return this.rear;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(200);
        stringBuffer.append("PDCStatusLevelRightLeft");
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

