/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.dsi.trace.optimized.internal.generated.dsi.caraircondition;

import de.vw.mib.dsi.trace.optimized.internal.AbstractOptimzedDSIObjectTracer;
import java.io.PrintWriter;
import org.dsi.ifc.caraircondition.AirconAirDistribution;
import org.dsi.ifc.caraircondition.AirconAirDistributionConfig;
import org.dsi.ifc.caraircondition.AirconAirFlow;
import org.dsi.ifc.caraircondition.AirconAirQuality;
import org.dsi.ifc.caraircondition.AirconAirVolume;
import org.dsi.ifc.caraircondition.AirconBCMeasuresConfiguration;
import org.dsi.ifc.caraircondition.AirconBlowerCompensation;
import org.dsi.ifc.caraircondition.AirconContent;
import org.dsi.ifc.caraircondition.AirconFreshAirCartridge;
import org.dsi.ifc.caraircondition.AirconFreshAirConfiguration;
import org.dsi.ifc.caraircondition.AirconMasterConfiguration;
import org.dsi.ifc.caraircondition.AirconMasterViewOptions;
import org.dsi.ifc.caraircondition.AirconNozzleListCapabilities;
import org.dsi.ifc.caraircondition.AirconNozzleListRecord;
import org.dsi.ifc.caraircondition.AirconNozzleListStyles;
import org.dsi.ifc.caraircondition.AirconPureAirSetup;
import org.dsi.ifc.caraircondition.AirconRowConfiguration;
import org.dsi.ifc.caraircondition.AirconRowViewOptions;
import org.dsi.ifc.caraircondition.AirconSteeringWheelHeater;
import org.dsi.ifc.caraircondition.AirconSteeringWheelHeaterViewOptions;
import org.dsi.ifc.caraircondition.AirconSynchronisation;
import org.dsi.ifc.caraircondition.AirconTemp;
import org.dsi.ifc.caraircondition.AirconZoneViewOptions;

public final class DSICarAirConditionTracer
extends AbstractOptimzedDSIObjectTracer {
    private static final int ID_AIRCONAIRDISTRIBUTION;
    private static final int ID_AIRCONAIRDISTRIBUTIONCONFIG;
    private static final int ID_AIRCONAIRFLOW;
    private static final int ID_AIRCONAIRQUALITY;
    private static final int ID_AIRCONAIRVOLUME;
    private static final int ID_AIRCONBCMEASURESCONFIGURATION;
    private static final int ID_AIRCONBLOWERCOMPENSATION;
    private static final int ID_AIRCONCONTENT;
    private static final int ID_AIRCONFRESHAIRCARTRIDGE;
    private static final int ID_AIRCONFRESHAIRCONFIGURATION;
    private static final int ID_AIRCONMASTERCONFIGURATION;
    private static final int ID_AIRCONMASTERVIEWOPTIONS;
    private static final int ID_AIRCONNOZZLELISTCAPABILITIES;
    private static final int ID_AIRCONNOZZLELISTRECORD;
    private static final int ID_AIRCONNOZZLELISTSTYLES;
    private static final int ID_AIRCONPUREAIRSETUP;
    private static final int ID_AIRCONROWCONFIGURATION;
    private static final int ID_AIRCONROWVIEWOPTIONS;
    private static final int ID_AIRCONSTEERINGWHEELHEATER;
    private static final int ID_AIRCONSTEERINGWHEELHEATERVIEWOPTIONS;
    private static final int ID_AIRCONSYNCHRONISATION;
    private static final int ID_AIRCONTEMP;
    private static final int ID_AIRCONZONEVIEWOPTIONS;
    static /* synthetic */ Class class$org$dsi$ifc$caraircondition$AirconAirDistribution;
    static /* synthetic */ Class class$org$dsi$ifc$caraircondition$AirconAirDistributionConfig;
    static /* synthetic */ Class class$org$dsi$ifc$caraircondition$AirconAirFlow;
    static /* synthetic */ Class class$org$dsi$ifc$caraircondition$AirconAirQuality;
    static /* synthetic */ Class class$org$dsi$ifc$caraircondition$AirconAirVolume;
    static /* synthetic */ Class class$org$dsi$ifc$caraircondition$AirconBCMeasuresConfiguration;
    static /* synthetic */ Class class$org$dsi$ifc$caraircondition$AirconBlowerCompensation;
    static /* synthetic */ Class class$org$dsi$ifc$caraircondition$AirconContent;
    static /* synthetic */ Class class$org$dsi$ifc$caraircondition$AirconFreshAirCartridge;
    static /* synthetic */ Class class$org$dsi$ifc$caraircondition$AirconFreshAirConfiguration;
    static /* synthetic */ Class class$org$dsi$ifc$caraircondition$AirconMasterConfiguration;
    static /* synthetic */ Class class$org$dsi$ifc$caraircondition$AirconMasterViewOptions;
    static /* synthetic */ Class class$org$dsi$ifc$caraircondition$AirconNozzleListCapabilities;
    static /* synthetic */ Class class$org$dsi$ifc$caraircondition$AirconNozzleListRecord;
    static /* synthetic */ Class class$org$dsi$ifc$caraircondition$AirconNozzleListStyles;
    static /* synthetic */ Class class$org$dsi$ifc$caraircondition$AirconPureAirSetup;
    static /* synthetic */ Class class$org$dsi$ifc$caraircondition$AirconRowConfiguration;
    static /* synthetic */ Class class$org$dsi$ifc$caraircondition$AirconRowViewOptions;
    static /* synthetic */ Class class$org$dsi$ifc$caraircondition$AirconSteeringWheelHeater;
    static /* synthetic */ Class class$org$dsi$ifc$caraircondition$AirconSteeringWheelHeaterViewOptions;
    static /* synthetic */ Class class$org$dsi$ifc$caraircondition$AirconSynchronisation;
    static /* synthetic */ Class class$org$dsi$ifc$caraircondition$AirconTemp;
    static /* synthetic */ Class class$org$dsi$ifc$caraircondition$AirconZoneViewOptions;

    public DSICarAirConditionTracer() {
        this.registerDSIDatacontainerID(class$org$dsi$ifc$caraircondition$AirconAirDistribution == null ? (class$org$dsi$ifc$caraircondition$AirconAirDistribution = DSICarAirConditionTracer.class$("org.dsi.ifc.caraircondition.AirconAirDistribution")) : class$org$dsi$ifc$caraircondition$AirconAirDistribution, 1);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$caraircondition$AirconAirDistributionConfig == null ? (class$org$dsi$ifc$caraircondition$AirconAirDistributionConfig = DSICarAirConditionTracer.class$("org.dsi.ifc.caraircondition.AirconAirDistributionConfig")) : class$org$dsi$ifc$caraircondition$AirconAirDistributionConfig, 2);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$caraircondition$AirconAirFlow == null ? (class$org$dsi$ifc$caraircondition$AirconAirFlow = DSICarAirConditionTracer.class$("org.dsi.ifc.caraircondition.AirconAirFlow")) : class$org$dsi$ifc$caraircondition$AirconAirFlow, 3);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$caraircondition$AirconAirQuality == null ? (class$org$dsi$ifc$caraircondition$AirconAirQuality = DSICarAirConditionTracer.class$("org.dsi.ifc.caraircondition.AirconAirQuality")) : class$org$dsi$ifc$caraircondition$AirconAirQuality, 4);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$caraircondition$AirconAirVolume == null ? (class$org$dsi$ifc$caraircondition$AirconAirVolume = DSICarAirConditionTracer.class$("org.dsi.ifc.caraircondition.AirconAirVolume")) : class$org$dsi$ifc$caraircondition$AirconAirVolume, 5);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$caraircondition$AirconBCMeasuresConfiguration == null ? (class$org$dsi$ifc$caraircondition$AirconBCMeasuresConfiguration = DSICarAirConditionTracer.class$("org.dsi.ifc.caraircondition.AirconBCMeasuresConfiguration")) : class$org$dsi$ifc$caraircondition$AirconBCMeasuresConfiguration, 6);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$caraircondition$AirconBlowerCompensation == null ? (class$org$dsi$ifc$caraircondition$AirconBlowerCompensation = DSICarAirConditionTracer.class$("org.dsi.ifc.caraircondition.AirconBlowerCompensation")) : class$org$dsi$ifc$caraircondition$AirconBlowerCompensation, 7);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$caraircondition$AirconContent == null ? (class$org$dsi$ifc$caraircondition$AirconContent = DSICarAirConditionTracer.class$("org.dsi.ifc.caraircondition.AirconContent")) : class$org$dsi$ifc$caraircondition$AirconContent, 8);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$caraircondition$AirconFreshAirCartridge == null ? (class$org$dsi$ifc$caraircondition$AirconFreshAirCartridge = DSICarAirConditionTracer.class$("org.dsi.ifc.caraircondition.AirconFreshAirCartridge")) : class$org$dsi$ifc$caraircondition$AirconFreshAirCartridge, 9);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$caraircondition$AirconFreshAirConfiguration == null ? (class$org$dsi$ifc$caraircondition$AirconFreshAirConfiguration = DSICarAirConditionTracer.class$("org.dsi.ifc.caraircondition.AirconFreshAirConfiguration")) : class$org$dsi$ifc$caraircondition$AirconFreshAirConfiguration, 10);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$caraircondition$AirconMasterConfiguration == null ? (class$org$dsi$ifc$caraircondition$AirconMasterConfiguration = DSICarAirConditionTracer.class$("org.dsi.ifc.caraircondition.AirconMasterConfiguration")) : class$org$dsi$ifc$caraircondition$AirconMasterConfiguration, 11);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$caraircondition$AirconMasterViewOptions == null ? (class$org$dsi$ifc$caraircondition$AirconMasterViewOptions = DSICarAirConditionTracer.class$("org.dsi.ifc.caraircondition.AirconMasterViewOptions")) : class$org$dsi$ifc$caraircondition$AirconMasterViewOptions, 12);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$caraircondition$AirconNozzleListCapabilities == null ? (class$org$dsi$ifc$caraircondition$AirconNozzleListCapabilities = DSICarAirConditionTracer.class$("org.dsi.ifc.caraircondition.AirconNozzleListCapabilities")) : class$org$dsi$ifc$caraircondition$AirconNozzleListCapabilities, 13);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$caraircondition$AirconNozzleListRecord == null ? (class$org$dsi$ifc$caraircondition$AirconNozzleListRecord = DSICarAirConditionTracer.class$("org.dsi.ifc.caraircondition.AirconNozzleListRecord")) : class$org$dsi$ifc$caraircondition$AirconNozzleListRecord, 14);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$caraircondition$AirconNozzleListStyles == null ? (class$org$dsi$ifc$caraircondition$AirconNozzleListStyles = DSICarAirConditionTracer.class$("org.dsi.ifc.caraircondition.AirconNozzleListStyles")) : class$org$dsi$ifc$caraircondition$AirconNozzleListStyles, 15);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$caraircondition$AirconPureAirSetup == null ? (class$org$dsi$ifc$caraircondition$AirconPureAirSetup = DSICarAirConditionTracer.class$("org.dsi.ifc.caraircondition.AirconPureAirSetup")) : class$org$dsi$ifc$caraircondition$AirconPureAirSetup, 16);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$caraircondition$AirconRowConfiguration == null ? (class$org$dsi$ifc$caraircondition$AirconRowConfiguration = DSICarAirConditionTracer.class$("org.dsi.ifc.caraircondition.AirconRowConfiguration")) : class$org$dsi$ifc$caraircondition$AirconRowConfiguration, 17);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$caraircondition$AirconRowViewOptions == null ? (class$org$dsi$ifc$caraircondition$AirconRowViewOptions = DSICarAirConditionTracer.class$("org.dsi.ifc.caraircondition.AirconRowViewOptions")) : class$org$dsi$ifc$caraircondition$AirconRowViewOptions, 18);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$caraircondition$AirconSteeringWheelHeater == null ? (class$org$dsi$ifc$caraircondition$AirconSteeringWheelHeater = DSICarAirConditionTracer.class$("org.dsi.ifc.caraircondition.AirconSteeringWheelHeater")) : class$org$dsi$ifc$caraircondition$AirconSteeringWheelHeater, 19);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$caraircondition$AirconSteeringWheelHeaterViewOptions == null ? (class$org$dsi$ifc$caraircondition$AirconSteeringWheelHeaterViewOptions = DSICarAirConditionTracer.class$("org.dsi.ifc.caraircondition.AirconSteeringWheelHeaterViewOptions")) : class$org$dsi$ifc$caraircondition$AirconSteeringWheelHeaterViewOptions, 20);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$caraircondition$AirconSynchronisation == null ? (class$org$dsi$ifc$caraircondition$AirconSynchronisation = DSICarAirConditionTracer.class$("org.dsi.ifc.caraircondition.AirconSynchronisation")) : class$org$dsi$ifc$caraircondition$AirconSynchronisation, 21);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$caraircondition$AirconTemp == null ? (class$org$dsi$ifc$caraircondition$AirconTemp = DSICarAirConditionTracer.class$("org.dsi.ifc.caraircondition.AirconTemp")) : class$org$dsi$ifc$caraircondition$AirconTemp, 22);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$caraircondition$AirconZoneViewOptions == null ? (class$org$dsi$ifc$caraircondition$AirconZoneViewOptions = DSICarAirConditionTracer.class$("org.dsi.ifc.caraircondition.AirconZoneViewOptions")) : class$org$dsi$ifc$caraircondition$AirconZoneViewOptions, 23);
    }

    @Override
    public void traceDSIObject(PrintWriter printWriter, Object object) {
        if (printWriter == null) {
            return;
        }
        switch (this.resolveID(object)) {
            case 1: {
                this.traceAirconAirDistribution(printWriter, (AirconAirDistribution)object);
                break;
            }
            case 2: {
                this.traceAirconAirDistributionConfig(printWriter, (AirconAirDistributionConfig)object);
                break;
            }
            case 3: {
                this.traceAirconAirFlow(printWriter, (AirconAirFlow)object);
                break;
            }
            case 4: {
                this.traceAirconAirQuality(printWriter, (AirconAirQuality)object);
                break;
            }
            case 5: {
                this.traceAirconAirVolume(printWriter, (AirconAirVolume)object);
                break;
            }
            case 6: {
                this.traceAirconBCMeasuresConfiguration(printWriter, (AirconBCMeasuresConfiguration)object);
                break;
            }
            case 7: {
                this.traceAirconBlowerCompensation(printWriter, (AirconBlowerCompensation)object);
                break;
            }
            case 8: {
                this.traceAirconContent(printWriter, (AirconContent)object);
                break;
            }
            case 9: {
                this.traceAirconFreshAirCartridge(printWriter, (AirconFreshAirCartridge)object);
                break;
            }
            case 10: {
                this.traceAirconFreshAirConfiguration(printWriter, (AirconFreshAirConfiguration)object);
                break;
            }
            case 11: {
                this.traceAirconMasterConfiguration(printWriter, (AirconMasterConfiguration)object);
                break;
            }
            case 12: {
                this.traceAirconMasterViewOptions(printWriter, (AirconMasterViewOptions)object);
                break;
            }
            case 13: {
                this.traceAirconNozzleListCapabilities(printWriter, (AirconNozzleListCapabilities)object);
                break;
            }
            case 14: {
                this.traceAirconNozzleListRecord(printWriter, (AirconNozzleListRecord)object);
                break;
            }
            case 15: {
                this.traceAirconNozzleListStyles(printWriter, (AirconNozzleListStyles)object);
                break;
            }
            case 16: {
                this.traceAirconPureAirSetup(printWriter, (AirconPureAirSetup)object);
                break;
            }
            case 17: {
                this.traceAirconRowConfiguration(printWriter, (AirconRowConfiguration)object);
                break;
            }
            case 18: {
                this.traceAirconRowViewOptions(printWriter, (AirconRowViewOptions)object);
                break;
            }
            case 19: {
                this.traceAirconSteeringWheelHeater(printWriter, (AirconSteeringWheelHeater)object);
                break;
            }
            case 20: {
                this.traceAirconSteeringWheelHeaterViewOptions(printWriter, (AirconSteeringWheelHeaterViewOptions)object);
                break;
            }
            case 21: {
                this.traceAirconSynchronisation(printWriter, (AirconSynchronisation)object);
                break;
            }
            case 22: {
                this.traceAirconTemp(printWriter, (AirconTemp)object);
                break;
            }
            case 23: {
                this.traceAirconZoneViewOptions(printWriter, (AirconZoneViewOptions)object);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Not a valid DSI object for tracing: ").append(object.getClass()).toString());
            }
        }
    }

    private void traceAirconAirDistribution(PrintWriter printWriter, AirconAirDistribution airconAirDistribution) {
        if (airconAirDistribution == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(airconAirDistribution.up);
        printWriter.print(airconAirDistribution.body);
        printWriter.print(airconAirDistribution.footwell);
        printWriter.print(airconAirDistribution.indirect);
        printWriter.print(airconAirDistribution.automode);
        printWriter.print(airconAirDistribution.autoDemandOriented);
        printWriter.print(airconAirDistribution.side);
    }

    private void traceAirconAirDistributionConfig(PrintWriter printWriter, AirconAirDistributionConfig airconAirDistributionConfig) {
        if (airconAirDistributionConfig == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(airconAirDistributionConfig.autoSupported);
        printWriter.print(airconAirDistributionConfig.downUp);
        printWriter.print(airconAirDistributionConfig.up);
        printWriter.print(airconAirDistributionConfig.upMiddle);
        printWriter.print(airconAirDistributionConfig.middle);
        printWriter.print(airconAirDistributionConfig.downMiddle);
        printWriter.print(airconAirDistributionConfig.down);
        printWriter.print(airconAirDistributionConfig.upMiddleDown);
    }

    private void traceAirconAirFlow(PrintWriter printWriter, AirconAirFlow airconAirFlow) {
        if (airconAirFlow == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(airconAirFlow.outletUp);
        printWriter.print(airconAirFlow.outletBody);
        printWriter.print(airconAirFlow.outletFootwell);
        printWriter.print(airconAirFlow.outletIndirect);
        printWriter.print(airconAirFlow.automaticAirDistribution);
        printWriter.print(airconAirFlow.outletSide);
    }

    private void traceAirconAirQuality(PrintWriter printWriter, AirconAirQuality airconAirQuality) {
        if (airconAirQuality == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(airconAirQuality.outsideCustomerThreshold);
        printWriter.print(airconAirQuality.outsideOnlineData);
        printWriter.print(airconAirQuality.incarCO2);
        printWriter.print(airconAirQuality.incarPollution);
    }

    private void traceAirconAirVolume(PrintWriter printWriter, AirconAirVolume airconAirVolume) {
        if (airconAirVolume == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(airconAirVolume.airVolume);
        printWriter.print(airconAirVolume.airVolumeRegulated);
        printWriter.print(airconAirVolume.airVolumeAuto);
    }

    private void traceAirconBCMeasuresConfiguration(PrintWriter printWriter, AirconBCMeasuresConfiguration airconBCMeasuresConfiguration) {
        if (airconBCMeasuresConfiguration == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(airconBCMeasuresConfiguration.swh);
        printWriter.print(airconBCMeasuresConfiguration.seatHeater);
        printWriter.print(airconBCMeasuresConfiguration.seatVentilation);
        printWriter.print(airconBCMeasuresConfiguration.surfaceHeater);
        printWriter.print(airconBCMeasuresConfiguration.neckHeater);
    }

    private void traceAirconBlowerCompensation(PrintWriter printWriter, AirconBlowerCompensation airconBlowerCompensation) {
        if (airconBlowerCompensation == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(airconBlowerCompensation.sds);
        printWriter.print(airconBlowerCompensation.tel);
    }

    private void traceAirconContent(PrintWriter printWriter, AirconContent airconContent) {
        if (airconContent == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(airconContent.zone1);
        printWriter.print(airconContent.zone2);
        printWriter.print(airconContent.zone3);
        printWriter.print(airconContent.zone4);
        printWriter.print(airconContent.zone5);
        printWriter.print(airconContent.zone6);
        printWriter.print(airconContent.master);
    }

    private void traceAirconFreshAirCartridge(PrintWriter printWriter, AirconFreshAirCartridge airconFreshAirCartridge) {
        if (airconFreshAirCartridge == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(airconFreshAirCartridge.level);
        printWriter.print(airconFreshAirCartridge.warning);
        printWriter.print(airconFreshAirCartridge.flavourID);
    }

    private void traceAirconFreshAirConfiguration(PrintWriter printWriter, AirconFreshAirConfiguration airconFreshAirConfiguration) {
        if (airconFreshAirConfiguration == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(airconFreshAirConfiguration.setup);
        printWriter.print(airconFreshAirConfiguration.flavourSelection);
        printWriter.print(airconFreshAirConfiguration.intensityCartridge1);
        printWriter.print(airconFreshAirConfiguration.intensityCartridge2);
    }

    private void traceAirconMasterConfiguration(PrintWriter printWriter, AirconMasterConfiguration airconMasterConfiguration) {
        if (airconMasterConfiguration == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(airconMasterConfiguration.carDriverSide);
        printWriter.print(airconMasterConfiguration.numberOfZones);
        printWriter.print(airconMasterConfiguration.zl1r);
        printWriter.print(airconMasterConfiguration.zr1r);
        printWriter.print(airconMasterConfiguration.zl2r);
        printWriter.print(airconMasterConfiguration.zr2r);
        printWriter.print(airconMasterConfiguration.zl3r);
        printWriter.print(airconMasterConfiguration.zr3r);
        printWriter.print(airconMasterConfiguration.freshAirCartridge1);
        printWriter.print(airconMasterConfiguration.freshAirCartridge2);
        printWriter.print(airconMasterConfiguration.pureAirIonisator);
        printWriter.print(airconMasterConfiguration.pureAirFragrance);
        printWriter.print(airconMasterConfiguration.airQualityParticleSensor);
        printWriter.print(airconMasterConfiguration.airQualityInCarQualityCO2);
        printWriter.print(airconMasterConfiguration.airQualityInCarQualityPollution);
        printWriter.print(airconMasterConfiguration.airQualityOutsideCustomerThreshold);
    }

    private void traceAirconMasterViewOptions(PrintWriter printWriter, AirconMasterViewOptions airconMasterViewOptions) {
        if (airconMasterViewOptions == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        this.trace(printWriter, airconMasterViewOptions.airconSetFactoryDefaultMaster);
        this.trace(printWriter, airconMasterViewOptions.airconAC);
        this.trace(printWriter, airconMasterViewOptions.airconMaxAC);
        this.trace(printWriter, airconMasterViewOptions.airconEcoAC);
        this.trace(printWriter, airconMasterViewOptions.airconAirCirculationMan);
        this.trace(printWriter, airconMasterViewOptions.airconAirCirculationAuto);
        this.trace(printWriter, airconMasterViewOptions.airconAirCirculationSensitivity);
        this.trace(printWriter, airconMasterViewOptions.airconSolar);
        this.trace(printWriter, airconMasterViewOptions.airconMiddleExhaust);
        this.trace(printWriter, airconMasterViewOptions.airconIndirectVentilation);
        this.trace(printWriter, airconMasterViewOptions.airconSynchronisation);
        this.trace(printWriter, airconMasterViewOptions.airconFrontWindowHeater);
        this.trace(printWriter, airconMasterViewOptions.airconFrontWindowHeaterAuto);
        this.trace(printWriter, airconMasterViewOptions.airconRearWindowHeater);
        this.trace(printWriter, airconMasterViewOptions.airconSteeringWheelHeaterViewOptions);
        this.trace(printWriter, airconMasterViewOptions.airconPopupTime);
        this.trace(printWriter, airconMasterViewOptions.airconSuppressVisualisation);
        this.trace(printWriter, airconMasterViewOptions.airconHeater);
        this.trace(printWriter, airconMasterViewOptions.airconQuickHeater);
        this.trace(printWriter, airconMasterViewOptions.airconRearAuxHeater);
        this.trace(printWriter, airconMasterViewOptions.airconResidualHeat);
        this.trace(printWriter, airconMasterViewOptions.airconDefrost);
        this.trace(printWriter, airconMasterViewOptions.airconMaxDefrost);
        this.trace(printWriter, airconMasterViewOptions.airconSideWindowDefrost);
        this.trace(printWriter, airconMasterViewOptions.airconRearControl);
        this.trace(printWriter, airconMasterViewOptions.airconRearControlFondPlus);
        this.trace(printWriter, airconMasterViewOptions.airconSDSAirBlowerCompensation);
        this.trace(printWriter, airconMasterViewOptions.airconTelAirBlowerCompensation);
        this.trace(printWriter, airconMasterViewOptions.airconAirQuality);
        this.trace(printWriter, airconMasterViewOptions.airconFreshAirConfiguration);
        this.trace(printWriter, airconMasterViewOptions.airconFreshAirState);
        this.trace(printWriter, airconMasterViewOptions.airconPureAir);
        this.trace(printWriter, airconMasterViewOptions.configuration);
    }

    private void traceAirconNozzleListCapabilities(PrintWriter printWriter, AirconNozzleListCapabilities airconNozzleListCapabilities) {
        if (airconNozzleListCapabilities == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(airconNozzleListCapabilities.horizontalPosition);
        printWriter.print(airconNozzleListCapabilities.verticalPosition);
        printWriter.print(airconNozzleListCapabilities.airflow);
        printWriter.print(airconNozzleListCapabilities.style);
        printWriter.print(airconNozzleListCapabilities.intervalHorizontal);
        printWriter.print(airconNozzleListCapabilities.intervalVertical);
    }

    private void traceAirconNozzleListRecord(PrintWriter printWriter, AirconNozzleListRecord airconNozzleListRecord) {
        if (airconNozzleListRecord == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(airconNozzleListRecord.pos);
        printWriter.print(airconNozzleListRecord.horizontalPosition);
        printWriter.print(airconNozzleListRecord.verticalPosition);
        this.trace(printWriter, airconNozzleListRecord.capabilities);
        printWriter.print(airconNozzleListRecord.horizontal);
        printWriter.print(airconNozzleListRecord.vertical);
        printWriter.print(airconNozzleListRecord.airflow);
        this.trace(printWriter, airconNozzleListRecord.style);
        printWriter.print(airconNozzleListRecord.intervalHorizontal);
        printWriter.print(airconNozzleListRecord.intervalVertical);
    }

    private void traceAirconNozzleListStyles(PrintWriter printWriter, AirconNozzleListStyles airconNozzleListStyles) {
        if (airconNozzleListStyles == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(airconNozzleListStyles.interval);
        printWriter.print(airconNozzleListStyles.focus);
        printWriter.print(airconNozzleListStyles.diffuse);
        printWriter.print(airconNozzleListStyles.manual);
    }

    private void traceAirconPureAirSetup(PrintWriter printWriter, AirconPureAirSetup airconPureAirSetup) {
        if (airconPureAirSetup == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(airconPureAirSetup.systemOnOff);
        printWriter.print(airconPureAirSetup.ionisator);
        printWriter.print(airconPureAirSetup.fragrance);
    }

    private void traceAirconRowConfiguration(PrintWriter printWriter, AirconRowConfiguration airconRowConfiguration) {
        if (airconRowConfiguration == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(airconRowConfiguration.externalDisplay);
        printWriter.print(airconRowConfiguration.setupButton);
        printWriter.print(airconRowConfiguration.autoMode);
        this.trace(printWriter, airconRowConfiguration.airFlowConfigZoneLeft);
        this.trace(printWriter, airconRowConfiguration.airFlowConfigZoneRight);
        this.trace(printWriter, airconRowConfiguration.airDistributionConfigZoneLeft);
        this.trace(printWriter, airconRowConfiguration.airDistributionConfigZoneRight);
        printWriter.print(airconRowConfiguration.airconTempStepViaHMI);
        this.trace(printWriter, airconRowConfiguration.bcMeasureConfig);
        printWriter.print(airconRowConfiguration.airVolumeSteps);
        printWriter.print(airconRowConfiguration.airDistributionSteps);
        printWriter.print(airconRowConfiguration.airDistributionCombined);
        this.trace(printWriter, airconRowConfiguration.nozzleListTransmittableElements);
        if (airconRowConfiguration.nozzleListRAConfig == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            int n = airconRowConfiguration.nozzleListRAConfig.length;
            printWriter.print(n);
            for (int i2 = 0; i2 < n; ++i2) {
                printWriter.print(airconRowConfiguration.nozzleListRAConfig[i2]);
            }
        }
    }

    private void traceAirconRowViewOptions(PrintWriter printWriter, AirconRowViewOptions airconRowViewOptions) {
        if (airconRowViewOptions == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        this.trace(printWriter, airconRowViewOptions.airconSystemOnOffRow);
        this.trace(printWriter, airconRowViewOptions.airconSetFactoryDefaultRow);
        this.trace(printWriter, airconRowViewOptions.airconNozzleList);
        this.trace(printWriter, airconRowViewOptions.airconNozzleControl);
        this.trace(printWriter, airconRowViewOptions.airconNozzleStatus);
        this.trace(printWriter, airconRowViewOptions.zoneLeftViewOptions);
        this.trace(printWriter, airconRowViewOptions.zoneRightViewOptions);
        this.trace(printWriter, airconRowViewOptions.configuration);
    }

    private void traceAirconSteeringWheelHeater(PrintWriter printWriter, AirconSteeringWheelHeater airconSteeringWheelHeater) {
        if (airconSteeringWheelHeater == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(airconSteeringWheelHeater.heating);
        printWriter.print(airconSteeringWheelHeater.currentState);
        printWriter.print(airconSteeringWheelHeater.autoHeating);
        printWriter.print(airconSteeringWheelHeater.adjustViaSeatHeating);
        printWriter.print(airconSteeringWheelHeater.heatingStep);
    }

    private void traceAirconSteeringWheelHeaterViewOptions(PrintWriter printWriter, AirconSteeringWheelHeaterViewOptions airconSteeringWheelHeaterViewOptions) {
        if (airconSteeringWheelHeaterViewOptions == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        this.trace(printWriter, airconSteeringWheelHeaterViewOptions.heating);
        this.trace(printWriter, airconSteeringWheelHeaterViewOptions.autoHeating);
        this.trace(printWriter, airconSteeringWheelHeaterViewOptions.heatingStep);
        this.trace(printWriter, airconSteeringWheelHeaterViewOptions.adjustViaSeatHeating);
        this.trace(printWriter, airconSteeringWheelHeaterViewOptions.currentState);
    }

    private void traceAirconSynchronisation(PrintWriter printWriter, AirconSynchronisation airconSynchronisation) {
        if (airconSynchronisation == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(airconSynchronisation.master);
        printWriter.print(airconSynchronisation.slaveZL1R);
        printWriter.print(airconSynchronisation.slaveZR1R);
        printWriter.print(airconSynchronisation.slaveZL2R);
        printWriter.print(airconSynchronisation.slaveZR2R);
        printWriter.print(airconSynchronisation.slaveZL3R);
        printWriter.print(airconSynchronisation.slaveZR3R);
    }

    private void traceAirconTemp(PrintWriter printWriter, AirconTemp airconTemp) {
        if (airconTemp == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(airconTemp.tempValue);
        printWriter.print(airconTemp.tempUnit);
    }

    private void traceAirconZoneViewOptions(PrintWriter printWriter, AirconZoneViewOptions airconZoneViewOptions) {
        if (airconZoneViewOptions == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        this.trace(printWriter, airconZoneViewOptions.airconTemp);
        this.trace(printWriter, airconZoneViewOptions.airconAirVolume);
        this.trace(printWriter, airconZoneViewOptions.airconAirDistribution);
        this.trace(printWriter, airconZoneViewOptions.airconFootwellTemp);
        this.trace(printWriter, airconZoneViewOptions.airconSeatHeater);
        this.trace(printWriter, airconZoneViewOptions.airconSeatVentilation);
        this.trace(printWriter, airconZoneViewOptions.airconSeatHeaterDistribution);
        this.trace(printWriter, airconZoneViewOptions.airconSeatVentilationDistribution);
        this.trace(printWriter, airconZoneViewOptions.airconTempStep);
        this.trace(printWriter, airconZoneViewOptions.airconAirVolumeRegulated);
        this.trace(printWriter, airconZoneViewOptions.airconNeckHeater);
        this.trace(printWriter, airconZoneViewOptions.airconSurfaceHeaterState);
        this.trace(printWriter, airconZoneViewOptions.airconSurfaceHeaterLink);
        this.trace(printWriter, airconZoneViewOptions.airconSurfaceHeaterHeaterLevel);
        this.trace(printWriter, airconZoneViewOptions.airconIndividualClimatisation);
        this.trace(printWriter, airconZoneViewOptions.airconIonisator);
        this.trace(printWriter, airconZoneViewOptions.airconBodyCloseMeasures);
        this.trace(printWriter, airconZoneViewOptions.airconClimateStyle);
        this.trace(printWriter, airconZoneViewOptions.airconClimateState);
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

