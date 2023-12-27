/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.event.internal.dispatcher;

import de.vw.mib.event.internal.AbstractEvent;
import de.vw.mib.event.internal.dispatcher.AbstractDispatcher;
import de.vw.mib.event.internal.dispatcher.EventQueue;

final class StartupDispatcher
extends AbstractDispatcher {
    private final EventQueue queue;

    StartupDispatcher(EventQueue eventQueue) {
        this.queue = eventQueue;
    }

    @Override
    protected AbstractEvent poll() {
        return this.queue.poll();
    }
}

