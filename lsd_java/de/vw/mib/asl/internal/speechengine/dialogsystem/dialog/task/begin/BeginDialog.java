/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.dialogsystem.dialog.task.begin;

import de.vw.mib.asl.internal.speechengine.dialogsystem.Dialog;
import de.vw.mib.asl.internal.speechengine.dialogsystem.DialogListener;
import de.vw.mib.asl.internal.speechengine.dialogsystem.dialog.task.DefaultDialogTask;
import de.vw.mib.asl.internal.speechengine.messenger.DialogSystemPublisher;
import de.vw.mib.log4mib.Logger;

public class BeginDialog
extends DefaultDialogTask {
    private final DialogSystemPublisher dialogSystemPublisher;
    private final DialogListener dialogListener;
    private final Dialog dialog;

    public BeginDialog(Logger logger, DialogSystemPublisher dialogSystemPublisher, DialogListener dialogListener, Dialog dialog) {
        super(logger);
        this.dialogSystemPublisher = dialogSystemPublisher;
        this.dialogListener = dialogListener;
        this.dialog = dialog;
    }

    @Override
    public void execute() {
        this.dialogSystemPublisher.onDialogStepStarted(1);
        this.dialogListener.onStarted(this.dialog, 0);
        this.dialogSystemPublisher.onDialogStepFinished(1);
        this.notifyFinishedSuccessful();
    }

    @Override
    public void terminate() {
    }

    @Override
    public void abort() {
    }
}

