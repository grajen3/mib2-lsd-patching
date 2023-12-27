/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.cardriverassistance;

import org.dsi.ifc.cardriverassistance.ACCDistanceWarning;
import org.dsi.ifc.cardriverassistance.AWVEmergencyBrake;
import org.dsi.ifc.cardriverassistance.NVObjectDetection;
import org.dsi.ifc.cardriverassistance.TSDRoadSignFilter;
import org.dsi.ifc.global.CarBCSpeed;

public interface DSICarDriverAssistanceC {
    default public void setACCGongState(boolean bl) {
    }

    default public void setACCGongVolume(int n) {
    }

    default public void setACCDrivingProgram(int n) {
    }

    default public void setACCTimeGap(int n) {
    }

    default public void setACCDefaultMode(int n) {
    }

    default public void setACCCurveAssist(boolean bl) {
    }

    default public void setACCSpeedLimitAdoption(boolean bl) {
    }

    default public void setACCTrafficJamAssist(boolean bl) {
    }

    default public void setACCSpeedLimitOffset(int n) {
    }

    default public void setACCDistanceWarning(ACCDistanceWarning aCCDistanceWarning) {
    }

    default public void setACCSetFactoryDefault() {
    }

    default public void setPACCSensibility(boolean bl) {
    }

    default public void setPACCMaxSpeed(int n, int n2) {
    }

    default public void setPACCDrivingProgram(int n) {
    }

    default public void setAWVSystem(int n) {
    }

    default public void setAWVWarning(boolean bl) {
    }

    default public void setAWVGong(boolean bl) {
    }

    default public void setAWVGongVolume(int n) {
    }

    default public void setAWVBrakeJerk(boolean bl) {
    }

    default public void setAWVEmergencyBrake(AWVEmergencyBrake aWVEmergencyBrake) {
    }

    default public void setAWVDistanceWarning(boolean bl) {
    }

    default public void setAWVWarningTimegap(int n) {
    }

    default public void setAWVSetFactoryDefault() {
    }

    default public void setSWABrightness(int n) {
    }

    default public void setSWAWarningTime(int n) {
    }

    default public void setSWAFrequency(int n) {
    }

    default public void setSWASystem(int n) {
    }

    default public void setSWAGongState(boolean bl) {
    }

    default public void setSWAGongVolume(int n) {
    }

    default public void setSWARCTA(boolean bl) {
    }

    default public void setSWAExitAssist(boolean bl) {
    }

    default public void setNVActivation(boolean bl) {
    }

    default public void setNVContrast(int n) {
    }

    default public void setNVBrightness(int n) {
    }

    default public void setNVObjectDetection(NVObjectDetection nVObjectDetection) {
    }

    default public void setNVColorPA(int n) {
    }

    default public void setNVDesignPA(int n) {
    }

    default public void setNVDisplay(int n) {
    }

    default public void setNVZoomPanning(int n) {
    }

    default public void setNVSound(int n) {
    }

    default public void setNVSymbol(boolean bl) {
    }

    default public void setNVSetFactoryDefault() {
    }

    default public void setNVWarningTimegap(int n) {
    }

    default public void setNVSystem(boolean bl) {
    }

    default public void setLDWWarningTime(int n) {
    }

    default public void setLDWSteeringWheelVibration(int n) {
    }

    default public void setHCAInterventionStyle(int n) {
    }

    default public void setHCAToleranceLevel(int n) {
    }

    default public void setLdwhcaSetFactoryDefault() {
    }

    default public void setLDWHCASystemOnOff(boolean bl) {
    }

    default public void setLDWHCAWarningSound(boolean bl, int n) {
    }

    default public void setTSDSystemOnOff(boolean bl) {
    }

    default public void setTSDRoadSignFilter(TSDRoadSignFilter tSDRoadSignFilter) {
    }

    default public void setTsdSetFactoryDefault() {
    }

    default public void setTSDSpeedWarningThreshold(boolean bl, CarBCSpeed carBCSpeed) {
    }

    default public void setTSDTrailerSpeedLimit(CarBCSpeed carBCSpeed) {
    }

    default public void setTSDSpeedWarningAcoustics(boolean bl) {
    }

    default public void setMKESystemOnOff(boolean bl) {
    }

    default public void setMKESetFactoryDefault() {
    }

    default public void setPASystemOnOff(boolean bl) {
    }

    default public void setPASetFactoryDefault() {
    }

    default public void setPAConfigInformation(boolean bl) {
    }

    default public void setPAConfigWarning(boolean bl) {
    }

    default public void setPAWarningTimegap(int n) {
    }

    default public void setCurveAssistSystemOnOff(boolean bl) {
    }

    default public void setCurveAssistSetFactoryDefault() {
    }

    default public void setFTASystemOnOff(boolean bl) {
    }

    default public void setNotification(int[] nArray) {
    }

    default public void setNotification(int n) {
    }

    default public void setNotification() {
    }

    default public void clearNotification(int[] nArray) {
    }

    default public void clearNotification(int n) {
    }

    default public void clearNotification() {
    }

    default public void yySet(String string, String string2) {
    }
}

