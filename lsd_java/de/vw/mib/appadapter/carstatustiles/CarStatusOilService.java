/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.appadapter.carstatustiles;

import de.vw.mib.app.appadapter.AppAdapterSystemServices;
import de.vw.mib.asl.api.car.ASLCarFactory;
import de.vw.mib.asl.api.car.vehicle.VehicleServiceListenerAdapter;
import de.vw.mib.log4mib.Logger;
import generated.de.vw.mib.appadapter.carstatustiles.CarStatusOilModelApiCallback;

public class CarStatusOilService
extends VehicleServiceListenerAdapter {
    private AppAdapterSystemServices systemServices;
    private CarStatusOilModelApiCallback carStatusOilModelApiCallback;
    static /* synthetic */ Class class$generated$de$vw$mib$appadapter$carstatustiles$CarStatusOilModelApiCallback;

    public CarStatusOilService(AppAdapterSystemServices appAdapterSystemServices) {
        this.systemServices = appAdapterSystemServices;
    }

    public void start() {
        ASLCarFactory.getCarVehicleApi().addVehicleServiceListener(this);
        this.updateOilLevel(ASLCarFactory.getCarVehicleApi().getVehicleService().getOilLevel());
        this.updateOilLevelAvailability(ASLCarFactory.getCarVehicleApi().getVehicleService().getOilLevelAvailability());
        this.updateOilRefillQuantity(ASLCarFactory.getCarVehicleApi().getVehicleService().getOilRefillQuantity());
        this.updateOilRefillUnit(ASLCarFactory.getCarVehicleApi().getVehicleService().getOilRefillUnit());
        this.updateOilWarning(ASLCarFactory.getCarVehicleApi().getVehicleService().getOilWarning());
    }

    private Logger getLogger() {
        return this.systemServices.createLogger(0xA004000);
    }

    private CarStatusOilModelApiCallback getCarStatusOilModelApiCallback() {
        if (this.carStatusOilModelApiCallback == null) {
            this.carStatusOilModelApiCallback = (CarStatusOilModelApiCallback)this.systemServices.createModelApiClient(class$generated$de$vw$mib$appadapter$carstatustiles$CarStatusOilModelApiCallback == null ? (class$generated$de$vw$mib$appadapter$carstatustiles$CarStatusOilModelApiCallback = CarStatusOilService.class$("generated.de.vw.mib.appadapter.carstatustiles.CarStatusOilModelApiCallback")) : class$generated$de$vw$mib$appadapter$carstatustiles$CarStatusOilModelApiCallback);
        }
        return this.carStatusOilModelApiCallback;
    }

    @Override
    public void updateOilLevel(int n) {
        this.getCarStatusOilModelApiCallback()._update_getOilLevel(n);
    }

    @Override
    public void updateOilLevelAvailability(int n) {
        this.getCarStatusOilModelApiCallback()._update_getOilLevelAvailability(n);
    }

    @Override
    public void updateOilWarning(int n) {
        this.getCarStatusOilModelApiCallback()._update_getOilWarning(n);
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

