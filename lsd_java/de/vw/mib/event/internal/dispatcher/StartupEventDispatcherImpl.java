/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.event.internal.dispatcher;

import de.vw.mib.event.dispatcher.StartupEventDispatcher;
import de.vw.mib.event.internal.ServiceManager;
import de.vw.mib.event.internal.StartupEventImpl;
import de.vw.mib.event.internal.dispatcher.EventQueue;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.log4mib.Logger;

final class StartupEventDispatcherImpl
implements StartupEventDispatcher {
    private static Logger logger = ServiceManager.loggerFactory.getLogger(64);
    private final EventQueue queue;

    StartupEventDispatcherImpl(EventQueue eventQueue) {
        this.queue = eventQueue;
    }

    @Override
    public void createAndSubmitStartupEvent(int n) {
        if (logger.isTraceEnabled(128)) {
            LogMessage logMessage = logger.trace(128);
            logMessage.append("create and submit StartupEvent - eventId: ").append(n).log();
        }
        this.queue.add(new StartupEventImpl(n));
    }
}

