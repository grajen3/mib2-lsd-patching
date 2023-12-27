/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.audiosd.serializer;

import de.vw.mib.bap.datatypes.ArrayHeader;
import de.vw.mib.bap.datatypes.BAPArrayElement;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.datatypes.BAPString;
import de.vw.mib.bap.mqbab2.generated.audiosd.serializer.MediaBrowser_FileState;
import de.vw.mib.bap.stream.BitStream;

public final class MediaBrowser_Data
implements BAPArrayElement {
    private ArrayHeader arrayHeader;
    public static final int RECORD_ADDRESS_FILE_TYPE_FILE_STATE_FILE_NAME;
    public static final int RECORD_ADDRESS_FILE_TYPE_FILE_STATE;
    public static final int RECORD_ADDRESS_FILE_NAME;
    public static final int RECORD_ADDRESS_POS;
    public static final int POS_MIN;
    public int pos;
    public static final int FILE_TYPE_ANY_TYPE_UNKNOWN;
    public static final int FILE_TYPE_DIRECTORY_FOLDER;
    public static final int FILE_TYPE_ITEM_TRACK;
    public static final int FILE_TYPE_PLAYLIST;
    public static final int FILE_TYPE_PLAYLIST_FOLDER;
    public static final int FILE_TYPE_UNKNOWN_CATEGORY;
    public static final int FILE_TYPE_AUDIO_FILE;
    public static final int FILE_TYPE_VIDEO_FILE;
    public static final int FILE_TYPE_CD_AUDIO_TRACK;
    public static final int FILE_TYPE_CD_AUDIO_TRACK_CD_TEXT;
    public static final int FILE_TYPE_VOICEMEMO_FILE;
    public static final int FILE_TYPE_IMAGE_FILE;
    public static final int FILE_TYPE_AUDIO_FOLDER;
    public static final int FILE_TYPE_VIDEO_FOLDER;
    public static final int FILE_TYPE_IMAGE_FOLDER;
    public static final int FILE_TYPE_VOICEMEMO_FOLDER;
    public static final int FILE_TYPE_CATEGORY_GENRE;
    public static final int FILE_TYPE_CATEGORY_GENRES;
    public static final int FILE_TYPE_CATEGORY_UNKNOWN_GENRE;
    public static final int FILE_TYPE_CATEGORY_UNKNOWN_GENRES;
    public static final int FILE_TYPE_CATEGORY_ARTIST;
    public static final int FILE_TYPE_CATEGORY_ARTISTS;
    public static final int FILE_TYPE_CATEGORY_UNKNOWN_ARTIST;
    public static final int FILE_TYPE_CATEGORY_UNKNOWN_ARTISTS;
    public static final int FILE_TYPE_CATEGORY_COMPOSER;
    public static final int FILE_TYPE_CATEGORY_COMPOSERS;
    public static final int FILE_TYPE_CATEGORY_UNKNOWN_COMPOSER;
    public static final int FILE_TYPE_CATEGORY_UNKNOWN_COMPOSERS;
    public static final int FILE_TYPE_CATEGORY_YEAR;
    public static final int FILE_TYPE_CATEGORY_UNKNOWN_YEAR;
    public static final int FILE_TYPE_CATEGORY_COMMENT;
    public static final int FILE_TYPE_CATEGORY_UNKNOWN_COMMENT;
    public static final int FILE_TYPE_CATEGORY_ALBUM;
    public static final int FILE_TYPE_CATEGORY_ALBUMS;
    public static final int FILE_TYPE_CATEGORY_UNKNOWN_ALBUM;
    public static final int FILE_TYPE_CATEGORY_UNKNOWN_ALBUMS;
    public static final int FILE_TYPE_CATEGORY_SONG;
    public static final int FILE_TYPE_CATEGORY_SONGS;
    public static final int FILE_TYPE_CATEGORY_UNKNOWN_SONG;
    public static final int FILE_TYPE_CATEGORY_UNKNOWN_SONGS;
    public static final int FILE_TYPE_CATEGORY_AUDIOBOOK;
    public static final int FILE_TYPE_CATEGORY_AUDIOBOOKS;
    public static final int FILE_TYPE_CATEGORY_ALL;
    public static final int FILE_TYPE_CATEGORY_PODCAST;
    public static final int FILE_TYPE_CATEGORY_PODCASTS;
    public static final int FILE_TYPE_CATEGORY_DYNAMIC_PLAYLIST_NOT_RATED;
    public static final int FILE_TYPE_CATEGORY_DYNAMIC_PLAYLIST_1_STAR;
    public static final int FILE_TYPE_CATEGORY_DYNAMIC_PLAYLIST_2_STARS;
    public static final int FILE_TYPE_CATEGORY_DYNAMIC_PLAYLIST_3_STARS;
    public static final int FILE_TYPE_CATEGORY_DYNAMIC_PLAYLIST_4_STARS;
    public static final int FILE_TYPE_CATEGORY_DYNAMIC_PLAYLIST_5_STARS;
    public static final int FILE_TYPE_CATEGORY_DYNAMIC_PLAYLIST_MOST_PLAYED;
    public static final int FILE_TYPE_CATEGORY_DYNAMIC_PLAYLIST_LAST_PLAYED;
    public static final int FILE_TYPE_CATEGORY_DYNAMIC_PLAYLIST_ON_THE_GO;
    public static final int FILE_TYPE_CATEGORY_DYNAMIC_PLAYLISTS;
    public static final int FILE_TYPE_CATEGORY_MOVIES_DF4_1;
    public static final int FILE_TYPE_CATEGORY_MUSIC_VIDEOS_DF4_1;
    public static final int FILE_TYPE_CATEGORY_VIDEO_PODCASTS_GERMAN_SENDUNGEN_DF4_1;
    public static final int FILE_TYPE_CATEGORY_BORROWED_VIDEOS_DF4_1;
    public static final int FILE_TYPE_CATEGORY_LAST_COPIED_FILES_DF4_1;
    public static final int FILE_TYPE_CATEGORY_FAVORITES_DF4_1;
    public static final int FILE_TYPE_CATEGORY_UNKNOWN_PODCAST_DF4_1;
    public static final int FILE_TYPE_CATEGORY_UNKNOWN_PODCASTS_DF4_1;
    public static final int FILE_TYPE_CATEGORY_VARIOUS_ARTISTS_DF4_1;
    public static final int FILE_TYPE_DVD_MAIN_MENUE;
    public static final int FILE_TYPE_DVD_CHAPTER;
    public static final int FILE_TYPE_DVD_TITLE;
    public static final int FILE_TYPE_CATEGORY_UNKNOWN_AUDIOBOOK_DF4_1;
    public static final int FILE_TYPE_CATEGORY_UNKNOWN_AUDIOBOOKS_DF4_1;
    public static final int FILE_TYPE_CATEGORY_MOOD_DF4_1;
    public static final int FILE_TYPE_CATEGORY_UNKNOWN_MOOD_DF4_1;
    public static final int FILE_TYPE_NOT_SUPPORTED;
    public int fileType;
    public MediaBrowser_FileState fileState;
    private static final int MAX_FILENAME_LENGTH;
    public final BAPString fileName;

    @Override
    public void setArrayHeader(ArrayHeader arrayHeader) {
        this.arrayHeader = arrayHeader;
    }

    @Override
    public ArrayHeader getArrayHeader() {
        return this.arrayHeader;
    }

    public MediaBrowser_Data(ArrayHeader arrayHeader) {
        this.arrayHeader = arrayHeader;
        this.fileState = new MediaBrowser_FileState();
        this.fileName = new BAPString(97);
        this.internalReset();
        this.customInitialization();
    }

    public MediaBrowser_Data(BitStream bitStream, ArrayHeader arrayHeader) {
        this(arrayHeader);
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.pos = 0;
        this.fileType = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
        this.arrayHeader.reset();
        this.fileState.reset();
        this.fileName.reset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        MediaBrowser_Data mediaBrowser_Data = (MediaBrowser_Data)bAPEntity;
        return this.arrayHeader.equalTo(mediaBrowser_Data.arrayHeader) && this.pos == mediaBrowser_Data.pos && this.fileType == mediaBrowser_Data.fileType && this.fileState.equalTo(mediaBrowser_Data.fileState) && this.fileName.equalTo(mediaBrowser_Data.fileName);
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "MediaBrowser_Empty:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        switch (this.arrayHeader.getSerializationRecordAddress()) {
            case 15: {
                this.arrayHeader.serializePosOfArrayElement(bitStream, this);
                break;
            }
            case 2: {
                this.arrayHeader.serializePosOfArrayElement(bitStream, this);
                this.fileName.serialize(bitStream);
                break;
            }
            case 1: {
                this.arrayHeader.serializePosOfArrayElement(bitStream, this);
                bitStream.pushByte((byte)this.fileType);
                this.fileState.serialize(bitStream);
                break;
            }
            case 0: {
                this.arrayHeader.serializePosOfArrayElement(bitStream, this);
                bitStream.pushByte((byte)this.fileType);
                this.fileState.serialize(bitStream);
                this.fileName.serialize(bitStream);
                break;
            }
        }
    }

    @Override
    public void deserialize(BitStream bitStream) {
        switch (this.arrayHeader.getSerializationRecordAddress()) {
            case 15: {
                this.arrayHeader.deserializePosOfArrayElement(bitStream, this);
                break;
            }
            case 2: {
                this.arrayHeader.deserializePosOfArrayElement(bitStream, this);
                this.fileName.deserialize(bitStream);
                break;
            }
            case 1: {
                this.arrayHeader.deserializePosOfArrayElement(bitStream, this);
                this.fileType = bitStream.popFrontByte();
                this.fileState.deserialize(bitStream);
                break;
            }
            case 0: {
                this.arrayHeader.deserializePosOfArrayElement(bitStream, this);
                this.fileType = bitStream.popFrontByte();
                this.fileState.deserialize(bitStream);
                this.fileName.deserialize(bitStream);
                break;
            }
        }
    }

    @Override
    public void setPos(int n) {
        this.pos = n;
    }

    @Override
    public int getPos() {
        return this.pos;
    }
}

