/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.event.internal.diag;

import de.vw.mib.event.internal.diag.EventQueueMonitor;

public interface EventDispatcherDiag {
    default public void registerStatemachineEventQueueMonitor(EventQueueMonitor eventQueueMonitor) {
    }

    default public void registerSystemEventQueueMonitor(EventQueueMonitor eventQueueMonitor) {
    }

    default public void registerViewEventQueueMonitor(EventQueueMonitor eventQueueMonitor) {
    }
}

