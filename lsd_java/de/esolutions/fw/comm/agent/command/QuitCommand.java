/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.agent.command;

import de.esolutions.fw.comm.agent.command.Command;
import de.esolutions.fw.comm.agent.command.ICommandExecutor;

public class QuitCommand
extends Command {
    public QuitCommand() {
        super("Quit");
    }

    @Override
    public boolean handle(ICommandExecutor iCommandExecutor) {
        return iCommandExecutor.doQuit();
    }
}

