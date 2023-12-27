/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.dab.dsi;

interface Events {
    public static final int UP;
    public static final int DOWN;
    public static final int EV_DAB_ASL_START;
    public static final int EV_DAB_ASL_STOP;
    public static final int EV_DAB_ASL_FREQUENCY_STEP_UP;
    public static final int EV_DAB_ASL_FREQUENCY_STEP_DOWN;
    public static final int EV_DAB_ASL_START_CHANGING_FREQUENCY;
    public static final int P_STARTCHANGINGFREQUENCY_DIRECTION;
    public static final int P_STARTCHANGINGFREQUENCY_WRAP;
    public static final int EV_DAB_ASL_STOP_CHANGING_FREQUENCY;
    public static final int EV_DAB_ASL_START_TARGET_SEEK;
    public static final int P_STARTTARGETSEEK_DIRECTION;
    public static final int P_STARTTARGETSEEK_WRAP;
    public static final int P_STARTTARGETSEEK_STOPATNEXT;
    public static final int EV_DAB_ASL_STOP_TARGET_SEEK_AT_NEXT;
    public static final int EV_DAB_ASL_STOP_TARGET_SEEK;
    public static final int EV_DAB_ASL_TUNE_FREQUENCY;
    public static final int P_TUNEFREQUENCY_FREQUENCY;
    public static final int EV_DAB_ASL_SCAN;
    public static final int P_SCAN_ANSWERID;
    public static final int P_SCAN_MODE;
    public static final int EV_DAB_ASL_CANCEL_SCAN;
    public static final int EV_DAB_ASL_SELECT_SERVICE;
    public static final int P_SELECTSERVICE_SERVICE;
    public static final int EV_DAB_ASL_CANCEL_EMERGENCY_SEEK;
    public static final int EV_DAB_ASL_SELECT_COMPONENT;
    public static final int P_SELECTCOMPONENT_COMPONENT;
    public static final int EV_DAB_ASL_UPDATE_LEARN_MEMORY;
    public static final int P_UPDATELEARNMEMORY_TARGETIDFORANSWER;
    public static final int P_UPDATELEARNMEMORY_EVENTIDFORANSWER;
    public static final int P_UPDATELEARNMEMORY_MODE;
    public static final int EV_DAB_ASL_CANCEL_UPDATE_LEARN_MEMORY;
    public static final int EV_TIMEOUT_RESPONSE;
    public static final int P0_CURRENT_STATE;
    public static final int EV_DAB_ASL_SELECT_STORED_SERVICE;
    public static final int P_SELECTSTOREDSERVICE_STOREDSERVICE;
    public static final int EV_DAB_ASL_JUMP_LM;
    public static final int P_JUMP_LM_DIRECTION;
    public static final int EV_ABORT_TIMEOUT_RESPONSE;
    public static final int TIMEOUT_ABORT;
    public static final int EV_MUTE_TIMEOUT_RESPONSE;
    public static final int TIMEOUT_MUTE;
    public static final int EV_DAB_ASL_CANCEL_JUMP_LM;
    public static final int EV_DAB_ASL_LEAVE_MANUAL_MODE;
    public static final int EV_DAB_ASL_LEAVE_SCAN_MODE;
    public static final int EV_DAB_ASL_DDS_ROTATED;
    public static final int P_DDS_TICKS;
    public static final int EV_DAB_ASL_PREPARE_TUNING;
    public static final int EV_DAB_ASL_STEP_SERVICE;
    public static final int P0_STEPSERVICE_NEXT;
    public static final int EV_DAB_ASL_SELECT_SERVICE_BY_FREQUENCY;
    public static final int P_SELECTSERVICE_FREQUENCY;
    public static final int EV_DAB_ASL_ACTIVATE_TUNER;
    public static final int EV_DAB_ASL_DEACTIVATE_TUNER;
    public static final int EV_SCAN_PLAY_TIMEOUT;
    public static final int TIMEOUT_SCAN;
    public static final int EV_DAB_ASL_FAKESEARCHINGFORHIGH_TIMER;
}

