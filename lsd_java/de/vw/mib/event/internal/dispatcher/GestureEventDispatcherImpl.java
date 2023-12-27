/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.event.internal.dispatcher;

import de.vw.mib.event.dispatcher.GestureEventDispatcher;
import de.vw.mib.event.internal.EventFactory;
import de.vw.mib.event.internal.ServiceManager;
import de.vw.mib.event.internal.dispatcher.EventQueue;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.log4mib.Logger;

final class GestureEventDispatcherImpl
implements GestureEventDispatcher {
    private static Logger logger = ServiceManager.loggerFactory.getLogger(64);
    private final EventFactory eventFactory;
    private final EventQueue queue;

    GestureEventDispatcherImpl(EventQueue eventQueue, EventFactory eventFactory) {
        this.queue = eventQueue;
        this.eventFactory = eventFactory;
    }

    @Override
    public void createAndSubmitProximityEvent(int n, int n2, int n3, float f2, float f3, float f4, float f5, float f6, int n4) {
        if (logger.isTraceEnabled(16384)) {
            LogMessage logMessage = logger.trace(16384);
            logMessage.append("create and submit advanced ProximityEvent - type: ").append(n);
            logMessage.append(", proximity area: ").append(n2);
            logMessage.append(", object id: ").append(n3);
            logMessage.append(", x: ").append(f2).append(", y: ").append(f3);
            logMessage.append(", width: ").append(f4).append(", height: ").append(f5);
            logMessage.append(", distance: ").append(f6);
            logMessage.append(", timestamp: ").append(n4).log();
        }
        this.queue.add(this.eventFactory.createProximityEvent(n, n2, n3, f2, f3, f4, f5, f6, n4));
    }

    @Override
    public void createAndSubmitTouchEvent(int n, int n2, int n3, int n4, int n5, int n6, int n7) {
        if (logger.isTraceEnabled(512)) {
            LogMessage logMessage = logger.trace(512);
            logMessage.append("create and submit TouchEvent - type: ").append(n);
            logMessage.append(", x: ").append(n2);
            logMessage.append(", y: ").append(n3);
            logMessage.append(", zDelta: ").append(n4);
            logMessage.append(", param1: ").append(n5);
            logMessage.append(", param2: ").append(n6).log();
        }
        this.queue.add(this.eventFactory.createTouchEvent(n, n2, n3, n4, n5, n6, n7));
    }
}

