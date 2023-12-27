/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asi.impl;

import de.vw.mib.asi.impl.ClassifiedLoggerImpl$EmptyLogMessage;
import de.vw.mib.log4mib.ClassifiedLogger;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.log4mib.Logger;

class ClassifiedLoggerImpl
implements ClassifiedLogger {
    private final Logger logger;
    private final int subclassifier;
    private final String prefix;

    ClassifiedLoggerImpl(Logger logger, int n) {
        this(logger, n, null);
    }

    ClassifiedLoggerImpl(Logger logger, int n, String string) {
        this.logger = logger;
        this.subclassifier = n;
        this.prefix = string;
    }

    @Override
    public LogMessage error() {
        return null != this.logger ? this.appendPrefix(this.logger.error(this.subclassifier)) : ClassifiedLoggerImpl$EmptyLogMessage.INSTANCE;
    }

    @Override
    public LogMessage fatal() {
        return null != this.logger ? this.appendPrefix(this.logger.fatal(this.subclassifier)) : ClassifiedLoggerImpl$EmptyLogMessage.INSTANCE;
    }

    @Override
    public LogMessage info() {
        return null != this.logger ? this.appendPrefix(this.logger.info(this.subclassifier)) : ClassifiedLoggerImpl$EmptyLogMessage.INSTANCE;
    }

    @Override
    public boolean isTraceEnabled() {
        return null != this.logger && this.logger.isTraceEnabled(this.subclassifier);
    }

    @Override
    public LogMessage normal() {
        return null != this.logger ? this.appendPrefix(this.logger.normal(this.subclassifier)) : ClassifiedLoggerImpl$EmptyLogMessage.INSTANCE;
    }

    @Override
    public LogMessage trace() {
        return this.isTraceEnabled() ? this.appendPrefix(this.logger.trace(this.subclassifier)) : ClassifiedLoggerImpl$EmptyLogMessage.INSTANCE;
    }

    @Override
    public LogMessage warn() {
        return null != this.logger ? this.appendPrefix(this.logger.warn(this.subclassifier)) : ClassifiedLoggerImpl$EmptyLogMessage.INSTANCE;
    }

    private LogMessage appendPrefix(LogMessage logMessage) {
        return null != this.prefix ? logMessage.append(this.prefix) : logMessage;
    }
}

