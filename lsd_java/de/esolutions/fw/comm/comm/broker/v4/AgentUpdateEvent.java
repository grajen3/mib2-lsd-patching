/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.comm.broker.v4;

public class AgentUpdateEvent {
    public int agent_id;
    public int agent_epoch;

    public int getAgent_id() {
        return this.agent_id;
    }

    public void setAgent_id(int n) {
        this.agent_id = n;
    }

    public int getAgent_epoch() {
        return this.agent_epoch;
    }

    public void setAgent_epoch(int n) {
        this.agent_epoch = n;
    }

    public AgentUpdateEvent() {
    }

    public AgentUpdateEvent(int n, int n2) {
        this.agent_id = n;
        this.agent_epoch = n2;
    }

    public String toString() {
        return new StringBuffer("AgentUpdateEvent{").append("agent_id=").append(this.agent_id).append(", agent_epoch=").append(this.agent_epoch).append("}").toString();
    }
}

