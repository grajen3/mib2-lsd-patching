/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.core.message;

import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.message.AbstractMessage;
import de.esolutions.fw.comm.core.message.AnnounceFeatureMessage;
import de.esolutions.fw.comm.core.message.AnnounceFeatureMessageV4;
import de.esolutions.fw.comm.core.message.BrokerAckMessage;
import de.esolutions.fw.comm.core.message.BrokerAckMessageV3;
import de.esolutions.fw.comm.core.message.BrokerAckMessageV4;
import de.esolutions.fw.comm.core.message.CallMethodMessage;
import de.esolutions.fw.comm.core.message.CreateRRStubMessage;
import de.esolutions.fw.comm.core.message.CreateStubMessage;
import de.esolutions.fw.comm.core.message.DestroyStubMessage;
import de.esolutions.fw.comm.core.message.DropMessage;
import de.esolutions.fw.comm.core.message.ExitMessage;
import de.esolutions.fw.comm.core.message.HelloMessage;
import de.esolutions.fw.comm.core.message.ICallMethodSerializeCallback;
import de.esolutions.fw.comm.core.message.IOutgoingMessageListener;
import de.esolutions.fw.comm.core.message.InitMessage;
import de.esolutions.fw.comm.core.message.InitMessageV4;
import de.esolutions.fw.comm.core.message.MessageType;
import de.esolutions.fw.comm.core.message.PingMessage;
import de.esolutions.fw.comm.core.message.ProxyAliveMessage;
import de.esolutions.fw.comm.core.message.RRStubCreatedMessage;
import de.esolutions.fw.comm.core.message.RawMessage;
import de.esolutions.fw.comm.core.message.RejectMessage;
import de.esolutions.fw.comm.core.message.SetFeatureMessage;
import de.esolutions.fw.comm.core.message.StubCreatedMessage;
import de.esolutions.fw.comm.core.message.StubFailedMessage;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.serializer.connection.Connection;
import de.esolutions.fw.util.transport.ITransport;
import de.esolutions.fw.util.transport.debug.ITransportDebug;

public class MessageSender {
    private ITransportDebug debug;
    protected ITransport transport;
    protected ISerializer serializer;
    protected byte protocolVersion;
    private IOutgoingMessageListener messageListener;

    public MessageSender(Connection connection, byte by) {
        this.transport = connection.getTransport();
        this.serializer = connection.getSerializer();
        this.protocolVersion = by;
    }

    public void setConnection(Connection connection) {
        this.transport = connection.getTransport();
        this.serializer = connection.getSerializer();
    }

    public void setDebug(ITransportDebug iTransportDebug) {
        this.debug = iTransportDebug;
    }

    public void setMessageListener(IOutgoingMessageListener iOutgoingMessageListener) {
        this.messageListener = iOutgoingMessageListener;
    }

    public void setSerializer(ISerializer iSerializer) {
        this.serializer = iSerializer;
    }

    public void sendInit(short s, byte by, short s2) {
        InitMessage initMessage = this.protocolVersion < 4 ? new InitMessage(this.serializer, s, by) : new InitMessageV4(this.serializer, s, by, s2);
        this.send(initMessage);
    }

    public void sendAnnounceFeature(short s, byte by, short s2) {
        AnnounceFeatureMessage announceFeatureMessage = this.protocolVersion < 4 ? new AnnounceFeatureMessage(this.serializer, s, by) : new AnnounceFeatureMessageV4(this.serializer, s, by, s2);
        this.send(announceFeatureMessage);
    }

    public void sendSetFeature(byte by) {
        SetFeatureMessage setFeatureMessage = new SetFeatureMessage(this.serializer, by);
        this.send(setFeatureMessage);
    }

    public void sendDrop() {
        DropMessage dropMessage = new DropMessage(this.serializer);
        this.send(dropMessage);
    }

    public void sendCreateStub(short s, short s2, ServiceInstanceID serviceInstanceID) {
        CreateStubMessage createStubMessage = new CreateStubMessage(this.serializer, s, s2, serviceInstanceID);
        this.send(createStubMessage);
    }

    public void sendCreateRRStub(short s, short s2, short s3, ServiceInstanceID serviceInstanceID, ServiceInstanceID serviceInstanceID2) {
        CreateRRStubMessage createRRStubMessage = new CreateRRStubMessage(this.serializer, s, s2, s3, serviceInstanceID, serviceInstanceID2);
        this.send(createRRStubMessage);
    }

    public void sendStubCreated(short s, short s2) {
        StubCreatedMessage stubCreatedMessage = new StubCreatedMessage(this.serializer, s, s2);
        this.send(stubCreatedMessage);
    }

    public void sendRRStubCreated(short s, short s2, short s3) {
        RRStubCreatedMessage rRStubCreatedMessage = new RRStubCreatedMessage(this.serializer, s, s2, s3);
        this.send(rRStubCreatedMessage);
    }

    public void sendStubFailed(short s, byte by) {
        StubFailedMessage stubFailedMessage = new StubFailedMessage(this.serializer, s, by);
        this.send(stubFailedMessage);
    }

    public void sendDestroyStub(short s) {
        DestroyStubMessage destroyStubMessage = new DestroyStubMessage(this.serializer, s);
        this.send(destroyStubMessage);
    }

    public void sendProxyAlive(short s) {
        ProxyAliveMessage proxyAliveMessage = new ProxyAliveMessage(this.serializer, s);
        this.send(proxyAliveMessage);
    }

    public void sendCallMethod(short s, short s2, ISerializable iSerializable, ICallMethodSerializeCallback iCallMethodSerializeCallback) {
        CallMethodMessage callMethodMessage = new CallMethodMessage(this.serializer, s, s2, iSerializable);
        callMethodMessage.setSerializeCallback(iCallMethodSerializeCallback);
        this.send(callMethodMessage);
    }

    public void sendExit() {
        ExitMessage exitMessage = new ExitMessage(this.serializer);
        this.send(exitMessage);
    }

    public void sendBrokerAck(short s, ServiceInstanceID serviceInstanceID, short s2, short s3) {
        BrokerAckMessage brokerAckMessage = this.protocolVersion < 3 ? new BrokerAckMessage(this.serializer, s, serviceInstanceID) : (this.protocolVersion == 3 ? new BrokerAckMessageV3(this.serializer, s, serviceInstanceID) : new BrokerAckMessageV4(this.serializer, s, serviceInstanceID, s2, s3));
        this.send(brokerAckMessage);
    }

    public void sendHello(short s, String string) {
        HelloMessage helloMessage = new HelloMessage(this.serializer, s, string);
        this.send(helloMessage);
    }

    public void sendReject(short s, String string) {
        RejectMessage rejectMessage = new RejectMessage(this.serializer, s, string);
        this.send(rejectMessage);
    }

    public void sendPing() {
        PingMessage pingMessage = new PingMessage(this.serializer);
        this.send(pingMessage);
    }

    public void sendCustomMessage(byte by, byte[] byArray) {
        MessageType messageType = MessageType.getType(by);
        RawMessage rawMessage = new RawMessage(messageType, this.serializer, byArray);
        this.send(rawMessage);
    }

    private void send(AbstractMessage abstractMessage) {
        if (this.debug != null) {
            long l = System.currentTimeMillis();
            abstractMessage.createDebugTag(System.currentTimeMillis());
            this.debug.log(l, 2057, 0, abstractMessage.getDebugTag());
        }
        this.transport.send(abstractMessage);
        if (this.messageListener != null) {
            this.messageListener.outgoingMessage(abstractMessage);
        }
        if (this.debug != null) {
            this.debug.log(System.currentTimeMillis(), 2065, 0, abstractMessage.getDebugTag());
        }
    }
}

