/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.event.consumer;

import de.vw.mib.event.StartupEvent;

public interface StartupManagerEventConsumer {
    default public void consumeEvent(StartupEvent startupEvent) {
    }
}

