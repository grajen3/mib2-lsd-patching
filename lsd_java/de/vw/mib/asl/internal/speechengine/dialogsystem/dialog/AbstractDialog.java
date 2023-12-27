/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.dialogsystem.dialog;

import de.vw.mib.asl.api.speechengine.features.model.Prompt;
import de.vw.mib.asl.internal.speechengine.audio.AudioConnectionClientAdapter;
import de.vw.mib.asl.internal.speechengine.dialogsystem.DialogListener;
import de.vw.mib.asl.internal.speechengine.dialogsystem.SpeechDialog;
import de.vw.mib.asl.internal.speechengine.dialogsystem.SpeechDialogConfiguration;
import de.vw.mib.asl.internal.speechengine.dialogsystem.controller.asr.AsrController;
import de.vw.mib.asl.internal.speechengine.dialogsystem.controller.tts.TtsController;
import de.vw.mib.asl.internal.speechengine.dialogsystem.dialog.AbstractDialog$1;
import de.vw.mib.asl.internal.speechengine.dialogsystem.dialog.AbstractDialog$ErrorCode;
import de.vw.mib.asl.internal.speechengine.dialogsystem.dialog.DialogAudioConnectionClient;
import de.vw.mib.asl.internal.speechengine.dialogsystem.dialog.DialogListenerProxy;
import de.vw.mib.asl.internal.speechengine.dialogsystem.dialog.DialogWatchdog;
import de.vw.mib.asl.internal.speechengine.dialogsystem.dialog.task.PauseTask;
import de.vw.mib.asl.internal.speechengine.dialogsystem.dialog.task.begin.BeginDialog;
import de.vw.mib.asl.internal.speechengine.dialogsystem.dialog.task.begin.RequestAudio;
import de.vw.mib.asl.internal.speechengine.dialogsystem.dialog.task.end.ReleaseAudio;
import de.vw.mib.asl.internal.speechengine.dialogsystem.dialog.task.prompt.Prompting;
import de.vw.mib.asl.internal.speechengine.dialogsystem.dialog.task.recognition.Recognition;
import de.vw.mib.asl.internal.speechengine.dialogsystem.start.DialogSystemParameter;
import de.vw.mib.asl.internal.speechengine.dialogsystem.task.DialogTask;
import de.vw.mib.asl.internal.speechengine.dialogsystem.util.Mappings$Audio;
import de.vw.mib.asl.internal.speechengine.messenger.DialogSystemPublisher;
import de.vw.mib.asl.internal.speechengine.task.AbstractTaskInvoker;
import de.vw.mib.asl.internal.speechengine.task.RecognitionWithBackgroundPrompts;
import de.vw.mib.asl.internal.speechengine.task.Task;
import de.vw.mib.asl.internal.speechengine.task.TaskInvoker;
import de.vw.mib.asl.internal.speechengine.task.TaskInvokerIgnoringErrors;
import de.vw.mib.asl.internal.speechengine.task.TaskInvokerListener;
import de.vw.mib.asl.internal.speechengine.task.TaskListener;
import de.vw.mib.collections.ints.IntOptHashSet;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.log4mib.Logger;

public abstract class AbstractDialog
implements SpeechDialog,
TaskInvokerListener,
AudioConnectionClientAdapter,
TaskListener {
    protected static final String TRACE_PREFIX;
    protected static final int TRACE_CLASSIFIER;
    protected Logger logger;
    protected final AsrController asr;
    protected final TtsController tts;
    protected final DialogSystemParameter dialogSystemParameter;
    protected SpeechDialogConfiguration dialogConfig;
    protected final DialogSystemPublisher dialogSystemPublisher;
    protected TaskInvokerIgnoringErrors taskInvoker;
    protected DialogListenerProxy dialogListenerProxy;
    protected IntOptHashSet requiredAudioConnections;
    protected DialogAudioConnectionClient audioClient;
    private final short sourceId;
    private AbstractDialog$ErrorCode error;
    private DialogWatchdog watchdog;
    private RequestAudio taskRequestAudio;
    private ReleaseAudio taskReleaseAudio;
    private BeginDialog taskBeginDialog;

    public AbstractDialog(Logger logger, AsrController asrController, TtsController ttsController, DialogSystemParameter dialogSystemParameter, int n, DialogSystemPublisher dialogSystemPublisher) {
        this(logger, asrController, ttsController, dialogSystemParameter, n, null, dialogSystemPublisher);
    }

    public AbstractDialog(Logger logger, AsrController asrController, TtsController ttsController, DialogSystemParameter dialogSystemParameter, int n, SpeechDialogConfiguration speechDialogConfiguration, DialogSystemPublisher dialogSystemPublisher) {
        this.logger = logger;
        this.error = AbstractDialog$ErrorCode.NO_ERROR;
        this.asr = asrController;
        this.tts = ttsController;
        this.dialogSystemParameter = dialogSystemParameter;
        this.dialogSystemPublisher = dialogSystemPublisher;
        this.dialogListenerProxy = new DialogListenerProxy();
        this.dialogConfig = speechDialogConfiguration;
        if (this.dialogConfig == null) {
            this.dialogConfig = new AbstractDialog$1(this);
        }
        try {
            this.audioClient = new DialogAudioConnectionClient(this, this.dialogSystemParameter.getAudioConnectionProvider());
        }
        catch (Exception exception) {
            this.logger.fatal(8, "Can't create an AudioConnectionClient for this Dialog! ", exception);
            this.setError(AbstractDialog$ErrorCode.ERROR_AUDIO);
        }
        this.requiredAudioConnections = this.getRequiredAudioConnections(n);
        this.taskInvoker = new TaskInvokerIgnoringErrors(8, this.logger, "Dialog");
        this.taskInvoker.setInvokerListener(this);
        this.sourceId = Mappings$Audio.getSourceIdByPromptType(n);
        if (this.sourceId == -1) {
            this.logger.error(8, new StringBuffer().append("[Dialog]: Undefined sourceId for sessionType: ").append(n).toString());
        }
        this.taskRequestAudio = new RequestAudio(this.logger, this.audioClient, this.requiredAudioConnections, this.dialogSystemPublisher);
        this.taskRequestAudio.addListener(this);
        this.taskInvoker.add(this.taskRequestAudio);
        this.taskBeginDialog = new BeginDialog(this.logger, this.dialogSystemPublisher, this.dialogListenerProxy, this);
        this.taskInvoker.add(this.taskBeginDialog);
        this.taskReleaseAudio = new ReleaseAudio(this.logger, this.audioClient, this.requiredAudioConnections, this.dialogSystemPublisher);
        this.taskReleaseAudio.addListener(this);
        this.watchdog = new DialogWatchdog(this.logger, this, this.dialogSystemParameter.getAslServices().getTimerManager(), this.dialogSystemParameter.getAslServices().getASLThreadSwitch());
    }

    protected void setError(AbstractDialog$ErrorCode abstractDialog$ErrorCode) {
        this.error = abstractDialog$ErrorCode;
    }

    protected AbstractDialog$ErrorCode getError() {
        return this.error;
    }

    protected boolean hasError() {
        return !AbstractDialog$ErrorCode.NO_ERROR.equals(this.error);
    }

    private IntOptHashSet getRequiredAudioConnections(int n) {
        IntOptHashSet intOptHashSet = new IntOptHashSet();
        int n2 = Mappings$Audio.getAudioConnectionByPromptType(n);
        if (n2 != -1) {
            intOptHashSet.add(n2);
            if (n == 0) {
                intOptHashSet.add(113);
            }
        }
        return intOptHashSet;
    }

    @Override
    public void start() {
        this.logger.trace(8, "[Dialog]: starting dialog");
        this.watchdog.startWatching();
        this.taskInvoker.invoke();
    }

    @Override
    public void abort() {
        this.logger.trace(8, "[Dialog]: aborting dialog");
        this.watchdog.startCountDown();
        this.taskInvoker.abort();
        this.addEndDialog(1);
    }

    @Override
    public void pttBargeIn() {
        DialogTask dialogTask = (DialogTask)this.taskInvoker.getRunningTask();
        if (dialogTask != null) {
            dialogTask.onPttBargeIn();
        }
    }

    @Override
    public void clear() {
        this.taskInvoker.abort();
    }

    @Override
    public void clear(int n) {
        this.taskInvoker.abort(n);
        if ((8 & n) != 0) {
            this.taskInvoker.unlock();
        }
    }

    @Override
    public void terminate() {
        this.logger.warn(8, "[Dialog]: terminate( ) was called");
        this.setError(AbstractDialog$ErrorCode.ERROR_KILLED);
        this.tearDown(false, true);
    }

    protected void tearDown(boolean bl, boolean bl2) {
        Object object;
        this.logger.trace(8, "[Dialog]: tearing down dialog ...");
        if (!this.taskInvoker.isIdle()) {
            if (this.taskInvoker.isRunning() && !this.taskInvoker.getRunningTask().matchMask(8) && this.logger.isTraceEnabled(8)) {
                object = new StringBuffer("[Dialog]: ");
                ((StringBuffer)object).append("Dialog ends with unfinished tasks( ");
                ((StringBuffer)object).append(this.taskInvoker.toString());
                ((StringBuffer)object).append(" ) ... cleaning tasks ... ");
                this.logger.trace(8, ((StringBuffer)object).toString());
            }
            this.taskInvoker.abort();
        }
        if (bl2) {
            this.taskInvoker.terminate();
        }
        if (!bl) {
            this.logger.warn(8, "[Dialog]: Dialog ends before end was reached. Cleaning resources ...");
            this.dialogSystemPublisher.onDialogStepStarted(5);
            this.dialogSystemPublisher.onDialogStepFinished(5);
            object = new TaskInvokerIgnoringErrors(8, this.logger, "Unfinished-Dialog-Invoker");
            ReleaseAudio releaseAudio = new ReleaseAudio(this.logger, this.audioClient, this.requiredAudioConnections, this.dialogSystemPublisher);
            ((AbstractTaskInvoker)object).add(releaseAudio);
            ((AbstractTaskInvoker)object).invoke();
        }
        if (this.hasError()) {
            this.logger.warn(8, "[Dialog]: Call onTerminated( Dialog.RESULT_ERROR )");
            this.dialogListenerProxy.onTerminated(this, 1);
        } else {
            this.logger.trace(8, "[Dialog]: Call onTerminated( Dialog.RESULT_SUCCESSFUL )");
            this.dialogListenerProxy.onTerminated(this, 0);
        }
        this.dialogListenerProxy.removeAllDialogListener();
    }

    @Override
    public void addDialogListener(DialogListener dialogListener) {
        this.dialogListenerProxy.addDialogListener(dialogListener);
    }

    @Override
    public void removeDialogListener(DialogListener dialogListener) {
        this.dialogListenerProxy.removeDialogListener(dialogListener);
    }

    @Override
    public void addPrompts(Prompt[] promptArray, int n) {
        this.taskInvoker.add(new Prompting(this.logger, this.tts, promptArray, n, this.sourceId, this.dialogListenerProxy, this.dialogSystemPublisher, false));
    }

    @Override
    public void addFirstRecognition() {
        this.taskInvoker.add(new Recognition(this.logger, this.asr, true, this, this.dialogListenerProxy, this.dialogConfig));
    }

    @Override
    public void addRecognition() {
        this.taskInvoker.add(new Recognition(this.logger, this.asr, false, this, this.dialogListenerProxy, this.dialogConfig));
    }

    @Override
    public void addPause() {
        if (!this.isPaused()) {
            this.taskInvoker.add(new PauseTask(this.logger, this.dialogSystemParameter.getAslServices().getTimerManager(), this, this.dialogListenerProxy, this.dialogSystemPublisher));
        }
    }

    @Override
    public boolean isPaused() {
        return this.taskInvoker.getRunningTask() != null && this.taskInvoker.getRunningTask().matchMask(4);
    }

    @Override
    public abstract void addEndDialog(int n) {
    }

    protected void addEndDialog(DialogTask dialogTask) {
        this.taskInvoker.add(dialogTask);
        this.audioClient.removeClientAdapter(this);
        this.taskInvoker.add(this.taskReleaseAudio);
        this.taskInvoker.lock();
    }

    @Override
    public void playBackgroundPrompts(Prompt[] promptArray, int n) {
        if (this.taskInvoker.isIdle()) {
            Prompting prompting = new Prompting(this.logger, this.tts, promptArray, n, this.sourceId, this.dialogListenerProxy, this.dialogSystemPublisher, true);
            this.taskInvoker.add(prompting);
        } else if (this.taskInvoker.isRunning() && this.taskInvoker.getRunningTask().matchMask(33)) {
            RecognitionWithBackgroundPrompts recognitionWithBackgroundPrompts;
            Task task = this.taskInvoker.getRunningTask();
            Prompting prompting = new Prompting(this.logger, this.tts, promptArray, n, this.sourceId, this.dialogListenerProxy, this.dialogSystemPublisher, true);
            if (task instanceof RecognitionWithBackgroundPrompts) {
                recognitionWithBackgroundPrompts = (RecognitionWithBackgroundPrompts)task;
            } else {
                recognitionWithBackgroundPrompts = new RecognitionWithBackgroundPrompts(this.logger);
                this.taskInvoker.forkRunningTask(recognitionWithBackgroundPrompts);
            }
            recognitionWithBackgroundPrompts.addServantTask(prompting);
        } else {
            LogMessage logMessage = this.logger.warn(8);
            logMessage.append("[Dialog]: ");
            logMessage.append("Discarding please-wait-prompt because dialog is not idle and no recognition is pending!");
            logMessage.log();
        }
    }

    @Override
    public void invokingStopped(TaskInvoker taskInvoker) {
        this.logger.trace(8, "[Dialog]: Invoker stopped. ");
        if (taskInvoker.hasErrors()) {
            this.logger.warn(8, "[Dialog]: Time for error handling. ");
        } else {
            this.logger.trace(8, "[Dialog]: All tasks finished successful.  ");
            this.dialogListenerProxy.onIdle(this);
        }
    }

    @Override
    public void onAudioConnectionReleased(int n) {
    }

    @Override
    public void onAudioConnectionReserved(int n) {
    }

    @Override
    public void onAudioConnectionLost(int n) {
        if (this.requiredAudioConnections.contains(n)) {
            this.logger.info(8, new StringBuffer().append("[Dialog]: connection lost: ").append(n).toString());
            this.requiredAudioConnections.remove(n);
            this.audioClient.releaseConnections(this.requiredAudioConnections.toArray());
            this.onAudioConnectionLostInternal(n);
        }
    }

    protected abstract void onAudioConnectionLostInternal(int n) {
    }

    @Override
    public void taskFinishedSuccessful(Task task) {
        if (task.equals(this.taskRequestAudio)) {
            this.audioClient.addClientAdapter(this);
        } else if (task.equals(this.taskReleaseAudio)) {
            this.tearDown(true, false);
        }
    }

    @Override
    public void taskFinishedFlawed(Task task) {
        if (task.equals(this.taskRequestAudio)) {
            this.dialogListenerProxy.onStarted(this, 1);
            this.tearDown(true, false);
        } else if (task.equals(this.taskReleaseAudio)) {
            this.logger.warn(8, "Problems while releasing audio-connection!");
            this.tearDown(true, false);
        }
    }

    @Override
    public void taskFinishedAborted(Task task) {
    }
}

