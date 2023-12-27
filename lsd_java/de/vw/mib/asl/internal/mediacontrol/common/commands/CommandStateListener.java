/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.mediacontrol.common.commands;

import de.vw.mib.asl.internal.mediacontrol.common.commands.Command;

public interface CommandStateListener {
    default public void notifyCommandStateChanged(Command command) {
    }
}

