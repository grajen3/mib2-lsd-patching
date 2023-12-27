/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.speech.onlinesds;

public class AudioFormat {
    public long sampleRate;
    public long nChannels;
    public long bitsPerSample;
    public int format;
    public int endianness;

    public long getSampleRate() {
        return this.sampleRate;
    }

    public void setSampleRate(long l) {
        this.sampleRate = l;
    }

    public long getNChannels() {
        return this.nChannels;
    }

    public void setNChannels(long l) {
        this.nChannels = l;
    }

    public long getBitsPerSample() {
        return this.bitsPerSample;
    }

    public void setBitsPerSample(long l) {
        this.bitsPerSample = l;
    }

    public int getFormat() {
        return this.format;
    }

    public void setFormat(int n) {
        this.format = n;
    }

    public int getEndianness() {
        return this.endianness;
    }

    public void setEndianness(int n) {
        this.endianness = n;
    }

    public AudioFormat() {
    }

    public AudioFormat(long l, long l2, long l3, int n, int n2) {
        this.sampleRate = l;
        this.nChannels = l2;
        this.bitsPerSample = l3;
        this.format = n;
        this.endianness = n2;
    }

    public String toString() {
        return new StringBuffer("AudioFormat{").append("sampleRate=").append(this.sampleRate).append(", nChannels=").append(this.nChannels).append(", bitsPerSample=").append(this.bitsPerSample).append(", format=").append(this.format).append(", endianness=").append(this.endianness).append("}").toString();
    }
}

