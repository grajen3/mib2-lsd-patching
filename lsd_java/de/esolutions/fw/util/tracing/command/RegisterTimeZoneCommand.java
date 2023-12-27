/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.command;

import de.esolutions.fw.util.tracing.command.ITraceCommand;
import de.esolutions.fw.util.tracing.command.ITraceCommandExecutor;
import de.esolutions.fw.util.tracing.timezone.TraceTimeZone;

public class RegisterTimeZoneCommand
implements ITraceCommand {
    private final int epoch;
    private final TraceTimeZone zone;

    public RegisterTimeZoneCommand(int n, TraceTimeZone traceTimeZone) {
        this.epoch = n;
        this.zone = traceTimeZone;
    }

    @Override
    public boolean execute(ITraceCommandExecutor iTraceCommandExecutor) {
        iTraceCommandExecutor.registerTimeZone(this.epoch, this.zone);
        return false;
    }
}

