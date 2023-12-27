/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.telephone.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.ResultMethod;
import de.vw.mib.bap.stream.BitStream;

public final class DialNumber_Result
implements ResultMethod {
    public int dialNumber_Result;
    public static final int DIAL_NUMBER_RESULT_SUCCESSFUL;
    public static final int DIAL_NUMBER_RESULT_NOT_SUCCESSFUL;
    public static final int DIAL_NUMBER_RESULT_ABORT_SUCCESSFUL;
    public static final int DIAL_NUMBER_RESULT_ABORT_NOT_SUCCESSFUL;
    public static final int DIAL_NUMBER_RESULT_NOT_SUCCESSFUL_NUMBER_INVALID;
    public static final int DIAL_NUMBER_RESULT_NOT_SUCCESSFUL_NO_NETWORK;
    public static final int DIAL_NUMBER_RESULT_NOT_SUCCESSFUL_CONFIRM_EMERGENCY_CALL;
    public static final int DIAL_NUMBER_RESULT_NOT_SUCCESSFUL_AUTOMATIC_REDIAL_ACTIVE;

    @Override
    public int getResultCode() {
        return this.dialNumber_Result;
    }

    public DialNumber_Result() {
        this.internalReset();
        this.customInitialization();
    }

    public DialNumber_Result(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.dialNumber_Result = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        DialNumber_Result dialNumber_Result = (DialNumber_Result)bAPEntity;
        return this.dialNumber_Result == dialNumber_Result.dialNumber_Result;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "DialNumber_Result:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.dialNumber_Result);
    }

    @Override
    public void deserialize(BitStream bitStream) {
    }

    public static int functionId() {
        return 26;
    }

    @Override
    public int getFunctionId() {
        return DialNumber_Result.functionId();
    }
}

