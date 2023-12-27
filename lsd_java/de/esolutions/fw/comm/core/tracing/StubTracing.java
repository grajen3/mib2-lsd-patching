/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.core.tracing;

import de.esolutions.fw.comm.core.IStub;
import de.esolutions.fw.comm.core.tracing.CommMessageTracing;
import de.esolutions.fw.comm.core.tracing.SubBuffer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.tracing.TraceChannel;
import de.esolutions.fw.util.transport.IReadable;

public class StubTracing {
    private static CommMessageTracing commMessageTracing;
    private final IStub stub;
    private final TraceChannel channel;
    private final int callCount;

    public static void setTracing(CommMessageTracing commMessageTracing) {
        StubTracing.commMessageTracing = commMessageTracing;
    }

    public static boolean isEnabled() {
        return commMessageTracing != null;
    }

    public StubTracing(IStub iStub, TraceChannel traceChannel, int n) {
        this.stub = iStub;
        this.channel = traceChannel;
        this.callCount = n;
    }

    public void log(short s, IDeserializer iDeserializer) {
        if (commMessageTracing == null) {
            return;
        }
        IReadable iReadable = iDeserializer.getAttachedBuffer();
        byte[] byArray = iReadable.getDirectData();
        int n = iReadable.getDirectOffset();
        int n2 = byArray.length - n;
        SubBuffer subBuffer = new SubBuffer(byArray, n2, n);
        ISerializer iSerializer = iDeserializer.createCompatibleSerializer();
        commMessageTracing.logStub(this.channel, iSerializer, this.stub, s, subBuffer, this.callCount);
    }
}

