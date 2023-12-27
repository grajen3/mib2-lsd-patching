/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carparkingsystem;

public class DisplayContent {
    public int popup;
    public int screen;
    public int view;
    public int mode;

    public DisplayContent() {
        this.popup = 0;
        this.screen = 0;
        this.view = 0;
        this.mode = 0;
    }

    public DisplayContent(int n, int n2, int n3, int n4) {
        this.popup = n;
        this.screen = n2;
        this.view = n3;
        this.mode = n4;
    }

    public int getPopup() {
        return this.popup;
    }

    public int getScreen() {
        return this.screen;
    }

    public int getView() {
        return this.view;
    }

    public int getMode() {
        return this.mode;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(200);
        stringBuffer.append("DisplayContent");
        stringBuffer.append('(');
        stringBuffer.append("popup");
        stringBuffer.append('=');
        stringBuffer.append(this.popup);
        stringBuffer.append(',');
        stringBuffer.append("screen");
        stringBuffer.append('=');
        stringBuffer.append(this.screen);
        stringBuffer.append(',');
        stringBuffer.append("view");
        stringBuffer.append('=');
        stringBuffer.append(this.view);
        stringBuffer.append(',');
        stringBuffer.append("mode");
        stringBuffer.append('=');
        stringBuffer.append(this.mode);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

