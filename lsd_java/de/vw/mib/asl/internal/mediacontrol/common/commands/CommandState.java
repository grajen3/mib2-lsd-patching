/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.mediacontrol.common.commands;

public interface CommandState {
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

