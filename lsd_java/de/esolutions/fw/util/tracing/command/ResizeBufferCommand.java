/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.command;

import de.esolutions.fw.util.tracing.command.ITraceCommand;
import de.esolutions.fw.util.tracing.command.ITraceCommandExecutor;

public class ResizeBufferCommand
implements ITraceCommand {
    private final int newCapacity;

    public ResizeBufferCommand(int n) {
        this.newCapacity = n;
    }

    @Override
    public boolean execute(ITraceCommandExecutor iTraceCommandExecutor) {
        iTraceCommandExecutor.resizeBuffer(this.newCapacity);
        return false;
    }
}

