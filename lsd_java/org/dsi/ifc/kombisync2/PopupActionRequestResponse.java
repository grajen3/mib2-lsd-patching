/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.kombisync2;

import org.dsi.ifc.kombisync2.MenuContext;

public class PopupActionRequestResponse {
    public int tid;
    public int popupState;
    public int popupID;
    public int screenFormat;
    public int focus;
    public MenuContext menuContext;

    public PopupActionRequestResponse() {
        this.tid = 0;
        this.popupState = 0;
        this.popupID = 0;
        this.screenFormat = 0;
        this.focus = 0;
        this.menuContext = null;
    }

    public PopupActionRequestResponse(int n, int n2, int n3, int n4, int n5, MenuContext menuContext) {
        this.tid = n;
        this.popupState = n2;
        this.popupID = n3;
        this.screenFormat = n4;
        this.focus = n5;
        this.menuContext = menuContext;
    }

    public int getTid() {
        return this.tid;
    }

    public int getPopupState() {
        return this.popupState;
    }

    public int getPopupID() {
        return this.popupID;
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

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(1300);
        stringBuffer.append("PopupActionRequestResponse");
        stringBuffer.append('(');
        stringBuffer.append("tid");
        stringBuffer.append('=');
        stringBuffer.append(this.tid);
        stringBuffer.append(',');
        stringBuffer.append("popupState");
        stringBuffer.append('=');
        stringBuffer.append(this.popupState);
        stringBuffer.append(',');
        stringBuffer.append("popupID");
        stringBuffer.append('=');
        stringBuffer.append(this.popupID);
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
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

