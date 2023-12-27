/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.dialogsystem.dialog.task.end;

import de.vw.mib.asl.internal.speechengine.dialogsystem.Dialog;
import de.vw.mib.asl.internal.speechengine.dialogsystem.DialogListener;
import de.vw.mib.asl.internal.speechengine.dialogsystem.adapter.handler.AsyncExceptionHandler;
import de.vw.mib.asl.internal.speechengine.dialogsystem.controller.tts.TtsController;
import de.vw.mib.asl.internal.speechengine.dialogsystem.dialog.task.DefaultTtsHandler;
import de.vw.mib.asl.internal.speechengine.dialogsystem.util.AsyncExceptionLogger;
import de.vw.mib.asl.internal.speechengine.messenger.DialogSystemPublisher;
import de.vw.mib.log4mib.Logger;

public class PlayToneTask
extends DefaultTtsHandler
implements AsyncExceptionHandler {
    private final TtsController ttsController;
    private final DialogSystemPublisher dialogSystemPublisher;
    private final short sourceId;
    private final int toneId;
    private final DialogListener dialogListener;
    private final Dialog activeDialog;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$TtsHandler;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$AsyncExceptionHandler;

    public PlayToneTask(Logger logger, TtsController ttsController, short s, int n, DialogListener dialogListener, Dialog dialog) {
        super(logger);
        this.ttsController = ttsController;
        this.sourceId = s;
        this.toneId = n;
        this.dialogSystemPublisher = ttsController.getDialogSystemPublisher();
        this.dialogListener = dialogListener;
        this.activeDialog = dialog;
    }

    @Override
    public void execute() {
        this.ttsController.getHandlerRegistry().addHandler(class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$TtsHandler == null ? (class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$TtsHandler = PlayToneTask.class$("de.vw.mib.asl.internal.speechengine.dialogsystem.adapter.handler.TtsHandler")) : class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$TtsHandler, this);
        this.ttsController.getHandlerRegistry().addHandler(class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$AsyncExceptionHandler == null ? (class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$AsyncExceptionHandler = PlayToneTask.class$("de.vw.mib.asl.internal.speechengine.dialogsystem.adapter.handler.AsyncExceptionHandler")) : class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$AsyncExceptionHandler, this);
        this.ttsController.getTts().requestPlayTone(this.sourceId, this.toneId);
        this.ttsController.getDiagnosisListener().requestPlayTone(this.sourceId, this.toneId);
    }

    @Override
    public void terminate() {
        this.ttsController.getHandlerRegistry().removeHandler(class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$TtsHandler == null ? (class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$TtsHandler = PlayToneTask.class$("de.vw.mib.asl.internal.speechengine.dialogsystem.adapter.handler.TtsHandler")) : class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$TtsHandler, this);
        this.ttsController.getHandlerRegistry().removeHandler(class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$AsyncExceptionHandler == null ? (class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$AsyncExceptionHandler = PlayToneTask.class$("de.vw.mib.asl.internal.speechengine.dialogsystem.adapter.handler.AsyncExceptionHandler")) : class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$AsyncExceptionHandler, this);
    }

    @Override
    public void abort() {
    }

    @Override
    public void responseSpeakPrompt(short s, int n) {
    }

    @Override
    public short getSourceId() {
        return this.sourceId;
    }

    @Override
    public void responsePlayTone(short s, int n) {
        if (s == this.sourceId && n != 0) {
            this.notifyFinishedFlawed();
        }
    }

    @Override
    public void updateAudioRequest(int n, int n2) {
        if (n == 4 && this.isEndTone()) {
            this.dialogSystemPublisher.onDialogStepActive(5);
            this.dialogListener.onEndStarted(this.activeDialog);
        } else if (n == 5) {
            if (this.isEndTone()) {
                this.dialogSystemPublisher.onDialogStepPostProcessing(5);
            }
            this.notifyFinishedSuccessful();
        }
    }

    private boolean isEndTone() {
        return this.toneId == 1;
    }

    @Override
    public void asyncException(int n, String string, int n2) {
        if (n2 == 1009) {
            AsyncExceptionLogger.logAsyncException(this.taskLogger, 1024, "PlayToneTask", n, string, n2);
            this.notifyFinishedFlawed();
        }
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

