/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.tvtuner;

public interface ASLTVTunerSetter {
    public static final int DUMMY;
    public static final int SET_BROWSER_LIST_SORTING_MODE;
    public static final int SET_BROWSER_LIST_SORTING_MODE__P0_BROWSERLISTSORTINGMODE__INT;
    public static final int SET_BROWSER_LIST_SORTING_MODE__BROWSERLISTSORTINGMODE__C0_BROWSER_LIST_SORTING_MODE_ALPHABETIC;
    public static final int SET_BROWSER_LIST_SORTING_MODE__BROWSERLISTSORTINGMODE__C1_BROWSER_LIST_SORTING_MODE_VARIANT_1;
    public static final int SET_BROWSER_LIST_SORTING_MODE__BROWSERLISTSORTINGMODE__C2_BROWSER_LIST_SORTING_MODE_VARIANT_2;
    public static final int SET_SELECTED_TV_NORM;
    public static final int SET_SELECTED_TV_NORM__P0_MODELID__INT;
    public static final int ACTIVATE_NEXT_STATION;
    public static final int ACTIVATE_PREVIOUS_STATION;
    public static final int DECREASE_FREQUENCY;
    public static final int INCREASE_FREQUENCY;
    public static final int MANUAL_TUNING_MODE_ENTERED;
    public static final int MANUAL_TUNING_MODE_EXITED;
    public static final int START_NON_STOP_SEEKING_UP;
    public static final int START_NON_STOP_SEEKING_DOWN;
    public static final int STOP_NON_STOP_SEEKING_BOTH_DIRECTIONS;
    public static final int SET_TV_SERVICE_LINKING_STATE;
    public static final int SET_TV_SERVICE_LINKING_STATE__P0_ACTIVATIONSTATE__BOOLEAN;
    public static final boolean SET_TV_SERVICE_LINKING_STATE__ACTIVATIONSTATE__C0_ACTIVATE;
    public static final boolean SET_TV_SERVICE_LINKING_STATE__ACTIVATIONSTATE__C1_DEACTIVATE;
    public static final int SET_VISUAL_AUDIO_SHOW_PICTURES_STATE;
    public static final int SET_VISUAL_AUDIO_SHOW_PICTURES_STATE__P0_ACTIVATIONSTATE__BOOLEAN;
    public static final boolean SET_VISUAL_AUDIO_SHOW_PICTURES_STATE__ACTIVATIONSTATE__C0_ACTIVATE;
    public static final boolean SET_VISUAL_AUDIO_SHOW_PICTURES_STATE__ACTIVATIONSTATE__C1_DEACTIVATE;
    public static final int SET_SHOW_EWS_MESSAGE_STATE;
    public static final int SET_SHOW_EWS_MESSAGE_STATE__P0_ACTIVATIONSTATE__BOOLEAN;
    public static final boolean SET_SHOW_EWS_MESSAGE_STATE__ACTIVATIONSTATE__C0_ACTIVATE;
    public static final boolean SET_SHOW_EWS_MESSAGE_STATE__ACTIVATIONSTATE__C1_DEACTIVATE;
    public static final int SET_TERMINAL_MODE_ENTERED_STATE;
    public static final int SET_TERMINAL_MODE_ENTERED_STATE__P0_ENTEREDSTATE__BOOLEAN;
    public static final boolean SET_TERMINAL_MODE_ENTERED_STATE__ENTEREDSTATE__C0_ENTERED;
    public static final boolean SET_TERMINAL_MODE_ENTERED_STATE__ENTEREDSTATE__C1_NOT_ENTERED;
    public static final int SET_TV_SUBTITLE_STATE;
    public static final int SET_TV_SUBTITLE_STATE__P0_ACTIVATIONSTATE__BOOLEAN;
    public static final boolean SET_TV_SUBTITLE_STATE__ACTIVATIONSTATE__C0_ACTIVATE;
    public static final boolean SET_TV_SUBTITLE_STATE__ACTIVATIONSTATE__C1_DEACTIVATE;
    public static final int STATION_LIST_ENTERED;
    public static final int STATION_LIST_EXITED;
    public static final int PRESET_STORE_LIST_ENTERED;
    public static final int TV_SETUP_DELETE_ALL_PRESETS;
    public static final int INCREASE_TV_BRIGHTNESS;
    public static final int DECREASE_TV_BRIGHTNESS;
    public static final int INCREASE_TV_CONTRAST;
    public static final int DECREASE_TV_CONTRAST;
    public static final int SET_TMCAS;
    public static final int CLOSE_EWS_MESSAGE;
    public static final int ABORT_MANUAL_SEEK;
    public static final int INCREASE_TV_SATURATION;
    public static final int DECREASE_TV_SATURATION;
    public static final int PRESET_STORE_LIST_EXITED;
    public static final int TV_CONTEXT_ENTERED;
    public static final int TV_CONTEXT_LEFT;
    public static final int SET_SELECTED_SERVICE_LIST_ENTRY;
    public static final int SET_SELECTED_SERVICE_LIST_ENTRY__P0_INDEX__INT;
    public static final int SET_SELECTED_SERVICE_LIST_ENTRY__P1_NAMEPID__LONG;
    public static final int SET_SELECTED_SERVICE_LIST_ENTRY__P2_SERVICEPID__INT;
    public static final int SET_SELECTED_SERVICE_LIST_ENTRY__P3_STYPE__INT;
    public static final int SET_SELECTED_SERVICES_LIST_ENTRY;
    public static final int SET_SELECTED_SERVICES_LIST_ENTRY__P0_INDEX__INT;
    public static final int SET_SELECTED_SERVICES_LIST_ENTRY__P1_NAMEPID__LONG;
    public static final int SET_SELECTED_SERVICES_LIST_ENTRY__P2_SERVICEPID__INT;
    public static final int SET_SELECTED_SERVICES_LIST_ENTRY__P3_STYPE__INT;
    public static final int SET_SELECTED_SERVICES_LIST_ENTRY__P4_SAVESTATION__BOOLEAN;
    public static final int SET_SELECTED_STATION_LIST_ENTRY;
    public static final int SET_SELECTED_STATION_LIST_ENTRY__P0_INDEX__INT;
    public static final int SET_SELECTED_PRESET_LIST_ENTRY;
    public static final int SET_SELECTED_PRESET_LIST_ENTRY__P0_INDEX__INT;
    public static final int TV_SETUP_DELETE_PRESET;
    public static final int TV_SETUP_DELETE_PRESET__P0_INDEX__INT;
    public static final int STORE_STATION_LIST_ENTRY;
    public static final int STORE_STATION_LIST_ENTRY__P0_INDEX__INT;
    public static final int SET_SELECTED_AUDIO_CHANNEL;
    public static final int SET_SELECTED_AUDIO_CHANNEL__P0_INDEX__INT;
    public static final int SET_SELECTED_PRESET_STORE_LIST_ENTRY;
    public static final int SET_SELECTED_PRESET_STORE_LIST_ENTRY__P0_INDEX__INT;
    public static final int SET_SCOPE_OF_ARROW_KEY_MODE;
    public static final int SET_SCOPE_OF_ARROW_KEY_MODE__P0_ACTIVATIONSTATE__INT;
    public static final int SET_SCOPE_OF_ARROW_KEY_MODE__ACTIVATIONSTATE__C0_STATE_SKIP_PRESET_LIST_ELEMENTS;
    public static final int SET_SCOPE_OF_ARROW_KEY_MODE__ACTIVATIONSTATE__C1_STATE_SKIP_STATION_LIST_ELEMENTS;
    public static final int SET_ASPECT_RATIO_MODE;
    public static final int SET_ASPECT_RATIO_MODE__P0_ASPECTRATIOSTATE__INT;
    public static final int SET_ASPECT_RATIO_MODE__ASPECTRATIOSTATE__C0_ASPECT_RATIO_MODE_AUTO;
    public static final int SET_ASPECT_RATIO_MODE__ASPECTRATIOSTATE__C1_ASPECT_RATIO_MODE_16_TO_9;
    public static final int SET_ASPECT_RATIO_MODE__ASPECTRATIOSTATE__C2_ASPECT_RATIO_MODE_4_TO_3;
    public static final int SET_AV_ASPECT_RATIO_MODE;
    public static final int SET_AV_ASPECT_RATIO_MODE__P0_AVASPECTRATIOSTATE__INT;
    public static final int SET_AV_ASPECT_RATIO_MODE__AVASPECTRATIOSTATE__C0_ASPECT_RATIO_MODE_AUTO;
    public static final int SET_AV_ASPECT_RATIO_MODE__AVASPECTRATIOSTATE__C1_ASPECT_RATIO_MODE_16_TO_9;
    public static final int SET_AV_ASPECT_RATIO_MODE__AVASPECTRATIOSTATE__C2_ASPECT_RATIO_MODE_4_TO_3;
    public static final int SET_TERMINAL_MODE;
    public static final int SET_TERMINAL_MODE__P0_TERMINALMODE__INT;
    public static final int SET_TERMINAL_MODE__TERMINALMODE__C0_TM_OFF;
    public static final int SET_TERMINAL_MODE__TERMINALMODE__C1_TM_TELETXT;
    public static final int SET_TERMINAL_MODE__TERMINALMODE__C2_TM_DVB;
    public static final int SET_TERMINAL_MODE__TERMINALMODE__C3_TM_ISDB;
    public static final int SET_TERMINAL_MODE__TERMINALMODE__C4_TM_CMMB;
    public static final int SET_TERMINAL_MODE__TERMINALMODE__C5_TM_DMB;
    public static final int SET_TERMINAL_MODE__TERMINALMODE__C6_TM_ATSC;
    public static final int SET_TERMINAL_MODE__TERMINALMODE__C7_TM_DB1;
    public static final int SET_TERMINAL_MODE__TERMINALMODE__C8_TM_DB2;
    public static final int SET_TERMINAL_MODE__TERMINALMODE__C9_TM_BWS;
    public static final int SET_TERMINAL_MODE__TERMINALMODE__C10_TM_SLS;
    public static final int SET_TERMINAL_MODE__TERMINALMODE__C11_TM_TXT;
    public static final int SET_TERMINAL_MODE__TERMINALMODE__C12_TM_CAS;
    public static final int SET_TERMINAL_MODE__TERMINALMODE__C13_TM_EPG;
    public static final int SET_TERMINAL_MODE__TERMINALMODE__C14_TM_VA;
    public static final int SET_TERMINAL_MODE__TERMINALMODE__C15_TM_ENG;
    public static final int SET_AV_NORM;
    public static final int SET_AV_NORM__P0_AVNORMSTATE__INT;
    public static final int SET_AV_NORM__AVNORMSTATE__C0_AUTO;
    public static final int SET_AV_NORM__AVNORMSTATE__C1_PAL;
    public static final int SET_AV_NORM__AVNORMSTATE__C2_NTSC;
    public static final int SET_TV_BRIGHTNESS;
    public static final int SET_TV_BRIGHTNESS__P0_VALUE__INT;
    public static final int SET_TV_CONTRAST;
    public static final int SET_TV_CONTRAST__P0_VALUE__INT;
    public static final int SET_TV_SATURATION;
    public static final int SET_TV_SATURATION__P0_VALUE__INT;
    public static final int SET_SOURCE;
    public static final int SET_SOURCE__P0_SOURCE__INT;
    public static final int SET_SOURCE__SOURCE__C0_SOURCE_TYPE_TV;
    public static final int SET_SOURCE__SOURCE__C1_SOURCE_TYPE_AV;
    public static final int SET_INC_MOVED;
    public static final int SET_INC_MOVED__P0_STEP__INT;
    public static final int SET_INC_MOVED__STEP__C0_TURN_LEFT;
    public static final int SET_INC_MOVED__STEP__C1_TURN_RIGHT;
    public static final int SET_INC_MOVED__STEP__C2_TURN_NOTHING;
    public static final int SET_TMTV_KEY;
    public static final int SET_TMTV_KEY__P0_STATE__INT;
    public static final int SET_TMTV_KEY__STATE__C0_RELEASED;
    public static final int SET_TMTV_KEY__STATE__C1_PRESSED;
    public static final int SET_TMTV_KEY__P1_ID__INT;
    public static final int SET_TMTV_KEY__ID__C0_YELLOW;
    public static final int SET_TMTV_KEY__ID__C1_GREEN;
    public static final int SET_TMTV_KEY__ID__C2_RED;
    public static final int SET_TMTV_KEY__ID__C3_BLUE;
    public static final int SET_TMTV_KEY__ID__C4_BACK;
    public static final int SET_TMTV_KEY__ID__C5_ENTER;
    public static final int SET_TMTV_KEY__ID__C6_HOME;
    public static final int SET_TMTV_KEY__ID__C7_NEXT;
    public static final int SET_TMTV_KEY__ID__C8_PREVIOUS;
    public static final int SET_TMTV_KEY__ID__C9_SETUP;
    public static final int SET_TMTV_KEY__ID__C10_MENU;
    public static final int SET_TMTV_KEY__ID__C11_JS_NORTH;
    public static final int SET_TMTV_KEY__ID__C12_JS_SOUTH;
    public static final int SET_TMTV_KEY__ID__C13_JS_WEST;
    public static final int SET_TMTV_KEY__ID__C14_JS_EAST;
    public static final int SET_TMTV_KEY__ID__C15_JS_NORTH_EAST;
    public static final int SET_TMTV_KEY__ID__C16_JS_NORTH_WEST;
    public static final int SET_TMTV_KEY__ID__C17_JS_SOUTH_EAST;
    public static final int SET_TMTV_KEY__ID__C18_JS_SOUTH_WEST;
    public static final int SET_TMTV_KEY__ID__C19_NUM_1;
    public static final int SET_TMTV_KEY__ID__C20_NUM_2;
    public static final int SET_TMTV_KEY__ID__C21_NUM_3;
    public static final int SET_TMTV_KEY__ID__C22_NUM_4;
    public static final int SET_TMTV_KEY__ID__C23_NUM_5;
    public static final int SET_TMTV_KEY__ID__C24_NUM_6;
    public static final int SET_TMTV_KEY__ID__C25_NUM_7;
    public static final int SET_TMTV_KEY__ID__C26_NUM_8;
    public static final int SET_TMTV_KEY__ID__C27_NUM_9;
    public static final int SET_TMTV_KEY__ID__C28_NUM_0;
    public static final int SET_TMTV_KEY__ID__C29_NUM_MINUS_SLASH_MINUS;
    public static final int SET_TMTV_KEY__ID__C30_START;
    public static final int SET_TMTV_KEY__ID__C31_STOP;
    public static final int SET_TMTV_KEY__ID__C32_MIX_ON;
    public static final int SET_TMTV_KEY__ID__C33_MIX_OFF;
    public static final int SET_TMTV_KEY__ID__C34_D;
    public static final int SET_TMTV_KEY__ID__C35_TM_ZOOM;
    public static final int SET_TMTV_KEY__ID__C36_PAGE_FLIP_UP;
    public static final int SET_TMTV_KEY__ID__C37_PAGE_FLIP_DOWN;
    public static final int SET_TMTV_KEY__ID__C38_PAGE_FLIP_WEST;
    public static final int SET_TMTV_KEY__ID__C39_PAGE_FLIP_EAST;
    public static final int SET_TMTV_KEY__ID__C40_DUMMY;
    public static final int SET_TM_CANVAS_XY_DELTA;
    public static final int SET_TM_CANVAS_XY_DELTA__P0_DELTAX__INT;
    public static final int SET_TM_CANVAS_XY_DELTA__P1_DELTAY__INT;
    public static final int SET3D_GESTURE;
    public static final int SET3D_GESTURE__P0_DIRECTION__INT;
    public static final int SET3D_GESTURE__DIRECTION__C0_LEFT;
    public static final int SET3D_GESTURE__DIRECTION__C1_RIGHT;
    public static final int DTV_MAIN_ENTERED;
}
