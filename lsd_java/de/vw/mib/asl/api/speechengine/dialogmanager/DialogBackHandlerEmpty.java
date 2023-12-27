/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.speechengine.dialogmanager;

import de.vw.mib.asl.api.speechengine.dialogmanager.DialogBackHandler;

public class DialogBackHandlerEmpty
implements DialogBackHandler {
    @Override
    public void restoreState() {
    }

    @Override
    public boolean shouldBackPromptBePlayed() {
        return false;
    }
}

