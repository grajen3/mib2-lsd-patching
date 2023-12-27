/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechtuner.controller;

import de.vw.mib.asl.internal.speechtuner.behavior.problemhandling.TunerProblemHandler;
import de.vw.mib.asl.internal.speechtuner.controller.TunerAction;
import de.vw.mib.asl.internal.speechtuner.utils.SpeechTunerServiceManager;

public class HelpForSelectStationAction
extends TunerAction {
    private static final String LOGGER_PREFIX;

    public HelpForSelectStationAction(SpeechTunerServiceManager speechTunerServiceManager, TunerProblemHandler tunerProblemHandler) {
        super(speechTunerServiceManager, tunerProblemHandler, 5);
        this.logger = speechTunerServiceManager.createSpeechTunerLogger("[HelpForSelectStationAction] ");
    }

    @Override
    protected void informModel() {
        if (this.serviceManager.getASLServices().getFeatureAvailabilityChecker().isSiriusByNameCoded()) {
            if (this.logger.isTraceEnabled()) {
                this.logger.trace("\"select station\" help request but SDARS coded, send \"select channel\" response to model");
            }
            this.serviceManager.getModelServices().sendEventToModel(-417187328);
        } else if (!(this.serviceManager.getASLServices().getFeatureAvailabilityChecker().isFmByNameCoded() || this.serviceManager.getASLServices().getFeatureAvailabilityChecker().isDabByNameCoded() || this.serviceManager.getASLServices().getFeatureAvailabilityChecker().isSiriusByNameCoded())) {
            if (this.logger.isTraceEnabled()) {
                this.logger.trace("\"select station\" help request but no selection by name possible, send \"select frequency\" response to model");
            }
            this.serviceManager.getModelServices().sendEventToModel(-501073408);
        } else {
            if (this.logger.isTraceEnabled()) {
                this.logger.trace("\"select station\" help request, send \"select station\" response to model");
            }
            this.serviceManager.getModelServices().sendEventToModel(-484296192);
        }
    }
}

