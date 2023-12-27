/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.dab.main;

interface Events {
    public static final int EV_DAB_PUB_CANCEL_AUTOSTORE;
    public static final int EV_DAB_PUB_DO_AUTOSTORE;
    public static final int P_DOAUTOSTORE_SERVICES;
    public static final int EV_DAB_PUB_NOTIFY_COMPONENTLIST;
    public static final int P_NOTIFYCOMPONENTLIST_COMPONENTINFOARRAY;
    public static final int EV_DAB_PUB_NOTIFY_SERVICELIST;
    public static final int P_NOTIFYSERVICELIST_SERVICEINFOARRAY;
    public static final int EV_DAB_PUB_NOTIFY_PREPARE_TUNING_STATUS;
    public static final int P_NOTIFYPREPARETUNINGSTATUS_STATUS;
    public static final int EV_DAB_PUB_NOTIFY_SERVICE_SELECTED_UNSUCCESSFUL;
    public static final int EV_DAB_PUB_NOTIFY_DATASERVICELIST;
    public static final int EV_DAB_PUB_NOTIFY_ENSEMBLE_SELECTED;
    public static final int EV_DAB_PUB_NOTIFY_SERVICE_SELECTED;
    public static final int EV_DAB_PUB_NOTIFY_COMPONENT_SELECTED;
    public static final int EV_DAB_PUB_NOTIFY_SYNC_STATUS;
    public static final int P_NOTIFYSYNCSTATUS_STATUS;
    public static final int EV_DAB_PUB_NOTIFY_SELECT_SERVICE_DONE;
    public static final int P_NOTIFYSELECTSERVICEDONE_ENSEMBLE;
    public static final int P_NOTIFYSELECTSERVICEDONE_SERVICE;
    public static final int P_NOTIFYSELECTSERVICEDONE_COMPONENT;
    public static final int EV_DAB_PUB_NOTIFY_TUNER_ACTIVATED;
    public static final int EV_DAB_PUB_NOTIFY_TUNER_DEACTIVATED;
    public static final int EV_DAB_ASL_RESTART_TUNER;
    public static final int EV_DAB_ASL_PAUSE_TUNER;
    public static final int EV_DAB_PUB_NOTIFY_SELECT_SERVICE_RUNNING;
    public static final int EV_DAB_PUB_NOTIFY_SCAN_NEXT_SERVICE;
    public static final int EV_DAB_ASL_ANSWER_REQUEST_AUDIO_CONNECTION;
    public static final int EV_DAB_ASL_ANSWER_PERSISTENCE_PRELOAD;
    public static final int EV_DAB_ASL_SCAN_FINISHED;
    public static final int EV_DAB_ASL_ANSWER_UPDATE_LEARN_MEMORY;
    public static final int P0_LEARNMEMORY_UPDATE_STATUS;
    public static final int EV_DAB_ASL_UPDATE_DISPLAY;
    public static final int EV_DAB_ASL_DIAG_DATA;
    public static final int EV_DAB_ASL_ANSWER_PICTURESTORE;
    public static final int EV_DAB_ASL_RADIO_UPDATE_DAB_PRESET_BANK;
    public static final int EV_DAB_TIMER_SCAN;
    public static final int TIMEOUT_SCAN_PLAY_TIME;
    public static final int EV_DAB_TIMER_SERVICE_SELECTION_DONE;
    public static final int TIMEOUT_SERVICE_SELECTION_DONE;
    public static final int EV_DAB_ANSWER_FADE_TO_CONNECTION;
    public static final int EV_DAB_ASL_RADIO_SERVICE_FROM_LIST;
    public static final int EV_DAB_PUB_NOTIFY_CURRENT_PRESET;
    public static final int P_NOTIFYCURRENTPRESET_INDEX;
    public static final int EV_DAB_ASL_ANSWER_SEEK;
    public static final int EV_DAB_PUB_NOTIFY_FREQUENCY_LIST;
    public static final int EV_DAB_ASL_SEARCHING;
    public static final int P_SEARCHING;
}

