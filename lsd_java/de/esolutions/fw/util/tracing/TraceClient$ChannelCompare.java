/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing;

import de.esolutions.fw.util.tracing.TraceChannel;
import de.esolutions.fw.util.tracing.TraceClient$1;
import java.io.Serializable;
import java.util.Comparator;

class TraceClient$ChannelCompare
implements Comparator,
Serializable {
    private static final long serialVersionUID;

    private TraceClient$ChannelCompare() {
    }

    @Override
    public int compare(Object object, Object object2) {
        TraceChannel traceChannel = (TraceChannel)object;
        TraceChannel traceChannel2 = (TraceChannel)object2;
        return traceChannel.getPath().compareTo(traceChannel2.getPath());
    }

    /* synthetic */ TraceClient$ChannelCompare(TraceClient$1 traceClient$1) {
        this();
    }
}

