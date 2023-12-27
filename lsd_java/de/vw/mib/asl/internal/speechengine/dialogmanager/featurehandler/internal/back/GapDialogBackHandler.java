/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler.internal.back;

import de.vw.mib.asl.api.speechengine.dialogmanager.DialogBackHandlerEmpty;

final class GapDialogBackHandler
extends DialogBackHandlerEmpty {
    static final GapDialogBackHandler INSTANCE = new GapDialogBackHandler();

    private GapDialogBackHandler() {
    }

    public String toString() {
        return "GAP";
    }
}

