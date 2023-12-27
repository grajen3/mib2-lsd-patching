/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.generated.ecall.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.StartResultMethod;
import de.vw.mib.bap.stream.BitStream;

public final class HangupCall_StartResult
implements StartResultMethod {
    public int callId;
    public static final int CALL_ID_ALL_CALLS;
    public static final int CALL_ID_ALL_ACTIVE_HELD_CALLS;
    public static final int CALL_ID_ALL_HELD_CALLS;
    public static final int CALL_ID_ALL_ACTIVE_CALLS;
    public static final int CALL_ID_CALL6;
    public static final int CALL_ID_CALL5;
    public static final int CALL_ID_CALL4;
    public static final int CALL_ID_CALL3;
    public static final int CALL_ID_CALL2;
    public static final int CALL_ID_CALL1;
    public static final int CALL_ID_CALL0;

    public HangupCall_StartResult() {
        this.internalReset();
        this.customInitialization();
    }

    public HangupCall_StartResult(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.callId = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        HangupCall_StartResult hangupCall_StartResult = (HangupCall_StartResult)bAPEntity;
        return this.callId == hangupCall_StartResult.callId;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "HangupCall_StartResult:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.callId);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.callId = bitStream.popFrontByte();
    }

    public static int functionId() {
        return 18;
    }

    @Override
    public int getFunctionId() {
        return HangupCall_StartResult.functionId();
    }
}

