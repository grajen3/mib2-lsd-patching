/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechmedia.controller;

import de.vw.mib.asl.api.media.services.Callback;
import de.vw.mib.asl.api.media.services.ResultCode;
import de.vw.mib.asl.api.media.services.player.MediaActivationStateListener;
import de.vw.mib.asl.api.media.services.sources.current.CurrentMediaSourceListener;
import de.vw.mib.asl.api.media.services.sources.medialist.Source;
import de.vw.mib.asl.internal.speechmedia.controller.ActivationHandler$1;
import de.vw.mib.asl.internal.speechmedia.controller.MediaServiceController;
import de.vw.mib.asl.internal.speechmedia.controller.SlotController;
import de.vw.mib.asl.internal.speechmedia.controller.SlotStateListener;
import de.vw.mib.asl.internal.speechmedia.utils.SpeechMediaLogger;
import de.vw.mib.timer.Timer;
import de.vw.mib.timer.TimerManager;

public class ActivationHandler
implements SlotStateListener,
CurrentMediaSourceListener,
MediaActivationStateListener {
    public static final String TIMER_NAME;
    protected SpeechMediaLogger logger = new SpeechMediaLogger("[ActivationHandler] ");
    private final MediaServiceController msContr;
    protected boolean activationInProgress = false;
    protected Callback activationCallback;
    protected int useCase;
    protected Timer activationTimer;
    private Runnable activationTimeout = new ActivationHandler$1(this);

    public ActivationHandler(SlotController slotController, MediaServiceController mediaServiceController) {
        this.msContr = mediaServiceController;
        mediaServiceController.registerCurrentSourceListener(this);
        mediaServiceController.registerActivateionStateListener(this);
        slotController.registerSlotStateListener(this);
        TimerManager timerManager = mediaServiceController.getSpeechMediaServiceManager().getTimerManager();
        this.activationTimer = timerManager.createTimer("MediaSourceActivationTimer", 0, false, this.activationTimeout, mediaServiceController.getSpeechMediaServiceManager().getThreadSwitchingTarget());
    }

    public void activate(int n, Callback callback) {
        this.useCase = n;
        this.activationCallback = callback;
        if (this.activationInProgress) {
            return;
        }
        this.msContr.activate();
        Source source = this.msContr.getCurrentMediaSource();
        if (this.msContr.isCurrentMediaSourceValid() && source.getContentBrowsingAvailable() == 1) {
            if (this.logger.isTraceEnabled()) {
                this.logger.trace("Current media source does not supprot DB handling.");
            }
            callback.response(ResultCode.NOK);
            return;
        }
        if (this.handleChanges()) {
            return;
        }
        if (this.logger.isTraceEnabled()) {
            this.logger.trace("DB synching or slot loading. Wait...");
        }
        this.activationInProgress = true;
        this.activationTimer.start();
    }

    private boolean handleChanges() {
        if (!this.msContr.isCurrentMediaSourceValid()) {
            return false;
        }
        if (this.msContr.getActivationState() != 3) {
            return false;
        }
        Source source = this.msContr.getCurrentMediaSource();
        if (source.getContentBrowsingAvailable() == 2) {
            return false;
        }
        if (this.msContr.getUseCaseSlotState(this.useCase) == 2 || this.msContr.getUseCaseSlotState(this.useCase) == 3 || this.msContr.getUseCaseSlotState(this.useCase) == -1) {
            return false;
        }
        this.activationTimer.stop();
        this.activationInProgress = false;
        if (source.getContentBrowsingAvailable() == 3 && this.msContr.getUseCaseSlotState(this.useCase) == 1) {
            this.activationCallback.response(ResultCode.OK);
            return true;
        }
        if (this.logger.isTraceEnabled()) {
            this.logger.trace("Seems, the slot could not be compiled.");
        }
        this.activationCallback.response(ResultCode.NOK);
        return true;
    }

    @Override
    public void onSlotStateChanged(int n, int n2) {
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
        this.handleChanges();
    }

    @Override
    public void updateActivationState(int n) {
        if (!this.activationInProgress) {
            return;
        }
        this.handleChanges();
    }
}

