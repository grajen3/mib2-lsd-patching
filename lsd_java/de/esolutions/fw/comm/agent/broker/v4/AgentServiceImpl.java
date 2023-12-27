/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.agent.broker.v4;

import de.esolutions.fw.comm.agent.broker.BrokerAgentUpdate;
import de.esolutions.fw.comm.agent.broker.BrokerServiceUpdate;
import de.esolutions.fw.comm.agent.broker.IBrokerServiceListener;
import de.esolutions.fw.comm.agent.broker.v4.BrokerIDLTool;
import de.esolutions.fw.comm.agent.tracing.CommAgentTracing;
import de.esolutions.fw.comm.comm.broker.v4.Agent;
import de.esolutions.fw.comm.comm.broker.v4.AgentUpdateEvent;
import de.esolutions.fw.comm.comm.broker.v4.UpdateEvent;

public class AgentServiceImpl
implements Agent {
    private final IBrokerServiceListener listener;

    public AgentServiceImpl(IBrokerServiceListener iBrokerServiceListener) {
        this.listener = iBrokerServiceListener;
    }

    @Override
    public void serviceUpdate(UpdateEvent[] updateEventArray) {
        if (updateEventArray == null) {
            return;
        }
        BrokerServiceUpdate[] brokerServiceUpdateArray = new BrokerServiceUpdate[updateEventArray.length];
        for (int i2 = 0; i2 < updateEventArray.length; ++i2) {
            int n;
            int n2;
            short s = (short)(updateEventArray[i2].home_agent_id & 0xFFFF0000);
            switch (updateEventArray[i2].action) {
                case 2: {
                    n2 = 2;
                    break;
                }
                case 0: {
                    n2 = 0;
                    break;
                }
                case 1: {
                    n2 = 1;
                    break;
                }
                default: {
                    CommAgentTracing.BROKER.log((short)4, "Invalid serviceUpdate V3 action received: %1", new Integer(updateEventArray[i2].action));
                    return;
                }
            }
            switch (updateEventArray[i2].reason) {
                case 3: {
                    n = 3;
                    break;
                }
                case 1: {
                    n = 1;
                    break;
                }
                case 2: {
                    n = 2;
                    break;
                }
                case 0: {
                    n = 0;
                    break;
                }
                default: {
                    CommAgentTracing.BROKER.log((short)4, "Invalid serviceUpdate V3 reason received: %1", new Integer(updateEventArray[i2].reason));
                    return;
                }
            }
            brokerServiceUpdateArray[i2] = new BrokerServiceUpdate(n2, n, BrokerIDLTool.convertInstanceIDFromIDL(updateEventArray[i2].svc_id), s);
        }
        this.listener.serviceUpdate(brokerServiceUpdateArray);
    }

    @Override
    public void agentUpdate(AgentUpdateEvent[] agentUpdateEventArray) {
        if (agentUpdateEventArray == null) {
            return;
        }
        BrokerAgentUpdate[] brokerAgentUpdateArray = new BrokerAgentUpdate[agentUpdateEventArray.length];
        for (int i2 = 0; i2 < agentUpdateEventArray.length; ++i2) {
            AgentUpdateEvent agentUpdateEvent = agentUpdateEventArray[i2];
            short s = (short)(agentUpdateEvent.getAgent_id() & 0xFFFF0000);
            short s2 = (short)(agentUpdateEvent.getAgent_epoch() & 0xFFFF0000);
            brokerAgentUpdateArray[i2] = new BrokerAgentUpdate(s, s2);
        }
        this.listener.agentUpdate(brokerAgentUpdateArray);
    }
}

