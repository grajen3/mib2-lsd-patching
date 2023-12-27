/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.travellink;

import de.vw.mib.asl.api.navigation.ASLNavigationServices;
import de.vw.mib.asl.api.navigation.GuidanceInfo;
import de.vw.mib.asl.api.navigation.NavAddress;
import de.vw.mib.asl.api.navigation.map.ASLNavigationMapConfiguration;
import de.vw.mib.asl.api.navigation.map.ASLNavigationServiceMainMap;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.travellink.ApiNavigationException;
import de.vw.mib.asl.internal.travellink.TLinkServiceManager;
import de.vw.mib.asl.internal.travellink.list.GenericPropertyUtility;
import de.vw.mib.asl.internal.travellink.main.StateTopMain;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEventException;
import org.dsi.ifc.map.Point;
import org.dsi.ifc.map.Rect;
import org.dsi.ifc.organizer.AdbEntry;
import org.dsi.ifc.travellink.GenericPropertyContainer;

public final class ApiNavigation {
    private boolean serviceReady = false;
    private boolean mapLocked = false;
    private boolean serviceError = false;
    private boolean twoFingerZoomIn = false;
    private boolean isMapLockedRequested = false;
    private int PREVIOUSTWOFINGERDISTANCE_UNKNOWN;
    private int previousTwoFingerDistance = this.PREVIOUSTWOFINGERDISTANCE_UNKNOWN = -1;
    private int viewId = 8;

    public void createServiceMainMap() {
        try {
            int[] nArray = new int[]{1340158720, 1323381504, 1424044800, 1373713152, 1457599232, 1306604288, 1440822016, 1390490368, 1407267584, 1273049856, 1356935936, 1407267584, 1491153664, 1507930880};
            ASLNavigationServices aSLNavigationServices = TLinkServiceManager.getServiceManager().getAslNavigationServices();
            ASLNavigationServiceMainMap aSLNavigationServiceMainMap = null;
            if (null != aSLNavigationServices) {
                aSLNavigationServiceMainMap = aSLNavigationServices.createMainMapService(TLinkServiceManager.getServiceManager().getTargetMain(), nArray);
            }
            if (null != aSLNavigationServiceMainMap) {
                TLinkServiceManager.getServiceManager().setNavigationServiceMainMap(aSLNavigationServiceMainMap);
                if (ServiceManager.logger2.isTraceEnabled(64)) {
                    ServiceManager.logger2.trace(64).append("ApiNavigation: createServiceMainMap() : Navigation main map service available ! ").log();
                }
            } else {
                ServiceManager.logger2.error(64).append("ApiNavigation: createServiceMainMap() : Navigation main map service not available ! So, Main map service is null").log();
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void unlockMapViewer() {
        if (this.isNavigationMainMapServiceReady()) {
            ASLNavigationServiceMainMap aSLNavigationServiceMainMap;
            if (ServiceManager.logger2.isTraceEnabled(64)) {
                ServiceManager.logger2.trace(64).append("ApiNavigation : unlockMapViewer() : call getNavigationServiceMainMap().unlockMapViewer()").log();
            }
            if (null != (aSLNavigationServiceMainMap = TLinkServiceManager.getServiceManager().getNavigationServiceMainMap())) {
                aSLNavigationServiceMainMap.unlockMapViewer();
            }
            this.setMapLocked(false);
        } else {
            try {
                if (!this.isMapLocked()) {
                    throw new ApiNavigationException("Map is not locked!");
                }
            }
            catch (ApiNavigationException apiNavigationException) {
                ServiceManager.errorHandler.handleError(apiNavigationException);
            }
            if (ServiceManager.logger2.isTraceEnabled(64)) {
                ServiceManager.logger2.error(64).append("ApiNavigation : unlockMapViewer() Error : Unlock not called. Check the below navigation service status.").log();
                this.printMainMapServiceStatus();
            }
        }
    }

    public void lockMapViewer() {
        if (ServiceManager.logger2.isTraceEnabled(64)) {
            ServiceManager.logger2.trace(64).append("ApiNavigation : lockMapViewer()").log();
            this.printMainMapServiceStatus();
        }
        if (this.isServiceReady() && !this.isMapLocked()) {
            ASLNavigationServiceMainMap aSLNavigationServiceMainMap = TLinkServiceManager.getServiceManager().getNavigationServiceMainMap();
            if (null != aSLNavigationServiceMainMap) {
                int n = TLinkServiceManager.getServiceManager().getCurrentViewId();
                if (0 == n) {
                    TLinkServiceManager.getServiceManager().getTraffic().setMapLockedRequested(true);
                }
                if (17 == n) {
                    this.setMapLockedRequested(true);
                }
                aSLNavigationServiceMainMap.lockMapViewer();
                if (ServiceManager.logger2.isTraceEnabled(64)) {
                    ServiceManager.logger2.trace(64).append("ApiNavigation : lockMapViewer() : Locking main map service").log();
                }
            }
        } else {
            try {
                if (this.isMapLocked()) {
                    throw new ApiNavigationException("Map is locked!");
                }
            }
            catch (ApiNavigationException apiNavigationException) {
                ServiceManager.errorHandler.handleError(apiNavigationException);
            }
            if (ServiceManager.logger2.isTraceEnabled(64)) {
                ServiceManager.logger2.error(64).append("ApiNavigation : lockMapViewer() : Locking main map service not called. Check the below Navigation service status").log();
                this.printMainMapServiceStatus();
            }
        }
    }

    public ASLNavigationMapConfiguration getInitialMapConfigurationForWeatherMaps() {
        if (ServiceManager.logger2.isTraceEnabled(64)) {
            ServiceManager.logger2.trace(64).append("ApiNavigation : getInitialMapConfigurationForWeatherMaps() :  Getting initial map configurations ").log();
        }
        ASLNavigationMapConfiguration aSLNavigationMapConfiguration = TLinkServiceManager.getServiceManager().getAslNavigationMapConfigurationFullView();
        aSLNavigationMapConfiguration.setMapLayerVisible(1);
        aSLNavigationMapConfiguration.setOrientation(2);
        boolean bl = TLinkServiceManager.getServiceManager().getWeatherGraphical().isCcpButtonEnabled();
        if (bl) {
            aSLNavigationMapConfiguration.setMapMode(2);
        } else {
            aSLNavigationMapConfiguration.setMapMode(1);
        }
        aSLNavigationMapConfiguration.setViewType(0);
        aSLNavigationMapConfiguration.setFlagStyleType(29);
        int n = TLinkServiceManager.getServiceManager().getTravelLinkPersistable().getZoomLevel();
        aSLNavigationMapConfiguration.setZoomLevel(n);
        int n2 = TLinkServiceManager.getServiceManager().getTravelLinkPersistable().getSelectedWeatherMap();
        if (n2 >= 0 && n2 <= 2) {
            if (n2 == 0) {
                aSLNavigationMapConfiguration.setMapLayerVisible(1);
            } else if (n2 == 1) {
                aSLNavigationMapConfiguration.setMapLayerVisible(0);
            } else if (n2 == 2) {
                aSLNavigationMapConfiguration.setMapLayerVisible(2);
            }
        } else if (ServiceManager.logger2.isTraceEnabled(64)) {
            ServiceManager.logger2.error(64).append("ApiNavigation : getInitialMapConfigurationForWeatherMaps() :  Persisted Map layer values not in range").log();
        }
        return aSLNavigationMapConfiguration;
    }

    public ASLNavigationMapConfiguration getInitialMapConfigurationForTrafficMap() {
        ASLNavigationMapConfiguration aSLNavigationMapConfiguration = TLinkServiceManager.getServiceManager().getAslNavigationMapConfigurationTrafficMap();
        aSLNavigationMapConfiguration.setZoomArea(new Rect(0, 0, 800, 400));
        aSLNavigationMapConfiguration.setCarPosition(new Point(400, 240));
        aSLNavigationMapConfiguration.setHotPoint(new Point(400, 240));
        aSLNavigationMapConfiguration.setMapLayerVisible(-1);
        aSLNavigationMapConfiguration.setMapMode(1);
        aSLNavigationMapConfiguration.setZoomLevel(6000);
        aSLNavigationMapConfiguration.setOrientation(2);
        aSLNavigationMapConfiguration.setViewType(0);
        aSLNavigationMapConfiguration.setFlagStyleType(25);
        if (ServiceManager.logger2.isTraceEnabled(64)) {
            ServiceManager.logger2.trace(64).append("ApiNavigation : getInitialMapConfigurationForTrafficMap() :  Getting initial map configurations for traffic map ").log();
        }
        return aSLNavigationMapConfiguration;
    }

    public boolean isRouteGuidanceActive() {
        ASLNavigationServices aSLNavigationServices = TLinkServiceManager.getServiceManager().getAslNavigationServices();
        boolean bl = false;
        if (null != aSLNavigationServices) {
            bl = aSLNavigationServices.isGuidanceActive();
            if (ServiceManager.logger2.isTraceEnabled(64)) {
                ServiceManager.logger2.trace(64).append("ApiNavigation : isRouteGuidanceActive() : ").append(bl).log();
            }
        } else {
            ServiceManager.logger2.error(64).append("ApiNavigation : isRouteGuidanceActive : ASLNavigationServices is null").log();
        }
        return bl;
    }

    public void startGuidance(NavAddress navAddress) {
        try {
            ASLNavigationServices aSLNavigationServices = TLinkServiceManager.getServiceManager().getAslNavigationServices();
            if (null != aSLNavigationServices && null != navAddress) {
                if (ServiceManager.logger2.isTraceEnabled(64)) {
                    ServiceManager.logger2.trace(64).append("ApiNavigation : startGuidance() : Start guidance called successfully : navAddress =").log();
                    ServiceManager.logger2.trace(64).append("name = ").append(navAddress.getName()).append(", state = ").append(navAddress.getState()).append(", zip = ").append(navAddress.getZip()).log();
                    ServiceManager.logger2.trace(64).append("url = ").append(navAddress.getUrl()).append(", phoneNumber = ").append(navAddress.getPhoneNumber()).append(", houseNumber = ").append(navAddress.getHousenumber()).log();
                    ServiceManager.logger2.trace(64).append("country = ").append(navAddress.getCountry()).append(", city = ").append(navAddress.getCity()).append(", crossing = ").append(navAddress.getCrossing()).log();
                    ServiceManager.logger2.trace(64).append("street = ").append(navAddress.getStreet()).append(", longitude = ").append(navAddress.getLongitude()).append(", latitude = ").append(navAddress.getLatitude()).log();
                    ServiceManager.logger2.trace(64).append("latitudeDecimal = ").append(navAddress.getLatitudeDecimal()).append(", longitudeDecimal = ").append(navAddress.getLongitudeDecimal()).log();
                }
                aSLNavigationServices.startGuidance(new NavAddress[]{navAddress}, false, 5);
            } else if (ServiceManager.logger2.isTraceEnabled(64)) {
                ServiceManager.logger2.trace(64).append("ApiNavigation : startGuidance() : Start guidance not called. Because, ASLNavigationServices is not available").log();
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void storeContact(AdbEntry adbEntry) {
        try {
            ASLNavigationServices aSLNavigationServices = TLinkServiceManager.getServiceManager().getAslNavigationServices();
            if (null == aSLNavigationServices) {
                if (ServiceManager.logger2.isTraceEnabled(64)) {
                    ServiceManager.logger2.trace(64).append("ApiNavigation : storeContact() : null == navServices").log();
                }
                return;
            }
            if (aSLNavigationServices.getContactCapacity() > 0) {
                aSLNavigationServices.importContact(adbEntry, 5);
                if (ServiceManager.logger2.isTraceEnabled(64)) {
                    ServiceManager.logger2.trace(64).append("ApiNavigation : storeContact() : Contact stored").log();
                }
            } else if (ServiceManager.logger2.isTraceEnabled(64)) {
                ServiceManager.logger2.error(64).append("ApiNavigation : storeContact() : There is no space available to store the contacts").log();
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public boolean isServiceReady() {
        if (ServiceManager.logger2.isTraceEnabled(64)) {
            ServiceManager.logger2.trace(64).append("ApiNavigation : isServiceReady() = ").append(this.serviceReady).log();
        }
        return this.serviceReady;
    }

    public void setServiceReady(boolean bl) {
        this.serviceReady = bl;
        if (ServiceManager.logger2.isTraceEnabled(64)) {
            ServiceManager.logger2.trace(64).append("ApiNavigation : setServiceReady() : Service ready is set to ").append(bl).log();
        }
    }

    public boolean isMapLocked() {
        if (ServiceManager.logger2.isTraceEnabled(64)) {
            ServiceManager.logger2.trace(64).append("ApiNavigation : isMapLocked() = ").append(this.mapLocked).log();
        }
        return this.mapLocked;
    }

    public void setMapLocked(boolean bl) {
        this.mapLocked = bl;
        if (ServiceManager.logger2.isTraceEnabled(64)) {
            ServiceManager.logger2.trace(64).append("ApiNavigation : setMapLocked() : Map locked is set to ").append(bl).log();
        }
    }

    public boolean isServiceError() {
        return this.serviceError;
    }

    public void setServiceError(boolean bl) {
        this.serviceError = bl;
        if (ServiceManager.logger2.isTraceEnabled(64)) {
            ServiceManager.logger2.trace(64).append("ApiNavigation : setServiceError() : Service error is set to ").append(bl).log();
        }
    }

    public void setInitialMapSettings() {
        int n = this.getViewId();
        if (n == 1 || n == 2 || n == 3) {
            this.setMapConfiguration(this.getInitialMapConfigurationForWeatherMaps());
        } else if (n == 4 || n == 5) {
            this.setMapConfiguration(TLinkServiceManager.getServiceManager().getAslNavigationMapConfigurationWeatherMapSplitView());
        } else if (n == 6 || n == 7) {
            this.setMapConfiguration(TLinkServiceManager.getServiceManager().getAslNavigationMapConfigurationSplitView());
        }
        if (ServiceManager.logger2.isTraceEnabled(64)) {
            ServiceManager.logger2.trace(64).append("ApiNavigation : setInitialMapSettings() for the view with id - ").append(n).log();
        }
    }

    public int getViewId() {
        return this.viewId;
    }

    public void setViewId(int n) {
        this.viewId = n;
        if (ServiceManager.logger2.isTraceEnabled(64)) {
            ServiceManager.logger2.trace(64).append("ApiNavigation : setViewId() :  View id is set to ").append(n).log();
        }
    }

    public void showCCP() {
        ASLNavigationMapConfiguration aSLNavigationMapConfiguration = TLinkServiceManager.getServiceManager().getAslNavigationMapConfigurationFullView();
        int n = TLinkServiceManager.getServiceManager().getTravelLinkPersistable().getZoomLevel();
        aSLNavigationMapConfiguration.setZoomLevel(n);
        aSLNavigationMapConfiguration.setMapMode(1);
        TLinkServiceManager.getServiceManager().getWeatherGraphical().setCcpButtonEnabled(false);
        this.setMapConfiguration(aSLNavigationMapConfiguration);
        if (ServiceManager.logger2.isTraceEnabled(64)) {
            ServiceManager.logger2.trace(64).append("ApiNavigation : showCCP() :  Setting map to centre car position").append(this.viewId).log();
        }
    }

    public void showUsaMap() {
        ASLNavigationMapConfiguration aSLNavigationMapConfiguration = TLinkServiceManager.getServiceManager().getAslNavigationMapConfigurationFullView();
        aSLNavigationMapConfiguration.setZoomLevel(-1071183616);
        aSLNavigationMapConfiguration.setNavLocation(39.828127, -98.579404);
        this.setMapConfiguration(aSLNavigationMapConfiguration);
        if (ServiceManager.logger2.isTraceEnabled(64)) {
            ServiceManager.logger2.trace(64).append("ApiNavigation : showUsaMap() :  Showing the USA map overview !").append(this.viewId).log();
        }
    }

    public void zoomOut() {
        if (this.isNavigationMainMapServiceReady()) {
            ASLNavigationServiceMainMap aSLNavigationServiceMainMap = TLinkServiceManager.getServiceManager().getNavigationServiceMainMap();
            if (null != aSLNavigationServiceMainMap) {
                aSLNavigationServiceMainMap.zoomOut();
            }
            if (ServiceManager.logger2.isTraceEnabled(64)) {
                ServiceManager.logger2.trace(64).append("ApiNavigation : ddsRotateZoomOut() : Zoom out ").log();
            }
        } else {
            TLinkServiceManager.getServiceManager().getGuiControllerWeatherGraphical().updateNavigationLoadingStatus(this.isServiceReady(), this.isServiceError());
            if (ServiceManager.logger2.isTraceEnabled(64)) {
                ServiceManager.logger2.error(64).append("ApiNavigation : ddsRotateZoomOut() : Zoom out not possible. Because of below navigation status  ").log();
            }
            this.printMainMapServiceStatus();
        }
    }

    public void zoomIn() {
        if (this.isNavigationMainMapServiceReady()) {
            int n = TLinkServiceManager.getServiceManager().getCurrentViewId();
            int n2 = TLinkServiceManager.getServiceManager().getWeatherGraphical().getSelectedWeatherMap();
            if (n == 17 || n == 18 || n == 21) {
                TLinkServiceManager.getServiceManager().getWeatherGraphical().setUnblockZoomInForRouteOverview(false);
                if (n2 == 0) {
                    boolean bl = TLinkServiceManager.getServiceManager().getWeatherGraphical().isWeatherIconMapZoomInBlocked();
                    if (bl) {
                        if (ServiceManager.logger2.isTraceEnabled(64)) {
                            ServiceManager.logger2.trace(64).append("ApiNavigation : zoomIn() : Icon map Zoom in blocked ").log();
                        }
                    } else {
                        ASLNavigationServiceMainMap aSLNavigationServiceMainMap = TLinkServiceManager.getServiceManager().getNavigationServiceMainMap();
                        if (null != aSLNavigationServiceMainMap) {
                            aSLNavigationServiceMainMap.zoomIn();
                        }
                    }
                } else if (n2 == 2) {
                    boolean bl = TLinkServiceManager.getServiceManager().getWeatherGraphical().isWeatherIsobarMapZoomInBlocked();
                    if (bl) {
                        if (ServiceManager.logger2.isTraceEnabled(64)) {
                            ServiceManager.logger2.trace(64).append("ApiNavigation : zoomIn() : Isobar map Zoom in blocked ").log();
                        }
                    } else {
                        ASLNavigationServiceMainMap aSLNavigationServiceMainMap = TLinkServiceManager.getServiceManager().getNavigationServiceMainMap();
                        if (null != aSLNavigationServiceMainMap) {
                            aSLNavigationServiceMainMap.zoomIn();
                        }
                    }
                } else if (n2 == 1) {
                    boolean bl = TLinkServiceManager.getServiceManager().getWeatherGraphical().isWeatherRadarMapZoomInBlocked();
                    if (bl) {
                        if (ServiceManager.logger2.isTraceEnabled(64)) {
                            ServiceManager.logger2.trace(64).append("ApiNavigation : zoomIn() : Radar map Zoom in blocked ").log();
                        }
                    } else {
                        ASLNavigationServiceMainMap aSLNavigationServiceMainMap = TLinkServiceManager.getServiceManager().getNavigationServiceMainMap();
                        if (null != aSLNavigationServiceMainMap) {
                            aSLNavigationServiceMainMap.zoomIn();
                        }
                    }
                }
            } else {
                ASLNavigationServiceMainMap aSLNavigationServiceMainMap = TLinkServiceManager.getServiceManager().getNavigationServiceMainMap();
                if (null != aSLNavigationServiceMainMap) {
                    aSLNavigationServiceMainMap.zoomIn();
                }
                if (ServiceManager.logger2.isTraceEnabled(64)) {
                    ServiceManager.logger2.trace(64).append("ApiNavigation : zoomIn() : For Movie and Fuel details view ").log();
                }
            }
            if (ServiceManager.logger2.isTraceEnabled(64)) {
                ServiceManager.logger2.trace(64).append("ApiNavigation : zoomIn() : Zoom in ").log();
            }
        } else {
            TLinkServiceManager.getServiceManager().getGuiControllerWeatherGraphical().updateNavigationLoadingStatus(this.isServiceReady(), this.isServiceError());
            if (ServiceManager.logger2.isTraceEnabled(64)) {
                ServiceManager.logger2.error(64).append("ApiNavigation : zoomIn() :  Zoom in not possible. Because of below navigation status  ").log();
            }
            this.printMainMapServiceStatus();
        }
    }

    public void setMapConfiguration(ASLNavigationMapConfiguration aSLNavigationMapConfiguration) {
        try {
            ASLNavigationServiceMainMap aSLNavigationServiceMainMap;
            if (ServiceManager.logger2.isTraceEnabled(64)) {
                ServiceManager.logger2.trace(64).append("ApiNavigation : setMapConfiguration()").log();
            }
            if (null != (aSLNavigationServiceMainMap = TLinkServiceManager.getServiceManager().getNavigationServiceMainMap()) && null != aSLNavigationMapConfiguration) {
                int n = TLinkServiceManager.getServiceManager().getCurrentViewId();
                if (this.isNavigationMainMapServiceReady()) {
                    if (n == 0) {
                        aSLNavigationServiceMainMap.setTrafficIncidents(true);
                    } else {
                        aSLNavigationServiceMainMap.setTrafficIncidents(false);
                    }
                    if (ServiceManager.logger2.isTraceEnabled(64)) {
                        ServiceManager.logger2.trace(64).append("ApiNavigation : setMapConfiguration() : goToLocation()").log();
                        ServiceManager.logger2.trace(64).append(aSLNavigationMapConfiguration.toString()).log();
                    }
                    aSLNavigationServiceMainMap.goToLocation(aSLNavigationMapConfiguration);
                    if (ServiceManager.logger2.isTraceEnabled(64)) {
                        ServiceManager.logger2.trace(64).append("ApiNavigation : setMapConfiguration() : Map configuration changed. Navigation interface goToLocation() called : ").append(aSLNavigationMapConfiguration.toString()).log();
                    }
                } else {
                    TLinkServiceManager.getServiceManager().getGuiControllerWeatherGraphical().updateNavigationLoadingStatus(this.isServiceReady(), this.isServiceError());
                    if (ServiceManager.logger2.isTraceEnabled(64)) {
                        ServiceManager.logger2.error(64).append("ApiNavigation : setMapConfiguration() : Map configuration not changed. Check navigation service status ").log();
                    }
                    this.printMainMapServiceStatus();
                }
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void setMapContent(EventGeneric eventGeneric) {
        try {
            int n = eventGeneric.getInt(0);
            this.setViewId(n);
            int n2 = eventGeneric.getInt(1);
            int n3 = eventGeneric.getInt(2);
            int n4 = eventGeneric.getInt(3);
            int n5 = eventGeneric.getInt(4);
            if (ServiceManager.logger2.isTraceEnabled(64)) {
                ServiceManager.logger2.trace(64).append("ApiNavigation : setMapContent() : view id is ").append(n).append("Position x is ").append(n2).append("Position y is ").append(n3).append("Width is ").append(n5).append("Height is ").append(n4).log();
            }
            if (n == 1 || n == 2 || n == 3) {
                ASLNavigationMapConfiguration aSLNavigationMapConfiguration = TLinkServiceManager.getServiceManager().getAslNavigationMapConfigurationFullView();
                aSLNavigationMapConfiguration.setZoomArea(new Rect(n2, n3, n5, n4));
            } else if (n == 4 || n == 5) {
                ASLNavigationMapConfiguration aSLNavigationMapConfiguration = TLinkServiceManager.getServiceManager().getAslNavigationMapConfigurationWeatherMapSplitView();
                aSLNavigationMapConfiguration.setZoomArea(new Rect(n2, n3, n5, n4));
                int n6 = TLinkServiceManager.getServiceManager().getTravelLinkPersistable().getSelectedWeatherMap();
                if (n6 >= 0 && n6 <= 2) {
                    if (n6 == 0) {
                        aSLNavigationMapConfiguration.setMapLayerVisible(1);
                    } else if (n6 == 1) {
                        aSLNavigationMapConfiguration.setMapLayerVisible(0);
                    } else if (n6 == 2) {
                        aSLNavigationMapConfiguration.setMapLayerVisible(2);
                    }
                } else if (ServiceManager.logger2.isTraceEnabled(64)) {
                    ServiceManager.logger2.error(64).append("ApiNavigation : getInitialMapConfigurationForWeatherMaps() :  Persisted Map layer values not in range").log();
                }
            } else if (n == 6 || n == 7) {
                ASLNavigationMapConfiguration aSLNavigationMapConfiguration = TLinkServiceManager.getServiceManager().getAslNavigationMapConfigurationSplitView();
                aSLNavigationMapConfiguration.setZoomArea(new Rect(n2, n3, n5, n4));
                if (n == 6) {
                    this.setMovieTheaterNavLocation(aSLNavigationMapConfiguration);
                } else if (n == 7) {
                    this.setFuelStationNavLocation(aSLNavigationMapConfiguration);
                }
            }
        }
        catch (GenericEventException genericEventException) {
            ServiceManager.errorHandler.handleError(genericEventException);
        }
    }

    public void setMovieTheaterNavLocation(ASLNavigationMapConfiguration aSLNavigationMapConfiguration) {
        if (null == aSLNavigationMapConfiguration) {
            ServiceManager.logger2.error(64).append("ApiNavigation : setMovieTheaterNavLocation() - null == aslNavigationMapConfigurationSplitView").log();
            return;
        }
        if (ServiceManager.logger2.isTraceEnabled(64)) {
            ServiceManager.logger2.trace(64).append("ApiNavigation : setMovieTheaterNavLocation()").log();
        }
        GenericPropertyContainer genericPropertyContainer = null;
        genericPropertyContainer = StateTopMain.isMoviesContextActive ? TLinkServiceManager.getServiceManager().getMovies().getSelectedMovieTheater() : TLinkServiceManager.getServiceManager().getMovieTheaters().getSelectedTheaterForMovieTheaters();
        if (null != genericPropertyContainer) {
            double d2 = GenericPropertyUtility.getDouble(226951424, 0, genericPropertyContainer);
            double d3 = GenericPropertyUtility.getDouble(243728640, 0, genericPropertyContainer);
            if (ServiceManager.logger2.isTraceEnabled(64)) {
                ServiceManager.logger2.trace(64).append("ApiNavigation : setMovieTheaterNavLocation() - latitude = ").append(d2).append(", longitude = ").append(d3).log();
            }
            aSLNavigationMapConfiguration.setNavLocation(d2, d3);
        } else {
            if (ServiceManager.logger2.isTraceEnabled(64)) {
                ServiceManager.logger2.trace(64).append("ApiNavigation : setMovieTheaterNavLocation() - null == selectedTheater").log();
            }
            aSLNavigationMapConfiguration.setNavLocation(0.0, 0.0);
        }
    }

    public void setFuelStationNavLocation(ASLNavigationMapConfiguration aSLNavigationMapConfiguration) {
        GenericPropertyContainer genericPropertyContainer;
        if (null == aSLNavigationMapConfiguration) {
            ServiceManager.logger2.error(64).append("ApiNavigation : setFuelStationNavLocation() - null == aslNavigationMapConfigurationSplitView").log();
            return;
        }
        if (ServiceManager.logger2.isTraceEnabled(64)) {
            ServiceManager.logger2.trace(64).append("ApiNavigation : setFuelStationNavLocation()").log();
        }
        if (null != (genericPropertyContainer = TLinkServiceManager.getServiceManager().getFuel().getSelectedFuelStation())) {
            double d2 = GenericPropertyUtility.getDouble(681641728, 0, genericPropertyContainer);
            double d3 = GenericPropertyUtility.getDouble(698418944, 0, genericPropertyContainer);
            aSLNavigationMapConfiguration.setNavLocation(d2, d3);
        } else {
            aSLNavigationMapConfiguration.setNavLocation(0.0, 0.0);
        }
    }

    public void pinchWithTwoFingure(EventGeneric eventGeneric) {
        try {
            int n = eventGeneric.getInt(0);
            int n2 = eventGeneric.getInt(1);
            int n3 = eventGeneric.getInt(2);
            int n4 = eventGeneric.getInt(3);
            if (this.previousTwoFingerDistance < n4) {
                this.twoFingerZoomIn = true;
                TLinkServiceManager.getServiceManager().getWeatherGraphical().setUnblockZoomInForRouteOverview(false);
                if (ServiceManager.logger2.isTraceEnabled(64)) {
                    ServiceManager.logger2.trace(64).append("ApiNavigation : pinchWithTwoFingure() : twoFingerZoomIn set to true ").log();
                }
            } else {
                this.twoFingerZoomIn = false;
                if (ServiceManager.logger2.isTraceEnabled(64)) {
                    ServiceManager.logger2.trace(64).append("ApiNavigation : pinchWithTwoFingure() : twoFingerZoomIn set to false ").log();
                }
            }
            if (this.isNavigationMainMapServiceReady()) {
                if (this.twoFingerZoomIn) {
                    if (ServiceManager.logger2.isTraceEnabled(64)) {
                        ServiceManager.logger2.trace(64).append("ApiNavigation : pinchWithTwoFingure() : twoFingerZoomIn is true ").log();
                    }
                    int n5 = TLinkServiceManager.getServiceManager().getCurrentViewId();
                    int n6 = TLinkServiceManager.getServiceManager().getWeatherGraphical().getSelectedWeatherMap();
                    if (n5 == 17) {
                        if (n6 == 0) {
                            boolean bl = TLinkServiceManager.getServiceManager().getWeatherGraphical().isWeatherIconMapZoomInBlocked();
                            if (!bl) {
                                ASLNavigationServiceMainMap aSLNavigationServiceMainMap = TLinkServiceManager.getServiceManager().getNavigationServiceMainMap();
                                if (null != aSLNavigationServiceMainMap) {
                                    aSLNavigationServiceMainMap.zoomTwoFingers(n, n2, n3, n4);
                                }
                            } else if (ServiceManager.logger2.isTraceEnabled(64)) {
                                ServiceManager.logger2.trace(64).append("ApiNavigation : pinchWithTwoFingure() : Icon map Two finger Zoom in blocked ").log();
                            }
                        } else if (n6 == 2) {
                            boolean bl = TLinkServiceManager.getServiceManager().getWeatherGraphical().isWeatherIsobarMapZoomInBlocked();
                            if (!bl) {
                                ASLNavigationServiceMainMap aSLNavigationServiceMainMap = TLinkServiceManager.getServiceManager().getNavigationServiceMainMap();
                                if (null != aSLNavigationServiceMainMap) {
                                    aSLNavigationServiceMainMap.zoomTwoFingers(n, n2, n3, n4);
                                }
                            } else if (ServiceManager.logger2.isTraceEnabled(64)) {
                                ServiceManager.logger2.trace(64).append("ApiNavigation : pinchWithTwoFingure() : Isobar map  Two finger Zoom in blocked ").log();
                            }
                        } else if (n6 == 1) {
                            boolean bl = TLinkServiceManager.getServiceManager().getWeatherGraphical().isWeatherRadarMapZoomInBlocked();
                            if (!bl) {
                                ASLNavigationServiceMainMap aSLNavigationServiceMainMap = TLinkServiceManager.getServiceManager().getNavigationServiceMainMap();
                                if (null != aSLNavigationServiceMainMap) {
                                    aSLNavigationServiceMainMap.zoomTwoFingers(n, n2, n3, n4);
                                }
                            } else if (ServiceManager.logger2.isTraceEnabled(64)) {
                                ServiceManager.logger2.trace(64).append("ApiNavigation : pinchWithTwoFingure() : Radar map  Two finger Zoom in blocked ").log();
                            }
                        }
                    }
                } else if (this.previousTwoFingerDistance == n4) {
                    if (ServiceManager.logger2.isTraceEnabled(64)) {
                        ServiceManager.logger2.trace(64).append("ApiNavigation : pinchWithTwoFingure() : Previoous distance and current distance are equal. So, ZoomTwoFingers are not called. ").log();
                    }
                } else {
                    ASLNavigationServiceMainMap aSLNavigationServiceMainMap = TLinkServiceManager.getServiceManager().getNavigationServiceMainMap();
                    if (null != aSLNavigationServiceMainMap) {
                        aSLNavigationServiceMainMap.zoomTwoFingers(n, n2, n3, n4);
                    }
                    if (ServiceManager.logger2.isTraceEnabled(64)) {
                        ServiceManager.logger2.trace(64).append("ApiNavigation : pinchWithTwoFingure() : Previoous distance and current distance are NOT equal ").log();
                    }
                }
                this.previousTwoFingerDistance = n4;
                if (ServiceManager.logger2.isTraceEnabled(64)) {
                    ServiceManager.logger2.trace(64).append("ApiNavigation : pinchWithTwoFingure() : ").append("X is ").append(n).append("Y is ").append(n2).append("zDelta is ").append(n3).append("zDistance is ").append(n4).log();
                }
            } else {
                TLinkServiceManager.getServiceManager().getGuiControllerWeatherGraphical().updateNavigationLoadingStatus(this.isServiceReady(), this.isServiceError());
                if (ServiceManager.logger2.isTraceEnabled(64)) {
                    ServiceManager.logger2.error(64).append("ApiNavigation : pinchWithTwoFingure() : Two figure zoom not possible. Check navigation service status ").log();
                }
                this.printMainMapServiceStatus();
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void showRouteOverview() {
        TLinkServiceManager.getServiceManager().getWeatherGraphical().setUnblockZoomInForRouteOverview(true);
        ASLNavigationMapConfiguration aSLNavigationMapConfiguration = TLinkServiceManager.getServiceManager().getAslNavigationMapConfigurationFullView();
        ASLNavigationMapConfiguration aSLNavigationMapConfiguration2 = new ASLNavigationMapConfiguration();
        aSLNavigationMapConfiguration2.setPerspective(3);
        this.setMapConfiguration(aSLNavigationMapConfiguration2);
        if (ServiceManager.logger2.isTraceEnabled(64)) {
            ServiceManager.logger2.trace(64).append("ApiNavigation : showRouteOverview() : Map set to route overview ").log();
        }
    }

    public void clickInMap(Point point) {
        if (null != point) {
            if (this.isNavigationMainMapServiceReady()) {
                ASLNavigationServiceMainMap aSLNavigationServiceMainMap = TLinkServiceManager.getServiceManager().getNavigationServiceMainMap();
                if (null != aSLNavigationServiceMainMap) {
                    aSLNavigationServiceMainMap.clickInMap(point);
                }
                if (ServiceManager.logger2.isTraceEnabled(64)) {
                    ServiceManager.logger2.trace(64).append("ApiNavigation : clickInMap() : X = ").append(point.xPos).append(", Y = ").append(point.yPos).log();
                }
            } else {
                TLinkServiceManager.getServiceManager().getGuiControllerWeatherGraphical().updateNavigationLoadingStatus(this.isServiceReady(), this.isServiceError());
                if (ServiceManager.logger2.isTraceEnabled(64)) {
                    ServiceManager.logger2.error(64).append("ApiNavigation : clickInMap() : Not clicked. Check the below navigation service status ").log();
                }
                this.printMainMapServiceStatus();
            }
        }
    }

    public void dragMap(short s, short s2) {
        if (this.isNavigationMainMapServiceReady()) {
            ASLNavigationServiceMainMap aSLNavigationServiceMainMap = TLinkServiceManager.getServiceManager().getNavigationServiceMainMap();
            if (null != aSLNavigationServiceMainMap) {
                aSLNavigationServiceMainMap.dragMap(s, s2);
            }
            if (ServiceManager.logger2.isTraceEnabled(64)) {
                ServiceManager.logger2.trace(64).append("ApiNavigation : dragMap() : X is ").append(s).append("Y is ").append(s2).log();
            }
        } else {
            TLinkServiceManager.getServiceManager().getGuiControllerWeatherGraphical().updateNavigationLoadingStatus(this.isServiceReady(), this.isServiceError());
            if (ServiceManager.logger2.isTraceEnabled(64)) {
                ServiceManager.logger2.error(64).append("ApiNavigation : dragMap() : Not dragged. Check the below navigation service status ").log();
            }
            this.printMainMapServiceStatus();
        }
    }

    public void dragStop() {
        if (this.isNavigationMainMapServiceReady()) {
            ASLNavigationServiceMainMap aSLNavigationServiceMainMap = TLinkServiceManager.getServiceManager().getNavigationServiceMainMap();
            if (null != aSLNavigationServiceMainMap) {
                aSLNavigationServiceMainMap.dragMapStop();
            }
            if (ServiceManager.logger2.isTraceEnabled(64)) {
                ServiceManager.logger2.trace(64).append("ApiNavigation : dragStop() : Dragging stopped ").log();
            }
        } else {
            TLinkServiceManager.getServiceManager().getGuiControllerWeatherGraphical().updateNavigationLoadingStatus(this.isServiceReady(), this.isServiceError());
            if (ServiceManager.logger2.isTraceEnabled(64)) {
                ServiceManager.logger2.error(64).append("ApiNavigation : dragStop() : Dragging stopp not called. Check navigation service status ").log();
            }
            this.printMainMapServiceStatus();
        }
    }

    public void twoFingerZoomStop() {
        if (this.isNavigationMainMapServiceReady()) {
            ASLNavigationServiceMainMap aSLNavigationServiceMainMap = TLinkServiceManager.getServiceManager().getNavigationServiceMainMap();
            if (null != aSLNavigationServiceMainMap) {
                aSLNavigationServiceMainMap.zoomTwoFingersStop();
            }
            if (ServiceManager.logger2.isTraceEnabled(64)) {
                ServiceManager.logger2.trace(64).append("ApiNavigation : twoFingerZoomStop() : Two finger zoom stopped ").log();
            }
        } else {
            TLinkServiceManager.getServiceManager().getGuiControllerWeatherGraphical().updateNavigationLoadingStatus(this.isServiceReady(), this.isServiceError());
            if (ServiceManager.logger2.isTraceEnabled(64)) {
                ServiceManager.logger2.error(64).append("ApiNavigation : twoFingerZoomStop() : Two finger zoom stop not called. Check navigation service status ").log();
            }
            this.printMainMapServiceStatus();
        }
    }

    public void ddsRotate(EventGeneric eventGeneric) {
        block11: {
            if (ServiceManager.logger2.isTraceEnabled(64)) {
                ServiceManager.logger2.trace(64).append("ApiNavigation : ddsRotate()").log();
            }
            if (this.isNavigationMainMapServiceReady()) {
                try {
                    int n = eventGeneric.getInt(1);
                    if (n != 30) break block11;
                    int n2 = eventGeneric.getInt(0);
                    if (n2 > 0) {
                        TLinkServiceManager.getServiceManager().getApiNavigation().zoomOut();
                        if (ServiceManager.logger2.isTraceEnabled(64)) {
                            ServiceManager.logger2.trace(64).append("DDS rotated right").log();
                        }
                    } else if (n2 < 0) {
                        TLinkServiceManager.getServiceManager().getApiNavigation().zoomIn();
                        if (ServiceManager.logger2.isTraceEnabled(64)) {
                            ServiceManager.logger2.warn(64).append("DDS rotated left").log();
                        }
                    }
                }
                catch (GenericEventException genericEventException) {
                    ServiceManager.errorHandler.handleError(genericEventException);
                }
            } else {
                TLinkServiceManager.getServiceManager().getGuiControllerWeatherGraphical().updateNavigationLoadingStatus(this.isServiceReady(), this.isServiceError());
                if (ServiceManager.logger2.isTraceEnabled(64)) {
                    ServiceManager.logger2.error(64).append("ApiNavigation : ddsRotate() : DDS rotate not called. Check navigation service status ").log();
                }
                this.printMainMapServiceStatus();
            }
        }
    }

    public void printMainMapServiceStatus() {
        if (ServiceManager.logger2.isTraceEnabled(64)) {
            if (this.isServiceError()) {
                ServiceManager.logger2.error(64).append("Navigation Service is in error").log();
            } else {
                ServiceManager.logger2.trace(64).append("No error in navigation service").log();
            }
            if (this.isServiceReady()) {
                ServiceManager.logger2.trace(64).append("Navigation service is ready").log();
            } else {
                ServiceManager.logger2.warn(64).append("Navigation service is not ready").log();
            }
            if (this.isMapLocked()) {
                ServiceManager.logger2.trace(64).append("Map is locked").log();
            } else {
                ServiceManager.logger2.warn(64).append("Map is not locked").log();
            }
        }
    }

    public boolean isNavigationMainMapServiceReady() {
        ASLNavigationServiceMainMap aSLNavigationServiceMainMap = TLinkServiceManager.getServiceManager().getNavigationServiceMainMap();
        if (this.isServiceReady() && this.isMapLocked() && null != aSLNavigationServiceMainMap) {
            if (ServiceManager.logger2.isTraceEnabled(64)) {
                ServiceManager.logger2.trace(64).append("ApiNavigation : isNavigationMainMapServiceReady() = true").log();
            }
            return true;
        }
        if (ServiceManager.logger2.isTraceEnabled(64)) {
            ServiceManager.logger2.trace(64).append("ApiNavigation : isNavigationMainMapServiceReady() = false").log();
        }
        return false;
    }

    public NavAddress getCurrentCarPosition() {
        ASLNavigationServices aSLNavigationServices;
        if (ServiceManager.logger2.isTraceEnabled(64)) {
            ServiceManager.logger2.trace(64).append("ApiNavigation : getCurrentCarPosition()").log();
        }
        if (null != (aSLNavigationServices = TLinkServiceManager.getServiceManager().getAslNavigationServices())) {
            NavAddress navAddress = aSLNavigationServices.getCurrentCarPosition();
            if (null != navAddress) {
                if (ServiceManager.logger2.isTraceEnabled(64)) {
                    ServiceManager.logger2.trace(64).append("City = ").append(navAddress.getCity()).append(" , Street = ").append(navAddress.getStreet()).append(" , HouseNumber = ").append(navAddress.getHousenumber()).append(" , PhoneNumber = ").append(navAddress.getPhoneNumber()).append(" , Zip = ").append(navAddress.getZip()).append(" , Country = ").append(navAddress.getCountry()).log();
                }
                return navAddress;
            }
            ServiceManager.logger2.error(64).append("ApiNavigation : getCurrentCarPosition : navAddress is null").log();
            return null;
        }
        ServiceManager.logger2.error(64).append("ApiNavigation : getCurrentCarPosition : ASLNavigationServices is null").log();
        return null;
    }

    public GuidanceInfo[] getGuidanceInfo() {
        ASLNavigationServices aSLNavigationServices;
        if (ServiceManager.logger2.isTraceEnabled(64)) {
            ServiceManager.logger2.trace(64).append("ApiNavigation : getGuidanceInfo()").log();
        }
        if (null != (aSLNavigationServices = TLinkServiceManager.getServiceManager().getAslNavigationServices())) {
            GuidanceInfo[] guidanceInfoArray = aSLNavigationServices.getGuidanceInfo();
            if (null != guidanceInfoArray) {
                if (ServiceManager.logger2.isTraceEnabled(64)) {
                    ServiceManager.logger2.trace(64).append("City = ").append(guidanceInfoArray[1].getAddress().getCity()).append(" , Street = ").append(guidanceInfoArray[1].getAddress().getStreet()).append(" , HouseNumber = ").append(guidanceInfoArray[1].getAddress().getHousenumber()).append(" , PhoneNumber = ").append(guidanceInfoArray[1].getAddress().getPhoneNumber()).append(" , Zip = ").append(guidanceInfoArray[1].getAddress().getZip()).append(" , Country = ").append(guidanceInfoArray[1].getAddress().getCountry()).log();
                }
                return guidanceInfoArray;
            }
            ServiceManager.logger2.error(64).append("ApiNavigation : getGuidanceInfo : guidanceInfo is null  ").log();
            return null;
        }
        ServiceManager.logger2.error(64).append("ApiNavigation : getGuidanceInfo : ASLNavigationServices is null  ").log();
        return null;
    }

    public boolean isMapLockedRequested() {
        return this.isMapLockedRequested;
    }

    public void setMapLockedRequested(boolean bl) {
        this.isMapLockedRequested = bl;
    }
}

