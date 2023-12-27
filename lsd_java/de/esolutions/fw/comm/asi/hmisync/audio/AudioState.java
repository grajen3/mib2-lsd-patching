/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.audio;

public class AudioState {
    public int audioContext;
    public int audioState;

    public int getAudioContext() {
        return this.audioContext;
    }

    public void setAudioContext(int n) {
        this.audioContext = n;
    }

    public int getAudioState() {
        return this.audioState;
    }

    public void setAudioState(int n) {
        this.audioState = n;
    }

    public AudioState() {
    }

    public AudioState(int n, int n2) {
        this.audioContext = n;
        this.audioState = n2;
    }

    public String toString() {
        return new StringBuffer("AudioState{").append("audioContext=").append(this.audioContext).append(", audioState=").append(this.audioState).append("}").toString();
    }
}

