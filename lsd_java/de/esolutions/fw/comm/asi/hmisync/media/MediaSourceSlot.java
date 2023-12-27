/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.media;

public class MediaSourceSlot {
    public int source;
    public int slotIdx;
    public int mediaType;
    public int deviceIdx;
    public int state;
    public int flags;
    public String name;

    public int getSource() {
        return this.source;
    }

    public void setSource(int n) {
        this.source = n;
    }

    public int getSlotIdx() {
        return this.slotIdx;
    }

    public void setSlotIdx(int n) {
        this.slotIdx = n;
    }

    public int getMediaType() {
        return this.mediaType;
    }

    public void setMediaType(int n) {
        this.mediaType = n;
    }

    public int getDeviceIdx() {
        return this.deviceIdx;
    }

    public void setDeviceIdx(int n) {
        this.deviceIdx = n;
    }

    public int getState() {
        return this.state;
    }

    public void setState(int n) {
        this.state = n;
    }

    public int getFlags() {
        return this.flags;
    }

    public void setFlags(int n) {
        this.flags = n;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String string) {
        this.name = string;
    }

    public MediaSourceSlot() {
    }

    public MediaSourceSlot(int n, int n2, int n3, int n4, int n5, int n6, String string) {
        this.source = n;
        this.slotIdx = n2;
        this.mediaType = n3;
        this.deviceIdx = n4;
        this.state = n5;
        this.flags = n6;
        this.name = string;
    }

    public String toString() {
        return new StringBuffer("MediaSourceSlot{").append("source=").append(this.source).append(", slotIdx=").append(this.slotIdx).append(", mediaType=").append(this.mediaType).append(", deviceIdx=").append(this.deviceIdx).append(", state=").append(this.state).append(", flags=").append(this.flags).append(", name=").append(this.name).append("}").toString();
    }
}

