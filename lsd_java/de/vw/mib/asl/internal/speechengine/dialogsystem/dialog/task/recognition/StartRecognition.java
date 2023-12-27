/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.dialogsystem.dialog.task.recognition;

import de.vw.mib.asl.internal.speechengine.dialogsystem.DialogListener;
import de.vw.mib.asl.internal.speechengine.dialogsystem.SpeechDialogConfiguration;
import de.vw.mib.asl.internal.speechengine.dialogsystem.adapter.handler.AsyncExceptionHandler;
import de.vw.mib.asl.internal.speechengine.dialogsystem.adapter.handler.RecognitionHandler;
import de.vw.mib.asl.internal.speechengine.dialogsystem.controller.asr.AsrController;
import de.vw.mib.asl.internal.speechengine.dialogsystem.dialog.task.DefaultDialogTask;
import de.vw.mib.asl.internal.speechengine.dialogsystem.dialog.task.recognition.Recognition;
import de.vw.mib.asl.internal.speechengine.dialogsystem.util.AsyncExceptionLogger;
import de.vw.mib.log4mib.Logger;
import org.dsi.ifc.speechrec.NBestList;

final class StartRecognition
extends DefaultDialogTask
implements RecognitionHandler,
AsyncExceptionHandler {
    private AsrController asr;
    private Recognition recognitionTask;
    private boolean isFirstRecognition;
    private SpeechDialogConfiguration dialogConfiguration;
    private final DialogListener dialogListener;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$RecognitionHandler;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$AsyncExceptionHandler;

    public StartRecognition(Logger logger, AsrController asrController, Recognition recognition, boolean bl, SpeechDialogConfiguration speechDialogConfiguration, DialogListener dialogListener) {
        super(logger);
        this.asr = asrController;
        this.recognitionTask = recognition;
        this.isFirstRecognition = bl;
        this.dialogConfiguration = speechDialogConfiguration;
        this.dialogListener = dialogListener;
    }

    @Override
    public void execute() {
        int n = 1;
        if (this.isFirstRecognition && this.dialogConfiguration.isSessionStartToneEnabled()) {
            n = 3;
        } else if (!this.isFirstRecognition && this.dialogConfiguration.isRecognizerReadyToneEnabled()) {
            n = 2;
        }
        int n2 = 1;
        if (this.dialogConfiguration.isRecognizerFinishToneEnabled()) {
            n2 = 2;
        }
        this.asr.getHandlerRegistry().addHandler(class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$RecognitionHandler == null ? (class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$RecognitionHandler = StartRecognition.class$("de.vw.mib.asl.internal.speechengine.dialogsystem.adapter.handler.RecognitionHandler")) : class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$RecognitionHandler, this);
        this.asr.getHandlerRegistry().addHandler(class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$AsyncExceptionHandler == null ? (class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$AsyncExceptionHandler = StartRecognition.class$("de.vw.mib.asl.internal.speechengine.dialogsystem.adapter.handler.AsyncExceptionHandler")) : class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$AsyncExceptionHandler, this);
        this.asr.getSpeechRec().startRecognition(n, n2, 1);
    }

    @Override
    public void abort() {
    }

    @Override
    public void terminate() {
        this.asr.getHandlerRegistry().removeHandler(class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$RecognitionHandler == null ? (class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$RecognitionHandler = StartRecognition.class$("de.vw.mib.asl.internal.speechengine.dialogsystem.adapter.handler.RecognitionHandler")) : class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$RecognitionHandler, this);
        this.asr.getHandlerRegistry().removeHandler(class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$AsyncExceptionHandler == null ? (class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$AsyncExceptionHandler = StartRecognition.class$("de.vw.mib.asl.internal.speechengine.dialogsystem.adapter.handler.AsyncExceptionHandler")) : class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$AsyncExceptionHandler, this);
        this.asr = null;
        this.recognitionTask = null;
    }

    @Override
    public void responseStartRecognition(int n) {
        if (n == 200 || this.recognitionTask.isAborted()) {
            this.notifyFinishedAborted();
        } else if (n == 0) {
            this.notifyFinishedSuccessful();
        } else {
            this.dialogListener.onRecognitionFinished(n, null);
            this.notifyFinishedFlawed();
        }
    }

    @Override
    public void responseWaitForResults(int n, NBestList nBestList) {
    }

    @Override
    public void updateRecognizerState(int n) {
    }

    @Override
    public void asyncException(int n, String string, int n2) {
        if (n2 == 1012) {
            AsyncExceptionLogger.logAsyncException(this.taskLogger, 512, "StartRecognitionTask", n, string, n2);
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

