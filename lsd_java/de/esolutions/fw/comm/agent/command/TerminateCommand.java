/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.agent.command;

import de.esolutions.fw.comm.agent.command.Command;
import de.esolutions.fw.comm.agent.command.ICommandExecutor;

public class TerminateCommand
extends Command {
    public TerminateCommand() {
        super("Terminate");
    }

    @Override
    public boolean handle(ICommandExecutor iCommandExecutor) {
        return false;
    }
}

