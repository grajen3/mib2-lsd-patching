/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechtuner.utils.implementation;

import de.vw.mib.asl.internal.speechtuner.utils.SpeechTunerLogger;
import de.vw.mib.asl.internal.util.AbstractClassifiedLogger;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.log4mib.Logger;

public class SpeechTunerLoggerImpl
extends AbstractClassifiedLogger
implements SpeechTunerLogger {
    private static final String LOGGER_PRE_PREFIX;
    private static final int LOGGER_CLASSIFIER;
    private Logger logger;

    public SpeechTunerLoggerImpl(String string, Logger logger) {
        super(0x800000, new StringBuffer().append("[[ST]]").append(string).toString());
        this.logger = logger;
    }

    @Override
    public boolean isTraceEnabled() {
        return super.isTraceEnabled();
    }

    @Override
    public void trace(String string) {
        LogMessage logMessage = super.trace();
        this.logMessage(string, logMessage);
    }

    @Override
    public void fatal(String string) {
        LogMessage logMessage = super.fatal();
        this.logMessage(string, logMessage);
    }

    @Override
    public void error(String string) {
        LogMessage logMessage = super.error();
        this.logMessage(string, logMessage);
    }

    @Override
    public void warn(String string) {
        LogMessage logMessage = super.warn();
        this.logMessage(string, logMessage);
    }

    private void logMessage(String string, LogMessage logMessage) {
        logMessage.append(string);
        logMessage.log();
    }

    @Override
    protected Logger getLogger() {
        return this.logger;
    }
}

