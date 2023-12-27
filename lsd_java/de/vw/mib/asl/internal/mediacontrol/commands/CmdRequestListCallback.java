/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.mediacontrol.commands;

import de.vw.mib.asl.internal.mediacontrol.common.commands.CommandState;
import org.dsi.ifc.upnp.ListEntry;

public interface CmdRequestListCallback {
    default public void response(ListEntry[] listEntryArray, CommandState commandState) {
    }
}

