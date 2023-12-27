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

public class UpdateTimezoneMessage
extends AbstractMessage {
    private int id;
    private long tzTime;
    private long coreTime;

    public UpdateTimezoneMessage(int n, long l, long l2) {
        super(MessageType.UPDATE_TIMEZONE);
        this.id = n;
        this.tzTime = l;
        this.coreTime = l2;
    }

    public UpdateTimezoneMessage() {
        super(MessageType.UPDATE_TIMEZONE);
    }

    @Override
    public void serializeElements(ISerializer iSerializer) {
        iSerializer.putInt32(this.id);
        iSerializer.putInt64(this.tzTime);
        iSerializer.putInt64(this.coreTime);
    }

    @Override
    public void deserializeElements(IDeserializer iDeserializer) {
        this.id = iDeserializer.getInt32();
        this.tzTime = iDeserializer.getInt64();
        this.coreTime = iDeserializer.getInt64();
    }

    public int getId() {
        return this.id;
    }

    public long getTimezoneTimeStamp() {
        return this.tzTime;
    }

    public long getCoreTimeStamp() {
        return this.coreTime;
    }

    @Override
    public long getTimeStamp() {
        return this.coreTime;
    }

    @Override
    public long getExternalTimeStamp() {
        return this.tzTime;
    }

    @Override
    public void toStringBuffer(Buffer buffer) {
        buffer.append("Update TimeZone: id=");
        buffer.append(this.id);
        buffer.append(" tzTime=");
        buffer.append(this.tzTime);
        buffer.append("/");
        buffer.append(TraceTimeStamp.longToUTCTimeString(this.tzTime, true));
        buffer.append(" coreTime=");
        buffer.append(this.coreTime);
        buffer.append("/");
        buffer.append(TraceTimeStamp.longToUTCTimeString(this.coreTime, true));
    }
}

