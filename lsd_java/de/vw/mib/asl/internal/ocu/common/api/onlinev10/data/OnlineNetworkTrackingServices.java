/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.common.api.onlinev10.data;

public class OnlineNetworkTrackingServices
implements de.vw.mib.asl.api.ocu.onlinev10.data.OnlineNetworkTrackingServices {
    private final boolean valetAlertActive;
    private final boolean speedAlertActive;
    private final boolean geofenceActive;
    private final boolean vehicleLocationAndTrackingActive;
    private final boolean timefenceActive;
    private final boolean driversLogbookActive;
    private final boolean driverEfficiencyReportActive;
    private final boolean personalDataBasedServicesActive;
    private final boolean positioningDataBasedServicesActive;

    public OnlineNetworkTrackingServices(boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6, boolean bl7, boolean bl8, boolean bl9) {
        this.valetAlertActive = bl;
        this.speedAlertActive = bl2;
        this.geofenceActive = bl3;
        this.vehicleLocationAndTrackingActive = bl4;
        this.timefenceActive = bl5;
        this.driversLogbookActive = bl6;
        this.driverEfficiencyReportActive = bl7;
        this.personalDataBasedServicesActive = bl8;
        this.positioningDataBasedServicesActive = bl9;
    }

    @Override
    public boolean isValetAlertActive() {
        return this.valetAlertActive;
    }

    @Override
    public boolean isSpeedAlertActive() {
        return this.speedAlertActive;
    }

    @Override
    public boolean isGeofenceActive() {
        return this.geofenceActive;
    }

    @Override
    public boolean isPositionDataBasedServicesActive() {
        return this.positioningDataBasedServicesActive;
    }

    @Override
    public boolean isPersonalDataBasedServicesActive() {
        return this.personalDataBasedServicesActive;
    }

    @Override
    public boolean isVehicleLocationAndTrackingActive() {
        return this.vehicleLocationAndTrackingActive;
    }

    @Override
    public boolean isTimefenceActive() {
        return this.timefenceActive;
    }

    @Override
    public boolean isDriversLogbookActive() {
        return this.driversLogbookActive;
    }

    @Override
    public boolean isDriversEfficiencyReportActive() {
        return this.driverEfficiencyReportActive;
    }

    public boolean equals(Object object) {
        OnlineNetworkTrackingServices onlineNetworkTrackingServices = (OnlineNetworkTrackingServices)object;
        return onlineNetworkTrackingServices.valetAlertActive == this.valetAlertActive && onlineNetworkTrackingServices.speedAlertActive == this.speedAlertActive && onlineNetworkTrackingServices.geofenceActive == this.geofenceActive && onlineNetworkTrackingServices.vehicleLocationAndTrackingActive == this.vehicleLocationAndTrackingActive && onlineNetworkTrackingServices.timefenceActive == this.timefenceActive && onlineNetworkTrackingServices.driversLogbookActive == this.driversLogbookActive && onlineNetworkTrackingServices.driverEfficiencyReportActive == this.driverEfficiencyReportActive && onlineNetworkTrackingServices.personalDataBasedServicesActive == this.personalDataBasedServicesActive && onlineNetworkTrackingServices.positioningDataBasedServicesActive == this.positioningDataBasedServicesActive;
    }

    public int hashCode() {
        return super.hashCode();
    }
}

