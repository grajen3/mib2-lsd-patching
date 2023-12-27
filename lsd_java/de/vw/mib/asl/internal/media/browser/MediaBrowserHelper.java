/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.browser;

import de.vw.mib.asl.api.devicehandling.MediumState;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.avdc.audio.browser.transformer.ExtendedListEntry;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.media.browser.MediaBrowser;
import de.vw.mib.asl.internal.media.browser.MediaBrowserState;
import de.vw.mib.asl.internal.media.browser.Selection;
import de.vw.mib.asl.internal.media.playback.MediaPlayerState;
import de.vw.mib.asl.internal.media.playback.PlayMode;
import de.vw.mib.asl.internal.media.sourcehandling.state.MediaCollector;
import de.vw.mib.util.StringBuilder;
import de.vw.mib.util.Util;
import generated.de.vw.mib.asl.internal.ListManager;
import generated.de.vw.mib.has.containers.MediaBrowserEntryContainer;
import java.util.List;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.media.EntryInfo;
import org.dsi.ifc.media.ListEntry;
import org.dsi.ifc.media.MediaInfo;

public class MediaBrowserHelper {
    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean isActive(MediaPlayerState mediaPlayerState, MediaBrowserState mediaBrowserState, ListEntry listEntry) {
        if (mediaPlayerState == null || mediaBrowserState == null || listEntry == null) return false;
        MediaCollector mediaCollector = mediaPlayerState.getActiveMedia();
        PlayMode playMode = mediaPlayerState.getPlaybackMode();
        Object[] objectArray = mediaPlayerState.getPlaybackPath();
        EntryInfo entryInfo = mediaPlayerState.getPlaybackEntry();
        MediaCollector mediaCollector2 = mediaBrowserState.getBrowseMedia();
        Object[] objectArray2 = mediaBrowserState.getBrowseFolder();
        if (mediaCollector == null || Util.isNullOrEmpty(objectArray) || entryInfo == null || playMode == PlayMode.UNKNOWN || mediaCollector2 == null || Util.isNullOrEmpty(objectArray2) || listEntry == null || mediaCollector != mediaCollector2) return false;
        if (MediaBrowserHelper.isSameFolder((ListEntry[])objectArray, (ListEntry[])objectArray2)) {
            if (!MediaBrowserHelper.isFile(listEntry)) return false;
            if (!mediaPlayerState.isIPodMixMode() && !mediaCollector.isBT()) return MediaBrowserHelper.isSameListEntry(listEntry, entryInfo);
            if (!Util.isNullOrEmpty(entryInfo.getTitle()) && !Util.isNullOrEmpty(listEntry.getTitle())) {
                return entryInfo.getTitle().equals(listEntry.getTitle());
            }
            if (!Util.isNullOrEmpty(entryInfo.getFilename()) && !Util.isNullOrEmpty(listEntry.getFilename())) {
                return entryInfo.getFilename().equals(listEntry.getFilename());
            }
            if (!Util.isNullOrEmpty(entryInfo.getTitle()) && !Util.isNullOrEmpty(listEntry.getFilename())) {
                return entryInfo.getTitle().equals(listEntry.getFilename());
            }
            if (Util.isNullOrEmpty(entryInfo.getFilename()) || Util.isNullOrEmpty(listEntry.getTitle())) return false;
            return entryInfo.getFilename().equals(listEntry.getTitle());
        }
        if (!MediaBrowserHelper.isFolder(listEntry) || !MediaBrowserHelper.isSubFolder((ListEntry[])objectArray2, (ListEntry[])objectArray) || mediaPlayerState.isJoggerMode()) return false;
        return MediaBrowserHelper.isSameListEntry((ListEntry)objectArray[objectArray2.length], listEntry);
    }

    public static ListEntry getListEntry(EntryInfo entryInfo) {
        ListEntry listEntry = null;
        if (entryInfo != null) {
            listEntry = new ListEntry(entryInfo.entryID, entryInfo.filename, entryInfo.title, entryInfo.contentType, 0, entryInfo.flags, null);
        }
        return listEntry;
    }

    public static boolean compareStrings(String string, String string2) {
        if (string == null && string2 == null) {
            return true;
        }
        if (string == null || string2 == null) {
            return false;
        }
        return string.equals(string2);
    }

    public static ExtendedListEntry getListItemByIndex(GenericASLList genericASLList, int n) {
        Object object;
        ExtendedListEntry extendedListEntry = null;
        if (genericASLList != null && genericASLList.isValidItem(object = genericASLList.getRowItemCacheOnly(n))) {
            extendedListEntry = (ExtendedListEntry)object;
        }
        return extendedListEntry;
    }

    public static ExtendedListEntry getListItemById(GenericASLList genericASLList, long l) {
        Object object;
        ExtendedListEntry extendedListEntry = null;
        if (genericASLList != null && genericASLList.isValidItem(object = genericASLList.getListItemByIdCacheOnly(l))) {
            extendedListEntry = (ExtendedListEntry)object;
        }
        return extendedListEntry;
    }

    public static boolean resourceLocatorChanged(ResourceLocator resourceLocator, ResourceLocator resourceLocator2) {
        if (resourceLocator == null && resourceLocator2 == null) {
            return false;
        }
        if (resourceLocator == null || resourceLocator2 == null) {
            return true;
        }
        if (resourceLocator.url == null && resourceLocator2.url == null) {
            return false;
        }
        if (resourceLocator.url == null || resourceLocator2.url == null) {
            return true;
        }
        return !resourceLocator.url.equals(resourceLocator2.url);
    }

    public static boolean isSameMedia(MediaInfo mediaInfo, MediaInfo mediaInfo2) {
        if (mediaInfo == null || mediaInfo2 == null) {
            return mediaInfo == null && mediaInfo2 == null;
        }
        return mediaInfo != null && mediaInfo2 != null && mediaInfo.deviceID == mediaInfo2.deviceID && mediaInfo.mediaID == mediaInfo2.mediaID;
    }

    public static boolean isSameFolder(ListEntry[] listEntryArray, ListEntry[] listEntryArray2) {
        return MediaBrowserHelper.isSameFolder(listEntryArray, listEntryArray2, -1, false);
    }

    private static boolean isSameFolder(ListEntry[] listEntryArray, ListEntry[] listEntryArray2, int n, boolean bl) {
        if (Util.isNullOrEmpty(listEntryArray) || Util.isNullOrEmpty(listEntryArray2)) {
            return Util.isNullOrEmpty(listEntryArray) && Util.isNullOrEmpty(listEntryArray2);
        }
        if (listEntryArray.length != listEntryArray2.length && n == -1) {
            return false;
        }
        int n2 = Math.max(listEntryArray.length, listEntryArray2.length);
        if (n > n2) {
            throw new IllegalArgumentException("level > max(path1.length, path2.length)");
        }
        for (int i2 = bl ? 1 : 0; i2 < (n == -1 ? listEntryArray.length : n); ++i2) {
            if (MediaBrowserHelper.isSameListEntry(listEntryArray[i2], listEntryArray2[i2])) continue;
            return false;
        }
        return true;
    }

    public static boolean isSubFolder(ListEntry[] listEntryArray, ListEntry[] listEntryArray2) {
        if (Util.isNullOrEmpty(listEntryArray2) || Util.isNullOrEmpty(listEntryArray)) {
            return Util.isNullOrEmpty(listEntryArray2) && Util.isNullOrEmpty(listEntryArray);
        }
        if (listEntryArray2.length < listEntryArray.length) {
            return false;
        }
        return MediaBrowserHelper.isSameFolder(listEntryArray2, listEntryArray, listEntryArray.length, false);
    }

    public static boolean isSameListEntry(ListEntry listEntry, ListEntry listEntry2) {
        if (listEntry == null || listEntry2 == null) {
            return listEntry == null && listEntry2 == null;
        }
        if (listEntry.getEntryID() == listEntry2.getEntryID() && listEntry.getContentType() != listEntry2.getContentType()) {
            ServiceManager.logger.error(32).append("Content types of entries do not match although the entryIds do!").log();
        }
        return listEntry.getEntryID() == listEntry2.getEntryID() && listEntry.getContentType() == listEntry2.getContentType();
    }

    public static boolean isSameListEntry(ListEntry listEntry, EntryInfo entryInfo) {
        if (listEntry == null || entryInfo == null) {
            return listEntry == null && entryInfo == null;
        }
        if (listEntry.getEntryID() == entryInfo.getEntryID() && listEntry.getContentType() != entryInfo.getContentType()) {
            ServiceManager.logger.error(32).append("Content types of entries do not match although the entryIds do!").log();
        }
        return listEntry.getEntryID() == entryInfo.entryID && listEntry.getContentType() == entryInfo.getContentType();
    }

    public static boolean isSameEntryInfo(EntryInfo entryInfo, EntryInfo entryInfo2) {
        if (entryInfo == null || entryInfo2 == null) {
            return entryInfo == null && entryInfo2 == null;
        }
        if (entryInfo.getEntryID() == entryInfo2.getEntryID() && entryInfo.getContentType() != entryInfo2.getContentType()) {
            ServiceManager.logger.error(32).append("Content types of entries do not match although the entryIds do!").log();
        }
        return entryInfo.getEntryID() == entryInfo2.entryID && entryInfo.getContentType() == entryInfo2.getContentType() && entryInfo.getAlbum().equals(entryInfo2.getAlbum()) && entryInfo.getArtist().equals(entryInfo2.getAlbum()) && entryInfo.getFilename().equals(entryInfo2.getAlbum()) && entryInfo.getGenre().equals(entryInfo2.getAlbum()) && entryInfo.getTitle().equals(entryInfo2.getAlbum()) && entryInfo.getAlbumID() == entryInfo2.getAlbumID() && entryInfo.getGenreID() == entryInfo2.getGenreID() && entryInfo.getTrackNo() == entryInfo2.getTrackNo();
    }

    public static String getListString(GenericASLList genericASLList) {
        String string = "null";
        if (genericASLList != null) {
            if (genericASLList == ListManager.getGenericASLList(3648)) {
                string = "AVDC_AUDIO_BROWSER_ALBUM_INFO_LIST";
            } else if (genericASLList == ListManager.getGenericASLList(99)) {
                string = "AVDC_AUDIO_BROWSER_ARTIST_INFO_LIST";
            } else if (genericASLList == ListManager.getGenericASLList(102)) {
                string = "AVDC_AUDIO_BROWSER_GENRE_INFO_LIST";
            } else if (genericASLList == ListManager.getGenericASLList(3650)) {
                string = "AVDC_AUDIO_BROWSER_TITLE_INFO_LIST";
            } else if (genericASLList == ListManager.getGenericASLList(3651)) {
                string = "AVDC_AUDIO_BROWSER_VIDEO_INFO_LIST";
            } else if (genericASLList == ListManager.getGenericASLList(3649)) {
                string = "AVDC_AUDIO_BROWSER_BROWSER_INFO_LIST";
            } else if (genericASLList == ListManager.getGenericASLList(2350)) {
                string = "AVDC_AUDIO_ALBUMBROWSER_COVER_FLOW_INFOLIST";
            }
        }
        return string;
    }

    public static String getPathString(ListEntry[] listEntryArray) {
        String string = "null/empty";
        if (!Util.isNullOrEmpty(listEntryArray)) {
            string = "";
            for (int i2 = 0; i2 < listEntryArray.length; ++i2) {
                String string2 = "null";
                if (listEntryArray[i2] != null) {
                    String string3;
                    String string4 = string3 = listEntryArray[i2].filename != null ? listEntryArray[i2].filename : "null";
                    if (i2 == 0) {
                        switch (MediaBrowserHelper.getBrowseMode(listEntryArray)) {
                            case 0: {
                                string3 = "RAW";
                                break;
                            }
                            case 1: {
                                string3 = "DBL";
                                break;
                            }
                        }
                    }
                    String string5 = new StringBuffer().append(listEntryArray[i2].entryID).append("").toString();
                    String string6 = new StringBuffer().append(listEntryArray[i2].contentType).append("").toString();
                    string2 = new StringBuffer().append(string3).append("[").append(string5).append(",").append(string6).append("]").toString();
                }
                string = new StringBuffer().append(string).append("/").append(string2).toString();
            }
            string = new StringBuffer().append(string).append("/").toString();
        }
        return new StringBuffer().append("\"").append(string).append("\"").toString();
    }

    public static String getReducedPathString(ListEntry[] listEntryArray) {
        String string = "null";
        if (listEntryArray != null) {
            if (listEntryArray.length > 3 && listEntryArray[1] != null && listEntryArray[1].getFilename() != null && listEntryArray[listEntryArray.length - 1] != null && listEntryArray[listEntryArray.length - 1].getFilename() != null) {
                string = "root";
                string = new StringBuffer().append(string).append("/").append(listEntryArray[1].getFilename().trim()).toString();
                string = new StringBuffer().append(string).append("/...").toString();
                string = new StringBuffer().append(string).append("/").append(listEntryArray[listEntryArray.length - 1].getFilename().trim()).toString();
            } else {
                string = MediaBrowserHelper.getPathString(listEntryArray);
            }
        }
        return string;
    }

    public static String getListEntriesStr(ListEntry[] listEntryArray) {
        String string = "null";
        if (listEntryArray != null) {
            string = listEntryArray.length < 1 ? "[size=0 | empty]" : (listEntryArray.length == 1 ? new StringBuffer().append("[size=1 | ").append(MediaBrowserHelper.getListEntryStr(listEntryArray[0])).append(" ]").toString() : new StringBuffer().append("[size=").append(listEntryArray.length).append(" | ").append(listEntryArray[0].getFilename()).append(" .. ").append(listEntryArray[listEntryArray.length - 1].getFilename()).append("]").toString());
        }
        return string;
    }

    public static String getListEntryStr(ListEntry listEntry) {
        String string = "null";
        if (listEntry != null) {
            string = new StringBuffer().append("\"").append(listEntry.getFilename()).append("\"").append(" [id: ").append(listEntry.getEntryID()).append(", contentType: ").append(listEntry.getContentType()).append("]").toString();
        }
        return string;
    }

    public static String getMediaBrowserEntryContainerStr(MediaBrowserEntryContainer mediaBrowserEntryContainer) {
        StringBuilder stringBuilder = new StringBuilder("null");
        if (mediaBrowserEntryContainer != null) {
            if (mediaBrowserEntryContainer.isDisplayTextSet()) {
                stringBuilder.append("\"").append(mediaBrowserEntryContainer.getDisplayText());
            } else {
                stringBuilder.append("\"display text not set!");
            }
            if (mediaBrowserEntryContainer.isEntryIdSet()) {
                stringBuilder.append("\" [id: ").append(mediaBrowserEntryContainer.getEntryId());
            } else {
                stringBuilder.append("\" [id: not set!");
            }
            if (mediaBrowserEntryContainer.isEntryIdSet()) {
                stringBuilder.append(", contentType: ").append(mediaBrowserEntryContainer.getEntryType());
            } else {
                stringBuilder.append(", contentType: not set!");
            }
            if (mediaBrowserEntryContainer.isTrackInfoSet() && mediaBrowserEntryContainer.getTrackInfo().isTitleSet()) {
                stringBuilder.append(", title: ").append(mediaBrowserEntryContainer.getTrackInfo().getTitle());
            } else {
                stringBuilder.append(", title: not set!");
            }
            stringBuilder.append("]");
        }
        return stringBuilder.toString();
    }

    public static String getListEntriesStr(List list) {
        String string = "null";
        if (list != null) {
            string = list.size() < 1 ? "[size=0 | empty]" : (list.size() == 1 ? new StringBuffer().append("[size=1 | ").append(list.get(0)).append(" ]").toString() : new StringBuffer().append("[size=").append(list.size()).append(" | ").append(list.get(0)).append(" .. ").append(list.get(list.size() - 1)).append("]").toString());
        }
        return string;
    }

    public static String getListEntryStr(ExtendedListEntry extendedListEntry) {
        String string = "null";
        if (extendedListEntry != null) {
            string = new StringBuffer().append("\"").append(extendedListEntry.getFilename()).append("\"").append(" [id: ").append(extendedListEntry.getEntryID()).append(", index: ").append(extendedListEntry.listIndex).append("]").toString();
        }
        return string;
    }

    public static String getEntryInfoStr(EntryInfo entryInfo) {
        String string = "null";
        if (entryInfo != null) {
            string = new StringBuffer().append("name:").append(entryInfo.getFilename()).append(" entryId:").append(entryInfo.getEntryID()).toString();
        }
        return string;
    }

    public static String getBrowseModeSwitchingStr(int n) {
        String string = "-";
        switch (n) {
            case 1: {
                string = "NOT_SUPPORTED";
                break;
            }
            case 2: {
                string = "REFRESHING";
                break;
            }
            case 3: {
                string = "AVAILABLE";
                break;
            }
        }
        return string;
    }

    public static String getBrowseModeStr(int n) {
        switch (n) {
            case 0: {
                return "RAW";
            }
            case 1: {
                return "CONTENT";
            }
        }
        return "unknown_mode";
    }

    public static String getClassStr(Object object) {
        String string = object.getClass().getName();
        return string.substring(string.lastIndexOf(".") + 1, string.length());
    }

    public static String getDomainStateStr(int n) {
        String string = "";
        if (n == 0) {
            string = "S_NOT_INIT";
        } else {
            if (Util.isBitSet(1, n)) {
                string = new StringBuffer().append(string).append("|S_NOT_STARTED").toString();
            }
            if (Util.isBitSet(2, n)) {
                string = new StringBuffer().append(string).append("|S_AUDIBLE").toString();
            }
            if (Util.isBitSet(4, n)) {
                string = new StringBuffer().append(string).append("|S_OPERABLE").toString();
            }
            if (Util.isBitSet(8, n)) {
                string = new StringBuffer().append(string).append("|S_FULLY_OPERABLE").toString();
            }
            if (Util.isBitSet(16, n)) {
                string = new StringBuffer().append(string).append("|S_ERROR").toString();
            }
            if (Util.isBitSet(32, n)) {
                string = new StringBuffer().append(string).append("|S_ERROR_INDICATION_UNRECOVERABLE").toString();
            }
            if (Util.isBitSet(64, n)) {
                string = new StringBuffer().append(string).append("|S_ERROR_INDICATION_NOT_AVAILABLE").toString();
            }
            if (Util.isBitSet(256, n)) {
                string = new StringBuffer().append(string).append("|RM_DRIVER").toString();
            }
            if (Util.isBitSet(512, n)) {
                string = new StringBuffer().append(string).append("|RM_MEDIA_SUITE").toString();
            }
            if (Util.isBitSet(1024, n)) {
                string = new StringBuffer().append(string).append("|RM_MEDIA_APP").toString();
            }
            if (Util.isBitSet(4096, n)) {
                string = new StringBuffer().append(string).append("|RM_ABSTRACTION_LAYER").toString();
            }
            if (Util.isBitSet(8192, n)) {
                string = new StringBuffer().append(string).append("|RM_SYSTEM_LAYER").toString();
            }
            if (Util.isBitSet(16384, n)) {
                string = new StringBuffer().append(string).append("|RM_DIAGNOSIS").toString();
            }
            if (Util.isBitSet(0x800000, n)) {
                string = new StringBuffer().append(string).append("|RM_SPEECH_SERVICE").toString();
            }
            if (Util.isBitSet(256, n)) {
                string = new StringBuffer().append(string).append("|RM_RECORDER").toString();
            }
            if (Util.isBitSet(512, n)) {
                string = new StringBuffer().append(string).append("|RM_ALBUMBROWSER").toString();
            }
            if (Util.isBitSet(4096, n)) {
                string = new StringBuffer().append(string).append("|RM_METADATA_SERVICE").toString();
            }
            if (Util.isBitSet(2048, n)) {
                string = new StringBuffer().append(string).append("|RM_RADIOTAGGING_SERVICE").toString();
            }
            if (Util.isBitSet(1, n)) {
                string = new StringBuffer().append(string).append("|RM_DSIRECORDER").toString();
            }
            if (Util.isBitSet(8192, n)) {
                string = new StringBuffer().append(string).append("|RM_DSIBASE").toString();
            }
            if (Util.isBitSet(16384, n)) {
                string = new StringBuffer().append(string).append("|RM_DSIPLAYER_TERMINAL_LEFT").toString();
            }
            if (Util.isBitSet(2, n)) {
                string = new StringBuffer().append(string).append("|RM_DSIBROWSER_CLUSTER_1").toString();
            }
            if (Util.isBitSet(4, n)) {
                string = new StringBuffer().append(string).append("|RM_DSIBROWSER_CLUSTER_2").toString();
            }
            if (Util.isBitSet(8, n)) {
                string = new StringBuffer().append(string).append("|RM_DSIBROWSER_CLUSTER_3").toString();
            }
            if (Util.isBitSet(16, n)) {
                string = new StringBuffer().append(string).append("|RM_DSIBROWSER_CLUSTER_4").toString();
            }
            if (Util.isBitSet(32, n)) {
                string = new StringBuffer().append(string).append("|RM_DSIBROWSER_RECORDER").toString();
            }
        }
        if (string.trim().length() == 0) {
            return "none";
        }
        return string;
    }

    public static String getPlaybackStateStr(int n) {
        String string = "null";
        switch (n) {
            case 0: {
                string = "invalid";
                break;
            }
            case 1: {
                string = "readyToPlay";
                break;
            }
            case 2: {
                string = "notReadyToPlay";
                break;
            }
            case 3: {
                string = "playing";
                break;
            }
            case 4: {
                string = "stopped";
                break;
            }
            case 5: {
                string = "paused";
                break;
            }
            case 6: {
                string = "seekSlowFW";
                break;
            }
            case 7: {
                string = "seekSlowBW";
                break;
            }
            case 8: {
                string = "seekFastFW";
                break;
            }
            case 9: {
                string = "seekFastBW";
                break;
            }
            case 10: {
                string = "playingMenu";
                break;
            }
            case 11: {
                string = "stoppedWithError";
                break;
            }
            case 12: {
                string = "menuSelect";
                break;
            }
        }
        return string;
    }

    public static boolean isFolder(ListEntry listEntry) {
        return listEntry != null && !MediaBrowserHelper.isFile(listEntry);
    }

    public static boolean isFile(ListEntry listEntry) {
        return listEntry != null && (listEntry.getContentType() == 2 || listEntry.getContentType() == 1 || listEntry.getContentType() == 3 || listEntry.getContentType() == 0);
    }

    public static boolean isVideoFile(ListEntry listEntry) {
        return listEntry != null && listEntry.getContentType() == 2;
    }

    public static boolean isAudioFile(ListEntry listEntry) {
        return listEntry != null && listEntry.getContentType() == 1;
    }

    public static boolean isFile(EntryInfo entryInfo) {
        return entryInfo != null && (entryInfo.getContentType() == 2 || entryInfo.getContentType() == 1 || entryInfo.getContentType() == 3 || entryInfo.getContentType() == 0);
    }

    public static boolean isVideoFile(EntryInfo entryInfo) {
        return entryInfo != null && entryInfo.getContentType() == 2;
    }

    public static boolean isAudioFile(EntryInfo entryInfo) {
        return entryInfo != null && entryInfo.getContentType() == 1;
    }

    public static ListEntry getEntryPoint(ListEntry[] listEntryArray) {
        ListEntry listEntry = null;
        if (!Util.isNullOrEmpty(listEntryArray) && listEntryArray.length > 0) {
            listEntry = listEntryArray[0];
            if (listEntryArray.length > 1 && listEntryArray[1].getContentType() != 4 && listEntryArray[1].getContentType() != 5) {
                listEntry = listEntryArray[1];
            }
        }
        return listEntry;
    }

    public static boolean isFolderSpecificSelectionRequired(ListEntry[] listEntryArray) {
        return MediaBrowserHelper.isVideoFolder(listEntryArray) || MediaBrowserHelper.isPlaylistFolder(listEntryArray);
    }

    public static String getSelectionResultStr(int n) {
        String string = "null";
        switch (n) {
            case 0: {
                string = "OK";
                break;
            }
            case 3: {
                string = "NOK";
                break;
            }
            case 1: {
                string = "JUKEBOX_FULL";
                break;
            }
            case 2: {
                string = "LIBRARY_FULL";
                break;
            }
        }
        return string;
    }

    public static int getBrowseMode(ListEntry[] listEntryArray) {
        if (!Util.isNullOrEmpty(listEntryArray) && listEntryArray[0] != null && listEntryArray[0].getFilename() != null) {
            if (listEntryArray[0].getFilename().length() == 0) {
                return 1;
            }
            return 0;
        }
        return -1;
    }

    public static int getBrowseMode(Selection selection) {
        return selection != null ? MediaBrowserHelper.getBrowseMode(selection.getSelectionPath()) : -1;
    }

    public static boolean isRAWFolder(ListEntry[] listEntryArray) {
        return MediaBrowserHelper.getBrowseMode(listEntryArray) == 0;
    }

    public static boolean isDBLFolder(ListEntry[] listEntryArray) {
        return MediaBrowserHelper.getBrowseMode(listEntryArray) == 1;
    }

    public static boolean isDBLRootFolder(ListEntry[] listEntryArray) {
        return listEntryArray != null && listEntryArray.length == 1 && MediaBrowserHelper.getBrowseMode(listEntryArray) == 1;
    }

    public static boolean isDBLPlaylistsFolder(ListEntry[] listEntryArray) {
        return listEntryArray != null && listEntryArray.length == 2 && listEntryArray[1].getContentType() == 6 && MediaBrowserHelper.getBrowseMode(listEntryArray) == 1;
    }

    public static boolean isPlaylistFolder(ListEntry[] listEntryArray) {
        if (listEntryArray != null && listEntryArray.length > 1) {
            int n = listEntryArray[listEntryArray.length - 1].getContentType();
            return n == 5 || n == 6 || n == 10;
        }
        return false;
    }

    public static boolean isDynamicPlaylistFolder(ListEntry[] listEntryArray) {
        if (listEntryArray != null && listEntryArray.length > 1) {
            int n = listEntryArray[listEntryArray.length - 1].getContentType();
            return n == 10;
        }
        return false;
    }

    public static boolean isVideoFolder(ListEntry[] listEntryArray) {
        boolean bl = false;
        if (!Util.isNullOrEmpty(listEntryArray)) {
            bl = listEntryArray[listEntryArray.length - 1].getContentType() == 8;
        }
        return bl;
    }

    public static boolean isPrimaryFolder(ListEntry[] listEntryArray) {
        if (listEntryArray != null && listEntryArray.length == 2) {
            return MediaBrowserHelper.isPrimaryFolder(listEntryArray[listEntryArray.length - 1]);
        }
        return false;
    }

    public static boolean isPrimaryFolder(ListEntry listEntry) {
        boolean bl = false;
        if (listEntry != null) {
            int n = listEntry.getContentType();
            bl = n == 6;
            bl |= n == 13;
            bl |= n == 14;
            bl |= n == 16;
            bl |= n == 15;
            bl |= n == 8;
            bl |= n == 19;
        }
        return bl;
    }

    public static boolean isSameResourceLocator(ResourceLocator resourceLocator, ResourceLocator resourceLocator2) {
        String string;
        String string2 = resourceLocator != null ? resourceLocator.url : null;
        String string3 = string = resourceLocator2 != null ? resourceLocator2.url : null;
        if (string2 == null && string == null) {
            return true;
        }
        if (string2 == null || string == null) {
            return false;
        }
        return string2.equals(string);
    }

    public static String getCoverArtStr(ResourceLocator resourceLocator) {
        return resourceLocator != null ? resourceLocator.getUrl() : "null";
    }

    public static boolean isRootFolder(ListEntry[] listEntryArray) {
        return listEntryArray != null && listEntryArray.length == 1;
    }

    public static ListEntry[] getRootFolder(ListEntry[] listEntryArray) {
        return new ListEntry[]{listEntryArray[0]};
    }

    public static String getContentFilterStr(int n) {
        String string = "";
        if (Util.isBitSet(1, n)) {
            string = new StringBuffer().append(string).append("|AUDIO").toString();
        }
        if (Util.isBitSet(8, n)) {
            string = new StringBuffer().append(string).append("|PICTURE").toString();
        }
        if (Util.isBitSet(4, n)) {
            string = new StringBuffer().append(string).append("|PLAYLIST").toString();
        }
        if (Util.isBitSet(2, n)) {
            string = new StringBuffer().append(string).append("|VIDEO").toString();
        }
        if (string.trim().length() == 0) {
            return "none";
        }
        return string.substring(1);
    }

    public static String getMediaFlagsStr(int n) {
        return MediumState.getMediaFlagsStr(n);
    }

    public static String getInstanceIdStr(MediaBrowser mediaBrowser) {
        return mediaBrowser != null ? MediaBrowserHelper.getInstanceIdStr(mediaBrowser.getInstanceId()) : "null";
    }

    public static String getInstanceIdStr(int n) {
        String string = "";
        switch (n) {
            case 0: {
                string = "M";
                break;
            }
            case 1: {
                string = "C";
                break;
            }
            case 7: {
                string = "R";
                break;
            }
            case 2: {
                string = "S";
                break;
            }
            case 3: {
                string = "B";
                break;
            }
            case 4: {
                string = "H";
                break;
            }
            default: {
                string = new StringBuffer().append("UNKNOWN_ID_").append(n).toString();
            }
        }
        return string;
    }

    public static String getContentTypeStr(int n) {
        switch (n) {
            case 14: {
                return "ALBUM_FOLDER";
            }
            case 13: {
                return "ARTIST_FOLDER";
            }
            case 1: {
                return "AUDIO";
            }
            case 7: {
                return "AUDIO_FOLDER";
            }
            case 18: {
                return "AUDIOBOOK_FOLDER";
            }
            case 17: {
                return "COMPOSER_FOLDER";
            }
            case 10: {
                return "DYNAMIC_PLAYLIST";
            }
            case 20: {
                return "FAVORITE_FOLDER";
            }
            case 4: {
                return "FOLDER";
            }
            case 16: {
                return "GENRE_FOLDER";
            }
            case 3: {
                return "IMAGE";
            }
            case 9: {
                return "IMAGE_FOLDER";
            }
            case 19: {
                return "NOTPLAYABLE_FOLDER";
            }
            case 5: {
                return "PLAYLIST";
            }
            case 6: {
                return "PLAYLIST_FOLDER";
            }
            case 11: {
                return "PODCAST_FOLDER";
            }
            case 12: {
                return "SELECTCONTROL";
            }
            case 15: {
                return "TITLE_FOLDER";
            }
            case 0: {
                return "UNKNOWN";
            }
            case 2: {
                return "VIDEO";
            }
            case 8: {
                return "VIDEO_FOLDER";
            }
        }
        return "unknown";
    }

    public static final void showDebugPopup(String string) {
        ServiceManager.aslPropertyManager.valueChangedString(2401, string);
        ServiceManager.eventDispatcher.createAndSubmitHMIEvent(429);
    }

    public static boolean isJoggerMode(ListEntry[] listEntryArray) {
        if (listEntryArray != null && listEntryArray.length == 2) {
            long l = listEntryArray[1].getEntryID();
            String string = listEntryArray[1].getFilename();
            return l == 0x1000001FFFFL || string != null && string.equals("filterCriteria.nowPlaying");
        }
        return false;
    }

    public static String getCmdBlockingStr(int n) {
        String string = "";
        if (n == 0) {
            string = "NONE";
        } else {
            if (Util.isBitSet(1, n)) {
                string = new StringBuffer().append(string).append("|TIME_PLAY_SEARCH").toString();
            }
            if (Util.isBitSet(2, n)) {
                string = new StringBuffer().append(string).append("|PTT_PLAY_SEARCH").toString();
            }
            if (Util.isBitSet(4, n)) {
                string = new StringBuffer().append(string).append("|TITLE_SEARCH").toString();
            }
            if (Util.isBitSet(8, n)) {
                string = new StringBuffer().append(string).append("|STOP").toString();
            }
            if (Util.isBitSet(16, n)) {
                string = new StringBuffer().append(string).append("|GO_UP").toString();
            }
            if (Util.isBitSet(32, n)) {
                string = new StringBuffer().append(string).append("|TIME_PTT_SEARCH").toString();
            }
            if (Util.isBitSet(64, n)) {
                string = new StringBuffer().append(string).append("|PREV_TOP_PG_SEARCH").toString();
            }
            if (Util.isBitSet(128, n)) {
                string = new StringBuffer().append(string).append("|NEXT_PG_SEARCH").toString();
            }
            if (Util.isBitSet(256, n)) {
                string = new StringBuffer().append(string).append("|FORWARD_SCAN").toString();
            }
            if (Util.isBitSet(512, n)) {
                string = new StringBuffer().append(string).append("|BACKWARD_SCAN").toString();
            }
            if (Util.isBitSet(1024, n)) {
                string = new StringBuffer().append(string).append("|MENU_CALL_TITLE").toString();
            }
            if (Util.isBitSet(2048, n)) {
                string = new StringBuffer().append(string).append("|MENU_CALL_ROOT").toString();
            }
            if (Util.isBitSet(4096, n)) {
                string = new StringBuffer().append(string).append("|MENU_CALL_SUB_PICTURE").toString();
            }
            if (Util.isBitSet(8192, n)) {
                string = new StringBuffer().append(string).append("|MENU_CALL_AUDIO").toString();
            }
            if (Util.isBitSet(16384, n)) {
                string = new StringBuffer().append(string).append("|MENU_CALL_ANGLE").toString();
            }
            if (Util.isBitSet(0x800000, n)) {
                string = new StringBuffer().append(string).append("|MENU_CALL_PTT").toString();
            }
            if (Util.isBitSet(256, n)) {
                string = new StringBuffer().append(string).append("|RESUME").toString();
            }
            if (Util.isBitSet(512, n)) {
                string = new StringBuffer().append(string).append("|BUTTON").toString();
            }
            if (Util.isBitSet(1024, n)) {
                string = new StringBuffer().append(string).append("|STILL_OFF").toString();
            }
            if (Util.isBitSet(2048, n)) {
                string = new StringBuffer().append(string).append("|PAUSE_ON").toString();
            }
            if (Util.isBitSet(4096, n)) {
                string = new StringBuffer().append(string).append("|AUDIO_CHANGE").toString();
            }
            if (Util.isBitSet(8192, n)) {
                string = new StringBuffer().append(string).append("|SUB_PICTURE_CHANGE").toString();
            }
            if (Util.isBitSet(16384, n)) {
                string = new StringBuffer().append(string).append("|ANGLE_CHANGE").toString();
            }
            if (Util.isBitSet(32768, n)) {
                string = new StringBuffer().append(string).append("|KARAOKE_CHANGE").toString();
            }
            if (Util.isBitSet(1, n)) {
                string = new StringBuffer().append(string).append("|VIDEO_CHANGE").toString();
            }
        }
        if (string.trim().length() == 0) {
            return "none";
        }
        return string;
    }

    public static String getCategoryStr(int n) {
        switch (n) {
            case 0: {
                return "ALL";
            }
            case 1: {
                return "PLAYLIST";
            }
            case 2: {
                return "GENRE";
            }
            case 3: {
                return "ARTIST";
            }
            case 4: {
                return "ALBUM";
            }
            case 5: {
                return "TITLE";
            }
            case 6: {
                return "VIDEO";
            }
        }
        return "UNKNOWN";
    }
}

