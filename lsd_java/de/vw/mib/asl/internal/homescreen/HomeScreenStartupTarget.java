/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.homescreen;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.homescreen.HomeScreenServices;
import de.vw.mib.asl.internal.impl.homescreen.AbstractHomeScreenTarget;
import de.vw.mib.asl.internal.impl.homescreen.DriverDistractionPreventionHandler;
import de.vw.mib.asl.internal.impl.homescreen.HomeScreenInfoTarget;
import de.vw.mib.asl.internal.impl.homescreen.HomeScreenMainTarget;
import de.vw.mib.asl.internal.impl.homescreen.HomeScreenServicesProvider;
import de.vw.mib.asl.internal.impl.homescreen.HomeScreenSpaceGesturesTarget;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;

public class HomeScreenStartupTarget
extends AbstractHomeScreenTarget {
    public HomeScreenStartupTarget(GenericEvents genericEvents, String string) {
        super(genericEvents, ServiceManager.logger, -1290331648);
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
        HomeScreenServices homeScreenServices = HomeScreenServicesProvider.getHomeScreenServices();
        new HomeScreenMainTarget(homeScreenServices);
        new HomeScreenInfoTarget(homeScreenServices);
        new HomeScreenSpaceGesturesTarget(homeScreenServices);
        homeScreenServices.getFactoryResetService();
        homeScreenServices.getDriverDistractionPreventionService().addDriverDistractionPreventionListener(new DriverDistractionPreventionHandler(homeScreenServices.getASLPropertyManager(), homeScreenServices.getTileInstaller(), homeScreenServices.getConfigurationManager()));
    }
}

