/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.generated.ecall.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.StartResultMethod;
import de.vw.mib.bap.stream.BitStream;

public final class ServiceControl_StartResult
implements StartResultMethod {
    public int serviceType;
    public static final int SERVICE_TYPE_ALL_SERVICES;
    public static final int SERVICE_TYPE_TEST_MODE_DF3_4;
    public static final int SERVICE_TYPE_MEC;
    public static final int SERVICE_TYPE_ACN;
    public static final int SERVICE_TYPE_INFO_CALL;
    public static final int SERVICE_TYPE_USM;
    public static final int SERVICE_TYPE_SERVICE_BREAKDOWN_CALL;
    public static final int SERVICE_TYPE_DEFAULT_IN_CASE_OF_CANCLE_ABORT;
    public int controlCode;
    public static final int CONTROL_CODE_TRIGGER_SERVICE_BY_ASG_DF3_3;
    public static final int CONTROL_CODE_TERMINATE_IF_NOT_PENDING_ANYMORE;
    public static final int CONTROL_CODE_DENY_IN_CASE_OF_CONFIRMATION_PENDING;
    public static final int CONTROL_CODE_CONFIRM;

    public ServiceControl_StartResult() {
        this.internalReset();
        this.customInitialization();
    }

    public ServiceControl_StartResult(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.serviceType = 0;
        this.controlCode = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        ServiceControl_StartResult serviceControl_StartResult = (ServiceControl_StartResult)bAPEntity;
        return this.serviceType == serviceControl_StartResult.serviceType && this.controlCode == serviceControl_StartResult.controlCode;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "ServiceControl_StartResult:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.serviceType);
        bitStream.pushByte((byte)this.controlCode);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.serviceType = bitStream.popFrontByte();
        this.controlCode = bitStream.popFrontByte();
    }

    public static int functionId() {
        return 25;
    }

    @Override
    public int getFunctionId() {
        return ServiceControl_StartResult.functionId();
    }
}

