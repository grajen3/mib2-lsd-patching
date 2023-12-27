/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.event.internal.dispatcher;

import de.vw.mib.event.consumer.ViewAnimationEventConsumer;
import de.vw.mib.event.dispatcher.FrameworkEventDispatcher;
import de.vw.mib.event.internal.EventFactory;
import de.vw.mib.event.internal.ServiceManager;
import de.vw.mib.event.internal.StartupEventImpl;
import de.vw.mib.event.internal.dispatcher.EventQueue;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.log4mib.Logger;

final class FrameworkEventDispatcherImpl
implements FrameworkEventDispatcher {
    private static Logger logger = ServiceManager.loggerFactory.getLogger(64);
    private final EventFactory eventFactory;
    private final EventQueue systemQueue;
    private final EventQueue viewQueue;

    FrameworkEventDispatcherImpl(EventQueue eventQueue, EventQueue eventQueue2, EventFactory eventFactory) {
        this.systemQueue = eventQueue;
        this.viewQueue = eventQueue2;
        this.eventFactory = eventFactory;
    }

    public void createAndSubmitAnimationEvent() {
        this.createAndSubmitAnimationEvent(0);
    }

    @Override
    public void createAndSubmitAnimationEvent(int n) {
        logger.trace(32, "create and submit AnimationEvent");
        this.systemQueue.add(this.eventFactory.createAnimationEvent(n));
    }

    public void createAndSubmitAsiaInputEvent(int n) {
    }

    public void createAndSubmitAsiaInputEvent(int n, int n2) {
    }

    public void createAndSubmitAsiaInputEvent(int n, int n2, boolean bl) {
    }

    public void createAndSubmitAsiaInputEvent(int n, int n2, int n3) {
    }

    public void createAndSubmitAsiaInputEvent(int n, int n2, String string) {
    }

    public void createAndSubmitAsiaInputEvent(int n, String string) {
    }

    public void createAndSubmitAsiaInputEvent(int n, String[] stringArray) {
    }

    @Override
    public void createAndSubmitDynamicStateEvent(int n, int n2) {
        if (logger.isTraceEnabled(32)) {
            LogMessage logMessage = logger.trace(32);
            logMessage.append("create and submit DynamicStateEvent - dynamicStateId: ").append(n).append(", command: ").append(n2).log();
        }
        this.viewQueue.add(this.eventFactory.createDynamicStateEvent(n, n2, -1));
    }

    @Override
    public void createAndSubmitListReadoutEvent(int n, int n2, int n3) {
        if (logger.isTraceEnabled(32)) {
            LogMessage logMessage = logger.trace(32);
            logMessage.append("create and submit ListReadoutEvent - vAIndexListItem: ").append(n);
            logMessage.append(", viewHandlerID: ").append(n2);
            logMessage.append(", datasourceIndex: ").append(n3).log();
        }
        this.viewQueue.add(this.eventFactory.createListReadoutEvent(n, n2, n3));
    }

    @Override
    public void createAndSubmitLSChangeEvent(int n) {
        if (logger.isTraceEnabled(32)) {
            LogMessage logMessage = logger.trace(32);
            logMessage.append("create and submit LsChange event - command: ").append(n).log();
        }
        this.systemQueue.add(this.eventFactory.createLSChangeEvent(n));
    }

    @Override
    public void createAndSubmitPopupStackChangeEvent(int n, int n2) {
        if (logger.isTraceEnabled(32)) {
            LogMessage logMessage = logger.trace(32);
            logMessage.append("create and submit PopupStackChangeEvent event - numberOfPopups: ").append(n).append(", numberOfUserPerceivedPopups: ").append(n2).log();
        }
        this.systemQueue.add(this.eventFactory.createPopupStackChangeEvent(n, n2));
    }

    @Override
    public void createAndSubmitReadoutSelectionEvent(int n, int[] nArray, int n2, int n3) {
        if (logger.isTraceEnabled(32)) {
            LogMessage logMessage = logger.trace(32);
            logMessage.append("create and submit ReadoutListSelectionEvent - vAIndexListItem: ").append(n);
            logMessage.append(", vAIndexButtons: ").append(nArray);
            logMessage.append(", datasourceIndex: ").append(n2);
            logMessage.append(", viewHandlerId: ").append(n3).log();
        }
        this.systemQueue.add(this.eventFactory.createReadoutSelectionEvent(n, nArray, n2, n3));
    }

    @Override
    public void createAndSubmitRepaintEvent() {
        logger.trace(32, "create and submit RepaintEvent");
        this.systemQueue.add(this.eventFactory.createRepaintEvent());
    }

    public void createAndSubmitSpeechRecognitionEvent() {
        logger.warn(32, "SpeechRecognitionEvents no longer supported!");
    }

    @Override
    public void createAndSubmitStartupEvent(int n) {
        if (logger.isTraceEnabled(128)) {
            LogMessage logMessage = logger.trace(128);
            logMessage.append("create and submit StartupEvent - eventId: ").append(n).log();
        }
        this.systemQueue.add(new StartupEventImpl(n));
    }

    @Override
    public void createAndSubmitViewAnimationEvent(ViewAnimationEventConsumer viewAnimationEventConsumer, int n) {
        if (logger.isTraceEnabled(32)) {
            LogMessage logMessage = logger.trace(32);
            logMessage.append("create and submit AnimationFinishedEvent - animation type: ").append(n).log();
        }
        this.viewQueue.add(this.eventFactory.createViewAnimationEvent(viewAnimationEventConsumer, n));
    }

    @Override
    public void invoke(Runnable runnable) {
        if (logger.isTraceEnabled(32)) {
            LogMessage logMessage = logger.trace(32);
            logMessage.append("invoke runnable: ").append(runnable).log();
        }
        this.systemQueue.add(this.eventFactory.createInvocationEvent(runnable));
    }
}

