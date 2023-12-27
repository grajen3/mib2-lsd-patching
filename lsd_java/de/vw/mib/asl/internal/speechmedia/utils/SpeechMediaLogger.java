/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechmedia.utils;

import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.log4mib.Logger;

public class SpeechMediaLogger {
    public static final String LOGGER_PRE_PREFIX;
    public static final int LOGGER_CLASSIFIER;
    private static Logger logger;
    private String loggerPrefix;

    public static void setLogger(Logger logger) {
        SpeechMediaLogger.logger = logger;
    }

    public SpeechMediaLogger(String string) {
        this.loggerPrefix = new StringBuffer().append("[[SM]]").append(string).toString();
    }

    public boolean isTraceEnabled() {
        return logger.isTraceEnabled(8192);
    }

    public void trace(String string) {
        if (!logger.isTraceEnabled(8192)) {
            return;
        }
        LogMessage logMessage = logger.trace(8192);
        this.logMessage(this.loggerPrefix, string, logMessage);
    }

    public void fatal(String string) {
        LogMessage logMessage = logger.fatal(8192);
        this.logMessage(this.loggerPrefix, string, logMessage);
    }

    public void error(String string) {
        LogMessage logMessage = logger.error(8192);
        this.logMessage(this.loggerPrefix, string, logMessage);
    }

    public void error(String string, Throwable throwable) {
        logger.error(8192, new StringBuffer().append(this.loggerPrefix).append(string).toString(), throwable);
    }

    public void warn(String string) {
        LogMessage logMessage = logger.warn(8192);
        this.logMessage(this.loggerPrefix, string, logMessage);
    }

    private void logMessage(String string, String string2, LogMessage logMessage) {
        logMessage.append(string);
        logMessage.append(string2);
        logMessage.log();
    }

    public LogMessage trace() {
        LogMessage logMessage = logger.trace(8192);
        logMessage.append(this.loggerPrefix);
        return logMessage;
    }

    public LogMessage error() {
        LogMessage logMessage = logger.error(8192);
        logMessage.append(this.loggerPrefix);
        return logMessage;
    }

    static {
        logger = null;
    }
}

