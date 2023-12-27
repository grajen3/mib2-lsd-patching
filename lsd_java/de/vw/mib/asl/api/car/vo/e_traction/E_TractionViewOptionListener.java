/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.car.vo.e_traction;

import de.vw.mib.asl.api.car.vo.e_traction.BatteryControlViewOptionsData;
import de.vw.mib.asl.api.car.vo.e_traction.HybridViewOptionsData;

public interface E_TractionViewOptionListener {
    default public void updateBatteryControlViewOptions(BatteryControlViewOptionsData batteryControlViewOptionsData, int n) {
    }

    default public void updateHybridViewOptions(HybridViewOptionsData hybridViewOptionsData, int n) {
    }

    default public void updateBatteryControlDevice(int n) {
    }

    default public void updateHybridDevice(int n) {
    }
}

