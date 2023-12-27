/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler;

import de.vw.mib.asl.api.speechengine.features.Feature;
import de.vw.mib.asl.api.speechengine.features.model.Event;
import de.vw.mib.asl.internal.speechengine.dialogmanager.DialogManagerLogger;
import de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler.AbstractCommandConsumer;
import de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler.AbstractFeatureHandler;
import de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler.MainMenuFeatureHandler$1;
import de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler.internal.OrderedPromptsManager;
import de.vw.mib.asl.internal.speechengine.dialogmanager.interfaces.DialogManagerInternal;
import de.vw.mib.asl.internal.speechengine.dialogsystem.SpeechDialogSystem;
import de.vw.mib.asl.internal.speechengine.features.master.MainMenuMasterFeature;
import de.vw.mib.asl.internal.speechengine.messenger.HmiEventPublisher;

public class MainMenuFeatureHandler
extends AbstractFeatureHandler {
    private static final String LOGGER_PREFIX;
    private static final String COMMAND;
    protected DialogManagerLogger logger = new DialogManagerLogger("[MainMenuFeatureHandler] ");
    private DialogManagerInternal dialogManager;
    private HmiEventPublisher hmiEventPublisher;
    protected OrderedPromptsManager prompts;
    private AbstractCommandConsumer commandConsumer;
    private Event event;
    private int menuContext;

    public MainMenuFeatureHandler(DialogManagerInternal dialogManagerInternal, SpeechDialogSystem speechDialogSystem, HmiEventPublisher hmiEventPublisher) {
        this.dialogManager = dialogManagerInternal;
        this.hmiEventPublisher = hmiEventPublisher;
        this.initCommandConsumer();
        this.prompts = new OrderedPromptsManager();
        dialogManagerInternal.registerFeatureHandler(105, this);
    }

    void handleMainMenuFeature(int n, MainMenuMasterFeature mainMenuMasterFeature) {
        this.menuContext = n;
        this.event = mainMenuMasterFeature.getMainMenuEvent();
        if (mainMenuMasterFeature.isMainMenuCommandValid()) {
            this.commandConsumer.updateCommand(mainMenuMasterFeature.getMainMenuCommand());
        }
        if (mainMenuMasterFeature.isMainMenuPromptsValid()) {
            this.prompts.clearPrompts();
            this.prompts.addPrompts(mainMenuMasterFeature.getMainMenuPrompts());
        }
    }

    @Override
    public void handleFeature(int n, Feature feature) {
        this.handleMainMenuFeature(n, (MainMenuMasterFeature)feature);
    }

    @Override
    public void updateFeature(int n, Feature feature) {
        this.handleMainMenuFeature(n, (MainMenuMasterFeature)feature);
    }

    public void openMainMenu(boolean bl, boolean bl2) {
        if (this.event != null) {
            if (this.logger.isTraceEnabled()) {
                this.logger.trace("Main menu.");
            }
            this.hmiEventPublisher.publishHmiEvent(this.menuContext, this.event.getEventId());
        } else {
            this.logger.error("Main menu open called - no main menu event set.");
        }
        if (bl) {
            if (this.prompts.isValid()) {
                if (this.logger.isTraceEnabled()) {
                    this.logger.trace("Play main menu prompt.");
                }
                this.dialogManager.playPrompt(this.prompts.getNextPromptId(), true, false);
            } else {
                this.logger.error("Play main menu prompt - No main menu prompt set.");
            }
        }
        if (bl2) {
            this.dialogManager.setState(2);
            this.dialogManager.clearBackstack(1);
        }
    }

    private void initCommandConsumer() {
        this.commandConsumer = new MainMenuFeatureHandler$1(this, this.dialogManager, "[MainMenuFeatureHandler] ", "MAIN_MENU");
    }
}

