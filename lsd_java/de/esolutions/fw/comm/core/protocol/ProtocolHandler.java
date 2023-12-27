/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.core.protocol;

import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.message.AbstractMessage;
import de.esolutions.fw.comm.core.message.AnnounceFeatureMessage;
import de.esolutions.fw.comm.core.message.AnnounceFeatureMessageV4;
import de.esolutions.fw.comm.core.message.BrokerAckMessage;
import de.esolutions.fw.comm.core.message.BrokerAckMessageV4;
import de.esolutions.fw.comm.core.message.CallMethodMessage;
import de.esolutions.fw.comm.core.message.CreateRRStubMessage;
import de.esolutions.fw.comm.core.message.CreateStubMessage;
import de.esolutions.fw.comm.core.message.DestroyStubMessage;
import de.esolutions.fw.comm.core.message.HelloMessage;
import de.esolutions.fw.comm.core.message.ICallMethodSerializeCallback;
import de.esolutions.fw.comm.core.message.IMessageListener;
import de.esolutions.fw.comm.core.message.InitMessage;
import de.esolutions.fw.comm.core.message.InitMessageV4;
import de.esolutions.fw.comm.core.message.MessageReceiver;
import de.esolutions.fw.comm.core.message.MessageSender;
import de.esolutions.fw.comm.core.message.MessageType;
import de.esolutions.fw.comm.core.message.PingMessage;
import de.esolutions.fw.comm.core.message.ProxyAliveMessage;
import de.esolutions.fw.comm.core.message.RRStubCreatedMessage;
import de.esolutions.fw.comm.core.message.RejectMessage;
import de.esolutions.fw.comm.core.message.SetFeatureMessage;
import de.esolutions.fw.comm.core.message.StubCreatedMessage;
import de.esolutions.fw.comm.core.message.StubFailedMessage;
import de.esolutions.fw.comm.core.protocol.IProtocolActions;
import de.esolutions.fw.comm.core.protocol.IProtocolCallbacks;
import de.esolutions.fw.comm.core.protocol.IProtocolDecider;
import de.esolutions.fw.comm.core.protocol.ProtocolException;
import de.esolutions.fw.comm.core.tracing.CommCoreTracing;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.connection.Connection;
import de.esolutions.fw.util.transport.IReadable;
import de.esolutions.fw.util.transport.debug.ITransportDebug;

public class ProtocolHandler {
    public static final short DYNAMIC_AGENT_ID_BIT;
    public static final int STATE_INIT;
    public static final int STATE_CONNECTED;
    public static final int STATE_EXIT;
    public static final int STATE_DISCONNECTED;
    public static final int STATE_ERROR;
    public static final int STATE_DROPPED;
    public static final byte PROTOCOL_V5;
    protected short agentID;
    protected short agentEpoch;
    protected short peerAgentID;
    protected short peerAgentEpoch;
    protected Connection connection;
    protected IProtocolActions actions;
    protected IProtocolCallbacks callbacks;
    protected MessageSender sender;
    protected MessageReceiver receiver;
    protected int state;
    protected boolean withBroker;
    protected boolean dynamicAgentId;
    protected byte protocolVersion;
    protected byte activeProtocolVersion;
    protected boolean iAmMaster;
    protected short brokerAgentID;
    protected ServiceInstanceID brokerInstanceID;
    protected IProtocolDecider decider;
    protected Object owner;

    public ProtocolHandler(short s, short s2, Connection connection, boolean bl, boolean bl2, byte by, IProtocolCallbacks iProtocolCallbacks) {
        this.agentID = s;
        this.agentEpoch = s2;
        this.connection = connection;
        this.sender = new MessageSender(connection, by);
        this.receiver = new MessageReceiver(connection, by);
        this.state = 0;
        this.withBroker = bl;
        this.protocolVersion = by;
        this.iAmMaster = false;
        this.dynamicAgentId = bl2;
        this.callbacks = iProtocolCallbacks;
    }

    public void setMessageListener(IMessageListener iMessageListener) {
        this.sender.setMessageListener(iMessageListener);
        this.receiver.setMessageListener(iMessageListener);
    }

    public void setDebug(ITransportDebug iTransportDebug) {
        this.sender.setDebug(iTransportDebug);
        this.receiver.setDebug(iTransportDebug);
    }

    public synchronized void setConnection(Connection connection) {
        this.connection = connection;
        this.sender.setConnection(connection);
    }

    public void setActionHandler(IProtocolActions iProtocolActions) {
        this.actions = iProtocolActions;
    }

    public void setDecider(IProtocolDecider iProtocolDecider, Object object) {
        this.decider = iProtocolDecider;
        this.owner = object;
    }

    public int getState() {
        return this.state;
    }

    public short getPeerAgentID() {
        return this.peerAgentID;
    }

    public short getPeerAgentEpoch() {
        return this.peerAgentEpoch;
    }

    public short getAgentID() {
        return this.agentID;
    }

    public short getAgentEpoch() {
        return this.agentEpoch;
    }

    public byte getActiveProtocolVersion() {
        return this.activeProtocolVersion;
    }

    public ServiceInstanceID getBrokerInstanceID() {
        return this.brokerInstanceID;
    }

    public void setBrokerInstanceID(ServiceInstanceID serviceInstanceID) {
        this.brokerInstanceID = serviceInstanceID;
    }

    public synchronized boolean disconnect() {
        if (this.state != 1) {
            throw new ProtocolException("disconnect only allowed in CONNECTED state");
        }
        this.sender.sendExit();
        return true;
    }

    public synchronized void sendCreateStub(short s, ServiceInstanceID serviceInstanceID) {
        CommCoreTracing.PROTOCOL.log((short)1, "  outgoing CREATE_STUB: proxyID=%1 instanceID=%2", new Short(s), (Object)serviceInstanceID);
        this.sender.sendCreateStub(this.agentID, s, serviceInstanceID);
    }

    public synchronized void sendProxyAlive(short s) {
        CommCoreTracing.PROTOCOL.log((short)1, "  outgoing PROXY_ALIVE: stubID=%1", new Short(s));
        this.sender.sendProxyAlive(s);
    }

    public synchronized void sendDestroyStub(short s) {
        CommCoreTracing.PROTOCOL.log((short)1, "  outgoing DESTROY_STUB: stubID=%1", new Short(s));
        this.sender.sendDestroyStub(s);
    }

    public synchronized void sendCallMethod(short s, short s2, ISerializable iSerializable, ICallMethodSerializeCallback iCallMethodSerializeCallback) {
        CommCoreTracing.PROTOCOL.log((short)0, "  outgoing CALL_METHOD: stubID=%1 methodID=%2", new Short(s), (Object)new Short(s2));
        this.sender.sendCallMethod(s, s2, iSerializable, iCallMethodSerializeCallback);
    }

    public synchronized void sendStubCreated(short s, short s2) {
        CommCoreTracing.PROTOCOL.log((short)1, "  outgoing STUB_CREATED: proxyID=%1 stubID=%2", new Short(s), (Object)new Short(s2));
        this.sender.sendStubCreated(s, s2);
    }

    public synchronized void sendRRStubCreated(short s, short s2, short s3) {
        CommCoreTracing.PROTOCOL.log((short)1, "  outgoing RRSTUB_CREATED: proxyID=%1 stubID=%2 replyProxyID=%3", new Short(s), (Object)new Short(s2), (Object)new Short(s3));
        this.sender.sendRRStubCreated(s, s2, s3);
    }

    public synchronized void sendCreateRRStub(short s, short s2, ServiceInstanceID serviceInstanceID, ServiceInstanceID serviceInstanceID2) {
        CommCoreTracing.PROTOCOL.log((short)1, "  outgoing CREATE_RRSTUB: proxyID=%1 stubID=%2 agentID=%3 instanceID=%4 replyInstanceID=%5", new Short(s), (Object)new Short(s2), (Object)new Short(this.agentID), (Object)serviceInstanceID, (Object)serviceInstanceID2);
        this.sender.sendCreateRRStub(this.agentID, s, s2, serviceInstanceID, serviceInstanceID2);
    }

    public synchronized void sendStubFailed(short s, byte by) {
        CommCoreTracing.PROTOCOL.log((short)1, "  outgoing STUB_FAILED: proxyID=%1 errorCode=%2", new Short(s), (Object)new Byte(by));
        this.sender.sendStubFailed(s, by);
    }

    public synchronized void sendPing() {
        CommCoreTracing.PROTOCOL.log((short)1, "  outgoing PING");
        this.sender.sendPing();
    }

    public boolean handleIncomingMessage() {
        if (this.state != 1) {
            throw new ProtocolException("handle incoming message only allowed in CONNECTED state");
        }
        AbstractMessage abstractMessage = this.recvMessage();
        return this.dispatchMessage(abstractMessage);
    }

    public AbstractMessage recvMessage() {
        return this.receiver.recvMessage();
    }

    public boolean dispatchMessage(AbstractMessage abstractMessage) {
        MessageType messageType = abstractMessage.getMessageType();
        if (messageType == MessageType.EXIT) {
            this.state = 2;
            return false;
        }
        if (messageType == MessageType.STUB_CREATED) {
            StubCreatedMessage stubCreatedMessage = (StubCreatedMessage)abstractMessage;
            CommCoreTracing.PROTOCOL.log((short)1, "  incoming STUB_CREATED: proxyID=%1 stubID=%2", new Short(stubCreatedMessage.getProxyID()), (Object)new Short(stubCreatedMessage.getStubID()));
            if (this.actions != null) {
                this.actions.handleStubCreated(stubCreatedMessage.getProxyID(), stubCreatedMessage.getStubID());
            }
        } else if (messageType == MessageType.RRSTUB_CREATED) {
            RRStubCreatedMessage rRStubCreatedMessage = (RRStubCreatedMessage)abstractMessage;
            CommCoreTracing.PROTOCOL.log((short)1, "  incoming RRSTUB_CREATED: proxyID=%1 stubID=%2 replyProxyID=%3", new Short(rRStubCreatedMessage.getProxyID()), (Object)new Short(rRStubCreatedMessage.getStubID()), (Object)new Short(rRStubCreatedMessage.getReplyProxyID()));
            if (this.actions != null) {
                this.actions.handleRRStubCreated(rRStubCreatedMessage.getProxyID(), rRStubCreatedMessage.getStubID(), rRStubCreatedMessage.getReplyProxyID());
            }
        } else if (messageType == MessageType.CREATE_STUB) {
            CreateStubMessage createStubMessage = (CreateStubMessage)abstractMessage;
            CommCoreTracing.PROTOCOL.log((short)1, "  incoming CREATE_STUB: agentID=%1 proxyID=%2 instanceID=%3 replyInstanceID=%4", new Short(createStubMessage.getAgentID()), (Object)new Short(createStubMessage.getProxyID()), (Object)createStubMessage.getInstanceID());
            if (this.actions != null) {
                this.actions.handleCreateStub(createStubMessage.getAgentID(), createStubMessage.getProxyID(), createStubMessage.getInstanceID());
            }
        } else if (messageType == MessageType.CREATE_RRSTUB) {
            CreateRRStubMessage createRRStubMessage = (CreateRRStubMessage)abstractMessage;
            CommCoreTracing.PROTOCOL.log((short)1, "  incoming CREATE_RRSTUB: agentID=%1 proxyID=%2 instanceID=%3 replyInstanceID=%4 stubID=%5", new Short(createRRStubMessage.getAgentID()), (Object)new Short(createRRStubMessage.getProxyID()), (Object)createRRStubMessage.getInstanceID(), (Object)createRRStubMessage.getReplyInstanceID(), (Object)new Short(createRRStubMessage.getStubID()));
            if (this.actions != null) {
                this.actions.handleCreateRRStub(createRRStubMessage.getAgentID(), createRRStubMessage.getProxyID(), createRRStubMessage.getInstanceID(), createRRStubMessage.getReplyInstanceID(), createRRStubMessage.getStubID());
            }
        } else if (messageType == MessageType.STUB_FAILED) {
            StubFailedMessage stubFailedMessage = (StubFailedMessage)abstractMessage;
            CommCoreTracing.PROTOCOL.log((short)1, "  incoming STUB_FAILED: proxyID=%1 errorCode=%2", new Short(stubFailedMessage.getProxyID()), (Object)new Byte(stubFailedMessage.getErrorCode()));
            if (this.actions != null) {
                this.actions.handleStubFailed(stubFailedMessage.getProxyID(), stubFailedMessage.getErrorCode());
            }
        } else if (messageType == MessageType.DESTROY_STUB) {
            DestroyStubMessage destroyStubMessage = (DestroyStubMessage)abstractMessage;
            CommCoreTracing.PROTOCOL.log((short)1, "  incoming DESTROY_STUB: stubID=%1", new Short(destroyStubMessage.getStubID()));
            if (this.actions != null) {
                this.actions.handleDestroyStub(destroyStubMessage.getStubID());
            }
        } else if (messageType == MessageType.CALL_METHOD) {
            CallMethodMessage callMethodMessage = (CallMethodMessage)abstractMessage;
            CommCoreTracing.PROTOCOL.log((short)0, "  incoming CALL_METHOD: stubID=%1 methodID=%2", new Short(callMethodMessage.getStubID()), (Object)new Short(callMethodMessage.getMethodID()));
            if (this.actions != null) {
                IReadable iReadable = callMethodMessage.getPayload();
                IDeserializer iDeserializer = null;
                if (iReadable != null) {
                    iDeserializer = callMethodMessage.getDeserializer();
                    iDeserializer.attachBuffer(callMethodMessage.getPayload());
                }
                this.actions.handleCallMethod(callMethodMessage.getStubID(), callMethodMessage.getMethodID(), iDeserializer);
                if (iReadable != null) {
                    iDeserializer.detachBuffer();
                }
            }
        } else if (messageType == MessageType.PROXY_ALIVE) {
            ProxyAliveMessage proxyAliveMessage = (ProxyAliveMessage)abstractMessage;
            CommCoreTracing.PROTOCOL.log((short)1, "  incoming PROXY_ALIVE: stubID=%1", new Short(proxyAliveMessage.getStubID()));
            if (this.actions != null) {
                this.actions.handleProxyAlive(proxyAliveMessage.getStubID());
            }
        } else if (messageType == MessageType.PING) {
            PingMessage pingMessage = (PingMessage)abstractMessage;
            CommCoreTracing.PROTOCOL.log((short)1, "  incoming PING");
            if (this.actions != null) {
                this.actions.handlePing();
            }
        }
        return true;
    }

    public synchronized void sendCostumMessage(byte by, byte[] byArray) {
        CommCoreTracing.PROTOCOL.log((short)1, "  outgoing CUSTOM_MESSAGE: MessageType=%1", new Byte(by));
        this.sender.sendCustomMessage(by, byArray);
    }

    public boolean connectActive(short s) {
        Object object;
        Object object2;
        if (this.state != 0) {
            throw new ProtocolException("connect only allowed in INIT state");
        }
        this.peerAgentID = s;
        this.peerAgentEpoch = 0;
        CommCoreTracing.HANDSHAKE.log((short)1, "Handshake Active: connect Active withBroker=%1, dynamicAgentId=%2, agentId=%3, peerAgentID=%4", new Boolean(this.withBroker), (Object)new Boolean(this.dynamicAgentId), (Object)new Short(this.agentID), (Object)new Short(this.peerAgentID));
        this.iAmMaster = this.withBroker && this.dynamicAgentId ? false : ProtocolHandler.determineMasterRole(this.agentID, this.peerAgentID);
        if (this.decider != null && this.decider.reportProtocolRole(this.iAmMaster, this.peerAgentID, this.owner)) {
            CommCoreTracing.HANDSHAKE.log((short)1, "Handshake Active: send _early_ DROP to peerAgentId=%1 (done)", new Short(this.peerAgentID));
            this.sender.sendDrop();
            this.state = 5;
            return false;
        }
        if (this.iAmMaster) {
            CommCoreTracing.HANDSHAKE.log((short)1, "Handshake Active: I am Master!");
            if (this.decider != null && this.decider.decideProtocolDrop(this.peerAgentID, this.owner)) {
                CommCoreTracing.HANDSHAKE.log((short)1, "Handshake Active: send DROP to peerAgentId=%1 (done)", new Short(this.peerAgentID));
                this.sender.sendDrop();
                this.state = 5;
                return false;
            }
        } else {
            CommCoreTracing.HANDSHAKE.log((short)1, "Handshake Active: I am Slave!");
        }
        short s2 = this.agentID;
        if (this.withBroker && this.dynamicAgentId) {
            if (this.callbacks != null) {
                object2 = this.callbacks.getAgentIdProposal();
                if (object2 != null) {
                    s2 = (Short)object2;
                }
                CommCoreTracing.HANDSHAKE.log((short)1, "Handshake Active: using proposalId =  %1", object2);
            }
            s2 = (short)(s2 | Short.MIN_VALUE);
            CommCoreTracing.HANDSHAKE.log((short)1, "Handshake Active: dynamicAgentId, request agentId %1, sending id %2", new Short(this.agentID), (Object)new Short(s2));
        }
        CommCoreTracing.HANDSHAKE.log((short)1, "Handshake Active: begin: send INIT protocol=%1 fromAgentId=%2@%3 toAgentId=%4, initAgentId=%5", new Byte(this.protocolVersion), (Object)new Short(this.agentID), (Object)new Short(this.agentEpoch), (Object)new Short(s), (Object)new Short(s2));
        this.sender.sendInit(s2, this.protocolVersion, this.agentEpoch);
        this.activeProtocolVersion = this.protocolVersion;
        CommCoreTracing.HANDSHAKE.log((short)1, "Handshake Active: wait for ANNOUNCE_FEATURE");
        object2 = this.receiver.recvAnnounceFeatureMessage();
        if (object2 == null) {
            CommCoreTracing.HANDSHAKE.log((short)1, "Handshake Active: received DROP from peer (done)");
            this.state = 5;
            return false;
        }
        AnnounceFeatureMessageV4 announceFeatureMessageV4 = (AnnounceFeatureMessageV4)object2;
        this.peerAgentEpoch = announceFeatureMessageV4.getAgentEpoch();
        CommCoreTracing.HANDSHAKE.log((short)1, "Handshake Active: got ANNOUNCE_FEATURE: agentId=%1 feature=%2 agentEpoch=%3", new Short(((AnnounceFeatureMessage)object2).getAgentID()), (Object)new Short(((AnnounceFeatureMessage)object2).getFeature()), (Object)new Short(announceFeatureMessageV4.getAgentEpoch()));
        if (this.peerAgentID != ((AnnounceFeatureMessage)object2).getAgentID()) {
            CommCoreTracing.HANDSHAKE.log((short)1, "Handshake Active: ERROR: peerAgentID mismatch: expected=%1 got=%2", new Short(this.peerAgentID), (Object)new Short(((AnnounceFeatureMessage)object2).getAgentID()));
            this.state = 4;
            return false;
        }
        CommCoreTracing.HANDSHAKE.log((short)1, "Handshake Active: send SET_FEATURE");
        this.sender.sendSetFeature(((AnnounceFeatureMessage)object2).getFeature());
        if (this.withBroker) {
            CommCoreTracing.HANDSHAKE.log((short)1, "Handshake Active: wait for BROKER_ACK");
            object = this.receiver.recvBrokerAckMessage();
            this.brokerAgentID = ((BrokerAckMessage)object).getBrokerAgentID();
            this.brokerInstanceID = ((BrokerAckMessage)object).getBrokerInstanceID();
            BrokerAckMessageV4 brokerAckMessageV4 = (BrokerAckMessageV4)object;
            short s3 = brokerAckMessageV4.getAssignedAgentID();
            short s4 = brokerAckMessageV4.getAssignedAgentEpoch();
            if (this.dynamicAgentId) {
                CommCoreTracing.HANDSHAKE.log((short)1, "Handshake Active: got BROKER_ACK: assignedAgentID=%1", new Short(s3));
            }
            if (this.dynamicAgentId && (s3 & Short.MIN_VALUE) == Short.MIN_VALUE) {
                CommCoreTracing.HANDSHAKE.log((short)4, "Handshake Active: ERROR: broker send agentId with dynamic agent id bit, something went wrong ");
                this.state = 4;
                return false;
            }
            if (s3 != this.agentID) {
                this.agentID = s3;
                CommCoreTracing.HANDSHAKE.log((short)1, "Handshake Active: got BROKER_ACK: assign new agent id: %1", new Short(this.agentID));
            }
            if (s4 != this.agentEpoch) {
                this.agentEpoch = s4;
                CommCoreTracing.HANDSHAKE.log((short)1, "Handshake Active: got BROKER_ACK: assign new agent epoch: %1", new Short(this.agentEpoch));
            }
            CommCoreTracing.HANDSHAKE.log((short)1, "Handshake Active: got BROKER_ACK: brokerAgentID=%1 brokerInstanceID=%2", new Short(this.brokerAgentID), (Object)this.brokerInstanceID);
        }
        if (this.decider != null && (object = this.decider.setupProtocolActions(this.peerAgentID, this.owner)) != null) {
            CommCoreTracing.HANDSHAKE.log((short)1, "Handshake Active: set actions via decider");
            this.actions = object;
        }
        CommCoreTracing.HANDSHAKE.log((short)1, "Handshake Active: done");
        this.state = 1;
        return true;
    }

    public boolean connectPassive() {
        CommCoreTracing.HANDSHAKE.log((short)1, "Handshake Passive: wait for INIT");
        boolean bl = false;
        do {
            AbstractMessage abstractMessage;
            if ((abstractMessage = this.receiver.recvInitOrHelloMessage()) == null) {
                CommCoreTracing.HANDSHAKE.log((short)1, "Handshake Passive: received DROP from peer (done)");
                this.state = 5;
                bl = true;
                return false;
            }
            if (abstractMessage.getMessageType() == MessageType.INIT) {
                bl = true;
                return this.connectPassiveV5((InitMessage)abstractMessage);
            }
            if (abstractMessage.getMessageType() != MessageType.HELLO) continue;
            bl = false;
            this.connectPassiveV6((HelloMessage)abstractMessage);
        } while (!bl);
        return false;
    }

    public boolean connectPassiveV6(HelloMessage helloMessage) {
        this.sender.sendReject((short)2, RejectMessage.ERROR_NAMES[2]);
        return true;
    }

    public boolean connectPassiveV5(InitMessage initMessage) {
        IProtocolActions iProtocolActions;
        byte by = initMessage.getProtocolRevision();
        CommCoreTracing.HANDSHAKE.log((short)1, "Handshake Passive: got agent=%1 protocol=%2 own protocol %3", new Short(initMessage.getAgentID()), (Object)new Short(initMessage.getProtocolRevision()), (Object)new Short(this.protocolVersion));
        this.peerAgentID = initMessage.getAgentID();
        if (by != this.protocolVersion) {
            CommCoreTracing.HANDSHAKE.log((short)1, "Handshake Passive: ERROR: protocol version mismatch: mine=%1 theirs=%2", new Byte(this.protocolVersion), (Object)new Byte(by));
            this.state = 4;
            return false;
        }
        this.activeProtocolVersion = by;
        if (!(initMessage instanceof InitMessageV4)) {
            CommCoreTracing.HANDSHAKE.log((short)4, "Handshake Passive: ERROR: wrong InitMessage received, no instance of InitMessageV4");
            return false;
        }
        this.peerAgentEpoch = ((InitMessageV4)initMessage).getAgentEpoch();
        this.iAmMaster = ProtocolHandler.determineMasterRole(this.agentID, this.peerAgentID);
        if (this.decider != null && this.decider.reportProtocolRole(this.iAmMaster, this.peerAgentID, this.owner)) {
            CommCoreTracing.HANDSHAKE.log((short)1, "Handshake Passive: send _early_ DROP to peerAgentId=%1 (done)", new Short(this.peerAgentID));
            this.sender.sendDrop();
            this.state = 5;
            return false;
        }
        if (this.iAmMaster) {
            CommCoreTracing.HANDSHAKE.log((short)1, "Handshake Passive: I am Master!");
            if (this.decider != null && this.decider.decideProtocolDrop(this.peerAgentID, this.owner)) {
                CommCoreTracing.HANDSHAKE.log((short)1, "Handshake Passive: send DROP to peerAgentId=%1 (done)", new Short(this.peerAgentID));
                this.sender.sendDrop();
                this.state = 5;
                return false;
            }
        }
        CommCoreTracing.HANDSHAKE.log((short)1, "Handshake Passive: send ANNOUNCE_FEATURE");
        byte by2 = this.connection.getSerializer().getSerializerId();
        this.sender.sendAnnounceFeature(this.agentID, by2, this.agentEpoch);
        CommCoreTracing.HANDSHAKE.log((short)1, "Handshake Passive: get SET_FEATURE");
        SetFeatureMessage setFeatureMessage = this.receiver.recvSetFeatureMessage();
        byte by3 = setFeatureMessage.getValue();
        if (by2 != by3) {
            CommCoreTracing.HANDSHAKE.log((short)1, "Handshake Passive: ERROR: serializer id mismatch!");
            this.state = 4;
            return false;
        }
        if (this.withBroker) {
            short s = this.peerAgentID;
            short s2 = this.peerAgentEpoch;
            CommCoreTracing.HANDSHAKE.log((short)1, "Handshake Passive: send BROKER_ACK");
            this.sender.sendBrokerAck(this.brokerAgentID, this.brokerInstanceID, s, s2);
        }
        if (this.decider != null && (iProtocolActions = this.decider.setupProtocolActions(this.peerAgentID, this.owner)) != null) {
            CommCoreTracing.HANDSHAKE.log((short)1, "Handshake Passive: set actions via decider");
            this.actions = iProtocolActions;
        }
        CommCoreTracing.HANDSHAKE.log((short)1, "Handshake Passive: done");
        this.state = 1;
        return true;
    }

    public static boolean determineMasterRole(short s, short s2) {
        return s > s2;
    }
}

