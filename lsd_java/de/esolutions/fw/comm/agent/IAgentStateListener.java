/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.agent;

import de.esolutions.fw.comm.agent.Agent;

public interface IAgentStateListener {
    default public void agentStarted(Agent agent) {
    }

    default public void agentAboutToStop(Agent agent) {
    }
}

