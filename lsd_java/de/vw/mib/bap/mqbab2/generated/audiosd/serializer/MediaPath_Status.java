/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.audiosd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.datatypes.BAPString;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class MediaPath_Status
implements StatusProperty {
    public int folder_Type;
    public static final int FOLDER_TYPE_NOT_SUPPORTED;
    public static final int FOLDER_TYPE_CATEGORY_UNKNOWN_MOOD_DF4_1;
    public static final int FOLDER_TYPE_CATEGORY_MOOD_DF4_1;
    public static final int FOLDER_TYPE_CATEGORY_UNKNOWN_AUDIOBOOKS_DF4_1;
    public static final int FOLDER_TYPE_CATEGORY_UNKNOWN_AUDIOBOOK_DF4_1;
    public static final int FOLDER_TYPE_DVD_CHAPTER;
    public static final int FOLDER_TYPE_DVD_MAIN_MENUE;
    public static final int FOLDER_TYPE_CATEGORY_VARIOUS_ARTISTS_DF4_1;
    public static final int FOLDER_TYPE_CATEGORY_UNKNOWN_PODCASTS_DF4_1;
    public static final int FOLDER_TYPE_CATEGORY_UNKNOWN_PODCAST_DF4_1;
    public static final int FOLDER_TYPE_CATEGORY_FAVORITES_DF4_1;
    public static final int FOLDER_TYPE_CATEGORY_LAST_COPIED_FILES_DF4_1;
    public static final int FOLDER_TYPE_CATEGORY_BORROWED_VIDEOS_DF4_1;
    public static final int FOLDER_TYPE_CATEGORY_VIDEO_PODCASTS_GERMAN_SENDUNGEN_DF4_1;
    public static final int FOLDER_TYPE_CATEGORY_MUSIC_VIDEOS_DF4_1;
    public static final int FOLDER_TYPE_CATEGORY_MOVIES_DF4_1;
    public static final int FOLDER_TYPE_CATEGORY_DYNAMIC_PLAYLISTS;
    public static final int FOLDER_TYPE_CATEGORY_DYNAMIC_PLAYLIST_ON_THE_GO;
    public static final int FOLDER_TYPE_CATEGORY_DYNAMIC_PLAYLIST_LAST_PLAYED;
    public static final int FOLDER_TYPE_CATEGORY_DYNAMIC_PLAYLIST_MOST_PLAYED;
    public static final int FOLDER_TYPE_CATEGORY_DYNAMIC_PLAYLIST_5_STARS;
    public static final int FOLDER_TYPE_CATEGORY_DYNAMIC_PLAYLIST_4_STARS;
    public static final int FOLDER_TYPE_CATEGORY_DYNAMIC_PLAYLIST_3_STARS;
    public static final int FOLDER_TYPE_CATEGORY_DYNAMIC_PLAYLIST_2_STARS;
    public static final int FOLDER_TYPE_CATEGORY_DYNAMIC_PLAYLIST_1_STAR;
    public static final int FOLDER_TYPE_CATEGORY_DYNAMIC_PLAYLIST_NOT_RATED;
    public static final int FOLDER_TYPE_CATEGORY_PODCASTS;
    public static final int FOLDER_TYPE_CATEGORY_PODCAST;
    public static final int FOLDER_TYPE_CATEGORY_ALL;
    public static final int FOLDER_TYPE_CATEGORY_AUDIOBOOKS;
    public static final int FOLDER_TYPE_CATEGORY_AUDIOBOOK;
    public static final int FOLDER_TYPE_CATEGORY_UNKNOWN_SONGS;
    public static final int FOLDER_TYPE_CATEGORY_UNKNOWN_SONG;
    public static final int FOLDER_TYPE_CATEGORY_SONGS;
    public static final int FOLDER_TYPE_CATEGORY_SONG;
    public static final int FOLDER_TYPE_CATEGORY_UNKNOWN_ALBUMS;
    public static final int FOLDER_TYPE_CATEGORY_UNKNOWN_ALBUM;
    public static final int FOLDER_TYPE_CATEGORY_ALBUMS;
    public static final int FOLDER_TYPE_CATEGORY_ALBUM;
    public static final int FOLDER_TYPE_CATEGORY_UNKNOWN_COMMENT;
    public static final int FOLDER_TYPE_CATEGORY_COMMENT;
    public static final int FOLDER_TYPE_CATEGORY_UNKNOWN_YEAR;
    public static final int FOLDER_TYPE_CATEGORY_YEAR;
    public static final int FOLDER_TYPE_CATEGORY_UNKNOWN_COMPOSERS;
    public static final int FOLDER_TYPE_CATEGORY_UNKNOWN_COMPOSER;
    public static final int FOLDER_TYPE_CATEGORY_COMPOSERS;
    public static final int FOLDER_TYPE_CATEGORY_COMPOSER;
    public static final int FOLDER_TYPE_CATEGORY_UNKNOWN_ARTISTS;
    public static final int FOLDER_TYPE_CATEGORY_UNKNOWN_ARTIST;
    public static final int FOLDER_TYPE_CATEGORY_ARTISTS;
    public static final int FOLDER_TYPE_CATEGORY_ARTIST;
    public static final int FOLDER_TYPE_CATEGORY_UNKNOWN_GENRES;
    public static final int FOLDER_TYPE_CATEGORY_UNKNOWN_GENRE;
    public static final int FOLDER_TYPE_CATEGORY_GENRES;
    public static final int FOLDER_TYPE_CATEGORY_GENRE;
    public static final int FOLDER_TYPE_VOICEMEMO_FOLDER;
    public static final int FOLDER_TYPE_IMAGE_FOLDER;
    public static final int FOLDER_TYPE_VIDEO_FOLDER;
    public static final int FOLDER_TYPE_AUDIO_FOLDER;
    public static final int FOLDER_TYPE_PLAYLIST_FOLDER;
    public static final int FOLDER_TYPE_FOLDER;
    public static final int FOLDER_TYPE_ANY_TYPE_UNKNOWN;
    public final BAPString path = new BAPString(152);
    private static final int MAX_PATH_LENGTH;

    public MediaPath_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public MediaPath_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.folder_Type = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
        this.path.reset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        MediaPath_Status mediaPath_Status = (MediaPath_Status)bAPEntity;
        return this.folder_Type == mediaPath_Status.folder_Type && this.path.equalTo(mediaPath_Status.path);
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "MediaPath_Status:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.folder_Type);
        this.path.serialize(bitStream);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.folder_Type = bitStream.popFrontByte();
        this.path.deserialize(bitStream);
    }

    public static int functionId() {
        return 37;
    }

    @Override
    public int getFunctionId() {
        return MediaPath_Status.functionId();
    }
}

