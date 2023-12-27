/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.phone;

public interface ASLPhonePropertyManager {
    public static final int ACTIVATION_STATE__1;
    public static final int ACTIVATION_STATE__1__DEFAULT_VALUE;
    public static final int ACTIVATION_STATE__1__C0_ACTIVATIONSTATE_INIT;
    public static final int ACTIVATION_STATE__1__C1_ACTIVATIONSTATE_NOT_ATTACHED;
    public static final int ACTIVATION_STATE__1__C2_ACTIVATIONSTATE_TEL_ACTIVE_CALL;
    public static final int ACTIVATION_STATE__1__C3_ACTIVATIONSTATE_PHONE_OFF;
    public static final int ACTIVATION_STATE__1__C4_ACTIVATIONSTATE_PHONE_ON;
    public static final int ACTIVATION_STATE__1__C5_ACTIVATIONSTATE_ATTACHED_NOT_READY;
    public static final int ACTIVATION_STATE__1__C6_ACTIVATIONSTATE_ATTACHED_NOT_FUNC;
    public static final int ACTIVATION_STATE__1__C7_ACTIVATIONSTATE_ME_RECONNECT;
    public static final int BATTERY_LEVEL__1;
    public static final int BATTERY_LEVEL__1__DEFAULT_VALUE;
    public static final int BATTERY_LEVEL__1__C0_BATTERY_NOT_AVAILABLE;
    public static final int BATTERY_LEVEL__1__C1_ONE;
    public static final int BATTERY_LEVEL__1__C2_TWO;
    public static final int BATTERY_LEVEL__1__C3_THREE;
    public static final int BATTERY_LEVEL__1__C4_FOUR;
    public static final int BATTERY_LEVEL__1__C5_FIVE;
    public static final int BTHSSIM_CARD_STATE;
    public static final int BTHSSIM_CARD_STATE__DEFAULT_VALUE;
    public static final int BTHSSIM_CARD_STATE__C0_NO_SIM_CARD;
    public static final int BTHSSIM_CARD_STATE__C1_SIM_CARD_NOT_READY;
    public static final int BTHSSIM_CARD_STATE__C2_SIM_CARD_READY;
    public static final int DATA_CONNECTION_TYPE;
    public static final int DATA_CONNECTION_TYPE__DEFAULT_VALUE;
    public static final int DATA_CONNECTION_TYPE__C0_NOT_AVAILABLE;
    public static final int DATA_CONNECTION_TYPE__C1_3G_PLUS;
    public static final int DATA_CONNECTION_TYPE__C2_3G;
    public static final int DATA_CONNECTION_TYPE__C3_EGPRS;
    public static final int DATA_CONNECTION_TYPE__C4_GPRS;
    public static final int DATA_CONNECTION_TYPE__C5_4G;
    public static final int FORMATTING_RULE_OFFSET;
    public static final int FORMATTING_RULE_OFFSET__DEFAULT_VALUE;
    public static final int INTERNAL_SIM_CARD_STATE;
    public static final int INTERNAL_SIM_CARD_STATE__DEFAULT_VALUE;
    public static final int INTERNAL_SIM_CARD_STATE__C0_NO_SIM_CARD;
    public static final int INTERNAL_SIM_CARD_STATE__C1_SIM_CARD_NOT_READY;
    public static final int INTERNAL_SIM_CARD_STATE__C2_SIM_CARD_READY;
    public static final int LOCK_STATE;
    public static final int LOCK_STATE__DEFAULT_VALUE;
    public static final int LOCK_STATE__C0_LOCKSTATE_UNKNOWN;
    public static final int LOCK_STATE__C1_LOCKSTATE_UNLOCK_INPR;
    public static final int LOCK_STATE__C2_LOCKSTATE_NO_LOCK;
    public static final int LOCK_STATE__C3_LOCKSTATE_PIN_REQUIRED;
    public static final int LOCK_STATE__C4_LOCKSTATE_PIN2_REQUIRED;
    public static final int LOCK_STATE__C5_LOCKSTATE_PUK_REQUIRED;
    public static final int LOCK_STATE__C6_LOCKSTATE_PUK2_REQUIRED;
    public static final int LOCK_STATE__C7_LOCKSTATE_PUK_BLOCKED;
    public static final int LOCK_STATE__C8_LOCKSTATE_PUK2_BLOCKED;
    public static final int LOCK_STATE__C9_LOCKSTATE_SECCO_REQUIRED;
    public static final int LOCK_STATE__C10_LOCKSTATE_SECCO_BLOCKED;
    public static final int LOCK_STATE__C11_LOCKSTATE_SIMNOTFUNC;
    public static final int LOCK_STATE__C12_LOCKSTATE_SIM_INVALID;
    public static final int NAD_STATE__2;
    public static final int NAD_STATE__2__DEFAULT_VALUE;
    public static final int NAD_STATE__2__C0_NOT_AVAILABLE;
    public static final int NAD_STATE__2__C1_NAD_OFF_HIGH_TEMP;
    public static final int NAD_STATE__2__C2_NAD_ON;
    public static final int NAD_STATE__2__C3_NAD_OFF;
    public static final int NAD_STATE__2__C4_NAD_OFF_DIAG;
    public static final int NAD_STATE__2__C5_NAD_NOT_FUNCTION;
    public static final int NAD_STATE__2__C6_NAD_INIT;
    public static final int NAD_STATE__2__C7_NAD_SWITCHING_ON;
    public static final int NAD_STATE__2__C8_NAD_SWITCHING_OFF;
    public static final int NETWORK_NAME;
    public static final String NETWORK_NAME__DEFAULT_VALUE;
    public static final int NETWORK_STATE;
    public static final int NETWORK_STATE__DEFAULT_VALUE;
    public static final int NETWORK_STATE__C0_NETWORK_NOT_AVAILABLE;
    public static final int NETWORK_STATE__C1_REGISTERED_AT_PROVIDER_NETWORK;
    public static final int NETWORK_STATE__C2_REGISTERED_AT_ROAMING_NETWORK;
    public static final int NETWORK_STATE__C3_NETWORK_SEARCHING;
    public static final int NETWORK_STATE__C4_NETWORK_ACCESS_DENIED;
    public static final int NETWORK_STATE__C5_EMERGENCY_NETWORK;
    public static final int NETWORK_TYPE;
    public static final int NETWORK_TYPE__DEFAULT_VALUE;
    public static final int NETWORK_TYPE__C0_NOT_AVAILABLE;
    public static final int NETWORK_TYPE__C1_GSM;
    public static final int NETWORK_TYPE__C2_3G;
    public static final int NETWORK_TYPE__C3_4G;
    public static final int SIGNAL_STRENGTH;
    public static final int SIGNAL_STRENGTH__DEFAULT_VALUE;
    public static final int SIGNAL_STRENGTH__C0_ZERO;
    public static final int SIGNAL_STRENGTH__C1_ONE;
    public static final int SIGNAL_STRENGTH__C2_TWO;
    public static final int SIGNAL_STRENGTH__C3_THREE;
    public static final int SIGNAL_STRENGTH__C4_FOUR;
    public static final int SIGNAL_STRENGTH__C5_FIVE;
    public static final int SIM_TYPE;
    public static final int SIM_TYPE__DEFAULT_VALUE;
    public static final int SIM_TYPE__C0_INTERNAL_SIM;
    public static final int SIM_TYPE__C1_EXTERNAL_SIM;
    public static final int SUPPLEMENTARY_SERVICE_STATE;
    public static final int SUPPLEMENTARY_SERVICE_STATE__DEFAULT_VALUE;
    public static final int SUPPLEMENTARY_SERVICE_STATE__C0_SERVICE_REQUEST_IS_BEING_PROCESSED;
    public static final int SUPPLEMENTARY_SERVICE_STATE__C1_SUPPLEMENTARY_SERVICE_SUCCESS;
    public static final int SUPPLEMENTARY_SERVICE_STATE__C2_SUPPLEMENTARY_SERVICE_FAILED;
    public static final int SUPPLEMENTARY_SERVICE_STATE__C3_SUPPLEMENTARY_SERVICE_UNSTRUCTURED;
    public static final int SUPPLEMENTARY_UNSTRUCTURED_RESULT;
    public static final String SUPPLEMENTARY_UNSTRUCTURED_RESULT__DEFAULT_VALUE;
    public static final int DATA_TRANSFER;
    public static final boolean DATA_TRANSFER__DEFAULT_VALUE;
    public static final int INTERNAL_NAD_AVAILABLE;
    public static final boolean INTERNAL_NAD_AVAILABLE__DEFAULT_VALUE;
    public static final int ME_IN_CRADLE;
    public static final boolean ME_IN_CRADLE__DEFAULT_VALUE;
    public static final int MUTE_MICROPHONE;
    public static final boolean MUTE_MICROPHONE__DEFAULT_VALUE;
    public static final int MUTE_RINGTONE;
    public static final boolean MUTE_RINGTONE__DEFAULT_VALUE;
    public static final int PHONE_TILE_VISIBLE;
    public static final boolean PHONE_TILE_VISIBLE__DEFAULT_VALUE;
    public static final int PRIMARY_PHONE_SIM;
    public static final boolean PRIMARY_PHONE_SIM__DEFAULT_VALUE;
    public static final int SECOND_PHONE_SIM;
    public static final boolean SECOND_PHONE_SIM__DEFAULT_VALUE;
    public static final int SIGNAL_STRENGTH_AVAILABLE;
    public static final boolean SIGNAL_STRENGTH_AVAILABLE__DEFAULT_VALUE;
    public static final int SIM_CARD_ALREADY_KNOWN;
    public static final boolean SIM_CARD_ALREADY_KNOWN__DEFAULT_VALUE;
    public static final int SIM_CARD_MODE_SWITCH;
    public static final boolean SIM_CARD_MODE_SWITCH__DEFAULT_VALUE;
    public static final int SUPPLEMENTARY_SERVICE_AVAILABLE;
    public static final boolean SUPPLEMENTARY_SERVICE_AVAILABLE__DEFAULT_VALUE;
}
