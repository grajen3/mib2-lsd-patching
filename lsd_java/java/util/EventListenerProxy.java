/*
 * Decompiled with CFR 0.152.
 */
package java.util;

import java.util.EventListener;

public abstract class EventListenerProxy
implements EventListener {
    private final EventListener listener;

    public EventListenerProxy(EventListener eventListener) {
        this.listener = eventListener;
    }

    public EventListener getListener() {
        return this.listener;
    }
}

