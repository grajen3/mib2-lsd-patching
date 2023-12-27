/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.dialogsystem.controller.tts;

import de.vw.mib.asl.internal.speechengine.diagnosis.DialogSystemDiagnosisListener;
import de.vw.mib.asl.internal.speechengine.dialogsystem.DialogSystemInitializer;
import de.vw.mib.asl.internal.speechengine.dialogsystem.activity.ActivityManager;
import de.vw.mib.asl.internal.speechengine.dialogsystem.adapter.DSIAdapter;
import de.vw.mib.asl.internal.speechengine.dialogsystem.adapter.GenericEventsAdapter;
import de.vw.mib.asl.internal.speechengine.dialogsystem.adapter.handler.TtsAdapterHandlerRegistry;
import de.vw.mib.asl.internal.speechengine.dialogsystem.appstate.ApplicationStateTracker;
import de.vw.mib.asl.internal.speechengine.dialogsystem.controller.DeviceController;
import de.vw.mib.asl.internal.speechengine.dialogsystem.controller.tts.config.TtsConfigImpl;
import de.vw.mib.asl.internal.speechengine.dialogsystem.start.DialogSystemParameter;
import de.vw.mib.asl.internal.speechengine.dialogsystem.startup.ConnectCommunications;
import de.vw.mib.asl.internal.speechengine.dialogsystem.startup.tts.InitDsiTts;
import de.vw.mib.asl.internal.speechengine.task.TaskInvoker;
import de.vw.mib.asl.internal.speechengine.task.TaskInvokerListener;
import de.vw.mib.asl.internal.speechengine.task.TaskInvokerStopOnFailure;
import de.vw.mib.log4mib.Logger;
import org.dsi.ifc.tts.DSITTS;

public class TtsController
extends DeviceController
implements TaskInvokerListener {
    private final String TRACE_PREFIX;
    private static final int TRACE_CLASSIFIER;
    private Logger logger;
    private final GenericEventsAdapter genericEventsAdapter;
    private final DSIAdapter dsiAdapter;
    private TaskInvokerStopOnFailure startupInvoker;
    private final TtsConfigImpl ttsConfig;

    public TtsController(DialogSystemParameter dialogSystemParameter, DialogSystemInitializer dialogSystemInitializer, DSIAdapter dSIAdapter, GenericEventsAdapter genericEventsAdapter, DialogSystemDiagnosisListener dialogSystemDiagnosisListener, ActivityManager activityManager, ApplicationStateTracker applicationStateTracker) {
        super(dialogSystemParameter, dialogSystemInitializer, dialogSystemDiagnosisListener, activityManager, applicationStateTracker);
        this.logger = dialogSystemParameter.getLogger();
        this.dsiAdapter = dSIAdapter;
        this.genericEventsAdapter = genericEventsAdapter;
        this.TRACE_PREFIX = new StringBuffer().append("[TtsController[").append(this.dsiAdapter.getInstanceId()).append("]]: ").toString();
        this.ttsConfig = new TtsConfigImpl(this, this.logger);
    }

    public DSITTS getTts() {
        return (DSITTS)this.dsiAdapter.getDSIProxy();
    }

    public TtsAdapterHandlerRegistry getHandlerRegistry() {
        return (TtsAdapterHandlerRegistry)this.dsiAdapter.getAdapterHandlerRegistry();
    }

    public int getInstanceId() {
        return this.dsiAdapter.getInstanceId();
    }

    @Override
    public void start() {
        this.logger.trace(1024, new StringBuffer().append(this.TRACE_PREFIX).append("start").toString());
        this.startupInvoker = this.getStartupInvoker();
        this.startupInvoker.setInvokerListener(this);
        this.startupInvoker.invoke();
    }

    @Override
    public void onDeviceShutdown() {
        this.logger.info(1024, new StringBuffer().append(this.TRACE_PREFIX).append("Device Shutdown").toString());
        this.logger.info(1024, new StringBuffer().append(this.TRACE_PREFIX).append("Uninit DSIProxy").toString());
        this.dsiAdapter.uninitDSIProxy();
    }

    @Override
    public void onDeviceRestart() {
        this.logger.info(1024, new StringBuffer().append(this.TRACE_PREFIX).append("Device Restart").toString());
        this.logger.info(1024, new StringBuffer().append(this.TRACE_PREFIX).append("Repeat StartUp Sequence").toString());
        this.dialogSystemInitializer.getConfiRegistry().removeTtsConfig(this.ttsConfig);
        TaskInvokerStopOnFailure taskInvokerStopOnFailure = this.getStartupInvoker();
        taskInvokerStopOnFailure.invoke();
    }

    private TaskInvokerStopOnFailure getStartupInvoker() {
        TaskInvokerStopOnFailure taskInvokerStopOnFailure = new TaskInvokerStopOnFailure(1024, this.logger, "TTS-Startup-Invoker");
        ConnectCommunications connectCommunications = new ConnectCommunications(this.logger, this.genericEventsAdapter, this.dsiAdapter, 1024);
        taskInvokerStopOnFailure.add(connectCommunications);
        InitDsiTts initDsiTts = new InitDsiTts(this.logger, this, 1);
        taskInvokerStopOnFailure.add(initDsiTts);
        return taskInvokerStopOnFailure;
    }

    @Override
    public void invokingStopped(TaskInvoker taskInvoker) {
        this.logger.info(1024, new StringBuffer().append(this.TRACE_PREFIX).append("Startup has finished. ").toString());
        if (taskInvoker.hasErrors()) {
            this.logger.error(1024, new StringBuffer().append(this.TRACE_PREFIX).append("Errors occured durint TTS startup. ").toString());
        } else {
            this.dialogSystemInitializer.setTtsController(this);
        }
    }

    public void onVoiceInfoReady() {
        this.dialogSystemInitializer.setTtsConfig(this.ttsConfig);
    }
}

