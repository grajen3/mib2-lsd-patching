/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.dialogsystem.dialog.task.recognition;

import de.vw.mib.asl.internal.speechengine.dialogsystem.DialogListener;
import de.vw.mib.asl.internal.speechengine.dialogsystem.adapter.handler.AsyncExceptionHandler;
import de.vw.mib.asl.internal.speechengine.dialogsystem.adapter.handler.RecognitionHandler;
import de.vw.mib.asl.internal.speechengine.dialogsystem.controller.asr.AsrController;
import de.vw.mib.asl.internal.speechengine.dialogsystem.dialog.task.DefaultDialogTask;
import de.vw.mib.asl.internal.speechengine.dialogsystem.dialog.task.recognition.Recognition;
import de.vw.mib.asl.internal.speechengine.dialogsystem.util.AsyncExceptionLogger;
import de.vw.mib.log4mib.Logger;
import org.dsi.ifc.speechrec.NBestList;

final class WaitForResults
extends DefaultDialogTask
implements RecognitionHandler,
AsyncExceptionHandler {
    private AsrController asr;
    private Recognition recognitionTask;
    private DialogListener dialogListener;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$RecognitionHandler;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$AsyncExceptionHandler;

    public WaitForResults(Logger logger, AsrController asrController, Recognition recognition, DialogListener dialogListener) {
        super(logger);
        this.asr = asrController;
        this.recognitionTask = recognition;
        this.dialogListener = dialogListener;
    }

    @Override
    public void execute() {
        this.asr.getHandlerRegistry().addHandler(class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$RecognitionHandler == null ? (class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$RecognitionHandler = WaitForResults.class$("de.vw.mib.asl.internal.speechengine.dialogsystem.adapter.handler.RecognitionHandler")) : class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$RecognitionHandler, this);
        this.asr.getHandlerRegistry().addHandler(class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$AsyncExceptionHandler == null ? (class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$AsyncExceptionHandler = WaitForResults.class$("de.vw.mib.asl.internal.speechengine.dialogsystem.adapter.handler.AsyncExceptionHandler")) : class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$AsyncExceptionHandler, this);
        this.asr.getSpeechRec().waitForResults();
    }

    @Override
    public void abort() {
    }

    @Override
    public void terminate() {
        this.asr.getHandlerRegistry().removeHandler(class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$RecognitionHandler == null ? (class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$RecognitionHandler = WaitForResults.class$("de.vw.mib.asl.internal.speechengine.dialogsystem.adapter.handler.RecognitionHandler")) : class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$RecognitionHandler, this);
        this.asr.getHandlerRegistry().removeHandler(class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$AsyncExceptionHandler == null ? (class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$AsyncExceptionHandler = WaitForResults.class$("de.vw.mib.asl.internal.speechengine.dialogsystem.adapter.handler.AsyncExceptionHandler")) : class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$AsyncExceptionHandler, this);
        this.asr = null;
        this.recognitionTask = null;
    }

    @Override
    public void responseStartRecognition(int n) {
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void responseWaitForResults(int n, NBestList nBestList) {
        if (n == 200 || this.recognitionTask.isAborted()) {
            this.dialogListener.onRecognitionFinished(n, nBestList);
            this.notifyFinishedAborted();
        } else {
            try {
                this.dialogListener.onRecognitionFinished(n, nBestList);
            }
            catch (Exception exception) {
                this.taskLogger.error(512, "DialogSystem was hit by exception while dispatching the recognition result", exception);
            }
            finally {
                this.notifyFinishedSuccessful();
            }
        }
    }

    @Override
    public void updateRecognizerState(int n) {
    }

    @Override
    public void asyncException(int n, String string, int n2) {
        if (n2 == 1010) {
            AsyncExceptionLogger.logAsyncException(this.taskLogger, 512, "WaitForResultsTask", n, string, n2);
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

