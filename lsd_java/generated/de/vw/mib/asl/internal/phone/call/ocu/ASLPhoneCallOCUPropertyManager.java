/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.phone.call.ocu;

import de.vw.mib.properties.values.FixFormatterFieldData;

public interface ASLPhoneCallOCUPropertyManager {
    public static final int ADDRESS_DIRECTION__1;
    public static final int ADDRESS_DIRECTION__1__DEFAULT_VALUE;
    public static final int ADDRESS_DIRECTION__1__C0_NOT_AVAILABLE;
    public static final int ADDRESS_DIRECTION__1__C1_DEGREE_0;
    public static final int ADDRESS_DIRECTION__1__C2_DEGREE_45;
    public static final int ADDRESS_DIRECTION__1__C3_DEGREE_90;
    public static final int ADDRESS_DIRECTION__1__C4_DEGREE_135;
    public static final int ADDRESS_DIRECTION__1__C5_DEGREE_180;
    public static final int ADDRESS_DIRECTION__1__C6_DEGREE_225;
    public static final int ADDRESS_DIRECTION__1__C7_DEGREE_270;
    public static final int ADDRESS_DIRECTION__1__C8_DEGREE_315;
    public static final int ADDRESS_FIX_FORMATTER;
    public static final FixFormatterFieldData ADDRESS_FIX_FORMATTER__DEFAULT_VALUE;
    public static final int CALL_DURATION;
    public static final int CALL_DURATION__DEFAULT_VALUE;
    public static final int CALL_DURATION__MIN_VALUE;
    public static final int CALL_DURATION__STEP_SIZE;
    public static final int CALL_STATE__2;
    public static final int CALL_STATE__2__DEFAULT_VALUE;
    public static final int CALL_STATE__2__C0_CALLSTATE_IDLE;
    public static final int CALL_STATE__2__C1_CALLSTATE_DIALING;
    public static final int CALL_STATE__2__C2_CALLSTATE_ALERTING;
    public static final int CALL_STATE__2__C3_CALLSTATE_INCOMING;
    public static final int CALL_STATE__2__C4_CALLSTATE_INCOMING_ON_HOLD;
    public static final int CALL_STATE__2__C5_CALLSTATE_ACTIVE;
    public static final int CALL_STATE__2__C6_CALLSTATE_DISCONNECTING;
    public static final int CALL_STATE__2__C7_CALLSTATE_HOLD;
    public static final int DISCONNECTION_REASON;
    public static final int DISCONNECTION_REASON__DEFAULT_VALUE;
    public static final int DISCONNECTION_REASON__C0_NOT_AVAILABLE;
    public static final int DISCONNECTION_REASON__C1_HANGED_UP;
    public static final int DISCONNECTION_REASON__C2_NOLINE;
    public static final int DISCONNECTION_REASON__C3_SYSTEM_BUSY;
    public static final int DISCONNECTION_REASON__C4_REMOTE_BUSY;
    public static final int DISCONNECTION_REASON__C5_NUMBER_NOT_ASSIGNED;
    public static final int DISCONNECTION_REASON__C6_NUMBER_NOT_REACHABLE;
    public static final int DISCONNECTION_REASON__C7_NETWORK_ERROR;
    public static final int DISCONNECTION_REASON__C8_NUMBER_BLOCKED_OR_CALL_BARRING;
    public static final int DISCONNECTION_REASON__C9_CALL_REJECTED;
    public static final int DISCONNECTION_REASON__C10_REMOTE_NOT_ANSWERING;
    public static final int DISCONNECTION_REASON__C11_NUMBER_CHANGED;
    public static final int DISCONNECTION_REASON__C12_NUMBER_NOT_VALID;
    public static final int DISCONNECTION_REASON__C13_SERVICE_NOT_AVAILABLE;
    public static final int DISCONNECTION_REASON__C14_INFO_NOT_AVAILABLE;
    public static final int DISCONNECTION_REASON__C15_NUMBER_TEMP_FORBIDDEN;
    public static final int LICENSE_EXPIRE_DATE_DAY;
    public static final int LICENSE_EXPIRE_DATE_DAY__DEFAULT_VALUE;
    public static final int LICENSE_EXPIRE_DATE_DAY__MIN_VALUE;
    public static final int LICENSE_EXPIRE_DATE_DAY__MAX_VALUE;
    public static final int LICENSE_EXPIRE_DATE_DAY__STEP_SIZE;
    public static final int LICENSE_EXPIRE_DATE_MONTH;
    public static final int LICENSE_EXPIRE_DATE_MONTH__DEFAULT_VALUE;
    public static final int LICENSE_EXPIRE_DATE_MONTH__MIN_VALUE;
    public static final int LICENSE_EXPIRE_DATE_MONTH__MAX_VALUE;
    public static final int LICENSE_EXPIRE_DATE_MONTH__STEP_SIZE;
    public static final int LICENSE_EXPIRE_DATE_YEAR;
    public static final int LICENSE_EXPIRE_DATE_YEAR__DEFAULT_VALUE;
    public static final int LICENSE_EXPIRE_DATE_YEAR__MIN_VALUE;
    public static final int LICENSE_EXPIRE_DATE_YEAR__MAX_VALUE;
    public static final int LICENSE_EXPIRE_DATE_YEAR__STEP_SIZE;
    public static final int SERVICE_STATE__1;
    public static final int SERVICE_STATE__1__DEFAULT_VALUE;
    public static final int SERVICE_STATE__1__C0_NOT_AVAILABLE;
    public static final int SERVICE_STATE__1__C1_SERVICESTATE_COLLECTING_DATA;
    public static final int SERVICE_STATE__1__C2_SERVICESTATE_SENDING_DATA;
    public static final int SERVICE_STATE__1__C3_SERVICESTATE_ERROR_ABORTING;
    public static final int SERVICE_STATE__1__C4_SERVICESTATE_DIALING_FAILED;
    public static final int SERVICE_STATE__1__C5_SERVICESTATE_CALL_INTERRUPTED;
    public static final int SERVICE_STATE__1__C6_SERVICESTATE_REDIAL_FAILED;
    public static final int SERVICE_STATE__1__C7_SERVICESTATE_TESTMODE_ACTIVE;
    public static final int SERVICE_STATE__1__C8_SERVICESTATE_FALLBACK_TO_OFFICIAL_ECALL;
    public static final int SIGNAL_STRENGTH;
    public static final int SIGNAL_STRENGTH__DEFAULT_VALUE;
    public static final int SIGNAL_STRENGTH__C0_NO_INFO;
    public static final int SIGNAL_STRENGTH__C1_NO_SIGNAL;
    public static final int SIGNAL_STRENGTH__C2_WEAK_SIGNAL;
    public static final int SIGNAL_STRENGTH__C3_GOOD_SIGNAL;
    public static final int TYPE;
    public static final int TYPE__DEFAULT_VALUE;
    public static final int TYPE__C0_NONE;
    public static final int TYPE__C1_AUTOMATIC_EMERGENCY_CALL;
    public static final int TYPE__C2_MANUAL_EMERGENCY_CALL;
    public static final int TYPE__C3_INFO_CALL;
    public static final int TYPE__C4_SERVICE_CALL;
    public static final int EMERGENCY_CALL_AVAILABLE;
    public static final boolean EMERGENCY_CALL_AVAILABLE__DEFAULT_VALUE;
    public static final int EMERGENCY_CALL_REQUESTED;
    public static final boolean EMERGENCY_CALL_REQUESTED__DEFAULT_VALUE;
    public static final boolean EMERGENCY_CALL_REQUESTED__C0_TRUE;
    public static final boolean EMERGENCY_CALL_REQUESTED__C1_FALSE;
    public static final int HANG_UP_AVAILABLE;
    public static final boolean HANG_UP_AVAILABLE__DEFAULT_VALUE;
    public static final int INFO_CALL_AVAILABLE;
    public static final boolean INFO_CALL_AVAILABLE__DEFAULT_VALUE;
    public static final int OCU2AVAILABLE;
    public static final boolean OCU2AVAILABLE__DEFAULT_VALUE;
    public static final int SERVICE_CALL_AVAILABLE;
    public static final boolean SERVICE_CALL_AVAILABLE__DEFAULT_VALUE;
    public static final int EXT_USM_CONFIRMATION_REQUIRED;
    public static final boolean EXT_USM_CONFIRMATION_REQUIRED__DEFAULT_VALUE;
    public static final boolean EXT_USM_CONFIRMATION_REQUIRED__C0_TRUE;
    public static final boolean EXT_USM_CONFIRMATION_REQUIRED__C1_FALSE;

    static {
        ADDRESS_FIX_FORMATTER__DEFAULT_VALUE = null;
    }
}

