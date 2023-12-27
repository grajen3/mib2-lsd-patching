/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.util;

import de.vw.mib.log4mib.ClassifiedLogger;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.log4mib.Logger;

public abstract class AbstractClassifiedLogger
implements ClassifiedLogger {
    private final int subClassifier;
    private final String prefix;

    protected AbstractClassifiedLogger(int n, int n2) {
        this(n2);
    }

    protected AbstractClassifiedLogger(int n, int n2, String string) {
        this(n2, string);
    }

    protected AbstractClassifiedLogger(int n) {
        this(n, null);
    }

    protected AbstractClassifiedLogger(int n, String string) {
        this.subClassifier = n;
        this.prefix = string;
    }

    protected abstract Logger getLogger() {
    }

    public int getSubClassifier() {
        return this.subClassifier;
    }

    @Override
    public boolean isTraceEnabled() {
        Logger logger = this.getLogger();
        return null != logger && logger.isTraceEnabled(this.subClassifier);
    }

    @Override
    public LogMessage trace() {
        Logger logger = this.getLogger();
        return null != logger && logger.isTraceEnabled(this.subClassifier) ? this.appendPrefix(logger.trace(this.subClassifier)) : (LogMessage)null;
    }

    @Override
    public LogMessage normal() {
        Logger logger = this.getLogger();
        return null != logger ? this.appendPrefix(logger.normal(this.subClassifier)) : (LogMessage)null;
    }

    @Override
    public LogMessage info() {
        Logger logger = this.getLogger();
        return null != logger ? this.appendPrefix(logger.info(this.subClassifier)) : (LogMessage)null;
    }

    @Override
    public LogMessage warn() {
        Logger logger = this.getLogger();
        return null != logger ? this.appendPrefix(logger.warn(this.subClassifier)) : (LogMessage)null;
    }

    @Override
    public LogMessage error() {
        Logger logger = this.getLogger();
        return null != logger ? this.appendPrefix(logger.error(this.subClassifier)) : (LogMessage)null;
    }

    @Override
    public LogMessage fatal() {
        Logger logger = this.getLogger();
        return null != logger ? this.appendPrefix(logger.fatal(this.subClassifier)) : (LogMessage)null;
    }

    private LogMessage appendPrefix(LogMessage logMessage) {
        return null != this.prefix ? logMessage.append(this.prefix) : logMessage;
    }
}

