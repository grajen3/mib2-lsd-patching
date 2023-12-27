/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.agent.command;

import de.esolutions.fw.comm.agent.command.Command;
import de.esolutions.fw.comm.agent.command.ICommandExecutor;

public class ConnectBrokerLinkCommand
extends Command {
    public ConnectBrokerLinkCommand() {
        super("ConnectBrokerLink");
    }

    @Override
    public boolean handle(ICommandExecutor iCommandExecutor) {
        return iCommandExecutor.doConnectBrokerLink();
    }
}

