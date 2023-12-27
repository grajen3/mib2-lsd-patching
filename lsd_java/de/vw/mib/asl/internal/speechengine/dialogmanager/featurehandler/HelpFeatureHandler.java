/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler;

import de.vw.mib.asl.api.speechengine.features.FeatureFactory;
import de.vw.mib.asl.api.speechengine.features.model.Command;
import de.vw.mib.asl.api.speechengine.features.model.OrderedPrompts;
import de.vw.mib.asl.api.speechengine.features.model.Prompt;
import de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler.AbstractCommandConsumer;
import de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler.BackFeatureHandler;
import de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler.HelpFeatureHandler$1;
import de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler.HelpFeatureHandler$2;
import de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler.HelpFeatureHandler$3;
import de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler.HelpFeatureHandler$4;
import de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler.OverloadFeatureHandler;
import de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler.internal.OrderedPromptsManager;
import de.vw.mib.asl.internal.speechengine.dialogmanager.interfaces.DialogManagerInternal;
import de.vw.mib.asl.internal.speechengine.dialogmanager.interfaces.DialogManagerStateListener;
import de.vw.mib.asl.internal.speechengine.dialogmanager.interfaces.FeatureHandler;
import de.vw.mib.asl.internal.speechengine.features.client.state.HelpPromptsStateFeature;
import de.vw.mib.asl.internal.speechengine.features.client.state.ListStateFeature;
import de.vw.mib.asl.internal.speechengine.features.master.HelpMasterFeature;
import de.vw.mib.asl.internal.speechengine.features.master.ListHelpPromptMasterFeature;

public class HelpFeatureHandler
extends AbstractCommandConsumer
implements DialogManagerStateListener {
    private static final String LOGGER_PREFIX;
    private static final String COMMAND;
    private FeatureFactory featureFactory;
    private final OverloadFeatureHandler overloadFeatureHandler;
    protected OrderedPromptsManager feedbackPrompts;
    protected OrderedPromptsManager prompts;
    protected boolean enableListHelp = false;
    private int dialogManagerState;
    private final BackFeatureHandler backFeatureHandler;
    protected boolean isDialogStep = false;
    private FeatureHandler helpFeatureHandler = new HelpFeatureHandler$1(this);
    private FeatureHandler helpPromptsFeatureHandler = new HelpFeatureHandler$2(this);
    private FeatureHandler listHelpPromptFeatureHandler = new HelpFeatureHandler$3(this);
    private FeatureHandler listHelpActivationFeatureHandler = new HelpFeatureHandler$4(this);

    public HelpFeatureHandler(DialogManagerInternal dialogManagerInternal, OverloadFeatureHandler overloadFeatureHandler, FeatureFactory featureFactory, BackFeatureHandler backFeatureHandler) {
        super(dialogManagerInternal, "[HelpFeatureHandler] ", "HELP");
        this.dialogManager = dialogManagerInternal;
        this.overloadFeatureHandler = overloadFeatureHandler;
        this.featureFactory = featureFactory;
        this.backFeatureHandler = backFeatureHandler;
        this.prompts = new OrderedPromptsManager();
        this.feedbackPrompts = new OrderedPromptsManager();
        dialogManagerInternal.registerFeatureHandler(104, this.helpFeatureHandler);
        dialogManagerInternal.registerFeatureHandler(303, this.helpPromptsFeatureHandler);
        dialogManagerInternal.registerFeatureHandler(111, this.listHelpPromptFeatureHandler);
        dialogManagerInternal.registerFeatureHandler(307, this.listHelpActivationFeatureHandler);
        dialogManagerInternal.registerFeatureHandlerDone(this.listHelpPromptFeatureHandler);
        dialogManagerInternal.registerDialogManagerStateListener(this);
    }

    @Override
    public void onDialogManagerStateChanged(int n, int n2) {
        this.dialogManagerState = n2;
    }

    public void reset() {
        this.isDialogStep = false;
        this.enableListHelp = false;
        this.prompts.clearPrompts();
        this.prompts.setExtraPromptsEnabled(false);
    }

    @Override
    public void setCurrentDialogManagerState(int n) {
        this.dialogManagerState = n;
    }

    void handleHelpFeature(HelpMasterFeature helpMasterFeature) {
        if (helpMasterFeature.isHelpCommandValid()) {
            this.updateCommand(helpMasterFeature.getHelpCommand());
        }
        if (helpMasterFeature.isFeedbackPromptsValid()) {
            this.feedbackPrompts.clearPrompts();
            this.feedbackPrompts.addPrompts(helpMasterFeature.getFeedbackPrompts());
        }
    }

    void handleHelpPromptsFeature(HelpPromptsStateFeature helpPromptsStateFeature) {
        OrderedPrompts[] orderedPromptsArray;
        if (helpPromptsStateFeature.isHelpPromptsValid() && !this.prompts.equalPropmpts(orderedPromptsArray = helpPromptsStateFeature.getHelpPrompts())) {
            this.prompts.clearPrompts();
            for (int i2 = 0; i2 < orderedPromptsArray.length; ++i2) {
                this.prompts.addPrompts(orderedPromptsArray[i2]);
            }
        }
    }

    void handleListHelpPromptFeature(ListHelpPromptMasterFeature listHelpPromptMasterFeature) {
        if (listHelpPromptMasterFeature.isListHelpPromptValid()) {
            this.prompts.clearExtraPrompts();
            this.prompts.addSingleExtraPrompt(listHelpPromptMasterFeature.getListHelpPrompt());
        }
    }

    void handleListHelpActivationFeature(ListStateFeature listStateFeature) {
        if (listStateFeature.isListHelpPromptActivatedValid()) {
            this.enableListHelp = listStateFeature.isListHelpPromptActivated();
        }
    }

    @Override
    public void recognizedCommand(Command command) {
        if (this.overloadFeatureHandler.fireHelp()) {
            return;
        }
        if (this.dialogManagerState == 4) {
            this.playHelpPrompt();
        } else if (this.dialogManagerState == 3) {
            this.playHelpPrompt();
            this.dialogManager.resetHelpMode();
            this.backFeatureHandler.pushMode();
        } else {
            this.dialogManager.setState(3);
            if (this.feedbackPrompts.isValid()) {
                this.dialogManager.playPrompt(this.feedbackPrompts.getNextPromptId(), true, true);
            } else {
                this.logger.error("HELP command recognized in GLOBAL mode, changing to HELP mode, but no feedback prompts were specified.");
            }
            this.backFeatureHandler.pushMode();
        }
        this.dialogManager.startRecognition();
    }

    @Override
    public boolean isUniversal() {
        return true;
    }

    public void playHelpPrompt() {
        Prompt prompt = this.getHelpPrompt();
        if (prompt == null) {
            return;
        }
        this.dialogManager.playPrompt(prompt.getPromptId(), true, true);
    }

    public Prompt getHelpPrompt() {
        if (!this.prompts.isValid()) {
            this.logger.error("Triggered getHelpPrompt(), but no help prompts were specified.");
            return null;
        }
        Prompt prompt = this.featureFactory.createPrompt(this.prompts.getNextPromptId(), null);
        return prompt;
    }

    public void notifyDialogStep() {
        this.isDialogStep = true;
    }
}

