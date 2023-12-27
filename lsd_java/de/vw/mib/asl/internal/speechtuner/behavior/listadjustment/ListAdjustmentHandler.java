/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechtuner.behavior.listadjustment;

import de.vw.mib.asl.api.speechengine.dialogmanager.DialogManager;
import de.vw.mib.asl.api.speechengine.result.router.ModelEventConsumer;
import de.vw.mib.asl.internal.speechtuner.utils.SpeechTunerLogger;
import de.vw.mib.asl.internal.speechtuner.utils.SpeechTunerServiceManager;
import de.vw.mib.genericevents.EventGeneric;

public class ListAdjustmentHandler
implements ModelEventConsumer {
    private static final String LOGGER_PREFIX;
    private final SpeechTunerLogger logger;
    private final DialogManager dialogManager;

    public ListAdjustmentHandler(SpeechTunerServiceManager speechTunerServiceManager, DialogManager dialogManager) {
        this.logger = speechTunerServiceManager.createSpeechTunerLogger("[ListAdjustmentHandler] ");
        this.dialogManager = dialogManager;
    }

    @Override
    public void onEvent(EventGeneric eventGeneric) {
        int n = eventGeneric.getReceiverEventId();
        if (n == -453297856) {
            this.handleAdjustmentStarted();
        } else {
            this.logger.warn(new StringBuffer().append("received unhandled event ").append(n).toString());
        }
    }

    private void handleAdjustmentStarted() {
        this.dialogManager.pauseSession();
        if (this.logger.isTraceEnabled()) {
            this.logger.trace("handle list adjustment");
        }
    }
}

