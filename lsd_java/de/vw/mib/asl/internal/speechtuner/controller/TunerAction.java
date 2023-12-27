/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechtuner.controller;

import de.vw.mib.asl.api.speechengine.result.router.ModelEventConsumer;
import de.vw.mib.asl.api.speechengine.result.router.RecognizedEventConsumer;
import de.vw.mib.asl.internal.speechtuner.behavior.problemhandling.TunerProblemHandler;
import de.vw.mib.asl.internal.speechtuner.utils.SpeechTunerLogger;
import de.vw.mib.asl.internal.speechtuner.utils.SpeechTunerServiceManager;
import de.vw.mib.genericevents.EventGeneric;

public abstract class TunerAction
implements RecognizedEventConsumer,
ModelEventConsumer {
    private static final String LOGGER_PREFIX;
    protected SpeechTunerServiceManager serviceManager;
    protected SpeechTunerLogger logger;
    protected final TunerProblemHandler problemHandler;
    protected final int usecase;

    public TunerAction(SpeechTunerServiceManager speechTunerServiceManager, TunerProblemHandler tunerProblemHandler, int n) {
        this.serviceManager = speechTunerServiceManager;
        this.logger = speechTunerServiceManager.createSpeechTunerLogger("[TunerAction] ");
        this.problemHandler = tunerProblemHandler;
        this.usecase = n;
    }

    @Override
    public void onRecognizedEvent(int n) {
        this.problemHandler.setCurrentUseCase(this.usecase);
        this.processEvent();
    }

    @Override
    public void onEvent(EventGeneric eventGeneric) {
        this.problemHandler.setCurrentUseCase(this.usecase);
        this.processEvent();
    }

    protected void processEvent() {
        boolean bl = this.doProblemCheck();
        if (bl) {
            this.reactOnRequest();
            this.informModel();
        }
    }

    public void triggerManually() {
        this.problemHandler.setCurrentUseCase(this.usecase);
        this.processEvent();
    }

    protected boolean doProblemCheck() {
        return this.problemHandler.isProblemCheckSuccessful();
    }

    protected void reactOnRequest() {
    }

    protected void informModel() {
    }
}

