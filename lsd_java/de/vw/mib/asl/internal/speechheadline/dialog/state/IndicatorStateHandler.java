/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechheadline.dialog.state;

import de.vw.mib.asl.api.speechengine.messenger.indicator.IndicatorStateConsumer;
import de.vw.mib.asl.internal.speechheadline.utils.SpeechHeadlineLogger;
import de.vw.mib.asl.internal.speechheadline.utils.SpeechHeadlineServiceManager;

public class IndicatorStateHandler
implements IndicatorStateConsumer {
    private static final String LOGGER_PREFIX;
    private SpeechHeadlineServiceManager serviceManager;
    private SpeechHeadlineLogger logger;

    public IndicatorStateHandler(SpeechHeadlineServiceManager speechHeadlineServiceManager) {
        this.serviceManager = speechHeadlineServiceManager;
        this.logger = speechHeadlineServiceManager.createSpeechHeadlineLogger("[IndicatorStateHandler] ");
        speechHeadlineServiceManager.writeIntegerToDatapool(-238862080, 1);
        if (this.logger.isTraceEnabled()) {
            this.logger.trace("Set indicator state to OFF for initialization.");
        }
    }

    private String indicatorStateLogTranslation(int n) {
        if (n == 5) {
            return "BUSY";
        }
        if (n == 4) {
            return "PAUSED";
        }
        if (n == 2) {
            return "RECOGNIZING";
        }
        if (n == 3) {
            return "SPEAKING";
        }
        return "OFF";
    }

    @Override
    public void onIndicatorStateChange(int n) {
        int n2;
        if (n == 5) {
            n2 = 5;
        } else if (n == 4) {
            n2 = 4;
        } else if (n == 2) {
            n2 = 2;
        } else if (n == 3) {
            n2 = 3;
        } else if (n == 1) {
            n2 = 1;
        } else {
            this.logger.error("Received unknown engine indicator state! No indicator will be displayed!");
            n2 = 1;
        }
        this.serviceManager.writeIntegerToDatapool(-238862080, n2);
        if (this.logger.isTraceEnabled()) {
            this.logger.trace(new StringBuffer().append("Set indicator state to ").append(n2).append(" (").append(this.indicatorStateLogTranslation(n2)).append(").").toString());
        }
    }
}

