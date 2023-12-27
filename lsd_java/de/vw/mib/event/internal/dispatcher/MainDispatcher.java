/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.event.internal.dispatcher;

import de.vw.mib.error.HMIDumpInformationProvider;
import de.vw.mib.event.internal.AbstractEvent;
import de.vw.mib.event.internal.DatapoolUpdateEventImpl;
import de.vw.mib.event.internal.ServiceManager;
import de.vw.mib.event.internal.diag.EventDispatcherDiag;
import de.vw.mib.event.internal.diag.EventQueueMonitor;
import de.vw.mib.event.internal.dispatcher.AbstractDispatcher;
import de.vw.mib.event.internal.dispatcher.EventQueue;
import de.vw.mib.log4mib.LogMessage;

final class MainDispatcher
extends AbstractDispatcher
implements EventDispatcherDiag,
HMIDumpInformationProvider {
    static final int EVENTS_TO_STORE_FOR_HMIDUMP;
    private static final int MAX_EVENT_COUNT_FOR_STATEMACHINE_CYCLE_DETECTION;
    private static final int MAX_EVENT_COUNT_FOR_STATEMACHINE_RESET;
    private int statemachineEventCounter;
    private final EventQueue statemachineEventQueue;
    private final EventQueue systemEventQueue;
    private final EventQueue viewEventQueue;
    private final AbstractEvent[] lastEvents = new AbstractEvent[15];
    private final long[] lastEventsTimestamps = new long[15];
    private int lastEventsIndex = 0;

    MainDispatcher(EventQueue eventQueue, EventQueue eventQueue2, EventQueue eventQueue3) {
        this.statemachineEventQueue = eventQueue;
        this.systemEventQueue = eventQueue2;
        this.viewEventQueue = eventQueue3;
        ServiceManager.errorHandler.addHMIDumpInformationProvider(this);
    }

    @Override
    public void clearDumpInformation() {
    }

    @Override
    public String[] getDumpInformation() {
        String[] stringArray = new String[15];
        for (int i2 = 0; i2 < 15; ++i2) {
            int n = (i2 + this.lastEventsIndex) % 15;
            stringArray[i2] = this.lastEventsTimestamps[n] > 0L ? new StringBuffer().append(this.lastEventsTimestamps[n]).append(" - ").toString() : new StringBuffer().append("").append(this.lastEvents[n]).toString();
        }
        return stringArray;
    }

    @Override
    public String getName() {
        return "MainDispatcher - last dispatched events:";
    }

    @Override
    public void registerStatemachineEventQueueMonitor(EventQueueMonitor eventQueueMonitor) {
        this.statemachineEventQueue.registerEventQueueMonitor(eventQueueMonitor);
    }

    @Override
    public void registerSystemEventQueueMonitor(EventQueueMonitor eventQueueMonitor) {
        this.systemEventQueue.registerEventQueueMonitor(eventQueueMonitor);
    }

    @Override
    public void registerViewEventQueueMonitor(EventQueueMonitor eventQueueMonitor) {
        this.viewEventQueue.registerEventQueueMonitor(eventQueueMonitor);
    }

    private void checkAndBreakCycle() {
        if (this.statemachineEventCounter > MAX_EVENT_COUNT_FOR_STATEMACHINE_RESET && MAX_EVENT_COUNT_FOR_STATEMACHINE_RESET > 0) {
            logger.error(1, "Try to break event cycle in statemachine! Clearing event queues!");
            this.viewEventQueue.clear();
            this.statemachineEventQueue.clear();
            this.resetEventCounter();
            ServiceManager.statemachineManager.cycleBreakOut();
        }
    }

    private void incrementAndCheckEventCounter(AbstractEvent abstractEvent) {
        ++this.statemachineEventCounter;
        if (this.statemachineEventCounter > MAX_EVENT_COUNT_FOR_STATEMACHINE_CYCLE_DETECTION && MAX_EVENT_COUNT_FOR_STATEMACHINE_CYCLE_DETECTION > 0) {
            logger.error(1).append("Event cycle in statemachine detected! ").append(abstractEvent).log();
            ServiceManager.statemachineManager.cycleDetected(abstractEvent);
        }
    }

    private void resetEventCounter() {
        this.statemachineEventCounter = 0;
    }

    @Override
    AbstractEvent poll() {
        this.checkAndBreakCycle();
        AbstractEvent abstractEvent = this.viewEventQueue.poll();
        if (abstractEvent != null) {
            this.incrementAndCheckEventCounter(abstractEvent);
            return abstractEvent;
        }
        abstractEvent = this.statemachineEventQueue.poll();
        if (abstractEvent != null) {
            this.incrementAndCheckEventCounter(abstractEvent);
            return abstractEvent;
        }
        this.resetEventCounter();
        return this.systemEventQueue.poll();
    }

    @Override
    void releaseEvent(AbstractEvent abstractEvent) {
        AbstractEvent abstractEvent2 = this.lastEvents[this.lastEventsIndex];
        if (abstractEvent2 != null) {
            abstractEvent2.releaseEvent();
        }
        this.lastEvents[this.lastEventsIndex] = abstractEvent;
        this.lastEventsTimestamps[this.lastEventsIndex] = -1L;
        this.lastEventsIndex = (this.lastEventsIndex + 1) % 15;
    }

    void submitDatapoolUpdateEvent(DatapoolUpdateEventImpl datapoolUpdateEventImpl) {
        if (!this.thread.isAlive() || this.isCurrentThread()) {
            if (logger.isTraceEnabled(2048)) {
                LogMessage logMessage = logger.trace(2048);
                logMessage.append("dispatch ").append(datapoolUpdateEventImpl).append(" immediately").log();
            }
            datapoolUpdateEventImpl.traceBypass();
            datapoolUpdateEventImpl.dispatchEvent();
            datapoolUpdateEventImpl.releaseEvent();
            return;
        }
        if (logger.isTraceEnabled(2048)) {
            LogMessage logMessage = logger.trace(2048);
            logMessage.append("add event ").append(datapoolUpdateEventImpl).append(" to the event queue").log();
        }
        this.systemEventQueue.add(datapoolUpdateEventImpl);
    }

    static {
        MAX_EVENT_COUNT_FOR_STATEMACHINE_CYCLE_DETECTION = Integer.getInteger("EventDispatcher.cycleDetectionThreshold", 150);
        MAX_EVENT_COUNT_FOR_STATEMACHINE_RESET = MAX_EVENT_COUNT_FOR_STATEMACHINE_CYCLE_DETECTION << 1;
    }
}

