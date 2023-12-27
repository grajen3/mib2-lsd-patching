/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.careco.impl;

import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.careco.DSICarEcoReply;
import de.esolutions.fw.comm.dsi.careco.impl.BCmEConsumerListConsumptionRA0Serializer;
import de.esolutions.fw.comm.dsi.careco.impl.BCmEConsumerListConsumptionRA1Serializer;
import de.esolutions.fw.comm.dsi.careco.impl.BCmEConsumerListRangeRA0Serializer;
import de.esolutions.fw.comm.dsi.careco.impl.BCmEConsumerListRangeRA1Serializer;
import de.esolutions.fw.comm.dsi.careco.impl.BCmEConsumerListRangeRA2Serializer;
import de.esolutions.fw.comm.dsi.careco.impl.BCmEConsumerListSerializer;
import de.esolutions.fw.comm.dsi.careco.impl.BCmECurrentRangeSerializer;
import de.esolutions.fw.comm.dsi.careco.impl.BCmEEnergyFlowComfortSerializer;
import de.esolutions.fw.comm.dsi.careco.impl.BCmEListUpdateInfoSerializer;
import de.esolutions.fw.comm.dsi.careco.impl.BCmERangeGainTotalSerializer;
import de.esolutions.fw.comm.dsi.careco.impl.BCmEViewOptionsSerializer;
import de.esolutions.fw.comm.dsi.careco.impl.EAViewOptionsSerializer;
import de.esolutions.fw.comm.dsi.careco.impl.RangeDataResidualEnergySerializer;
import de.esolutions.fw.comm.dsi.careco.impl.RangeDataViewOptionsSerializer;
import de.esolutions.fw.comm.dsi.careco.impl.StartStopListUpdateInfoSerializer;
import de.esolutions.fw.comm.dsi.careco.impl.StartStopProhibitListSerializer;
import de.esolutions.fw.comm.dsi.careco.impl.StartStopRestartListSerializer;
import de.esolutions.fw.comm.dsi.careco.impl.StartStopRestartProhibitListSerializer;
import de.esolutions.fw.comm.dsi.careco.impl.StartStopViewOptionsSerializer;
import de.esolutions.fw.comm.dsi.global.impl.CarBCConsumptionSerializer;
import de.esolutions.fw.comm.dsi.global.impl.CarBCCurrentRangeSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.careco.BCmEConsumerList;
import org.dsi.ifc.careco.BCmEConsumerListConsumptionRA0;
import org.dsi.ifc.careco.BCmEConsumerListConsumptionRA1;
import org.dsi.ifc.careco.BCmEConsumerListRangeRA0;
import org.dsi.ifc.careco.BCmEConsumerListRangeRA1;
import org.dsi.ifc.careco.BCmEConsumerListRangeRA2;
import org.dsi.ifc.careco.BCmECurrentRange;
import org.dsi.ifc.careco.BCmEEnergyFlowComfort;
import org.dsi.ifc.careco.BCmEListUpdateInfo;
import org.dsi.ifc.careco.BCmERangeGainTotal;
import org.dsi.ifc.careco.BCmEViewOptions;
import org.dsi.ifc.careco.EAViewOptions;
import org.dsi.ifc.careco.RangeDataResidualEnergy;
import org.dsi.ifc.careco.RangeDataViewOptions;
import org.dsi.ifc.careco.StartStopListUpdateInfo;
import org.dsi.ifc.careco.StartStopProhibitList;
import org.dsi.ifc.careco.StartStopRestartList;
import org.dsi.ifc.careco.StartStopRestartProhibitList;
import org.dsi.ifc.careco.StartStopViewOptions;
import org.dsi.ifc.global.CarBCConsumption;
import org.dsi.ifc.global.CarBCCurrentRange;

public class DSICarEcoReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.dsi.careco.DSICarEco");
    private static int dynamicHandle = 0;
    private DSICarEcoReply p_DSICarEcoReply;

    public DSICarEcoReplyService(DSICarEcoReply dSICarEcoReply) {
        super(new ServiceInstanceID("c0f3be5b-817e-5a0c-b1a2-8c438d97a242", DSICarEcoReplyService.nextDynamicHandle(), "cd0ec0e9-11a1-57f4-9385-56d694cbab95", "dsi.careco.DSICarEco"));
        this.p_DSICarEcoReply = dSICarEcoReply;
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
                case 85: {
                    BCmEViewOptions bCmEViewOptions = BCmEViewOptionsSerializer.getOptionalBCmEViewOptions(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarEcoReply.updateBCmEViewOptions(bCmEViewOptions, n);
                    break;
                }
                case 104: {
                    BCmEListUpdateInfo bCmEListUpdateInfo = BCmEListUpdateInfoSerializer.getOptionalBCmEListUpdateInfo(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarEcoReply.updateBCmEListUpdateInfo(bCmEListUpdateInfo, n);
                    break;
                }
                case 20: {
                    int n = iDeserializer.getInt32();
                    int n2 = iDeserializer.getInt32();
                    int n3 = iDeserializer.getInt32();
                    int n4 = iDeserializer.getInt32();
                    this.p_DSICarEcoReply.updateBCmEConsumption(n, n2, n3, n4);
                    break;
                }
                case 22: {
                    int n = iDeserializer.getInt32();
                    boolean bl = iDeserializer.getBool();
                    int n5 = iDeserializer.getInt32();
                    this.p_DSICarEcoReply.updateBCmELiveTip(n, bl, n5);
                    break;
                }
                case 94: {
                    BCmEListUpdateInfo bCmEListUpdateInfo = BCmEListUpdateInfoSerializer.getOptionalBCmEListUpdateInfo(iDeserializer);
                    BCmEConsumerList[] bCmEConsumerListArray = BCmEConsumerListSerializer.getOptionalBCmEConsumerListVarArray(iDeserializer);
                    this.p_DSICarEcoReply.responseBCmEConsumerList(bCmEListUpdateInfo, bCmEConsumerListArray);
                    break;
                }
                case 0: {
                    boolean bl = iDeserializer.getBool();
                    this.p_DSICarEcoReply.acknowledgeBcmeSetFactoryDefault(bl);
                    break;
                }
                case 46: {
                    StartStopListUpdateInfo startStopListUpdateInfo = StartStopListUpdateInfoSerializer.getOptionalStartStopListUpdateInfo(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarEcoReply.updateStartStopProhibitReasonListUpdateInfo(startStopListUpdateInfo, n);
                    break;
                }
                case 11: {
                    StartStopListUpdateInfo startStopListUpdateInfo = StartStopListUpdateInfoSerializer.getOptionalStartStopListUpdateInfo(iDeserializer);
                    StartStopProhibitList[] startStopProhibitListArray = StartStopProhibitListSerializer.getOptionalStartStopProhibitListVarArray(iDeserializer);
                    this.p_DSICarEcoReply.responseStartStopProhibitReasonList(startStopListUpdateInfo, startStopProhibitListArray);
                    break;
                }
                case 50: {
                    StartStopListUpdateInfo startStopListUpdateInfo = StartStopListUpdateInfoSerializer.getOptionalStartStopListUpdateInfo(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarEcoReply.updateStartStopRestartReasonListUpdateInfo(startStopListUpdateInfo, n);
                    break;
                }
                case 13: {
                    StartStopListUpdateInfo startStopListUpdateInfo = StartStopListUpdateInfoSerializer.getOptionalStartStopListUpdateInfo(iDeserializer);
                    StartStopRestartList[] startStopRestartListArray = StartStopRestartListSerializer.getOptionalStartStopRestartListVarArray(iDeserializer);
                    this.p_DSICarEcoReply.responseStartStopRestartReasonList(startStopListUpdateInfo, startStopRestartListArray);
                    break;
                }
                case 48: {
                    StartStopListUpdateInfo startStopListUpdateInfo = StartStopListUpdateInfoSerializer.getOptionalStartStopListUpdateInfo(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarEcoReply.updateStartStopRestartProhibitReasonListUpdateInfo(startStopListUpdateInfo, n);
                    break;
                }
                case 12: {
                    StartStopListUpdateInfo startStopListUpdateInfo = StartStopListUpdateInfoSerializer.getOptionalStartStopListUpdateInfo(iDeserializer);
                    StartStopRestartProhibitList[] startStopRestartProhibitListArray = StartStopRestartProhibitListSerializer.getOptionalStartStopRestartProhibitListVarArray(iDeserializer);
                    this.p_DSICarEcoReply.responseStartStopRestartProhibitReasonList(startStopListUpdateInfo, startStopRestartProhibitListArray);
                    break;
                }
                case 51: {
                    int n = iDeserializer.getInt32();
                    int n6 = iDeserializer.getInt32();
                    this.p_DSICarEcoReply.updateStartStopState(n, n6);
                    break;
                }
                case 45: {
                    int n = iDeserializer.getInt32();
                    int n7 = iDeserializer.getInt32();
                    this.p_DSICarEcoReply.updateStartStopProhibitReasonListTotalNumberOfElements(n, n7);
                    break;
                }
                case 49: {
                    int n = iDeserializer.getInt32();
                    int n8 = iDeserializer.getInt32();
                    this.p_DSICarEcoReply.updateStartStopRestartReasonListTotalNumberOfElements(n, n8);
                    break;
                }
                case 47: {
                    int n = iDeserializer.getInt32();
                    int n9 = iDeserializer.getInt32();
                    this.p_DSICarEcoReply.updateStartStopRestartProhibitReasonListTotalNumberOfElements(n, n9);
                    break;
                }
                case 106: {
                    StartStopViewOptions startStopViewOptions = StartStopViewOptionsSerializer.getOptionalStartStopViewOptions(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarEcoReply.updateStartStopViewOptions(startStopViewOptions, n);
                    break;
                }
                case 105: {
                    int n = iDeserializer.getInt32();
                    int n10 = iDeserializer.getInt32();
                    this.p_DSICarEcoReply.updateStartStopCollectedReasons(n, n10);
                    break;
                }
                case 44: {
                    RangeDataViewOptions rangeDataViewOptions = RangeDataViewOptionsSerializer.getOptionalRangeDataViewOptions(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarEcoReply.updateRDViewOptions(rangeDataViewOptions, n);
                    break;
                }
                case 34: {
                    CarBCConsumption carBCConsumption = CarBCConsumptionSerializer.getOptionalCarBCConsumption(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarEcoReply.updateRDConsumptionMotorway1(carBCConsumption, n);
                    break;
                }
                case 35: {
                    CarBCConsumption carBCConsumption = CarBCConsumptionSerializer.getOptionalCarBCConsumption(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarEcoReply.updateRDConsumptionMotorway2(carBCConsumption, n);
                    break;
                }
                case 30: {
                    CarBCConsumption carBCConsumption = CarBCConsumptionSerializer.getOptionalCarBCConsumption(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarEcoReply.updateRDConsumptionHighway1(carBCConsumption, n);
                    break;
                }
                case 31: {
                    CarBCConsumption carBCConsumption = CarBCConsumptionSerializer.getOptionalCarBCConsumption(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarEcoReply.updateRDConsumptionHighway2(carBCConsumption, n);
                    break;
                }
                case 26: {
                    CarBCConsumption carBCConsumption = CarBCConsumptionSerializer.getOptionalCarBCConsumption(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarEcoReply.updateRDConsumptionCountryRoad1(carBCConsumption, n);
                    break;
                }
                case 27: {
                    CarBCConsumption carBCConsumption = CarBCConsumptionSerializer.getOptionalCarBCConsumption(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarEcoReply.updateRDConsumptionCountryRoad2(carBCConsumption, n);
                    break;
                }
                case 28: {
                    CarBCConsumption carBCConsumption = CarBCConsumptionSerializer.getOptionalCarBCConsumption(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarEcoReply.updateRDConsumptionDistrictRoad1(carBCConsumption, n);
                    break;
                }
                case 29: {
                    CarBCConsumption carBCConsumption = CarBCConsumptionSerializer.getOptionalCarBCConsumption(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarEcoReply.updateRDConsumptionDistrictRoad2(carBCConsumption, n);
                    break;
                }
                case 32: {
                    CarBCConsumption carBCConsumption = CarBCConsumptionSerializer.getOptionalCarBCConsumption(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarEcoReply.updateRDConsumptionLocalRoad1(carBCConsumption, n);
                    break;
                }
                case 33: {
                    CarBCConsumption carBCConsumption = CarBCConsumptionSerializer.getOptionalCarBCConsumption(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarEcoReply.updateRDConsumptionLocalRoad2(carBCConsumption, n);
                    break;
                }
                case 36: {
                    CarBCConsumption carBCConsumption = CarBCConsumptionSerializer.getOptionalCarBCConsumption(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarEcoReply.updateRDConsumptionRuralRoad1(carBCConsumption, n);
                    break;
                }
                case 37: {
                    CarBCConsumption carBCConsumption = CarBCConsumptionSerializer.getOptionalCarBCConsumption(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarEcoReply.updateRDConsumptionRuralRoad2(carBCConsumption, n);
                    break;
                }
                case 38: {
                    CarBCConsumption carBCConsumption = CarBCConsumptionSerializer.getOptionalCarBCConsumption(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarEcoReply.updateRDConsumptionUnclassifiedRoad1(carBCConsumption, n);
                    break;
                }
                case 39: {
                    CarBCConsumption carBCConsumption = CarBCConsumptionSerializer.getOptionalCarBCConsumption(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarEcoReply.updateRDConsumptionUnclassifiedRoad2(carBCConsumption, n);
                    break;
                }
                case 40: {
                    CarBCCurrentRange carBCCurrentRange = CarBCCurrentRangeSerializer.getOptionalCarBCCurrentRange(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarEcoReply.updateRDMaxRange1(carBCCurrentRange, n);
                    break;
                }
                case 41: {
                    CarBCCurrentRange carBCCurrentRange = CarBCCurrentRangeSerializer.getOptionalCarBCCurrentRange(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarEcoReply.updateRDMaxRange2(carBCCurrentRange, n);
                    break;
                }
                case 42: {
                    RangeDataResidualEnergy rangeDataResidualEnergy = RangeDataResidualEnergySerializer.getOptionalRangeDataResidualEnergy(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarEcoReply.updateRDResidualEnergy1(rangeDataResidualEnergy, n);
                    break;
                }
                case 43: {
                    RangeDataResidualEnergy rangeDataResidualEnergy = RangeDataResidualEnergySerializer.getOptionalRangeDataResidualEnergy(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarEcoReply.updateRDResidualEnergy2(rangeDataResidualEnergy, n);
                    break;
                }
                case 1: {
                    boolean bl = iDeserializer.getBool();
                    this.p_DSICarEcoReply.acknowledgeRDSetFactoryDefault(bl);
                    break;
                }
                case 102: {
                    BCmEListUpdateInfo bCmEListUpdateInfo = BCmEListUpdateInfoSerializer.getOptionalBCmEListUpdateInfo(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarEcoReply.updateBCmEConsumerListConsumptionUpdateInfo(bCmEListUpdateInfo, n);
                    break;
                }
                case 103: {
                    BCmEListUpdateInfo bCmEListUpdateInfo = BCmEListUpdateInfoSerializer.getOptionalBCmEListUpdateInfo(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarEcoReply.updateBCmEConsumerListRangeUpdateInfo(bCmEListUpdateInfo, n);
                    break;
                }
                case 72: {
                    BCmEEnergyFlowComfort bCmEEnergyFlowComfort = BCmEEnergyFlowComfortSerializer.getOptionalBCmEEnergyFlowComfort(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarEcoReply.updateBCmEEnergyFlowComfort(bCmEEnergyFlowComfort, n);
                    break;
                }
                case 74: {
                    BCmERangeGainTotal bCmERangeGainTotal = BCmERangeGainTotalSerializer.getOptionalBCmERangeGainTotal(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarEcoReply.updateBCmERangeGainTotal(bCmERangeGainTotal, n);
                    break;
                }
                case 95: {
                    BCmEListUpdateInfo bCmEListUpdateInfo = BCmEListUpdateInfoSerializer.getOptionalBCmEListUpdateInfo(iDeserializer);
                    BCmEConsumerListConsumptionRA0[] bCmEConsumerListConsumptionRA0Array = BCmEConsumerListConsumptionRA0Serializer.getOptionalBCmEConsumerListConsumptionRA0VarArray(iDeserializer);
                    this.p_DSICarEcoReply.responseBCmEConsumerListConsumptionRA0(bCmEListUpdateInfo, bCmEConsumerListConsumptionRA0Array);
                    break;
                }
                case 96: {
                    BCmEListUpdateInfo bCmEListUpdateInfo = BCmEListUpdateInfoSerializer.getOptionalBCmEListUpdateInfo(iDeserializer);
                    BCmEConsumerListConsumptionRA1[] bCmEConsumerListConsumptionRA1Array = BCmEConsumerListConsumptionRA1Serializer.getOptionalBCmEConsumerListConsumptionRA1VarArray(iDeserializer);
                    this.p_DSICarEcoReply.responseBCmEConsumerListConsumptionRA1(bCmEListUpdateInfo, bCmEConsumerListConsumptionRA1Array);
                    break;
                }
                case 97: {
                    BCmEListUpdateInfo bCmEListUpdateInfo = BCmEListUpdateInfoSerializer.getOptionalBCmEListUpdateInfo(iDeserializer);
                    int[] nArray = iDeserializer.getOptionalInt32VarArray();
                    this.p_DSICarEcoReply.responseBCmEConsumerListConsumptionRAF(bCmEListUpdateInfo, nArray);
                    break;
                }
                case 98: {
                    BCmEListUpdateInfo bCmEListUpdateInfo = BCmEListUpdateInfoSerializer.getOptionalBCmEListUpdateInfo(iDeserializer);
                    BCmEConsumerListRangeRA0[] bCmEConsumerListRangeRA0Array = BCmEConsumerListRangeRA0Serializer.getOptionalBCmEConsumerListRangeRA0VarArray(iDeserializer);
                    this.p_DSICarEcoReply.responseBCmEConsumerListRangeRA0(bCmEListUpdateInfo, bCmEConsumerListRangeRA0Array);
                    break;
                }
                case 99: {
                    BCmEListUpdateInfo bCmEListUpdateInfo = BCmEListUpdateInfoSerializer.getOptionalBCmEListUpdateInfo(iDeserializer);
                    BCmEConsumerListRangeRA1[] bCmEConsumerListRangeRA1Array = BCmEConsumerListRangeRA1Serializer.getOptionalBCmEConsumerListRangeRA1VarArray(iDeserializer);
                    this.p_DSICarEcoReply.responseBCmEConsumerListRangeRA1(bCmEListUpdateInfo, bCmEConsumerListRangeRA1Array);
                    break;
                }
                case 100: {
                    BCmEListUpdateInfo bCmEListUpdateInfo = BCmEListUpdateInfoSerializer.getOptionalBCmEListUpdateInfo(iDeserializer);
                    BCmEConsumerListRangeRA2[] bCmEConsumerListRangeRA2Array = BCmEConsumerListRangeRA2Serializer.getOptionalBCmEConsumerListRangeRA2VarArray(iDeserializer);
                    this.p_DSICarEcoReply.responseBCmEConsumerListRangeRA2(bCmEListUpdateInfo, bCmEConsumerListRangeRA2Array);
                    break;
                }
                case 101: {
                    BCmEListUpdateInfo bCmEListUpdateInfo = BCmEListUpdateInfoSerializer.getOptionalBCmEListUpdateInfo(iDeserializer);
                    int[] nArray = iDeserializer.getOptionalInt32VarArray();
                    this.p_DSICarEcoReply.responseBCmEConsumerListRangeRAF(bCmEListUpdateInfo, nArray);
                    break;
                }
                case 71: {
                    BCmECurrentRange bCmECurrentRange = BCmECurrentRangeSerializer.getOptionalBCmECurrentRange(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarEcoReply.updateBCmECurrentRange(bCmECurrentRange, n);
                    break;
                }
                case 70: {
                    int n = iDeserializer.getInt32();
                    int n11 = iDeserializer.getInt32();
                    this.p_DSICarEcoReply.updateBCmEConsumerListTotalNumberOfElements(n, n11);
                    break;
                }
                case 66: {
                    int n = iDeserializer.getInt32();
                    int n12 = iDeserializer.getInt32();
                    this.p_DSICarEcoReply.updateBCmEConsumerListConsumptionTotalNumberOfElements(n, n12);
                    break;
                }
                case 68: {
                    int n = iDeserializer.getInt32();
                    int n13 = iDeserializer.getInt32();
                    this.p_DSICarEcoReply.updateBCmEConsumerListRangeTotalNumberOfElements(n, n13);
                    break;
                }
                case 84: {
                    int n = iDeserializer.getInt32();
                    int n14 = iDeserializer.getInt32();
                    int n15 = iDeserializer.getInt32();
                    int n16 = iDeserializer.getInt32();
                    this.p_DSICarEcoReply.updateBCmECurrentRangeSOC(n, n14, n15, n16);
                    break;
                }
                case 83: {
                    int n = iDeserializer.getInt32();
                    int n17 = iDeserializer.getInt32();
                    int n18 = iDeserializer.getInt32();
                    int n19 = iDeserializer.getInt32();
                    this.p_DSICarEcoReply.updateBCmECatalogueRange(n, n17, n18, n19);
                    break;
                }
                case 90: {
                    EAViewOptions eAViewOptions = EAViewOptionsSerializer.getOptionalEAViewOptions(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarEcoReply.updateEAViewOptions(eAViewOptions, n);
                    break;
                }
                case 81: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarEcoReply.updateEASystem(bl, n);
                    break;
                }
                case 80: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarEcoReply.updateEAPedalJerk(bl, n);
                    break;
                }
                case 76: {
                    boolean bl = iDeserializer.getBool();
                    this.p_DSICarEcoReply.acknowledgeEASetFactoryDefault(bl);
                    break;
                }
                case 88: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarEcoReply.updateEAFreeWheeling(bl, n);
                    break;
                }
                case 89: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarEcoReply.updateEAStartStop(bl, n);
                    break;
                }
                case 2: {
                    int n = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    int n20 = iDeserializer.getInt32();
                    this.p_DSICarEcoReply.asyncException(n, string, n20);
                    break;
                }
                case 53: {
                    String string = iDeserializer.getOptionalString();
                    String string2 = iDeserializer.getOptionalString();
                    this.p_DSICarEcoReply.yyIndication(string, string2);
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

