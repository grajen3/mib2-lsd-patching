/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.audiosd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.datatypes.BAPString;
import de.vw.mib.bap.mqbab2.generated.audiosd.serializer.CurrentStationInfo_StationInfoSwitches;
import de.vw.mib.bap.mqbab2.generated.audiosd.serializer.CurrentStationInfo_StationProperties;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class CurrentStationInfo_Status
implements StatusProperty {
    public final BAPString primaryInformation = new BAPString(73);
    private static final int MAX_PRIMARYINFORMATION_LENGTH;
    public int pi_Type;
    public static final int PI_TYPE_ONLINE_RADIO_STATION_DF4_2;
    public static final int PI_TYPE_CATEGORY_UNKNOWN_MOOD_DF4_1;
    public static final int PI_TYPE_CATEGORY_MOOD_DF4_1;
    public static final int PI_TYPE_CATEGORY_UNKNOWN_AUDIOBOOKS_DF4_1;
    public static final int PI_TYPE_CATEGORY_UNKNOWN_AUDIOBOOK_DF4_1;
    public static final int PI_TYPE_PROGRAM_NOW_DF_4_1;
    public static final int PI_TYPE_COMPOSER_DF_4_1;
    public static final int PI_TYPE_CONDUCTOR_DF_4_1;
    public static final int PI_TYPE_MODERATOR_DF_4_1;
    public static final int PI_TYPE_DAB_SECONDARY_SERVICE_DF_4_1;
    public static final int PI_TYPE_DAB_ENSEMBLE_DF_4_1;
    public static final int PI_TYPE_ALBUM;
    public static final int PI_TYPE_ARTIST;
    public static final int PI_TYPE_TITLE_FORBIDDEN_IN_CASE_OF_LEGACY_AUDIO_CD;
    public static final int PI_TYPE_DVB_SERVICE_TV_STATION;
    public static final int PI_TYPE_DAB_SERVICE;
    public static final int PI_TYPE_SDARS_STATION;
    public static final int PI_TYPE_RADIO_STATION_FM_AM_AM_SW_AM_LW;
    public static final int PI_TYPE_CHANNEL;
    public static final int PI_TYPE_DVD_TITLE;
    public static final int PI_TYPE_DVD_CHAPTER;
    public static final int PI_TYPE_DVD_MAIN_MENUE;
    public static final int PI_TYPE_CATEGORY_VARIOUS_ARTISTS_DF4_1;
    public static final int PI_TYPE_CATEGORY_UNKNOWN_PODCASTS_DF4_1;
    public static final int PI_TYPE_CATEGORY_UNKNOWN_PODCAST_DF4_1;
    public static final int PI_TYPE_CATEGORY_FAVORITES_DF4_1;
    public static final int PI_TYPE_CATEGORY_LAST_COPIED_FILES_DF4_1;
    public static final int PI_TYPE_CATEGORY_BORROWED_VIDEOS_DF4_1;
    public static final int PI_TYPE_CATEGORY_VIDEO_PODCASTS_GERMAN_SENDUNGEN_DF4_1;
    public static final int PI_TYPE_CATEGORY_MUSIC_VIDEOS_DF4_1;
    public static final int PI_TYPE_CATEGORY_MOVIES_DF4_1;
    public static final int PI_TYPE_CATEGORY_DYNAMIC_PLAYLISTS;
    public static final int PI_TYPE_CATEGORY_DYNAMIC_PLAYLIST_ON_THE_GO;
    public static final int PI_TYPE_CATEGORY_DYNAMIC_PLAYLIST_LAST_PLAYED;
    public static final int PI_TYPE_CATEGORY_DYNAMIC_PLAYLIST_MOST_PLAYED;
    public static final int PI_TYPE_CATEGORY_DYNAMIC_PLAYLIST_5_STARS;
    public static final int PI_TYPE_CATEGORY_DYNAMIC_PLAYLIST_4_STARS;
    public static final int PI_TYPE_CATEGORY_DYNAMIC_PLAYLIST_3_STARS;
    public static final int PI_TYPE_CATEGORY_DYNAMIC_PLAYLIST_2_STARS;
    public static final int PI_TYPE_CATEGORY_DYNAMIC_PLAYLIST_1_STAR;
    public static final int PI_TYPE_CATEGORY_DYNAMIC_PLAYLIST_NOT_RATED;
    public static final int PI_TYPE_CATEGORY_PODCASTS;
    public static final int PI_TYPE_CATEGORY_PODCAST;
    public static final int PI_TYPE_CATEGORY_ALL;
    public static final int PI_TYPE_CATEGORY_AUDIOBOOKS;
    public static final int PI_TYPE_CATEGORY_AUDIOBOOK;
    public static final int PI_TYPE_CATEGORY_UNKNOWN_SONGS;
    public static final int PI_TYPE_CATEGORY_UNKNOWN_SONG;
    public static final int PI_TYPE_CATEGORY_SONGS;
    public static final int PI_TYPE_CATEGORY_SONG;
    public static final int PI_TYPE_CATEGORY_UNKNOWN_ALBUMS;
    public static final int PI_TYPE_CATEGORY_UNKNOWN_ALBUM;
    public static final int PI_TYPE_CATEGORY_ALBUMS;
    public static final int PI_TYPE_CATEGORY_ALBUM;
    public static final int PI_TYPE_CATEGORY_UNKNOWN_COMMENT;
    public static final int PI_TYPE_CATEGORY_COMMENT;
    public static final int PI_TYPE_CATEGORY_UNKNOWN_YEAR;
    public static final int PI_TYPE_CATEGORY_YEAR;
    public static final int PI_TYPE_CATEGORY_UNKNOWN_COMPOSERS;
    public static final int PI_TYPE_CATEGORY_UNKNOWN_COMPOSER;
    public static final int PI_TYPE_CATEGORY_COMPOSERS;
    public static final int PI_TYPE_CATEGORY_COMPOSER;
    public static final int PI_TYPE_CATEGORY_UNKNOWN_ARTISTS;
    public static final int PI_TYPE_CATEGORY_UNKNOWN_ARTIST;
    public static final int PI_TYPE_CATEGORY_ARTISTS;
    public static final int PI_TYPE_CATEGORY_ARTIST;
    public static final int PI_TYPE_CATEGORY_UNKNOWN_GENRES;
    public static final int PI_TYPE_CATEGORY_UNKNOWN_GENRE;
    public static final int PI_TYPE_CATEGORY_GENRES;
    public static final int PI_TYPE_CATEGORY_GENRE;
    public static final int PI_TYPE_VOICEMEMO_FOLDER;
    public static final int PI_TYPE_IMAGE_FOLDER;
    public static final int PI_TYPE_VIDEO_FOLDER;
    public static final int PI_TYPE_AUDIO_FOLDER;
    public static final int PI_TYPE_IMAGE_FILE;
    public static final int PI_TYPE_VOICEMEMO_FILE;
    public static final int PI_TYPE_CD_AUDIO_TRACK_CD_TEXT;
    public static final int PI_TYPE_LEGACY_AUDIO_TRACK_CD;
    public static final int PI_TYPE_VIDEO_FILE;
    public static final int PI_TYPE_AUDIO_FILE;
    public static final int PI_TYPE_ANY_CATEGORY_UNKNOWN_CATEGORY;
    public static final int PI_TYPE_PLAYLIST_FOLDER;
    public static final int PI_TYPE_PLAYLIST;
    public static final int PI_TYPE_TRACK;
    public static final int PI_TYPE_FOLDER;
    public static final int PI_TYPE_ANY_TYPE_UNKNOWN;
    public int pi_Id;
    public static final int PI_ID_MIN;
    public final BAPString secondaryInformation = new BAPString(73);
    private static final int MAX_SECONDARYINFORMATION_LENGTH;
    public int si_Type;
    public static final int SI_TYPE_ONLINE_RADIO_STATION_DF4_2;
    public static final int SI_TYPE_CATEGORY_UNKNOWN_MOOD_DF4_1;
    public static final int SI_TYPE_CATEGORY_MOOD_DF4_1;
    public static final int SI_TYPE_CATEGORY_UNKNOWN_AUDIOBOOKS_DF4_1;
    public static final int SI_TYPE_CATEGORY_UNKNOWN_AUDIOBOOK_DF4_1;
    public static final int SI_TYPE_PROGRAM_NOW_DF_4_1;
    public static final int SI_TYPE_COMPOSER_DF_4_1;
    public static final int SI_TYPE_CONDUCTOR_DF_4_1;
    public static final int SI_TYPE_MODERATOR_DF_4_1;
    public static final int SI_TYPE_DAB_SECONDARY_SERVICE_DF_4_1;
    public static final int SI_TYPE_DAB_ENSEMBLE_DF_4_1;
    public static final int SI_TYPE_ALBUM;
    public static final int SI_TYPE_ARTIST;
    public static final int SI_TYPE_TITLE_FORBIDDEN_IN_CASE_OF_LEGACY_AUDIO_CD;
    public static final int SI_TYPE_DVB_SERVICE_TV_STATION;
    public static final int SI_TYPE_DAB_SERVICE;
    public static final int SI_TYPE_SDARS_STATION;
    public static final int SI_TYPE_RADIO_STATION_FM_AM_AM_SW_AM_LW;
    public static final int SI_TYPE_CHANNEL;
    public static final int SI_TYPE_DVD_TITLE;
    public static final int SI_TYPE_DVD_CHAPTER;
    public static final int SI_TYPE_DVD_MAIN_MENUE;
    public static final int SI_TYPE_CATEGORY_VARIOUS_ARTISTS_DF4_1;
    public static final int SI_TYPE_CATEGORY_UNKNOWN_PODCASTS_DF4_1;
    public static final int SI_TYPE_CATEGORY_UNKNOWN_PODCAST_DF4_1;
    public static final int SI_TYPE_CATEGORY_FAVORITES_DF4_1;
    public static final int SI_TYPE_CATEGORY_LAST_COPIED_FILES_DF4_1;
    public static final int SI_TYPE_CATEGORY_BORROWED_VIDEOS_DF4_1;
    public static final int SI_TYPE_CATEGORY_VIDEO_PODCASTS_GERMAN_SENDUNGEN_DF4_1;
    public static final int SI_TYPE_CATEGORY_MUSIC_VIDEOS_DF4_1;
    public static final int SI_TYPE_CATEGORY_MOVIES_DF4_1;
    public static final int SI_TYPE_CATEGORY_DYNAMIC_PLAYLISTS;
    public static final int SI_TYPE_CATEGORY_DYNAMIC_PLAYLIST_ON_THE_GO;
    public static final int SI_TYPE_CATEGORY_DYNAMIC_PLAYLIST_LAST_PLAYED;
    public static final int SI_TYPE_CATEGORY_DYNAMIC_PLAYLIST_MOST_PLAYED;
    public static final int SI_TYPE_CATEGORY_DYNAMIC_PLAYLIST_5_STARS;
    public static final int SI_TYPE_CATEGORY_DYNAMIC_PLAYLIST_4_STARS;
    public static final int SI_TYPE_CATEGORY_DYNAMIC_PLAYLIST_3_STARS;
    public static final int SI_TYPE_CATEGORY_DYNAMIC_PLAYLIST_2_STARS;
    public static final int SI_TYPE_CATEGORY_DYNAMIC_PLAYLIST_1_STAR;
    public static final int SI_TYPE_CATEGORY_DYNAMIC_PLAYLIST_NOT_RATED;
    public static final int SI_TYPE_CATEGORY_PODCASTS;
    public static final int SI_TYPE_CATEGORY_PODCAST;
    public static final int SI_TYPE_CATEGORY_ALL;
    public static final int SI_TYPE_CATEGORY_AUDIOBOOKS;
    public static final int SI_TYPE_CATEGORY_AUDIOBOOK;
    public static final int SI_TYPE_CATEGORY_UNKNOWN_SONGS;
    public static final int SI_TYPE_CATEGORY_UNKNOWN_SONG;
    public static final int SI_TYPE_CATEGORY_SONGS;
    public static final int SI_TYPE_CATEGORY_SONG;
    public static final int SI_TYPE_CATEGORY_UNKNOWN_ALBUMS;
    public static final int SI_TYPE_CATEGORY_UNKNOWN_ALBUM;
    public static final int SI_TYPE_CATEGORY_ALBUMS;
    public static final int SI_TYPE_CATEGORY_ALBUM;
    public static final int SI_TYPE_CATEGORY_UNKNOWN_COMMENT;
    public static final int SI_TYPE_CATEGORY_COMMENT;
    public static final int SI_TYPE_CATEGORY_UNKNOWN_YEAR;
    public static final int SI_TYPE_CATEGORY_YEAR;
    public static final int SI_TYPE_CATEGORY_UNKNOWN_COMPOSERS;
    public static final int SI_TYPE_CATEGORY_UNKNOWN_COMPOSER;
    public static final int SI_TYPE_CATEGORY_COMPOSERS;
    public static final int SI_TYPE_CATEGORY_COMPOSER;
    public static final int SI_TYPE_CATEGORY_UNKNOWN_ARTISTS;
    public static final int SI_TYPE_CATEGORY_UNKNOWN_ARTIST;
    public static final int SI_TYPE_CATEGORY_ARTISTS;
    public static final int SI_TYPE_CATEGORY_ARTIST;
    public static final int SI_TYPE_CATEGORY_UNKNOWN_GENRES;
    public static final int SI_TYPE_CATEGORY_UNKNOWN_GENRE;
    public static final int SI_TYPE_CATEGORY_GENRES;
    public static final int SI_TYPE_CATEGORY_GENRE;
    public static final int SI_TYPE_VOICEMEMO_FOLDER;
    public static final int SI_TYPE_IMAGE_FOLDER;
    public static final int SI_TYPE_VIDEO_FOLDER;
    public static final int SI_TYPE_AUDIO_FOLDER;
    public static final int SI_TYPE_IMAGE_FILE;
    public static final int SI_TYPE_VOICEMEMO_FILE;
    public static final int SI_TYPE_CD_AUDIO_TRACK_CD_TEXT;
    public static final int SI_TYPE_LEGACY_AUDIO_TRACK_CD;
    public static final int SI_TYPE_VIDEO_FILE;
    public static final int SI_TYPE_AUDIO_FILE;
    public static final int SI_TYPE_ANY_CATEGORY_UNKNOWN_CATEGORY;
    public static final int SI_TYPE_PLAYLIST_FOLDER;
    public static final int SI_TYPE_PLAYLIST;
    public static final int SI_TYPE_TRACK;
    public static final int SI_TYPE_FOLDER;
    public static final int SI_TYPE_ANY_TYPE_UNKNOWN;
    public final BAPString tertiaryInformation = new BAPString(73);
    private static final int MAX_TERTIARYINFORMATION_LENGTH;
    public int ti_Type;
    public static final int TI_TYPE_ONLINE_RADIO_STATION_DF4_2;
    public static final int TI_TYPE_CATEGORY_UNKNOWN_MOOD_DF4_1;
    public static final int TI_TYPE_CATEGORY_MOOD_DF4_1;
    public static final int TI_TYPE_CATEGORY_UNKNOWN_AUDIOBOOKS_DF4_1;
    public static final int TI_TYPE_CATEGORY_UNKNOWN_AUDIOBOOK_DF4_1;
    public static final int TI_TYPE_PROGRAM_NOW_DF_4_1;
    public static final int TI_TYPE_COMPOSER_DF_4_1;
    public static final int TI_TYPE_CONDUCTOR_DF_4_1;
    public static final int TI_TYPE_MODERATOR_DF_4_1;
    public static final int TI_TYPE_DAB_SECONDARY_SERVICE_DF_4_1;
    public static final int TI_TYPE_DAB_ENSEMBLE_DF_4_1;
    public static final int TI_TYPE_ALBUM;
    public static final int TI_TYPE_ARTIST;
    public static final int TI_TYPE_TITLE_FORBIDDEN_IN_CASE_OF_LEGACY_AUDIO_CD;
    public static final int TI_TYPE_DVB_SERVICE_TV_STATION;
    public static final int TI_TYPE_DAB_SERVICE;
    public static final int TI_TYPE_SDARS_STATION;
    public static final int TI_TYPE_RADIO_STATION_FM_AM_AM_SW_AM_LW;
    public static final int TI_TYPE_CHANNEL;
    public static final int TI_TYPE_DVD_TITLE;
    public static final int TI_TYPE_DVD_CHAPTER;
    public static final int TI_TYPE_DVD_MAIN_MENUE;
    public static final int TI_TYPE_CATEGORY_VARIOUS_ARTISTS_DF4_1;
    public static final int TI_TYPE_CATEGORY_UNKNOWN_PODCASTS_DF4_1;
    public static final int TI_TYPE_CATEGORY_UNKNOWN_PODCAST_DF4_1;
    public static final int TI_TYPE_CATEGORY_FAVORITES_DF4_1;
    public static final int TI_TYPE_CATEGORY_LAST_COPIED_FILES_DF4_1;
    public static final int TI_TYPE_CATEGORY_BORROWED_VIDEOS_DF4_1;
    public static final int TI_TYPE_CATEGORY_VIDEO_PODCASTS_GERMAN_SENDUNGEN_DF4_1;
    public static final int TI_TYPE_CATEGORY_MUSIC_VIDEOS_DF4_1;
    public static final int TI_TYPE_CATEGORY_MOVIES_DF4_1;
    public static final int TI_TYPE_CATEGORY_DYNAMIC_PLAYLISTS;
    public static final int TI_TYPE_CATEGORY_DYNAMIC_PLAYLIST_ON_THE_GO;
    public static final int TI_TYPE_CATEGORY_DYNAMIC_PLAYLIST_LAST_PLAYED;
    public static final int TI_TYPE_CATEGORY_DYNAMIC_PLAYLIST_MOST_PLAYED;
    public static final int TI_TYPE_CATEGORY_DYNAMIC_PLAYLIST_5_STARS;
    public static final int TI_TYPE_CATEGORY_DYNAMIC_PLAYLIST_4_STARS;
    public static final int TI_TYPE_CATEGORY_DYNAMIC_PLAYLIST_3_STARS;
    public static final int TI_TYPE_CATEGORY_DYNAMIC_PLAYLIST_2_STARS;
    public static final int TI_TYPE_CATEGORY_DYNAMIC_PLAYLIST_1_STAR;
    public static final int TI_TYPE_CATEGORY_DYNAMIC_PLAYLIST_NOT_RATED;
    public static final int TI_TYPE_CATEGORY_PODCASTS;
    public static final int TI_TYPE_CATEGORY_PODCAST;
    public static final int TI_TYPE_CATEGORY_ALL;
    public static final int TI_TYPE_CATEGORY_AUDIOBOOKS;
    public static final int TI_TYPE_CATEGORY_AUDIOBOOK;
    public static final int TI_TYPE_CATEGORY_UNKNOWN_SONGS;
    public static final int TI_TYPE_CATEGORY_UNKNOWN_SONG;
    public static final int TI_TYPE_CATEGORY_SONGS;
    public static final int TI_TYPE_CATEGORY_SONG;
    public static final int TI_TYPE_CATEGORY_UNKNOWN_ALBUMS;
    public static final int TI_TYPE_CATEGORY_UNKNOWN_ALBUM;
    public static final int TI_TYPE_CATEGORY_ALBUMS;
    public static final int TI_TYPE_CATEGORY_ALBUM;
    public static final int TI_TYPE_CATEGORY_UNKNOWN_COMMENT;
    public static final int TI_TYPE_CATEGORY_COMMENT;
    public static final int TI_TYPE_CATEGORY_UNKNOWN_YEAR;
    public static final int TI_TYPE_CATEGORY_YEAR;
    public static final int TI_TYPE_CATEGORY_UNKNOWN_COMPOSERS;
    public static final int TI_TYPE_CATEGORY_UNKNOWN_COMPOSER;
    public static final int TI_TYPE_CATEGORY_COMPOSERS;
    public static final int TI_TYPE_CATEGORY_COMPOSER;
    public static final int TI_TYPE_CATEGORY_UNKNOWN_ARTISTS;
    public static final int TI_TYPE_CATEGORY_UNKNOWN_ARTIST;
    public static final int TI_TYPE_CATEGORY_ARTISTS;
    public static final int TI_TYPE_CATEGORY_ARTIST;
    public static final int TI_TYPE_CATEGORY_UNKNOWN_GENRES;
    public static final int TI_TYPE_CATEGORY_UNKNOWN_GENRE;
    public static final int TI_TYPE_CATEGORY_GENRES;
    public static final int TI_TYPE_CATEGORY_GENRE;
    public static final int TI_TYPE_VOICEMEMO_FOLDER;
    public static final int TI_TYPE_IMAGE_FOLDER;
    public static final int TI_TYPE_VIDEO_FOLDER;
    public static final int TI_TYPE_AUDIO_FOLDER;
    public static final int TI_TYPE_IMAGE_FILE;
    public static final int TI_TYPE_VOICEMEMO_FILE;
    public static final int TI_TYPE_CD_AUDIO_TRACK_CD_TEXT;
    public static final int TI_TYPE_LEGACY_AUDIO_TRACK_CD;
    public static final int TI_TYPE_VIDEO_FILE;
    public static final int TI_TYPE_AUDIO_FILE;
    public static final int TI_TYPE_ANY_CATEGORY_UNKNOWN_CATEGORY;
    public static final int TI_TYPE_PLAYLIST_FOLDER;
    public static final int TI_TYPE_PLAYLIST;
    public static final int TI_TYPE_TRACK;
    public static final int TI_TYPE_FOLDER;
    public static final int TI_TYPE_ANY_TYPE_UNKNOWN;
    public final BAPString quaternaryInformation = new BAPString(73);
    private static final int MAX_QUATERNARYINFORMATION_LENGTH;
    public int qi_Type;
    public static final int QI_TYPE_ONLINE_RADIO_STATION_DF4_2;
    public static final int QI_TYPE_CATEGORY_UNKNOWN_MOOD_DF4_1;
    public static final int QI_TYPE_CATEGORY_MOOD_DF4_1;
    public static final int QI_TYPE_CATEGORY_UNKNOWN_AUDIOBOOKS_DF4_1;
    public static final int QI_TYPE_CATEGORY_UNKNOWN_AUDIOBOOK_DF4_1;
    public static final int QI_TYPE_PROGRAM_NOW_DF_4_1;
    public static final int QI_TYPE_COMPOSER_DF_4_1;
    public static final int QI_TYPE_CONDUCTOR_DF_4_1;
    public static final int QI_TYPE_MODERATOR_DF_4_1;
    public static final int QI_TYPE_DAB_SECONDARY_SERVICE_DF_4_1;
    public static final int QI_TYPE_DAB_ENSEMBLE_DF_4_1;
    public static final int QI_TYPE_ALBUM;
    public static final int QI_TYPE_ARTIST;
    public static final int QI_TYPE_TITLE_FORBIDDEN_IN_CASE_OF_LEGACY_AUDIO_CD;
    public static final int QI_TYPE_DVB_SERVICE_TV_STATION;
    public static final int QI_TYPE_DAB_SERVICE;
    public static final int QI_TYPE_SDARS_STATION;
    public static final int QI_TYPE_RADIO_STATION_FM_AM_AM_SW_AM_LW;
    public static final int QI_TYPE_CHANNEL;
    public static final int QI_TYPE_DVD_TITLE;
    public static final int QI_TYPE_DVD_CHAPTER;
    public static final int QI_TYPE_DVD_MAIN_MENUE;
    public static final int QI_TYPE_CATEGORY_VARIOUS_ARTISTS_DF4_1;
    public static final int QI_TYPE_CATEGORY_UNKNOWN_PODCASTS_DF4_1;
    public static final int QI_TYPE_CATEGORY_UNKNOWN_PODCAST_DF4_1;
    public static final int QI_TYPE_CATEGORY_FAVORITES_DF4_1;
    public static final int QI_TYPE_CATEGORY_LAST_COPIED_FILES_DF4_1;
    public static final int QI_TYPE_CATEGORY_BORROWED_VIDEOS_DF4_1;
    public static final int QI_TYPE_CATEGORY_VIDEO_PODCASTS_GERMAN_SENDUNGEN_DF4_1;
    public static final int QI_TYPE_CATEGORY_MUSIC_VIDEOS_DF4_1;
    public static final int QI_TYPE_CATEGORY_MOVIES_DF4_1;
    public static final int QI_TYPE_CATEGORY_DYNAMIC_PLAYLISTS;
    public static final int QI_TYPE_CATEGORY_DYNAMIC_PLAYLIST_ON_THE_GO;
    public static final int QI_TYPE_CATEGORY_DYNAMIC_PLAYLIST_LAST_PLAYED;
    public static final int QI_TYPE_CATEGORY_DYNAMIC_PLAYLIST_MOST_PLAYED;
    public static final int QI_TYPE_CATEGORY_DYNAMIC_PLAYLIST_5_STARS;
    public static final int QI_TYPE_CATEGORY_DYNAMIC_PLAYLIST_4_STARS;
    public static final int QI_TYPE_CATEGORY_DYNAMIC_PLAYLIST_3_STARS;
    public static final int QI_TYPE_CATEGORY_DYNAMIC_PLAYLIST_2_STARS;
    public static final int QI_TYPE_CATEGORY_DYNAMIC_PLAYLIST_1_STAR;
    public static final int QI_TYPE_CATEGORY_DYNAMIC_PLAYLIST_NOT_RATED;
    public static final int QI_TYPE_CATEGORY_PODCASTS;
    public static final int QI_TYPE_CATEGORY_PODCAST;
    public static final int QI_TYPE_CATEGORY_ALL;
    public static final int QI_TYPE_CATEGORY_AUDIOBOOKS;
    public static final int QI_TYPE_CATEGORY_AUDIOBOOK;
    public static final int QI_TYPE_CATEGORY_UNKNOWN_SONGS;
    public static final int QI_TYPE_CATEGORY_UNKNOWN_SONG;
    public static final int QI_TYPE_CATEGORY_SONGS;
    public static final int QI_TYPE_CATEGORY_SONG;
    public static final int QI_TYPE_CATEGORY_UNKNOWN_ALBUMS;
    public static final int QI_TYPE_CATEGORY_UNKNOWN_ALBUM;
    public static final int QI_TYPE_CATEGORY_ALBUMS;
    public static final int QI_TYPE_CATEGORY_ALBUM;
    public static final int QI_TYPE_CATEGORY_UNKNOWN_COMMENT;
    public static final int QI_TYPE_CATEGORY_COMMENT;
    public static final int QI_TYPE_CATEGORY_UNKNOWN_YEAR;
    public static final int QI_TYPE_CATEGORY_YEAR;
    public static final int QI_TYPE_CATEGORY_UNKNOWN_COMPOSERS;
    public static final int QI_TYPE_CATEGORY_UNKNOWN_COMPOSER;
    public static final int QI_TYPE_CATEGORY_COMPOSERS;
    public static final int QI_TYPE_CATEGORY_COMPOSER;
    public static final int QI_TYPE_CATEGORY_UNKNOWN_ARTISTS;
    public static final int QI_TYPE_CATEGORY_UNKNOWN_ARTIST;
    public static final int QI_TYPE_CATEGORY_ARTISTS;
    public static final int QI_TYPE_CATEGORY_ARTIST;
    public static final int QI_TYPE_CATEGORY_UNKNOWN_GENRES;
    public static final int QI_TYPE_CATEGORY_UNKNOWN_GENRE;
    public static final int QI_TYPE_CATEGORY_GENRES;
    public static final int QI_TYPE_CATEGORY_GENRE;
    public static final int QI_TYPE_VOICEMEMO_FOLDER;
    public static final int QI_TYPE_IMAGE_FOLDER;
    public static final int QI_TYPE_VIDEO_FOLDER;
    public static final int QI_TYPE_AUDIO_FOLDER;
    public static final int QI_TYPE_IMAGE_FILE;
    public static final int QI_TYPE_VOICEMEMO_FILE;
    public static final int QI_TYPE_CD_AUDIO_TRACK_CD_TEXT;
    public static final int QI_TYPE_LEGACY_AUDIO_TRACK_CD;
    public static final int QI_TYPE_VIDEO_FILE;
    public static final int QI_TYPE_AUDIO_FILE;
    public static final int QI_TYPE_ANY_CATEGORY_UNKNOWN_CATEGORY;
    public static final int QI_TYPE_PLAYLIST_FOLDER;
    public static final int QI_TYPE_PLAYLIST;
    public static final int QI_TYPE_TRACK;
    public static final int QI_TYPE_FOLDER;
    public static final int QI_TYPE_ANY_TYPE_UNKNOWN;
    public CurrentStationInfo_StationInfoSwitches stationInfoSwitches = new CurrentStationInfo_StationInfoSwitches();
    public CurrentStationInfo_StationProperties stationProperties = new CurrentStationInfo_StationProperties();
    public int channel_Id;
    public static final int CHANNEL_ID_MIN;

    public CurrentStationInfo_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public CurrentStationInfo_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.pi_Type = 0;
        this.pi_Id = 0;
        this.si_Type = 0;
        this.ti_Type = 0;
        this.qi_Type = 0;
        this.channel_Id = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
        this.primaryInformation.reset();
        this.secondaryInformation.reset();
        this.tertiaryInformation.reset();
        this.quaternaryInformation.reset();
        this.stationInfoSwitches.reset();
        this.stationProperties.reset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        CurrentStationInfo_Status currentStationInfo_Status = (CurrentStationInfo_Status)bAPEntity;
        return this.primaryInformation.equalTo(currentStationInfo_Status.primaryInformation) && this.pi_Type == currentStationInfo_Status.pi_Type && this.pi_Id == currentStationInfo_Status.pi_Id && this.secondaryInformation.equalTo(currentStationInfo_Status.secondaryInformation) && this.si_Type == currentStationInfo_Status.si_Type && this.tertiaryInformation.equalTo(currentStationInfo_Status.tertiaryInformation) && this.ti_Type == currentStationInfo_Status.ti_Type && this.quaternaryInformation.equalTo(currentStationInfo_Status.quaternaryInformation) && this.qi_Type == currentStationInfo_Status.qi_Type && this.stationInfoSwitches.equalTo(currentStationInfo_Status.stationInfoSwitches) && this.stationProperties.equalTo(currentStationInfo_Status.stationProperties) && this.channel_Id == currentStationInfo_Status.channel_Id;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "CurrentStationInfo_Status:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        this.primaryInformation.serialize(bitStream);
        bitStream.pushByte((byte)this.pi_Type);
        bitStream.pushShort((short)this.pi_Id);
        this.secondaryInformation.serialize(bitStream);
        bitStream.pushByte((byte)this.si_Type);
        this.tertiaryInformation.serialize(bitStream);
        bitStream.pushByte((byte)this.ti_Type);
        this.quaternaryInformation.serialize(bitStream);
        bitStream.pushByte((byte)this.qi_Type);
        this.stationInfoSwitches.serialize(bitStream);
        this.stationProperties.serialize(bitStream);
        bitStream.pushShort((short)this.channel_Id);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.primaryInformation.deserialize(bitStream);
        this.pi_Type = bitStream.popFrontByte();
        this.pi_Id = bitStream.popFrontShort();
        this.secondaryInformation.deserialize(bitStream);
        this.si_Type = bitStream.popFrontByte();
        this.tertiaryInformation.deserialize(bitStream);
        this.ti_Type = bitStream.popFrontByte();
        this.quaternaryInformation.deserialize(bitStream);
        this.qi_Type = bitStream.popFrontByte();
        this.stationInfoSwitches.deserialize(bitStream);
        this.stationProperties.deserialize(bitStream);
        this.channel_Id = bitStream.popFrontShort();
    }

    public static int functionId() {
        return 21;
    }

    @Override
    public int getFunctionId() {
        return CurrentStationInfo_Status.functionId();
    }
}

