/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.dialogsystem.controller.grammar;

import de.vw.mib.asl.internal.speechengine.diagnosis.DialogSystemDiagnosisListener;
import de.vw.mib.asl.internal.speechengine.diagnosis.GrammarDiagnosis;
import de.vw.mib.asl.internal.speechengine.dialogsystem.CommandLoader;
import de.vw.mib.asl.internal.speechengine.dialogsystem.CommandLoaderObserver;
import de.vw.mib.asl.internal.speechengine.dialogsystem.DialogSystemInitializer;
import de.vw.mib.asl.internal.speechengine.dialogsystem.activity.ActivityManager;
import de.vw.mib.asl.internal.speechengine.dialogsystem.activity.ActivityObserver;
import de.vw.mib.asl.internal.speechengine.dialogsystem.activity.ActivityType;
import de.vw.mib.asl.internal.speechengine.dialogsystem.activity.observer.InitialLscObserver;
import de.vw.mib.asl.internal.speechengine.dialogsystem.activity.observer.InitialLscObserverCallback;
import de.vw.mib.asl.internal.speechengine.dialogsystem.adapter.handler.GrammarHandler;
import de.vw.mib.asl.internal.speechengine.dialogsystem.appstate.ApplicationStateTracker;
import de.vw.mib.asl.internal.speechengine.dialogsystem.controller.DeviceController;
import de.vw.mib.asl.internal.speechengine.dialogsystem.controller.asr.AsrController;
import de.vw.mib.asl.internal.speechengine.dialogsystem.controller.grammar.CommandLoaderEmpty;
import de.vw.mib.asl.internal.speechengine.dialogsystem.controller.grammar.CommandLoaderImpl;
import de.vw.mib.asl.internal.speechengine.dialogsystem.controller.grammar.CommandLoaderObserverProxy;
import de.vw.mib.asl.internal.speechengine.dialogsystem.controller.grammar.CommandLoaderProxy;
import de.vw.mib.asl.internal.speechengine.dialogsystem.controller.grammar.GrammarController$1;
import de.vw.mib.asl.internal.speechengine.dialogsystem.start.DialogSystemParameter;
import de.vw.mib.asl.internal.speechengine.messenger.DialogSystemPublisher;
import de.vw.mib.collections.ints.IntIntMap;
import de.vw.mib.collections.ints.IntIntOptHashMap;
import de.vw.mib.collections.ints.IntIterator;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.log4mib.Logger;
import org.dsi.ifc.speechrec.Grammar;
import org.dsi.ifc.speechrec.GrammarInfo;
import org.dsi.ifc.speechrec.GrammarStateInfo;

public class GrammarController
extends DeviceController
implements GrammarDiagnosis,
GrammarHandler,
ActivityObserver,
InitialLscObserverCallback {
    private static final String TRACE_PREFIX;
    private static final int TRACE_CLASSIFIER;
    private Logger logger;
    private CommandLoaderProxy commandLoaderProxy;
    private CommandLoaderImpl commandLoaderImpl;
    private CommandLoaderEmpty commandLoaderEmpty;
    private final CommandLoaderObserverProxy commandLoaderObserver;
    private final AsrController asrController;
    private InitialLscObserver initialLscObserver;
    private IntIntMap slotStateMap;
    private boolean isAsrDeviceReady;
    private boolean isLanguageSet;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$GrammarHandler;

    public GrammarController(Logger logger, DialogSystemParameter dialogSystemParameter, DialogSystemInitializer dialogSystemInitializer, DialogSystemDiagnosisListener dialogSystemDiagnosisListener, AsrController asrController, ActivityManager activityManager, boolean bl, ApplicationStateTracker applicationStateTracker) {
        super(dialogSystemParameter, dialogSystemInitializer, dialogSystemDiagnosisListener, activityManager, applicationStateTracker);
        this.logger = logger;
        this.slotStateMap = new IntIntOptHashMap();
        this.asrController = asrController;
        this.isAsrDeviceReady = false;
        this.isLanguageSet = false;
        this.commandLoaderImpl = new CommandLoaderImpl(activityManager, this.asrController, this.logger);
        this.commandLoaderEmpty = new CommandLoaderEmpty(this.commandLoaderImpl, this.logger);
        this.commandLoaderProxy = new CommandLoaderProxy(this.commandLoaderImpl, this);
        this.commandLoaderObserver = new CommandLoaderObserverProxy();
        asrController.getHandlerRegistry().addHandler(class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$GrammarHandler == null ? (class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$GrammarHandler = GrammarController.class$("de.vw.mib.asl.internal.speechengine.dialogsystem.adapter.handler.GrammarHandler")) : class$de$vw$mib$asl$internal$speechengine$dialogsystem$adapter$handler$GrammarHandler, this);
        this.initialLscObserver = new InitialLscObserver(this.getActivityManager(), this);
        this.initialLscObserver.startObserving();
    }

    public void onAsrDeviceReady() {
        this.isAsrDeviceReady = true;
        this.start();
    }

    @Override
    public void onLanguageSet() {
        this.isLanguageSet = true;
        this.start();
    }

    public CommandLoader getCommandLoaderProxy() {
        return this.commandLoaderProxy;
    }

    public CommandLoader getCommandLoaderInternal() {
        return this.commandLoaderImpl;
    }

    public Grammar[] getCurrentGrammarSet() {
        return this.commandLoaderObserver.onCommandsLost();
    }

    public void pause() {
        if (this.logger.isTraceEnabled(128)) {
            LogMessage logMessage = this.logger.trace(128);
            logMessage.append("[GrammarController] ");
            logMessage.append("pausing command-loading");
            logMessage.log();
        }
        this.commandLoaderProxy.switchCommandLoader(this.commandLoaderEmpty);
    }

    public void resume() {
        if (this.logger.isTraceEnabled(128)) {
            LogMessage logMessage = this.logger.trace(128);
            logMessage.append("[GrammarController] ");
            logMessage.append("resume command-loading");
            logMessage.log();
        }
        this.commandLoaderProxy.switchCommandLoader(this.commandLoaderImpl);
    }

    void registerObserver(CommandLoaderObserver commandLoaderObserver) {
        this.commandLoaderObserver.addObserver(commandLoaderObserver);
        this.diagnosisListener.loadGrammar(this.commandLoaderObserver.onCommandsLost());
    }

    public void reloadSlots() {
        if (this.logger.isTraceEnabled(128)) {
            LogMessage logMessage = this.logger.trace(128);
            logMessage.append("[GrammarController] ");
            logMessage.append("re-loading slots");
            logMessage.log();
        }
        this.commandLoaderObserver.onSlotsLost();
    }

    @Override
    public void start() {
        LogMessage logMessage;
        if (this.logger.isTraceEnabled(128)) {
            logMessage = this.logger.trace(128);
            logMessage.append("[GrammarController] ").append("start( ) ... ");
            logMessage.append("isAsrDeviceReady=").append(this.isAsrDeviceReady).append(", isLanguageSet=").append(this.isLanguageSet);
            logMessage.log();
        }
        if (this.isAsrDeviceReady && this.isLanguageSet) {
            logMessage = this.logger.info(128);
            logMessage.append("[GrammarController] ").append("Startup has finished. ");
            logMessage.log();
            this.dialogSystemInitializer.setGrammarController(this);
            this.activityManager.addObserver(this, ActivityType.LANGUAGE_CHANGE);
        } else {
            logMessage = this.logger.info(128);
            logMessage.append("[GrammarController] ").append("not yet finished. ");
            logMessage.log();
        }
    }

    @Override
    public void onDeviceShutdown() {
        this.commandLoaderImpl.deviceShutdown();
        Grammar[] grammarArray = this.getCurrentGrammarSet();
        GrammarInfo[] grammarInfoArray = new GrammarInfo[grammarArray.length];
        for (int i2 = 0; i2 < grammarArray.length; ++i2) {
            int n = grammarArray[i2].getGrammarId();
            int n2 = grammarArray[i2].getCommandHierarchy();
            grammarInfoArray[i2] = new GrammarInfo(n, n2);
        }
        this.diagnosisListener.unloadGrammar(grammarInfoArray);
    }

    @Override
    public void onDeviceRestart() {
        new InitialLscObserver(this.activityManager, new GrammarController$1(this)).startObserving();
    }

    @Override
    public void onDiagnosisListenerRegistered(DialogSystemDiagnosisListener dialogSystemDiagnosisListener) {
        dialogSystemDiagnosisListener.loadGrammar(this.commandLoaderObserver.onCommandsLost());
        IntIterator intIterator = this.slotStateMap.keyIterator();
        while (intIterator.hasNext()) {
            int n = intIterator.next();
            int n2 = this.slotStateMap.get(n);
            dialogSystemDiagnosisListener.changedSlotState(n, n2);
        }
    }

    @Override
    public void responseLoadGrammar(int n, GrammarInfo[] grammarInfoArray) {
    }

    @Override
    public void responseUnloadGrammar(int n, GrammarInfo[] grammarInfoArray) {
    }

    @Override
    public void updateGrammarState(GrammarStateInfo grammarStateInfo) {
        if (grammarStateInfo != null) {
            int[] nArray = grammarStateInfo.getSlotIds();
            DialogSystemPublisher dialogSystemPublisher = this.getDialogSystemPublisher();
            for (int i2 = 0; i2 < nArray.length; ++i2) {
                this.diagnosisListener.changedSlotState(nArray[i2], grammarStateInfo.getGrammarStatus());
                dialogSystemPublisher.onSlotStateChanged(nArray[i2], grammarStateInfo.getGrammarStatus());
                this.slotStateMap.put(nArray[i2], grammarStateInfo.getGrammarStatus());
            }
        }
    }

    @Override
    public void onActivityIdle(ActivityType activityType) {
        if (ActivityType.LANGUAGE_CHANGE.equals(activityType)) {
            this.reloadSlots();
        }
    }

    @Override
    public void onActivityActive(ActivityType activityType) {
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

