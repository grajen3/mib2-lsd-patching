/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.appadapter.thinkbluetiles;

import de.vw.mib.app.appadapter.AppAdapterSystemServices;
import de.vw.mib.asl.api.car.ASLCarFactory;
import de.vw.mib.asl.api.car.thinkblue.TBTServiceListenerAdapter;
import de.vw.mib.log4mib.Logger;
import generated.de.vw.mib.appadapter.thinkbluetiles.CarTBTIrisModelApiCallback;
import generated.de.vw.mib.appadapter.thinkbluetiles.CarTBTIrisModelApiService;

public class CarTBTIrisService
extends TBTServiceListenerAdapter
implements CarTBTIrisModelApiService {
    private AppAdapterSystemServices systemServices;
    private CarTBTIrisModelApiCallback carTBTIrisModelApiCallback;
    static /* synthetic */ Class class$generated$de$vw$mib$appadapter$thinkbluetiles$CarTBTIrisModelApiCallback;

    public CarTBTIrisService(AppAdapterSystemServices appAdapterSystemServices) {
        this.systemServices = appAdapterSystemServices;
    }

    public void start() {
        ASLCarFactory.getTBTApi().addTBTServiceListener(this);
        this.updateBluePoints(ASLCarFactory.getTBTApi().getTBTService().getBluePoints());
        this.updateCurrentGear(ASLCarFactory.getTBTApi().getTBTService().getCurrentGear());
        this.updateCurrentIrisSegment(ASLCarFactory.getTBTApi().getTBTService().getCurrentIrisSegment());
        this.updateIrisSegmentsValues(ASLCarFactory.getTBTApi().getTBTService().getIrisSegmentsValues());
        this.updateMaxAcceleration(ASLCarFactory.getTBTApi().getTBTService().getMaxAcceleration());
        this.updateRecommendedGear(ASLCarFactory.getTBTApi().getTBTService().getRecommendedGear());
        this.updateDisplayDurationHintIcon(ASLCarFactory.getTBTApi().getTBTService().getDisplayDurationHintIcon());
        this.updateDrivingBehaviorMode(ASLCarFactory.getTBTApi().getTBTService().getDrivingBehaviorMode());
        this.updateCurrentAcceleration(ASLCarFactory.getTBTApi().getTBTService().getCurrentAcceleration());
    }

    private Logger getLogger() {
        return this.systemServices.createLogger(0xA004000);
    }

    private CarTBTIrisModelApiCallback getCarTBTConsumptionModelApiCallback() {
        if (this.carTBTIrisModelApiCallback == null) {
            this.carTBTIrisModelApiCallback = (CarTBTIrisModelApiCallback)this.systemServices.createModelApiClient(class$generated$de$vw$mib$appadapter$thinkbluetiles$CarTBTIrisModelApiCallback == null ? (class$generated$de$vw$mib$appadapter$thinkbluetiles$CarTBTIrisModelApiCallback = CarTBTIrisService.class$("generated.de.vw.mib.appadapter.thinkbluetiles.CarTBTIrisModelApiCallback")) : class$generated$de$vw$mib$appadapter$thinkbluetiles$CarTBTIrisModelApiCallback);
        }
        return this.carTBTIrisModelApiCallback;
    }

    @Override
    public void _mda_speedHintIconDisplayed() {
        ASLCarFactory.getTBTApi().getTBTService().speedHintIconDisplayed();
    }

    @Override
    public void _mda_hintIconTimerElapsed() {
        ASLCarFactory.getTBTApi().getTBTService().hintIconTimerElapsed();
    }

    @Override
    public void updateBluePoints(int n) {
        this.getCarTBTConsumptionModelApiCallback()._update_getBluePoints(n);
    }

    @Override
    public void updateCurrentGear(int n) {
        this.getCarTBTConsumptionModelApiCallback()._update_getCurrentGear(n);
    }

    @Override
    public void updateCurrentIrisSegment(int n) {
        this.getCarTBTConsumptionModelApiCallback()._update_getCurrentIrisSegment(n);
    }

    @Override
    public void updateIrisSegmentsValues(int[] nArray) {
        this.getCarTBTConsumptionModelApiCallback()._update_getIrisSegmentsValues(nArray);
    }

    @Override
    public void updateMaxAcceleration(int n) {
        this.getCarTBTConsumptionModelApiCallback()._update_getMaxAcceleration(n);
    }

    @Override
    public void updateRecommendedGear(int n) {
        this.getCarTBTConsumptionModelApiCallback()._update_getRecommendedGear(n);
    }

    @Override
    public void updateDisplayDurationHintIcon(int n) {
        this.getCarTBTConsumptionModelApiCallback()._update_getDisplayDurationHintIcon(n);
    }

    @Override
    public void updateDrivingBehaviorMode(int n) {
        this.getCarTBTConsumptionModelApiCallback()._update_getDrivingBehaviorMode(n);
    }

    @Override
    public void updateCurrentAcceleration(int n) {
        this.getCarTBTConsumptionModelApiCallback()._update_getCurrentAcceleration(n);
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

