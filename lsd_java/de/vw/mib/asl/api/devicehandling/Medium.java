/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.devicehandling;

import de.vw.mib.asl.api.devicehandling.Device;
import de.vw.mib.asl.api.devicehandling.MediumState;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.util.Util;
import org.dsi.ifc.media.MediaInfo;

public final class Medium {
    private final Device parent;
    private final int partitionIndex;
    private final MediumState previousState;
    private final MediumState currentState;
    private final IntObjectOptHashMap tags = new IntObjectOptHashMap();

    public IntObjectOptHashMap tags() {
        return this.tags;
    }

    Medium(Device device, int n) {
        this.parent = device;
        this.partitionIndex = n;
        this.previousState = new MediumState(device.getPreviousState());
        device.getPreviousState().ensureCapacity(n + 1);
        device.getPreviousState().partitions[n] = this.previousState;
        device.getCurrentState().partitions[n] = this.currentState = new MediumState(device.getCurrentState());
    }

    public Device getParent() {
        return this.parent;
    }

    public MediumState getPreviousState() {
        return this.previousState;
    }

    public MediumState getCurrentState() {
        return this.currentState;
    }

    public MediaInfo getPreviousInfo() {
        return this.previousState.getInfo();
    }

    public MediaInfo getCurrentInfo() {
        return this.currentState.getInfo();
    }

    public long getId() {
        if (this.currentState.getInfo() != MediumState.EMPTY_MEDIA_INFO) {
            return this.currentState.getInfo().mediaID;
        }
        return this.previousState.getInfo().mediaID;
    }

    void swapStates(boolean bl) {
        this.previousState.setInfo(this.getCurrentInfo());
        if (bl) {
            this.currentState.setInfo(MediumState.EMPTY_MEDIA_INFO);
        }
    }

    public boolean isJustLoaded() {
        return !this.previousState.isPlayable() && this.currentState.isPlayable();
    }

    public boolean isJustRemoved() {
        return this.previousState.isPlayable() && !this.currentState.isPlayable();
    }

    public boolean isJustUnavailable() {
        return this.previousState.isPlayable() && this.currentState.isPlayableIgnoringVdrop() && !this.currentState.deviceState.isOperable();
    }

    public boolean isJustFullyRemoved() {
        return this.previousState.isPlayableIgnoringVdrop() && !this.currentState.isPlayable() && this.currentState.deviceState.isOperable();
    }

    public boolean isTypeEntered(int n) {
        return this.previousState.getInfo().getMediaType() != n && this.currentState.getInfo().getMediaType() == n;
    }

    public boolean isTypeExitted(int n) {
        return this.previousState.getInfo().getMediaType() == n && this.currentState.getInfo().getMediaType() != n;
    }

    public boolean isFlagEntered(int n) {
        return !Util.isBitSet(n, this.getPreviousInfo().getFlags()) && Util.isBitSet(n, this.getCurrentInfo().getFlags());
    }

    public boolean isFlagChanged(int n) {
        return ((this.getPreviousInfo().getFlags() ^ this.getCurrentInfo().getFlags()) & n) != 0;
    }

    public int getPartitionIndex() {
        return this.partitionIndex;
    }

    public String toString() {
        return new StringBuffer().append(this.getParent().toString()).append("/").append(this.partitionIndex).append(":").append(this.getCurrentInfo() != null ? this.getCurrentState().getMediaTypeStr() : "(no info)").toString();
    }
}

