/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing;

import de.esolutions.fw.util.tracing.TraceChannel;

public interface ITraceClient {
    default public boolean enableChannel(TraceChannel traceChannel) {
    }

    default public boolean disableChannel(TraceChannel traceChannel) {
    }

    default public boolean logMessage(TraceChannel traceChannel, short s, short s2, String string, Object[] objectArray) {
    }

    default public boolean logMessage(TraceChannel traceChannel, short s, short s2, short s3, byte[] byArray) {
    }

    default public boolean registerChannel(TraceChannel traceChannel) {
    }

    default public boolean unregisterChannel(TraceChannel traceChannel) {
    }

    default public boolean changeChannelFilterLevel(TraceChannel traceChannel, short s) {
    }
}

