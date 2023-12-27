/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.telephone.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.ResultMethod;
import de.vw.mib.bap.stream.BitStream;

public final class CCSplit_Result
implements ResultMethod {
    public int ccsplit_Result;
    public static final int CC_SPLIT_RESULT_SUCCESSFUL;
    public static final int CC_SPLIT_RESULT_NOT_SUCCESSFUL;
    public static final int CC_SPLIT_RESULT_ABORT_SUCCESSFUL;
    public static final int CC_SPLIT_RESULT_ABORT_NOT_SUCCESSFUL;
    public static final int CC_SPLIT_RESULT_NOT_SUCCESSFUL_ADDITIONAL_CALL_ALREADY_PRESENT;
    public static final int CC_SPLIT_RESULT_NOT_SUCCESSFUL_NOT_SUPPORTED_BY_NETWORK;
    public static final int CC_SPLIT_RESULT_NOT_SUCCESSFUL_NOT_SUPPORTED_BY_MOBILE;

    @Override
    public int getResultCode() {
        return this.ccsplit_Result;
    }

    public CCSplit_Result() {
        this.internalReset();
        this.customInitialization();
    }

    public CCSplit_Result(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.ccsplit_Result = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        CCSplit_Result cCSplit_Result = (CCSplit_Result)bAPEntity;
        return this.ccsplit_Result == cCSplit_Result.ccsplit_Result;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "CCSplit_Result:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.ccsplit_Result);
    }

    @Override
    public void deserialize(BitStream bitStream) {
    }

    public static int functionId() {
        return 41;
    }

    @Override
    public int getFunctionId() {
        return CCSplit_Result.functionId();
    }
}

