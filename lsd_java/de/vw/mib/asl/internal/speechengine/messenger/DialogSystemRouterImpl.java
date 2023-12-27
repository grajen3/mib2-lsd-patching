/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.messenger;

import de.vw.mib.asl.api.speechengine.messenger.application.ApplicationStateConsumer;
import de.vw.mib.asl.api.speechengine.messenger.application.ApplicationStateRouter;
import de.vw.mib.asl.api.speechengine.messenger.dialog.DialogStateBitField;
import de.vw.mib.asl.api.speechengine.messenger.dialog.DialogStateConsumer;
import de.vw.mib.asl.api.speechengine.messenger.dialog.DialogStateRouter;
import de.vw.mib.asl.api.speechengine.messenger.indicator.IndicatorStateConsumer;
import de.vw.mib.asl.api.speechengine.messenger.indicator.IndicatorStateRouter;
import de.vw.mib.asl.api.speechengine.messenger.slot.SlotStateConsumer;
import de.vw.mib.asl.api.speechengine.messenger.slot.SlotStateRouter;
import de.vw.mib.asl.internal.speechengine.messenger.DialogStateBitFieldTracker;
import de.vw.mib.asl.internal.speechengine.messenger.DialogSystemPublisher;
import de.vw.mib.asl.internal.speechengine.messenger.start.SpeechMessengerParameters;
import de.vw.mib.asl.internal.util.AbstractClassifiedLogger;
import de.vw.mib.collections.ObjectObjectMap;
import de.vw.mib.collections.ObjectObjectOptHashMap;
import de.vw.mib.collections.ints.IntIntMap;
import de.vw.mib.collections.ints.IntIntOptHashMap;
import de.vw.mib.collections.ints.IntObjectMultimap;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.threads.AsyncServiceFactory;
import java.util.Collection;
import java.util.Iterator;

public class DialogSystemRouterImpl
implements DialogSystemPublisher,
DialogStateRouter,
IndicatorStateRouter,
ApplicationStateRouter,
SlotStateRouter {
    private final Logger logger;
    private final AbstractClassifiedLogger aLogger;
    private final AsyncServiceFactory asyncServiceFactory;
    private final int loggerClassifier;
    private final String loggerPrefix;
    private final DialogStateBitFieldTracker dialogStateBitFieldTracker;
    private final ObjectObjectMap indicatorStateConsumerAsync;
    private final ObjectObjectMap dialogStateConsumerAsync;
    private final ObjectObjectMap applicationStateConsumerAsync;
    private final IntObjectMultimap slotStateConsumer;
    private IntIntMap slotStateValue;
    private int currentApplicationState;
    private int currentIndicatorState;

    public DialogSystemRouterImpl(SpeechMessengerParameters speechMessengerParameters) {
        this.logger = speechMessengerParameters.getLogger();
        this.aLogger = speechMessengerParameters.getAbstractClassifiedLogger();
        this.asyncServiceFactory = speechMessengerParameters.getASLAsyncServiceFactory();
        this.loggerClassifier = speechMessengerParameters.getLoggerClassifier();
        this.loggerPrefix = speechMessengerParameters.getLoggerPrefix();
        this.indicatorStateConsumerAsync = new ObjectObjectOptHashMap();
        this.dialogStateConsumerAsync = new ObjectObjectOptHashMap();
        this.applicationStateConsumerAsync = new ObjectObjectOptHashMap();
        this.slotStateConsumer = new IntObjectMultimap();
        this.slotStateValue = new IntIntOptHashMap();
        this.dialogStateBitFieldTracker = new DialogStateBitFieldTracker(speechMessengerParameters.getAbstractClassifiedLogger());
        this.currentIndicatorState = 1;
    }

    private String getNameOfIndicatorState(int n) {
        String string;
        switch (n) {
            case 1: {
                string = "OFF";
                break;
            }
            case 2: {
                string = "RECOGNIZING";
                break;
            }
            case 3: {
                string = "SPEAKING";
                break;
            }
            case 4: {
                string = "PAUSED";
                break;
            }
            case 5: {
                string = "BUSY";
                break;
            }
            default: {
                this.logger.warn(this.loggerClassifier, new StringBuffer().append(this.loggerPrefix).append("Unknown Indicator State: ").append(n).toString());
                string = "UNKNOWN";
            }
        }
        return string;
    }

    private String getNameOfDialogStep(int n) {
        switch (n) {
            case 0: {
                return "DIALOG_STEP_AUDIO_REQUESTING";
            }
            case 1: {
                return "DIALOG_STEP_DIALOG_BEGIN";
            }
            case 2: {
                return "DIALOG_STEP_RECOGNITION";
            }
            case 3: {
                return "DIALOG_STEP_PROMPTING";
            }
            case 4: {
                return "DIALOG_STEP_PAUSE";
            }
            case 5: {
                return "DIALOG_STEP_DIALOG_END";
            }
            case 6: {
                return "DIALOG_STEP_AUDIO_RELEASING";
            }
        }
        this.logger.warn(this.loggerClassifier, new StringBuffer().append(this.loggerPrefix).append("Unknown Dialog Step: ").append(n).toString());
        return "UNKNOWN";
    }

    private void publishIndicatorState(int n) {
        Object object;
        boolean bl;
        boolean bl2 = bl = this.currentIndicatorState == n;
        if (this.aLogger.isTraceEnabled()) {
            object = this.aLogger.trace().append("publishIndicatorState( ").append(this.getNameOfIndicatorState(n)).append(" )");
            if (bl) {
                object.append(": state has not changed");
            }
            object.log();
        }
        if (bl) {
            return;
        }
        this.currentIndicatorState = n;
        object = this.indicatorStateConsumerAsync.valueIterator();
        while (object.hasNext()) {
            IndicatorStateConsumer indicatorStateConsumer = (IndicatorStateConsumer)object.next();
            indicatorStateConsumer.onIndicatorStateChange(n);
        }
    }

    private void publishDialogState() {
        Collection collection = this.dialogStateConsumerAsync.values();
        this.dialogStateBitFieldTracker.submitUpdates(collection);
    }

    @Override
    public void onDialogStepStarted(int n) {
        if (this.aLogger.isTraceEnabled()) {
            this.aLogger.trace().append("onDialogStepStarted( ").append(this.getNameOfDialogStep(n)).append(" )").log();
        }
        int n2 = this.getIndicatorState();
        switch (n) {
            case 0: {
                n2 = 1;
                break;
            }
            case 1: {
                n2 = 5;
                this.dialogStateBitFieldTracker.setSpeechActive(2);
                break;
            }
            case 2: {
                this.dialogStateBitFieldTracker.setRecognitionActive(0);
                break;
            }
            case 3: {
                this.dialogStateBitFieldTracker.setPromptActive(4);
                break;
            }
            case 4: {
                n2 = 4;
                this.dialogStateBitFieldTracker.setPauseActive(6);
                break;
            }
            case 5: {
                n2 = 5;
                this.dialogStateBitFieldTracker.setShutdownActive(8);
                break;
            }
            case 6: {
                n2 = 1;
                break;
            }
            default: {
                this.logger.warn(this.loggerClassifier, new StringBuffer().append(this.loggerPrefix).append("Default handling of DialogSystemPublisher#onDialogStepStarted(").append(n).append(")").toString());
            }
        }
        this.publishDialogState();
        this.publishIndicatorState(n2);
    }

    @Override
    public void onDialogStepActive(int n) {
        if (this.aLogger.isTraceEnabled()) {
            this.aLogger.trace().append("onDialogStepActive( ").append(this.getNameOfDialogStep(n)).append(" )").log();
        }
        int n2 = this.getIndicatorState();
        switch (n) {
            case 0: {
                n2 = 1;
                break;
            }
            case 1: {
                n2 = 5;
                break;
            }
            case 2: {
                n2 = 2;
                break;
            }
            case 3: {
                n2 = 3;
                break;
            }
            case 4: {
                n2 = 4;
                break;
            }
            case 5: {
                n2 = 3;
                break;
            }
            case 6: {
                n2 = 1;
                break;
            }
            default: {
                n2 = 5;
            }
        }
        this.publishIndicatorState(n2);
    }

    @Override
    public void onDialogStepPostProcessing(int n) {
        if (this.aLogger.isTraceEnabled()) {
            this.aLogger.trace().append("onDialogStepPostProcessing( ").append(this.getNameOfDialogStep(n)).append(" )").log();
        }
        switch (n) {
            case 0: {
                this.publishIndicatorState(1);
                break;
            }
            case 1: 
            case 2: 
            case 3: 
            case 4: 
            case 5: {
                this.publishIndicatorState(5);
                break;
            }
            case 6: {
                this.publishIndicatorState(1);
                break;
            }
            default: {
                this.publishIndicatorState(1);
            }
        }
    }

    @Override
    public void onDialogStepFinished(int n) {
        if (this.aLogger.isTraceEnabled()) {
            this.aLogger.trace().append("onDialogStepFinished( ").append(this.getNameOfDialogStep(n)).append(" )").log();
        }
        int n2 = this.getIndicatorState();
        switch (n) {
            case 0: {
                break;
            }
            case 1: {
                break;
            }
            case 2: {
                this.dialogStateBitFieldTracker.setRecognitionActive(1);
                n2 = 5;
                break;
            }
            case 3: {
                this.dialogStateBitFieldTracker.setPromptActive(5);
                n2 = 5;
                break;
            }
            case 4: {
                this.dialogStateBitFieldTracker.setPauseActive(7);
                break;
            }
            case 5: {
                this.dialogStateBitFieldTracker.setShutdownActive(9);
                n2 = 1;
                break;
            }
            case 6: {
                this.dialogStateBitFieldTracker.setSpeechActive(3);
                n2 = 1;
                break;
            }
            default: {
                this.logger.error(this.loggerClassifier, new StringBuffer().append(this.loggerPrefix).append("Default handling of DialogSystemPublisher#onDialogStepFinished(").append(n).append(")").toString());
            }
        }
        this.publishDialogState();
        this.publishIndicatorState(n2);
    }

    @Override
    public void register(IndicatorStateConsumer indicatorStateConsumer) {
        if (!this.indicatorStateConsumerAsync.containsKey(indicatorStateConsumer)) {
            if (this.logger.isTraceEnabled(this.loggerClassifier)) {
                this.logger.trace(this.loggerClassifier, new StringBuffer().append(this.loggerPrefix).append("register(IndicatorStateConsumer) : ").append(super.getClass().getName()).toString());
            }
            Object object = this.asyncServiceFactory.create(indicatorStateConsumer);
            this.indicatorStateConsumerAsync.put(indicatorStateConsumer, object);
        }
    }

    @Override
    public void unregister(IndicatorStateConsumer indicatorStateConsumer) {
        if (this.indicatorStateConsumerAsync.containsKey(indicatorStateConsumer)) {
            if (this.logger.isTraceEnabled(this.loggerClassifier)) {
                this.logger.trace(this.loggerClassifier, new StringBuffer().append(this.loggerPrefix).append("unregister(IndicatorStateConsumer) : ").append(super.getClass().getName()).toString());
            }
            this.indicatorStateConsumerAsync.remove(indicatorStateConsumer);
        }
    }

    @Override
    public void register(DialogStateConsumer dialogStateConsumer) {
        if (!this.dialogStateConsumerAsync.containsKey(dialogStateConsumer)) {
            if (this.logger.isTraceEnabled(this.loggerClassifier)) {
                this.logger.trace(this.loggerClassifier, new StringBuffer().append(this.loggerPrefix).append("register(DialogStateConsumer) : ").append(super.getClass().getName()).toString());
            }
            Object object = this.asyncServiceFactory.create(dialogStateConsumer);
            this.dialogStateConsumerAsync.put(dialogStateConsumer, object);
        }
    }

    @Override
    public void unregister(DialogStateConsumer dialogStateConsumer) {
        if (this.dialogStateConsumerAsync.containsKey(dialogStateConsumer)) {
            if (this.logger.isTraceEnabled(this.loggerClassifier)) {
                this.logger.trace(this.loggerClassifier, new StringBuffer().append(this.loggerPrefix).append("unregister(DialogStateConsumer) : ").append(super.getClass().getName()).toString());
            }
            this.dialogStateConsumerAsync.remove(dialogStateConsumer);
        }
    }

    @Override
    public void register(ApplicationStateConsumer applicationStateConsumer) {
        if (!this.applicationStateConsumerAsync.containsKey(applicationStateConsumer)) {
            if (this.logger.isTraceEnabled(this.loggerClassifier)) {
                this.logger.trace(this.loggerClassifier, new StringBuffer().append(this.loggerPrefix).append("register(ApplicationStateConsumer) : ").append(super.getClass().getName()).toString());
            }
            Object object = this.asyncServiceFactory.create(applicationStateConsumer);
            this.applicationStateConsumerAsync.put(applicationStateConsumer, object);
        }
    }

    @Override
    public void unregister(ApplicationStateConsumer applicationStateConsumer) {
        if (this.applicationStateConsumerAsync.containsKey(applicationStateConsumer)) {
            if (this.logger.isTraceEnabled(this.loggerClassifier)) {
                this.logger.trace(this.loggerClassifier, new StringBuffer().append(this.loggerPrefix).append("unregister(ApplicationStateConsumer) : ").append(super.getClass().getName()).toString());
            }
            this.applicationStateConsumerAsync.remove(applicationStateConsumer);
        }
    }

    @Override
    public void onApplicationStateChanged(int n) {
        if (this.currentApplicationState == n) {
            if (this.aLogger.isTraceEnabled()) {
                this.aLogger.trace().append("onApplicationStateChangedn state has not changed.").log();
            }
            return;
        }
        this.currentApplicationState = n;
        this.aLogger.info().append(new StringBuffer().append("onApplicationStateChanged() : ").append(n).toString()).log();
        Iterator iterator = this.applicationStateConsumerAsync.valueIterator();
        while (iterator.hasNext()) {
            ApplicationStateConsumer applicationStateConsumer = (ApplicationStateConsumer)iterator.next();
            applicationStateConsumer.onApplicationStateChanged(n);
        }
    }

    @Override
    public void register(int n, SlotStateConsumer slotStateConsumer) {
        ObjectObjectMap objectObjectMap;
        Object object = this.asyncServiceFactory.create(slotStateConsumer);
        if (!this.slotStateConsumer.containsKey(n)) {
            if (this.logger.isTraceEnabled(this.loggerClassifier)) {
                this.logger.trace(this.loggerClassifier, new StringBuffer().append(this.loggerPrefix).append("register(SlotStateConsumer) : ").append(super.getClass().getName()).toString());
            }
            objectObjectMap = new ObjectObjectOptHashMap();
            objectObjectMap.put(slotStateConsumer, object);
            this.slotStateConsumer.put(n, objectObjectMap);
        } else {
            objectObjectMap = (ObjectObjectMap)this.slotStateConsumer.get(n);
            if (!objectObjectMap.containsKey(slotStateConsumer)) {
                if (this.logger.isTraceEnabled(this.loggerClassifier)) {
                    this.logger.trace(this.loggerClassifier, new StringBuffer().append(this.loggerPrefix).append("register(SlotStateConsumer) : ").append(super.getClass().getName()).toString());
                }
                objectObjectMap.put(slotStateConsumer, object);
            }
        }
        int n2 = this.slotStateValue.get(n);
        if (n2 == 0) {
            n2 = -1;
        }
        ((SlotStateConsumer)object).onSlotStateChanged(n, n2);
    }

    @Override
    public void unregister(int n, SlotStateConsumer slotStateConsumer) {
        ObjectObjectMap objectObjectMap;
        if (this.slotStateConsumer.containsKey(n) && (objectObjectMap = (ObjectObjectMap)this.slotStateConsumer.get(n)).containsKey(slotStateConsumer)) {
            if (this.logger.isTraceEnabled(this.loggerClassifier)) {
                this.logger.trace(this.loggerClassifier, new StringBuffer().append(this.loggerPrefix).append("unregister(SlotStateConsumer) : ").append(super.getClass().getName()).toString());
            }
            objectObjectMap.remove(slotStateConsumer);
        }
    }

    @Override
    public void onSlotStateChanged(int n, int n2) {
        this.slotStateValue.put(n, this.convertGrammarState(n2));
        Iterator iterator = this.slotStateConsumer.getAll(n).iterator();
        while (iterator.hasNext()) {
            ObjectObjectMap objectObjectMap = (ObjectObjectMap)iterator.next();
            int n3 = this.convertGrammarState(n2);
            Iterator iterator2 = objectObjectMap.valueIterator();
            while (iterator2.hasNext()) {
                SlotStateConsumer slotStateConsumer = (SlotStateConsumer)iterator2.next();
                slotStateConsumer.onSlotStateChanged(n, n3);
            }
        }
    }

    private int convertGrammarState(int n) {
        switch (n) {
            case 1: {
                return 1;
            }
            case 2: {
                return 2;
            }
            case 3: {
                return 3;
            }
            case 4: {
                return 4;
            }
            case 5: {
                return 5;
            }
        }
        LogMessage logMessage = this.logger.warn(this.loggerClassifier);
        logMessage.append("SlotStateRouter#convertGrammarState(dsiGrammarStatus:");
        logMessage.append(n);
        logMessage.append(") Unknown grammar state.");
        logMessage.log();
        return -1;
    }

    @Override
    public int getApplicationState() {
        return this.currentApplicationState;
    }

    @Override
    public DialogStateBitField getDialogState() {
        return this.dialogStateBitFieldTracker;
    }

    @Override
    public int getIndicatorState() {
        return this.currentIndicatorState;
    }
}

