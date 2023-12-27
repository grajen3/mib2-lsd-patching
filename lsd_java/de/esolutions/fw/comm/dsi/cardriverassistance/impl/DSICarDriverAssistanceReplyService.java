/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.cardriverassistance.impl;

import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.cardriverassistance.DSICarDriverAssistanceReply;
import de.esolutions.fw.comm.dsi.cardriverassistance.impl.ACCDistanceWarningSerializer;
import de.esolutions.fw.comm.dsi.cardriverassistance.impl.ACCViewOptionsSerializer;
import de.esolutions.fw.comm.dsi.cardriverassistance.impl.AWVEmergencyBrakeSerializer;
import de.esolutions.fw.comm.dsi.cardriverassistance.impl.AWVViewOptionsSerializer;
import de.esolutions.fw.comm.dsi.cardriverassistance.impl.FTASensorDataSerializer;
import de.esolutions.fw.comm.dsi.cardriverassistance.impl.FTAViewOptionsSerializer;
import de.esolutions.fw.comm.dsi.cardriverassistance.impl.LDWHCAViewOptionsSerializer;
import de.esolutions.fw.comm.dsi.cardriverassistance.impl.MKEViewOptionsSerializer;
import de.esolutions.fw.comm.dsi.cardriverassistance.impl.NVObjectDetectionSerializer;
import de.esolutions.fw.comm.dsi.cardriverassistance.impl.NVViewOptionsSerializer;
import de.esolutions.fw.comm.dsi.cardriverassistance.impl.PAViewOptionsSerializer;
import de.esolutions.fw.comm.dsi.cardriverassistance.impl.SWARCTASensorDataSerializer;
import de.esolutions.fw.comm.dsi.cardriverassistance.impl.SWAViewOptionsSerializer;
import de.esolutions.fw.comm.dsi.cardriverassistance.impl.TSDRoadSignFilterSerializer;
import de.esolutions.fw.comm.dsi.cardriverassistance.impl.TSDSignFctSerializer;
import de.esolutions.fw.comm.dsi.cardriverassistance.impl.TSDSystemMessagesSerializer;
import de.esolutions.fw.comm.dsi.cardriverassistance.impl.TSDViewOptionsSerializer;
import de.esolutions.fw.comm.dsi.global.impl.CarBCConsumptionSerializer;
import de.esolutions.fw.comm.dsi.global.impl.CarBCSpeedSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.cardriverassistance.ACCDistanceWarning;
import org.dsi.ifc.cardriverassistance.ACCViewOptions;
import org.dsi.ifc.cardriverassistance.AWVEmergencyBrake;
import org.dsi.ifc.cardriverassistance.AWVViewOptions;
import org.dsi.ifc.cardriverassistance.FTASensorData;
import org.dsi.ifc.cardriverassistance.FTAViewOptions;
import org.dsi.ifc.cardriverassistance.LDWHCAViewOptions;
import org.dsi.ifc.cardriverassistance.MKEViewOptions;
import org.dsi.ifc.cardriverassistance.NVObjectDetection;
import org.dsi.ifc.cardriverassistance.NVViewOptions;
import org.dsi.ifc.cardriverassistance.PAViewOptions;
import org.dsi.ifc.cardriverassistance.SWARCTASensorData;
import org.dsi.ifc.cardriverassistance.SWAViewOptions;
import org.dsi.ifc.cardriverassistance.TSDRoadSignFilter;
import org.dsi.ifc.cardriverassistance.TSDSignFct;
import org.dsi.ifc.cardriverassistance.TSDSystemMessages;
import org.dsi.ifc.cardriverassistance.TSDViewOptions;
import org.dsi.ifc.global.CarBCConsumption;
import org.dsi.ifc.global.CarBCSpeed;

public class DSICarDriverAssistanceReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.dsi.cardriverassistance.DSICarDriverAssistance");
    private static int dynamicHandle = 0;
    private DSICarDriverAssistanceReply p_DSICarDriverAssistanceReply;

    public DSICarDriverAssistanceReplyService(DSICarDriverAssistanceReply dSICarDriverAssistanceReply) {
        super(new ServiceInstanceID("1b8b4cb5-341f-5615-b7d8-31e37f3889c7", DSICarDriverAssistanceReplyService.nextDynamicHandle(), "af7b3820-5766-5f83-9d75-8c232c3d0d2e", "dsi.cardriverassistance.DSICarDriverAssistance"));
        this.p_DSICarDriverAssistanceReply = dSICarDriverAssistanceReply;
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
                case 162: {
                    ACCViewOptions aCCViewOptions = ACCViewOptionsSerializer.getOptionalACCViewOptions(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarDriverAssistanceReply.updateACCViewOptions(aCCViewOptions, n);
                    break;
                }
                case 48: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarDriverAssistanceReply.updateACCGongState(bl, n);
                    break;
                }
                case 49: {
                    int n = iDeserializer.getInt32();
                    int n2 = iDeserializer.getInt32();
                    this.p_DSICarDriverAssistanceReply.updateACCGongVolume(n, n2);
                    break;
                }
                case 47: {
                    int n = iDeserializer.getInt32();
                    int n3 = iDeserializer.getInt32();
                    this.p_DSICarDriverAssistanceReply.updateACCDrivingProgram(n, n3);
                    break;
                }
                case 50: {
                    int n = iDeserializer.getInt32();
                    int n4 = iDeserializer.getInt32();
                    this.p_DSICarDriverAssistanceReply.updateACCTimeGap(n, n4);
                    break;
                }
                case 46: {
                    int n = iDeserializer.getInt32();
                    int n5 = iDeserializer.getInt32();
                    this.p_DSICarDriverAssistanceReply.updateACCDefaultMode(n, n5);
                    break;
                }
                case 117: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarDriverAssistanceReply.updateACCCurveAssist(bl, n);
                    break;
                }
                case 119: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarDriverAssistanceReply.updateACCSpeedLimitAdoption(bl, n);
                    break;
                }
                case 121: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarDriverAssistanceReply.updateACCTrafficJamAssist(bl, n);
                    break;
                }
                case 145: {
                    int n = iDeserializer.getInt32();
                    int n6 = iDeserializer.getInt32();
                    this.p_DSICarDriverAssistanceReply.updateACCSpeedLimitOffset(n, n6);
                    break;
                }
                case 118: {
                    ACCDistanceWarning aCCDistanceWarning = ACCDistanceWarningSerializer.getOptionalACCDistanceWarning(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarDriverAssistanceReply.updateACCDistanceWarning(aCCDistanceWarning, n);
                    break;
                }
                case 168: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarDriverAssistanceReply.updatePACCSensibility(bl, n);
                    break;
                }
                case 165: {
                    CarBCSpeed carBCSpeed = CarBCSpeedSerializer.getOptionalCarBCSpeed(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarDriverAssistanceReply.updatePACCMaxSpeed(carBCSpeed, n);
                    break;
                }
                case 167: {
                    CarBCSpeed carBCSpeed = CarBCSpeedSerializer.getOptionalCarBCSpeed(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarDriverAssistanceReply.updatePACCMeanVelocity(carBCSpeed, n);
                    break;
                }
                case 166: {
                    CarBCConsumption carBCConsumption = CarBCConsumptionSerializer.getOptionalCarBCConsumption(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarDriverAssistanceReply.updatePACCMeanConsumption(carBCConsumption, n);
                    break;
                }
                case 163: {
                    int n = iDeserializer.getInt32();
                    int n7 = iDeserializer.getInt32();
                    this.p_DSICarDriverAssistanceReply.updatePACCCoastingPercentage(n, n7);
                    break;
                }
                case 164: {
                    int n = iDeserializer.getInt32();
                    int n8 = iDeserializer.getInt32();
                    this.p_DSICarDriverAssistanceReply.updatePACCDrivingProgram(n, n8);
                    break;
                }
                case 169: {
                    int n = iDeserializer.getInt32();
                    int n9 = iDeserializer.getInt32();
                    this.p_DSICarDriverAssistanceReply.updatePACCSystemState(n, n9);
                    break;
                }
                case 94: {
                    boolean bl = iDeserializer.getBool();
                    this.p_DSICarDriverAssistanceReply.acknowledgeACCSetFactoryDefault(bl);
                    break;
                }
                case 53: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarDriverAssistanceReply.updateAWVDistanceWarning(bl, n);
                    break;
                }
                case 150: {
                    AWVViewOptions aWVViewOptions = AWVViewOptionsSerializer.getOptionalAWVViewOptions(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarDriverAssistanceReply.updateAWVViewOptions(aWVViewOptions, n);
                    break;
                }
                case 57: {
                    int n = iDeserializer.getInt32();
                    int n10 = iDeserializer.getInt32();
                    this.p_DSICarDriverAssistanceReply.updateAWVSystem(n, n10);
                    break;
                }
                case 59: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarDriverAssistanceReply.updateAWVWarning(bl, n);
                    break;
                }
                case 55: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarDriverAssistanceReply.updateAWVGong(bl, n);
                    break;
                }
                case 56: {
                    int n = iDeserializer.getInt32();
                    int n11 = iDeserializer.getInt32();
                    this.p_DSICarDriverAssistanceReply.updateAWVGongVolume(n, n11);
                    break;
                }
                case 52: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarDriverAssistanceReply.updateAWVBrakeJerk(bl, n);
                    break;
                }
                case 54: {
                    AWVEmergencyBrake aWVEmergencyBrake = AWVEmergencyBrakeSerializer.getOptionalAWVEmergencyBrake(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarDriverAssistanceReply.updateAWVEmergencyBrake(aWVEmergencyBrake, n);
                    break;
                }
                case 151: {
                    int n = iDeserializer.getInt32();
                    int n12 = iDeserializer.getInt32();
                    this.p_DSICarDriverAssistanceReply.updateAWVWarningTimegap(n, n12);
                    break;
                }
                case 146: {
                    boolean bl = iDeserializer.getBool();
                    this.p_DSICarDriverAssistanceReply.acknowledgeAWVSetFactoryDefault(bl);
                    break;
                }
                case 136: {
                    SWAViewOptions sWAViewOptions = SWAViewOptionsSerializer.getOptionalSWAViewOptions(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarDriverAssistanceReply.updateSWAViewOptions(sWAViewOptions, n);
                    break;
                }
                case 78: {
                    int n = iDeserializer.getInt32();
                    int n13 = iDeserializer.getInt32();
                    this.p_DSICarDriverAssistanceReply.updateSWABrightness(n, n13);
                    break;
                }
                case 84: {
                    int n = iDeserializer.getInt32();
                    int n14 = iDeserializer.getInt32();
                    this.p_DSICarDriverAssistanceReply.updateSWAWarningTime(n, n14);
                    break;
                }
                case 79: {
                    int n = iDeserializer.getInt32();
                    int n15 = iDeserializer.getInt32();
                    this.p_DSICarDriverAssistanceReply.updateSWAFrequency(n, n15);
                    break;
                }
                case 82: {
                    int n = iDeserializer.getInt32();
                    int n16 = iDeserializer.getInt32();
                    this.p_DSICarDriverAssistanceReply.updateSWASystem(n, n16);
                    break;
                }
                case 80: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarDriverAssistanceReply.updateSWAGongState(bl, n);
                    break;
                }
                case 81: {
                    int n = iDeserializer.getInt32();
                    int n17 = iDeserializer.getInt32();
                    this.p_DSICarDriverAssistanceReply.updateSWAGongVolume(n, n17);
                    break;
                }
                case 135: {
                    SWARCTASensorData sWARCTASensorData = SWARCTASensorDataSerializer.getOptionalSWARCTASensorData(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarDriverAssistanceReply.updateSWARCTASensorData(sWARCTASensorData, n);
                    break;
                }
                case 134: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarDriverAssistanceReply.updateSWARCTA(bl, n);
                    break;
                }
                case 133: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarDriverAssistanceReply.updateSWAExitAssist(bl, n);
                    break;
                }
                case 183: {
                    NVViewOptions nVViewOptions = NVViewOptionsSerializer.getOptionalNVViewOptions(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarDriverAssistanceReply.updateNVViewOptions(nVViewOptions, n);
                    break;
                }
                case 67: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarDriverAssistanceReply.updateNVActivation(bl, n);
                    break;
                }
                case 70: {
                    int n = iDeserializer.getInt32();
                    int n18 = iDeserializer.getInt32();
                    this.p_DSICarDriverAssistanceReply.updateNVContrast(n, n18);
                    break;
                }
                case 68: {
                    int n = iDeserializer.getInt32();
                    int n19 = iDeserializer.getInt32();
                    this.p_DSICarDriverAssistanceReply.updateNVBrightness(n, n19);
                    break;
                }
                case 127: {
                    NVObjectDetection nVObjectDetection = NVObjectDetectionSerializer.getOptionalNVObjectDetection(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarDriverAssistanceReply.updateNVObjectDetection(nVObjectDetection, n);
                    break;
                }
                case 69: {
                    int n = iDeserializer.getInt32();
                    int n20 = iDeserializer.getInt32();
                    this.p_DSICarDriverAssistanceReply.updateNVColorPA(n, n20);
                    break;
                }
                case 71: {
                    int n = iDeserializer.getInt32();
                    int n21 = iDeserializer.getInt32();
                    this.p_DSICarDriverAssistanceReply.updateNVDesignPA(n, n21);
                    break;
                }
                case 72: {
                    int n = iDeserializer.getInt32();
                    int n22 = iDeserializer.getInt32();
                    this.p_DSICarDriverAssistanceReply.updateNVDisplay(n, n22);
                    break;
                }
                case 77: {
                    int n = iDeserializer.getInt32();
                    int n23 = iDeserializer.getInt32();
                    this.p_DSICarDriverAssistanceReply.updateNVZoomPanning(n, n23);
                    break;
                }
                case 74: {
                    int n = iDeserializer.getInt32();
                    int n24 = iDeserializer.getInt32();
                    this.p_DSICarDriverAssistanceReply.updateNVSound(n, n24);
                    break;
                }
                case 75: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarDriverAssistanceReply.updateNVSymbol(bl, n);
                    break;
                }
                case 170: {
                    boolean bl = iDeserializer.getBool();
                    this.p_DSICarDriverAssistanceReply.acknowledgeNVSetFactoryDefault(bl);
                    break;
                }
                case 182: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarDriverAssistanceReply.updateNVSystem(bl, n);
                    break;
                }
                case 184: {
                    int n = iDeserializer.getInt32();
                    int n25 = iDeserializer.getInt32();
                    this.p_DSICarDriverAssistanceReply.updateNVWarningTimegap(n, n25);
                    break;
                }
                case 180: {
                    LDWHCAViewOptions lDWHCAViewOptions = LDWHCAViewOptionsSerializer.getOptionalLDWHCAViewOptions(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarDriverAssistanceReply.updateLDWHCAViewOptions(lDWHCAViewOptions, n);
                    break;
                }
                case 64: {
                    int n = iDeserializer.getInt32();
                    int n26 = iDeserializer.getInt32();
                    this.p_DSICarDriverAssistanceReply.updateLDWWarningTime(n, n26);
                    break;
                }
                case 63: {
                    int n = iDeserializer.getInt32();
                    int n27 = iDeserializer.getInt32();
                    this.p_DSICarDriverAssistanceReply.updateLDWSteeringWheelVibration(n, n27);
                    break;
                }
                case 60: {
                    int n = iDeserializer.getInt32();
                    int n28 = iDeserializer.getInt32();
                    this.p_DSICarDriverAssistanceReply.updateHCAInterventionStyle(n, n28);
                    break;
                }
                case 61: {
                    int n = iDeserializer.getInt32();
                    int n29 = iDeserializer.getInt32();
                    this.p_DSICarDriverAssistanceReply.updateHCAToleranceLevel(n, n29);
                    break;
                }
                case 0: {
                    boolean bl = iDeserializer.getBool();
                    this.p_DSICarDriverAssistanceReply.acknowledgeLdwhcaSetFactoryDefault(bl);
                    break;
                }
                case 124: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarDriverAssistanceReply.updateLDWHCASystemOnOff(bl, n);
                    break;
                }
                case 181: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    int n30 = iDeserializer.getInt32();
                    this.p_DSICarDriverAssistanceReply.updateLDWHCAWarningSound(bl, n, n30);
                    break;
                }
                case 191: {
                    TSDViewOptions tSDViewOptions = TSDViewOptionsSerializer.getOptionalTSDViewOptions(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarDriverAssistanceReply.updateTSDViewOptions(tSDViewOptions, n);
                    break;
                }
                case 89: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarDriverAssistanceReply.updateTSDSystemOnOff(bl, n);
                    break;
                }
                case 90: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarDriverAssistanceReply.updateTSDTrailerDetection(bl, n);
                    break;
                }
                case 185: {
                    TSDSignFct tSDSignFct = TSDSignFctSerializer.getOptionalTSDSignFct(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarDriverAssistanceReply.updateTSDSign1(tSDSignFct, n);
                    break;
                }
                case 186: {
                    TSDSignFct tSDSignFct = TSDSignFctSerializer.getOptionalTSDSignFct(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarDriverAssistanceReply.updateTSDSign2(tSDSignFct, n);
                    break;
                }
                case 187: {
                    TSDSignFct tSDSignFct = TSDSignFctSerializer.getOptionalTSDSignFct(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarDriverAssistanceReply.updateTSDSign3(tSDSignFct, n);
                    break;
                }
                case 188: {
                    TSDSignFct tSDSignFct = TSDSignFctSerializer.getOptionalTSDSignFct(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarDriverAssistanceReply.updateTSDSign4(tSDSignFct, n);
                    break;
                }
                case 189: {
                    TSDSignFct tSDSignFct = TSDSignFctSerializer.getOptionalTSDSignFct(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarDriverAssistanceReply.updateTSDSign5(tSDSignFct, n);
                    break;
                }
                case 85: {
                    TSDRoadSignFilter tSDRoadSignFilter = TSDRoadSignFilterSerializer.getOptionalTSDRoadSignFilter(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarDriverAssistanceReply.updateTSDRoadSignFilter(tSDRoadSignFilter, n);
                    break;
                }
                case 1: {
                    boolean bl = iDeserializer.getBool();
                    this.p_DSICarDriverAssistanceReply.acknowledgeTsdSetFactoryDefault(bl);
                    break;
                }
                case 137: {
                    boolean bl = iDeserializer.getBool();
                    CarBCSpeed carBCSpeed = CarBCSpeedSerializer.getOptionalCarBCSpeed(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarDriverAssistanceReply.updateTSDSpeedWarningThreshold(bl, carBCSpeed, n);
                    break;
                }
                case 139: {
                    CarBCSpeed carBCSpeed = CarBCSpeedSerializer.getOptionalCarBCSpeed(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarDriverAssistanceReply.updateTSDTrailerSpeedLimit(carBCSpeed, n);
                    break;
                }
                case 158: {
                    TSDSystemMessages tSDSystemMessages = TSDSystemMessagesSerializer.getOptionalTSDSystemMessages(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarDriverAssistanceReply.updateTSDSystemMessages(tSDSystemMessages, n);
                    break;
                }
                case 190: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarDriverAssistanceReply.updateTSDSpeedWarningAcoustics(bl, n);
                    break;
                }
                case 126: {
                    MKEViewOptions mKEViewOptions = MKEViewOptionsSerializer.getOptionalMKEViewOptions(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarDriverAssistanceReply.updateMKEViewOptions(mKEViewOptions, n);
                    break;
                }
                case 65: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarDriverAssistanceReply.updateMKESystemOnOff(bl, n);
                    break;
                }
                case 96: {
                    boolean bl = iDeserializer.getBool();
                    this.p_DSICarDriverAssistanceReply.acknowledgeMKESetFactoryDefault(bl);
                    break;
                }
                case 152: {
                    PAViewOptions pAViewOptions = PAViewOptionsSerializer.getOptionalPAViewOptions(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarDriverAssistanceReply.updatePAViewOptions(pAViewOptions, n);
                    break;
                }
                case 131: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarDriverAssistanceReply.updatePASystemOnOff(bl, n);
                    break;
                }
                case 97: {
                    boolean bl = iDeserializer.getBool();
                    this.p_DSICarDriverAssistanceReply.acknowledgePASetFactoryDefault(bl);
                    break;
                }
                case 129: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarDriverAssistanceReply.updatePAConfigInformation(bl, n);
                    break;
                }
                case 130: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarDriverAssistanceReply.updatePAConfigWarning(bl, n);
                    break;
                }
                case 153: {
                    int n = iDeserializer.getInt32();
                    int n31 = iDeserializer.getInt32();
                    this.p_DSICarDriverAssistanceReply.updatePAWarningTimegap(n, n31);
                    break;
                }
                case 123: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarDriverAssistanceReply.updateCurveAssistSystemOnOff(bl, n);
                    break;
                }
                case 95: {
                    boolean bl = iDeserializer.getBool();
                    this.p_DSICarDriverAssistanceReply.acknowledgeCurveAssistSetFactoryDefault(bl);
                    break;
                }
                case 179: {
                    FTAViewOptions fTAViewOptions = FTAViewOptionsSerializer.getOptionalFTAViewOptions(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarDriverAssistanceReply.updateFTAViewOptions(fTAViewOptions, n);
                    break;
                }
                case 178: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarDriverAssistanceReply.updateFTASystemOnOff(bl, n);
                    break;
                }
                case 177: {
                    FTASensorData fTASensorData = FTASensorDataSerializer.getOptionalFTASensorData(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarDriverAssistanceReply.updateFTASensorData(fTASensorData, n);
                    break;
                }
                case 2: {
                    int n = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    int n32 = iDeserializer.getInt32();
                    this.p_DSICarDriverAssistanceReply.asyncException(n, string, n32);
                    break;
                }
                case 92: {
                    String string = iDeserializer.getOptionalString();
                    String string2 = iDeserializer.getOptionalString();
                    this.p_DSICarDriverAssistanceReply.yyIndication(string, string2);
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

