/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.command;

import de.esolutions.fw.util.tracing.command.ITraceCommandExecutor;

public interface ITraceCommand {
    default public boolean execute(ITraceCommandExecutor iTraceCommandExecutor) {
    }
}

