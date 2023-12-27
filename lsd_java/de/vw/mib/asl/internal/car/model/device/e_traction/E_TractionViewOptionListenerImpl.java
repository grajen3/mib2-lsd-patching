/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.model.device.e_traction;

import de.vw.mib.asl.api.car.vo.e_traction.BatteryControlViewOptionsData;
import de.vw.mib.asl.api.car.vo.e_traction.E_TractionViewOptionAdapter;
import de.vw.mib.asl.api.car.vo.e_traction.HybridViewOptionsData;
import de.vw.mib.asl.internal.car.model.device.e_traction.E_TractionDevice;

public class E_TractionViewOptionListenerImpl
extends E_TractionViewOptionAdapter {
    private E_TractionDevice device;

    public E_TractionViewOptionListenerImpl(E_TractionDevice e_TractionDevice) {
        this.device = e_TractionDevice;
    }

    @Override
    public void updateBatteryControlViewOptions(BatteryControlViewOptionsData batteryControlViewOptionsData, int n) {
        this.device.addMapping(0, batteryControlViewOptionsData.getProfileList(), n);
        this.device.addMapping(1, batteryControlViewOptionsData.getProfileList(), n);
        this.device.addMapping(2, batteryControlViewOptionsData.getProfileList(), n);
        this.device.addMapping(3, batteryControlViewOptionsData.getProfileList(), n);
        this.device.addMapping(5, batteryControlViewOptionsData.getProfileList(), n);
        this.device.updateModel();
    }

    @Override
    public void updateBatteryControlDevice(int n) {
        this.device.addMapping(0, n);
        this.device.addMapping(1, n);
        this.device.addMapping(2, n);
        this.device.addMapping(3, n);
        this.device.addMapping(5, n);
        this.device.updateModel();
    }

    @Override
    public void updateHybridViewOptions(HybridViewOptionsData hybridViewOptionsData, int n) {
        this.device.addMapping(4, hybridViewOptionsData.getHybridTargetRange(), n);
        this.device.addMapping(6, hybridViewOptionsData.getHybridActivePedal(), n);
        this.device.updateModel();
    }

    @Override
    public void updateHybridDevice(int n) {
        this.device.addMapping(4, n);
        this.device.addMapping(6, n);
        this.device.updateModel();
    }
}

