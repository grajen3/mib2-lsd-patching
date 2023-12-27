/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.generated.ecall.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.ResultMethod;
import de.vw.mib.bap.stream.BitStream;

public final class ServiceControl_Result
implements ResultMethod {
    public int controlResult;
    public static final int CONTROL_RESULT_NOT_SUCCESSFUL_NO_SERVICE_PENDING;
    public static final int CONTROL_RESULT_ABORT_NOT_SUCCESSFUL;
    public static final int CONTROL_RESULT_ABORT_SUCCESSFUL;
    public static final int CONTROL_RESULT_NOT_SUCCESSFUL;
    public static final int CONTROL_RESULT_SUCCESSFUL;

    public ServiceControl_Result() {
        this.internalReset();
        this.customInitialization();
    }

    public ServiceControl_Result(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.controlResult = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        ServiceControl_Result serviceControl_Result = (ServiceControl_Result)bAPEntity;
        return this.controlResult == serviceControl_Result.controlResult;
    }

    private void customInitialization() {
    }

    @Override
    public int getResultCode() {
        return this.controlResult;
    }

    @Override
    public String toString() {
        return "ServiceControl_Result:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.controlResult);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.controlResult = bitStream.popFrontByte();
    }

    public static int functionId() {
        return 25;
    }

    @Override
    public int getFunctionId() {
        return ServiceControl_Result.functionId();
    }
}

