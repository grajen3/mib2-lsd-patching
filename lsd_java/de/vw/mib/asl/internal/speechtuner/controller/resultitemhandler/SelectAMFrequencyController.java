/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechtuner.controller.resultitemhandler;

import de.vw.mib.asl.api.radio.amFm.AmFmStation;
import de.vw.mib.asl.api.speechengine.result.handling.ResultItemHandler;
import de.vw.mib.asl.api.speechengine.result.model.ResultItem;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.speechtuner.behavior.problemhandling.EntertainmentSourceProblemHandler;
import de.vw.mib.asl.internal.speechtuner.communication.dialogstate.DialogStateHandler;
import de.vw.mib.asl.internal.speechtuner.communication.entertainmentmanager.EntertainmentSourceHandler;
import de.vw.mib.asl.internal.speechtuner.communication.tuner.AmFmInterfaceHandler;
import de.vw.mib.asl.internal.speechtuner.controller.resultitemhandler.TunerFrequencyController;
import de.vw.mib.asl.internal.speechtuner.data.internal.SpeechTunerAMFrequency;
import de.vw.mib.asl.internal.speechtuner.data.internal.SpeechTunerFrequency;
import de.vw.mib.asl.internal.speechtuner.utils.SpeechTunerServiceManager;

public class SelectAMFrequencyController
extends TunerFrequencyController {
    private static final String LOGGER_PREFIX;

    public SelectAMFrequencyController(SpeechTunerServiceManager speechTunerServiceManager, EntertainmentSourceHandler entertainmentSourceHandler, EntertainmentSourceProblemHandler entertainmentSourceProblemHandler, DialogStateHandler dialogStateHandler, AmFmInterfaceHandler amFmInterfaceHandler, ResultItemHandler resultItemHandler) {
        super(speechTunerServiceManager, entertainmentSourceHandler, entertainmentSourceProblemHandler, dialogStateHandler, amFmInterfaceHandler, resultItemHandler, 2);
        this.logger = speechTunerServiceManager.createSpeechTunerLogger("[SelectAMFrequencyController] ");
    }

    @Override
    protected int getSelectionEvent() {
        return -654624448;
    }

    @Override
    protected int getSuccessEvent() {
        return -98420224;
    }

    @Override
    protected SpeechTunerFrequency convertSelectedFrequency(ResultItem resultItem) {
        String string = resultItem.getIdentifier().getRecognizedString();
        if (this.logger.isTraceEnabled()) {
            this.logger.trace(new StringBuffer().append("recognized AM frequency with recognizedString").append(string).toString());
        }
        int n = Integer.valueOf(string);
        SpeechTunerAMFrequency speechTunerAMFrequency = new SpeechTunerAMFrequency(this.serviceManager.getRadioUtils(), n, 0);
        return speechTunerAMFrequency;
    }

    @Override
    protected void updateViewModel(AmFmStation amFmStation) {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace(new StringBuffer().append("filling AM frequency ").append(amFmStation.getFrequency()).append(" kHz with HD subchannel ").append(amFmStation.getHdServiceId()).append(" into viewmodel").toString());
        }
        Object[] objectArray = new SpeechTunerAMFrequency[]{this.serviceManager.getRadioUtils().createInternalAMFrequency(amFmStation)};
        GenericASLList genericASLList = this.serviceManager.getModelServices().getGenericASLList(-584959488);
        if (genericASLList != null) {
            genericASLList.updateList(objectArray);
        } else {
            this.logger.error("ASL list for AM Frequency was null.");
        }
    }
}

