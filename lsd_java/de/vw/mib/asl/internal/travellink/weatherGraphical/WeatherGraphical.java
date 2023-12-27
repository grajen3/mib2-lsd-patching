/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.travellink.weatherGraphical;

import de.vw.mib.asl.api.navigation.map.ASLNavigationMapConfiguration;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.travellink.DataProcessor;
import de.vw.mib.asl.internal.travellink.TLinkServiceManager;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEventException;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.NavLocationWgs84;
import org.dsi.ifc.map.Point;
import org.dsi.ifc.map.PosInfo;
import org.dsi.ifc.travellink.GenericPropertyContainer;

public final class WeatherGraphical
implements DataProcessor {
    private boolean dragged = false;
    private boolean twoFingureZoom = false;
    private boolean ccpButtonEnabled = false;
    public static final int ZOOMLEVEL_USAMAP;
    public static final int ZOOM_LEVEL_FOR_TRAFFIC_MAP;
    public static final int MINIMUM_ZOOM_LEVEL_FOR_WEATHERMAPS_ICON;
    public static final int MINIMUM_ZOOM_LEVEL_FOR_WEATHERMAPS_ISOBAR;
    public static final int MINIMUM_ZOOM_LEVEL_FOR_WEATHERMAPS_RADAR;
    public boolean reachedMinimumZoomLevelWeatherMaps = false;
    public static final double CENTER_MAP_USA_LATITUDE;
    public static final double CENTER_MAP_USA_LONGITUDE;
    public static final int SELECTED_WEATHER_MAP;
    private int selectedWeatherMap = -1;
    private boolean weatherIconMapZoomInBlocked = false;
    private boolean weatherIsobarMapZoomInBlocked = false;
    private boolean weatherRadarMapZoomInBlocked = false;
    private boolean unblockZoomInForRouteOverview = false;

    @Override
    public void processAndUpdate(int n, GenericPropertyContainer[] genericPropertyContainerArray, int n2, int n3) {
        switch (n) {
            case 39: {
                if (n2 == 1 || n2 == 0 || n2 == 2) {
                    TLinkServiceManager.getServiceManager().getGuiControllerWeatherGraphical().prepareAndUpdateDataForStorm(genericPropertyContainerArray);
                    break;
                }
                if (!ServiceManager.logger2.isTraceEnabled(64)) break;
                ServiceManager.logger2.error(64).append("WeatherGraphical : processAndUpdate : Unexpected update status with updatedstatus id --> ").append(n2).log();
                break;
            }
            default: {
                if (!ServiceManager.logger2.isTraceEnabled(64)) break;
                ServiceManager.logger2.error(64).append("WeatherGraphical : processAndUpdate : RequestType is not handled. RequestTypeID --> ").append(n).log();
            }
        }
    }

    public void setSelectedWeatherMap(EventGeneric eventGeneric) {
        try {
            int n = eventGeneric.getInt(0);
            this.setSelectedGraphicalWeatherMap(n);
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void setSelectedGraphicalWeatherMap(int n) {
        try {
            TLinkServiceManager.getServiceManager().getTravelLinkPersistable().setSelectedWeatherMap(n);
            TLinkServiceManager.getServiceManager().getWeatherGraphical().setSelectedWeatherMap(n);
            TLinkServiceManager.getServiceManager().getGuiControllerWeatherGraphical().setSelectedWeatherMap(n);
            if (n >= 0 && n <= 2) {
                ASLNavigationMapConfiguration aSLNavigationMapConfiguration = TLinkServiceManager.getServiceManager().getApiNavigation().getInitialMapConfigurationForWeatherMaps();
                if (null != aSLNavigationMapConfiguration) {
                    if (n == 0) {
                        aSLNavigationMapConfiguration.setMapLayerVisible(1);
                    } else if (n == 1) {
                        aSLNavigationMapConfiguration.setMapLayerVisible(0);
                    } else if (n == 2) {
                        aSLNavigationMapConfiguration.setMapLayerVisible(2);
                    }
                    TLinkServiceManager.getServiceManager().getApiNavigation().setMapConfiguration(aSLNavigationMapConfiguration);
                }
            } else if (ServiceManager.logger2.isTraceEnabled(64)) {
                ServiceManager.logger2.error(64).append("The map layer received from GUI is not in range").log();
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void updateMapPosition(EventGeneric eventGeneric) {
        try {
            NavLocationWgs84 navLocationWgs84 = (NavLocationWgs84)eventGeneric.getObject(0);
            if (navLocationWgs84 != null) {
                ASLNavigationMapConfiguration aSLNavigationMapConfiguration = TLinkServiceManager.getServiceManager().getAslNavigationMapConfigurationFullView();
                NavLocation navLocation = aSLNavigationMapConfiguration.getNavLocation();
                if (navLocation == null) {
                    navLocation = new NavLocation();
                }
                navLocation.latitude = navLocationWgs84.getLatitude();
                navLocation.longitude = navLocationWgs84.getLongitude();
                aSLNavigationMapConfiguration.setNavLocation(navLocation);
                if (ServiceManager.logger2.isTraceEnabled(64)) {
                    ServiceManager.logger2.trace(64).append("WeatherGraphical : updateMapPosition() : Latitude = ").append(navLocation.latitude).append(", Longitude = ").append(navLocation.longitude).log();
                }
            } else if (ServiceManager.logger2.isTraceEnabled(64)) {
                ServiceManager.logger2.error(64).append("WeatherGraphical : updateMapPosition() : NavLocation is null").log();
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void setWeatherMapModeToFreeMapAndDefaultPerspective() {
        try {
            int n = TLinkServiceManager.getServiceManager().getCurrentViewId();
            if (17 == n) {
                boolean bl = false;
                ASLNavigationMapConfiguration aSLNavigationMapConfiguration = TLinkServiceManager.getServiceManager().getAslNavigationMapConfigurationFullView();
                if (aSLNavigationMapConfiguration.getMapMode() != 2) {
                    aSLNavigationMapConfiguration.setMapMode(2);
                    bl = true;
                }
                if (aSLNavigationMapConfiguration.getPerspective() != -1) {
                    aSLNavigationMapConfiguration.setPerspective(-1);
                    bl = true;
                }
                if (bl) {
                    TLinkServiceManager.getServiceManager().getApiNavigation().setMapConfiguration(aSLNavigationMapConfiguration);
                    bl = false;
                }
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void updateMapPointInfo(EventGeneric eventGeneric) {
        try {
            PosInfo[] posInfoArray = (PosInfo[])eventGeneric.getObject(0);
            if (posInfoArray != null) {
                if (posInfoArray.length > 0 && null != posInfoArray[0]) {
                    int n;
                    NavLocation navLocation = posInfoArray[0].getTLocation();
                    if (null == navLocation) {
                        ServiceManager.logger2.error(64).append("WeatherGraphical - updateMapPointInfo() - navLocation is null").log();
                        return;
                    }
                    long l = posInfoArray[0].getObjectId();
                    ASLNavigationMapConfiguration aSLNavigationMapConfiguration = TLinkServiceManager.getServiceManager().getAslNavigationMapConfigurationWeatherMapSplitView();
                    if (null == aSLNavigationMapConfiguration) {
                        ServiceManager.logger2.error(64).append("WeatherGraphical - updateMapPointInfo() - aslNavigationMapConfiguration is null").log();
                        return;
                    }
                    NavLocation navLocation2 = new NavLocation();
                    navLocation2.latitude = navLocation.getLatitude();
                    navLocation2.longitude = navLocation.getLongitude();
                    aSLNavigationMapConfiguration.setNavLocation(navLocation2);
                    if (ServiceManager.logger2.isTraceEnabled(64)) {
                        ServiceManager.logger2.trace(64).append("WeatherGraphical - updateMapPointInfo() - latitude = ").append(navLocation2.latitude).append(", longitude = ").append(navLocation2.longitude).log();
                    }
                    if ((n = posInfoArray[0].getEInfoType()) == 17) {
                        ServiceManager.aslPropertyManager.valueChangedInteger(-1304485120, 0);
                        ServiceManager.eventDispatcher.createAndSubmitHMIEvent(2118066944);
                        boolean bl = false;
                        TLinkServiceManager.getServiceManager().getDsiTravelLinkWeatherAdapter().requestWeatherForecast(l, false, false);
                        TLinkServiceManager.getServiceManager().getWeather().setSelectedWeatherStationId(l);
                    } else if (n == 18) {
                        boolean bl = false;
                        ServiceManager.aslPropertyManager.valueChangedInteger(-1304485120, 1);
                        ServiceManager.eventDispatcher.createAndSubmitHMIEvent(2118066944);
                        TLinkServiceManager.getServiceManager().getDsiTravelLinkSkiAdapter().requestSkiCondition(l, false);
                        TLinkServiceManager.getServiceManager().getSki().setSkiStationId(l);
                    } else if (n == 19) {
                        if (ServiceManager.logger2.isTraceEnabled(64)) {
                            ServiceManager.logger2.info(64).append("WeatherGraphical - updateMapPointInfo() - positionType == DSIMapViewerControl.POSITIONINFOTYPE_SDARS_STORMINFO").log();
                        }
                        TLinkServiceManager.getServiceManager().getDsiTravelLinkWeatherGraphicalAdapter().requestStormInformation((int)l);
                        ServiceManager.eventDispatcher.createAndSubmitHMIEvent(2017403648);
                    } else if (ServiceManager.logger2.isTraceEnabled(64)) {
                        ServiceManager.logger2.trace(64).append("PosInfo (id ").append(n).append(" ) is not handled by travellink").log();
                    }
                }
            } else if (ServiceManager.logger2.isTraceEnabled(64)) {
                ServiceManager.logger2.trace(64).append("posInfoArray is null").log();
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void clickInMap(EventGeneric eventGeneric) {
        try {
            int n = eventGeneric.getInt(0);
            Point point = new Point();
            point.xPos = eventGeneric.getInt(1);
            point.yPos = eventGeneric.getInt(2);
            switch (n) {
                case 0: {
                    break;
                }
                case 1: {
                    this.dragged = true;
                    TLinkServiceManager.getServiceManager().getApiNavigation().dragMap((short)point.xPos, (short)point.yPos);
                    if (this.isCcpButtonEnabled()) break;
                    this.setCcpButtonEnabled(true);
                    break;
                }
                case 2: {
                    if (this.dragged) {
                        TLinkServiceManager.getServiceManager().getApiNavigation().dragStop();
                        this.dragged = false;
                    }
                    if (!this.twoFingureZoom) break;
                    TLinkServiceManager.getServiceManager().getApiNavigation().twoFingerZoomStop();
                    this.twoFingureZoom = false;
                    break;
                }
                case 3: {
                    TLinkServiceManager.getServiceManager().getApiNavigation().clickInMap(point);
                    break;
                }
                case 4: {
                    break;
                }
            }
        }
        catch (GenericEventException genericEventException) {
            ServiceManager.errorHandler.handleError(genericEventException);
        }
    }

    public boolean isDragged() {
        return this.dragged;
    }

    public void setDragged(boolean bl) {
        this.dragged = bl;
    }

    public boolean isTwoFingureZoom() {
        return this.twoFingureZoom;
    }

    public void setTwoFingureZoom(boolean bl) {
        this.twoFingureZoom = bl;
    }

    public void setViewEnteredWeatherMapsActions() {
        if (ServiceManager.logger2.isTraceEnabled(64)) {
            ServiceManager.logger2.trace(64).append("WeatherGraphical: setViewEnteredWeatherMapsActions : Entered Weather maps. Trying to lock the view.").log();
        }
        TLinkServiceManager.getServiceManager().getApiNavigation().lockMapViewer();
        TLinkServiceManager.getServiceManager().getGuiControllerWeatherGraphical().updateRouteGuidance();
    }

    public boolean isCcpButtonEnabled() {
        return this.ccpButtonEnabled;
    }

    public void setCcpButtonEnabled(boolean bl) {
        this.ccpButtonEnabled = bl;
        TLinkServiceManager.getServiceManager().getGuiControllerWeatherGraphical().enableCcpButton(bl);
    }

    public int getSelectedWeatherMap() {
        return this.selectedWeatherMap;
    }

    public void setSelectedWeatherMap(int n) {
        this.selectedWeatherMap = n >= 0 && n <= 2 ? n : 0;
    }

    public boolean isWeatherIconMapZoomInBlocked() {
        return this.weatherIconMapZoomInBlocked;
    }

    public void setWeatherIconMapZoomInBlocked(boolean bl) {
        this.weatherIconMapZoomInBlocked = bl;
    }

    public boolean isWeatherIsobarMapZoomInBlocked() {
        return this.weatherIsobarMapZoomInBlocked;
    }

    public void setWeatherIsobarMapZoomInBlocked(boolean bl) {
        this.weatherIsobarMapZoomInBlocked = bl;
    }

    public boolean isWeatherRadarMapZoomInBlocked() {
        return this.weatherRadarMapZoomInBlocked;
    }

    public void setWeatherRadarMapZoomInBlocked(boolean bl) {
        this.weatherRadarMapZoomInBlocked = bl;
    }

    public boolean isUnblockZoomInForRouteOverview() {
        return this.unblockZoomInForRouteOverview;
    }

    public void setUnblockZoomInForRouteOverview(boolean bl) {
        this.unblockZoomInForRouteOverview = bl;
    }
}

