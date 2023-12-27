/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.sourcehandling.controller;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.media.accessor.MediaObjectAccessor;
import de.vw.mib.asl.internal.media.playback.CurrentAudioSourceState;
import de.vw.mib.asl.internal.media.sourcehandling.SourceHandlingPersistence;
import de.vw.mib.asl.internal.media.sourcehandling.controller.SourceIconController;
import de.vw.mib.asl.internal.media.sourcehandling.state.MediaCollector;

public final class MediaSourceController {
    public static final int ACTIVATE_SUCCESS;
    public static final int ACTIVATE_UNPLAYABLE;
    public static final int ACTIVATE_ALREADY_ACTIVE;
    public static final int ACTIVATE_GENERAL_ERROR;
    private static MediaSourceController instance;

    private MediaSourceController() {
    }

    public static MediaSourceController getInstance() {
        if (instance == null) {
            instance = new MediaSourceController();
        }
        return instance;
    }

    public int activateMediaSource(MediaCollector mediaCollector) {
        if (mediaCollector.isDisconnectableButNotPlayable() || mediaCollector.isMediaPlayable() && CurrentAudioSourceState.get() == 5) {
            SourceIconController.getInstance().setCurrentAudioSource(mediaCollector);
            SourceHandlingPersistence.getInstance().storePartition(mediaCollector);
            return 0;
        }
        if (!this.checkSource(mediaCollector, true)) {
            return 1;
        }
        SourceIconController.getInstance().setCurrentAudioSource(mediaCollector);
        if (mediaCollector.isMediaActive() && mediaCollector.isFlagSet(512)) {
            if (ServiceManager.logger.isTraceEnabled(128)) {
                ServiceManager.logger.trace(128).append("Not activating already active media source: ").append(mediaCollector.toStringShort()).log();
            }
            CurrentAudioSourceState.setIgnoreError(false);
            return 2;
        }
        SourceHandlingPersistence.getInstance().storePartition(mediaCollector);
        return 0;
    }

    public boolean checkSource(MediaCollector mediaCollector, boolean bl) {
        if (mediaCollector.check()) {
            return true;
        }
        if (mediaCollector.isOpticalMediaPlaybackToBeBlocked()) {
            MediaObjectAccessor.getModelController().sendMediumImportActiveEvent(mediaCollector.getParentDevice().getDevice());
        }
        if (bl && mediaCollector != MediaCollector.EMPTY) {
            MediaObjectAccessor.getModelController().reportMediumError(mediaCollector.getMedium());
        }
        return false;
    }
}

