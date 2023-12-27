/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.common.api.media;

import de.vw.mib.bap.mqbab2.common.api.hmi.HMIEventListener;
import de.vw.mib.bap.mqbab2.common.api.media.MediaService;

public interface MediaServiceListener
extends HMIEventListener {
    public static final int MEDIA_SERVICE__CURRENT_AUDIO_SOURCE;
    public static final int MEDIA_SERVICE__CURRENT_AUDIO_SOURCE_STATE;
    public static final int MEDIA_SERVICE__CD_MEDIUM_TYPE;
    public static final int MEDIA_SERVICE__CD_CONTENT_TYPE;
    public static final int MEDIA_SERVICE__DVD_CHAPTER;
    public static final int MEDIA_SERVICE__DVD_CHAPTER_COUNT;
    public static final int MEDIA_SERVICE__DVD_MENU_ACTIVE;
    public static final int MEDIA_SERVICE__DVD_REGION_CODE_MISMATCH;
    public static final int MEDIA_SERVICE__BAP_MEDIA_BROWSER_AVAILABLE;
    public static final int MEDIA_SERVICE__BAP_MEDIA_BROWSER_STATE;
    public static final int MEDIA_SERVICE__CURRENTLY_PLAYED_FOLDER_NAME;
    public static final int MEDIA_SERVICE__REPEAT_SUPPORTED;
    public static final int MEDIA_SERVICE__REPEAT_ACTIVE;
    public static final int MEDIA_SERVICE__REPEAT_MODE;
    public static final int MEDIA_SERVICE__MIX_SUPPORTED;
    public static final int MEDIA_SERVICE__MIX_ACTIVE;
    public static final int MEDIA_SERVICE__INCLUDE_SUBFOLDERS_STATE;
    public static final int MEDIA_SERVICE__PLAY_MORE_LIKE_THIS_ACTIVE;
    public static final int MEDIA_SERVICE__SKIP_FORWARD_SUPPORTED;
    public static final int MEDIA_SERVICE__SKIP_BACKWARD_SUPPORTED;
    public static final int MEDIA_SERVICE__PLAYER_STATE;
    public static final int MEDIA_SERVICE__REMOTE_CONTROL_PLAYER_STATE;
    public static final int MEDIA_SERVICE__CONNECTED_MITSUMI_ADAPTER;
    public static final int MEDIA_SERVICE__CURRENT_IMPORT_SOURCE;
    public static final int MEDIA_SERVICE__CURRENT_IMPORT_STATE;
    public static final int MEDIA_SERVICE__CURRENT_IMPORT_PROGRESS;
    public static final int MEDIA_SERVICE__JUKEBOX_DELETION_STATE;
    public static final int MEDIA_SERVICE__DATABASE_BROWSING_ACTIVE;
    public static final int MEDIA_SERVICE__SECOND_USB_SOCKET_AVAILABLE;
    public static final int MEDIA_SERVICE__META_INFO_REQUEST_SUPPORTED;
    public static final int MEDIA_SERVICE__CURRENT_TRACK_INFO;
    public static final int MEDIA_SERVICE__ACTIVE_TRACK_INFO;
    public static final int MEDIA_SERVICE__CURRENT_ACTION;
    public static final int MEDIA_SERVICE__BROWSED_FOLDER;
    public static final int MEDIA_SERVICE__BROWSED_FOLDER_ACTIVE_ELEMENT;
    public static final int MEDIA_SERVICE__AVAILABLE_AUDIO_SOURCES;
    public static final int MEDIA_SERVICE__FILE_BROWSER;
    public static final int MEDIA_SREVICE__HMI_EVENT__VIDEO_DVD_USER_ACTION_BLOCKED;
    public static final int MEDIA_SREVICE__HMI_EVENT__MEDIA_BROWSER_ACTION_PERFORMED;

    default public void updateMediaData(MediaService mediaService, int n) {
    }
}

