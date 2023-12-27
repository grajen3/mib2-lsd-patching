/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.transport;

import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.fw.util.tracing.util.TraceTimeStamp;
import de.esolutions.fw.util.transport.debug.TransportDebugTool;

class TransportDebugAdapter$Entry {
    public final Thread t;
    public final long ts;
    public final int state;
    public final int value;
    public final Object tag;

    public TransportDebugAdapter$Entry(Thread thread, long l, int n, int n2, Object object) {
        this.t = thread;
        this.ts = l;
        this.state = n;
        this.value = n2;
        this.tag = object;
    }

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append(this.t.getName());
        buffer.append(": ");
        TraceTimeStamp traceTimeStamp = new TraceTimeStamp(this.ts);
        buffer.append(traceTimeStamp.toUTCTimeString(false));
        buffer.append(' ');
        TransportDebugTool.decodeState(this.state, buffer);
        buffer.append(' ');
        buffer.append(this.value);
        if (this.tag != null) {
            buffer.append(' ');
            buffer.append(this.tag);
        }
        return buffer.toString();
    }
}

