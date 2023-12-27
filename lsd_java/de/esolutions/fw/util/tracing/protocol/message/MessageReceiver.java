/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.protocol.message;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.connection.Connection;
import de.esolutions.fw.util.tracing.protocol.message.AbstractMessage;
import de.esolutions.fw.util.tracing.protocol.message.InitMessage;
import de.esolutions.fw.util.tracing.protocol.message.MessageDecoder;
import de.esolutions.fw.util.tracing.protocol.message.MessageType;
import de.esolutions.fw.util.transport.ITransport;
import de.esolutions.fw.util.transport.exception.TransportException;

public class MessageReceiver {
    protected ITransport transport;
    protected MessageDecoder decoder;

    public MessageReceiver(Connection connection) {
        this.transport = connection.getTransport();
        this.decoder = new MessageDecoder(connection.getDeserializer());
    }

    public void setDeserializer(IDeserializer iDeserializer) {
        this.decoder = new MessageDecoder(iDeserializer);
    }

    public AbstractMessage recvMessage() {
        return this.decoder.decodeReadable(this.transport.recv());
    }

    public InitMessage recvInitMessage() {
        AbstractMessage abstractMessage = this.recvMessage();
        if (abstractMessage == null) {
            throw new TransportException("Invalid Received Comm Message");
        }
        if (abstractMessage.getMessageType() != MessageType.INIT) {
            throw new TransportException(new StringBuffer().append("Expected INIT message, but got ").append(abstractMessage.getMessageType()).toString());
        }
        return (InitMessage)abstractMessage;
    }
}

