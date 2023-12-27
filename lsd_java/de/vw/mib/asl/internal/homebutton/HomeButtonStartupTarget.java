/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.homebutton;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.impl.homebutton.AbstractHomeButtonTarget;
import de.vw.mib.asl.internal.impl.homebutton.HomeButtonMainTarget;
import de.vw.mib.asl.internal.impl.homebutton.HomeButtonServicesImpl;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;

public class HomeButtonStartupTarget
extends AbstractHomeButtonTarget {
    public HomeButtonStartupTarget(GenericEvents genericEvents, String string) {
        super(genericEvents, ServiceManager.logger, -1019340288);
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        if (eventGeneric.getReceiverEventId() == 106) {
            this.processPowerOn();
        }
    }

    private void processPowerOn() {
        HomeButtonServicesImpl homeButtonServicesImpl = new HomeButtonServicesImpl();
        new HomeButtonMainTarget(homeButtonServicesImpl).registerEvents();
    }
}

