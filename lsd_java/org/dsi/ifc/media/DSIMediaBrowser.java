/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.media;

import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.media.ListEntry;

public interface DSIMediaBrowser
extends DSIBase {
    public static final String VERSION;
    public static final int ATTR_BROWSEMODE;
    public static final int ATTR_CONTENTFILTER;
    public static final int ATTR_BROWSEMEDIA;
    public static final int ATTR_BROWSEFOLDER;
    public static final int ATTR_LISTSIZE;
    public static final int ATTR_SEARCHSPELLERSTATE;
    public static final int ATTR_SEARCHSIZE;
    public static final int ATTR_ALPHABETICALINDEX;
    public static final int RT_ENABLERECURSESUBDIRECTORIES;
    public static final int RT_ADDSELECTION;
    public static final int RT_UNDOLASTSELECTION;
    public static final int RT_RESETSELECTION;
    public static final int RT_SETCONTENTFILTER;
    public static final int RT_SETBROWSEMODE;
    public static final int RT_SETBROWSEMEDIA;
    public static final int RT_CHANGEFOLDER;
    public static final int RT_REQUESTLIST;
    public static final int RT_REQUESTPICKLIST;
    public static final int RT_ACTIVATESEARCHSPELLER;
    public static final int RT_DEACTIVATESEARCHSPELLER;
    public static final int RT_REQUESTSEARCHLIST;
    public static final int RT_SETSEARCHSTRING;
    public static final int RT_RESETSEARCHSTRING;
    public static final int RT_SELECTSEARCHRESULT;
    public static final int RT_SETSEARCHCRITERIA;
    public static final int RT_REQUESTSEARCHLISTEXT;
    public static final int RT_REQUESTFULLYQUALIFIEDNAME;
    public static final int RP_RESPONSELIST;
    public static final int RP_SELECTIONRESULT;
    public static final int RP_RESPONSEPICKLIST;
    public static final int RP_RESPONSESEARCHLIST;
    public static final int RP_RESPONSESETSEARCHSTRING;
    public static final int RP_RESPONSESELECTSEARCHRESULT;
    public static final int RP_RESPONSESETSEARCHCRITERIA;
    public static final int RP_RESPONSESEARCHLISTEXT;
    public static final int RP_RESPONSEFULLYQUALIFIEDNAME;
    public static final int BROWSERID_1;
    public static final int BROWSERID_2;
    public static final int BROWSERID_3;
    public static final int BROWSERID_4;
    public static final int BROWSERID_5;
    public static final int BROWSERID_6;
    public static final int BROWSERID_7;
    public static final int BROWSERID_RECORDER;
    public static final int MEDIATAGTYPE_ALBUM;
    public static final int MEDIATAGTYPE_GENRE;
    public static final int MEDIATAGTYPE_ARTIST;
    public static final int MEDIATAGTYPE_TITLE;
    public static final int MEDIATAGTYPE_VIDEO;
    public static final int MEDIATAGTYPE_FILENAME;
    public static final int MEDIATAGTYPE_FOLDER;
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
    public static final int ENTRYFLAG_ONLINE;
    public static final int BROWSEMODE_RAW;
    public static final int BROWSEMODE_CONTENT;
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
    public static final int SELECTIONSTATE_NONE;
    public static final int SELECTIONSTATE_ALL;
    public static final int SELECTIONSTATE_PARTIAL;
    public static final int SELECTIONRANGE_INDEX;
    public static final int SELECTIONRANGE_ALL;
    public static final int SELECTIONRESULT_OK;
    public static final int SELECTIONRESULT_JUKEBOX_FULL;
    public static final int SELECTIONRESULT_LIBRARY_DB_FULL;
    public static final int SELECTIONRESULT_NOK;
    public static final int SEARCHSPELLERCRITERIA_ALBUM;
    public static final int SEARCHSPELLERCRITERIA_ARTIST;
    public static final int SEARCHSPELLERCRITERIA_TITLE;
    public static final int SEARCHSPELLERCRITERIA_FILENAME;
    public static final int SEARCHSPELLERCRITERIA_FOLDER;
    public static final int SEARCHSPELLERSTATE_UNKNOWN;
    public static final int SEARCHSPELLERSTATE_SEARCHING;
    public static final int SEARCHSPELLERSTATE_WAITING;
    public static final int SEARCHSPELLERSTATE_SEARCHNOTPOSSIBLE;
    public static final int CONTENTFILTER_AUDIO;
    public static final int CONTENTFILTER_VIDEO;
    public static final int CONTENTFILTER_PLAYLIST;
    public static final int CONTENTFILTER_PICTURE;

    default public void setContentFilter(int n) {
    }

    default public void setBrowseMode(int n) {
    }

    default public void setBrowseMedia(long l, long l2) {
    }

    default public void changeFolder(ListEntry[] listEntryArray) {
    }

    default public void requestList(long l, int n, int n2, int n3) {
    }

    default public void requestPickList(long[] lArray) {
    }

    default public void enableRecurseSubdirectories(boolean bl) {
    }

    default public void addSelection(boolean bl, int n, long l, int n2, boolean bl2) {
    }

    default public void undoLastSelection() {
    }

    default public void resetSelection() {
    }

    default public void setSearchString(String string) {
    }

    default public void setSearchCriteria(int n) {
    }

    default public void activateSearchSpeller() {
    }

    default public void deactivateSearchSpeller() {
    }

    default public void selectSearchResult(long l) {
    }

    default public void requestSearchList(long l, int n, int n2) {
    }

    default public void resetSearchString() {
    }

    default public void requestSearchListExt(long l, int n, int n2) {
    }

    default public void requestFullyQualifiedName(long l) {
    }
}

