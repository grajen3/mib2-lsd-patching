/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carlife;

public class TouchEvent {
    public int x;
    public int y;
    public int action;

    public TouchEvent() {
        this.x = 0;
        this.y = 0;
        this.action = 0;
    }

    public TouchEvent(int n, int n2, int n3) {
        this.x = n;
        this.y = n2;
        this.action = n3;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public int getAction() {
        return this.action;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(150);
        stringBuffer.append("TouchEvent");
        stringBuffer.append('(');
        stringBuffer.append("x");
        stringBuffer.append('=');
        stringBuffer.append(this.x);
        stringBuffer.append(',');
        stringBuffer.append("y");
        stringBuffer.append('=');
        stringBuffer.append(this.y);
        stringBuffer.append(',');
        stringBuffer.append("action");
        stringBuffer.append('=');
        stringBuffer.append(this.action);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

