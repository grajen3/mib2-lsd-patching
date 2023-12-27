/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.agent.command;

import de.esolutions.fw.comm.agent.command.Command;
import de.esolutions.fw.comm.agent.command.ICommandExecutor;

public class BrokerProxyAliveCommand
extends Command {
    public BrokerProxyAliveCommand() {
        super("BrokerProxyAlive");
    }

    @Override
    public boolean handle(ICommandExecutor iCommandExecutor) {
        return iCommandExecutor.doBrokerProxyAlive();
    }
}

