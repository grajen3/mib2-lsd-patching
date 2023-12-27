/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.generated.ecall.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.ResultMethod;
import de.vw.mib.bap.stream.BitStream;

public final class AcceptCall_Result
implements ResultMethod {
    public int acceptCall_Result;
    public static final int ACCEPT_CALL_RESULT_ABORT_NOT_SUCCESSFUL;
    public static final int ACCEPT_CALL_RESULT_ABORT_SUCCESSFUL;
    public static final int ACCEPT_CALL_RESULT_NOT_SUCCESSFUL;
    public static final int ACCEPT_CALL_RESULT_SUCCESSFUL;

    public AcceptCall_Result() {
        this.internalReset();
        this.customInitialization();
    }

    public AcceptCall_Result(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.acceptCall_Result = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        AcceptCall_Result acceptCall_Result = (AcceptCall_Result)bAPEntity;
        return this.acceptCall_Result == acceptCall_Result.acceptCall_Result;
    }

    private void customInitialization() {
    }

    @Override
    public int getResultCode() {
        return this.acceptCall_Result;
    }

    @Override
    public String toString() {
        return "AcceptCall_Result:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.acceptCall_Result);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.acceptCall_Result = bitStream.popFrontByte();
    }

    public static int functionId() {
        return 19;
    }

    @Override
    public int getFunctionId() {
        return AcceptCall_Result.functionId();
    }
}

