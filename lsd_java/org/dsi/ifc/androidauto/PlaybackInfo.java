/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.androidauto;

public class PlaybackInfo {
    public int status;
    public int shuffleMode;
    public int repeatMode;
    public String playbackApp;

    public PlaybackInfo() {
        this.status = 0;
        this.shuffleMode = 0;
        this.repeatMode = 0;
        this.playbackApp = "";
    }

    public PlaybackInfo(int n, int n2, int n3, String string) {
        this.status = n;
        this.shuffleMode = n2;
        this.repeatMode = n3;
        this.playbackApp = string;
    }

    public int getStatus() {
        return this.status;
    }

    public int getShuffleMode() {
        return this.shuffleMode;
    }

    public int getRepeatMode() {
        return this.repeatMode;
    }

    public String getPlaybackApp() {
        return this.playbackApp;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(250);
        stringBuffer.append("PlaybackInfo");
        stringBuffer.append('(');
        stringBuffer.append("status");
        stringBuffer.append('=');
        stringBuffer.append(this.status);
        stringBuffer.append(',');
        stringBuffer.append("shuffleMode");
        stringBuffer.append('=');
        stringBuffer.append(this.shuffleMode);
        stringBuffer.append(',');
        stringBuffer.append("repeatMode");
        stringBuffer.append('=');
        stringBuffer.append(this.repeatMode);
        stringBuffer.append(',');
        stringBuffer.append("playbackApp");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.playbackApp);
        stringBuffer.append('\"');
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

