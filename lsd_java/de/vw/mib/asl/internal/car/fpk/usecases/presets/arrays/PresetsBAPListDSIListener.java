/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.fpk.usecases.presets.arrays;

import org.dsi.ifc.carkombi.DCDisplayPresetsListRecord;
import org.dsi.ifc.global.CarArrayListUpdateInfo;

public interface PresetsBAPListDSIListener {
    default public void onServiceStateChanged(boolean bl) {
    }

    default public void dsiCarKombiUpdateDCDisplayPresetsListUpdateInfo(CarArrayListUpdateInfo carArrayListUpdateInfo, DCDisplayPresetsListRecord[] dCDisplayPresetsListRecordArray, int n) {
    }

    default public void dsiCarKombiUpdateDCDisplayPresetsListTotalNumberOfElements(int n, int n2) {
    }

    default public void dsiCarKombiResponseDCDisplayPresetsList(CarArrayListUpdateInfo carArrayListUpdateInfo, DCDisplayPresetsListRecord[] dCDisplayPresetsListRecordArray) {
    }
}

