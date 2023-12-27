/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.telephone.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.ResultMethod;
import de.vw.mib.bap.stream.BitStream;

public final class MPRelActiveCallAcceptWC_Result
implements ResultMethod {
    public int mpracawc_Result;
    public static final int MPRACAWC_RESULT_SUCCESSFUL;
    public static final int MPRACAWC_RESULT_NOT_SUCCESSFUL;
    public static final int MPRACAWC_RESULT_ABORT_SUCCESSFUL;
    public static final int MPRACAWC_RESULT_ABORT_NOT_SUCCESSFUL;

    @Override
    public int getResultCode() {
        return this.mpracawc_Result;
    }

    public MPRelActiveCallAcceptWC_Result() {
        this.internalReset();
        this.customInitialization();
    }

    public MPRelActiveCallAcceptWC_Result(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.mpracawc_Result = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        MPRelActiveCallAcceptWC_Result mPRelActiveCallAcceptWC_Result = (MPRelActiveCallAcceptWC_Result)bAPEntity;
        return this.mpracawc_Result == mPRelActiveCallAcceptWC_Result.mpracawc_Result;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "MPRelActiveCallAcceptWC_Result:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.mpracawc_Result);
    }

    @Override
    public void deserialize(BitStream bitStream) {
    }

    public static int functionId() {
        return 35;
    }

    @Override
    public int getFunctionId() {
        return MPRelActiveCallAcceptWC_Result.functionId();
    }
}

