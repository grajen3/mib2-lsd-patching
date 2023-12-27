/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.telephone.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.ResultMethod;
import de.vw.mib.bap.stream.BitStream;

public final class CCJoin_Result
implements ResultMethod {
    public int ccjoin_Result;
    public static final int CC_JOIN_RESULT_SUCCESSFUL;
    public static final int CC_JOIN_RESULT_NOT_SUCCESSFUL;
    public static final int CC_JOIN_RESULT_ABORT_SUCCESSFUL;
    public static final int CC_JOIN_RESULT_ABORT_NOT_SUCCESSFUL;
    public static final int CC_JOIN_RESULT_NOT_SUCCESSFUL_NOT_SUPPORTED_BY_NETWORK;
    public static final int CC_JOIN_RESULT_NOT_SUCCESSFUL_MAXIMUM_NUMBER_OF_MEMBERS_OF_CONFERENCE_REACHED;

    @Override
    public int getResultCode() {
        return this.ccjoin_Result;
    }

    public CCJoin_Result() {
        this.internalReset();
        this.customInitialization();
    }

    public CCJoin_Result(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.ccjoin_Result = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        CCJoin_Result cCJoin_Result = (CCJoin_Result)bAPEntity;
        return this.ccjoin_Result == cCJoin_Result.ccjoin_Result;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "CCJoin_Result:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.ccjoin_Result);
    }

    @Override
    public void deserialize(BitStream bitStream) {
    }

    public static int functionId() {
        return 40;
    }

    @Override
    public int getFunctionId() {
        return CCJoin_Result.functionId();
    }
}

