/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing;

import de.esolutions.fw.util.commons.traceme.TraceMe;
import de.esolutions.fw.util.tracing.ITraceClient;
import de.esolutions.fw.util.tracing.TraceChannel;
import java.util.ArrayList;
import java.util.List;

public class TraceChannelList {
    private List channels = new ArrayList();
    private ITraceClient client;
    private static TraceChannelList theChannelList;

    public static synchronized TraceChannelList getInstance() {
        if (theChannelList == null) {
            theChannelList = new TraceChannelList();
        }
        return theChannelList;
    }

    public synchronized void setClient(ITraceClient iTraceClient) {
        this.client = iTraceClient;
    }

    public synchronized void registerChannel(TraceChannel traceChannel) {
        TraceMe.msg(TraceMe.DEBUG, "TraceChannelList", "registerChannel: %1", traceChannel.getPath());
        if (this.client != null) {
            this.client.registerChannel(traceChannel);
        } else {
            this.channels.add(traceChannel);
        }
    }

    public synchronized void unregisterChannel(TraceChannel traceChannel) {
        TraceMe.msg(TraceMe.DEBUG, "TraceChannelList", "unregisterChannel: %1", traceChannel.getPath());
        if (this.client != null) {
            this.client.unregisterChannel(traceChannel);
        } else {
            this.channels.remove(traceChannel);
        }
    }

    public synchronized TraceChannel[] getAllChannels() {
        int n = this.channels.size();
        Object[] objectArray = new TraceChannel[n];
        this.channels.toArray(objectArray);
        return objectArray;
    }
}

