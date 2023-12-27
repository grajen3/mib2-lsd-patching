/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.media;

import de.esolutions.fw.comm.asi.hmisync.media.MediaSourceSlot;

public class MediaActiveSourceState {
    public MediaSourceSlot slot;
    public int state;

    public MediaSourceSlot getSlot() {
        return this.slot;
    }

    public void setSlot(MediaSourceSlot mediaSourceSlot) {
        this.slot = mediaSourceSlot;
    }

    public int getState() {
        return this.state;
    }

    public void setState(int n) {
        this.state = n;
    }

    public MediaActiveSourceState() {
        this.slot = null;
    }

    public MediaActiveSourceState(MediaSourceSlot mediaSourceSlot, int n) {
        this.slot = mediaSourceSlot;
        this.state = n;
    }

    public String toString() {
        return new StringBuffer("MediaActiveSourceState{").append("slot=").append(this.slot).append(", state=").append(this.state).append("}").toString();
    }
}

