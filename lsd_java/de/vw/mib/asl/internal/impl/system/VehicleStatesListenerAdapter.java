/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.impl.system;

import org.dsi.ifc.generalvehiclestates.AirbagData;
import org.dsi.ifc.generalvehiclestates.DSIGeneralVehicleStatesListener;
import org.dsi.ifc.generalvehiclestates.TLOViewOptions;
import org.dsi.ifc.generalvehiclestates.TankInfo;
import org.dsi.ifc.global.CarViewOption;

public abstract class VehicleStatesListenerAdapter
implements DSIGeneralVehicleStatesListener {
    @Override
    public void asyncException(int n, String string, int n2) {
    }

    @Override
    public void updateAirbagData(AirbagData airbagData, int n) {
    }

    @Override
    public void updateTankInfo(TankInfo tankInfo, int n) {
    }

    @Override
    public void updateDimmedHeadlight(boolean bl, int n) {
    }

    @Override
    public void updateAcousticParkingSystem(boolean bl, int n) {
    }

    @Override
    public void updateReverseGear(boolean bl, int n) {
    }

    @Override
    public void updateVehicleStandstill(boolean bl, int n) {
    }

    @Override
    public void updateCarVelocityThreshold(boolean bl, int n) {
    }

    @Override
    public void updateTVVelocityThreshold(boolean bl, int n) {
    }

    @Override
    public void updateHDDVelocityThreshold(boolean bl, int n) {
    }

    @Override
    public void updateBrowserSlideShowVelocityThreshold(boolean bl, int n) {
    }

    @Override
    public void updateBrowserBordBookVelocityThreshold(boolean bl, int n) {
    }

    @Override
    public void updateBrowserTravelAgentVelocityThreshold(boolean bl, int n) {
    }

    @Override
    public void updateBrowserWebVelocityThreshold(boolean bl, int n) {
    }

    @Override
    public void updateBWSVelocityThreshold(boolean bl, int n) {
    }

    @Override
    public void updateRadiotextVelocityThreshold(boolean bl, int n) {
    }

    @Override
    public void updateDisplayDayNightDesign(boolean bl, int n) {
    }

    @Override
    public void updateBTBondingVelocityThreshold(boolean bl, int n) {
    }

    @Override
    public void updateMessagingVelocityThreshold(boolean bl, int n) {
    }

    @Override
    public void updateDestinationInputVelocityThreshold(boolean bl, int n) {
    }

    @Override
    public void updateDSSSViewOption(CarViewOption carViewOption, int n) {
    }

    @Override
    public void updateServiceKeyData(byte[] byArray, int n) {
    }

    @Override
    public void updateServiceKeyViewOption(CarViewOption carViewOption, int n) {
    }

    @Override
    public void updatePersonalizationStatus(boolean bl, int n, int n2) {
    }

    @Override
    public void updateTLOViewOptions(TLOViewOptions tLOViewOptions, int n) {
    }

    @Override
    public void updateEmergencyAssistVolLowering(int n, int n2) {
    }

    @Override
    public void updateParkingBrake(boolean bl, int n) {
    }

    public void updateFASProfileButton(int n, int n2) {
    }

    @Override
    public void updateAppConnectTrigger(int n, int n2) {
    }

    @Override
    public void updateSTPState(int n, int n2) {
    }

    @Override
    public void updateAutomaticGearShiftTransMode(int n, int n2) {
    }
}

