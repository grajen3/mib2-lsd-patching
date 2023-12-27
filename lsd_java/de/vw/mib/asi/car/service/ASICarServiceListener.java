/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asi.car.service;

import de.esolutions.fw.comm.asi.hmisync.car.FloatBaseType;
import de.esolutions.fw.comm.asi.hmisync.car.service.AdBlueInfo;
import de.esolutions.fw.comm.asi.hmisync.car.service.OilLevelData;
import de.esolutions.fw.comm.asi.hmisync.car.service.SIAOilInspection;
import de.esolutions.fw.comm.asi.hmisync.car.service.SIAServiceData;
import de.esolutions.fw.comm.asi.hmisync.car.service.TireDisplayData;
import de.vw.mib.asi.ASIListener;

public interface ASICarServiceListener
extends ASIListener {
    default public void updateAdBlueInfo(AdBlueInfo adBlueInfo, boolean bl) {
    }

    default public void updateAdBlueInfoVisibilityState(int n, boolean bl) {
    }

    default public void updateKeyData(int[] nArray, boolean bl) {
    }

    default public void updateKeyDataVisibilityState(int n, boolean bl) {
    }

    default public void updateOilLevelData(OilLevelData oilLevelData, boolean bl) {
    }

    default public void updateOilLevelDataVisibilityState(int n, boolean bl) {
    }

    default public void updateSIAOilInspection(SIAOilInspection sIAOilInspection, boolean bl) {
    }

    default public void updateSIAOilInspectionVisibilityState(int[] nArray, boolean bl) {
    }

    default public void updateSIAServiceData(SIAServiceData sIAServiceData, boolean bl) {
    }

    default public void updateSIAServiceDataVisibilityState(int n, boolean bl) {
    }

    default public void updateTireDisplayData(TireDisplayData tireDisplayData, boolean bl) {
    }

    default public void updateTireDisplayDataVisibilityState(int n, boolean bl) {
    }

    default public void updateTireSystem(int n, boolean bl) {
    }

    default public void updateVehicleSpeed(FloatBaseType floatBaseType, boolean bl) {
    }

    default public void updateVehicleSpeedVisibility(int n, boolean bl) {
    }

    default public void updateVinData(String string, boolean bl) {
    }

    default public void updateVinDataVisibilityState(int n, boolean bl) {
    }
}

