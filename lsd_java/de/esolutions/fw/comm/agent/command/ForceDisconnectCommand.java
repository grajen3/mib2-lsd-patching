/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.agent.command;

import de.esolutions.fw.comm.agent.command.Command;
import de.esolutions.fw.comm.agent.command.ICommandExecutor;

public class ForceDisconnectCommand
extends Command {
    short agentId;

    public ForceDisconnectCommand(short s) {
        super("ForceDisconnect");
        this.agentId = s;
    }

    @Override
    public boolean handle(ICommandExecutor iCommandExecutor) {
        return iCommandExecutor.doForceDisconnect(this.agentId);
    }
}

