/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.event.internal.dispatcher;

import de.vw.mib.app.framework.AppDefinition;
import de.vw.mib.event.dispatcher.StatemachineEventDispatcherExt;
import de.vw.mib.event.internal.AbstractEvent;
import de.vw.mib.event.internal.AbstractPooledEvent;
import de.vw.mib.event.internal.EventFactory;
import de.vw.mib.event.internal.ServiceManager;
import de.vw.mib.event.internal.ViewChangeEventImpl;
import de.vw.mib.event.internal.dispatcher.EventQueue;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.log4mib.Logger;

final class StatemachineEventDispatcherImpl
implements StatemachineEventDispatcherExt {
    private static Logger logger = ServiceManager.loggerFactory.getLogger(64);
    private final EventFactory eventFactory;
    private final EventQueue statemachineEventQueue;
    private final EventQueue systemEventQueue;

    StatemachineEventDispatcherImpl(EventQueue eventQueue, EventQueue eventQueue2, EventFactory eventFactory) {
        this.statemachineEventQueue = eventQueue2;
        this.systemEventQueue = eventQueue;
        this.eventFactory = eventFactory;
    }

    @Override
    public void createAndSubmitBooleanValueEvent(int n, boolean bl) {
        this.createAndSubmitBooleanValueEvent(null, null, n, bl);
    }

    @Override
    public void createAndSubmitBooleanValueEvent(AppDefinition appDefinition, AppDefinition appDefinition2, int n, boolean bl) {
        if (logger.isTraceEnabled(256)) {
            LogMessage logMessage = logger.trace(256);
            logMessage.append("create and submit BooleanValueEvent - id: ").append(n).append(", value: ").append(bl).log();
        }
        this.statemachineEventQueue.add(this.eventFactory.createBooleanValueEvent(appDefinition, appDefinition2, n, bl));
    }

    @Override
    public void createAndSubmitContextChangeEvent(String string) {
        if (logger.isTraceEnabled(256)) {
            LogMessage logMessage = logger.trace(256);
            logMessage.append("create and submit ContextChangeEvent - context: ").append(string).log();
        }
        this.statemachineEventQueue.add(this.eventFactory.createContextChangeEvent(string));
    }

    @Override
    public void createAndSubmitDpChangedEvent(int n) {
        this.createAndSubmitDpChangedEvent(null, null, n);
    }

    @Override
    public void createAndSubmitDpChangedEvent(AppDefinition appDefinition, AppDefinition appDefinition2, int n) {
        if (logger.isTraceEnabled(256)) {
            LogMessage logMessage = logger.trace(256);
            logMessage.append("create and submit HMIEvent (System) - id: ").append(n).log();
        }
        this.systemEventQueue.add(this.eventFactory.createHMIEvent(appDefinition, appDefinition2, n));
    }

    @Override
    public void createAndSubmitDynamicStateEvent(int n, int n2, int n3) {
        if (logger.isTraceEnabled(256)) {
            LogMessage logMessage = logger.trace(256);
            logMessage.append("create and submit DynamicStateEvent - dynamicStateId: ").append(n).append(", command: ").append(n2).append(", popupInfoId: ").append(n3).log();
        }
        this.statemachineEventQueue.add(this.eventFactory.createDynamicStateEvent(n, n2, n3));
    }

    @Override
    public void createAndSubmitHMIEvent(int n) {
        this.createAndSubmitHMIEvent(null, null, n);
    }

    @Override
    public void createAndSubmitHMIEvent(AppDefinition appDefinition, AppDefinition appDefinition2, int n) {
        if (logger.isTraceEnabled(256)) {
            LogMessage logMessage = logger.trace(256);
            logMessage.append("create and submit HMIEvent - id: ").append(n).log();
        }
        this.statemachineEventQueue.add(this.eventFactory.createHMIEvent(appDefinition, appDefinition2, n));
    }

    @Override
    public void createAndSubmitIntegerValueEvent(int n, int n2) {
        this.createAndSubmitIntegerValueEvent(null, null, n, n2);
    }

    @Override
    public void createAndSubmitIntegerValueEvent(AppDefinition appDefinition, AppDefinition appDefinition2, int n, int n2) {
        if (logger.isTraceEnabled(256)) {
            LogMessage logMessage = logger.trace(256);
            logMessage.append("create and submit IntegerValueEvent - id: ").append(n).append(", value: ").append(n2).log();
        }
        this.statemachineEventQueue.add(this.eventFactory.createIntegerValueEvent(appDefinition, appDefinition2, n, n2));
    }

    @Override
    public void createAndSubmitListItemEvent(int n, int n2, int n3, int n4, int n5, String string, long l) {
        this.createAndSubmitListItemEvent(null, null, n, n2, n3, n4, n5, string, l);
    }

    @Override
    public void createAndSubmitListItemEvent(AppDefinition appDefinition, AppDefinition appDefinition2, int n, int n2, int n3, int n4, int n5, String string, long l) {
        if (logger.isTraceEnabled(256)) {
            LogMessage logMessage = logger.trace(256);
            logMessage.append("create and submit ListItem - id: ").append(n).append(", absoluteIndex: ").append(n2).append(", actionIndex: ").append(n3).append(", destinationIndex: ").append(n4).append(", dropDownIndex: ").append(n5).append(", eventSender: ").append(string).append(", objectId: ").append(l).log();
        }
        this.statemachineEventQueue.add(this.eventFactory.createListItemEvent(appDefinition, appDefinition2, n, n2, n3, n4, n5, string, l));
    }

    @Override
    public void createAndSubmitPointEvent(int n, int n2, int n3, int n4, int n5) {
        this.createAndSubmitPointEvent(null, null, n, n2, n3, n4, n5);
    }

    @Override
    public void createAndSubmitPointEvent(AppDefinition appDefinition, AppDefinition appDefinition2, int n, int n2, int n3, int n4, int n5) {
        if (logger.isTraceEnabled(256)) {
            LogMessage logMessage = logger.trace(256);
            logMessage.append("create and submit PointItem - id: ").append(n).append(", x: ").append(n2).append(", y: ").append(n3).append(", param1: ").append(n4).append(", param2: ").append(n5).log();
        }
        this.statemachineEventQueue.add(this.eventFactory.createPointEvent(appDefinition, appDefinition2, n, n2, n3, n4, n5));
    }

    @Override
    public void createAndSubmitPopupViewEvent(int n, String string, int n2) {
        this.createAndSubmitPopupViewEvent(n, string, n2, -1);
    }

    @Override
    public void createAndSubmitPopupViewEvent(int n, String string, int n2, int n3) {
        if (logger.isTraceEnabled(256)) {
            LogMessage logMessage = logger.trace(256);
            logMessage.append("create and submit PopupViewEvent - dynamicStateId: ").append(n);
            logMessage.append(", popupViewId: ").append(string);
            logMessage.append(", command: ").append(n2);
            logMessage.append(", popupInfoId: ").append(n3).log();
        }
        this.statemachineEventQueue.add(this.eventFactory.createPopupViewEvent(n, string, n2, n3));
    }

    @Override
    public void createAndSubmitSpellerValueEvent(int n, String string, int n2, int n3, int n4) {
        this.createAndSubmitSpellerValueEvent(null, null, n, string, n2, n3, n4);
    }

    @Override
    public void createAndSubmitSpellerValueEvent(AppDefinition appDefinition, AppDefinition appDefinition2, int n, String string, int n2, int n3, int n4) {
        if (logger.isTraceEnabled(256)) {
            LogMessage logMessage = logger.trace(256);
            logMessage.append("create and submit SpellerValueEvent - id: ").append(n).append(", pressedChar: ").append(string).append(", cursorPosition: ").append(n2).append(", selectionStart: ").append(n3).append(", selectionEnd: ").append(n4).log();
        }
        this.statemachineEventQueue.add(this.eventFactory.createSpellerValueEvent(appDefinition, appDefinition2, n, string, n2, n3, n4));
    }

    @Override
    public void createAndSubmitStringValueEvent(int n, String string) {
        this.createAndSubmitStringValueEvent(null, null, n, string);
    }

    @Override
    public void createAndSubmitStringValueEvent(AppDefinition appDefinition, AppDefinition appDefinition2, int n, String string) {
        if (logger.isTraceEnabled(256)) {
            LogMessage logMessage = logger.trace(256);
            logMessage.append("create and submit StringValueEvent - id: ").append(n).append(", value: ").append(string).log();
        }
        this.statemachineEventQueue.add(this.eventFactory.createStringValueEvent(appDefinition, appDefinition2, n, string));
    }

    @Override
    public void createAndSubmitViewChangeEvent(int n, String string, boolean bl, int n2, int n3) {
        Object object;
        if (logger.isTraceEnabled(256)) {
            object = logger.trace(256);
            object.append("create and submit ViewChangeEvent - command: ").append(n);
            object.append(", following view: ").append(string);
            object.append(", reset view: ").append(bl);
            object.append(", sequence number: ").append(n2).log();
        }
        if (0 == n) {
            object = this.eventFactory.createViewChangeEvent(n, string, bl, n2, n3);
            ((AbstractEvent)object).traceBypass();
            ((ViewChangeEventImpl)object).dispatchEvent();
            ((AbstractPooledEvent)object).releaseEvent();
        } else {
            this.statemachineEventQueue.add(this.eventFactory.createViewChangeEvent(n, string, bl, n2, n3));
        }
    }

    @Override
    public void invoke(Runnable runnable) {
        if (logger.isTraceEnabled(256)) {
            LogMessage logMessage = logger.trace(256);
            logMessage.append("invoke runnable: ").append(runnable).log();
        }
        this.statemachineEventQueue.add(this.eventFactory.createInvocationEvent(runnable));
    }
}

