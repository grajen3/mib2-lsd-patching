/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.dialogsystem.dialog.task.recognition;

import de.vw.mib.asl.internal.speechengine.dialogsystem.DialogListener;
import de.vw.mib.asl.internal.speechengine.dialogsystem.SpeechDialog;
import de.vw.mib.asl.internal.speechengine.dialogsystem.SpeechDialogConfiguration;
import de.vw.mib.asl.internal.speechengine.dialogsystem.adapter.handler.AsyncExceptionHandler;
import de.vw.mib.asl.internal.speechengine.dialogsystem.adapter.handler.RecognitionHandler;
import de.vw.mib.asl.internal.speechengine.dialogsystem.controller.asr.AsrController;
import de.vw.mib.asl.internal.speechengine.dialogsystem.dialog.task.DefaultDialogTask;
import de.vw.mib.asl.internal.speechengine.dialogsystem.dialog.task.recognition.StartDialog;
import de.vw.mib.asl.internal.speechengine.dialogsystem.dialog.task.recognition.StartRecognition;
import de.vw.mib.asl.internal.speechengine.dialogsystem.dialog.task.recognition.WaitForGrammarLoading;
import de.vw.mib.asl.internal.speechengine.dialogsystem.dialog.task.recognition.WaitForResults;
import de.vw.mib.asl.internal.speechengine.dialogsystem.util.AsyncExceptionLogger;
import de.vw.mib.asl.internal.speechengine.messenger.DialogSystemPublisher;
import de.vw.mib.asl.internal.speechengine.task.TaskInvoker;
import de.vw.mib.asl.internal.speechengine.task.TaskInvokerListener;
import de.vw.mib.asl.internal.speechengine.task.TaskInvokerStopOnFailure;
import de.vw.mib.log4mib.Logger;
import org.dsi.ifc.speechrec.NBestList;

public class Recognition
extends DefaultDialogTask
implements TaskInvokerListener,
RecognitionHandler,
AsyncExceptionHandler {
    private final AsrController asr;
    private final TaskInvokerStopOnFailure subTaskInvoker;
    private final SpeechDialog speechDialog;
    private final SpeechDialogConfiguration dialogConfig;
    private final DialogSystemPublisher dialogSystemPublisher;
    private boolean isFirstRecognition;
    private DialogListener dialogListener;
    private static final int TRACE_CLASSIFIER;
    private boolean isExecuted;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$RecognitionHandler;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$AsyncExceptionHandler;

    public Recognition(Logger logger, AsrController asrController, boolean bl, SpeechDialog speechDialog, DialogListener dialogListener, SpeechDialogConfiguration speechDialogConfiguration) {
        super(logger);
        this.speechDialog = speechDialog;
        this.asr = asrController;
        this.dialogSystemPublisher = this.asr.getDialogSystemPublisher();
        this.dialogListener = dialogListener;
        this.dialogConfig = speechDialogConfiguration;
        this.isFirstRecognition = bl;
        this.subTaskInvoker = new TaskInvokerStopOnFailure(512, this.taskLogger, "Recognition");
        this.subTaskInvoker.setInvokerListener(this);
        this.loadSubTasks();
        this.isExecuted = false;
    }

    private void loadSubTasks() {
        DefaultDialogTask defaultDialogTask;
        if (this.isFirstRecognition) {
            defaultDialogTask = new StartDialog(this.taskLogger, this.asr);
            this.subTaskInvoker.add(defaultDialogTask);
        }
        defaultDialogTask = new WaitForGrammarLoading(this.taskLogger, this.asr.getActivityManager());
        this.subTaskInvoker.add(defaultDialogTask);
        StartRecognition startRecognition = new StartRecognition(this.taskLogger, this.asr, this, this.isFirstRecognition, this.dialogConfig, this.dialogListener);
        this.subTaskInvoker.add(startRecognition);
        WaitForResults waitForResults = new WaitForResults(this.taskLogger, this.asr, this, this.dialogListener);
        this.subTaskInvoker.add(waitForResults);
    }

    boolean isAborted() {
        return this.isAborted;
    }

    @Override
    public void execute() {
        this.dialogSystemPublisher.onDialogStepStarted(2);
        this.asr.getHandlerRegistry().addHandler(class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$RecognitionHandler == null ? (class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$RecognitionHandler = Recognition.class$("de.vw.mib.asl.internal.speechengine.dialogsystem.adapter.handler.RecognitionHandler")) : class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$RecognitionHandler, this);
        this.asr.getHandlerRegistry().addHandler(class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$AsyncExceptionHandler == null ? (class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$AsyncExceptionHandler = Recognition.class$("de.vw.mib.asl.internal.speechengine.dialogsystem.adapter.handler.AsyncExceptionHandler")) : class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$AsyncExceptionHandler, this);
        this.subTaskInvoker.invoke();
        this.isExecuted = true;
    }

    @Override
    public void terminate() {
        this.subTaskInvoker.terminate();
        if (this.isExecuted) {
            this.dialogSystemPublisher.onDialogStepFinished(2);
        }
        this.asr.getHandlerRegistry().removeHandler(class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$RecognitionHandler == null ? (class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$RecognitionHandler = Recognition.class$("de.vw.mib.asl.internal.speechengine.dialogsystem.adapter.handler.RecognitionHandler")) : class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$RecognitionHandler, this);
        this.asr.getHandlerRegistry().removeHandler(class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$AsyncExceptionHandler == null ? (class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$AsyncExceptionHandler = Recognition.class$("de.vw.mib.asl.internal.speechengine.dialogsystem.adapter.handler.AsyncExceptionHandler")) : class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$AsyncExceptionHandler, this);
    }

    @Override
    public void abort() {
        this.isAborted = true;
        this.asr.getSpeechRec().abort();
        if (!this.subTaskInvoker.isIdle()) {
            this.subTaskInvoker.abort();
        }
    }

    @Override
    public void onPttBargeIn() {
        this.abort();
        this.speechDialog.addRecognition();
    }

    @Override
    protected int getMask() {
        return 1;
    }

    @Override
    public void invokingStopped(TaskInvoker taskInvoker) {
        if (this.isAborted) {
            this.notifyFinishedAborted();
            this.isAborted = false;
        } else if (taskInvoker.hasErrors()) {
            this.notifyFinishedFlawed();
        } else {
            this.notifyFinishedSuccessful();
        }
    }

    @Override
    public void responseStartRecognition(int n) {
        this.dialogSystemPublisher.onDialogStepActive(2);
    }

    @Override
    public void responseWaitForResults(int n, NBestList nBestList) {
        if (nBestList != null) {
            this.taskLogger.trace(512, new StringBuffer().append("Recognition Result = ").append(nBestList.toString()).toString());
        }
        this.dialogSystemPublisher.onDialogStepPostProcessing(2);
        this.asr.getDiagnosisListener().responseWaitForResults(n, nBestList);
    }

    @Override
    public void updateRecognizerState(int n) {
        if (n == 3) {
            this.dialogSystemPublisher.onDialogStepActive(2);
        }
        if (n == 6) {
            this.dialogSystemPublisher.onDialogStepPostProcessing(2);
            this.dialogListener.onUtteranceFinished();
        }
    }

    @Override
    public void asyncException(int n, String string, int n2) {
        if (n2 == 1029 || n2 == 1000) {
            AsyncExceptionLogger.logAsyncException(this.taskLogger, 512, "RecognitionTask", n, string, n2);
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

