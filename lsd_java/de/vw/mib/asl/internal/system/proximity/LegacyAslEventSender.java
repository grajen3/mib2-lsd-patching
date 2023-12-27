/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system.proximity;

import de.vw.mib.asl.api.system.proximity.ProximityListener;
import de.vw.mib.genericevents.EventDispatcherHSM;
import de.vw.mib.genericevents.EventFactory;
import de.vw.mib.genericevents.EventGeneric;

public class LegacyAslEventSender
implements ProximityListener {
    private final EventDispatcherHSM eventDispatcher;
    private final EventFactory eventFactory;

    public LegacyAslEventSender(EventDispatcherHSM eventDispatcherHSM, EventFactory eventFactory) {
        this.eventDispatcher = eventDispatcherHSM;
        this.eventFactory = eventFactory;
    }

    @Override
    public void onProximityChanged(boolean bl) {
        EventGeneric eventGeneric = this.eventFactory.newEvent(194855168);
        eventGeneric.setBoolean(0, bl);
        this.eventDispatcher.sendSafe(eventGeneric);
    }

    @Override
    public void onUserInteractionProximityChanged(boolean bl) {
    }
}

