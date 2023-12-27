/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.core;

import de.esolutions.fw.util.tracing.config.TraceConfig;
import de.esolutions.fw.util.tracing.core.TraceCoreStats;
import de.esolutions.fw.util.tracing.entity.TraceEntityURI;
import de.esolutions.fw.util.tracing.entity.TraceEntityURIWithLevel;
import de.esolutions.fw.util.tracing.frontend.ITraceFrontendListener;
import de.esolutions.fw.util.tracing.frontend.TraceFrontend;

public class TraceCoreStatsLogger
implements ITraceFrontendListener {
    private final TraceFrontend frontend;
    private final TraceCoreStats stats;
    private final TraceConfig config;
    private final int channel;
    private final int thread;
    private final int callback;

    public TraceCoreStatsLogger(TraceConfig traceConfig, TraceFrontend traceFrontend, TraceCoreStats traceCoreStats) {
        this.frontend = traceFrontend;
        this.stats = traceCoreStats;
        this.config = traceConfig;
        TraceEntityURIWithLevel traceEntityURIWithLevel = traceFrontend.createChannelPath("FW.Tracing.Statistics", (short)0);
        this.channel = traceEntityURIWithLevel != null ? traceEntityURIWithLevel.getId() : -1;
        traceEntityURIWithLevel = traceFrontend.createThread("traceCore", (short)0);
        this.thread = traceEntityURIWithLevel != null ? traceEntityURIWithLevel.getId() : -1;
        this.callback = traceFrontend.createCallback("setCoreStatisticsInterval");
        traceFrontend.registerListener(this);
    }

    public void log() {
        String string;
        if (this.channel != -1 && this.thread != -1 && (string = this.stats.readValues()) != null) {
            this.frontend.log(this.channel, this.thread, (short)2, (short)0, string);
        }
    }

    @Override
    public void executeCallback(int n, byte[] byArray) {
        if (n == this.callback) {
            try {
                String string = new String(byArray, "UTF-8");
                int n2 = Integer.parseInt(string);
                if (n2 >= 0 && n2 != this.config.getCoreStatisticsInterval()) {
                    this.frontend.log(this.channel, this.thread, (short)2, (short)0, new StringBuffer().append("new coreStatisticsInterval=").append(n2).toString());
                    this.config.setCoreStatisticsInterval(n2);
                }
            }
            catch (Exception exception) {
                this.frontend.log(this.channel, this.thread, (short)4, (short)0, new StringBuffer().append("callback failed: ").append(exception.getMessage()).toString());
            }
        }
    }

    @Override
    public void requestFilterLevel(TraceEntityURI traceEntityURI, short s) {
    }

    @Override
    public void requestQuit() {
    }
}

