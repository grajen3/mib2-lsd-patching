/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.agent.command;

import de.esolutions.fw.comm.agent.client.IClientHandler;
import de.esolutions.fw.comm.agent.command.Command;
import de.esolutions.fw.comm.agent.command.ICommandExecutor;

public class ClientHandlerUpdateCommand
extends Command {
    protected IClientHandler clientHandler;
    protected boolean connected;

    public ClientHandlerUpdateCommand(IClientHandler iClientHandler, boolean bl) {
        super("ClientHandlerUpdate");
        this.clientHandler = iClientHandler;
        this.connected = bl;
    }

    @Override
    public boolean handle(ICommandExecutor iCommandExecutor) {
        return iCommandExecutor.doClientHandlerUpdate(this.clientHandler, this.connected);
    }

    @Override
    public String getArgsString() {
        return new StringBuffer().append("agent=#").append(this.clientHandler.getPeerAgentID()).append(" connected=").append(this.connected).toString();
    }
}

