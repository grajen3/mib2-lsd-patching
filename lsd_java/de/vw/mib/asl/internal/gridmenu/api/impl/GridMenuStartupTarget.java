/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.gridmenu.api.impl;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.gridmenu.api.impl.GridMenuServices;
import de.vw.mib.asl.internal.gridmenu.api.impl.GridMenuServicesProvider;
import de.vw.mib.asl.internal.impl.gridmenu.AbstractGridMenuTarget;
import de.vw.mib.asl.internal.impl.gridmenu.GridMenuDebugTarget;
import de.vw.mib.asl.internal.impl.gridmenu.GridMenuValetParking;
import de.vw.mib.asl.internal.impl.gridmenu.MainMenuTarget;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;

public class GridMenuStartupTarget
extends AbstractGridMenuTarget {
    public GridMenuStartupTarget(GenericEvents genericEvents, String string) {
        super(genericEvents, ServiceManager.logger, -748348928);
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 106: {
                this.processPowerOn();
                break;
            }
        }
    }

    private void processPowerOn() {
        GridMenuServices gridMenuServices = GridMenuServicesProvider.getGridMenuServices();
        new GridMenuDebugTarget(gridMenuServices);
        new MainMenuTarget(gridMenuServices);
        new GridMenuValetParking(gridMenuServices).run();
    }
}

