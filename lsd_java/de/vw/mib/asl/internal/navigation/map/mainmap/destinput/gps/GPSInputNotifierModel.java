/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.mainmap.destinput.gps;

import de.vw.mib.asl.api.navigation.ILocationWrapper;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.framework.internal.framework.AbstractASLTarget;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.navigation.map.mainmap.destinput.gps.GPSInputDataPool;
import de.vw.mib.asl.internal.navigation.map.mainmap.destinput.gps.GPSInputTargetHSM;
import generated.de.vw.mib.asl.internal.ListManager;
import generated.de.vw.mib.asl.internal.navigation.destinput.gps.transformer.NavigationDestInputGPSCoordinatesCollector;
import generated.de.vw.mib.asl.internal.navigation.destinput.gps.transformer.NavigationDestInputGPSMapInputLocationCollector;

public class GPSInputNotifierModel {
    private final NavigationDestInputGPSCoordinatesCollector collectorCoordinates;
    private final NavigationDestInputGPSMapInputLocationCollector collectorMapInputLocation;
    private final GPSInputDataPool datapool;
    private final NavigationDestInputGPSCoordinatesCollector[] listArrayCoordinates;
    private final NavigationDestInputGPSMapInputLocationCollector[] listArrayMapInputLocation;
    private final GenericASLList listCoordinates;
    private final GenericASLList listMapInputLocation;
    private final IExtLogger LOGGER = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(256, "[GPSInputNotifierModel]");

    public GPSInputNotifierModel(GPSInputTargetHSM gPSInputTargetHSM) {
        this.datapool = gPSInputTargetHSM.datapool;
        this.listCoordinates = ListManager.getGenericASLList(3558);
        Object object = this.listCoordinates.getRowItemCacheOnly(0);
        this.collectorCoordinates = object instanceof NavigationDestInputGPSCoordinatesCollector ? (NavigationDestInputGPSCoordinatesCollector)object : new NavigationDestInputGPSCoordinatesCollector();
        this.listArrayCoordinates = new NavigationDestInputGPSCoordinatesCollector[]{this.collectorCoordinates};
        this.listMapInputLocation = ListManager.getGenericASLList(3570);
        object = this.listMapInputLocation.getRowItemCacheOnly(0);
        this.collectorMapInputLocation = object instanceof NavigationDestInputGPSMapInputLocationCollector ? (NavigationDestInputGPSMapInputLocationCollector)object : new NavigationDestInputGPSMapInputLocationCollector();
        this.listArrayMapInputLocation = new NavigationDestInputGPSMapInputLocationCollector[]{this.collectorMapInputLocation};
    }

    protected NavigationDestInputGPSCoordinatesCollector getCollectorCoordinates() {
        return this.collectorCoordinates;
    }

    public void notifyActionResultIsError() {
        this.LOGGER.trace("notifyActionResultIsError()");
        AbstractASLTarget.writeIntegerToDatapool(3559, 1);
    }

    public void notifyActionResultIsOk() {
        this.LOGGER.trace("notifyActionResultIsOk()");
        AbstractASLTarget.writeIntegerToDatapool(3559, 0);
    }

    public void notifyCoordinatesChanged() {
        this.LOGGER.trace("notifyCoordinatesChanged()");
        ILocationWrapper iLocationWrapper = this.datapool.getLocationCurrent();
        int n = Math.abs(iLocationWrapper.getLatitudeDegrees());
        int n2 = Math.abs(iLocationWrapper.getLatitudeMinutes());
        int n3 = Math.abs(iLocationWrapper.getLatitudeSeconds());
        int n4 = Math.abs(iLocationWrapper.getLongitudeDegrees());
        int n5 = Math.abs(iLocationWrapper.getLongitudeMinutes());
        int n6 = Math.abs(iLocationWrapper.getLongitudeSeconds());
        this.collectorCoordinates.navigation_destinput_gps_coordinates_lat_degree = n;
        this.collectorCoordinates.navigation_destinput_gps_coordinates_lat_min = n2;
        this.collectorCoordinates.navigation_destinput_gps_coordinates_lat_sec = n3;
        this.collectorCoordinates.navigation_destinput_gps_coordinates_lat_hemisphere = iLocationWrapper.getLatitude() >= 0 ? 0 : 1;
        this.collectorCoordinates.navigation_destinput_gps_coordinates_lon_degree = n4;
        this.collectorCoordinates.navigation_destinput_gps_coordinates_lon_min = n5;
        this.collectorCoordinates.navigation_destinput_gps_coordinates_lon_sec = n6;
        this.collectorCoordinates.navigation_destinput_gps_coordinates_lon_hemisphere = iLocationWrapper.getLongitude() >= 0 ? 1 : 0;
        int[] nArray = this.splitValueIntoDigits(n, 2);
        this.collectorCoordinates.navigation_destinput_gps_coordinates_lat_degree_ten = nArray[0];
        this.collectorCoordinates.navigation_destinput_gps_coordinates_lat_degree_one = nArray[1];
        nArray = this.splitValueIntoDigits(n2, 2);
        this.collectorCoordinates.navigation_destinput_gps_coordinates_lat_min_ten = nArray[0];
        this.collectorCoordinates.navigation_destinput_gps_coordinates_lat_min_one = nArray[1];
        nArray = this.splitValueIntoDigits(n3, 3);
        this.collectorCoordinates.navigation_destinput_gps_coordinates_lat_sec_ten = nArray[0];
        this.collectorCoordinates.navigation_destinput_gps_coordinates_lat_sec_one = nArray[1];
        this.collectorCoordinates.navigation_destinput_gps_coordinates_lat_sec_tenth = nArray[2];
        nArray = this.splitValueIntoDigits(n4, 3);
        this.collectorCoordinates.navigation_destinput_gps_coordinates_lon_degree_hundred = nArray[0];
        this.collectorCoordinates.navigation_destinput_gps_coordinates_lon_degree_ten = nArray[1];
        this.collectorCoordinates.navigation_destinput_gps_coordinates_lon_degree_one = nArray[2];
        nArray = this.splitValueIntoDigits(n5, 2);
        this.collectorCoordinates.navigation_destinput_gps_coordinates_lon_min_ten = nArray[0];
        this.collectorCoordinates.navigation_destinput_gps_coordinates_lon_min_one = nArray[1];
        nArray = this.splitValueIntoDigits(n6, 3);
        this.collectorCoordinates.navigation_destinput_gps_coordinates_lon_sec_ten = nArray[0];
        this.collectorCoordinates.navigation_destinput_gps_coordinates_lon_sec_one = nArray[1];
        this.collectorCoordinates.navigation_destinput_gps_coordinates_lon_sec_tenth = nArray[2];
        this.updateListCoordinates();
    }

    public void notifyCoordinatesOffMap() {
        this.LOGGER.trace("notifyCoordinatesOffMap()");
        AbstractASLTarget.writeBooleanToDatapool(3561, false);
    }

    public void notifyCoordinatesOnMap() {
        this.LOGGER.trace("notifyCoordinatesOnMap()");
        AbstractASLTarget.writeBooleanToDatapool(3561, true);
    }

    public void notifyLatitudeDegreeOneChanged(int n) {
        if (this.LOGGER.isTraceEnabled()) {
            this.LOGGER.makeTrace().append("notifyLatitudeDegreeOneChanged(").append(n).append(")");
        }
        this.collectorCoordinates.navigation_destinput_gps_coordinates_lat_degree_one = n;
        this.updateListCoordinates();
    }

    public void notifyLatitudeDegreeTenChanged(int n) {
        if (this.LOGGER.isTraceEnabled()) {
            this.LOGGER.makeTrace().append("notifyLatitudeDegreeTenChanged(").append(n).append(")").log();
        }
        this.collectorCoordinates.navigation_destinput_gps_coordinates_lat_degree_ten = n;
        this.updateListCoordinates();
    }

    public void notifyLatitudeHemisphereChanged(int n) {
        if (this.LOGGER.isTraceEnabled()) {
            this.LOGGER.makeTrace().append("notifyLatitudeHemisphereChanged(").append(n).append(")").log();
        }
        this.collectorCoordinates.navigation_destinput_gps_coordinates_lat_hemisphere = n;
        this.updateListCoordinates();
    }

    public void notifyLatitudeMinutesOneChanged(int n) {
        if (this.LOGGER.isTraceEnabled()) {
            this.LOGGER.makeTrace().append("notifyLatitudeMinutesOneChanged(").append(n).append(")").log();
        }
        this.collectorCoordinates.navigation_destinput_gps_coordinates_lat_min_one = n;
        this.updateListCoordinates();
    }

    public void notifyLatitudeMinutesTenChanged(int n) {
        if (this.LOGGER.isTraceEnabled()) {
            this.LOGGER.makeTrace().append("notifyLatitudeMinutesTenChanged(").append(n).append(")").log();
        }
        this.collectorCoordinates.navigation_destinput_gps_coordinates_lat_min_ten = n;
        this.updateListCoordinates();
    }

    public void notifyLatitudeSecondsOneChanged(int n) {
        if (this.LOGGER.isTraceEnabled()) {
            this.LOGGER.makeTrace().append("notifyLatitudeSecondsOneChanged(").append(n).append(")").log();
        }
        this.collectorCoordinates.navigation_destinput_gps_coordinates_lat_sec_one = n;
        this.updateListCoordinates();
    }

    public void notifyLatitudeSecondsTenChanged(int n) {
        if (this.LOGGER.isTraceEnabled()) {
            this.LOGGER.makeTrace().append("notifyLatitudeSecondsTenChanged(").append(n).append(")").log();
        }
        this.collectorCoordinates.navigation_destinput_gps_coordinates_lat_sec_ten = n;
        this.updateListCoordinates();
    }

    public void notifyLatitudeSecondsTenthChanged(int n) {
        if (this.LOGGER.isTraceEnabled()) {
            this.LOGGER.makeTrace().append("notifyLatitudeSecondsTenthChanged").append(n).append(")").log();
        }
        this.collectorCoordinates.navigation_destinput_gps_coordinates_lat_sec_tenth = n;
        this.updateListCoordinates();
    }

    public void notifyLongitudeDegreeHundredChanged(int n) {
        if (this.LOGGER.isTraceEnabled()) {
            this.LOGGER.makeTrace().append("notifyLongitudeDegreeHundredChanged(").append(n).append(")").log();
        }
        this.collectorCoordinates.navigation_destinput_gps_coordinates_lon_degree_hundred = n;
        this.updateListCoordinates();
    }

    public void notifyLongitudeDegreeOneChanged(int n) {
        if (this.LOGGER.isTraceEnabled()) {
            this.LOGGER.makeTrace().append("notifyLongitudeDegreeOneChanged(").append(n).append(")").log();
        }
        this.collectorCoordinates.navigation_destinput_gps_coordinates_lon_degree_one = n;
        this.updateListCoordinates();
    }

    public void notifyLongitudeDegreeTenChanged(int n) {
        if (this.LOGGER.isTraceEnabled()) {
            this.LOGGER.makeTrace().append("notifyLongitudeDegreeTenChanged(").append(n).append(")").log();
        }
        this.collectorCoordinates.navigation_destinput_gps_coordinates_lon_degree_ten = n;
        this.updateListCoordinates();
    }

    public void notifyLongitudeHemisphereChanged(int n) {
        if (this.LOGGER.isTraceEnabled()) {
            this.LOGGER.makeTrace().append("notifyLongitudeHemisphereChanged(").append(n).append(")").log();
        }
        this.collectorCoordinates.navigation_destinput_gps_coordinates_lon_hemisphere = n;
        this.updateListCoordinates();
    }

    public void notifyLongitudeMinutesOneChanged(int n) {
        if (this.LOGGER.isTraceEnabled()) {
            this.LOGGER.makeTrace().append("notifyLongitudeMinutesOneChanged(").append(n).append(")").log();
        }
        this.collectorCoordinates.navigation_destinput_gps_coordinates_lon_min_one = n;
        this.updateListCoordinates();
    }

    public void notifyLongitudeMinutesTenChanged(int n) {
        if (this.LOGGER.isTraceEnabled()) {
            this.LOGGER.makeTrace().append("notifyLongitudeMinutesTenChanged(").append(n).append(")").log();
        }
        this.collectorCoordinates.navigation_destinput_gps_coordinates_lon_min_ten = n;
        this.updateListCoordinates();
    }

    public void notifyLongitudeSecondsOneChanged(int n) {
        if (this.LOGGER.isTraceEnabled()) {
            this.LOGGER.makeTrace().append("notifyLongitudeSecondsOneChanged(").append(n).append(")").log();
        }
        this.collectorCoordinates.navigation_destinput_gps_coordinates_lon_sec_one = n;
        this.updateListCoordinates();
    }

    public void notifyLongitudeSecondsTenChanged(int n) {
        if (this.LOGGER.isTraceEnabled()) {
            this.LOGGER.makeTrace().append("notifyLongitudeSecondsTenChanged(").append(n).append(")").log();
        }
        this.collectorCoordinates.navigation_destinput_gps_coordinates_lon_sec_ten = n;
        this.updateListCoordinates();
    }

    public void notifyLongitudeSecondsTenthChanged(int n) {
        if (this.LOGGER.isTraceEnabled()) {
            this.LOGGER.makeTrace().append("notifyLongitudeSecondsTenthChanged(").append(n).append(")").log();
        }
        this.collectorCoordinates.navigation_destinput_gps_coordinates_lon_sec_tenth = n;
        this.updateListCoordinates();
    }

    public void notifyMapInputLocationChanged() {
        this.LOGGER.trace("notifyMapInputLocationChanged()");
        this.updateListMapInputLocationFixFormatter();
        this.updateListMapInputLocationCountry();
        this.updateListMapInputLocationState();
        this.updateListMapInputLocationProvince();
        this.updateListMapInputLocationCity();
        this.updateListMapInputLocationPostalCode();
        this.updateListMapInputLocationStreet();
        this.updateListMapInputLocationHousenumber();
        this.updateListMapInputLocationLatitude();
        this.updateListMapInputLocationLongitude();
        this.updateListMapInputLocationType();
        this.updateListMapInputLocationGuideable();
        this.updateListMapInputLocationCrossing();
        this.updateListMapInputLocation();
        if (this.collectorMapInputLocation.navigation_destinput_gps_map_input_location_guideable) {
            this.notifyCoordinatesOnMap();
        } else {
            this.notifyCoordinatesOffMap();
        }
    }

    public void notifyMapIsNotReady() {
        this.LOGGER.trace("notifyMapIsNotReady()");
        AbstractASLTarget.writeBooleanToDatapool(3560, false);
    }

    public void notifyMapIsReady() {
        this.LOGGER.trace("notifyMapIsReady()");
        AbstractASLTarget.writeBooleanToDatapool(3560, true);
    }

    public void notifyZoomLevelChanged(int n) {
        if (this.LOGGER.isTraceEnabled()) {
            this.LOGGER.makeTrace().append("notifyZoomLevelChanged(zoomLevel=").append(n).append(")").log();
        }
        AbstractASLTarget.writeIntegerToDatapool(3598, n);
    }

    public void presetZoomLevel(int n) {
        if (this.LOGGER.isTraceEnabled()) {
            this.LOGGER.makeTrace().append("presetZoomLevel(zoomListIndex=").append(n).append(")").log();
        }
        int n2 = this.datapool.getZoomListIndexMax();
        if (n < 0 || n > n2) {
            this.LOGGER.makeWarn().append("new zoomListIndex (").append(n).append(") out of range, min: 0, max: ").append(n2);
            return;
        }
        float[] fArray = this.datapool.getZoomList();
        if (fArray == null || fArray.length == 0) {
            this.LOGGER.warn("zoomList contains no entries, preset of zoomLevel and zoomListIndex is not possible");
            return;
        }
        int n3 = (int)fArray[n];
        int n4 = n3 / 100;
        this.notifyZoomLevelChanged(n4);
    }

    private int[] splitValueIntoDigits(int n, int n2) {
        int[] nArray = new int[n2];
        int n3 = n2;
        while (n != 0) {
            nArray[--n3] = n % 10;
            n /= 10;
        }
        return nArray;
    }

    public void updateListCoordinates() {
        this.LOGGER.trace("updateListCoordinates()");
        this.listCoordinates.updateList(this.listArrayCoordinates);
    }

    private void updateListMapInputLocation() {
        this.LOGGER.trace("updateListMapInputLocation()");
        this.listMapInputLocation.updateList(this.listArrayMapInputLocation);
    }

    private void updateListMapInputLocationFixFormatter() {
        this.LOGGER.trace("updateListMapInputLocationFixFormatter()");
        this.collectorMapInputLocation.navigation_destinput_gps_map_input_location_details_for_fix_formatter = ASLNavigationUtilFactory.getNavigationUtilApi().getLocationFormatter().prepareFixFormatterFieldData(this.datapool.getLocationCurrent());
    }

    private void updateListMapInputLocationCity() {
        this.LOGGER.trace("updateListMapInputLocation()");
        this.collectorMapInputLocation.navigation_destinput_gps_map_input_location_city = this.datapool.getLocationCurrent().getCity();
        this.collectorMapInputLocation.navigation_destinput_gps_map_input_location_city_refinement = this.datapool.getLocationCurrent().getCityRefinement();
        this.collectorMapInputLocation.navigation_destinput_gps_map_input_location_town_refinement_needed = this.datapool.getLocationCurrent().isCityRefinementAvailable();
        this.collectorMapInputLocation.navigation_destinput_gps_map_input_location_city_center = this.datapool.getLocationCurrent().isCityCenter();
    }

    private void updateListMapInputLocationCountry() {
        this.LOGGER.trace("updateListMapInputLocationCountry()");
        this.collectorMapInputLocation.navigation_destinput_gps_map_input_location_country = this.datapool.getLocationCurrent().getCountry();
        this.collectorMapInputLocation.navigation_destinput_gps_map_input_location_country_code = this.datapool.getLocationCurrent().getCountryCode();
    }

    private void updateListMapInputLocationCrossing() {
        this.LOGGER.trace("updateListMapInputLocationCrossing()");
        this.collectorMapInputLocation.navigation_destinput_gps_map_input_location_crossing = this.datapool.getLocationCurrent().getCrossing();
    }

    private void updateListMapInputLocationGuideable() {
        this.LOGGER.trace("updateListMapInputLocationGuideable()");
        this.collectorMapInputLocation.navigation_destinput_gps_map_input_location_guideable = this.datapool.getLocationCurrent().isNavigable();
    }

    private void updateListMapInputLocationHousenumber() {
        this.LOGGER.trace("updateListMapInputLocationHousenumber()");
        this.collectorMapInputLocation.navigation_destinput_gps_map_input_location_housenumber = this.datapool.getLocationCurrent().getHousenumber();
    }

    private void updateListMapInputLocationLatitude() {
        this.LOGGER.trace("updateListMapInputLocationLatitude()");
        double[] dArray = ASLNavigationUtilFactory.getNavigationUtilApi().getNaviHelper().dsiToDegMinSec(this.datapool.getLocationCurrent().getLatitude());
        this.collectorMapInputLocation.navigation_destinput_gps_map_input_location_lat_degree = (int)dArray[0];
        this.collectorMapInputLocation.navigation_destinput_gps_map_input_location_lat_minutes = (int)dArray[1];
        this.collectorMapInputLocation.navigation_destinput_gps_map_input_location_lat_seconds = (int)(10.0 * dArray[2]);
    }

    private void updateListMapInputLocationLongitude() {
        this.LOGGER.trace("updateListMapInputLocationLongitude()");
        double[] dArray = ASLNavigationUtilFactory.getNavigationUtilApi().getNaviHelper().dsiToDegMinSec(this.datapool.getLocationCurrent().getLongitude());
        this.collectorMapInputLocation.navigation_destinput_gps_map_input_location_lon_degree = (int)dArray[0];
        this.collectorMapInputLocation.navigation_destinput_gps_map_input_location_lon_minutes = (int)dArray[1];
        this.collectorMapInputLocation.navigation_destinput_gps_map_input_location_lon_seconds = (int)(10.0 * dArray[2]);
    }

    private void updateListMapInputLocationPostalCode() {
        this.LOGGER.trace("updateListMapInputLocationPostalCode()");
        this.collectorMapInputLocation.navigation_destinput_gps_map_input_location_postal_code = this.datapool.getLocationCurrent().getPostalCode();
    }

    private void updateListMapInputLocationProvince() {
        this.LOGGER.trace("updateListMapInputLocationProvince()");
        this.collectorMapInputLocation.navigation_destinput_gps_map_input_location_province = this.datapool.getLocationCurrent().getProvince();
    }

    private void updateListMapInputLocationState() {
        this.LOGGER.trace("updateListMapInputLocationState()");
    }

    private void updateListMapInputLocationStreet() {
        this.LOGGER.trace("updateListMapInputLocationStreet()");
        this.collectorMapInputLocation.navigation_destinput_gps_map_input_location_street = this.datapool.getLocationCurrent().getStreet();
        this.collectorMapInputLocation.navigation_destinput_gps_map_input_location_street_refinement = this.datapool.getLocationCurrent().getStreetRefinement();
        this.collectorMapInputLocation.navigation_destinput_gps_map_input_location_street_refinement_needed = this.datapool.getLocationCurrent().isStreetRefinementAvailable();
    }

    private void updateListMapInputLocationType() {
        this.LOGGER.trace("updateListMapInputLocationType()");
        int n = this.datapool.getLocationCurrent().getLocationType();
        if (n == 1) {
            this.collectorMapInputLocation.navigation_destinput_gps_map_input_location_type = 0;
        } else if (n == 0) {
            this.collectorMapInputLocation.navigation_destinput_gps_map_input_location_type = 1;
        } else if (n == -1) {
            this.collectorMapInputLocation.navigation_destinput_gps_map_input_location_type = 255;
        } else {
            this.LOGGER.makeWarn().append("unsupported Location Type: ").append(n);
        }
    }
}

