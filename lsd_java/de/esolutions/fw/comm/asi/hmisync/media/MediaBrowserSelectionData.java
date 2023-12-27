/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.media;

public class MediaBrowserSelectionData {
    public int browserInstance;
    public long trackID;
    public boolean seamless;

    public int getBrowserInstance() {
        return this.browserInstance;
    }

    public void setBrowserInstance(int n) {
        this.browserInstance = n;
    }

    public long getTrackID() {
        return this.trackID;
    }

    public void setTrackID(long l) {
        this.trackID = l;
    }

    public boolean isSeamless() {
        return this.seamless;
    }

    public void setSeamless(boolean bl) {
        this.seamless = bl;
    }

    public MediaBrowserSelectionData() {
    }

    public MediaBrowserSelectionData(int n, long l, boolean bl) {
        this.browserInstance = n;
        this.trackID = l;
        this.seamless = bl;
    }

    public String toString() {
        return new StringBuffer("MediaBrowserSelectionData{").append("browserInstance=").append(this.browserInstance).append(", trackID=").append(this.trackID).append(", seamless=").append(this.seamless).append("}").toString();
    }
}

