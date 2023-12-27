/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechtuner.controller;

import de.vw.mib.asl.internal.speechtuner.behavior.problemhandling.StationListProblemHandler;
import de.vw.mib.asl.internal.speechtuner.communication.dialogstate.DialogStateHandler;
import de.vw.mib.asl.internal.speechtuner.communication.entertainmentmanager.EntertainmentSourceHandler;
import de.vw.mib.asl.internal.speechtuner.communication.tuner.DabInterfaceHandler;
import de.vw.mib.asl.internal.speechtuner.communication.tuner.SiriusInterfaceHandler;
import de.vw.mib.asl.internal.speechtuner.controller.EntertainmentSourceChangeAction;
import de.vw.mib.asl.internal.speechtuner.utils.SpeechTunerServiceManager;

public class SelectFrequencyAction
extends EntertainmentSourceChangeAction {
    private static final String LOGGER_PREFIX;
    private final DabInterfaceHandler dabInterfaceHandler;
    private final SiriusInterfaceHandler siriusInterfaceHandler;

    public SelectFrequencyAction(SpeechTunerServiceManager speechTunerServiceManager, EntertainmentSourceHandler entertainmentSourceHandler, StationListProblemHandler stationListProblemHandler, DialogStateHandler dialogStateHandler, DabInterfaceHandler dabInterfaceHandler, SiriusInterfaceHandler siriusInterfaceHandler) {
        super(speechTunerServiceManager, entertainmentSourceHandler, stationListProblemHandler, dialogStateHandler, 2);
        this.logger = speechTunerServiceManager.createSpeechTunerLogger("[SelectFrequencyAction] ");
        this.dabInterfaceHandler = dabInterfaceHandler;
        this.siriusInterfaceHandler = siriusInterfaceHandler;
    }

    @Override
    protected boolean doProblemCheck() {
        if (this.serviceManager.getASLServices().getFeatureAvailabilityChecker().isDabByNameActive()) {
            ((StationListProblemHandler)this.problemHandler).updateCacheState(this.dabInterfaceHandler.isCacheEmpty());
        } else if (this.serviceManager.getASLServices().getFeatureAvailabilityChecker().isSiriusByNameActive()) {
            ((StationListProblemHandler)this.problemHandler).updateCacheState(this.siriusInterfaceHandler.isCacheEmpty());
        } else {
            ((StationListProblemHandler)this.problemHandler).updateCacheState(false);
        }
        return super.doProblemCheck();
    }

    @Override
    protected void informModel() {
        if (this.serviceManager.getASLServices().getFeatureAvailabilityChecker().isAmFrequencyActive()) {
            if (this.logger.isTraceEnabled()) {
                this.logger.trace("show AM select frequency dialog as response to the \"select frequency\" request");
            }
            this.serviceManager.getModelServices().sendEventToModel(-115197440);
        } else if (this.serviceManager.getASLServices().getFeatureAvailabilityChecker().isAmHDFrequencyActive()) {
            if (this.logger.isTraceEnabled()) {
                this.logger.trace("show AM HD select frequency dialog as response to the \"select frequency\" request");
            }
            this.serviceManager.getModelServices().sendEventToModel(170080768);
        } else if (this.serviceManager.getASLServices().getFeatureAvailabilityChecker().isFmFrequencyActive()) {
            if (this.logger.isTraceEnabled()) {
                this.logger.trace("show FM select frequency dialog as response to the \"select frequency\" request");
            }
            this.serviceManager.getModelServices().sendEventToModel(-81643008);
        } else if (this.serviceManager.getASLServices().getFeatureAvailabilityChecker().isFmHDFrequencyActive()) {
            if (this.logger.isTraceEnabled()) {
                this.logger.trace("show FM HD select frequency dialog as response to the \"select frequency\" request");
            }
            this.serviceManager.getModelServices().sendEventToModel(203635200);
        } else if (this.serviceManager.getASLServices().getFeatureAvailabilityChecker().isDabByNameActive()) {
            if (this.logger.isTraceEnabled()) {
                this.logger.trace("show DAB select station dialog as response to the \"select frequency\" request");
            }
            this.dabInterfaceHandler.writeAnyStationIntoSelectedItem();
            this.serviceManager.getModelServices().sendEventToModel(-165529088);
        } else if (this.serviceManager.getASLServices().getFeatureAvailabilityChecker().isSiriusByNameActive()) {
            if (this.logger.isTraceEnabled()) {
                this.logger.trace("show Sirius select channel dialog as response to the \"select frequency\" request");
            }
            this.siriusInterfaceHandler.writeAnyStationIntoSelectedItem();
            this.serviceManager.getModelServices().sendEventToModel(119749120);
        } else {
            this.logger.warn("maybe invalid configuration, \"select frequency\" dialog request found no valid dialog to show");
            this.serviceManager.getModelServices().sendUnexpectedErrorEventToModel();
        }
    }
}

