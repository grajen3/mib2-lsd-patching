/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.telephone.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.ResultMethod;
import de.vw.mib.bap.stream.BitStream;

public final class HangupCall_Result
implements ResultMethod {
    public int hangupCall_Result;
    public static final int HANGUP_CALL_RESULT_SUCCESSFUL;
    public static final int HANGUP_CALL_RESULT_NOT_SUCCESSFUL;
    public static final int HANGUP_CALL_RESULT_ABORT_SUCCESSFUL;
    public static final int HANGUP_CALL_RESULT_ABORT_NOT_SUCCESSFUL;

    @Override
    public int getResultCode() {
        return this.hangupCall_Result;
    }

    public HangupCall_Result() {
        this.internalReset();
        this.customInitialization();
    }

    public HangupCall_Result(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.hangupCall_Result = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        HangupCall_Result hangupCall_Result = (HangupCall_Result)bAPEntity;
        return this.hangupCall_Result == hangupCall_Result.hangupCall_Result;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "HangupCall_Result:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.hangupCall_Result);
    }

    @Override
    public void deserialize(BitStream bitStream) {
    }

    public static int functionId() {
        return 29;
    }

    @Override
    public int getFunctionId() {
        return HangupCall_Result.functionId();
    }
}

