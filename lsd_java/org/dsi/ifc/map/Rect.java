/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.map;

public class Rect {
    public int kordX;
    public int kordY;
    public int diffX;
    public int diffY;

    public Rect() {
        this.kordX = 0;
        this.kordY = 0;
        this.diffX = 0;
        this.diffY = 0;
    }

    public Rect(int n, int n2, int n3, int n4) {
        this.kordX = n;
        this.kordY = n2;
        this.diffX = n3;
        this.diffY = n4;
    }

    public int getKordX() {
        return this.kordX;
    }

    public int getKordY() {
        return this.kordY;
    }

    public int getDiffX() {
        return this.diffX;
    }

    public int getDiffY() {
        return this.diffY;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(200);
        stringBuffer.append("Rect");
        stringBuffer.append('(');
        stringBuffer.append("kordX");
        stringBuffer.append('=');
        stringBuffer.append(this.kordX);
        stringBuffer.append(',');
        stringBuffer.append("kordY");
        stringBuffer.append('=');
        stringBuffer.append(this.kordY);
        stringBuffer.append(',');
        stringBuffer.append("diffX");
        stringBuffer.append('=');
        stringBuffer.append(this.diffX);
        stringBuffer.append(',');
        stringBuffer.append("diffY");
        stringBuffer.append('=');
        stringBuffer.append(this.diffY);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

