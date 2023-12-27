/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.mediacontrol.common;

import de.vw.mib.asl.api.mediacontrol.services.MediaControlCallback;
import de.vw.mib.asl.api.mediacontrol.services.browser.MediaControlListEntry;
import de.vw.mib.asl.api.mediacontrol.services.player.MediaControlActiveTrack;
import de.vw.mib.asl.api.mediacontrol.services.player.MediaControlDevice;
import de.vw.mib.asl.internal.mediacontrol.common.Helper$1;
import de.vw.mib.asl.internal.mediacontrol.common.commands.CommandCallback;
import de.vw.mib.asl.internal.mediacontrol.components.player.PlayerStateActiveTrack;
import de.vw.mib.asl.internal.mediacontrol.components.player.PlayerStateDevice;
import de.vw.mib.util.Util;
import org.dsi.ifc.upnp.EntryInfo;
import org.dsi.ifc.upnp.ListEntry;

public class Helper {
    public static CommandCallback getDefaultCommandCallback(MediaControlCallback mediaControlCallback) {
        Helper$1 helper$1 = new Helper$1(mediaControlCallback);
        return helper$1;
    }

    public static MediaControlDevice[] getMediaControlDevices(PlayerStateDevice[] playerStateDeviceArray) {
        MediaControlDevice[] mediaControlDeviceArray = null;
        if (!Util.isNullOrEmpty(playerStateDeviceArray)) {
            mediaControlDeviceArray = new MediaControlDevice[playerStateDeviceArray.length];
            for (int i2 = 0; i2 < playerStateDeviceArray.length; ++i2) {
                mediaControlDeviceArray[i2] = Helper.getMediaControlDevice(playerStateDeviceArray[i2]);
            }
        }
        return mediaControlDeviceArray;
    }

    public static MediaControlDevice getMediaControlDevice(PlayerStateDevice playerStateDevice) {
        MediaControlDevice mediaControlDevice = null;
        if (playerStateDevice != null) {
            mediaControlDevice = new MediaControlDevice();
            mediaControlDevice.deviceID = playerStateDevice.mDeviceId;
            mediaControlDevice.deviceName = playerStateDevice.mDeviceName;
            mediaControlDevice.deviceType = Helper.getMediaControlDeviceType(playerStateDevice.mDeviceType);
            mediaControlDevice.playbackState = Helper.getMediaControlPlaybackState(playerStateDevice.mPlaybackState);
            mediaControlDevice.volume = playerStateDevice.mVolume;
            mediaControlDevice.activeTrack = Helper.getMediaControlActiveTrack(playerStateDevice.mActiveTrack);
        }
        return mediaControlDevice;
    }

    private static MediaControlActiveTrack getMediaControlActiveTrack(PlayerStateActiveTrack playerStateActiveTrack) {
        MediaControlActiveTrack mediaControlActiveTrack = null;
        if (playerStateActiveTrack != null) {
            mediaControlActiveTrack = new MediaControlActiveTrack();
            mediaControlActiveTrack.entryId = playerStateActiveTrack.entryId;
            mediaControlActiveTrack.playPosition = playerStateActiveTrack.timePosition;
            mediaControlActiveTrack.totalPlayTime = playerStateActiveTrack.totalPlayTime;
            EntryInfo entryInfo = playerStateActiveTrack.entryInfo;
            if (entryInfo != null) {
                mediaControlActiveTrack.genre = entryInfo.genre;
                mediaControlActiveTrack.artist = entryInfo.artist;
                mediaControlActiveTrack.album = entryInfo.album;
                mediaControlActiveTrack.title = entryInfo.title;
                mediaControlActiveTrack.filename = entryInfo.filename;
            }
            mediaControlActiveTrack.coverArt = playerStateActiveTrack.coverArt;
        }
        return mediaControlActiveTrack;
    }

    private static int getMediaControlDeviceType(int n) {
        switch (n) {
            case 0: {
                return 0;
            }
            case 1: {
                return 1;
            }
        }
        return 0;
    }

    public static int getMediaControlPlaybackState(int n) {
        switch (n) {
            case 0: {
                return 0;
            }
            case 2: {
                return 2;
            }
            case 1: {
                return 1;
            }
            case 4: {
                return 0;
            }
            case 3: {
                return 3;
            }
        }
        return 0;
    }

    public static MediaControlListEntry[] getMediaControlListEntries(ListEntry[] listEntryArray) {
        MediaControlListEntry[] mediaControlListEntryArray = null;
        if (listEntryArray != null) {
            mediaControlListEntryArray = new MediaControlListEntry[listEntryArray.length];
            for (int i2 = 0; i2 < listEntryArray.length; ++i2) {
                mediaControlListEntryArray[i2] = Helper.getMediaControlListEntry(listEntryArray[i2]);
            }
        }
        return mediaControlListEntryArray;
    }

    public static MediaControlListEntry getMediaControlListEntry(ListEntry listEntry) {
        MediaControlListEntry mediaControlListEntry = null;
        if (listEntry != null) {
            mediaControlListEntry = new MediaControlListEntry();
            mediaControlListEntry.entryId = listEntry.entryID;
            mediaControlListEntry.contentType = Helper.getMediaControlListEntryContentType(listEntry.contentType);
            mediaControlListEntry.title = listEntry.title;
            mediaControlListEntry.filename = listEntry.filename;
            mediaControlListEntry.flags = listEntry.flags;
            mediaControlListEntry.secLength = listEntry.secLength;
        }
        return mediaControlListEntry;
    }

    private static int getMediaControlListEntryContentType(int n) {
        switch (n) {
            case 14: {
                return 14;
            }
            case 13: {
                return 13;
            }
            case 1: {
                return 1;
            }
            case 7: {
                return 7;
            }
            case 18: {
                return 18;
            }
            case 17: {
                return 17;
            }
            case 10: {
                return 10;
            }
            case 20: {
                return 20;
            }
            case 4: {
                return 4;
            }
            case 16: {
                return 16;
            }
            case 3: {
                return 3;
            }
            case 9: {
                return 9;
            }
            case 19: {
                return 19;
            }
            case 5: {
                return 5;
            }
            case 6: {
                return 6;
            }
            case 11: {
                return 11;
            }
            case 12: {
                return 12;
            }
            case 15: {
                return 15;
            }
            case 0: {
                return 0;
            }
            case 2: {
                return 2;
            }
            case 8: {
                return 8;
            }
            case 22: {
                return 22;
            }
            case 21: {
                return 21;
            }
        }
        return 0;
    }

    public static String getContentTypeStr(int n) {
        switch (n) {
            case 14: {
                return "CONTENTTYPE_ALBUM_FOLDER";
            }
            case 13: {
                return "CONTENTTYPE_ARTIST_FOLDER";
            }
            case 1: {
                return "CONTENTTYPE_AUDIO";
            }
            case 7: {
                return "CONTENTTYPE_AUDIO_FOLDER";
            }
            case 18: {
                return "CONTENTTYPE_AUDIOBOOK_FOLDER";
            }
            case 17: {
                return "CONTENTTYPE_COMPOSER_FOLDER";
            }
            case 10: {
                return "CONTENTTYPE_DYNAMIC_PLAYLIST";
            }
            case 20: {
                return "CONTENTTYPE_FAVORITE_FOLDER";
            }
            case 4: {
                return "CONTENTTYPE_FOLDER";
            }
            case 16: {
                return "CONTENTTYPE_GENRE_FOLDER";
            }
            case 3: {
                return "CONTENTTYPE_IMAGE";
            }
            case 9: {
                return "CONTENTTYPE_IMAGE_FOLDER";
            }
            case 19: {
                return "CONTENTTYPE_NOTPLAYABLE_FOLDER";
            }
            case 5: {
                return "CONTENTTYPE_PLAYLIST";
            }
            case 6: {
                return "CONTENTTYPE_PLAYLIST_FOLDER";
            }
            case 11: {
                return "CONTENTTYPE_PODCAST_FOLDER";
            }
            case 12: {
                return "CONTENTTYPE_SELECTCONTROL";
            }
            case 15: {
                return "CONTENTTYPE_TITLE_FOLDER";
            }
            case 0: {
                return "CONTENTTYPE_UNKNOWN";
            }
            case 2: {
                return "CONTENTTYPE_VIDEO";
            }
            case 8: {
                return "CONTENTTYPE_VIDEO_FOLDER";
            }
            case 22: {
                return "CONTENTTYPE_DEVICE";
            }
            case 21: {
                return "CONTENTTYPE_SHARED_AUDIO_QUEUE";
            }
        }
        return "CONTENTTYPE_UNKNOWN";
    }

    public static String getListEntriesStr(ListEntry[] listEntryArray) {
        String string = "null";
        if (listEntryArray != null) {
            string = listEntryArray.length < 1 ? "[size=0 | empty]" : (listEntryArray.length == 1 ? new StringBuffer().append("[size=1 | ").append(Helper.getListEntryStr(listEntryArray[0])).append(" ]").toString() : new StringBuffer().append("[size=").append(listEntryArray.length).append(" | ").append(listEntryArray[0].getFilename()).append(" .. ").append(listEntryArray[listEntryArray.length - 1].getFilename()).append("]").toString());
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

    public static boolean isSameFolder(ListEntry[] listEntryArray, ListEntry[] listEntryArray2) {
        if (Util.isNullOrEmpty(listEntryArray) || Util.isNullOrEmpty(listEntryArray2)) {
            return Util.isNullOrEmpty(listEntryArray) && Util.isNullOrEmpty(listEntryArray2);
        }
        if (listEntryArray.length != listEntryArray2.length) {
            return false;
        }
        for (int i2 = 0; i2 < listEntryArray.length; ++i2) {
            if (Helper.isSameListEntry(listEntryArray[i2], listEntryArray2[i2])) continue;
            return false;
        }
        return true;
    }

    public static boolean isSameListEntry(ListEntry listEntry, ListEntry listEntry2) {
        if (listEntry == null || listEntry2 == null) {
            return listEntry == null && listEntry2 == null;
        }
        return Helper.isSameString(listEntry.getEntryID(), listEntry2.getEntryID()) && listEntry.getContentType() == listEntry2.getContentType();
    }

    public static boolean isSameString(String string, String string2) {
        if (string == null || string2 == null) {
            return string == null && string2 == null;
        }
        return string.equals(string2);
    }

    public static int getMediaControlListState(int n) {
        switch (n) {
            case -1: {
                return 0;
            }
            case 0: {
                return 1;
            }
            case 1: {
                return 2;
            }
            case 2: {
                return 3;
            }
        }
        return 0;
    }
}

