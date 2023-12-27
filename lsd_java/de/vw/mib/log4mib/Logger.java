/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.log4mib;

import de.vw.mib.log4mib.LogMessage;

public interface Logger {
    default public LogMessage error(int n) {
    }

    default public void error(int n, String string) {
    }

    default public void error(int n, String string, Throwable throwable) {
    }

    default public LogMessage fatal(int n) {
    }

    default public void fatal(int n, String string) {
    }

    default public void fatal(int n, String string, Throwable throwable) {
    }

    default public LogMessage info(int n) {
    }

    default public void info(int n, String string) {
    }

    default public boolean isTraceEnabled(int n) {
    }

    default public LogMessage normal(int n) {
    }

    default public void normal(int n, String string) {
    }

    default public LogMessage trace(int n) {
    }

    default public void trace(int n, String string) {
    }

    default public LogMessage warn(int n) {
    }

    default public void warn(int n, String string) {
    }

    default public void emitOSEvent(int n, String string) {
    }
}

