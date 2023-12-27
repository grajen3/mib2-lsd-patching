/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.protocol.message;

import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.tracing.message.ITraceMessage;
import de.esolutions.fw.util.tracing.protocol.message.AbstractMessage;
import de.esolutions.fw.util.tracing.protocol.message.LogDataMessage;
import de.esolutions.fw.util.tracing.protocol.message.MessageType;

public class LogDataBulkMessage
extends AbstractMessage {
    private ITraceMessage[] msgs;

    public LogDataBulkMessage(ITraceMessage[] iTraceMessageArray) {
        super(MessageType.BULK_LOG_DATA);
        this.msgs = iTraceMessageArray;
    }

    public LogDataBulkMessage() {
        super(MessageType.BULK_LOG_DATA);
    }

    @Override
    protected void serializeElements(ISerializer iSerializer) {
        int n = 0;
        if (this.msgs != null) {
            n = this.msgs.length;
        }
        iSerializer.putInt32(n);
        for (int i2 = 0; i2 < n; ++i2) {
            LogDataMessage logDataMessage = new LogDataMessage(this.msgs[i2]);
            logDataMessage.serializeElements(iSerializer);
        }
    }

    @Override
    protected void deserializeElements(IDeserializer iDeserializer) {
        int n = iDeserializer.getInt32();
        this.msgs = new ITraceMessage[n];
        for (int i2 = 0; i2 < n; ++i2) {
            LogDataMessage logDataMessage = new LogDataMessage();
            logDataMessage.deserializeElements(iDeserializer);
            this.msgs[i2] = logDataMessage.getMessage();
        }
    }

    public ITraceMessage[] getMessages() {
        return this.msgs;
    }

    @Override
    public void toStringBuffer(Buffer buffer) {
        int n = 0;
        if (this.msgs != null) {
            n = this.msgs.length;
        }
        buffer.append("LogDataBulk: n=");
        buffer.append(n);
        buffer.append(" [");
        for (int i2 = 0; i2 < n; ++i2) {
            LogDataMessage logDataMessage = new LogDataMessage(this.msgs[i2]);
            logDataMessage.toStringBuffer(buffer);
            buffer.append(", ");
        }
        buffer.append("]");
    }
}

