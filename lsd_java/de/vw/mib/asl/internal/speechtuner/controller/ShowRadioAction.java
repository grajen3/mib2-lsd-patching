/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechtuner.controller;

import de.vw.mib.asl.internal.speechtuner.behavior.problemhandling.EntertainmentSourceProblemHandler;
import de.vw.mib.asl.internal.speechtuner.communication.dialogstate.DialogStateHandler;
import de.vw.mib.asl.internal.speechtuner.communication.entertainmentmanager.EntertainmentSourceHandler;
import de.vw.mib.asl.internal.speechtuner.controller.EntertainmentSourceChangeAction;
import de.vw.mib.asl.internal.speechtuner.utils.SpeechTunerServiceManager;

public class ShowRadioAction
extends EntertainmentSourceChangeAction {
    private static final String LOGGER_PREFIX;

    public ShowRadioAction(SpeechTunerServiceManager speechTunerServiceManager, EntertainmentSourceHandler entertainmentSourceHandler, EntertainmentSourceProblemHandler entertainmentSourceProblemHandler, DialogStateHandler dialogStateHandler) {
        super(speechTunerServiceManager, entertainmentSourceHandler, entertainmentSourceProblemHandler, dialogStateHandler, 1);
        this.logger = speechTunerServiceManager.createSpeechTunerLogger("[ShowRadioAction] ");
    }

    @Override
    protected void informModel() {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace("show use case teleprompter as response to the \"show radio\" request");
        }
        this.serviceManager.getModelServices().sendEventToModel(-568182272);
    }
}

