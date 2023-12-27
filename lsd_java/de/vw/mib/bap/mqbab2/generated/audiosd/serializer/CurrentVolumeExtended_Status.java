/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.audiosd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.mqbab2.generated.audiosd.serializer.CurrentVolumeExtended_VolumeState;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class CurrentVolumeExtended_Status
implements StatusProperty {
    public int changingVolumeType;
    public static final int CHANGING_VOLUME_TYPE_EXTERNAL_SDS_VOLUME_IS_BEING_CHANGED_DF4_4;
    public static final int CHANGING_VOLUME_TYPE_SDS_VOLUME_IS_BEING_CHANGED;
    public static final int CHANGING_VOLUME_TYPE_ONLINE_VOLUME_TYPE_IS_BEING_CHANGED;
    public static final int CHANGING_VOLUME_TYPE_ANNOUNCEMENT_VOLUME_IS_BEING_CHANGED;
    public static final int CHANGING_VOLUME_TYPE_MMI_TOUCH_VOLUME_IS_BEING_CHANGED;
    public static final int CHANGING_VOLUME_TYPE_READ_CONTACT_VOLUME_IS_BEING_CHANGED;
    public static final int CHANGING_VOLUME_TYPE_PHONE_CALL_VOLUME_IS_BEING_CHANGED;
    public static final int CHANGING_VOLUME_TYPE_TMC_TRAFFIC_MESSAGE_VOLUME_IS_BEING_CHANGED;
    public static final int CHANGING_VOLUME_TYPE_READ_MESSAGE_VOLUME_IS_BEING_CHANGED;
    public static final int CHANGING_VOLUME_TYPE_CAR_PARKING_FADER_IS_BEING_CHANGED;
    public static final int CHANGING_VOLUME_TYPE_TA_TP_VOLUME_IS_BEING_CHANGED;
    public static final int CHANGING_VOLUME_TYPE_PHONE_RINGING_VOLUME_IS_BEING_CHANGED;
    public static final int CHANGING_VOLUME_TYPE_NAVIGATION_VOLUME_IS_BEING_CHANGED;
    public static final int CHANGING_VOLUME_TYPE_ENTERTAINMENT_VOLUME_IS_BEING_CHANGED;
    public static final int CHANGING_VOLUME_TYPE_NO_VOLUME_IS_CHANGED;
    public CurrentVolumeExtended_VolumeState volumeState = new CurrentVolumeExtended_VolumeState();
    public int maxVolume;
    public static final int MAX_VOLUME_MIN;
    public int genericVolume;
    public static final int GENERIC_VOLUME_MIN;

    public CurrentVolumeExtended_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public CurrentVolumeExtended_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.changingVolumeType = 0;
        this.maxVolume = 0;
        this.genericVolume = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
        this.volumeState.reset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        CurrentVolumeExtended_Status currentVolumeExtended_Status = (CurrentVolumeExtended_Status)bAPEntity;
        return this.changingVolumeType == currentVolumeExtended_Status.changingVolumeType && this.volumeState.equalTo(currentVolumeExtended_Status.volumeState) && this.maxVolume == currentVolumeExtended_Status.maxVolume && this.genericVolume == currentVolumeExtended_Status.genericVolume;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "CurrentVolumeExtended_Status:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.changingVolumeType);
        this.volumeState.serialize(bitStream);
        bitStream.pushByte((byte)this.maxVolume);
        bitStream.pushByte((byte)this.genericVolume);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.changingVolumeType = bitStream.popFrontByte();
        this.volumeState.deserialize(bitStream);
        this.maxVolume = bitStream.popFrontByte();
        this.genericVolume = bitStream.popFrontByte();
    }

    public static int functionId() {
        return 47;
    }

    @Override
    public int getFunctionId() {
        return CurrentVolumeExtended_Status.functionId();
    }
}

