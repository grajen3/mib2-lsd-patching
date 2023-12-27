/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.agent.command;

import de.esolutions.fw.comm.agent.broker.BrokerAgentUpdate;
import de.esolutions.fw.comm.agent.command.Command;
import de.esolutions.fw.comm.agent.command.ICommandExecutor;

public class BrokerAgentUpdateCommand
extends Command {
    protected BrokerAgentUpdate[] updateEvents;

    public BrokerAgentUpdateCommand(BrokerAgentUpdate[] brokerAgentUpdateArray) {
        super("AgentUpdate");
        this.updateEvents = brokerAgentUpdateArray;
    }

    @Override
    public boolean handle(ICommandExecutor iCommandExecutor) {
        return iCommandExecutor.doBrokerAgentUpdate(this.updateEvents);
    }
}

