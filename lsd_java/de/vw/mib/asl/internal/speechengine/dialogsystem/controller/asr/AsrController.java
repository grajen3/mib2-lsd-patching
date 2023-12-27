/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.dialogsystem.controller.asr;

import de.vw.mib.asl.api.speechengine.vde.VoiceDestinationEntry;
import de.vw.mib.asl.api.speechengine.vde.VoiceDestinationEntryCallback;
import de.vw.mib.asl.internal.speechengine.diagnosis.DialogSystemDiagnosisListener;
import de.vw.mib.asl.internal.speechengine.dialogsystem.DialogSystemInitializer;
import de.vw.mib.asl.internal.speechengine.dialogsystem.activity.ActivityManager;
import de.vw.mib.asl.internal.speechengine.dialogsystem.adapter.DSIAdapter;
import de.vw.mib.asl.internal.speechengine.dialogsystem.adapter.GenericEventsAdapter;
import de.vw.mib.asl.internal.speechengine.dialogsystem.adapter.handler.AsrAdapterHandlerRegistry;
import de.vw.mib.asl.internal.speechengine.dialogsystem.adapter.handler.AsrDeviceFailureHandler;
import de.vw.mib.asl.internal.speechengine.dialogsystem.appstate.ApplicationStateTracker;
import de.vw.mib.asl.internal.speechengine.dialogsystem.controller.DeviceController;
import de.vw.mib.asl.internal.speechengine.dialogsystem.controller.asr.AsrRestart;
import de.vw.mib.asl.internal.speechengine.dialogsystem.controller.asr.capabilities.RequestVdeCaps;
import de.vw.mib.asl.internal.speechengine.dialogsystem.controller.asr.config.RecognizerConfigImpl;
import de.vw.mib.asl.internal.speechengine.dialogsystem.controller.asr.config.SwapConfigurationAttribute;
import de.vw.mib.asl.internal.speechengine.dialogsystem.controller.grammar.GrammarController;
import de.vw.mib.asl.internal.speechengine.dialogsystem.nbest.SubItemRequestHandler;
import de.vw.mib.asl.internal.speechengine.dialogsystem.start.DialogSystemParameter;
import de.vw.mib.asl.internal.speechengine.dialogsystem.startup.ConnectCommunications;
import de.vw.mib.asl.internal.speechengine.dialogsystem.startup.asr.InitDsiSpeechRec;
import de.vw.mib.asl.internal.speechengine.dialogsystem.startup.asr.RecognizerParameter;
import de.vw.mib.asl.internal.speechengine.task.TaskInvoker;
import de.vw.mib.asl.internal.speechengine.task.TaskInvokerListener;
import de.vw.mib.asl.internal.speechengine.task.TaskInvokerStopOnFailure;
import de.vw.mib.configuration.ConfigurationManagerDiag;
import de.vw.mib.log4mib.Logger;
import org.dsi.ifc.speechrec.DSISpeechRec;

public class AsrController
extends DeviceController
implements TaskInvokerListener,
VoiceDestinationEntry,
AsrDeviceFailureHandler {
    private Logger logger;
    private static final String TRACE_PREFIX;
    private static final int TRACE_CLASSIFIER;
    private final GrammarController grammarController;
    private final GenericEventsAdapter genericEventsAdapter;
    private final DSIAdapter dsiAdapter;
    private final SwapConfigurationAttribute swapAttribute;
    private final RecognizerConfigImpl recognizerConfig;
    private TaskInvokerStopOnFailure startupInvoker;
    private SubItemRequestHandler subItemRequest;
    private AsrRestart restart;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$SwapHandler;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$AsrDeviceFailureHandler;

    public AsrController(DialogSystemParameter dialogSystemParameter, DialogSystemInitializer dialogSystemInitializer, DSIAdapter dSIAdapter, GenericEventsAdapter genericEventsAdapter, DialogSystemDiagnosisListener dialogSystemDiagnosisListener, ConfigurationManagerDiag configurationManagerDiag, ActivityManager activityManager, ApplicationStateTracker applicationStateTracker) {
        super(dialogSystemParameter, dialogSystemInitializer, dialogSystemDiagnosisListener, activityManager, applicationStateTracker);
        this.logger = this.dialogSystemParameter.getLogger();
        this.dsiAdapter = dSIAdapter;
        this.genericEventsAdapter = genericEventsAdapter;
        this.swapAttribute = new SwapConfigurationAttribute(configurationManagerDiag);
        this.grammarController = new GrammarController(this.logger, dialogSystemParameter, dialogSystemInitializer, dialogSystemDiagnosisListener, this, activityManager, this.swapAttribute.isSwapEnabled(), applicationStateTracker);
        this.recognizerConfig = new RecognizerConfigImpl(this, this.logger);
    }

    public DSISpeechRec getSpeechRec() {
        return (DSISpeechRec)this.dsiAdapter.getDSIProxy();
    }

    public AsrAdapterHandlerRegistry getHandlerRegistry() {
        return (AsrAdapterHandlerRegistry)this.dsiAdapter.getAdapterHandlerRegistry();
    }

    @Override
    public void start() {
        this.logger.trace(512, "[AsrController]: start");
        this.startupInvoker = this.getStartupInvoker();
        this.startupInvoker.setInvokerListener(this);
        this.startupInvoker.invoke();
    }

    @Override
    public void onDeviceShutdown() {
        this.logger.info(512, "[AsrController]: Device Shutdown");
        TaskInvokerStopOnFailure taskInvokerStopOnFailure = this.getStartupInvoker();
        this.restart = new AsrRestart(this.logger, this.dsiAdapter, this.grammarController, taskInvokerStopOnFailure, this.activityManager);
        this.restart.deviceShutDown();
    }

    @Override
    public void onDeviceRestart() {
        this.logger.info(512, "[AsrController]: Device Restart");
        this.dialogSystemInitializer.getConfiRegistry().removeRecognizerConfig(this.recognizerConfig);
        this.restart.deviceRestart();
    }

    public SubItemRequestHandler getGroupSubItemRequest() {
        return this.subItemRequest;
    }

    public void activateSWapStateTracking() {
        this.getHandlerRegistry().addHandler(class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$SwapHandler == null ? (class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$SwapHandler = AsrController.class$("de.vw.mib.asl.internal.speechengine.dialogsystem.adapter.handler.SwapHandler")) : class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$SwapHandler, this.swapAttribute);
        this.dsiAdapter.trackSwapState();
    }

    private TaskInvokerStopOnFailure getStartupInvoker() {
        TaskInvokerStopOnFailure taskInvokerStopOnFailure = new TaskInvokerStopOnFailure(512, this.logger, "ASR-Startup-Invoker");
        ConnectCommunications connectCommunications = new ConnectCommunications(this.logger, this.genericEventsAdapter, this.dsiAdapter, 512);
        taskInvokerStopOnFailure.add(connectCommunications);
        InitDsiSpeechRec initDsiSpeechRec = new InitDsiSpeechRec(this.logger, this);
        taskInvokerStopOnFailure.add(initDsiSpeechRec);
        RecognizerParameter recognizerParameter = new RecognizerParameter(this.logger, this);
        taskInvokerStopOnFailure.add(recognizerParameter);
        return taskInvokerStopOnFailure;
    }

    private TaskInvokerStopOnFailure getReInitInvoker() {
        TaskInvokerStopOnFailure taskInvokerStopOnFailure = new TaskInvokerStopOnFailure(512, this.logger, "ASR-ReInit-Invoker");
        InitDsiSpeechRec initDsiSpeechRec = new InitDsiSpeechRec(this.logger, this);
        taskInvokerStopOnFailure.add(initDsiSpeechRec);
        RecognizerParameter recognizerParameter = new RecognizerParameter(this.logger, this);
        taskInvokerStopOnFailure.add(recognizerParameter);
        return taskInvokerStopOnFailure;
    }

    @Override
    public void invokingStopped(TaskInvoker taskInvoker) {
        this.logger.info(512, "[AsrController]: Startup has finished. ");
        if (taskInvoker.hasErrors()) {
            this.logger.error(512, "[AsrController]: Errors occured in ASR startup. ");
        }
        this.grammarController.onAsrDeviceReady();
        this.subItemRequest = new SubItemRequestHandler(this.logger, this);
        this.dialogSystemInitializer.setAsrController(this);
        this.getHandlerRegistry().addHandler(class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$AsrDeviceFailureHandler == null ? (class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$AsrDeviceFailureHandler = AsrController.class$("de.vw.mib.asl.internal.speechengine.dialogsystem.adapter.handler.AsrDeviceFailureHandler")) : class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$AsrDeviceFailureHandler, this);
    }

    @Override
    public void requestCapabilities(String string, VoiceDestinationEntryCallback voiceDestinationEntryCallback) {
        new RequestVdeCaps(this.logger, string, voiceDestinationEntryCallback, this).execute();
    }

    public void onAvailableLanguagesReady() {
        this.dialogSystemInitializer.setAsrConfig(this.recognizerConfig);
    }

    @Override
    public void dsiSpeechRecUpdateFailure() {
        TaskInvokerStopOnFailure taskInvokerStopOnFailure = this.getReInitInvoker();
        this.restart = new AsrRestart(this.logger, this.dsiAdapter, this.grammarController, taskInvokerStopOnFailure, this.activityManager);
        this.onDeviceRestart();
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

