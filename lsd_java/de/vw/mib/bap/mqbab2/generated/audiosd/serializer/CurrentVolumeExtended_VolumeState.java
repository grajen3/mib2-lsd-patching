/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.audiosd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class CurrentVolumeExtended_VolumeState
implements BAPEntity {
    private static final int RESERVED_BIT_1__7_BITSIZE;
    public boolean volumeIsNotLocked;

    public CurrentVolumeExtended_VolumeState() {
        this.internalReset();
        this.customInitialization();
    }

    public CurrentVolumeExtended_VolumeState(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.volumeIsNotLocked = false;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        CurrentVolumeExtended_VolumeState currentVolumeExtended_VolumeState = (CurrentVolumeExtended_VolumeState)bAPEntity;
        return this.volumeIsNotLocked == currentVolumeExtended_VolumeState.volumeIsNotLocked;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "CurrentVolumeExtended_Empty:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.resetBits(7);
        bitStream.pushBoolean(this.volumeIsNotLocked);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        bitStream.discardBits(7);
        this.volumeIsNotLocked = bitStream.popFrontBoolean();
    }
}

