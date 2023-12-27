/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.media.services.browser;

import de.vw.mib.asl.api.media.services.I18nString;
import org.dsi.ifc.global.ResourceLocator;

public class MediaEntry {
    private final long entryId;
    public static final int CONTENTTYPE_UNKNOWN;
    public static final int CONTENTTYPE_AUDIO;
    public static final int CONTENTTYPE_VIDEO;
    public static final int CONTENTTYPE_IMAGE;
    public static final int CONTENTTYPE_FOLDER;
    public static final int CONTENTTYPE_PLAYLIST;
    public static final int CONTENTTYPE_PLAYLIST_FOLDER;
    public static final int CONTENTTYPE_AUDIO_FOLDER;
    public static final int CONTENTTYPE_VIDEO_FOLDER;
    public static final int CONTENTTYPE_IMAGE_FOLDER;
    public static final int CONTENTTYPE_DYNAMIC_PLAYLIST;
    public static final int CONTENTTYPE_PODCAST_FOLDER;
    public static final int CONTENTTYPE_SELECTCONTROL;
    public static final int CONTENTTYPE_ARTIST_FOLDER;
    public static final int CONTENTTYPE_ALBUM_FOLDER;
    public static final int CONTENTTYPE_TITLE_FOLDER;
    public static final int CONTENTTYPE_GENRE_FOLDER;
    public static final int CONTENTTYPE_COMPOSER_FOLDER;
    public static final int CONTENTTYPE_AUDIOBOOK_FOLDER;
    public static final int CONTENTTYPE_NOTPLAYABLE_FOLDER;
    public static final int CONTENTTYPE_FAVORITE_FOLDER;
    public static final int BROWSER_INFO_LIST__STATE__DEFAULT_VALUE;
    public static final int BROWSER_INFO_LIST__STATE__C4_DRM_PROTECTED;
    public static final int BROWSER_INFO_LIST__STATE__C1_MISSING;
    public static final int BROWSER_INFO_LIST__STATE__C6_PREPARING_IMPORT;
    public static final int BROWSER_INFO_LIST__STATE__C5_IMPORTING;
    public static final int BROWSER_INFO_LIST__STATE__C0_PLAYABLE;
    public static final int BROWSER_INFO_LIST__STATE__C2_ERRONEOUS;
    int contentType;
    private final int fileState;
    private final I18nString filename;
    private final I18nString genre;
    private final I18nString artist;
    private final I18nString album;
    private final I18nString title;
    private final ResourceLocator cover;

    public MediaEntry() {
        this.entryId = 0L;
        this.contentType = 0;
        this.genre = null;
        this.artist = null;
        this.album = null;
        this.title = null;
        this.filename = null;
        this.cover = null;
        this.fileState = 0;
    }

    public MediaEntry(long l, int n, I18nString i18nString, I18nString i18nString2, I18nString i18nString3, I18nString i18nString4, I18nString i18nString5, ResourceLocator resourceLocator, int n2) {
        this.entryId = l;
        this.contentType = n;
        this.genre = i18nString;
        this.artist = i18nString2;
        this.album = i18nString3;
        this.title = i18nString4;
        this.filename = i18nString5;
        this.cover = resourceLocator;
        this.fileState = n2;
    }

    public MediaEntry(long l, int n, I18nString i18nString, I18nString i18nString2, I18nString i18nString3, I18nString i18nString4, I18nString i18nString5, ResourceLocator resourceLocator) {
        this.entryId = l;
        this.contentType = n;
        this.genre = i18nString;
        this.artist = i18nString2;
        this.album = i18nString3;
        this.title = i18nString4;
        this.filename = i18nString5;
        this.cover = resourceLocator;
        this.fileState = 0;
    }

    public long getEntryId() {
        return this.entryId;
    }

    public int getContentType() {
        return this.contentType;
    }

    public int getFileState() {
        return this.fileState;
    }

    public I18nString getGenreName() {
        return this.genre;
    }

    public I18nString getArtistName() {
        return this.artist;
    }

    public I18nString getAlbumName() {
        return this.album;
    }

    public I18nString getTitleName() {
        return this.title;
    }

    public I18nString getFileName() {
        return this.filename;
    }

    public ResourceLocator getCover() {
        return this.cover;
    }

    public String toString() {
        return new StringBuffer().append("id: ").append(this.entryId).append(" type:").append(this.contentType).append(" genre:").append(this.genre).append(" artist:").append(this.artist).append(" album:").append(this.album).append(" title:").append(this.title).append(" filename:").append(this.filename).append(" filestate:").append(this.fileState).toString();
    }
}

