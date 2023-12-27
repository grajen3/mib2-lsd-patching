/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler;

import de.vw.mib.asl.api.speechengine.features.model.Command;
import de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler.AbortFeatureHandler$1;
import de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler.AbstractCommandConsumer;
import de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler.OverloadFeatureHandler;
import de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler.internal.OrderedPromptsManager;
import de.vw.mib.asl.internal.speechengine.dialogmanager.interfaces.DialogManagerInternal;
import de.vw.mib.asl.internal.speechengine.dialogmanager.interfaces.FeatureHandler;
import de.vw.mib.asl.internal.speechengine.features.master.AbortMasterFeature;

public class AbortFeatureHandler
extends AbstractCommandConsumer {
    private static final String LOGGER_PREFIX;
    private static final String COMMAND;
    private final OverloadFeatureHandler overloadFeatureHandler;
    private OrderedPromptsManager prompts;
    private FeatureHandler abortFeatureHandler = new AbortFeatureHandler$1(this);

    public AbortFeatureHandler(DialogManagerInternal dialogManagerInternal, OverloadFeatureHandler overloadFeatureHandler) {
        super(dialogManagerInternal, "[AbortFeatureHandler] ", "ABORT");
        this.overloadFeatureHandler = overloadFeatureHandler;
        this.prompts = new OrderedPromptsManager();
        dialogManagerInternal.registerFeatureHandler(101, this.abortFeatureHandler);
    }

    void handleAbortFeature(AbortMasterFeature abortMasterFeature) {
        if (abortMasterFeature.isAbortCommandValid()) {
            this.updateCommand(abortMasterFeature.getAbortCommand());
        }
        if (abortMasterFeature.isAbortPromptsValid()) {
            this.prompts.clearPrompts();
            this.prompts.addPrompts(abortMasterFeature.getAbortPrompts());
        }
    }

    @Override
    public void recognizedCommand(Command command) {
        this.dialogManager.resetHelpMode();
        if (this.overloadFeatureHandler.fireAbort()) {
            return;
        }
        if (this.prompts.isValid()) {
            if (this.logger.isTraceEnabled()) {
                this.logger.trace("Abort command recognized - Play abort prompt.");
            }
            this.dialogManager.playPrompt(this.prompts.getNextPromptId(), true, false);
        } else {
            this.logger.error("Abort command recognized - No abort prompt set.");
        }
        this.dialogManager.endSDS();
    }

    @Override
    public boolean isUniversal() {
        return true;
    }
}

