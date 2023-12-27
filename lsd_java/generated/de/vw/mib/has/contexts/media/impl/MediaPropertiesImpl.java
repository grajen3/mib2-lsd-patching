/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.has.contexts.media.impl;

import de.vw.mib.has.HASBaseContainerFactory;
import de.vw.mib.has.HASDatapool;
import de.vw.mib.has.HASList;
import de.vw.mib.has.HASListControl;
import generated.de.vw.mib.has.containers.MediaBrowserPathContainer;
import generated.de.vw.mib.has.containers.MediaPlayInfoContainer;
import generated.de.vw.mib.has.containers.MediaPlayModeContainer;
import generated.de.vw.mib.has.containers.MediaSourcesContainer;
import generated.de.vw.mib.has.containers.TrackInfoContainer;
import generated.de.vw.mib.has.contexts.impl.AbstractContextProperties;
import generated.de.vw.mib.has.contexts.media.MediaProperties;

public class MediaPropertiesImpl
extends AbstractContextProperties
implements MediaProperties {
    private HASListControl controlMediaBrowserList;

    public MediaPropertiesImpl(HASDatapool hASDatapool, HASBaseContainerFactory hASBaseContainerFactory) {
        super(hASDatapool, hASBaseContainerFactory);
    }

    @Override
    public void updateCurrentTrackInfo(TrackInfoContainer trackInfoContainer) {
        this.updateProperty(21, trackInfoContainer);
    }

    @Override
    public void updateMediaPlayInfo(MediaPlayInfoContainer mediaPlayInfoContainer) {
        this.updateProperty(22, mediaPlayInfoContainer);
    }

    @Override
    public void updateMediaPlayMode(MediaPlayModeContainer mediaPlayModeContainer) {
        this.updateProperty(23, mediaPlayModeContainer);
    }

    @Override
    public void updateAvailableMediaSources(MediaSourcesContainer mediaSourcesContainer) {
        this.updateProperty(27, mediaSourcesContainer);
    }

    @Override
    public void updateMediaBrowserFollowMode(boolean bl) {
        this.updateProperty(43, 46, bl);
    }

    @Override
    public void updateMediaBrowserFolder(MediaBrowserPathContainer mediaBrowserPathContainer) {
        this.updateProperty(47, mediaBrowserPathContainer);
    }

    @Override
    public void updateCurrentTrackPath(MediaBrowserPathContainer mediaBrowserPathContainer) {
        this.updateProperty(50, mediaBrowserPathContainer);
    }

    public void setMediaBrowserList(HASListControl hASListControl) {
        this.controlMediaBrowserList = hASListControl;
    }

    @Override
    public HASList getMediaBrowserList() {
        return this.controlMediaBrowserList.getStrategy();
    }
}

