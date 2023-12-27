/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.exboxm.services;

import de.vw.mib.asl.internal.exboxm.services.ExboxServices;
import de.vw.mib.asl.internal.exboxm.services.ExboxServicesProvider;
import de.vw.mib.asl.internal.exboxm.services.StartupServiceImpl;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.Target;

public class TargetASLExBoxMServices
implements Target {
    private final GenericEvents genericEvents;

    public TargetASLExBoxMServices(GenericEvents genericEvents, String string) {
        this.genericEvents = genericEvents;
        genericEvents.getEventDispatcher().registerTarget(this.getTargetId(), this, string);
    }

    @Override
    public GenericEvents getMainObject() {
        return this.genericEvents;
    }

    @Override
    public int getTargetId() {
        return -1312550400;
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 106: {
                this.processAslEventPowerOn();
                break;
            }
        }
    }

    private void processAslEventPowerOn() {
        ExboxServices exboxServices = ExboxServicesProvider.getExBoxServices();
        StartupServiceImpl startupServiceImpl = (StartupServiceImpl)exboxServices.getInternalStartupService();
        startupServiceImpl.processPowerOnOccured();
    }

    @Override
    public void setTargetId(int n) {
    }
}

