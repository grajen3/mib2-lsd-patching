/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.protocol.message;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.adapter.DefaultExtendedDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import de.esolutions.fw.util.serializer.stream.BEDefaultDeserializer;
import de.esolutions.fw.util.tracing.protocol.message.AbstractMessage;
import de.esolutions.fw.util.tracing.protocol.message.MessageType;
import de.esolutions.fw.util.transport.IReadable;
import de.esolutions.fw.util.transport.buffer.TransportBuffer;

public class MessageDecoder {
    private IDeserializer deserializer;

    public MessageDecoder() {
        this.deserializer = new DefaultExtendedDeserializer(new BEDefaultDeserializer());
    }

    public MessageDecoder(IDeserializer iDeserializer) {
        this.deserializer = iDeserializer;
    }

    public AbstractMessage decodeBuffer(byte[] byArray) {
        return this.decodeReadable(new TransportBuffer(byArray));
    }

    public AbstractMessage decodeReadable(IReadable iReadable) {
        try {
            this.deserializer.attachBuffer(iReadable);
            byte by = this.deserializer.getInt8();
            MessageType messageType = MessageType.getType(by);
            AbstractMessage abstractMessage = messageType.createMessage();
            if (abstractMessage == null) {
                throw new SerializerException(new StringBuffer().append("Invalid Trace Message Type: ").append(by).toString());
            }
            abstractMessage.deserialize(this.deserializer);
            int n = this.deserializer.bytesLeft();
            if (n > 0) {
                throw new SerializerException(new StringBuffer().append("Serializer has bytes left: ").append(n).toString());
            }
            this.deserializer.detachBuffer();
            return abstractMessage;
        }
        catch (RuntimeException runtimeException) {
            throw new SerializerException(new StringBuffer().append("Serializer had runtime problem: ").append(runtimeException.getMessage()).toString());
        }
    }
}

