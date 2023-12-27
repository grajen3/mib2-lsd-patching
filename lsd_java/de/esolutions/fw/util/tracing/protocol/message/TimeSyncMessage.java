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

public class TimeSyncMessage
extends AbstractMessage {
    public static final byte TYPE_PING;
    public static final byte TYPE_PONG;
    private long timeStamp;
    private byte serial;
    private byte type;

    public TimeSyncMessage(long l, byte by, byte by2) {
        super(MessageType.TIME_SYNC);
        this.timeStamp = l;
        this.serial = by;
        this.type = by2;
    }

    public TimeSyncMessage() {
        super(MessageType.TIME_SYNC);
    }

    @Override
    public void serializeElements(ISerializer iSerializer) {
        iSerializer.putInt64(this.timeStamp);
        iSerializer.putInt8(this.serial);
        iSerializer.putInt8(this.type);
    }

    @Override
    public void deserializeElements(IDeserializer iDeserializer) {
        this.timeStamp = iDeserializer.getInt64();
        this.serial = iDeserializer.getInt8();
        this.type = iDeserializer.getInt8();
    }

    @Override
    public long getTimeStamp() {
        return this.timeStamp;
    }

    public byte getSerial() {
        return this.serial;
    }

    public byte getType() {
        return this.type;
    }

    @Override
    public void toStringBuffer(Buffer buffer) {
        buffer.append("Time Sync: ts=");
        buffer.append(this.timeStamp);
        buffer.append("/");
        buffer.append(TraceTimeStamp.longToUTCTimeString(this.timeStamp, true));
        buffer.append(" serial=");
        buffer.append(this.serial);
        buffer.append(" type=");
        buffer.append(this.type);
    }
}

