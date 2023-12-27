/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.map;

import de.vw.mib.asl.api.navigation.ASLNavigationFactory;
import de.vw.mib.asl.api.navigation.INavigationLocation;
import de.vw.mib.asl.api.navigation.NavigationServiceException;
import de.vw.mib.asl.api.navigation.map.ASLNavigationMapConfiguration;
import de.vw.mib.asl.api.navigation.map.NavigationMapService;
import de.vw.mib.asl.internal.speechnavigation.common.AppLogger;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.map.MapService;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.map.NavigationMapServiceAdapterBase;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.map.NavigationMapServiceAdapterBase$MapCallerLock;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.map.listener.MapServiceListener;
import org.dsi.ifc.map.Rect;

public final class NavigationMapServiceAdapter
extends NavigationMapServiceAdapterBase
implements MapService {
    private NavigationMapService navigationMapService;
    private NavigationMapServiceAdapterBase$MapCallerLock showMapCaller;
    private Rect defaultMapCanvasSize = new Rect(0, 63, 724, 417);
    private boolean isMapConfigurationDirty = false;
    private static final int MAP_ZOOM_LEVEL;
    private static final int MAP_FLAG_STYLETYP_DESTINATION;
    private static NavigationMapServiceAdapter instance;

    private NavigationMapServiceAdapter() {
        try {
            this.navigationMapService = ASLNavigationFactory.getNavigationApi().getNavigationMapService(this);
            super.updateMapType(this.navigationMapService.getMapType());
            this.showMapCaller = new NavigationMapServiceAdapterBase$MapCallerLock(this, this.navigationMapService);
        }
        catch (Exception exception) {
            AppLogger.error(this, new StringBuffer().append(", an exception occured getting the navigation map service: ").append(exception.getMessage()).toString());
            throw new NavigationServiceException(exception);
        }
    }

    private static NavigationMapServiceAdapter getInstance() {
        if (instance == null) {
            instance = new NavigationMapServiceAdapter();
        }
        return instance;
    }

    public static MapService getMapService() {
        return NavigationMapServiceAdapter.getInstance();
    }

    @Override
    public void initMapSize(Rect rect) {
        this.defaultMapCanvasSize = rect;
    }

    @Override
    public void showAddressOnMap(MapServiceListener mapServiceListener, INavigationLocation iNavigationLocation, Rect rect) {
        if (rect == null) {
            rect = this.defaultMapCanvasSize;
        }
        AppLogger.trace(this, new StringBuffer().append(".showAddressOnMap(.., mapSize = ").append(rect.toString()).append(", address = ").append(iNavigationLocation.toString()).append(" )").toString());
        this.showMapCaller.acquire(mapServiceListener, iNavigationLocation, rect);
    }

    private void onShowAddressOnMapGranted() {
        AppLogger.trace(this, ".onShowAddressOnMapGranted() ");
        try {
            ASLNavigationMapConfiguration aSLNavigationMapConfiguration = new ASLNavigationMapConfiguration();
            aSLNavigationMapConfiguration.setMapMode(2);
            aSLNavigationMapConfiguration.setViewType(0);
            aSLNavigationMapConfiguration.setOrientation(2);
            aSLNavigationMapConfiguration.setPerspective(-1);
            aSLNavigationMapConfiguration.setZoomArea(this.showMapCaller.getMapSize());
            aSLNavigationMapConfiguration.setZoomLevel(200);
            aSLNavigationMapConfiguration.setFlagStyleType(25);
            aSLNavigationMapConfiguration.setNavigationLocation(this.showMapCaller.getDestination());
            this.isMapConfigurationDirty = true;
            AppLogger.trace(this, new StringBuffer().append(", call NavigationMapService.goToLocation( mapConfig = ").append(aSLNavigationMapConfiguration.toString()).append(") ").toString());
            this.navigationMapService.goToLocation(aSLNavigationMapConfiguration);
            this.showMapCaller.release(0);
        }
        catch (NavigationServiceException navigationServiceException) {
            AppLogger.error(this, new StringBuffer().append(", exception calling NavigationMapService.goToLocation(..), ").append(navigationServiceException.getMessage()).toString());
            this.showMapCaller.release(1);
        }
    }

    @Override
    public void lockMapViewerResult(boolean bl) {
        AppLogger.trace(this, new StringBuffer().append(".lockMapViewerResult( isLocked = ").append(bl).append(" )").toString());
        if (this.showMapCaller.isAcquired()) {
            if (!bl) {
                AppLogger.error(this, ", map lock not granted or lock lost while prepairing NavigationMapService.goToLocation(..)");
                this.showMapCaller.release(1);
                return;
            }
            this.onShowAddressOnMapGranted();
        }
    }

    @Override
    public void release() {
        if (this.isMapConfigurationDirty) {
            AppLogger.trace(this, ".releaseView(), restore map config");
            this.isMapConfigurationDirty = false;
            this.navigationMapService.releaseView();
        }
        if (this.navigationMapService.isMapServiceLockedByMe()) {
            try {
                AppLogger.warn(this, ".release(), map service still locked by @me.");
                this.navigationMapService.unlockMapViewer();
            }
            catch (NavigationServiceException navigationServiceException) {
                AppLogger.error(this, new StringBuffer().append(".release(), an exception occured calling NavigationMapService.unlockMapViewer(): ").append(navigationServiceException.getMessage()).toString());
            }
        }
    }

    static {
        instance = null;
    }
}

