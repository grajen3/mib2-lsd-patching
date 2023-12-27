/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechtuner.behavior.problemhandling;

import de.vw.mib.asl.internal.speechtuner.behavior.problemhandling.EntertainmentSourceProblemHandler;
import de.vw.mib.asl.internal.speechtuner.communication.entertainmentmanager.EntertainmentSourceHandler;
import de.vw.mib.asl.internal.speechtuner.communication.tuner.AmFmInterfaceHandler;
import de.vw.mib.asl.internal.speechtuner.utils.SpeechTunerServiceManager;

public class StationListProblemHandler
extends EntertainmentSourceProblemHandler {
    private static final String LOGGER_PREFIX;
    private boolean isCacheEmpty = true;

    public StationListProblemHandler(SpeechTunerServiceManager speechTunerServiceManager, EntertainmentSourceHandler entertainmentSourceHandler, AmFmInterfaceHandler amFmInterfaceHandler) {
        super(speechTunerServiceManager, entertainmentSourceHandler, amFmInterfaceHandler);
        this.logger = speechTunerServiceManager.createSpeechTunerLogger("[StationListProblemHandler] ");
    }

    public void updateCacheState(boolean bl) {
        this.isCacheEmpty = bl;
    }

    protected boolean hasSpeakableStations() {
        if (this.isCacheEmpty) {
            if (this.logger.isTraceEnabled()) {
                String string = "UNKNOWN";
                if (this.entertainmentSourceHandler.getCurrentBand() == 1) {
                    string = "FM";
                } else if (this.entertainmentSourceHandler.getCurrentBand() == 0) {
                    string = "AM";
                } else if (this.entertainmentSourceHandler.getCurrentBand() == 2) {
                    string = "DAB";
                } else if (this.entertainmentSourceHandler.getCurrentBand() == 3) {
                    string = "Sirius";
                }
                this.logger.trace(new StringBuffer().append("command which needs speakable stations has been recognized, but no stations are speakable for ").append(string).append(" band").toString());
            }
            this.serviceManager.getModelServices().sendEventToModel(-450741760);
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
        if (bl) {
            bl = this.hasSpeakableStations();
        }
        return bl;
    }
}

