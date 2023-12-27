/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.has.contexts.media;

import de.vw.mib.has.HASContextServices;
import generated.de.vw.mib.has.containers.MediaBrowserEntryContainer;
import generated.de.vw.mib.has.containers.MediaBrowserPathContainer;
import generated.de.vw.mib.has.containers.MediaPlayModeContainer;
import generated.de.vw.mib.has.containers.MediaSourceContainer;
import generated.de.vw.mib.has.containers.TrackPositionContainer;

public interface MediaServices
extends HASContextServices {
    default public void setPlayMode(int n, MediaPlayModeContainer mediaPlayModeContainer) {
    }

    default public void nextTrack(int n) {
    }

    default public void previousTrack(int n) {
    }

    default public void playMedia(int n) {
    }

    default public void pauseMedia(int n) {
    }

    default public void setTrackPosition(int n, TrackPositionContainer trackPositionContainer) {
    }

    default public void selectMediaBrowserSource(int n, MediaSourceContainer mediaSourceContainer) {
    }

    default public void enableMediaBrowserFollowMode(int n) {
    }

    default public void disableMediaBrowserFollowMode(int n) {
    }

    default public void changeMediaBrowserFolder(int n, MediaBrowserPathContainer mediaBrowserPathContainer) {
    }

    default public void mediaBrowserPlay(int n, MediaBrowserEntryContainer mediaBrowserEntryContainer) {
    }

    default public void getCurrentTrackInfo() {
    }

    default public void getMediaPlayInfo() {
    }

    default public void getMediaPlayMode() {
    }

    default public void getAvailableMediaSources() {
    }

    default public void getMediaBrowserFollowMode() {
    }

    default public void getMediaBrowserFolder() {
    }

    default public void getCurrentTrackPath() {
    }
}

