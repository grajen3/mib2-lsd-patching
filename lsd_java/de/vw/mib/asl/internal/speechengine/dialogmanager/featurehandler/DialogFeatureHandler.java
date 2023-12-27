/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler;

import de.vw.mib.asl.api.speechengine.config.settings.SpeechSettingsService;
import de.vw.mib.asl.api.speechengine.dialogmanager.DialogSessionListener;
import de.vw.mib.asl.api.speechengine.features.model.Prompt;
import de.vw.mib.asl.internal.speechengine.dialogmanager.DialogManagerLogger;
import de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler.DialogFeatureHandler$1;
import de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler.DialogFeatureHandler$2;
import de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler.DialogFeatureHandler$3;
import de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler.DialogFeatureHandler$4;
import de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler.DialogFeatureHandler$PromptDialogListener;
import de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler.internal.PromptList;
import de.vw.mib.asl.internal.speechengine.dialogmanager.interfaces.DialogManagerInternal;
import de.vw.mib.asl.internal.speechengine.dialogmanager.interfaces.FeatureHandler;
import de.vw.mib.asl.internal.speechengine.dialogmanager.utils.SessionTypeUtil;
import de.vw.mib.asl.internal.speechengine.dialogmanager.utils.SpeechClientIdentifiersUtil;
import de.vw.mib.asl.internal.speechengine.dialogsystem.DialogListener;
import de.vw.mib.asl.internal.speechengine.dialogsystem.PromptDialog;
import de.vw.mib.asl.internal.speechengine.dialogsystem.PromptSystem;
import de.vw.mib.asl.internal.speechengine.dialogsystem.SpeechDialog;
import de.vw.mib.asl.internal.speechengine.dialogsystem.SpeechDialogConfiguration;
import de.vw.mib.asl.internal.speechengine.dialogsystem.SpeechDialogSystem;
import de.vw.mib.asl.internal.speechengine.features.client.state.behavior.DialogStepBehaviorStateFeature;
import de.vw.mib.asl.internal.speechengine.features.client.state.behavior.SpeakOnlyStateFeature;
import de.vw.mib.collections.ints.IntIterator;
import de.vw.mib.collections.ints.IntObjectMap;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DialogFeatureHandler {
    protected DialogManagerLogger logger = new DialogManagerLogger("[DialogFeatureHandler] ");
    protected final DialogManagerInternal dialogManager;
    protected final PromptSystem promptSystem;
    protected final SpeechSettingsService settingsService;
    protected SpeechDialogSystem speechDialogSystem;
    protected boolean dialogSessionActive = false;
    protected SpeechDialog currentSpeechDialog;
    protected IntObjectMap promptDialogs;
    protected DialogStepBehaviorStateFeature dialogStepBehavior = null;
    protected SpeakOnlyStateFeature speakOnlyBehavior = null;
    protected int clientId;
    protected boolean keepPromptsRunning = false;
    protected boolean ignoreNextPrompt = false;
    protected List pauseListeners;
    protected boolean isRecognitionRunning = false;
    protected DialogSessionListener currentSessionListener = null;
    private SpeechDialogConfiguration speechDialogConfiguration = new DialogFeatureHandler$1(this);
    private FeatureHandler dialogStepBehaviorFeatureHandler = new DialogFeatureHandler$2(this);
    private FeatureHandler speakOnlyFeatureHandler = new DialogFeatureHandler$3(this);
    private DialogListener speechDialogListener = new DialogFeatureHandler$4(this);

    public DialogFeatureHandler(DialogManagerInternal dialogManagerInternal, PromptSystem promptSystem, SpeechSettingsService speechSettingsService) {
        this.dialogManager = dialogManagerInternal;
        this.promptSystem = promptSystem;
        this.settingsService = speechSettingsService;
        this.promptDialogs = new IntObjectOptHashMap();
        this.pauseListeners = new ArrayList();
        this.dialogManager.registerFeatureHandler(305, this.dialogStepBehaviorFeatureHandler);
        this.dialogManager.registerFeatureHandler(306, this.speakOnlyFeatureHandler);
        this.dialogManager.registerFeatureHandlerDone(this.dialogStepBehaviorFeatureHandler);
    }

    public void setSpeechDialogSystem(SpeechDialogSystem speechDialogSystem) {
        this.speechDialogSystem = speechDialogSystem;
    }

    protected void handleDialogStepBehaviorFeature(int n, DialogStepBehaviorStateFeature dialogStepBehaviorStateFeature) {
        this.speakOnlyBehavior = null;
        this.dialogStepBehavior = dialogStepBehaviorStateFeature;
        this.clientId = n;
    }

    protected void handleSpeakOnlyFeature(int n, SpeakOnlyStateFeature speakOnlyStateFeature) {
        this.dialogStepBehavior = null;
        this.speakOnlyBehavior = speakOnlyStateFeature;
        this.clientId = n;
    }

    protected void doDialogStepBehavior() {
        int n;
        if (this.logger.isTraceEnabled()) {
            this.logger.trace("Executing DialogStepBehavior.");
        }
        this.dialogManager.notifyDialogStep();
        if (this.logger.isTraceEnabled()) {
            this.logger.trace("1. Clear task list.");
            this.logger.trace(new StringBuffer().append("2. Keep prompts running : ").append(this.dialogStepBehavior.isKeepPrompts() || this.keepPromptsRunning).toString());
        }
        if (this.dialogStepBehavior.isKeepPrompts() || this.keepPromptsRunning) {
            this.clearTaskList(5);
        } else {
            this.clearTaskList(7);
        }
        PromptList promptList = new PromptList();
        if (this.logger.isTraceEnabled()) {
            this.logger.trace(new StringBuffer().append("3. Play help prompt : ").append(this.dialogStepBehavior.isPlayHelpPrompt() && !this.ignoreNextPrompt).toString());
        }
        if (this.dialogStepBehavior.isPlayHelpPrompt() && !this.ignoreNextPrompt) {
            promptList.add(this.dialogManager.getHelpPrompt());
        }
        if (this.logger.isTraceEnabled()) {
            this.logger.trace("4. Play initial prompts");
        }
        promptList.add(this.dialogManager.getInitialPrompts());
        if (promptList.isEmpty()) {
            if (this.logger.isTraceEnabled()) {
                this.logger.trace("There are either help prompts nor initial prompts specified on state change.");
            }
        } else {
            this.dialogManager.playPrompts(promptList.toArray(), !this.dialogStepBehavior.isKeepPrompts(), true, this.clientId);
        }
        if ((n = (this.dialogStepBehavior.isStartRecognizerAutomatically() ? 1 : 0) + (this.dialogStepBehavior.isPauseAutomatically() ? 1 : 0) + (this.dialogStepBehavior.isEndSession() ? 1 : 0)) > 1) {
            StringBuffer stringBuffer = new StringBuffer("StartRecognitionAutomatically : ");
            stringBuffer.append(this.dialogStepBehavior.isStartRecognizerAutomatically());
            stringBuffer.append("; PauseAutomatically : ");
            stringBuffer.append(this.dialogStepBehavior.isPauseAutomatically());
            stringBuffer.append("; EndSession : ");
            stringBuffer.append(this.dialogStepBehavior.isEndSession());
            stringBuffer.append("; Only one or none of these may be true at one time. Make sure the MODEL does consider it. Dialog session aborted after error.");
            this.logger.error(stringBuffer.toString());
            this.abortDialog();
            return;
        }
        if (this.dialogStepBehavior.isStartRecognizerAutomatically()) {
            if (this.logger.isTraceEnabled()) {
                this.logger.trace("5. StartRecognitionAutomatically : true");
            }
            this.startRecognition();
        } else if (this.dialogStepBehavior.isEndSession()) {
            if (this.dialogStepBehavior.isEndSessionTypeValid()) {
                if (this.logger.isTraceEnabled()) {
                    this.logger.trace(new StringBuffer().append("5. EndSession : true, type : ").append(this.dialogStepBehavior.getEndSessionType()).toString());
                }
                this.endSDS(this.dialogStepBehavior.getEndSessionType());
            } else {
                if (this.logger.isTraceEnabled()) {
                    this.logger.trace("5. EndSession : true, type : SUCCESSFULL");
                }
                this.endSDS(1);
            }
        } else if (this.dialogStepBehavior.isPauseAutomatically()) {
            if (this.logger.isTraceEnabled()) {
                this.logger.trace("5. PauseAutomatically : true");
            }
            this.pauseSDS();
        } else if (this.logger.isTraceEnabled()) {
            this.logger.trace("5. Wait for next state. => Start Pause timeout");
        }
    }

    public void ignoreNextPrompt() {
        this.ignoreNextPrompt = true;
    }

    protected void doSpeakOnly() {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace("Executing SpeakOnly.");
        }
        int n = this.speakOnlyBehavior.getSessionType();
        Object object = this.promptDialogs.get(n);
        boolean bl = true;
        if (object == null) {
            object = this.promptSystem.createPromptDialog(n);
            this.promptDialogs.put(n, object);
            bl = false;
        }
        PromptDialog promptDialog = (PromptDialog)object;
        if (!bl) {
            promptDialog.addDialogListener(new DialogFeatureHandler$PromptDialogListener(this, n));
        } else {
            promptDialog.clear(8);
        }
        promptDialog.addPrompts(this.dialogManager.getInitialPrompts().toArray(), this.clientId);
        promptDialog.addEndDialog(0);
        if (!bl) {
            promptDialog.start();
        }
        if (this.logger.isTraceEnabled()) {
            StringBuffer stringBuffer = new StringBuffer();
            if (!bl) {
                stringBuffer.append("No prompt dialog exists for sessionType: ");
                stringBuffer.append(SessionTypeUtil.toString(n));
                stringBuffer.append(". -> Create new.");
            } else {
                stringBuffer.append("Prompt dialog already exists for sessionType: ");
                stringBuffer.append(SessionTypeUtil.toString(n));
                stringBuffer.append(". -> Reuse it.");
            }
            this.logger.trace(stringBuffer.toString());
        }
    }

    public void keepPromptsRunning() {
        this.keepPromptsRunning = true;
    }

    public void clearTaskList() {
        this.clearTaskList(39);
    }

    public void clearTaskList(int n) {
        if (this.logger.isTraceEnabled()) {
            StringBuffer stringBuffer = new StringBuffer("triggered clearTaskList(");
            ArrayList arrayList = new ArrayList();
            if ((n & 4) != 0) {
                arrayList.add("Task.MASK_PAUSE");
            }
            if ((n & 2) != 0) {
                arrayList.add("Task.MASK_PROMPT");
            }
            if ((n & 1) != 0) {
                arrayList.add("Task.MASK_RECOGNITION");
            }
            for (int i2 = 0; i2 < arrayList.size(); ++i2) {
                stringBuffer.append(arrayList.get(i2));
                if (i2 >= arrayList.size() - 1) continue;
                stringBuffer.append(" | ");
            }
            stringBuffer.append(")");
            this.logger.trace(stringBuffer.toString());
        }
        if (this.dialogSessionActive) {
            this.currentSpeechDialog.clear(n);
        } else {
            this.logger.error("clearTaskList() triggered without a running dialog session.");
        }
    }

    public void playPrompts(Prompt[] promptArray, int n) {
        if (promptArray == null || promptArray.length == 0) {
            this.logger.error("triggered playPrompts() with empty prompts");
            return;
        }
        this.tracePrompts("playPrompts()", promptArray);
        if (this.dialogSessionActive) {
            this.currentSpeechDialog.addPrompts(promptArray, n);
        } else {
            this.logger.error("playPrompt() triggered without a running dialog session.");
        }
    }

    public void playBackgroundPrompts(Prompt[] promptArray, int n) {
        if (promptArray == null || promptArray.length == 0) {
            this.logger.error("triggered playBackgroundPrompts() with empty prompts");
            return;
        }
        this.tracePrompts("playBackgroundPrompts()", promptArray);
        if (this.dialogSessionActive) {
            this.currentSpeechDialog.playBackgroundPrompts(promptArray, n);
        } else {
            this.logger.error("playBackgroundPrompts() triggered without a running dialog session.");
        }
    }

    private void tracePrompts(String string, Prompt[] promptArray) {
        if (this.logger.isTraceEnabled()) {
            StringBuffer stringBuffer = new StringBuffer("triggered ").append(string).append(" with prompts : [");
            for (int i2 = 0; i2 < promptArray.length; ++i2) {
                stringBuffer.append(promptArray[i2].toString());
                if (i2 >= promptArray.length - 1) continue;
                stringBuffer.append(",");
            }
            stringBuffer.append("]");
            this.logger.trace(stringBuffer.toString());
        }
    }

    public void pauseSDS() {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace("triggered pauseSDS()");
        }
        if (this.dialogSessionActive) {
            this.currentSpeechDialog.addPause();
        } else {
            this.logger.error("pauseSDS() triggered without a running dialog session.");
        }
    }

    public void endSDS(int n) {
        if (this.logger.isTraceEnabled()) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("triggered endSDS(");
            switch (n) {
                case 0: {
                    stringBuffer.append("DIALOG_END");
                    break;
                }
                case 1: {
                    stringBuffer.append("SUCCESSFULL");
                    break;
                }
                case 2: {
                    stringBuffer.append("UNSUCCESSFULL");
                    break;
                }
                default: {
                    stringBuffer.append("UNKNOWN[");
                    stringBuffer.append(n);
                    stringBuffer.append("]");
                }
            }
            stringBuffer.append(" )");
            this.logger.trace(stringBuffer.toString());
        }
        if (this.dialogSessionActive) {
            this.currentSpeechDialog.addEndDialog(n);
        } else {
            this.logger.error("endSDS() triggered without a running dialog session.");
        }
    }

    public void startRecognition() {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace("triggered startRecognition()");
        }
        if (this.dialogSessionActive) {
            this.currentSpeechDialog.addRecognition();
        } else {
            this.logger.error("startRecognition() triggered without a running dialog session.");
        }
    }

    private void startNewDialog() {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace("start new Dialog.");
        }
        this.dialogSessionActive = true;
        this.ignoreNextPrompt = false;
        this.isRecognitionRunning = false;
        this.currentSpeechDialog = this.speechDialogSystem.createSpeechDialog(this.speechDialogConfiguration);
        this.currentSpeechDialog.addDialogListener(this.speechDialogListener);
        this.currentSpeechDialog.addFirstRecognition();
        this.currentSpeechDialog.start();
    }

    protected void disposeDialog() {
        this.currentSpeechDialog = null;
        this.dialogSessionActive = false;
        this.isRecognitionRunning = false;
        this.dialogManager.setState(1);
        if (this.currentSessionListener != null) {
            this.currentSessionListener.onFinished();
            this.currentSessionListener = null;
        }
    }

    private void abortDialog() {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace("abort Dialog.");
        }
        this.currentSpeechDialog.abort();
    }

    protected void promptStarted(int n) {
        if (n == 7) {
            return;
        }
        this.dialogManager.firePromptStartedEvent(n);
    }

    protected void promptSpoken(int n) {
        if (n == 7) {
            return;
        }
        this.dialogManager.firePromptSpokenEvent(n);
    }

    public void startSession(DialogSessionListener dialogSessionListener) {
        if (!this.promptDialogs.isEmpty()) {
            Iterator iterator = this.promptDialogs.values().iterator();
            while (iterator.hasNext()) {
                PromptDialog promptDialog = (PromptDialog)iterator.next();
                promptDialog.pttBargeIn();
            }
            if (dialogSessionListener != null) {
                dialogSessionListener.onFinished();
            }
            return;
        }
        if (this.dialogSessionActive) {
            this.currentSpeechDialog.pttBargeIn();
            this.dialogManager.resetPleaseWaitTimer();
        } else {
            this.currentSessionListener = dialogSessionListener;
            this.startNewDialog();
        }
    }

    public void endSession(boolean bl) {
        if (!this.dialogSessionActive) {
            return;
        }
        if (bl) {
            this.abortDialog();
        } else {
            this.currentSpeechDialog.terminate();
            this.disposeDialog();
        }
    }

    public void pauseSession() {
        if (!this.dialogSessionActive) {
            return;
        }
        if (this.currentSpeechDialog.isPaused()) {
            this.dialogManager.resetPauseTimer();
            this.dialogManager.startPauseTimer();
            return;
        }
        this.dialogManager.resetCounters();
        this.clearTaskList(37);
        this.pauseSDS();
    }

    public void togglePause() {
        if (!this.dialogSessionActive) {
            return;
        }
        boolean bl = this.currentSpeechDialog.isPaused();
        this.clearTaskList();
        this.dialogManager.resetPleaseWaitTimer();
        this.dialogManager.resetCounters();
        if (bl) {
            this.startRecognition();
        } else {
            this.pauseSDS();
        }
    }

    public void cancelCurrentRunningPrompt(int n) {
        if (this.promptDialogs.isEmpty()) {
            if (this.logger.isTraceEnabled()) {
                StringBuffer stringBuffer = new StringBuffer("Client ");
                stringBuffer.append(SpeechClientIdentifiersUtil.toString(n));
                stringBuffer.append(" tried to cancel running prompts, but no prompts are running.");
                this.logger.trace(stringBuffer.toString());
            }
            return;
        }
        IntIterator intIterator = this.promptDialogs.keyIterator();
        while (intIterator.hasNext()) {
            int n2 = intIterator.next();
            if (n2 == 5 || n2 == 4) {
                if (!this.logger.isTraceEnabled()) continue;
                this.logger.trace("Found active NAV_MENU_REFERENCE or SDS_MENU_REFERENCE SpeakOnly Dialog. Do not abort it.");
                continue;
            }
            PromptDialog promptDialog = (PromptDialog)this.promptDialogs.get(n2);
            promptDialog.pttBargeIn();
        }
    }
}

