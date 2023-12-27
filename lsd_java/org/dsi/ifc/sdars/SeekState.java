/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.sdars;

public class SeekState {
    public int seekType;
    public int state;

    public SeekState() {
        this.seekType = 0;
        this.state = 0;
    }

    public SeekState(int n, int n2) {
        this.seekType = n;
        this.state = n2;
    }

    public int getSeekType() {
        return this.seekType;
    }

    public int getState() {
        return this.state;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(100);
        stringBuffer.append("SeekState");
        stringBuffer.append('(');
        stringBuffer.append("seekType");
        stringBuffer.append('=');
        stringBuffer.append(this.seekType);
        stringBuffer.append(',');
        stringBuffer.append("state");
        stringBuffer.append('=');
        stringBuffer.append(this.state);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

