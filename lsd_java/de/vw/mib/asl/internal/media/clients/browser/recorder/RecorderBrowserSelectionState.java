/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.clients.browser.recorder;

import de.vw.mib.asl.ASLPropertyManager;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.media.browser.MediaBrowserState;
import de.vw.mib.asl.internal.media.browser.Selection;
import de.vw.mib.util.Util;
import org.dsi.ifc.media.ListEntry;

public class RecorderBrowserSelectionState {
    protected static final ASLPropertyManager DATA_POOL = ServiceManager.aslPropertyManager;

    public void onFolderPathChanged(MediaBrowserState mediaBrowserState) {
        ListEntry[] listEntryArray = mediaBrowserState != null ? mediaBrowserState.getBrowseFolder() : null;
        boolean bl = false;
        boolean bl2 = false;
        if (listEntryArray != null && listEntryArray.length != 0) {
            int n = listEntryArray[listEntryArray.length - 1].getFlags();
            bl = Util.isBitSet(32, n);
            bl2 = !Util.isAnyBitSet(96, n);
        }
        DATA_POOL.valueChangedBoolean(2555, bl);
        DATA_POOL.valueChangedBoolean(2584, bl2);
    }

    public void onSelectionChanged(MediaBrowserState mediaBrowserState) {
        Selection selection = mediaBrowserState != null ? mediaBrowserState.getSelection() : null;
        boolean bl = false;
        boolean bl2 = false;
        if (selection != null) {
            bl = selection.getSelectionState() == 1;
            bl2 = selection.getSelectionState() == 0 || selection.getEntriesSelected() == 0L;
        }
        DATA_POOL.valueChangedBoolean(2555, bl);
        DATA_POOL.valueChangedBoolean(2584, bl2);
    }
}

