/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.dialogsystem.dialog.task;

import de.vw.mib.asl.internal.speechengine.dialogsystem.DialogListener;
import de.vw.mib.asl.internal.speechengine.dialogsystem.SpeechDialog;
import de.vw.mib.asl.internal.speechengine.dialogsystem.dialog.task.DefaultDialogTask;
import de.vw.mib.asl.internal.speechengine.messenger.DialogSystemPublisher;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.timer.TimerManager;

public class PauseTask
extends DefaultDialogTask {
    private final DialogListener dialogListener;
    private final SpeechDialog speechDialog;
    private final DialogSystemPublisher dialogSystemPublisher;

    public PauseTask(Logger logger, TimerManager timerManager, SpeechDialog speechDialog, DialogListener dialogListener, DialogSystemPublisher dialogSystemPublisher) {
        super(logger);
        this.speechDialog = speechDialog;
        this.dialogSystemPublisher = dialogSystemPublisher;
        this.dialogListener = dialogListener;
    }

    @Override
    public void execute() {
        this.dialogListener.onPauseStarted();
        this.dialogSystemPublisher.onDialogStepStarted(4);
    }

    @Override
    public void terminate() {
        this.dialogSystemPublisher.onDialogStepFinished(4);
        this.dialogListener.onPauseFinished();
    }

    @Override
    public void abort() {
        this.notifyFinishedAborted();
    }

    @Override
    public void onPttBargeIn() {
        this.abort();
        this.speechDialog.addRecognition();
    }

    @Override
    protected int getMask() {
        return 4;
    }
}

