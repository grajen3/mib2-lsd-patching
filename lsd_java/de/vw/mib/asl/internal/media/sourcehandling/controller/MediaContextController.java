/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.sourcehandling.controller;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.media.accessor.MediaObjectAccessor;
import de.vw.mib.asl.internal.media.controller.commands.CommandCallback;
import de.vw.mib.asl.internal.media.controller.commands.CommandState;
import de.vw.mib.asl.internal.media.playback.CurrentAudioSourceState;
import de.vw.mib.asl.internal.media.sourcehandling.controller.MediaContext;
import de.vw.mib.asl.internal.media.sourcehandling.controller.SourceIconController;
import de.vw.mib.asl.internal.media.sourcehandling.state.MediaCollector;
import de.vw.mib.asl.internal.media.sourcehandling.state.MediaSourcesAudio;

public final class MediaContextController
implements MediaContext {
    private MediaSourcesAudio mediaSourcesAudio;
    private boolean media = false;
    private boolean cancelledPending;
    private boolean activationPending;

    @Override
    public boolean isMedia() {
        return this.media;
    }

    public void setDisconnectedState(MediaCollector mediaCollector) {
        SourceIconController.getInstance().setCurrentAudioSource(mediaCollector);
        this.mediaSourcesAudio.updateActiveMedia(mediaCollector.getMedium());
        this.setDisconnectedState();
    }

    @Override
    public void setDisconnectedState() {
        this.setDisconnectedStateWithCallback(null);
    }

    public void setDisconnectedStateWithCallback(CommandCallback commandCallback) {
        if (this.media) {
            this.deactivateMedia(false, false, commandCallback);
        }
    }

    public void deactivateMedia(boolean bl, boolean bl2, CommandCallback commandCallback) {
        if (ServiceManager.logger.isTraceEnabled(128)) {
            ServiceManager.logger.trace(128).append("Deactivating media.").log();
        }
        if (bl2) {
            this.mediaSourcesAudio.updateActiveMedia(MediaCollector.EMPTY.getMedium());
        }
        MediaObjectAccessor.mMediaController.insertDeactivatePlayerCmd(bl, bl2, commandCallback);
    }

    public void deactivateEntertainment() {
        this.media = false;
        this.deactivateMedia(true, true, null);
    }

    public boolean isCancelledPending() {
        return this.cancelledPending;
    }

    public boolean cancelEntertainment() {
        if (ServiceManager.logger.isTraceEnabled(128)) {
            ServiceManager.logger.trace(128).append("cancelEntertainment(): setting cancelledPending to ").append(this.activationPending).log();
        }
        this.cancelledPending = this.activationPending;
        this.mediaSourcesAudio.updateActiveMedia(MediaCollector.EMPTY.getMedium());
        return this.cancelledPending;
    }

    public void beginActivation() {
        this.activationPending = true;
        this.media = true;
    }

    public void handleActiveMedia(MediaCollector mediaCollector, CommandState commandState, boolean bl) {
        if (ServiceManager.logger.isTraceEnabled(128)) {
            ServiceManager.logger.trace(128).append("handleActiveMedia: ").append(mediaCollector).log();
        }
        if (!this.activationPending && this.media) {
            return;
        }
        if (this.media) {
            if (!(mediaCollector.getMedium().getCurrentState().isPlayable() || mediaCollector.isDisconnectable() || mediaCollector == MediaCollector.EMPTY || bl)) {
                mediaCollector.getParentDevice().reset();
            }
            if (!(bl || commandState.isCompleted() || mediaCollector == MediaCollector.EMPTY || this.cancelledPending)) {
                int n = mediaCollector.getMedium().getCurrentState().getErrorType();
                if (n == 0) {
                    n = 8;
                }
                CurrentAudioSourceState.set(CurrentAudioSourceState.audioSourceStateFromMediumState(n));
                MediaObjectAccessor.getModelController().reportMediumError(mediaCollector.getMedium());
            }
        }
        this.cancelledPending = false;
        this.activationPending = false;
        if (ServiceManager.logger.isTraceEnabled(128)) {
            ServiceManager.logger.trace(128, "ENDACTIVATION (regular)");
        }
    }

    public void setMediaSourcesAudio(MediaSourcesAudio mediaSourcesAudio) {
        this.mediaSourcesAudio = mediaSourcesAudio;
    }

    public void setMediaActive(MediaCollector mediaCollector) {
        this.media = true;
        this.mediaSourcesAudio.updateActiveMedia(mediaCollector.getMedium());
    }

    public void reset() {
        this.media = false;
        if (this.mediaSourcesAudio != null) {
            this.mediaSourcesAudio.updateActiveMedia(MediaCollector.EMPTY.getMedium());
        }
    }
}

