/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.mirrorlink;

public class DisplayCapabilities {
    public int screenWidthInPx;
    public int screenHeightInPx;
    public int screenWidthInMm;
    public int screenHeightInMm;
    public int screenPositionX;
    public int screenPositionY;
    public int displayDistanceToUser;

    public DisplayCapabilities() {
        this.screenWidthInPx = 0;
        this.screenHeightInPx = 0;
        this.screenWidthInMm = 0;
        this.screenHeightInMm = 0;
        this.screenPositionX = 0;
        this.screenPositionY = 0;
        this.displayDistanceToUser = 0;
    }

    public DisplayCapabilities(int n, int n2, int n3, int n4, int n5, int n6, int n7) {
        this.screenWidthInPx = n;
        this.screenHeightInPx = n2;
        this.screenWidthInMm = n3;
        this.screenHeightInMm = n4;
        this.screenPositionX = n5;
        this.screenPositionY = n6;
        this.displayDistanceToUser = n7;
    }

    public int getScreenWidthInPx() {
        return this.screenWidthInPx;
    }

    public int getScreenHeightInPx() {
        return this.screenHeightInPx;
    }

    public int getScreenWidthInMm() {
        return this.screenWidthInMm;
    }

    public int getScreenHeightInMm() {
        return this.screenHeightInMm;
    }

    public int getScreenPositionX() {
        return this.screenPositionX;
    }

    public int getScreenPositionY() {
        return this.screenPositionY;
    }

    public int getDisplayDistanceToUser() {
        return this.displayDistanceToUser;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(500);
        stringBuffer.append("DisplayCapabilities");
        stringBuffer.append('(');
        stringBuffer.append("screenWidthInPx");
        stringBuffer.append('=');
        stringBuffer.append(this.screenWidthInPx);
        stringBuffer.append(',');
        stringBuffer.append("screenHeightInPx");
        stringBuffer.append('=');
        stringBuffer.append(this.screenHeightInPx);
        stringBuffer.append(',');
        stringBuffer.append("screenWidthInMm");
        stringBuffer.append('=');
        stringBuffer.append(this.screenWidthInMm);
        stringBuffer.append(',');
        stringBuffer.append("screenHeightInMm");
        stringBuffer.append('=');
        stringBuffer.append(this.screenHeightInMm);
        stringBuffer.append(',');
        stringBuffer.append("screenPositionX");
        stringBuffer.append('=');
        stringBuffer.append(this.screenPositionX);
        stringBuffer.append(',');
        stringBuffer.append("screenPositionY");
        stringBuffer.append('=');
        stringBuffer.append(this.screenPositionY);
        stringBuffer.append(',');
        stringBuffer.append("displayDistanceToUser");
        stringBuffer.append('=');
        stringBuffer.append(this.displayDistanceToUser);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

