/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.travellink.traffic;

import de.vw.mib.asl.api.navigation.map.ASLNavigationServiceMainMap;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.travellink.TLinkServiceManager;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEventException;

public final class Traffic {
    public static final int ZOOMAREA_POSITIONX;
    public static final int ZOOMAREA_POSITIONY;
    public static final int ZOOMAREA_WIDTH;
    public static final int ZOOMAREA_HEIGHT;
    public static final int MAP_CENTER_X;
    public static final int MAP_CENTER_Y;
    private boolean isTrafficMapAvailable = false;
    private boolean isMapLockedRequested = false;

    public void eventHandlingPrepareTrafficMapScreenShot() {
        int n;
        if (ServiceManager.logger2.isTraceEnabled(128)) {
            ServiceManager.logger2.trace(128).append("Traffic : eventHandlingPrepareTrafficMapScreenShot()").log();
        }
        if (0 == (n = TLinkServiceManager.getServiceManager().getCurrentViewId())) {
            boolean bl = TLinkServiceManager.getServiceManager().getApiNavigation().isMapLocked();
            if (!this.isMapLockedRequested()) {
                TLinkServiceManager.getServiceManager().getApiNavigation().lockMapViewer();
            } else if (bl && this.isTrafficMapAvailable()) {
                TLinkServiceManager.getServiceManager().getGuiControllerTraffic().trafficMapAvailable();
            }
        }
    }

    public void eventHandlingTrafficMapAvailable() {
        int n;
        if (ServiceManager.logger2.isTraceEnabled(128)) {
            ServiceManager.logger2.trace(128).append("Traffic : eventHandlingTrafficMapAvailable()").log();
        }
        if (0 == (n = TLinkServiceManager.getServiceManager().getCurrentViewId())) {
            TLinkServiceManager.getServiceManager().getTargetMain().startTimer(-1417281280, (long)0, false);
        }
    }

    public void setTrafficMapAvailable() {
        int n;
        if (ServiceManager.logger2.isTraceEnabled(128)) {
            ServiceManager.logger2.trace(128).append("Traffic : setTrafficMapAvailable()").log();
        }
        if (0 == (n = TLinkServiceManager.getServiceManager().getCurrentViewId())) {
            TLinkServiceManager.getServiceManager().getGuiControllerTraffic().trafficMapAvailable();
            this.setTrafficMapAvailable(true);
        }
    }

    public void eventHandlingScreenShotTrafficeMapCreated() {
        if (ServiceManager.logger2.isTraceEnabled(128)) {
            ServiceManager.logger2.trace(128).append("Traffic : eventHandlingScreenShotTrafficeMapCreated()").log();
        }
    }

    public void unlockMapViewer() {
        boolean bl;
        if (ServiceManager.logger2.isTraceEnabled(128)) {
            ServiceManager.logger2.trace(128).append("Traffic : unlockMapViewer()").log();
        }
        if (bl = TLinkServiceManager.getServiceManager().getApiNavigation().isMapLocked()) {
            TLinkServiceManager.getServiceManager().getApiNavigation().unlockMapViewer();
        }
        this.setTrafficMapAvailable(false);
    }

    public void setTrafficMapScreenShotConfiguration() {
        int n = TLinkServiceManager.getServiceManager().getCurrentViewId();
        if (0 == n) {
            TLinkServiceManager.getServiceManager().getApiNavigation().setMapConfiguration(TLinkServiceManager.getServiceManager().getApiNavigation().getInitialMapConfigurationForTrafficMap());
            if (ServiceManager.logger2.isTraceEnabled(128)) {
                ServiceManager.logger2.info(128).append("Traffic : setTrafficMapScreenShotConfiguration() : Setting map configuration and creating navigation main map for Traffic map").log();
            }
        }
    }

    void setTrafficMapAvailable(boolean bl) {
        if (ServiceManager.logger2.isTraceEnabled(2)) {
            ServiceManager.logger2.trace(2).append("Traffic : setTrafficMapAvailable() : ").append(bl).log();
        }
        this.isTrafficMapAvailable = bl;
    }

    private boolean isTrafficMapAvailable() {
        if (ServiceManager.logger2.isTraceEnabled(2)) {
            ServiceManager.logger2.trace(2).append("Traffic : isTrafficMapAvailable() : ").append(this.isTrafficMapAvailable).log();
        }
        return this.isTrafficMapAvailable;
    }

    public void testTrafficSubscription(EventGeneric eventGeneric) {
        try {
            int n = eventGeneric.getInt(0);
            if (ServiceManager.logger2.isTraceEnabled(2)) {
                ServiceManager.logger2.trace(2).append("Traffic : subscription state").append(n).log();
            }
        }
        catch (GenericEventException genericEventException) {
            ServiceManager.errorHandler.handleError(genericEventException);
        }
    }

    public void showTrafficMiniMap() {
        int n = TLinkServiceManager.getServiceManager().getCurrentViewId();
        ASLNavigationServiceMainMap aSLNavigationServiceMainMap = TLinkServiceManager.getServiceManager().getNavigationServiceMainMap();
        if (ServiceManager.logger2.isTraceEnabled(2)) {
            if (null == aSLNavigationServiceMainMap) {
                ServiceManager.logger2.trace(2).append("Traffic - showTrafficMiniMap() - null == aslNavigationServiceMainMap - viewId = ").append(n).log();
            } else {
                ServiceManager.logger2.trace(2).append("Traffic - showTrafficMiniMap() - null != aslNavigationServiceMainMap - viewId = ").append(n).log();
            }
        }
        if (0 == n && null != aSLNavigationServiceMainMap) {
            TLinkServiceManager.getServiceManager().getTargetMain().stopTimer(-1434058496);
            TLinkServiceManager.getServiceManager().getTargetMain().startTimer(-1434058496, (long)0, true);
            TLinkServiceManager.getServiceManager().getGuiControllerTraffic().updateTrafficLoadingState(2);
        }
    }

    public boolean isMapLockedRequested() {
        return this.isMapLockedRequested;
    }

    public void setMapLockedRequested(boolean bl) {
        this.isMapLockedRequested = bl;
    }
}

