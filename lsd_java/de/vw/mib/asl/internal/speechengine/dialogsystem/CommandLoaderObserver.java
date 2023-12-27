/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.dialogsystem;

import org.dsi.ifc.speechrec.Grammar;

public interface CommandLoaderObserver {
    default public Grammar[] onCommandsLost() {
    }

    default public void onSlotsLost() {
    }
}

