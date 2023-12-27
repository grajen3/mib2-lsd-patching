/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.event.consumer;

import de.vw.mib.event.DatapoolUpdateEvent;

public interface DatapoolEventConsumer {
    default public void consumeEvent(DatapoolUpdateEvent datapoolUpdateEvent) {
    }
}

