/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.dialogsystem.dialog.task.end;

import de.vw.mib.asl.internal.speechengine.dialogsystem.Dialog;
import de.vw.mib.asl.internal.speechengine.dialogsystem.DialogListener;
import de.vw.mib.asl.internal.speechengine.dialogsystem.controller.tts.TtsController;
import de.vw.mib.asl.internal.speechengine.dialogsystem.dialog.task.end.EndDialog;
import de.vw.mib.asl.internal.speechengine.messenger.DialogSystemPublisher;
import de.vw.mib.asl.internal.speechengine.task.Task;
import de.vw.mib.log4mib.Logger;

public class EndPromptDialog
extends EndDialog {
    public EndPromptDialog(Logger logger, TtsController ttsController, DialogSystemPublisher dialogSystemPublisher, DialogListener dialogListener, Dialog dialog) {
        super(logger, ttsController, false, dialogSystemPublisher, dialogListener, dialog);
    }

    @Override
    public void taskFinishedSuccessful(Task task) {
        task.terminate();
        this.notifyFinishedSuccessful();
    }

    @Override
    public void taskFinishedFlawed(Task task) {
        task.terminate();
        this.notifyFinishedFlawed();
    }

    @Override
    public void taskFinishedAborted(Task task) {
        task.terminate();
        this.notifyFinishedAborted();
    }
}

