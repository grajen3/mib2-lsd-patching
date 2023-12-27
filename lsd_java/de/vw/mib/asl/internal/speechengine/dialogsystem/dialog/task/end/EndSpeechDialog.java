/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.dialogsystem.dialog.task.end;

import de.vw.mib.asl.internal.speechengine.dialogsystem.Dialog;
import de.vw.mib.asl.internal.speechengine.dialogsystem.DialogListener;
import de.vw.mib.asl.internal.speechengine.dialogsystem.controller.asr.AsrController;
import de.vw.mib.asl.internal.speechengine.dialogsystem.controller.tts.TtsController;
import de.vw.mib.asl.internal.speechengine.dialogsystem.dialog.task.end.EndDialog;
import de.vw.mib.asl.internal.speechengine.messenger.DialogSystemPublisher;
import de.vw.mib.asl.internal.speechengine.task.Task;
import de.vw.mib.log4mib.Logger;

public class EndSpeechDialog
extends EndDialog {
    private final AsrController asrController;

    public EndSpeechDialog(Logger logger, TtsController ttsController, AsrController asrController, boolean bl, DialogSystemPublisher dialogSystemPublisher, DialogListener dialogListener, Dialog dialog) {
        super(logger, ttsController, bl, dialogSystemPublisher, dialogListener, dialog);
        this.asrController = asrController;
    }

    @Override
    public void taskFinishedSuccessful(Task task) {
        task.terminate();
        this.asrController.getSpeechRec().stopDialogue();
        this.notifyFinishedSuccessful();
    }

    @Override
    public void taskFinishedFlawed(Task task) {
        task.terminate();
        this.asrController.getSpeechRec().stopDialogue();
        this.notifyFinishedFlawed();
    }

    @Override
    public void taskFinishedAborted(Task task) {
        task.terminate();
        this.asrController.getSpeechRec().stopDialogue();
        this.notifyFinishedAborted();
    }
}

