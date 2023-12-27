/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.browser;

import de.vw.mib.util.Util;
import org.dsi.ifc.media.ListEntry;

public class BrowserPathData {
    private static final ListEntry RAW_ROOT_ENTRY = new ListEntry(-1L, "/", "/", 4, -1, -1, null);
    private static final ListEntry DBL_ROOT_ENTRY = new ListEntry(-1L, "", "", 4, -1, -1, null);
    private static final ListEntry DBL_PLAYLIST_FOLDER_ENTRY = new ListEntry(-1L, null, null, 6, -1, -1, null);
    private static final ListEntry DBL_ARTIST_FOLDER_ENTRY = new ListEntry(-1L, null, null, 13, -1, -1, null);
    private static final ListEntry DBL_ALBUM_FOLDER_ENTRY = new ListEntry(-1L, null, null, 14, -1, -1, null);
    private static final ListEntry DBL_GENRE_FOLDER_ENTRY = new ListEntry(-1L, null, null, 16, -1, -1, null);
    private static final ListEntry DBL_TITLE_FOLDER_ENTRY = new ListEntry(-1L, null, null, 15, -1, -1, null);
    private static final ListEntry DBL_VIDEO_FOLDER_ENTRY = new ListEntry(-1L, null, null, 8, -1, -1, null);
    private final ListEntry[] DEFAULT_PATH_DBL_PLAYLIST = new ListEntry[]{DBL_ROOT_ENTRY, DBL_PLAYLIST_FOLDER_ENTRY};
    private final ListEntry[] DEFAULT_PATH_DBL_ARTIST = new ListEntry[]{DBL_ROOT_ENTRY, DBL_ARTIST_FOLDER_ENTRY};
    private final ListEntry[] DEFAULT_PATH_DBL_ALBUM = new ListEntry[]{DBL_ROOT_ENTRY, DBL_ALBUM_FOLDER_ENTRY};
    private final ListEntry[] DEFAULT_PATH_DBL_GENRE = new ListEntry[]{DBL_ROOT_ENTRY, DBL_GENRE_FOLDER_ENTRY};
    private final ListEntry[] DEFAULT_PATH_DBL_TITLE = new ListEntry[]{DBL_ROOT_ENTRY, DBL_TITLE_FOLDER_ENTRY};
    private final ListEntry[] DEFAULT_PATH_DBL_VIDEO = new ListEntry[]{DBL_ROOT_ENTRY, DBL_VIDEO_FOLDER_ENTRY};
    private static final ListEntry[] DEFAULT_PATH_RAW_ROOT = new ListEntry[]{RAW_ROOT_ENTRY};

    protected void updateDblPathData(ListEntry listEntry, ListEntry[] listEntryArray) {
        if (!Util.isNullOrEmpty(listEntryArray) && listEntry != null) {
            block8: for (int i2 = 0; i2 < listEntryArray.length; ++i2) {
                switch (listEntryArray[i2].getContentType()) {
                    case 6: {
                        this.DEFAULT_PATH_DBL_PLAYLIST[0] = listEntry;
                        this.DEFAULT_PATH_DBL_PLAYLIST[1] = listEntryArray[i2];
                        continue block8;
                    }
                    case 13: {
                        this.DEFAULT_PATH_DBL_ARTIST[0] = listEntry;
                        this.DEFAULT_PATH_DBL_ARTIST[1] = listEntryArray[i2];
                        continue block8;
                    }
                    case 14: {
                        this.DEFAULT_PATH_DBL_ALBUM[0] = listEntry;
                        this.DEFAULT_PATH_DBL_ALBUM[1] = listEntryArray[i2];
                        continue block8;
                    }
                    case 16: {
                        this.DEFAULT_PATH_DBL_GENRE[0] = listEntry;
                        this.DEFAULT_PATH_DBL_GENRE[1] = listEntryArray[i2];
                        continue block8;
                    }
                    case 15: {
                        this.DEFAULT_PATH_DBL_TITLE[0] = listEntry;
                        this.DEFAULT_PATH_DBL_TITLE[1] = listEntryArray[i2];
                        continue block8;
                    }
                    case 8: {
                        this.DEFAULT_PATH_DBL_VIDEO[0] = listEntry;
                        this.DEFAULT_PATH_DBL_VIDEO[1] = listEntryArray[i2];
                        continue block8;
                    }
                }
            }
        }
    }

    protected void updateRawPathData(ListEntry listEntry) {
        BrowserPathData.DEFAULT_PATH_RAW_ROOT[0] = listEntry;
    }

    public ListEntry[] getDBLPath(int n) {
        switch (n) {
            case 6: {
                return this.DEFAULT_PATH_DBL_PLAYLIST;
            }
            case 13: {
                return this.DEFAULT_PATH_DBL_ARTIST;
            }
            case 14: {
                return this.DEFAULT_PATH_DBL_ALBUM;
            }
            case 16: {
                return this.DEFAULT_PATH_DBL_GENRE;
            }
            case 15: {
                return this.DEFAULT_PATH_DBL_TITLE;
            }
            case 8: {
                return this.DEFAULT_PATH_DBL_VIDEO;
            }
        }
        return null;
    }

    public ListEntry[] getRAWPath() {
        return DEFAULT_PATH_RAW_ROOT;
    }

    protected void reset() {
        this.DEFAULT_PATH_DBL_PLAYLIST[0] = DBL_ROOT_ENTRY;
        this.DEFAULT_PATH_DBL_PLAYLIST[1] = DBL_PLAYLIST_FOLDER_ENTRY;
        this.DEFAULT_PATH_DBL_ARTIST[0] = DBL_ROOT_ENTRY;
        this.DEFAULT_PATH_DBL_ARTIST[1] = DBL_ARTIST_FOLDER_ENTRY;
        this.DEFAULT_PATH_DBL_ALBUM[0] = DBL_ROOT_ENTRY;
        this.DEFAULT_PATH_DBL_ALBUM[1] = DBL_ALBUM_FOLDER_ENTRY;
        this.DEFAULT_PATH_DBL_GENRE[0] = DBL_ROOT_ENTRY;
        this.DEFAULT_PATH_DBL_GENRE[1] = DBL_GENRE_FOLDER_ENTRY;
        this.DEFAULT_PATH_DBL_TITLE[0] = DBL_ROOT_ENTRY;
        this.DEFAULT_PATH_DBL_TITLE[1] = DBL_TITLE_FOLDER_ENTRY;
        this.DEFAULT_PATH_DBL_VIDEO[0] = DBL_ROOT_ENTRY;
        this.DEFAULT_PATH_DBL_VIDEO[1] = DBL_VIDEO_FOLDER_ENTRY;
    }

    public void replaceDummies(ListEntry[] listEntryArray) {
        if (this.containsDummies(listEntryArray)) {
            if (listEntryArray[0].filename.equals(BrowserPathData.RAW_ROOT_ENTRY.filename)) {
                listEntryArray[0] = DEFAULT_PATH_RAW_ROOT[0];
            } else if (listEntryArray[0].filename.equals(BrowserPathData.DBL_ROOT_ENTRY.filename)) {
                listEntryArray[0] = this.DEFAULT_PATH_DBL_ARTIST[0];
                if (listEntryArray.length >= 2 && listEntryArray[1].entryID == -1L) {
                    switch (listEntryArray[1].getContentType()) {
                        case 6: {
                            listEntryArray[1] = this.DEFAULT_PATH_DBL_PLAYLIST[1];
                            break;
                        }
                        case 13: {
                            listEntryArray[1] = this.DEFAULT_PATH_DBL_ARTIST[1];
                            break;
                        }
                        case 14: {
                            listEntryArray[1] = this.DEFAULT_PATH_DBL_ALBUM[1];
                            break;
                        }
                        case 16: {
                            listEntryArray[1] = this.DEFAULT_PATH_DBL_GENRE[1];
                            break;
                        }
                        case 15: {
                            listEntryArray[1] = this.DEFAULT_PATH_DBL_TITLE[1];
                            break;
                        }
                        case 8: {
                            listEntryArray[1] = this.DEFAULT_PATH_DBL_VIDEO[1];
                            break;
                        }
                    }
                }
            }
        }
    }

    public boolean containsDummies(ListEntry[] listEntryArray) {
        return !Util.isNullOrEmpty(listEntryArray) && listEntryArray[0].entryID == -1L;
    }
}

