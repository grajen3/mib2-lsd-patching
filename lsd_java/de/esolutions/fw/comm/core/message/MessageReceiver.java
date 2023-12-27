/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.core.message;

import de.esolutions.fw.comm.core.message.AbstractMessage;
import de.esolutions.fw.comm.core.message.AnnounceFeatureMessage;
import de.esolutions.fw.comm.core.message.BrokerAckMessage;
import de.esolutions.fw.comm.core.message.IIncomingMessageListener;
import de.esolutions.fw.comm.core.message.MessageType;
import de.esolutions.fw.comm.core.message.SetFeatureMessage;
import de.esolutions.fw.comm.core.tracing.CommCoreTracing;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.connection.Connection;
import de.esolutions.fw.util.transport.IReadable;
import de.esolutions.fw.util.transport.ITransport;
import de.esolutions.fw.util.transport.debug.ITransportDebug;
import de.esolutions.fw.util.transport.exception.TransportException;

public class MessageReceiver {
    private ITransportDebug debug;
    protected ITransport transport;
    protected IDeserializer deserializer;
    protected byte protocolVersion;
    private IIncomingMessageListener messageListener;

    public MessageReceiver(Connection connection, byte by) {
        this.transport = connection.getTransport();
        this.deserializer = connection.getDeserializer();
        this.protocolVersion = by;
    }

    public void setDebug(ITransportDebug iTransportDebug) {
        this.debug = iTransportDebug;
    }

    public void setMessageListener(IIncomingMessageListener iIncomingMessageListener) {
        this.messageListener = iIncomingMessageListener;
    }

    public void setDeserializer(IDeserializer iDeserializer) {
        this.deserializer = iDeserializer;
    }

    public AbstractMessage recvMessage() {
        int n;
        IReadable iReadable = null;
        MessageType messageType = null;
        while (true) {
            if (this.debug != null) {
                long l = System.currentTimeMillis();
                this.debug.log(l, 2058, 0, new Long(l));
            }
            if ((iReadable = this.transport.recv()) == null) {
                CommCoreTracing.MESSAGE.log((short)4, "COMM Message Reader: no readable received!");
                if (this.debug == null) continue;
                this.debug.log(System.currentTimeMillis(), 2082, 1, null);
                continue;
            }
            if (iReadable.size() == 0) {
                CommCoreTracing.MESSAGE.log((short)4, "COMM Message Reader: empty readable received!");
                if (this.debug == null) continue;
                this.debug.log(System.currentTimeMillis(), 2082, 1, iReadable.getDebugTag());
                continue;
            }
            if (this.debug != null) {
                this.debug.log(System.currentTimeMillis(), 2054, 0, iReadable.getDebugTag());
            }
            this.deserializer.attachBuffer(iReadable);
            byte by = this.deserializer.getInt8();
            messageType = MessageType.getType(by);
            if (messageType != null) break;
            this.deserializer.detachBuffer();
        }
        AbstractMessage abstractMessage = messageType.createMessage(this.deserializer, false, this.protocolVersion);
        if (abstractMessage == null) {
            throw new TransportException("Can't create Comm Message");
        }
        if (messageType.toString().equals("UNKNOWN")) {
            CommCoreTracing.MESSAGE.log((short)3, "unknown message type %detected: type=%1 [%2], size=%3", messageType, (Object)new StringBuffer().append("0x").append(Integer.toHexString(messageType.toByte())).toString(), (Object)new Integer(iReadable.size()));
        }
        int n2 = this.deserializer.detachBuffer();
        if (this.messageListener != null) {
            this.messageListener.incomingMessage(abstractMessage);
        }
        if ((n = iReadable.size() - n2) > 0) {
            abstractMessage.setPayload(iReadable.createSubBuffer(n2, n));
        }
        if (this.debug != null) {
            Object object = iReadable.getDebugTag();
            if (object != null) {
                abstractMessage.createDebugTag((Long)object);
            }
            this.debug.log(System.currentTimeMillis(), 2066, 0, abstractMessage.getDebugTag());
        }
        return abstractMessage;
    }

    public AnnounceFeatureMessage recvAnnounceFeatureMessage() {
        AbstractMessage abstractMessage = this.recvMessage();
        if (abstractMessage.getMessageType() == MessageType.DROP) {
            return null;
        }
        if (abstractMessage.getMessageType() != MessageType.ANNOUNCE_FEATURE) {
            throw new TransportException(new StringBuffer().append("Expected ANNOUNCE_FEATURE message, but got ").append(abstractMessage.getMessageType()).toString());
        }
        return (AnnounceFeatureMessage)abstractMessage;
    }

    public BrokerAckMessage recvBrokerAckMessage() {
        AbstractMessage abstractMessage = this.recvMessage();
        if (abstractMessage.getMessageType() != MessageType.BROKER_ACK) {
            throw new TransportException(new StringBuffer().append("Expected BROKER_ACK message, but got ").append(abstractMessage.getMessageType()).toString());
        }
        return (BrokerAckMessage)abstractMessage;
    }

    public AbstractMessage recvInitOrHelloMessage() {
        AbstractMessage abstractMessage = this.recvMessage();
        if (abstractMessage.getMessageType() == MessageType.DROP) {
            return null;
        }
        if (abstractMessage.getMessageType() != MessageType.INIT && abstractMessage.getMessageType() != MessageType.HELLO) {
            throw new TransportException(new StringBuffer().append("Expected INIT or HELLO message, but got ").append(abstractMessage.getMessageType()).toString());
        }
        return abstractMessage;
    }

    public SetFeatureMessage recvSetFeatureMessage() {
        AbstractMessage abstractMessage = this.recvMessage();
        if (abstractMessage.getMessageType() != MessageType.SET_FEATURE) {
            throw new TransportException(new StringBuffer().append("Expected SET_FEATURE message, but got ").append(abstractMessage.getMessageType()).toString());
        }
        return (SetFeatureMessage)abstractMessage;
    }
}

