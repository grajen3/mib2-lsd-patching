/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.mediacontrol.adapter.views.browser;

import de.vw.mib.asl.api.mediacontrol.services.MediaControlAPI;
import de.vw.mib.asl.api.mediacontrol.services.browser.MediaControlListEntry;
import de.vw.mib.asl.api.mediacontrol.services.browser.MediaControlListenerFolderPath;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.util.Util;
import generated.de.vw.mib.asl.internal.ListManager;

public class TitleBar
implements MediaControlListenerFolderPath {
    final MediaControlAPI mMediaControlAPI;
    private static GenericASLList DISPLAYED_FOLDER_PATH_LIST = ListManager.getGenericASLList(-987736320);
    private final Integer[] DISPLAY_LEVELS = new Integer[6];
    private static final Integer LEVEL_DEFAULT = new Integer(-1);
    private static final Integer LEVEL_UNKNOWN = new Integer(0);
    private static final Integer LEVEL_ROOT = new Integer(23);
    private static final Integer LEVEL_SHARED_QUEUE = new Integer(21);
    private static final Integer LEVEL_DEVICE = new Integer(22);
    private static final Integer LEVEL_UNKNOWN_GENRE_FOLDER = new Integer(30);
    private static final Integer LEVEL_GENRE_FOLDER = new Integer(16);
    private static final Integer LEVEL_ARTIST_FOLDER = new Integer(13);
    private static final Integer LEVEL_UNKNOWN_ARTIST_FOLDER = new Integer(26);
    private static final Integer LEVEL_ALBUM_FOLDER = new Integer(14);
    private static final Integer LEVEL_UNKNOWN_ALBUM_FOLDER = new Integer(28);
    private static final Integer LEVEL_PLAYLIST_FOLDER = new Integer(6);
    private static final Integer LEVEL_VIDEO_FOLDER = new Integer(8);
    private static final Integer LEVEL_TITLE_FOLDER = new Integer(7);
    private static final Integer LEVEL_PLAYLIST = new Integer(5);
    private static final Integer LEVEL_GENRE = new Integer(31);
    private static final Integer LEVEL_ARTIST = new Integer(27);
    private static final Integer LEVEL_ALBUM = new Integer(29);
    private static final Integer LEVEL_FOLDER = new Integer(4);

    public TitleBar(MediaControlAPI mediaControlAPI) {
        this.mMediaControlAPI = mediaControlAPI;
        mediaControlAPI.getBrowserService().addFolderPathListener(this);
    }

    @Override
    public void updateFolderPath(MediaControlListEntry[] mediaControlListEntryArray) {
        String string = "";
        int n = 0;
        if (!Util.isNullOrEmpty(mediaControlListEntryArray)) {
            string = mediaControlListEntryArray[mediaControlListEntryArray.length - 1].getTitle();
            n = mediaControlListEntryArray.length - 1;
        }
        ServiceManager.aslPropertyManager.valueChangedString(-1155508480, string);
        ServiceManager.aslPropertyManager.valueChangedInteger(-1172285696, n);
        this.updateDisplayLevelTypes(mediaControlListEntryArray);
    }

    private void updateDisplayLevelTypes(MediaControlListEntry[] mediaControlListEntryArray) {
        Integer[] integerArray = this.DISPLAY_LEVELS;
        integerArray[0] = LEVEL_DEFAULT;
        integerArray[1] = LEVEL_DEFAULT;
        integerArray[2] = LEVEL_DEFAULT;
        integerArray[3] = LEVEL_DEFAULT;
        integerArray[4] = LEVEL_DEFAULT;
        integerArray[5] = LEVEL_DEFAULT;
        if (!Util.isNullOrEmpty(mediaControlListEntryArray)) {
            block11: for (int i2 = 0; i2 < mediaControlListEntryArray.length; ++i2) {
                if (i2 == 0) {
                    integerArray[i2] = LEVEL_ROOT;
                    continue;
                }
                if (i2 == 1) {
                    if (mediaControlListEntryArray[i2].getContentType() == 21) {
                        integerArray[i2] = LEVEL_SHARED_QUEUE;
                        continue;
                    }
                    integerArray[i2] = LEVEL_DEVICE;
                    continue;
                }
                String string = mediaControlListEntryArray[i2].title;
                if (string != null) {
                    if (string.equals("filterCriteria.unknownGenre") || string.equals("filterCriteria.unknownGenres")) {
                        integerArray[i2] = LEVEL_UNKNOWN_GENRE_FOLDER;
                    } else if (string.equals("filterCriteria.unknownArtist") || string.equals("filterCriteria.unknownArtists")) {
                        integerArray[i2] = LEVEL_UNKNOWN_ARTIST_FOLDER;
                    } else if (string.equals("filterCriteria.unknownAlbum") || string.equals("filterCriteria.unknownAlbums")) {
                        integerArray[i2] = LEVEL_UNKNOWN_ALBUM_FOLDER;
                    }
                }
                if (integerArray[i2] != LEVEL_DEFAULT) continue;
                switch (mediaControlListEntryArray[i2].contentType) {
                    case 6: {
                        integerArray[i2] = LEVEL_PLAYLIST_FOLDER;
                        continue block11;
                    }
                    case 16: {
                        if (i2 == 2) {
                            integerArray[i2] = LEVEL_GENRE_FOLDER;
                            continue block11;
                        }
                        integerArray[i2] = LEVEL_GENRE;
                        continue block11;
                    }
                    case 13: {
                        if (i2 == 2) {
                            integerArray[i2] = LEVEL_ARTIST_FOLDER;
                            continue block11;
                        }
                        integerArray[i2] = LEVEL_ARTIST;
                        continue block11;
                    }
                    case 14: {
                        if (i2 == 2) {
                            integerArray[i2] = LEVEL_ALBUM_FOLDER;
                            continue block11;
                        }
                        integerArray[i2] = LEVEL_ALBUM;
                        continue block11;
                    }
                    case 8: {
                        integerArray[i2] = LEVEL_VIDEO_FOLDER;
                        continue block11;
                    }
                    case 15: {
                        integerArray[i2] = LEVEL_TITLE_FOLDER;
                        continue block11;
                    }
                    case 5: {
                        integerArray[i2] = LEVEL_PLAYLIST;
                        continue block11;
                    }
                    case 4: {
                        integerArray[i2] = LEVEL_FOLDER;
                        continue block11;
                    }
                    case 0: {
                        integerArray[i2] = LEVEL_UNKNOWN;
                        continue block11;
                    }
                    default: {
                        integerArray[i2] = LEVEL_DEFAULT;
                    }
                }
            }
        }
        DISPLAYED_FOLDER_PATH_LIST.updateList(this.DISPLAY_LEVELS);
    }
}

