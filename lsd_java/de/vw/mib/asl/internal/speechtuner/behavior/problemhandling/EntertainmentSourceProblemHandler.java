/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechtuner.behavior.problemhandling;

import de.vw.mib.asl.internal.speechtuner.behavior.problemhandling.TunerProblemHandler;
import de.vw.mib.asl.internal.speechtuner.communication.entertainmentmanager.EntertainmentSourceHandler;
import de.vw.mib.asl.internal.speechtuner.communication.tuner.AmFmInterfaceHandler;
import de.vw.mib.asl.internal.speechtuner.utils.SpeechTunerServiceManager;

public class EntertainmentSourceProblemHandler
extends TunerProblemHandler {
    private static final String LOGGER_PREFIX;

    public EntertainmentSourceProblemHandler(SpeechTunerServiceManager speechTunerServiceManager, EntertainmentSourceHandler entertainmentSourceHandler, AmFmInterfaceHandler amFmInterfaceHandler) {
        super(speechTunerServiceManager, entertainmentSourceHandler, amFmInterfaceHandler);
        this.logger = speechTunerServiceManager.createSpeechTunerLogger("[EntertainmentSourceProblemHandler] ");
    }

    protected boolean isEntertainmentSourceTuner() {
        if (!this.entertainmentSourceHandler.isRadioCurrentEntertainmentSource()) {
            if (this.logger.isTraceEnabled()) {
                this.logger.trace("tuner command recognized while entertainment source was not tuner, changing entertainment source now");
            }
            this.entertainmentSourceHandler.changeToRadio();
            return false;
        }
        return true;
    }

    @Override
    public boolean isProblemCheckSuccessful() {
        boolean bl = this.isTunerAvailable();
        if (bl) {
            bl = this.isEntertainmentSourceTuner();
        }
        return bl;
    }
}

