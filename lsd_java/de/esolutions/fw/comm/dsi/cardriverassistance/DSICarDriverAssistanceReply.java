/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.cardriverassistance;

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

public interface DSICarDriverAssistanceReply {
    public static final String IPL_COMM_UUID;
    public static final String IPL_COMM_INTERFACE_KEY;
    public static final String IPL_COMM_INTERFACE_VERSION;
    public static final String IPL_COMM_MODULE_VERSION;

    default public void updateACCViewOptions(ACCViewOptions aCCViewOptions, int n) {
    }

    default public void updateACCGongState(boolean bl, int n) {
    }

    default public void updateACCGongVolume(int n, int n2) {
    }

    default public void updateACCDrivingProgram(int n, int n2) {
    }

    default public void updateACCTimeGap(int n, int n2) {
    }

    default public void updateACCDefaultMode(int n, int n2) {
    }

    default public void updateACCCurveAssist(boolean bl, int n) {
    }

    default public void updateACCSpeedLimitAdoption(boolean bl, int n) {
    }

    default public void updateACCTrafficJamAssist(boolean bl, int n) {
    }

    default public void updateACCSpeedLimitOffset(int n, int n2) {
    }

    default public void updateACCDistanceWarning(ACCDistanceWarning aCCDistanceWarning, int n) {
    }

    default public void updatePACCSensibility(boolean bl, int n) {
    }

    default public void updatePACCMaxSpeed(CarBCSpeed carBCSpeed, int n) {
    }

    default public void updatePACCMeanVelocity(CarBCSpeed carBCSpeed, int n) {
    }

    default public void updatePACCMeanConsumption(CarBCConsumption carBCConsumption, int n) {
    }

    default public void updatePACCCoastingPercentage(int n, int n2) {
    }

    default public void updatePACCDrivingProgram(int n, int n2) {
    }

    default public void updatePACCSystemState(int n, int n2) {
    }

    default public void acknowledgeACCSetFactoryDefault(boolean bl) {
    }

    default public void updateAWVDistanceWarning(boolean bl, int n) {
    }

    default public void updateAWVViewOptions(AWVViewOptions aWVViewOptions, int n) {
    }

    default public void updateAWVSystem(int n, int n2) {
    }

    default public void updateAWVWarning(boolean bl, int n) {
    }

    default public void updateAWVGong(boolean bl, int n) {
    }

    default public void updateAWVGongVolume(int n, int n2) {
    }

    default public void updateAWVBrakeJerk(boolean bl, int n) {
    }

    default public void updateAWVEmergencyBrake(AWVEmergencyBrake aWVEmergencyBrake, int n) {
    }

    default public void updateAWVWarningTimegap(int n, int n2) {
    }

    default public void acknowledgeAWVSetFactoryDefault(boolean bl) {
    }

    default public void updateSWAViewOptions(SWAViewOptions sWAViewOptions, int n) {
    }

    default public void updateSWABrightness(int n, int n2) {
    }

    default public void updateSWAWarningTime(int n, int n2) {
    }

    default public void updateSWAFrequency(int n, int n2) {
    }

    default public void updateSWASystem(int n, int n2) {
    }

    default public void updateSWAGongState(boolean bl, int n) {
    }

    default public void updateSWAGongVolume(int n, int n2) {
    }

    default public void updateSWARCTASensorData(SWARCTASensorData sWARCTASensorData, int n) {
    }

    default public void updateSWARCTA(boolean bl, int n) {
    }

    default public void updateSWAExitAssist(boolean bl, int n) {
    }

    default public void updateNVViewOptions(NVViewOptions nVViewOptions, int n) {
    }

    default public void updateNVActivation(boolean bl, int n) {
    }

    default public void updateNVContrast(int n, int n2) {
    }

    default public void updateNVBrightness(int n, int n2) {
    }

    default public void updateNVObjectDetection(NVObjectDetection nVObjectDetection, int n) {
    }

    default public void updateNVColorPA(int n, int n2) {
    }

    default public void updateNVDesignPA(int n, int n2) {
    }

    default public void updateNVDisplay(int n, int n2) {
    }

    default public void updateNVZoomPanning(int n, int n2) {
    }

    default public void updateNVSound(int n, int n2) {
    }

    default public void updateNVSymbol(boolean bl, int n) {
    }

    default public void acknowledgeNVSetFactoryDefault(boolean bl) {
    }

    default public void updateNVSystem(boolean bl, int n) {
    }

    default public void updateNVWarningTimegap(int n, int n2) {
    }

    default public void updateLDWHCAViewOptions(LDWHCAViewOptions lDWHCAViewOptions, int n) {
    }

    default public void updateLDWWarningTime(int n, int n2) {
    }

    default public void updateLDWSteeringWheelVibration(int n, int n2) {
    }

    default public void updateHCAInterventionStyle(int n, int n2) {
    }

    default public void updateHCAToleranceLevel(int n, int n2) {
    }

    default public void acknowledgeLdwhcaSetFactoryDefault(boolean bl) {
    }

    default public void updateLDWHCASystemOnOff(boolean bl, int n) {
    }

    default public void updateLDWHCAWarningSound(boolean bl, int n, int n2) {
    }

    default public void updateTSDViewOptions(TSDViewOptions tSDViewOptions, int n) {
    }

    default public void updateTSDSystemOnOff(boolean bl, int n) {
    }

    default public void updateTSDTrailerDetection(boolean bl, int n) {
    }

    default public void updateTSDSign1(TSDSignFct tSDSignFct, int n) {
    }

    default public void updateTSDSign2(TSDSignFct tSDSignFct, int n) {
    }

    default public void updateTSDSign3(TSDSignFct tSDSignFct, int n) {
    }

    default public void updateTSDSign4(TSDSignFct tSDSignFct, int n) {
    }

    default public void updateTSDSign5(TSDSignFct tSDSignFct, int n) {
    }

    default public void updateTSDRoadSignFilter(TSDRoadSignFilter tSDRoadSignFilter, int n) {
    }

    default public void acknowledgeTsdSetFactoryDefault(boolean bl) {
    }

    default public void updateTSDSpeedWarningThreshold(boolean bl, CarBCSpeed carBCSpeed, int n) {
    }

    default public void updateTSDTrailerSpeedLimit(CarBCSpeed carBCSpeed, int n) {
    }

    default public void updateTSDSystemMessages(TSDSystemMessages tSDSystemMessages, int n) {
    }

    default public void updateTSDSpeedWarningAcoustics(boolean bl, int n) {
    }

    default public void updateMKEViewOptions(MKEViewOptions mKEViewOptions, int n) {
    }

    default public void updateMKESystemOnOff(boolean bl, int n) {
    }

    default public void acknowledgeMKESetFactoryDefault(boolean bl) {
    }

    default public void updatePAViewOptions(PAViewOptions pAViewOptions, int n) {
    }

    default public void updatePASystemOnOff(boolean bl, int n) {
    }

    default public void acknowledgePASetFactoryDefault(boolean bl) {
    }

    default public void updatePAConfigInformation(boolean bl, int n) {
    }

    default public void updatePAConfigWarning(boolean bl, int n) {
    }

    default public void updatePAWarningTimegap(int n, int n2) {
    }

    default public void updateCurveAssistSystemOnOff(boolean bl, int n) {
    }

    default public void acknowledgeCurveAssistSetFactoryDefault(boolean bl) {
    }

    default public void updateFTAViewOptions(FTAViewOptions fTAViewOptions, int n) {
    }

    default public void updateFTASystemOnOff(boolean bl, int n) {
    }

    default public void updateFTASensorData(FTASensorData fTASensorData, int n) {
    }

    default public void asyncException(int n, String string, int n2) {
    }

    default public void yyIndication(String string, String string2) {
    }
}

