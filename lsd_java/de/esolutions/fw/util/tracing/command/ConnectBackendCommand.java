/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.command;

import de.esolutions.fw.util.tracing.command.ITraceCommand;
import de.esolutions.fw.util.tracing.command.ITraceCommandExecutor;

public class ConnectBackendCommand
implements ITraceCommand {
    private final short bid;
    private final boolean ok;

    public ConnectBackendCommand(short s, boolean bl) {
        this.bid = s;
        this.ok = bl;
    }

    @Override
    public boolean execute(ITraceCommandExecutor iTraceCommandExecutor) {
        iTraceCommandExecutor.connectBackend(this.bid, this.ok);
        return false;
    }
}

