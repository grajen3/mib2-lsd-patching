/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.audiosd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.StartResultMethod;
import de.vw.mib.bap.stream.BitStream;

public final class DedicatedAudioControl_StartResult
implements StartResultMethod {
    public int controlType;
    public static final int CONTROL_TYPE_CANCEL_SEEK_SCAN;
    public static final int CONTROL_TYPE_CANCEL_STATION_LIST_UPDATE;
    public static final int CONTROL_TYPE_UPDATE_STATION_LIST_RELATED_TO_ACTIVE_BAND;
    public static final int CONTROL_TYPE_FAST_BACKWARD_REWIND;
    public static final int CONTROL_TYPE_FAST_FORWARD;
    public static final int CONTROL_TYPE_PREVIOUS;
    public static final int CONTROL_TYPE_NEXT;
    public static final int CONTROL_TYPE_SELECT_LIST_ENTRY;
    public int additionalControlInformation;
    public static final int ADDITIONAL_CONTROL_INFORMATION_MIN;
    public int listType;
    public static final int LIST_TYPE_LAST_STATION_LIST_DF4_5;
    public static final int LIST_TYPE_SIRIUS_ALERT_LIST_DF4_5;
    public static final int LIST_TYPE_TP_MEMO_LIST;
    public static final int LIST_TYPE_MEDIA_BROWSER;
    public static final int LIST_TYPE_RADIO_TV_PRESET_LIST;
    public static final int LIST_TYPE_RECEPTION_LIST;
    public static final int LIST_TYPE_NO_LIST;

    public DedicatedAudioControl_StartResult() {
        this.internalReset();
        this.customInitialization();
    }

    public DedicatedAudioControl_StartResult(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.controlType = 0;
        this.additionalControlInformation = 0;
        this.listType = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        DedicatedAudioControl_StartResult dedicatedAudioControl_StartResult = (DedicatedAudioControl_StartResult)bAPEntity;
        return this.controlType == dedicatedAudioControl_StartResult.controlType && this.additionalControlInformation == dedicatedAudioControl_StartResult.additionalControlInformation && this.listType == dedicatedAudioControl_StartResult.listType;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "DedicatedAudioControl_StartResult:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.controlType);
        bitStream.pushShort((short)this.additionalControlInformation);
        bitStream.pushByte((byte)this.listType);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.controlType = bitStream.popFrontByte();
        this.additionalControlInformation = bitStream.popFrontShort();
        this.listType = bitStream.popFrontByte();
    }

    public static int functionId() {
        return 24;
    }

    @Override
    public int getFunctionId() {
        return DedicatedAudioControl_StartResult.functionId();
    }
}

