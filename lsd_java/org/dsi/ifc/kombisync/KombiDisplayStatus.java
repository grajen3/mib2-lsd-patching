/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.kombisync;

import org.dsi.ifc.kombisync.MenuContext;

public class KombiDisplayStatus {
    public int tid;
    public int focus;
    public int screenFormat;
    public int mainContext;
    public MenuContext menuContext;
    public int popupContext;
    public int animationScreenType;
    public int animationScreenSubType;
    public int animationLeadTime;
    public int animationAddInfo;
    public int animationSpeed;

    public KombiDisplayStatus() {
        this.tid = 0;
        this.focus = 0;
        this.screenFormat = 0;
        this.mainContext = 0;
        this.menuContext = new MenuContext();
        this.popupContext = 0;
        this.animationScreenType = 0;
        this.animationScreenSubType = 0;
        this.animationLeadTime = 0;
        this.animationAddInfo = 0;
        this.animationSpeed = 0;
    }

    public KombiDisplayStatus(int n, int n2, int n3, int n4, MenuContext menuContext, int n5, int n6, int n7, int n8, int n9, int n10) {
        this.tid = n;
        this.focus = n2;
        this.screenFormat = n3;
        this.mainContext = n4;
        this.menuContext = menuContext;
        this.popupContext = n5;
        this.animationScreenType = n6;
        this.animationScreenSubType = n7;
        this.animationLeadTime = n8;
        this.animationAddInfo = n9;
        this.animationSpeed = n10;
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

    public int getAnimationScreenType() {
        return this.animationScreenType;
    }

    public int getAnimationScreenSubType() {
        return this.animationScreenSubType;
    }

    public int getAnimationLeadTime() {
        return this.animationLeadTime;
    }

    public int getAnimationAddInfo() {
        return this.animationAddInfo;
    }

    public int getAnimationSpeed() {
        return this.animationSpeed;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(1650);
        stringBuffer.append("KombiDisplayStatus");
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
        stringBuffer.append("animationScreenType");
        stringBuffer.append('=');
        stringBuffer.append(this.animationScreenType);
        stringBuffer.append(',');
        stringBuffer.append("animationScreenSubType");
        stringBuffer.append('=');
        stringBuffer.append(this.animationScreenSubType);
        stringBuffer.append(',');
        stringBuffer.append("animationLeadTime");
        stringBuffer.append('=');
        stringBuffer.append(this.animationLeadTime);
        stringBuffer.append(',');
        stringBuffer.append("animationAddInfo");
        stringBuffer.append('=');
        stringBuffer.append(this.animationAddInfo);
        stringBuffer.append(',');
        stringBuffer.append("animationSpeed");
        stringBuffer.append('=');
        stringBuffer.append(this.animationSpeed);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

