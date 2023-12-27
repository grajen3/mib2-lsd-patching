/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.event.internal;

import de.vw.mib.event.RestoreFactorySettingsEvent;
import de.vw.mib.event.internal.AbstractPooledEvent;
import de.vw.mib.event.internal.EventPool;
import de.vw.mib.event.internal.ServiceManager;
import de.vw.mib.log4mib.LogMessage;

final class RestoreFactorySettingsEventImpl
extends AbstractPooledEvent
implements RestoreFactorySettingsEvent {
    RestoreFactorySettingsEventImpl(EventPool eventPool) {
        super(eventPool);
    }

    @Override
    public void dispatchEvent() {
        ServiceManager.restoreFactorySettingsEventConsumer.consumeEvent(this);
    }

    public String toString() {
        return "RestoreFactorySettingsEvent";
    }

    @Override
    public void toString(LogMessage logMessage) {
        logMessage.append("RestoreFactorySettingsEvent");
    }

    @Override
    void traceEvent(byte by, byte by2) {
        ServiceManager.eventTracer.trace(by, by2, this);
    }
}

