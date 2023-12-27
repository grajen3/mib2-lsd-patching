/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.speechengine;

import de.vw.mib.asl.api.speechengine.SpeechEngine;
import de.vw.mib.asl.api.speechengine.dialogmanager.DialogManager;

public interface SpeechEngineMaster
extends SpeechEngine {
    default public DialogManager getDialogManager(int n) {
    }
}

