/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.appadapter.carstatustiles;

import de.vw.mib.app.appadapter.AppAdapterSystemServices;
import de.vw.mib.appadapter.carstatustiles.CarStatusMainService$1;
import de.vw.mib.asl.api.car.ASLCarFactory;
import de.vw.mib.asl.api.car.vehicle.ASLCarVehicleAPI;
import de.vw.mib.asl.api.car.vehicle.VehicleServiceListenerAdapter;
import de.vw.mib.asl.api.system.ASLSystemFactory;
import generated.de.vw.mib.appadapter.carstatustiles.CarStatusMainModelApiCallback;

public class CarStatusMainService
extends VehicleServiceListenerAdapter {
    private AppAdapterSystemServices systemServices;
    private CarStatusMainModelApiCallback carStatusMainModelApiCallback;
    private boolean isInitializing;
    static /* synthetic */ Class class$generated$de$vw$mib$appadapter$carstatustiles$CarStatusMainModelApiCallback;

    public CarStatusMainService(AppAdapterSystemServices appAdapterSystemServices) {
        this.systemServices = appAdapterSystemServices;
    }

    public void start() {
        ASLSystemFactory.getSystemApi().getClampSignalService().addListener(new CarStatusMainService$1(this));
        this.getCarVehicleAPI().addVehicleServiceListener(this);
        this.updateWarningCount(this.getCarVehicleAPI().getVehicleService().getWarningCount());
        this.updateSystemState(this.getCarVehicleAPI().getVehicleService().getSystemState()[0], this.getCarVehicleAPI().getVehicleService().getSystemState()[1]);
    }

    ASLCarVehicleAPI getCarVehicleAPI() {
        return ASLCarFactory.getCarVehicleApi();
    }

    CarStatusMainModelApiCallback getCarStatusMainModelApiCallback() {
        if (this.carStatusMainModelApiCallback == null) {
            this.carStatusMainModelApiCallback = (CarStatusMainModelApiCallback)this.systemServices.createModelApiClient(class$generated$de$vw$mib$appadapter$carstatustiles$CarStatusMainModelApiCallback == null ? (class$generated$de$vw$mib$appadapter$carstatustiles$CarStatusMainModelApiCallback = CarStatusMainService.class$("generated.de.vw.mib.appadapter.carstatustiles.CarStatusMainModelApiCallback")) : class$generated$de$vw$mib$appadapter$carstatustiles$CarStatusMainModelApiCallback);
        }
        return this.carStatusMainModelApiCallback;
    }

    @Override
    public void updateWarningCount(int n) {
        this.getCarStatusMainModelApiCallback()._update_getWarningCount(n);
    }

    @Override
    public void updateSystemState(boolean bl, boolean bl2) {
        this.isInitializing = bl;
        this.getCarStatusMainModelApiCallback()._update_getSystemStates(new boolean[]{bl, bl2});
    }

    static /* synthetic */ boolean access$000(CarStatusMainService carStatusMainService) {
        return carStatusMainService.isInitializing;
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

