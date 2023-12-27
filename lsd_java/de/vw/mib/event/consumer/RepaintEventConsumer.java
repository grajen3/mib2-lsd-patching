/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.event.consumer;

import de.vw.mib.event.RepaintEvent;

public interface RepaintEventConsumer {
    default public void consumeEvent(RepaintEvent repaintEvent) {
    }
}

