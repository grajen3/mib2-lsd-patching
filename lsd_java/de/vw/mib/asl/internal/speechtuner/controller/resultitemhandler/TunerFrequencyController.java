/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechtuner.controller.resultitemhandler;

import de.vw.mib.asl.api.radio.amFm.AmFmStation;
import de.vw.mib.asl.api.radio.speech.TuningResponse;
import de.vw.mib.asl.api.radio.speech.amfm.AmFmTuningResponse;
import de.vw.mib.asl.api.speechengine.result.handling.ResultItemControllerBase;
import de.vw.mib.asl.api.speechengine.result.handling.ResultItemHandler;
import de.vw.mib.asl.api.speechengine.result.model.ResultItem;
import de.vw.mib.asl.api.speechengine.result.router.RecognizedEventConsumer;
import de.vw.mib.asl.internal.speechtuner.behavior.problemhandling.EntertainmentSourceProblemHandler;
import de.vw.mib.asl.internal.speechtuner.communication.dialogstate.DialogStateHandler;
import de.vw.mib.asl.internal.speechtuner.communication.entertainmentmanager.EntertainmentSourceHandler;
import de.vw.mib.asl.internal.speechtuner.communication.tuner.AmFmInterfaceHandler;
import de.vw.mib.asl.internal.speechtuner.data.internal.SpeechTunerFrequency;
import de.vw.mib.asl.internal.speechtuner.utils.SpeechTunerLogger;
import de.vw.mib.asl.internal.speechtuner.utils.SpeechTunerServiceManager;
import de.vw.mib.asl.internal.speechtuner.utils.callbacks.EntertainmentSourceCallback;
import de.vw.mib.asl.internal.speechtuner.utils.callbacks.TuningCallback;

public abstract class TunerFrequencyController
extends ResultItemControllerBase
implements RecognizedEventConsumer,
TuningCallback,
EntertainmentSourceCallback {
    private static final String LOGGER_PREFIX;
    protected SpeechTunerServiceManager serviceManager;
    protected SpeechTunerLogger logger;
    protected final DialogStateHandler dialogStateHandler;
    protected final EntertainmentSourceProblemHandler problemHandler;
    protected final int usecase;
    protected int continuedEvent;
    protected final AmFmInterfaceHandler amFmInterface;
    protected final EntertainmentSourceHandler entertainmentSourceHandler;

    public TunerFrequencyController(SpeechTunerServiceManager speechTunerServiceManager, EntertainmentSourceHandler entertainmentSourceHandler, EntertainmentSourceProblemHandler entertainmentSourceProblemHandler, DialogStateHandler dialogStateHandler, AmFmInterfaceHandler amFmInterfaceHandler, ResultItemHandler resultItemHandler, int n) {
        super(resultItemHandler);
        this.serviceManager = speechTunerServiceManager;
        this.logger = speechTunerServiceManager.createSpeechTunerLogger("[TunerFrequencyController] ");
        this.entertainmentSourceHandler = entertainmentSourceHandler;
        this.problemHandler = entertainmentSourceProblemHandler;
        this.dialogStateHandler = dialogStateHandler;
        this.amFmInterface = amFmInterfaceHandler;
        this.usecase = n;
    }

    protected boolean doProblemCheck(int n) {
        this.continuedEvent = n;
        return this.problemHandler.isProblemCheckSuccessful();
    }

    protected abstract int getSelectionEvent() {
    }

    protected abstract int getSuccessEvent() {
    }

    @Override
    public void onActivateRadio() {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace("continue frequency use case since radio is active now (radio was active after continue request)");
        }
        if (this.dialogStateHandler.isDialogActive()) {
            this.onRecognizedEvent(this.continuedEvent);
        } else {
            this.logger.warn("radio is active now but dialog has been closed meanwhile, do not send anything to model");
        }
    }

    @Override
    public void onRecognizedEvent(int n) {
        if (!this.entertainmentSourceHandler.isRadioCurrentEntertainmentSource()) {
            this.entertainmentSourceHandler.registerForNextSourceChange(this);
            this.doProblemCheck(n);
        } else if (n == this.getSelectionEvent()) {
            if (this.logger.isTraceEnabled()) {
                this.logger.trace(new StringBuffer().append(this.entertainmentSourceHandler.getCurrentBandText()).append(" frequency has been selected with direct command").toString());
            }
            this.problemHandler.setCurrentUseCase(this.usecase);
            if (this.doProblemCheck(this.getSelectionEvent())) {
                super.onResult();
            }
        }
    }

    protected abstract SpeechTunerFrequency convertSelectedFrequency(ResultItem resultItem) {
    }

    private void tuneFrequency(SpeechTunerFrequency speechTunerFrequency) {
        this.amFmInterface.tuneFrequency(this, speechTunerFrequency);
    }

    @Override
    public void notifyResultCompleted(ResultItem resultItem) {
        SpeechTunerFrequency speechTunerFrequency = this.convertSelectedFrequency(resultItem);
        this.tuneFrequency(speechTunerFrequency);
    }

    protected abstract void updateViewModel(AmFmStation amFmStation) {
    }

    @Override
    public void onTuningResponse(TuningResponse tuningResponse) {
        if (this.dialogStateHandler.isDialogActive()) {
            if (tuningResponse == null || !(tuningResponse instanceof AmFmTuningResponse)) {
                this.serviceManager.getModelServices().sendEventToModel(-48088576);
            } else {
                AmFmTuningResponse amFmTuningResponse = (AmFmTuningResponse)tuningResponse;
                if (amFmTuningResponse.getResultState() == 1) {
                    this.updateViewModel(amFmTuningResponse.getAmFmStation());
                    this.serviceManager.getModelServices().sendEventToModel(this.getSuccessEvent());
                } else {
                    this.serviceManager.getModelServices().sendEventToModel(-48088576);
                }
            }
        } else {
            this.logger.warn("tuning response for frequency has arrived but dialog has been closed meanwhile, do not send anything to model");
        }
    }
}

