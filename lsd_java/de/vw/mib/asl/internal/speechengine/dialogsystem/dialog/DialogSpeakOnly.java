/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.dialogsystem.dialog;

import de.vw.mib.asl.internal.speechengine.dialogsystem.controller.asr.AsrController;
import de.vw.mib.asl.internal.speechengine.dialogsystem.controller.tts.TtsController;
import de.vw.mib.asl.internal.speechengine.dialogsystem.dialog.AbstractDialog;
import de.vw.mib.asl.internal.speechengine.dialogsystem.dialog.DialogSystemPublisherSpeakOnly;
import de.vw.mib.asl.internal.speechengine.dialogsystem.dialog.task.end.EndPromptDialog;
import de.vw.mib.asl.internal.speechengine.dialogsystem.start.DialogSystemParameter;
import de.vw.mib.log4mib.Logger;

public class DialogSpeakOnly
extends AbstractDialog {
    public DialogSpeakOnly(Logger logger, AsrController asrController, TtsController ttsController, DialogSystemParameter dialogSystemParameter, int n) {
        super(logger, asrController, ttsController, dialogSystemParameter, n, new DialogSystemPublisherSpeakOnly());
    }

    @Override
    public void addEndDialog(int n) {
        super.addEndDialog(new EndPromptDialog(this.logger, this.tts, this.dialogSystemPublisher, this.dialogListenerProxy, this));
    }

    @Override
    public void onAudioConnectionLostInternal(int n) {
        this.addEndDialog(new EndPromptDialog(this.logger, this.tts, this.dialogSystemPublisher, this.dialogListenerProxy, this));
        this.taskInvoker.abort();
    }

    public String toString() {
        return new String("PromptDialog");
    }
}

