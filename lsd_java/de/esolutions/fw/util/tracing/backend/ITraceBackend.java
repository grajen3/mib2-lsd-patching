/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.backend;

import de.esolutions.fw.util.tracing.backend.ITraceBackendListener;
import de.esolutions.fw.util.tracing.config.TraceConfigBackend;
import de.esolutions.fw.util.tracing.entity.ITraceEntity;
import de.esolutions.fw.util.tracing.entity.TraceEntityURI;
import de.esolutions.fw.util.tracing.message.ITraceMessage;

public interface ITraceBackend {
    public static final int FLAGS_DECODE_MESSAGE;
    public static final int FLAGS_ACCEPT_BULK_LOG_DATA;
    public static final int FLAGS_ACCEPT_BULK_CREATE_ENTITY;
    public static final int FLAGS_ACCEPT_BULK_CHANGE_LEVEL;

    default public void init(short s, ITraceBackendListener iTraceBackendListener, TraceConfigBackend traceConfigBackend) {
    }

    default public void exit() {
    }

    default public String getName() {
    }

    default public int getFlags() {
    }

    default public boolean connect() {
    }

    default public void disconnect() {
    }

    default public short backendFilterLevel(ITraceEntity iTraceEntity) {
    }

    default public short backendDefaultFilterLevel(short s) {
    }

    default public boolean adjustToChangeLevel(ITraceEntity iTraceEntity) {
    }

    default public boolean createEntity(ITraceEntity iTraceEntity) {
    }

    default public boolean createEntityBulk(ITraceEntity[] iTraceEntityArray) {
    }

    default public boolean changeFilterLevel(TraceEntityURI traceEntityURI, short s) {
    }

    default public boolean changeFilterLevelBulk(ITraceEntity[] iTraceEntityArray) {
    }

    default public boolean log(ITraceMessage iTraceMessage) {
    }

    default public ITraceMessage logBulk(ITraceMessage[] iTraceMessageArray) {
    }

    default public boolean droppedMessages(int n) {
    }

    default public void handleBreak() {
    }

    default public boolean registerTimeZone(int n, int n2, String string) {
    }

    default public boolean updateTimeZone(int n, long l, long l2) {
    }
}

