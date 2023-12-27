/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.audiosd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class SDS_State_Status
implements StatusProperty {
    public int state;
    public static final int STATE_SDS_PRESENTATION_IS_ACTIVE_IN_FSG_DF4_5;
    public static final int STATE_SDS_CLOUD_IS_BEING_LOADED_DF4_5;
    public static final int STATE_SDS_SYSTEM_IS_BEING_LOADED_DF4_5;
    public static final int STATE_EXTERNAL_SDS_ACTIVE_DF4_1;
    public static final int STATE_SDS_TEMPORARY_NOT_AVAILABLE;
    public static final int STATE_SDS_NOT_AVAILABLE_DUE_TO_ACTIVE_RVC_APS_OPS;
    public static final int STATE_SDS_DOWNLOAD_UNSUCCESSFUL;
    public static final int STATE_SDS_LANGUAGE_IS_BEEING_LOADED;
    public static final int STATE_SDS_DESIRED_LANGUAGE_NOT_AVAILABLE;
    public static final int STATE_SDS_NOT_BUIT_IN_ACTIVE;
    public static final int STATE_SDS_PAUSE_VOICE_RECOGNITION_IS_PAUSED;
    public static final int STATE_SDS_DEACTIVATED_VOICE_RECOGNITION_NOT_ACTIVE;
    public static final int STATE_SDS_NOT_READY;
    public static final int STATE_SDS_ACTIVE_RECOGNIZER_CLOSED_SPEECH_DIALOG_SYSTEM_IS_ACTIVE_VOICE_RECOGNITION_IS_ACTIVE;
    public static final int STATE_SDS_ACTIVE_RECOGNIZER_OPEN_SPEECH_DIALOG_SYSTEM_IS_ACTIVE_VOICE_RECOGNITION_IS_ACTIVE;
    public static final int STATE_SDS_INITIALISING_ACTIVE;
    public static final int STATE_SDS_INITIALISING_SDS_IS_BEING_INITIALISED;
    public static final int STATE_SDS_NOT_BUILT_IN;

    public SDS_State_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public SDS_State_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.state = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        SDS_State_Status sDS_State_Status = (SDS_State_Status)bAPEntity;
        return this.state == sDS_State_Status.state;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "SDS_State_Status:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.state);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.state = bitStream.popFrontByte();
    }

    public static int functionId() {
        return 41;
    }

    @Override
    public int getFunctionId() {
        return SDS_State_Status.functionId();
    }
}

