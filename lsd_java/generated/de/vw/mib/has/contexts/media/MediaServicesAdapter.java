/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.has.contexts.media;

import de.vw.mib.has.HASContainer;
import de.vw.mib.has.HASException;
import generated.de.vw.mib.has.containers.MediaBrowserEntryContainer;
import generated.de.vw.mib.has.containers.MediaBrowserPathContainer;
import generated.de.vw.mib.has.containers.MediaPlayModeContainer;
import generated.de.vw.mib.has.containers.MediaSourceContainer;
import generated.de.vw.mib.has.containers.TrackPositionContainer;
import generated.de.vw.mib.has.contexts.media.MediaServices;

public class MediaServicesAdapter
implements MediaServices {
    @Override
    public void actionRequest(int n, int n2, HASContainer hASContainer) {
        switch (n2) {
            case 6: {
                this.setPlayMode(n, (MediaPlayModeContainer)hASContainer);
                break;
            }
            case 7: {
                this.nextTrack(n);
                break;
            }
            case 8: {
                this.previousTrack(n);
                break;
            }
            case 15: {
                this.playMedia(n);
                break;
            }
            case 16: {
                this.pauseMedia(n);
                break;
            }
            case 17: {
                this.setTrackPosition(n, (TrackPositionContainer)hASContainer);
                break;
            }
            case 19: {
                this.selectMediaBrowserSource(n, (MediaSourceContainer)hASContainer);
                break;
            }
            case 32: {
                this.enableMediaBrowserFollowMode(n);
                break;
            }
            case 33: {
                this.disableMediaBrowserFollowMode(n);
                break;
            }
            case 35: {
                this.changeMediaBrowserFolder(n, (MediaBrowserPathContainer)hASContainer);
                break;
            }
            case 36: {
                this.mediaBrowserPlay(n, (MediaBrowserEntryContainer)hASContainer);
                break;
            }
            default: {
                throw HASException.invalidActionRequest(n2);
            }
        }
    }

    @Override
    public void propertyRequest(int n) {
        switch (n) {
            case 21: {
                this.getCurrentTrackInfo();
                break;
            }
            case 22: {
                this.getMediaPlayInfo();
                break;
            }
            case 23: {
                this.getMediaPlayMode();
                break;
            }
            case 27: {
                this.getAvailableMediaSources();
                break;
            }
            case 41: {
                break;
            }
            case 43: {
                this.getMediaBrowserFollowMode();
                break;
            }
            case 47: {
                this.getMediaBrowserFolder();
                break;
            }
            case 50: {
                this.getCurrentTrackPath();
                break;
            }
            default: {
                throw HASException.invalidPropertyRequest(n);
            }
        }
    }

    @Override
    public void setPlayMode(int n, MediaPlayModeContainer mediaPlayModeContainer) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void nextTrack(int n) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void previousTrack(int n) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void playMedia(int n) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void pauseMedia(int n) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setTrackPosition(int n, TrackPositionContainer trackPositionContainer) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void selectMediaBrowserSource(int n, MediaSourceContainer mediaSourceContainer) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void enableMediaBrowserFollowMode(int n) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void disableMediaBrowserFollowMode(int n) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void changeMediaBrowserFolder(int n, MediaBrowserPathContainer mediaBrowserPathContainer) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void mediaBrowserPlay(int n, MediaBrowserEntryContainer mediaBrowserEntryContainer) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void getCurrentTrackInfo() {
    }

    @Override
    public void getMediaPlayInfo() {
    }

    @Override
    public void getMediaPlayMode() {
    }

    @Override
    public void getAvailableMediaSources() {
    }

    @Override
    public void getMediaBrowserFollowMode() {
    }

    @Override
    public void getMediaBrowserFolder() {
    }

    @Override
    public void getCurrentTrackPath() {
    }
}

