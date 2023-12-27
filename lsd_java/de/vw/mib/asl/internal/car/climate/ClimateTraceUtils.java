/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.climate;

import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import org.dsi.ifc.caraircondition.AirconMasterViewOptions;
import org.dsi.ifc.caraircondition.AirconRowConfiguration;
import org.dsi.ifc.caraircondition.AirconRowViewOptions;
import org.dsi.ifc.caraircondition.AirconZoneViewOptions;

public class ClimateTraceUtils {
    public static void traceAirconVO(Class clazz, Object object, int n) {
        String string = "wrong parametrized use of traceAirconVO!";
        String string2 = new StringBuffer().append(clazz.getName().substring(clazz.getName().lastIndexOf(46) + 1)).append("-> Aircondition ViewOptions ").toString();
        String string3 = null;
        try {
            if (n == 92) {
                string2 = new StringBuffer().append(string2).append("Master").toString();
                AirconMasterViewOptions airconMasterViewOptions = (AirconMasterViewOptions)object;
                string3 = ClimateTraceUtils.formatACMasterVO(airconMasterViewOptions);
            } else if (n == 93 || n == 94 || n == 95) {
                if (n == 93) {
                    string2 = new StringBuffer().append(string2).append("Row 1").toString();
                } else if (n == 94) {
                    string2 = new StringBuffer().append(string2).append("Row 2").toString();
                } else if (n == 95) {
                    string2 = new StringBuffer().append(string2).append("Row 3").toString();
                }
                AirconRowViewOptions airconRowViewOptions = (AirconRowViewOptions)object;
                string3 = ClimateTraceUtils.formatACRowVO(airconRowViewOptions);
            } else {
                string2 = string;
            }
            if (string3 != null) {
                string2 = new StringBuffer().append(string2).append(" received:\n\n").append(string3).append("\n").toString();
            }
        }
        catch (Exception exception) {
            string2 = string;
        }
        ASLFrameworkFactory.getASLFrameworkAPI().getASLLogger().info(1, string2);
    }

    public static void traceNotification(Class clazz, String string, String string2) {
        ASLFrameworkFactory.getASLFrameworkAPI().getASLLogger().info(1, new StringBuffer().append(clazz.getName().substring(clazz.getName().lastIndexOf(46) + 1)).append(" ").append(string).append(" ").append(string2).toString());
    }

    public static String formatACRowVO(AirconRowViewOptions airconRowViewOptions) {
        StringBuffer stringBuffer = new StringBuffer(8400);
        stringBuffer.append("airconSystemOnOffRow");
        stringBuffer.append('=');
        stringBuffer.append(airconRowViewOptions.airconSystemOnOffRow);
        stringBuffer.append(',');
        stringBuffer.append("airconSetFactoryDefaultRow");
        stringBuffer.append('=');
        stringBuffer.append(airconRowViewOptions.airconSetFactoryDefaultRow);
        stringBuffer.append(',');
        stringBuffer.append("airconNozzleList");
        stringBuffer.append('=');
        stringBuffer.append(airconRowViewOptions.airconNozzleList);
        stringBuffer.append(',');
        stringBuffer.append("airconNozzleControl");
        stringBuffer.append('=');
        stringBuffer.append(airconRowViewOptions.airconNozzleControl);
        stringBuffer.append(',');
        stringBuffer.append("airconNozzleStatus");
        stringBuffer.append('=');
        stringBuffer.append(airconRowViewOptions.airconNozzleStatus);
        stringBuffer.append(',');
        stringBuffer.append("\n");
        stringBuffer.append("zoneLeftViewOptions");
        stringBuffer.append('=');
        stringBuffer.append(ClimateTraceUtils.formatZoneVO(airconRowViewOptions.zoneLeftViewOptions));
        stringBuffer.append(',');
        stringBuffer.append("\n");
        stringBuffer.append("zoneRightViewOptions");
        stringBuffer.append('=');
        stringBuffer.append(ClimateTraceUtils.formatZoneVO(airconRowViewOptions.zoneRightViewOptions));
        stringBuffer.append(',');
        stringBuffer.append("\n");
        stringBuffer.append("configuration");
        stringBuffer.append('=');
        stringBuffer.append(ClimateTraceUtils.formatRowConfig(airconRowViewOptions.configuration));
        stringBuffer.append(')');
        return stringBuffer.toString();
    }

    public static String formatRowConfig(AirconRowConfiguration airconRowConfiguration) {
        StringBuffer stringBuffer = new StringBuffer(6850);
        stringBuffer.append("AirconRowConfiguration");
        stringBuffer.append('(');
        stringBuffer.append("externalDisplay");
        stringBuffer.append('=');
        stringBuffer.append(airconRowConfiguration.externalDisplay);
        stringBuffer.append(',');
        stringBuffer.append("setupButton");
        stringBuffer.append('=');
        stringBuffer.append(airconRowConfiguration.setupButton);
        stringBuffer.append(',');
        stringBuffer.append("autoMode");
        stringBuffer.append('=');
        stringBuffer.append(airconRowConfiguration.autoMode);
        stringBuffer.append(',');
        stringBuffer.append('\n');
        stringBuffer.append("airFlowConfigZoneLeft");
        stringBuffer.append('=');
        stringBuffer.append(airconRowConfiguration.airFlowConfigZoneLeft);
        stringBuffer.append(',');
        stringBuffer.append('\n');
        stringBuffer.append("airFlowConfigZoneRight");
        stringBuffer.append('=');
        stringBuffer.append(airconRowConfiguration.airFlowConfigZoneRight);
        stringBuffer.append(',');
        stringBuffer.append('\n');
        stringBuffer.append("airDistributionConfigZoneLeft");
        stringBuffer.append('=');
        stringBuffer.append(airconRowConfiguration.airDistributionConfigZoneLeft);
        stringBuffer.append(',');
        stringBuffer.append('\n');
        stringBuffer.append("airDistributionConfigZoneRight");
        stringBuffer.append('=');
        stringBuffer.append(airconRowConfiguration.airDistributionConfigZoneRight);
        stringBuffer.append(',');
        stringBuffer.append('\n');
        stringBuffer.append("airconTempStepViaHMI");
        stringBuffer.append('=');
        stringBuffer.append(airconRowConfiguration.airconTempStepViaHMI);
        stringBuffer.append(',');
        stringBuffer.append('\n');
        stringBuffer.append("bcMeasureConfig");
        stringBuffer.append('=');
        stringBuffer.append(airconRowConfiguration.bcMeasureConfig);
        stringBuffer.append(',');
        stringBuffer.append('\n');
        stringBuffer.append("airVolumeSteps");
        stringBuffer.append('=');
        stringBuffer.append(airconRowConfiguration.airVolumeSteps);
        stringBuffer.append(',');
        stringBuffer.append("airDistributionSteps");
        stringBuffer.append('=');
        stringBuffer.append(airconRowConfiguration.airDistributionSteps);
        stringBuffer.append(',');
        stringBuffer.append("airDistributionCombined");
        stringBuffer.append('=');
        stringBuffer.append(airconRowConfiguration.airDistributionCombined);
        stringBuffer.append(',');
        stringBuffer.append("nozzleListTransmittableElements");
        stringBuffer.append('=');
        stringBuffer.append(airconRowConfiguration.nozzleListTransmittableElements);
        stringBuffer.append(',');
        stringBuffer.append('\n');
        stringBuffer.append("nozzleListRAConfig");
        stringBuffer.append('[');
        if (airconRowConfiguration.nozzleListRAConfig != null) {
            stringBuffer.append(airconRowConfiguration.nozzleListRAConfig.length);
        }
        stringBuffer.append(']');
        stringBuffer.append('=');
        stringBuffer.append('{');
        if (airconRowConfiguration.nozzleListRAConfig != null) {
            int n = airconRowConfiguration.nozzleListRAConfig.length;
            int n2 = n - 1;
            for (int i2 = 0; i2 < n; ++i2) {
                stringBuffer.append(airconRowConfiguration.nozzleListRAConfig[i2]);
                if (i2 >= n2) continue;
                stringBuffer.append(',');
            }
        } else {
            stringBuffer.append(airconRowConfiguration.nozzleListRAConfig);
        }
        stringBuffer.append('}');
        stringBuffer.append(')');
        return stringBuffer.toString();
    }

    public static String formatACMasterVO(AirconMasterViewOptions airconMasterViewOptions) {
        StringBuffer stringBuffer = new StringBuffer(-1937309696);
        stringBuffer.append("airconSetFactoryDefaultMaster");
        stringBuffer.append('=');
        stringBuffer.append(airconMasterViewOptions.airconSetFactoryDefaultMaster);
        stringBuffer.append(',');
        stringBuffer.append("airconAC");
        stringBuffer.append('=');
        stringBuffer.append(airconMasterViewOptions.airconAC);
        stringBuffer.append(',');
        stringBuffer.append("airconMaxAC");
        stringBuffer.append('=');
        stringBuffer.append(airconMasterViewOptions.airconMaxAC);
        stringBuffer.append(',');
        stringBuffer.append("airconEcoAC");
        stringBuffer.append('=');
        stringBuffer.append(airconMasterViewOptions.airconEcoAC);
        stringBuffer.append(',');
        stringBuffer.append("airconAirCirculationMan");
        stringBuffer.append('=');
        stringBuffer.append(airconMasterViewOptions.airconAirCirculationMan);
        stringBuffer.append(',');
        stringBuffer.append("airconAirCirculationAuto");
        stringBuffer.append('=');
        stringBuffer.append(airconMasterViewOptions.airconAirCirculationAuto);
        stringBuffer.append(',');
        stringBuffer.append("airconAirCirculationSensitivity");
        stringBuffer.append('=');
        stringBuffer.append(airconMasterViewOptions.airconAirCirculationSensitivity);
        stringBuffer.append(',');
        stringBuffer.append("\n");
        stringBuffer.append("airconSolar");
        stringBuffer.append('=');
        stringBuffer.append(airconMasterViewOptions.airconSolar);
        stringBuffer.append(',');
        stringBuffer.append("airconMiddleExhaust");
        stringBuffer.append('=');
        stringBuffer.append(airconMasterViewOptions.airconMiddleExhaust);
        stringBuffer.append(',');
        stringBuffer.append("airconIndirectVentilation");
        stringBuffer.append('=');
        stringBuffer.append(airconMasterViewOptions.airconIndirectVentilation);
        stringBuffer.append(',');
        stringBuffer.append("airconSynchronisation");
        stringBuffer.append('=');
        stringBuffer.append(airconMasterViewOptions.airconSynchronisation);
        stringBuffer.append(',');
        stringBuffer.append("airconFrontWindowHeater");
        stringBuffer.append('=');
        stringBuffer.append(airconMasterViewOptions.airconFrontWindowHeater);
        stringBuffer.append(',');
        stringBuffer.append("airconFrontWindowHeaterAuto");
        stringBuffer.append('=');
        stringBuffer.append(airconMasterViewOptions.airconFrontWindowHeaterAuto);
        stringBuffer.append(',');
        stringBuffer.append("airconRearWindowHeater");
        stringBuffer.append('=');
        stringBuffer.append(airconMasterViewOptions.airconRearWindowHeater);
        stringBuffer.append(',');
        stringBuffer.append("\n");
        stringBuffer.append("airconSteeringWheelHeaterViewOptions");
        stringBuffer.append('=');
        stringBuffer.append(airconMasterViewOptions.airconSteeringWheelHeaterViewOptions);
        stringBuffer.append(',');
        stringBuffer.append("\n");
        stringBuffer.append("airconPopupTime");
        stringBuffer.append('=');
        stringBuffer.append(airconMasterViewOptions.airconPopupTime);
        stringBuffer.append(',');
        stringBuffer.append("airconSuppressVisualisation");
        stringBuffer.append('=');
        stringBuffer.append(airconMasterViewOptions.airconSuppressVisualisation);
        stringBuffer.append(',');
        stringBuffer.append("airconHeater");
        stringBuffer.append('=');
        stringBuffer.append(airconMasterViewOptions.airconHeater);
        stringBuffer.append(',');
        stringBuffer.append("airconQuickHeater");
        stringBuffer.append('=');
        stringBuffer.append(airconMasterViewOptions.airconQuickHeater);
        stringBuffer.append(',');
        stringBuffer.append("airconRearAuxHeater");
        stringBuffer.append('=');
        stringBuffer.append(airconMasterViewOptions.airconRearAuxHeater);
        stringBuffer.append(',');
        stringBuffer.append("airconResidualHeat");
        stringBuffer.append('=');
        stringBuffer.append(airconMasterViewOptions.airconResidualHeat);
        stringBuffer.append(',');
        stringBuffer.append("\n");
        stringBuffer.append("airconDefrost");
        stringBuffer.append('=');
        stringBuffer.append(airconMasterViewOptions.airconDefrost);
        stringBuffer.append(',');
        stringBuffer.append("airconMaxDefrost");
        stringBuffer.append('=');
        stringBuffer.append(airconMasterViewOptions.airconMaxDefrost);
        stringBuffer.append(',');
        stringBuffer.append("airconSideWindowDefrost");
        stringBuffer.append('=');
        stringBuffer.append(airconMasterViewOptions.airconSideWindowDefrost);
        stringBuffer.append(',');
        stringBuffer.append("airconRearControl");
        stringBuffer.append('=');
        stringBuffer.append(airconMasterViewOptions.airconRearControl);
        stringBuffer.append(',');
        stringBuffer.append("airconRearControlFondPlus");
        stringBuffer.append('=');
        stringBuffer.append(airconMasterViewOptions.airconRearControlFondPlus);
        stringBuffer.append(',');
        stringBuffer.append("\n");
        stringBuffer.append("airconSDSAirBlowerCompensation");
        stringBuffer.append('=');
        stringBuffer.append(airconMasterViewOptions.airconSDSAirBlowerCompensation);
        stringBuffer.append(',');
        stringBuffer.append("airconTelAirBlowerCompensation");
        stringBuffer.append('=');
        stringBuffer.append(airconMasterViewOptions.airconTelAirBlowerCompensation);
        stringBuffer.append(',');
        stringBuffer.append("airconAirQuality");
        stringBuffer.append('=');
        stringBuffer.append(airconMasterViewOptions.airconAirQuality);
        stringBuffer.append(',');
        stringBuffer.append("airconFreshAirConfiguration");
        stringBuffer.append('=');
        stringBuffer.append(airconMasterViewOptions.airconFreshAirConfiguration);
        stringBuffer.append(',');
        stringBuffer.append("airconFreshAirState");
        stringBuffer.append('=');
        stringBuffer.append(airconMasterViewOptions.airconFreshAirState);
        stringBuffer.append(',');
        stringBuffer.append("airconPureAir");
        stringBuffer.append('=');
        stringBuffer.append(airconMasterViewOptions.airconPureAir);
        stringBuffer.append(',');
        stringBuffer.append("\n");
        stringBuffer.append("configuration");
        stringBuffer.append('=');
        stringBuffer.append(airconMasterViewOptions.configuration);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }

    public static String formatZoneVO(AirconZoneViewOptions airconZoneViewOptions) {
        StringBuffer stringBuffer = new StringBuffer(20000);
        stringBuffer.append("AirconZoneViewOptions");
        stringBuffer.append('(');
        stringBuffer.append("airconTemp");
        stringBuffer.append('=');
        stringBuffer.append(airconZoneViewOptions.airconTemp);
        stringBuffer.append(',');
        stringBuffer.append("airconAirVolume");
        stringBuffer.append('=');
        stringBuffer.append(airconZoneViewOptions.airconAirVolume);
        stringBuffer.append(',');
        stringBuffer.append("airconAirDistribution");
        stringBuffer.append('=');
        stringBuffer.append(airconZoneViewOptions.airconAirDistribution);
        stringBuffer.append(',');
        stringBuffer.append("airconFootwellTemp");
        stringBuffer.append('=');
        stringBuffer.append(airconZoneViewOptions.airconFootwellTemp);
        stringBuffer.append(',');
        stringBuffer.append("airconSeatHeater");
        stringBuffer.append('=');
        stringBuffer.append(airconZoneViewOptions.airconSeatHeater);
        stringBuffer.append(',');
        stringBuffer.append("airconSeatVentilation");
        stringBuffer.append('=');
        stringBuffer.append(airconZoneViewOptions.airconSeatVentilation);
        stringBuffer.append(',');
        stringBuffer.append("airconSeatHeaterDistribution");
        stringBuffer.append('=');
        stringBuffer.append(airconZoneViewOptions.airconSeatHeaterDistribution);
        stringBuffer.append(',');
        stringBuffer.append("airconSeatVentilationDistribution");
        stringBuffer.append('=');
        stringBuffer.append(airconZoneViewOptions.airconSeatVentilationDistribution);
        stringBuffer.append(',');
        stringBuffer.append("\n");
        stringBuffer.append("airconTempStep");
        stringBuffer.append('=');
        stringBuffer.append(airconZoneViewOptions.airconTempStep);
        stringBuffer.append(',');
        stringBuffer.append("airconAirVolumeRegulated");
        stringBuffer.append('=');
        stringBuffer.append(airconZoneViewOptions.airconAirVolumeRegulated);
        stringBuffer.append(',');
        stringBuffer.append("airconNeckHeater");
        stringBuffer.append('=');
        stringBuffer.append(airconZoneViewOptions.airconNeckHeater);
        stringBuffer.append(',');
        stringBuffer.append("airconSurfaceHeaterState");
        stringBuffer.append('=');
        stringBuffer.append(airconZoneViewOptions.airconSurfaceHeaterState);
        stringBuffer.append(',');
        stringBuffer.append("airconSurfaceHeaterLink");
        stringBuffer.append('=');
        stringBuffer.append(airconZoneViewOptions.airconSurfaceHeaterLink);
        stringBuffer.append(',');
        stringBuffer.append("airconSurfaceHeaterHeaterLevel");
        stringBuffer.append('=');
        stringBuffer.append(airconZoneViewOptions.airconSurfaceHeaterHeaterLevel);
        stringBuffer.append(',');
        stringBuffer.append("airconIndividualClimatisation");
        stringBuffer.append('=');
        stringBuffer.append(airconZoneViewOptions.airconIndividualClimatisation);
        stringBuffer.append(',');
        stringBuffer.append("airconIonisator");
        stringBuffer.append('=');
        stringBuffer.append(airconZoneViewOptions.airconIonisator);
        stringBuffer.append(',');
        stringBuffer.append("airconBodyCloseMeasures");
        stringBuffer.append('=');
        stringBuffer.append(airconZoneViewOptions.airconBodyCloseMeasures);
        stringBuffer.append(',');
        stringBuffer.append("airconClimateStyle");
        stringBuffer.append('=');
        stringBuffer.append(airconZoneViewOptions.airconClimateStyle);
        stringBuffer.append(',');
        stringBuffer.append("airconClimateState");
        stringBuffer.append('=');
        stringBuffer.append(airconZoneViewOptions.airconClimateState);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

