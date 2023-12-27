/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navinfotile;

import de.vw.mib.asl.api.navigation.INavigationLocation;
import de.vw.mib.asl.api.navigation.INavigationPosPosition;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import generated.de.vw.mib.asl.internal.ListManager;
import generated.de.vw.mib.asl.internal.navinfotile.ASLNavInfoTilePropertyManager;
import generated.de.vw.mib.asl.internal.navinfotile.transformer.NavInfoTileCompassDataCollector;
import generated.de.vw.mib.asl.internal.navinfotile.transformer.NavInfoTileGPSViewerDataCollector;
import generated.de.vw.mib.asl.internal.navinfotile.transformer.NavInfoTileSymbolDataCollector;

public class NavInfoTileNotifierModel {
    private final NavInfoTileCompassDataCollector[] collectorCompassData = new NavInfoTileCompassDataCollector[]{new NavInfoTileCompassDataCollector()};
    private final NavInfoTileGPSViewerDataCollector[] collectorGPSViewer = new NavInfoTileGPSViewerDataCollector[]{new NavInfoTileGPSViewerDataCollector()};
    private final NavInfoTileSymbolDataCollector[] collectorSymbol = new NavInfoTileSymbolDataCollector[]{new NavInfoTileSymbolDataCollector()};

    public NavInfoTileNotifierModel() {
        this.setCompassDefaultValues();
        this.setGPSViewerDefaultValues();
        this.setSymbolDefaultValues();
    }

    public void updateCollectorCompassDataRotation(int n) {
        this.collectorCompassData[0].navinfotile_compass_data_degree = n;
        this.updateListCompassData();
    }

    public void updateCollectorCompassDataStreet(String string) {
        this.collectorCompassData[0].navinfotile_compass_data_street = string;
        this.updateListCompassData();
    }

    private void updateListCompassData() {
        ListManager.getGenericASLList(-248686080).updateList(this.collectorCompassData);
    }

    public void updateCollectorLocation(INavigationLocation iNavigationLocation) {
        this.collectorGPSViewer[0].navinfotile_gps_viewer_data_city = iNavigationLocation.getCity();
        this.collectorGPSViewer[0].navinfotile_gps_viewer_data_city_refinement = iNavigationLocation.getCityRefinement();
        this.collectorGPSViewer[0].navinfotile_gps_viewer_data_street = iNavigationLocation.getStreet();
        this.collectorGPSViewer[0].navinfotile_gps_viewer_data_street_refinement = iNavigationLocation.getStreetRefinement();
        this.collectorGPSViewer[0].navinfotile_gps_viewer_data_house_number = iNavigationLocation.getHousenumber();
        this.collectorGPSViewer[0].navinfotile_gps_viewer_data_address_for_fix_formatter = iNavigationLocation.getLocationFormatter();
        this.updateListGPSViewer();
        this.updateCollectorCompassDataStreet(iNavigationLocation.getStreet());
        this.updateCollectorSymbolDataStreet(iNavigationLocation.getStreet());
    }

    private void updateCollectorSymbolDataStreet(String string) {
        this.collectorSymbol[0].navinfotile_symbol_data_street = string;
        this.updateListSymbolData();
    }

    public void updateCollectorGPSViewer(INavigationPosPosition iNavigationPosPosition) {
        this.collectorGPSViewer[0].navinfotile_gps_viewer_data_north_direction = iNavigationPosPosition.getNorthDirection();
        this.collectorGPSViewer[0].navinfotile_gps_viewer_data_altitude = iNavigationPosPosition.getAltitude();
        this.collectorGPSViewer[0].navinfotile_gps_viewer_data_gps_status = iNavigationPosPosition.getGPSStatus();
        this.collectorGPSViewer[0].navinfotile_gps_viewer_data_hdopvdop = iNavigationPosPosition.getHdopVdop();
        this.collectorGPSViewer[0].navinfotile_gps_viewer_data_satellites = iNavigationPosPosition.getSatellites();
        this.collectorGPSViewer[0].navinfotile_gps_viewer_data_tracked_satellites = iNavigationPosPosition.getTrackedSatellites();
        this.collectorGPSViewer[0].navinfotile_gps_viewer_data_used_satellites = iNavigationPosPosition.getUsedSatellites();
        this.collectorGPSViewer[0].navinfotile_gps_viewer_data_visible_satellites = iNavigationPosPosition.getVisibleSatellites();
        this.collectorGPSViewer[0].navinfotile_gps_viewer_data_lat_degree = iNavigationPosPosition.getLatDegree();
        this.collectorGPSViewer[0].navinfotile_gps_viewer_data_lat_minutes = iNavigationPosPosition.getLatMinutes();
        this.collectorGPSViewer[0].navinfotile_gps_viewer_data_lat_seconds = iNavigationPosPosition.getLatSeconds();
        this.collectorGPSViewer[0].navinfotile_gps_viewer_data_lon_degree = iNavigationPosPosition.getLonDegree();
        this.collectorGPSViewer[0].navinfotile_gps_viewer_data_lon_minutes = iNavigationPosPosition.getLonMinutes();
        this.collectorGPSViewer[0].navinfotile_gps_viewer_data_lon_seconds = iNavigationPosPosition.getLonSeconds();
        this.updateListGPSViewer();
    }

    private void updateListGPSViewer() {
        ListManager.getGenericASLList(-231908864).updateList(this.collectorGPSViewer);
    }

    private void updateListSymbolData() {
        ListManager.getGenericASLList(36592128).updateList(this.collectorSymbol);
    }

    public void notifySatelliteInfoChanged(int n) {
        ServiceManager.aslPropertyManager.valueChangedInteger(-215131648, n);
    }

    public void setDefaults() {
        this.setCurrentWPMModeDefault();
        this.setCompassDefaultValues();
        this.setGPSViewerDefaultValues();
        this.setSatelliteInfoDefaultValue();
        this.setWayPointModeDefaultValues();
    }

    public void notifyExecutionMode(int n) {
        ServiceManager.aslPropertyManager.valueChangedInteger(741235200, n);
    }

    void setCurrentWPMModeDefault() {
        ServiceManager.aslPropertyManager.valueChangedInteger(-198354432, 0);
    }

    public void notifyWayPointModeInfoDegreeChanged(int n) {
        ServiceManager.aslPropertyManager.valueChangedInteger(-64136704, n);
    }

    public void notifyWayPointModeInfoDirectionChanged(int n) {
        ServiceManager.aslPropertyManager.valueChangedInteger(-47359488, n);
    }

    public void notifyWayPointModeStateChanged(int n) {
        ServiceManager.aslPropertyManager.valueChangedInteger(-198354432, n);
    }

    public void notifyWayPointModeDistanceNextWPChanged(int n) {
        ServiceManager.aslPropertyManager.valueChangedInteger(-114468352, n);
    }

    public void notifyWayPointModeNumberAllWayPointsChanged(int n) {
        ServiceManager.aslPropertyManager.valueChangedInteger(-131245568, n);
    }

    public void notifyWayPointModeNumberFreeWayPointsChanged(int n) {
        ServiceManager.aslPropertyManager.valueChangedInteger(-181577216, n);
    }

    public void notifyWayPointModeNumberMaxWayPointsChanged(int n) {
        ServiceManager.aslPropertyManager.valueChangedInteger(-164800000, n);
    }

    public void notifyWayPointModeNumberNextWayPointChanged(int n) {
        ServiceManager.aslPropertyManager.valueChangedInteger(-148022784, n);
    }

    public void notifyWayPointModeNumberSavedWayPointsChanged(int n) {
        ServiceManager.aslPropertyManager.valueChangedInteger(-97691136, n);
    }

    public void notifyWayPointModeRecordModeDestinationSet(boolean bl) {
        ServiceManager.aslPropertyManager.valueChangedBoolean(-80913920, bl);
    }

    private void setSymbolDefaultValues() {
        this.collectorSymbol[0].navinfotile_symbol_data_street = "";
        this.updateListSymbolData();
    }

    public void setWayPointModeDefaultValues() {
        this.notifyWayPointModeInfoDegreeChanged(0);
        this.notifyWayPointModeInfoDirectionChanged(0);
        this.notifyWayPointModeDistanceNextWPChanged(0);
        this.notifyWayPointModeNumberAllWayPointsChanged(1);
        this.notifyWayPointModeNumberFreeWayPointsChanged(3000);
        this.notifyWayPointModeNumberMaxWayPointsChanged(15);
        this.notifyWayPointModeNumberNextWayPointChanged(0);
        this.notifyWayPointModeNumberSavedWayPointsChanged(1);
        this.notifyWayPointModeRecordModeDestinationSet(false);
        this.notifyWayPointModeStateChanged(0);
    }

    public void setGPSViewerDefaultValues() {
        this.collectorGPSViewer[0].navinfotile_gps_viewer_data_address_for_fix_formatter = ASLNavInfoTilePropertyManager.GPS_VIEWER_DATA__GPS_VIEWER_DATA_ADDRESS_FOR_FIX_FORMATTER__DEFAULT_VALUE;
        this.collectorGPSViewer[0].navinfotile_gps_viewer_data_altitude = 0;
        this.collectorGPSViewer[0].navinfotile_gps_viewer_data_city = "";
        this.collectorGPSViewer[0].navinfotile_gps_viewer_data_city_refinement = "";
        this.collectorGPSViewer[0].navinfotile_gps_viewer_data_gps_status = 0;
        this.collectorGPSViewer[0].navinfotile_gps_viewer_data_hdopvdop = "";
        this.collectorGPSViewer[0].navinfotile_gps_viewer_data_house_number = "";
        this.collectorGPSViewer[0].navinfotile_gps_viewer_data_lat_degree = 0;
        this.collectorGPSViewer[0].navinfotile_gps_viewer_data_lat_minutes = 0;
        this.collectorGPSViewer[0].navinfotile_gps_viewer_data_lat_seconds = 0;
        this.collectorGPSViewer[0].navinfotile_gps_viewer_data_lon_degree = 0;
        this.collectorGPSViewer[0].navinfotile_gps_viewer_data_lon_minutes = 0;
        this.collectorGPSViewer[0].navinfotile_gps_viewer_data_lon_seconds = 0;
        this.collectorGPSViewer[0].navinfotile_gps_viewer_data_north_direction = 0;
        this.collectorGPSViewer[0].navinfotile_gps_viewer_data_satellites = 0;
        this.collectorGPSViewer[0].navinfotile_gps_viewer_data_speed = 0;
        this.collectorGPSViewer[0].navinfotile_gps_viewer_data_street = "";
        this.collectorGPSViewer[0].navinfotile_gps_viewer_data_street_refinement = "";
        this.collectorGPSViewer[0].navinfotile_gps_viewer_data_tracked_satellites = 0;
        this.collectorGPSViewer[0].navinfotile_gps_viewer_data_used_satellites = 0;
        this.collectorGPSViewer[0].navinfotile_gps_viewer_data_visible_satellites = 0;
        this.updateListGPSViewer();
    }

    public void setCompassDefaultValues() {
        this.collectorCompassData[0].navinfotile_compass_data_degree = 0;
        this.collectorCompassData[0].navinfotile_compass_data_street = "";
        this.updateListCompassData();
    }

    public void setSatelliteInfoDefaultValue() {
        this.notifySatelliteInfoChanged(0);
    }

    public void notifyNavNotReady() {
        ServiceManager.aslPropertyManager.valueChangedBoolean(573463040, false);
    }

    public void notifyNavReady() {
        ServiceManager.aslPropertyManager.valueChangedBoolean(573463040, true);
    }
}

