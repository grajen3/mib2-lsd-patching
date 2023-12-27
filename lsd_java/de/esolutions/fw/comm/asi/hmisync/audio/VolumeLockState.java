/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.audio;

public class VolumeLockState {
    public int audioContext;
    public int state;

    public int getAudioContext() {
        return this.audioContext;
    }

    public void setAudioContext(int n) {
        this.audioContext = n;
    }

    public int getState() {
        return this.state;
    }

    public void setState(int n) {
        this.state = n;
    }

    public VolumeLockState() {
    }

    public VolumeLockState(int n, int n2) {
        this.audioContext = n;
        this.state = n2;
    }

    public String toString() {
        return new StringBuffer("VolumeLockState{").append("audioContext=").append(this.audioContext).append(", state=").append(this.state).append("}").toString();
    }
}

