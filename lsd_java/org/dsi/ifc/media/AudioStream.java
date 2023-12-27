/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.media;

public class AudioStream {
    public int languageCode;
    public int numChannels;
    public int audioCoding;
    public int samplingRate;
    public int audioLanguageExtension;

    public AudioStream() {
        this.languageCode = 0;
        this.numChannels = 0;
        this.audioCoding = 0;
        this.samplingRate = 0;
        this.audioLanguageExtension = 0;
    }

    public AudioStream(int n, int n2, int n3, int n4, int n5) {
        this.languageCode = n;
        this.numChannels = n2;
        this.audioCoding = n3;
        this.samplingRate = n4;
        this.audioLanguageExtension = n5;
    }

    public int getLanguageCode() {
        return this.languageCode;
    }

    public int getNumChannels() {
        return this.numChannels;
    }

    public int getAudioCoding() {
        return this.audioCoding;
    }

    public int getSamplingRate() {
        return this.samplingRate;
    }

    public int getAudioLanguageExtension() {
        return this.audioLanguageExtension;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(300);
        stringBuffer.append("AudioStream");
        stringBuffer.append('(');
        stringBuffer.append("languageCode");
        stringBuffer.append('=');
        stringBuffer.append(this.languageCode);
        stringBuffer.append(',');
        stringBuffer.append("numChannels");
        stringBuffer.append('=');
        stringBuffer.append(this.numChannels);
        stringBuffer.append(',');
        stringBuffer.append("audioCoding");
        stringBuffer.append('=');
        stringBuffer.append(this.audioCoding);
        stringBuffer.append(',');
        stringBuffer.append("samplingRate");
        stringBuffer.append('=');
        stringBuffer.append(this.samplingRate);
        stringBuffer.append(',');
        stringBuffer.append("audioLanguageExtension");
        stringBuffer.append('=');
        stringBuffer.append(this.audioLanguageExtension);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

