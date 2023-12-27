/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.browser.coverflow;

import de.vw.mib.asl.internal.media.browser.AbstractMediaBrowser;
import de.vw.mib.asl.internal.media.playback.MediaPlayer;
import de.vw.mib.genericevents.GenericEvents;
import org.dsi.ifc.media.ListEntry;

public class MediaCoverBrowser
extends AbstractMediaBrowser {
    public MediaCoverBrowser(GenericEvents genericEvents, String string, int n) {
        super(genericEvents, string, n);
    }

    @Override
    public int getDefaultTargetId() {
        return 430904064;
    }

    @Override
    public int getDefaultContentFilterMask() {
        return 1;
    }

    protected ListEntry[] getMaximumSelectionPath(boolean bl) {
        return this.getStandardDblPath(14);
    }

    @Override
    public int getMatchingBrowseMode(MediaPlayer mediaPlayer) {
        return 1;
    }

    @Override
    public ListEntry[] getMatchingBrowseFolder(MediaPlayer mediaPlayer) {
        return this.getStandardDblPath(14);
    }

    @Override
    public ListEntry getMatchingBrowseEntry(MediaPlayer mediaPlayer) {
        return mediaPlayer.getActiveAlbum();
    }

    @Override
    public int getComponentId() {
        return 64;
    }
}

