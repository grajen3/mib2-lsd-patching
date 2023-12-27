/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.dialogmanager;

import de.vw.mib.asl.internal.speechengine.dialogmanager.DialogManagerParameters;
import de.vw.mib.asl.internal.speechengine.dialogsystem.SpeechDialogSystem;

public interface DialogManagerActivator {
    public static final String DIALOG_MANAGER_ACTIVATOR;

    default public void activateProxy(DialogManagerParameters dialogManagerParameters) {
    }

    default public void activateManager(SpeechDialogSystem speechDialogSystem) {
    }
}

