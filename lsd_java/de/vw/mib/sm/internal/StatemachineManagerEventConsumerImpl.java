/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.sm.internal;

import de.vw.mib.event.Event;
import de.vw.mib.event.HMIEvent;
import de.vw.mib.event.StartupEvent;
import de.vw.mib.event.consumer.StatemachineManagerEventConsumer;
import de.vw.mib.sm.internal.CurrentHMIEvent;
import de.vw.mib.sm.internal.ServiceManagerStatemachine;

public class StatemachineManagerEventConsumerImpl
implements StatemachineManagerEventConsumer {
    private static final boolean CHECKPOINT_ED = Boolean.getBoolean("smjournal.checkpoint") || Boolean.getBoolean("smjournal.checkpoint.ed");
    private static final char CP_ED_RECEIVETABLE;
    private static final char CP_ED_HANDLE;
    private static final char CP_ED_HANDLED;

    private static void checkpoint(char c2) {
        if (CHECKPOINT_ED) {
            ServiceManagerStatemachine.journalEx.checkpoint(c2);
        }
    }

    @Override
    public void consumeEvent(StartupEvent startupEvent) {
        if (startupEvent.getEventId() == 0) {
            ServiceManagerStatemachine.statemachineManager.start();
        }
    }

    @Override
    public boolean consumeEvent(HMIEvent hMIEvent) {
        if (hMIEvent.isConsumed()) {
            return true;
        }
        int n = hMIEvent.getId();
        ServiceManagerStatemachine.journalEx.eventProcessing(n, (short)0);
        CurrentHMIEvent.set(hMIEvent);
        StatemachineManagerEventConsumerImpl.checkpoint('?');
        if (ServiceManagerStatemachine.eventReceiverTable.canResponseToCurrentEvent()) {
            StatemachineManagerEventConsumerImpl.checkpoint('>');
            boolean bl = this.handleHMIEvent();
            StatemachineManagerEventConsumerImpl.checkpoint('<');
            CurrentHMIEvent.reset();
            ServiceManagerStatemachine.journalEx.eventProcessed(n, bl);
            return bl;
        }
        CurrentHMIEvent.reset();
        ServiceManagerStatemachine.journalEx.eventSkipped(n);
        return false;
    }

    private boolean handleHMIEvent() {
        ServiceManagerStatemachine.statemachineManager.handleHMIEvent();
        if (CurrentHMIEvent.isConsumed()) {
            return true;
        }
        if (ServiceManagerStatemachine.eventReceiverTable.canResponseToCurrentEvent(ServiceManagerStatemachine.globalReceiverId)) {
            ServiceManagerStatemachine.dynamicStatemachineTrigger.handleHMIEvent();
            if (CurrentHMIEvent.isConsumed()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void cycleDetected(Event event) {
        ServiceManagerStatemachine.statemachineManager.cycleDetected(event);
    }

    @Override
    public void cycleBreakOut() {
    }
}

