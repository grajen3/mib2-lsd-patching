/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system;

import de.vw.mib.asl.framework.api.startupv7r.startupstate.StartupStateListener;
import de.vw.mib.asl.internal.system.SystemServices;
import de.vw.mib.genericevents.EventDispatcherHSM;
import de.vw.mib.genericevents.EventFactory;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEventException;
import de.vw.mib.log4mib.Logger;

public class PowerManagementStartupListener
implements StartupStateListener {
    private final Logger logger;
    private final EventDispatcherHSM eventDispatcher;
    private final EventFactory eventFactory;

    public PowerManagementStartupListener(SystemServices systemServices) {
        this.logger = systemServices.getAsl1Logger();
        this.eventDispatcher = systemServices.getGenericEvents().getEventDispatcher();
        this.eventFactory = systemServices.getEventFactory();
    }

    @Override
    public void onStartupStateChanged(int n) {
        if (n == 2) {
            this.enablePersistenceNormalFlushing();
        }
    }

    private void enablePersistenceNormalFlushing() {
        EventGeneric eventGeneric = this.eventFactory.newEvent();
        eventGeneric.setReceiverTargetId(5120);
        eventGeneric.setReceiverEventId(127746304);
        try {
            this.eventDispatcher.send(eventGeneric);
        }
        catch (GenericEventException genericEventException) {
            this.logger.error(2048).attachThrowable(genericEventException).log();
        }
    }
}

