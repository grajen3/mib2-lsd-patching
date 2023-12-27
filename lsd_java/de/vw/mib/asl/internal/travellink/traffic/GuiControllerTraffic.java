/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.travellink.traffic;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.travellink.GuiControllerCommon;
import de.vw.mib.asl.internal.travellink.TLinkServiceManager;

public final class GuiControllerTraffic
implements GuiControllerCommon {
    @Override
    public void setSubscriptionState(int n) {
        if (ServiceManager.logger2.isTraceEnabled(2)) {
            ServiceManager.logger2.trace(2).append("GuiControllerTraffic - setSubscriptionState(").append(n).append(")").log();
        }
        if (n == 2) {
            ServiceManager.aslPropertyManager.valueChangedInteger(-1220599040, 1);
        } else {
            ServiceManager.aslPropertyManager.valueChangedInteger(-1220599040, 0);
        }
    }

    public void refreshTrafficMap(boolean bl) {
        int n = TLinkServiceManager.getServiceManager().getCurrentViewId();
        if (0 == n) {
            TLinkServiceManager.getServiceManager().getTraffic().setTrafficMapAvailable(false);
            if (bl) {
                TLinkServiceManager.getServiceManager().getTraffic().setTrafficMapScreenShotConfiguration();
            }
            ServiceManager.eventDispatcher.createAndSubmitHMIEvent(-1975573760);
            if (ServiceManager.logger2.isTraceEnabled(128)) {
                ServiceManager.logger2.trace(128).append("GuiControllerTraffic : refreshTrafficMap() : Event TRAVELLINK_REFRESH_TRAFFIC_MAP fired to GUI ").log();
            }
        }
    }

    public void trafficMapAvailable() {
        if (ServiceManager.logger2.isTraceEnabled(128)) {
            ServiceManager.logger2.trace(128).append("GuiControllerTraffic : trafficMapAvailable()").log();
        }
        ServiceManager.eventDispatcher.createAndSubmitHMIEvent(-1958796544);
    }

    public void updateTrafficLoadingState(int n) {
        if (ServiceManager.logger2.isTraceEnabled(128)) {
            ServiceManager.logger2.trace(128).append("GuiControllerWeather : updateTrafficMapLoadingState(), trafficMapLoadingState = ").append(n).log();
        }
        if (n >= 0 && n <= 2) {
            ServiceManager.aslPropertyManager.valueChangedInteger(-1472257280, n);
        } else if (ServiceManager.logger2.isTraceEnabled(2)) {
            ServiceManager.logger2.error(2).append("GuiControllerWeather : updateTrafficLoadingState(), Loading state not in range - ").append(n).log();
        }
    }
}

