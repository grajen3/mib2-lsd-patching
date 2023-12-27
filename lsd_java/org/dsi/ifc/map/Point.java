/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.map;

public class Point {
    public int xPos;
    public int yPos;

    public Point() {
        this.xPos = 0;
        this.yPos = 0;
    }

    public Point(int n, int n2) {
        this.xPos = n;
        this.yPos = n2;
    }

    public int getXPos() {
        return this.xPos;
    }

    public int getYPos() {
        return this.yPos;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(100);
        stringBuffer.append("Point");
        stringBuffer.append('(');
        stringBuffer.append("xPos");
        stringBuffer.append('=');
        stringBuffer.append(this.xPos);
        stringBuffer.append(',');
        stringBuffer.append("yPos");
        stringBuffer.append('=');
        stringBuffer.append(this.yPos);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

