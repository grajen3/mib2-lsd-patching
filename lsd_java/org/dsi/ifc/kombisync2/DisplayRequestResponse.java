/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.kombisync2;

import org.dsi.ifc.kombisync2.MenuContext;

public class DisplayRequestResponse {
    public int reqRespInformation;
    public int mainContext;
    public int screenFormat;
    public int focus;
    public MenuContext menuContext;
    public int style;
    public int requestTID;
    public int responseTID;

    public DisplayRequestResponse() {
        this.reqRespInformation = 0;
        this.mainContext = 0;
        this.screenFormat = 0;
        this.focus = 0;
        this.menuContext = null;
        this.style = 0;
        this.requestTID = 0;
        this.responseTID = 0;
    }

    public DisplayRequestResponse(int n, int n2, int n3, int n4, MenuContext menuContext, int n5, int n6, int n7) {
        this.reqRespInformation = n;
        this.mainContext = n2;
        this.screenFormat = n3;
        this.focus = n4;
        this.menuContext = menuContext;
        this.style = n5;
        this.requestTID = n6;
        this.responseTID = n7;
    }

    public int getReqRespInformation() {
        return this.reqRespInformation;
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

    public int getRequestTID() {
        return this.requestTID;
    }

    public int getResponseTID() {
        return this.responseTID;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(1450);
        stringBuffer.append("DisplayRequestResponse");
        stringBuffer.append('(');
        stringBuffer.append("reqRespInformation");
        stringBuffer.append('=');
        stringBuffer.append(this.reqRespInformation);
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
        stringBuffer.append("requestTID");
        stringBuffer.append('=');
        stringBuffer.append(this.requestTID);
        stringBuffer.append(',');
        stringBuffer.append("responseTID");
        stringBuffer.append('=');
        stringBuffer.append(this.responseTID);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

