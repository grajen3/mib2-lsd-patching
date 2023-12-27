/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.kombisync2;

public class MenuContext {
    public int sdsTabState;
    public int leftMenuState;
    public int rightMenuState;
    public int secondStatusLineState;

    public MenuContext() {
        this.sdsTabState = 0;
        this.leftMenuState = 0;
        this.rightMenuState = 0;
        this.secondStatusLineState = 0;
    }

    public MenuContext(int n, int n2, int n3, int n4) {
        this.sdsTabState = n;
        this.leftMenuState = n2;
        this.rightMenuState = n3;
        this.secondStatusLineState = n4;
    }

    public int getSdsTabState() {
        return this.sdsTabState;
    }

    public int getSecondStatusLineState() {
        return this.secondStatusLineState;
    }

    public int getLeftMenuState() {
        return this.leftMenuState;
    }

    public int getRightMenuState() {
        return this.rightMenuState;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(250);
        stringBuffer.append("MenuContext");
        stringBuffer.append('(');
        stringBuffer.append("sdsTabState");
        stringBuffer.append('=');
        stringBuffer.append(this.sdsTabState);
        stringBuffer.append(',');
        stringBuffer.append("leftMenuState");
        stringBuffer.append('=');
        stringBuffer.append(this.leftMenuState);
        stringBuffer.append(',');
        stringBuffer.append("rightMenuState");
        stringBuffer.append('=');
        stringBuffer.append(this.rightMenuState);
        stringBuffer.append(',');
        stringBuffer.append("secondStatusLineState");
        stringBuffer.append('=');
        stringBuffer.append(this.secondStatusLineState);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

