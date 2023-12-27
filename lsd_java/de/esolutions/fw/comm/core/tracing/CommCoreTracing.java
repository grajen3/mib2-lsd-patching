/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.core.tracing;

import de.esolutions.fw.util.tracing.TraceChannel;
import de.esolutions.fw.util.tracing.TraceClient;

public interface CommCoreTracing {
    public static final TraceChannel PROTOCOL = TraceClient.createTraceChannel("comm.core.Protocol");
    public static final TraceChannel MESSAGE = TraceClient.createTraceChannel("comm.core.Message");
    public static final TraceChannel HANDSHAKE = TraceClient.createTraceChannel("comm.core.HandShake");
}

