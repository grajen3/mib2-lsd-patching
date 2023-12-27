/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.controller.commands;

import de.vw.mib.asl.internal.media.controller.commands.CommandCallback;
import de.vw.mib.asl.internal.media.controller.commands.CommandState;
import de.vw.mib.asl.internal.media.controller.commands.CommandStateListener;
import de.vw.mib.asl.internal.media.controller.commands.CommandTracer;

public interface Command
extends CommandState {
    default public void execute() {
    }

    default public void setCommandStateListener(CommandStateListener commandStateListener) {
    }

    default public void setCommandCallback(CommandCallback commandCallback) {
    }

    default public Class getCommandType() {
    }

    default public long getSequenceNumber() {
    }

    default public String getCommandStr(boolean bl, boolean bl2, boolean bl3, boolean bl4) {
    }

    default public void enter() {
    }

    default public void exit() {
    }

    default public void setExecutionDepth(int n) {
    }

    default public void abort(String string) {
    }

    default public void cancel(String string) {
    }

    default public void setSequenceNumber(long l) {
    }

    default public CommandTracer getTracer() {
    }

    default public int getRequiredComponents() {
    }
}

