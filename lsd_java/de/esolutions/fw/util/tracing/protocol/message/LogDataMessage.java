/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.protocol.message;

import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.fw.util.commons.StringConverter;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.tracing.TraceLevels;
import de.esolutions.fw.util.tracing.TraceMessageTypes;
import de.esolutions.fw.util.tracing.message.ITraceMessage;
import de.esolutions.fw.util.tracing.message.TraceMessage;
import de.esolutions.fw.util.tracing.protocol.message.AbstractMessage;
import de.esolutions.fw.util.tracing.protocol.message.ILogDataMessage;
import de.esolutions.fw.util.tracing.protocol.message.MessageType;
import de.esolutions.fw.util.tracing.util.TraceTimeStamp;
import java.io.UnsupportedEncodingException;

public class LogDataMessage
extends AbstractMessage
implements ILogDataMessage {
    private long timeStamp;
    private short level;
    private short modifiers;
    private int channelID;
    private int sourceID;
    private short messageType;
    private byte[] messageData;

    public LogDataMessage(ILogDataMessage iLogDataMessage) {
        super(MessageType.LOG_DATA);
        this.timeStamp = iLogDataMessage.getTimeStamp();
        this.level = iLogDataMessage.getLevel();
        this.modifiers = iLogDataMessage.getModifiers();
        this.channelID = iLogDataMessage.getChannelID();
        this.sourceID = iLogDataMessage.getSourceID();
        this.messageType = iLogDataMessage.getLogType();
        this.messageData = iLogDataMessage.getLogData();
    }

    public LogDataMessage(long l, short s, short s2, int n, int n2, short s3, byte[] byArray) {
        super(MessageType.LOG_DATA);
        this.timeStamp = l;
        this.level = s;
        this.modifiers = s2;
        this.channelID = n;
        this.sourceID = n2;
        this.messageType = s3;
        this.messageData = byArray;
    }

    public LogDataMessage(ITraceMessage iTraceMessage) {
        super(MessageType.LOG_DATA);
        this.timeStamp = iTraceMessage.getTimeStamp();
        this.level = iTraceMessage.getLevel();
        this.modifiers = iTraceMessage.getModifiers();
        this.channelID = iTraceMessage.getChannelID();
        this.sourceID = iTraceMessage.getThreadID();
        this.messageType = iTraceMessage.getMessageType();
        this.messageData = iTraceMessage.getMessageData();
    }

    public LogDataMessage() {
        super(MessageType.LOG_DATA);
    }

    @Override
    public void serializeElements(ISerializer iSerializer) {
        iSerializer.putInt64(this.timeStamp);
        iSerializer.putInt16(this.level);
        iSerializer.putInt16(this.modifiers);
        iSerializer.putInt32(this.channelID);
        iSerializer.putInt32(this.sourceID);
        iSerializer.putInt16(this.messageType);
        iSerializer.putInt8VarArray(this.messageData);
    }

    @Override
    public void deserializeElements(IDeserializer iDeserializer) {
        this.timeStamp = iDeserializer.getInt64();
        this.level = iDeserializer.getInt16();
        this.modifiers = iDeserializer.getInt16();
        this.channelID = iDeserializer.getInt32();
        this.sourceID = iDeserializer.getInt32();
        this.messageType = iDeserializer.getInt16();
        this.messageData = iDeserializer.getInt8VarArray();
    }

    public ITraceMessage getMessage() {
        return new TraceMessage(this.timeStamp, this.channelID, this.sourceID, this.level, this.modifiers, this.messageType, this.messageData);
    }

    @Override
    public long getTimeStamp() {
        return this.timeStamp;
    }

    @Override
    public short getLevel() {
        return this.level;
    }

    @Override
    public short getModifiers() {
        return this.modifiers;
    }

    @Override
    public int getChannelID() {
        return this.channelID;
    }

    @Override
    public int getSourceID() {
        return this.sourceID;
    }

    @Override
    public short getLogType() {
        return this.messageType;
    }

    @Override
    public byte[] getLogData() {
        return this.messageData;
    }

    public String getLogString(boolean bl) {
        if (this.messageType == 1) {
            try {
                return StringConverter.UTF8.getString(this.messageData);
            }
            catch (UnsupportedEncodingException unsupportedEncodingException) {
                return new String(this.messageData);
            }
        }
        if (bl) {
            Buffer buffer = new Buffer();
            buffer.append("UNDECODED: type=");
            buffer.append(this.messageType);
            buffer.append("[");
            buffer.append(TraceMessageTypes.getName(this.messageType));
            buffer.append("] size=");
            buffer.append(this.messageData.length);
            return buffer.toString();
        }
        return null;
    }

    @Override
    public void toStringBuffer(Buffer buffer) {
        buffer.append("LogData: ts=");
        buffer.append(this.timeStamp);
        buffer.append("/");
        buffer.append(TraceTimeStamp.longToUTCTimeString(this.timeStamp, true));
        buffer.append(" level=");
        buffer.append(this.level);
        buffer.append("/");
        buffer.append(TraceLevels.getName(this.level));
        buffer.append(" modifiers=");
        buffer.append(this.modifiers);
        buffer.append(" channel=");
        buffer.append(this.channelID);
        buffer.append(" source=");
        buffer.append(this.sourceID);
        buffer.append(" type=");
        buffer.append(this.messageType);
        buffer.append("/");
        buffer.append(TraceMessageTypes.getName(this.messageType));
        buffer.append(" size=");
        buffer.append(this.messageData.length);
    }

    @Override
    public byte[] getRawDataPortion() {
        return this.messageData;
    }
}

