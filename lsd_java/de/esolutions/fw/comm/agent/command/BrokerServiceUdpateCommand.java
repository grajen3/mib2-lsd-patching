/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.agent.command;

import de.esolutions.fw.comm.agent.broker.BrokerServiceUpdate;
import de.esolutions.fw.comm.agent.command.Command;
import de.esolutions.fw.comm.agent.command.ICommandExecutor;

public class BrokerServiceUdpateCommand
extends Command {
    protected BrokerServiceUpdate[] updateEvents;

    public BrokerServiceUdpateCommand(BrokerServiceUpdate[] brokerServiceUpdateArray) {
        super("ServiceUpdate");
        this.updateEvents = brokerServiceUpdateArray;
    }

    @Override
    public boolean handle(ICommandExecutor iCommandExecutor) {
        return iCommandExecutor.doBrokerServiceUpdate(this.updateEvents);
    }
}

