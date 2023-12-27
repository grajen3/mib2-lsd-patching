/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.model.device.mfa;

import de.vw.mib.asl.api.car.vo.CarFunctionState;
import de.vw.mib.asl.api.car.vo.kombi.BCViewOptionsData;
import de.vw.mib.asl.api.car.vo.kombi.KombiViewOptionAdapter;
import de.vw.mib.asl.internal.car.model.device.mfa.MFADevice;
import de.vw.mib.asl.internal.car.model.device.mfa.MFAViewOptionListenerImpl$1;

public class MFAViewOptionListenerImpl
extends KombiViewOptionAdapter {
    private MFADevice viewOptionsDevice;
    private CarFunctionState not_existent = new MFAViewOptionListenerImpl$1(this);

    public MFAViewOptionListenerImpl(MFADevice mFADevice) {
        this.viewOptionsDevice = mFADevice;
    }

    @Override
    public void updateBCViewOptions(BCViewOptionsData bCViewOptionsData, int n) {
        this.viewOptionsDevice.addMapping(8, bCViewOptionsData.getDigitalSpeed(), n);
        this.viewOptionsDevice.addMapping(3, bCViewOptionsData.getConsumerDisplay(), n);
        this.viewOptionsDevice.addMapping(4, bCViewOptionsData.getLifeTipsDisplay(), n);
        this.viewOptionsDevice.addMapping(11, bCViewOptionsData.getOilTemperature(), n);
        this.viewOptionsDevice.addMapping(9, bCViewOptionsData.getVzaMFA(), n);
        this.viewOptionsDevice.addMapping(15, bCViewOptionsData.getAstaMFA(), n);
        this.viewOptionsDevice.addMapping(2, bCViewOptionsData.getRefuelVolume(), n);
        this.viewOptionsDevice.addMapping(12, bCViewOptionsData.getCoolantTemp(), n);
        this.viewOptionsDevice.addMapping(10, bCViewOptionsData.getMFASpeedWarning(), n);
        this.viewOptionsDevice.addMapping(0, bCViewOptionsData.getCurrentConsumption(), n);
        this.viewOptionsDevice.addMapping(1, bCViewOptionsData.getAverageConsumption(), n);
        this.viewOptionsDevice.addMapping(5, bCViewOptionsData.getDrivingTime(), n);
        this.viewOptionsDevice.addMapping(6, bCViewOptionsData.getDrivingDistance(), n);
        this.viewOptionsDevice.addMapping(7, bCViewOptionsData.getAverageSpeed(), n);
        this.viewOptionsDevice.addMapping(13, bCViewOptionsData.getResetMenue1(), n);
        this.viewOptionsDevice.addMapping(14, bCViewOptionsData.getResetMenue2(), n);
        this.viewOptionsDevice.addMapping(16, bCViewOptionsData.getResetTrip(), n);
        this.viewOptionsDevice.updateModel();
    }

    @Override
    public void updateBCDevice(int n) {
        this.viewOptionsDevice.addMapping(8, n);
        this.viewOptionsDevice.addMapping(3, n);
        this.viewOptionsDevice.addMapping(4, n);
        this.viewOptionsDevice.addMapping(11, n);
        this.viewOptionsDevice.addMapping(9, n);
        this.viewOptionsDevice.addMapping(15, n);
        this.viewOptionsDevice.addMapping(2, n);
        this.viewOptionsDevice.addMapping(12, n);
        this.viewOptionsDevice.addMapping(10, n);
        this.viewOptionsDevice.addMapping(0, n);
        this.viewOptionsDevice.addMapping(1, n);
        this.viewOptionsDevice.addMapping(5, n);
        this.viewOptionsDevice.addMapping(6, n);
        this.viewOptionsDevice.addMapping(7, n);
        this.viewOptionsDevice.addMapping(13, n);
        this.viewOptionsDevice.addMapping(14, n);
        this.viewOptionsDevice.addMapping(16, n);
        this.viewOptionsDevice.updateModel();
    }
}

