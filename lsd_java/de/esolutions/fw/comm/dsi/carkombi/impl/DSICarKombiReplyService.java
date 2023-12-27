/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carkombi.impl;

import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.carkombi.DSICarKombiReply;
import de.esolutions.fw.comm.dsi.carkombi.impl.BCAverageRecoveredEnergySerializer;
import de.esolutions.fw.comm.dsi.carkombi.impl.BCComfortPowerConsumptionSerializer;
import de.esolutions.fw.comm.dsi.carkombi.impl.BCCycleGeneralDataSerializer;
import de.esolutions.fw.comm.dsi.carkombi.impl.BCIndicationsSerializer;
import de.esolutions.fw.comm.dsi.carkombi.impl.BCLongTermGeneralDataSerializer;
import de.esolutions.fw.comm.dsi.carkombi.impl.BCMaxValuesSerializer;
import de.esolutions.fw.comm.dsi.carkombi.impl.BCMenueConfigurationSerializer;
import de.esolutions.fw.comm.dsi.carkombi.impl.BCRefuelVolumeSerializer;
import de.esolutions.fw.comm.dsi.carkombi.impl.BCResetTimeStampSerializer;
import de.esolutions.fw.comm.dsi.carkombi.impl.BCShortTermGeneralDataSerializer;
import de.esolutions.fw.comm.dsi.carkombi.impl.BCSpeedWarningSettingsSerializer;
import de.esolutions.fw.comm.dsi.carkombi.impl.BCStatisticsACSerializer;
import de.esolutions.fw.comm.dsi.carkombi.impl.BCStatisticsConfigSerializer;
import de.esolutions.fw.comm.dsi.carkombi.impl.BCStatisticsDistanceEUSerializer;
import de.esolutions.fw.comm.dsi.carkombi.impl.BCStatisticsRESerializer;
import de.esolutions.fw.comm.dsi.carkombi.impl.BCStatisticsZESerializer;
import de.esolutions.fw.comm.dsi.carkombi.impl.BCTankLevelSerializer;
import de.esolutions.fw.comm.dsi.carkombi.impl.BCVehicleStateUpdateInfoAHSerializer;
import de.esolutions.fw.comm.dsi.carkombi.impl.BCViewOptionsSerializer;
import de.esolutions.fw.comm.dsi.carkombi.impl.BCZeroEmissionAbsoluteDistanceSerializer;
import de.esolutions.fw.comm.dsi.carkombi.impl.BCZeroEmissionAbsoluteTimeSerializer;
import de.esolutions.fw.comm.dsi.carkombi.impl.BCZeroEmissionRelativeSerializer;
import de.esolutions.fw.comm.dsi.carkombi.impl.DCAdditionalInfoSerializer;
import de.esolutions.fw.comm.dsi.carkombi.impl.DCAdditionalInstrument2Serializer;
import de.esolutions.fw.comm.dsi.carkombi.impl.DCAdditionalInstrumentSerializer;
import de.esolutions.fw.comm.dsi.carkombi.impl.DCDisplayDependencySerializer;
import de.esolutions.fw.comm.dsi.carkombi.impl.DCDisplayPresetsListRecordSerializer;
import de.esolutions.fw.comm.dsi.carkombi.impl.DCDisplayViewConfigurationSerializer;
import de.esolutions.fw.comm.dsi.carkombi.impl.DCDisplayedAdditionalInfosSerializer;
import de.esolutions.fw.comm.dsi.carkombi.impl.DCElementContentSelectionListRA1Serializer;
import de.esolutions.fw.comm.dsi.carkombi.impl.DCElementContentSelectionListRA2Serializer;
import de.esolutions.fw.comm.dsi.carkombi.impl.DCElementContentSelectionListUpdateInfoSerializer;
import de.esolutions.fw.comm.dsi.carkombi.impl.DCMainItemsSerializer;
import de.esolutions.fw.comm.dsi.carkombi.impl.DCViewOptionsSerializer;
import de.esolutions.fw.comm.dsi.carkombi.impl.HUDContentSerializer;
import de.esolutions.fw.comm.dsi.carkombi.impl.HUDViewOptionsSerializer;
import de.esolutions.fw.comm.dsi.carkombi.impl.ListDynValuesSerializer;
import de.esolutions.fw.comm.dsi.carkombi.impl.ListWarningIDsDynValuesSerializer;
import de.esolutions.fw.comm.dsi.carkombi.impl.SIADistanceDataSerializer;
import de.esolutions.fw.comm.dsi.carkombi.impl.SIAHistoryListRecordSerializer;
import de.esolutions.fw.comm.dsi.carkombi.impl.SIAOilInspectionSerializer;
import de.esolutions.fw.comm.dsi.carkombi.impl.SIAServiceDataSerializer;
import de.esolutions.fw.comm.dsi.carkombi.impl.SIAViewOptionsSerializer;
import de.esolutions.fw.comm.dsi.global.impl.CarArrayListUpdateInfoSerializer;
import de.esolutions.fw.comm.dsi.global.impl.CarBCConsumptionSerializer;
import de.esolutions.fw.comm.dsi.global.impl.CarBCCurrentRangeSerializer;
import de.esolutions.fw.comm.dsi.global.impl.CarBCDistanceSerializer;
import de.esolutions.fw.comm.dsi.global.impl.CarBCTemperatureSerializer;
import de.esolutions.fw.comm.dsi.global.impl.CarBCTimeSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.carkombi.BCAverageRecoveredEnergy;
import org.dsi.ifc.carkombi.BCComfortPowerConsumption;
import org.dsi.ifc.carkombi.BCCycleGeneralData;
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
import org.dsi.ifc.carkombi.BCStatisticsZE;
import org.dsi.ifc.carkombi.BCTankLevel;
import org.dsi.ifc.carkombi.BCVehicleStateUpdateInfoAH;
import org.dsi.ifc.carkombi.BCViewOptions;
import org.dsi.ifc.carkombi.BCZeroEmissionAbsoluteDistance;
import org.dsi.ifc.carkombi.BCZeroEmissionAbsoluteTime;
import org.dsi.ifc.carkombi.BCZeroEmissionRelative;
import org.dsi.ifc.carkombi.DCAdditionalInfo;
import org.dsi.ifc.carkombi.DCAdditionalInstrument;
import org.dsi.ifc.carkombi.DCAdditionalInstrument2;
import org.dsi.ifc.carkombi.DCDisplayDependency;
import org.dsi.ifc.carkombi.DCDisplayPresetsListRecord;
import org.dsi.ifc.carkombi.DCDisplayViewConfiguration;
import org.dsi.ifc.carkombi.DCDisplayedAdditionalInfos;
import org.dsi.ifc.carkombi.DCElementContentSelectionListRA1;
import org.dsi.ifc.carkombi.DCElementContentSelectionListRA2;
import org.dsi.ifc.carkombi.DCElementContentSelectionListUpdateInfo;
import org.dsi.ifc.carkombi.DCMainItems;
import org.dsi.ifc.carkombi.DCViewOptions;
import org.dsi.ifc.carkombi.HUDContent;
import org.dsi.ifc.carkombi.HUDViewOptions;
import org.dsi.ifc.carkombi.ListDynValues;
import org.dsi.ifc.carkombi.ListWarningIDsDynValues;
import org.dsi.ifc.carkombi.SIADistanceData;
import org.dsi.ifc.carkombi.SIAHistoryListRecord;
import org.dsi.ifc.carkombi.SIAOilInspection;
import org.dsi.ifc.carkombi.SIAServiceData;
import org.dsi.ifc.carkombi.SIAViewOptions;
import org.dsi.ifc.global.CarArrayListUpdateInfo;
import org.dsi.ifc.global.CarBCConsumption;
import org.dsi.ifc.global.CarBCCurrentRange;
import org.dsi.ifc.global.CarBCDistance;
import org.dsi.ifc.global.CarBCTemperature;
import org.dsi.ifc.global.CarBCTime;

public class DSICarKombiReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.dsi.carkombi.DSICarKombi");
    private static int dynamicHandle = 0;
    private DSICarKombiReply p_DSICarKombiReply;

    public DSICarKombiReplyService(DSICarKombiReply dSICarKombiReply) {
        super(new ServiceInstanceID("410c0a95-ec80-5576-a934-6bb9b4f8e057", DSICarKombiReplyService.nextDynamicHandle(), "02c03d54-69ee-573b-a80a-3677b10ee047", "dsi.carkombi.DSICarKombi"));
        this.p_DSICarKombiReply = dSICarKombiReply;
    }

    private static synchronized int nextDynamicHandle() {
        int n = ++dynamicHandle;
        return n;
    }

    @Override
    public CallContext getCallContext() {
        return context;
    }

    @Override
    public void handleCallMethod(short s, IDeserializer iDeserializer, IProxyFrontend iProxyFrontend) {
        try {
            switch (s) {
                case 231: {
                    SIAViewOptions sIAViewOptions = SIAViewOptionsSerializer.getOptionalSIAViewOptions(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarKombiReply.updateSIAViewOptions(sIAViewOptions, n);
                    break;
                }
                case 95: {
                    SIAServiceData sIAServiceData = SIAServiceDataSerializer.getOptionalSIAServiceData(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarKombiReply.updateSIAServiceData(sIAServiceData, n);
                    break;
                }
                case 94: {
                    SIAOilInspection sIAOilInspection = SIAOilInspectionSerializer.getOptionalSIAOilInspection(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarKombiReply.updateSIAOilInspection(sIAOilInspection, n);
                    break;
                }
                case 7: {
                    boolean bl = iDeserializer.getBool();
                    this.p_DSICarKombiReply.indicateEndOfSIAReset(bl);
                    break;
                }
                case 229: {
                    CarArrayListUpdateInfo carArrayListUpdateInfo = CarArrayListUpdateInfoSerializer.getOptionalCarArrayListUpdateInfo(iDeserializer);
                    int[] nArray = iDeserializer.getOptionalInt32VarArray();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarKombiReply.updateSIAHistoryListUpdateInfo(carArrayListUpdateInfo, nArray, n);
                    break;
                }
                case 191: {
                    CarArrayListUpdateInfo carArrayListUpdateInfo = CarArrayListUpdateInfoSerializer.getOptionalCarArrayListUpdateInfo(iDeserializer);
                    SIAHistoryListRecord[] sIAHistoryListRecordArray = SIAHistoryListRecordSerializer.getOptionalSIAHistoryListRecordVarArray(iDeserializer);
                    this.p_DSICarKombiReply.responseSIAHistoryList(carArrayListUpdateInfo, sIAHistoryListRecordArray);
                    break;
                }
                case 228: {
                    int n = iDeserializer.getInt32();
                    int n2 = iDeserializer.getInt32();
                    this.p_DSICarKombiReply.updateSIAHistoryListTotalNumberOfElements(n, n2);
                    break;
                }
                case 227: {
                    SIADistanceData sIADistanceData = SIADistanceDataSerializer.getOptionalSIADistanceData(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarKombiReply.updateSIADistanceOilUser(sIADistanceData, n);
                    break;
                }
                case 225: {
                    SIADistanceData sIADistanceData = SIADistanceDataSerializer.getOptionalSIADistanceData(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarKombiReply.updateSIADistanceAirFilterUser(sIADistanceData, n);
                    break;
                }
                case 226: {
                    SIADistanceData sIADistanceData = SIADistanceDataSerializer.getOptionalSIADistanceData(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarKombiReply.updateSIADistanceOilFilterUser(sIADistanceData, n);
                    break;
                }
                case 230: {
                    SIADistanceData sIADistanceData = SIADistanceDataSerializer.getOptionalSIADistanceData(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarKombiReply.updateSIAInspectionDistanceUser(sIADistanceData, n);
                    break;
                }
                case 224: {
                    int n = iDeserializer.getInt32();
                    int n3 = iDeserializer.getInt32();
                    int n4 = iDeserializer.getInt32();
                    this.p_DSICarKombiReply.updateSIADailyAverageMileage(n, n3, n4);
                    break;
                }
                case 207: {
                    BCViewOptions bCViewOptions = BCViewOptionsSerializer.getOptionalBCViewOptions(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarKombiReply.updateBCViewOptions(bCViewOptions, n);
                    break;
                }
                case 46: {
                    BCIndications bCIndications = BCIndicationsSerializer.getOptionalBCIndications(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarKombiReply.updateBCIndications(bCIndications, n);
                    break;
                }
                case 37: {
                    CarBCConsumption carBCConsumption = CarBCConsumptionSerializer.getOptionalCarBCConsumption(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarKombiReply.updateBCCurrentConsumption1(carBCConsumption, n);
                    break;
                }
                case 38: {
                    CarBCConsumption carBCConsumption = CarBCConsumptionSerializer.getOptionalCarBCConsumption(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarKombiReply.updateBCCurrentConsumption2(carBCConsumption, n);
                    break;
                }
                case 39: {
                    CarBCCurrentRange carBCCurrentRange = CarBCCurrentRangeSerializer.getOptionalCarBCCurrentRange(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarKombiReply.updateBCCurrentRange1(carBCCurrentRange, n);
                    break;
                }
                case 40: {
                    CarBCCurrentRange carBCCurrentRange = CarBCCurrentRangeSerializer.getOptionalCarBCCurrentRange(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarKombiReply.updateBCCurrentRange2(carBCCurrentRange, n);
                    break;
                }
                case 83: {
                    CarBCDistance carBCDistance = CarBCDistanceSerializer.getOptionalCarBCDistance(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarKombiReply.updateBCTotalDistance(carBCDistance, n);
                    break;
                }
                case 59: {
                    CarBCConsumption carBCConsumption = CarBCConsumptionSerializer.getOptionalCarBCConsumption(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarKombiReply.updateBCShortTermAverageConsumption1(carBCConsumption, n);
                    break;
                }
                case 60: {
                    CarBCConsumption carBCConsumption = CarBCConsumptionSerializer.getOptionalCarBCConsumption(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarKombiReply.updateBCShortTermAverageConsumption2(carBCConsumption, n);
                    break;
                }
                case 137: {
                    BCShortTermGeneralData bCShortTermGeneralData = BCShortTermGeneralDataSerializer.getOptionalBCShortTermGeneralData(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarKombiReply.updateBCShortTermGeneral(bCShortTermGeneralData, n);
                    break;
                }
                case 48: {
                    CarBCConsumption carBCConsumption = CarBCConsumptionSerializer.getOptionalCarBCConsumption(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarKombiReply.updateBCLongTermAverageConsumption1(carBCConsumption, n);
                    break;
                }
                case 49: {
                    CarBCConsumption carBCConsumption = CarBCConsumptionSerializer.getOptionalCarBCConsumption(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarKombiReply.updateBCLongTermAverageConsumption2(carBCConsumption, n);
                    break;
                }
                case 136: {
                    BCLongTermGeneralData bCLongTermGeneralData = BCLongTermGeneralDataSerializer.getOptionalBCLongTermGeneralData(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarKombiReply.updateBCLongTermGeneral(bCLongTermGeneralData, n);
                    break;
                }
                case 41: {
                    CarBCConsumption carBCConsumption = CarBCConsumptionSerializer.getOptionalCarBCConsumption(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarKombiReply.updateBCCycleAverageConsumption1(carBCConsumption, n);
                    break;
                }
                case 42: {
                    CarBCConsumption carBCConsumption = CarBCConsumptionSerializer.getOptionalCarBCConsumption(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarKombiReply.updateBCCycleAverageConsumption2(carBCConsumption, n);
                    break;
                }
                case 135: {
                    BCCycleGeneralData bCCycleGeneralData = BCCycleGeneralDataSerializer.getOptionalBCCycleGeneralData(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarKombiReply.updateBCCycleGeneral(bCCycleGeneralData, n);
                    break;
                }
                case 84: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarKombiReply.updateBCVZADisplay(bl, n);
                    break;
                }
                case 47: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarKombiReply.updateBCLifeTipsDisplay(bl, n);
                    break;
                }
                case 36: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarKombiReply.updateBCConsumerDisplay(bl, n);
                    break;
                }
                case 138: {
                    BCTankLevel bCTankLevel = BCTankLevelSerializer.getOptionalBCTankLevel(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarKombiReply.updateBCTankLevel1(bCTankLevel, n);
                    break;
                }
                case 139: {
                    BCTankLevel bCTankLevel = BCTankLevelSerializer.getOptionalBCTankLevel(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarKombiReply.updateBCTankLevel2(bCTankLevel, n);
                    break;
                }
                case 57: {
                    BCRefuelVolume bCRefuelVolume = BCRefuelVolumeSerializer.getOptionalBCRefuelVolume(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarKombiReply.updateBCRefuelVolume1(bCRefuelVolume, n);
                    break;
                }
                case 58: {
                    BCRefuelVolume bCRefuelVolume = BCRefuelVolumeSerializer.getOptionalBCRefuelVolume(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarKombiReply.updateBCRefuelVolume2(bCRefuelVolume, n);
                    break;
                }
                case 116: {
                    BCMenueConfiguration bCMenueConfiguration = BCMenueConfigurationSerializer.getOptionalBCMenueConfiguration(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarKombiReply.updateBCMenue1Config(bCMenueConfiguration, n);
                    break;
                }
                case 117: {
                    BCMenueConfiguration bCMenueConfiguration = BCMenueConfigurationSerializer.getOptionalBCMenueConfiguration(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarKombiReply.updateBCMenue2Config(bCMenueConfiguration, n);
                    break;
                }
                case 118: {
                    BCMenueConfiguration bCMenueConfiguration = BCMenueConfigurationSerializer.getOptionalBCMenueConfiguration(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarKombiReply.updateBCMenue3Config(bCMenueConfiguration, n);
                    break;
                }
                case 54: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarKombiReply.updateBCOilTemperature(bl, n);
                    break;
                }
                case 44: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarKombiReply.updateBCDigitalSpeed(bl, n);
                    break;
                }
                case 80: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarKombiReply.updateBCStopwatch(bl, n);
                    break;
                }
                case 87: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarKombiReply.updateBCVzaMFA(bl, n);
                    break;
                }
                case 62: {
                    BCSpeedWarningSettings bCSpeedWarningSettings = BCSpeedWarningSettingsSerializer.getOptionalBCSpeedWarningSettings(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarKombiReply.updateBCSpeedWarning(bCSpeedWarningSettings, n);
                    break;
                }
                case 45: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarKombiReply.updateBCGearRecommendation(bl, n);
                    break;
                }
                case 56: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarKombiReply.updateBCRearSeatbeltWarning(bl, n);
                    break;
                }
                case 55: {
                    CarBCTemperature carBCTemperature = CarBCTemperatureSerializer.getOptionalCarBCTemperature(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarKombiReply.updateBCOutsideTemperature(carBCTemperature, n);
                    break;
                }
                case 6: {
                    boolean bl = iDeserializer.getBool();
                    this.p_DSICarKombiReply.indicateEndOfBCMenuReset(bl);
                    break;
                }
                case 85: {
                    int n = iDeserializer.getInt32();
                    int n5 = iDeserializer.getInt32();
                    this.p_DSICarKombiReply.updateBCVehicleStateListTotalNumberOfElements(n, n5);
                    break;
                }
                case 151: {
                    BCVehicleStateUpdateInfoAH bCVehicleStateUpdateInfoAH = BCVehicleStateUpdateInfoAHSerializer.getOptionalBCVehicleStateUpdateInfoAH(iDeserializer);
                    int[] nArray = iDeserializer.getOptionalInt32VarArray();
                    this.p_DSICarKombiReply.responseVehicleStateUpdateInfo(bCVehicleStateUpdateInfoAH, nArray);
                    break;
                }
                case 149: {
                    BCVehicleStateUpdateInfoAH bCVehicleStateUpdateInfoAH = BCVehicleStateUpdateInfoAHSerializer.getOptionalBCVehicleStateUpdateInfoAH(iDeserializer);
                    int n = iDeserializer.getInt32();
                    int n6 = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    String string2 = iDeserializer.getOptionalString();
                    this.p_DSICarKombiReply.responseVehicleStateListWarningIDdynValueAlternativeText(bCVehicleStateUpdateInfoAH, n, n6, string, string2);
                    break;
                }
                case 148: {
                    BCVehicleStateUpdateInfoAH bCVehicleStateUpdateInfoAH = BCVehicleStateUpdateInfoAHSerializer.getOptionalBCVehicleStateUpdateInfoAH(iDeserializer);
                    ListWarningIDsDynValues[] listWarningIDsDynValuesArray = ListWarningIDsDynValuesSerializer.getOptionalListWarningIDsDynValuesVarArray(iDeserializer);
                    this.p_DSICarKombiReply.responseVehicleStateListWarningIDdynValue(bCVehicleStateUpdateInfoAH, listWarningIDsDynValuesArray);
                    break;
                }
                case 146: {
                    BCVehicleStateUpdateInfoAH bCVehicleStateUpdateInfoAH = BCVehicleStateUpdateInfoAHSerializer.getOptionalBCVehicleStateUpdateInfoAH(iDeserializer);
                    int n = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    this.p_DSICarKombiReply.responseVehicleStateListAlternativeText(bCVehicleStateUpdateInfoAH, n, string);
                    break;
                }
                case 150: {
                    BCVehicleStateUpdateInfoAH bCVehicleStateUpdateInfoAH = BCVehicleStateUpdateInfoAHSerializer.getOptionalBCVehicleStateUpdateInfoAH(iDeserializer);
                    ListDynValues[] listDynValuesArray = ListDynValuesSerializer.getOptionalListDynValuesVarArray(iDeserializer);
                    this.p_DSICarKombiReply.responseVehicleStateListdynValue(bCVehicleStateUpdateInfoAH, listDynValuesArray);
                    break;
                }
                case 147: {
                    BCVehicleStateUpdateInfoAH bCVehicleStateUpdateInfoAH = BCVehicleStateUpdateInfoAHSerializer.getOptionalBCVehicleStateUpdateInfoAH(iDeserializer);
                    int[] nArray = iDeserializer.getOptionalInt32VarArray();
                    this.p_DSICarKombiReply.responseVehicleStateListPos(bCVehicleStateUpdateInfoAH, nArray);
                    break;
                }
                case 0: {
                    boolean bl = iDeserializer.getBool();
                    this.p_DSICarKombiReply.acknowledgeBcSetFactoryDefault(bl);
                    break;
                }
                case 110: {
                    boolean bl = iDeserializer.getBool();
                    this.p_DSICarKombiReply.acknowledgeHUDSetFactoryDefault(bl);
                    break;
                }
                case 141: {
                    boolean bl = iDeserializer.getBool();
                    this.p_DSICarKombiReply.acknowledgeDCSetFactoryDefault(bl);
                    break;
                }
                case 1: {
                    int n = iDeserializer.getInt32();
                    this.p_DSICarKombiReply.acknowledgeBcStatisticsReset(n);
                    break;
                }
                case 64: {
                    BCStatisticsAC bCStatisticsAC = BCStatisticsACSerializer.getOptionalBCStatisticsAC(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarKombiReply.updateBCStatisticsDistanceAC1(bCStatisticsAC, n);
                    break;
                }
                case 65: {
                    BCStatisticsAC bCStatisticsAC = BCStatisticsACSerializer.getOptionalBCStatisticsAC(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarKombiReply.updateBCStatisticsDistanceAC2(bCStatisticsAC, n);
                    break;
                }
                case 70: {
                    BCStatisticsRE bCStatisticsRE = BCStatisticsRESerializer.getOptionalBCStatisticsRE(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarKombiReply.updateBCStatisticsDistanceRE(bCStatisticsRE, n);
                    break;
                }
                case 71: {
                    BCStatisticsZE bCStatisticsZE = BCStatisticsZESerializer.getOptionalBCStatisticsZE(iDeserializer);
                    BCZeroEmissionAbsoluteDistance bCZeroEmissionAbsoluteDistance = BCZeroEmissionAbsoluteDistanceSerializer.getOptionalBCZeroEmissionAbsoluteDistance(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarKombiReply.updateBCStatisticsDistanceZE(bCStatisticsZE, bCZeroEmissionAbsoluteDistance, n);
                    break;
                }
                case 66: {
                    CarBCConsumption carBCConsumption = CarBCConsumptionSerializer.getOptionalCarBCConsumption(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarKombiReply.updateBCStatisticsDistanceCurrentIntervalAC1(carBCConsumption, n);
                    break;
                }
                case 67: {
                    CarBCConsumption carBCConsumption = CarBCConsumptionSerializer.getOptionalCarBCConsumption(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarKombiReply.updateBCStatisticsDistanceCurrentIntervalAC2(carBCConsumption, n);
                    break;
                }
                case 68: {
                    BCAverageRecoveredEnergy bCAverageRecoveredEnergy = BCAverageRecoveredEnergySerializer.getOptionalBCAverageRecoveredEnergy(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarKombiReply.updateBCStatisticsDistanceCurrentIntervalRE(bCAverageRecoveredEnergy, n);
                    break;
                }
                case 69: {
                    BCZeroEmissionRelative bCZeroEmissionRelative = BCZeroEmissionRelativeSerializer.getOptionalBCZeroEmissionRelative(iDeserializer);
                    BCZeroEmissionAbsoluteDistance bCZeroEmissionAbsoluteDistance = BCZeroEmissionAbsoluteDistanceSerializer.getOptionalBCZeroEmissionAbsoluteDistance(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarKombiReply.updateBCStatisticsDistanceCurrentIntervalZE(bCZeroEmissionRelative, bCZeroEmissionAbsoluteDistance, n);
                    break;
                }
                case 72: {
                    BCStatisticsAC bCStatisticsAC = BCStatisticsACSerializer.getOptionalBCStatisticsAC(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarKombiReply.updateBCStatisticsTimeAC1(bCStatisticsAC, n);
                    break;
                }
                case 73: {
                    BCStatisticsAC bCStatisticsAC = BCStatisticsACSerializer.getOptionalBCStatisticsAC(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarKombiReply.updateBCStatisticsTimeAC2(bCStatisticsAC, n);
                    break;
                }
                case 78: {
                    BCStatisticsRE bCStatisticsRE = BCStatisticsRESerializer.getOptionalBCStatisticsRE(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarKombiReply.updateBCStatisticsTimeRE(bCStatisticsRE, n);
                    break;
                }
                case 79: {
                    BCStatisticsZE bCStatisticsZE = BCStatisticsZESerializer.getOptionalBCStatisticsZE(iDeserializer);
                    BCZeroEmissionAbsoluteTime bCZeroEmissionAbsoluteTime = BCZeroEmissionAbsoluteTimeSerializer.getOptionalBCZeroEmissionAbsoluteTime(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarKombiReply.updateBCStatisticsTimeZE(bCStatisticsZE, bCZeroEmissionAbsoluteTime, n);
                    break;
                }
                case 74: {
                    CarBCConsumption carBCConsumption = CarBCConsumptionSerializer.getOptionalCarBCConsumption(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarKombiReply.updateBCStatisticsTimeCurrentPeriodAC1(carBCConsumption, n);
                    break;
                }
                case 75: {
                    CarBCConsumption carBCConsumption = CarBCConsumptionSerializer.getOptionalCarBCConsumption(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarKombiReply.updateBCStatisticsTimeCurrentPeriodAC2(carBCConsumption, n);
                    break;
                }
                case 76: {
                    BCAverageRecoveredEnergy bCAverageRecoveredEnergy = BCAverageRecoveredEnergySerializer.getOptionalBCAverageRecoveredEnergy(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarKombiReply.updateBCStatisticsTimeCurrentPeriodRE(bCAverageRecoveredEnergy, n);
                    break;
                }
                case 77: {
                    BCZeroEmissionRelative bCZeroEmissionRelative = BCZeroEmissionRelativeSerializer.getOptionalBCZeroEmissionRelative(iDeserializer);
                    BCZeroEmissionAbsoluteTime bCZeroEmissionAbsoluteTime = BCZeroEmissionAbsoluteTimeSerializer.getOptionalBCZeroEmissionAbsoluteTime(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarKombiReply.updateBCStatisticsTimeCurrentPeriodZE(bCZeroEmissionRelative, bCZeroEmissionAbsoluteTime, n);
                    break;
                }
                case 63: {
                    BCStatisticsConfig bCStatisticsConfig = BCStatisticsConfigSerializer.getOptionalBCStatisticsConfig(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarKombiReply.updateBCStatisticsConfig(bCStatisticsConfig, n);
                    break;
                }
                case 122: {
                    BCStatisticsDistanceEU bCStatisticsDistanceEU = BCStatisticsDistanceEUSerializer.getOptionalBCStatisticsDistanceEU(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarKombiReply.updateBCStatisticDistanceEUkm(bCStatisticsDistanceEU, n);
                    break;
                }
                case 123: {
                    BCStatisticsDistanceEU bCStatisticsDistanceEU = BCStatisticsDistanceEUSerializer.getOptionalBCStatisticsDistanceEU(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarKombiReply.updateBCStatisticDistanceEUmls(bCStatisticsDistanceEU, n);
                    break;
                }
                case 101: {
                    CarBCTemperature carBCTemperature = CarBCTemperatureSerializer.getOptionalCarBCTemperature(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarKombiReply.updateBCOilTemperatureValue(carBCTemperature, n);
                    break;
                }
                case 100: {
                    CarBCTemperature carBCTemperature = CarBCTemperatureSerializer.getOptionalCarBCTemperature(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarKombiReply.updateBCCoolantTemperature(carBCTemperature, n);
                    break;
                }
                case 99: {
                    BCComfortPowerConsumption bCComfortPowerConsumption = BCComfortPowerConsumptionSerializer.getOptionalBCComfortPowerConsumption(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarKombiReply.updateBCComfortPowerConsumption(bCComfortPowerConsumption, n);
                    break;
                }
                case 124: {
                    CarBCDistance carBCDistance = CarBCDistanceSerializer.getOptionalCarBCDistance(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarKombiReply.updateBCTotalCurrentRange(carBCDistance, n);
                    break;
                }
                case 128: {
                    CarBCDistance carBCDistance = CarBCDistanceSerializer.getOptionalCarBCDistance(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarKombiReply.updateBCZeroEmissionDistanceST(carBCDistance, n);
                    break;
                }
                case 127: {
                    CarBCDistance carBCDistance = CarBCDistanceSerializer.getOptionalCarBCDistance(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarKombiReply.updateBCZeroEmissionDistanceLT(carBCDistance, n);
                    break;
                }
                case 126: {
                    CarBCDistance carBCDistance = CarBCDistanceSerializer.getOptionalCarBCDistance(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarKombiReply.updateBCZeroEmissionDistanceCY(carBCDistance, n);
                    break;
                }
                case 131: {
                    CarBCTime carBCTime = CarBCTimeSerializer.getOptionalCarBCTime(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarKombiReply.updateBCZeroEmissionTimeST(carBCTime, n);
                    break;
                }
                case 130: {
                    CarBCTime carBCTime = CarBCTimeSerializer.getOptionalCarBCTime(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarKombiReply.updateBCZeroEmissionTimeLT(carBCTime, n);
                    break;
                }
                case 129: {
                    CarBCTime carBCTime = CarBCTimeSerializer.getOptionalCarBCTime(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarKombiReply.updateBCZeroEmissionTimeCY(carBCTime, n);
                    break;
                }
                case 115: {
                    BCMaxValues bCMaxValues = BCMaxValuesSerializer.getOptionalBCMaxValues(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarKombiReply.updateBCMaxValues(bCMaxValues, n);
                    break;
                }
                case 121: {
                    BCResetTimeStamp bCResetTimeStamp = BCResetTimeStampSerializer.getOptionalBCResetTimeStamp(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarKombiReply.updateBCResetTimeStampST(bCResetTimeStamp, n);
                    break;
                }
                case 120: {
                    BCResetTimeStamp bCResetTimeStamp = BCResetTimeStampSerializer.getOptionalBCResetTimeStamp(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarKombiReply.updateBCResetTimeStampLT(bCResetTimeStamp, n);
                    break;
                }
                case 119: {
                    BCResetTimeStamp bCResetTimeStamp = BCResetTimeStampSerializer.getOptionalBCResetTimeStamp(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarKombiReply.updateBCResetTimeStampCY(bCResetTimeStamp, n);
                    break;
                }
                case 176: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarKombiReply.updateBCAstaMFA(bl, n);
                    break;
                }
                case 223: {
                    HUDViewOptions hUDViewOptions = HUDViewOptionsSerializer.getOptionalHUDViewOptions(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarKombiReply.updateHUDViewOptions(hUDViewOptions, n);
                    break;
                }
                case 91: {
                    byte by = iDeserializer.getInt8();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarKombiReply.updateHUDHeightAdjustment(by, n);
                    break;
                }
                case 89: {
                    byte by = iDeserializer.getInt8();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarKombiReply.updateHUDBrightness(by, n);
                    break;
                }
                case 132: {
                    int n = iDeserializer.getInt32();
                    int n7 = iDeserializer.getInt32();
                    int n8 = iDeserializer.getInt32();
                    this.p_DSICarKombiReply.updateHUDColour(n, n7, n8);
                    break;
                }
                case 106: {
                    HUDContent hUDContent = HUDContentSerializer.getOptionalHUDContent(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarKombiReply.updateHUDContent(hUDContent, n);
                    break;
                }
                case 92: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarKombiReply.updateHUDInfo(bl, n);
                    break;
                }
                case 133: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarKombiReply.updateHUDSystemOnOff(bl, n);
                    break;
                }
                case 107: {
                    int n = iDeserializer.getInt32();
                    int n9 = iDeserializer.getInt32();
                    this.p_DSICarKombiReply.updateHUDRotationAdjustment(n, n9);
                    break;
                }
                case 221: {
                    DCViewOptions dCViewOptions = DCViewOptionsSerializer.getOptionalDCViewOptions(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarKombiReply.updateDCViewOptions(dCViewOptions, n);
                    break;
                }
                case 160: {
                    int n = iDeserializer.getInt32();
                    int n10 = iDeserializer.getInt32();
                    this.p_DSICarKombiReply.updateDCBrightness(n, n10);
                    break;
                }
                case 170: {
                    int n = iDeserializer.getInt32();
                    int n11 = iDeserializer.getInt32();
                    this.p_DSICarKombiReply.updateDCVolume(n, n11);
                    break;
                }
                case 167: {
                    int n = iDeserializer.getInt32();
                    int n12 = iDeserializer.getInt32();
                    this.p_DSICarKombiReply.updateDCElementContentSelectionListTotalNumberOfElements(n, n12);
                    break;
                }
                case 211: {
                    DCMainItems dCMainItems = DCMainItemsSerializer.getOptionalDCMainItems(iDeserializer);
                    DCDisplayedAdditionalInfos dCDisplayedAdditionalInfos = DCDisplayedAdditionalInfosSerializer.getOptionalDCDisplayedAdditionalInfos(iDeserializer);
                    DCAdditionalInfo dCAdditionalInfo = DCAdditionalInfoSerializer.getOptionalDCAdditionalInfo(iDeserializer);
                    DCAdditionalInfo dCAdditionalInfo2 = DCAdditionalInfoSerializer.getOptionalDCAdditionalInfo(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarKombiReply.updateDCDisplay1Setup(dCMainItems, dCDisplayedAdditionalInfos, dCAdditionalInfo, dCAdditionalInfo2, n);
                    break;
                }
                case 213: {
                    DCMainItems dCMainItems = DCMainItemsSerializer.getOptionalDCMainItems(iDeserializer);
                    DCDisplayedAdditionalInfos dCDisplayedAdditionalInfos = DCDisplayedAdditionalInfosSerializer.getOptionalDCDisplayedAdditionalInfos(iDeserializer);
                    DCAdditionalInfo dCAdditionalInfo = DCAdditionalInfoSerializer.getOptionalDCAdditionalInfo(iDeserializer);
                    DCAdditionalInfo dCAdditionalInfo3 = DCAdditionalInfoSerializer.getOptionalDCAdditionalInfo(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarKombiReply.updateDCDisplay2Setup(dCMainItems, dCDisplayedAdditionalInfos, dCAdditionalInfo, dCAdditionalInfo3, n);
                    break;
                }
                case 215: {
                    DCMainItems dCMainItems = DCMainItemsSerializer.getOptionalDCMainItems(iDeserializer);
                    DCDisplayedAdditionalInfos dCDisplayedAdditionalInfos = DCDisplayedAdditionalInfosSerializer.getOptionalDCDisplayedAdditionalInfos(iDeserializer);
                    DCAdditionalInfo dCAdditionalInfo = DCAdditionalInfoSerializer.getOptionalDCAdditionalInfo(iDeserializer);
                    DCAdditionalInfo dCAdditionalInfo4 = DCAdditionalInfoSerializer.getOptionalDCAdditionalInfo(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarKombiReply.updateDCDisplay3Setup(dCMainItems, dCDisplayedAdditionalInfos, dCAdditionalInfo, dCAdditionalInfo4, n);
                    break;
                }
                case 210: {
                    DCMainItems dCMainItems = DCMainItemsSerializer.getOptionalDCMainItems(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarKombiReply.updateDCDisplay1MainSelection(dCMainItems, n);
                    break;
                }
                case 212: {
                    DCMainItems dCMainItems = DCMainItemsSerializer.getOptionalDCMainItems(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarKombiReply.updateDCDisplay2MainSelection(dCMainItems, n);
                    break;
                }
                case 214: {
                    DCMainItems dCMainItems = DCMainItemsSerializer.getOptionalDCMainItems(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarKombiReply.updateDCDisplay3MainSelection(dCMainItems, n);
                    break;
                }
                case 145: {
                    DCElementContentSelectionListUpdateInfo dCElementContentSelectionListUpdateInfo = DCElementContentSelectionListUpdateInfoSerializer.getOptionalDCElementContentSelectionListUpdateInfo(iDeserializer);
                    int[] nArray = iDeserializer.getOptionalInt32VarArray();
                    this.p_DSICarKombiReply.responseDCElementContentSelectionListRAF(dCElementContentSelectionListUpdateInfo, nArray);
                    break;
                }
                case 144: {
                    DCElementContentSelectionListUpdateInfo dCElementContentSelectionListUpdateInfo = DCElementContentSelectionListUpdateInfoSerializer.getOptionalDCElementContentSelectionListUpdateInfo(iDeserializer);
                    DCElementContentSelectionListRA1[] dCElementContentSelectionListRA1Array = DCElementContentSelectionListRA1Serializer.getOptionalDCElementContentSelectionListRA1VarArray(iDeserializer);
                    this.p_DSICarKombiReply.responseDCElementContentSelectionListRA1(dCElementContentSelectionListUpdateInfo, dCElementContentSelectionListRA1Array);
                    break;
                }
                case 190: {
                    DCElementContentSelectionListUpdateInfo dCElementContentSelectionListUpdateInfo = DCElementContentSelectionListUpdateInfoSerializer.getOptionalDCElementContentSelectionListUpdateInfo(iDeserializer);
                    DCElementContentSelectionListRA2[] dCElementContentSelectionListRA2Array = DCElementContentSelectionListRA2Serializer.getOptionalDCElementContentSelectionListRA2VarArray(iDeserializer);
                    this.p_DSICarKombiReply.responseDCElementContentSelectionListRA2(dCElementContentSelectionListUpdateInfo, dCElementContentSelectionListRA2Array);
                    break;
                }
                case 168: {
                    DCElementContentSelectionListUpdateInfo dCElementContentSelectionListUpdateInfo = DCElementContentSelectionListUpdateInfoSerializer.getOptionalDCElementContentSelectionListUpdateInfo(iDeserializer);
                    int[] nArray = iDeserializer.getOptionalInt32VarArray();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarKombiReply.updateDCElementContentSelectionListUpdateInfo(dCElementContentSelectionListUpdateInfo, nArray, n);
                    break;
                }
                case 178: {
                    DCAdditionalInstrument dCAdditionalInstrument = DCAdditionalInstrumentSerializer.getOptionalDCAdditionalInstrument(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarKombiReply.updateDCAdditionalInstrumentSetup(dCAdditionalInstrument, n);
                    break;
                }
                case 209: {
                    DCAdditionalInstrument2 dCAdditionalInstrument2 = DCAdditionalInstrument2Serializer.getOptionalDCAdditionalInstrument2(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarKombiReply.updateDCAdditionalInstrument2Setup(dCAdditionalInstrument2, n);
                    break;
                }
                case 217: {
                    int n = iDeserializer.getInt32();
                    int n13 = iDeserializer.getInt32();
                    this.p_DSICarKombiReply.updateDCDisplayPresetsListTotalNumberOfElements(n, n13);
                    break;
                }
                case 189: {
                    CarArrayListUpdateInfo carArrayListUpdateInfo = CarArrayListUpdateInfoSerializer.getOptionalCarArrayListUpdateInfo(iDeserializer);
                    DCDisplayPresetsListRecord[] dCDisplayPresetsListRecordArray = DCDisplayPresetsListRecordSerializer.getOptionalDCDisplayPresetsListRecordVarArray(iDeserializer);
                    this.p_DSICarKombiReply.responseDCDisplayPresetsList(carArrayListUpdateInfo, dCDisplayPresetsListRecordArray);
                    break;
                }
                case 218: {
                    CarArrayListUpdateInfo carArrayListUpdateInfo = CarArrayListUpdateInfoSerializer.getOptionalCarArrayListUpdateInfo(iDeserializer);
                    DCDisplayPresetsListRecord[] dCDisplayPresetsListRecordArray = DCDisplayPresetsListRecordSerializer.getOptionalDCDisplayPresetsListRecordVarArray(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarKombiReply.updateDCDisplayPresetsListUpdateInfo(carArrayListUpdateInfo, dCDisplayPresetsListRecordArray, n);
                    break;
                }
                case 216: {
                    DCDisplayDependency dCDisplayDependency = DCDisplayDependencySerializer.getOptionalDCDisplayDependency(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarKombiReply.updateDCDisplayDependencySetup(dCDisplayDependency, n);
                    break;
                }
                case 208: {
                    int n = iDeserializer.getInt32();
                    int n14 = iDeserializer.getInt32();
                    this.p_DSICarKombiReply.updateDCActiveDisplayPreset(n, n14);
                    break;
                }
                case 219: {
                    DCDisplayViewConfiguration dCDisplayViewConfiguration = DCDisplayViewConfigurationSerializer.getOptionalDCDisplayViewConfiguration(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarKombiReply.updateDCDisplayViewConfiguration(dCDisplayViewConfiguration, n);
                    break;
                }
                case 88: {
                    int n = iDeserializer.getInt32();
                    int n15 = iDeserializer.getInt32();
                    int n16 = iDeserializer.getInt32();
                    this.p_DSICarKombiReply.updateCompassInfo(n, n15, n16);
                    break;
                }
                case 222: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarKombiReply.updateHUDLicense(bl, n);
                    break;
                }
                case 220: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarKombiReply.updateDCLEDConfiguration(bl, n);
                    break;
                }
                case 2: {
                    int n = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    int n17 = iDeserializer.getInt32();
                    this.p_DSICarKombiReply.asyncException(n, string, n17);
                    break;
                }
                case 97: {
                    String string = iDeserializer.getOptionalString();
                    String string3 = iDeserializer.getOptionalString();
                    this.p_DSICarKombiReply.yyIndication(string, string3);
                    break;
                }
                default: {
                    throw new MethodException(new StringBuffer().append("Invalid Method Id ").append(s).toString());
                }
            }
        }
        catch (SerializerException serializerException) {
            throw new MethodException(new StringBuffer().append("Deserialization failed: method=").append(s).append(", error=").append(serializerException.getMessage()).toString());
        }
    }
}

