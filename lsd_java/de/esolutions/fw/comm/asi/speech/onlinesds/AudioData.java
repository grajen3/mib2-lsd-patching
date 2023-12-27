/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.speech.onlinesds;

import de.esolutions.fw.comm.asi.speech.onlinesds.AudioFormat;

public class AudioData {
    public byte[] audioData;
    public int audioDataSize;
    public AudioFormat format;

    public byte[] getAudioData() {
        return this.audioData;
    }

    public void setAudioData(byte[] byArray) {
        this.audioData = byArray;
    }

    public int getAudioDataSize() {
        return this.audioDataSize;
    }

    public void setAudioDataSize(int n) {
        this.audioDataSize = n;
    }

    public AudioFormat getFormat() {
        return this.format;
    }

    public void setFormat(AudioFormat audioFormat) {
        this.format = audioFormat;
    }

    public AudioData() {
        this.format = null;
    }

    public AudioData(byte[] byArray, int n, AudioFormat audioFormat) {
        this.audioData = byArray;
        this.audioDataSize = n;
        this.format = audioFormat;
    }

    public String toString() {
        return new StringBuffer("AudioData{").append("audioData=").append("[").append(this.audioData == null ? "null" : new StringBuffer().append("size=").append(this.audioData.length).toString()).append("]").append(", audioDataSize=").append(this.audioDataSize).append(", format=").append(this.format).append("}").toString();
    }
}

