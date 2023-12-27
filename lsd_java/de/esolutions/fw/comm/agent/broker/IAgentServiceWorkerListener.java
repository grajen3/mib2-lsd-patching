/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.agent.broker;

public interface IAgentServiceWorkerListener {
    default public void brokerConnectedToAgentService() {
    }

    default public void brokerDisconnectedFromAgentService() {
    }

    default public void brokerCallFailed() {
    }
}

