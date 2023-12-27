/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.srv.parking;

import de.vw.mib.asl.api.car.vo.CarFunctionState;
import de.vw.mib.asl.api.car.vo.parking.ParkingViewOptionData;
import de.vw.mib.asl.internal.car.srv.CarViewOptionWrapper;
import org.dsi.ifc.carparkingsystem.ParkingSystemViewOptions;
import org.dsi.ifc.global.CarViewOption;

public class ParkingViewOptionWrapper
implements ParkingViewOptionData {
    private ParkingSystemViewOptions vo;
    private CarViewOption extCamExt;
    private CarViewOption extCamInt;

    public ParkingViewOptionWrapper(ParkingSystemViewOptions parkingSystemViewOptions) {
        this.vo = parkingSystemViewOptions;
    }

    @Override
    public CarFunctionState getPdcSystemOnOff() {
        return new CarViewOptionWrapper(this.vo.getPdcSystemOnOff());
    }

    @Override
    public CarFunctionState getPdcVolumeFront() {
        return new CarViewOptionWrapper(this.vo.getPdcVolumeFront());
    }

    @Override
    public CarFunctionState getPdcFrequencyFront() {
        return new CarViewOptionWrapper(this.vo.getPdcFrequencyFront());
    }

    @Override
    public CarFunctionState getPdcVolumeRear() {
        return new CarViewOptionWrapper(this.vo.getPdcVolumeRear());
    }

    @Override
    public CarFunctionState getPdcFrequencyRear() {
        return new CarViewOptionWrapper(this.vo.getPdcFrequencyRear());
    }

    @Override
    public CarFunctionState getPdcVolumeRight() {
        return new CarViewOptionWrapper(this.vo.getPdcVolumeRight());
    }

    @Override
    public CarFunctionState getPdcFrequencyRight() {
        return new CarViewOptionWrapper(this.vo.getPdcFrequencyRight());
    }

    @Override
    public CarFunctionState getPdcVolumeLeft() {
        return new CarViewOptionWrapper(this.vo.getPdcVolumeLeft());
    }

    @Override
    public CarFunctionState getPdcFrequencyLeft() {
        return new CarViewOptionWrapper(this.vo.getPdcFrequencyLeft());
    }

    @Override
    public CarFunctionState getPdcDefaultParkingMode() {
        return new CarViewOptionWrapper(this.vo.getPdcDefaultParkingMode());
    }

    @Override
    public CarFunctionState getPdcMute() {
        return new CarViewOptionWrapper(this.vo.getPdcMute());
    }

    @Override
    public CarFunctionState getPdcAutoActivation() {
        return new CarViewOptionWrapper(this.vo.getPdcAutoActivation());
    }

    @Override
    public CarFunctionState getPdcSoundReproduction() {
        return new CarViewOptionWrapper(this.vo.getPdcSoundReproduction());
    }

    @Override
    public CarFunctionState getPdcFlankGuard() {
        return new CarViewOptionWrapper(this.vo.getPdcFlankGuard());
    }

    @Override
    public CarFunctionState getPdcSoundFront() {
        return new CarViewOptionWrapper(this.vo.getPdcSoundFront());
    }

    @Override
    public CarFunctionState getPdcSoundRear() {
        return new CarViewOptionWrapper(this.vo.getPdcSoundRear());
    }

    @Override
    public CarFunctionState getPdcSoundLeft() {
        return new CarViewOptionWrapper(this.vo.getPdcSoundLeft());
    }

    @Override
    public CarFunctionState getPdcSoundRight() {
        return new CarViewOptionWrapper(this.vo.getPdcSoundRight());
    }

    @Override
    public CarFunctionState getPdcOffroadMode() {
        return new CarViewOptionWrapper(this.vo.getPdcOffroadMode());
    }

    @Override
    public CarFunctionState getPdcParkboxVisualisation() {
        return new CarViewOptionWrapper(this.vo.getPdcParkboxVisualisation());
    }

    @Override
    public CarFunctionState getPdcPLAStatus() {
        return new CarViewOptionWrapper(this.vo.getPdcPLAStatus());
    }

    @Override
    public CarFunctionState getPdcPLABargraph() {
        return new CarViewOptionWrapper(this.vo.getPdcPLABargraph());
    }

    @Override
    public CarFunctionState getPdcPLAParkmodeSelection() {
        return new CarViewOptionWrapper(this.vo.getPdcPLAParkmodeSelection());
    }

    @Override
    public CarFunctionState getPdcPLASystemState() {
        return new CarViewOptionWrapper(this.vo.getPdcPLASystemState());
    }

    @Override
    public CarFunctionState getPdcOPSVisualisationPosition() {
        return new CarViewOptionWrapper(this.vo.getPdcOPSVisualisationPosition());
    }

    @Override
    public CarFunctionState getPdcManeuverAssist() {
        return new CarViewOptionWrapper(this.vo.getPdcManeuverAssist());
    }

    @Override
    public CarFunctionState getPdcContinueDrivingAssist() {
        return new CarViewOptionWrapper(this.vo.getPdcContinueDrivingAssist());
    }

    @Override
    public CarFunctionState getPdcIpaConfig() {
        return new CarViewOptionWrapper(this.vo.getPdcIpaConfig());
    }

    @Override
    public CarFunctionState getPdcPiloPaSystemStatePP() {
        return new CarViewOptionWrapper(this.vo.getPdcPiloPaSystemStatePP());
    }

    @Override
    public CarFunctionState getPdcPiloPaSystemStateGP() {
        return new CarViewOptionWrapper(this.vo.getPdcPiloPaSystemStateGP());
    }

    @Override
    public CarFunctionState getVpsSystemOnOff() {
        return new CarViewOptionWrapper(this.vo.getVpsSystemOnOff());
    }

    @Override
    public CarFunctionState getVpsColor() {
        return new CarViewOptionWrapper(this.vo.getVpsColor());
    }

    @Override
    public CarFunctionState getVpsBrightness() {
        return new CarViewOptionWrapper(this.vo.getVpsBrightness());
    }

    @Override
    public CarFunctionState getVpsContrast() {
        return new CarViewOptionWrapper(this.vo.getVpsContrast());
    }

    @Override
    public CarFunctionState getVpsFollowUpTime() {
        return new CarViewOptionWrapper(this.vo.getVpsFollowUpTime());
    }

    @Override
    public CarFunctionState getVpsOPSOverlay() {
        return new CarViewOptionWrapper(this.vo.getVpsOPSOverlay());
    }

    @Override
    public CarFunctionState getVpsDefaultView() {
        return new CarViewOptionWrapper(this.vo.getVpsDefaultView());
    }

    @Override
    public CarFunctionState getVpsDynamicParkingMode() {
        return new CarViewOptionWrapper(this.vo.getVpsDynamicParkingMode());
    }

    @Override
    public CarFunctionState getVpsDefaultModeRV() {
        return new CarViewOptionWrapper(this.vo.getVpsDefaultModeRV());
    }

    @Override
    public CarFunctionState getVpsDefaultModeFV() {
        return new CarViewOptionWrapper(this.vo.getVpsDefaultModeFV());
    }

    @Override
    public CarFunctionState getVpsDefaultModeSV() {
        return new CarViewOptionWrapper(this.vo.getVpsDefaultModeSV());
    }

    @Override
    public CarFunctionState getVpsDefaultModeBV() {
        return new CarViewOptionWrapper(this.vo.getVpsDefaultModeBV());
    }

    @Override
    public CarFunctionState getVpsExtCamConfig() {
        return new CarViewOptionWrapper(this.vo.getVpsExtCamConfig());
    }

    @Override
    public CarFunctionState getVpsExtCamManActivation() {
        return new CarViewOptionWrapper(this.vo.getVpsExtCamManActivation());
    }

    @Override
    public CarFunctionState getVps3DBirdview() {
        return new CarViewOptionWrapper(this.vo.getVps3DBirdview());
    }

    @Override
    public CarFunctionState getVpsSystemState() {
        return new CarViewOptionWrapper(this.vo.getVpsSystemState());
    }

    @Override
    public CarFunctionState getVpsCameraCleaning() {
        return new CarViewOptionWrapper(this.vo.getVpsCameraCleaning());
    }

    @Override
    public CarFunctionState getVpsRimProtection() {
        return new CarViewOptionWrapper(this.vo.getVpsRimProtection());
    }

    @Override
    public CarFunctionState getPdcSetFactoryDefault() {
        return new CarViewOptionWrapper(this.vo.getPdcSetFactoryDefault());
    }

    @Override
    public CarFunctionState getVpsSetFactoryDefault() {
        return new CarViewOptionWrapper(this.vo.getVpsSetFactoryDefault());
    }

    @Override
    public CarFunctionState getExtCamInterior() {
        return new CarViewOptionWrapper(this.extCamInt);
    }

    @Override
    public CarFunctionState getExtCamExterior() {
        return new CarViewOptionWrapper(this.extCamExt);
    }

    void setExtCamInterior(CarViewOption carViewOption) {
        this.extCamInt = carViewOption;
    }

    void setExtCamExterior(CarViewOption carViewOption) {
        this.extCamExt = carViewOption;
    }

    @Override
    public CarFunctionState getPdcManeuverAssistConfig() {
        return new CarViewOptionWrapper(this.vo.getPdcManeuverAssistConfig());
    }
}

