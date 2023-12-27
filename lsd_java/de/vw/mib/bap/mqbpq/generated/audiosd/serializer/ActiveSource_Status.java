/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbpq.generated.audiosd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.mqbpq.generated.audiosd.serializer.ActiveSource_Status$ListAvailable;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class ActiveSource_Status
implements StatusProperty {
    public int audioSource;
    public static final int AUDIO_SOURCE_NO_SOURCE_ACTIVE;
    public static final int AUDIO_SOURCE_FM;
    public static final int AUDIO_SOURCE_AM;
    public static final int AUDIO_SOURCE_DAB;
    public static final int AUDIO_SOURCE_SDARS_XM;
    public static final int AUDIO_SOURCE_SDARS_SIRIUS;
    public static final int AUDIO_SOURCE_CD;
    public static final int AUDIO_SOURCE_CD_CHANGER;
    public static final int AUDIO_SOURCE_DVD;
    public static final int AUDIO_SOURCE_TV;
    public static final int AUDIO_SOURCE_HDD;
    public static final int AUDIO_SOURCE_SD;
    public static final int AUDIO_SOURCE_TP_MEMO;
    public static final int AUDIO_SOURCE_TIM;
    public static final int AUDIO_SOURCE_AUX_IN;
    public static final int AUDIO_SOURCE_PORTABLE_DEVICE_MDI;
    public static final int AUDIO_SOURCE_GENERIC_PLAYER;
    public static final int AUDIO_SOURCE_PHONE;
    public static final int AUDIO_SOURCE_PHONE_INCOMING_CALL;
    public static final int AUDIO_SOURCE_AM_TI_SINCE_V1_03_DF3_1;
    public static final int AUDIO_SOURCE_UNKNOWN_SOURCE;
    public final ActiveSource_Status$ListAvailable listAvailable = new ActiveSource_Status$ListAvailable();
    public int number;
    public int channelId;

    public ActiveSource_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public ActiveSource_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.audioSource = 0;
        this.number = 0;
        this.channelId = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
        this.listAvailable.reset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        ActiveSource_Status activeSource_Status = (ActiveSource_Status)bAPEntity;
        return this.audioSource == activeSource_Status.audioSource && this.listAvailable.equalTo(activeSource_Status.listAvailable) && this.number == activeSource_Status.number && this.channelId == activeSource_Status.channelId;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "ActiveSource_Status:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.audioSource);
        this.listAvailable.serialize(bitStream);
        bitStream.pushByte((byte)this.number);
        bitStream.pushByte((byte)this.channelId);
    }

    @Override
    public void deserialize(BitStream bitStream) {
    }

    public static int functionId() {
        return 16;
    }

    @Override
    public int getFunctionId() {
        return ActiveSource_Status.functionId();
    }
}

