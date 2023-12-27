/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.event.internal.dispatcher;

import de.vw.mib.app.framework.AppDefinition;
import de.vw.mib.event.HMIEvent;
import de.vw.mib.event.dispatcher.ViewEventDispatcher;
import de.vw.mib.event.internal.AbstractEvent;
import de.vw.mib.event.internal.EventFactory;
import de.vw.mib.event.internal.ServiceManager;
import de.vw.mib.event.internal.dispatcher.EventQueue;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.log4mib.Logger;

final class ViewEventDispatcherImpl
implements ViewEventDispatcher {
    private static Logger logger = ServiceManager.loggerFactory.getLogger(64);
    private final EventFactory eventFactory;
    private boolean lsChangeFilter;
    private final EventQueue queue;

    ViewEventDispatcherImpl(EventQueue eventQueue, EventFactory eventFactory) {
        this.queue = eventQueue;
        this.eventFactory = eventFactory;
    }

    @Override
    public void createAndSubmitBooleanValueEvent(int n, boolean bl) {
        this.createAndSubmitBooleanValueEvent(null, null, n, bl);
    }

    @Override
    public void createAndSubmitBooleanValueEvent(AppDefinition appDefinition, AppDefinition appDefinition2, int n, boolean bl) {
        if (logger.isTraceEnabled(1024)) {
            LogMessage logMessage = logger.trace(1024);
            logMessage.append("create and submit BooleanValueEvent - id: ").append(n).append(", value: ").append(bl).log();
        }
        this.queue.add(this.eventFactory.createBooleanValueEvent(appDefinition, appDefinition2, n, bl));
    }

    @Override
    public void createAndSubmitHMIEvent(int n) {
        this.createAndSubmitHMIEvent(null, null, n);
    }

    @Override
    public void createAndSubmitHMIEvent(AppDefinition appDefinition, AppDefinition appDefinition2, int n) {
        if (logger.isTraceEnabled(1024)) {
            LogMessage logMessage = logger.trace(1024);
            logMessage.append("create and submit HMIEvent - id: ").append(n).log();
        }
        this.queue.add(this.eventFactory.createHMIEvent(appDefinition, appDefinition2, n));
    }

    @Override
    public void createAndSubmitIntegerValueEvent(int n, int n2) {
        this.createAndSubmitIntegerValueEvent(null, null, n, n2);
    }

    @Override
    public void createAndSubmitIntegerValueEvent(AppDefinition appDefinition, AppDefinition appDefinition2, int n, int n2) {
        if (logger.isTraceEnabled(1024)) {
            LogMessage logMessage = logger.trace(1024);
            logMessage.append("create and submit IntegerValueEvent - id: ").append(n).append(", value: ").append(n2).log();
        }
        this.queue.add(this.eventFactory.createIntegerValueEvent(appDefinition, appDefinition2, n, n2));
    }

    @Override
    public void createAndSubmitListItemEvent(int n, int n2, int n3, int n4, int n5, String string, long l) {
        this.createAndSubmitListItemEvent(null, null, n, n2, n3, n4, n5, string, l);
    }

    @Override
    public void createAndSubmitListItemEvent(AppDefinition appDefinition, AppDefinition appDefinition2, int n, int n2, int n3, int n4, int n5, String string, long l) {
        if (logger.isTraceEnabled(1024)) {
            LogMessage logMessage = logger.trace(1024);
            logMessage.append("create and submit ListItem - id: ").append(n).append(", absoluteIndex: ").append(n2).append(", actionIndex: ").append(n3).append(", destinationIndex: ").append(n4).append(", dropDownIndex: ").append(n5).append(", eventSender: ").append(string).append(", objectId: ").append(l).log();
        }
        this.queue.add(this.eventFactory.createListItemEvent(appDefinition, appDefinition2, n, n2, n3, n4, n5, string, l));
    }

    @Override
    public void createAndSubmitPointEvent(int n, int n2, int n3, int n4, int n5) {
        this.createAndSubmitPointEvent(null, null, n, n2, n3, n4, n5);
    }

    @Override
    public void createAndSubmitPointEvent(AppDefinition appDefinition, AppDefinition appDefinition2, int n, int n2, int n3, int n4, int n5) {
        if (logger.isTraceEnabled(1024)) {
            LogMessage logMessage = logger.trace(1024);
            logMessage.append("create and submit PointItem - id: ").append(n).append(", x: ").append(n2).append(", y: ").append(n3).append(", param1: ").append(n4).append(", param2: ").append(n5).log();
        }
        this.queue.add(this.eventFactory.createPointEvent(appDefinition, appDefinition2, n, n2, n3, n4, n5));
    }

    @Override
    public void createAndSubmitSpellerValueEvent(int n, String string, int n2, int n3, int n4) {
        this.createAndSubmitSpellerValueEvent(null, null, n, string, n2, n3, n4);
    }

    @Override
    public void createAndSubmitSpellerValueEvent(AppDefinition appDefinition, AppDefinition appDefinition2, int n, String string, int n2, int n3, int n4) {
        if (logger.isTraceEnabled(1024)) {
            LogMessage logMessage = logger.trace(1024);
            logMessage.append("create and submit SpellerValueEvent - id: ").append(n).append(", pressedChar: ").append(string).append(", cursorPosition: ").append(n2).append(", selectionStart: ").append(n3).append(", selectionEnd: ").append(n4).log();
        }
        this.queue.add(this.eventFactory.createSpellerValueEvent(appDefinition, appDefinition2, n, string, n2, n3, n4));
    }

    @Override
    public void createAndSubmitStringValueEvent(int n, String string) {
        this.createAndSubmitStringValueEvent(null, null, n, string);
    }

    @Override
    public void createAndSubmitStringValueEvent(AppDefinition appDefinition, AppDefinition appDefinition2, int n, String string) {
        if (logger.isTraceEnabled(1024)) {
            LogMessage logMessage = logger.trace(1024);
            logMessage.append("create and submit StringValueEvent - id: ").append(n).append(", value: ").append(string).log();
        }
        this.queue.add(this.eventFactory.createStringValueEvent(appDefinition, appDefinition2, n, string));
    }

    @Override
    public void submitEvent(HMIEvent hMIEvent) {
        if (this.lsChangeFilter && hMIEvent.getType() == 2) {
            logger.trace(1024, "discard hardkey event while performing language/skin change");
            return;
        }
        if (logger.isTraceEnabled(1024)) {
            LogMessage logMessage = logger.trace(1024);
            logMessage.append("submitEvent: ").append(hMIEvent).log();
        }
        this.queue.add((AbstractEvent)((Object)hMIEvent));
    }

    @Override
    public void invoke(Runnable runnable) {
        if (logger.isTraceEnabled(1024)) {
            LogMessage logMessage = logger.trace(1024);
            logMessage.append("invoke runnable: ").append(runnable).log();
        }
        this.queue.add(this.eventFactory.createInvocationEvent(runnable));
    }
}

