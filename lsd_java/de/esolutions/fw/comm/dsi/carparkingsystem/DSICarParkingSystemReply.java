/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carparkingsystem;

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

public interface DSICarParkingSystemReply {
    public static final String IPL_COMM_UUID;
    public static final String IPL_COMM_INTERFACE_KEY;
    public static final String IPL_COMM_INTERFACE_VERSION;
    public static final String IPL_COMM_MODULE_VERSION;

    default public void updateParkingSystemViewOptions(ParkingSystemViewOptions parkingSystemViewOptions, int n) {
    }

    default public void updatePDCDefaultParkingMode(int n, int n2) {
    }

    default public void updatePDCFrequenceFront(int n, int n2) {
    }

    default public void updatePDCFrequenceRear(int n, int n2) {
    }

    default public void updatePDCFrequenceRight(int n, int n2) {
    }

    default public void updatePDCFrequenceLeft(int n, int n2) {
    }

    default public void updatePDCVolumeFront(int n, int n2) {
    }

    default public void updatePDCVolumeRear(int n, int n2) {
    }

    default public void updatePDCVolumeRight(int n, int n2) {
    }

    default public void updatePDCVolumeLeft(int n, int n2) {
    }

    default public void updatePDCMute(boolean bl, int n) {
    }

    default public void updatePDCSystemOnOff(boolean bl, int n) {
    }

    default public void updatePDCTrailerHitched(boolean bl, int n) {
    }

    default public void updatePDCDistanceValuesFront(PDCDistanceValuesFrontRear pDCDistanceValuesFrontRear, int n) {
    }

    default public void updatePDCDistanceValuesRear(PDCDistanceValuesFrontRear pDCDistanceValuesFrontRear, int n) {
    }

    default public void updatePDCDistanceValuesRight(PDCDistanceValuesRightLeft pDCDistanceValuesRightLeft, int n) {
    }

    default public void updatePDCDistanceValuesLeft(PDCDistanceValuesRightLeft pDCDistanceValuesRightLeft, int n) {
    }

    default public void updatePDCStatusLevelFront(PDCStatusLevelFrontRear pDCStatusLevelFrontRear, int n) {
    }

    default public void updatePDCStatusLevelRear(PDCStatusLevelFrontRear pDCStatusLevelFrontRear, int n) {
    }

    default public void updatePDCStatusLevelRight(PDCStatusLevelRightLeft pDCStatusLevelRightLeft, int n) {
    }

    default public void updatePDCStatusLevelLeft(PDCStatusLevelRightLeft pDCStatusLevelRightLeft, int n) {
    }

    default public void updatePDCOPSAutoActivation(boolean bl, int n) {
    }

    default public void updatePDCCrashWarning(PDCCrashWarning pDCCrashWarning, int n) {
    }

    default public void updatePDCSteeringInformation(PDCSteeringInformation pDCSteeringInformation, int n) {
    }

    default public void updatePDCFlankGuard(boolean bl, int n) {
    }

    default public void updatePDCSoundReproduction(PDCSoundReproduction pDCSoundReproduction, int n) {
    }

    default public void updatePDCInfo(PDCInfo pDCInfo, int n) {
    }

    default public void updatePDCFailure(boolean bl, int n) {
    }

    default public void updatePDCDistanceValuesFrontExt(PDCDistanceValuesFrontRearExt pDCDistanceValuesFrontRearExt, int n) {
    }

    default public void updatePDCDistanceValuesRearExt(PDCDistanceValuesFrontRearExt pDCDistanceValuesFrontRearExt, int n) {
    }

    default public void updatePDCStatusLevelFrontExt(PDCStatusLevelFrontRearExt pDCStatusLevelFrontRearExt, int n) {
    }

    default public void updatePDCStatusLevelRearExt(PDCStatusLevelFrontRearExt pDCStatusLevelFrontRearExt, int n) {
    }

    default public void updatePDCWallDetection(PDCWallDetection pDCWallDetection, int n) {
    }

    default public void updatePDCPLAMessage(int n, int n2) {
    }

    default public void updatePDCSoundFront(PDCSound pDCSound, int n) {
    }

    default public void updatePDCSoundRear(PDCSound pDCSound, int n) {
    }

    default public void updatePDCSoundLeft(PDCSound pDCSound, int n) {
    }

    default public void updatePDCSoundRight(PDCSound pDCSound, int n) {
    }

    default public void updatePDCPLAStatus(PDCPLAStatus pDCPLAStatus, int n) {
    }

    default public void updatePDCPLABargraph(PDCPLABargraph pDCPLABargraph, int n) {
    }

    default public void updatePDCPLAParkmodeSelection(int n, int n2) {
    }

    default public void updatePDCPLASystemState(PDCPLASystemState pDCPLASystemState, int n) {
    }

    default public void updatePDCOPSVisualisationPosition(int n, int n2) {
    }

    default public void updatePDCOffroadMode(boolean bl, int n) {
    }

    default public void updatePDCParkboxVisualisation(boolean bl, int n) {
    }

    default public void updateVPSFollowUpTime(int n, int n2) {
    }

    default public void updateVPSVideoInfo(VPSVideoInfo vPSVideoInfo, int n) {
    }

    default public void updateVPSColor(int n, int n2) {
    }

    default public void updateVPSContrast(int n, int n2) {
    }

    default public void updateVPSBrightness(int n, int n2) {
    }

    default public void updateVPSDefaultModeRV(VPSDefaultMode vPSDefaultMode, int n) {
    }

    default public void updateVPSDefaultModeSV(VPSDefaultMode vPSDefaultMode, int n) {
    }

    default public void updateVPSDefaultModeFV(VPSDefaultMode vPSDefaultMode, int n) {
    }

    default public void updateVPSDefaultModeBV(VPSDefaultMode vPSDefaultMode, int n) {
    }

    default public void updateVPSDefaultView(int n, int n2) {
    }

    default public void updateVPSDynamicParkingMode(VPSDynParkingMode vPSDynParkingMode, int n) {
    }

    default public void updateVPSOPSOverlay(VPSOPSOverlay vPSOPSOverlay, int n) {
    }

    default public void updateVPSSystemOnOff(boolean bl, int n) {
    }

    default public void updateVPSFailure(boolean bl, int n) {
    }

    default public void updateVPSExtCamConfig(int n, int n2) {
    }

    default public void updateVPSExtCamManActivation(boolean bl, int n) {
    }

    default public void updateVPS3DBirdview(int n, int n2, int n3) {
    }

    default public void updateVPSSystemState(boolean bl, int n) {
    }

    default public void updateVPSCameraStates(VPSCameraStates vPSCameraStates, int n) {
    }

    default public void updateParkingPopupContent(DisplayContent displayContent, int n) {
    }

    default public void requestParkingPopup(DisplayContent displayContent) {
    }

    default public void acknowledgeParkingPopup(DisplayContent displayContent) {
    }

    default public void responseLifeMonitoring(boolean bl) {
    }

    default public void acknowledgePdcSetFactoryDefault(boolean bl) {
    }

    default public void acknowledgeVpsSetFactoryDefault(boolean bl) {
    }

    default public void updateARAFailure(boolean bl, int n) {
    }

    default public void updateARAInfo(ARAInfo aRAInfo, int n) {
    }

    default public void updateARACurrentTrailerAngle(ARACurrentTrailerAngle aRACurrentTrailerAngle, int n) {
    }

    default public void updateARATargetTrailerAngle(int n, int n2) {
    }

    default public void updatePDCManeuverAssistConfig(int n, int n2) {
    }

    default public void updatePDCManeuverAssist(boolean bl, int n) {
    }

    default public void updatePDCManeuverAssistState(PDCManeuverAssistState pDCManeuverAssistState, int n) {
    }

    default public void updatePDCManeuverAssistMessage(int n, int n2) {
    }

    default public void updatePDCIPAMessage(int n, int n2) {
    }

    default public void updatePDCContinueDrivingAssist(int n, int n2) {
    }

    default public void updatePDCIpaConfig(int n, int n2) {
    }

    default public void updatePDCPiloPaSystemState(PDCPiloPaSystemState pDCPiloPaSystemState, int n) {
    }

    default public void updateVPSCameraCleaning(VPSCameraCleaning vPSCameraCleaning, int n) {
    }

    default public void updateVPSRimProtection(VPSRimProtection vPSRimProtection, int n) {
    }

    default public void updateWCViewOptions(WCViewOptions wCViewOptions, int n) {
    }

    default public void updateWCSystemOnOff(boolean bl, int n) {
    }

    default public void updateWCAutoActivation(boolean bl, int n) {
    }

    default public void updateWCPopupContent(int n, int n2) {
    }

    default public void updateWCMessage(int n, int n2) {
    }

    default public void updateWCPanelPosition(WCPanelInfo wCPanelInfo, int n) {
    }

    default public void acknowledgeWCSetFactoryDefault(boolean bl) {
    }

    default public void requestWCPopup(int n) {
    }

    default public void acknowledgeWCPopup(int n) {
    }

    default public void updateWCPanelListUpdateInfo(CarArrayListUpdateInfo carArrayListUpdateInfo, int[] nArray, int n) {
    }

    default public void updateWCPanelListTotalNumberOfElements(int n, int n2) {
    }

    default public void updateWCVehiclePanelInfo(WCVehiclePanelInfo wCVehiclePanelInfo, int n) {
    }

    default public void updateWCPinPukState(WCPinPukState wCPinPukState, int n) {
    }

    default public void updateWCScanningProgress(int n, int n2) {
    }

    default public void updateWCSoftwareUpdateProgress(int n, int n2) {
    }

    default public void acknowledgeWCEnterPinPuk(int n) {
    }

    default public void acknowledgeWCScanning(int n) {
    }

    default public void acknowledgeWCPairing(int n) {
    }

    default public void acknowledgeWCSoftwareUpdate(int n) {
    }

    default public void acknowledgeWCChangePin(int n) {
    }

    default public void acknowledgeWCChangePanelName(int n) {
    }

    default public void responseWCPanelList(CarArrayListUpdateInfo carArrayListUpdateInfo, WCPanelListRecord[] wCPanelListRecordArray) {
    }

    default public void asyncException(int n, String string, int n2) {
    }

    default public void yyIndication(String string, String string2) {
    }
}

