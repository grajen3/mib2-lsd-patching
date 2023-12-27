/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechtuner.controller;

import de.vw.mib.asl.internal.speechtuner.behavior.problemhandling.TunerProblemHandler;
import de.vw.mib.asl.internal.speechtuner.controller.TunerAction;
import de.vw.mib.asl.internal.speechtuner.utils.SpeechTunerServiceManager;

public abstract class SimpleTunerAction
extends TunerAction {
    private static final String LOGGER_PREFIX;
    protected final int successSystemEventId;

    public SimpleTunerAction(SpeechTunerServiceManager speechTunerServiceManager, TunerProblemHandler tunerProblemHandler, int n, int n2) {
        super(speechTunerServiceManager, tunerProblemHandler, n2);
        this.logger = speechTunerServiceManager.createSpeechTunerLogger("[SimpleTunerAction] ");
        this.successSystemEventId = n;
    }

    @Override
    protected void informModel() {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace(new StringBuffer().append("inform model about success with event ").append(this.successSystemEventId).toString());
        }
        this.serviceManager.getModelServices().sendEventToModel(this.successSystemEventId);
    }

    public int getSuccessSystemEventId() {
        return this.successSystemEventId;
    }
}

