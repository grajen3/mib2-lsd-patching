/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.appadapter.thinkbluetiles;

import de.vw.mib.app.appadapter.AppAdapterSystemServices;
import de.vw.mib.asl.api.car.ASLCarFactory;
import de.vw.mib.asl.api.car.thinkblue.TBTServiceListenerAdapter;
import de.vw.mib.log4mib.Logger;
import generated.de.vw.mib.appadapter.thinkbluetiles.CarTBTBluePointsModelApiCallback;

public class CarTBTBluePointsService
extends TBTServiceListenerAdapter {
    private AppAdapterSystemServices systemServices;
    private CarTBTBluePointsModelApiCallback carTBTBluePointsModelApiCallback;
    static /* synthetic */ Class class$generated$de$vw$mib$appadapter$thinkbluetiles$CarTBTBluePointsModelApiCallback;

    public CarTBTBluePointsService(AppAdapterSystemServices appAdapterSystemServices) {
        this.systemServices = appAdapterSystemServices;
    }

    public void start() {
        ASLCarFactory.getTBTApi().addTBTServiceListener(this);
        this.updateBluePoints(ASLCarFactory.getTBTApi().getTBTService().getBluePoints());
        this.updateEcoAverageTrip(ASLCarFactory.getTBTApi().getTBTService().getEcoAverageTrip());
    }

    private Logger getLogger() {
        return this.systemServices.createLogger(0xA004000);
    }

    private CarTBTBluePointsModelApiCallback getCarTBTBluePointsModelApiCallback() {
        if (this.carTBTBluePointsModelApiCallback == null) {
            return (CarTBTBluePointsModelApiCallback)this.systemServices.createModelApiClient(class$generated$de$vw$mib$appadapter$thinkbluetiles$CarTBTBluePointsModelApiCallback == null ? (class$generated$de$vw$mib$appadapter$thinkbluetiles$CarTBTBluePointsModelApiCallback = CarTBTBluePointsService.class$("generated.de.vw.mib.appadapter.thinkbluetiles.CarTBTBluePointsModelApiCallback")) : class$generated$de$vw$mib$appadapter$thinkbluetiles$CarTBTBluePointsModelApiCallback);
        }
        return this.carTBTBluePointsModelApiCallback;
    }

    @Override
    public void updateBluePointsTrend(boolean bl) {
        this.getCarTBTBluePointsModelApiCallback()._update_getBluePointsTrend(bl);
    }

    @Override
    public void updateEcoAverageTrip(int n) {
        this.getCarTBTBluePointsModelApiCallback()._update_getEcoAverageTrip(n);
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

