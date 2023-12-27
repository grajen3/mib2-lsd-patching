/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.protocol.message;

import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.tracing.protocol.message.AbstractMessage;
import de.esolutions.fw.util.tracing.protocol.message.MessageType;
import de.esolutions.fw.util.tracing.util.TraceTimeStamp;

public class LoggerTimeMessage
extends AbstractMessage {
    private long loggerTime;
    private long traceTime;
    private int error;

    public LoggerTimeMessage(long l, long l2, int n) {
        super(MessageType.LOGGER_TIME);
        this.loggerTime = l;
        this.traceTime = l2;
        this.error = n;
    }

    public LoggerTimeMessage() {
        super(MessageType.LOGGER_TIME);
    }

    @Override
    public void serializeElements(ISerializer iSerializer) {
        iSerializer.putInt64(this.loggerTime);
        iSerializer.putInt64(this.traceTime);
        iSerializer.putInt32(this.error);
    }

    @Override
    public void deserializeElements(IDeserializer iDeserializer) {
        this.loggerTime = iDeserializer.getInt64();
        this.traceTime = iDeserializer.getInt64();
        this.error = iDeserializer.getInt32();
    }

    public long getLoggerTimeStamp() {
        return this.loggerTime;
    }

    public long getTraceTimeStamp() {
        return this.traceTime;
    }

    @Override
    public long getTimeStamp() {
        return this.traceTime;
    }

    @Override
    public long getExternalTimeStamp() {
        return this.loggerTime;
    }

    public int getError() {
        return this.error;
    }

    @Override
    public void toStringBuffer(Buffer buffer) {
        buffer.append("LoggerTime: lts=");
        buffer.append(this.loggerTime);
        buffer.append("/");
        buffer.append(TraceTimeStamp.longToUTCTimeString(this.loggerTime, true));
        buffer.append(" ts=");
        buffer.append(this.traceTime);
        buffer.append("/");
        buffer.append(TraceTimeStamp.longToUTCTimeString(this.traceTime, true));
        buffer.append(" error=");
        buffer.append(this.error);
    }
}

