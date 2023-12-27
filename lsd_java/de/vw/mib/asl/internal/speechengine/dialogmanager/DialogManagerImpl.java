/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.dialogmanager;

import de.vw.mib.asl.api.speechengine.config.settings.SpeechSettingsService;
import de.vw.mib.asl.api.speechengine.dialogmanager.DialogBackHandler;
import de.vw.mib.asl.api.speechengine.dialogmanager.DialogBackstackListener;
import de.vw.mib.asl.api.speechengine.dialogmanager.DialogSessionListener;
import de.vw.mib.asl.api.speechengine.features.Feature;
import de.vw.mib.asl.api.speechengine.features.FeatureFactory;
import de.vw.mib.asl.api.speechengine.features.model.Command;
import de.vw.mib.asl.api.speechengine.features.model.Prompt;
import de.vw.mib.asl.internal.speechengine.dialogmanager.DialogManagerLogger;
import de.vw.mib.asl.internal.speechengine.dialogmanager.DialogManagerParameters;
import de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler.AbortFeatureHandler;
import de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler.BackFeatureHandler;
import de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler.ClientEventsFeatureHandler;
import de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler.CommandFeatureHandler;
import de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler.DialogFeatureHandler;
import de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler.ErrorsFeatureHandler;
import de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler.HelpFeatureHandler;
import de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler.IdleStatemachineHandler;
import de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler.InitialPromptsFeatureHandler;
import de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler.MainMenuFeatureHandler;
import de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler.OverloadFeatureHandler;
import de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler.PardonFeatureHandler;
import de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler.PauseFeatureHandler;
import de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler.PleaseWaitFeatureHandler;
import de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler.RepeatFeatureHandler;
import de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler.StartupFeatureHandler;
import de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler.TeleprompterFeatureHandler;
import de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler.TimeoutFeatureHandler;
import de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler.internal.PromptList;
import de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler.internal.back.BackStack;
import de.vw.mib.asl.internal.speechengine.dialogmanager.interfaces.CommandConsumer;
import de.vw.mib.asl.internal.speechengine.dialogmanager.interfaces.DialogManagerInternal;
import de.vw.mib.asl.internal.speechengine.dialogmanager.interfaces.DialogManagerStateListener;
import de.vw.mib.asl.internal.speechengine.dialogmanager.interfaces.FeatureHandler;
import de.vw.mib.asl.internal.speechengine.dialogmanager.utils.DialogManagerStateUtil;
import de.vw.mib.asl.internal.speechengine.dialogmanager.utils.SpeechClientIdentifiersUtil;
import de.vw.mib.asl.internal.speechengine.dialogsystem.PromptSystem;
import de.vw.mib.asl.internal.speechengine.dialogsystem.SpeechDialogSystem;
import de.vw.mib.asl.internal.speechengine.messenger.BackstackStatePublisher;
import de.vw.mib.asl.internal.speechengine.messenger.HmiEventPublisher;
import de.vw.mib.asl.internal.speechengine.result.RecognizedResultPublisher;
import de.vw.mib.collections.ints.IntIterator;
import de.vw.mib.collections.ints.IntObjectMap;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.collections.ints.IntOptHashSet;
import de.vw.mib.collections.ints.IntSet;
import de.vw.mib.log4mib.LogMessage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.dsi.ifc.speechrec.NBestList;

public final class DialogManagerImpl
implements DialogManagerInternal {
    protected static DialogManagerLogger logger = new DialogManagerLogger("[DialogManager] ");
    private SpeechDialogSystem speechDialogSystem;
    private PromptSystem promptSystem;
    private HmiEventPublisher hmiEventPublisher;
    private BackstackStatePublisher backstackStatePublisher;
    private RecognizedResultPublisher recognizedResultPublisher;
    private FeatureFactory featureFactory;
    private DialogManagerParameters dialogManagerParameters;
    private IntObjectMap featureHandler;
    private List featureHandlerDone;
    private CommandFeatureHandler commandFeatureHandler;
    private DialogFeatureHandler dialogFeatureHandler;
    private PleaseWaitFeatureHandler pleaseWaitFeatureHandler;
    private ErrorsFeatureHandler errorsFeatureHandler;
    private MainMenuFeatureHandler mainMenuFeatureHandler;
    private TimeoutFeatureHandler timeoutFeatureHandler;
    private PardonFeatureHandler pardonFeatureHandler;
    private HelpFeatureHandler helpFeatureHandler;
    protected BackFeatureHandler backFeatureHandler;
    private RepeatFeatureHandler repeatFeatureHandler;
    private InitialPromptsFeatureHandler initialPromptsFeatureHandler;
    private ClientEventsFeatureHandler contextEventsFeatureHandler;
    private PauseFeatureHandler pauseFeatureHandler;
    private OverloadFeatureHandler overloadFeatureHandler;
    private IntObjectMap commandConsumer;
    private int state;
    private List stateListener;
    private IntSet disabledClients;
    private boolean startAfterInit = false;
    private DialogSessionListener startAfterInitListener = null;
    private boolean ignoreHelpReset = false;

    public DialogManagerImpl(DialogManagerParameters dialogManagerParameters) {
        this.dialogManagerParameters = dialogManagerParameters;
        DialogManagerLogger.setStaticLogger(dialogManagerParameters.getSpeechLogger());
        SpeechClientIdentifiersUtil.setSpeechConfig(dialogManagerParameters.getSpeechConfiguration());
        this.featureHandler = new IntObjectOptHashMap();
        this.commandConsumer = new IntObjectOptHashMap();
        this.featureHandlerDone = new ArrayList();
        this.stateListener = new ArrayList();
        this.disabledClients = new IntOptHashSet();
        this.setState(0);
        this.promptSystem = dialogManagerParameters.getPromptSystem();
        this.featureFactory = dialogManagerParameters.getFeatureFactory();
        this.recognizedResultPublisher = dialogManagerParameters.getRecognizedResultPublisher();
        this.hmiEventPublisher = dialogManagerParameters.getHmiEventPublisher();
        this.backstackStatePublisher = dialogManagerParameters.getBackstackStatePublisher();
        this.initialPromptsFeatureHandler = new InitialPromptsFeatureHandler(this);
        this.contextEventsFeatureHandler = new ClientEventsFeatureHandler(this, this.hmiEventPublisher);
        SpeechSettingsService speechSettingsService = dialogManagerParameters.getSpeechConfiguratorFactory().createSpeechConfiguration(7).getSpeechSettingsManager();
        this.dialogFeatureHandler = new DialogFeatureHandler(this, this.promptSystem, speechSettingsService);
        if (logger.isTraceEnabled()) {
            logger.trace("Prompt only initialized.");
        }
    }

    BackStack getBackStack() {
        return this.backFeatureHandler.getBackStack();
    }

    @Override
    public void startSession(DialogSessionListener dialogSessionListener) {
        if (logger.isTraceEnabled()) {
            logger.trace("triggered startSession(...)");
        }
        if (this.isSessionDisabled()) {
            LogMessage logMessage = logger.info();
            logMessage.append("DialogManager is disabled by following clients: [");
            IntIterator intIterator = this.disabledClients.iterator();
            while (intIterator.hasNext()) {
                int n = intIterator.next();
                logMessage.append(SpeechClientIdentifiersUtil.toString(n));
                if (!intIterator.hasNext()) continue;
                logMessage.append(", ");
            }
            logMessage.append("]").log();
            if (dialogSessionListener != null) {
                dialogSessionListener.onFinished();
            }
            return;
        }
        if (this.state == 0) {
            logger.warn("PTT - DialogManager is initializing. Start Session when ready.");
            this.startAfterInitListener = dialogSessionListener;
            this.startAfterInit = true;
            return;
        }
        this.dialogFeatureHandler.startSession(dialogSessionListener);
    }

    @Override
    public void endSession(boolean bl) {
        if (logger.isTraceEnabled()) {
            logger.trace(new StringBuffer().append("triggered endSession(").append(bl).append(")").toString());
        }
        if (this.state == 0) {
            logger.warn("PTT Multipress - DialogManager is initializing.");
            this.startAfterInit = false;
            return;
        }
        this.dialogFeatureHandler.endSession(bl);
    }

    @Override
    public void pauseSession() {
        if (logger.isTraceEnabled()) {
            logger.trace("triggered pauseSession()");
        }
        this.dialogFeatureHandler.pauseSession();
    }

    @Override
    public void back() {
        if (logger.isTraceEnabled()) {
            logger.trace("triggered back()");
        }
        this.dialogFeatureHandler.clearTaskList();
        if (this.backFeatureHandler.getBackstackState() == 0) {
            this.dialogFeatureHandler.endSession(true);
        } else {
            this.backFeatureHandler.executeBack(false);
        }
    }

    @Override
    public void togglePause() {
        if (logger.isTraceEnabled()) {
            logger.trace("triggered togglePause()");
        }
        this.dialogFeatureHandler.togglePause();
    }

    @Override
    public void disableSession(int n) {
        this.disabledClients.add(n);
        if (this.isSessionDisabled()) {
            this.dialogFeatureHandler.endSession(true);
        }
    }

    @Override
    public void enableSession(int n) {
        this.disabledClients.remove(n);
    }

    private boolean isSessionDisabled() {
        return !this.disabledClients.isEmpty();
    }

    @Override
    public void initializeSpeech(SpeechDialogSystem speechDialogSystem) {
        this.speechDialogSystem = speechDialogSystem;
        this.dialogFeatureHandler.setSpeechDialogSystem(speechDialogSystem);
        this.overloadFeatureHandler = new OverloadFeatureHandler(this, this.hmiEventPublisher);
        this.repeatFeatureHandler = new RepeatFeatureHandler(this, this.overloadFeatureHandler);
        this.commandFeatureHandler = new CommandFeatureHandler(this, this.speechDialogSystem);
        this.pleaseWaitFeatureHandler = new PleaseWaitFeatureHandler(this, this.speechDialogSystem, this.dialogManagerParameters);
        this.errorsFeatureHandler = new ErrorsFeatureHandler(this, this.speechDialogSystem);
        this.mainMenuFeatureHandler = new MainMenuFeatureHandler(this, this.speechDialogSystem, this.hmiEventPublisher);
        this.timeoutFeatureHandler = new TimeoutFeatureHandler(this, this.speechDialogSystem);
        this.pardonFeatureHandler = new PardonFeatureHandler(this, this.speechDialogSystem);
        this.backFeatureHandler = new BackFeatureHandler(this, this.hmiEventPublisher, this.overloadFeatureHandler, this.backstackStatePublisher);
        this.helpFeatureHandler = new HelpFeatureHandler(this, this.overloadFeatureHandler, this.featureFactory, this.backFeatureHandler);
        this.pauseFeatureHandler = new PauseFeatureHandler((DialogManagerInternal)this, this.overloadFeatureHandler, this.dialogManagerParameters);
        new IdleStatemachineHandler(this);
        new TeleprompterFeatureHandler(this, this.dialogManagerParameters);
        new AbortFeatureHandler(this, this.overloadFeatureHandler);
        new StartupFeatureHandler(this, this.dialogManagerParameters);
        if (logger.isTraceEnabled()) {
            logger.trace("SDS initialized.");
        }
    }

    @Override
    public void loadCommands(Command[] commandArray) {
        this.commandFeatureHandler.loadCommands(commandArray);
    }

    @Override
    public void unloadCommands(Command[] commandArray) {
        this.commandFeatureHandler.unloadCommands(commandArray);
    }

    @Override
    public void playPrompt(int n, boolean bl, boolean bl2) {
        Prompt prompt = this.featureFactory.createPrompt(n, null);
        this.playPrompts(new Prompt[]{prompt}, bl, bl2, 7);
    }

    @Override
    public void playBackgroundPrompt(int n) {
        Prompt prompt = this.featureFactory.createPrompt(n, null);
        this.dialogFeatureHandler.playBackgroundPrompts(new Prompt[]{prompt}, 7);
    }

    @Override
    public void playPrompts(Prompt[] promptArray, boolean bl, boolean bl2, int n) {
        if (this.repeatFeatureHandler != null) {
            if (bl) {
                this.repeatFeatureHandler.clearPrompts();
            }
            if (bl2) {
                this.repeatFeatureHandler.addPrompts(promptArray);
            }
        }
        this.dialogFeatureHandler.playPrompts(promptArray, n);
    }

    @Override
    public PromptList getInitialPrompts() {
        return this.initialPromptsFeatureHandler.getInitialPrompts();
    }

    @Override
    public PromptList getRepeatPrompts() {
        return this.repeatFeatureHandler.getRepeatPrompts();
    }

    @Override
    public Prompt getHelpPrompt() {
        return this.helpFeatureHandler.getHelpPrompt();
    }

    @Override
    public void startRecognition() {
        this.dialogFeatureHandler.startRecognition();
    }

    @Override
    public void pauseSDS() {
        this.dialogFeatureHandler.pauseSDS();
    }

    @Override
    public void endSDS() {
        this.dialogFeatureHandler.endSDS(1);
    }

    @Override
    public void openMainMenu(boolean bl, boolean bl2) {
        this.helpFeatureHandler.reset();
        this.mainMenuFeatureHandler.openMainMenu(bl, bl2);
    }

    @Override
    public void onRecognitionFinished(int n, NBestList nBestList) {
        switch (n) {
            case 200: {
                if (logger.isTraceEnabled()) {
                    logger.trace("SDS aborted.");
                }
                this.pleaseWaitFeatureHandler.resetPleaseWaitTimer();
                return;
            }
            case 0: 
            case 118: {
                this.handleSuccessfullRecognition(nBestList);
                break;
            }
            case 101: {
                this.pleaseWaitFeatureHandler.resetPleaseWaitTimer();
                this.timeoutFeatureHandler.onTimeout();
                break;
            }
            case 106: 
            case 107: {
                this.pleaseWaitFeatureHandler.resetPleaseWaitTimer();
                this.pardonFeatureHandler.onConfidenceTooLow();
                break;
            }
            default: {
                this.pleaseWaitFeatureHandler.resetPleaseWaitTimer();
                this.errorsFeatureHandler.onRecognitionFinished(n);
            }
        }
    }

    private void handleSuccessfullRecognition(NBestList nBestList) {
        Command command = this.commandFeatureHandler.getCommand(nBestList);
        if (command == null) {
            if (logger.isTraceEnabled()) {
                logger.trace("Recognized command was not found in CommandHandler.");
            }
            this.pleaseWaitFeatureHandler.resetPleaseWaitTimer();
            this.errorsFeatureHandler.onRecognitionFinished(300);
            return;
        }
        this.resetCounters();
        List list = this.getCommandconsumerListForCommandId(command.getSdsId(), false);
        if (list != null) {
            this.pleaseWaitFeatureHandler.resetPleaseWaitTimer();
            for (int i2 = 0; i2 < list.size(); ++i2) {
                CommandConsumer commandConsumer = (CommandConsumer)list.get(i2);
                commandConsumer.recognizedCommand(command);
            }
            return;
        }
        this.resetHelpMode();
        int n = command.getClientId();
        int n2 = command.getEventId();
        if (logger.isTraceEnabled()) {
            logger.trace(new StringBuffer().append("publish recognized result to client : ").append(SpeechClientIdentifiersUtil.toString(n)).append(", eventId : ").append(n2).toString());
        }
        this.recognizedResultPublisher.publish(n, n2, nBestList);
    }

    @Override
    public void resetCounters() {
        this.timeoutFeatureHandler.reset();
        this.pardonFeatureHandler.reset();
    }

    @Override
    public void resetHelpMode() {
        if (this.state == 3) {
            this.setState(2);
        }
    }

    @Override
    public void startPleaseWaitTimer() {
        this.pleaseWaitFeatureHandler.startPleaseWaitTimer();
    }

    @Override
    public void resetPleaseWaitTimer() {
        this.pleaseWaitFeatureHandler.resetPleaseWaitTimer();
    }

    @Override
    public void startPauseTimer() {
        this.pauseFeatureHandler.startPauseTimer();
    }

    @Override
    public void resetPauseTimer() {
        this.pauseFeatureHandler.resetPauseTimer();
    }

    @Override
    public void onInitializationReady() {
        this.setState(1);
        if (this.startAfterInit) {
            if (logger.isTraceEnabled()) {
                logger.trace("DialogManager is initialized. PTT was pressed, start session.");
            }
            this.dialogFeatureHandler.startSession(this.startAfterInitListener);
        }
    }

    private void loadCommand(int n, int n2) {
        Command command = this.featureFactory.createCommand(-1, n, -1, n2, true, false);
        this.commandFeatureHandler.loadCommands(new Command[]{command});
    }

    private void unloadCommand(int n, int n2) {
        Command command = this.featureFactory.createCommand(-1, n, -1, n2, true, false);
        this.commandFeatureHandler.unloadCommands(new Command[]{command});
    }

    @Override
    public void setState(int n) {
        if (this.state == n) {
            return;
        }
        if (logger.isTraceEnabled()) {
            StringBuffer stringBuffer = new StringBuffer("changed state : ");
            stringBuffer.append(DialogManagerStateUtil.toString(n));
            logger.trace(stringBuffer.toString());
        }
        int n2 = this.state;
        this.state = n;
        for (int i2 = 0; i2 < this.stateListener.size(); ++i2) {
            DialogManagerStateListener dialogManagerStateListener = (DialogManagerStateListener)this.stateListener.get(i2);
            dialogManagerStateListener.onDialogManagerStateChanged(n2, n);
        }
    }

    @Override
    public void registerDialogManagerStateListener(DialogManagerStateListener dialogManagerStateListener) {
        this.stateListener.add(dialogManagerStateListener);
        dialogManagerStateListener.setCurrentDialogManagerState(this.state);
    }

    @Override
    public void unregisterDialogManagerStateListener(DialogManagerStateListener dialogManagerStateListener) {
        this.stateListener.remove(dialogManagerStateListener);
    }

    @Override
    public void registerFeatureHandler(int n, FeatureHandler featureHandler) {
        List list = this.getFeatureHandlerListForFeatureId(n, false);
        list.add(featureHandler);
    }

    @Override
    public void unregisterFeatureHandler(int n, FeatureHandler featureHandler) {
        List list = this.getFeatureHandlerListForFeatureId(n, true);
        list.remove(featureHandler);
    }

    @Override
    public void registerCommandConsumer(int n, CommandConsumer commandConsumer) {
        if (commandConsumer.isUniversal()) {
            this.loadCommand(n, 0);
        } else {
            this.loadCommand(n, 1);
            this.loadCommand(n, 2);
        }
        List list = this.getCommandconsumerListForCommandId(n, true);
        list.add(commandConsumer);
    }

    @Override
    public void unregisterCommandConsumer(int n, CommandConsumer commandConsumer) {
        if (commandConsumer.isUniversal()) {
            this.unloadCommand(n, 0);
        } else {
            this.unloadCommand(n, 1);
            this.unloadCommand(n, 2);
        }
        List list = this.getCommandconsumerListForCommandId(n, false);
        if (list == null) {
            return;
        }
        list.remove(commandConsumer);
        if (list.size() == 0) {
            this.commandConsumer.remove(n);
        }
    }

    @Override
    public void registerFeatureHandlerDone(FeatureHandler featureHandler) {
        this.featureHandlerDone.add(featureHandler);
    }

    @Override
    public void unregisterFeatureHandlerDone(FeatureHandler featureHandler) {
        this.featureHandlerDone.remove(featureHandler);
    }

    @Override
    public void registerDialogBackstackListener(DialogBackstackListener dialogBackstackListener) {
        this.backFeatureHandler.registerDialogBackstackListener(dialogBackstackListener);
    }

    @Override
    public void unregisterDialogBackstackListener(DialogBackstackListener dialogBackstackListener) {
        this.backFeatureHandler.unregisterDialogBackstackListener(dialogBackstackListener);
    }

    private List getFeatureHandlerListForFeatureId(int n, boolean bl) {
        Object object = this.featureHandler.get(n);
        if (object == null) {
            object = new ArrayList();
            if (bl) {
                logger.error(new StringBuffer().append("No FeatureHandler registered for featureId : ").append(n).toString());
            } else {
                this.featureHandler.put(n, object);
            }
        }
        return (List)object;
    }

    private List getCommandconsumerListForCommandId(int n, boolean bl) {
        Object object = this.commandConsumer.get(n);
        if (object == null) {
            if (bl) {
                object = new ArrayList();
                this.commandConsumer.put(n, object);
            } else {
                return null;
            }
        }
        return (List)object;
    }

    @Override
    public void fireIdleEvent(int n) {
        this.contextEventsFeatureHandler.fireIdleEvent(n);
    }

    @Override
    public void firePromptStartedEvent(int n) {
        this.contextEventsFeatureHandler.firePromptStartedEvent(n);
    }

    @Override
    public void firePromptSpokenEvent(int n) {
        this.contextEventsFeatureHandler.firePromptSpokenEvent(n);
    }

    @Override
    public void clearBackstack(int n) {
        this.backFeatureHandler.clearBackstack(n);
    }

    @Override
    public void pushDialogBackHandler(DialogBackHandler dialogBackHandler) {
        this.backFeatureHandler.pushDialogBackHandler(dialogBackHandler);
    }

    @Override
    public void notifyDialogStep() {
        if (!this.ignoreHelpReset) {
            this.resetHelpMode();
        } else {
            this.ignoreHelpReset = false;
        }
        this.pleaseWaitFeatureHandler.resetPleaseWaitTimer();
        this.backFeatureHandler.notifyDialogStep();
        this.helpFeatureHandler.notifyDialogStep();
    }

    @Override
    public void keepPromptsRunning() {
        this.dialogFeatureHandler.keepPromptsRunning();
    }

    @Override
    public void clearTaskList() {
        this.dialogFeatureHandler.clearTaskList();
    }

    @Override
    public void ignoreInitialPrompts() {
        this.ignoreHelpReset = true;
        this.initialPromptsFeatureHandler.ignoreNext();
        this.dialogFeatureHandler.ignoreNextPrompt();
    }

    @Override
    public void cancelCurrentRunningPrompt(int n) {
        this.dialogFeatureHandler.cancelCurrentRunningPrompt(n);
    }

    @Override
    public void setFeatures(int n, Feature[] featureArray) {
        int n2;
        Object object;
        if (logger.isTraceEnabled()) {
            this.traceFeatures(n, featureArray, "setFeatures()");
        }
        for (int i2 = 0; i2 < featureArray.length; ++i2) {
            Feature feature = featureArray[i2];
            object = this.getFeatureHandlerListForFeatureId(feature.getFeatureType(), true);
            Iterator iterator = object.iterator();
            while (iterator.hasNext()) {
                FeatureHandler featureHandler = (FeatureHandler)iterator.next();
                featureHandler.handleFeature(n, feature);
            }
        }
        List list = null;
        for (n2 = 0; n2 < this.featureHandlerDone.size(); ++n2) {
            object = (FeatureHandler)this.featureHandlerDone.get(n2);
            if (!object.handleDone()) continue;
            if (list == null) {
                list = new ArrayList();
            }
            list.add(object);
        }
        if (list != null) {
            for (n2 = 0; n2 < list.size(); ++n2) {
                this.unregisterFeatureHandlerDone((FeatureHandler)list.get(n2));
            }
        }
    }

    @Override
    public void updateFeatures(int n, Feature[] featureArray) {
        int n2;
        Object object;
        if (logger.isTraceEnabled()) {
            this.traceFeatures(n, featureArray, "updateFeatures()");
        }
        for (int i2 = 0; i2 < featureArray.length; ++i2) {
            Feature feature = featureArray[i2];
            object = this.getFeatureHandlerListForFeatureId(feature.getFeatureType(), true);
            Iterator iterator = object.iterator();
            while (iterator.hasNext()) {
                FeatureHandler featureHandler = (FeatureHandler)iterator.next();
                featureHandler.updateFeature(n, feature);
            }
        }
        List list = null;
        for (n2 = 0; n2 < this.featureHandlerDone.size(); ++n2) {
            object = (FeatureHandler)this.featureHandlerDone.get(n2);
            if (!object.updateDone()) continue;
            if (list == null) {
                list = new ArrayList();
            }
            list.add(object);
        }
        if (list != null) {
            for (n2 = 0; n2 < list.size(); ++n2) {
                this.unregisterFeatureHandlerDone((FeatureHandler)list.get(n2));
            }
        }
    }

    private void traceFeatures(int n, Feature[] featureArray, String string) {
        StringBuffer stringBuffer = new StringBuffer(string);
        stringBuffer.append(" triggered with ");
        stringBuffer.append(featureArray.length);
        stringBuffer.append(" features from client: ");
        stringBuffer.append(SpeechClientIdentifiersUtil.toString(n));
        stringBuffer.append(":\n");
        for (int i2 = 0; i2 < featureArray.length; ++i2) {
            stringBuffer.append(featureArray[i2].toString());
            if (i2 >= featureArray.length - 1) continue;
            stringBuffer.append("\n");
        }
        logger.trace(stringBuffer.toString());
    }
}

