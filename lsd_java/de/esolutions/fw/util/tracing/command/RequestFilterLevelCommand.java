/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.command;

import de.esolutions.fw.util.tracing.command.ITraceCommand;
import de.esolutions.fw.util.tracing.command.ITraceCommandExecutor;
import de.esolutions.fw.util.tracing.entity.TraceEntityURI;

public class RequestFilterLevelCommand
implements ITraceCommand {
    private final TraceEntityURI uri;
    private final short level;

    public RequestFilterLevelCommand(TraceEntityURI traceEntityURI, short s) {
        this.uri = traceEntityURI;
        this.level = s;
    }

    @Override
    public boolean execute(ITraceCommandExecutor iTraceCommandExecutor) {
        iTraceCommandExecutor.requestFilterLevel(this.uri, this.level);
        return false;
    }
}

