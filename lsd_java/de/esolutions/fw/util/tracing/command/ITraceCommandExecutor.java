/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.command;

import de.esolutions.fw.util.tracing.backend.ITraceBackend;
import de.esolutions.fw.util.tracing.config.TraceConfigBackend;
import de.esolutions.fw.util.tracing.entity.TraceEntityURI;
import de.esolutions.fw.util.tracing.model.TraceEntity;
import de.esolutions.fw.util.tracing.timezone.TraceTimeZone;

public interface ITraceCommandExecutor {
    default public void activateBackend(ITraceBackend iTraceBackend) {
    }

    default public void createEntity(int n, TraceEntity traceEntity, short s) {
    }

    default public void changeFilterLevel(int n, TraceEntity traceEntity, short s) {
    }

    default public void executeCallback(int n, byte[] byArray) {
    }

    default public void requestFilterLevel(TraceEntityURI traceEntityURI, short s) {
    }

    default public void connectBackend(short s, boolean bl) {
    }

    default public void disconnectBackend(short s) {
    }

    default public void registerBackend(ITraceBackend iTraceBackend, TraceConfigBackend traceConfigBackend, String string) {
    }

    default public void unregisterBackend(ITraceBackend iTraceBackend) {
    }

    default public boolean flushMessages() {
    }

    default public void flushEntities() {
    }

    default public void requestQuit() {
    }

    default public void quit() {
    }

    default public void init() {
    }

    default public void registerTimeZone(int n, TraceTimeZone traceTimeZone) {
    }

    default public void updateTimeZone(TraceTimeZone traceTimeZone) {
    }

    default public void resizeBuffer(int n) {
    }
}

