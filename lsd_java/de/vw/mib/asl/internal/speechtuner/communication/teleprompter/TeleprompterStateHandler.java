/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechtuner.communication.teleprompter;

import de.vw.mib.asl.api.speechengine.teleprompter.TeleprompterManager;
import de.vw.mib.asl.api.speechengine.teleprompter.TeleprompterStateConsumer;
import de.vw.mib.asl.internal.speechtuner.utils.SpeechTunerLogger;
import de.vw.mib.asl.internal.speechtuner.utils.SpeechTunerServiceManager;

public class TeleprompterStateHandler
implements TeleprompterStateConsumer {
    private static final String LOGGER_PREFIX;
    protected SpeechTunerServiceManager serviceManager;
    protected SpeechTunerLogger logger;
    private final TeleprompterManager teleprompterManager;

    public TeleprompterStateHandler(SpeechTunerServiceManager speechTunerServiceManager, TeleprompterManager teleprompterManager) {
        this.serviceManager = speechTunerServiceManager;
        this.logger = speechTunerServiceManager.createSpeechTunerLogger("[TeleprompterStateHandler] ");
        this.teleprompterManager = teleprompterManager;
        teleprompterManager.register(this);
    }

    public void teleprompterButtonPressed() {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace("toggle teleprompter after button press");
        }
        this.teleprompterManager.toggle();
    }

    @Override
    public void onTeleprompterStateChanged(int n) {
        if (n == 0) {
            if (this.logger.isTraceEnabled()) {
                this.logger.trace("show teleprompter");
            }
            this.serviceManager.getModelServices().writeIntegerToDatapool(-652068352, 0);
        } else {
            if (this.logger.isTraceEnabled()) {
                this.logger.trace("hide teleprompter");
            }
            this.serviceManager.getModelServices().writeIntegerToDatapool(-652068352, 1);
        }
    }
}

