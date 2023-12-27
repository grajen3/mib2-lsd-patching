/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.has.contexts.media;

import de.vw.mib.has.HASContextProperties;
import de.vw.mib.has.HASList;
import generated.de.vw.mib.has.containers.MediaBrowserPathContainer;
import generated.de.vw.mib.has.containers.MediaPlayInfoContainer;
import generated.de.vw.mib.has.containers.MediaPlayModeContainer;
import generated.de.vw.mib.has.containers.MediaSourcesContainer;
import generated.de.vw.mib.has.containers.TrackInfoContainer;

public interface MediaProperties
extends HASContextProperties {
    default public void updateCurrentTrackInfo(TrackInfoContainer trackInfoContainer) {
    }

    default public void updateMediaPlayInfo(MediaPlayInfoContainer mediaPlayInfoContainer) {
    }

    default public void updateMediaPlayMode(MediaPlayModeContainer mediaPlayModeContainer) {
    }

    default public void updateAvailableMediaSources(MediaSourcesContainer mediaSourcesContainer) {
    }

    default public void updateMediaBrowserFollowMode(boolean bl) {
    }

    default public void updateMediaBrowserFolder(MediaBrowserPathContainer mediaBrowserPathContainer) {
    }

    default public void updateCurrentTrackPath(MediaBrowserPathContainer mediaBrowserPathContainer) {
    }

    default public HASList getMediaBrowserList() {
    }
}

