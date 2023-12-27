/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.audiosd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class InfoStates_Status
implements StatusProperty {
    public int states;
    public static final int STATES_UNKNOWN;
    public static final int STATES_ONLINE_MEDIA_NO_DEVICE_DF4_5;
    public static final int STATES_FILEPLAYER_ACTIVE_DF4_5;
    public static final int STATES_A2LS_TRANSMISSION_ACTIVE_DF4_5;
    public static final int STATES_MESSAGE_READ_ALOUD_DF4_5;
    public static final int STATES_NO_APP_ACTIVATED_DF4_4;
    public static final int STATES_FILES_BEING_USED_AS_RINGTONE_DF_4_1;
    public static final int STATES_SDARS_TUNER_IS_BEING_INITALISED_DF_4_1;
    public static final int STATES_MEDIA_DEVICE_IS_BEING_CONNECTED_DF_4_1;
    public static final int STATES_HANDBOOK_VIDEO_ACTIVE;
    public static final int STATES_EXTERNAL_DEVICE_FIRMWARE_ERROR;
    public static final int STATES_EXTERNAL_DEVICE_NOT_SUPPORTED;
    public static final int STATES_TEMPERATURE_TOO_LOW;
    public static final int STATES_WLAN_PLAYER_DEACTIVATED;
    public static final int STATES_BT_AUTOMATIC_RECONNECT;
    public static final int STATES_BT_AUDIO_PLAYER_DEACTIVATED;
    public static final int STATES_JUKEBOX_IS_STILL_EMPTY;
    public static final int STATES_JUBEBOX_IS_BEEING_DELETED;
    public static final int STATES_MEDIUM_WRITE_PROTECTED_SD_CARD_WRITE_PROTECTED;
    public static final int STATES_NO_TP_TIM_MESSAGE_S_RECORDED;
    public static final int STATES_ANTENNA_ERROR_SDARS;
    public static final int STATES_SUBSCRIPTION_UPDATE_PSV_UPDATE_SDARS;
    public static final int STATES_CABLE_ERROR;
    public static final int STATES_OVERCURRENT;
    public static final int STATES_UNSPECIFIC_WLAN_ERROR;
    public static final int STATES_WLAN_DEACTIVATED;
    public static final int STATES_WLAN_S_CONTACT_MISSING;
    public static final int STATES_NO_WLAN_PLAYER_IN_SYSTEM;
    public static final int STATES_WLAN_CONNECT_IN_PROGRESS;
    public static final int STATES_CHILDLOCK_ERROR;
    public static final int STATES_IMPORT_RUNNING;
    public static final int STATES_FILE_IS_DRM_PROTECTED;
    public static final int STATES_FILE_CORRUPTED;
    public static final int STATES_NO_BT_AUDIO_PLAYER_CONNECTED;
    public static final int STATES_BLUETOOTH_OFF_DUE_TO_CLAMP_S_OFF;
    public static final int STATES_BLUETOOTH_DEACTIVATED;
    public static final int STATES_BLUETOOTH_ERROR_UNSPECIFIED;
    public static final int STATES_NO_DEVICE_CONECTED;
    public static final int STATES_CONNECTION_ERROR_WIRELESS_CONNECTION;
    public static final int STATES_CONNECTION_ERROR_WIRED_CONNECTION;
    public static final int STATES_WRONG_REGION_CODE_NO_CHANGES_LEFT;
    public static final int STATES_WRONG_REGION_CODE_SOME_CHANGES_LEFT;
    public static final int STATES_NO_PLAYABLE_FILES;
    public static final int STATES_SDS_INITIALISING_SDS_IS_BEING_INITIALISED;
    public static final int STATES_TA_MESSAGE_IS_BEING_RECORDED;
    public static final int STATES_SOFTWARE_UPDATE_IN_PROGRESS;
    public static final int STATES_DIAGNOSIS_SESSION_ACTIVE;
    public static final int STATES_NO_SAT_RADIO_AVAILABLE_NO_SAT_TUNER_CONNECTED;
    public static final int STATES_CREATING_INITIAL_AUTO_STORE_LIST;
    public static final int STATES_CREATING_AUTO_STORE_LIST;
    public static final int STATES_SHUTTING_DOWN;
    public static final int STATES_RETRIEVING_DATA;
    public static final int STATES_SAVING_DATA;
    public static final int STATES_REMOVE_DISK;
    public static final int STATES_SELECT_CD_POSITION;
    public static final int STATES_SELECT_DISK;
    public static final int STATES_INSERT_DISK;
    public static final int STATES_PLEASE_WAIT;
    public static final int STATES_ENTER_CODE;
    public static final int STATES_AUX_IN_VIDEO;
    public static final int STATES_AUX_IN_AUDIO;
    public static final int STATES_GCI_UPDATE_IN_PROGRESS_SDARS;
    public static final int STATES_XM_NOT_SUBSCRIBED_SDARS;
    public static final int STATES_SIRIUS_NOT_SUBSCRIBED_SDARS;
    public static final int STATES_NO_STORAGE_SPACE_ON_MEDIUM_LEFT_SD_CARD_FULL;
    public static final int STATES_TEMPERATURE_TOO_HIGH;
    public static final int STATES_MEDIA_IS_BEING_EJECTED;
    public static final int STATES_MEDIA_IS_BEING_LOADED;
    public static final int STATES_MEDIA_NOT_READABLE;
    public static final int STATES_NO_MEDIA_INSERTED;
    public static final int STATES_NO_MEDIA;
    public static final int STATES_CHECK_MEDIA;
    public static final int STATES_NO_SD;
    public static final int STATES_NO_DVD;
    public static final int STATES_NO_CD;
    public static final int STATES_ERROR_UNSPECIFIED;
    public static final int STATES_NO_ERROR;

    public InfoStates_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public InfoStates_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.states = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        InfoStates_Status infoStates_Status = (InfoStates_Status)bAPEntity;
        return this.states == infoStates_Status.states;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "InfoStates_Status:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.states);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.states = bitStream.popFrontByte();
    }

    public static int functionId() {
        return 30;
    }

    @Override
    public int getFunctionId() {
        return InfoStates_Status.functionId();
    }
}

