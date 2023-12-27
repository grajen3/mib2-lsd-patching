/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler;

import de.vw.mib.asl.api.speechengine.dialogmanager.DialogBackHandler;
import de.vw.mib.asl.api.speechengine.dialogmanager.DialogBackstackListener;
import de.vw.mib.asl.api.speechengine.features.model.Command;
import de.vw.mib.asl.api.speechengine.features.model.Event;
import de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler.AbstractCommandConsumer;
import de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler.BackFeatureHandler$1;
import de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler.BackFeatureHandler$2;
import de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler.BackFeatureHandler$3;
import de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler.BackFeatureHandler$4;
import de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler.BackFeatureHandler$DefaultDialogBackHandler;
import de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler.OverloadFeatureHandler;
import de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler.internal.OrderedPromptsManager;
import de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler.internal.back.BackStack;
import de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler.internal.back.BackStackListener;
import de.vw.mib.asl.internal.speechengine.dialogmanager.interfaces.DialogManagerInternal;
import de.vw.mib.asl.internal.speechengine.dialogmanager.interfaces.DialogManagerStateListener;
import de.vw.mib.asl.internal.speechengine.dialogmanager.interfaces.FeatureHandler;
import de.vw.mib.asl.internal.speechengine.dialogmanager.utils.DialogBackstackStateUtil;
import de.vw.mib.asl.internal.speechengine.dialogmanager.utils.SpeechClientIdentifiersUtil;
import de.vw.mib.asl.internal.speechengine.features.client.state.BackstackStateFeature;
import de.vw.mib.asl.internal.speechengine.features.master.BackMasterFeature;
import de.vw.mib.asl.internal.speechengine.messenger.BackstackStatePublisher;
import de.vw.mib.asl.internal.speechengine.messenger.HmiEventPublisher;
import java.util.HashSet;
import java.util.Set;

public class BackFeatureHandler
extends AbstractCommandConsumer
implements DialogManagerStateListener {
    private static final String LOGGER_PREFIX;
    private static final String COMMAND;
    protected HmiEventPublisher hmiEventPublisher;
    private final BackstackStatePublisher backstackStatePublisher;
    private final OverloadFeatureHandler overloadFeatureHandler;
    private OrderedPromptsManager prompts;
    private BackStack backstack;
    protected int backstackClient = 1;
    private int dialogManagerState;
    private Event lastEvent;
    private boolean isDialogStep = false;
    private boolean hasBackstackFeature = false;
    protected boolean ignoreNextEvent = false;
    private int backstackState = 0;
    private Set dialogBackstackListener;
    private BackStackListener backstackListener = new BackFeatureHandler$1(this);
    private FeatureHandler backstackFeatureHandler = new BackFeatureHandler$2(this);
    private FeatureHandler backFeatureHandler = new BackFeatureHandler$3(this);
    private DialogBackHandler mainMenuHandler = new BackFeatureHandler$4(this);

    public BackFeatureHandler(DialogManagerInternal dialogManagerInternal, HmiEventPublisher hmiEventPublisher, OverloadFeatureHandler overloadFeatureHandler, BackstackStatePublisher backstackStatePublisher) {
        super(dialogManagerInternal, "[BackFeatureHandler] ", "BACK");
        this.dialogManager = dialogManagerInternal;
        this.hmiEventPublisher = hmiEventPublisher;
        this.overloadFeatureHandler = overloadFeatureHandler;
        this.backstackStatePublisher = backstackStatePublisher;
        this.dialogBackstackListener = new HashSet();
        this.backstack = new BackStack(this.mainMenuHandler);
        this.backstack.addBackStackListener(this.backstackListener);
        this.prompts = new OrderedPromptsManager();
        this.dialogManager.registerFeatureHandler(102, this.backFeatureHandler);
        this.dialogManager.registerFeatureHandler(301, this.backstackFeatureHandler);
        this.dialogManager.registerFeatureHandlerDone(this.backstackFeatureHandler);
        this.dialogManager.registerDialogManagerStateListener(this);
    }

    protected void setBackstackState(int n) {
        Object object;
        if (this.backstackState == n) {
            return;
        }
        if (this.logger.isTraceEnabled()) {
            object = new StringBuffer("changed backstack state to: ");
            ((StringBuffer)object).append(DialogBackstackStateUtil.toString(n));
            this.logger.trace(((StringBuffer)object).toString());
        }
        this.backstackState = n;
        this.backstackStatePublisher.publishBackstackState(n);
        object = this.dialogBackstackListener.iterator();
        while (object.hasNext()) {
            DialogBackstackListener dialogBackstackListener = (DialogBackstackListener)object.next();
            dialogBackstackListener.onBackstackStateChanged(n);
        }
    }

    @Override
    public void onDialogManagerStateChanged(int n, int n2) {
        this.dialogManagerState = n2;
        if (this.dialogManagerState == 4) {
            if (this.logger.isTraceEnabled()) {
                this.logger.trace("Changed DialogManager state to DIALOG => Clear backstack.");
            }
            this.clearBackstack(this.backstackClient);
        } else if (this.dialogManagerState == 1) {
            if (this.logger.isTraceEnabled()) {
                this.logger.trace("Changed DialogManager state to IDLE => Clear backstack.");
            }
            this.clearBackstack(this.backstackClient);
        }
    }

    public void registerDialogBackstackListener(DialogBackstackListener dialogBackstackListener) {
        this.dialogBackstackListener.add(dialogBackstackListener);
    }

    public void unregisterDialogBackstackListener(DialogBackstackListener dialogBackstackListener) {
        this.dialogBackstackListener.remove(dialogBackstackListener);
    }

    @Override
    public void setCurrentDialogManagerState(int n) {
        this.dialogManagerState = n;
    }

    public void notifyDialogStep() {
        this.isDialogStep = true;
    }

    void handleBackFeature(BackMasterFeature backMasterFeature) {
        if (backMasterFeature.isBackCommandValid()) {
            this.updateCommand(backMasterFeature.getBackCommand());
        }
        if (backMasterFeature.isBackPromptsValid()) {
            this.prompts.clearPrompts();
            this.prompts.addPrompts(backMasterFeature.getBackPrompts());
        }
    }

    void handleBackstackFeature(int n, BackstackStateFeature backstackStateFeature) {
        this.hasBackstackFeature = true;
        if (backstackStateFeature.isBackstackEventValid() && backstackStateFeature.isAddToBackstack()) {
            if (this.backstackClient != n) {
                if (this.logger.isTraceEnabled()) {
                    StringBuffer stringBuffer = new StringBuffer("Client changed from: ");
                    stringBuffer.append(SpeechClientIdentifiersUtil.toString(this.backstackClient));
                    stringBuffer.append(" to: ");
                    stringBuffer.append(SpeechClientIdentifiersUtil.toString(n));
                    stringBuffer.append(" => Clear backstack.");
                    this.logger.trace(stringBuffer.toString());
                }
                this.clearBackstack(n);
                this.backstackClient = n;
            }
            this.lastEvent = backstackStateFeature.getBackstackEvent();
        }
    }

    void handleBackstackFeatureDone() {
        if (this.ignoreNextEvent) {
            this.ignoreNextEvent = false;
            this.isDialogStep = false;
            this.hasBackstackFeature = false;
            this.lastEvent = null;
            return;
        }
        if (!this.isDialogStep) {
            if (this.logger.isTraceEnabled()) {
                this.logger.trace("Features without DialogStepBehavior. Skip handling backstack.");
            }
            return;
        }
        this.isDialogStep = false;
        if (!this.hasBackstackFeature) {
            if (this.logger.isTraceEnabled()) {
                this.logger.trace("DialogStep had no BackstackFeature.");
            }
            return;
        }
        this.hasBackstackFeature = false;
        if (this.logger.isTraceEnabled()) {
            if (this.lastEvent == null) {
                this.logger.trace("Added GAP to backstack.");
            } else {
                StringBuffer stringBuffer = new StringBuffer("Added event: ");
                stringBuffer.append(this.lastEvent.getEventId());
                stringBuffer.append(" to backstack.");
                this.logger.trace(stringBuffer.toString());
            }
        }
        if (this.lastEvent != null) {
            this.backstack.push(new BackFeatureHandler$DefaultDialogBackHandler(this, this.lastEvent, this.dialogManagerState, null));
        } else {
            this.backstack.pushGAP();
        }
        this.lastEvent = null;
    }

    public void pushMode() {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace("Mode changed, push it on backstack.");
        }
        DialogBackHandler dialogBackHandler = this.backstack.peek();
        Event event = null;
        if (dialogBackHandler instanceof BackFeatureHandler$DefaultDialogBackHandler) {
            event = ((BackFeatureHandler$DefaultDialogBackHandler)dialogBackHandler).event;
        }
        this.backstack.push(new BackFeatureHandler$DefaultDialogBackHandler(this, event, this.dialogManagerState, this.dialogManager.getRepeatPrompts().toArray()));
    }

    @Override
    public void recognizedCommand(Command command) {
        this.executeBack(true);
    }

    @Override
    public boolean isUniversal() {
        return true;
    }

    public void executeBack(boolean bl) {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace("BACK command recognized");
        }
        if (this.overloadFeatureHandler.fireBack()) {
            return;
        }
        if (this.ignoreNextEvent) {
            if (this.logger.isTraceEnabled()) {
                this.logger.trace("back ignored");
            }
            return;
        }
        DialogBackHandler dialogBackHandler = this.backstack.pop();
        if (dialogBackHandler.shouldBackPromptBePlayed() && bl) {
            this.playFeedbackPrompt();
        }
        dialogBackHandler.restoreState();
        if (this.logger.isTraceEnabled()) {
            this.logger.trace("State restored. Start recognition.");
        }
        this.dialogManager.startRecognition();
    }

    protected void playFeedbackPrompt() {
        if (this.prompts.isValid()) {
            if (this.logger.isTraceEnabled()) {
                this.logger.trace("Play 'back'-feedback prompt.");
            }
            this.dialogManager.playPrompt(this.prompts.getNextPromptId(), false, false);
            this.dialogManager.keepPromptsRunning();
        } else {
            this.logger.error("No 'back'-feedback prompt set.");
        }
    }

    public void clearBackstack(int n) {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace("Backstack cleared.");
        }
        this.backstackClient = n;
        this.backstack.clear();
        this.ignoreNextEvent = false;
    }

    public int getBackstackState() {
        return this.backstackState;
    }

    public BackStack getBackStack() {
        return this.backstack;
    }

    public void pushDialogBackHandler(DialogBackHandler dialogBackHandler) {
        this.backstack.push(dialogBackHandler);
    }
}

