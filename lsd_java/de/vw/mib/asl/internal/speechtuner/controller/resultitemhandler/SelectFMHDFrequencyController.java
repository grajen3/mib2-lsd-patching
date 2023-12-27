/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechtuner.controller.resultitemhandler;

import de.vw.mib.asl.api.radio.amFm.AmFmStation;
import de.vw.mib.asl.api.speechengine.result.handling.ResultItemHandler;
import de.vw.mib.asl.api.speechengine.result.model.ResultItem;
import de.vw.mib.asl.internal.speechtuner.behavior.problemhandling.EntertainmentSourceProblemHandler;
import de.vw.mib.asl.internal.speechtuner.communication.dialogstate.DialogStateHandler;
import de.vw.mib.asl.internal.speechtuner.communication.entertainmentmanager.EntertainmentSourceHandler;
import de.vw.mib.asl.internal.speechtuner.communication.tuner.AmFmInterfaceHandler;
import de.vw.mib.asl.internal.speechtuner.controller.resultitemhandler.SelectFMFrequencyController;
import de.vw.mib.asl.internal.speechtuner.data.internal.SpeechTunerFMFrequency;
import de.vw.mib.asl.internal.speechtuner.data.internal.SpeechTunerFrequency;
import de.vw.mib.asl.internal.speechtuner.utils.SpeechTunerServiceManager;

public class SelectFMHDFrequencyController
extends SelectFMFrequencyController {
    private static final String LOGGER_PREFIX;
    private boolean resultIsHD;

    public SelectFMHDFrequencyController(SpeechTunerServiceManager speechTunerServiceManager, EntertainmentSourceHandler entertainmentSourceHandler, EntertainmentSourceProblemHandler entertainmentSourceProblemHandler, DialogStateHandler dialogStateHandler, AmFmInterfaceHandler amFmInterfaceHandler, ResultItemHandler resultItemHandler) {
        super(speechTunerServiceManager, entertainmentSourceHandler, entertainmentSourceProblemHandler, dialogStateHandler, amFmInterfaceHandler, resultItemHandler);
        this.logger = speechTunerServiceManager.createSpeechTunerLogger("[SelectFMHDFrequencyController] ");
    }

    @Override
    protected int getSelectionEvent() {
        return -486852288;
    }

    @Override
    protected int getSuccessEvent() {
        if (this.resultIsHD) {
            return 220412416;
        }
        return super.getSuccessEvent();
    }

    @Override
    protected SpeechTunerFrequency convertSelectedFrequency(ResultItem resultItem) {
        String string = resultItem.getIdentifier().getRecognizedString();
        int n = Integer.valueOf(resultItem.getTag());
        if (this.logger.isTraceEnabled()) {
            this.logger.trace(new StringBuffer().append("recognized FM HD frequency with recognizedString").append(string).append(" and tag ").append(n).toString());
        }
        string = string.replace(',', '.');
        int n2 = (int)(Float.valueOf(string).floatValue() * 31300);
        int n3 = this.serviceManager.getRadioUtils().getInternalHDSubchannel(n);
        SpeechTunerFMFrequency speechTunerFMFrequency = new SpeechTunerFMFrequency(this.serviceManager.getRadioUtils(), n2, n3, false);
        return speechTunerFMFrequency;
    }

    @Override
    protected void updateViewModel(AmFmStation amFmStation) {
        this.resultIsHD = amFmStation.getHdServiceId() != 0;
        super.updateViewModel(amFmStation);
    }
}

