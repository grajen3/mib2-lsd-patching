/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carplay;

public class AppState {
    public int appStateID;
    public int owner;
    public int speechMode;

    public AppState() {
        this.appStateID = 0;
        this.owner = 0;
        this.speechMode = 0;
    }

    public AppState(int n, int n2, int n3) {
        this.appStateID = n;
        this.owner = n2;
        this.speechMode = n3;
    }

    public int getAppStateID() {
        return this.appStateID;
    }

    public int getOwner() {
        return this.owner;
    }

    public int getSpeechMode() {
        return this.speechMode;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(150);
        stringBuffer.append("AppState");
        stringBuffer.append('(');
        stringBuffer.append("appStateID");
        stringBuffer.append('=');
        stringBuffer.append(this.appStateID);
        stringBuffer.append(',');
        stringBuffer.append("owner");
        stringBuffer.append('=');
        stringBuffer.append(this.owner);
        stringBuffer.append(',');
        stringBuffer.append("speechMode");
        stringBuffer.append('=');
        stringBuffer.append(this.speechMode);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

