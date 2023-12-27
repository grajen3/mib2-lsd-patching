/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.sourcehandling.state;

import de.vw.mib.asl.api.devicehandling.Devices;
import de.vw.mib.asl.api.devicehandling.Medium;
import de.vw.mib.asl.api.devicehandling.clients.MediaListObserver;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.media.playback.CurrentAudioSourceState;
import de.vw.mib.asl.internal.media.sourcehandling.clients.MediaDevices;
import de.vw.mib.asl.internal.media.sourcehandling.clients.MediaListObservers;
import de.vw.mib.asl.internal.media.sourcehandling.controller.MediaContext;
import de.vw.mib.asl.internal.media.sourcehandling.controller.SourceIconController;
import de.vw.mib.asl.internal.media.sourcehandling.state.CurrentMediaSourceServiceImpl;
import de.vw.mib.asl.internal.media.sourcehandling.state.MediaCollector;
import de.vw.mib.util.Util;

public final class MediaSourcesAudio
implements MediaListObserver {
    private final MediaListObservers mediaListObservers;
    private final MediaContext mediaContext;
    private final MediaDevices mediaDevices;
    private final CurrentMediaSourceServiceImpl currentMediaSourceService;
    private Medium activeSource = MediaCollector.EMPTY.getMedium();

    public MediaSourcesAudio(MediaListObservers mediaListObservers, MediaContext mediaContext, MediaDevices mediaDevices) {
        this.mediaListObservers = mediaListObservers;
        this.mediaContext = mediaContext;
        this.mediaDevices = mediaDevices;
        this.currentMediaSourceService = new CurrentMediaSourceServiceImpl();
    }

    public Medium getActiveSource() {
        return this.activeSource;
    }

    private void checkErrorCondition(Medium medium) {
        if (medium != null && medium.getParent().getCurrentInfo().getDeviceID() != -1L) {
            MediaCollector mediaCollector;
            int n = medium.getCurrentState().getErrorType();
            CurrentAudioSourceState.set(CurrentAudioSourceState.audioSourceStateFromMediumState(n));
            if (medium.getCurrentState().isDVDVideoAudio()) {
                boolean bl = Util.isBitSet(32, medium.getCurrentInfo().getFlags());
                ServiceManager.aslPropertyManager.valueChangedBoolean(152, bl);
                if (bl) {
                    this.mediaContext.setDisconnectedState();
                }
            }
            if (medium.getCurrentState().isDatabaseFull() && !(mediaCollector = MediaCollector.get(medium)).isDatabaseFullReported()) {
                mediaCollector.setDatabaseFullReported(true);
                ServiceManager.eventDispatcher.createAndSubmitHMIEvent(358353920);
            }
            this.currentMediaSourceService.dsiUpdate();
        }
    }

    public void updateActiveMedia(Medium medium) {
        if (ServiceManager.logger.isTraceEnabled(128)) {
            ServiceManager.logger.trace(128).append("MediaSourcesAudio.updateActiveMedia(").append(medium).append(')').log();
        }
        MediaCollector.get(this.activeSource).setMediaActive(false);
        this.activeSource = medium;
        MediaCollector mediaCollector = MediaCollector.get(this.activeSource);
        this.currentMediaSourceService.updateSource(medium);
        mediaCollector.setMediaActive(true);
        boolean bl = medium.getParent().getCurrentInfo().getDeviceType() == 1;
        int n = medium.getParent().getSlot();
        ServiceManager.aslPropertyManager.valueChangedBoolean(1689, bl && n == 0);
        ServiceManager.aslPropertyManager.valueChangedBoolean(1687, bl && n == 1);
        mediaCollector.makeMainPartition();
        if (mediaCollector != MediaCollector.EMPTY) {
            this.checkErrorCondition(medium);
        }
        this.mediaListObservers.updateLists(true);
        this.reportAnotherSourceAvailable();
    }

    private void reportAnotherSourceAvailable() {
        int n = this.activeSource.getCurrentState().isPlayable() ? 1 : 0;
        ServiceManager.aslPropertyManager.valueChangedBoolean(34, this.mediaDevices.getPlayableSourceCount() > n);
    }

    @Override
    public void onUpdate(Devices devices) {
        if (MediaCollector.EMPTY.getMedium() != this.activeSource) {
            this.checkErrorCondition(this.activeSource);
        } else if (SourceIconController.getInstance().getDeviceCollector() == null) {
            SourceIconController.getInstance().initializeCurrentAudioSource();
            if (SourceIconController.getInstance().getDeviceCollector() != null) {
                this.checkErrorCondition(SourceIconController.getInstance().getDeviceCollector().getMainPartition().getMedium());
            }
        } else {
            this.checkErrorCondition(SourceIconController.getInstance().getDeviceCollector().getMainPartition().getMedium());
        }
        this.reportAnotherSourceAvailable();
    }
}

