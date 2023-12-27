/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.dialogsystem.controller.asr;

import de.vw.mib.asl.internal.speechengine.dialogsystem.activity.Activity;
import de.vw.mib.asl.internal.speechengine.dialogsystem.activity.ActivityManager;
import de.vw.mib.asl.internal.speechengine.dialogsystem.activity.ActivityType;
import de.vw.mib.asl.internal.speechengine.dialogsystem.adapter.DSIAdapter;
import de.vw.mib.asl.internal.speechengine.dialogsystem.controller.grammar.GrammarController;
import de.vw.mib.asl.internal.speechengine.task.TaskInvoker;
import de.vw.mib.asl.internal.speechengine.task.TaskInvokerListener;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.log4mib.Logger;

public class AsrRestart
implements Activity,
TaskInvokerListener {
    private static final int TRACE_CLASS;
    private static final String TRACE_PREFIX;
    private final Logger logger;
    private DSIAdapter dsiAdapter;
    private GrammarController grammarController;
    private TaskInvoker startupInvoker;
    private ActivityManager activityManager;
    private boolean isActive;

    AsrRestart(Logger logger, DSIAdapter dSIAdapter, GrammarController grammarController, TaskInvoker taskInvoker, ActivityManager activityManager) {
        this.logger = logger;
        this.dsiAdapter = dSIAdapter;
        this.grammarController = grammarController;
        this.activityManager = activityManager;
        this.startupInvoker = taskInvoker;
        this.startupInvoker.setInvokerListener(this);
        this.isActive = false;
    }

    void deviceShutDown() {
        this.activate();
        this.dsiAdapter.uninitDSIProxy();
    }

    void deviceRestart() {
        this.activate();
        this.grammarController.onDeviceRestart();
        this.startupInvoker.invoke();
    }

    @Override
    public ActivityType getType() {
        return ActivityType.RESTART_ASR;
    }

    @Override
    public void invokingStopped(TaskInvoker taskInvoker) {
        this.deactivate();
    }

    private void activate() {
        LogMessage logMessage = this.logger.info(8);
        logMessage.append("[AsrRestart] ");
        logMessage.append("activate( ) ");
        if (!this.isActive) {
            logMessage.append(" ... starting now ...");
            this.activityManager.onActive(this);
            this.isActive = true;
        } else {
            logMessage.append(" ... already active ...");
        }
        logMessage.log();
    }

    private void deactivate() {
        LogMessage logMessage = this.logger.info(8);
        logMessage.append("[AsrRestart] ");
        logMessage.append("deactivate( ) ");
        logMessage.log();
        this.isActive = false;
        this.activityManager.onFinished(this);
    }
}

