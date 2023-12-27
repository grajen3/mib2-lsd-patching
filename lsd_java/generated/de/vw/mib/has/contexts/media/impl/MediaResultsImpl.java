/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.has.contexts.media.impl;

import de.vw.mib.has.HASBaseContainerFactory;
import de.vw.mib.has.HASContextResults;
import generated.de.vw.mib.has.contexts.impl.AbstractContextResults;
import generated.de.vw.mib.has.contexts.media.MediaResults;

public class MediaResultsImpl
extends AbstractContextResults
implements MediaResults {
    public MediaResultsImpl(HASContextResults hASContextResults, HASBaseContainerFactory hASBaseContainerFactory) {
        super(hASContextResults, hASBaseContainerFactory);
    }

    @Override
    public void setPlayModeResult(int n, int n2) {
        this.callResult(n, 6, n2);
    }

    @Override
    public void nextTrackResult(int n, int n2) {
        this.callResult(n, 7, n2);
    }

    @Override
    public void previousTrackResult(int n, int n2) {
        this.callResult(n, 8, n2);
    }

    @Override
    public void playMediaResult(int n, int n2) {
        this.callResult(n, 15, n2);
    }

    @Override
    public void pauseMediaResult(int n, int n2) {
        this.callResult(n, 16, n2);
    }

    @Override
    public void setTrackPositionResult(int n, int n2) {
        this.callResult(n, 17, n2);
    }

    @Override
    public void selectMediaBrowserSourceResult(int n, int n2) {
        this.callResult(n, 19, n2);
    }

    @Override
    public void enableMediaBrowserFollowModeResult(int n, int n2) {
        this.callResult(n, 32, n2);
    }

    @Override
    public void disableMediaBrowserFollowModeResult(int n, int n2) {
        this.callResult(n, 33, n2);
    }

    @Override
    public void changeMediaBrowserFolderResult(int n, int n2) {
        this.callResult(n, 35, n2);
    }

    @Override
    public void mediaBrowserPlayResult(int n, int n2) {
        this.callResult(n, 36, n2);
    }
}

