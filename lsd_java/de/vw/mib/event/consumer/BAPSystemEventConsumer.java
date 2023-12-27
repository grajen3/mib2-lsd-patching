/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.event.consumer;

import de.vw.mib.event.SystemEvent;

public interface BAPSystemEventConsumer {
    default public boolean consumeEvent(SystemEvent systemEvent) {
    }
}

