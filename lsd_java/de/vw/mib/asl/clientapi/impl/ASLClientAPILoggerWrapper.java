/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.clientapi.impl;

import de.vw.mib.log4mib.ClassifiedLogger;
import de.vw.mib.log4mib.LogMessage;

class ASLClientAPILoggerWrapper
implements ClassifiedLogger {
    private final ClassifiedLogger clogger;
    private final String prefix;

    ASLClientAPILoggerWrapper(ClassifiedLogger classifiedLogger, String string, int n) {
        this.clogger = classifiedLogger;
        this.prefix = new StringBuffer().append("(").append(string).append("[").append(n).append("]) ").toString();
    }

    @Override
    public boolean isTraceEnabled() {
        return this.clogger.isTraceEnabled();
    }

    @Override
    public LogMessage trace() {
        return this.wrap(this.clogger.trace());
    }

    @Override
    public LogMessage normal() {
        return this.wrap(this.clogger.normal());
    }

    @Override
    public LogMessage info() {
        return this.wrap(this.clogger.info());
    }

    @Override
    public LogMessage warn() {
        return this.wrap(this.clogger.warn());
    }

    @Override
    public LogMessage error() {
        return this.wrap(this.clogger.error());
    }

    @Override
    public LogMessage fatal() {
        return this.wrap(this.clogger.fatal());
    }

    private LogMessage wrap(LogMessage logMessage) {
        return null != logMessage ? logMessage.append(this.prefix) : null;
    }
}

