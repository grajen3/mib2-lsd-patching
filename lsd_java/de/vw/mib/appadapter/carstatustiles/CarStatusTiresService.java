/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.appadapter.carstatustiles;

import de.vw.mib.app.appadapter.AppAdapterSystemServices;
import de.vw.mib.appadapter.carstatustiles.CarStatusTiresService$1;
import de.vw.mib.asl.api.car.ASLCarFactory;
import de.vw.mib.asl.api.car.rdk.RDKServiceListenerAdapter;
import de.vw.mib.asl.api.system.ASLSystemFactory;
import de.vw.mib.log4mib.Logger;
import generated.de.vw.mib.appadapter.carstatustiles.CarStatusTiresModelApiCallback;

public class CarStatusTiresService
extends RDKServiceListenerAdapter {
    private AppAdapterSystemServices systemServices;
    private CarStatusTiresModelApiCallback carStatusTiresModelApiCallback;
    private boolean isInitializing;
    static /* synthetic */ Class class$generated$de$vw$mib$appadapter$carstatustiles$CarStatusTiresModelApiCallback;

    public CarStatusTiresService(AppAdapterSystemServices appAdapterSystemServices) {
        this.systemServices = appAdapterSystemServices;
    }

    public void start() {
        ASLSystemFactory.getSystemApi().getClampSignalService().addListener(new CarStatusTiresService$1(this));
        ASLCarFactory.getRDKApi().addRDKServiceListener(this);
        this.updateRDKSTires(ASLCarFactory.getRDKApi().getRDKService().getRDKSTires());
        this.updateRKA_RDKS_States(ASLCarFactory.getRDKApi().getRDKService().getRKA_RDKS_States());
        this.updateRDKSystem(ASLCarFactory.getRDKApi().getRDKService().getRDKSystem());
        this.updateIsRDKSFSGControlOn(ASLCarFactory.getRDKApi().getRDKService().isRDKSFSGControlOn());
    }

    private Logger getLogger() {
        return this.systemServices.createLogger(0xA004000);
    }

    private CarStatusTiresModelApiCallback getCarStatusTiresModelApiCallback() {
        if (this.carStatusTiresModelApiCallback == null) {
            this.carStatusTiresModelApiCallback = (CarStatusTiresModelApiCallback)this.systemServices.createModelApiClient(class$generated$de$vw$mib$appadapter$carstatustiles$CarStatusTiresModelApiCallback == null ? (class$generated$de$vw$mib$appadapter$carstatustiles$CarStatusTiresModelApiCallback = CarStatusTiresService.class$("generated.de.vw.mib.appadapter.carstatustiles.CarStatusTiresModelApiCallback")) : class$generated$de$vw$mib$appadapter$carstatustiles$CarStatusTiresModelApiCallback);
        }
        return this.carStatusTiresModelApiCallback;
    }

    @Override
    public void updateRKA_RDKS_States(Boolean[] booleanArray) {
        if (booleanArray != null) {
            this.getCarStatusTiresModelApiCallback()._update_getRKA_RDKS_States(new boolean[]{booleanArray[0], booleanArray[1]});
        }
    }

    @Override
    public void updateRDKSTires(int[] nArray) {
        if (nArray != null) {
            this.getCarStatusTiresModelApiCallback()._update_getRDKSTires(nArray[0], nArray[1], nArray[2], nArray[3], nArray[4], nArray[5], nArray[6], nArray[7], nArray[8], nArray[9], nArray[10], nArray[11], nArray[12], nArray[13], nArray[14], nArray[15], nArray[16], nArray[17]);
        }
    }

    @Override
    public void updateIsRDKSFSGControlOn(boolean bl) {
        this.getCarStatusTiresModelApiCallback()._update_isRDKSFSGControlOn(bl);
    }

    @Override
    public void updateRDKSystem(int n) {
        int n2 = this.mapRDKStateToModel(n);
        this.getCarStatusTiresModelApiCallback()._update_getRDKSystem(n2);
    }

    private int mapRDKStateToModel(int n) {
        int n2 = n;
        if (n == 2) {
            n2 = 1;
        } else if (n == 1) {
            n2 = 0;
        }
        return n2;
    }

    static /* synthetic */ boolean access$000(CarStatusTiresService carStatusTiresService) {
        return carStatusTiresService.isInitializing;
    }

    static /* synthetic */ CarStatusTiresModelApiCallback access$100(CarStatusTiresService carStatusTiresService) {
        return carStatusTiresService.getCarStatusTiresModelApiCallback();
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

