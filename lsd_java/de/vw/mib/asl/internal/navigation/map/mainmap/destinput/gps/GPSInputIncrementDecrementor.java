/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.mainmap.destinput.gps;

import de.vw.mib.asl.api.navigation.ILocationWrapper;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.internal.navigation.map.mainmap.destinput.gps.GPSInputNotifierModel;
import generated.de.vw.mib.asl.internal.navigation.destinput.gps.transformer.NavigationDestInputGPSCoordinatesCollector;

public class GPSInputIncrementDecrementor {
    private final NavigationDestInputGPSCoordinatesCollector collectorCoordinates;
    private final GPSInputNotifierModel modelNotifier;

    public GPSInputIncrementDecrementor(GPSInputNotifierModel gPSInputNotifierModel) {
        this.modelNotifier = gPSInputNotifierModel;
        this.collectorCoordinates = gPSInputNotifierModel.getCollectorCoordinates();
    }

    private int calculateLatitudeCurrent() {
        double[] dArray = new double[]{this.collectorCoordinates.navigation_destinput_gps_coordinates_lat_degree, this.collectorCoordinates.navigation_destinput_gps_coordinates_lat_min, (double)this.collectorCoordinates.navigation_destinput_gps_coordinates_lat_sec / 10.0 + 0.1};
        boolean bl = this.collectorCoordinates.navigation_destinput_gps_coordinates_lat_hemisphere != 0;
        int n = ASLNavigationUtilFactory.getNavigationUtilApi().getNaviHelper().degMinSecToDsi(dArray, bl);
        return n;
    }

    private int calculateLongitudeCurrent() {
        double[] dArray = new double[]{this.collectorCoordinates.navigation_destinput_gps_coordinates_lon_degree, this.collectorCoordinates.navigation_destinput_gps_coordinates_lon_min, (double)this.collectorCoordinates.navigation_destinput_gps_coordinates_lon_sec / 10.0 + 0.1};
        boolean bl = this.collectorCoordinates.navigation_destinput_gps_coordinates_lon_hemisphere != 1;
        int n = ASLNavigationUtilFactory.getNavigationUtilApi().getNaviHelper().degMinSecToDsi(dArray, bl);
        return n;
    }

    private int decrement(int n, int n2, int n3, int n4) {
        int n5 = n - n2;
        if (n5 < n4) {
            n5 = n3;
        }
        return n5;
    }

    public ILocationWrapper getMapLocationNew() {
        this.updateLatitudeValues();
        this.updateLongitudeValues();
        int n = this.calculateLatitudeCurrent();
        int n2 = this.calculateLongitudeCurrent();
        return ASLNavigationUtilFactory.getNavigationUtilApi().getLocationWrapper(n, n2);
    }

    private int increment(int n, int n2, int n3, int n4) {
        int n5 = n + n2;
        if (n5 > n3) {
            n5 = n4;
        }
        return n5;
    }

    public void latitudeDegreeOneDecrement() {
        int n = this.collectorCoordinates.navigation_destinput_gps_coordinates_lat_degree_one;
        boolean bl = true;
        boolean bl2 = false;
        int n2 = 9;
        int n3 = this.decrement(n, 1, 9, 0);
        this.modelNotifier.notifyLatitudeDegreeOneChanged(n3);
    }

    public void latitudeDegreeOneIncrement() {
        int n = this.collectorCoordinates.navigation_destinput_gps_coordinates_lat_degree_one;
        boolean bl = true;
        boolean bl2 = false;
        int n2 = 9;
        int n3 = this.increment(n, 1, 9, 0);
        this.modelNotifier.notifyLatitudeDegreeOneChanged(n3);
    }

    public void latitudeDegreeTenDecrement() {
        int n = this.collectorCoordinates.navigation_destinput_gps_coordinates_lat_degree_ten;
        boolean bl = true;
        boolean bl2 = false;
        int n2 = 8;
        int n3 = this.decrement(n, 1, 8, 0);
        this.modelNotifier.notifyLatitudeDegreeTenChanged(n3);
    }

    public void latitudeDegreeTenIncrement() {
        int n = this.collectorCoordinates.navigation_destinput_gps_coordinates_lat_degree_ten;
        boolean bl = true;
        boolean bl2 = false;
        int n2 = 8;
        int n3 = this.increment(n, 1, 8, 0);
        this.modelNotifier.notifyLatitudeDegreeTenChanged(n3);
    }

    public void latitudeHemisphereDecrement() {
        this.latitudeHemisphereToggle();
    }

    public void latitudeHemisphereIncrement() {
        this.latitudeHemisphereToggle();
    }

    private void latitudeHemisphereToggle() {
        int n = this.collectorCoordinates.navigation_destinput_gps_coordinates_lat_hemisphere;
        n = n == 0 ? 1 : 0;
        this.modelNotifier.notifyLatitudeHemisphereChanged(n);
    }

    public void latitudeMinutesOneDecrement() {
        int n = this.collectorCoordinates.navigation_destinput_gps_coordinates_lat_min_one;
        boolean bl = true;
        boolean bl2 = false;
        int n2 = 9;
        int n3 = this.decrement(n, 1, 9, 0);
        this.modelNotifier.notifyLatitudeMinutesOneChanged(n3);
    }

    public void latitudeMinutesOneIncrement() {
        int n = this.collectorCoordinates.navigation_destinput_gps_coordinates_lat_min_one;
        boolean bl = true;
        boolean bl2 = false;
        int n2 = 9;
        int n3 = this.increment(n, 1, 9, 0);
        this.modelNotifier.notifyLatitudeMinutesOneChanged(n3);
    }

    public void latitudeMinutesTenDecrement() {
        int n = this.collectorCoordinates.navigation_destinput_gps_coordinates_lat_min_ten;
        boolean bl = true;
        boolean bl2 = false;
        int n2 = 5;
        int n3 = this.decrement(n, 1, 5, 0);
        this.modelNotifier.notifyLatitudeMinutesTenChanged(n3);
    }

    public void latitudeMinutesTenIncrement() {
        int n = this.collectorCoordinates.navigation_destinput_gps_coordinates_lat_min_ten;
        boolean bl = true;
        boolean bl2 = false;
        int n2 = 5;
        int n3 = this.increment(n, 1, 5, 0);
        this.modelNotifier.notifyLatitudeMinutesTenChanged(n3);
    }

    public void latitudeSecondsOneDecrement() {
        int n = this.collectorCoordinates.navigation_destinput_gps_coordinates_lat_sec_one;
        boolean bl = true;
        boolean bl2 = false;
        int n2 = 9;
        int n3 = this.decrement(n, 1, 9, 0);
        this.modelNotifier.notifyLatitudeSecondsOneChanged(n3);
    }

    public void latitudeSecondsOneIncrement() {
        int n = this.collectorCoordinates.navigation_destinput_gps_coordinates_lat_sec_one;
        boolean bl = true;
        boolean bl2 = false;
        int n2 = 9;
        int n3 = this.increment(n, 1, 9, 0);
        this.modelNotifier.notifyLatitudeSecondsOneChanged(n3);
    }

    public void latitudeSecondTenDecrement() {
        int n = this.collectorCoordinates.navigation_destinput_gps_coordinates_lat_sec_ten;
        boolean bl = true;
        boolean bl2 = false;
        int n2 = 5;
        int n3 = this.decrement(n, 1, 5, 0);
        this.modelNotifier.notifyLatitudeSecondsTenChanged(n3);
    }

    public void latitudeSecondTenIncrement() {
        int n = this.collectorCoordinates.navigation_destinput_gps_coordinates_lat_sec_ten;
        boolean bl = true;
        boolean bl2 = false;
        int n2 = 5;
        int n3 = this.increment(n, 1, 5, 0);
        this.modelNotifier.notifyLatitudeSecondsTenChanged(n3);
    }

    public void latitudeSecondTenthDecrement() {
        int n = this.collectorCoordinates.navigation_destinput_gps_coordinates_lat_sec_tenth;
        boolean bl = true;
        boolean bl2 = false;
        int n2 = 9;
        int n3 = this.decrement(n, 1, 9, 0);
        this.modelNotifier.notifyLatitudeSecondsTenthChanged(n3);
    }

    public void latitudeSecondTenthIncrement() {
        int n = this.collectorCoordinates.navigation_destinput_gps_coordinates_lat_sec_tenth;
        boolean bl = true;
        boolean bl2 = false;
        int n2 = 9;
        int n3 = this.increment(n, 1, 9, 0);
        this.modelNotifier.notifyLatitudeSecondsTenthChanged(n3);
    }

    public void longitudeDegreeHundredDecrement() {
        int n = this.collectorCoordinates.navigation_destinput_gps_coordinates_lon_degree_hundred;
        boolean bl = true;
        boolean bl2 = false;
        boolean bl3 = true;
        int n2 = this.decrement(n, 1, 1, 0);
        if (n2 == 1 && this.collectorCoordinates.navigation_destinput_gps_coordinates_lon_degree_ten > 7) {
            this.collectorCoordinates.navigation_destinput_gps_coordinates_lon_degree_ten = 7;
            this.collectorCoordinates.navigation_destinput_gps_coordinates_lon_degree_one = 9;
        }
        this.modelNotifier.notifyLongitudeDegreeHundredChanged(n2);
    }

    public void longitudeDegreeHundredIncrement() {
        int n = this.collectorCoordinates.navigation_destinput_gps_coordinates_lon_degree_hundred;
        boolean bl = true;
        boolean bl2 = false;
        boolean bl3 = true;
        int n2 = this.increment(n, 1, 1, 0);
        if (n2 == 1 && this.collectorCoordinates.navigation_destinput_gps_coordinates_lon_degree_ten > 7) {
            this.collectorCoordinates.navigation_destinput_gps_coordinates_lon_degree_ten = 7;
            this.collectorCoordinates.navigation_destinput_gps_coordinates_lon_degree_one = 9;
        }
        this.modelNotifier.notifyLongitudeDegreeHundredChanged(n2);
    }

    public void longitudeDegreeOneDecrement() {
        int n = this.collectorCoordinates.navigation_destinput_gps_coordinates_lon_degree_one;
        boolean bl = true;
        boolean bl2 = false;
        int n2 = 9;
        int n3 = this.decrement(n, 1, 9, 0);
        this.modelNotifier.notifyLongitudeDegreeOneChanged(n3);
    }

    public void longitudeDegreeOneIncrement() {
        int n = this.collectorCoordinates.navigation_destinput_gps_coordinates_lon_degree_one;
        boolean bl = true;
        boolean bl2 = false;
        int n2 = 9;
        int n3 = this.increment(n, 1, 9, 0);
        this.modelNotifier.notifyLongitudeDegreeOneChanged(n3);
    }

    public void longitudeDegreeTenDecrement() {
        int n = this.collectorCoordinates.navigation_destinput_gps_coordinates_lon_degree_ten;
        boolean bl = true;
        boolean bl2 = false;
        int n2 = 9;
        if (this.collectorCoordinates.navigation_destinput_gps_coordinates_lon_degree_hundred == 1) {
            n2 = 7;
        }
        int n3 = this.decrement(n, 1, n2, 0);
        this.modelNotifier.notifyLongitudeDegreeTenChanged(n3);
    }

    public void longitudeDegreeTenIncrement() {
        int n = this.collectorCoordinates.navigation_destinput_gps_coordinates_lon_degree_ten;
        boolean bl = true;
        boolean bl2 = false;
        int n2 = 9;
        if (this.collectorCoordinates.navigation_destinput_gps_coordinates_lon_degree_hundred == 1) {
            n2 = 7;
        }
        int n3 = this.increment(n, 1, n2, 0);
        this.modelNotifier.notifyLongitudeDegreeTenChanged(n3);
    }

    public void longitudeHemisphereDecrement() {
        this.longitudeHemisphereToggle();
    }

    public void longitudeHemisphereIncrement() {
        this.longitudeHemisphereToggle();
    }

    private void longitudeHemisphereToggle() {
        int n = this.collectorCoordinates.navigation_destinput_gps_coordinates_lon_hemisphere;
        n = n == 0 ? 1 : 0;
        this.modelNotifier.notifyLongitudeHemisphereChanged(n);
    }

    public void longitudeMinuteOneIncrement() {
        int n = this.collectorCoordinates.navigation_destinput_gps_coordinates_lon_min_one;
        boolean bl = true;
        boolean bl2 = false;
        int n2 = 9;
        int n3 = this.increment(n, 1, 9, 0);
        this.modelNotifier.notifyLongitudeMinutesOneChanged(n3);
    }

    public void longitudeMinutesOneDecrement() {
        int n = this.collectorCoordinates.navigation_destinput_gps_coordinates_lon_min_one;
        boolean bl = true;
        boolean bl2 = false;
        int n2 = 9;
        int n3 = this.decrement(n, 1, 9, 0);
        this.modelNotifier.notifyLongitudeMinutesOneChanged(n3);
    }

    public void longitudeMinuteTenDecrement() {
        int n = this.collectorCoordinates.navigation_destinput_gps_coordinates_lon_min_ten;
        boolean bl = true;
        boolean bl2 = false;
        int n2 = 5;
        int n3 = this.decrement(n, 1, 5, 0);
        this.modelNotifier.notifyLongitudeMinutesTenChanged(n3);
    }

    public void longitudeMinuteTenIncrement() {
        int n = this.collectorCoordinates.navigation_destinput_gps_coordinates_lon_min_ten;
        boolean bl = true;
        boolean bl2 = false;
        int n2 = 5;
        int n3 = this.increment(n, 1, 5, 0);
        this.modelNotifier.notifyLongitudeMinutesTenChanged(n3);
    }

    public void longitudeSecondsOneDecrement() {
        int n = this.collectorCoordinates.navigation_destinput_gps_coordinates_lon_sec_one;
        boolean bl = true;
        boolean bl2 = false;
        int n2 = 9;
        int n3 = this.decrement(n, 1, 9, 0);
        this.modelNotifier.notifyLongitudeSecondsOneChanged(n3);
    }

    public void longitudeSecondsOneIncrement() {
        int n = this.collectorCoordinates.navigation_destinput_gps_coordinates_lon_sec_one;
        boolean bl = true;
        boolean bl2 = false;
        int n2 = 9;
        int n3 = this.increment(n, 1, 9, 0);
        this.modelNotifier.notifyLongitudeSecondsOneChanged(n3);
    }

    public void longitudeSecondTenDecrement() {
        int n = this.collectorCoordinates.navigation_destinput_gps_coordinates_lon_sec_ten;
        boolean bl = true;
        boolean bl2 = false;
        int n2 = 5;
        int n3 = this.decrement(n, 1, 5, 0);
        this.modelNotifier.notifyLongitudeSecondsTenChanged(n3);
    }

    public void longitudeSecondTenIncrement() {
        int n = this.collectorCoordinates.navigation_destinput_gps_coordinates_lon_sec_ten;
        boolean bl = true;
        boolean bl2 = false;
        int n2 = 5;
        int n3 = this.increment(n, 1, 5, 0);
        this.modelNotifier.notifyLongitudeSecondsTenChanged(n3);
    }

    public void longitudeSecondTenthDecrement() {
        int n = this.collectorCoordinates.navigation_destinput_gps_coordinates_lon_sec_tenth;
        boolean bl = true;
        boolean bl2 = false;
        int n2 = 9;
        int n3 = this.decrement(n, 1, 9, 0);
        this.modelNotifier.notifyLongitudeSecondsTenthChanged(n3);
    }

    public void longitudeSecondTenthIncrement() {
        int n = this.collectorCoordinates.navigation_destinput_gps_coordinates_lon_sec_tenth;
        boolean bl = true;
        boolean bl2 = false;
        int n2 = 9;
        int n3 = this.increment(n, 1, 9, 0);
        this.modelNotifier.notifyLongitudeSecondsTenthChanged(n3);
    }

    private void updateLatitudeValues() {
        int n = this.collectorCoordinates.navigation_destinput_gps_coordinates_lat_degree_ten * 10 + this.collectorCoordinates.navigation_destinput_gps_coordinates_lat_degree_one;
        int n2 = this.collectorCoordinates.navigation_destinput_gps_coordinates_lat_min_ten * 10 + this.collectorCoordinates.navigation_destinput_gps_coordinates_lat_min_one;
        int n3 = this.collectorCoordinates.navigation_destinput_gps_coordinates_lat_sec_ten * 100 + this.collectorCoordinates.navigation_destinput_gps_coordinates_lat_sec_one * 10 + this.collectorCoordinates.navigation_destinput_gps_coordinates_lat_sec_tenth;
        this.collectorCoordinates.navigation_destinput_gps_coordinates_lat_degree = n;
        this.collectorCoordinates.navigation_destinput_gps_coordinates_lat_min = n2;
        this.collectorCoordinates.navigation_destinput_gps_coordinates_lat_sec = n3;
    }

    private void updateLongitudeValues() {
        int n = this.collectorCoordinates.navigation_destinput_gps_coordinates_lon_degree_hundred * 100 + this.collectorCoordinates.navigation_destinput_gps_coordinates_lon_degree_ten * 10 + this.collectorCoordinates.navigation_destinput_gps_coordinates_lon_degree_one;
        int n2 = this.collectorCoordinates.navigation_destinput_gps_coordinates_lon_min_ten * 10 + this.collectorCoordinates.navigation_destinput_gps_coordinates_lon_min_one;
        int n3 = this.collectorCoordinates.navigation_destinput_gps_coordinates_lon_sec_ten * 100 + this.collectorCoordinates.navigation_destinput_gps_coordinates_lon_sec_one * 10 + this.collectorCoordinates.navigation_destinput_gps_coordinates_lon_sec_tenth;
        this.collectorCoordinates.navigation_destinput_gps_coordinates_lon_degree = n;
        this.collectorCoordinates.navigation_destinput_gps_coordinates_lon_min = n2;
        this.collectorCoordinates.navigation_destinput_gps_coordinates_lon_sec = n3;
    }
}

