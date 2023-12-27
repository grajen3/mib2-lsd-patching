/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.event.consumer;

import de.vw.mib.event.Event;
import de.vw.mib.event.HMIEvent;
import de.vw.mib.event.StartupEvent;

public interface StatemachineManagerEventConsumer {
    default public boolean consumeEvent(HMIEvent hMIEvent) {
    }

    default public void consumeEvent(StartupEvent startupEvent) {
    }

    default public void cycleBreakOut() {
    }

    default public void cycleDetected(Event event) {
    }
}

