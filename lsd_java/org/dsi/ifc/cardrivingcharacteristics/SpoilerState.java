/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.cardrivingcharacteristics;

public class SpoilerState {
    public int state;
    public int currentPosition;

    public SpoilerState() {
        this.state = 0;
        this.currentPosition = 0;
    }

    public SpoilerState(int n, int n2) {
        this.state = n;
        this.currentPosition = n2;
    }

    public int getState() {
        return this.state;
    }

    public int getCurrentPosition() {
        return this.currentPosition;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(150);
        stringBuffer.append("SpoilerState");
        stringBuffer.append('(');
        stringBuffer.append("state");
        stringBuffer.append('=');
        stringBuffer.append(this.state);
        stringBuffer.append(',');
        stringBuffer.append("currentPosition");
        stringBuffer.append('=');
        stringBuffer.append(this.currentPosition);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

