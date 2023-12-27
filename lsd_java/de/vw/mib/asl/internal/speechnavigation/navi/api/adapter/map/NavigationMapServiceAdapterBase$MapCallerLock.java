/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.map;

import de.vw.mib.asl.api.navigation.INavigationLocation;
import de.vw.mib.asl.api.navigation.NavigationServiceException;
import de.vw.mib.asl.api.navigation.map.NavigationMapService;
import de.vw.mib.asl.internal.speechnavigation.common.AppLogger;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.map.NavigationMapServiceAdapterBase;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.map.listener.MapServiceListener;
import org.dsi.ifc.map.Rect;

public class NavigationMapServiceAdapterBase$MapCallerLock {
    private MapServiceListener listener;
    private INavigationLocation destination;
    private Rect mapSize;
    private final NavigationMapService navigationMapService;
    private final /* synthetic */ NavigationMapServiceAdapterBase this$0;

    public NavigationMapServiceAdapterBase$MapCallerLock(NavigationMapServiceAdapterBase navigationMapServiceAdapterBase, NavigationMapService navigationMapService) {
        this.this$0 = navigationMapServiceAdapterBase;
        this.navigationMapService = navigationMapService;
    }

    public void acquire(MapServiceListener mapServiceListener, INavigationLocation iNavigationLocation, Rect rect) {
        if (this.listener != null) {
            AppLogger.warn(this, new StringBuffer().append(", collision caller detected (previous caller did not released the map): ").append(this.toString()).toString());
        }
        if (this.navigationMapService.isMapServiceLockedByMe()) {
            AppLogger.error(this, ".acquire(..), updateGoToLocationMapReady() / handleMapServiceError(..) has not been callback on previous goToLocation() call.");
        }
        this.listener = mapServiceListener;
        this.destination = iNavigationLocation;
        this.mapSize = rect;
        AppLogger.trace(this, new StringBuffer().append(", caller aquired: ").append(this.toString()).toString());
        try {
            AppLogger.trace(this, ".showAddressOnMap(), call NavigationMapService.lockMapViewer");
            this.navigationMapService.lockMapViewer();
        }
        catch (NavigationServiceException navigationServiceException) {
            AppLogger.error(this, new StringBuffer().append(", error calling NavigationMapService.lockMapViewer: ").append(navigationServiceException.getMessage()).toString());
            this.release(1);
        }
    }

    public void release(int n) {
        if (this.listener == null) {
            AppLogger.trace(this, ".release() has been already called.");
            return;
        }
        this.listener.showAddressOnMapResponse(n, this.destination);
        this.release();
        try {
            AppLogger.trace(this, ", call NavigationMapService.unlockMapViewer");
            this.navigationMapService.unlockMapViewer();
        }
        catch (NavigationServiceException navigationServiceException) {
            AppLogger.error(this, new StringBuffer().append(", an exception occured calling NavigationMapService.unlockMapViewer: ").append(navigationServiceException.getMessage()).toString());
        }
    }

    public INavigationLocation getDestination() {
        return this.destination;
    }

    public Rect getMapSize() {
        return this.mapSize;
    }

    private void release() {
        AppLogger.trace(this, new StringBuffer().append(", caller released: ").append(this.toString()).toString());
        this.listener = null;
    }

    public boolean isAcquired() {
        return this.listener != null;
    }

    public String toString() {
        return new StringBuffer().append(super.getClass().getName()).append(" - ").append(this.listener.hashCode()).toString();
    }
}

