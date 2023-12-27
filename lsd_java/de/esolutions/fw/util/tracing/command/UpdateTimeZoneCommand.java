/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.command;

import de.esolutions.fw.util.tracing.command.ITraceCommand;
import de.esolutions.fw.util.tracing.command.ITraceCommandExecutor;
import de.esolutions.fw.util.tracing.timezone.TraceTimeZone;

public class UpdateTimeZoneCommand
implements ITraceCommand {
    private final TraceTimeZone zone;

    public UpdateTimeZoneCommand(TraceTimeZone traceTimeZone) {
        this.zone = traceTimeZone;
    }

    @Override
    public boolean execute(ITraceCommandExecutor iTraceCommandExecutor) {
        iTraceCommandExecutor.updateTimeZone(this.zone);
        return false;
    }
}

