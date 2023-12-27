/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.command;

import de.esolutions.fw.util.tracing.backend.ITraceBackend;
import de.esolutions.fw.util.tracing.command.ITraceCommand;
import de.esolutions.fw.util.tracing.command.ITraceCommandExecutor;
import de.esolutions.fw.util.tracing.config.TraceConfigBackend;

public class RegisterBackendCommand
implements ITraceCommand {
    private final ITraceBackend backend;
    private final TraceConfigBackend config;
    private final String key;

    public RegisterBackendCommand(ITraceBackend iTraceBackend, TraceConfigBackend traceConfigBackend, String string) {
        this.backend = iTraceBackend;
        this.config = traceConfigBackend;
        this.key = string;
    }

    @Override
    public boolean execute(ITraceCommandExecutor iTraceCommandExecutor) {
        iTraceCommandExecutor.registerBackend(this.backend, this.config, this.key);
        return false;
    }
}

