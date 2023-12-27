/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.appadapter.speechsetup.utils;

import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.log4mib.Logger;

public class SpeechSetupLogger {
    private final String modulePrefix;
    private final Logger logger;
    private final int subClassifier;

    public SpeechSetupLogger(Logger logger, int n, String string) {
        this.modulePrefix = string;
        this.logger = logger;
        this.subClassifier = n;
    }

    public boolean isTraceEnabled() {
        return this.logger.isTraceEnabled(this.subClassifier);
    }

    public LogMessage warn() {
        LogMessage logMessage = this.logger.warn(this.subClassifier);
        logMessage.append(this.modulePrefix);
        return logMessage;
    }

    public LogMessage trace() {
        LogMessage logMessage = this.logger.trace(this.subClassifier);
        logMessage.append(this.modulePrefix);
        return logMessage;
    }

    public LogMessage error() {
        LogMessage logMessage = this.logger.error(this.subClassifier);
        logMessage.append(this.modulePrefix);
        return logMessage;
    }
}

