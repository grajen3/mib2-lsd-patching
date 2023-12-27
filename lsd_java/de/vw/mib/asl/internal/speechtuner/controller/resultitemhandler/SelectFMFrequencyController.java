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
import de.vw.mib.asl.internal.speechtuner.data.internal.SpeechTunerFMFrequency;
import de.vw.mib.asl.internal.speechtuner.data.internal.SpeechTunerFrequency;
import de.vw.mib.asl.internal.speechtuner.utils.SpeechTunerServiceManager;

public class SelectFMFrequencyController
extends TunerFrequencyController {
    private static final String LOGGER_PREFIX;

    public SelectFMFrequencyController(SpeechTunerServiceManager speechTunerServiceManager, EntertainmentSourceHandler entertainmentSourceHandler, EntertainmentSourceProblemHandler entertainmentSourceProblemHandler, DialogStateHandler dialogStateHandler, AmFmInterfaceHandler amFmInterfaceHandler, ResultItemHandler resultItemHandler) {
        super(speechTunerServiceManager, entertainmentSourceHandler, entertainmentSourceProblemHandler, dialogStateHandler, amFmInterfaceHandler, resultItemHandler, 2);
        this.logger = speechTunerServiceManager.createSpeechTunerLogger("[SelectFMFrequencyController] ");
    }

    @Override
    protected int getSelectionEvent() {
        return -637847232;
    }

    @Override
    protected int getSuccessEvent() {
        return -64865792;
    }

    @Override
    protected SpeechTunerFrequency convertSelectedFrequency(ResultItem resultItem) {
        String string = resultItem.getIdentifier().getRecognizedString();
        if (this.logger.isTraceEnabled()) {
            this.logger.trace(new StringBuffer().append("recognized FM frequency with recognizedString").append(string).toString());
        }
        string = string.replace(',', '.');
        int n = (int)(Float.valueOf(string).floatValue() * 31300);
        SpeechTunerFMFrequency speechTunerFMFrequency = new SpeechTunerFMFrequency(this.serviceManager.getRadioUtils(), n, 0, false);
        return speechTunerFMFrequency;
    }

    @Override
    protected void updateViewModel(AmFmStation amFmStation) {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace(new StringBuffer().append("filling FM frequency ").append(amFmStation.getFrequency()).append(" kHz with HD subchannel ").append(amFmStation.getHdServiceId()).append(" into viewmodel").toString());
        }
        boolean bl = false;
        if (amFmStation.getHdServiceId() == 1) {
            bl = this.amFmInterface.isMPS(amFmStation.getFrequency());
        }
        Object[] objectArray = new SpeechTunerFMFrequency[]{this.serviceManager.getRadioUtils().createInternalFMFrequency(amFmStation, bl)};
        GenericASLList genericASLList = this.serviceManager.getModelServices().getGenericASLList(-568182272);
        if (genericASLList != null) {
            genericASLList.updateList(objectArray);
        } else {
            this.logger.error("ASL list for FM Frequency was null.");
        }
    }
}

