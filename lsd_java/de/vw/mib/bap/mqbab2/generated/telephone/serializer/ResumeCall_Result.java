/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.telephone.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.ResultMethod;
import de.vw.mib.bap.stream.BitStream;

public final class ResumeCall_Result
implements ResultMethod {
    public int resumeCall_Result;
    public static final int RESUME_CALL_RESULT_SUCCESSFUL;
    public static final int RESUME_CALL_RESULT_NOT_SUCCESSFUL;
    public static final int RESUME_CALL_RESULT_ABORT_SUCCESSFUL;
    public static final int RESUME_CALL_RESULT_ABORT_NOT_SUCCESSFUL;

    @Override
    public int getResultCode() {
        return this.resumeCall_Result;
    }

    public ResumeCall_Result() {
        this.internalReset();
        this.customInitialization();
    }

    public ResumeCall_Result(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.resumeCall_Result = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        ResumeCall_Result resumeCall_Result = (ResumeCall_Result)bAPEntity;
        return this.resumeCall_Result == resumeCall_Result.resumeCall_Result;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "ResumeCall_Result:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.resumeCall_Result);
    }

    @Override
    public void deserialize(BitStream bitStream) {
    }

    public static int functionId() {
        return 32;
    }

    @Override
    public int getFunctionId() {
        return ResumeCall_Result.functionId();
    }
}

