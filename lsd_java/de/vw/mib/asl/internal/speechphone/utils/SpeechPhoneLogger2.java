/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechphone.utils;

import de.vw.mib.asl.internal.util.AbstractClassifiedLogger;
import de.vw.mib.log4mib.LogMessage;

public class SpeechPhoneLogger2 {
    public static final String LOGGER_PRE_PREFIX;
    public static final int LOGGER_CLASSIFIER;
    public final AbstractClassifiedLogger logger;
    private String loggerPrefix;

    public SpeechPhoneLogger2(AbstractClassifiedLogger abstractClassifiedLogger, String string) {
        this.loggerPrefix = new StringBuffer().append("[[SP]] ").append(string).append(": ").toString();
        this.logger = abstractClassifiedLogger;
    }

    public boolean isTraceEnabled() {
        return this.logger.isTraceEnabled();
    }

    public void trace(String string) {
        LogMessage logMessage = this.logger.trace();
        this.logMessage(this.loggerPrefix, string, logMessage);
    }

    public void fatal(String string) {
        LogMessage logMessage = this.logger.fatal();
        this.logMessage(this.loggerPrefix, string, logMessage);
    }

    public void error(String string) {
        LogMessage logMessage = this.logger.error();
        this.logMessage(this.loggerPrefix, string, logMessage);
    }

    public void warn(String string) {
        LogMessage logMessage = this.logger.warn();
        this.logMessage(this.loggerPrefix, string, logMessage);
    }

    private void logMessage(String string, String string2, LogMessage logMessage) {
        logMessage.append(string);
        logMessage.append(string2);
        logMessage.log();
    }
}

