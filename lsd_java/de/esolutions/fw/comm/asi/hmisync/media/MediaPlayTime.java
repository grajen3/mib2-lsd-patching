/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.media;

public class MediaPlayTime {
    public long id;
    public int time;
    public int totalTime;

    public long getId() {
        return this.id;
    }

    public void setId(long l) {
        this.id = l;
    }

    public int getTime() {
        return this.time;
    }

    public void setTime(int n) {
        this.time = n;
    }

    public int getTotalTime() {
        return this.totalTime;
    }

    public void setTotalTime(int n) {
        this.totalTime = n;
    }

    public MediaPlayTime() {
    }

    public MediaPlayTime(long l, int n, int n2) {
        this.id = l;
        this.time = n;
        this.totalTime = n2;
    }

    public String toString() {
        return new StringBuffer("MediaPlayTime{").append("id=").append(this.id).append(", time=").append(this.time).append(", totalTime=").append(this.totalTime).append("}").toString();
    }
}

