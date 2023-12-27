/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.dialogsystem.appstate;

import de.vw.mib.asl.internal.speechengine.dialogsystem.DialogSystemInitializer;
import de.vw.mib.asl.internal.speechengine.dialogsystem.activity.ActivityManager;
import de.vw.mib.asl.internal.speechengine.dialogsystem.activity.ActivityObserver;
import de.vw.mib.asl.internal.speechengine.dialogsystem.activity.ActivityType;
import de.vw.mib.asl.internal.speechengine.dialogsystem.appstate.ApplicationStateTracker$1;
import de.vw.mib.asl.internal.speechengine.dialogsystem.appstate.DeactivationByLanguage;
import de.vw.mib.asl.internal.speechengine.dialogsystem.controller.grammar.GrammarController;
import de.vw.mib.asl.internal.speechengine.messenger.DialogSystemPublisher;
import de.vw.mib.asl.internal.speechengine.task.Task;
import de.vw.mib.asl.internal.speechengine.task.TaskListener;
import de.vw.mib.configuration.ConfigurationManager;
import de.vw.mib.configuration.RtMethodListener;
import de.vw.mib.genericevents.ThreadSwitchingTarget;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.log4mib.Logger;

public class ApplicationStateTracker
implements RtMethodListener,
ActivityObserver,
TaskListener {
    private static final int TRACE_CLASSIFIER;
    private static final String TRACE_PREFIX;
    private final Logger logger;
    private final DialogSystemPublisher publisher;
    private final ThreadSwitchingTarget aslThreadSwitch;
    private final ConfigurationManager configurationManager;
    private final ActivityManager activityManager;
    private int runState;
    private boolean isLanguageSupported;
    private boolean isLanguageChanging;
    private boolean isSwapActive;
    private int currentApplicationState;
    private GrammarController grammarController;
    private DeactivationByLanguage deactivationByLanguage;

    public ApplicationStateTracker(int n, ActivityManager activityManager, DialogSystemInitializer dialogSystemInitializer, DialogSystemPublisher dialogSystemPublisher, Logger logger, ThreadSwitchingTarget threadSwitchingTarget, ConfigurationManager configurationManager) {
        this.publisher = dialogSystemPublisher;
        this.logger = logger;
        this.aslThreadSwitch = threadSwitchingTarget;
        this.configurationManager = configurationManager;
        this.activityManager = activityManager;
        this.currentApplicationState = 0;
        this.runState = n;
        this.isLanguageSupported = true;
        this.isLanguageChanging = false;
        this.isSwapActive = this.configurationManager.isFeatureFlagSet(582);
        this.activityManager.addObserver(this, ActivityType.STARTUP);
        this.activityManager.addObserver(this, ActivityType.RESTART_ASR);
        this.activityManager.addObserver(this, ActivityType.RESTART_TTS);
        this.configurationManager.addRtMethodListener(this);
        dialogSystemInitializer.setApplicationStateTracker(this);
        this.grammarController = null;
        this.deactivationByLanguage = null;
        this.updateApplicationState();
    }

    public void setGrammarController(GrammarController grammarController) {
        if (this.grammarController == null && this.deactivationByLanguage == null) {
            this.grammarController = grammarController;
            this.deactivationByLanguage = new DeactivationByLanguage(this.logger, this.grammarController);
        }
        if (!this.isLanguageSupported) {
            this.deactivationByLanguage.start();
        }
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ApplicationStateTracker [isSwapActive=");
        stringBuffer.append(this.isSwapActive);
        stringBuffer.append(", runState=");
        stringBuffer.append(this.runState);
        stringBuffer.append(", isLanguageChanging=");
        stringBuffer.append(this.isLanguageChanging);
        stringBuffer.append(", isLanguageSupported=");
        stringBuffer.append(this.isLanguageSupported);
        stringBuffer.append(", currentApplicationState=");
        stringBuffer.append(this.currentApplicationState);
        stringBuffer.append("]");
        return stringBuffer.toString();
    }

    private void updateApplicationState() {
        if (!this.isSwapActive) {
            this.publishState(5);
        } else if (this.runState != 2) {
            this.publishState(1);
        } else if (this.isLanguageChanging) {
            this.publishState(4);
        } else if (!this.isLanguageSupported) {
            this.publishState(3);
        } else {
            this.publishState(2);
        }
    }

    private void publishState(int n) {
        if (n == this.currentApplicationState) {
            return;
        }
        this.currentApplicationState = n;
        LogMessage logMessage = this.logger.info(8);
        logMessage.append("[ApplicationStateTracker] ");
        logMessage.append("publish new application-state: ");
        logMessage.append(n);
        logMessage.append(", ");
        logMessage.append(this.toString());
        logMessage.log();
        this.publisher.onApplicationStateChanged(n);
    }

    public void onLanguageSupported(boolean bl) {
        boolean bl2 = this.isLanguageSupported != bl;
        this.isLanguageSupported = bl;
        if (!this.isLanguageSupported && bl2 && this.deactivationByLanguage != null) {
            this.deactivationByLanguage.start();
        }
        this.updateApplicationState();
    }

    public int getCurrentApplicationStatus() {
        return this.currentApplicationState;
    }

    @Override
    public void onActivityActive(ActivityType activityType) {
        if (ActivityType.LANGUAGE_CHANGE.equals(activityType)) {
            this.isLanguageChanging = true;
            this.updateApplicationState();
        } else if (ActivityType.STARTUP.equals(activityType) || ActivityType.RESTART_ASR.equals(activityType) || ActivityType.RESTART_TTS.equals(activityType)) {
            this.runState = 1;
            this.updateApplicationState();
        }
    }

    @Override
    public void onActivityIdle(ActivityType activityType) {
        if (ActivityType.LANGUAGE_CHANGE.equals(activityType)) {
            this.isLanguageChanging = false;
            this.updateApplicationState();
        } else if (ActivityType.STARTUP.equals(activityType)) {
            this.runState = 2;
            this.activityManager.addObserver(this, ActivityType.LANGUAGE_CHANGE);
            this.updateApplicationState();
        } else if (ActivityType.RESTART_ASR.equals(activityType) || ActivityType.RESTART_TTS.equals(activityType)) {
            this.runState = 2;
            this.updateApplicationState();
        }
    }

    @Override
    public void onRtMethodValueChanged(String string) {
        if ("ASL.Configuration.isSdsSwAP".equals(string)) {
            this.aslThreadSwitch.enqueue(new ApplicationStateTracker$1(this));
        }
    }

    void onRtMethodValueChangedInASLThread() {
        this.isSwapActive = this.configurationManager.isFeatureFlagSet(582);
        this.updateApplicationState();
    }

    @Override
    public void taskFinishedSuccessful(Task task) {
        this.undoDeactivation(task);
    }

    @Override
    public void taskFinishedFlawed(Task task) {
        this.undoDeactivation(task);
    }

    @Override
    public void taskFinishedAborted(Task task) {
        this.undoDeactivation(task);
    }

    private void undoDeactivation(Task task) {
        if (this.deactivationByLanguage != null && task.matchMask(32)) {
            this.deactivationByLanguage.undo();
        }
    }
}

