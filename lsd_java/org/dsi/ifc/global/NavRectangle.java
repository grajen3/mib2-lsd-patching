/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.global;

public class NavRectangle {
    public int xLeft;
    public int xRight;
    public int yBottom;
    public int yUp;
    public boolean rectangleInvalid;

    public NavRectangle() {
        this.xLeft = 0;
        this.xRight = 0;
        this.yBottom = 0;
        this.yUp = 0;
        this.rectangleInvalid = false;
    }

    public NavRectangle(int n, int n2, int n3, int n4, boolean bl) {
        this.xLeft = n;
        this.xRight = n2;
        this.yBottom = n3;
        this.yUp = n4;
        this.rectangleInvalid = bl;
    }

    public int getXLeft() {
        return this.xLeft;
    }

    public int getXRight() {
        return this.xRight;
    }

    public int getYBottom() {
        return this.yBottom;
    }

    public int getYUp() {
        return this.yUp;
    }

    public boolean isRectangleInvalid() {
        return this.rectangleInvalid;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("NavRectangle {");
        stringBuffer.append("x_left=");
        stringBuffer.append(this.xLeft);
        stringBuffer.append(", ");
        stringBuffer.append("x_right=");
        stringBuffer.append(this.xRight);
        stringBuffer.append(", ");
        stringBuffer.append("y_bottom=");
        stringBuffer.append(this.yBottom);
        stringBuffer.append(", ");
        stringBuffer.append("y_up=");
        stringBuffer.append(this.yUp);
        stringBuffer.append(", ");
        stringBuffer.append("rectangleInvalid=");
        stringBuffer.append(this.rectangleInvalid);
        stringBuffer.append("}");
        return stringBuffer.toString();
    }
}

