/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carvehiclestates;

import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.carvehiclestates.DynamicVehicleInfoHighFrequent;
import org.dsi.ifc.carvehiclestates.DynamicVehicleInfoHighFrequentViewOptions;
import org.dsi.ifc.carvehiclestates.DynamicVehicleInfoMidFrequent;
import org.dsi.ifc.carvehiclestates.DynamicVehicleInfoMidFrequentViewOptions;
import org.dsi.ifc.carvehiclestates.DynamicVehicleInfoSCR;
import org.dsi.ifc.carvehiclestates.KeyData;
import org.dsi.ifc.carvehiclestates.OilLevelData;
import org.dsi.ifc.carvehiclestates.SemiStaticDataViewOptions;
import org.dsi.ifc.carvehiclestates.SemiStaticVehicleData;
import org.dsi.ifc.carvehiclestates.VehicleInfoViewOptions;
import org.dsi.ifc.global.CarViewOption;

public interface DSICarVehicleStatesListener
extends DSIListener {
    default public void updateOilLevelViewOption(CarViewOption carViewOption, int n) {
    }

    default public void updateOilLevelData(OilLevelData oilLevelData, int n) {
    }

    default public void updateVINViewOption(CarViewOption carViewOption, int n) {
    }

    default public void updateVINData(String string, int n) {
    }

    default public void updateKeyViewOption(CarViewOption carViewOption, int n) {
    }

    default public void updateKeyData(KeyData keyData, int n) {
    }

    default public void updateDrvSchoolSystem(boolean bl, int n) {
    }

    default public void updateVehicleInfoViewOptions(VehicleInfoViewOptions vehicleInfoViewOptions, int n) {
    }

    default public void updateDynamicVehicleInfoHighFrequentViewOptions(DynamicVehicleInfoHighFrequentViewOptions dynamicVehicleInfoHighFrequentViewOptions, int n) {
    }

    default public void updateDynamicVehicleInfoMidFrequentViewOptions(DynamicVehicleInfoMidFrequentViewOptions dynamicVehicleInfoMidFrequentViewOptions, int n) {
    }

    default public void updateDynamicVehicleInfoHighFrequent(DynamicVehicleInfoHighFrequent dynamicVehicleInfoHighFrequent, int n) {
    }

    default public void updateDynamicVehicleInfoMidFrequent(DynamicVehicleInfoMidFrequent dynamicVehicleInfoMidFrequent, int n) {
    }

    default public void updateSemiStaticVehicleDataViewOptions(SemiStaticDataViewOptions semiStaticDataViewOptions, int n) {
    }

    default public void updateSemiStaticVehicleData(SemiStaticVehicleData semiStaticVehicleData, int n) {
    }

    default public void updateDynamicVehicleInfoSCR(DynamicVehicleInfoSCR dynamicVehicleInfoSCR, int n) {
    }
}

