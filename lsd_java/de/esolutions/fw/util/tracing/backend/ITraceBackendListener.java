/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.backend;

import de.esolutions.fw.util.tracing.entity.TraceEntityURI;
import de.esolutions.fw.util.tracing.format.ITraceEntityResolver;
import de.esolutions.fw.util.tracing.format.ITraceMessageFormatter;

public interface ITraceBackendListener {
    default public void connected(short s, boolean bl) {
    }

    default public void disconnected(short s) {
    }

    default public boolean triggerRequestFilterLevel(TraceEntityURI traceEntityURI, short s) {
    }

    default public boolean triggerExecuteCallback(int n, byte[] byArray) {
    }

    default public short queryFilterLevel(TraceEntityURI traceEntityURI) {
    }

    default public void logMessage(short s, String string) {
    }

    default public int getCoreMaxEntities() {
    }

    default public String getCoreId() {
    }

    default public void requestQuit() {
    }

    default public ITraceMessageFormatter createFormatter(String string, boolean bl) {
    }

    default public ITraceEntityResolver getEntityResolver() {
    }

    default public String getTimeZoneName(int n) {
    }

    default public Object getComponent(String string) {
    }
}

