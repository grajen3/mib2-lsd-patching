/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.dialogsystem.dialog;

import de.vw.mib.asl.api.speechengine.features.model.Prompt;
import de.vw.mib.asl.internal.speechengine.dialogsystem.DialogListener;
import de.vw.mib.asl.internal.speechengine.dialogsystem.SpeechDialog;

public class DialogDeactivated
implements SpeechDialog {
    private DialogListener dialogListener;

    @Override
    public void addPrompts(Prompt[] promptArray, int n) {
    }

    @Override
    public void start() {
        if (this.dialogListener != null) {
            this.dialogListener.onTerminated(this, 0);
        }
    }

    @Override
    public void abort() {
    }

    @Override
    public void pttBargeIn() {
    }

    @Override
    public void clear() {
    }

    @Override
    public void clear(int n) {
    }

    @Override
    public void terminate() {
    }

    @Override
    public void addDialogListener(DialogListener dialogListener) {
        this.dialogListener = dialogListener;
    }

    @Override
    public void removeDialogListener(DialogListener dialogListener) {
    }

    @Override
    public void addFirstRecognition() {
    }

    @Override
    public void addRecognition() {
    }

    @Override
    public void addPause() {
    }

    @Override
    public void addEndDialog(int n) {
    }

    @Override
    public boolean isPaused() {
        return false;
    }

    @Override
    public void playBackgroundPrompts(Prompt[] promptArray, int n) {
    }
}

