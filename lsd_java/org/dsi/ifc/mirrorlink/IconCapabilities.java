/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.mirrorlink;

public class IconCapabilities {
    public int iconWidth;
    public int iconHeight;
    public int colourDepth;

    public IconCapabilities() {
        this.iconWidth = 0;
        this.iconHeight = 0;
        this.colourDepth = 0;
    }

    public IconCapabilities(int n, int n2, int n3) {
        this.iconWidth = n;
        this.iconHeight = n2;
        this.colourDepth = n3;
    }

    public int getIconWidth() {
        return this.iconWidth;
    }

    public int getIconHeight() {
        return this.iconHeight;
    }

    public int getColourDepth() {
        return this.colourDepth;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(200);
        stringBuffer.append("IconCapabilities");
        stringBuffer.append('(');
        stringBuffer.append("iconWidth");
        stringBuffer.append('=');
        stringBuffer.append(this.iconWidth);
        stringBuffer.append(',');
        stringBuffer.append("iconHeight");
        stringBuffer.append('=');
        stringBuffer.append(this.iconHeight);
        stringBuffer.append(',');
        stringBuffer.append("colourDepth");
        stringBuffer.append('=');
        stringBuffer.append(this.colourDepth);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

