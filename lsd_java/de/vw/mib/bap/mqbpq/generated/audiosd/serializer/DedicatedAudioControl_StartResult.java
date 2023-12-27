/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbpq.generated.audiosd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.StartResultMethod;
import de.vw.mib.bap.stream.BitStream;

public final class DedicatedAudioControl_StartResult
implements StartResultMethod {
    public int controlType;
    public static final int CONTROL_TYPE_SELECT_LIST_ENTRY;
    public static final int CONTROL_TYPE_NEXT;
    public static final int CONTROL_TYPE_PREVIOUS;
    public static final int CONTROL_TYPE_FAST_FORWARD;
    public static final int CONTROL_TYPE_FAST_BACKWARD_REWIND;
    public static final int CONTROL_TYPE_CHANNEL_UP;
    public static final int CONTROL_TYPE_CHANNEL_DOWN;
    public int additionalControlInformation;

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
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        DedicatedAudioControl_StartResult dedicatedAudioControl_StartResult = (DedicatedAudioControl_StartResult)bAPEntity;
        return this.controlType == dedicatedAudioControl_StartResult.controlType && this.additionalControlInformation == dedicatedAudioControl_StartResult.additionalControlInformation;
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
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.controlType = bitStream.popFrontByte();
        this.additionalControlInformation = bitStream.popFrontShort();
    }

    public static int functionId() {
        return 23;
    }

    @Override
    public int getFunctionId() {
        return DedicatedAudioControl_StartResult.functionId();
    }
}

