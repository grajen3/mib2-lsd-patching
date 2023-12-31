/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.phone.bluetooth;

public interface ASLPhoneBluetoothPropertyManager {
    public static final int BONDING_ERROR__BONDING_ERROR_DEVICE_NAME;
    public static final String BONDING_ERROR__BONDING_ERROR_DEVICE_NAME__DEFAULT_VALUE;
    public static final int BONDING_ERROR__BONDING_ERROR_PROFILE;
    public static final int BONDING_ERROR__BONDING_ERROR_PROFILE__DEFAULT_VALUE;
    public static final int BONDING_ERROR__BONDING_ERROR_PROFILE__C0_NO_PROFILE_CONNECTED;
    public static final int BONDING_ERROR__BONDING_ERROR_PROFILE__C1_TELEPHONY_SIMAP;
    public static final int BONDING_ERROR__BONDING_ERROR_PROFILE__C2_TELEPHONY_HFP_AG;
    public static final int BONDING_ERROR__BONDING_ERROR_PROFILE__C3_TELEPHONY_HFP_HF;
    public static final int BONDING_ERROR__BONDING_ERROR_PROFILE__C4_TELEPHONY_HANDSET;
    public static final int BONDING_ERROR__BONDING_ERROR_PROFILE__C5_AUDIO_SOURCE;
    public static final int BONDING_ERROR__BONDING_ERROR_PROFILE__C6_AUDIO_SINK;
    public static final int BONDING_ERROR__BONDING_ERROR_PROFILE__C7_BIP;
    public static final int BONDING_ERROR__BONDING_ERROR_PROFILE__C8_DUN_SERVER;
    public static final int BONDING_ERROR__BONDING_ERROR_PROFILE__C9_PAN;
    public static final int BONDING_ERROR__BONDING_ERROR_PROFILE__C10_MAP1_SERVER;
    public static final int BONDING_ERROR__BONDING_ERROR_PROFILE__C11_MAP2_SERVER;
    public static final int BONDING_ERROR__BONDING_ERROR_PROFILE__C12_OBJECTPUSH_SERVER;
    public static final int BONDING_ERROR__BONDING_ERROR_PROFILE__C13_PHONEBOOK;
    public static final int BONDING_ERROR__BONDING_ERROR_PROFILE__C14_SYNCHML;
    public static final int BONDING_ERROR__BONDING_ERROR_PROFILE__C15_HID;
    public static final int BONDING_ERROR__BONDING_ERROR_PROFILE__C16_SPP;
    public static final int BONDING_ERROR__BONDING_ERROR__7;
    public static final int BONDING_ERROR__BONDING_ERROR__7__DEFAULT_VALUE;
    public static final int BONDING_ERROR__BONDING_ERROR__7__C0_NO_ERROR;
    public static final int BONDING_ERROR__BONDING_ERROR__7__C1_ERROR_GENERAL;
    public static final int BONDING_ERROR__BONDING_ERROR__7__C2_ERROR_PAIRING_GENERAL;
    public static final int BONDING_ERROR__BONDING_ERROR__7__C3_ERROR_PAIRING_TIMEOUT;
    public static final int BONDING_ERROR__BONDING_ERROR__7__C4_ERROR_PAIRING_WRONG_PASSKEY;
    public static final int BONDING_ERROR__BONDING_ERROR__7__C5_ERROR_SERVICE_NOT_SUPPORTED;
    public static final int BONDING_ERROR__BONDING_ERROR__7__C6_ERROR_DEVICE_NOT_RESPONDING;
    public static final int BONDING_ERROR__BONDING_ERROR__7__C7_SERVICE_REJECTED;
    public static final int BONDING_ERROR__BONDING_ERROR__7__C8_SERVICE_CONNECT_TIMEOUT;
    public static final int BONDING_ERROR__BONDING_ERROR__7__C9_HW_FAILURE;
    public static final int BONDING_ERROR__BONDING_ERROR__7__C10_ERROR_SIM_INSERTED;
    public static final int BONDING_ERROR__BONDING_ERROR__7__C11_ERROR_SIM_NOT_INSERTED;
    public static final int BONDING_ERROR__BONDING_ERROR__7__C12_ERROR_CONCURRENT_CONNECTION;
    public static final int BONDING_ERROR__BONDING_ERROR__7__C13_RESULT_ERROR_CONNECTION_LIMIT_EXCEEDED;
    public static final int BONDING_ERROR__BONDING_ERROR__7__C14_RESULT_ERROR_ANDROID_AUTO_ACTIVE;
    public static final int BONDING_ERROR__BONDING_ERROR__7__C15_RESULT_ERROR_CARPLAY_ACTIVE;
    public static final int BONDING_PROFILE_SELECTION__BONDING_PROFILE;
    public static final int BONDING_PROFILE_SELECTION__BONDING_PROFILE__DEFAULT_VALUE;
    public static final int BONDING_PROFILE_SELECTION__BONDING_PROFILE__C0_NO_PROFILE_CONNECTED;
    public static final int BONDING_PROFILE_SELECTION__BONDING_PROFILE__C1_TELEPHONY_SIMAP;
    public static final int BONDING_PROFILE_SELECTION__BONDING_PROFILE__C2_TELEPHONY_HFP_AG;
    public static final int BONDING_PROFILE_SELECTION__BONDING_PROFILE__C3_TELEPHONY_HFP_HF;
    public static final int BONDING_PROFILE_SELECTION__BONDING_PROFILE__C4_TELEPHONY_HANDSET;
    public static final int BONDING_PROFILE_SELECTION__BONDING_PROFILE__C5_AUDIO_SOURCE;
    public static final int BONDING_PROFILE_SELECTION__BONDING_PROFILE__C6_AUDIO_SINK;
    public static final int BONDING_PROFILE_SELECTION__BONDING_PROFILE__C7_BIP;
    public static final int BONDING_PROFILE_SELECTION__BONDING_PROFILE__C8_DUN_SERVER;
    public static final int BONDING_PROFILE_SELECTION__BONDING_PROFILE__C9_PAN;
    public static final int BONDING_PROFILE_SELECTION__BONDING_PROFILE__C10_MAP1_SERVER;
    public static final int BONDING_PROFILE_SELECTION__BONDING_PROFILE__C11_MAP2_SERVER;
    public static final int BONDING_PROFILE_SELECTION__BONDING_PROFILE__C12_OBJECTPUSH_SERVER;
    public static final int BONDING_PROFILE_SELECTION__BONDING_PROFILE__C13_PHONEBOOK;
    public static final int BONDING_PROFILE_SELECTION__BONDING_PROFILE__C14_SYNCHML;
    public static final int BONDING_PROFILE_SELECTION__BONDING_PROFILE__C15_HID;
    public static final int BONDING_PROFILE_SELECTION__BONDING_PROFILE__C16_SPP;
    public static final int BONDING_PROFILE_SELECTION__BONDING_PROFILE_CONNECTED;
    public static final boolean BONDING_PROFILE_SELECTION__BONDING_PROFILE_CONNECTED__DEFAULT_VALUE;
    public static final boolean BONDING_PROFILE_SELECTION__BONDING_PROFILE_CONNECTED__C0_NOT_CONNECTED;
    public static final boolean BONDING_PROFILE_SELECTION__BONDING_PROFILE_CONNECTED__C1_CONNECTED;
    public static final int BONDING_PROFILE_SELECTION__BONDING_PROFILE_TEMPORARY_AVAILABLE;
    public static final boolean BONDING_PROFILE_SELECTION__BONDING_PROFILE_TEMPORARY_AVAILABLE__DEFAULT_VALUE;
    public static final boolean BONDING_PROFILE_SELECTION__BONDING_PROFILE_TEMPORARY_AVAILABLE__C0_NOT_AVAILABLE;
    public static final boolean BONDING_PROFILE_SELECTION__BONDING_PROFILE_TEMPORARY_AVAILABLE__C1_AVAILABLE;
    public static final int BONDING_SEARCH_RESULT__BONDING_SEARCH_FIRST_SUPPORTED_PROFILE;
    public static final int BONDING_SEARCH_RESULT__BONDING_SEARCH_FIRST_SUPPORTED_PROFILE__DEFAULT_VALUE;
    public static final int BONDING_SEARCH_RESULT__BONDING_SEARCH_FIRST_SUPPORTED_PROFILE__C0_NO_PROFILE_CONNECTED;
    public static final int BONDING_SEARCH_RESULT__BONDING_SEARCH_FIRST_SUPPORTED_PROFILE__C1_TELEPHONY_SIMAP;
    public static final int BONDING_SEARCH_RESULT__BONDING_SEARCH_FIRST_SUPPORTED_PROFILE__C2_TELEPHONY_HFP_AG;
    public static final int BONDING_SEARCH_RESULT__BONDING_SEARCH_FIRST_SUPPORTED_PROFILE__C3_TELEPHONY_HFP_HF;
    public static final int BONDING_SEARCH_RESULT__BONDING_SEARCH_FIRST_SUPPORTED_PROFILE__C4_TELEPHONY_HANDSET;
    public static final int BONDING_SEARCH_RESULT__BONDING_SEARCH_FIRST_SUPPORTED_PROFILE__C5_AUDIO_SOURCE;
    public static final int BONDING_SEARCH_RESULT__BONDING_SEARCH_FIRST_SUPPORTED_PROFILE__C6_AUDIO_SINK;
    public static final int BONDING_SEARCH_RESULT__BONDING_SEARCH_FIRST_SUPPORTED_PROFILE__C7_BIP;
    public static final int BONDING_SEARCH_RESULT__BONDING_SEARCH_FIRST_SUPPORTED_PROFILE__C8_DUN_SERVER;
    public static final int BONDING_SEARCH_RESULT__BONDING_SEARCH_FIRST_SUPPORTED_PROFILE__C9_PAN;
    public static final int BONDING_SEARCH_RESULT__BONDING_SEARCH_FIRST_SUPPORTED_PROFILE__C10_MAP1_SERVER;
    public static final int BONDING_SEARCH_RESULT__BONDING_SEARCH_FIRST_SUPPORTED_PROFILE__C11_MAP2_SERVER;
    public static final int BONDING_SEARCH_RESULT__BONDING_SEARCH_FIRST_SUPPORTED_PROFILE__C12_OBJECTPUSH_SERVER;
    public static final int BONDING_SEARCH_RESULT__BONDING_SEARCH_FIRST_SUPPORTED_PROFILE__C13_PHONEBOOK;
    public static final int BONDING_SEARCH_RESULT__BONDING_SEARCH_FIRST_SUPPORTED_PROFILE__C14_SYNCHML;
    public static final int BONDING_SEARCH_RESULT__BONDING_SEARCH_FIRST_SUPPORTED_PROFILE__C15_HID;
    public static final int BONDING_SEARCH_RESULT__BONDING_SEARCH_FIRST_SUPPORTED_PROFILE__C16_SPP;
    public static final int BONDING_SEARCH_RESULT__BONDING_SEARCH_NAME;
    public static final String BONDING_SEARCH_RESULT__BONDING_SEARCH_NAME__DEFAULT_VALUE;
    public static final int BONDING_SEARCH_RESULT__BONDING_SEARCH_PROFILES_COUNT;
    public static final int BONDING_SEARCH_RESULT__BONDING_SEARCH_PROFILES_COUNT__DEFAULT_VALUE;
    public static final int BONDING_SEARCH_RESULT__BONDING_SEARCH_ALREADY_PAIRED;
    public static final boolean BONDING_SEARCH_RESULT__BONDING_SEARCH_ALREADY_PAIRED__DEFAULT_VALUE;
    public static final boolean BONDING_SEARCH_RESULT__BONDING_SEARCH_ALREADY_PAIRED__C0_NOT_PAIRED;
    public static final boolean BONDING_SEARCH_RESULT__BONDING_SEARCH_ALREADY_PAIRED__C1_ALREADY_PAIRED;
    public static final int BONDING_SEARCH_RESULT__BONDING_SEARCH_FIRST_SUPPORTED_PROFILE_CONNECTED;
    public static final boolean BONDING_SEARCH_RESULT__BONDING_SEARCH_FIRST_SUPPORTED_PROFILE_CONNECTED__DEFAULT_VALUE;
    public static final boolean BONDING_SEARCH_RESULT__BONDING_SEARCH_FIRST_SUPPORTED_PROFILE_CONNECTED__C0_NOT_CONNECTED;
    public static final boolean BONDING_SEARCH_RESULT__BONDING_SEARCH_FIRST_SUPPORTED_PROFILE_CONNECTED__C1_CONNECTED;
    public static final int BONDING_SEARCH_RESULT__BONDING_SEARCH_FIRST_SUPPORTED_PROFILE_TEMPORARY_AVAILABLE;
    public static final boolean BONDING_SEARCH_RESULT__BONDING_SEARCH_FIRST_SUPPORTED_PROFILE_TEMPORARY_AVAILABLE__DEFAULT_VALUE;
    public static final boolean BONDING_SEARCH_RESULT__BONDING_SEARCH_FIRST_SUPPORTED_PROFILE_TEMPORARY_AVAILABLE__C0_NOT_AVAILABLE;
    public static final boolean BONDING_SEARCH_RESULT__BONDING_SEARCH_FIRST_SUPPORTED_PROFILE_TEMPORARY_AVAILABLE__C1_AVAILABLE;
    public static final int BONDING_SEARCH_RESULT__BONDING_SEARCH_MEDIA_PROFILE_CONNECTED;
    public static final boolean BONDING_SEARCH_RESULT__BONDING_SEARCH_MEDIA_PROFILE_CONNECTED__DEFAULT_VALUE;
    public static final boolean BONDING_SEARCH_RESULT__BONDING_SEARCH_MEDIA_PROFILE_CONNECTED__C0_NOT_CONNECTED;
    public static final boolean BONDING_SEARCH_RESULT__BONDING_SEARCH_MEDIA_PROFILE_CONNECTED__C1_CONNECTED;
    public static final int BONDING_SEARCH_RESULT__BONDING_SEARCH_MEDIA_PROFILE_SUPPORTED;
    public static final boolean BONDING_SEARCH_RESULT__BONDING_SEARCH_MEDIA_PROFILE_SUPPORTED__DEFAULT_VALUE;
    public static final boolean BONDING_SEARCH_RESULT__BONDING_SEARCH_MEDIA_PROFILE_SUPPORTED__C0_NOT_ACTIVE;
    public static final boolean BONDING_SEARCH_RESULT__BONDING_SEARCH_MEDIA_PROFILE_SUPPORTED__C1_ACTIVE;
    public static final int BONDING_SEARCH_RESULT__BONDING_SEARCH_OTHER_PROFILE_CONNECTED;
    public static final boolean BONDING_SEARCH_RESULT__BONDING_SEARCH_OTHER_PROFILE_CONNECTED__DEFAULT_VALUE;
    public static final boolean BONDING_SEARCH_RESULT__BONDING_SEARCH_OTHER_PROFILE_CONNECTED__C0_NOT_CONNECTED;
    public static final boolean BONDING_SEARCH_RESULT__BONDING_SEARCH_OTHER_PROFILE_CONNECTED__C1_CONNECTED;
    public static final int BONDING_SEARCH_RESULT__BONDING_SEARCH_OTHER_PROFILE_SUPPORTED;
    public static final boolean BONDING_SEARCH_RESULT__BONDING_SEARCH_OTHER_PROFILE_SUPPORTED__DEFAULT_VALUE;
    public static final boolean BONDING_SEARCH_RESULT__BONDING_SEARCH_OTHER_PROFILE_SUPPORTED__C0_NOT_ACTIVE;
    public static final boolean BONDING_SEARCH_RESULT__BONDING_SEARCH_OTHER_PROFILE_SUPPORTED__C1_ACTIVE;
    public static final int BONDING_SEARCH_RESULT__BONDING_SEARCH_PHONE_PROFILE_CONNECTED;
    public static final boolean BONDING_SEARCH_RESULT__BONDING_SEARCH_PHONE_PROFILE_CONNECTED__DEFAULT_VALUE;
    public static final boolean BONDING_SEARCH_RESULT__BONDING_SEARCH_PHONE_PROFILE_CONNECTED__C0_NOT_CONNECTED;
    public static final boolean BONDING_SEARCH_RESULT__BONDING_SEARCH_PHONE_PROFILE_CONNECTED__C1_CONNECTED;
    public static final int BONDING_SEARCH_RESULT__BONDING_SEARCH_PHONE_PROFILE_SUPPORTED;
    public static final boolean BONDING_SEARCH_RESULT__BONDING_SEARCH_PHONE_PROFILE_SUPPORTED__DEFAULT_VALUE;
    public static final boolean BONDING_SEARCH_RESULT__BONDING_SEARCH_PHONE_PROFILE_SUPPORTED__C0_NOT_ACTIVE;
    public static final boolean BONDING_SEARCH_RESULT__BONDING_SEARCH_PHONE_PROFILE_SUPPORTED__C1_ACTIVE;
    public static final int SELECTEDBONDING_DEVICE__SELECTED_DEVICE_CONNECTED_SIMAP;
    public static final boolean SELECTEDBONDING_DEVICE__SELECTED_DEVICE_CONNECTED_SIMAP__DEFAULT_VALUE;
    public static final int SELECTEDBONDING_DEVICE__SELECTED_DEVICE_SIMAP_TEMPORARY_AVAILABLE;
    public static final boolean SELECTEDBONDING_DEVICE__SELECTED_DEVICE_SIMAP_TEMPORARY_AVAILABLE__DEFAULT_VALUE;
    public static final int SELECTEDBONDING_DEVICE__SELECTED_DEVICE_SUPPORT_HFP;
    public static final boolean SELECTEDBONDING_DEVICE__SELECTED_DEVICE_SUPPORT_HFP__DEFAULT_VALUE;
    public static final int SELECTEDBONDING_DEVICE__SELECTED_DEVICE_SUPPORT_MAP1;
    public static final boolean SELECTEDBONDING_DEVICE__SELECTED_DEVICE_SUPPORT_MAP1__DEFAULT_VALUE;
    public static final int SELECTEDBONDING_DEVICE__SELECTED_DEVICE_SUPPORT_MAP2;
    public static final boolean SELECTEDBONDING_DEVICE__SELECTED_DEVICE_SUPPORT_MAP2__DEFAULT_VALUE;
    public static final int SELECTEDBONDING_DEVICE__SELECTED_DEVICE_SUPPORT_SIMAP;
    public static final boolean SELECTEDBONDING_DEVICE__SELECTED_DEVICE_SUPPORT_SIMAP__DEFAULT_VALUE;
    public static final int CONNECTION_ERROR;
    public static final int CONNECTION_ERROR__DEFAULT_VALUE;
    public static final int CONNECTION_ERROR__C0_NO_ERROR;
    public static final int CONNECTION_ERROR__C1_ERROR_GENERAL;
    public static final int CONNECTION_ERROR__C2_ERROR_USER_ID_WRONG;
    public static final int CONNECTION_ERROR__C3_ERROR_PIN_WRONG;
    public static final int CURRENT_MEDIA_PROFILE;
    public static final int CURRENT_MEDIA_PROFILE__DEFAULT_VALUE;
    public static final int CURRENT_MEDIA_PROFILE__C0_NO_PROFILE_CONNECTED;
    public static final int CURRENT_MEDIA_PROFILE__C1_AUDIO_SOURCE;
    public static final int CURRENT_MEDIA_PROFILE__C2_AUDIO_SINK;
    public static final int CURRENT_OTHER_PROFILE;
    public static final int CURRENT_OTHER_PROFILE__DEFAULT_VALUE;
    public static final int CURRENT_OTHER_PROFILE__C0_NO_PROFILE_CONNECTED;
    public static final int CURRENT_OTHER_PROFILE__C1_BIP;
    public static final int CURRENT_OTHER_PROFILE__C2_DUN_SERVER;
    public static final int CURRENT_OTHER_PROFILE__C3_PAN;
    public static final int CURRENT_OTHER_PROFILE__C4_MAP1_SERVER;
    public static final int CURRENT_OTHER_PROFILE__C5_MAP2_SERVER;
    public static final int CURRENT_OTHER_PROFILE__C6_OBJECTPUSH_SERVER;
    public static final int CURRENT_OTHER_PROFILE__C7_PHONEBOOK;
    public static final int CURRENT_OTHER_PROFILE__C8_SYNCHML;
    public static final int CURRENT_OTHER_PROFILE__C9_HID;
    public static final int CURRENT_OTHER_PROFILE__C10_SPP;
    public static final int CURRENT_PHONE_PROFILE__1;
    public static final int CURRENT_PHONE_PROFILE__1__DEFAULT_VALUE;
    public static final int CURRENT_PHONE_PROFILE__1__C0_NO_PROFILE_CONNECTED;
    public static final int CURRENT_PHONE_PROFILE__1__C1_TELEPHONY_SIMAP;
    public static final int CURRENT_PHONE_PROFILE__1__C2_TELEPHONY_HFP_AG;
    public static final int CURRENT_PHONE_PROFILE__1__C3_TELEPHONY_HFP_HF;
    public static final int CURRENT_PHONE_PROFILE__1__C4_TELEPHONY_HANDSET;
    public static final int EXTERNAL_DEVICE_NAME;
    public static final String EXTERNAL_DEVICE_NAME__DEFAULT_VALUE;
    public static final int EXTERNAL_PROFILE;
    public static final int EXTERNAL_PROFILE__DEFAULT_VALUE;
    public static final int EXTERNAL_PROFILE__C0_NO_PROFILE_CONNECTED;
    public static final int EXTERNAL_PROFILE__C1_TELEPHONY_SIMAP;
    public static final int EXTERNAL_PROFILE__C2_TELEPHONY_HFP_AG;
    public static final int EXTERNAL_PROFILE__C3_TELEPHONY_HFP_HF;
    public static final int EXTERNAL_PROFILE__C4_TELEPHONY_HANDSET;
    public static final int EXTERNAL_PROFILE__C5_AUDIO_SOURCE;
    public static final int EXTERNAL_PROFILE__C6_AUDIO_SINK;
    public static final int EXTERNAL_PROFILE__C7_BIP;
    public static final int EXTERNAL_PROFILE__C8_DUN_SERVER;
    public static final int EXTERNAL_PROFILE__C9_PAN;
    public static final int EXTERNAL_PROFILE__C10_MAP1_SERVER;
    public static final int EXTERNAL_PROFILE__C11_MAP2_SERVER;
    public static final int EXTERNAL_PROFILE__C12_OBJECTPUSH_SERVER;
    public static final int EXTERNAL_PROFILE__C13_PHONEBOOK;
    public static final int EXTERNAL_PROFILE__C14_SYNCHML;
    public static final int EXTERNAL_PROFILE__C15_HID;
    public static final int EXTERNAL_PROFILE__C16_SPP;
    public static final int MEDIA_DEVICE_NAME;
    public static final String MEDIA_DEVICE_NAME__DEFAULT_VALUE;
    public static final int OPP_DEVICE_NAME;
    public static final String OPP_DEVICE_NAME__DEFAULT_VALUE;
    public static final int OTHER_DEVICE_NAME;
    public static final String OTHER_DEVICE_NAME__DEFAULT_VALUE;
    public static final int PASSKEY;
    public static final String PASSKEY__DEFAULT_VALUE;
    public static final int PASSKEY_STATE;
    public static final int PASSKEY_STATE__DEFAULT_VALUE;
    public static final int PASSKEY_STATE__C0_NO_PASSKEY_REQUIRED;
    public static final int PASSKEY_STATE__C1_PASSKEY_REQUIRED;
    public static final int PASSKEY_STATE__C2_PASSKEY_TO_BE_DISPLAYED;
    public static final int PASSKEY_TIMER_VALUE;
    public static final int PASSKEY_TIMER_VALUE__DEFAULT_VALUE;
    public static final int PASSKEY_TIMER_VALUE__MIN_VALUE;
    public static final int PASSKEY_TIMER_VALUE__STEP_SIZE;
    public static final int PHONE_CONTACTS_DEVICE_NAME;
    public static final String PHONE_CONTACTS_DEVICE_NAME__DEFAULT_VALUE;
    public static final int PHONE_CONTACTS_PROFILE;
    public static final int PHONE_CONTACTS_PROFILE__DEFAULT_VALUE;
    public static final int PHONE_CONTACTS_PROFILE__C0_NO_PROFILE_CONNECTED;
    public static final int PHONE_CONTACTS_PROFILE__C1_PHONEBOOK;
    public static final int PHONE_DEVICE_NAME;
    public static final String PHONE_DEVICE_NAME__DEFAULT_VALUE;
    public static final int SECOND_PHONE_DEVICE_NAME;
    public static final String SECOND_PHONE_DEVICE_NAME__DEFAULT_VALUE;
    public static final int SECOND_PHONE_PROFILE;
    public static final int SECOND_PHONE_PROFILE__DEFAULT_VALUE;
    public static final int SECOND_PHONE_PROFILE__C0_NO_PROFILE_CONNECTED;
    public static final int SECOND_PHONE_PROFILE__C1_TELEPHONY_SIMAP;
    public static final int SECOND_PHONE_PROFILE__C2_TELEPHONY_HFP_AG;
    public static final int SECOND_PHONE_PROFILE__C3_TELEPHONY_HFP_HF;
    public static final int SECOND_PHONE_PROFILE__C4_TELEPHONY_HANDSET;
    public static final int SECOND_PHONE_PROFILE__1;
    public static final int SECOND_PHONE_PROFILE__1__DEFAULT_VALUE;
    public static final int SECOND_PHONE_PROFILE__1__C0_NO_PROFILE_CONNECTED;
    public static final int SECOND_PHONE_PROFILE__1__C1_TELEPHONY_SIMAP;
    public static final int SECOND_PHONE_PROFILE__1__C2_TELEPHONY_HFP_AG;
    public static final int SECOND_PHONE_PROFILE__1__C3_TELEPHONY_HFP_HF;
    public static final int SECOND_PHONE_PROFILE__1__C4_TELEPHONY_HANDSET;
    public static final int SECOND_PHONE_PROFILE__1__C5_SIM_CARD_READY;
    public static final int SECOND_PHONE_PROFILE__2;
    public static final int SECOND_PHONE_PROFILE__2__DEFAULT_VALUE;
    public static final int SECOND_PHONE_PROFILE__2__C0_NO_PROFILE_CONNECTED;
    public static final int SECOND_PHONE_PROFILE__2__C1_TELEPHONY_SIMAP;
    public static final int SECOND_PHONE_PROFILE__2__C2_TELEPHONY_HFP_AG;
    public static final int SECOND_PHONE_PROFILE__2__C3_TELEPHONY_HFP_HF;
    public static final int SECOND_PHONE_PROFILE__2__C4_TELEPHONY_HANDSET;
    public static final int SECURE_SIMPLE_PAIRING_STATE;
    public static final int SECURE_SIMPLE_PAIRING_STATE__DEFAULT_VALUE;
    public static final int SECURE_SIMPLE_PAIRING_STATE__C0_NO_SECURE_SIMPLE_PAIRING;
    public static final int SECURE_SIMPLE_PAIRING_STATE__C1_SSP_SHOW_AND_CONFIRM;
    public static final int SECURE_SIMPLE_PAIRING_STATE__C2_SSP_SHOW_ONLY;
    public static final int SOFTWARE_DOWNLOAD_STATE;
    public static final int SOFTWARE_DOWNLOAD_STATE__DEFAULT_VALUE;
    public static final int SOFTWARE_DOWNLOAD_STATE__C0_NO_DOWNLOAD;
    public static final int SOFTWARE_DOWNLOAD_STATE__C1_DOWNLOAD_IN_PROGRESS;
    public static final int SOFTWARE_DOWNLOAD_STATE__C2_ERROR;
    public static final int STATE__1;
    public static final int STATE__1__DEFAULT_VALUE;
    public static final int STATE__1__C0_BT_ON;
    public static final int STATE__1__C1_BT_OFF;
    public static final int STATE__1__C2_BT_NOT_FUNCTIONAL;
    public static final int STATE__1__C3_BT_SWITCHING_ON;
    public static final int STATE__1__C4_BT_SWITCHING_OFF;
    public static final int STATE__1__C5_BT_DIAGNOSE_NOT_ON_ALLOWED;
    public static final int USER_ID;
    public static final String USER_ID__DEFAULT_VALUE;
    public static final int BONDING_PROFILE_SELECTION_UPDATED;
    public static final boolean BONDING_PROFILE_SELECTION_UPDATED__DEFAULT_VALUE;
    public static final boolean BONDING_PROFILE_SELECTION_UPDATED__C0_FALSE;
    public static final boolean BONDING_PROFILE_SELECTION_UPDATED__C1_TRUE;
    public static final int CONNECTING_PROFILE_POP_UP_VISIBLE;
    public static final boolean CONNECTING_PROFILE_POP_UP_VISIBLE__DEFAULT_VALUE;
    public static final int CONNECTION_ESTABLISHED;
    public static final boolean CONNECTION_ESTABLISHED__DEFAULT_VALUE;
    public static final int ENABLED;
    public static final boolean ENABLED__DEFAULT_VALUE;
    public static final int EXTERNAL_DEVICE_ALREADY_PAIRED;
    public static final boolean EXTERNAL_DEVICE_ALREADY_PAIRED__DEFAULT_VALUE;
    public static final int HU_CAPABLE_OF_SIMAP;
    public static final boolean HU_CAPABLE_OF_SIMAP__DEFAULT_VALUE;
    public static final int HU_SUPPORT_SIMAP;
    public static final boolean HU_SUPPORT_SIMAP__DEFAULT_VALUE;
    public static final int PIN_REQUIRED;
    public static final boolean PIN_REQUIRED__DEFAULT_VALUE;
    public static final int SEARCHING_DEVICES;
    public static final boolean SEARCHING_DEVICES__DEFAULT_VALUE;
    public static final int SELECTED_PROFILE_CONNECTION_POSSIBLE;
    public static final boolean SELECTED_PROFILE_CONNECTION_POSSIBLE__DEFAULT_VALUE;
    public static final int SELECTED_PROFILE_SECOND_CONNECTION_POSSIBLE;
    public static final boolean SELECTED_PROFILE_SECOND_CONNECTION_POSSIBLE__DEFAULT_VALUE;
    public static final int USER_ID_REQUIRED;
    public static final boolean USER_ID_REQUIRED__DEFAULT_VALUE;
}

