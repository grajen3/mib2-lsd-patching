/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.browser.headunit;

import de.vw.mib.asl.internal.media.browser.AbstractMediaBrowser;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.util.Util;
import org.dsi.ifc.media.ListEntry;

public class MediaRecorderBrowser
extends AbstractMediaBrowser {
    public MediaRecorderBrowser(GenericEvents genericEvents, String string, int n) {
        super(genericEvents, string, n);
    }

    @Override
    public int getDefaultTargetId() {
        return 447681280;
    }

    protected ListEntry[] getMaximumSelectionPath(boolean bl) {
        Object[] objectArray = this.getBrowseFolder();
        ListEntry[] listEntryArray = null;
        if (!Util.isNullOrEmpty(objectArray)) {
            listEntryArray = new ListEntry[]{objectArray[0]};
        }
        return listEntryArray;
    }

    @Override
    public int getComponentId() {
        return 1024;
    }
}

