/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.dialogsystem;

import de.vw.mib.asl.api.speechengine.vde.VoiceDestinationEntry;
import de.vw.mib.asl.framework.api.framework.Services;
import de.vw.mib.asl.internal.speechengine.audio.DialogSystemAudioAccessor;
import de.vw.mib.asl.internal.speechengine.diagnosis.DialogSystemDiagnosisImpl;
import de.vw.mib.asl.internal.speechengine.dialogsystem.CommandLoader;
import de.vw.mib.asl.internal.speechengine.dialogsystem.DialogRegistry;
import de.vw.mib.asl.internal.speechengine.dialogsystem.DialogSystemInitializer;
import de.vw.mib.asl.internal.speechengine.dialogsystem.PromptDialog;
import de.vw.mib.asl.internal.speechengine.dialogsystem.SpeechDialog;
import de.vw.mib.asl.internal.speechengine.dialogsystem.SpeechDialogConfiguration;
import de.vw.mib.asl.internal.speechengine.dialogsystem.SpeechDialogSystem;
import de.vw.mib.asl.internal.speechengine.dialogsystem.activity.ActivityManager;
import de.vw.mib.asl.internal.speechengine.dialogsystem.appstate.ApplicationStateTracker;
import de.vw.mib.asl.internal.speechengine.dialogsystem.config.DialogSystemConfigRegistry;
import de.vw.mib.asl.internal.speechengine.dialogsystem.config.RecognizerConfig;
import de.vw.mib.asl.internal.speechengine.dialogsystem.config.TTSConfig;
import de.vw.mib.asl.internal.speechengine.dialogsystem.controller.ConfigController;
import de.vw.mib.asl.internal.speechengine.dialogsystem.controller.asr.AsrController;
import de.vw.mib.asl.internal.speechengine.dialogsystem.controller.grammar.GrammarController;
import de.vw.mib.asl.internal.speechengine.dialogsystem.controller.tts.TtsController;
import de.vw.mib.asl.internal.speechengine.dialogsystem.dialog.DialogDeactivated;
import de.vw.mib.asl.internal.speechengine.dialogsystem.dialog.DialogSDS;
import de.vw.mib.asl.internal.speechengine.dialogsystem.dialog.DialogSpeakOnly;
import de.vw.mib.asl.internal.speechengine.dialogsystem.nbest.SubItemRequest;
import de.vw.mib.asl.internal.speechengine.dialogsystem.nbest.SubItemRequestHandler;
import de.vw.mib.asl.internal.speechengine.dialogsystem.start.DialogSystemParameter;
import de.vw.mib.asl.internal.speechengine.dialogsystem.startup.StartupActivity;
import de.vw.mib.log4mib.Logger;

public final class DialogSystemImpl
implements SpeechDialogSystem,
DialogSystemInitializer {
    private ApplicationStateTracker applicationStateTracker;
    private DialogSystemParameter dialogSystemParameter;
    private GrammarController grammarController;
    private AsrController asr;
    private TtsController tts;
    private TtsController ttsNavi;
    private Logger dsLogger;
    private DialogSystemDiagnosisImpl diagnosisDispatcher;
    private final ConfigController configController;
    private StartupActivity startupActivity;
    private final ActivityManager activityManager;
    private DialogRegistry dialogRegistry;

    public DialogSystemImpl(Services services, ActivityManager activityManager) {
        this.activityManager = activityManager;
        this.configController = new ConfigController();
    }

    public void onRestart() {
    }

    @Override
    public CommandLoader getCommandLoader() {
        return this.grammarController.getCommandLoaderProxy();
    }

    @Override
    public PromptDialog createPromptDialog(int n) {
        boolean bl = n == 5 || n == 6;
        TtsController ttsController = bl && this.ttsNavi != null ? this.ttsNavi : this.tts;
        DialogSpeakOnly dialogSpeakOnly = new DialogSpeakOnly(this.dsLogger, this.asr, ttsController, this.dialogSystemParameter, n);
        dialogSpeakOnly.addDialogListener(this.dialogRegistry);
        this.dialogRegistry.addDialog(dialogSpeakOnly);
        return dialogSpeakOnly;
    }

    @Override
    public SpeechDialog createSpeechDialog(SpeechDialogConfiguration speechDialogConfiguration) {
        SpeechDialog speechDialog = this.applicationStateTracker != null && this.applicationStateTracker.getCurrentApplicationStatus() == 2 ? new DialogSDS(this.dsLogger, this.asr, this.tts, this.dialogSystemParameter, 0, speechDialogConfiguration) : new DialogDeactivated();
        speechDialog.addDialogListener(this.dialogRegistry);
        this.dialogRegistry.addDialog(speechDialog);
        return speechDialog;
    }

    @Override
    public VoiceDestinationEntry getVoiceDestinationEntry() {
        return this.asr;
    }

    @Override
    public SubItemRequest getSubItemRequest() {
        return new SubItemRequestHandler(this.dsLogger, this.asr);
    }

    public DialogSystemConfigRegistry getDialogSystemConfig() {
        return this.configController;
    }

    @Override
    public void setParameter(DialogSystemParameter dialogSystemParameter) {
        if (this.dialogSystemParameter == null) {
            this.dialogSystemParameter = dialogSystemParameter;
            this.dsLogger = this.dialogSystemParameter.getLogger();
            this.dialogRegistry = new DialogRegistry(this.dsLogger, this.activityManager);
            this.dialogSystemParameter.getSpeechEngineStarter().onDialogSystemConfigReady(this.configController);
            DialogSystemAudioAccessor dialogSystemAudioAccessor = new DialogSystemAudioAccessor(this.dsLogger, this.dialogSystemParameter.getAudioConnectionProvider(), dialogSystemParameter.getAslServices().getTimerManager(), dialogSystemParameter.getAslServices().getASLThreadSwitch());
            this.dialogSystemParameter.getSpeechEngineStarter().onAudioAccessorReady(dialogSystemAudioAccessor);
            this.startupActivity = new StartupActivity(this.dsLogger, this.activityManager);
            this.startupActivity.start();
        }
    }

    @Override
    public void setGrammarController(GrammarController grammarController) {
        this.grammarController = grammarController;
        this.diagnosisDispatcher.setGrammarMonitor(this.grammarController);
        this.applicationStateTracker.setGrammarController(this.grammarController);
        this.onSubDeviceAdded();
    }

    @Override
    public void setAsrController(AsrController asrController) {
        this.asr = asrController;
        this.dialogSystemParameter.getSpeechEngineStarter().onVoiceDestinationEntryReady(this.asr);
        this.onSubDeviceAdded();
    }

    @Override
    public void setAsrConfig(RecognizerConfig recognizerConfig) {
        this.configController.addRecognizerConfig(recognizerConfig);
    }

    @Override
    public void setTtsController(TtsController ttsController) {
        if (ttsController.getInstanceId() == 0) {
            this.tts = ttsController;
            this.dialogSystemParameter.getSpeechEngineStarter().onPromptSystemReady(this);
            this.onSubDeviceAdded();
        }
        if (ttsController.getInstanceId() == 1) {
            this.ttsNavi = ttsController;
        }
    }

    @Override
    public void setTtsConfig(TTSConfig tTSConfig) {
        this.configController.addTtsConfig(tTSConfig);
    }

    @Override
    public void setDiagnosis(DialogSystemDiagnosisImpl dialogSystemDiagnosisImpl) {
        this.diagnosisDispatcher = dialogSystemDiagnosisImpl;
    }

    @Override
    public void setApplicationStateTracker(ApplicationStateTracker applicationStateTracker) {
        this.applicationStateTracker = applicationStateTracker;
    }

    private void onSubDeviceAdded() {
        if (this.asr != null && this.grammarController != null && this.tts != null) {
            this.asr.activateSWapStateTracking();
            this.dialogSystemParameter.getSpeechEngineStarter().onSpeechDialogSystemReady(this);
            this.startupActivity.onDevicesReady();
        }
    }

    @Override
    public ConfigController getConfiRegistry() {
        return this.configController;
    }
}

