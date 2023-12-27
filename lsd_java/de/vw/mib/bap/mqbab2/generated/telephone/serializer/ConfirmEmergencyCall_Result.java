/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.telephone.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.ResultMethod;
import de.vw.mib.bap.stream.BitStream;

public final class ConfirmEmergencyCall_Result
implements ResultMethod {
    public int confirmErmergencyCall_Result;
    public static final int CONFIRM_ERMERGENCY_CALL_RESULT_SUCCESSFUL;
    public static final int CONFIRM_ERMERGENCY_CALL_RESULT_NOT_SUCCESSFUL;
    public static final int CONFIRM_ERMERGENCY_CALL_RESULT_ABORT_SUCCESSFUL;
    public static final int CONFIRM_ERMERGENCY_CALL_RESULT_ABORT_NOT_SUCCESSFUL;
    public static final int CONFIRM_ERMERGENCY_CALL_RESULT_NOT_SUCCESSFUL_NO_EMERGENCY_CALL_PENDING;

    @Override
    public int getResultCode() {
        return this.confirmErmergencyCall_Result;
    }

    public ConfirmEmergencyCall_Result() {
        this.internalReset();
        this.customInitialization();
    }

    public ConfirmEmergencyCall_Result(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.confirmErmergencyCall_Result = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        ConfirmEmergencyCall_Result confirmEmergencyCall_Result = (ConfirmEmergencyCall_Result)bAPEntity;
        return this.confirmErmergencyCall_Result == confirmEmergencyCall_Result.confirmErmergencyCall_Result;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "ConfirmEmergencyCall_Result:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.confirmErmergencyCall_Result);
    }

    @Override
    public void deserialize(BitStream bitStream) {
    }

    public static int functionId() {
        return 28;
    }

    @Override
    public int getFunctionId() {
        return ConfirmEmergencyCall_Result.functionId();
    }
}

