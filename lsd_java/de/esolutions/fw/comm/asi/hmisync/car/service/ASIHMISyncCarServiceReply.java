/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.car.service;

import de.esolutions.fw.comm.asi.hmisync.car.FloatBaseType;
import de.esolutions.fw.comm.asi.hmisync.car.service.AdBlueInfo;
import de.esolutions.fw.comm.asi.hmisync.car.service.OilLevelData;
import de.esolutions.fw.comm.asi.hmisync.car.service.SIAOilInspection;
import de.esolutions.fw.comm.asi.hmisync.car.service.SIAServiceData;
import de.esolutions.fw.comm.asi.hmisync.car.service.TireDisplayData;

public interface ASIHMISyncCarServiceReply {
    public static final String IPL_COMM_UUID;
    public static final String IPL_COMM_INTERFACE_KEY;
    public static final String IPL_COMM_INTERFACE_VERSION;
    public static final String IPL_COMM_MODULE_VERSION;

    default public void updateASIVersion(String string, boolean bl) {
    }

    default public void updateRequestIDs(short[] sArray, boolean bl) {
    }

    default public void updateReplyIDs(short[] sArray, boolean bl) {
    }

    default public void updateOilLevelData(OilLevelData oilLevelData, boolean bl) {
    }

    default public void updateOilLevelDataVisibilityState(int n, boolean bl) {
    }

    default public void updateAdBlueInfo(AdBlueInfo adBlueInfo, boolean bl) {
    }

    default public void updateAdBlueInfoVisibilityState(int n, boolean bl) {
    }

    default public void updateSIAOilInspection(SIAOilInspection sIAOilInspection, boolean bl) {
    }

    default public void updateSIAOilInspectionVisibilityState(int[] nArray, boolean bl) {
    }

    default public void updateSIAServiceData(SIAServiceData sIAServiceData, boolean bl) {
    }

    default public void updateSIAServiceDataVisibilityState(int n, boolean bl) {
    }

    default public void updateVinData(String string, boolean bl) {
    }

    default public void updateVinDataVisibilityState(int n, boolean bl) {
    }

    default public void updateKeyData(int[] nArray, boolean bl) {
    }

    default public void updateKeyDataVisibilityState(int n, boolean bl) {
    }

    default public void updateTireDisplayData(TireDisplayData tireDisplayData, boolean bl) {
    }

    default public void updateTireDisplayDataVisibilityState(int n, boolean bl) {
    }

    default public void updateTireSystem(int n, boolean bl) {
    }

    default public void updateVehicleSpeedVisibility(int n, boolean bl) {
    }

    default public void updateVehicleSpeed(FloatBaseType floatBaseType, boolean bl) {
    }
}

