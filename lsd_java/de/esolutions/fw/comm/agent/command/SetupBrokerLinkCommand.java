/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.agent.command;

import de.esolutions.fw.comm.agent.client.IClientHandler;
import de.esolutions.fw.comm.agent.command.Command;
import de.esolutions.fw.comm.agent.command.ICommandExecutor;

public class SetupBrokerLinkCommand
extends Command {
    private final IClientHandler handler;

    public SetupBrokerLinkCommand(IClientHandler iClientHandler) {
        super("SetupBrokerLink");
        this.setDependentClientHandler(iClientHandler);
        this.handler = iClientHandler;
    }

    @Override
    public boolean handle(ICommandExecutor iCommandExecutor) {
        return iCommandExecutor.doSetupBrokerLink(this.handler);
    }

    @Override
    public void drop(ICommandExecutor iCommandExecutor, boolean bl) {
        iCommandExecutor.dropSetupBrokerLink(this.handler);
    }
}

