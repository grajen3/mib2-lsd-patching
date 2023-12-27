/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler;

import de.vw.mib.asl.internal.speechengine.dialogmanager.DialogManagerLogger;
import de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler.InitialPromptsFeatureHandler$1;
import de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler.internal.PromptList;
import de.vw.mib.asl.internal.speechengine.dialogmanager.interfaces.DialogManagerInternal;
import de.vw.mib.asl.internal.speechengine.dialogmanager.interfaces.DialogManagerStateListener;
import de.vw.mib.asl.internal.speechengine.dialogmanager.interfaces.FeatureHandler;
import de.vw.mib.asl.internal.speechengine.features.client.state.InitialPromptsStateFeature;

public class InitialPromptsFeatureHandler
implements DialogManagerStateListener {
    protected DialogManagerLogger logger = new DialogManagerLogger("[InitialPromptsFeatureHandler] ");
    private PromptList promptList;
    private boolean ignoreNext = false;
    private FeatureHandler initialPromptsFeatureHandler = new InitialPromptsFeatureHandler$1(this);

    public InitialPromptsFeatureHandler(DialogManagerInternal dialogManagerInternal) {
        this.promptList = new PromptList();
        dialogManagerInternal.registerFeatureHandler(304, this.initialPromptsFeatureHandler);
        dialogManagerInternal.registerDialogManagerStateListener(this);
    }

    @Override
    public void onDialogManagerStateChanged(int n, int n2) {
        if (n2 == 1) {
            this.clearPromptList();
        }
    }

    @Override
    public void setCurrentDialogManagerState(int n) {
    }

    public void ignoreNext() {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace("Enabled ignore next initial prompts");
        }
        this.ignoreNext = true;
    }

    void handleInitialPromptsFeature(InitialPromptsStateFeature initialPromptsStateFeature) {
        if (this.ignoreNext) {
            if (this.logger.isTraceEnabled()) {
                this.logger.trace("Initial prompts ignored");
            }
            this.ignoreNext = false;
            return;
        }
        if (initialPromptsStateFeature.isInitialPromptsValid()) {
            this.promptList.add(initialPromptsStateFeature.getInitialPrompts());
        }
    }

    public void clearPromptList() {
        this.promptList.clear();
    }

    public PromptList getInitialPrompts() {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace(new StringBuffer().append("Triggered getInitialPrompts() with ").append(this.promptList.size()).append(" prompts in queue.").toString());
        }
        PromptList promptList = new PromptList();
        promptList.add(this.promptList.toArray());
        this.clearPromptList();
        return promptList;
    }
}

