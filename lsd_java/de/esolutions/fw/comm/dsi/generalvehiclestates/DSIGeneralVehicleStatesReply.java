/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.generalvehiclestates;

import org.dsi.ifc.generalvehiclestates.AirbagData;
import org.dsi.ifc.generalvehiclestates.TLOViewOptions;
import org.dsi.ifc.generalvehiclestates.TankInfo;
import org.dsi.ifc.global.CarViewOption;

public interface DSIGeneralVehicleStatesReply {
    public static final String IPL_COMM_UUID;
    public static final String IPL_COMM_INTERFACE_KEY;
    public static final String IPL_COMM_INTERFACE_VERSION;
    public static final String IPL_COMM_MODULE_VERSION;

    default public void updateAirbagData(AirbagData airbagData, int n) {
    }

    default public void updateTankInfo(TankInfo tankInfo, int n) {
    }

    default public void updateDimmedHeadlight(boolean bl, int n) {
    }

    default public void updateAcousticParkingSystem(boolean bl, int n) {
    }

    default public void updateReverseGear(boolean bl, int n) {
    }

    default public void updateVehicleStandstill(boolean bl, int n) {
    }

    default public void updateCarVelocityThreshold(boolean bl, int n) {
    }

    default public void updateTVVelocityThreshold(boolean bl, int n) {
    }

    default public void updateHDDVelocityThreshold(boolean bl, int n) {
    }

    default public void updateBrowserSlideShowVelocityThreshold(boolean bl, int n) {
    }

    default public void updateBrowserBordBookVelocityThreshold(boolean bl, int n) {
    }

    default public void updateBrowserTravelAgentVelocityThreshold(boolean bl, int n) {
    }

    default public void updateBrowserWebVelocityThreshold(boolean bl, int n) {
    }

    default public void updateBWSVelocityThreshold(boolean bl, int n) {
    }

    default public void updateRadiotextVelocityThreshold(boolean bl, int n) {
    }

    default public void updateDisplayDayNightDesign(boolean bl, int n) {
    }

    default public void updateBTBondingVelocityThreshold(boolean bl, int n) {
    }

    default public void updateMessagingVelocityThreshold(boolean bl, int n) {
    }

    default public void updateDestinationInputVelocityThreshold(boolean bl, int n) {
    }

    default public void updateDSSSViewOption(CarViewOption carViewOption, int n) {
    }

    default public void updateServiceKeyData(byte[] byArray, int n) {
    }

    default public void updateServiceKeyViewOption(CarViewOption carViewOption, int n) {
    }

    default public void updatePersonalizationStatus(boolean bl, int n, int n2) {
    }

    default public void updateTLOViewOptions(TLOViewOptions tLOViewOptions, int n) {
    }

    default public void updateEmergencyAssistVolLowering(int n, int n2) {
    }

    default public void updateParkingBrake(boolean bl, int n) {
    }

    default public void updateAppConnectTrigger(int n, int n2) {
    }

    default public void updateSTPState(int n, int n2) {
    }

    default public void updateAutomaticGearShiftTransMode(int n, int n2) {
    }

    default public void asyncException(int n, String string, int n2) {
    }

    default public void yyIndication(String string, String string2) {
    }
}

