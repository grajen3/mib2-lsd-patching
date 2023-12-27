/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.dialogsystem.dialog;

import de.vw.mib.asl.internal.speechengine.dialogsystem.SpeechDialogConfiguration;
import de.vw.mib.asl.internal.speechengine.dialogsystem.controller.asr.AsrController;
import de.vw.mib.asl.internal.speechengine.dialogsystem.controller.tts.TtsController;
import de.vw.mib.asl.internal.speechengine.dialogsystem.dialog.AbstractDialog;
import de.vw.mib.asl.internal.speechengine.dialogsystem.dialog.task.end.EndSpeechDialog;
import de.vw.mib.asl.internal.speechengine.dialogsystem.start.DialogSystemParameter;
import de.vw.mib.log4mib.Logger;

public class DialogSDS
extends AbstractDialog {
    public DialogSDS(Logger logger, AsrController asrController, TtsController ttsController, DialogSystemParameter dialogSystemParameter, int n, SpeechDialogConfiguration speechDialogConfiguration) {
        super(logger, asrController, ttsController, dialogSystemParameter, n, speechDialogConfiguration, dialogSystemParameter.getDialogSystemPublisher());
    }

    @Override
    protected void tearDown(boolean bl, boolean bl2) {
        if (!bl && this.asr.getSpeechRec() != null) {
            this.asr.getSpeechRec().stopDialogue();
        }
        super.tearDown(bl, bl2);
    }

    @Override
    public void addEndDialog(int n) {
        super.addEndDialog(new EndSpeechDialog(this.logger, this.tts, this.asr, this.dialogConfig.isSessionEndToneEnabled(), this.dialogSystemPublisher, this.dialogListenerProxy, this));
    }

    @Override
    public void onAudioConnectionLostInternal(int n) {
        this.addEndDialog(new EndSpeechDialog(this.logger, this.tts, this.asr, false, this.dialogSystemPublisher, this.dialogListenerProxy, this));
        this.taskInvoker.abort();
    }

    public String toString() {
        return new String("SpeechDialog");
    }
}

