/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler;

import de.vw.mib.asl.internal.speechengine.dialogmanager.DialogManagerLogger;
import de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler.TimeoutFeatureHandler$1;
import de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler.TimeoutFeatureHandler$2;
import de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler.internal.OrderedPromptsManager;
import de.vw.mib.asl.internal.speechengine.dialogmanager.interfaces.DialogManagerInternal;
import de.vw.mib.asl.internal.speechengine.dialogmanager.interfaces.DialogManagerStateListener;
import de.vw.mib.asl.internal.speechengine.dialogmanager.interfaces.FeatureHandler;
import de.vw.mib.asl.internal.speechengine.dialogsystem.SpeechDialogSystem;
import de.vw.mib.asl.internal.speechengine.features.master.PauseMasterFeature;
import de.vw.mib.asl.internal.speechengine.features.master.TimeoutMasterFeature;

public class TimeoutFeatureHandler
implements DialogManagerStateListener {
    public static final int TIMEOUT_RETRIES_BEFORE_PAUSE;
    protected DialogManagerLogger logger = new DialogManagerLogger("[TimeoutFeatureHandler] ");
    private DialogManagerInternal dialogManager;
    private OrderedPromptsManager prompts;
    private OrderedPromptsManager pausePrompts;
    private int timeoutCounter = 0;
    private FeatureHandler timeoutFeatureHandler = new TimeoutFeatureHandler$1(this);
    private FeatureHandler pauseFeatureHandler = new TimeoutFeatureHandler$2(this);

    public TimeoutFeatureHandler(DialogManagerInternal dialogManagerInternal, SpeechDialogSystem speechDialogSystem) {
        this.dialogManager = dialogManagerInternal;
        this.prompts = new OrderedPromptsManager();
        this.pausePrompts = new OrderedPromptsManager();
        this.dialogManager.registerFeatureHandler(110, this.timeoutFeatureHandler);
        this.dialogManager.registerFeatureHandler(107, this.pauseFeatureHandler);
        this.dialogManager.registerDialogManagerStateListener(this);
    }

    @Override
    public void onDialogManagerStateChanged(int n, int n2) {
        if (n2 == 1) {
            this.reset();
        }
    }

    @Override
    public void setCurrentDialogManagerState(int n) {
    }

    protected void handleTimeoutFeature(TimeoutMasterFeature timeoutMasterFeature) {
        if (timeoutMasterFeature.isTimeoutPromptsValid()) {
            this.prompts.clearPrompts();
            this.prompts.addPrompts(timeoutMasterFeature.getTimeoutPrompts());
        }
    }

    protected void handlePauseFeature(PauseMasterFeature pauseMasterFeature) {
        if (pauseMasterFeature.isErrorPausePromptsValid()) {
            this.pausePrompts.clearPrompts();
            this.pausePrompts.addPrompts(pauseMasterFeature.getErrorPausePrompts());
        }
    }

    public void reset() {
        this.timeoutCounter = 0;
    }

    public void onTimeout() {
        ++this.timeoutCounter;
        if (this.logger.isTraceEnabled()) {
            this.logger.trace(new StringBuffer().append("Timeout occured. Counter=").append(this.timeoutCounter).toString());
        }
        if (this.timeoutCounter <= 2) {
            if (this.prompts.isValid()) {
                this.dialogManager.playPrompt(this.prompts.getNextPromptId(), false, false);
            } else {
                this.logger.error("No timeout prompt set.");
            }
            this.dialogManager.startRecognition();
        } else {
            this.logger.trace("Pause SDS");
            this.timeoutCounter = 0;
            if (this.pausePrompts.isValid()) {
                this.dialogManager.playPrompt(this.pausePrompts.getNextPromptId(), true, false);
            } else {
                this.logger.error("No pause timeout prompt set.");
            }
            this.dialogManager.pauseSDS();
        }
    }
}

