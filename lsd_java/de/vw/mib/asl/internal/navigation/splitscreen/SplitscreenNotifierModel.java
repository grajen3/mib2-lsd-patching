/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.splitscreen;

import de.vw.mib.asl.api.navbap.ASLNavBAPFactory;
import de.vw.mib.asl.api.navigation.ILocationWrapper;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import generated.de.vw.mib.asl.internal.ListManager;
import generated.de.vw.mib.asl.internal.navigation.map.ss.ASLNavigationMapSSPropertyManager;
import generated.de.vw.mib.asl.internal.navigation.map.ss.transformer.NavigationMapSSCompassDataCollector;
import generated.de.vw.mib.asl.internal.navigation.map.ss.transformer.NavigationMapSSGPSViewerDataCollector;
import generated.de.vw.mib.asl.internal.navigation.map.ss.transformer.NavigationMapSSSymbolDataCollector;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.BapTurnToInfo;
import org.dsi.ifc.navigation.DistanceToNextManeuver;
import org.dsi.ifc.navigation.PosPosition;

public class SplitscreenNotifierModel {
    private static final String SEPERATOR;
    private static final double SPEED_FACTOR;
    private final NavigationMapSSCompassDataCollector[] collectorCompassData;
    private final NavigationMapSSGPSViewerDataCollector[] collectorGPSViewer;
    private final NavigationMapSSSymbolDataCollector[] collectorSymbol;
    private final IExtLogger logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(16384, "[SplitscreenNotifierModel]");

    public SplitscreenNotifierModel() {
        ASLNavBAPFactory.getNavBAPApi().updateBapAltitudeCollector(0, 0);
        ASLNavBAPFactory.getNavBAPApi().updateBapCompassInfo(0, 0);
        this.collectorCompassData = new NavigationMapSSCompassDataCollector[]{new NavigationMapSSCompassDataCollector()};
        this.collectorCompassData[0].navigation_map_ss_compass_data_degree = 0;
        this.collectorCompassData[0].navigation_map_ss_compass_data_street = "";
        this.updateListCompassData();
        this.collectorGPSViewer = new NavigationMapSSGPSViewerDataCollector[]{new NavigationMapSSGPSViewerDataCollector()};
        this.collectorGPSViewer[0].navigation_map_ss_gps_viewer_data_altitude = 0;
        this.collectorGPSViewer[0].navigation_map_ss_gps_viewer_data_city = "";
        this.collectorGPSViewer[0].navigation_map_ss_gps_viewer_data_city_refinement = "";
        this.collectorGPSViewer[0].navigation_map_ss_gps_viewer_data_gps_status = 0;
        this.collectorGPSViewer[0].navigation_map_ss_gps_viewer_data_hdopvdop = "";
        this.collectorGPSViewer[0].navigation_map_ss_gps_viewer_data_house_number = "";
        this.collectorGPSViewer[0].navigation_map_ss_gps_viewer_data_lat_degree = 0;
        this.collectorGPSViewer[0].navigation_map_ss_gps_viewer_data_lat_minutes = 0;
        this.collectorGPSViewer[0].navigation_map_ss_gps_viewer_data_lat_seconds = 0;
        this.collectorGPSViewer[0].navigation_map_ss_gps_viewer_data_lon_degree = 0;
        this.collectorGPSViewer[0].navigation_map_ss_gps_viewer_data_lon_minutes = 0;
        this.collectorGPSViewer[0].navigation_map_ss_gps_viewer_data_lon_seconds = 0;
        this.collectorGPSViewer[0].navigation_map_ss_gps_viewer_data_north_direction = 0;
        this.collectorGPSViewer[0].navigation_map_ss_gps_viewer_data_satellites = 0;
        this.collectorGPSViewer[0].navigation_map_ss_gps_viewer_data_speed = 0;
        this.collectorGPSViewer[0].navigation_map_ss_gps_viewer_data_street = "";
        this.collectorGPSViewer[0].navigation_map_ss_gps_viewer_data_street_refinement = "";
        this.collectorGPSViewer[0].navigation_map_ss_gps_viewer_data_tracked_satellites = 0;
        this.collectorGPSViewer[0].navigation_map_ss_gps_viewer_data_used_satellites = 0;
        this.collectorGPSViewer[0].navigation_map_ss_gps_viewer_data_visible_satellites = 0;
        this.collectorGPSViewer[0].navigation_map_ss_gps_viewer_data_address_for_fix_formatter = ASLNavigationMapSSPropertyManager.GPS_VIEWER_DATA__GPS_VIEWER_DATA_ADDRESS_FOR_FIX_FORMATTER__DEFAULT_VALUE;
        this.updateListGPSViewer();
        this.collectorSymbol = new NavigationMapSSSymbolDataCollector[]{new NavigationMapSSSymbolDataCollector()};
        this.collectorSymbol[0].navigation_map_ss_symbol_data_distance = 0;
        this.collectorSymbol[0].navigation_map_ss_symbol_data_distance_to_next_maneuvre = 0;
        this.collectorSymbol[0].navigation_map_ss_symbol_data_distance_to_next_maneuvre_is_visible = false;
        this.collectorSymbol[0].navigation_map_ss_symbol_data_distance_visible = false;
        this.collectorSymbol[0].navigation_map_ss_symbol_data_next_street = "";
        this.collectorSymbol[0].navigation_map_ss_symbol_data_next_street_sign_post = "";
        this.collectorSymbol[0].navigation_map_ss_symbol_data_street = "";
        this.updateListSymbol();
    }

    public void notifySplitScreenContentChanged(int n) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("notifySplitScreenContentChanged(content =").append(n).append(")").log();
        }
        ServiceManager.aslPropertyManager.valueChangedInteger(850, n);
    }

    public void notifySplitScreenGuidanceChanged(boolean bl) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("notifySplitScreenGuidanceChanged(value =").append(bl).append(")").log();
        }
        ServiceManager.aslPropertyManager.valueChangedBoolean(852, bl);
    }

    public void notifySplitscreenNoGuidanceChanged(boolean bl) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("notifySplitscreenNoGuidanceChanged(value =").append(bl).append(")").log();
        }
        ServiceManager.aslPropertyManager.valueChangedBoolean(853, bl);
    }

    public void notifySplitscreenNoGuidanceContentChanged(int n) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("notifySplitscreenNoGuidanceContentChanged(content =").append(n).append(")").log();
        }
        ServiceManager.aslPropertyManager.valueChangedInteger(851, n);
    }

    public void updateCollectorCompassDataRotation(int n) {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace("updateCollectorCompassDataRotation()");
        }
        this.collectorCompassData[0].navigation_map_ss_compass_data_degree = n;
        this.updateListCompassData();
    }

    public void updateCollectorGPSViewer(PosPosition posPosition) {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace("updateCollectorGPSViewer()");
        }
        this.collectorGPSViewer[0].navigation_map_ss_gps_viewer_data_north_direction = posPosition.directionAngle;
        this.collectorGPSViewer[0].navigation_map_ss_gps_viewer_data_satellites = posPosition.visibleSatellites;
        this.collectorGPSViewer[0].navigation_map_ss_gps_viewer_data_visible_satellites = posPosition.visibleSatellites;
        this.collectorGPSViewer[0].navigation_map_ss_gps_viewer_data_used_satellites = posPosition.usedSatellites;
        double[] dArray = ASLNavigationUtilFactory.getNavigationUtilApi().getNaviHelper().dsiToDegMinSec(posPosition.latitude);
        this.collectorGPSViewer[0].navigation_map_ss_gps_viewer_data_lat_degree = (int)dArray[0];
        this.collectorGPSViewer[0].navigation_map_ss_gps_viewer_data_lat_minutes = (int)dArray[1];
        this.collectorGPSViewer[0].navigation_map_ss_gps_viewer_data_lat_seconds = (int)(10.0 * dArray[2]);
        double[] dArray2 = ASLNavigationUtilFactory.getNavigationUtilApi().getNaviHelper().dsiToDegMinSec(posPosition.longitude);
        this.collectorGPSViewer[0].navigation_map_ss_gps_viewer_data_lon_degree = (int)dArray2[0];
        this.collectorGPSViewer[0].navigation_map_ss_gps_viewer_data_lon_minutes = (int)dArray2[1];
        this.collectorGPSViewer[0].navigation_map_ss_gps_viewer_data_lon_seconds = (int)(10.0 * dArray2[2]);
        this.collectorGPSViewer[0].navigation_map_ss_gps_viewer_data_speed = (int)((double)posPosition.speed * 0.036);
        switch (posPosition.state) {
            case 0: {
                this.collectorGPSViewer[0].navigation_map_ss_gps_viewer_data_gps_status = 0;
                break;
            }
            case 1: {
                this.collectorGPSViewer[0].navigation_map_ss_gps_viewer_data_gps_status = 1;
                break;
            }
            case 2: {
                this.collectorGPSViewer[0].navigation_map_ss_gps_viewer_data_gps_status = 2;
                break;
            }
            case 3: {
                this.collectorGPSViewer[0].navigation_map_ss_gps_viewer_data_gps_status = 3;
                break;
            }
            case 4: {
                this.collectorGPSViewer[0].navigation_map_ss_gps_viewer_data_gps_status = 4;
                break;
            }
        }
        this.collectorGPSViewer[0].navigation_map_ss_gps_viewer_data_hdopvdop = new StringBuffer().append(posPosition.hdop).append("/").append(posPosition.vdop).toString();
        this.collectorGPSViewer[0].navigation_map_ss_gps_viewer_data_altitude = posPosition.height;
        this.updateListGPSViewer();
    }

    public void updateCollectorLocation(NavLocation navLocation) {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace("updateCollectorLocation()");
        }
        ILocationWrapper iLocationWrapper = ASLNavigationUtilFactory.getNavigationUtilApi().getLocationWrapper(navLocation);
        this.collectorGPSViewer[0].navigation_map_ss_gps_viewer_data_city = iLocationWrapper.getCity();
        this.collectorGPSViewer[0].navigation_map_ss_gps_viewer_data_city_refinement = iLocationWrapper.getCityRefinement();
        this.collectorGPSViewer[0].navigation_map_ss_gps_viewer_data_house_number = iLocationWrapper.getHousenumber();
        this.collectorGPSViewer[0].navigation_map_ss_gps_viewer_data_address_for_fix_formatter = ASLNavigationUtilFactory.getNavigationUtilApi().getLocationFormatter().prepareFixFormatterFieldData(iLocationWrapper);
        this.updateListGPSViewer();
    }

    public void updateCollectorStreetData(NavLocation navLocation) {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace("updateCollectorStreetData()");
        }
        ILocationWrapper iLocationWrapper = ASLNavigationUtilFactory.getNavigationUtilApi().getLocationWrapper(navLocation);
        this.collectorGPSViewer[0].navigation_map_ss_gps_viewer_data_street = iLocationWrapper.getStreet();
        this.collectorGPSViewer[0].navigation_map_ss_gps_viewer_data_street_refinement = iLocationWrapper.getStreetRefinement();
        this.collectorCompassData[0].navigation_map_ss_compass_data_street = iLocationWrapper.getStreet();
        this.collectorSymbol[0].navigation_map_ss_symbol_data_street = iLocationWrapper.getStreet();
        this.updateListGPSViewer();
        this.updateListSymbol();
        this.updateListCompassData();
    }

    public void updateCollectorSymbol(BapTurnToInfo[] bapTurnToInfoArray) {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace("updateCollectorSymbol()");
        }
        this.collectorSymbol[0].navigation_map_ss_symbol_data_next_street = ASLNavigationUtilFactory.getNavigationUtilApi().getNaviHelper().splitTurnToInfoStreet(bapTurnToInfoArray[0].turnToInfo);
        this.collectorSymbol[0].navigation_map_ss_symbol_data_next_street_sign_post = bapTurnToInfoArray[0].signPost;
        this.updateListSymbol();
    }

    public void updateCollectorSymbol(DistanceToNextManeuver distanceToNextManeuver) {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace("updateCollectorSymbol()");
        }
        this.collectorSymbol[0].navigation_map_ss_symbol_data_distance = (int)((double)distanceToNextManeuver.bargraph * 100.0 / 255.0);
        this.collectorSymbol[0].navigation_map_ss_symbol_data_distance_to_next_maneuvre = distanceToNextManeuver.distance;
        this.collectorSymbol[0].navigation_map_ss_symbol_data_distance_visible = distanceToNextManeuver.showBargraph;
        this.collectorSymbol[0].navigation_map_ss_symbol_data_distance_to_next_maneuvre_is_visible = distanceToNextManeuver.showDistance;
        this.updateListSymbol();
    }

    private void updateListCompassData() {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace("updateListCompassData()");
        }
        ListManager.getGenericASLList(859).updateList(this.collectorCompassData);
    }

    private void updateListGPSViewer() {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace("updateListGPSViewer()");
        }
        ListManager.getGenericASLList(860).updateList(this.collectorGPSViewer);
    }

    private void updateListSymbol() {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace("updateListSymbol()");
        }
        ListManager.getGenericASLList(861).updateList(this.collectorSymbol);
    }
}

