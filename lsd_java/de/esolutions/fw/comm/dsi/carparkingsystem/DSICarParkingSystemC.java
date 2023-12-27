/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carparkingsystem;

import org.dsi.ifc.carparkingsystem.DisplayContent;
import org.dsi.ifc.carparkingsystem.PDCPLASystemState;
import org.dsi.ifc.carparkingsystem.PDCPiloPaSystemState;
import org.dsi.ifc.carparkingsystem.PDCSound;
import org.dsi.ifc.carparkingsystem.PDCSoundReproduction;
import org.dsi.ifc.carparkingsystem.VPSCameraCleaning;
import org.dsi.ifc.carparkingsystem.VPSDefaultMode;
import org.dsi.ifc.carparkingsystem.VPSDynParkingMode;
import org.dsi.ifc.carparkingsystem.VPSOPSOverlay;
import org.dsi.ifc.global.CarArrayListUpdateInfo;

public interface DSICarParkingSystemC {
    default public void setHMIStateIsReady(boolean bl) {
    }

    default public void setPDCDefaultParkingMode(int n) {
    }

    default public void setPDCMute(boolean bl) {
    }

    default public void setPDCFrequenceFront(int n) {
    }

    default public void setPDCFrequenceRear(int n) {
    }

    default public void setPDCVolumeFront(int n) {
    }

    default public void setPDCVolumeRear(int n) {
    }

    default public void setPDCAutoActivation(boolean bl) {
    }

    default public void setPDCSystemOnOff(boolean bl) {
    }

    default public void setPDCFrequenceRight(int n) {
    }

    default public void setPDCFrequenceLeft(int n) {
    }

    default public void setPDCVolumeRight(int n) {
    }

    default public void setPDCVolumeLeft(int n) {
    }

    default public void setPDCFlankGuard(boolean bl) {
    }

    default public void setPDCSoundReproduction(PDCSoundReproduction pDCSoundReproduction) {
    }

    default public void setPDCSoundFront(PDCSound pDCSound) {
    }

    default public void setPDCSoundRear(PDCSound pDCSound) {
    }

    default public void setPDCSoundLeft(PDCSound pDCSound) {
    }

    default public void setPDCSoundRight(PDCSound pDCSound) {
    }

    default public void setPDCPLAPreSelection(int n) {
    }

    default public void setPDCPLAParkMode(int n) {
    }

    default public void setPDCPLASystemState(PDCPLASystemState pDCPLASystemState) {
    }

    default public void setPDCOffroadMode(boolean bl) {
    }

    default public void setPDCVisualisationParkbox(boolean bl) {
    }

    default public void setPDCOPSVisualisationPosition(int n) {
    }

    default public void setVPSFollowUpTime(int n) {
    }

    default public void setVPSColor(int n) {
    }

    default public void setVPSContrast(int n) {
    }

    default public void setVPSBrightness(int n) {
    }

    default public void setVPSDefaultModeRV(VPSDefaultMode vPSDefaultMode) {
    }

    default public void setVPSDefaultModeFV(VPSDefaultMode vPSDefaultMode) {
    }

    default public void setVPSDefaultModeSV(VPSDefaultMode vPSDefaultMode) {
    }

    default public void setVPSDefaultModeBV(VPSDefaultMode vPSDefaultMode) {
    }

    default public void setVPSDefaultView(int n) {
    }

    default public void setVPSOPSOverlay(VPSOPSOverlay vPSOPSOverlay) {
    }

    default public void setVPSDynamicParkingMode(VPSDynParkingMode vPSDynParkingMode) {
    }

    default public void setVPSSystemOnOff(boolean bl) {
    }

    default public void setVPSExtCamConfig(int n) {
    }

    default public void setVPSExtCamManActivation(boolean bl) {
    }

    default public void setVPS3DBirdview(int n, int n2) {
    }

    default public void setVPSSystemState(boolean bl) {
    }

    default public void showParkingPopup(DisplayContent displayContent) {
    }

    default public void cancelParkingPopup(DisplayContent displayContent, int n) {
    }

    default public void requestLifeMonitoring(boolean bl) {
    }

    default public void setPdcSetFactoryDefault() {
    }

    default public void setVpsSetFactoryDefault() {
    }

    default public void setARATargetTrailerAngle(int n) {
    }

    default public void setPDCManeuverAssistConfig(int n) {
    }

    default public void setPDCManeuverAssist(boolean bl) {
    }

    default public void setPDCContinueDrivingAssist(int n) {
    }

    default public void setPDCIpaConfig(int n) {
    }

    default public void setPDCPiloPaSystemState(PDCPiloPaSystemState pDCPiloPaSystemState) {
    }

    default public void setVPSCameraCleaning(VPSCameraCleaning vPSCameraCleaning) {
    }

    default public void setWCAutoActivation(boolean bl) {
    }

    default public void setWCSystemOnOff(boolean bl) {
    }

    default public void setWCSetFactoryDefault() {
    }

    default public void showWCPopup(int n) {
    }

    default public void cancelWCPopup(int n, int n2) {
    }

    default public void requestWCPanelList(CarArrayListUpdateInfo carArrayListUpdateInfo) {
    }

    default public void enterWCPinPuk(String string, String string2) {
    }

    default public void abortWCEnterPinPuk() {
    }

    default public void startWCScanning() {
    }

    default public void abortWCScanning() {
    }

    default public void startWCPairing(String string, String string2) {
    }

    default public void abortWCPairing() {
    }

    default public void startWCSoftwareUpdate(String string) {
    }

    default public void abortWCSoftwareUpdate() {
    }

    default public void changeWCPin(String string, String string2) {
    }

    default public void abortWCChangePin() {
    }

    default public void changeWCPanelName(String string, String string2) {
    }

    default public void abortWCChangePanelName() {
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

