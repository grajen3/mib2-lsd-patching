/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carplay;

public class TouchEvent {
    public int x;
    public int y;

    public TouchEvent() {
        this.x = 0;
        this.y = 0;
    }

    public TouchEvent(int n, int n2) {
        this.x = n;
        this.y = n2;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(100);
        stringBuffer.append("TouchEvent");
        stringBuffer.append('(');
        stringBuffer.append("x");
        stringBuffer.append('=');
        stringBuffer.append(this.x);
        stringBuffer.append(',');
        stringBuffer.append("y");
        stringBuffer.append('=');
        stringBuffer.append(this.y);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

