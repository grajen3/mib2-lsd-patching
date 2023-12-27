/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechtuner.controller;

import de.vw.mib.asl.internal.speechtuner.behavior.problemhandling.EntertainmentSourceProblemHandler;
import de.vw.mib.asl.internal.speechtuner.communication.dialogstate.DialogStateHandler;
import de.vw.mib.asl.internal.speechtuner.communication.entertainmentmanager.EntertainmentSourceHandler;
import de.vw.mib.asl.internal.speechtuner.controller.EntertainmentSourceChangeAction;
import de.vw.mib.asl.internal.speechtuner.utils.SpeechTunerServiceManager;

public class ListenToRadioAction
extends EntertainmentSourceChangeAction {
    private static final String LOGGER_PREFIX;
    boolean showRadio = false;
    boolean isContinue;

    public ListenToRadioAction(SpeechTunerServiceManager speechTunerServiceManager, EntertainmentSourceHandler entertainmentSourceHandler, EntertainmentSourceProblemHandler entertainmentSourceProblemHandler, DialogStateHandler dialogStateHandler) {
        super(speechTunerServiceManager, entertainmentSourceHandler, entertainmentSourceProblemHandler, dialogStateHandler, 1);
        this.logger = speechTunerServiceManager.createSpeechTunerLogger("[ListenToRadioAction] ");
    }

    @Override
    protected void processEvent() {
        if (!this.isContinue) {
            this.showRadio = this.entertainmentSourceHandler.isRadioCurrentEntertainmentSource();
            this.isContinue = true;
        }
        super.processEvent();
    }

    @Override
    protected void informModel() {
        if (this.showRadio) {
            if (this.logger.isTraceEnabled()) {
                this.logger.trace("show use case teleprompter as response to the \"listen to radio\" request while radio was already active");
            }
            this.serviceManager.getModelServices().sendEventToModel(-568182272);
        } else {
            if (this.logger.isTraceEnabled()) {
                this.logger.trace("play corresponding prompt as response to the \"listen to radio\" request");
            }
            this.serviceManager.getModelServices().sendEventToModel(-551405056);
        }
        this.isContinue = false;
    }
}

