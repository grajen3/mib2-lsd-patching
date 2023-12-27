/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.telephone.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.ResultMethod;
import de.vw.mib.bap.stream.BitStream;

public final class MPSetWaitingCallOnHold_Result
implements ResultMethod {
    public int mpswcoh_Result;
    public static final int MPSWCOH_RESULT_SUCCESSFUL;
    public static final int MPSWCOH_RESULT_NOT_SUCCESSFUL;
    public static final int MPSWCOH_RESULT_ABORT_SUCCESSFUL;
    public static final int MPSWCOH_RESULT_ABORT_NOT_SUCCESSFUL;
    public static final int MPSWCOH_RESULT_NOT_SUCCESSFUL_NOT_SUPPORTED_BY_NETWORK;

    @Override
    public int getResultCode() {
        return this.mpswcoh_Result;
    }

    public MPSetWaitingCallOnHold_Result() {
        this.internalReset();
        this.customInitialization();
    }

    public MPSetWaitingCallOnHold_Result(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.mpswcoh_Result = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        MPSetWaitingCallOnHold_Result mPSetWaitingCallOnHold_Result = (MPSetWaitingCallOnHold_Result)bAPEntity;
        return this.mpswcoh_Result == mPSetWaitingCallOnHold_Result.mpswcoh_Result;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "MPSetWaitingCallOnHold_Result:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.mpswcoh_Result);
    }

    @Override
    public void deserialize(BitStream bitStream) {
    }

    public static int functionId() {
        return 39;
    }

    @Override
    public int getFunctionId() {
        return MPSetWaitingCallOnHold_Result.functionId();
    }
}

