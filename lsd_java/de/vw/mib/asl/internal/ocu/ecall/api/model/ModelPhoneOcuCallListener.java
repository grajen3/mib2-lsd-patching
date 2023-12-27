/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.ecall.api.model;

public interface ModelPhoneOcuCallListener {
    public static final int OCU_CALL_TYPE_NONE_ACTIVE;
    public static final int OCU_CALL_TYPE_MEC;
    public static final int OCU_CALL_TYPE_INFO;
    public static final int OCU_CALL_TYPE_SERVICE;
    public static final int OCU_CALL_TYPE_ACN;
    public static final int OCU_CALL_STATE_IDLE;
    public static final int OCU_CALL_STATE_DIALING;
    public static final int OCU_CALL_STATE_ALERTING;
    public static final int OCU_CALL_STATE_ICOMING;
    public static final int OCU_CALL_STATE_INCOMING_ON_HOLD;
    public static final int OCU_CALL_STATE_ACTIVE;
    public static final int OCU_CALL_STATE_DISCONNECTING;
    public static final int OCU_CALL_STATE_HOLD;
    public static final int OCU_SERVICE_TYPE_IDLE_NONE;
    public static final int OCU_SERVICE_TYPE_BREAKDOWN_CALL;
    public static final int OCU_SERVICE_TYPE_INFO_CALL;
    public static final int OCU_SERVICE_TYPE_ACN_CALL;
    public static final int OCU_SERVICE_TYPE_MEC_CALL;
    public static final int OCU_SERVICE_STATE_IDLE;
    public static final int OCU_SERVICE_STATE_COLLECTING_DATA;
    public static final int OCU_SERVICE_STATE_SENDING_DATA;
    public static final int OCU_SERVICE_STATE_ERROR_ABORTING;
    public static final int OCU_SERVICE_STATE_DIALING_FAILED;
    public static final int OCU_SERVICE_STATE_INTERRUPTED;
    public static final int OCU_SERVICE_STATE_REDIAL_FAILED;
    public static final int OCU_SERVICE_STATE_TESTMODE_ACTIVE;
    public static final int OCU_SERVICE_STATE_FALLBACK_TO_OFFICIAL_ECALL;
    public static final int OCU_SERVICE_STATE_VOICE_CALL_PENDING;
    public static final int OCU_SIGNAL_STRENGHT_NO_IFNO;
    public static final int OCU_SIGNAL_STRENGHT_NO_SIGNAL;
    public static final int OCU_SIGNAL_STRENGHT_WEAK_SIGNAL;
    public static final int OCU_SIGNAL_STRENGHT_GOOD_SIGNAL;
    public static final int OCU_DISCONNECT_REASON_NOT_AVAILABLE;
    public static final int OCU_DISCONNECT_REASON_HANGED_UP;
    public static final int OCU_DISCONNECT_REASON_NOLINE;
    public static final int OCU_DISCONNECT_REASON_SYSTEM_BUSY;
    public static final int OCU_DISCONNECT_REASON_REMOTE_BUSY;
    public static final int OCU_DISCONNECT_REASON_NUMBER_NOT_ASSIGNED;
    public static final int OCU_DISCONNECT_REASON_NUMBER_NOT_REACHABLE;
    public static final int OCU_DISCONNECT_REASON_NETWORK_ERROR;
    public static final int OCU_DISCONNECT_REASON_NUMBER_BLOCKED_OR_CALL_BARRING;
    public static final int OCU_DISCONNECT_REASON_CALL_REJECTED;
    public static final int OCU_DISCONNECT_REASON_REMOTE_NOT_ANSWERING;
    public static final int OCU_DISCONNECT_REASON_NUMBER_CHANGED;
    public static final int OCU_DISCONNECT_REASON_NUMBER_NOT_VALID;
    public static final int OCU_DISCONNECT_REASON_SERVICE_NOT_AVAILABLE;
    public static final int OCU_DISCONNECT_REASON_INFO_NOT_AVAILABLE;
    public static final int OCU_DISCONNECT_REASON_NUMBER_TEMP_FORBIDDEN;
    public static final int OCU_MENU_SERVICE_TYPE_NONE;
    public static final int OCU_MENU_SERVICE_TYPE_CALL;
    public static final int OCU_MENU_SERVICE_TYPE_SERVICE;

    default public void updateOcuCallType(int n) {
    }

    default public void updateOcuCallState(int n) {
    }

    default public void updateOcu2Available(boolean bl) {
    }

    default public void updateSupportedServices(boolean bl, boolean bl2, boolean bl3) {
    }

    default public void updateHangupAvailable(boolean bl) {
    }

    default public void updateSignalStrength(int n) {
    }

    default public void informPhoneCallTerminatedByError(int n) {
    }

    default public void informServiceCallNotLicensed() {
    }

    default public void informUsmConfirmationPending(boolean bl) {
    }

    default public void updateEmergencyCallRequested(boolean bl) {
    }

    default public void updateServiceState(int n, int n2) {
    }

    default public void updateDisconnectReason(int n) {
    }

    default public void updateOcuManualECall112Present(boolean bl) {
    }

    default public void updateOcuMenuServiceType(int n) {
    }
}

