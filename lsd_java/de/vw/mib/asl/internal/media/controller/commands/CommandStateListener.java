/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.controller.commands;

import de.vw.mib.asl.internal.media.controller.commands.Command;

public interface CommandStateListener {
    default public void notifyCommandStateChanged(Command command) {
    }
}

