/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler;

import de.vw.mib.asl.api.speechengine.features.Feature;
import de.vw.mib.asl.internal.speechengine.config.SpeechEngineSettings;
import de.vw.mib.asl.internal.speechengine.dialogmanager.DialogManagerLogger;
import de.vw.mib.asl.internal.speechengine.dialogmanager.DialogManagerParameters;
import de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler.PleaseWaitFeatureHandler$1;
import de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler.PleaseWaitFeatureHandler$2;
import de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler.internal.OrderedPromptsManager;
import de.vw.mib.asl.internal.speechengine.dialogmanager.interfaces.DialogManagerInternal;
import de.vw.mib.asl.internal.speechengine.dialogmanager.interfaces.DialogManagerStateListener;
import de.vw.mib.asl.internal.speechengine.dialogmanager.interfaces.FeatureHandler;
import de.vw.mib.asl.internal.speechengine.dialogsystem.SpeechDialogSystem;
import de.vw.mib.asl.internal.speechengine.features.master.PleaseWaitMasterFeature;
import de.vw.mib.timer.Timer;
import de.vw.mib.timer.TimerManager;

public class PleaseWaitFeatureHandler
implements FeatureHandler,
DialogManagerStateListener {
    protected DialogManagerLogger logger = new DialogManagerLogger("[PleaseWaitFeatureHandler] ");
    protected DialogManagerInternal dialogManager;
    protected int dialogManagerState;
    protected OrderedPromptsManager pleaseWaitPrompts;
    protected Timer currentTimer;
    protected Timer firstTimer;
    protected Timer nextTimer;
    protected boolean pleaseWaitPlaying = false;
    private Runnable firstPleaseWaitTimeout = new PleaseWaitFeatureHandler$1(this);
    private Runnable nextPleaseWaitTimeout = new PleaseWaitFeatureHandler$2(this);

    public PleaseWaitFeatureHandler(DialogManagerInternal dialogManagerInternal, SpeechDialogSystem speechDialogSystem, DialogManagerParameters dialogManagerParameters) {
        this.dialogManager = dialogManagerInternal;
        this.pleaseWaitPrompts = new OrderedPromptsManager();
        this.dialogManager.registerFeatureHandler(108, this);
        this.dialogManager.registerFeatureHandlerDone(this);
        this.dialogManager.registerDialogManagerStateListener(this);
        TimerManager timerManager = dialogManagerParameters.getTimerManager();
        SpeechEngineSettings speechEngineSettings = dialogManagerParameters.getSpeechConfiguratorFactory().getSpeechEngineSettingsService(7).geSpeechEngineSettings();
        this.firstTimer = timerManager.createTimer("FirstPleaseWaitTimeoutTimer", speechEngineSettings.getFirstPleaseWaitTimeout(), false, this.firstPleaseWaitTimeout, dialogManagerParameters.getThreadSwitchingTarget());
        this.nextTimer = timerManager.createTimer("NextPleaseWaitTimeoutTimer", speechEngineSettings.getNextPleaseWaitTimeout(), false, this.nextPleaseWaitTimeout, dialogManagerParameters.getThreadSwitchingTarget());
        this.currentTimer = this.firstTimer;
    }

    protected void handlePleaseWaitFeature(PleaseWaitMasterFeature pleaseWaitMasterFeature) {
        if (pleaseWaitMasterFeature.isPleaseWaitPromptsValid()) {
            this.pleaseWaitPrompts.clearPrompts();
            this.pleaseWaitPrompts.addPrompts(pleaseWaitMasterFeature.getPleaseWaitPrompts());
        }
    }

    public void startPleaseWaitTimer() {
        if (!this.pleaseWaitPlaying) {
            if (this.logger.isTraceEnabled()) {
                StringBuffer stringBuffer = new StringBuffer("Start ");
                stringBuffer.append(this.currentTimer.getName());
                stringBuffer.append(" with delay: ");
                stringBuffer.append(this.currentTimer.getDelay());
                this.logger.trace(stringBuffer.toString());
            }
            this.pleaseWaitPlaying = true;
            this.currentTimer.start();
        }
    }

    public void resetPleaseWaitTimer() {
        if (this.pleaseWaitPlaying) {
            if (this.logger.isTraceEnabled()) {
                this.logger.trace("Reset please wait timer");
            }
            this.currentTimer.stop();
            this.pleaseWaitPlaying = false;
            this.currentTimer = this.firstTimer;
        }
    }

    protected void promptPleaseWait() {
        this.pleaseWaitPlaying = false;
        if (this.pleaseWaitPrompts.isValid()) {
            if (this.logger.isTraceEnabled()) {
                this.logger.trace("Please wait...");
            }
            this.dialogManager.playBackgroundPrompt(this.pleaseWaitPrompts.getNextPromptId());
        } else {
            this.logger.error(" no please wait prompt was set.");
        }
    }

    @Override
    public void handleFeature(int n, Feature feature) {
        this.handlePleaseWaitFeature((PleaseWaitMasterFeature)feature);
    }

    @Override
    public void updateFeature(int n, Feature feature) {
        this.handlePleaseWaitFeature((PleaseWaitMasterFeature)feature);
    }

    @Override
    public boolean handleDone() {
        return false;
    }

    @Override
    public boolean updateDone() {
        return false;
    }

    @Override
    public void onDialogManagerStateChanged(int n, int n2) {
        this.dialogManagerState = n2;
        this.resetPleaseWaitTimer();
    }

    @Override
    public void setCurrentDialogManagerState(int n) {
        this.dialogManagerState = n;
    }
}

