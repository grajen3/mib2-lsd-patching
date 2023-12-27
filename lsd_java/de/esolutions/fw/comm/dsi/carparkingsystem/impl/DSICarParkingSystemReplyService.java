/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carparkingsystem.impl;

import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.carparkingsystem.DSICarParkingSystemReply;
import de.esolutions.fw.comm.dsi.carparkingsystem.impl.ARACurrentTrailerAngleSerializer;
import de.esolutions.fw.comm.dsi.carparkingsystem.impl.ARAInfoSerializer;
import de.esolutions.fw.comm.dsi.carparkingsystem.impl.DisplayContentSerializer;
import de.esolutions.fw.comm.dsi.carparkingsystem.impl.PDCCrashWarningSerializer;
import de.esolutions.fw.comm.dsi.carparkingsystem.impl.PDCDistanceValuesFrontRearExtSerializer;
import de.esolutions.fw.comm.dsi.carparkingsystem.impl.PDCDistanceValuesFrontRearSerializer;
import de.esolutions.fw.comm.dsi.carparkingsystem.impl.PDCDistanceValuesRightLeftSerializer;
import de.esolutions.fw.comm.dsi.carparkingsystem.impl.PDCInfoSerializer;
import de.esolutions.fw.comm.dsi.carparkingsystem.impl.PDCManeuverAssistStateSerializer;
import de.esolutions.fw.comm.dsi.carparkingsystem.impl.PDCPLABargraphSerializer;
import de.esolutions.fw.comm.dsi.carparkingsystem.impl.PDCPLAStatusSerializer;
import de.esolutions.fw.comm.dsi.carparkingsystem.impl.PDCPLASystemStateSerializer;
import de.esolutions.fw.comm.dsi.carparkingsystem.impl.PDCPiloPaSystemStateSerializer;
import de.esolutions.fw.comm.dsi.carparkingsystem.impl.PDCSoundReproductionSerializer;
import de.esolutions.fw.comm.dsi.carparkingsystem.impl.PDCSoundSerializer;
import de.esolutions.fw.comm.dsi.carparkingsystem.impl.PDCStatusLevelFrontRearExtSerializer;
import de.esolutions.fw.comm.dsi.carparkingsystem.impl.PDCStatusLevelFrontRearSerializer;
import de.esolutions.fw.comm.dsi.carparkingsystem.impl.PDCStatusLevelRightLeftSerializer;
import de.esolutions.fw.comm.dsi.carparkingsystem.impl.PDCSteeringInformationSerializer;
import de.esolutions.fw.comm.dsi.carparkingsystem.impl.PDCWallDetectionSerializer;
import de.esolutions.fw.comm.dsi.carparkingsystem.impl.ParkingSystemViewOptionsSerializer;
import de.esolutions.fw.comm.dsi.carparkingsystem.impl.VPSCameraCleaningSerializer;
import de.esolutions.fw.comm.dsi.carparkingsystem.impl.VPSCameraStatesSerializer;
import de.esolutions.fw.comm.dsi.carparkingsystem.impl.VPSDefaultModeSerializer;
import de.esolutions.fw.comm.dsi.carparkingsystem.impl.VPSDynParkingModeSerializer;
import de.esolutions.fw.comm.dsi.carparkingsystem.impl.VPSOPSOverlaySerializer;
import de.esolutions.fw.comm.dsi.carparkingsystem.impl.VPSRimProtectionSerializer;
import de.esolutions.fw.comm.dsi.carparkingsystem.impl.VPSVideoInfoSerializer;
import de.esolutions.fw.comm.dsi.carparkingsystem.impl.WCPanelInfoSerializer;
import de.esolutions.fw.comm.dsi.carparkingsystem.impl.WCPanelListRecordSerializer;
import de.esolutions.fw.comm.dsi.carparkingsystem.impl.WCPinPukStateSerializer;
import de.esolutions.fw.comm.dsi.carparkingsystem.impl.WCVehiclePanelInfoSerializer;
import de.esolutions.fw.comm.dsi.carparkingsystem.impl.WCViewOptionsSerializer;
import de.esolutions.fw.comm.dsi.global.impl.CarArrayListUpdateInfoSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.carparkingsystem.ARACurrentTrailerAngle;
import org.dsi.ifc.carparkingsystem.ARAInfo;
import org.dsi.ifc.carparkingsystem.DisplayContent;
import org.dsi.ifc.carparkingsystem.PDCCrashWarning;
import org.dsi.ifc.carparkingsystem.PDCDistanceValuesFrontRear;
import org.dsi.ifc.carparkingsystem.PDCDistanceValuesFrontRearExt;
import org.dsi.ifc.carparkingsystem.PDCDistanceValuesRightLeft;
import org.dsi.ifc.carparkingsystem.PDCInfo;
import org.dsi.ifc.carparkingsystem.PDCManeuverAssistState;
import org.dsi.ifc.carparkingsystem.PDCPLABargraph;
import org.dsi.ifc.carparkingsystem.PDCPLAStatus;
import org.dsi.ifc.carparkingsystem.PDCPLASystemState;
import org.dsi.ifc.carparkingsystem.PDCPiloPaSystemState;
import org.dsi.ifc.carparkingsystem.PDCSound;
import org.dsi.ifc.carparkingsystem.PDCSoundReproduction;
import org.dsi.ifc.carparkingsystem.PDCStatusLevelFrontRear;
import org.dsi.ifc.carparkingsystem.PDCStatusLevelFrontRearExt;
import org.dsi.ifc.carparkingsystem.PDCStatusLevelRightLeft;
import org.dsi.ifc.carparkingsystem.PDCSteeringInformation;
import org.dsi.ifc.carparkingsystem.PDCWallDetection;
import org.dsi.ifc.carparkingsystem.ParkingSystemViewOptions;
import org.dsi.ifc.carparkingsystem.VPSCameraCleaning;
import org.dsi.ifc.carparkingsystem.VPSCameraStates;
import org.dsi.ifc.carparkingsystem.VPSDefaultMode;
import org.dsi.ifc.carparkingsystem.VPSDynParkingMode;
import org.dsi.ifc.carparkingsystem.VPSOPSOverlay;
import org.dsi.ifc.carparkingsystem.VPSRimProtection;
import org.dsi.ifc.carparkingsystem.VPSVideoInfo;
import org.dsi.ifc.carparkingsystem.WCPanelInfo;
import org.dsi.ifc.carparkingsystem.WCPanelListRecord;
import org.dsi.ifc.carparkingsystem.WCPinPukState;
import org.dsi.ifc.carparkingsystem.WCVehiclePanelInfo;
import org.dsi.ifc.carparkingsystem.WCViewOptions;
import org.dsi.ifc.global.CarArrayListUpdateInfo;

public class DSICarParkingSystemReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.dsi.carparkingsystem.DSICarParkingSystem");
    private static int dynamicHandle = 0;
    private DSICarParkingSystemReply p_DSICarParkingSystemReply;

    public DSICarParkingSystemReplyService(DSICarParkingSystemReply dSICarParkingSystemReply) {
        super(new ServiceInstanceID("25fd9fa4-e912-5fdd-a328-629d65736e4c", DSICarParkingSystemReplyService.nextDynamicHandle(), "d37789a1-552e-5f0f-b925-4e2178c41e40", "dsi.carparkingsystem.DSICarParkingSystem"));
        this.p_DSICarParkingSystemReply = dSICarParkingSystemReply;
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
                case 153: {
                    ParkingSystemViewOptions parkingSystemViewOptions = ParkingSystemViewOptionsSerializer.getOptionalParkingSystemViewOptions(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarParkingSystemReply.updateParkingSystemViewOptions(parkingSystemViewOptions, n);
                    break;
                }
                case 45: {
                    int n = iDeserializer.getInt32();
                    int n2 = iDeserializer.getInt32();
                    this.p_DSICarParkingSystemReply.updatePDCDefaultParkingMode(n, n2);
                    break;
                }
                case 52: {
                    int n = iDeserializer.getInt32();
                    int n3 = iDeserializer.getInt32();
                    this.p_DSICarParkingSystemReply.updatePDCFrequenceFront(n, n3);
                    break;
                }
                case 54: {
                    int n = iDeserializer.getInt32();
                    int n4 = iDeserializer.getInt32();
                    this.p_DSICarParkingSystemReply.updatePDCFrequenceRear(n, n4);
                    break;
                }
                case 55: {
                    int n = iDeserializer.getInt32();
                    int n5 = iDeserializer.getInt32();
                    this.p_DSICarParkingSystemReply.updatePDCFrequenceRight(n, n5);
                    break;
                }
                case 53: {
                    int n = iDeserializer.getInt32();
                    int n6 = iDeserializer.getInt32();
                    this.p_DSICarParkingSystemReply.updatePDCFrequenceLeft(n, n6);
                    break;
                }
                case 67: {
                    int n = iDeserializer.getInt32();
                    int n7 = iDeserializer.getInt32();
                    this.p_DSICarParkingSystemReply.updatePDCVolumeFront(n, n7);
                    break;
                }
                case 69: {
                    int n = iDeserializer.getInt32();
                    int n8 = iDeserializer.getInt32();
                    this.p_DSICarParkingSystemReply.updatePDCVolumeRear(n, n8);
                    break;
                }
                case 70: {
                    int n = iDeserializer.getInt32();
                    int n9 = iDeserializer.getInt32();
                    this.p_DSICarParkingSystemReply.updatePDCVolumeRight(n, n9);
                    break;
                }
                case 68: {
                    int n = iDeserializer.getInt32();
                    int n10 = iDeserializer.getInt32();
                    this.p_DSICarParkingSystemReply.updatePDCVolumeLeft(n, n10);
                    break;
                }
                case 57: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarParkingSystemReply.updatePDCMute(bl, n);
                    break;
                }
                case 65: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarParkingSystemReply.updatePDCSystemOnOff(bl, n);
                    break;
                }
                case 66: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarParkingSystemReply.updatePDCTrailerHitched(bl, n);
                    break;
                }
                case 46: {
                    PDCDistanceValuesFrontRear pDCDistanceValuesFrontRear = PDCDistanceValuesFrontRearSerializer.getOptionalPDCDistanceValuesFrontRear(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarParkingSystemReply.updatePDCDistanceValuesFront(pDCDistanceValuesFrontRear, n);
                    break;
                }
                case 48: {
                    PDCDistanceValuesFrontRear pDCDistanceValuesFrontRear = PDCDistanceValuesFrontRearSerializer.getOptionalPDCDistanceValuesFrontRear(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarParkingSystemReply.updatePDCDistanceValuesRear(pDCDistanceValuesFrontRear, n);
                    break;
                }
                case 49: {
                    PDCDistanceValuesRightLeft pDCDistanceValuesRightLeft = PDCDistanceValuesRightLeftSerializer.getOptionalPDCDistanceValuesRightLeft(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarParkingSystemReply.updatePDCDistanceValuesRight(pDCDistanceValuesRightLeft, n);
                    break;
                }
                case 47: {
                    PDCDistanceValuesRightLeft pDCDistanceValuesRightLeft = PDCDistanceValuesRightLeftSerializer.getOptionalPDCDistanceValuesRightLeft(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarParkingSystemReply.updatePDCDistanceValuesLeft(pDCDistanceValuesRightLeft, n);
                    break;
                }
                case 118: {
                    PDCStatusLevelFrontRear pDCStatusLevelFrontRear = PDCStatusLevelFrontRearSerializer.getOptionalPDCStatusLevelFrontRear(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarParkingSystemReply.updatePDCStatusLevelFront(pDCStatusLevelFrontRear, n);
                    break;
                }
                case 121: {
                    PDCStatusLevelFrontRear pDCStatusLevelFrontRear = PDCStatusLevelFrontRearSerializer.getOptionalPDCStatusLevelFrontRear(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarParkingSystemReply.updatePDCStatusLevelRear(pDCStatusLevelFrontRear, n);
                    break;
                }
                case 123: {
                    PDCStatusLevelRightLeft pDCStatusLevelRightLeft = PDCStatusLevelRightLeftSerializer.getOptionalPDCStatusLevelRightLeft(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarParkingSystemReply.updatePDCStatusLevelRight(pDCStatusLevelRightLeft, n);
                    break;
                }
                case 120: {
                    PDCStatusLevelRightLeft pDCStatusLevelRightLeft = PDCStatusLevelRightLeftSerializer.getOptionalPDCStatusLevelRightLeft(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarParkingSystemReply.updatePDCStatusLevelLeft(pDCStatusLevelRightLeft, n);
                    break;
                }
                case 58: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarParkingSystemReply.updatePDCOPSAutoActivation(bl, n);
                    break;
                }
                case 44: {
                    PDCCrashWarning pDCCrashWarning = PDCCrashWarningSerializer.getOptionalPDCCrashWarning(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarParkingSystemReply.updatePDCCrashWarning(pDCCrashWarning, n);
                    break;
                }
                case 64: {
                    PDCSteeringInformation pDCSteeringInformation = PDCSteeringInformationSerializer.getOptionalPDCSteeringInformation(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarParkingSystemReply.updatePDCSteeringInformation(pDCSteeringInformation, n);
                    break;
                }
                case 51: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarParkingSystemReply.updatePDCFlankGuard(bl, n);
                    break;
                }
                case 59: {
                    PDCSoundReproduction pDCSoundReproduction = PDCSoundReproductionSerializer.getOptionalPDCSoundReproduction(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarParkingSystemReply.updatePDCSoundReproduction(pDCSoundReproduction, n);
                    break;
                }
                case 56: {
                    PDCInfo pDCInfo = PDCInfoSerializer.getOptionalPDCInfo(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarParkingSystemReply.updatePDCInfo(pDCInfo, n);
                    break;
                }
                case 50: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarParkingSystemReply.updatePDCFailure(bl, n);
                    break;
                }
                case 104: {
                    PDCDistanceValuesFrontRearExt pDCDistanceValuesFrontRearExt = PDCDistanceValuesFrontRearExtSerializer.getOptionalPDCDistanceValuesFrontRearExt(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarParkingSystemReply.updatePDCDistanceValuesFrontExt(pDCDistanceValuesFrontRearExt, n);
                    break;
                }
                case 105: {
                    PDCDistanceValuesFrontRearExt pDCDistanceValuesFrontRearExt = PDCDistanceValuesFrontRearExtSerializer.getOptionalPDCDistanceValuesFrontRearExt(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarParkingSystemReply.updatePDCDistanceValuesRearExt(pDCDistanceValuesFrontRearExt, n);
                    break;
                }
                case 119: {
                    PDCStatusLevelFrontRearExt pDCStatusLevelFrontRearExt = PDCStatusLevelFrontRearExtSerializer.getOptionalPDCStatusLevelFrontRearExt(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarParkingSystemReply.updatePDCStatusLevelFrontExt(pDCStatusLevelFrontRearExt, n);
                    break;
                }
                case 122: {
                    PDCStatusLevelFrontRearExt pDCStatusLevelFrontRearExt = PDCStatusLevelFrontRearExtSerializer.getOptionalPDCStatusLevelFrontRearExt(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarParkingSystemReply.updatePDCStatusLevelRearExt(pDCStatusLevelFrontRearExt, n);
                    break;
                }
                case 124: {
                    PDCWallDetection pDCWallDetection = PDCWallDetectionSerializer.getOptionalPDCWallDetection(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarParkingSystemReply.updatePDCWallDetection(pDCWallDetection, n);
                    break;
                }
                case 109: {
                    int n = iDeserializer.getInt32();
                    int n11 = iDeserializer.getInt32();
                    this.p_DSICarParkingSystemReply.updatePDCPLAMessage(n, n11);
                    break;
                }
                case 114: {
                    PDCSound pDCSound = PDCSoundSerializer.getOptionalPDCSound(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarParkingSystemReply.updatePDCSoundFront(pDCSound, n);
                    break;
                }
                case 116: {
                    PDCSound pDCSound = PDCSoundSerializer.getOptionalPDCSound(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarParkingSystemReply.updatePDCSoundRear(pDCSound, n);
                    break;
                }
                case 115: {
                    PDCSound pDCSound = PDCSoundSerializer.getOptionalPDCSound(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarParkingSystemReply.updatePDCSoundLeft(pDCSound, n);
                    break;
                }
                case 117: {
                    PDCSound pDCSound = PDCSoundSerializer.getOptionalPDCSound(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarParkingSystemReply.updatePDCSoundRight(pDCSound, n);
                    break;
                }
                case 151: {
                    PDCPLAStatus pDCPLAStatus = PDCPLAStatusSerializer.getOptionalPDCPLAStatus(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarParkingSystemReply.updatePDCPLAStatus(pDCPLAStatus, n);
                    break;
                }
                case 108: {
                    PDCPLABargraph pDCPLABargraph = PDCPLABargraphSerializer.getOptionalPDCPLABargraph(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarParkingSystemReply.updatePDCPLABargraph(pDCPLABargraph, n);
                    break;
                }
                case 110: {
                    int n = iDeserializer.getInt32();
                    int n12 = iDeserializer.getInt32();
                    this.p_DSICarParkingSystemReply.updatePDCPLAParkmodeSelection(n, n12);
                    break;
                }
                case 112: {
                    PDCPLASystemState pDCPLASystemState = PDCPLASystemStateSerializer.getOptionalPDCPLASystemState(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarParkingSystemReply.updatePDCPLASystemState(pDCPLASystemState, n);
                    break;
                }
                case 106: {
                    int n = iDeserializer.getInt32();
                    int n13 = iDeserializer.getInt32();
                    this.p_DSICarParkingSystemReply.updatePDCOPSVisualisationPosition(n, n13);
                    break;
                }
                case 107: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarParkingSystemReply.updatePDCOffroadMode(bl, n);
                    break;
                }
                case 113: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarParkingSystemReply.updatePDCParkboxVisualisation(bl, n);
                    break;
                }
                case 83: {
                    int n = iDeserializer.getInt32();
                    int n14 = iDeserializer.getInt32();
                    this.p_DSICarParkingSystemReply.updateVPSFollowUpTime(n, n14);
                    break;
                }
                case 86: {
                    VPSVideoInfo vPSVideoInfo = VPSVideoInfoSerializer.getOptionalVPSVideoInfo(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarParkingSystemReply.updateVPSVideoInfo(vPSVideoInfo, n);
                    break;
                }
                case 74: {
                    int n = iDeserializer.getInt32();
                    int n15 = iDeserializer.getInt32();
                    this.p_DSICarParkingSystemReply.updateVPSColor(n, n15);
                    break;
                }
                case 75: {
                    int n = iDeserializer.getInt32();
                    int n16 = iDeserializer.getInt32();
                    this.p_DSICarParkingSystemReply.updateVPSContrast(n, n16);
                    break;
                }
                case 73: {
                    int n = iDeserializer.getInt32();
                    int n17 = iDeserializer.getInt32();
                    this.p_DSICarParkingSystemReply.updateVPSBrightness(n, n17);
                    break;
                }
                case 78: {
                    VPSDefaultMode vPSDefaultMode = VPSDefaultModeSerializer.getOptionalVPSDefaultMode(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarParkingSystemReply.updateVPSDefaultModeRV(vPSDefaultMode, n);
                    break;
                }
                case 79: {
                    VPSDefaultMode vPSDefaultMode = VPSDefaultModeSerializer.getOptionalVPSDefaultMode(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarParkingSystemReply.updateVPSDefaultModeSV(vPSDefaultMode, n);
                    break;
                }
                case 77: {
                    VPSDefaultMode vPSDefaultMode = VPSDefaultModeSerializer.getOptionalVPSDefaultMode(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarParkingSystemReply.updateVPSDefaultModeFV(vPSDefaultMode, n);
                    break;
                }
                case 76: {
                    VPSDefaultMode vPSDefaultMode = VPSDefaultModeSerializer.getOptionalVPSDefaultMode(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarParkingSystemReply.updateVPSDefaultModeBV(vPSDefaultMode, n);
                    break;
                }
                case 80: {
                    int n = iDeserializer.getInt32();
                    int n18 = iDeserializer.getInt32();
                    this.p_DSICarParkingSystemReply.updateVPSDefaultView(n, n18);
                    break;
                }
                case 81: {
                    VPSDynParkingMode vPSDynParkingMode = VPSDynParkingModeSerializer.getOptionalVPSDynParkingMode(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarParkingSystemReply.updateVPSDynamicParkingMode(vPSDynParkingMode, n);
                    break;
                }
                case 84: {
                    VPSOPSOverlay vPSOPSOverlay = VPSOPSOverlaySerializer.getOptionalVPSOPSOverlay(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarParkingSystemReply.updateVPSOPSOverlay(vPSOPSOverlay, n);
                    break;
                }
                case 85: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarParkingSystemReply.updateVPSSystemOnOff(bl, n);
                    break;
                }
                case 82: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarParkingSystemReply.updateVPSFailure(bl, n);
                    break;
                }
                case 132: {
                    int n = iDeserializer.getInt32();
                    int n19 = iDeserializer.getInt32();
                    this.p_DSICarParkingSystemReply.updateVPSExtCamConfig(n, n19);
                    break;
                }
                case 133: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarParkingSystemReply.updateVPSExtCamManActivation(bl, n);
                    break;
                }
                case 131: {
                    int n = iDeserializer.getInt32();
                    int n20 = iDeserializer.getInt32();
                    int n21 = iDeserializer.getInt32();
                    this.p_DSICarParkingSystemReply.updateVPS3DBirdview(n, n20, n21);
                    break;
                }
                case 134: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarParkingSystemReply.updateVPSSystemState(bl, n);
                    break;
                }
                case 135: {
                    VPSCameraStates vPSCameraStates = VPSCameraStatesSerializer.getOptionalVPSCameraStates(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarParkingSystemReply.updateVPSCameraStates(vPSCameraStates, n);
                    break;
                }
                case 71: {
                    DisplayContent displayContent = DisplayContentSerializer.getOptionalDisplayContent(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarParkingSystemReply.updateParkingPopupContent(displayContent, n);
                    break;
                }
                case 9: {
                    DisplayContent displayContent = DisplayContentSerializer.getOptionalDisplayContent(iDeserializer);
                    this.p_DSICarParkingSystemReply.requestParkingPopup(displayContent);
                    break;
                }
                case 0: {
                    DisplayContent displayContent = DisplayContentSerializer.getOptionalDisplayContent(iDeserializer);
                    this.p_DSICarParkingSystemReply.acknowledgeParkingPopup(displayContent);
                    break;
                }
                case 10: {
                    boolean bl = iDeserializer.getBool();
                    this.p_DSICarParkingSystemReply.responseLifeMonitoring(bl);
                    break;
                }
                case 1: {
                    boolean bl = iDeserializer.getBool();
                    this.p_DSICarParkingSystemReply.acknowledgePdcSetFactoryDefault(bl);
                    break;
                }
                case 2: {
                    boolean bl = iDeserializer.getBool();
                    this.p_DSICarParkingSystemReply.acknowledgeVpsSetFactoryDefault(bl);
                    break;
                }
                case 101: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarParkingSystemReply.updateARAFailure(bl, n);
                    break;
                }
                case 102: {
                    ARAInfo aRAInfo = ARAInfoSerializer.getOptionalARAInfo(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarParkingSystemReply.updateARAInfo(aRAInfo, n);
                    break;
                }
                case 100: {
                    ARACurrentTrailerAngle aRACurrentTrailerAngle = ARACurrentTrailerAngleSerializer.getOptionalARACurrentTrailerAngle(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarParkingSystemReply.updateARACurrentTrailerAngle(aRACurrentTrailerAngle, n);
                    break;
                }
                case 103: {
                    int n = iDeserializer.getInt32();
                    int n22 = iDeserializer.getInt32();
                    this.p_DSICarParkingSystemReply.updateARATargetTrailerAngle(n, n22);
                    break;
                }
                case 139: {
                    int n = iDeserializer.getInt32();
                    int n23 = iDeserializer.getInt32();
                    this.p_DSICarParkingSystemReply.updatePDCManeuverAssistConfig(n, n23);
                    break;
                }
                case 138: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarParkingSystemReply.updatePDCManeuverAssist(bl, n);
                    break;
                }
                case 150: {
                    PDCManeuverAssistState pDCManeuverAssistState = PDCManeuverAssistStateSerializer.getOptionalPDCManeuverAssistState(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarParkingSystemReply.updatePDCManeuverAssistState(pDCManeuverAssistState, n);
                    break;
                }
                case 149: {
                    int n = iDeserializer.getInt32();
                    int n24 = iDeserializer.getInt32();
                    this.p_DSICarParkingSystemReply.updatePDCManeuverAssistMessage(n, n24);
                    break;
                }
                case 147: {
                    int n = iDeserializer.getInt32();
                    int n25 = iDeserializer.getInt32();
                    this.p_DSICarParkingSystemReply.updatePDCIPAMessage(n, n25);
                    break;
                }
                case 146: {
                    int n = iDeserializer.getInt32();
                    int n26 = iDeserializer.getInt32();
                    this.p_DSICarParkingSystemReply.updatePDCContinueDrivingAssist(n, n26);
                    break;
                }
                case 148: {
                    int n = iDeserializer.getInt32();
                    int n27 = iDeserializer.getInt32();
                    this.p_DSICarParkingSystemReply.updatePDCIpaConfig(n, n27);
                    break;
                }
                case 152: {
                    PDCPiloPaSystemState pDCPiloPaSystemState = PDCPiloPaSystemStateSerializer.getOptionalPDCPiloPaSystemState(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarParkingSystemReply.updatePDCPiloPaSystemState(pDCPiloPaSystemState, n);
                    break;
                }
                case 154: {
                    VPSCameraCleaning vPSCameraCleaning = VPSCameraCleaningSerializer.getOptionalVPSCameraCleaning(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarParkingSystemReply.updateVPSCameraCleaning(vPSCameraCleaning, n);
                    break;
                }
                case 155: {
                    VPSRimProtection vPSRimProtection = VPSRimProtectionSerializer.getOptionalVPSRimProtection(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarParkingSystemReply.updateVPSRimProtection(vPSRimProtection, n);
                    break;
                }
                case 195: {
                    WCViewOptions wCViewOptions = WCViewOptionsSerializer.getOptionalWCViewOptions(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarParkingSystemReply.updateWCViewOptions(wCViewOptions, n);
                    break;
                }
                case 193: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarParkingSystemReply.updateWCSystemOnOff(bl, n);
                    break;
                }
                case 184: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarParkingSystemReply.updateWCAutoActivation(bl, n);
                    break;
                }
                case 190: {
                    int n = iDeserializer.getInt32();
                    int n28 = iDeserializer.getInt32();
                    this.p_DSICarParkingSystemReply.updateWCPopupContent(n, n28);
                    break;
                }
                case 185: {
                    int n = iDeserializer.getInt32();
                    int n29 = iDeserializer.getInt32();
                    this.p_DSICarParkingSystemReply.updateWCMessage(n, n29);
                    break;
                }
                case 188: {
                    WCPanelInfo wCPanelInfo = WCPanelInfoSerializer.getOptionalWCPanelInfo(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarParkingSystemReply.updateWCPanelPosition(wCPanelInfo, n);
                    break;
                }
                case 168: {
                    boolean bl = iDeserializer.getBool();
                    this.p_DSICarParkingSystemReply.acknowledgeWCSetFactoryDefault(bl);
                    break;
                }
                case 175: {
                    int n = iDeserializer.getInt32();
                    this.p_DSICarParkingSystemReply.requestWCPopup(n);
                    break;
                }
                case 166: {
                    int n = iDeserializer.getInt32();
                    this.p_DSICarParkingSystemReply.acknowledgeWCPopup(n);
                    break;
                }
                case 187: {
                    CarArrayListUpdateInfo carArrayListUpdateInfo = CarArrayListUpdateInfoSerializer.getOptionalCarArrayListUpdateInfo(iDeserializer);
                    int[] nArray = iDeserializer.getOptionalInt32VarArray();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarParkingSystemReply.updateWCPanelListUpdateInfo(carArrayListUpdateInfo, nArray, n);
                    break;
                }
                case 186: {
                    int n = iDeserializer.getInt32();
                    int n30 = iDeserializer.getInt32();
                    this.p_DSICarParkingSystemReply.updateWCPanelListTotalNumberOfElements(n, n30);
                    break;
                }
                case 194: {
                    WCVehiclePanelInfo wCVehiclePanelInfo = WCVehiclePanelInfoSerializer.getOptionalWCVehiclePanelInfo(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarParkingSystemReply.updateWCVehiclePanelInfo(wCVehiclePanelInfo, n);
                    break;
                }
                case 189: {
                    WCPinPukState wCPinPukState = WCPinPukStateSerializer.getOptionalWCPinPukState(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarParkingSystemReply.updateWCPinPukState(wCPinPukState, n);
                    break;
                }
                case 191: {
                    int n = iDeserializer.getInt32();
                    int n31 = iDeserializer.getInt32();
                    this.p_DSICarParkingSystemReply.updateWCScanningProgress(n, n31);
                    break;
                }
                case 192: {
                    int n = iDeserializer.getInt32();
                    int n32 = iDeserializer.getInt32();
                    this.p_DSICarParkingSystemReply.updateWCSoftwareUpdateProgress(n, n32);
                    break;
                }
                case 164: {
                    int n = iDeserializer.getInt32();
                    this.p_DSICarParkingSystemReply.acknowledgeWCEnterPinPuk(n);
                    break;
                }
                case 167: {
                    int n = iDeserializer.getInt32();
                    this.p_DSICarParkingSystemReply.acknowledgeWCScanning(n);
                    break;
                }
                case 165: {
                    int n = iDeserializer.getInt32();
                    this.p_DSICarParkingSystemReply.acknowledgeWCPairing(n);
                    break;
                }
                case 169: {
                    int n = iDeserializer.getInt32();
                    this.p_DSICarParkingSystemReply.acknowledgeWCSoftwareUpdate(n);
                    break;
                }
                case 163: {
                    int n = iDeserializer.getInt32();
                    this.p_DSICarParkingSystemReply.acknowledgeWCChangePin(n);
                    break;
                }
                case 162: {
                    int n = iDeserializer.getInt32();
                    this.p_DSICarParkingSystemReply.acknowledgeWCChangePanelName(n);
                    break;
                }
                case 176: {
                    CarArrayListUpdateInfo carArrayListUpdateInfo = CarArrayListUpdateInfoSerializer.getOptionalCarArrayListUpdateInfo(iDeserializer);
                    WCPanelListRecord[] wCPanelListRecordArray = WCPanelListRecordSerializer.getOptionalWCPanelListRecordVarArray(iDeserializer);
                    this.p_DSICarParkingSystemReply.responseWCPanelList(carArrayListUpdateInfo, wCPanelListRecordArray);
                    break;
                }
                case 3: {
                    int n = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    int n33 = iDeserializer.getInt32();
                    this.p_DSICarParkingSystemReply.asyncException(n, string, n33);
                    break;
                }
                case 87: {
                    String string = iDeserializer.getOptionalString();
                    String string2 = iDeserializer.getOptionalString();
                    this.p_DSICarParkingSystemReply.yyIndication(string, string2);
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

