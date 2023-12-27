/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.core;

import de.esolutions.fw.util.tracing.TraceChannel;

public class CallContext {
    private String name;
    private TraceChannel channel;

    public static CallContext getContext(String string) {
        return new CallContext(string);
    }

    private CallContext(String string) {
        this.name = string;
    }

    public TraceChannel getTraceChannel() {
        if (this.channel == null) {
            this.channel = new TraceChannel(this.name);
        }
        return this.channel;
    }
}

