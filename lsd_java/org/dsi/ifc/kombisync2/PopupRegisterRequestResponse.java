/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.kombisync2;

import org.dsi.ifc.kombisync2.MenuContext;
import org.dsi.ifc.kombisync2.PopupStatusFlags;

public class PopupRegisterRequestResponse {
    public int tid;
    public int popupState;
    public int popupID;
    public int screenFormat;
    public int focus;
    public MenuContext menuContext;
    public int popupContext;
    public int popupType;
    public int popupPriority;
    public PopupStatusFlags popupStatusFlags;

    public PopupRegisterRequestResponse() {
        this.tid = 0;
        this.popupState = 0;
        this.popupID = 0;
        this.screenFormat = 0;
        this.focus = 0;
        this.menuContext = null;
        this.popupContext = 0;
        this.popupType = 0;
        this.popupPriority = 0;
        this.popupStatusFlags = null;
    }

    public PopupRegisterRequestResponse(int n, int n2, int n3, int n4, int n5, MenuContext menuContext, int n6, int n7, int n8, PopupStatusFlags popupStatusFlags) {
        this.tid = n;
        this.popupState = n2;
        this.popupID = n3;
        this.screenFormat = n4;
        this.focus = n5;
        this.menuContext = menuContext;
        this.popupContext = n6;
        this.popupType = n7;
        this.popupPriority = n8;
        this.popupStatusFlags = popupStatusFlags;
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

    public int getPopupContext() {
        return this.popupContext;
    }

    public int getPopupType() {
        return this.popupType;
    }

    public int getPopupPriority() {
        return this.popupPriority;
    }

    public PopupStatusFlags getPopupStatusFlags() {
        return this.popupStatusFlags;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(2500);
        stringBuffer.append("PopupRegisterRequestResponse");
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
        stringBuffer.append(',');
        stringBuffer.append("popupContext");
        stringBuffer.append('=');
        stringBuffer.append(this.popupContext);
        stringBuffer.append(',');
        stringBuffer.append("popupType");
        stringBuffer.append('=');
        stringBuffer.append(this.popupType);
        stringBuffer.append(',');
        stringBuffer.append("popupPriority");
        stringBuffer.append('=');
        stringBuffer.append(this.popupPriority);
        stringBuffer.append(',');
        stringBuffer.append("popupStatusFlags");
        stringBuffer.append('=');
        stringBuffer.append(this.popupStatusFlags);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

