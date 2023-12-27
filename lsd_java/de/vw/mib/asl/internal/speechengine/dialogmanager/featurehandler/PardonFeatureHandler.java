/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler;

import de.vw.mib.asl.api.speechengine.features.model.Prompt;
import de.vw.mib.asl.internal.speechengine.dialogmanager.DialogManagerLogger;
import de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler.PardonFeatureHandler$1;
import de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler.PardonFeatureHandler$2;
import de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler.internal.OrderedPromptsManager;
import de.vw.mib.asl.internal.speechengine.dialogmanager.interfaces.DialogManagerInternal;
import de.vw.mib.asl.internal.speechengine.dialogmanager.interfaces.DialogManagerStateListener;
import de.vw.mib.asl.internal.speechengine.dialogmanager.interfaces.FeatureHandler;
import de.vw.mib.asl.internal.speechengine.dialogsystem.SpeechDialogSystem;
import de.vw.mib.asl.internal.speechengine.features.master.PardonMasterFeature;
import de.vw.mib.asl.internal.speechengine.features.master.PauseMasterFeature;

public class PardonFeatureHandler
implements DialogManagerStateListener {
    public static final int PARDON_RETRIES_BEFORE_PAUSE;
    protected DialogManagerLogger logger = new DialogManagerLogger("[PardonFeatureHandler] ");
    private DialogManagerInternal dialogManager;
    private OrderedPromptsManager prompts;
    private OrderedPromptsManager pausePrompts;
    private int errorCounter = 0;
    private FeatureHandler pardonFeatureHandler = new PardonFeatureHandler$1(this);
    private FeatureHandler pauseFeatureHandler = new PardonFeatureHandler$2(this);

    public PardonFeatureHandler(DialogManagerInternal dialogManagerInternal, SpeechDialogSystem speechDialogSystem) {
        this.dialogManager = dialogManagerInternal;
        this.prompts = new OrderedPromptsManager();
        this.pausePrompts = new OrderedPromptsManager();
        this.dialogManager.registerFeatureHandler(106, this.pardonFeatureHandler);
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

    protected void handlePardonFeature(PardonMasterFeature pardonMasterFeature) {
        if (pardonMasterFeature.isPardonPromptsValid()) {
            this.prompts.clearPrompts();
            this.prompts.addPrompts(pardonMasterFeature.getPardonPrompts());
        }
    }

    protected void handlePauseFeature(PauseMasterFeature pauseMasterFeature) {
        if (pauseMasterFeature.isErrorPausePromptsValid()) {
            this.pausePrompts.clearPrompts();
            this.pausePrompts.addPrompts(pauseMasterFeature.getErrorPausePrompts());
        }
    }

    public void reset() {
        this.errorCounter = 0;
    }

    public void onConfidenceTooLow() {
        ++this.errorCounter;
        if (this.logger.isTraceEnabled()) {
            this.logger.trace(new StringBuffer().append("Confidence too low. Counter=").append(this.errorCounter).toString());
        }
        if (this.errorCounter <= 1) {
            if (this.prompts.isValid()) {
                this.dialogManager.playPrompt(this.prompts.getNextPromptId(), false, false);
            } else {
                this.logger.error("No pardon prompt set.");
            }
            this.dialogManager.startRecognition();
        } else if (this.errorCounter <= 2) {
            Prompt prompt = this.dialogManager.getHelpPrompt();
            if (prompt != null) {
                this.dialogManager.playPrompt(prompt.getPromptId(), false, false);
            } else {
                this.logger.error("No help prompt set.");
            }
            this.dialogManager.startRecognition();
        } else {
            if (this.logger.isTraceEnabled()) {
                this.logger.trace("Pause SDS");
            }
            this.errorCounter = 0;
            if (this.pausePrompts.isValid()) {
                this.dialogManager.playPrompt(this.pausePrompts.getNextPromptId(), true, false);
            } else {
                this.logger.error("No pause error prompt set.");
            }
            this.dialogManager.pauseSDS();
        }
    }
}

