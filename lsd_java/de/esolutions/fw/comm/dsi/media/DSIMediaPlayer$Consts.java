/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.media;

public interface DSIMediaPlayer$Consts {
    public static final String VERSION;
    public static final int PLAYERID_TERMINAL_LEFT;
    public static final int PLAYERID_TERMINAL_RIGHT;
    public static final int PHYSICALPLAYERID_1;
    public static final int PHYSICALPLAYERID_2;
    public static final int PHYSICALPLAYERID_EXTERNAL;
    public static final int PLAYVIEWFLAG_NONE;
    public static final int PLAYVIEWFLAG_FILESYSTEM_UPDATE;
    public static final int PLAYVIEWFLAG_METADATA_UPDATE;
    public static final int PLAYVIEWFLAG_FORCE_GETALL;
    public static final int PLAYVIEWFLAG_NO_PLAYABLE_FILES_LEFT;
    public static final int PLAYVIEWFLAG_COVERART_UPDATE;
    public static final int DVDEVENT_UNKNOWN;
    public static final int DVDEVENT_MENU_SELECTION;
    public static final int PLAYMODEFLAG_REPEAT;
    public static final int PLAYMODEFLAG_SHUFFLE;
    public static final int PLAYBACKSCOPE_FILE;
    public static final int PLAYBACKSCOPE_DEVICE;
    public static final int PLAYBACKSCOPE_MEDIUM;
    public static final int PLAYBACKSCOPE_SELECTION;
    public static final int PLAYBACKMODE_TAKEOVER;
    public static final int PLAYBACKMODE_TOGGLE_NEXT_REPEAT;
    public static final int PLAYBACKMODE_TOGGLE_NEXT_RANDOM;
    public static final int DVDCMD_NONE;
    public static final int DVDCMD_TIME_PLAY_SEARCH;
    public static final int DVDCMD_PTT_PLAY_SEARCH;
    public static final int DVDCMD_TITLE_SEARCH;
    public static final int DVDCMD_STOP;
    public static final int DVDCMD_GO_UP;
    public static final int DVDCMD_TIME_PTT_SEARCH;
    public static final int DVDCMD_PREV_TOP_PG_SEARCH;
    public static final int DVDCMD_NEXT_PG_SEARCH;
    public static final int DVDCMD_FORWARD_SCAN;
    public static final int DVDCMD_BACKWARD_SCAN;
    public static final int DVDCMD_MENU_CALL_TITLE;
    public static final int DVDCMD_MENU_CALL_ROOT;
    public static final int DVDCMD_MENU_CALL_SUB_PICTURE;
    public static final int DVDCMD_MENU_CALL_AUDIO;
    public static final int DVDCMD_MENU_CALL_ANGLE;
    public static final int DVDCMD_MENU_CALL_PTT;
    public static final int DVDCMD_RESUME;
    public static final int DVDCMD_BUTTON;
    public static final int DVDCMD_STILL_OFF;
    public static final int DVDCMD_PAUSE_ON;
    public static final int DVDCMD_AUDIO_CHANGE;
    public static final int DVDCMD_SUB_PICTURE_CHANGE;
    public static final int DVDCMD_ANGLE_CHANGE;
    public static final int DVDCMD_KARAOKE_CHANGE;
    public static final int DVDCMD_VIDEO_CHANGE;
    public static final int PLAYBACKSTATE_INVALID;
    public static final int PLAYBACKSTATE_READY_TO_PLAY;
    public static final int PLAYBACKSTATE_NOT_READY_TO_PLAY;
    public static final int PLAYBACKSTATE_PLAYING;
    public static final int PLAYBACKSTATE_STOPPED;
    public static final int PLAYBACKSTATE_PAUSED;
    public static final int PLAYBACKSTATE_SEEK_SLOWFW;
    public static final int PLAYBACKSTATE_SEEK_SLOWBW;
    public static final int PLAYBACKSTATE_SEEK_FASTFW;
    public static final int PLAYBACKSTATE_SEEK_FASTBW;
    public static final int PLAYBACKSTATE_PLAYING_MENU;
    public static final int PLAYBACKSTATE_STOPPED_WITH_ERROR;
    public static final int PLAYBACKSTATE_MENU_SELECT;
    public static final int PLAYBACKSTATE_DOWNLOADING;
    public static final int DIRECTION_FW;
    public static final int DIRECTION_BW;
    public static final int SKIP_NEXT_ENTRY;
    public static final int SKIP_PREV_ENTRY;
    public static final int SKIP_BEGIN_ENTRY;
    public static final int SKIP_NEXT_FOLDER;
    public static final int SKIP_PREV_FOLDER;
    public static final int SKIP_BEGIN_CHAPTER;
    public static final int SKIP_NEXT_CHAPTER;
    public static final int SKIP_PREV_CHAPTER;
    public static final int MENUCMD_MENU_TITLE;
    public static final int MENUCMD_MENU_ROOT;
    public static final int MENUCMD_MENU_ENTER;
    public static final int MENUCMD_MENU_UP;
    public static final int MENUCMD_MENU_DOWN;
    public static final int MENUCMD_MENU_RIGHT;
    public static final int MENUCMD_MENU_LEFT;
    public static final int MENUCMD_MENU_BACK;
    public static final int MENUCMD_MENU_NEXTCHAPTER;
    public static final int MENUCMD_MENU_PREVIOUSCHAPTER;
    public static final int ORDERCRITERIA_RAW;
    public static final int ORDERCRITERIA_TITLE;
    public static final int ORDERCRITERIA_ARTIST;
    public static final int ORDERCRITERIA_ALBUM;
    public static final int ORDERCRITERIA_GENRE;
    public static final int ORDERCRITERIA_PLAYLIST;
    public static final int ORDERCRITERIA_VIDEO;
    public static final int VIDEONORM_UNKNOWN;
    public static final int VIDEONORM_PAL;
    public static final int VIDEONORM_NTSC;
    public static final int VIDEONORM_AUTO;
    public static final int VIDEOFORMAT_UNKNOWN;
    public static final int VIDEOFORMAT_4_BY_3_STANDARD;
    public static final int VIDEOFORMAT_16_BY_9_WIDESCREEN;
    public static final int VIDEOFORMAT_14_BY_9_ZOOM;
    public static final int VIDEOFORMAT_47_BY_20_CINEMASCOPE;
    public static final int VIDEOFORMAT_AUTOMATIC;
    public static final int VIDEOFORMAT_ORIGINAL;
    public static final int PLAYBACKRATE_2X;
    public static final int PLAYBACKRATE_4X;
    public static final int PLAYBACKRATE_8X;
    public static final int PLAYBACKRATE_16X;
    public static final int PLAYBACKRATE_32X;
    public static final int PLAYBACKRATE_1BY2X;
    public static final int PLAYBACKRATE_1BY4X;
    public static final int PLAYBACKRATE_1BY8X;
    public static final int PLAYBACKRATE_1BY16X;
    public static final int PLAYBACKRATE_1BY32X;
    public static final int PLAYBACKRATE_64X;
    public static final int AUDIOCODINGFORMAT_UNKNOWN;
    public static final int AUDIOCODINGFORMAT_DOLBYAC3;
    public static final int AUDIOCODINGFORMAT_RESERVED;
    public static final int AUDIOCODINGFORMAT_MPEG;
    public static final int AUDIOCODINGFORMAT_MPEGEXT;
    public static final int AUDIOCODINGFORMAT_LPCM;
    public static final int AUDIOCODINGFORMAT_RESERVED1;
    public static final int AUDIOCODINGFORMAT_DTS;
    public static final int AUDIOCODINGFORMAT_SDDS;
    public static final int AUDIOCODINGFORMAT_MLP;
    public static final int AUDIOSTREAMEXTENSION_NOTSPECIFIED;
    public static final int AUDIOSTREAMEXTENSION_NORMALCAPTION;
    public static final int AUDIOSTREAMEXTENSION_VISUALLYIMPAIRED;
    public static final int AUDIOSTREAMEXTENSION_DIRECTORSCOMMENT1;
    public static final int AUDIOSTREAMEXTENSION_DIRECTORSCOMMENT2;
    public static final int PICTURECONFIGUSECASE_COVERART;
    public static final int SELECTIONRESULT_OK;
    public static final int SELECTIONRESULT_NOK;
    public static final int SELECTIONRESULT_OK_SEAMLESS_FAILED;
    public static final int RATINGFLAG_SET_FAVORITE;
    public static final int RATINGFLAG_REMOVE_FAVORITE;
    public static final int RATINGFLAG_CLEAR_ALL_FAVORITES;
    public static final int TOUCHEVENT_BUTTON_SELECT;
    public static final int TOUCHEVENT_BUTTON_ACTIVATE;
    public static final String DEVICE_NAME;
    public static final String DEVICE_INSTANCE;
}

