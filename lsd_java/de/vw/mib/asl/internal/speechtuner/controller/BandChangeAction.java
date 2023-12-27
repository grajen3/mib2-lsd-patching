/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechtuner.controller;

import de.vw.mib.asl.internal.speechtuner.behavior.problemhandling.EntertainmentSourceProblemHandler;
import de.vw.mib.asl.internal.speechtuner.communication.dialogstate.DialogStateHandler;
import de.vw.mib.asl.internal.speechtuner.communication.entertainmentmanager.EntertainmentSourceHandler;
import de.vw.mib.asl.internal.speechtuner.communication.tuner.AmFmInterfaceHandler;
import de.vw.mib.asl.internal.speechtuner.communication.tuner.SiriusInterfaceHandler;
import de.vw.mib.asl.internal.speechtuner.controller.EntertainmentSourceChangeAction;
import de.vw.mib.asl.internal.speechtuner.controller.SelectStationAction;
import de.vw.mib.asl.internal.speechtuner.utils.SpeechTunerServiceManager;
import de.vw.mib.asl.internal.speechtuner.utils.callbacks.BandChangeCallback;
import de.vw.mib.genericevents.EventGeneric;

public class BandChangeAction
extends EntertainmentSourceChangeAction
implements BandChangeCallback {
    private static final String LOGGER_PREFIX;
    private int bandChangeEvent;
    private int expectedBand;
    private boolean alreadyActive;
    private boolean bandChangeResponseArrived;
    private boolean nextUseCaseRequestArrived;
    private AmFmInterfaceHandler amFmInterfaceHandler;
    private SiriusInterfaceHandler siriusInterfaceHandler;
    private SelectStationAction selectStationAction;

    public BandChangeAction(SpeechTunerServiceManager speechTunerServiceManager, EntertainmentSourceHandler entertainmentSourceHandler, EntertainmentSourceProblemHandler entertainmentSourceProblemHandler, DialogStateHandler dialogStateHandler, AmFmInterfaceHandler amFmInterfaceHandler, SiriusInterfaceHandler siriusInterfaceHandler, SelectStationAction selectStationAction) {
        super(speechTunerServiceManager, entertainmentSourceHandler, entertainmentSourceProblemHandler, dialogStateHandler, 4);
        this.logger = speechTunerServiceManager.createSpeechTunerLogger("[BandChangeAction] ");
        this.amFmInterfaceHandler = amFmInterfaceHandler;
        this.siriusInterfaceHandler = siriusInterfaceHandler;
        this.selectStationAction = selectStationAction;
    }

    @Override
    public void onEvent(EventGeneric eventGeneric) {
        this.bandChangeEvent = eventGeneric.getReceiverEventId();
        super.onEvent(eventGeneric);
    }

    @Override
    public void onRecognizedEvent(int n) {
        this.bandChangeEvent = n;
        super.onRecognizedEvent(n);
    }

    @Override
    protected void reactOnRequest() {
        if (this.bandChangeEvent != -537183936) {
            this.bandChangeResponseArrived = false;
            this.nextUseCaseRequestArrived = false;
            this.alreadyActive = false;
            this.expectedBand = -1;
            if (this.bandChangeEvent == -604292800) {
                this.expectedBand = 0;
            } else if (this.bandChangeEvent == -587515584) {
                this.expectedBand = 1;
            } else if (this.bandChangeEvent == -570738368) {
                this.expectedBand = 2;
            } else if (this.bandChangeEvent == -553961152) {
                this.expectedBand = 3;
            }
            if (this.expectedBand != -1) {
                if (this.expectedBand != this.entertainmentSourceHandler.getCurrentBand()) {
                    if (this.logger.isTraceEnabled()) {
                        this.logger.trace(new StringBuffer().append("change to band ").append(this.expectedBand).toString());
                    }
                    this.entertainmentSourceHandler.changeToBand(this.expectedBand, this);
                } else {
                    if (this.logger.isTraceEnabled()) {
                        this.logger.trace(new StringBuffer().append("expected band ").append(this.expectedBand).append(" is already active").toString());
                    }
                    this.alreadyActive = true;
                }
            }
        }
    }

    private void startNextUseCase() {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace("select next use case to trigger");
        }
        if (this.serviceManager.getASLServices().getFeatureAvailabilityChecker().hasOnlyOneBand()) {
            if (this.logger.isTraceEnabled()) {
                this.logger.trace("there is only FM band, so the \"only one band\" logic will be executed");
            }
            if (this.serviceManager.getASLServices().getFeatureAvailabilityChecker().isFmByNameActive() && !this.amFmInterfaceHandler.isCacheEmpty()) {
                if (this.logger.isTraceEnabled()) {
                    this.logger.trace("start station selection dialog for FM only");
                }
                this.amFmInterfaceHandler.writeAnyStationIntoSelectedItem();
                this.serviceManager.getModelServices().sendEventToModel(86194688);
            } else if (this.serviceManager.getASLServices().getFeatureAvailabilityChecker().isFmFrequencyActive()) {
                if (this.logger.isTraceEnabled()) {
                    this.logger.trace("start frequency selection dialog for FM only");
                }
                this.serviceManager.getModelServices().sendEventToModel(102971904);
            } else if (this.serviceManager.getASLServices().getFeatureAvailabilityChecker().isFmHDFrequencyActive()) {
                if (this.logger.isTraceEnabled()) {
                    this.logger.trace("start HD frequency selection dialog for FM only");
                }
                this.serviceManager.getModelServices().sendEventToModel(237189632);
            } else {
                this.logger.warn("there is only FM band, but nothing is speakable in FM band, even though tuner itself is speakable");
                this.serviceManager.getModelServices().sendUnexpectedErrorEventToModel();
            }
        } else {
            if (this.logger.isTraceEnabled()) {
                this.logger.trace("use case following on band change will be selected similar to the \"select station\" logic");
            }
            this.selectStationAction.triggerManually();
        }
    }

    @Override
    protected void informModel() {
        if (this.serviceManager.getASLServices().getFeatureAvailabilityChecker().hasOnlyOneBand() || this.bandChangeEvent == -537183936) {
            if (this.logger.isTraceEnabled()) {
                this.logger.trace("next use case will follow on band change, wait for band change response");
            }
            this.nextUseCaseRequestArrived = true;
            if (this.bandChangeResponseArrived || this.serviceManager.getASLServices().getFeatureAvailabilityChecker().hasOnlyOneBand() || this.alreadyActive) {
                this.startNextUseCase();
            }
        } else if (this.bandChangeEvent == -621070016) {
            if (this.logger.isTraceEnabled()) {
                this.logger.trace("band change dialog requested");
            }
            this.serviceManager.getModelServices().sendEventToModel(-31311360);
        } else if (this.alreadyActive) {
            if (this.logger.isTraceEnabled()) {
                this.logger.trace("band change to active band requested");
            }
            this.serviceManager.getModelServices().sendEventToModel(69417472);
        } else if (this.expectedBand == 0) {
            if (this.logger.isTraceEnabled()) {
                this.logger.trace("band change to AM band");
            }
            this.serviceManager.getModelServices().sendEventToModel(-14534144);
        } else if (this.expectedBand == 1) {
            if (this.logger.isTraceEnabled()) {
                this.logger.trace("band change to FM band");
            }
            this.serviceManager.getModelServices().sendEventToModel(2308608);
        } else if (this.expectedBand == 2) {
            if (this.logger.isTraceEnabled()) {
                this.logger.trace("band change to DAB band");
            }
            this.serviceManager.getModelServices().sendEventToModel(19085824);
        } else if (this.expectedBand == 3) {
            if (this.siriusInterfaceHandler.isSubscribed()) {
                if (this.logger.isTraceEnabled()) {
                    this.logger.trace("band change to Sirius band");
                }
                this.serviceManager.getModelServices().sendEventToModel(35863040);
            } else {
                if (this.logger.isTraceEnabled()) {
                    this.logger.trace("band change to Sirius band even though Sirius is not subscribed");
                }
                this.serviceManager.getModelServices().sendEventToModel(52640256);
            }
        } else {
            this.logger.warn("band change lead to state with no useful use case option");
            this.serviceManager.getModelServices().sendUnexpectedErrorEventToModel();
        }
    }

    @Override
    public void onBandChanged() {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace("band change response has arrived, wait for next use case request");
        }
        this.bandChangeResponseArrived = true;
        if (this.nextUseCaseRequestArrived) {
            if (this.dialogStateHandler.isDialogActive()) {
                this.startNextUseCase();
            } else {
                this.logger.warn("band change response arrived but dialog has been closed meanwhile, do not send anything to model");
            }
        }
    }
}

