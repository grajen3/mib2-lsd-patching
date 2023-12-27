/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.androidauto;

public class AppStateRequest {
    public int appStateID;
    public boolean state;

    public AppStateRequest() {
        this.appStateID = 0;
        this.state = false;
    }

    public AppStateRequest(int n, boolean bl) {
        this.appStateID = n;
        this.state = bl;
    }

    public int getAppStateID() {
        return this.appStateID;
    }

    public boolean isState() {
        return this.state;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(100);
        stringBuffer.append("AppStateRequest");
        stringBuffer.append('(');
        stringBuffer.append("appStateID");
        stringBuffer.append('=');
        stringBuffer.append(this.appStateID);
        stringBuffer.append(',');
        stringBuffer.append("state");
        stringBuffer.append('=');
        stringBuffer.append(this.state);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

