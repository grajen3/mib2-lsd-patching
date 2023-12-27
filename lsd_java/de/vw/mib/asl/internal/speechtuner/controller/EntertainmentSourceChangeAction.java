/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechtuner.controller;

import de.vw.mib.asl.internal.speechtuner.behavior.problemhandling.EntertainmentSourceProblemHandler;
import de.vw.mib.asl.internal.speechtuner.communication.dialogstate.DialogStateHandler;
import de.vw.mib.asl.internal.speechtuner.communication.entertainmentmanager.EntertainmentSourceHandler;
import de.vw.mib.asl.internal.speechtuner.controller.TunerAction;
import de.vw.mib.asl.internal.speechtuner.utils.SpeechTunerServiceManager;
import de.vw.mib.asl.internal.speechtuner.utils.callbacks.EntertainmentSourceCallback;

public abstract class EntertainmentSourceChangeAction
extends TunerAction
implements EntertainmentSourceCallback {
    private static final String LOGGER_PREFIX;
    protected final EntertainmentSourceHandler entertainmentSourceHandler;
    protected final DialogStateHandler dialogStateHandler;

    public EntertainmentSourceChangeAction(SpeechTunerServiceManager speechTunerServiceManager, EntertainmentSourceHandler entertainmentSourceHandler, EntertainmentSourceProblemHandler entertainmentSourceProblemHandler, DialogStateHandler dialogStateHandler, int n) {
        super(speechTunerServiceManager, entertainmentSourceProblemHandler, n);
        this.logger = speechTunerServiceManager.createSpeechTunerLogger("[EntertainmentSourceChangeTunerAction] ");
        this.entertainmentSourceHandler = entertainmentSourceHandler;
        this.dialogStateHandler = dialogStateHandler;
    }

    @Override
    protected void processEvent() {
        if (!this.entertainmentSourceHandler.isRadioCurrentEntertainmentSource()) {
            this.entertainmentSourceHandler.registerForNextSourceChange(this);
        }
        super.processEvent();
    }

    @Override
    public void onActivateRadio() {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace("continue simple use case since radio is active now");
        }
        if (this.dialogStateHandler.isDialogActive()) {
            this.processEvent();
        } else {
            this.logger.warn("radio is active now but dialog has been closed meanwhile, do not send anything to model");
        }
    }
}

