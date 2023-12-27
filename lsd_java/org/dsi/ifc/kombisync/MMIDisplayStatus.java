/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.kombisync;

import org.dsi.ifc.kombisync.MenuContext;

public class MMIDisplayStatus {
    public int tid;
    public int focus;
    public int screenFormat;
    public int mainContext;
    public MenuContext menuContext;
    public int popupContext;
    public int animationSpeed;
    public int animationInfo;
    public int kdkOpacity;
    public boolean kdkVisible;
    public boolean bargraphVisible;
    public int kdkPositionInfo;

    public MMIDisplayStatus() {
        this.tid = 0;
        this.focus = 0;
        this.screenFormat = 0;
        this.mainContext = 0;
        this.menuContext = new MenuContext();
        this.popupContext = 0;
        this.animationSpeed = 0;
        this.animationInfo = 0;
        this.kdkOpacity = 0;
        this.kdkVisible = false;
        this.bargraphVisible = false;
        this.kdkPositionInfo = 0;
    }

    public MMIDisplayStatus(int n, int n2, int n3, int n4, MenuContext menuContext, int n5, int n6, int n7, int n8, boolean bl, boolean bl2, int n9) {
        this.tid = n;
        this.focus = n2;
        this.screenFormat = n3;
        this.mainContext = n4;
        this.menuContext = menuContext;
        this.popupContext = n5;
        this.animationSpeed = n6;
        this.animationInfo = n7;
        this.kdkOpacity = n8;
        this.kdkVisible = bl;
        this.bargraphVisible = bl2;
        this.kdkPositionInfo = n9;
    }

    public int getTid() {
        return this.tid;
    }

    public int getFocus() {
        return this.focus;
    }

    public int getScreenFormat() {
        return this.screenFormat;
    }

    public int getMainContext() {
        return this.mainContext;
    }

    public MenuContext getMenuContext() {
        return this.menuContext;
    }

    public int getPopupContext() {
        return this.popupContext;
    }

    public int getAnimationSpeed() {
        return this.animationSpeed;
    }

    public int getAnimationInfo() {
        return this.animationInfo;
    }

    public int getKdkOpacity() {
        return this.kdkOpacity;
    }

    public boolean isKdkVisible() {
        return this.kdkVisible;
    }

    public boolean isBargraphVisible() {
        return this.bargraphVisible;
    }

    public int getKdkPositionInfo() {
        return this.kdkPositionInfo;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(1650);
        stringBuffer.append("MMIDisplayStatus");
        stringBuffer.append('(');
        stringBuffer.append("tid");
        stringBuffer.append('=');
        stringBuffer.append(this.tid);
        stringBuffer.append(',');
        stringBuffer.append("focus");
        stringBuffer.append('=');
        stringBuffer.append(this.focus);
        stringBuffer.append(',');
        stringBuffer.append("screenFormat");
        stringBuffer.append('=');
        stringBuffer.append(this.screenFormat);
        stringBuffer.append(',');
        stringBuffer.append("mainContext");
        stringBuffer.append('=');
        stringBuffer.append(this.mainContext);
        stringBuffer.append(',');
        stringBuffer.append("menuContext");
        stringBuffer.append('=');
        stringBuffer.append(this.menuContext);
        stringBuffer.append(',');
        stringBuffer.append("popupContext");
        stringBuffer.append('=');
        stringBuffer.append(this.popupContext);
        stringBuffer.append(',');
        stringBuffer.append("animationSpeed");
        stringBuffer.append('=');
        stringBuffer.append(this.animationSpeed);
        stringBuffer.append(',');
        stringBuffer.append("animationInfo");
        stringBuffer.append('=');
        stringBuffer.append(this.animationInfo);
        stringBuffer.append(',');
        stringBuffer.append("kdkOpacity");
        stringBuffer.append('=');
        stringBuffer.append(this.kdkOpacity);
        stringBuffer.append(',');
        stringBuffer.append("kdkVisible");
        stringBuffer.append('=');
        stringBuffer.append(this.kdkVisible);
        stringBuffer.append(',');
        stringBuffer.append("bargraphVisible");
        stringBuffer.append('=');
        stringBuffer.append(this.bargraphVisible);
        stringBuffer.append(',');
        stringBuffer.append("kdkPositionInfo");
        stringBuffer.append('=');
        stringBuffer.append(this.kdkPositionInfo);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

