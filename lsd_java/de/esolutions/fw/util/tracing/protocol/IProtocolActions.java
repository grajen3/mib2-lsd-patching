/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.protocol;

import de.esolutions.fw.util.tracing.entity.IExternalTraceEntity;
import de.esolutions.fw.util.tracing.entity.TraceEntityURI;
import de.esolutions.fw.util.tracing.message.ITraceMessage;

public interface IProtocolActions {
    default public boolean handleInit(String string, int n) {
    }

    default public boolean handlePassiveInit() {
    }

    default public void handleExit() {
    }

    default public boolean handleCreateEntity(IExternalTraceEntity iExternalTraceEntity) {
    }

    default public boolean handleLogData(ITraceMessage iTraceMessage) {
    }

    default public boolean handleChangeLevel(TraceEntityURI traceEntityURI, short s) {
    }

    default public boolean handleExecuteCallback(int n, byte[] byArray) {
    }

    default public boolean handleDroppedData(int n) {
    }

    default public boolean handleToggleEntity(TraceEntityURI traceEntityURI, boolean bl) {
    }

    default public boolean handleRegisterTimezone(int n, int n2, String string) {
    }

    default public boolean handleUpdateTimezone(int n, long l, long l2) {
    }

    default public boolean handleFileRequestMessage(int n, String string, byte by) {
    }

    default public boolean handleFileStatusMessage(int n, String string, byte by, long l, long l2, byte by2, byte[] byArray) {
    }

    default public boolean handleFileTransferMessage(int n, int n2, byte by, int n3, byte[] byArray) {
    }
}

