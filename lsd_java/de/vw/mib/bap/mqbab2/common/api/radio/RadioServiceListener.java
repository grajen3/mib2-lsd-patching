/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.common.api.radio;

import de.vw.mib.bap.mqbab2.common.api.hmi.HMIEventListener;
import de.vw.mib.bap.mqbab2.common.api.radio.RadioService;

public interface RadioServiceListener
extends HMIEventListener {
    public static final int RADIO_SERVICE__DAB_LIST_STATE;
    public static final int RADIO_SERVICE__AM_LIST_STATE;
    public static final int RADIO_SERVICE__CURRENT_AM_STATION_INFO;
    public static final int RADIO_SERVICE__AM_RADIO_TEXT_ARTIST_NAME;
    public static final int RADIO_SERVICE__AM_RADIO_TEXT_TITLE_NAME;
    public static final int RADIO_SERVICE__AM_HD_RADIO_STATE;
    public static final int RADIO_SERVICE__FM_FREQUENCY_SCALE;
    public static final int RADIO_SERVICE__CURRENT_FM_STATION_INFO;
    public static final int RADIO_SERVICE__FM_RADIO_TEXT_ARTIST_NAME;
    public static final int RADIO_SERVICE__FM_RADIO_TEXT_TITLE_NAME;
    public static final int RADIO_SERVICE__FM_HD_RADIO_STATE;
    public static final int RADIO_SERVICE__CURRENT_BAND;
    public static final int RADIO_SERVICE__CURRENT_STATION_INDICES;
    public static final int RADIO_SERVICE__TRAFFIC_ANNOUNCEMENT_ACTIVE;
    public static final int RADIO_SERVICE__TRAFFIC_ANNOUNCEMENT_SOURCE;
    public static final int RADIO_SERVICE__DAB_ANNOUNCEMENT_PLAYING;
    public static final int RADIO_SERVICE__CURRENT_DAB_ANNOUNCEMENT_TYPE;
    public static final int RADIO_SERVICE__CURRENT_DAB_ANNOUNCEMENT_STATION_NAME;
    public static final int RADIO_SERVICE__DAB_ENSEMBLE_STATE;
    public static final int RADIO_SERVICE__DAB_SERVICE_STATE;
    public static final int RADIO_SERVICE__DAB_ADDITIONAL_SERVICE_STATE;
    public static final int RADIO_SERVICE__CURRENT_DAB_STATION_INFO;
    public static final int RADIO_SERVICE__DAB_RADIO_TEXT_ARTIST_NAME;
    public static final int RADIO_SERVICE__DAB_RADIO_TEXT_TITLE_NAME;
    public static final int RADIO_SERVICE__TRAFFIC_INFORMATION_ACTIVE;
    public static final int RADIO_SERVICE__TRAFFIC_INFORMATION_FREQUENCY;
    public static final int RADIO_SERVICE__PTY_ANNOUNCEMENT_ACTIVE;
    public static final int RADIO_SERVICE__CURRENT_PTY_ANNOUNCEMENT_STATION_NAME;
    public static final int RADIO_SERVICE__CURRENT_PTY_ANNOUNCEMENT_FREQUENCY;
    public static final int RADIO_SERVICE__CURRENT_TRAFFIC_ANNOUNCEMENT_FREQUENCY;
    public static final int RADIO_SERVICE__CURRENT_TRAFFIC_ANNOUNCEMENT_STATION_NAME;
    public static final int RADIO_SERVICE__PI_CODING;
    public static final int RADIO_SERVICE__RDS_SETUP_OPTION_STATE;
    public static final int RADIO_SERVICE__RDS_SETUP_OPTION_AVAILABLE;
    public static final int RADIO_SERVICE__CURRENT_HD_RADIO_PS_TITLE_NAME;
    public static final int RADIO_SERVICE__CURRENT_HD_RADIO_PS_ARTIST_NAME;
    public static final int RADIO_SERVICE__RADIO_TEXT_PLUS_ACTIVE;
    public static final int RADIO_SERVICE__DAB_RADIO_TEXT_PLUS_ACTIVE;
    public static final int RADIO_SERVICE__RADIO_TEXT_PLUS_SETUP_ACTIVE;
    public static final int RADIO_SERVICE__RADIO_TEXT_SETUP_ACTIVE;
    public static final int RADIO_SERVICE__TP_STATE;
    public static final int RADIO_SERVICE__CURRENT_SAT_CHANNEL;
    public static final int RADIO_SERVICE__CURRENT_SAT_RADIO_TEXT;
    public static final int RADIO_SERVICE__SEEK_ACTIVE;
    public static final int RADIO_SERVICE__SCANNING_ACTIVE;
    public static final int RADIO_SERVICE__MANUAL_MODE_ACTIVE;
    public static final int RADIO_SERVICE__SIRIUS_PRESET_SELECTED_INDEX;
    public static final int RADIO_SERVICE__TRAFFIC_MESSAGE_RECORDING_ACTIVE;
    public static final int RADIO_SERVICE__TP_MEMO_LIST_SELECTED_INDEX;
    public static final int RADIO_SERVICE__TP_SETUP_OPTION_STATE;
    public static final int RADIO_SERVICE__SCOPE_OF_ARROW_KEY_MODE;
    public static final int RADIO_SERVICE__SAT_TUNER_STATE;
    public static final int RADIO_SERVICE__AM_PRESET_LIST;
    public static final int RADIO_SERVICE__DAB_PRESET_LIST;
    public static final int RADIO_SERVICE__FM_PRESET_LIST;
    public static final int RADIO_SERVICE__RECEPTION_LIST;
    public static final int RADIO_SERVICE__SIRIUS_PRESET_LIST;
    public static final int RADIO_SERVICE__TRAFFIC_MESSAGE_LIST;
    public static final int RADIO_SERVICE__HMI_EVENT__INITIAL_AUTOSTORE_STARTED;
    public static final int RADIO_SERVICE__HMI_EVENT__INITIAL_AUTOSTORE_FINISHED;
    public static final int RADIO_SERVICE__HMI_EVENT__INITIAL_AUTOSTORE_CANCELED;
    public static final int RADIO_SERVICE__HMI_EVENT__NEXT_AUDIO_SOURCE_THROUGH_MFL;
    public static final int RADIO_SERVICE__HMI_EVENT__NEXT_AUDIO_COMPONENT_THROUGH_MFL;

    default public void updateRadioData(RadioService radioService, int n) {
    }
}

