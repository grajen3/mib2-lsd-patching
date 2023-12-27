/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.dialogsystem.dialog.task.end;

import de.vw.mib.asl.internal.speechengine.dialogsystem.Dialog;
import de.vw.mib.asl.internal.speechengine.dialogsystem.DialogListener;
import de.vw.mib.asl.internal.speechengine.dialogsystem.controller.tts.TtsController;
import de.vw.mib.asl.internal.speechengine.dialogsystem.dialog.task.DefaultDialogTask;
import de.vw.mib.asl.internal.speechengine.dialogsystem.dialog.task.end.PlayToneTask;
import de.vw.mib.asl.internal.speechengine.messenger.DialogSystemPublisher;
import de.vw.mib.asl.internal.speechengine.task.Task;
import de.vw.mib.asl.internal.speechengine.task.TaskListener;
import de.vw.mib.log4mib.Logger;

public abstract class EndDialog
extends DefaultDialogTask
implements TaskListener {
    protected final TtsController ttsController;
    private final boolean isEndToneEnabled;
    protected final DialogSystemPublisher dialogSystemPublisher;
    protected final DialogListener dialogListener;
    private Dialog activeDialog;

    public EndDialog(Logger logger, TtsController ttsController, boolean bl, DialogSystemPublisher dialogSystemPublisher, DialogListener dialogListener, Dialog dialog) {
        super(logger);
        this.ttsController = ttsController;
        this.isEndToneEnabled = bl;
        this.dialogSystemPublisher = dialogSystemPublisher;
        this.dialogListener = dialogListener;
        this.activeDialog = dialog;
    }

    @Override
    public void execute() {
        this.dialogSystemPublisher.onDialogStepStarted(5);
        PlayToneTask playToneTask = new PlayToneTask(this.taskLogger, this.ttsController, 1, 1, this.dialogListener, this.activeDialog);
        if (this.isEndToneEnabled) {
            playToneTask.addListener(this);
            playToneTask.execute();
        } else {
            this.dialogListener.onEndStarted(this.activeDialog);
            this.taskFinishedSuccessful(playToneTask);
        }
    }

    @Override
    public void terminate() {
        this.dialogSystemPublisher.onDialogStepFinished(5);
    }

    @Override
    public void abort() {
    }

    @Override
    protected int getMask() {
        return 8;
    }

    @Override
    public abstract void taskFinishedSuccessful(Task task) {
    }

    @Override
    public abstract void taskFinishedFlawed(Task task) {
    }

    @Override
    public abstract void taskFinishedAborted(Task task) {
    }
}

