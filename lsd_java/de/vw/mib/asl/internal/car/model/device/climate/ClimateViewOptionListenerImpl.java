/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.model.device.climate;

import de.vw.mib.asl.api.car.vo.climate.AirconRowViewOptionsData;
import de.vw.mib.asl.api.car.vo.climate.AirconViewOptionsMasterData;
import de.vw.mib.asl.api.car.vo.climate.ClimateViewOptionAdapter;
import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.car.model.device.climate.ClimateDevice;
import de.vw.mib.asl.internal.car.srv.climate.impl.ClimateViewOptionServiceImpl;
import org.dsi.ifc.caraircondition.AirconMasterViewOptions;
import org.dsi.ifc.global.CarViewOption;

public class ClimateViewOptionListenerImpl
extends ClimateViewOptionAdapter {
    private ClimateDevice climateDevice;
    private AirconMasterViewOptions storedMasterViewOptions = null;

    public ClimateViewOptionListenerImpl(ClimateDevice climateDevice) {
        this.climateDevice = climateDevice;
    }

    @Override
    public void updateAirconViewOptionsMaster(AirconViewOptionsMasterData airconViewOptionsMasterData, int n) {
        boolean bl = false;
        if (airconViewOptionsMasterData == null) {
            bl = true;
        }
        ASLFrameworkFactory.getASLFrameworkAPI().getASLLogger().info(1, new StringBuffer().append("ClimateViewOptionListenerImpl: MasterViewOptions stored. IsViewOptionNULL = ").append(bl).toString());
        if (airconViewOptionsMasterData != null) {
            this.storedMasterViewOptions = new AirconMasterViewOptions(airconViewOptionsMasterData.getAirconMasterVO().airconSetFactoryDefaultMaster, airconViewOptionsMasterData.getAirconMasterVO().airconAC, airconViewOptionsMasterData.getAirconMasterVO().airconMaxAC, airconViewOptionsMasterData.getAirconMasterVO().airconEcoAC, airconViewOptionsMasterData.getAirconMasterVO().airconAirCirculationMan, airconViewOptionsMasterData.getAirconMasterVO().airconAirCirculationAuto, airconViewOptionsMasterData.getAirconMasterVO().airconAirCirculationSensitivity, airconViewOptionsMasterData.getAirconMasterVO().airconSolar, airconViewOptionsMasterData.getAirconMasterVO().airconMiddleExhaust, airconViewOptionsMasterData.getAirconMasterVO().airconIndirectVentilation, airconViewOptionsMasterData.getAirconMasterVO().airconSynchronisation, airconViewOptionsMasterData.getAirconMasterVO().airconFrontWindowHeater, airconViewOptionsMasterData.getAirconMasterVO().airconFrontWindowHeaterAuto, airconViewOptionsMasterData.getAirconMasterVO().airconRearWindowHeater, airconViewOptionsMasterData.getAirconMasterVO().airconSteeringWheelHeaterViewOptions, airconViewOptionsMasterData.getAirconMasterVO().airconPopupTime, airconViewOptionsMasterData.getAirconMasterVO().airconSuppressVisualisation, airconViewOptionsMasterData.getAirconMasterVO().airconHeater, airconViewOptionsMasterData.getAirconMasterVO().airconQuickHeater, airconViewOptionsMasterData.getAirconMasterVO().airconRearAuxHeater, airconViewOptionsMasterData.getAirconMasterVO().airconResidualHeat, airconViewOptionsMasterData.getAirconMasterVO().airconDefrost, airconViewOptionsMasterData.getAirconMasterVO().airconMaxDefrost, airconViewOptionsMasterData.getAirconMasterVO().airconSideWindowDefrost, airconViewOptionsMasterData.getAirconMasterVO().airconRearControl, airconViewOptionsMasterData.getAirconMasterVO().airconRearControlFondPlus, airconViewOptionsMasterData.getAirconMasterVO().airconSDSAirBlowerCompensation, airconViewOptionsMasterData.getAirconMasterVO().airconTelAirBlowerCompensation, airconViewOptionsMasterData.getAirconMasterVO().airconAirQuality, airconViewOptionsMasterData.getAirconMasterVO().airconFreshAirConfiguration, airconViewOptionsMasterData.getAirconMasterVO().airconFreshAirState, airconViewOptionsMasterData.getAirconMasterVO().airconPureAir, airconViewOptionsMasterData.getAirconMasterVO().configuration);
            if (airconViewOptionsMasterData.getAirconMasterVO().configuration.zl1r) {
                ClimateViewOptionServiceImpl.getInstance().registerViewOption(93);
                ASLFrameworkFactory.getASLFrameworkAPI().getASLLogger().info(1, "ClimateViewOptionListenerImpl: Register on ViewOptions Row1");
            }
        }
    }

    @Override
    public void updateAirconViewOptionsRow1(AirconRowViewOptionsData airconRowViewOptionsData, int n) {
        airconRowViewOptionsData.setStoredMasterViewOptions(this.storedMasterViewOptions);
        ServiceManager.aslPropertyManager.valueChangedBoolean(755265024, airconRowViewOptionsData.getIsKME());
        this.climateDevice.setHasSetupButton(airconRowViewOptionsData.getAirconRowVO().getConfiguration().isSetupButton());
        if (airconRowViewOptionsData.getStoredMasterViewOptions() != null) {
            this.climateDevice.addMapping(0, airconRowViewOptionsData.getSteeringWheelHeaterHeatingStep(), n);
            this.climateDevice.addMapping(1, airconRowViewOptionsData.getFrontWindowHeaterAuto(), n);
            this.climateDevice.addMapping(2, airconRowViewOptionsData.getAirCirculationAuto(), n);
            this.climateDevice.addMapping(3, airconRowViewOptionsData.getSteeringWheelHeaterAutoHeating(), n);
            this.climateDevice.addMapping(4, airconRowViewOptionsData.getAirconHeater(), n);
            this.climateDevice.addMapping(5, airconRowViewOptionsData.getSteeringWheelHeaterAdjustViaSeatHeating(), n);
            ASLFrameworkFactory.getASLFrameworkAPI().getASLLogger().info(1, "ClimateViewOptionListenerImpl: no setup button -> climate Setup is visible");
        } else {
            this.climateDevice.addMapping(0, new CarViewOption(0, 0));
            this.climateDevice.addMapping(1, new CarViewOption(0, 0));
            this.climateDevice.addMapping(2, new CarViewOption(0, 0));
            this.climateDevice.addMapping(3, new CarViewOption(0, 0));
            this.climateDevice.addMapping(4, new CarViewOption(0, 0));
            this.climateDevice.addMapping(5, new CarViewOption(0, 0));
            ASLFrameworkFactory.getASLFrameworkAPI().getASLLogger().info(1, "ClimateViewOptionListenerImpl: setup button existent -> climate Setup is NOT visible");
        }
        this.climateDevice.updateModel();
    }
}

