/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.media;

import org.dsi.ifc.base.DSIBase;

public interface DSIMediaPlayer
extends DSIBase {
    public static final String VERSION;
    public static final int ATTR_VIDEOFORMAT;
    public static final int ATTR_VIDEONORM;
    public static final int ATTR_CMDBLOCKINGMASK;
    public static final int ATTR_NUMVIDEOANGLES;
    public static final int ATTR_PLAYBACKMODELIST;
    public static final int ATTR_PLAYBACKMODE;
    public static final int ATTR_PLAYBACKSTATE;
    public static final int ATTR_ACTIVEMEDIA;
    public static final int ATTR_PLAYBACKFOLDER;
    public static final int ATTR_CAPABILITIES;
    public static final int ATTR_PLAYPOSITION;
    public static final int ATTR_PLAYVIEWSIZE;
    public static final int ATTR_ACTIVEVIDEOANGLE;
    public static final int ATTR_AUDIOSTREAMLIST;
    public static final int ATTR_ACTIVEAUDIOSTREAM;
    public static final int ATTR_SUBTITLELIST;
    public static final int ATTR_ACTIVESUBTITLE;
    public static final int ATTR_PLAYBACKCONTENTFOLDER;
    public static final int RT_SETPLAYBACKMODE;
    public static final int RT_SETVIDEONORM;
    public static final int RT_SETRATING;
    public static final int RT_REQUESTCOVERART;
    public static final int RT_REQUESTFULLYQUALIFIEDNAME;
    public static final int RT_SETENTRY;
    public static final int RT_PLAY;
    public static final int RT_RESUME;
    public static final int RT_PAUSE;
    public static final int RT_STOP;
    public static final int RT_SEEK;
    public static final int RT_SKIP;
    public static final int RT_SETACTIVEMEDIA;
    public static final int RT_REQUESTPLAYVIEW;
    public static final int RT_EXECUTEMENUCMD;
    public static final int RT_SETVIDEOANGLE;
    public static final int RT_SETAUDIOSTREAM;
    public static final int RT_SETVIDEOFORMAT;
    public static final int RT_SETSUBTITLELANGUAGE;
    public static final int RT_REQUESTDETAILINFO;
    public static final int RT_SETPLAYBACKURL;
    public static final int RT_SETPLAYSELECTION;
    public static final int RT_SETVIDEORECT;
    public static final int RT_PLAYSIMILARENTRY;
    public static final int RT_GRANTTEMPPMLREQUEST;
    public static final int RT_DENYTEMPPMLREQUEST;
    public static final int RT_SETPLAYSELECTIONAB;
    public static final int RT_REQUESTTOUCHEVENT;
    public static final int RP_RESPONSERATING;
    public static final int RP_RESPONSEFULLYQUALIFIEDNAME;
    public static final int RP_RESPONSEPLAYVIEW;
    public static final int RP_RESPONSESETPLAYSELECTION;
    public static final int RP_RESPONSESETPLAYBACKURL;
    public static final int RP_RESPONSESETVIDEORECT;
    public static final int RP_RESPONSEPLAYSIMILARENTRY;
    public static final int RP_RESPONSESETPLAYSELECTIONAB;
    public static final int IN_INDICATIONDVDEVENT;
    public static final int IN_TEMPPMLREQUEST;
    public static final int IN_RESPONSECMDBLOCKED;
    public static final int IN_RESPONSEDETAILINFO;
    public static final int IN_RESPONSECOVERART;
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

    default public void setPlaybackMode(int n) {
    }

    default public void setVideoNorm(int n) {
    }

    default public void setRating(long l, int n) {
    }

    default public void requestCoverArt(long l) {
    }

    default public void requestFullyQualifiedName(long l) {
    }

    default public void setEntry(long l, int n) {
    }

    default public void play() {
    }

    default public void resume() {
    }

    default public void pause() {
    }

    default public void stop() {
    }

    default public void seek(int n, int n2) {
    }

    default public void skip(int n, int n2) {
    }

    default public void setActiveMedia(long l, long l2, int n) {
    }

    default public void requestPlayView(long l, int n, int n2, int n3) {
    }

    default public void executeMenuCmd(int n) {
    }

    default public void setVideoAngle(int n) {
    }

    default public void setAudioStream(int n) {
    }

    default public void setVideoFormat(int n) {
    }

    default public void setSubtitleLanguage(int n) {
    }

    default public void requestDetailInfo(long l) {
    }

    default public void setPlaySelection(int n, long l, boolean bl) {
    }

    default public void setPlaySelectionAB(int n) {
    }

    default public void setPlaybackURL(String string) {
    }

    default public void setVideoRect(int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8) {
    }

    default public void playSimilarEntry(long l, int n) {
    }

    default public void grantTempPMLRequest() {
    }

    default public void denyTempPMLRequest() {
    }

    default public void requestTouchEvent(int n, int n2, int n3) {
    }
}

