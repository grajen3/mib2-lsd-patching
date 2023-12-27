/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system.valetparking;

import de.vw.mib.asl.api.car.vehicle.ASLCarVehicleAPI;
import de.vw.mib.asl.api.car.vehicle.VehicleServiceListenerAdapter;
import de.vw.mib.asl.internal.system.util.Preconditions;
import de.vw.mib.asl.internal.system.valetparking.ValetParkingServiceImpl;

public class ValetParkingVehicleListener
extends VehicleServiceListenerAdapter {
    private final ValetParkingServiceImpl valetParkingService;
    private final ASLCarVehicleAPI vehicleApi;
    boolean vehicleServiceEnabled;

    ValetParkingVehicleListener(ValetParkingServiceImpl valetParkingServiceImpl, ASLCarVehicleAPI aSLCarVehicleAPI) {
        Preconditions.checkArgumentNotNull(valetParkingServiceImpl);
        Preconditions.checkArgumentNotNull(aSLCarVehicleAPI);
        this.vehicleApi = aSLCarVehicleAPI;
        this.valetParkingService = valetParkingServiceImpl;
        this.vehicleServiceEnabled = aSLCarVehicleAPI.getVehicleService().isValetParkingAvailable();
    }

    @Override
    public void updateValetParkingAvailable(boolean bl) {
        this.vehicleServiceEnabled = bl;
        if (this.vehicleServiceEnabled) {
            boolean bl2 = this.vehicleApi.getVehicleService().isValetParkingActive();
            this.valetParkingService.notifyServiceOnValetParkingStateChanged(bl2);
        }
    }

    @Override
    public void updateValetParkingActive(boolean bl) {
        if (this.vehicleServiceEnabled) {
            this.valetParkingService.notifyServiceOnValetParkingStateChanged(bl);
        }
    }
}

