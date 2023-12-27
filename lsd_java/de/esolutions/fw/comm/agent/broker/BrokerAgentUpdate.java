/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.agent.broker;

public class BrokerAgentUpdate {
    private short agentID;
    private short agentEpoch;

    public BrokerAgentUpdate(short s, short s2) {
        this.agentID = s;
        this.agentEpoch = s2;
    }

    public short getAgentID() {
        return this.agentID;
    }

    public short getAgentEpoch() {
        return this.agentEpoch;
    }
}

