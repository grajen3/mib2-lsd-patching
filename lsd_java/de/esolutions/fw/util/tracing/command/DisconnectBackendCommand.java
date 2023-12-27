/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.command;

import de.esolutions.fw.util.tracing.command.ITraceCommand;
import de.esolutions.fw.util.tracing.command.ITraceCommandExecutor;

public class DisconnectBackendCommand
implements ITraceCommand {
    private final short bid;

    public DisconnectBackendCommand(short s) {
        this.bid = s;
    }

    @Override
    public boolean execute(ITraceCommandExecutor iTraceCommandExecutor) {
        iTraceCommandExecutor.disconnectBackend(this.bid);
        return false;
    }
}

