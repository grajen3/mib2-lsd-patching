/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechtuner.behavior.problemhandling;

import de.vw.mib.asl.internal.speechtuner.communication.entertainmentmanager.EntertainmentSourceHandler;
import de.vw.mib.asl.internal.speechtuner.communication.tuner.AmFmInterfaceHandler;
import de.vw.mib.asl.internal.speechtuner.utils.SpeechTunerLogger;
import de.vw.mib.asl.internal.speechtuner.utils.SpeechTunerServiceManager;

public class TunerProblemHandler {
    private static final String LOGGER_PREFIX;
    protected SpeechTunerServiceManager serviceManager;
    protected SpeechTunerLogger logger;
    protected final EntertainmentSourceHandler entertainmentSourceHandler;
    protected final AmFmInterfaceHandler amFmInterfaceHandler;

    public TunerProblemHandler(SpeechTunerServiceManager speechTunerServiceManager, EntertainmentSourceHandler entertainmentSourceHandler, AmFmInterfaceHandler amFmInterfaceHandler) {
        this.serviceManager = speechTunerServiceManager;
        this.logger = speechTunerServiceManager.createSpeechTunerLogger("[TunerProblemHandler] ");
        this.entertainmentSourceHandler = entertainmentSourceHandler;
        this.amFmInterfaceHandler = amFmInterfaceHandler;
    }

    protected boolean isTunerAvailable() {
        if (this.entertainmentSourceHandler == null || !this.entertainmentSourceHandler.isReady() || this.amFmInterfaceHandler == null || !this.amFmInterfaceHandler.isReady()) {
            this.logger.warn("tuner speech command has been recognized but tuner and/or entertainment manager are not available");
            this.serviceManager.getModelServices().sendEventToModel(-467518976);
            return false;
        }
        return true;
    }

    public boolean isProblemCheckSuccessful() {
        return this.isTunerAvailable();
    }

    public void setCurrentUseCase(int n) {
        this.serviceManager.getModelServices().writeIntegerToDatapool(-786286080, n);
    }

    public void setContinueUseCase() {
        this.serviceManager.getModelServices().writeIntegerToDatapool(-786286080, 7);
    }
}

