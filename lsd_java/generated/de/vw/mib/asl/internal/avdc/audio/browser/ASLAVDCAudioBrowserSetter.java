/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.avdc.audio.browser;

public interface ASLAVDCAudioBrowserSetter {
    public static final int ACTIVATE_BROWSER_FOR_DELETION;
    public static final int ACTIVATE_DVD_CHANGER_SLOT;
    public static final int ACTIVATE_DVD_CHANGER_SLOT__P0_SLOTNUMBER__INT;
    public static final int ACTIVATE_PARTITION_LIST;
    public static final int ACTIVATE_PARTITION_LIST__P0_TYPE__INT;
    public static final int ACTIVATE_PARTITION_LIST__TYPE__C0_CURRENT_AUDIO_SOURCE;
    public static final int ACTIVATE_PARTITION_LIST__TYPE__C1_AUDIO_SOURCE_BY_OBJECTID;
    public static final int ACTIVATE_PARTITION_LIST__TYPE__C2_CURRENT_BROWSING_SOURCE;
    public static final int ACTIVATE_PARTITION_LIST__TYPE__C3_BROWSING_SOURCE_BY_OBJECTID;
    public static final int ACTIVATE_PARTITION_LIST__TYPE__C4_CURRENT_IMPORT_SOURCE;
    public static final int ACTIVATE_PARTITION_LIST__TYPE__C5_IMPORT_SOURCE_BY_OBJECTID;
    public static final int ACTIVATE_PARTITION_LIST__P1_OBJECTID__LONG;
    public static final int BROWSE_DVD_CHANGER_SLOT;
    public static final int BROWSE_DVD_CHANGER_SLOT__P0_SLOTNUMBER__INT;
    public static final int EXIT_DELETE_BROWSER;
    public static final int EXIT_IMPORT_BROWSER;
    public static final int MOVE_FOLDER_LEVEL_UP;
    public static final int MOVE_FOLDER_LEVEL_UP__P0_STEPS__INT;
    public static final int MOVE_FOLDER_LEVEL_UP__STEPS__C0_DEVICE_SELECTION;
    public static final int MOVE_FOLDER_LEVEL_UP__STEPS__C1_ROOT;
    public static final int MOVE_FOLDER_LEVEL_UP__STEPS__C2_ONE_STEP_UP;
    public static final int MOVE_FOLDER_LEVEL_UP__STEPS__C3_TWO_STEP_UP;
    public static final int MOVE_FOLDER_LEVEL_UP__STEPS__C4_THREE_STEP_UP;
    public static final int OPEN_ALBUM;
    public static final int OPEN_ALBUM__P0_DYNAMICINDEX__INT;
    public static final int OPEN_FOLDER;
    public static final int OPEN_FOLDER__P0_DYNAMICINDEX__INT;
    public static final int OPEN_PLAYLIST;
    public static final int OPEN_PLAYLIST__P0_DYNAMICINDEX__INT;
    public static final int OPEN_SD_CARD;
    public static final int OPEN_SD_CARD__P0_DYNAMICINDEX__INT;
    public static final int PLAY_ALL;
    public static final int PLAY_ALL_FROM_ALBUM;
    public static final int PLAY_ALL_FROM_ALBUM__P0_INDEX__INT;
    public static final int PLAY_FILE;
    public static final int PLAY_FILE__P0_DYNAMICINDEX__INT;
    public static final int PLAY_FOLDER;
    public static final int PLAY_FOLDER__P0_DYNAMICINDEX__INT;
    public static final int SET_ACTIVE_BROWSER_TYPE;
    public static final int SET_ACTIVE_BROWSER_TYPE__P0_TYPE__INT;
    public static final int SET_ACTIVE_BROWSER_TYPE__TYPE__C0_BROWSING_TYPE_FOLDER;
    public static final int SET_ACTIVE_BROWSER_TYPE__TYPE__C1_BROWSING_TYPE_DATA_BASE;
    public static final int SET_MIX_MODE;
    public static final int SET_MIX_MODE__P0_MODE__INT;
    public static final int SET_MIX_MODE__MODE__C0_MIX_MODE_OFF;
    public static final int SET_MIX_MODE__MODE__C1_MIX_MODE_ON;
    public static final int SET_MIX_MODE__MODE__C2_MIX_MODE_MEDIUM;
    public static final int SET_MIX_MODE_ALBUM;
    public static final int SET_MIX_MODE_ALBUM__P0_INDEX__INT;
    public static final int SET_MIX_MODE_ALBUM__P1_MODE__INT;
    public static final int SET_MIX_MODE_ALBUM__MODE__C0_MIX_MODE_OFF;
    public static final int SET_MIX_MODE_ALBUM__MODE__C1_MIX_MODE_ON;
    public static final int SET_PLAY_MORE_LIKE_THIS_STATE;
    public static final int SET_PLAY_MORE_LIKE_THIS_STATE__P0_STATE__BOOLEAN;
    public static final int SET_RATING_FILTER;
    public static final int SET_RATING_FILTER__P0_RATING__INT;
    public static final int SET_RATING_FILTER__RATING__C0_NO_FILTER;
    public static final int SET_RATING_FILTER__RATING__C1_0_STAR_RATING;
    public static final int SET_RATING_FILTER__RATING__C2_1_STAR_RATING;
    public static final int SET_RATING_FILTER__RATING__C3_2_STAR_RATING;
    public static final int SET_RATING_FILTER__RATING__C4_3_STAR_RATING;
    public static final int SET_RATING_FILTER__RATING__C5_4_STAR_RATING;
    public static final int SET_RATING_FILTER__RATING__C6_5_STAR_RATING;
    public static final int SET_REPEAT_MODE;
    public static final int SET_REPEAT_MODE__P0_MODE__INT;
    public static final int SET_REPEAT_MODE__MODE__C0_REPEAT_MODE_OFF;
    public static final int SET_REPEAT_MODE__MODE__C1_REPEAT_MODE_FOLDER;
    public static final int SET_REPEAT_MODE__MODE__C2_REPEAT_MODE_FILE;
    public static final int SET_REPEAT_MODE_ALBUM;
    public static final int SET_REPEAT_MODE_ALBUM__P0_INDEX__INT;
    public static final int SET_REPEAT_MODE_ALBUM__P1_MODE__INT;
    public static final int SET_REPEAT_MODE_ALBUM__MODE__C0_REPEAT_MODE_OFF;
    public static final int SET_REPEAT_MODE_ALBUM__MODE__C1_REPEAT_MODE_FOLDER;
    public static final int SET_REPEAT_MODE_ALBUM__MODE__C2_REPEAT_MODE_FILE;
    public static final int SET_SELECTION;
    public static final int SET_SELECTION__P0_DYNAMICINDEX__INT;
    public static final int SET_SELECTION__P1_MODE__INT;
    public static final int SET_SELECTION__MODE__C0_NOT_SELECTED;
    public static final int SET_SELECTION__MODE__C1_FULLY_SELECTED;
    public static final int SET_SELECTION_ALL_ELEMENTS;
    public static final int SET_SELECTION_ALL_ELEMENTS__P0_MODE__INT;
    public static final int SET_SELECTION_ALL_ELEMENTS__MODE__C0_NOT_SELECTED;
    public static final int SET_SELECTION_ALL_ELEMENTS__MODE__C1_FULLY_SELECTED;
    public static final int SHOW_ALBUMS;
    public static final int SHOW_ALBUMS__P0_ARTISTINDEX__INT;
    public static final int SHOW_ARTISTS;
    public static final int SHOW_ARTISTS__P0_GENREINDEX__INT;
    public static final int SHOW_GENRES;
    public static final int SHOW_NOT_PLAYABLES;
    public static final int SHOW_PLAYLISTS;
    public static final int SHOW_TITLES;
    public static final int SHOW_VIDEOS;
    public static final int START_BUILDING_META_INFO_DB;
    public static final int START_FOLLOW_MODE;
    public static final int STOP_FOLLOW_MODE;
}

