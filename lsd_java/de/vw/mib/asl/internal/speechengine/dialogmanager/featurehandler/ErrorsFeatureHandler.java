/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler;

import de.vw.mib.asl.api.speechengine.features.Feature;
import de.vw.mib.asl.internal.speechengine.dialogmanager.DialogManagerLogger;
import de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler.AbstractFeatureHandler;
import de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler.internal.OrderedPromptsManager;
import de.vw.mib.asl.internal.speechengine.dialogmanager.interfaces.DialogManagerInternal;
import de.vw.mib.asl.internal.speechengine.dialogsystem.SpeechDialogSystem;
import de.vw.mib.asl.internal.speechengine.features.master.ErrorsMasterFeature;

public class ErrorsFeatureHandler
extends AbstractFeatureHandler {
    protected DialogManagerLogger logger = new DialogManagerLogger("[ErrorsFeatureHandler] ");
    protected DialogManagerInternal dialogManager;
    private OrderedPromptsManager hardwareOfPoorQuality;
    private OrderedPromptsManager unknownError;
    private OrderedPromptsManager speechLevelTooLoud;
    private OrderedPromptsManager speechLevelTooWeak;
    private OrderedPromptsManager signalNoiseRatioTooLow;

    public ErrorsFeatureHandler(DialogManagerInternal dialogManagerInternal, SpeechDialogSystem speechDialogSystem) {
        this.dialogManager = dialogManagerInternal;
        this.hardwareOfPoorQuality = new OrderedPromptsManager();
        this.unknownError = new OrderedPromptsManager();
        this.speechLevelTooLoud = new OrderedPromptsManager();
        this.speechLevelTooWeak = new OrderedPromptsManager();
        this.signalNoiseRatioTooLow = new OrderedPromptsManager();
        this.dialogManager.registerFeatureHandler(103, this);
    }

    private void handleErrorsFeature(ErrorsMasterFeature errorsMasterFeature) {
        this.hardwareOfPoorQuality.clearPrompts();
        this.signalNoiseRatioTooLow.clearPrompts();
        this.speechLevelTooLoud.clearPrompts();
        this.speechLevelTooWeak.clearPrompts();
        this.unknownError.clearPrompts();
        if (errorsMasterFeature.isHardwareOfPoorQualityPromptsValid()) {
            this.hardwareOfPoorQuality.addPrompts(errorsMasterFeature.getHardwareOfPoorQualityPrompts());
        }
        if (errorsMasterFeature.isSignalNoiseRatioTooLowPromptsValid()) {
            this.signalNoiseRatioTooLow.addPrompts(errorsMasterFeature.getSignalNoiseRatioTooLowPrompts());
        }
        if (errorsMasterFeature.isSpeechLevelTooLoudPromptsValid()) {
            this.speechLevelTooLoud.addPrompts(errorsMasterFeature.getSpeechLevelTooLoudPrompts());
        }
        if (errorsMasterFeature.isSpeechLevelTooWeakPromptsValid()) {
            this.speechLevelTooWeak.addPrompts(errorsMasterFeature.getSpeechLevelTooWeakPrompts());
        }
        if (errorsMasterFeature.isUnknownErrorPromptsValid()) {
            this.unknownError.addPrompts(errorsMasterFeature.getUnknownErrorPrompts());
        }
    }

    @Override
    public void handleFeature(int n, Feature feature) {
        this.handleErrorsFeature((ErrorsMasterFeature)feature);
    }

    @Override
    public void updateFeature(int n, Feature feature) {
        this.handleErrorsFeature((ErrorsMasterFeature)feature);
    }

    public void onRecognitionFinished(int n) {
        switch (n) {
            case 102: {
                this.speechLevelTooLoud();
                this.dialogManager.startRecognition();
                break;
            }
            case 103: {
                this.speechLevelTooWeak();
                this.dialogManager.startRecognition();
                break;
            }
            case 105: {
                this.signalNoiseRatioTooLow();
                this.dialogManager.startRecognition();
                break;
            }
            case 31: {
                this.hardwareOfPoorQuality();
                this.dialogManager.endSDS();
                break;
            }
            default: {
                this.unknownError(n);
                this.dialogManager.endSDS();
            }
        }
    }

    private void speechLevelTooLoud() {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace("Recognition failed - too loud");
        }
        if (this.speechLevelTooLoud.isValid()) {
            this.dialogManager.playPrompt(this.speechLevelTooLoud.getNextPromptId(), false, false);
        } else {
            this.logger.error("no speechLevelTooLoud prompts set.");
        }
    }

    private void speechLevelTooWeak() {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace("Recognition failed - too weak");
        }
        if (this.speechLevelTooWeak.isValid()) {
            this.dialogManager.playPrompt(this.speechLevelTooWeak.getNextPromptId(), false, false);
        } else {
            this.logger.error("no speechLevelTooWeak prompts set.");
        }
    }

    private void signalNoiseRatioTooLow() {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace("Recognition failed - too noisy");
        }
        if (this.signalNoiseRatioTooLow.isValid()) {
            this.dialogManager.playPrompt(this.signalNoiseRatioTooLow.getNextPromptId(), false, false);
        } else {
            this.logger.error("no signalNoiseRatioTooLow prompts set.");
        }
    }

    private void hardwareOfPoorQuality() {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace("Recognition failed - audio failure");
        }
        if (this.hardwareOfPoorQuality.isValid()) {
            this.dialogManager.playPrompt(this.hardwareOfPoorQuality.getNextPromptId(), true, false);
        } else {
            this.logger.error("no hardwareOfPoorQuality prompts set.");
        }
    }

    private void unknownError(int n) {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace(new StringBuffer().append("Recognition failed - error unknown:").append(n).toString());
        }
        if (this.unknownError.isValid()) {
            this.dialogManager.playPrompt(this.unknownError.getNextPromptId(), true, false);
        } else {
            this.logger.error("no unknownError prompts set.");
        }
    }
}

