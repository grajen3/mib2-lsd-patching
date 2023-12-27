/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.navigation.waypointmode;

import de.vw.mib.properties.values.SpellerData;

public interface ASLNavigationWayPointModePropertyManager {
    public static final int TRACK_LIST__TRACK_LIST_NAME;
    public static final String TRACK_LIST__TRACK_LIST_NAME__DEFAULT_VALUE;
    public static final int TRACK_LIST__TRACK_LIST_NUMBER_OF_WAY_POINTS;
    public static final int TRACK_LIST__TRACK_LIST_NUMBER_OF_WAY_POINTS__DEFAULT_VALUE;
    public static final int ACTION_RESULT;
    public static final int ACTION_RESULT__DEFAULT_VALUE;
    public static final int ACTION_RESULT__C0_OK;
    public static final int ACTION_RESULT__C1_ERROR;
    public static final int CURRENT_MODE;
    public static final int CURRENT_MODE__DEFAULT_VALUE;
    public static final int CURRENT_MODE__C0_DEFAULT;
    public static final int CURRENT_MODE__C1_DRIVE;
    public static final int CURRENT_MODE__C2_RECORD;
    public static final int NUMBER_OF_TRACKS_IN_MEMORY;
    public static final int NUMBER_OF_TRACKS_IN_MEMORY__DEFAULT_VALUE;
    public static final int NUMBER_OF_FREE_WAY_POINTS_IN_MEMORY;
    public static final int NUMBER_OF_FREE_WAY_POINTS_IN_MEMORY__DEFAULT_VALUE;
    public static final int NUMBER_OF_FREE_WAY_POINTS_THRESHOLD_EXCEEDED;
    public static final boolean NUMBER_OF_FREE_WAY_POINTS_THRESHOLD_EXCEEDED__DEFAULT_VALUE;
    public static final boolean NUMBER_OF_FREE_WAY_POINTS_THRESHOLD_EXCEEDED__C0_FALSE;
    public static final boolean NUMBER_OF_FREE_WAY_POINTS_THRESHOLD_EXCEEDED__C1_TRUE;
    public static final int NUMBER_OF_MAXIMUM_WAY_POINTS_IN_MEMORY;
    public static final int NUMBER_OF_MAXIMUM_WAY_POINTS_IN_MEMORY__DEFAULT_VALUE;
    public static final int NUMBER_OF_NEXT_WAY_POINT_FOR_THIS_TOUR;
    public static final int NUMBER_OF_NEXT_WAY_POINT_FOR_THIS_TOUR__DEFAULT_VALUE;
    public static final int NUMBER_OF_ALL_WAY_POINTS_FOR_THIS_TOUR;
    public static final int NUMBER_OF_ALL_WAY_POINTS_FOR_THIS_TOUR__DEFAULT_VALUE;
    public static final int DISTANCE_TO_NEXT_WAY_POINTS_FOR_THIS_TOUR;
    public static final int DISTANCE_TO_NEXT_WAY_POINTS_FOR_THIS_TOUR__DEFAULT_VALUE;
    public static final int NUMBER_OF_SAVED_WAY_POINTS_FOR_THIS_RECORD;
    public static final int NUMBER_OF_SAVED_WAY_POINTS_FOR_THIS_RECORD__DEFAULT_VALUE;
    public static final int RECORD_MODE_DESTINATION_SET;
    public static final boolean RECORD_MODE_DESTINATION_SET__DEFAULT_VALUE;
    public static final boolean RECORD_MODE_DESTINATION_SET__C0_FALSE;
    public static final boolean RECORD_MODE_DESTINATION_SET__C1_TRUE;
    public static final int SPLIT_SCREEN;
    public static final boolean SPLIT_SCREEN__DEFAULT_VALUE;
    public static final boolean SPLIT_SCREEN__C0_FALSE;
    public static final boolean SPLIT_SCREEN__C1_TRUE;
    public static final int CURRENT_CONTENT_DEFAULT;
    public static final int CURRENT_CONTENT_DEFAULT__DEFAULT_VALUE;
    public static final int CURRENT_CONTENT_DEFAULT__C0_AUDIO;
    public static final int CURRENT_CONTENT_DEFAULT__C1_COMPASS;
    public static final int CURRENT_CONTENT_DEFAULT__C2_GPS;
    public static final int CURRENT_CONTENT_DRIVE_OR_RECORD;
    public static final int CURRENT_CONTENT_DRIVE_OR_RECORD__DEFAULT_VALUE;
    public static final int CURRENT_CONTENT_DRIVE_OR_RECORD__C0_AUDIO;
    public static final int CURRENT_CONTENT_DRIVE_OR_RECORD__C1_COMPASS;
    public static final int CURRENT_CONTENT_DRIVE_OR_RECORD__C2_GPS;
    public static final int CURRENT_CONTENT_DRIVE_OR_RECORD__C3_WAYPOINTINFO;
    public static final int WPM_INFO_DEGREE;
    public static final int WPM_INFO_DEGREE__DEFAULT_VALUE;
    public static final int WPM_INFO_DEGREE__MIN_VALUE;
    public static final int WPM_INFO_DEGREE__MAX_VALUE;
    public static final int WPM_INFO_DEGREE__STEP_SIZE;
    public static final int WPM_INFO_DIRECTION;
    public static final int WPM_INFO_DIRECTION__DEFAULT_VALUE;
    public static final int WPM_INFO_DIRECTION__MIN_VALUE;
    public static final int WPM_INFO_DIRECTION__MAX_VALUE;
    public static final int WPM_INFO_DIRECTION__STEP_SIZE;
    public static final int DELETION_STATUS;
    public static final int DELETION_STATUS__DEFAULT_VALUE;
    public static final int DELETION_STATUS__C0_IDLE;
    public static final int DELETION_STATUS__C1_DELETING;
    public static final int SELECTED_TRACK_READY_FOR_GUIDANCE_START;
    public static final boolean SELECTED_TRACK_READY_FOR_GUIDANCE_START__DEFAULT_VALUE;
    public static final boolean SELECTED_TRACK_READY_FOR_GUIDANCE_START__C0_FALSE;
    public static final boolean SELECTED_TRACK_READY_FOR_GUIDANCE_START__C1_TRUE;
    public static final int IMPORT_STATE;
    public static final int IMPORT_STATE__DEFAULT_VALUE;
    public static final int IMPORT_STATE__C0_IDLE;
    public static final int IMPORT_STATE__C1_IMPORTING;
    public static final int IMPORT_RESULT;
    public static final int IMPORT_RESULT__DEFAULT_VALUE;
    public static final int IMPORT_RESULT__C0_FINISH_SUCCESS;
    public static final int IMPORT_RESULT__C1_FINISH_FAIL_COMMON;
    public static final int IMPORT_RESULT__C2_FINISH_FAIL_MEMFULL;
    public static final int EXPORT_RESULT;
    public static final int EXPORT_RESULT__DEFAULT_VALUE;
    public static final int EXPORT_RESULT__C0_FINISH_SUCCESS;
    public static final int EXPORT_RESULT__C1_FINISH_ERROR;
    public static final int SPELLER_DATA;
    public static final SpellerData SPELLER_DATA__DEFAULT_VALUE;
    public static final int TRACK_LIST_RENAME_STRING;
    public static final String TRACK_LIST_RENAME_STRING__DEFAULT_VALUE;
    public static final int SPELLER_DATA_CHAR_ENTERED;
    public static final boolean SPELLER_DATA_CHAR_ENTERED__DEFAULT_VALUE;
    public static final boolean SPELLER_DATA_CHAR_ENTERED__C0_FALSE;
    public static final boolean SPELLER_DATA_CHAR_ENTERED__C1_TRUE;
    public static final int TOUR_LIST_NAME_EXISTS;
    public static final boolean TOUR_LIST_NAME_EXISTS__DEFAULT_VALUE;
    public static final boolean TOUR_LIST_NAME_EXISTS__C0_TRUE;
    public static final boolean TOUR_LIST_NAME_EXISTS__C1_FALSE;

    static {
        SPELLER_DATA__DEFAULT_VALUE = new SpellerData();
    }
}

