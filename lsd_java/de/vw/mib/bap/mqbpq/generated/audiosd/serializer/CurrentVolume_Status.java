/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbpq.generated.audiosd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class CurrentVolume_Status
implements StatusProperty {
    public int volume;
    public int changingVolume;
    public static final int CHANGING_VOLUME_FALSE;
    public static final int CHANGING_VOLUME_TRUE;

    public CurrentVolume_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public CurrentVolume_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.volume = 0;
        this.changingVolume = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        CurrentVolume_Status currentVolume_Status = (CurrentVolume_Status)bAPEntity;
        return this.volume == currentVolume_Status.volume && this.changingVolume == currentVolume_Status.changingVolume;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "CurrentVolume_Status:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.volume);
        bitStream.pushByte((byte)this.changingVolume);
    }

    @Override
    public void deserialize(BitStream bitStream) {
    }

    public static int functionId() {
        return 18;
    }

    @Override
    public int getFunctionId() {
        return CurrentVolume_Status.functionId();
    }
}

