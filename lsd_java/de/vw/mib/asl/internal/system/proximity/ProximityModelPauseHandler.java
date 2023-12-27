/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system.proximity;

import de.vw.mib.asl.internal.impl.system.AbstractSystemTarget;
import de.vw.mib.asl.internal.system.SystemServices;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.ServiceRegister;
import de.vw.mib.proximation.ProximityInstaller;

public class ProximityModelPauseHandler
extends AbstractSystemTarget {
    private final ProximityInstaller proximityInstaller;

    public ProximityModelPauseHandler(SystemServices systemServices, ProximityInstaller proximityInstaller) {
        super(systemServices.getGenericEvents(), systemServices.getAsl1Logger(), -156625664);
        this.proximityInstaller = proximityInstaller;
        this.addObservers(systemServices.getServiceRegister());
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 1073743179: {
                this.proximityInstaller.pauseProximity(0, true);
                break;
            }
            case 0x40000555: {
                this.proximityInstaller.resetProximityPause(0);
                break;
            }
        }
    }

    private void addObservers(ServiceRegister serviceRegister) {
        serviceRegister.addObserver(1258618944, this.getTargetId());
        serviceRegister.addObserver(0x55050040, this.getTargetId());
    }
}

