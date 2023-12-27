/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.persistence.internal.persistence2.impl;

import de.vw.mib.asl.framework.internal.persistence.internal.debug.PersDebug;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.PersistenceLogger;

public final class PersistenceLoggerImpl
implements PersistenceLogger {
    public static PersistenceLoggerImpl INSTANCE = new PersistenceLoggerImpl();

    private PersistenceLoggerImpl() {
    }

    @Override
    public void trace(String string) {
        PersDebug.trace(string, true);
    }

    @Override
    public void info(String string) {
        PersDebug.info(string);
    }

    @Override
    public void warning(String string) {
        PersDebug.warn(string);
    }

    @Override
    public void error(String string) {
        Throwable throwable = null;
        PersDebug.error(string, throwable);
    }

    @Override
    public void error(String string, Throwable throwable) {
        PersDebug.error(string, throwable);
    }
}

