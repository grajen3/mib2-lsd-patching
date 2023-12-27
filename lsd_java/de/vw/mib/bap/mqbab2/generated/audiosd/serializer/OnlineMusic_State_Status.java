/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.audiosd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class OnlineMusic_State_Status
implements StatusProperty {
    public int state;
    public static final int STATE_ONLINE_MEDIA_ERROR_SWITCH_TO_FSG_DF4_5;
    public static final int STATE_ONLINE_MEDIA_OPERATION_ONLY_POSSIBLE_BY_FSG_DF4_5;
    public static final int STATE_ONLINE_MEDIA_SERVICE_IS_NOT_AVAILABLE_IN_THIS_COUNTRY_DF4_5;
    public static final int STATE_ONLINE_MEDIA_NO_DATA_VIA_WLAN_DF4_5;
    public static final int STATE_ONLINE_MEDIA_FUNCTION_TEMPORARY_NOT_AVAILABLE_DF4_5;
    public static final int STATE_ONLINE_MEDIA_PROVIDER_UNREACHABLE_DF4_5;
    public static final int STATE_ONLINE_MEDIA_NO_CONNECTION_TO_PROVIDER_DF4_5;
    public static final int STATE_ONLINE_MEDIA_NO_CONNECTION_DF4_5;
    public static final int STATE_ONLINE_MEDIA_CONFIGURE_NAPSTER_DF4_5;
    public static final int STATE_ONLINE_MEDIA_CONFIGURE_AUPEO_DF4_5;
    public static final int STATE_ONLINE_MEDIA_CHECK_APP_DF4_5;
    public static final int STATE_ONLINE_MEDIA_NO_ANSWER_FROM_APP_DF4_5;
    public static final int STATE_ONLINE_MEDIA_UNLOCK_DEVICE_DF4_5;
    public static final int STATE_ONLINE_MEDIA_NO_DATA_VOLUME_DF4_5;
    public static final int STATE_ONLINE_MEDIA_CONTENT_IS_BEING_LOADED_DF4_5;
    public static final int STATE_ONLINE_RADIO_ERROR_SWITCH_TO_FSG_DF4_5;
    public static final int STATE_ONLINE_RADIO_OPERATION_ONLY_POSSIBLE_BY_FSG_DF4_5;
    public static final int STATE_ONLINE_RADIO_STATION_IS_NOT_AVAILABLE_IN_THIS_COUNTRY_DF4_5;
    public static final int STATE_ONLINE_RADIO_FUNCTION_TEMPORARY_NOT_AVAILABLE_DF4_5;
    public static final int STATE_ONLINE_RADIO_PROVIDER_UNREACHABLE_DF4_5;
    public static final int STATE_ONLINE_RADIO_NO_LICENCE_DF4_5;
    public static final int STATE_ONLINE_RADIO_NO_CONNECTION_TO_PROVIDER_DF4_5;
    public static final int STATE_ONLINE_RADIO_NO_CONNECTION_DF4_5;
    public static final int STATE_ONLINE_RADIO_NO_DATA_VOLUME_DF4_5;
    public static final int STATE_ONLINE_RADIO_TESTPHASE_DF4_5;
    public static final int STATE_ONLINE_RADIO_CONTENT_IS_BEING_LOADED_DF4_5;
    public static final int STATE_SUBSCRIPTION_MISSING;
    public static final int STATE_AUTHENTIFICATION_FAILED;
    public static final int STATE_LOW_BANDWIDTH;
    public static final int STATE_NO_SIM_AVAILABLE;
    public static final int STATE_NO_NETWORK;
    public static final int STATE_BUFFERING_DATA_NO_PLAYBACK_OF_RECEIVED_DATA_YET;
    public static final int STATE_NO_DATA_RECEIVED_FROM_ONLINE_RADIO_SERVER_BUT_CONNECTION_IS_ESTABLISHED_SUCCESSFULLY;
    public static final int STATE_DATA_CONNECTION_SETUP_CONFIRMATION_IS_STILL_PENDING;
    public static final int STATE_CONNECTING_TO_NETWORK_CONNECTION_SETUP_IN_PROGRESS;
    public static final int STATE_NORMAL_OPERATION_PLAYBACK_OF_RECEIVED_DATA;
    public static final int STATE_ONLINE_RADIO_OFF_DISABLED;
    public int bufferLevel;
    public static final int BUFFER_LEVEL_MIN;
    public int dummy;
    public static final int DUMMY_MIN;

    public OnlineMusic_State_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public OnlineMusic_State_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.state = 0;
        this.bufferLevel = 0;
        this.dummy = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        OnlineMusic_State_Status onlineMusic_State_Status = (OnlineMusic_State_Status)bAPEntity;
        return this.state == onlineMusic_State_Status.state && this.bufferLevel == onlineMusic_State_Status.bufferLevel && this.dummy == onlineMusic_State_Status.dummy;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "OnlineMusic_State_Status:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.state);
        bitStream.pushByte((byte)this.bufferLevel);
        bitStream.pushShort((short)this.dummy);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.state = bitStream.popFrontByte();
        this.bufferLevel = bitStream.popFrontByte();
        this.dummy = bitStream.popFrontShort();
    }

    public static int functionId() {
        return 49;
    }

    @Override
    public int getFunctionId() {
        return OnlineMusic_State_Status.functionId();
    }
}

