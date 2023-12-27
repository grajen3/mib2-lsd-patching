/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.playback;

import de.vw.mib.asl.internal.media.browser.BrowserPathData;
import de.vw.mib.asl.internal.media.browser.Selection;
import de.vw.mib.asl.internal.media.playback.PlayMode;
import de.vw.mib.asl.internal.media.sourcehandling.state.MediaCollector;
import org.dsi.ifc.media.ListEntry;

public class DefaultSelectionFactory {
    private static final int DEFAULT_SELECTION_INSTANCE_ID;
    private static final ListEntry RAW_ROOT_ENTRY;
    private static final ListEntry DBL_ROOT_ENTRY;
    private static final ListEntry DBL_ARTIST_FOLDER_ENTRY;
    private static final ListEntry DBL_VIDEO_FOLDER_ENTRY;
    private final ListEntry[] DEFAULT_PATH_DBL_VIDEO = new ListEntry[]{DBL_ROOT_ENTRY, DBL_VIDEO_FOLDER_ENTRY};
    private final ListEntry[] DEFAULT_PATH_DBL_ARTIST = new ListEntry[]{DBL_ROOT_ENTRY, DBL_ARTIST_FOLDER_ENTRY};
    private final ListEntry[] DEFAULT_PATH_RAW_ROOT = new ListEntry[]{RAW_ROOT_ENTRY};

    public Selection createDefaultPlaySelection(PlayMode playMode, MediaCollector mediaCollector, boolean bl) {
        String string = null;
        ListEntry[] listEntryArray = null;
        if (mediaCollector != null) {
            string = mediaCollector.getUniqueMediaID();
            listEntryArray = mediaCollector.supportsContentModeOnly() ? (bl ? this.DEFAULT_PATH_DBL_VIDEO : this.DEFAULT_PATH_DBL_ARTIST) : this.DEFAULT_PATH_RAW_ROOT;
        }
        return new Selection(playMode, 0, string, listEntryArray, true, true, false, 1);
    }

    public void updatePlaceholderPaths(BrowserPathData browserPathData) {
        if (browserPathData != null) {
            ListEntry[] listEntryArray = browserPathData.getDBLPath(8);
            this.DEFAULT_PATH_DBL_VIDEO[0] = listEntryArray[0];
            this.DEFAULT_PATH_DBL_VIDEO[1] = listEntryArray[1];
            listEntryArray = browserPathData.getDBLPath(13);
            this.DEFAULT_PATH_DBL_ARTIST[0] = listEntryArray[0];
            this.DEFAULT_PATH_DBL_ARTIST[1] = listEntryArray[1];
            listEntryArray = browserPathData.getRAWPath();
            this.DEFAULT_PATH_RAW_ROOT[0] = listEntryArray[0];
        }
    }

    public int getInstanceID() {
        return 0;
    }

    static {
        RAW_ROOT_ENTRY = new ListEntry(-1L, "/", "/", 4, -1, -1, null);
        DBL_ROOT_ENTRY = new ListEntry(-1L, "", "", 4, -1, -1, null);
        DBL_ARTIST_FOLDER_ENTRY = new ListEntry(-1L, null, null, 13, -1, -1, null);
        DBL_VIDEO_FOLDER_ENTRY = new ListEntry(-1L, null, null, 8, -1, -1, null);
    }
}

