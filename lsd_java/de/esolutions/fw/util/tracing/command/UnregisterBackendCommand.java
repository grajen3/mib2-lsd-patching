/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.command;

import de.esolutions.fw.util.tracing.backend.ITraceBackend;
import de.esolutions.fw.util.tracing.command.ITraceCommand;
import de.esolutions.fw.util.tracing.command.ITraceCommandExecutor;

public class UnregisterBackendCommand
implements ITraceCommand {
    private final ITraceBackend backend;

    public UnregisterBackendCommand(ITraceBackend iTraceBackend) {
        this.backend = iTraceBackend;
    }

    @Override
    public boolean execute(ITraceCommandExecutor iTraceCommandExecutor) {
        iTraceCommandExecutor.unregisterBackend(this.backend);
        return false;
    }
}

