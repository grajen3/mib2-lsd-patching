/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.carlife.common;

import de.vw.mib.asl.api.navigation.AbstractASLNavigationServicesListener;
import de.vw.mib.asl.internal.carlife.CarlifeHSMTarget;
import de.vw.mib.asl.internal.carlife.common.CarLifeGlobalProperties;
import de.vw.mib.asl.internal.carlife.common.CarLifeModeHandling;

public class NavigationHandler
extends AbstractASLNavigationServicesListener {
    private CarlifeHSMTarget target;
    private CarLifeGlobalProperties properties;
    private CarLifeModeHandling modeHandling;

    public NavigationHandler(CarlifeHSMTarget carlifeHSMTarget, CarLifeGlobalProperties carLifeGlobalProperties) {
        this.target = carlifeHSMTarget;
        this.properties = carLifeGlobalProperties;
        this.modeHandling = null;
    }

    public void setModeHandling(CarLifeModeHandling carLifeModeHandling) {
        this.modeHandling = carLifeModeHandling;
    }

    @Override
    public void updateGuidanceActive(boolean bl) {
        if (null != this.modeHandling) {
            if (bl && this.properties.isConnected()) {
                this.modeHandling.getRequiredResourceOwner().setNavigationOwner(1);
                this.modeHandling.sendSetMode();
            } else if (!bl && this.properties.isConnected() && this.properties.getActiveNavigation() == 1) {
                this.modeHandling.getRequiredResourceOwner().setNavigationOwner(0);
                this.modeHandling.sendSetMode();
            }
        }
        this.properties.setHmiRouteGuidanceActive(bl);
    }

    @Override
    public void updateServiceAvailable(boolean bl) {
    }
}

