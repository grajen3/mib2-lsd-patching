/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.tracing;

import de.esolutions.fw.util.tracing.TraceChannel;
import de.esolutions.fw.util.tracing.TraceClient;

public interface Channels {
    public static final TraceChannel SERVICE_STATE = TraceClient.createTraceChannel("dsi.adapter.ServiceState");
    public static final TraceChannel LISTENER_TRACKER = TraceClient.createTraceChannel("dsi.adapter.ListenerTracker");
    public static final TraceChannel PROVIDER_TRACKER = TraceClient.createTraceChannel("dsi.adapter.ProviderTracker");
    public static final TraceChannel DSI_ADMIN = TraceClient.createTraceChannel("dsi.adapter.Admin");
    public static final TraceChannel DSI_PROVIDER = TraceClient.createTraceChannel("dsi.adapter.Provider");
    public static final TraceChannel DSI_DISPATCHER = TraceClient.createTraceChannel("dsi.adapter.Dispatcher");
    public static final TraceChannel CONFIG = TraceClient.createTraceChannel("dsi.adapter.Config");
    public static final TraceChannel SERVICEWORKER = TraceClient.createTraceChannel("dsi.adapter.ServiceWorker");
    public static final TraceChannel BENCH_STARTUP = TraceClient.createTraceChannel("BENCH.Startup");
}

