/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.iconhandling;

public class TextRenderingInfo {
    public int fontReference;
    public int fontSize;
    public int fontColor;
    public int deltaX;
    public int deltaY;

    public TextRenderingInfo() {
        this.fontReference = 0;
        this.fontSize = 0;
        this.fontColor = 0;
        this.deltaX = 0;
        this.deltaY = 0;
    }

    public TextRenderingInfo(int n, int n2, int n3, int n4, int n5) {
        this.fontReference = n;
        this.fontSize = n2;
        this.fontColor = n3;
        this.deltaX = n4;
        this.deltaY = n5;
    }

    public int getFontReference() {
        return this.fontReference;
    }

    public int getFontSize() {
        return this.fontSize;
    }

    public int getFontColor() {
        return this.fontColor;
    }

    public int getDeltaX() {
        return this.deltaX;
    }

    public int getDeltaY() {
        return this.deltaY;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(250);
        stringBuffer.append("TextRenderingInfo");
        stringBuffer.append('(');
        stringBuffer.append("fontReference");
        stringBuffer.append('=');
        stringBuffer.append(this.fontReference);
        stringBuffer.append(',');
        stringBuffer.append("fontSize");
        stringBuffer.append('=');
        stringBuffer.append(this.fontSize);
        stringBuffer.append(',');
        stringBuffer.append("fontColor");
        stringBuffer.append('=');
        stringBuffer.append(this.fontColor);
        stringBuffer.append(',');
        stringBuffer.append("deltaX");
        stringBuffer.append('=');
        stringBuffer.append(this.deltaX);
        stringBuffer.append(',');
        stringBuffer.append("deltaY");
        stringBuffer.append('=');
        stringBuffer.append(this.deltaY);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

