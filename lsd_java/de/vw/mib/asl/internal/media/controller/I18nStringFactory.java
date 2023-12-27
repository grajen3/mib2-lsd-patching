/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.controller;

import de.vw.mib.asl.api.media.services.I18nString;
import de.vw.mib.asl.internal.media.controller.I18nStringFactory$1;
import de.vw.mib.collections.ObjectIntOptHashMap;

public class I18nStringFactory {
    private static final String EMPTY_STRING;
    private static final String I18N_FILTERCRITERIA_PLAYLISTS_STRING;
    private static final String I18N_FILTERCRITERIA_DYNPLAYLIST_STARS_0_STRING;
    private static final String I18N_FILTERCRITERIA_DYNPLAYLIST_STARS_1_STRING;
    private static final String I18N_FILTERCRITERIA_DYNPLAYLIST_STARS_2_STRING;
    private static final String I18N_FILTERCRITERIA_DYNPLAYLIST_STARS_3_STRING;
    private static final String I18N_FILTERCRITERIA_DYNPLAYLIST_STARS_4_STRING;
    private static final String I18N_FILTERCRITERIA_DYNPLAYLIST_STARS_5_STRING;
    private static final String I18N_FILTERCRITERIA_DYNPLAYLIST_MOST_PLAYED_STRING;
    private static final String I18N_FILTERCRITERIA_DYNPLAYLIST_LAST_PLAYED_STRING;
    private static final String I18N_FILTERCRITERIA_DYNPLAYLISTS_STRING;
    private static final String I18N_FILTERCRITERIA_ARTISTS_STRING;
    private static final String I18N_FILTERCRITERIA_UNKNOWN_ARTIST_STRING;
    private static final String I18N_FILTERCRITERIA_UNKNOWN_ARTISTS_STRING;
    private static final String I18N_FILTERCRITERIA_ALBUMS_STRING;
    private static final String I18N_FILTERCRITERIA_UNKNOWN_ALBUM_STRING;
    private static final String I18N_FILTERCRITERIA_UNKNOWN_ALBUMS_STRING;
    private static final String I18N_FILTERCRITERIA_SONGS_STRING;
    private static final String I18N_FILTERCRITERIA_UNKNOWN_SONG_STRING;
    private static final String I18N_FILTERCRITERIA_GENRES_STRING;
    private static final String I18N_FILTERCRITERIA_UNKNOWN_GENRE_STRING;
    private static final String I18N_FILTERCRITERIA_UNKNOWN_GENRES_STRING;
    private static final String I18N_FILTERCRITERIA_VIDEOS_STRING;
    private static final String I18N_FILTERCRITERIA_ALL_STRING;
    private static final String I18N_FILTERCRITERIA_AUDIOBOOKS_STRING;
    private static final String I18N_FILTERCRITERIA_UNKNOWN_AUDIOBOOK_STRING;
    private static final String I18N_FILTERCRITERIA_UNKNOWN_AUDIOBOOKS_STRING;
    private static final String I18N_FILTERCRITERIA_PODCASTS_STRING;
    private static final String I18N_FILTERCRITERIA_UNKNOWN_PODCAST_STRING;
    private static final String I18N_FILTERCRITERIA_UNKNOWN_PODCASTS_STRING;
    private static final String I18N_FILTERCRITERIA_VARIOUS_ARTISTS_STRING;
    private static final String I18N_FILTERCRITERIA_COMPOSERS_STRING;
    private static final String I18N_FILTERCRITERIA_I_TUNES_US_STRING;
    private static final String I18N_FILTERCRITERIA_GENIUS_PLAYLISTS_STRING;
    private static final String I18N_FILTERCRITERIA_UNKNOWN_TITLE_STRING;
    private static final String I18N_FILTERCRITERIA_NOW_PLAYING_STRING;
    private static final String I18N_GENERAL_UNKNOWN_STRING;
    private static final String I18N_CDDA_TRACK_STRING;
    private static final String I18N_CDDA_DISK_STRING;
    private static final String I18N_DVDA_GROUP_STRING;
    private static final String I18N_DVDA_TRACK_STRING;
    private static final String I18N_DVDV_TITLE_STRING;
    private static final String I18N_DVDV_CHAPTER_STRING;
    private static final String I18N_MEDIUM_SD_CARD_STRING;
    private static final String I18N_MEDIUM_USB_STRING;
    private static final String I18N_MEDIUM_JUKEBOX_STRING;
    private static final String I18N_MEDIUM_CDDA_STRING;
    private static final String I18N_MEDIUM_CDROM_STRING;
    private static final String I18N_MEDIUM_DVDROM_STRING;
    private static final String I18N_MEDIUM_DVD_AUDIO_STRING;
    private static final String I18N_MEDIUM_DVD_VIDEO_STRING;
    private static final String I18N_MEDIUM_BD_STRING;
    private static final String I18N_MEDIUM_RCP_STRING;
    private static final String I18N_MEDIUM_IPOD_STRING;
    private static final String I18N_MEDIUM_AUX_STRING;
    private static final String I18N_MEDIUM_HDMI_STRING;
    private static final String I18N_MEDIUM_AUXAV_STRING;
    private static final String I18N_MEDIUM_BT_STRING;
    private static final String I18N_MEDIUM_WLAN_STRING;
    private static final String I18N_MEDIUM_ONLINE_STRING;
    private static final String I18N_MEDIUM_FILE_PLAYER_STRING;
    private static final ObjectIntOptHashMap I18N_STRING_SET;

    public static I18nString createI18nString(String string) {
        if (string == null) {
            return null;
        }
        int n = I18N_STRING_SET.get(string);
        boolean bl = n == 0;
        return new I18nString(string, bl, n);
    }

    public static String deleteI18nTags(String string) {
        if (I18N_STRING_SET.containsKey(string)) {
            return "";
        }
        return string;
    }

    static {
        I18N_STRING_SET = new I18nStringFactory$1(60);
    }
}

