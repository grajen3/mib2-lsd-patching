/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.appadapter.thinkbluetiles;

import de.vw.mib.app.appadapter.AppAdapterSystemServices;
import de.vw.mib.appadapter.thinkbluetiles.TBTBordComputerServiceListenerAdapter;
import de.vw.mib.asl.api.car.ASLCarFactory;
import de.vw.mib.asl.api.car.thinkblue.TBTServiceListenerAdapter;
import de.vw.mib.log4mib.Logger;
import generated.de.vw.mib.appadapter.thinkbluetiles.CarTBTConsumptionModelApiCallback;

public class CarTBTConsumptionService
extends TBTServiceListenerAdapter {
    private AppAdapterSystemServices systemServices;
    private CarTBTConsumptionModelApiCallback carTBTConsumptionModelApiCallback;
    private TBTBordComputerServiceListenerAdapter bordComputerListener;
    static /* synthetic */ Class class$generated$de$vw$mib$appadapter$thinkbluetiles$CarTBTConsumptionModelApiCallback;

    public CarTBTConsumptionService(AppAdapterSystemServices appAdapterSystemServices) {
        this.systemServices = appAdapterSystemServices;
        this.bordComputerListener = new TBTBordComputerServiceListenerAdapter(this);
    }

    public void start() {
        ASLCarFactory.getTBTApi().addTBTServiceListener(this);
        this.bordComputerListener.start();
        this.updateConsumptionTrend(ASLCarFactory.getTBTApi().getTBTService().getConsumptionTrend());
        this.updateCurrentConsumption(ASLCarFactory.getTBTApi().getTBTService().getCurrentConsumption());
        this.updateCurrentConsumptionDecimal(ASLCarFactory.getTBTApi().getTBTService().getCurrentConsumptionDecimal());
        this.bordComputerListener.updateBCMenu1(ASLCarFactory.getBordComputerAPI().getService().getBCMenu1());
    }

    private Logger getLogger() {
        return this.systemServices.createLogger(0xA004000);
    }

    private CarTBTConsumptionModelApiCallback getCarTBTConsumptionModelApiCallback() {
        if (this.carTBTConsumptionModelApiCallback == null) {
            this.carTBTConsumptionModelApiCallback = (CarTBTConsumptionModelApiCallback)this.systemServices.createModelApiClient(class$generated$de$vw$mib$appadapter$thinkbluetiles$CarTBTConsumptionModelApiCallback == null ? (class$generated$de$vw$mib$appadapter$thinkbluetiles$CarTBTConsumptionModelApiCallback = CarTBTConsumptionService.class$("generated.de.vw.mib.appadapter.thinkbluetiles.CarTBTConsumptionModelApiCallback")) : class$generated$de$vw$mib$appadapter$thinkbluetiles$CarTBTConsumptionModelApiCallback);
        }
        return this.carTBTConsumptionModelApiCallback;
    }

    @Override
    public void updateConsumptionTrend(boolean bl) {
        this.getCarTBTConsumptionModelApiCallback()._update_getConsumptionTrend(bl);
    }

    @Override
    public void updateCurrentConsumption(int n) {
        this.getCarTBTConsumptionModelApiCallback()._update_getCurrentConsumption(n);
    }

    @Override
    public void updateCurrentConsumptionDecimal(int n) {
        this.getCarTBTConsumptionModelApiCallback()._update_getCurrentConsumptionDecimal(n);
    }

    void updateCurrentConsumptionUnit(int n) {
        this.getCarTBTConsumptionModelApiCallback()._update_getCurrentConsumptionUnit(n);
        this.getCarTBTConsumptionModelApiCallback()._update_getCurrentHybridConsumptionUnit(n);
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

