/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.core.tracing;

import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.message.ICallMethodSerializeCallback;
import de.esolutions.fw.comm.core.tracing.CommMessageTracing;
import de.esolutions.fw.comm.core.tracing.SubBuffer;
import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.serializer.IStreamSerializer;
import de.esolutions.fw.util.tracing.TraceChannel;
import de.esolutions.fw.util.transport.IWriteable;

public class ProxyTracing
implements ICallMethodSerializeCallback {
    private static CommMessageTracing commMessageTracing;
    private final Proxy proxy;
    private final short peerAgentID;
    private final TraceChannel channel;
    private final int callCount;
    private int offset;

    public static void setTracing(CommMessageTracing commMessageTracing) {
        ProxyTracing.commMessageTracing = commMessageTracing;
    }

    public static boolean isEnabled() {
        return commMessageTracing != null;
    }

    public ProxyTracing(Proxy proxy, short s, TraceChannel traceChannel, int n) {
        this.proxy = proxy;
        this.peerAgentID = s;
        this.channel = traceChannel;
        this.callCount = n;
    }

    @Override
    public void beginSerializeCallMethodPayload(short s, short s2, ISerializer iSerializer) {
        this.offset = iSerializer.getDirectPos();
    }

    @Override
    public void endSerializeCallMethodPayload(short s, short s2, ISerializer iSerializer) {
        if (commMessageTracing == null) {
            return;
        }
        IWriteable iWriteable = iSerializer.getAttachedBuffer();
        int n = iSerializer.getDirectPos() - this.offset;
        if (this.channel != null) {
            byte[] byArray = iWriteable.getDirectData();
            if (n == 0) {
                byArray = null;
                this.offset = 0;
            }
            SubBuffer subBuffer = new SubBuffer(byArray, n, this.offset);
            IStreamSerializer iStreamSerializer = iSerializer.createCompatibleStreamSerializer();
            commMessageTracing.logProxy(this.channel, iStreamSerializer, this.proxy, this.peerAgentID, s2, subBuffer, this.callCount);
        }
    }
}

