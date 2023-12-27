/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.protocol.message;

import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.fw.util.commons.StringConverter;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.tracing.protocol.message.AbstractMessage;
import de.esolutions.fw.util.tracing.protocol.message.ILoggerDataMessage;
import de.esolutions.fw.util.tracing.protocol.message.MessageType;
import de.esolutions.fw.util.tracing.util.TraceTimeStamp;
import java.io.UnsupportedEncodingException;

public class LoggerDataMessage
extends AbstractMessage
implements ILoggerDataMessage {
    public static final short DATA_TYPE_MARKER;
    public static final short DATA_TYPE_SYSTEM;
    public static final short DATA_TYPE_STREAM;
    public static final short DATA_TYPE_STREAM_RESYNC;
    public static final short DATA_TYPE_STREAM_GAP_TIMESTAMP;
    public static final short DATA_TYPE_STREAM_GAP_SYNC_MARKER;
    private long loggerTimeStamp;
    private short dataType;
    private short messageType;
    private byte[] messageData;

    public LoggerDataMessage(ILoggerDataMessage iLoggerDataMessage) {
        super(MessageType.LOGGER_DATA);
        this.loggerTimeStamp = iLoggerDataMessage.getLoggerTimeStamp();
        this.dataType = iLoggerDataMessage.getLoggerDataType();
        this.messageType = iLoggerDataMessage.getLoggerMessageType();
        this.messageData = iLoggerDataMessage.getLoggerMessageData();
    }

    public LoggerDataMessage(long l, short s, short s2, byte[] byArray) {
        super(MessageType.LOGGER_DATA);
        this.loggerTimeStamp = l;
        this.dataType = s;
        this.messageType = s2;
        this.messageData = byArray;
    }

    public LoggerDataMessage() {
        super(MessageType.LOGGER_DATA);
    }

    @Override
    public void serializeElements(ISerializer iSerializer) {
        iSerializer.putInt64(this.loggerTimeStamp);
        iSerializer.putInt16(this.dataType);
        iSerializer.putInt16(this.messageType);
        iSerializer.putInt8VarArray(this.messageData);
    }

    @Override
    public void deserializeElements(IDeserializer iDeserializer) {
        this.loggerTimeStamp = iDeserializer.getInt64();
        this.dataType = iDeserializer.getInt16();
        this.messageType = iDeserializer.getInt16();
        this.messageData = iDeserializer.getInt8VarArray();
    }

    @Override
    public long getLoggerTimeStamp() {
        return this.loggerTimeStamp;
    }

    @Override
    public short getLoggerDataType() {
        return this.dataType;
    }

    @Override
    public short getLoggerMessageType() {
        return this.messageType;
    }

    @Override
    public byte[] getLoggerMessageData() {
        return this.messageData;
    }

    public String getLoggerMessageString(boolean bl) {
        if (this.messageType == 1) {
            try {
                return StringConverter.UTF8.getString(this.messageData);
            }
            catch (UnsupportedEncodingException unsupportedEncodingException) {
                return new String(this.messageData);
            }
        }
        if (bl) {
            return new StringBuffer().append("UNDECODED: type=").append(this.messageType).append(" size=").append(this.messageData.length).toString();
        }
        return null;
    }

    @Override
    public long getExternalTimeStamp() {
        return this.loggerTimeStamp;
    }

    @Override
    public void toStringBuffer(Buffer buffer) {
        buffer.append("LoggerData: lts=");
        buffer.append(this.loggerTimeStamp);
        buffer.append("/");
        buffer.append(TraceTimeStamp.longToUTCTimeString(this.loggerTimeStamp, true));
        buffer.append(" data type=");
        buffer.append(this.dataType);
        buffer.append(" message type=");
        buffer.append(this.messageType);
        buffer.append(" size=");
        buffer.append(this.messageData.length);
    }

    @Override
    public byte[] getRawDataPortion() {
        return this.messageData;
    }
}

