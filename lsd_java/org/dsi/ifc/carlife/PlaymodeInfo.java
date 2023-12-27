/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carlife;

public class PlaymodeInfo {
    public int shuffleMode;
    public int repeatMode;

    public PlaymodeInfo() {
        this.shuffleMode = 0;
        this.repeatMode = 0;
    }

    public PlaymodeInfo(int n, int n2) {
        this.shuffleMode = n;
        this.repeatMode = n2;
    }

    public int getShuffleMode() {
        return this.shuffleMode;
    }

    public int getRepeatMode() {
        return this.repeatMode;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(150);
        stringBuffer.append("PlaymodeInfo");
        stringBuffer.append('(');
        stringBuffer.append("shuffleMode");
        stringBuffer.append('=');
        stringBuffer.append(this.shuffleMode);
        stringBuffer.append(',');
        stringBuffer.append("repeatMode");
        stringBuffer.append('=');
        stringBuffer.append(this.repeatMode);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

