/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.command;

import de.esolutions.fw.util.tracing.command.ITraceCommand;
import de.esolutions.fw.util.tracing.command.ITraceCommandExecutor;

public class TerminateCommand
implements ITraceCommand {
    @Override
    public boolean execute(ITraceCommandExecutor iTraceCommandExecutor) {
        return true;
    }
}

