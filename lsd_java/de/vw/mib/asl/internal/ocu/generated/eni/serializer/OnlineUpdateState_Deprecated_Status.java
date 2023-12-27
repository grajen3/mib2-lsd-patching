/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.generated.eni.serializer;

import de.vw.mib.asl.internal.ocu.generated.eni.serializer.OnlineUpdateState_Deprecated_DownloadSize;
import de.vw.mib.asl.internal.ocu.generated.eni.serializer.OnlineUpdateState_Deprecated_UpdateDomain;
import de.vw.mib.asl.internal.ocu.generated.eni.serializer.OnlineUpdateState_Deprecated_UpdateInfo;
import de.vw.mib.asl.internal.ocu.generated.eni.serializer.OnlineUpdateState_Deprecated_UpdatePreconditions;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.datatypes.BAPString;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class OnlineUpdateState_Deprecated_Status
implements StatusProperty {
    public int updateState;
    public static final int UPDATE_STATE_UPDATE_WITHDRAWN_PROCESS_CANCELLED_CONFIRMATION_REQUIRED_DF3_6;
    public static final int UPDATE_STATE_ECU_UPDATE_CONFIRMATION_FAILED_DETAILS_IN_EXCEPTION_STATE_DF3_5;
    public static final int UPDATE_STATE_CONNECTING_TO_SERVER_DF3_5;
    public static final int UPDATE_STATE_ONLINE_UPDATE_AVAILABLE_USER_AUTHORIZATION_PENDING_DF3_5;
    public static final int UPDATE_STATE_ONLINE_UPDATE_AVAILABLE_NEW_LANGUAGE_DF3_5;
    public static final int UPDATE_STATE_LANGUAGE_REQUEST_IN_PROGRESS_DF3_5;
    public static final int UPDATE_STATE_UPDATE_WITHDRAWN_PROCESS_CANCELED;
    public static final int UPDATE_STATE_USER_AUTHORIZATION_APPROVED;
    public static final int UPDATE_STATE_USER_AUTHORIZATION_FAILED_DETAILS_IN_EXCEPTION_STATE;
    public static final int UPDATE_STATE_USER_AUTHORIZATION_PENDING;
    public static final int UPDATE_STATE_ECU_UPDATE_FINISHED_SUCCESSFULLY;
    public static final int UPDATE_STATE_ECU_UPDATE_FAILED_DETAILS_IN_EXCEPTION_STATE;
    public static final int UPDATE_STATE_ECU_UPDATE_IN_PROGRESS;
    public static final int UPDATE_STATE_ECU_UPDATE_CONFIRMED;
    public static final int UPDATE_STATE_ECU_UPDATE_POSTPONED;
    public static final int UPDATE_STATE_ECU_UPDATE_REJECTED;
    public static final int UPDATE_STATE_DOWNLOAD_FINISHED_ECU_UPDATE_CONFIRMATION_PENDING;
    public static final int UPDATE_STATE_DOWNLOAD_TERMINATED_BY_ERROR_DETAILS_IN_EXCEPTION_STATE;
    public static final int UPDATE_STATE_DOWNLOAD_FINISHED_SUCCESSFULLY;
    public static final int UPDATE_STATE_ONLINE_UPDATE_CONFIRMED_DOWNLOAD_IN_PROGRESS;
    public static final int UPDATE_STATE_ONLINE_UPDATE_CONFIRMED_DOWNLOAD_PENDING;
    public static final int UPDATE_STATE_ONLINE_UPDATE_POSTPONED;
    public static final int UPDATE_STATE_ONLINE_UPDATE_REJECTED;
    public static final int UPDATE_STATE_ONLINE_UPDATE_AVAILABLE_DOWNLOAD_CONFIRMATION_PENDING;
    public static final int UPDATE_STATE_NO_UPDATE_ACTIVE_DEFAULT_DURING_NORMAL_OPERATION;
    public static final int UPDATE_STATE_NO_INFORMATION_DEFAULT_DURING_STARTUP;
    public final BAPString updateId = new BAPString(21);
    private static final int MAX_UPDATEID_LENGTH;
    public OnlineUpdateState_Deprecated_UpdateDomain updateDomain = new OnlineUpdateState_Deprecated_UpdateDomain();
    public OnlineUpdateState_Deprecated_UpdateInfo updateInfo = new OnlineUpdateState_Deprecated_UpdateInfo();
    public OnlineUpdateState_Deprecated_DownloadSize downloadSize = new OnlineUpdateState_Deprecated_DownloadSize();
    public OnlineUpdateState_Deprecated_UpdatePreconditions updatePreconditions = new OnlineUpdateState_Deprecated_UpdatePreconditions();
    public final BAPString startTime = new BAPString(18);
    private static final int MAX_STARTTIME_LENGTH;
    public int updateProgress;
    public static final int UPDATE_PROGRESS_MIN;
    public int exceptionState;
    public static final int EXCEPTION_STATE_FATAL_UPDATE_FAILURE_CONFIRMATION_REQUIRED_DF3_6;
    public static final int EXCEPTION_STATE_UPDATE_FAILURE_CONFIRMATION_REQUIRED_DF3_6;
    public static final int EXCEPTION_STATE_ECU_UPDATE_PRECONDITION_NOT_FULFILLED_DF3_5;
    public static final int EXCEPTION_STATE_WRONG_PIN_9_REMAINING;
    public static final int EXCEPTION_STATE_WRONG_PIN_8_REMAINING;
    public static final int EXCEPTION_STATE_WRONG_PIN_7_REMAINING;
    public static final int EXCEPTION_STATE_WRONG_PIN_6_REMAINING;
    public static final int EXCEPTION_STATE_WRONG_PIN_5_REMAINING;
    public static final int EXCEPTION_STATE_WRONG_PIN_4_REMAINING;
    public static final int EXCEPTION_STATE_WRONG_PIN_3_REMAINING;
    public static final int EXCEPTION_STATE_WRONG_PIN_2_REMAINING;
    public static final int EXCEPTION_STATE_WRONG_PIN_1_REMAINING;
    public static final int EXCEPTION_STATE_WRONG_PIN_0_REMAINING;
    public static final int EXCEPTION_STATE_WRONG_PIN_GENERAL;
    public static final int EXCEPTION_STATE_NOT_SUCCESSFUL_TIMEOUT;
    public static final int EXCEPTION_STATE_NOT_SUCCESSFUL_MISC_BACKEND_ERROR;
    public static final int EXCEPTION_STATE_NOT_SUCCESSFUL_BACKEND_SERVICE_UNAVAILABLE;
    public static final int EXCEPTION_STATE_NOT_SUCCESSFUL_BACKEND_AUTHENTICATION_ERROR;
    public static final int EXCEPTION_STATE_NOT_SUCCESSFUL_NO_VERIFIED_ACCOUNT_FOUND;
    public static final int EXCEPTION_STATE_NOT_SUCCESSFUL_NO_NETWORK_CONNECTION;
    public static final int EXCEPTION_STATE_NOT_SUCCESSFUL_PARAMETER_MISMATCH;
    public static final int EXCEPTION_STATE_NOT_SUCCESSFUL_USED_CODE_TYPE_NOT_SUPPORTED_BY_BACK_END;
    public static final int EXCEPTION_STATE_NOT_SUCCESSFUL;
    public static final int EXCEPTION_STATE_NO_ERROR_EXCEPTION;

    public OnlineUpdateState_Deprecated_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public OnlineUpdateState_Deprecated_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.updateState = 0;
        this.updateProgress = 0;
        this.exceptionState = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
        this.updateId.reset();
        this.updateDomain.reset();
        this.updateInfo.reset();
        this.downloadSize.reset();
        this.updatePreconditions.reset();
        this.startTime.reset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        OnlineUpdateState_Deprecated_Status onlineUpdateState_Deprecated_Status = (OnlineUpdateState_Deprecated_Status)bAPEntity;
        return this.updateState == onlineUpdateState_Deprecated_Status.updateState && this.updateId.equalTo(onlineUpdateState_Deprecated_Status.updateId) && this.updateDomain.equalTo(onlineUpdateState_Deprecated_Status.updateDomain) && this.updateInfo.equalTo(onlineUpdateState_Deprecated_Status.updateInfo) && this.downloadSize.equalTo(onlineUpdateState_Deprecated_Status.downloadSize) && this.updatePreconditions.equalTo(onlineUpdateState_Deprecated_Status.updatePreconditions) && this.startTime.equalTo(onlineUpdateState_Deprecated_Status.startTime) && this.updateProgress == onlineUpdateState_Deprecated_Status.updateProgress && this.exceptionState == onlineUpdateState_Deprecated_Status.exceptionState;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "OnlineUpdateState_Deprecated_Status:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.updateState);
        this.updateId.serialize(bitStream);
        this.updateDomain.serialize(bitStream);
        this.updateInfo.serialize(bitStream);
        this.downloadSize.serialize(bitStream);
        this.updatePreconditions.serialize(bitStream);
        this.startTime.serialize(bitStream);
        bitStream.pushByte((byte)this.updateProgress);
        bitStream.pushByte((byte)this.exceptionState);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.updateState = bitStream.popFrontByte();
        this.updateId.deserialize(bitStream);
        this.updateDomain.deserialize(bitStream);
        this.updateInfo.deserialize(bitStream);
        this.downloadSize.deserialize(bitStream);
        this.updatePreconditions.deserialize(bitStream);
        this.startTime.deserialize(bitStream);
        this.updateProgress = bitStream.popFrontByte();
        this.exceptionState = bitStream.popFrontByte();
    }

    public static int functionId() {
        return 28;
    }

    @Override
    public int getFunctionId() {
        return OnlineUpdateState_Deprecated_Status.functionId();
    }
}

