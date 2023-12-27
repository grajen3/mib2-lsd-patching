/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.dialogsystem.dialog.task.recognition;

import de.vw.mib.asl.internal.speechengine.dialogsystem.controller.asr.AsrController;
import de.vw.mib.asl.internal.speechengine.dialogsystem.dialog.task.DefaultDialogTask;
import de.vw.mib.log4mib.Logger;

final class StartDialog
extends DefaultDialogTask {
    private AsrController asr;

    public StartDialog(Logger logger, AsrController asrController) {
        super(logger);
        this.asr = asrController;
    }

    @Override
    public void execute() {
        this.asr.getSpeechRec().startDialogue();
        this.notifyFinishedSuccessful();
    }

    @Override
    public void abort() {
    }

    @Override
    public void terminate() {
        this.asr = null;
    }
}

