/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.controller.commands;

import de.vw.mib.asl.internal.media.controller.commands.Command;

public interface CommandState {
    default public Command getCommand() {
    }

    default public boolean isWaiting() {
    }

    default public boolean isExecuting() {
    }

    default public boolean isCompleted() {
    }

    default public boolean isAbortedByError() {
    }

    default public boolean isAbortedByTimeout() {
    }

    default public boolean isAbortedByCall() {
    }

    default public boolean isTerminated() {
    }
}

