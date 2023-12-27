/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.dsi.trace.optimized.internal.generated.dsi.carkombi;

import de.vw.mib.dsi.trace.optimized.internal.AbstractOptimzedDSIObjectTracer;
import java.io.PrintWriter;
import org.dsi.ifc.carkombi.BCAverageRecoveredEnergy;
import org.dsi.ifc.carkombi.BCComfortPowerConsumption;
import org.dsi.ifc.carkombi.BCConfiguration;
import org.dsi.ifc.carkombi.BCCounter;
import org.dsi.ifc.carkombi.BCCycleGeneralData;
import org.dsi.ifc.carkombi.BCFISAdditionalConfiguration;
import org.dsi.ifc.carkombi.BCFunctionSupport;
import org.dsi.ifc.carkombi.BCIndications;
import org.dsi.ifc.carkombi.BCLongTermGeneralData;
import org.dsi.ifc.carkombi.BCMaxValues;
import org.dsi.ifc.carkombi.BCMenueConfiguration;
import org.dsi.ifc.carkombi.BCRefuelVolume;
import org.dsi.ifc.carkombi.BCResetTimeStamp;
import org.dsi.ifc.carkombi.BCShortTermGeneralData;
import org.dsi.ifc.carkombi.BCSpeedWarningSettings;
import org.dsi.ifc.carkombi.BCStatisticsAC;
import org.dsi.ifc.carkombi.BCStatisticsConfig;
import org.dsi.ifc.carkombi.BCStatisticsDistanceEU;
import org.dsi.ifc.carkombi.BCStatisticsRE;
import org.dsi.ifc.carkombi.BCStatisticsReset;
import org.dsi.ifc.carkombi.BCStatisticsZE;
import org.dsi.ifc.carkombi.BCTankLevel;
import org.dsi.ifc.carkombi.BCTotalDistance;
import org.dsi.ifc.carkombi.BCTransmittableElements;
import org.dsi.ifc.carkombi.BCVehicleStateUpdateInfoAH;
import org.dsi.ifc.carkombi.BCViewOptions;
import org.dsi.ifc.carkombi.BCZeroEmissionAbsoluteDistance;
import org.dsi.ifc.carkombi.BCZeroEmissionAbsoluteTime;
import org.dsi.ifc.carkombi.BCZeroEmissionRelative;
import org.dsi.ifc.carkombi.DCAdditionalInfo;
import org.dsi.ifc.carkombi.DCAdditionalInstrument;
import org.dsi.ifc.carkombi.DCAdditionalInstrument2;
import org.dsi.ifc.carkombi.DCConfiguration;
import org.dsi.ifc.carkombi.DCDisplayDependency;
import org.dsi.ifc.carkombi.DCDisplayPresetsListRecord;
import org.dsi.ifc.carkombi.DCDisplayPresetsListRecordDisplayData;
import org.dsi.ifc.carkombi.DCDisplayViewConfiguration;
import org.dsi.ifc.carkombi.DCDisplayedAdditionalInfos;
import org.dsi.ifc.carkombi.DCElementContentSelectionListRA1;
import org.dsi.ifc.carkombi.DCElementContentSelectionListRA2;
import org.dsi.ifc.carkombi.DCElementContentSelectionListUpdateInfo;
import org.dsi.ifc.carkombi.DCMainItems;
import org.dsi.ifc.carkombi.DCTransmittableElements;
import org.dsi.ifc.carkombi.DCViewOptions;
import org.dsi.ifc.carkombi.HUDConfiguration;
import org.dsi.ifc.carkombi.HUDContent;
import org.dsi.ifc.carkombi.HUDViewOptions;
import org.dsi.ifc.carkombi.ListDynValues;
import org.dsi.ifc.carkombi.ListWarningIDsDynValues;
import org.dsi.ifc.carkombi.SIAConfiguration;
import org.dsi.ifc.carkombi.SIADistanceData;
import org.dsi.ifc.carkombi.SIAHistoryListRecord;
import org.dsi.ifc.carkombi.SIAOilInspection;
import org.dsi.ifc.carkombi.SIAResetValues;
import org.dsi.ifc.carkombi.SIAServiceAttributes;
import org.dsi.ifc.carkombi.SIAServiceData;
import org.dsi.ifc.carkombi.SIAServiceTypes;
import org.dsi.ifc.carkombi.SIAViewOptions;

public final class DSICarKombiTracer
extends AbstractOptimzedDSIObjectTracer {
    private static final int ID_BCAVERAGERECOVEREDENERGY;
    private static final int ID_BCCOMFORTPOWERCONSUMPTION;
    private static final int ID_BCCONFIGURATION;
    private static final int ID_BCCOUNTER;
    private static final int ID_BCCYCLEGENERALDATA;
    private static final int ID_BCFISADDITIONALCONFIGURATION;
    private static final int ID_BCFUNCTIONSUPPORT;
    private static final int ID_BCINDICATIONS;
    private static final int ID_BCLONGTERMGENERALDATA;
    private static final int ID_BCMAXVALUES;
    private static final int ID_BCMENUECONFIGURATION;
    private static final int ID_BCREFUELVOLUME;
    private static final int ID_BCRESETTIMESTAMP;
    private static final int ID_BCSHORTTERMGENERALDATA;
    private static final int ID_BCSPEEDWARNINGSETTINGS;
    private static final int ID_BCSTATISTICSAC;
    private static final int ID_BCSTATISTICSCONFIG;
    private static final int ID_BCSTATISTICSDISTANCEEU;
    private static final int ID_BCSTATISTICSRE;
    private static final int ID_BCSTATISTICSRESET;
    private static final int ID_BCSTATISTICSZE;
    private static final int ID_BCTANKLEVEL;
    private static final int ID_BCTOTALDISTANCE;
    private static final int ID_BCTRANSMITTABLEELEMENTS;
    private static final int ID_BCVEHICLESTATEUPDATEINFOAH;
    private static final int ID_BCVIEWOPTIONS;
    private static final int ID_BCZEROEMISSIONABSOLUTEDISTANCE;
    private static final int ID_BCZEROEMISSIONABSOLUTETIME;
    private static final int ID_BCZEROEMISSIONRELATIVE;
    private static final int ID_DCADDITIONALINFO;
    private static final int ID_DCADDITIONALINSTRUMENT;
    private static final int ID_DCADDITIONALINSTRUMENT2;
    private static final int ID_DCCONFIGURATION;
    private static final int ID_DCDISPLAYDEPENDENCY;
    private static final int ID_DCDISPLAYPRESETSLISTRECORD;
    private static final int ID_DCDISPLAYPRESETSLISTRECORDDISPLAYDATA;
    private static final int ID_DCDISPLAYVIEWCONFIGURATION;
    private static final int ID_DCDISPLAYEDADDITIONALINFOS;
    private static final int ID_DCELEMENTCONTENTSELECTIONLISTRA1;
    private static final int ID_DCELEMENTCONTENTSELECTIONLISTRA2;
    private static final int ID_DCELEMENTCONTENTSELECTIONLISTUPDATEINFO;
    private static final int ID_DCMAINITEMS;
    private static final int ID_DCTRANSMITTABLEELEMENTS;
    private static final int ID_DCVIEWOPTIONS;
    private static final int ID_HUDCONFIGURATION;
    private static final int ID_HUDCONTENT;
    private static final int ID_HUDVIEWOPTIONS;
    private static final int ID_LISTDYNVALUES;
    private static final int ID_LISTWARNINGIDSDYNVALUES;
    private static final int ID_SIACONFIGURATION;
    private static final int ID_SIADISTANCEDATA;
    private static final int ID_SIAHISTORYLISTRECORD;
    private static final int ID_SIAOILINSPECTION;
    private static final int ID_SIARESETVALUES;
    private static final int ID_SIASERVICEATTRIBUTES;
    private static final int ID_SIASERVICEDATA;
    private static final int ID_SIASERVICETYPES;
    private static final int ID_SIAVIEWOPTIONS;
    static /* synthetic */ Class class$org$dsi$ifc$carkombi$BCAverageRecoveredEnergy;
    static /* synthetic */ Class class$org$dsi$ifc$carkombi$BCComfortPowerConsumption;
    static /* synthetic */ Class class$org$dsi$ifc$carkombi$BCConfiguration;
    static /* synthetic */ Class class$org$dsi$ifc$carkombi$BCCounter;
    static /* synthetic */ Class class$org$dsi$ifc$carkombi$BCCycleGeneralData;
    static /* synthetic */ Class class$org$dsi$ifc$carkombi$BCFISAdditionalConfiguration;
    static /* synthetic */ Class class$org$dsi$ifc$carkombi$BCFunctionSupport;
    static /* synthetic */ Class class$org$dsi$ifc$carkombi$BCIndications;
    static /* synthetic */ Class class$org$dsi$ifc$carkombi$BCLongTermGeneralData;
    static /* synthetic */ Class class$org$dsi$ifc$carkombi$BCMaxValues;
    static /* synthetic */ Class class$org$dsi$ifc$carkombi$BCMenueConfiguration;
    static /* synthetic */ Class class$org$dsi$ifc$carkombi$BCRefuelVolume;
    static /* synthetic */ Class class$org$dsi$ifc$carkombi$BCResetTimeStamp;
    static /* synthetic */ Class class$org$dsi$ifc$carkombi$BCShortTermGeneralData;
    static /* synthetic */ Class class$org$dsi$ifc$carkombi$BCSpeedWarningSettings;
    static /* synthetic */ Class class$org$dsi$ifc$carkombi$BCStatisticsAC;
    static /* synthetic */ Class class$org$dsi$ifc$carkombi$BCStatisticsConfig;
    static /* synthetic */ Class class$org$dsi$ifc$carkombi$BCStatisticsDistanceEU;
    static /* synthetic */ Class class$org$dsi$ifc$carkombi$BCStatisticsRE;
    static /* synthetic */ Class class$org$dsi$ifc$carkombi$BCStatisticsReset;
    static /* synthetic */ Class class$org$dsi$ifc$carkombi$BCStatisticsZE;
    static /* synthetic */ Class class$org$dsi$ifc$carkombi$BCTankLevel;
    static /* synthetic */ Class class$org$dsi$ifc$carkombi$BCTotalDistance;
    static /* synthetic */ Class class$org$dsi$ifc$carkombi$BCTransmittableElements;
    static /* synthetic */ Class class$org$dsi$ifc$carkombi$BCVehicleStateUpdateInfoAH;
    static /* synthetic */ Class class$org$dsi$ifc$carkombi$BCViewOptions;
    static /* synthetic */ Class class$org$dsi$ifc$carkombi$BCZeroEmissionAbsoluteDistance;
    static /* synthetic */ Class class$org$dsi$ifc$carkombi$BCZeroEmissionAbsoluteTime;
    static /* synthetic */ Class class$org$dsi$ifc$carkombi$BCZeroEmissionRelative;
    static /* synthetic */ Class class$org$dsi$ifc$carkombi$DCAdditionalInfo;
    static /* synthetic */ Class class$org$dsi$ifc$carkombi$DCAdditionalInstrument;
    static /* synthetic */ Class class$org$dsi$ifc$carkombi$DCAdditionalInstrument2;
    static /* synthetic */ Class class$org$dsi$ifc$carkombi$DCConfiguration;
    static /* synthetic */ Class class$org$dsi$ifc$carkombi$DCDisplayDependency;
    static /* synthetic */ Class class$org$dsi$ifc$carkombi$DCDisplayPresetsListRecord;
    static /* synthetic */ Class class$org$dsi$ifc$carkombi$DCDisplayPresetsListRecordDisplayData;
    static /* synthetic */ Class class$org$dsi$ifc$carkombi$DCDisplayViewConfiguration;
    static /* synthetic */ Class class$org$dsi$ifc$carkombi$DCDisplayedAdditionalInfos;
    static /* synthetic */ Class class$org$dsi$ifc$carkombi$DCElementContentSelectionListRA1;
    static /* synthetic */ Class class$org$dsi$ifc$carkombi$DCElementContentSelectionListRA2;
    static /* synthetic */ Class class$org$dsi$ifc$carkombi$DCElementContentSelectionListUpdateInfo;
    static /* synthetic */ Class class$org$dsi$ifc$carkombi$DCMainItems;
    static /* synthetic */ Class class$org$dsi$ifc$carkombi$DCTransmittableElements;
    static /* synthetic */ Class class$org$dsi$ifc$carkombi$DCViewOptions;
    static /* synthetic */ Class class$org$dsi$ifc$carkombi$HUDConfiguration;
    static /* synthetic */ Class class$org$dsi$ifc$carkombi$HUDContent;
    static /* synthetic */ Class class$org$dsi$ifc$carkombi$HUDViewOptions;
    static /* synthetic */ Class class$org$dsi$ifc$carkombi$ListDynValues;
    static /* synthetic */ Class class$org$dsi$ifc$carkombi$ListWarningIDsDynValues;
    static /* synthetic */ Class class$org$dsi$ifc$carkombi$SIAConfiguration;
    static /* synthetic */ Class class$org$dsi$ifc$carkombi$SIADistanceData;
    static /* synthetic */ Class class$org$dsi$ifc$carkombi$SIAHistoryListRecord;
    static /* synthetic */ Class class$org$dsi$ifc$carkombi$SIAOilInspection;
    static /* synthetic */ Class class$org$dsi$ifc$carkombi$SIAResetValues;
    static /* synthetic */ Class class$org$dsi$ifc$carkombi$SIAServiceAttributes;
    static /* synthetic */ Class class$org$dsi$ifc$carkombi$SIAServiceData;
    static /* synthetic */ Class class$org$dsi$ifc$carkombi$SIAServiceTypes;
    static /* synthetic */ Class class$org$dsi$ifc$carkombi$SIAViewOptions;

    public DSICarKombiTracer() {
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carkombi$BCAverageRecoveredEnergy == null ? (class$org$dsi$ifc$carkombi$BCAverageRecoveredEnergy = DSICarKombiTracer.class$("org.dsi.ifc.carkombi.BCAverageRecoveredEnergy")) : class$org$dsi$ifc$carkombi$BCAverageRecoveredEnergy, 1);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carkombi$BCComfortPowerConsumption == null ? (class$org$dsi$ifc$carkombi$BCComfortPowerConsumption = DSICarKombiTracer.class$("org.dsi.ifc.carkombi.BCComfortPowerConsumption")) : class$org$dsi$ifc$carkombi$BCComfortPowerConsumption, 2);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carkombi$BCConfiguration == null ? (class$org$dsi$ifc$carkombi$BCConfiguration = DSICarKombiTracer.class$("org.dsi.ifc.carkombi.BCConfiguration")) : class$org$dsi$ifc$carkombi$BCConfiguration, 3);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carkombi$BCCounter == null ? (class$org$dsi$ifc$carkombi$BCCounter = DSICarKombiTracer.class$("org.dsi.ifc.carkombi.BCCounter")) : class$org$dsi$ifc$carkombi$BCCounter, 4);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carkombi$BCCycleGeneralData == null ? (class$org$dsi$ifc$carkombi$BCCycleGeneralData = DSICarKombiTracer.class$("org.dsi.ifc.carkombi.BCCycleGeneralData")) : class$org$dsi$ifc$carkombi$BCCycleGeneralData, 5);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carkombi$BCFISAdditionalConfiguration == null ? (class$org$dsi$ifc$carkombi$BCFISAdditionalConfiguration = DSICarKombiTracer.class$("org.dsi.ifc.carkombi.BCFISAdditionalConfiguration")) : class$org$dsi$ifc$carkombi$BCFISAdditionalConfiguration, 6);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carkombi$BCFunctionSupport == null ? (class$org$dsi$ifc$carkombi$BCFunctionSupport = DSICarKombiTracer.class$("org.dsi.ifc.carkombi.BCFunctionSupport")) : class$org$dsi$ifc$carkombi$BCFunctionSupport, 7);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carkombi$BCIndications == null ? (class$org$dsi$ifc$carkombi$BCIndications = DSICarKombiTracer.class$("org.dsi.ifc.carkombi.BCIndications")) : class$org$dsi$ifc$carkombi$BCIndications, 8);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carkombi$BCLongTermGeneralData == null ? (class$org$dsi$ifc$carkombi$BCLongTermGeneralData = DSICarKombiTracer.class$("org.dsi.ifc.carkombi.BCLongTermGeneralData")) : class$org$dsi$ifc$carkombi$BCLongTermGeneralData, 9);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carkombi$BCMaxValues == null ? (class$org$dsi$ifc$carkombi$BCMaxValues = DSICarKombiTracer.class$("org.dsi.ifc.carkombi.BCMaxValues")) : class$org$dsi$ifc$carkombi$BCMaxValues, 10);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carkombi$BCMenueConfiguration == null ? (class$org$dsi$ifc$carkombi$BCMenueConfiguration = DSICarKombiTracer.class$("org.dsi.ifc.carkombi.BCMenueConfiguration")) : class$org$dsi$ifc$carkombi$BCMenueConfiguration, 11);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carkombi$BCRefuelVolume == null ? (class$org$dsi$ifc$carkombi$BCRefuelVolume = DSICarKombiTracer.class$("org.dsi.ifc.carkombi.BCRefuelVolume")) : class$org$dsi$ifc$carkombi$BCRefuelVolume, 12);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carkombi$BCResetTimeStamp == null ? (class$org$dsi$ifc$carkombi$BCResetTimeStamp = DSICarKombiTracer.class$("org.dsi.ifc.carkombi.BCResetTimeStamp")) : class$org$dsi$ifc$carkombi$BCResetTimeStamp, 13);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carkombi$BCShortTermGeneralData == null ? (class$org$dsi$ifc$carkombi$BCShortTermGeneralData = DSICarKombiTracer.class$("org.dsi.ifc.carkombi.BCShortTermGeneralData")) : class$org$dsi$ifc$carkombi$BCShortTermGeneralData, 14);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carkombi$BCSpeedWarningSettings == null ? (class$org$dsi$ifc$carkombi$BCSpeedWarningSettings = DSICarKombiTracer.class$("org.dsi.ifc.carkombi.BCSpeedWarningSettings")) : class$org$dsi$ifc$carkombi$BCSpeedWarningSettings, 15);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carkombi$BCStatisticsAC == null ? (class$org$dsi$ifc$carkombi$BCStatisticsAC = DSICarKombiTracer.class$("org.dsi.ifc.carkombi.BCStatisticsAC")) : class$org$dsi$ifc$carkombi$BCStatisticsAC, 16);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carkombi$BCStatisticsConfig == null ? (class$org$dsi$ifc$carkombi$BCStatisticsConfig = DSICarKombiTracer.class$("org.dsi.ifc.carkombi.BCStatisticsConfig")) : class$org$dsi$ifc$carkombi$BCStatisticsConfig, 17);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carkombi$BCStatisticsDistanceEU == null ? (class$org$dsi$ifc$carkombi$BCStatisticsDistanceEU = DSICarKombiTracer.class$("org.dsi.ifc.carkombi.BCStatisticsDistanceEU")) : class$org$dsi$ifc$carkombi$BCStatisticsDistanceEU, 18);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carkombi$BCStatisticsRE == null ? (class$org$dsi$ifc$carkombi$BCStatisticsRE = DSICarKombiTracer.class$("org.dsi.ifc.carkombi.BCStatisticsRE")) : class$org$dsi$ifc$carkombi$BCStatisticsRE, 19);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carkombi$BCStatisticsReset == null ? (class$org$dsi$ifc$carkombi$BCStatisticsReset = DSICarKombiTracer.class$("org.dsi.ifc.carkombi.BCStatisticsReset")) : class$org$dsi$ifc$carkombi$BCStatisticsReset, 20);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carkombi$BCStatisticsZE == null ? (class$org$dsi$ifc$carkombi$BCStatisticsZE = DSICarKombiTracer.class$("org.dsi.ifc.carkombi.BCStatisticsZE")) : class$org$dsi$ifc$carkombi$BCStatisticsZE, 21);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carkombi$BCTankLevel == null ? (class$org$dsi$ifc$carkombi$BCTankLevel = DSICarKombiTracer.class$("org.dsi.ifc.carkombi.BCTankLevel")) : class$org$dsi$ifc$carkombi$BCTankLevel, 22);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carkombi$BCTotalDistance == null ? (class$org$dsi$ifc$carkombi$BCTotalDistance = DSICarKombiTracer.class$("org.dsi.ifc.carkombi.BCTotalDistance")) : class$org$dsi$ifc$carkombi$BCTotalDistance, 23);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carkombi$BCTransmittableElements == null ? (class$org$dsi$ifc$carkombi$BCTransmittableElements = DSICarKombiTracer.class$("org.dsi.ifc.carkombi.BCTransmittableElements")) : class$org$dsi$ifc$carkombi$BCTransmittableElements, 24);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carkombi$BCVehicleStateUpdateInfoAH == null ? (class$org$dsi$ifc$carkombi$BCVehicleStateUpdateInfoAH = DSICarKombiTracer.class$("org.dsi.ifc.carkombi.BCVehicleStateUpdateInfoAH")) : class$org$dsi$ifc$carkombi$BCVehicleStateUpdateInfoAH, 25);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carkombi$BCViewOptions == null ? (class$org$dsi$ifc$carkombi$BCViewOptions = DSICarKombiTracer.class$("org.dsi.ifc.carkombi.BCViewOptions")) : class$org$dsi$ifc$carkombi$BCViewOptions, 26);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carkombi$BCZeroEmissionAbsoluteDistance == null ? (class$org$dsi$ifc$carkombi$BCZeroEmissionAbsoluteDistance = DSICarKombiTracer.class$("org.dsi.ifc.carkombi.BCZeroEmissionAbsoluteDistance")) : class$org$dsi$ifc$carkombi$BCZeroEmissionAbsoluteDistance, 27);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carkombi$BCZeroEmissionAbsoluteTime == null ? (class$org$dsi$ifc$carkombi$BCZeroEmissionAbsoluteTime = DSICarKombiTracer.class$("org.dsi.ifc.carkombi.BCZeroEmissionAbsoluteTime")) : class$org$dsi$ifc$carkombi$BCZeroEmissionAbsoluteTime, 28);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carkombi$BCZeroEmissionRelative == null ? (class$org$dsi$ifc$carkombi$BCZeroEmissionRelative = DSICarKombiTracer.class$("org.dsi.ifc.carkombi.BCZeroEmissionRelative")) : class$org$dsi$ifc$carkombi$BCZeroEmissionRelative, 29);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carkombi$DCAdditionalInfo == null ? (class$org$dsi$ifc$carkombi$DCAdditionalInfo = DSICarKombiTracer.class$("org.dsi.ifc.carkombi.DCAdditionalInfo")) : class$org$dsi$ifc$carkombi$DCAdditionalInfo, 30);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carkombi$DCAdditionalInstrument == null ? (class$org$dsi$ifc$carkombi$DCAdditionalInstrument = DSICarKombiTracer.class$("org.dsi.ifc.carkombi.DCAdditionalInstrument")) : class$org$dsi$ifc$carkombi$DCAdditionalInstrument, 31);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carkombi$DCAdditionalInstrument2 == null ? (class$org$dsi$ifc$carkombi$DCAdditionalInstrument2 = DSICarKombiTracer.class$("org.dsi.ifc.carkombi.DCAdditionalInstrument2")) : class$org$dsi$ifc$carkombi$DCAdditionalInstrument2, 32);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carkombi$DCConfiguration == null ? (class$org$dsi$ifc$carkombi$DCConfiguration = DSICarKombiTracer.class$("org.dsi.ifc.carkombi.DCConfiguration")) : class$org$dsi$ifc$carkombi$DCConfiguration, 33);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carkombi$DCDisplayDependency == null ? (class$org$dsi$ifc$carkombi$DCDisplayDependency = DSICarKombiTracer.class$("org.dsi.ifc.carkombi.DCDisplayDependency")) : class$org$dsi$ifc$carkombi$DCDisplayDependency, 34);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carkombi$DCDisplayPresetsListRecord == null ? (class$org$dsi$ifc$carkombi$DCDisplayPresetsListRecord = DSICarKombiTracer.class$("org.dsi.ifc.carkombi.DCDisplayPresetsListRecord")) : class$org$dsi$ifc$carkombi$DCDisplayPresetsListRecord, 35);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carkombi$DCDisplayPresetsListRecordDisplayData == null ? (class$org$dsi$ifc$carkombi$DCDisplayPresetsListRecordDisplayData = DSICarKombiTracer.class$("org.dsi.ifc.carkombi.DCDisplayPresetsListRecordDisplayData")) : class$org$dsi$ifc$carkombi$DCDisplayPresetsListRecordDisplayData, 36);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carkombi$DCDisplayViewConfiguration == null ? (class$org$dsi$ifc$carkombi$DCDisplayViewConfiguration = DSICarKombiTracer.class$("org.dsi.ifc.carkombi.DCDisplayViewConfiguration")) : class$org$dsi$ifc$carkombi$DCDisplayViewConfiguration, 37);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carkombi$DCDisplayedAdditionalInfos == null ? (class$org$dsi$ifc$carkombi$DCDisplayedAdditionalInfos = DSICarKombiTracer.class$("org.dsi.ifc.carkombi.DCDisplayedAdditionalInfos")) : class$org$dsi$ifc$carkombi$DCDisplayedAdditionalInfos, 38);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carkombi$DCElementContentSelectionListRA1 == null ? (class$org$dsi$ifc$carkombi$DCElementContentSelectionListRA1 = DSICarKombiTracer.class$("org.dsi.ifc.carkombi.DCElementContentSelectionListRA1")) : class$org$dsi$ifc$carkombi$DCElementContentSelectionListRA1, 39);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carkombi$DCElementContentSelectionListRA2 == null ? (class$org$dsi$ifc$carkombi$DCElementContentSelectionListRA2 = DSICarKombiTracer.class$("org.dsi.ifc.carkombi.DCElementContentSelectionListRA2")) : class$org$dsi$ifc$carkombi$DCElementContentSelectionListRA2, 40);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carkombi$DCElementContentSelectionListUpdateInfo == null ? (class$org$dsi$ifc$carkombi$DCElementContentSelectionListUpdateInfo = DSICarKombiTracer.class$("org.dsi.ifc.carkombi.DCElementContentSelectionListUpdateInfo")) : class$org$dsi$ifc$carkombi$DCElementContentSelectionListUpdateInfo, 41);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carkombi$DCMainItems == null ? (class$org$dsi$ifc$carkombi$DCMainItems = DSICarKombiTracer.class$("org.dsi.ifc.carkombi.DCMainItems")) : class$org$dsi$ifc$carkombi$DCMainItems, 42);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carkombi$DCTransmittableElements == null ? (class$org$dsi$ifc$carkombi$DCTransmittableElements = DSICarKombiTracer.class$("org.dsi.ifc.carkombi.DCTransmittableElements")) : class$org$dsi$ifc$carkombi$DCTransmittableElements, 43);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carkombi$DCViewOptions == null ? (class$org$dsi$ifc$carkombi$DCViewOptions = DSICarKombiTracer.class$("org.dsi.ifc.carkombi.DCViewOptions")) : class$org$dsi$ifc$carkombi$DCViewOptions, 44);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carkombi$HUDConfiguration == null ? (class$org$dsi$ifc$carkombi$HUDConfiguration = DSICarKombiTracer.class$("org.dsi.ifc.carkombi.HUDConfiguration")) : class$org$dsi$ifc$carkombi$HUDConfiguration, 45);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carkombi$HUDContent == null ? (class$org$dsi$ifc$carkombi$HUDContent = DSICarKombiTracer.class$("org.dsi.ifc.carkombi.HUDContent")) : class$org$dsi$ifc$carkombi$HUDContent, 46);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carkombi$HUDViewOptions == null ? (class$org$dsi$ifc$carkombi$HUDViewOptions = DSICarKombiTracer.class$("org.dsi.ifc.carkombi.HUDViewOptions")) : class$org$dsi$ifc$carkombi$HUDViewOptions, 47);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carkombi$ListDynValues == null ? (class$org$dsi$ifc$carkombi$ListDynValues = DSICarKombiTracer.class$("org.dsi.ifc.carkombi.ListDynValues")) : class$org$dsi$ifc$carkombi$ListDynValues, 48);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carkombi$ListWarningIDsDynValues == null ? (class$org$dsi$ifc$carkombi$ListWarningIDsDynValues = DSICarKombiTracer.class$("org.dsi.ifc.carkombi.ListWarningIDsDynValues")) : class$org$dsi$ifc$carkombi$ListWarningIDsDynValues, 49);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carkombi$SIAConfiguration == null ? (class$org$dsi$ifc$carkombi$SIAConfiguration = DSICarKombiTracer.class$("org.dsi.ifc.carkombi.SIAConfiguration")) : class$org$dsi$ifc$carkombi$SIAConfiguration, 50);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carkombi$SIADistanceData == null ? (class$org$dsi$ifc$carkombi$SIADistanceData = DSICarKombiTracer.class$("org.dsi.ifc.carkombi.SIADistanceData")) : class$org$dsi$ifc$carkombi$SIADistanceData, 51);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carkombi$SIAHistoryListRecord == null ? (class$org$dsi$ifc$carkombi$SIAHistoryListRecord = DSICarKombiTracer.class$("org.dsi.ifc.carkombi.SIAHistoryListRecord")) : class$org$dsi$ifc$carkombi$SIAHistoryListRecord, 52);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carkombi$SIAOilInspection == null ? (class$org$dsi$ifc$carkombi$SIAOilInspection = DSICarKombiTracer.class$("org.dsi.ifc.carkombi.SIAOilInspection")) : class$org$dsi$ifc$carkombi$SIAOilInspection, 53);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carkombi$SIAResetValues == null ? (class$org$dsi$ifc$carkombi$SIAResetValues = DSICarKombiTracer.class$("org.dsi.ifc.carkombi.SIAResetValues")) : class$org$dsi$ifc$carkombi$SIAResetValues, 54);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carkombi$SIAServiceAttributes == null ? (class$org$dsi$ifc$carkombi$SIAServiceAttributes = DSICarKombiTracer.class$("org.dsi.ifc.carkombi.SIAServiceAttributes")) : class$org$dsi$ifc$carkombi$SIAServiceAttributes, 55);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carkombi$SIAServiceData == null ? (class$org$dsi$ifc$carkombi$SIAServiceData = DSICarKombiTracer.class$("org.dsi.ifc.carkombi.SIAServiceData")) : class$org$dsi$ifc$carkombi$SIAServiceData, 56);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carkombi$SIAServiceTypes == null ? (class$org$dsi$ifc$carkombi$SIAServiceTypes = DSICarKombiTracer.class$("org.dsi.ifc.carkombi.SIAServiceTypes")) : class$org$dsi$ifc$carkombi$SIAServiceTypes, 57);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carkombi$SIAViewOptions == null ? (class$org$dsi$ifc$carkombi$SIAViewOptions = DSICarKombiTracer.class$("org.dsi.ifc.carkombi.SIAViewOptions")) : class$org$dsi$ifc$carkombi$SIAViewOptions, 58);
    }

    @Override
    public void traceDSIObject(PrintWriter printWriter, Object object) {
        if (printWriter == null) {
            return;
        }
        switch (this.resolveID(object)) {
            case 1: {
                this.traceBCAverageRecoveredEnergy(printWriter, (BCAverageRecoveredEnergy)object);
                break;
            }
            case 2: {
                this.traceBCComfortPowerConsumption(printWriter, (BCComfortPowerConsumption)object);
                break;
            }
            case 3: {
                this.traceBCConfiguration(printWriter, (BCConfiguration)object);
                break;
            }
            case 4: {
                this.traceBCCounter(printWriter, (BCCounter)object);
                break;
            }
            case 5: {
                this.traceBCCycleGeneralData(printWriter, (BCCycleGeneralData)object);
                break;
            }
            case 6: {
                this.traceBCFISAdditionalConfiguration(printWriter, (BCFISAdditionalConfiguration)object);
                break;
            }
            case 7: {
                this.traceBCFunctionSupport(printWriter, (BCFunctionSupport)object);
                break;
            }
            case 8: {
                this.traceBCIndications(printWriter, (BCIndications)object);
                break;
            }
            case 9: {
                this.traceBCLongTermGeneralData(printWriter, (BCLongTermGeneralData)object);
                break;
            }
            case 10: {
                this.traceBCMaxValues(printWriter, (BCMaxValues)object);
                break;
            }
            case 11: {
                this.traceBCMenueConfiguration(printWriter, (BCMenueConfiguration)object);
                break;
            }
            case 12: {
                this.traceBCRefuelVolume(printWriter, (BCRefuelVolume)object);
                break;
            }
            case 13: {
                this.traceBCResetTimeStamp(printWriter, (BCResetTimeStamp)object);
                break;
            }
            case 14: {
                this.traceBCShortTermGeneralData(printWriter, (BCShortTermGeneralData)object);
                break;
            }
            case 15: {
                this.traceBCSpeedWarningSettings(printWriter, (BCSpeedWarningSettings)object);
                break;
            }
            case 16: {
                this.traceBCStatisticsAC(printWriter, (BCStatisticsAC)object);
                break;
            }
            case 17: {
                this.traceBCStatisticsConfig(printWriter, (BCStatisticsConfig)object);
                break;
            }
            case 18: {
                this.traceBCStatisticsDistanceEU(printWriter, (BCStatisticsDistanceEU)object);
                break;
            }
            case 19: {
                this.traceBCStatisticsRE(printWriter, (BCStatisticsRE)object);
                break;
            }
            case 20: {
                this.traceBCStatisticsReset(printWriter, (BCStatisticsReset)object);
                break;
            }
            case 21: {
                this.traceBCStatisticsZE(printWriter, (BCStatisticsZE)object);
                break;
            }
            case 22: {
                this.traceBCTankLevel(printWriter, (BCTankLevel)object);
                break;
            }
            case 23: {
                this.traceBCTotalDistance(printWriter, (BCTotalDistance)object);
                break;
            }
            case 24: {
                this.traceBCTransmittableElements(printWriter, (BCTransmittableElements)object);
                break;
            }
            case 25: {
                this.traceBCVehicleStateUpdateInfoAH(printWriter, (BCVehicleStateUpdateInfoAH)object);
                break;
            }
            case 26: {
                this.traceBCViewOptions(printWriter, (BCViewOptions)object);
                break;
            }
            case 27: {
                this.traceBCZeroEmissionAbsoluteDistance(printWriter, (BCZeroEmissionAbsoluteDistance)object);
                break;
            }
            case 28: {
                this.traceBCZeroEmissionAbsoluteTime(printWriter, (BCZeroEmissionAbsoluteTime)object);
                break;
            }
            case 29: {
                this.traceBCZeroEmissionRelative(printWriter, (BCZeroEmissionRelative)object);
                break;
            }
            case 30: {
                this.traceDCAdditionalInfo(printWriter, (DCAdditionalInfo)object);
                break;
            }
            case 31: {
                this.traceDCAdditionalInstrument(printWriter, (DCAdditionalInstrument)object);
                break;
            }
            case 32: {
                this.traceDCAdditionalInstrument2(printWriter, (DCAdditionalInstrument2)object);
                break;
            }
            case 33: {
                this.traceDCConfiguration(printWriter, (DCConfiguration)object);
                break;
            }
            case 34: {
                this.traceDCDisplayDependency(printWriter, (DCDisplayDependency)object);
                break;
            }
            case 35: {
                this.traceDCDisplayPresetsListRecord(printWriter, (DCDisplayPresetsListRecord)object);
                break;
            }
            case 36: {
                this.traceDCDisplayPresetsListRecordDisplayData(printWriter, (DCDisplayPresetsListRecordDisplayData)object);
                break;
            }
            case 37: {
                this.traceDCDisplayViewConfiguration(printWriter, (DCDisplayViewConfiguration)object);
                break;
            }
            case 38: {
                this.traceDCDisplayedAdditionalInfos(printWriter, (DCDisplayedAdditionalInfos)object);
                break;
            }
            case 39: {
                this.traceDCElementContentSelectionListRA1(printWriter, (DCElementContentSelectionListRA1)object);
                break;
            }
            case 40: {
                this.traceDCElementContentSelectionListRA2(printWriter, (DCElementContentSelectionListRA2)object);
                break;
            }
            case 41: {
                this.traceDCElementContentSelectionListUpdateInfo(printWriter, (DCElementContentSelectionListUpdateInfo)object);
                break;
            }
            case 42: {
                this.traceDCMainItems(printWriter, (DCMainItems)object);
                break;
            }
            case 43: {
                this.traceDCTransmittableElements(printWriter, (DCTransmittableElements)object);
                break;
            }
            case 44: {
                this.traceDCViewOptions(printWriter, (DCViewOptions)object);
                break;
            }
            case 45: {
                this.traceHUDConfiguration(printWriter, (HUDConfiguration)object);
                break;
            }
            case 46: {
                this.traceHUDContent(printWriter, (HUDContent)object);
                break;
            }
            case 47: {
                this.traceHUDViewOptions(printWriter, (HUDViewOptions)object);
                break;
            }
            case 48: {
                this.traceListDynValues(printWriter, (ListDynValues)object);
                break;
            }
            case 49: {
                this.traceListWarningIDsDynValues(printWriter, (ListWarningIDsDynValues)object);
                break;
            }
            case 50: {
                this.traceSIAConfiguration(printWriter, (SIAConfiguration)object);
                break;
            }
            case 51: {
                this.traceSIADistanceData(printWriter, (SIADistanceData)object);
                break;
            }
            case 52: {
                this.traceSIAHistoryListRecord(printWriter, (SIAHistoryListRecord)object);
                break;
            }
            case 53: {
                this.traceSIAOilInspection(printWriter, (SIAOilInspection)object);
                break;
            }
            case 54: {
                this.traceSIAResetValues(printWriter, (SIAResetValues)object);
                break;
            }
            case 55: {
                this.traceSIAServiceAttributes(printWriter, (SIAServiceAttributes)object);
                break;
            }
            case 56: {
                this.traceSIAServiceData(printWriter, (SIAServiceData)object);
                break;
            }
            case 57: {
                this.traceSIAServiceTypes(printWriter, (SIAServiceTypes)object);
                break;
            }
            case 58: {
                this.traceSIAViewOptions(printWriter, (SIAViewOptions)object);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Not a valid DSI object for tracing: ").append(object.getClass()).toString());
            }
        }
    }

    private void traceBCAverageRecoveredEnergy(PrintWriter printWriter, BCAverageRecoveredEnergy bCAverageRecoveredEnergy) {
        if (bCAverageRecoveredEnergy == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(bCAverageRecoveredEnergy.state);
        printWriter.print(bCAverageRecoveredEnergy.value);
    }

    private void traceBCComfortPowerConsumption(PrintWriter printWriter, BCComfortPowerConsumption bCComfortPowerConsumption) {
        if (bCComfortPowerConsumption == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        this.trace(printWriter, bCComfortPowerConsumption.comfortConsumptionST);
        this.trace(printWriter, bCComfortPowerConsumption.comfortConsumptionLT);
        this.trace(printWriter, bCComfortPowerConsumption.comfortConsumptionCY);
    }

    private void traceBCConfiguration(PrintWriter printWriter, BCConfiguration bCConfiguration) {
        if (bCConfiguration == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(bCConfiguration.primaryEngineType);
        printWriter.print(bCConfiguration.secondaryEngineType);
        this.trace(printWriter, bCConfiguration.fisAdditionalConfiguration);
        this.trace(printWriter, bCConfiguration.transmittableElementsVehicleState);
        this.trace(printWriter, bCConfiguration.functionSupport);
    }

    private void traceBCCounter(PrintWriter printWriter, BCCounter bCCounter) {
        if (bCCounter == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(bCCounter.state);
        printWriter.print(bCCounter.value);
    }

    private void traceBCCycleGeneralData(PrintWriter printWriter, BCCycleGeneralData bCCycleGeneralData) {
        if (bCCycleGeneralData == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        this.trace(printWriter, bCCycleGeneralData.distance);
        this.trace(printWriter, bCCycleGeneralData.speed);
        this.trace(printWriter, bCCycleGeneralData.timeValue);
    }

    private void traceBCFISAdditionalConfiguration(PrintWriter printWriter, BCFISAdditionalConfiguration bCFISAdditionalConfiguration) {
        if (bCFISAdditionalConfiguration == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(bCFISAdditionalConfiguration.fis1);
        printWriter.print(bCFISAdditionalConfiguration.fis2);
        printWriter.print(bCFISAdditionalConfiguration.fis3);
        printWriter.print(bCFISAdditionalConfiguration.stopWatch);
        printWriter.print(bCFISAdditionalConfiguration.oilTemp);
        printWriter.print(bCFISAdditionalConfiguration.digitalSpeed);
        printWriter.print(bCFISAdditionalConfiguration.refuelVolume);
        printWriter.print(bCFISAdditionalConfiguration.speedWarning);
        printWriter.print(bCFISAdditionalConfiguration.coolantTemp);
        printWriter.print(bCFISAdditionalConfiguration.secondarySpeed);
        printWriter.print(bCFISAdditionalConfiguration.vza);
        printWriter.print(bCFISAdditionalConfiguration.resetTime);
        printWriter.print(bCFISAdditionalConfiguration.comfortPowerConsumption);
        printWriter.print(bCFISAdditionalConfiguration.zeroEmissionTime);
        printWriter.print(bCFISAdditionalConfiguration.zeroEmissionDistance);
        printWriter.print(bCFISAdditionalConfiguration.vzaMfa);
        printWriter.print(bCFISAdditionalConfiguration.bcmeConsumerList);
        printWriter.print(bCFISAdditionalConfiguration.bcmeLiveTips);
        printWriter.print(bCFISAdditionalConfiguration.astaMfa);
    }

    private void traceBCFunctionSupport(PrintWriter printWriter, BCFunctionSupport bCFunctionSupport) {
        if (bCFunctionSupport == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(bCFunctionSupport.resetTrip);
    }

    private void traceBCIndications(PrintWriter printWriter, BCIndications bCIndications) {
        if (bCIndications == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(bCIndications.washingWater);
        printWriter.print(bCIndications.oilLevel);
        printWriter.print(bCIndications.tyrePressure);
        printWriter.print(bCIndications.tankLevel);
    }

    private void traceBCLongTermGeneralData(PrintWriter printWriter, BCLongTermGeneralData bCLongTermGeneralData) {
        if (bCLongTermGeneralData == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        this.trace(printWriter, bCLongTermGeneralData.distance);
        this.trace(printWriter, bCLongTermGeneralData.speed);
        this.trace(printWriter, bCLongTermGeneralData.timeValue);
    }

    private void traceBCMaxValues(PrintWriter printWriter, BCMaxValues bCMaxValues) {
        if (bCMaxValues == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        this.trace(printWriter, bCMaxValues.maxLeftLateralAcceleration);
        this.trace(printWriter, bCMaxValues.maxRightLateralAcceleration);
        this.trace(printWriter, bCMaxValues.maxPosLongitudinalAcceleration);
        this.trace(printWriter, bCMaxValues.maxNegLongitudinalAcceleration);
        this.trace(printWriter, bCMaxValues.maxSpeed);
    }

    private void traceBCMenueConfiguration(PrintWriter printWriter, BCMenueConfiguration bCMenueConfiguration) {
        if (bCMenueConfiguration == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(bCMenueConfiguration.cruisingRange);
        printWriter.print(bCMenueConfiguration.averageConsumption);
        printWriter.print(bCMenueConfiguration.currentConsumption);
        printWriter.print(bCMenueConfiguration.averageSpeed);
        printWriter.print(bCMenueConfiguration.drivingTime);
        printWriter.print(bCMenueConfiguration.drivenDistance);
        printWriter.print(bCMenueConfiguration.menueDisplay);
        printWriter.print(bCMenueConfiguration.refuelVolume);
        printWriter.print(bCMenueConfiguration.speedWarningFIS);
        printWriter.print(bCMenueConfiguration.coolantTemp);
        printWriter.print(bCMenueConfiguration.secondarySpeed);
        printWriter.print(bCMenueConfiguration.resetTime);
        printWriter.print(bCMenueConfiguration.comfortPowerConsumption);
        printWriter.print(bCMenueConfiguration.zeroEmissionTime);
        printWriter.print(bCMenueConfiguration.zeroEmissionDistance);
    }

    private void traceBCRefuelVolume(PrintWriter printWriter, BCRefuelVolume bCRefuelVolume) {
        if (bCRefuelVolume == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(bCRefuelVolume.state);
        printWriter.print(bCRefuelVolume.refuelVolumeValue);
        printWriter.print(bCRefuelVolume.refuelVolumeUnit);
    }

    private void traceBCResetTimeStamp(PrintWriter printWriter, BCResetTimeStamp bCResetTimeStamp) {
        if (bCResetTimeStamp == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(bCResetTimeStamp.year);
        printWriter.print(bCResetTimeStamp.month);
        printWriter.print(bCResetTimeStamp.day);
        printWriter.print(bCResetTimeStamp.hours);
        printWriter.print(bCResetTimeStamp.minutes);
    }

    private void traceBCShortTermGeneralData(PrintWriter printWriter, BCShortTermGeneralData bCShortTermGeneralData) {
        if (bCShortTermGeneralData == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        this.trace(printWriter, bCShortTermGeneralData.distance);
        this.trace(printWriter, bCShortTermGeneralData.speed);
        this.trace(printWriter, bCShortTermGeneralData.timeValue);
    }

    private void traceBCSpeedWarningSettings(PrintWriter printWriter, BCSpeedWarningSettings bCSpeedWarningSettings) {
        if (bCSpeedWarningSettings == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(bCSpeedWarningSettings.state);
        printWriter.print(bCSpeedWarningSettings.speedValue);
        printWriter.print(bCSpeedWarningSettings.speedUnit);
    }

    private void traceBCStatisticsAC(PrintWriter printWriter, BCStatisticsAC bCStatisticsAC) {
        if (bCStatisticsAC == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        this.trace(printWriter, bCStatisticsAC.tripCounter);
        this.trace(printWriter, bCStatisticsAC.valueCounter);
        this.trace(printWriter, bCStatisticsAC.averageConsumption);
    }

    private void traceBCStatisticsConfig(PrintWriter printWriter, BCStatisticsConfig bCStatisticsConfig) {
        if (bCStatisticsConfig == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(bCStatisticsConfig.statisticsTimeState);
        printWriter.print(bCStatisticsConfig.statisticsDistanceState);
        printWriter.print(bCStatisticsConfig.statisticsPeriodState);
        printWriter.print(bCStatisticsConfig.statisticsIntervalState);
        printWriter.print(bCStatisticsConfig.statisticsPeriodValue);
        printWriter.print(bCStatisticsConfig.statisticsIntervalValue);
    }

    private void traceBCStatisticsDistanceEU(PrintWriter printWriter, BCStatisticsDistanceEU bCStatisticsDistanceEU) {
        if (bCStatisticsDistanceEU == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        this.trace(printWriter, bCStatisticsDistanceEU.valueCounter);
        this.trace(printWriter, bCStatisticsDistanceEU.distancePrimary);
        this.trace(printWriter, bCStatisticsDistanceEU.distanceSecondary);
        this.trace(printWriter, bCStatisticsDistanceEU.distanceEfficiency);
    }

    private void traceBCStatisticsRE(PrintWriter printWriter, BCStatisticsRE bCStatisticsRE) {
        if (bCStatisticsRE == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        this.trace(printWriter, bCStatisticsRE.tripCounter);
        this.trace(printWriter, bCStatisticsRE.valueCounter);
        this.trace(printWriter, bCStatisticsRE.averageRecoveredEnergy);
    }

    private void traceBCStatisticsReset(PrintWriter printWriter, BCStatisticsReset bCStatisticsReset) {
        if (bCStatisticsReset == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(bCStatisticsReset.time);
        printWriter.print(bCStatisticsReset.distance);
    }

    private void traceBCStatisticsZE(PrintWriter printWriter, BCStatisticsZE bCStatisticsZE) {
        if (bCStatisticsZE == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        this.trace(printWriter, bCStatisticsZE.tripCounter);
        this.trace(printWriter, bCStatisticsZE.valueCounter);
        this.trace(printWriter, bCStatisticsZE.zeroEmissionRelative);
    }

    private void traceBCTankLevel(PrintWriter printWriter, BCTankLevel bCTankLevel) {
        if (bCTankLevel == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(bCTankLevel.state);
        printWriter.print(bCTankLevel.tankLevelValue);
    }

    private void traceBCTotalDistance(PrintWriter printWriter, BCTotalDistance bCTotalDistance) {
        if (bCTotalDistance == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(bCTotalDistance.distanceValue);
        printWriter.print(bCTotalDistance.distanceUnit);
    }

    private void traceBCTransmittableElements(PrintWriter printWriter, BCTransmittableElements bCTransmittableElements) {
        if (bCTransmittableElements == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(bCTransmittableElements.ra0);
        printWriter.print(bCTransmittableElements.ra1);
        printWriter.print(bCTransmittableElements.ra2);
        printWriter.print(bCTransmittableElements.ra3);
        printWriter.print(bCTransmittableElements.raF);
    }

    private void traceBCVehicleStateUpdateInfoAH(PrintWriter printWriter, BCVehicleStateUpdateInfoAH bCVehicleStateUpdateInfoAH) {
        if (bCVehicleStateUpdateInfoAH == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(bCVehicleStateUpdateInfoAH.arrayContent);
        printWriter.print(bCVehicleStateUpdateInfoAH.recordContent);
        printWriter.print(bCVehicleStateUpdateInfoAH.startElement);
        printWriter.print(bCVehicleStateUpdateInfoAH.numOfElements);
        printWriter.print(bCVehicleStateUpdateInfoAH.transactionID);
        printWriter.print(bCVehicleStateUpdateInfoAH.asgID);
    }

    private void traceBCViewOptions(PrintWriter printWriter, BCViewOptions bCViewOptions) {
        if (bCViewOptions == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        this.trace(printWriter, bCViewOptions.currentConsumption1);
        this.trace(printWriter, bCViewOptions.currentConsumption2);
        this.trace(printWriter, bCViewOptions.currentRange1);
        this.trace(printWriter, bCViewOptions.currentRange2);
        this.trace(printWriter, bCViewOptions.totalDistance);
        this.trace(printWriter, bCViewOptions.shortTermAverageConsumption1);
        this.trace(printWriter, bCViewOptions.shortTermAverageConsumption2);
        this.trace(printWriter, bCViewOptions.shortTermGeneral);
        this.trace(printWriter, bCViewOptions.longTermAverageConsumption1);
        this.trace(printWriter, bCViewOptions.longTermAverageConsumption2);
        this.trace(printWriter, bCViewOptions.longTermGeneral);
        this.trace(printWriter, bCViewOptions.cycleAverageConsumption1);
        this.trace(printWriter, bCViewOptions.cycleAverageConsumption2);
        this.trace(printWriter, bCViewOptions.cycleGeneral);
        this.trace(printWriter, bCViewOptions.vZADisplay);
        this.trace(printWriter, bCViewOptions.lifeTipsDisplay);
        this.trace(printWriter, bCViewOptions.consumerDisplay);
        this.trace(printWriter, bCViewOptions.tankLevel1);
        this.trace(printWriter, bCViewOptions.tankLevel2);
        this.trace(printWriter, bCViewOptions.refuelVolume1);
        this.trace(printWriter, bCViewOptions.refuelVolume2);
        this.trace(printWriter, bCViewOptions.menue1Config);
        this.trace(printWriter, bCViewOptions.menue2Config);
        this.trace(printWriter, bCViewOptions.menue3Config);
        this.trace(printWriter, bCViewOptions.resetMenue1);
        this.trace(printWriter, bCViewOptions.resetMenue2);
        this.trace(printWriter, bCViewOptions.resetMenue3);
        this.trace(printWriter, bCViewOptions.oilTemperature);
        this.trace(printWriter, bCViewOptions.digitalSpeed);
        this.trace(printWriter, bCViewOptions.stopwatch);
        this.trace(printWriter, bCViewOptions.vzaMFA);
        this.trace(printWriter, bCViewOptions.speedWarning);
        this.trace(printWriter, bCViewOptions.gearRecommendation);
        this.trace(printWriter, bCViewOptions.rearSeatbeltWarning);
        this.trace(printWriter, bCViewOptions.indications);
        this.trace(printWriter, bCViewOptions.outsideTemperature);
        this.trace(printWriter, bCViewOptions.bcSetFactoryDefault);
        this.trace(printWriter, bCViewOptions.vehicleStateList);
        this.trace(printWriter, bCViewOptions.statisticsTimeAC1);
        this.trace(printWriter, bCViewOptions.statisticsTimeAC2);
        this.trace(printWriter, bCViewOptions.statisticsTimeRE);
        this.trace(printWriter, bCViewOptions.statisticsTimeZE);
        this.trace(printWriter, bCViewOptions.statisticsTimeCurrentPeriodAC1);
        this.trace(printWriter, bCViewOptions.statisticsTimeCurrentPeriodAC2);
        this.trace(printWriter, bCViewOptions.statisticsTimeCurrentPeriodRE);
        this.trace(printWriter, bCViewOptions.statisticsTimeCurrentPeriodZE);
        this.trace(printWriter, bCViewOptions.statisticsDistanceAC1);
        this.trace(printWriter, bCViewOptions.statisticsDistanceAC2);
        this.trace(printWriter, bCViewOptions.statisticsDistanceRE);
        this.trace(printWriter, bCViewOptions.statisticsDistanceZE);
        this.trace(printWriter, bCViewOptions.statisticsDistanceCurrentIntervallAC1);
        this.trace(printWriter, bCViewOptions.statisticsDistanceCurrentIntervallAC2);
        this.trace(printWriter, bCViewOptions.statisticsDistanceCurrentIntervallRE);
        this.trace(printWriter, bCViewOptions.statisticsDistanceCurrentIntervallZE);
        this.trace(printWriter, bCViewOptions.statisticsReset);
        this.trace(printWriter, bCViewOptions.statisticsConfig);
        this.trace(printWriter, bCViewOptions.oilTemperatureValue);
        this.trace(printWriter, bCViewOptions.coolantTemperature);
        this.trace(printWriter, bCViewOptions.comfortPowerConsumptionST);
        this.trace(printWriter, bCViewOptions.statisticDistanceEUkm);
        this.trace(printWriter, bCViewOptions.statisticDistanceEUmls);
        this.trace(printWriter, bCViewOptions.totalCurrentRange);
        this.trace(printWriter, bCViewOptions.resetMaxValues);
        this.trace(printWriter, bCViewOptions.zeroEmissionDistanceST);
        this.trace(printWriter, bCViewOptions.zeroEmissionTimeST);
        this.trace(printWriter, bCViewOptions.zeroEmissionDistanceLT);
        this.trace(printWriter, bCViewOptions.zeroEmissionTimeLT);
        this.trace(printWriter, bCViewOptions.zeroEmissionDistanceCY);
        this.trace(printWriter, bCViewOptions.zeroEmissionTimeCY);
        this.trace(printWriter, bCViewOptions.maxValues);
        this.trace(printWriter, bCViewOptions.resetTimeStampST);
        this.trace(printWriter, bCViewOptions.resetTimeStampLT);
        this.trace(printWriter, bCViewOptions.resetTimeStampCY);
        this.trace(printWriter, bCViewOptions.comfortPowerConsumptionLT);
        this.trace(printWriter, bCViewOptions.comfortPowerConsumptionCY);
        this.trace(printWriter, bCViewOptions.astaMFA);
        this.trace(printWriter, bCViewOptions.resetTrip);
        this.trace(printWriter, bCViewOptions.configuration);
    }

    private void traceBCZeroEmissionAbsoluteDistance(PrintWriter printWriter, BCZeroEmissionAbsoluteDistance bCZeroEmissionAbsoluteDistance) {
        if (bCZeroEmissionAbsoluteDistance == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(bCZeroEmissionAbsoluteDistance.state);
        printWriter.print(bCZeroEmissionAbsoluteDistance.value);
    }

    private void traceBCZeroEmissionAbsoluteTime(PrintWriter printWriter, BCZeroEmissionAbsoluteTime bCZeroEmissionAbsoluteTime) {
        if (bCZeroEmissionAbsoluteTime == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(bCZeroEmissionAbsoluteTime.state);
        printWriter.print(bCZeroEmissionAbsoluteTime.value);
    }

    private void traceBCZeroEmissionRelative(PrintWriter printWriter, BCZeroEmissionRelative bCZeroEmissionRelative) {
        if (bCZeroEmissionRelative == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(bCZeroEmissionRelative.state);
        printWriter.print(bCZeroEmissionRelative.value);
    }

    private void traceDCAdditionalInfo(PrintWriter printWriter, DCAdditionalInfo dCAdditionalInfo) {
        if (dCAdditionalInfo == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(dCAdditionalInfo.blankLine);
        printWriter.print(dCAdditionalInfo.boostPressure);
        printWriter.print(dCAdditionalInfo.oilPressure);
        printWriter.print(dCAdditionalInfo.oilTemperature);
        printWriter.print(dCAdditionalInfo.coolantTemperature);
        printWriter.print(dCAdditionalInfo.fuelRange);
        printWriter.print(dCAdditionalInfo.destinationArrivalTime);
        printWriter.print(dCAdditionalInfo.intermediateArrivalTime);
        printWriter.print(dCAdditionalInfo.destinationTripTime);
        printWriter.print(dCAdditionalInfo.intermediateTripTime);
        printWriter.print(dCAdditionalInfo.compass);
        printWriter.print(dCAdditionalInfo.gpsHeight);
        printWriter.print(dCAdditionalInfo.time);
        printWriter.print(dCAdditionalInfo.date);
        printWriter.print(dCAdditionalInfo.hybridBattery);
        printWriter.print(dCAdditionalInfo.station);
        printWriter.print(dCAdditionalInfo.phoneInfo);
        printWriter.print(dCAdditionalInfo.lateralAcceleration);
        printWriter.print(dCAdditionalInfo.acceleration);
        printWriter.print(dCAdditionalInfo.deceleration);
        printWriter.print(dCAdditionalInfo.electricRange);
        printWriter.print(dCAdditionalInfo.batteryStateOfCharge);
        printWriter.print(dCAdditionalInfo.chargingTimeLeft);
        printWriter.print(dCAdditionalInfo.batteryTemperature);
        printWriter.print(dCAdditionalInfo.batteryLevel);
        printWriter.print(dCAdditionalInfo.coolant);
        printWriter.print(dCAdditionalInfo.boostLevel);
        printWriter.print(dCAdditionalInfo.batteryCoolant);
        printWriter.print(dCAdditionalInfo.batteryBoost);
        printWriter.print(dCAdditionalInfo.boostCoolant);
        printWriter.print(dCAdditionalInfo.vehicleVoltage);
        printWriter.print(dCAdditionalInfo.averageConsumption);
        printWriter.print(dCAdditionalInfo.distance);
        printWriter.print(dCAdditionalInfo.drivingTime);
        printWriter.print(dCAdditionalInfo.currentConsumption);
        printWriter.print(dCAdditionalInfo.zeroEmission);
        printWriter.print(dCAdditionalInfo.drivingProfile);
        printWriter.print(dCAdditionalInfo.secondarySpeed);
        printWriter.print(dCAdditionalInfo.digitalSpeed);
        printWriter.print(dCAdditionalInfo.energyFlow);
        printWriter.print(dCAdditionalInfo.aCC);
        printWriter.print(dCAdditionalInfo.routeGuidance);
        printWriter.print(dCAdditionalInfo.trafficSignDetection);
        printWriter.print(dCAdditionalInfo.shiftUpIndication);
        printWriter.print(dCAdditionalInfo.performance);
        printWriter.print(dCAdditionalInfo.predictiveEfficiencyAssistant);
        printWriter.print(dCAdditionalInfo.wildcard);
        printWriter.print(dCAdditionalInfo.steeringAngle);
        printWriter.print(dCAdditionalInfo.slope);
        printWriter.print(dCAdditionalInfo.consumptionData);
        printWriter.print(dCAdditionalInfo.combustorConsumption);
        printWriter.print(dCAdditionalInfo.electricalConsumption);
        printWriter.print(dCAdditionalInfo.averageSpeed);
        printWriter.print(dCAdditionalInfo.powermeter);
        printWriter.print(dCAdditionalInfo.tachometer);
        printWriter.print(dCAdditionalInfo.powermeterAndTachometer);
        printWriter.print(dCAdditionalInfo.hybrid);
        printWriter.print(dCAdditionalInfo.engineData);
        printWriter.print(dCAdditionalInfo.shortTermData);
        printWriter.print(dCAdditionalInfo.longTermData);
        printWriter.print(dCAdditionalInfo.gMeter);
        printWriter.print(dCAdditionalInfo.tyrePressureMonitor);
    }

    private void traceDCAdditionalInstrument(PrintWriter printWriter, DCAdditionalInstrument dCAdditionalInstrument) {
        if (dCAdditionalInstrument == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(dCAdditionalInstrument.instrumentOnOff);
        printWriter.print(dCAdditionalInstrument.light);
        printWriter.print(dCAdditionalInstrument.time);
        printWriter.print(dCAdditionalInstrument.brightness);
    }

    private void traceDCAdditionalInstrument2(PrintWriter printWriter, DCAdditionalInstrument2 dCAdditionalInstrument2) {
        if (dCAdditionalInstrument2 == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(dCAdditionalInstrument2.instrumentOnOff);
        printWriter.print(dCAdditionalInstrument2.digitalClock);
        printWriter.print(dCAdditionalInstrument2.analogClock);
        printWriter.print(dCAdditionalInstrument2.compass);
        printWriter.print(dCAdditionalInstrument2.navigation);
    }

    private void traceDCConfiguration(PrintWriter printWriter, DCConfiguration dCConfiguration) {
        if (dCConfiguration == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(dCConfiguration.maxVolume);
        this.trace(printWriter, dCConfiguration.elementContentSelectionListTransmittableElements);
        printWriter.print(dCConfiguration.dependencyDrivingProfile);
        this.trace(printWriter, dCConfiguration.displayPresetsListTransmittableElements);
        if (dCConfiguration.displayPresetsListRAConfig == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            int n = dCConfiguration.displayPresetsListRAConfig.length;
            printWriter.print(n);
            for (int i2 = 0; i2 < n; ++i2) {
                printWriter.print(dCConfiguration.displayPresetsListRAConfig[i2]);
            }
        }
    }

    private void traceDCDisplayDependency(PrintWriter printWriter, DCDisplayDependency dCDisplayDependency) {
        if (dCDisplayDependency == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(dCDisplayDependency.drivingProfile);
    }

    private void traceDCDisplayPresetsListRecord(PrintWriter printWriter, DCDisplayPresetsListRecord dCDisplayPresetsListRecord) {
        if (dCDisplayPresetsListRecord == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(dCDisplayPresetsListRecord.pos);
        printWriter.print(dCDisplayPresetsListRecord.state);
        printWriter.print(dCDisplayPresetsListRecord.type);
        printWriter.print(dCDisplayPresetsListRecord.instance);
        this.trace(printWriter, dCDisplayPresetsListRecord.display1);
        this.trace(printWriter, dCDisplayPresetsListRecord.display2);
        this.trace(printWriter, dCDisplayPresetsListRecord.display3);
    }

    private void traceDCDisplayPresetsListRecordDisplayData(PrintWriter printWriter, DCDisplayPresetsListRecordDisplayData dCDisplayPresetsListRecordDisplayData) {
        if (dCDisplayPresetsListRecordDisplayData == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        this.trace(printWriter, dCDisplayPresetsListRecordDisplayData.mainSelection);
        this.trace(printWriter, dCDisplayPresetsListRecordDisplayData.additionalInfo1);
        this.trace(printWriter, dCDisplayPresetsListRecordDisplayData.additionalInfo2);
    }

    private void traceDCDisplayViewConfiguration(PrintWriter printWriter, DCDisplayViewConfiguration dCDisplayViewConfiguration) {
        if (dCDisplayViewConfiguration == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(dCDisplayViewConfiguration.activeDisplayView);
    }

    private void traceDCDisplayedAdditionalInfos(PrintWriter printWriter, DCDisplayedAdditionalInfos dCDisplayedAdditionalInfos) {
        if (dCDisplayedAdditionalInfos == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(dCDisplayedAdditionalInfos.additionalInfo1);
        printWriter.print(dCDisplayedAdditionalInfos.additionalInfo2);
    }

    private void traceDCElementContentSelectionListRA1(PrintWriter printWriter, DCElementContentSelectionListRA1 dCElementContentSelectionListRA1) {
        if (dCElementContentSelectionListRA1 == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(dCElementContentSelectionListRA1.pos);
        printWriter.print(dCElementContentSelectionListRA1.display);
        printWriter.print(dCElementContentSelectionListRA1.additionalInfo);
        printWriter.print(dCElementContentSelectionListRA1.element);
        printWriter.print(dCElementContentSelectionListRA1.elementContent);
    }

    private void traceDCElementContentSelectionListRA2(PrintWriter printWriter, DCElementContentSelectionListRA2 dCElementContentSelectionListRA2) {
        if (dCElementContentSelectionListRA2 == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(dCElementContentSelectionListRA2.pos);
        printWriter.print(dCElementContentSelectionListRA2.elementContent);
    }

    private void traceDCElementContentSelectionListUpdateInfo(PrintWriter printWriter, DCElementContentSelectionListUpdateInfo dCElementContentSelectionListUpdateInfo) {
        if (dCElementContentSelectionListUpdateInfo == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(dCElementContentSelectionListUpdateInfo.arrayContent);
        printWriter.print(dCElementContentSelectionListUpdateInfo.recordContent);
        printWriter.print(dCElementContentSelectionListUpdateInfo.startElement);
        printWriter.print(dCElementContentSelectionListUpdateInfo.numOfElements);
        printWriter.print(dCElementContentSelectionListUpdateInfo.transactionID);
        printWriter.print(dCElementContentSelectionListUpdateInfo.asgID);
    }

    private void traceDCMainItems(PrintWriter printWriter, DCMainItems dCMainItems) {
        if (dCMainItems == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(dCMainItems.weatherTemperature);
        printWriter.print(dCMainItems.roadSignNotification);
        printWriter.print(dCMainItems.highBeamAssistant);
        printWriter.print(dCMainItems.fASACC);
        printWriter.print(dCMainItems.speedLimitScreen);
        printWriter.print(dCMainItems.tripScreen);
        printWriter.print(dCMainItems.tyrePressureControl);
        printWriter.print(dCMainItems.sportChrono);
        printWriter.print(dCMainItems.shiftAssist);
        printWriter.print(dCMainItems.gForce);
        printWriter.print(dCMainItems.performance);
        printWriter.print(dCMainItems.offroadAllWheel);
        printWriter.print(dCMainItems.efficiency);
        printWriter.print(dCMainItems.boost);
        printWriter.print(dCMainItems.hybrid);
        printWriter.print(dCMainItems.eConsumption);
        printWriter.print(dCMainItems.nightvision);
        printWriter.print(dCMainItems.nightvisionMap);
        printWriter.print(dCMainItems.info);
        printWriter.print(dCMainItems.carMain);
        printWriter.print(dCMainItems.eMobility);
        printWriter.print(dCMainItems.navigation);
        printWriter.print(dCMainItems.individual);
        printWriter.print(dCMainItems.audioMedia);
        printWriter.print(dCMainItems.telephone);
        printWriter.print(dCMainItems.powerMonitor);
        printWriter.print(dCMainItems.protectiveShield);
        printWriter.print(dCMainItems.speedometer);
        printWriter.print(dCMainItems.trafficLightInfo);
    }

    private void traceDCTransmittableElements(PrintWriter printWriter, DCTransmittableElements dCTransmittableElements) {
        if (dCTransmittableElements == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(dCTransmittableElements.ra0);
        printWriter.print(dCTransmittableElements.ra1);
        printWriter.print(dCTransmittableElements.ra2);
        printWriter.print(dCTransmittableElements.raF);
    }

    private void traceDCViewOptions(PrintWriter printWriter, DCViewOptions dCViewOptions) {
        if (dCViewOptions == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        this.trace(printWriter, dCViewOptions.brightness);
        this.trace(printWriter, dCViewOptions.volume);
        this.trace(printWriter, dCViewOptions.elementContentSelectionList);
        this.trace(printWriter, dCViewOptions.display1Setup);
        this.trace(printWriter, dCViewOptions.display1MainSelection);
        this.trace(printWriter, dCViewOptions.display2Setup);
        this.trace(printWriter, dCViewOptions.display2MainSelection);
        this.trace(printWriter, dCViewOptions.display3Setup);
        this.trace(printWriter, dCViewOptions.display3MainSelection);
        this.trace(printWriter, dCViewOptions.setFactoryDefault);
        this.trace(printWriter, dCViewOptions.additionalInstrumentSetup);
        this.trace(printWriter, dCViewOptions.additionalInstrument2Setup);
        this.trace(printWriter, dCViewOptions.displayPresetsList);
        this.trace(printWriter, dCViewOptions.activeDisplayPreset);
        this.trace(printWriter, dCViewOptions.displayViewConfiguration);
        this.trace(printWriter, dCViewOptions.displayDependency);
        this.trace(printWriter, dCViewOptions.ledConfiguration);
        this.trace(printWriter, dCViewOptions.configuration);
    }

    private void traceHUDConfiguration(PrintWriter printWriter, HUDConfiguration hUDConfiguration) {
        if (hUDConfiguration == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(hUDConfiguration.speed);
        printWriter.print(hUDConfiguration.warning);
        printWriter.print(hUDConfiguration.gra);
        printWriter.print(hUDConfiguration.nightvision);
        printWriter.print(hUDConfiguration.roadsign);
        printWriter.print(hUDConfiguration.rgi);
        printWriter.print(hUDConfiguration.navInfo);
        printWriter.print(hUDConfiguration.infoList);
        printWriter.print(hUDConfiguration.hca);
        printWriter.print(hUDConfiguration.acc);
        printWriter.print(hUDConfiguration.telephone);
        printWriter.print(hUDConfiguration.efficiencyAssist);
        printWriter.print(hUDConfiguration.speedLimiter);
        printWriter.print(hUDConfiguration.colourDesignAuto);
        printWriter.print(hUDConfiguration.colourDesignDay);
        printWriter.print(hUDConfiguration.colourDesignNight);
        printWriter.print(hUDConfiguration.colourDefault);
        printWriter.print(hUDConfiguration.colourAlternative);
    }

    private void traceHUDContent(PrintWriter printWriter, HUDContent hUDContent) {
        if (hUDContent == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(hUDContent.speed);
        printWriter.print(hUDContent.warning);
        printWriter.print(hUDContent.gra);
        printWriter.print(hUDContent.nightvision);
        printWriter.print(hUDContent.roadsign);
        printWriter.print(hUDContent.rgi);
        printWriter.print(hUDContent.navInfo);
        printWriter.print(hUDContent.infoList);
        printWriter.print(hUDContent.hca);
        printWriter.print(hUDContent.acc);
        printWriter.print(hUDContent.telephone);
        printWriter.print(hUDContent.efficiencyAssist);
        printWriter.print(hUDContent.speedLimiter);
    }

    private void traceHUDViewOptions(PrintWriter printWriter, HUDViewOptions hUDViewOptions) {
        if (hUDViewOptions == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        this.trace(printWriter, hUDViewOptions.heightAdjustment);
        this.trace(printWriter, hUDViewOptions.brightness);
        this.trace(printWriter, hUDViewOptions.content);
        this.trace(printWriter, hUDViewOptions.rotationAdjustment);
        this.trace(printWriter, hUDViewOptions.colour);
        this.trace(printWriter, hUDViewOptions.setFactoryDefault);
        this.trace(printWriter, hUDViewOptions.systemOnOff);
        this.trace(printWriter, hUDViewOptions.configuration);
        this.trace(printWriter, hUDViewOptions.license);
    }

    private void traceListDynValues(PrintWriter printWriter, ListDynValues listDynValues) {
        if (listDynValues == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(listDynValues.pos);
        printWriter.print(listDynValues.dynValue);
    }

    private void traceListWarningIDsDynValues(PrintWriter printWriter, ListWarningIDsDynValues listWarningIDsDynValues) {
        if (listWarningIDsDynValues == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(listWarningIDsDynValues.pos);
        printWriter.print(listWarningIDsDynValues.warningID);
        printWriter.print(listWarningIDsDynValues.dynValue);
    }

    private void traceSIAConfiguration(PrintWriter printWriter, SIAConfiguration sIAConfiguration) {
        if (sIAConfiguration == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        this.trace(printWriter, sIAConfiguration.historyListTransmittableElements);
        if (sIAConfiguration.historyListRAConfig == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            int n = sIAConfiguration.historyListRAConfig.length;
            printWriter.print(n);
            for (int i2 = 0; i2 < n; ++i2) {
                printWriter.print(sIAConfiguration.historyListRAConfig[i2]);
            }
        }
    }

    private void traceSIADistanceData(PrintWriter printWriter, SIADistanceData sIADistanceData) {
        if (sIADistanceData == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(sIADistanceData.state);
        printWriter.print(sIADistanceData.distance);
        printWriter.print(sIADistanceData.unit);
    }

    private void traceSIAHistoryListRecord(PrintWriter printWriter, SIAHistoryListRecord sIAHistoryListRecord) {
        if (sIAHistoryListRecord == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(sIAHistoryListRecord.pos);
        this.trace(printWriter, sIAHistoryListRecord.serviceTypes);
        this.trace(printWriter, sIAHistoryListRecord.serviceAttributes);
        printWriter.print(sIAHistoryListRecord.year);
        printWriter.print(sIAHistoryListRecord.month);
        printWriter.print(sIAHistoryListRecord.day);
        printWriter.print(sIAHistoryListRecord.orderCode);
        printWriter.print(sIAHistoryListRecord.mileage);
        printWriter.print(sIAHistoryListRecord.mileageUnit);
        printWriter.print(sIAHistoryListRecord.dealerName);
    }

    private void traceSIAOilInspection(PrintWriter printWriter, SIAOilInspection sIAOilInspection) {
        if (sIAOilInspection == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(sIAOilInspection.distanceStatus);
        printWriter.print(sIAOilInspection.distance);
        printWriter.print(sIAOilInspection.distanceUnit);
        printWriter.print(sIAOilInspection.timeStatus);
        printWriter.print(sIAOilInspection.time);
    }

    private void traceSIAResetValues(PrintWriter printWriter, SIAResetValues sIAResetValues) {
        if (sIAResetValues == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(sIAResetValues.distanceOil);
        printWriter.print(sIAResetValues.timeOil);
        printWriter.print(sIAResetValues.inspectionDistance);
        printWriter.print(sIAResetValues.inspectionTime);
    }

    private void traceSIAServiceAttributes(PrintWriter printWriter, SIAServiceAttributes sIAServiceAttributes) {
        if (sIAServiceAttributes == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(sIAServiceAttributes.brakeFluid);
        printWriter.print(sIAServiceAttributes.sparkPlug);
        printWriter.print(sIAServiceAttributes.airFilter);
        printWriter.print(sIAServiceAttributes.fuelFilter);
        printWriter.print(sIAServiceAttributes.tyreSealant);
        printWriter.print(sIAServiceAttributes.gearboxOil);
        printWriter.print(sIAServiceAttributes.engineOil);
    }

    private void traceSIAServiceData(PrintWriter printWriter, SIAServiceData sIAServiceData) {
        if (sIAServiceData == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(sIAServiceData.distanceStatus);
        printWriter.print(sIAServiceData.distance);
        printWriter.print(sIAServiceData.distanceUnit);
        printWriter.print(sIAServiceData.timeStatus);
        printWriter.print(sIAServiceData.time);
    }

    private void traceSIAServiceTypes(PrintWriter printWriter, SIAServiceTypes sIAServiceTypes) {
        if (sIAServiceTypes == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(sIAServiceTypes.maintenanceService);
        printWriter.print(sIAServiceTypes.oilService);
    }

    private void traceSIAViewOptions(PrintWriter printWriter, SIAViewOptions sIAViewOptions) {
        if (sIAViewOptions == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        this.trace(printWriter, sIAViewOptions.oilInspection);
        this.trace(printWriter, sIAViewOptions.serviceData);
        this.trace(printWriter, sIAViewOptions.reset);
        this.trace(printWriter, sIAViewOptions.historyList);
        this.trace(printWriter, sIAViewOptions.distanceOilUser);
        this.trace(printWriter, sIAViewOptions.distanceAirFilterUser);
        this.trace(printWriter, sIAViewOptions.distanceOilFilterUser);
        this.trace(printWriter, sIAViewOptions.inspectionDistanceUser);
        this.trace(printWriter, sIAViewOptions.dailyAverageMileage);
        this.trace(printWriter, sIAViewOptions.configuration);
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

