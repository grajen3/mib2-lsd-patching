/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carcomfort;

import org.dsi.ifc.carcomfort.DoorLockingComfortOpenSettings;
import org.dsi.ifc.carcomfort.DoorLockingRearBlind;
import org.dsi.ifc.carcomfort.DoorLockingTheftWarningSettings;
import org.dsi.ifc.carcomfort.DoorLockingUserListRA1;
import org.dsi.ifc.carcomfort.DoorLockingUserListUpdateInfo;
import org.dsi.ifc.carcomfort.DoorLockingUserProfileOnOff;
import org.dsi.ifc.carcomfort.RGSBeltPretensionData;
import org.dsi.ifc.carcomfort.RGSLocalHazardInformation;
import org.dsi.ifc.carcomfort.UGDOButtonListRA0;
import org.dsi.ifc.carcomfort.UGDOButtonListRA1;
import org.dsi.ifc.carcomfort.UGDOButtonListRA2;
import org.dsi.ifc.carcomfort.UGDOButtonListRA3;
import org.dsi.ifc.carcomfort.UGDOButtonListRA4;
import org.dsi.ifc.carcomfort.UGDOButtonListRA5;
import org.dsi.ifc.carcomfort.UGDOButtonListUpdateInfo;
import org.dsi.ifc.carcomfort.UGDOContent;
import org.dsi.ifc.carcomfort.UGDODestinationReached;
import org.dsi.ifc.carcomfort.UGDOLearningData;
import org.dsi.ifc.carcomfort.UGDOOpenDoor;
import org.dsi.ifc.carcomfort.UGDOSoftkeys;
import org.dsi.ifc.carcomfort.UGDOSynchronisation;

public interface DSICarComfortC {
    default public void setRGSBeltPretensionerDataFront(RGSBeltPretensionData rGSBeltPretensionData) {
    }

    default public void setRGSBeltPretensionerDataRear(RGSBeltPretensionData rGSBeltPretensionData) {
    }

    default public void setRGSPreCrashSystem(boolean bl) {
    }

    default public void setRgsSetFactoryDefault() {
    }

    default public void setRGSPreSenseSystem(boolean bl) {
    }

    default public void setRGSPreSenseWarning(int n) {
    }

    default public void setRGSLocalHazardInformation(RGSLocalHazardInformation rGSLocalHazardInformation) {
    }

    default public void setDoorLockingComfortOpenSettings(DoorLockingComfortOpenSettings doorLockingComfortOpenSettings) {
    }

    default public void setDoorLockingTheftWarningSettings(DoorLockingTheftWarningSettings doorLockingTheftWarningSettings) {
    }

    default public void setDoorLockingClBootOpen(boolean bl) {
    }

    default public void setDoorLockingBootOpen(boolean bl) {
    }

    default public void setDoorLockingBootClose(boolean bl) {
    }

    default public void startDoorLockingRemoteLockUnlock(String string) {
    }

    default public void abortDoorLockingRemoteLockUnlock() {
    }

    default public void sendDoorLockingRemoteLockUnlockSignature(String string) {
    }

    default public void startDoorLockingRemoteBlinking(int n) {
    }

    default public void startDoorLockingRemoteHorn(int n) {
    }

    default public void setDoorLockingUnlockingMode(int n) {
    }

    default public void setDoorLockingAutoLock(int n) {
    }

    default public void setDoorLockingAutoUnlock(boolean bl) {
    }

    default public void setDoorLockingClBootLock(boolean bl) {
    }

    default public void setDoorLockingMirrorProtection(boolean bl) {
    }

    default public void setDoorLockingConfirmation(boolean bl) {
    }

    default public void setDoorLockingRainClosing(boolean bl) {
    }

    default public void setDoorLockingRearBlind(DoorLockingRearBlind doorLockingRearBlind) {
    }

    default public void setDoorLockingSetFactoryDefault() {
    }

    default public void requestDoorLockingUserList(DoorLockingUserListUpdateInfo doorLockingUserListUpdateInfo) {
    }

    default public void setDoorLockingUserListRA1(DoorLockingUserListUpdateInfo doorLockingUserListUpdateInfo, DoorLockingUserListRA1[] doorLockingUserListRA1Array) {
    }

    default public void setDoorLockingUserListRAF(DoorLockingUserListUpdateInfo doorLockingUserListUpdateInfo, int[] nArray) {
    }

    default public void setDoorLockingActiveUser(int n) {
    }

    default public void setDoorLockingUserProfileOnOff(DoorLockingUserProfileOnOff doorLockingUserProfileOnOff) {
    }

    default public void startDoorLockingUserProfileControl(int n, int n2) {
    }

    default public void abortDoorLockingUserProfileControl() {
    }

    default public void setDoorLockingWindowAutoClose(boolean bl) {
    }

    default public void setDoorlockingBlindsControl(int n) {
    }

    default public void setDoorlockingBlindsControlExtended(int n) {
    }

    default public void setDoorLockingLeftSideBlindControl(int n) {
    }

    default public void setDoorLockingRightSideBlindControl(int n) {
    }

    default public void setDoorLockingTurnIndRepeat(boolean bl) {
    }

    default public void setDoorLockingKeyless(boolean bl) {
    }

    default public void setWiperServicePosition(boolean bl) {
    }

    default public void setWiperRainSensorOnOff(boolean bl) {
    }

    default public void setWiperRainSensorConfig(int n) {
    }

    default public void setWiperRearWiping(boolean bl) {
    }

    default public void setWiperTearsWiping(boolean bl) {
    }

    default public void setWiperWinterPosition(boolean bl) {
    }

    default public void setEasyEntrySteeringColumn(boolean bl) {
    }

    default public void setWiperSetFactoryDefault() {
    }

    default public void setUGDOLearningData(UGDOLearningData uGDOLearningData) {
    }

    default public void showUGDOPopup(UGDOContent uGDOContent) {
    }

    default public void cancelUGDOPopup(UGDOContent uGDOContent) {
    }

    default public void deleteUGDOButton(UGDOSoftkeys uGDOSoftkeys) {
    }

    default public void setUGDOSetFactoryDefault() {
    }

    default public void setUGDODestinationReached(UGDODestinationReached uGDODestinationReached) {
    }

    default public void setUGDOOpenDoor(UGDOOpenDoor uGDOOpenDoor) {
    }

    default public void setUGDOSynchronisation(UGDOSynchronisation uGDOSynchronisation) {
    }

    default public void responseUGDOSynchronisation(UGDOSynchronisation uGDOSynchronisation) {
    }

    default public void startUGDOLearning(int n, int n2) {
    }

    default public void abortUGDOLearning() {
    }

    default public void requestUGDOButtonList(UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo) {
    }

    default public void setUGDOButtonListRA0(UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo, UGDOButtonListRA0[] uGDOButtonListRA0Array) {
    }

    default public void setUGDOButtonListRA1(UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo, UGDOButtonListRA1[] uGDOButtonListRA1Array) {
    }

    default public void setUGDOButtonListRA2(UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo, UGDOButtonListRA2[] uGDOButtonListRA2Array) {
    }

    default public void setUGDOButtonListRA3(UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo, UGDOButtonListRA3[] uGDOButtonListRA3Array) {
    }

    default public void setUGDOButtonListRA4(UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo, UGDOButtonListRA4[] uGDOButtonListRA4Array) {
    }

    default public void setUGDOButtonListRA5(UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo, UGDOButtonListRA5[] uGDOButtonListRA5Array) {
    }

    default public void setUGDOButtonListRAF(UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo, int[] nArray) {
    }

    default public void setRDKSystemOnOff(boolean bl) {
    }

    default public void setRDKTireSetupSelectedTire(int n) {
    }

    default public void setRDKSpeedLimit(int n) {
    }

    default public void setRDKTireChanged() {
    }

    default public void setRDKPressureChanged() {
    }

    default public void requestRDKLifeMonitoring() {
    }

    default public void setRDKPressureLevel(byte by) {
    }

    default public void setRDKSetFactoryDefault() {
    }

    default public void setMirrorLowering(boolean bl) {
    }

    default public void setMirrorSyncAdjust(boolean bl) {
    }

    default public void setMirrorFolding(boolean bl) {
    }

    default public void setMirrorDimming(boolean bl) {
    }

    default public void setMirrorHeating(boolean bl) {
    }

    default public void setMirrorSetFactoryDefault() {
    }

    default public void setBrakeElectricalParking(boolean bl) {
    }

    default public void setBrakeAutoHold(int n) {
    }

    default public void setBrakeEscMode(int n) {
    }

    default public void setBrakeHdcMode(boolean bl) {
    }

    default public void setHMIIsReady(boolean bl) {
    }

    default public void showDoorLockingPrompt(int n) {
    }

    default public void cancelDoorLockingPrompt(int n) {
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

