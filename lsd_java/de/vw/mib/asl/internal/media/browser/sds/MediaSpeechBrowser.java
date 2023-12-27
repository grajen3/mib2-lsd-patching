/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.browser.sds;

import de.vw.mib.asl.internal.media.browser.AbstractMediaBrowser;
import de.vw.mib.asl.internal.media.playback.MediaPlayer;
import de.vw.mib.genericevents.GenericEvents;
import org.dsi.ifc.media.ListEntry;

public class MediaSpeechBrowser
extends AbstractMediaBrowser {
    private int mSelectedFolderType;

    public MediaSpeechBrowser(GenericEvents genericEvents, String string, int n) {
        super(genericEvents, string, n);
    }

    @Override
    public int getDefaultTargetId() {
        return 464458496;
    }

    @Override
    public int getComponentId() {
        return 128;
    }

    @Override
    public int getMatchingBrowseMode(MediaPlayer mediaPlayer) {
        if (mediaPlayer.getActiveMedia().supportsContentMode()) {
            return 1;
        }
        return 0;
    }

    @Override
    public ListEntry[] getMatchingBrowseFolder(MediaPlayer mediaPlayer) {
        if (mediaPlayer.getActiveMedia().supportsContentMode()) {
            return this.getStandardDblPath(this.mSelectedFolderType);
        }
        return super.getMatchingBrowseFolder(mediaPlayer);
    }

    @Override
    public ListEntry getMatchingBrowseEntry(MediaPlayer mediaPlayer) {
        return null;
    }
}

