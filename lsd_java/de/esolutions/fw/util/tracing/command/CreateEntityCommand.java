/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.command;

import de.esolutions.fw.util.tracing.command.ITraceCommand;
import de.esolutions.fw.util.tracing.command.ITraceCommandExecutor;
import de.esolutions.fw.util.tracing.model.TraceEntity;

public class CreateEntityCommand
implements ITraceCommand {
    private final int epoch;
    private final TraceEntity entity;
    private final short level;

    public CreateEntityCommand(int n, TraceEntity traceEntity, short s) {
        this.epoch = n;
        this.entity = traceEntity;
        this.level = s;
    }

    @Override
    public boolean execute(ITraceCommandExecutor iTraceCommandExecutor) {
        iTraceCommandExecutor.createEntity(this.epoch, this.entity, this.level);
        return false;
    }
}

