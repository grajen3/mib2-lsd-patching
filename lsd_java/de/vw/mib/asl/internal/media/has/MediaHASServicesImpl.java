/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.has;

import de.vw.mib.asl.framework.internal.framework.AbstractASLTarget;
import de.vw.mib.asl.internal.media.common.HASUtil;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.has.HAS;
import de.vw.mib.has.HASContext;
import de.vw.mib.has.HASEngineAPI;
import generated.de.vw.mib.has.containers.MediaBrowserEntryContainer;
import generated.de.vw.mib.has.containers.MediaBrowserPathContainer;
import generated.de.vw.mib.has.containers.MediaPlayModeContainer;
import generated.de.vw.mib.has.containers.MediaSourceContainer;
import generated.de.vw.mib.has.containers.TrackPositionContainer;
import generated.de.vw.mib.has.contexts.media.MediaProperties;
import generated.de.vw.mib.has.contexts.media.MediaResults;
import generated.de.vw.mib.has.contexts.media.MediaServicesAdapter;

public class MediaHASServicesImpl
extends MediaServicesAdapter {
    private final MediaResults hasResults;
    private final MediaProperties hasProperties;
    private final AbstractASLTarget mMediaHASTarget;

    public MediaHASServicesImpl(AbstractASLTarget abstractASLTarget) {
        this.mMediaHASTarget = abstractASLTarget;
        HASEngineAPI hASEngineAPI = HAS.getInstance().getEngine();
        HASContext hASContext = hASEngineAPI.getRegistry().getContextByName("Media");
        hASContext.setServicesImpl(this);
        this.hasResults = (MediaResults)hASContext.getResultsImpl();
        this.hasProperties = (MediaProperties)hASContext.getPropertiesImpl();
    }

    @Override
    public void setPlayMode(int n, MediaPlayModeContainer mediaPlayModeContainer) {
        boolean bl;
        boolean bl2 = mediaPlayModeContainer.isRepeatModeSet() && mediaPlayModeContainer.getRepeatMode() != 0 || mediaPlayModeContainer.isMixModeSet() && mediaPlayModeContainer.getMixMode();
        boolean bl3 = bl = mediaPlayModeContainer.isPMLTModeSet() && mediaPlayModeContainer.getPMLTMode();
        if (bl2) {
            EventGeneric eventGeneric = this.mMediaHASTarget.getEventFactory().newEvent(this.mMediaHASTarget.getDefaultTargetId(), 279909120, -1350172416);
            eventGeneric.setInt(0, n);
            eventGeneric.setObject(1, HASUtil.convertPlaybackModeHAS2DummyPlayMode(mediaPlayModeContainer.getRepeatMode(), mediaPlayModeContainer.getMixMode()));
            this.mMediaHASTarget.sendSafe(eventGeneric);
        } else if (bl) {
            EventGeneric eventGeneric = this.mMediaHASTarget.getEventFactory().newEvent(this.mMediaHASTarget.getDefaultTargetId(), 279909120, -1148845824);
            eventGeneric.setInt(0, n);
            eventGeneric.setBoolean(1, true);
            this.mMediaHASTarget.sendSafe(eventGeneric);
        } else {
            EventGeneric eventGeneric = this.mMediaHASTarget.getEventFactory().newEvent(this.mMediaHASTarget.getDefaultTargetId(), 279909120, -1148845824);
            eventGeneric.setInt(0, n);
            eventGeneric.setBoolean(1, false);
            this.mMediaHASTarget.sendSafe(eventGeneric);
        }
    }

    @Override
    public void playMedia(int n) {
        EventGeneric eventGeneric = this.mMediaHASTarget.getEventFactory().newEvent(this.mMediaHASTarget.getDefaultTargetId(), 279909120, -1283063552);
        eventGeneric.setInt(0, n);
        this.mMediaHASTarget.sendSafe(eventGeneric);
    }

    @Override
    public void pauseMedia(int n) {
        EventGeneric eventGeneric = this.mMediaHASTarget.getEventFactory().newEvent(this.mMediaHASTarget.getDefaultTargetId(), 279909120, -1266286336);
        eventGeneric.setInt(0, n);
        this.mMediaHASTarget.sendSafe(eventGeneric);
    }

    @Override
    public void selectMediaBrowserSource(int n, MediaSourceContainer mediaSourceContainer) {
        EventGeneric eventGeneric = this.mMediaHASTarget.getEventFactory().newEvent(this.mMediaHASTarget.getDefaultTargetId(), 279909120, -1232731904);
        eventGeneric.setInt(0, n);
        eventGeneric.setInt(1, HASUtil.convertHASSourceIdASL(mediaSourceContainer.getSource()));
        this.mMediaHASTarget.sendSafe(eventGeneric);
    }

    @Override
    public void changeMediaBrowserFolder(int n, MediaBrowserPathContainer mediaBrowserPathContainer) {
        EventGeneric eventGeneric = this.mMediaHASTarget.getEventFactory().newEvent(this.mMediaHASTarget.getDefaultTargetId(), 279909120, -1182400256);
        eventGeneric.setInt(0, n);
        eventGeneric.setObject(1, mediaBrowserPathContainer);
        this.mMediaHASTarget.sendSafe(eventGeneric);
    }

    @Override
    public void enableMediaBrowserFollowMode(int n) {
        EventGeneric eventGeneric = this.mMediaHASTarget.getEventFactory().newEvent(this.mMediaHASTarget.getDefaultTargetId(), 279909120, -1215954688);
        eventGeneric.setInt(0, n);
        this.mMediaHASTarget.sendSafe(eventGeneric);
        this.hasResults.enableMediaBrowserFollowModeResult(n, 0);
        this.hasProperties.updateMediaBrowserFollowMode(true);
    }

    @Override
    public void disableMediaBrowserFollowMode(int n) {
        EventGeneric eventGeneric = this.mMediaHASTarget.getEventFactory().newEvent(this.mMediaHASTarget.getDefaultTargetId(), 279909120, -1199177472);
        eventGeneric.setInt(0, n);
        this.mMediaHASTarget.sendSafe(eventGeneric);
        this.hasResults.disableMediaBrowserFollowModeResult(n, 0);
        this.hasProperties.updateMediaBrowserFollowMode(false);
    }

    @Override
    public void setTrackPosition(int n, TrackPositionContainer trackPositionContainer) {
        EventGeneric eventGeneric = this.mMediaHASTarget.getEventFactory().newEvent(this.mMediaHASTarget.getDefaultTargetId(), 279909120, -1249509120);
        eventGeneric.setInt(0, n);
        eventGeneric.setInt(1, trackPositionContainer.getPosition());
        this.mMediaHASTarget.sendSafe(eventGeneric);
    }

    @Override
    public void nextTrack(int n) {
        EventGeneric eventGeneric = this.mMediaHASTarget.getEventFactory().newEvent(this.mMediaHASTarget.getDefaultTargetId(), 279909120, -1316617984);
        eventGeneric.setInt(0, n);
        this.mMediaHASTarget.sendSafe(eventGeneric);
        this.hasResults.nextTrackResult(n, 0);
    }

    @Override
    public void previousTrack(int n) {
        EventGeneric eventGeneric = this.mMediaHASTarget.getEventFactory().newEvent(this.mMediaHASTarget.getDefaultTargetId(), 279909120, -1299840768);
        eventGeneric.setInt(0, n);
        this.mMediaHASTarget.sendSafe(eventGeneric);
        this.hasResults.previousTrackResult(n, 0);
    }

    @Override
    public void mediaBrowserPlay(int n, MediaBrowserEntryContainer mediaBrowserEntryContainer) {
        EventGeneric eventGeneric = this.mMediaHASTarget.getEventFactory().newEvent(this.mMediaHASTarget.getDefaultTargetId(), 279909120, -1165623040);
        eventGeneric.setInt(0, n);
        eventGeneric.setObject(1, mediaBrowserEntryContainer);
        this.mMediaHASTarget.sendSafe(eventGeneric);
    }
}

