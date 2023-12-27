/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.androidauto2;

public class TouchEvent {
    public int x;
    public int y;
    public int pointerID;

    public TouchEvent() {
        this.x = 0;
        this.y = 0;
        this.pointerID = 0;
    }

    public TouchEvent(int n, int n2, int n3) {
        this.x = n;
        this.y = n2;
        this.pointerID = n3;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public int getPointerID() {
        return this.pointerID;
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
        stringBuffer.append("pointerID");
        stringBuffer.append('=');
        stringBuffer.append(this.pointerID);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

