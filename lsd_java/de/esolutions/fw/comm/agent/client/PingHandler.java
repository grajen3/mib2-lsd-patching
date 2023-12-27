/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.agent.client;

import de.esolutions.fw.comm.agent.config.CommConfig;
import de.esolutions.fw.comm.agent.config.CommConfigDynamicAgentIDs;
import de.esolutions.fw.comm.agent.config.CommConfigPing;
import de.esolutions.fw.comm.agent.tracing.CommAgentTracing;
import de.esolutions.fw.comm.core.message.AbstractMessage;
import de.esolutions.fw.comm.core.message.IMessageListener;
import de.esolutions.fw.comm.core.message.MessageType;
import de.esolutions.fw.comm.core.protocol.ProtocolHandler;
import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.fw.util.commons.timeout.ITimeSource;
import de.esolutions.fw.util.commons.timeout.TimeSourceProvider;

public class PingHandler
implements IMessageListener {
    private final short conId;
    private final short peerAgentId;
    private final int sendInterval;
    private final int maxRecvInterval;
    private final ITimeSource timeSource;
    private final ProtocolHandler protocolHandler;
    private final CommConfigPing config;
    private boolean sendPing;
    private boolean checkPing;
    private long lastOutgoingPacketTimestamp;
    private long lastIncomingPacketTimestamp;
    private boolean didRecvPing;
    private boolean doSendFirstPing = true;
    private boolean injectFailed = false;

    public static PingHandler create(CommConfig commConfig, ProtocolHandler protocolHandler, short s, short s2) {
        CommConfigPing commConfigPing = commConfig.getPingConfig();
        if (commConfigPing == null) {
            CommAgentTracing.PINGHANDLER.log((short)2, "$%1(%2) no ping config. disabled.", new Short(s), (Object)new Short(s2));
            return null;
        }
        if (PingHandler.isPeerValid(s2, commConfig)) {
            return new PingHandler(commConfigPing, protocolHandler, s, s2);
        }
        CommAgentTracing.PINGHANDLER.log((short)2, "$%1(%2) ping is not allowed. disabled.", new Short(s), (Object)new Short(s2));
        return null;
    }

    private static boolean isPeerValid(short s, CommConfig commConfig) {
        short[] sArray;
        CommConfigPing commConfigPing = commConfig.getPingConfig();
        if (commConfigPing.getAllPeers()) {
            CommAgentTracing.PINGHANDLER.log((short)1, "peer: %1 matches 'all'", new Short(s));
            return true;
        }
        boolean bl = false;
        CommConfigDynamicAgentIDs commConfigDynamicAgentIDs = commConfig.getDynamicAgentIdsConfig();
        if (commConfigDynamicAgentIDs != null) {
            bl = commConfigDynamicAgentIDs.isDynamicAgentID(s);
        }
        if (bl) {
            if (commConfigPing.getDynamicPeers()) {
                CommAgentTracing.PINGHANDLER.log((short)1, "peer: %1 matches 'dynamic'", new Short(s));
                return true;
            }
        } else if (commConfigPing.getStaticPeers()) {
            CommAgentTracing.PINGHANDLER.log((short)1, "peer: %1 matches 'static'", new Short(s));
            return true;
        }
        if ((sArray = commConfigPing.getPeerList()) != null) {
            for (int i2 = 0; i2 < sArray.length; ++i2) {
                if (sArray[i2] != s) continue;
                CommAgentTracing.PINGHANDLER.log((short)1, "peer: %1 matches peer list", new Short(s));
                return true;
            }
        }
        CommAgentTracing.PINGHANDLER.log((short)1, "peer: %1 NO MATCH", new Short(s));
        return false;
    }

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append("[$");
        buffer.append(this.conId);
        buffer.append("(");
        buffer.append(this.peerAgentId);
        buffer.append("): startSend=");
        buffer.append(this.config.getStartSend());
        buffer.append(",checkEnabled=");
        buffer.append(this.config.getCheckEnabled());
        buffer.append(",autoReply=");
        buffer.append(this.config.getAutoReply());
        buffer.append(",sendInterval=");
        buffer.append(this.sendInterval);
        buffer.append(",maxRecvInterval=");
        buffer.append(this.maxRecvInterval);
        buffer.append("]");
        return buffer.toString();
    }

    public PingHandler(CommConfigPing commConfigPing, ProtocolHandler protocolHandler, short s, short s2) {
        this.config = commConfigPing;
        this.conId = s;
        this.peerAgentId = s2;
        this.sendPing = commConfigPing.getStartSend();
        this.sendInterval = commConfigPing.getSendInterval();
        this.maxRecvInterval = commConfigPing.getMaxRecvInterval();
        this.protocolHandler = protocolHandler;
        this.timeSource = TimeSourceProvider.getMonotonicTimeSource();
        CommAgentTracing.PINGHANDLER.log((short)2, "$%2(%3) PingHandler started: %1", this, (Object)new Short(s), (Object)new Short(s2));
    }

    @Override
    public void incomingMessage(AbstractMessage abstractMessage) {
        this.lastIncomingPacketTimestamp = this.timeSource.getCurrentTime();
        if (abstractMessage.getMessageType() == MessageType.PING) {
            CommAgentTracing.PINGHANDLER_RX.log((short)1, "$%1(%2) Received Ping", new Short(this.conId), (Object)new Short(this.peerAgentId));
        } else {
            CommAgentTracing.PINGHANDLER_RX.log((short)0, "$%1(%2) Received Packet [msgType=%3]", new Short(this.conId), (Object)new Short(this.peerAgentId), (Object)abstractMessage.getMessageType().toString());
        }
        if (!this.didRecvPing && abstractMessage.getMessageType() == MessageType.PING && this.maxRecvInterval > 0) {
            this.didRecvPing = true;
            if (this.config.getCheckEnabled()) {
                this.checkPing = true;
                CommAgentTracing.PINGHANDLER.log((short)2, "$%1(%2) enable PING observation. max recv timeout=%3", new Short(this.conId), (Object)new Short(this.peerAgentId), (Object)new Integer(this.maxRecvInterval));
            } else {
                CommAgentTracing.PINGHANDLER.log((short)2, "$%1(%2) PING received but observation is disabled", new Short(this.conId), (Object)new Short(this.peerAgentId));
            }
            if (!this.sendPing && this.config.getAutoReply()) {
                this.sendPing = true;
                CommAgentTracing.PINGHANDLER.log((short)2, "$%1(%2) auto reply: enable PING sending", new Short(this.conId), (Object)new Short(this.peerAgentId));
            }
        }
    }

    @Override
    public void outgoingMessage(AbstractMessage abstractMessage) {
        this.lastOutgoingPacketTimestamp = this.timeSource.getCurrentTime();
        CommAgentTracing.PINGHANDLER_TX.log((short)0, "$%1(%2) sending packet [msgType=%3]", new Short(this.conId), (Object)new Short(this.peerAgentId), (Object)abstractMessage.getMessageType().toString());
    }

    public boolean timerTick() {
        long l = this.timeSource.getCurrentTime();
        boolean bl = true;
        if (this.sendPing) {
            bl = this.handleSendPing(l);
        }
        boolean bl2 = true;
        if (this.checkPing) {
            bl2 = this.handleRecvPing(l);
        }
        return bl && bl2;
    }

    private boolean handleRecvPing(long l) {
        long l2 = l - this.lastIncomingPacketTimestamp;
        CommAgentTracing.PINGHANDLER.log((short)0, "$%1(%2) recv delta=%3, cfg max interval=%4", new Short(this.conId), (Object)new Short(this.peerAgentId), (Object)new Long(l2), (Object)new Integer(this.maxRecvInterval));
        if (l2 >= (long)this.maxRecvInterval) {
            CommAgentTracing.PINGHANDLER.log((short)3, "$%1(%2) recv timeout detected: delta=%3, max interval=%4", new Short(this.conId), (Object)new Short(this.peerAgentId), (Object)new Long(l2), (Object)new Integer(this.maxRecvInterval));
            return false;
        }
        return true;
    }

    private boolean handleSendPing(long l) {
        long l2 = l - this.lastOutgoingPacketTimestamp;
        CommAgentTracing.PINGHANDLER.log((short)0, "$%1(%2): send delta=%3, cfg interval=%4", new Short(this.conId), (Object)new Short(this.peerAgentId), (Object)new Long(l2), (Object)new Integer(this.sendInterval));
        if (this.doSendFirstPing || l2 >= (long)this.sendInterval) {
            if (this.injectFailed) {
                CommAgentTracing.PINGHANDLER.log((short)3, "timerTick sending PING failed, injected by User, [use this only for testing]");
                return false;
            }
            try {
                this.lastOutgoingPacketTimestamp = this.timeSource.getCurrentTime();
                this.protocolHandler.sendPing();
                CommAgentTracing.PINGHANDLER_TX.log((short)1, "$%1(%2) send PING (first %3)", new Short(this.conId), (Object)new Short(this.peerAgentId), (Object)new Boolean(this.doSendFirstPing));
                this.doSendFirstPing = false;
            }
            catch (Exception exception) {
                CommAgentTracing.PINGHANDLER.log((short)3, "$%2(%3) timerTick sending ping failed: %1", exception, (Object)new Short(this.conId), (Object)new Short(this.peerAgentId));
                return false;
            }
        }
        return true;
    }

    public void parseControlCommand(String string) {
        this.injectFailed();
    }

    public void injectFailed() {
        this.injectFailed = true;
    }

    public String getEndpointID() {
        return null;
    }
}

