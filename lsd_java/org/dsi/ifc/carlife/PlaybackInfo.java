/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carlife;

public class PlaybackInfo {
    public int status;
    public String playbackApp;

    public PlaybackInfo() {
        this.status = 0;
        this.playbackApp = "";
    }

    public PlaybackInfo(int n, String string) {
        this.status = n;
        this.playbackApp = string;
    }

    public int getStatus() {
        return this.status;
    }

    public String getPlaybackApp() {
        return this.playbackApp;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(150);
        stringBuffer.append("PlaybackInfo");
        stringBuffer.append('(');
        stringBuffer.append("status");
        stringBuffer.append('=');
        stringBuffer.append(this.status);
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

