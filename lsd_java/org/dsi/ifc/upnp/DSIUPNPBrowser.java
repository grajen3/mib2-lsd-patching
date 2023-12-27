/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.upnp;

import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.upnp.ListEntry;

public interface DSIUPNPBrowser
extends DSIBase {
    public static final String VERSION;
    public static final int ATTR_BROWSEFOLDER;
    public static final int ATTR_LISTSIZE;
    public static final int RT_CHANGEFOLDER;
    public static final int RT_REQUESTLIST;
    public static final int RP_RESPONSELIST;
    public static final int IN_INVALIDBROWSEPATH;
    public static final int LISTSIZEFLAG_NONE;
    public static final int ENTRYFLAG_NOENTRIES;
    public static final int ENTRYFLAG_DRM;
    public static final int ENTRYFLAG_CORRUPT;
    public static final int ENTRYFLAG_DEADLINK;
    public static final int ENTRYFLAG_INTERNATIONALIZABLE;
    public static final int ENTRYFLAG_SELECTED;
    public static final int ENTRYFLAG_PARTLY_SELECTED;
    public static final int ENTRYFLAG_IMPORT_RUNNING;
    public static final int ENTRYFLAG_IMPORT_PENDING;
    public static final int ENTRYFLAG_IMPORT_NOT_PLAYABLE;
    public static final int ENTRYFLAG_ALREADY_IMPORTED;
    public static final int ENTRYFLAG_PARTLY_IMPORTED;
    public static final int ENTRYFLAG_FAVORITE;
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
    public static final int CONTENTTYPE_SHARED_AUDIO_QUEUE;
    public static final int CONTENTTYPE_DEVICE;

    default public void changeFolder(ListEntry[] listEntryArray) {
    }

    default public void requestList(String string, int n, int n2, int n3) {
    }
}

