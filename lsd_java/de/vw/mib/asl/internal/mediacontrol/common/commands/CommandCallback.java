/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.mediacontrol.common.commands;

import de.vw.mib.asl.internal.mediacontrol.common.commands.CommandState;

public interface CommandCallback {
    default public void onCommandExecutionFinished(CommandState commandState) {
    }
}

