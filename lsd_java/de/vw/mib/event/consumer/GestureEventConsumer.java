/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.event.consumer;

import de.vw.mib.event.ProximityEvent;

public interface GestureEventConsumer {
    default public void consumeEvent(ProximityEvent proximityEvent) {
    }
}

