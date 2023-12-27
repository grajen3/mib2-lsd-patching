/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechmedia.controller;

import de.vw.mib.asl.api.media.services.Callback;
import de.vw.mib.asl.api.media.services.ResultCode;
import de.vw.mib.asl.api.media.services.sources.current.CurrentMediaSourceListener;
import de.vw.mib.asl.api.media.services.sources.medialist.Source;
import de.vw.mib.asl.internal.speechmedia.controller.EntertainmentSourceListener;
import de.vw.mib.asl.internal.speechmedia.controller.MediaServiceController;
import de.vw.mib.asl.internal.speechmedia.utils.SpeechMediaLogger;

public class ActivationHandlerSimple
implements EntertainmentSourceListener,
CurrentMediaSourceListener {
    protected SpeechMediaLogger logger = new SpeechMediaLogger("[ActivationHandlerSimple] ");
    private final MediaServiceController msContr;
    protected boolean activationInProgress = false;
    protected boolean hasCurrentMediaSource = false;
    protected Callback activationCallback;

    public ActivationHandlerSimple(MediaServiceController mediaServiceController) {
        this.msContr = mediaServiceController;
        mediaServiceController.registerEntertainmentSourceListener(this);
        mediaServiceController.registerCurrentSourceListener(this);
    }

    public void activate(Callback callback) {
        this.activationCallback = callback;
        if (this.activationInProgress) {
            return;
        }
        if (this.msContr.isActive()) {
            if (this.logger.isTraceEnabled()) {
                this.logger.trace("Tried to activate media, but it was already active.");
            }
            callback.response(ResultCode.OK);
            return;
        }
        this.hasCurrentMediaSource = false;
        this.activationInProgress = true;
        if (this.logger.isTraceEnabled()) {
            this.logger.trace("Try to activate media with callback.");
        }
        this.msContr.activate();
    }

    private void handleChanges() {
        if (this.msContr.isActive() && this.hasCurrentMediaSource) {
            if (this.logger.isTraceEnabled()) {
                this.logger.trace("Media activated, callback.");
            }
            this.activationInProgress = false;
            this.activationCallback.response(ResultCode.OK);
        }
    }

    @Override
    public void onEntertainmentSourceChanged(boolean bl) {
        if (!this.activationInProgress) {
            return;
        }
        this.handleChanges();
    }

    @Override
    public void updateCurrentMediaSource(Source source) {
        if (!this.activationInProgress) {
            return;
        }
        this.hasCurrentMediaSource = true;
        this.handleChanges();
    }
}

