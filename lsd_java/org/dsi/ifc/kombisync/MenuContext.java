/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.kombisync;

public class MenuContext {
    public boolean leftSideMenuOpen;
    public boolean rightSideMenuOpen;
    public boolean partialPopupOpen;
    public boolean secondStatusLine;

    public MenuContext() {
        this.leftSideMenuOpen = false;
        this.rightSideMenuOpen = false;
        this.partialPopupOpen = false;
        this.secondStatusLine = false;
    }

    public MenuContext(boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        this.leftSideMenuOpen = bl;
        this.rightSideMenuOpen = bl2;
        this.partialPopupOpen = bl3;
        this.secondStatusLine = bl4;
    }

    public boolean isLeftSideMenuOpen() {
        return this.leftSideMenuOpen;
    }

    public boolean isRightSideMenuOpen() {
        return this.rightSideMenuOpen;
    }

    public boolean isPartialPopupOpen() {
        return this.partialPopupOpen;
    }

    public boolean isSecondStatusLine() {
        return this.secondStatusLine;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(250);
        stringBuffer.append("MenuContext");
        stringBuffer.append('(');
        stringBuffer.append("leftSideMenuOpen");
        stringBuffer.append('=');
        stringBuffer.append(this.leftSideMenuOpen);
        stringBuffer.append(',');
        stringBuffer.append("rightSideMenuOpen");
        stringBuffer.append('=');
        stringBuffer.append(this.rightSideMenuOpen);
        stringBuffer.append(',');
        stringBuffer.append("partialPopupOpen");
        stringBuffer.append('=');
        stringBuffer.append(this.partialPopupOpen);
        stringBuffer.append(',');
        stringBuffer.append("secondStatusLine");
        stringBuffer.append('=');
        stringBuffer.append(this.secondStatusLine);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

