/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.command;

import de.esolutions.fw.util.tracing.command.ITraceCommand;
import de.esolutions.fw.util.tracing.command.ITraceCommandExecutor;

public class InitCommand
implements ITraceCommand {
    @Override
    public boolean execute(ITraceCommandExecutor iTraceCommandExecutor) {
        iTraceCommandExecutor.init();
        return false;
    }
}

