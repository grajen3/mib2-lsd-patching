/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.mediacontrol.services.browser;

import de.vw.mib.asl.api.mediacontrol.services.MediaControlCallback;
import de.vw.mib.asl.api.mediacontrol.services.browser.MediaControlCallbackListRequest;
import de.vw.mib.asl.api.mediacontrol.services.browser.MediaControlListenerFolderPath;
import de.vw.mib.asl.api.mediacontrol.services.browser.MediaControlListenerInvalidBrowserPath;
import de.vw.mib.asl.api.mediacontrol.services.browser.MediaControlListenerListSize;
import de.vw.mib.asl.api.mediacontrol.services.browser.MediaControlListenerListState;

public interface MediaControlServiceBrowser {
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
    public static final int CONTENTTYPE_SHARED_AUDIO_QUEUE_FOLDER;
    public static final int CONTENTTYPE_DEVICE_FOLDER;
    public static final int LIST_STATE_NOT_AVAILABLE;
    public static final int LIST_STATE_LOADING;
    public static final int LIST_STATE_EMPTY;
    public static final int LIST_STATE_READY;

    default public void addListStateListener(MediaControlListenerListState mediaControlListenerListState) {
    }

    default public void addListSizeListener(MediaControlListenerListSize mediaControlListenerListSize) {
    }

    default public void addFolderPathListener(MediaControlListenerFolderPath mediaControlListenerFolderPath) {
    }

    default public void addInvalidBrowsePathListener(MediaControlListenerInvalidBrowserPath mediaControlListenerInvalidBrowserPath) {
    }

    default public void openDeviceSelection(MediaControlCallback mediaControlCallback) {
    }

    default public void openDeviceRoot(MediaControlCallback mediaControlCallback) {
    }

    default public void moveFolderLevelUp(int n, MediaControlCallback mediaControlCallback) {
    }

    default public void openFolder(String string, int n, MediaControlCallback mediaControlCallback) {
    }

    default public void requestList(int n, int n2, MediaControlCallbackListRequest mediaControlCallbackListRequest) {
    }
}

