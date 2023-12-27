/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.dialogsystem;

import de.vw.mib.asl.api.speechengine.features.model.Prompt;
import de.vw.mib.asl.internal.speechengine.dialogsystem.PromptDialog;

public interface SpeechDialog
extends PromptDialog {
    default public void addFirstRecognition() {
    }

    default public void addRecognition() {
    }

    default public void addPause() {
    }

    default public boolean isPaused() {
    }

    default public void playBackgroundPrompts(Prompt[] promptArray, int n) {
    }
}

