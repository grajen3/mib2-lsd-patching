/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler;

import de.vw.mib.asl.api.speechengine.features.model.Command;
import de.vw.mib.asl.internal.speechengine.config.SpeechEngineSettings;
import de.vw.mib.asl.internal.speechengine.dialogmanager.DialogManagerParameters;
import de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler.AbstractCommandConsumer;
import de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler.OverloadFeatureHandler;
import de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler.PauseFeatureHandler$1;
import de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler.PauseFeatureHandler$2;
import de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler.internal.OrderedPromptsManager;
import de.vw.mib.asl.internal.speechengine.dialogmanager.interfaces.DialogManagerInternal;
import de.vw.mib.asl.internal.speechengine.dialogmanager.interfaces.FeatureHandler;
import de.vw.mib.asl.internal.speechengine.features.master.PauseMasterFeature;
import de.vw.mib.timer.Timer;
import de.vw.mib.timer.TimerManager;

public class PauseFeatureHandler
extends AbstractCommandConsumer {
    private static final String LOGGER_PREFIX;
    private static final String COMMAND;
    private final OverloadFeatureHandler overloadFeatureHandler;
    private OrderedPromptsManager prompts;
    private OrderedPromptsManager timeoutPrompts;
    protected Timer pauseTimer;
    protected boolean pauseTimerActive = false;
    private FeatureHandler pauseFeatureHandler = new PauseFeatureHandler$1(this);
    private Runnable pauseTimeoutTask = new PauseFeatureHandler$2(this);

    public PauseFeatureHandler(DialogManagerInternal dialogManagerInternal, OverloadFeatureHandler overloadFeatureHandler, DialogManagerParameters dialogManagerParameters) {
        super(dialogManagerInternal, "[PauseFeatureHandler] ", "PAUSE");
        this.dialogManager = dialogManagerInternal;
        this.overloadFeatureHandler = overloadFeatureHandler;
        this.prompts = new OrderedPromptsManager();
        this.timeoutPrompts = new OrderedPromptsManager();
        dialogManagerInternal.registerFeatureHandler(107, this.pauseFeatureHandler);
        TimerManager timerManager = dialogManagerParameters.getTimerManager();
        SpeechEngineSettings speechEngineSettings = dialogManagerParameters.getSpeechConfiguratorFactory().getSpeechEngineSettingsService(7).geSpeechEngineSettings();
        this.pauseTimer = timerManager.createTimer("PauseTimer", speechEngineSettings.getPauseTimeout(), false, this.pauseTimeoutTask, dialogManagerParameters.getThreadSwitchingTarget());
    }

    void handlePauseFeature(PauseMasterFeature pauseMasterFeature) {
        if (pauseMasterFeature.isPauseCommandValid()) {
            this.updateCommand(pauseMasterFeature.getPauseCommand());
        }
        if (pauseMasterFeature.isCommandPausePromptsValid()) {
            this.prompts.clearPrompts();
            this.prompts.addPrompts(pauseMasterFeature.getCommandPausePrompts());
        }
        if (pauseMasterFeature.isPauseTimeoutPromptsValid()) {
            this.timeoutPrompts.clearPrompts();
            this.timeoutPrompts.addPrompts(pauseMasterFeature.getPauseTimeoutPrompts());
        }
    }

    public void startPauseTimer() {
        if (!this.pauseTimerActive) {
            if (this.logger.isTraceEnabled()) {
                StringBuffer stringBuffer = new StringBuffer("Start ");
                stringBuffer.append(this.pauseTimer.getName());
                stringBuffer.append(" with delay: ");
                stringBuffer.append(this.pauseTimer.getDelay());
                this.logger.trace(stringBuffer.toString());
            }
            this.pauseTimerActive = true;
            this.pauseTimer.start();
        }
    }

    public void resetPauseTimer() {
        if (this.pauseTimerActive) {
            if (this.logger.isTraceEnabled()) {
                this.logger.trace("Reset PauseTimer");
            }
            this.pauseTimerActive = false;
            this.pauseTimer.stop();
        }
    }

    @Override
    public void recognizedCommand(Command command) {
        if (this.overloadFeatureHandler.firePause()) {
            return;
        }
        if (this.prompts.isValid()) {
            if (this.logger.isTraceEnabled()) {
                this.logger.trace("Pause command recognized - Play pause prompt.");
            }
            this.dialogManager.playPrompt(this.prompts.getNextPromptId(), true, false);
        } else {
            this.logger.error("Pause command recognized - No pause prompt set.");
        }
        this.dialogManager.pauseSDS();
    }

    @Override
    public boolean isUniversal() {
        return true;
    }

    public void onPauseTimeout() {
        this.dialogManager.clearTaskList();
        if (this.timeoutPrompts.isValid()) {
            if (this.logger.isTraceEnabled()) {
                this.logger.trace("Pause timed out - play pause timeout prompt.");
            }
            this.dialogManager.playPrompt(this.timeoutPrompts.getNextPromptId(), true, false);
        } else {
            this.logger.error("Pause timed out - but no pause timeout prompt set.");
        }
        this.dialogManager.endSDS();
    }
}

