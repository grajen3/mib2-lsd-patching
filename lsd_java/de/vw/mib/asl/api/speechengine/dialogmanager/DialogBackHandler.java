/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.speechengine.dialogmanager;

public interface DialogBackHandler {
    default public void restoreState() {
    }

    default public boolean shouldBackPromptBePlayed() {
    }
}

