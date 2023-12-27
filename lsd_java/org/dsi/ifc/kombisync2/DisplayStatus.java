/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.kombisync2;

import org.dsi.ifc.kombisync2.DisplayStatusFlags;
import org.dsi.ifc.kombisync2.MenuContext;

public class DisplayStatus {
    public int internalState;
    public int mainContext;
    public int screenFormat;
    public int focus;
    public MenuContext menuContext;
    public int style;
    public DisplayStatusFlags statusFlags;

    public DisplayStatus() {
        this.internalState = 0;
        this.mainContext = 0;
        this.screenFormat = 0;
        this.focus = 0;
        this.menuContext = null;
        this.style = 0;
        this.statusFlags = null;
    }

    public DisplayStatus(int n, int n2, int n3, int n4, MenuContext menuContext, int n5, DisplayStatusFlags displayStatusFlags) {
        this.internalState = n;
        this.mainContext = n2;
        this.screenFormat = n3;
        this.focus = n4;
        this.menuContext = menuContext;
        this.style = n5;
        this.statusFlags = displayStatusFlags;
    }

    public int getInternalState() {
        return this.internalState;
    }

    public int getMainContext() {
        return this.mainContext;
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

    public int getStyle() {
        return this.style;
    }

    public DisplayStatusFlags getStatusFlags() {
        return this.statusFlags;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(2350);
        stringBuffer.append("DisplayStatus");
        stringBuffer.append('(');
        stringBuffer.append("internalState");
        stringBuffer.append('=');
        stringBuffer.append(this.internalState);
        stringBuffer.append(',');
        stringBuffer.append("mainContext");
        stringBuffer.append('=');
        stringBuffer.append(this.mainContext);
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
        stringBuffer.append("style");
        stringBuffer.append('=');
        stringBuffer.append(this.style);
        stringBuffer.append(',');
        stringBuffer.append("statusFlags");
        stringBuffer.append('=');
        stringBuffer.append(this.statusFlags);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

