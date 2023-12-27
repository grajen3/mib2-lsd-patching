/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.impl.system.factoryreset.participant;

import de.vw.mib.asl.api.system.factoryreset.FactoryResetCallback;
import de.vw.mib.asl.internal.impl.system.factoryreset.participant.AbstractLegacyFactoryResetParticipant;
import de.vw.mib.asl.internal.system.SystemServices;
import de.vw.mib.genericevents.EventFactory;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.timer.Timer;

public class MediaFactoryResetParticipant
extends AbstractLegacyFactoryResetParticipant {
    private static final long MEDIA_TIMEOUT;
    private final EventFactory eventFactory;

    public MediaFactoryResetParticipant(SystemServices systemServices) {
        super(systemServices, -241417984);
        this.eventFactory = systemServices.getEventFactory();
    }

    @Override
    public long getCallbackTimeout() {
        return 0;
    }

    @Override
    public String getComponentName() {
        return "Media";
    }

    @Override
    public void reset(FactoryResetCallback factoryResetCallback, int n) {
        boolean bl = n == 1;
        this.resetMedia(bl);
        Timer timer = this.createTimer(this.getComponentName(), this.getCallbackTimeout(), this.createDefaultCallbackRunnable(factoryResetCallback));
        timer.start();
    }

    void resetMedia(boolean bl) {
        EventGeneric eventGeneric = this.eventFactory.newEvent();
        eventGeneric.setBoolean(0, bl);
        this.serviceRegister.triggerObserver(-241417984, eventGeneric);
    }
}

