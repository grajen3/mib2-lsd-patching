/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.telephone.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.ResultMethod;
import de.vw.mib.bap.stream.BitStream;

public final class DialService_Result
implements ResultMethod {
    public int dialService_Result;
    public static final int DIAL_SERVICE_RESULT_SUCCESSFUL;
    public static final int DIAL_SERVICE_RESULT_NOT_SUCCESSFUL;
    public static final int DIAL_SERVICE_RESULT_ABORT_SUCCESSFUL;
    public static final int DIAL_SERVICE_RESULT_ABORT_NOT_SUCCESSFUL;
    public static final int DIAL_SERVICE_RESULT_NOT_SUCCESSFUL_SERVICE_NOT_AVAILABLE;
    public static final int DIAL_SERVICE_RESULT_NOT_SUCCESSFUL_NO_NETWORK;
    public static final int DIAL_SERVICE_RESULT_NOT_SUCCESSFUL_NOT_SUPPORTED_BY_NETWORK;
    public static final int DIAL_SERVICE_RESULT_NOT_SUCCESSFUL_NOT_SUPPORTED_BY_MOBILE;
    public static final int DIAL_SERVICE_RESULT_NOT_SUCCESSFUL_CONFIRM_EMERGENCY_CALL;
    public static final int DIAL_SERVICE_RESULT_NOT_SUCCESSFUL_AUTOMATIC_REDIAL_ACTIVE;

    @Override
    public int getResultCode() {
        return this.dialService_Result;
    }

    public DialService_Result() {
        this.internalReset();
        this.customInitialization();
    }

    public DialService_Result(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.dialService_Result = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        DialService_Result dialService_Result = (DialService_Result)bAPEntity;
        return this.dialService_Result == dialService_Result.dialService_Result;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "DialService_Result:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.dialService_Result);
    }

    @Override
    public void deserialize(BitStream bitStream) {
    }

    public static int functionId() {
        return 27;
    }

    @Override
    public int getFunctionId() {
        return DialService_Result.functionId();
    }
}

