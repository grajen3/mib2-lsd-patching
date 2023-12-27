/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.radio;

public class AudioStatus {
    public long sID;
    public int sCIDI;
    public int dRCStatus;
    public int musicSpeech;
    public int audioMode;
    public int decodingAlgorithm;
    public int audioBitrate;
    public int originalStatus;
    public int copyrightStatus;
    public int samplingRate;

    public AudioStatus() {
        this.sID = 0L;
        this.sCIDI = 0;
        this.dRCStatus = 0;
        this.musicSpeech = 0;
        this.audioMode = 0;
        this.decodingAlgorithm = 0;
        this.audioBitrate = 0;
        this.originalStatus = 0;
        this.copyrightStatus = 0;
        this.samplingRate = 0;
    }

    public AudioStatus(long l, int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9) {
        this.sID = l;
        this.sCIDI = n;
        this.dRCStatus = n2;
        this.musicSpeech = n3;
        this.audioMode = n4;
        this.decodingAlgorithm = n5;
        this.audioBitrate = n6;
        this.originalStatus = n7;
        this.copyrightStatus = n8;
        this.samplingRate = n9;
    }

    public long getSID() {
        return this.sID;
    }

    public int getSCIDI() {
        return this.sCIDI;
    }

    public int getDRCStatus() {
        return this.dRCStatus;
    }

    public int getMusicSpeech() {
        return this.musicSpeech;
    }

    public int getAudioMode() {
        return this.audioMode;
    }

    public int getDecodingAlgorithm() {
        return this.decodingAlgorithm;
    }

    public int getAudioBitrate() {
        return this.audioBitrate;
    }

    public int getOriginalStatus() {
        return this.originalStatus;
    }

    public int getCopyrightStatus() {
        return this.copyrightStatus;
    }

    public int getSamplingRate() {
        return this.samplingRate;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(600);
        stringBuffer.append("AudioStatus");
        stringBuffer.append('(');
        stringBuffer.append("sID");
        stringBuffer.append('=');
        stringBuffer.append(this.sID);
        stringBuffer.append(',');
        stringBuffer.append("sCIDI");
        stringBuffer.append('=');
        stringBuffer.append(this.sCIDI);
        stringBuffer.append(',');
        stringBuffer.append("dRCStatus");
        stringBuffer.append('=');
        stringBuffer.append(this.dRCStatus);
        stringBuffer.append(',');
        stringBuffer.append("musicSpeech");
        stringBuffer.append('=');
        stringBuffer.append(this.musicSpeech);
        stringBuffer.append(',');
        stringBuffer.append("audioMode");
        stringBuffer.append('=');
        stringBuffer.append(this.audioMode);
        stringBuffer.append(',');
        stringBuffer.append("decodingAlgorithm");
        stringBuffer.append('=');
        stringBuffer.append(this.decodingAlgorithm);
        stringBuffer.append(',');
        stringBuffer.append("audioBitrate");
        stringBuffer.append('=');
        stringBuffer.append(this.audioBitrate);
        stringBuffer.append(',');
        stringBuffer.append("originalStatus");
        stringBuffer.append('=');
        stringBuffer.append(this.originalStatus);
        stringBuffer.append(',');
        stringBuffer.append("copyrightStatus");
        stringBuffer.append('=');
        stringBuffer.append(this.copyrightStatus);
        stringBuffer.append(',');
        stringBuffer.append("samplingRate");
        stringBuffer.append('=');
        stringBuffer.append(this.samplingRate);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

