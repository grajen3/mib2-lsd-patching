/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.appadapter.carstatustiles;

import de.vw.mib.app.appadapter.AppAdapterSystemServices;
import de.vw.mib.asl.api.car.ASLCarFactory;
import de.vw.mib.asl.api.car.vehicle.VehicleServiceListenerAdapter;
import de.vw.mib.log4mib.Logger;
import generated.de.vw.mib.appadapter.carstatustiles.ViewOptionsModelApiCallback;

public class CarStatusViewOptionsService
extends VehicleServiceListenerAdapter {
    private AppAdapterSystemServices systemServices;
    private ViewOptionsModelApiCallback viewOptionsModelApiCallback;
    private boolean[] lastFunctionAvailability = new boolean[]{true, true};
    private boolean[] lastFunctionExistence = new boolean[]{true, true};
    static /* synthetic */ Class class$generated$de$vw$mib$appadapter$carstatustiles$ViewOptionsModelApiCallback;

    public CarStatusViewOptionsService(AppAdapterSystemServices appAdapterSystemServices) {
        this.systemServices = appAdapterSystemServices;
    }

    public void start() {
        ASLCarFactory.getCarVehicleApi().addVehicleServiceListener(this);
        this.getCarStatusViewOptionsModelApiCallback()._update_getOillevelFunctionAvailableReason(0);
        this.getCarStatusViewOptionsModelApiCallback()._update_getRDKFunctionAvailableReason(0);
        this.getCarStatusViewOptionsModelApiCallback()._update_getFunctionAvailability(this.lastFunctionAvailability);
        this.getCarStatusViewOptionsModelApiCallback()._update_getFunctionExistence(this.lastFunctionExistence);
        this.getCarStatusViewOptionsModelApiCallback()._update_getOillevelFunctionAvailableReason(0);
        this.getCarStatusViewOptionsModelApiCallback()._update_getRDKFunctionAvailableReason(0);
    }

    private Logger getLogger() {
        return this.systemServices.createLogger(0xA004000);
    }

    private ViewOptionsModelApiCallback getCarStatusViewOptionsModelApiCallback() {
        if (this.viewOptionsModelApiCallback == null) {
            this.viewOptionsModelApiCallback = (ViewOptionsModelApiCallback)this.systemServices.createModelApiClient(class$generated$de$vw$mib$appadapter$carstatustiles$ViewOptionsModelApiCallback == null ? (class$generated$de$vw$mib$appadapter$carstatustiles$ViewOptionsModelApiCallback = CarStatusViewOptionsService.class$("generated.de.vw.mib.appadapter.carstatustiles.ViewOptionsModelApiCallback")) : class$generated$de$vw$mib$appadapter$carstatustiles$ViewOptionsModelApiCallback);
        }
        return this.viewOptionsModelApiCallback;
    }

    @Override
    public void updateCarStatusTileSFunctionAvailabilty(int n, boolean bl) {
        this.lastFunctionAvailability[n] = bl;
        this.getCarStatusViewOptionsModelApiCallback()._update_getFunctionAvailability(this.lastFunctionAvailability);
    }

    @Override
    public void updateCarStatusTileSFunctionExistence(int n, boolean bl) {
        this.lastFunctionExistence[n] = bl;
        this.getCarStatusViewOptionsModelApiCallback()._update_getFunctionExistence(this.lastFunctionExistence);
    }

    @Override
    public void updateOillevelFunctionAvailableReason(int n) {
        this.getCarStatusViewOptionsModelApiCallback()._update_getOillevelFunctionAvailableReason(n);
    }

    @Override
    public void updateRDKFunctionAvailableReason(int n) {
        this.getCarStatusViewOptionsModelApiCallback()._update_getRDKFunctionAvailableReason(n);
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

