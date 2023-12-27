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
import de.vw.mib.asl.internal.speechtuner.controller.resultitemhandler.SelectAMFrequencyController;
import de.vw.mib.asl.internal.speechtuner.data.internal.SpeechTunerAMFrequency;
import de.vw.mib.asl.internal.speechtuner.data.internal.SpeechTunerFrequency;
import de.vw.mib.asl.internal.speechtuner.utils.SpeechTunerServiceManager;

public class SelectAMHDFrequencyController
extends SelectAMFrequencyController {
    private static final String LOGGER_PREFIX;
    private boolean resultIsHD;

    public SelectAMHDFrequencyController(SpeechTunerServiceManager speechTunerServiceManager, EntertainmentSourceHandler entertainmentSourceHandler, EntertainmentSourceProblemHandler entertainmentSourceProblemHandler, DialogStateHandler dialogStateHandler, AmFmInterfaceHandler amFmInterfaceHandler, ResultItemHandler resultItemHandler) {
        super(speechTunerServiceManager, entertainmentSourceHandler, entertainmentSourceProblemHandler, dialogStateHandler, amFmInterfaceHandler, resultItemHandler);
        this.logger = speechTunerServiceManager.createSpeechTunerLogger("[SelectAMHDFrequencyController] ");
    }

    @Override
    protected int getSelectionEvent() {
        return -503629504;
    }

    @Override
    protected int getSuccessEvent() {
        if (this.resultIsHD) {
            return 186857984;
        }
        return super.getSuccessEvent();
    }

    @Override
    protected SpeechTunerFrequency convertSelectedFrequency(ResultItem resultItem) {
        String string = resultItem.getIdentifier().getRecognizedString();
        int n = Integer.valueOf(resultItem.getTag());
        if (this.logger.isTraceEnabled()) {
            this.logger.trace(new StringBuffer().append("recognized AM HD frequency with recognizedString").append(string).append(" and tag ").append(n).toString());
        }
        int n2 = Integer.valueOf(string);
        int n3 = this.serviceManager.getRadioUtils().getInternalHDSubchannel(n);
        SpeechTunerAMFrequency speechTunerAMFrequency = new SpeechTunerAMFrequency(this.serviceManager.getRadioUtils(), n2, n3);
        return speechTunerAMFrequency;
    }

    @Override
    protected void updateViewModel(AmFmStation amFmStation) {
        this.resultIsHD = amFmStation.getHdServiceId() != 0;
        super.updateViewModel(amFmStation);
    }
}

