/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.dialogsystem.dialog.task.prompt;

import de.vw.mib.asl.api.speechengine.features.model.Prompt;
import de.vw.mib.asl.internal.speechengine.dialogsystem.DialogListener;
import de.vw.mib.asl.internal.speechengine.dialogsystem.controller.tts.TtsController;
import de.vw.mib.asl.internal.speechengine.dialogsystem.dialog.task.DefaultTtsHandler;
import de.vw.mib.asl.internal.speechengine.dialogsystem.dialog.task.prompt.RequestAudioTrigger;
import de.vw.mib.asl.internal.speechengine.dialogsystem.dialog.task.prompt.SpeakPrompt;
import de.vw.mib.asl.internal.speechengine.messenger.DialogSystemPublisher;
import de.vw.mib.asl.internal.speechengine.task.TaskInvoker;
import de.vw.mib.asl.internal.speechengine.task.TaskInvokerListener;
import de.vw.mib.asl.internal.speechengine.task.TaskInvokerStopOnFailure;
import de.vw.mib.log4mib.Logger;

public class Prompting
extends DefaultTtsHandler
implements TaskInvokerListener {
    private final TtsController ttsController;
    private final short sourceId;
    private final DialogListener dialogListener;
    private final int clientId;
    private final DialogSystemPublisher dialogSystemPublisher;
    private TaskInvokerStopOnFailure subTaskInvoker;
    private final int mask;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$TtsHandler;

    public Prompting(Logger logger, TtsController ttsController, Prompt[] promptArray, int n, short s, DialogListener dialogListener, DialogSystemPublisher dialogSystemPublisher, boolean bl) {
        super(logger);
        this.mask = bl ? 32 : 2;
        this.ttsController = ttsController;
        this.clientId = n;
        this.sourceId = s;
        this.dialogListener = dialogListener;
        this.dialogSystemPublisher = dialogSystemPublisher;
        this.subTaskInvoker = new TaskInvokerStopOnFailure(1024, this.taskLogger, "Prompting");
        this.subTaskInvoker.setInvokerListener(this);
        this.loadSubTasks(promptArray);
    }

    private void loadSubTasks(Prompt[] promptArray) {
        SpeakPrompt speakPrompt = new SpeakPrompt(this.taskLogger, this.ttsController, promptArray, this.sourceId);
        this.subTaskInvoker.add(speakPrompt);
        RequestAudioTrigger requestAudioTrigger = new RequestAudioTrigger(this.taskLogger, this.ttsController, this.sourceId);
        this.subTaskInvoker.add(requestAudioTrigger);
    }

    @Override
    public void execute() {
        this.dialogSystemPublisher.onDialogStepStarted(3);
        this.ttsController.getHandlerRegistry().addHandler(class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$TtsHandler == null ? (class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$TtsHandler = Prompting.class$("de.vw.mib.asl.internal.speechengine.dialogsystem.adapter.handler.TtsHandler")) : class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$TtsHandler, this);
        this.subTaskInvoker.invoke();
    }

    @Override
    public void terminate() {
        this.subTaskInvoker.terminate();
        this.dialogListener.onPromptSpoken(this.clientId);
        this.dialogSystemPublisher.onDialogStepFinished(3);
        this.ttsController.getHandlerRegistry().removeHandler(class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$TtsHandler == null ? (class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$TtsHandler = Prompting.class$("de.vw.mib.asl.internal.speechengine.dialogsystem.adapter.handler.TtsHandler")) : class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$TtsHandler, this);
    }

    @Override
    public void abort() {
        this.subTaskInvoker.abort();
        this.ttsController.getTts().requestAudioTrigger(this.sourceId, 2);
    }

    @Override
    public void onPttBargeIn() {
        this.abort();
    }

    @Override
    public short getSourceId() {
        return this.sourceId;
    }

    @Override
    public void updateAudioRequest(int n, int n2) {
        if (n == 1) {
            this.dialogSystemPublisher.onDialogStepActive(3);
            this.dialogListener.onPromptStarted(this.clientId);
        } else if (n == 3 || n == 2 || n == 7) {
            this.dialogSystemPublisher.onDialogStepPostProcessing(3);
        }
    }

    @Override
    protected int getMask() {
        return this.mask;
    }

    @Override
    public void invokingStopped(TaskInvoker taskInvoker) {
        if (taskInvoker.hasErrors()) {
            this.notifyFinishedFlawed();
        } else {
            this.notifyFinishedSuccessful();
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

