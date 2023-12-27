/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.media;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;

public interface IMediaConstants {
    public static final long PLAYER_JOGGER_ID;
    public static final String PLAYER_JOGGER_FILENAME;
    public static final int SKIP_DEBOUNCE_TIMER;
    public static final int THREE_SECOND_TIMER;
    public static final int DEVICE_UNAVAILABLE_TIMEOUT;
    public static final int MEDIALIAST_START_UP_TIMER;
    public static final int BROWSER_LISTS_COLUMN_FOR_OBJECT_ID;
    public static final int INVALID_INDEX;
    public static final int TIMEPOS_SET_ENTRY_CHOOSE_FILE;
    public static final int INVALID_DEVICEID;
    public static final int INVALID_ASLDEVICEID;
    public static final int UNKNOWN_ASLDEVICEID;
    public static final int INVALID_TRACK_ENTRY_ID;
    public static final String I18N_GENERAL_UNKNOWN_STRING;
    public static final String I18N_CDDA_TRACK_STRING;
    public static final String I18N_CDDA_DISK_STRING;
    public static final String I18N_DVDA_GROUP_STRING;
    public static final String I18N_DVDA_TRACK_STRING;
    public static final String I18N_DVDV_TITLE_STRING;
    public static final String I18N_DVDV_CHAPTER_STRING;
    public static final String I18N_FILTERCRITERIA_PLAYLISTS_STRING;
    public static final String I18N_FILTERCRITERIA_DYNPLAYLIST_STARS_0_STRING;
    public static final String I18N_FILTERCRITERIA_DYNPLAYLIST_STARS_1_STRING;
    public static final String I18N_FILTERCRITERIA_DYNPLAYLIST_STARS_2_STRING;
    public static final String I18N_FILTERCRITERIA_DYNPLAYLIST_STARS_3_STRING;
    public static final String I18N_FILTERCRITERIA_DYNPLAYLIST_STARS_4_STRING;
    public static final String I18N_FILTERCRITERIA_DYNPLAYLIST_STARS_5_STRING;
    public static final String I18N_FILTERCRITERIA_DYNPLAYLIST_MOST_PLAYEDSTRING;
    public static final String I18N_FILTERCRITERIA_DYNPLAYLIST_LAST_PLAYEDSTRING;
    public static final String I18N_FILTERCRITERIA_DYNPLAYLISTS_STRING;
    public static final String I18N_FILTERCRITERIA_ARTISTS_STRING;
    public static final String I18N_FILTERCRITERIA_UNKNOWN_ARTIST_STRING;
    public static final String I18N_FILTERCRITERIA_UNKNOWN_ARTISTS_STRING;
    public static final String I18N_FILTERCRITERIA_ALBUMS_STRING;
    public static final String I18N_FILTERCRITERIA_UNKNOWN_ALBUM_STRING;
    public static final String I18N_FILTERCRITERIA_UNKNOWN_ALBUMS_STRING;
    public static final String I18N_FILTERCRITERIA_SONGS_STRING;
    public static final String I18N_FILTERCRITERIA_UNKNOWN_SONG_STRING;
    public static final String I18N_FILTERCRITERIA_GENRES_STRING;
    public static final String I18N_FILTERCRITERIA_UNKNOWN_GENRE_STRING;
    public static final String I18N_FILTERCRITERIA_UNKNOWN_GENRES_STRING;
    public static final String I18N_FILTERCRITERIA_VIDEOS_STRING;
    public static final String I18N_FILTERCRITERIA_ALL_STRING;
    public static final String I18N_FILTERCRITERIA_AUDIOBOOKS_STRING;
    public static final String I18N_FILTERCRITERIA_UNKNOWN_AUDIOBOOK_STRING;
    public static final String I18N_FILTERCRITERIA_UNKNOWN_AUDIOBOOKS_STRING;
    public static final String I18N_FILTERCRITERIA_PODCASTS_STRING;
    public static final String I18N_FILTERCRITERIA_UNKNOWN_PODCAST_STRING;
    public static final String I18N_FILTERCRITERIA_UNKNOWN_PODCASTS_STRING;
    public static final String I18N_FILTERCRITERIA_VARIOUS_ARTISTS_STRING;
    public static final String I18N_FILTERCRITERIA_COMPOSERS_STRING;
    public static final String I18N_FILTERCRITERIA_I_TUNES_US_STRING;
    public static final String I18N_FILTERCRITERIA_GENIUS_PLAYLISTS_STRING;
    public static final String I18N_FILTERCRITERIA_UNKNOWN_TITLE_STRING;
    public static final String I18N_MEDIUM_SD_CARD;
    public static final String I18N_MEDIUM_USB;
    public static final String I18N_MEDIUM_JUKEBOX;
    public static final String I18N_MEDIUM_CDDA;
    public static final String I18N_MEDIUM_CDROM;
    public static final String I18N_MEDIUM_DVDROM;
    public static final String I18N_MEDIUM_DVD_AUDIO;
    public static final String I18N_MEDIUM_DVD_VIDEO;
    public static final String I18N_MEDIUM_BD;
    public static final String I18N_MEDIUM_RCP;
    public static final String I18N_MEDIUM_IPOD;
    public static final String I18N_MEDIUM_AUX;
    public static final String I18N_MEDIUM_HDMI;
    public static final String I18N_MEDIUM_AUXAV;
    public static final String I18N_MEDIUM_BT;
    public static final String I18N_MEDIUM_WLAN;
    public static final String I18N_MEDIUM_ONLINE;
    public static final String I18N_MEDIUM_FILE_PLAYER;
    public static final int WINDOW_SIZE;
    public static final String EMPTY_STRING;
    public static final boolean ESO;
    public static final int PLAYBACKSTATE_RAW;

    static {
        MEDIALIAST_START_UP_TIMER = Integer.getInteger("de.vw.mib.asl.media.startupListTimer", 5000);
        ESO = ServiceManager.configManagerDiag.isFeatureFlagSet(378);
    }
}

