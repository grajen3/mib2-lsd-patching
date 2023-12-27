/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.audiosd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class CurrentVolume_Status
implements StatusProperty {
    public int entertainmentVolume;
    public static final int ENTERTAINMENT_VOLUME_MIN;
    public int navigationVolume;
    public static final int NAVIGATION_VOLUME_MIN;
    public int taVolume;
    public static final int TA_VOLUME_MIN;
    public int phoneVolume;
    public static final int PHONE_VOLUME_MIN;
    public int sdsVolume;
    public static final int SDS_VOLUME_MIN;
    public int changingVolumeType;
    public static final int CHANGING_VOLUME_TYPE_SDS_VOLUME_IS_BEING_CHANGED;
    public static final int CHANGING_VOLUME_TYPE_PHONE_VOLUME_IS_BEING_CHANGED;
    public static final int CHANGING_VOLUME_TYPE_TA_VOLUME_IS_BEING_CHANGED;
    public static final int CHANGING_VOLUME_TYPE_NAVIGATION_VOLUME_IS_BEING_CHANGED;
    public static final int CHANGING_VOLUME_TYPE_ENTERTAINMENT_VOLUME_IS_BEING_CHANGED;
    public static final int CHANGING_VOLUME_TYPE_NO_VOLUME_IS_CHANGED;

    public CurrentVolume_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public CurrentVolume_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.entertainmentVolume = 0;
        this.navigationVolume = 0;
        this.taVolume = 0;
        this.phoneVolume = 0;
        this.sdsVolume = 0;
        this.changingVolumeType = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        CurrentVolume_Status currentVolume_Status = (CurrentVolume_Status)bAPEntity;
        return this.entertainmentVolume == currentVolume_Status.entertainmentVolume && this.navigationVolume == currentVolume_Status.navigationVolume && this.taVolume == currentVolume_Status.taVolume && this.phoneVolume == currentVolume_Status.phoneVolume && this.sdsVolume == currentVolume_Status.sdsVolume && this.changingVolumeType == currentVolume_Status.changingVolumeType;
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
        bitStream.pushByte((byte)this.entertainmentVolume);
        bitStream.pushByte((byte)this.navigationVolume);
        bitStream.pushByte((byte)this.taVolume);
        bitStream.pushByte((byte)this.phoneVolume);
        bitStream.pushByte((byte)this.sdsVolume);
        bitStream.pushByte((byte)this.changingVolumeType);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.entertainmentVolume = bitStream.popFrontByte();
        this.navigationVolume = bitStream.popFrontByte();
        this.taVolume = bitStream.popFrontByte();
        this.phoneVolume = bitStream.popFrontByte();
        this.sdsVolume = bitStream.popFrontByte();
        this.changingVolumeType = bitStream.popFrontByte();
    }

    public static int functionId() {
        return 18;
    }

    @Override
    public int getFunctionId() {
        return CurrentVolume_Status.functionId();
    }
}

