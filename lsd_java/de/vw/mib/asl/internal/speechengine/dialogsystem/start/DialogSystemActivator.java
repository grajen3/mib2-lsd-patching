/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.dialogsystem.start;

import de.vw.mib.asl.internal.speechengine.dialogsystem.start.DialogSystemParameter;

public interface DialogSystemActivator {
    public static final String DIALOG_SYSTEM_ACTIVATOR;

    default public void activateTts(DialogSystemParameter dialogSystemParameter, String string, int n) {
    }

    default public void activateAsr(DialogSystemParameter dialogSystemParameter, String string) {
    }
}

