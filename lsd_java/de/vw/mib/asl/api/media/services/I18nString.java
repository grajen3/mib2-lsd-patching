/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.media.services;

public class I18nString {
    private final String value;
    private final boolean localized;
    public static final int I18N_NONE;
    public static final int I18N_FILTERCRITERIA_PLAYLISTS;
    public static final int I18N_FILTERCRITERIA_DYNPLAYLIST_STARS_0;
    public static final int I18N_FILTERCRITERIA_DYNPLAYLIST_STARS_1;
    public static final int I18N_FILTERCRITERIA_DYNPLAYLIST_STARS_2;
    public static final int I18N_FILTERCRITERIA_DYNPLAYLIST_STARS_3;
    public static final int I18N_FILTERCRITERIA_DYNPLAYLIST_STARS_4;
    public static final int I18N_FILTERCRITERIA_DYNPLAYLIST_STARS_5;
    public static final int I18N_FILTERCRITERIA_DYNPLAYLIST_MOST_PLAYED;
    public static final int I18N_FILTERCRITERIA_DYNPLAYLIST_LAST_PLAYED;
    public static final int I18N_FILTERCRITERIA_DYNPLAYLISTS;
    public static final int I18N_FILTERCRITERIA_ARTISTS;
    public static final int I18N_FILTERCRITERIA_UNKNOWN_ARTIST;
    public static final int I18N_FILTERCRITERIA_UNKNOWN_ARTISTS;
    public static final int I18N_FILTERCRITERIA_ALBUMS;
    public static final int I18N_FILTERCRITERIA_UNKNOWN_ALBUM;
    public static final int I18N_FILTERCRITERIA_UNKNOWN_ALBUMS;
    public static final int I18N_FILTERCRITERIA_SONGS;
    public static final int I18N_FILTERCRITERIA_UNKNOWN_SONG;
    public static final int I18N_FILTERCRITERIA_GENRES;
    public static final int I18N_FILTERCRITERIA_UNKNOWN_GENRE;
    public static final int I18N_FILTERCRITERIA_UNKNOWN_GENRES;
    public static final int I18N_FILTERCRITERIA_VIDEOS;
    public static final int I18N_FILTERCRITERIA_ALL;
    public static final int I18N_FILTERCRITERIA_AUDIOBOOKS;
    public static final int I18N_FILTERCRITERIA_UNKNOWN_AUDIOBOOK;
    public static final int I18N_FILTERCRITERIA_UNKNOWN_AUDIOBOOKS;
    public static final int I18N_FILTERCRITERIA_PODCASTS;
    public static final int I18N_FILTERCRITERIA_UNKNOWN_PODCAST;
    public static final int I18N_FILTERCRITERIA_UNKNOWN_PODCASTS;
    public static final int I18N_FILTERCRITERIA_VARIOUS_ARTISTS;
    public static final int I18N_FILTERCRITERIA_COMPOSERS;
    public static final int I18N_FILTERCRITERIA_I_TUNES_US;
    public static final int I18N_FILTERCRITERIA_GENIUS_PLAYLISTS;
    public static final int I18N_FILTERCRITERIA_UNKNOWN_TITLE;
    public static final int I18N_FILTERCRITERIA_NOW_PLAYING;
    public static final int I18N_GENERAL_UNKNOWN;
    public static final int I18N_CDDA_TRACK;
    public static final int I18N_CDDA_DISK;
    public static final int I18N_DVDA_GROUP;
    public static final int I18N_DVDA_TRACK;
    public static final int I18N_DVDV_TITLE;
    public static final int I18N_DVDV_CHAPTER;
    public static final int I18N_MEDIUM_SD_CARD;
    public static final int I18N_MEDIUM_USB;
    public static final int I18N_MEDIUM_JUKEBOX;
    public static final int I18N_MEDIUM_CDDA;
    public static final int I18N_MEDIUM_CDROM;
    public static final int I18N_MEDIUM_DVDROM;
    public static final int I18N_MEDIUM_DVD_AUDIO;
    public static final int I18N_MEDIUM_DVD_VIDEO;
    public static final int I18N_MEDIUM_BD;
    public static final int I18N_MEDIUM_RCP;
    public static final int I18N_MEDIUM_IPOD;
    public static final int I18N_MEDIUM_AUX;
    public static final int I18N_MEDIUM_HDMI;
    public static final int I18N_MEDIUM_AUXAV;
    public static final int I18N_MEDIUM_BT;
    public static final int I18N_MEDIUM_WLAN;
    public static final int I18N_MEDIUM_ONLINE;
    public static final int I18N_MEDIUM_FILE_PLAYER;
    private final int localizationType;

    public I18nString(String string, boolean bl, int n) {
        this.value = string;
        this.localized = bl;
        this.localizationType = n;
    }

    public String getValue() {
        return this.value;
    }

    public boolean isLocalized() {
        return this.localized;
    }

    public int getLocalizationType() {
        return this.localizationType;
    }

    public String toString() {
        return new StringBuffer().append(this.value).append(" [").append(this.localizationType).append("]").toString();
    }
}

