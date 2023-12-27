/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler;

import de.vw.mib.asl.api.speechengine.features.model.Command;
import de.vw.mib.asl.api.speechengine.features.model.Prompt;
import de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler.AbstractCommandConsumer;
import de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler.OverloadFeatureHandler;
import de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler.RepeatFeatureHandler$1;
import de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler.internal.OrderedPromptsManager;
import de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler.internal.PromptList;
import de.vw.mib.asl.internal.speechengine.dialogmanager.interfaces.DialogManagerInternal;
import de.vw.mib.asl.internal.speechengine.dialogmanager.interfaces.DialogManagerStateListener;
import de.vw.mib.asl.internal.speechengine.dialogmanager.interfaces.FeatureHandler;
import de.vw.mib.asl.internal.speechengine.features.master.RepeatMasterFeature;

public class RepeatFeatureHandler
extends AbstractCommandConsumer
implements DialogManagerStateListener {
    private static final String LOGGER_PREFIX;
    private static final String COMMAND;
    private final OverloadFeatureHandler overloadFeatureHandler;
    private OrderedPromptsManager prompts;
    private PromptList promptQueue;
    private FeatureHandler repeatFeatureHandler = new RepeatFeatureHandler$1(this);

    public RepeatFeatureHandler(DialogManagerInternal dialogManagerInternal, OverloadFeatureHandler overloadFeatureHandler) {
        super(dialogManagerInternal, "[RepeatFeatureHandler] ", "REPEAT");
        this.dialogManager = dialogManagerInternal;
        this.overloadFeatureHandler = overloadFeatureHandler;
        this.promptQueue = new PromptList();
        this.prompts = new OrderedPromptsManager();
        dialogManagerInternal.registerFeatureHandler(109, this.repeatFeatureHandler);
        dialogManagerInternal.registerDialogManagerStateListener(this);
    }

    @Override
    public void onDialogManagerStateChanged(int n, int n2) {
        if (n2 == 1) {
            this.clearPrompts();
        }
    }

    @Override
    public void setCurrentDialogManagerState(int n) {
    }

    void handleRepeatFeature(RepeatMasterFeature repeatMasterFeature) {
        if (repeatMasterFeature.isRepeatCommandValid()) {
            this.updateCommand(repeatMasterFeature.getRepeatCommand());
        }
        if (repeatMasterFeature.isRepeatFallbackPromptsValid()) {
            this.prompts.clearPrompts();
            this.prompts.addPrompts(repeatMasterFeature.getRepeatFallbackPrompts());
        }
    }

    @Override
    public void recognizedCommand(Command command) {
        if (this.overloadFeatureHandler.fireRepeat()) {
            return;
        }
        if (this.promptQueue.isEmpty()) {
            if (this.logger.isTraceEnabled()) {
                this.logger.trace("Repeat command recognized - Prompt queue is empty, play fallback repeat prompt.");
            }
            if (this.prompts.isValid()) {
                this.dialogManager.playPrompt(this.prompts.getNextPromptId(), true, false);
            } else {
                this.logger.error("Repeat command recognized - Prompt queue is empty, no fallback repeat prompt set.");
            }
        } else {
            if (this.logger.isTraceEnabled()) {
                this.logger.trace("Repeat command recognized - Repeat prompt queue.");
            }
            this.dialogManager.playPrompts(this.getRepeatPrompts().toArray(), false, false, 7);
        }
        this.dialogManager.startRecognition();
    }

    @Override
    public boolean isUniversal() {
        return true;
    }

    public PromptList getRepeatPrompts() {
        return this.promptQueue;
    }

    public void clearPrompts() {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace("Repeat queue cleared.");
        }
        this.promptQueue.clear();
    }

    public void addPrompts(Prompt[] promptArray) {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace("Added prompts to repeat queue.");
        }
        this.promptQueue.add(promptArray);
    }
}

