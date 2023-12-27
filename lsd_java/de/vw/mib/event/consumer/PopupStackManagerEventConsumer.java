/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.event.consumer;

import de.vw.mib.event.ContextChangeEvent;
import de.vw.mib.event.DynamicStateEvent;
import de.vw.mib.event.PowerStateEvent;

public interface PopupStackManagerEventConsumer {
    default public void consumeEvent(ContextChangeEvent contextChangeEvent) {
    }

    default public void consumeEvent(DynamicStateEvent dynamicStateEvent) {
    }

    default public void consumeEvent(PowerStateEvent powerStateEvent) {
    }
}

