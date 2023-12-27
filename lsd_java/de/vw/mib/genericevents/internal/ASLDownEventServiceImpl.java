/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.genericevents.internal;

import de.vw.mib.coreapi.ASLDownEvent;
import de.vw.mib.coreapi.client.ASLDownEventService;
import de.vw.mib.genericevents.EventFactory;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.ServiceRegister;

final class ASLDownEventServiceImpl
implements ASLDownEventService {
    private final EventFactory eventFactory;
    private final ServiceRegister serviceRegister;

    ASLDownEventServiceImpl(EventFactory eventFactory, ServiceRegister serviceRegister) {
        this.eventFactory = eventFactory;
        this.serviceRegister = serviceRegister;
    }

    @Override
    public ASLDownEvent createASLDownEvent(int n) {
        return this.eventFactory.newEvent(n);
    }

    @Override
    public void sendASLDownEvent(ASLDownEvent aSLDownEvent) {
        this.serviceRegister.triggerObserver(aSLDownEvent.getServiceId(), (EventGeneric)aSLDownEvent);
    }
}

