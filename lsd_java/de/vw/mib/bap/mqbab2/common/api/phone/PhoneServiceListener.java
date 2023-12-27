/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.common.api.phone;

import de.vw.mib.bap.mqbab2.common.api.hmi.HMIEventListener;
import de.vw.mib.bap.mqbab2.common.api.phone.PhoneService;

public interface PhoneServiceListener
extends HMIEventListener {
    public static final int PHONE_SERVICE__DEVICE_NAME;
    public static final int PHONE_SERVICE__EXTERNAL_DEVICE_NAME;
    public static final int PHONE_SERVICE__CONNECTING_PROFILE_POP_UP_VISIBLE;
    public static final int PHONE_SERVICE__TELEPHONE_FEATURES;
    public static final int PHONE_SERVICE__CURRENT_PHONE_PROFILE;
    public static final int PHONE_SERVICE__CURRENT_PHONE_MEDIA_PROFILE;
    public static final int PHONE_SERVICE__CURRENT_PHONE_OTHER_PROFILE;
    public static final int PHONE_SERVICE__DATA_VOLUME_STATE;
    public static final int PHONE_SERVICE__DATA_VOLUME_UPLINK;
    public static final int PHONE_SERVICE__DATA_VOLUME_DOWNLINK;
    public static final int PHONE_SERVICE__LAST_DIALED_NUMBER_INFORMATION;
    public static final int PHONE_SERVICE__PHONE_LINE_FREE;
    public static final int PHONE_SERVICE__NETWORK_STATE;
    public static final int PHONE_SERVICE__NETWORK_NAME;
    public static final int PHONE_SERVICE__NETWORK_TYPE;
    public static final int PHONE_SERVICE__DIALING_FAILED_REASONS;
    public static final int PHONE_SERVICE__SELECTED_NUMBER_TYPE;
    public static final int PHONE_SERVICE__EMERGENCY_NUMBER;
    public static final int PHONE_SERVICE__SERVICE_NUMBER;
    public static final int PHONE_SERVICE__INFO_NUMBER;
    public static final int PHONE_SERVICE__MAILBOX_NUMBER;
    public static final int PHONE_SERVICE__NETWORK_ACCESS_DEVICE_STATE;
    public static final int PHONE_SERVICE__PHONE_ACTIVATION_STATE;
    public static final int PHONE_SERVICE__BLUETOOTH_STATE;
    public static final int PHONE_SERVICE__BLUETOOTH_VISIBILITY;
    public static final int PHONE_SERVICE__PRIVACY_MODE_ACTIVATION;
    public static final int PHONE_SERVICE__SIM_TYPE;
    public static final int PHONE_SERVICE__SOFTWARE_DOWNLOAD_STATE;
    public static final int PHONE_SERVICE__REMOTE_SIM_ACCESS_PROFILE_SUPPORT;
    public static final int PHONE_SERVICE__SIM_CARD_STATE;
    public static final int PHONE_SERVICE__EXTERNAL_PHONE_AVAILABILITY;
    public static final int PHONE_SERVICE__INTERNAL_PHONE_AVAILABILITY;
    public static final int PHONE_SERVICE__NETWORKING_INTERNAL_SIM_DATA_MODE_ONLY;
    public static final int PHONE_SERVICE__CURRENT_PHONE_CALL_COUNT;
    public static final int PHONE_SERVICE__HANDFREE_AUDIO_MODE;
    public static final int PHONE_SERVICE__PHONE_LOCK_STATE;
    public static final int PHONE_SERVICE__MICROPHONE_MUTE;
    public static final int PHONE_SERVICE__RINGTONE_MUTE;
    public static final int PHONE_SERVICE__MISSED_CALLS_COUNT;
    public static final int PHONE_SERVICE__BATTERY_LEVEL_WARNING;
    public static final int PHONE_SERVICE__BATTERY_LEVEL;
    public static final int PHONE_SERVICE__ACTIVE_CALL;
    public static final int PHONE_SERVICE__SIGNAL_STRENGTH_AVAILABILITY;
    public static final int PHONE_SERVICE__SIGNAL_STRENGTH;
    public static final int PHONE_SERVICE__CONTACTS_DOWNLOAD_STATUS;
    public static final int PHONE_SERVICE__MESSAGING_AVAILABILITY;
    public static final int PHONE_SERVICE__NEW_MESSAGES_COUNT;
    public static final int PHONE_SERVICE__MESSAGES_STORAGE_FULL;
    public static final int PHONE_SERVICE__CALL_FORWARDING_AVAILABILITY;
    public static final int PHONE_SERVICE__DATA_CONNECTION_TYPE;
    public static final int PHONE_SERVICE__CALL_INFORMATIONS;
    public static final int PHONE_SERVICE__CONFERENCE_CALL_INFORMATION;
    public static final int PHONE_SERVICE__DIALED_CALLS;
    public static final int PHONE_SERVICE__MISSED_CALLS;
    public static final int PHONE_SERVICE__MIXED_CALLS;
    public static final int PHONE_SERVICE__RECEIVED_CALLS;
    public static final int PHONE_SERVICE__PHONE_PRESETS;
    public static final int PHONE_SERVICE__CALL_FORWARDINGS;
    public static final int PHONE_SERVICE__HMI_EVENT__PHONE_CALL_ACCEPT_FAILED;
    public static final int PHONE_SERVICE__HMI_EVENT__PHONE_CALL_HOLD_FAILED;
    public static final int PHONE_SERVICE__HMI_EVENT__PHONE_CALL_JOIN_FAILED;
    public static final int PHONE_SERVICE__HMI_EVENT__PHONE_CALL_SPLIT_FAILED;
    public static final int PHONE_SERVICE__HMI_EVENT__PHONE_CALL_HANGUP_FAILED;
    public static final int PHONE_SERVICE__HMI_EVENT__PHONE_CALL_DIALING_FAILED;
    public static final int PHONE_SERVICE__HMI_EVENT__EMERGENCY_CALL_CONFIRMATION_CLOSE_DIALOG;
    public static final int PHONE_SERVICE__HMI_EVENT__EMERGENCY_CALL_CONFIRMATION_REQUIRED;
    public static final int PHONE_SERVICE__HMI_EVENT__PHONE_INIT_UPDATE;
    public static final int PHONE_SERVICE__HMI_EVENT__BLUETOOTH_CONNECTION_FAILED;
    public static final int PHONE_SERVICE__HMI_EVENT__BLUETOOTH_BONDING_FAILED;
    public static final int PHONE_SERVICE__HMI_EVENT__MESSAGE_SMS_MEMORY_FULL;

    default public void updatePhoneData(PhoneService phoneService, int n) {
    }
}

