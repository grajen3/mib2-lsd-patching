/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.media;

public class MediaPlaylistState {
    public int flags;
    public long id;
    public int size;

    public int getFlags() {
        return this.flags;
    }

    public void setFlags(int n) {
        this.flags = n;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long l) {
        this.id = l;
    }

    public int getSize() {
        return this.size;
    }

    public void setSize(int n) {
        this.size = n;
    }

    public MediaPlaylistState() {
    }

    public MediaPlaylistState(int n, long l, int n2) {
        this.flags = n;
        this.id = l;
        this.size = n2;
    }

    public String toString() {
        return new StringBuffer("MediaPlaylistState{").append("flags=").append(this.flags).append(", id=").append(this.id).append(", size=").append(this.size).append("}").toString();
    }
}

