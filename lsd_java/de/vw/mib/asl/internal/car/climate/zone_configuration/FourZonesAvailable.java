/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.climate.zone_configuration;

import de.vw.mib.asl.internal.car.climate.ClimateMainController;
import de.vw.mib.asl.internal.car.climate.service.ClimateServiceValueFactory;
import de.vw.mib.asl.internal.car.climate.zone_configuration.BaseConfiguration;
import org.dsi.ifc.caraircondition.AirconAirDistribution;
import org.dsi.ifc.caraircondition.AirconAirVolume;
import org.dsi.ifc.caraircondition.AirconTemp;

public class FourZonesAvailable
extends BaseConfiguration {
    public boolean isAutoActive = false;

    public FourZonesAvailable(ClimateMainController climateMainController) {
        super(climateMainController);
    }

    @Override
    public void updateAirconAirVolumeZone1(AirconAirVolume airconAirVolume, int n) {
        this.airVolumeZone1 = new AirconAirVolume(airconAirVolume.airVolume, airconAirVolume.airVolumeRegulated, airconAirVolume.airVolumeAuto);
        this.airVolumeSliderFrontCollector.climate_air_distribution_slider_front_value = airconAirVolume.airVolume;
        this.airVolumeSliderFrontCollector.climate_air_distribution_slider_front_maximum = 7;
        this.isAutoAirVolumeFront = airconAirVolume.airVolumeAuto == 1;
        this.evaluateAutoModeFront();
        this.evaluatePresetFront();
        this.updateArrowColourZone1(this.airDistributionZone1);
        this.updateArrowColourZone2(this.airDistributionZone2);
        this.informAirFlowArrowStateToModel();
        this.informPresetCollectorToModel();
        this.informAirDistributionSliderFrontToModel();
    }

    @Override
    public void updateAirconAirDistributionZone1(AirconAirDistribution airconAirDistribution, int n) {
        this.airDistributionZone1 = new AirconAirDistribution(airconAirDistribution.up, airconAirDistribution.body, airconAirDistribution.footwell, airconAirDistribution.indirect, airconAirDistribution.automode, airconAirDistribution.autoDemandOriented, 0);
        this.isAutoAirDistributionFront = airconAirDistribution.automode;
        this.evaluateAutoModeFront();
        this.evaluatePresetFront();
        this.updateArrowColourZone1(this.airDistributionZone1);
        if (!this.airDistributionAvailableZone2) {
            this.airDistributionZone2 = new AirconAirDistribution(airconAirDistribution.up, airconAirDistribution.body, airconAirDistribution.footwell, airconAirDistribution.indirect, airconAirDistribution.automode, airconAirDistribution.autoDemandOriented, 0);
            this.updateArrowColourZone2(airconAirDistribution);
        }
        this.informAirFlowArrowStateToModel();
        this.informPresetCollectorToModel();
        if (this.getMainControllerHandel().getClimateConfiguration().getZoneConfiguration((int)0).airDistributionCombined == 2) {
            int n2 = this.evaluateAirDistributionCombined(airconAirDistribution);
            this.getMainControllerHandel().getClimateServiceListener().updateClimateAirDistributionCombined(new ClimateServiceValueFactory().createClimateAirDistributionCombined(0, n2));
        }
    }

    @Override
    public void updateAirconAirVolumeZone2(AirconAirVolume airconAirVolume, int n) {
        this.airVolumeZone2 = new AirconAirVolume(airconAirVolume.airVolume, airconAirVolume.airVolumeRegulated, airconAirVolume.airVolumeAuto);
        this.updateArrowColourZone2(this.airDistributionZone2);
        this.informAirFlowArrowStateToModel();
    }

    @Override
    public void updateAirconAirDistributionZone2(AirconAirDistribution airconAirDistribution, int n) {
        this.airDistributionZone2 = new AirconAirDistribution(airconAirDistribution.up, airconAirDistribution.body, airconAirDistribution.footwell, airconAirDistribution.indirect, airconAirDistribution.automode, airconAirDistribution.autoDemandOriented, 0);
        this.updateArrowColourZone2(this.airDistributionZone2);
        this.informAirFlowArrowStateToModel();
        if (this.getMainControllerHandel().getClimateConfiguration().getZoneConfiguration((int)1).airDistributionCombined == 2) {
            int n2 = this.evaluateAirDistributionCombined(airconAirDistribution);
            this.getMainControllerHandel().getClimateServiceListener().updateClimateAirDistributionCombined(new ClimateServiceValueFactory().createClimateAirDistributionCombined(1, n2));
        }
    }

    @Override
    public void updateAirconAirVolumeZone3(AirconAirVolume airconAirVolume, int n) {
        this.airVolumeZone3 = new AirconAirVolume(airconAirVolume.airVolume, airconAirVolume.airVolumeRegulated, airconAirVolume.airVolumeAuto);
        this.isAutoAirVolumeRear = airconAirVolume.airVolumeAuto == 1;
        this.airDistributionSliderRearCollector.climate_air_distribution_slider_rear_value = airconAirVolume.airVolume;
        this.airDistributionSliderRearCollector.climate_air_distribution_slider_rear_maximum = 7;
        this.evaluateAutoModeRear();
        this.evaluatePresetRear();
        this.updateArrowColourZone3(this.airDistributionZone3);
        this.updateArrowColourZone4(this.airDistributionZone4);
        this.informAirFlowArrowStateToModel();
        this.informPresetCollectorToModel();
        this.informAirDistributionSliderRearToModel();
    }

    @Override
    public void updateAirconAirDistributionZone3(AirconAirDistribution airconAirDistribution, int n) {
        this.airDistributionZone3 = new AirconAirDistribution(airconAirDistribution.up, airconAirDistribution.body, airconAirDistribution.footwell, airconAirDistribution.indirect, airconAirDistribution.automode, airconAirDistribution.autoDemandOriented, 0);
        this.isAutoAirDistributionRear = airconAirDistribution.automode;
        this.evaluateAutoModeRear();
        this.evaluatePresetRear();
        this.updateArrowColourZone3(this.airDistributionZone3);
        if (!this.airDistributionAvailableZone4) {
            this.airDistributionZone4 = new AirconAirDistribution(airconAirDistribution.up, airconAirDistribution.body, airconAirDistribution.footwell, airconAirDistribution.indirect, airconAirDistribution.automode, airconAirDistribution.autoDemandOriented, 0);
            this.updateArrowColourZone4(airconAirDistribution);
        }
        this.informAirFlowArrowStateToModel();
        this.informPresetCollectorToModel();
    }

    @Override
    public void updateAirconAirVolumeZone4(AirconAirVolume airconAirVolume, int n) {
        this.airVolumeZone4 = new AirconAirVolume(airconAirVolume.airVolume, airconAirVolume.airVolumeRegulated, airconAirVolume.airVolumeAuto);
        this.updateArrowColourZone4(this.airDistributionZone4);
        this.informAirFlowArrowStateToModel();
    }

    @Override
    public void updateAirconAirDistributionZone4(AirconAirDistribution airconAirDistribution, int n) {
        this.airDistributionZone4 = new AirconAirDistribution(airconAirDistribution.up, airconAirDistribution.body, airconAirDistribution.footwell, airconAirDistribution.indirect, airconAirDistribution.automode, airconAirDistribution.autoDemandOriented, 0);
        this.updateArrowColourZone4(this.airDistributionZone4);
        this.informAirFlowArrowStateToModel();
    }

    @Override
    public void updateAirconTempZone1(AirconTemp airconTemp, int n) {
        this.airconTempZone1 = new AirconTemp(airconTemp.tempValue, airconTemp.tempUnit);
        this.temperatureButtonList[0].temperatureValue = this.evaluateTemperatureValue(airconTemp.tempValue, airconTemp.tempUnit);
        this.temperatureButtonList[0].unit = this.evaluateTemperatureUnit(airconTemp, this.isEcoZone1);
        this.updateArrowColourZone1(this.airDistributionZone1);
        this.informAirFlowArrowStateToModel();
        this.informTemperaturToModel();
        this.getMainControllerHandel().getClimateServiceListener().updateClimateTemperature(new ClimateServiceValueFactory().createTemperatureValue(0, airconTemp.tempValue, airconTemp.tempUnit));
    }

    @Override
    public void updateAirconTempZone2(AirconTemp airconTemp, int n) {
        this.airconTempZone2 = new AirconTemp(airconTemp.tempValue, airconTemp.tempUnit);
        this.temperatureButtonList[1].temperatureValue = this.evaluateTemperatureValue(airconTemp.tempValue, airconTemp.tempUnit);
        this.temperatureButtonList[1].unit = this.evaluateTemperatureUnit(airconTemp, this.isEcoZone2);
        this.updateArrowColourZone2(this.airDistributionZone2);
        this.informAirFlowArrowStateToModel();
        this.informTemperaturToModel();
        this.getMainControllerHandel().getClimateServiceListener().updateClimateTemperature(new ClimateServiceValueFactory().createTemperatureValue(1, airconTemp.tempValue, airconTemp.tempUnit));
    }

    @Override
    public void updateAirconTempZone3(AirconTemp airconTemp, int n) {
        this.airconTempZone3 = new AirconTemp(airconTemp.tempValue, airconTemp.tempUnit);
        this.temperatureButtonList[2].temperatureValue = this.evaluateTemperatureValue(airconTemp.tempValue, airconTemp.tempUnit);
        this.temperatureButtonList[2].unit = this.evaluateTemperatureUnit(airconTemp, this.isEcoZone3);
        this.updateArrowColourZone3(this.airDistributionZone3);
        this.informAirFlowArrowStateToModel();
        this.informTemperaturToModel();
    }

    @Override
    public void updateAirconTempZone4(AirconTemp airconTemp, int n) {
        this.airconTempZone4 = new AirconTemp(airconTemp.tempValue, airconTemp.tempUnit);
        this.temperatureButtonList[4].temperatureValue = this.evaluateTemperatureValue(airconTemp.tempValue, airconTemp.tempUnit);
        this.temperatureButtonList[4].unit = this.evaluateTemperatureUnit(airconTemp, this.isEcoZone4);
        this.updateArrowColourZone4(this.airDistributionZone4);
        this.informAirFlowArrowStateToModel();
        this.informTemperaturToModel();
    }

    @Override
    public void updateAirconTempStepZone3(int n, int n2, int n3) {
        this.airConTempStepZone3 = n;
        this.airconTempStepMaxCount3 = n2;
        this.temperatureButtonList[2].temperatureValue = n;
        this.temperatureButtonList[2].unit = this.evaluateTemperatureStepUnit(n, n2, this.isEcoZone3);
        this.informTemperaturToModel();
    }

    @Override
    public void updateAirconClimateStateZone1(int n, int n2) {
        this.styleStateZone1 = n;
        this.isEcoZone1 = this.evaluateEcoTempearture(this.styleStateZone1);
        if (this.isEcoZone1) {
            this.temperatureButtonList[0].unit = 5;
        } else if (this.tempTypeZone1 == 1) {
            this.temperatureButtonList[0].unit = this.evaluateTemperatureUnit(this.airconTempZone1, this.isEcoZone1);
        } else if (this.tempTypeZone1 == 2) {
            this.temperatureButtonList[0].unit = this.evaluateTemperatureStepUnit(this.airConTempStepZone1, this.airconTempStepMaxCount1, this.isEcoZone1);
        }
        this.informTemperaturToModel();
        this.updateArrowColourZone1(this.airDistributionZone1);
        this.informAirFlowArrowStateToModel();
        this.getMainControllerHandel().getClimateServiceListener().updateClimateAirFlowState(new ClimateServiceValueFactory().createAirFlowState(0, n));
    }

    @Override
    public void updateAirconClimateStateZone2(int n, int n2) {
        this.styleStateZone2 = n;
        this.isEcoZone2 = this.evaluateEcoTempearture(this.styleStateZone2);
        if (this.isEcoZone2) {
            this.temperatureButtonList[1].unit = 5;
        } else if (this.tempTypeZone2 == 1) {
            this.temperatureButtonList[1].unit = this.evaluateTemperatureUnit(this.airconTempZone2, this.isEcoZone2);
        } else if (this.tempTypeZone2 == 2) {
            this.temperatureButtonList[1].unit = this.evaluateTemperatureStepUnit(this.airConTempStepZone2, this.airconTempStepMaxCount2, this.isEcoZone2);
        }
        this.informTemperaturToModel();
        this.updateArrowColourZone2(this.airDistributionZone2);
        this.informAirFlowArrowStateToModel();
        this.getMainControllerHandel().getClimateServiceListener().updateClimateAirFlowState(new ClimateServiceValueFactory().createAirFlowState(1, n));
    }

    @Override
    public void updateAirconClimateStateZone3(int n, int n2) {
        this.styleStateZone3 = n;
        this.isEcoZone3 = this.evaluateEcoTempearture(this.styleStateZone3);
        if (this.isEcoZone3) {
            this.temperatureButtonList[2].unit = 5;
        } else if (this.tempTypeZone3 == 1) {
            this.temperatureButtonList[2].unit = this.evaluateTemperatureUnit(this.airconTempZone3, this.isEcoZone3);
        } else if (this.tempTypeZone3 == 2) {
            this.temperatureButtonList[2].unit = this.evaluateTemperatureStepUnit(this.airConTempStepZone3, this.airconTempStepMaxCount3, this.isEcoZone3);
        }
        this.informTemperaturToModel();
        this.updateArrowColourZone3(this.airDistributionZone3);
        this.informAirFlowArrowStateToModel();
    }

    @Override
    public void updateAirconClimateStateZone4(int n, int n2) {
        this.styleStateZone4 = n;
        this.isEcoZone4 = this.evaluateEcoTempearture(this.styleStateZone4);
        if (this.isEcoZone4) {
            this.temperatureButtonList[4].unit = 5;
        } else if (this.tempTypeZone4 == 1) {
            this.temperatureButtonList[4].unit = this.evaluateTemperatureUnit(this.airconTempZone4, this.isEcoZone4);
        } else if (this.tempTypeZone4 == 2) {
            this.temperatureButtonList[4].unit = this.evaluateTemperatureStepUnit(this.airConTempStepZone4, this.airconTempStepMaxCount4, this.isEcoZone4);
        }
        this.informTemperaturToModel();
        this.updateArrowColourZone4(this.airDistributionZone4);
        this.informAirFlowArrowStateToModel();
    }

    private void updateArrowColourZone1(AirconAirDistribution airconAirDistribution) {
        this.isButtonFrontAirFlowBodyActive = airconAirDistribution.body > 0;
        this.isButttonFrontAirFlowFootWellActive = airconAirDistribution.footwell > 0;
        boolean bl = this.isButtonFrontAirFlowWindowActive = airconAirDistribution.up > 0;
        if (this.isAutoAirDistributionFront || airconAirDistribution.up > 0) {
            this.airFlowArrowStateCollector[0] = this.evaluateArrowColor(this.styleStateZone1, this.tempTypeZone1, this.airconTempZone1, this.isAutoAirDistributionFront);
        } else {
            this.airFlowArrowStateCollector[0] = 0;
            this.isButtonFrontAirFlowWindowActive = false;
        }
        this.airFlowArrowStateCollector[1] = this.isAutoAirDistributionFront || airconAirDistribution.body > 0 ? this.evaluateArrowColor(this.styleStateZone1, this.tempTypeZone1, this.airconTempZone1, this.isAutoAirDistributionFront) : 0;
        if (this.isAutoAirDistributionFront || airconAirDistribution.footwell > 0) {
            this.airFlowArrowStateCollector[2] = this.evaluateArrowColor(this.styleStateZone1, this.tempTypeZone1, this.airconTempZone1, this.isAutoAirDistributionFront);
        } else {
            this.airFlowArrowStateCollector[2] = 0;
            this.isButttonFrontAirFlowFootWellActive = false;
        }
        this.informFlyingWindowFrontContentToModel(-1112735488, this.isButtonFrontAirFlowBodyActive);
        this.informFlyingWindowFrontContentToModel(-1079181056, this.isButtonFrontAirFlowWindowActive);
        this.informFlyingWindowFrontContentToModel(-1095958272, this.isButttonFrontAirFlowFootWellActive);
        this.informAirFlowArrowStateToModel();
    }

    private void updateArrowColourZone2(AirconAirDistribution airconAirDistribution) {
        this.airFlowArrowStateCollector[3] = this.isAutoAirDistributionFront || airconAirDistribution.up > 0 ? this.evaluateArrowColor(this.styleStateZone2, this.tempTypeZone2, this.airconTempZone2, this.isAutoAirDistributionFront) : 0;
        this.airFlowArrowStateCollector[4] = this.isAutoAirDistributionFront || airconAirDistribution.body > 0 ? this.evaluateArrowColor(this.styleStateZone2, this.tempTypeZone2, this.airconTempZone2, this.isAutoAirDistributionFront) : 0;
        this.airFlowArrowStateCollector[5] = this.isAutoAirDistributionFront || airconAirDistribution.footwell > 0 ? this.evaluateArrowColor(this.styleStateZone2, this.tempTypeZone2, this.airconTempZone2, this.isAutoAirDistributionFront) : 0;
    }

    private void updateArrowColourZone3(AirconAirDistribution airconAirDistribution) {
        this.isButtonRearAirFlowWindowActive = this.isRearWindowOutletAvailable & airconAirDistribution.up > 0;
        this.isButtonRearAirFlowBodyActive = airconAirDistribution.body > 0;
        this.isButtonRearAirFlowFootWellActive = airconAirDistribution.footwell > 0;
        this.airFlowArrowStateCollector[6] = this.isRearWindowOutletAvailable && (this.isAutoAirDistributionRear || airconAirDistribution.up > 0) ? this.evaluateArrowColor(this.styleStateZone3, this.tempTypeZone3, this.airconTempZone3, this.isAutoAirDistributionRear) : 0;
        this.airFlowArrowStateCollector[7] = this.isAutoAirDistributionRear || airconAirDistribution.body > 0 ? this.evaluateArrowColor(this.styleStateZone3, this.tempTypeZone3, this.airconTempZone3, this.isAutoAirDistributionRear) : 0;
        this.airFlowArrowStateCollector[8] = this.isAutoAirDistributionRear || airconAirDistribution.footwell > 0 ? this.evaluateArrowColor(this.styleStateZone3, this.tempTypeZone3, this.airconTempZone3, this.isAutoAirDistributionRear) : 0;
        this.informFlyingWindowFrontContentToModel(-1012072192, this.isButtonRearAirFlowWindowActive);
        this.informFlyingWindowFrontContentToModel(-1045626624, this.isButtonRearAirFlowBodyActive);
        this.informFlyingWindowFrontContentToModel(-1028849408, this.isButtonRearAirFlowFootWellActive);
    }

    private void updateArrowColourZone4(AirconAirDistribution airconAirDistribution) {
        this.airFlowArrowStateCollector[9] = this.isRearWindowOutletAvailable && (this.isAutoAirDistributionRear || airconAirDistribution.up > 0) ? this.evaluateArrowColor(this.styleStateZone4, this.tempTypeZone4, this.airconTempZone4, this.isAutoAirDistributionRear) : 0;
        this.airFlowArrowStateCollector[10] = this.isAutoAirDistributionRear || airconAirDistribution.body > 0 ? this.evaluateArrowColor(this.styleStateZone4, this.tempTypeZone4, this.airconTempZone4, this.isAutoAirDistributionRear) : 0;
        this.airFlowArrowStateCollector[11] = this.isAutoAirDistributionRear || airconAirDistribution.footwell > 0 ? this.evaluateArrowColor(this.styleStateZone4, this.tempTypeZone4, this.airconTempZone4, this.isAutoAirDistributionRear) : 0;
    }
}

