/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.internal.navigation.map.dsi.datapool.MapDataPool;
import de.vw.mib.asl.internal.navigation.map.dsi.factories.DSIMapViewerControlFactoryVW;
import de.vw.mib.asl.internal.navigation.map.mainmap.MapViewerDatapoolShared;
import de.vw.mib.asl.internal.navigation.map.setup.PersistedMapSetup;

public final class GoogleEarthUtils {
    private static boolean finalDestinationZoom;
    private static IExtLogger LOGGER;

    private GoogleEarthUtils() {
    }

    public static boolean isGoogleEarthActive() {
        int n = DSIMapViewerControlFactoryVW.getMapViewerInstanceIdCurrentMain();
        return n == 1;
    }

    public static boolean isUseCrosshairMap() {
        float f2;
        GoogleEarthUtils.getLogger().trace("isUseCrosshairMap()");
        if (!GoogleEarthUtils.isGoogleEarthActive()) {
            GoogleEarthUtils.getLogger().trace("StreetView crosshair not visible: Google Earth is not active.");
            return false;
        }
        if (finalDestinationZoom) {
            GoogleEarthUtils.getLogger().trace("StreetView crosshair not visible: Final destination zoom is active.");
            return false;
        }
        MapViewerDatapoolShared mapViewerDatapoolShared = MapViewerDatapoolShared.getInstance();
        if (!mapViewerDatapoolShared.isStreetviewLicenceOK()) {
            GoogleEarthUtils.getLogger().trace("StreetView crosshair not visible: StreetView is disabled in CarNet setup.");
            return false;
        }
        if (!mapViewerDatapoolShared.isTouchApproximated()) {
            GoogleEarthUtils.getLogger().trace("StreetView crosshair not visible: No touch approximation.");
            return false;
        }
        if (mapViewerDatapoolShared.isVelocityTresholdForStreetViewReached()) {
            GoogleEarthUtils.getLogger().trace("StreetView crosshair not visible: Vehicle has reached velocity threshold.");
            return false;
        }
        if (mapViewerDatapoolShared.isTwoFingerZoomActive()) {
            GoogleEarthUtils.getLogger().trace("StreetView crosshair not visible: Two finger zoom is active.");
            return false;
        }
        if (mapViewerDatapoolShared.isClickInMapMenuActive()) {
            GoogleEarthUtils.getLogger().trace("StreetView crosshair not visible: Click in map menu active.");
            return false;
        }
        if (mapViewerDatapoolShared.isPerspectiveAlternativeRouteMap()) {
            GoogleEarthUtils.getLogger().trace("StreetView crosshair not visible: Alternative route map shown.");
            return false;
        }
        int n = PersistedMapSetup.getInstance().getMainMapContent();
        if (n != 0) {
            GoogleEarthUtils.getLogger().trace("StreetView crosshair not visible: Main map is not active.");
            return false;
        }
        MapDataPool mapDataPool = DSIMapViewerControlFactoryVW.getMapDatapoolMain();
        int n2 = mapDataPool.getZoomListIndex();
        if (n2 < 0) {
            f2 = mapDataPool.getZoomLevel();
        } else {
            float[] fArray = mapDataPool.getZoomList();
            float f3 = f2 = fArray == null || fArray.length <= n2 ? mapDataPool.getZoomLevel() : fArray[n2];
        }
        if (f2 < 8163912) {
            GoogleEarthUtils.getLogger().trace("StreetView crosshair visible.");
            return true;
        }
        GoogleEarthUtils.getLogger().trace("StreetView crosshair not visible: Maximum zoom level for showing crosshair exceeded.");
        return false;
    }

    public static void setFinalDestinationZoom(boolean bl) {
        finalDestinationZoom = bl;
    }

    private static IExtLogger getLogger() {
        if (LOGGER == null) {
            LOGGER = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(256, "[GoogleEarthUtils]");
        }
        return LOGGER;
    }

    static {
        LOGGER = null;
    }
}

