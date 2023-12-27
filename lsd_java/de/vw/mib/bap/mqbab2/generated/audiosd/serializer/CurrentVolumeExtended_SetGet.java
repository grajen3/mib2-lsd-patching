/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.audiosd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.SetGetProperty;
import de.vw.mib.bap.stream.BitStream;

public final class CurrentVolumeExtended_SetGet
implements SetGetProperty {
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
    public int reserve1;
    public static final int RESERVE1_MIN;
    public int reserve2;
    public static final int RESERVE2_MIN;
    public int genericVolume;
    public static final int GENERIC_VOLUME_MIN;

    public CurrentVolumeExtended_SetGet() {
        this.internalReset();
        this.customInitialization();
    }

    public CurrentVolumeExtended_SetGet(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.changingVolumeType = 0;
        this.reserve1 = 0;
        this.reserve2 = 0;
        this.genericVolume = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        CurrentVolumeExtended_SetGet currentVolumeExtended_SetGet = (CurrentVolumeExtended_SetGet)bAPEntity;
        return this.changingVolumeType == currentVolumeExtended_SetGet.changingVolumeType && this.reserve1 == currentVolumeExtended_SetGet.reserve1 && this.reserve2 == currentVolumeExtended_SetGet.reserve2 && this.genericVolume == currentVolumeExtended_SetGet.genericVolume;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "CurrentVolumeExtended_SetGet:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.changingVolumeType);
        bitStream.pushByte((byte)this.reserve1);
        bitStream.pushByte((byte)this.reserve2);
        bitStream.pushByte((byte)this.genericVolume);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.changingVolumeType = bitStream.popFrontByte();
        this.reserve1 = bitStream.popFrontByte();
        this.reserve2 = bitStream.popFrontByte();
        this.genericVolume = bitStream.popFrontByte();
    }

    public static int functionId() {
        return 47;
    }

    @Override
    public int getFunctionId() {
        return CurrentVolumeExtended_SetGet.functionId();
    }
}

