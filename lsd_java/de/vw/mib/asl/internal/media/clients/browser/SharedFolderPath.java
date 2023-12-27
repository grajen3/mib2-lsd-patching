/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.clients.browser;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.media.browser.MediaBrowserState;
import de.vw.mib.asl.internal.media.sourcehandling.state.MediaCollector;
import de.vw.mib.util.Util;
import generated.de.vw.mib.asl.internal.ListManager;
import org.dsi.ifc.media.ListEntry;

public class SharedFolderPath {
    private static final String MOST_PLAYED;
    private static final String LAST_PLAYED;
    private static final String RATED_0;
    private static final String RATED_1;
    private static final String RATED_2;
    private static final String RATED_3;
    private static final String RATED_4;
    private static final String RATED_5;
    private static GenericASLList DISPLAY_LEVEL_LIST;
    private final Integer[] DISPLAY_LEVELS = new Integer[6];
    private static final Integer DISPLAYED_LEVEL_NONE;
    private static final Integer DISPLAYED_LEVEL_ROOT;
    private static final Integer DISPLAYED_LEVEL_ARTISTS;
    private static final Integer DISPLAYED_LEVEL_ALBUMS;
    private static final Integer DISPLAYED_LEVEL_GENRES;
    private static final Integer DISPLAYED_LEVEL_PLAYLIST;
    private static final Integer DISPLAYED_LEVEL_VIDEOS;
    private static final Integer DISPLAYED_LEVEL_NOT_PLAYABLE;
    private static final Integer DISPLAYED_LEVEL_DYN_LAST_PLAYED;
    private static final Integer DISPLAYED_LEVEL_DYN_MOST_PLAYED;
    private static final Integer DISPLAYED_LEVEL_DYN_RATED_0;
    private static final Integer DISPLAYED_LEVEL_DYN_RATED_1;
    private static final Integer DISPLAYED_LEVEL_DYN_RATED_2;
    private static final Integer DISPLAYED_LEVEL_DYN_RATED_3;
    private static final Integer DISPLAYED_LEVEL_DYN_RATED_4;
    private static final Integer DISPLAYED_LEVEL_DYN_RATED_5;
    private static final Integer DISPLAYED_LEVEL_SONGS;
    private static final Integer DISPLAYED_LEVEL_PLAYLISTS;
    private static final Integer DISPLAYED_LEVEL_SEARCH;
    private boolean mSearchEnabled = false;

    public void reset() {
        ServiceManager.aslPropertyManager.valueChangedInteger(76, 0);
        ServiceManager.aslPropertyManager.valueChangedString(77, "");
        boolean bl = false;
        ServiceManager.aslPropertyManager.valueChangedInteger(78, 0);
        this.DISPLAY_LEVELS[0] = DISPLAYED_LEVEL_ROOT;
        this.DISPLAY_LEVELS[1] = DISPLAYED_LEVEL_NONE;
        this.DISPLAY_LEVELS[2] = DISPLAYED_LEVEL_NONE;
        this.DISPLAY_LEVELS[3] = DISPLAYED_LEVEL_NONE;
        this.DISPLAY_LEVELS[4] = DISPLAYED_LEVEL_NONE;
        this.DISPLAY_LEVELS[5] = DISPLAYED_LEVEL_NONE;
        DISPLAY_LEVEL_LIST.updateList(this.DISPLAY_LEVELS);
    }

    public void update(MediaBrowserState mediaBrowserState) {
        MediaCollector mediaCollector = null;
        ListEntry[] listEntryArray = null;
        int n = -1;
        if (mediaBrowserState != null) {
            mediaCollector = mediaBrowserState.getBrowseMedia();
            listEntryArray = mediaBrowserState.getBrowseFolder();
            n = mediaBrowserState.getBrowseMode();
        }
        if (mediaCollector == null || Util.isNullOrEmpty(listEntryArray) || n == -1) {
            this.reset();
        }
        String string = "";
        int n2 = 0;
        if (listEntryArray != null && listEntryArray.length >= 2) {
            string = listEntryArray[listEntryArray.length - 1].getFilename();
            n2 = listEntryArray.length - 1;
        } else {
            string = mediaCollector != null && mediaCollector.getName() != null && !mediaCollector.getName().startsWith("medium.") ? mediaCollector.getName() : "";
            n2 = 0;
        }
        ServiceManager.aslPropertyManager.valueChangedInteger(76, this.mSearchEnabled ? n2 + 1 : n2);
        ServiceManager.aslPropertyManager.valueChangedString(77, string);
        switch (n) {
            case 0: {
                this.updateDisplayLevelsRaw(listEntryArray);
                break;
            }
            case 1: {
                this.updateDisplayLevelsContent(listEntryArray);
                break;
            }
        }
    }

    private void updateDisplayLevelsRaw(ListEntry[] listEntryArray) {
        int n = 0;
        if (!Util.isNullOrEmpty(listEntryArray)) {
            switch (listEntryArray[listEntryArray.length - 1].getContentType()) {
                case 4: {
                    n = 1;
                    break;
                }
                case 5: {
                    n = 2;
                    break;
                }
            }
        }
        ServiceManager.aslPropertyManager.valueChangedInteger(78, n);
    }

    private void updateDisplayLevelsContent(ListEntry[] listEntryArray) {
        if (!Util.isNullOrEmpty(listEntryArray)) {
            Integer[] integerArray = this.DISPLAY_LEVELS;
            integerArray[0] = DISPLAYED_LEVEL_ROOT;
            integerArray[1] = DISPLAYED_LEVEL_NONE;
            integerArray[2] = DISPLAYED_LEVEL_NONE;
            integerArray[3] = DISPLAYED_LEVEL_NONE;
            integerArray[4] = DISPLAYED_LEVEL_NONE;
            integerArray[5] = DISPLAYED_LEVEL_NONE;
            block0 : switch (listEntryArray.length) {
                case 2: {
                    switch (listEntryArray[1].getContentType()) {
                        case 16: {
                            integerArray[1] = DISPLAYED_LEVEL_GENRES;
                            break block0;
                        }
                        case 13: {
                            integerArray[1] = DISPLAYED_LEVEL_ARTISTS;
                            break block0;
                        }
                        case 14: {
                            integerArray[1] = DISPLAYED_LEVEL_ALBUMS;
                            break block0;
                        }
                        case 15: {
                            integerArray[1] = DISPLAYED_LEVEL_SONGS;
                            break block0;
                        }
                        case 6: {
                            integerArray[1] = DISPLAYED_LEVEL_PLAYLISTS;
                            break block0;
                        }
                        case 8: {
                            integerArray[1] = DISPLAYED_LEVEL_VIDEOS;
                            break block0;
                        }
                        case 19: {
                            integerArray[1] = DISPLAYED_LEVEL_NOT_PLAYABLE;
                            break block0;
                        }
                    }
                    break;
                }
                case 3: {
                    switch (listEntryArray[1].getContentType()) {
                        case 14: {
                            integerArray[1] = DISPLAYED_LEVEL_ALBUMS;
                            integerArray[2] = DISPLAYED_LEVEL_SONGS;
                            break;
                        }
                        case 13: {
                            integerArray[1] = DISPLAYED_LEVEL_ARTISTS;
                            integerArray[2] = DISPLAYED_LEVEL_ALBUMS;
                            break;
                        }
                        case 16: {
                            integerArray[1] = DISPLAYED_LEVEL_GENRES;
                            integerArray[2] = DISPLAYED_LEVEL_ARTISTS;
                            break;
                        }
                        case 6: {
                            integerArray[1] = DISPLAYED_LEVEL_PLAYLISTS;
                            ListEntry listEntry = listEntryArray[listEntryArray.length - 1];
                            if (listEntry.getContentType() == 10) {
                                String string = listEntry.getFilename();
                                if (string.equals("filterCriteria.dynPlaylistMostPlayed")) {
                                    integerArray[2] = DISPLAYED_LEVEL_DYN_MOST_PLAYED;
                                    break;
                                }
                                if (string.equals("filterCriteria.dynPlaylistLastPlayed")) {
                                    integerArray[2] = DISPLAYED_LEVEL_DYN_LAST_PLAYED;
                                    break;
                                }
                                if (string.equals("filterCriteria.dynPlaylistStars0")) {
                                    integerArray[2] = DISPLAYED_LEVEL_DYN_RATED_0;
                                    break;
                                }
                                if (string.equals("filterCriteria.dynPlaylistStars1")) {
                                    integerArray[2] = DISPLAYED_LEVEL_DYN_RATED_1;
                                    break;
                                }
                                if (string.equals("filterCriteria.dynPlaylistStars2")) {
                                    integerArray[2] = DISPLAYED_LEVEL_DYN_RATED_2;
                                    break;
                                }
                                if (string.equals("filterCriteria.dynPlaylistStars3")) {
                                    integerArray[2] = DISPLAYED_LEVEL_DYN_RATED_3;
                                    break;
                                }
                                if (string.equals("filterCriteria.dynPlaylistStars4")) {
                                    integerArray[2] = DISPLAYED_LEVEL_DYN_RATED_4;
                                    break;
                                }
                                if (!string.equals("filterCriteria.dynPlaylistStars5")) break block0;
                                integerArray[2] = DISPLAYED_LEVEL_DYN_RATED_5;
                                break;
                            }
                            integerArray[2] = DISPLAYED_LEVEL_PLAYLIST;
                            break;
                        }
                    }
                    break;
                }
                case 4: {
                    switch (listEntryArray[1].getContentType()) {
                        case 13: {
                            integerArray[1] = DISPLAYED_LEVEL_ARTISTS;
                            integerArray[2] = DISPLAYED_LEVEL_ALBUMS;
                            integerArray[3] = DISPLAYED_LEVEL_SONGS;
                            break block0;
                        }
                        case 16: {
                            integerArray[1] = DISPLAYED_LEVEL_GENRES;
                            integerArray[2] = DISPLAYED_LEVEL_ARTISTS;
                            integerArray[3] = DISPLAYED_LEVEL_ALBUMS;
                            break block0;
                        }
                    }
                    break;
                }
                case 5: {
                    integerArray[1] = DISPLAYED_LEVEL_GENRES;
                    integerArray[2] = DISPLAYED_LEVEL_ARTISTS;
                    integerArray[3] = DISPLAYED_LEVEL_ALBUMS;
                    integerArray[4] = DISPLAYED_LEVEL_SONGS;
                    break;
                }
            }
            this.updateFolderList(integerArray, this.mSearchEnabled);
        }
    }

    public void setSearchEnabled(boolean bl) {
        this.mSearchEnabled = bl;
    }

    private void updateFolderList(Integer[] integerArray, boolean bl) {
        if (bl) {
            if (this.DISPLAY_LEVELS[2] != DISPLAYED_LEVEL_SEARCH) {
                this.DISPLAY_LEVELS[5] = this.DISPLAY_LEVELS[4];
                this.DISPLAY_LEVELS[4] = this.DISPLAY_LEVELS[3];
                this.DISPLAY_LEVELS[3] = this.DISPLAY_LEVELS[2];
                this.DISPLAY_LEVELS[2] = DISPLAYED_LEVEL_SEARCH;
            }
        } else if (this.DISPLAY_LEVELS[2] == DISPLAYED_LEVEL_SEARCH) {
            this.DISPLAY_LEVELS[2] = this.DISPLAY_LEVELS[3];
            this.DISPLAY_LEVELS[3] = this.DISPLAY_LEVELS[4];
            this.DISPLAY_LEVELS[4] = this.DISPLAY_LEVELS[5];
            this.DISPLAY_LEVELS[5] = DISPLAYED_LEVEL_NONE;
        }
        DISPLAY_LEVEL_LIST.updateList(integerArray);
    }

    static {
        DISPLAY_LEVEL_LIST = ListManager.getGenericASLList(84);
        DISPLAYED_LEVEL_NONE = new Integer(-1);
        DISPLAYED_LEVEL_ROOT = new Integer(0);
        DISPLAYED_LEVEL_ARTISTS = new Integer(1);
        DISPLAYED_LEVEL_ALBUMS = new Integer(2);
        DISPLAYED_LEVEL_GENRES = new Integer(3);
        DISPLAYED_LEVEL_PLAYLIST = new Integer(5);
        DISPLAYED_LEVEL_VIDEOS = new Integer(7);
        DISPLAYED_LEVEL_NOT_PLAYABLE = new Integer(16);
        DISPLAYED_LEVEL_DYN_LAST_PLAYED = new Integer(8);
        DISPLAYED_LEVEL_DYN_MOST_PLAYED = new Integer(9);
        DISPLAYED_LEVEL_DYN_RATED_0 = new Integer(10);
        DISPLAYED_LEVEL_DYN_RATED_1 = new Integer(11);
        DISPLAYED_LEVEL_DYN_RATED_2 = new Integer(12);
        DISPLAYED_LEVEL_DYN_RATED_3 = new Integer(13);
        DISPLAYED_LEVEL_DYN_RATED_4 = new Integer(14);
        DISPLAYED_LEVEL_DYN_RATED_5 = new Integer(15);
        DISPLAYED_LEVEL_SONGS = new Integer(16);
        DISPLAYED_LEVEL_PLAYLISTS = new Integer(17);
        DISPLAYED_LEVEL_SEARCH = new Integer(18);
    }
}

