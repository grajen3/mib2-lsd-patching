/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.telephone.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.ResultMethod;
import de.vw.mib.bap.stream.BitStream;

public final class CallHold_Result
implements ResultMethod {
    public int callHold_Result;
    public static final int CALL_HOLD_RESULT_SUCCESSFUL;
    public static final int CALL_HOLD_RESULT_NOT_SUCCESSFUL;
    public static final int CALL_HOLD_RESULT_ABORT_SUCCESSFUL;
    public static final int CALL_HOLD_RESULT_ABORT_NOT_SUCCESSFUL;
    public static final int CALL_HOLD_RESULT_NOT_SUCCESSFUL_NOT_SUPPORTED_BY_NETWORK;

    @Override
    public int getResultCode() {
        return this.callHold_Result;
    }

    public CallHold_Result() {
        this.internalReset();
        this.customInitialization();
    }

    public CallHold_Result(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.callHold_Result = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        CallHold_Result callHold_Result = (CallHold_Result)bAPEntity;
        return this.callHold_Result == callHold_Result.callHold_Result;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "CallHold_Result:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.callHold_Result);
    }

    @Override
    public void deserialize(BitStream bitStream) {
    }

    public static int functionId() {
        return 31;
    }

    @Override
    public int getFunctionId() {
        return CallHold_Result.functionId();
    }
}

