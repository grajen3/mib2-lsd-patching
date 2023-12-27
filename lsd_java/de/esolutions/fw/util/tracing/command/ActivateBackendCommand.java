/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.command;

import de.esolutions.fw.util.tracing.backend.ITraceBackend;
import de.esolutions.fw.util.tracing.command.ITraceCommand;
import de.esolutions.fw.util.tracing.command.ITraceCommandExecutor;

public class ActivateBackendCommand
implements ITraceCommand {
    private final ITraceBackend backend;

    public ActivateBackendCommand(ITraceBackend iTraceBackend) {
        this.backend = iTraceBackend;
    }

    @Override
    public boolean execute(ITraceCommandExecutor iTraceCommandExecutor) {
        iTraceCommandExecutor.activateBackend(this.backend);
        return false;
    }
}

