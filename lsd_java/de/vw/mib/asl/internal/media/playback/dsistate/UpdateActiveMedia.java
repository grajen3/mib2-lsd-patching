/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.playback.dsistate;

import de.vw.mib.asl.internal.media.sourcehandling.state.MediaCollector;

public final class UpdateActiveMedia {
    private long deviceID;
    private long mediaID;
    private int groupID;
    private int physicalPlayerID;
    private int validFlag = -1;

    public void invalidate() {
        this.validFlag = -1;
    }

    public void updateActiveMedia(long l, long l2, int n, int n2, int n3) {
        this.deviceID = l;
        this.mediaID = l2;
        this.groupID = n;
        this.physicalPlayerID = n2;
        this.validFlag = n3;
    }

    public int getGroupID() {
        return this.groupID;
    }

    public int getPhysicalPlayerID() {
        return this.physicalPlayerID;
    }

    public boolean isEmpty() {
        return this.validFlag != 1 || this.deviceID == 0L && this.mediaID == 0L;
    }

    public boolean isActive(MediaCollector mediaCollector) {
        return this.validFlag == 1 && mediaCollector.getDeviceID() == this.deviceID && mediaCollector.getMediaID() == this.mediaID;
    }

    public long getMediaID() {
        return this.mediaID;
    }
}

