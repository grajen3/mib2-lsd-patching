/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.service.arrays.vehiclestate;

import org.dsi.ifc.carkombi.BCVehicleStateUpdateInfoAH;
import org.dsi.ifc.carkombi.ListDynValues;
import org.dsi.ifc.carkombi.ListWarningIDsDynValues;

public interface VehicleStateDsiListener {
    default public void dsiCarKombiResponseVehicleStateUpdateInfo(BCVehicleStateUpdateInfoAH bCVehicleStateUpdateInfoAH, int[] nArray) {
    }

    default public void dsiCarKombiUpdateBCVehicleStateListTotalNumberOfElements(int n, int n2) {
    }

    default public void dsiCarKombiResponseVehicleStateListPos(BCVehicleStateUpdateInfoAH bCVehicleStateUpdateInfoAH, int[] nArray) {
    }

    default public void dsiCarKombiResponseVehicleStateListWarningIDdynValueAlternativeText(BCVehicleStateUpdateInfoAH bCVehicleStateUpdateInfoAH, int n, int n2, String string, String string2) {
    }

    default public void dsiCarKombiResponseVehicleStateListWarningIDdynValue(BCVehicleStateUpdateInfoAH bCVehicleStateUpdateInfoAH, ListWarningIDsDynValues[] listWarningIDsDynValuesArray) {
    }

    default public void dsiCarKombiResponseVehicleStateListdynValue(BCVehicleStateUpdateInfoAH bCVehicleStateUpdateInfoAH, ListDynValues[] listDynValuesArray) {
    }

    default public void dsiCarKombiResponseVehicleStateListAlternativeText(BCVehicleStateUpdateInfoAH bCVehicleStateUpdateInfoAH, int n, String string) {
    }
}

