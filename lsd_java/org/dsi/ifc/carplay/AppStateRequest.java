/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carplay;

public class AppStateRequest {
    public int appStateID;
    public boolean state;
    public int speechMode;

    public AppStateRequest() {
        this.appStateID = 0;
        this.state = false;
        this.speechMode = 0;
    }

    public AppStateRequest(int n, boolean bl, int n2) {
        this.appStateID = n;
        this.state = bl;
        this.speechMode = n2;
    }

    public int getAppStateID() {
        return this.appStateID;
    }

    public boolean isState() {
        return this.state;
    }

    public int getSpeechMode() {
        return this.speechMode;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(150);
        stringBuffer.append("AppStateRequest");
        stringBuffer.append('(');
        stringBuffer.append("appStateID");
        stringBuffer.append('=');
        stringBuffer.append(this.appStateID);
        stringBuffer.append(',');
        stringBuffer.append("state");
        stringBuffer.append('=');
        stringBuffer.append(this.state);
        stringBuffer.append(',');
        stringBuffer.append("speechMode");
        stringBuffer.append('=');
        stringBuffer.append(this.speechMode);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

