/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.upnp;

public class PlaybackMode {
    public int modeID;
    public int scope;
    public int modeFlag;

    public PlaybackMode() {
        this.modeID = 0;
        this.scope = 0;
        this.modeFlag = 0;
    }

    public PlaybackMode(int n, int n2, int n3) {
        this.modeID = n;
        this.scope = n2;
        this.modeFlag = n3;
    }

    public int getModeID() {
        return this.modeID;
    }

    public int getScope() {
        return this.scope;
    }

    public int getModeFlag() {
        return this.modeFlag;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(150);
        stringBuffer.append("PlaybackMode");
        stringBuffer.append('(');
        stringBuffer.append("modeID");
        stringBuffer.append('=');
        stringBuffer.append(this.modeID);
        stringBuffer.append(',');
        stringBuffer.append("scope");
        stringBuffer.append('=');
        stringBuffer.append(this.scope);
        stringBuffer.append(',');
        stringBuffer.append("modeFlag");
        stringBuffer.append('=');
        stringBuffer.append(this.modeFlag);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

