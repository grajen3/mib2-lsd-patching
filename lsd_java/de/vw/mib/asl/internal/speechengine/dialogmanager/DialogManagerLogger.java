/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.dialogmanager;

import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.log4mib.Logger;

public class DialogManagerLogger {
    public static final String LOGGER_PRE_PREFIX;
    public static final int DM_CLASSIFIER;
    private static Logger logger;
    private int loggerClassifier;
    private String loggerPrefix;

    public static void setStaticLogger(Logger logger) {
        DialogManagerLogger.logger = logger;
    }

    public DialogManagerLogger(int n, String string) {
        this.loggerClassifier = n;
        this.loggerPrefix = new StringBuffer().append("[[DM]]").append(string).toString();
    }

    public DialogManagerLogger(String string) {
        this(16, string);
    }

    public boolean isTraceEnabled() {
        return logger.isTraceEnabled(this.loggerClassifier);
    }

    public void trace(String string) {
        if (!logger.isTraceEnabled(this.loggerClassifier)) {
            return;
        }
        LogMessage logMessage = logger.trace(this.loggerClassifier);
        logMessage.append(this.loggerPrefix);
        logMessage.append(string);
        logMessage.log();
    }

    public void error(String string) {
        LogMessage logMessage = logger.error(this.loggerClassifier);
        logMessage.append(this.loggerPrefix);
        logMessage.append(string);
        logMessage.log();
    }

    public void warn(String string) {
        LogMessage logMessage = logger.warn(this.loggerClassifier);
        logMessage.append(this.loggerPrefix);
        logMessage.append(string);
        logMessage.log();
    }

    public void info(String string) {
        LogMessage logMessage = logger.info(this.loggerClassifier);
        logMessage.append(this.loggerPrefix);
        logMessage.append(string);
        logMessage.log();
    }

    public LogMessage trace() {
        LogMessage logMessage = logger.trace(this.loggerClassifier);
        logMessage.append(this.loggerPrefix);
        return logMessage;
    }

    public LogMessage info() {
        LogMessage logMessage = logger.info(this.loggerClassifier);
        logMessage.append(this.loggerPrefix);
        return logMessage;
    }

    public LogMessage warn() {
        LogMessage logMessage = logger.warn(this.loggerClassifier);
        logMessage.append(this.loggerPrefix);
        return logMessage;
    }

    static {
        logger = null;
    }
}

