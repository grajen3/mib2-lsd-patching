/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.command;

import de.esolutions.fw.util.tracing.command.ITraceCommand;
import de.esolutions.fw.util.tracing.command.ITraceCommandExecutor;

public class ExecuteCallbackCommand
implements ITraceCommand {
    private final int cbid;
    private final byte[] cbData;

    public ExecuteCallbackCommand(int n, byte[] byArray) {
        this.cbid = n;
        this.cbData = byArray;
    }

    @Override
    public boolean execute(ITraceCommandExecutor iTraceCommandExecutor) {
        iTraceCommandExecutor.executeCallback(this.cbid, this.cbData);
        return false;
    }
}

