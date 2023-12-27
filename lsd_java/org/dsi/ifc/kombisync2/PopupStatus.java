/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.kombisync2;

import org.dsi.ifc.kombisync2.MenuContext;
import org.dsi.ifc.kombisync2.PopupStatusFlags;

public class PopupStatus {
    public int popupID;
    public int popupID2;
    public int screenFormat;
    public int focus;
    public MenuContext menuContext;
    public int popupFlapLeft;
    public int popupFlapRight;
    public PopupStatusFlags popupStatusFlags;

    public PopupStatus() {
        this.popupID = 0;
        this.popupID2 = 0;
        this.screenFormat = 0;
        this.focus = 0;
        this.menuContext = null;
        this.popupFlapLeft = 0;
        this.popupFlapRight = 0;
        this.popupStatusFlags = null;
    }

    public PopupStatus(int n, int n2, int n3, int n4, MenuContext menuContext, int n5, int n6, PopupStatusFlags popupStatusFlags) {
        this.popupID = n;
        this.popupID2 = n2;
        this.screenFormat = n3;
        this.focus = n4;
        this.menuContext = menuContext;
        this.popupFlapLeft = n5;
        this.popupFlapRight = n6;
        this.popupStatusFlags = popupStatusFlags;
    }

    public int getPopupID() {
        return this.popupID;
    }

    public int getPopupID2() {
        return this.popupID2;
    }

    public int getScreenFormat() {
        return this.screenFormat;
    }

    public int getFocus() {
        return this.focus;
    }

    public MenuContext getMenuContext() {
        return this.menuContext;
    }

    public int getPopupFlapLeft() {
        return this.popupFlapLeft;
    }

    public int getPopupFlapRight() {
        return this.popupFlapRight;
    }

    public PopupStatusFlags getPopupStatusFlags() {
        return this.popupStatusFlags;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(2400);
        stringBuffer.append("PopupStatus");
        stringBuffer.append('(');
        stringBuffer.append("popupID");
        stringBuffer.append('=');
        stringBuffer.append(this.popupID);
        stringBuffer.append(',');
        stringBuffer.append("popupID2");
        stringBuffer.append('=');
        stringBuffer.append(this.popupID2);
        stringBuffer.append(',');
        stringBuffer.append("screenFormat");
        stringBuffer.append('=');
        stringBuffer.append(this.screenFormat);
        stringBuffer.append(',');
        stringBuffer.append("focus");
        stringBuffer.append('=');
        stringBuffer.append(this.focus);
        stringBuffer.append(',');
        stringBuffer.append("menuContext");
        stringBuffer.append('=');
        stringBuffer.append(this.menuContext);
        stringBuffer.append(',');
        stringBuffer.append("popupFlapLeft");
        stringBuffer.append('=');
        stringBuffer.append(this.popupFlapLeft);
        stringBuffer.append(',');
        stringBuffer.append("popupFlapRight");
        stringBuffer.append('=');
        stringBuffer.append(this.popupFlapRight);
        stringBuffer.append(',');
        stringBuffer.append("popupStatusFlags");
        stringBuffer.append('=');
        stringBuffer.append(this.popupStatusFlags);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

