/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.log4mib.internal;

import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.log4mib.internal.EmptyLoggerFactory$EmptyLogMessage;

public class EmptyLoggerFactory$EmptyLogger
implements Logger {
    LogMessage EMPTY_MESSAGE = new EmptyLoggerFactory$EmptyLogMessage();

    @Override
    public void emitOSEvent(int n, String string) {
    }

    @Override
    public LogMessage error(int n) {
        return this.EMPTY_MESSAGE;
    }

    @Override
    public void error(int n, String string) {
    }

    @Override
    public void error(int n, String string, Throwable throwable) {
    }

    @Override
    public LogMessage fatal(int n) {
        return this.EMPTY_MESSAGE;
    }

    @Override
    public void fatal(int n, String string) {
    }

    @Override
    public void fatal(int n, String string, Throwable throwable) {
    }

    @Override
    public LogMessage info(int n) {
        return this.EMPTY_MESSAGE;
    }

    @Override
    public void info(int n, String string) {
    }

    @Override
    public boolean isTraceEnabled(int n) {
        return false;
    }

    @Override
    public LogMessage normal(int n) {
        return this.EMPTY_MESSAGE;
    }

    @Override
    public void normal(int n, String string) {
    }

    @Override
    public LogMessage trace(int n) {
        return this.EMPTY_MESSAGE;
    }

    @Override
    public void trace(int n, String string) {
    }

    @Override
    public LogMessage warn(int n) {
        return this.EMPTY_MESSAGE;
    }

    @Override
    public void warn(int n, String string) {
    }
}

