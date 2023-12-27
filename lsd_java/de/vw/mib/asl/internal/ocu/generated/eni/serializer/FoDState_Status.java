/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.generated.eni.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class FoDState_Status
implements StatusProperty {
    public int foDstate;
    public static final int FO_DSTATE_FO_D_ERROR_DETAILS_IN_EXCEPTION_STATE_0X30_0X4F;
    public static final int FO_DSTATE_REPAIR_SUCCESSFUL;
    public static final int FO_DSTATE_SEARCHING_FOR_NETWORK;
    public static final int FO_DSTATE_ACTIVATION_FAILED_DETAILS_IN_EXCEPTION_STATE_0X01_0X2F;
    public static final int FO_DSTATE_ACTIVATION_SUCCESSFUL_CLAMP_CHANGE_REQUIRED;
    public static final int FO_DSTATE_ACTIVATION_SUCCESSFUL;
    public static final int FO_DSTATE_ACTIVATION_IN_PROGRESS;
    public static final int FO_DSTATE_CHECK_PRECONDITIONS;
    public static final int FO_DSTATE_REQUEST_IN_PROGRESS_RESPONSE_PENDING;
    public static final int FO_DSTATE_CONNECTING_TO_SERVER;
    public static final int FO_DSTATE_NEW_FSC_AVAILABLE_USER_AUTHORIZATION_PENDING;
    public static final int FO_DSTATE_NEW_FSC_AVAILABLE_DOWNLOAD_CONFIRMATION_PENDING;
    public static final int FO_DSTATE_NO_INFORMATION_DEFAULT;
    public int exceptionState;
    public static final int EXCEPTION_STATE_ERROR_FRESHNESS_COUNTER;
    public static final int EXCEPTION_STATE_BAD_FRESHNESS_COUNTER_ONLINE_CONNECTION_REQUIRED_WITHIN_X_DAYS_SEE_ADDITIONAL_DATA;
    public static final int EXCEPTION_STATE_GENERAL_FO_D_ERROR;
    public static final int EXCEPTION_STATE_NOT_SUCCESSFUL_INSTALLATION_DENIED;
    public static final int EXCEPTION_STATE_NOT_SUCCESSFUL_FUNCTION_DEFECT;
    public static final int EXCEPTION_STATE_NOT_SUCCESSFUL_CLAMP15_TURNED_OFF;
    public static final int EXCEPTION_STATE_NOT_SUCCESSFUL_INSTALLATION_FAILED_RETRY_IN_NEXT_CLAMP_CYCLE;
    public static final int EXCEPTION_STATE_NOT_SUCCESSFUL_INSTALLATION_FAILED;
    public static final int EXCEPTION_STATE_NOT_SUCCESSFUL_TIMEOUT;
    public static final int EXCEPTION_STATE_NOT_SUCCESSFUL_MISC_BACKEND_ERROR;
    public static final int EXCEPTION_STATE_NOT_SUCCESSFUL_BACKEND_SERVICE_UNAVAILABLE;
    public static final int EXCEPTION_STATE_NOT_SUCCESSFUL_BACKEND_AUTHENTICATION_ERROR;
    public static final int EXCEPTION_STATE_NOT_SUCCESSFUL_NO_VERIFIED_ACCOUNT_FOUND;
    public static final int EXCEPTION_STATE_NOT_SUCCESSFUL_NO_NETWORK_CONNECTION;
    public static final int EXCEPTION_STATE_NOT_SUCCESSFUL;
    public static final int EXCEPTION_STATE_NO_ERROR_EXCEPTION;
    public int additionalData;
    public static final int ADDITIONAL_DATA_MIN;
    public int activationProgress;
    public static final int ACTIVATION_PROGRESS_MIN;

    public FoDState_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public FoDState_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.foDstate = 0;
        this.exceptionState = 0;
        this.additionalData = 0;
        this.activationProgress = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        FoDState_Status foDState_Status = (FoDState_Status)bAPEntity;
        return this.foDstate == foDState_Status.foDstate && this.exceptionState == foDState_Status.exceptionState && this.additionalData == foDState_Status.additionalData && this.activationProgress == foDState_Status.activationProgress;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "FoDState_Status:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.foDstate);
        bitStream.pushByte((byte)this.exceptionState);
        bitStream.pushByte((byte)this.additionalData);
        bitStream.pushByte((byte)this.activationProgress);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.foDstate = bitStream.popFrontByte();
        this.exceptionState = bitStream.popFrontByte();
        this.additionalData = bitStream.popFrontByte();
        this.activationProgress = bitStream.popFrontByte();
    }

    public static int functionId() {
        return 32;
    }

    @Override
    public int getFunctionId() {
        return FoDState_Status.functionId();
    }
}

