/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.generated.ecall.serializer;

import de.vw.mib.asl.internal.ocu.generated.ecall.serializer.ServiceState_DataTransmissionState;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class ServiceState_Status
implements StatusProperty {
    public int serviceType;
    public static final int SERVICE_TYPE_MEC_LEGAL_DF3_7;
    public static final int SERVICE_TYPE_ACN_LEGAL_DF3_7;
    public static final int SERVICE_TYPE_TEST_MODE_DF3_4;
    public static final int SERVICE_TYPE_MEC;
    public static final int SERVICE_TYPE_ACN;
    public static final int SERVICE_TYPE_INFO_CALL;
    public static final int SERVICE_TYPE_USM;
    public static final int SERVICE_TYPE_SERVICE_BREAKDOWN_CALL;
    public static final int SERVICE_TYPE_IDLE;
    public int serviceState;
    public static final int SERVICE_STATE_VOICE_CALL_PRESENT_SENDING_DATA_DF3_7;
    public static final int SERVICE_STATE_SERVICE_NOT_STARTED_DUE_TO_NETWORK_ERROR_DF3_6;
    public static final int SERVICE_STATE_SERVICE_DISABLED_BY_DRIVER_DF3_5;
    public static final int SERVICE_STATE_REDIAL_FAILED_CALLBACK_PENDING_DF3_4;
    public static final int SERVICE_STATE_CALL_SETUP_FAILED_REDIAL_PENDING_DF3_4;
    public static final int SERVICE_STATE_VOICE_CALL_TERMINATED_DF3_4;
    public static final int SERVICE_STATE_TEST_MODE_ACTIVE_DF3_4;
    public static final int SERVICE_STATE_SERVICE_NOT_STARTED_TIMEOUT_DF3_4;
    public static final int SERVICE_STATE_SERVICE_NOT_STARTED_DENIED_BY_USER;
    public static final int SERVICE_STATE_SERVICE_NOT_LICENSED;
    public static final int SERVICE_STATE_SERVICE_TERMINATED_WITH_BY_ERROR;
    public static final int SERVICE_STATE_SERVICE_TERMINATED_WITH_BY_ERROR_WAITING_FOR_DATA_RECEIVED_CONFIRMATION;
    public static final int SERVICE_STATE_SERVICE_TERMINATED_REGULARLY;
    public static final int SERVICE_STATE_SERVICE_TERMINATED_BY_USER;
    public static final int SERVICE_STATE_SENDING_DATA_VIA_INBAND_MODEM;
    public static final int SERVICE_STATE_VOICE_CALL_TERMINATED_REDIAL_PENDING;
    public static final int SERVICE_STATE_VOICE_CALL_PRESENT;
    public static final int SERVICE_STATE_VOICE_CALL_PENDING;
    public static final int SERVICE_STATE_DISCONNECTING_FROM_SERVER;
    public static final int SERVICE_STATE_SENDING_DATA_VIA_IP_CONNECTION;
    public static final int SERVICE_STATE_CONNECTING_TO_SERVER;
    public static final int SERVICE_STATE_COLLECTING_DATA;
    public static final int SERVICE_STATE_IDLE;
    public ServiceState_DataTransmissionState dataTransmissionState = new ServiceState_DataTransmissionState();

    public ServiceState_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public ServiceState_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.serviceType = 0;
        this.serviceState = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
        this.dataTransmissionState.reset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        ServiceState_Status serviceState_Status = (ServiceState_Status)bAPEntity;
        return this.serviceType == serviceState_Status.serviceType && this.serviceState == serviceState_Status.serviceState && this.dataTransmissionState.equalTo(serviceState_Status.dataTransmissionState);
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "ServiceState_Status:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.serviceType);
        bitStream.pushByte((byte)this.serviceState);
        this.dataTransmissionState.serialize(bitStream);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.serviceType = bitStream.popFrontByte();
        this.serviceState = bitStream.popFrontByte();
        this.dataTransmissionState.deserialize(bitStream);
    }

    public static int functionId() {
        return 26;
    }

    @Override
    public int getFunctionId() {
        return ServiceState_Status.functionId();
    }
}

