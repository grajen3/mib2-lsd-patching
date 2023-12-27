/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.agent.broker;

import de.esolutions.fw.comm.agent.broker.BrokerAgentUpdate;
import de.esolutions.fw.comm.agent.broker.BrokerServiceUpdate;

public interface IBrokerServiceListener {
    default public void serviceUpdate(BrokerServiceUpdate[] brokerServiceUpdateArray) {
    }

    default public void agentUpdate(BrokerAgentUpdate[] brokerAgentUpdateArray) {
    }
}

