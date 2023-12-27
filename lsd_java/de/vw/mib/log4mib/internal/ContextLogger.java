/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.log4mib.internal;

import de.vw.mib.log4mib.LogLevel;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.log4mib.internal.LogWriterManager;
import de.vw.mib.log4mib.internal.MainLogger;
import de.vw.mib.log4mib.internal.MessageFactory;

final class ContextLogger
implements Logger,
LogLevel {
    private final MessageFactory factory;
    private final MainLogger logger;
    private final LogWriterManager logWriter;
    private int mainClassifier;
    private int subClassifierMask;

    ContextLogger(int n, MainLogger mainLogger, LogWriterManager logWriterManager, MessageFactory messageFactory) {
        this.mainClassifier = n;
        this.logger = mainLogger;
        this.logWriter = logWriterManager;
        this.factory = messageFactory;
    }

    @Override
    public void emitOSEvent(int n, String string) {
        this.logWriter.emitOSEvent(n, string);
    }

    @Override
    public LogMessage error(int n) {
        return this.factory.createLogMessage(2, this.mainClassifier, n);
    }

    @Override
    public void error(int n, String string) {
        this.logger.log(2, this.mainClassifier, n, string);
    }

    @Override
    public void error(int n, String string, Throwable throwable) {
        this.logger.log(2, this.mainClassifier, n, string, throwable);
    }

    @Override
    public LogMessage fatal(int n) {
        return this.factory.createLogMessage(1, this.mainClassifier, n);
    }

    @Override
    public void fatal(int n, String string) {
        this.logger.log(1, this.mainClassifier, n, string);
    }

    @Override
    public void fatal(int n, String string, Throwable throwable) {
        this.logger.log(1, this.mainClassifier, n, string, throwable);
    }

    @Override
    public LogMessage info(int n) {
        return this.factory.createLogMessage(8, this.mainClassifier, n);
    }

    @Override
    public void info(int n, String string) {
        this.logger.log(8, this.mainClassifier, n, string);
    }

    @Override
    public boolean isTraceEnabled(int n) {
        return (this.subClassifierMask & n) != 0;
    }

    @Override
    public LogMessage normal(int n) {
        return this.factory.createLogMessage(12, this.mainClassifier, n);
    }

    @Override
    public void normal(int n, String string) {
        this.logger.log(12, this.mainClassifier, n, string);
    }

    @Override
    public LogMessage trace(int n) {
        return this.factory.createLogMessage(16, this.mainClassifier, n);
    }

    @Override
    public void trace(int n, String string) {
        if (!this.isTraceEnabled(n)) {
            return;
        }
        this.logger.log(16, this.mainClassifier, n, string);
    }

    @Override
    public LogMessage warn(int n) {
        return this.factory.createLogMessage(4, this.mainClassifier, n);
    }

    @Override
    public void warn(int n, String string) {
        this.logger.log(4, this.mainClassifier, n, string);
    }

    int getTraceSubClassifierMask() {
        return this.subClassifierMask;
    }

    void setTraceSubClassifierMask(int n) {
        this.subClassifierMask = n;
    }
}

