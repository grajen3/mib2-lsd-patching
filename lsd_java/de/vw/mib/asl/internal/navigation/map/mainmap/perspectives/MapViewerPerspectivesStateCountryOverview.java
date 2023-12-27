/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.mainmap.perspectives;

import de.vw.mib.asl.api.navigation.ILocationWrapper;
import de.vw.mib.asl.api.navigation.NavigationConfiguration;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.internal.navigation.map.MapViewerUtils;
import de.vw.mib.asl.internal.navigation.map.mainmap.perspectives.MapViewerPerspectivesTargetHSM;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.HsmState;

public class MapViewerPerspectivesStateCountryOverview
extends AbstractHsmState {
    private final IExtLogger logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(256, "[MapViewerPerspectivesStateCountryOverview]");
    private final MapViewerPerspectivesTargetHSM target;
    private final ILocationWrapper countryOverviewLocation;

    public MapViewerPerspectivesStateCountryOverview(MapViewerPerspectivesTargetHSM mapViewerPerspectivesTargetHSM, String string, HsmState hsmState) {
        super(mapViewerPerspectivesTargetHSM.getHsm(), string, hsmState);
        this.target = mapViewerPerspectivesTargetHSM;
        this.countryOverviewLocation = ASLNavigationUtilFactory.getNavigationUtilApi().getLocationWrapper(ASLNavigationUtilFactory.getNavigationUtilApi().getNaviHelper().degMinSecToDsi(new double[]{NavigationConfiguration.COUNTRY_OVERVIEW_LOCATION_LATITUDE_DEGREES, NavigationConfiguration.COUNTRY_OVERVIEW_LOCATION_LATITUDE_MINUTES, NavigationConfiguration.COUNTRY_OVERVIEW_LOCATION_LATITUDE_SECONDS}), ASLNavigationUtilFactory.getNavigationUtilApi().getNaviHelper().degMinSecToDsi(new double[]{NavigationConfiguration.COUNTRY_OVERVIEW_LOCATION_LONGITUDE_DEGREES, NavigationConfiguration.COUNTRY_OVERVIEW_LOCATION_LONGITUDE_MINUTES, NavigationConfiguration.COUNTRY_OVERVIEW_LOCATION_LONGITUDE_SECONDS}));
    }

    public HsmState dsiMapViewerControlUpdateZoomListIndex(int n, int n2) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("dsiMapViewerControlUpdateZoomListIndex() received zoomListIndex=").append(n).log();
        }
        if (!MapViewerUtils.isMainMapMaximumZoomListIndexReached()) {
            this.target.transStateNorthUp2D();
            return this.myParent;
        }
        return null;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        block0 : switch (eventGeneric.getReceiverEventId()) {
            case 2: {
                this.handleEntry();
                break;
            }
            case 4: {
                this.handleExit();
                break;
            }
            case 3: {
                this.handleStart();
                break;
            }
            case 1073742409: {
                this.handleASLNavigationMapViewCenterMapToCCP();
                break;
            }
            case 1073742420: {
                this.handleASLNavigationMapViewZoomIn();
                return this.myParent;
            }
            case 1073742385: {
                this.logger.trace("handleASLNavigationMapSetupPerspectiveSet()");
                switch (eventGeneric.getInt(0)) {
                    case 0: {
                        break block0;
                    }
                }
                return this.myParent;
            }
            default: {
                this.handleDefault(eventGeneric);
                return this.myParent;
            }
        }
        return null;
    }

    private void handleASLNavigationMapViewCenterMapToCCP() {
        this.logger.trace("handleASLNavigationMapViewCenterMapToCCP()");
        this.target.notifierModel.notifyMapMovedFalse();
        this.setNewZoomLevel();
        this.target.triggerObserver(1409417280, null);
    }

    private void handleASLNavigationMapViewZoomIn() {
        this.logger.trace("handleASLNavigationMapViewZoomIn()");
        this.target.transStateNorthUp2D();
    }

    private void handleDefault(EventGeneric eventGeneric) {
        this.logger.trace("handleDefault()");
    }

    private void handleEntry() {
        this.logger.trace("handleEntry()");
    }

    private void handleExit() {
        this.logger.trace("handleExit()");
        this.target.notifierModel.notifyOverviewZoomOff();
        this.target.datapool.setPerspectiveCountryOverview(false);
        if (this.target.datapool.isFocusCcpZoom() && !this.target.datapool.isMapMoved()) {
            this.target.notifierDSI.setModePositionMap();
        }
        if (this.target.datapool.isMapMoved()) {
            this.target.notifierModel.notifyMapMovedTrue();
            this.target.notifierDSI.setLocationByLocation(this.target.datapool.getMapPosition());
        }
    }

    private void handleStart() {
        this.logger.trace("handleStart()");
        this.target.datapool.setMainMapPerspective(0);
        this.target.datapool.setPerspectiveCountryOverview(true);
        this.target.notifierDSI.viewFreezeTrue();
        this.target.notifierDSI.setModeFreeMap();
        this.target.notifierDSI.setViewType2D();
        this.target.notifierDSI.setOrientationNorthUp();
        if (this.target.datapool.isFeatureShowEnhancedCityModelAllViewtypes()) {
            this.target.notifierDSI.setCityModelModeEnhanced();
        } else {
            this.target.notifierDSI.setCityModelModeOff();
        }
        this.target.notifierDSI.set3DLandmarksInvisible();
        this.target.notifierDSI.setLocationByLocation(this.countryOverviewLocation.getLocation());
        this.target.notifierDSI.viewFreezeFalse();
        this.target.notifierModel.notifyPerspective2DNorth();
        this.target.notifierModel.notifyMapMovedFalse();
    }

    private void setNewZoomLevel() {
        this.logger.trace("zoomIn()");
        int n = MapViewerUtils.calculateZoomListIndexNew(-1);
        float f2 = MapViewerUtils.calculateZoomLevelByZoomIndex(n);
        MapViewerUtils.updateMainMapPersistedZoomLevel(f2);
    }
}

