/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.tvtuner;

public class AudioChannel {
    public int channelID;
    public String audioLanguage;
    public int audioFormat;
    public int audioDescription;

    public AudioChannel() {
        this.channelID = 0;
        this.audioLanguage = null;
        this.audioFormat = 0;
        this.audioDescription = 0;
    }

    public AudioChannel(int n, String string, int n2, int n3) {
        this.channelID = n;
        this.audioLanguage = string;
        this.audioFormat = n2;
        this.audioDescription = n3;
    }

    public int getChannelID() {
        return this.channelID;
    }

    public String getAudioLanguage() {
        return this.audioLanguage;
    }

    public int getAudioFormat() {
        return this.audioFormat;
    }

    public int getAudioDescription() {
        return this.audioDescription;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(300);
        stringBuffer.append("AudioChannel");
        stringBuffer.append('(');
        stringBuffer.append("channelID");
        stringBuffer.append('=');
        stringBuffer.append(this.channelID);
        stringBuffer.append(',');
        stringBuffer.append("audioLanguage");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.audioLanguage);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("audioFormat");
        stringBuffer.append('=');
        stringBuffer.append(this.audioFormat);
        stringBuffer.append(',');
        stringBuffer.append("audioDescription");
        stringBuffer.append('=');
        stringBuffer.append(this.audioDescription);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

