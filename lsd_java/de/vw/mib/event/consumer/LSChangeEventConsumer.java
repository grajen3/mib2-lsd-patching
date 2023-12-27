/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.event.consumer;

import de.vw.mib.event.LSChangeEvent;

public interface LSChangeEventConsumer {
    default public void consumeEvent(LSChangeEvent lSChangeEvent) {
    }
}

