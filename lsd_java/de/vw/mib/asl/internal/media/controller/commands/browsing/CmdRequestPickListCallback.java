/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.controller.commands.browsing;

import de.vw.mib.asl.internal.media.controller.commands.CommandState;
import org.dsi.ifc.media.ListEntry;

public interface CmdRequestPickListCallback {
    default public void response(ListEntry[] listEntryArray, CommandState commandState) {
    }
}

