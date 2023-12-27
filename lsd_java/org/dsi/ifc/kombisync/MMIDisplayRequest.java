/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.kombisync;

import org.dsi.ifc.kombisync.MenuContext;

public class MMIDisplayRequest {
    public int tid;
    public int focus;
    public int screenFormat;
    public int mainContext;
    public MenuContext menuContext;
    public int popupContext;
    public boolean quitInfo;

    public MMIDisplayRequest() {
        this.tid = 0;
        this.focus = 0;
        this.screenFormat = 0;
        this.mainContext = 0;
        this.menuContext = new MenuContext();
        this.popupContext = 0;
        this.quitInfo = false;
    }

    public MMIDisplayRequest(int n, int n2, int n3, int n4, MenuContext menuContext, int n5, boolean bl) {
        this.tid = n;
        this.focus = n2;
        this.screenFormat = n3;
        this.mainContext = n4;
        this.menuContext = menuContext;
        this.popupContext = n5;
        this.quitInfo = bl;
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

    public boolean isQuitInfo() {
        return this.quitInfo;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(1350);
        stringBuffer.append("MMIDisplayRequest");
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
        stringBuffer.append("quitInfo");
        stringBuffer.append('=');
        stringBuffer.append(this.quitInfo);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

