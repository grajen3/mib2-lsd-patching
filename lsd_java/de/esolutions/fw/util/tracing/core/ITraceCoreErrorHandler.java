/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.core;

import de.esolutions.fw.util.tracing.core.TraceCore;

public interface ITraceCoreErrorHandler {
    default public void errorShutdown(TraceCore traceCore, Throwable throwable) {
    }
}

