/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carcomfort;

import org.dsi.ifc.carcomfort.BrakeViewOptions;
import org.dsi.ifc.carcomfort.DoorLockingBootBlindState;
import org.dsi.ifc.carcomfort.DoorLockingComfortOpenSettings;
import org.dsi.ifc.carcomfort.DoorLockingLockStatus;
import org.dsi.ifc.carcomfort.DoorLockingMessage;
import org.dsi.ifc.carcomfort.DoorLockingRearBlind;
import org.dsi.ifc.carcomfort.DoorLockingTheftWarningSettings;
import org.dsi.ifc.carcomfort.DoorLockingUserListRA1;
import org.dsi.ifc.carcomfort.DoorLockingUserListUpdateInfo;
import org.dsi.ifc.carcomfort.DoorLockingUserProfileOnOff;
import org.dsi.ifc.carcomfort.DoorLockingViewOptions;
import org.dsi.ifc.carcomfort.DoorLockingWindowStatus;
import org.dsi.ifc.carcomfort.MirrorViewOptions;
import org.dsi.ifc.carcomfort.RDKResidualBatteryLifetime;
import org.dsi.ifc.carcomfort.RDKTireDisplayData;
import org.dsi.ifc.carcomfort.RDKTireInfo;
import org.dsi.ifc.carcomfort.RDKViewOptions;
import org.dsi.ifc.carcomfort.RDKWheelPressures;
import org.dsi.ifc.carcomfort.RGSBeltPretensionData;
import org.dsi.ifc.carcomfort.RGSLocalHazardDetection;
import org.dsi.ifc.carcomfort.RGSViewOptions;
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
import org.dsi.ifc.carcomfort.UGDOSynchronisation;
import org.dsi.ifc.carcomfort.UGDOVersionData;
import org.dsi.ifc.carcomfort.UGDOViewOptions;
import org.dsi.ifc.carcomfort.WiperViewOptions;

public interface DSICarComfortReply {
    public static final String IPL_COMM_UUID;
    public static final String IPL_COMM_INTERFACE_KEY;
    public static final String IPL_COMM_INTERFACE_VERSION;
    public static final String IPL_COMM_MODULE_VERSION;

    default public void updateRGSViewOptions(RGSViewOptions rGSViewOptions, int n) {
    }

    default public void updateRGSBeltPretensionDataFront(RGSBeltPretensionData rGSBeltPretensionData, int n) {
    }

    default public void updateRGSBeltPretensionDataRear(RGSBeltPretensionData rGSBeltPretensionData, int n) {
    }

    default public void updateRGSPreCrashSystem(boolean bl, int n) {
    }

    default public void acknowledgeRgsSetFactoryDefault(boolean bl) {
    }

    default public void updateRGSPreSenseSystem(boolean bl, int n) {
    }

    default public void updateRGSPreSenseWarning(int n, int n2) {
    }

    default public void updateRGSLocalHazardDetection(RGSLocalHazardDetection rGSLocalHazardDetection, int n) {
    }

    default public void updateDoorLockingViewOptions(DoorLockingViewOptions doorLockingViewOptions, int n) {
    }

    default public void updateDoorLockingMessage(DoorLockingMessage doorLockingMessage, int n) {
    }

    default public void updateDoorLockingLockStatus(DoorLockingLockStatus doorLockingLockStatus, int n) {
    }

    default public void updateDoorLockingWindowStatus(DoorLockingWindowStatus doorLockingWindowStatus, int n) {
    }

    default public void updateDoorLockingComfortOpenSettings(DoorLockingComfortOpenSettings doorLockingComfortOpenSettings, int n) {
    }

    default public void updateDoorLockingTheftWarningSettings(DoorLockingTheftWarningSettings doorLockingTheftWarningSettings, int n) {
    }

    default public void updateDoorLockingClBootOpen(boolean bl, int n) {
    }

    default public void updateDoorLockingBootOpen(boolean bl, int n) {
    }

    default public void updateDoorLockingBootClose(boolean bl, int n) {
    }

    default public void updateDoorLockingUnlockingMode(int n, int n2) {
    }

    default public void updateDoorLockingAutoLock(int n, int n2) {
    }

    default public void updateDoorLockingAutoUnlock(boolean bl, int n) {
    }

    default public void updateDoorLockingClBootLock(boolean bl, int n) {
    }

    default public void updateDoorLockingMirrorProtection(boolean bl, int n) {
    }

    default public void updateDoorLockingConfirmation(boolean bl, int n) {
    }

    default public void updateDoorLockingRainClosing(boolean bl, int n) {
    }

    default public void updateDoorLockingRearBlind(DoorLockingRearBlind doorLockingRearBlind, int n) {
    }

    default public void acknowledgeDoorLockingSetFactoryDefault(boolean bl) {
    }

    default public void acknowledgeDoorLockingRemoteLockUnlock(String string, boolean bl) {
    }

    default public void acknowledgeDoorLockingRemoteBlinking(boolean bl) {
    }

    default public void acknowledgeDoorLockingRemoteHorn(boolean bl) {
    }

    default public void receivedDoorLockingRemoteLockUnlockSignatureVerification(String string) {
    }

    default public void receivedDoorLockingRemoteLockUnlockAuthentification(String string, int n) {
    }

    default public void responseDoorLockingUserListRA1(DoorLockingUserListUpdateInfo doorLockingUserListUpdateInfo, DoorLockingUserListRA1[] doorLockingUserListRA1Array) {
    }

    default public void responseDoorLockingUserListRAF(DoorLockingUserListUpdateInfo doorLockingUserListUpdateInfo, int[] nArray) {
    }

    default public void updateDoorLockingUserListUpdateInfo(DoorLockingUserListUpdateInfo doorLockingUserListUpdateInfo, int n) {
    }

    default public void updateDoorLockingUserListTotalNumberOfElements(int n, int n2) {
    }

    default public void updateDoorLockingActiveUser(int n, int n2) {
    }

    default public void updateDoorLockingUserProfileOnOff(DoorLockingUserProfileOnOff doorLockingUserProfileOnOff, int n) {
    }

    default public void acknowledgeDoorLockingUserProfileControl(int n, boolean bl) {
    }

    default public void updateDoorLockingUserProfileControlProcessing(boolean bl, int n, boolean bl2, int n2) {
    }

    default public void updateDoorLockingWindowAutoClose(boolean bl, int n) {
    }

    default public void updateDoorLockingBlindsControl(int n, int n2) {
    }

    default public void updateDoorLockingBlindsControlExtended(DoorLockingBootBlindState doorLockingBootBlindState, int n) {
    }

    default public void updateDoorLockingLeftSideBlindControl(int n, int n2) {
    }

    default public void updateDoorLockingRightSideBlindControl(int n, int n2) {
    }

    default public void updateDoorLockingTurnIndRepeat(boolean bl, int n) {
    }

    default public void updateDoorLockingKeyless(boolean bl, int n) {
    }

    default public void updateWiperViewOptions(WiperViewOptions wiperViewOptions, int n) {
    }

    default public void updateWiperServicePosition(boolean bl, int n) {
    }

    default public void updateWiperRainSensorOnOff(boolean bl, int n) {
    }

    default public void updateWiperRainSensorConfig(int n, int n2) {
    }

    default public void updateWiperRearWiping(boolean bl, int n) {
    }

    default public void updateWiperTearsWiping(boolean bl, int n) {
    }

    default public void updateWiperWinterPosition(boolean bl, int n) {
    }

    default public void updateEasyEntrySteeringColumn(boolean bl, int n) {
    }

    default public void acknowledgeWiperSetFactoryDefault(boolean bl) {
    }

    default public void updateUGDOViewOptions(UGDOViewOptions uGDOViewOptions, int n) {
    }

    default public void updateUGDOLearningData(UGDOLearningData uGDOLearningData, int n) {
    }

    default public void updateUGDODestinationReached(UGDODestinationReached uGDODestinationReached, int n) {
    }

    default public void updateUGDOOpenDoor(UGDOOpenDoor uGDOOpenDoor, int n) {
    }

    default public void updateUGDOContent(UGDOContent uGDOContent, int n) {
    }

    default public void updateUGDOVersionData(UGDOVersionData uGDOVersionData, int n) {
    }

    default public void acknowledgeUGDOSetFactoryDefault(boolean bl) {
    }

    default public void updateUGDOButtonListUpdateInfo(UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo, int n) {
    }

    default public void updateUGDOButtonListTotalNumberOfElements(int n, int n2) {
    }

    default public void requestUGDOPopup(UGDOContent uGDOContent) {
    }

    default public void acknowledgeUGDOPopup(UGDOContent uGDOContent) {
    }

    default public void acknowledgeUGDODeleteButton(boolean bl) {
    }

    default public void acknowledgeUGDOSynchronisation(UGDOSynchronisation uGDOSynchronisation) {
    }

    default public void acknowledgeUGDOLearning(int n, int n2) {
    }

    default public void requestUGDOSynchronisation(UGDOSynchronisation uGDOSynchronisation) {
    }

    default public void responseUGDOButtonListRA0(UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo, UGDOButtonListRA0[] uGDOButtonListRA0Array) {
    }

    default public void responseUGDOButtonListRA1(UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo, UGDOButtonListRA1[] uGDOButtonListRA1Array) {
    }

    default public void responseUGDOButtonListRA2(UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo, UGDOButtonListRA2[] uGDOButtonListRA2Array) {
    }

    default public void responseUGDOButtonListRA3(UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo, UGDOButtonListRA3[] uGDOButtonListRA3Array) {
    }

    default public void responseUGDOButtonListRA4(UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo, UGDOButtonListRA4[] uGDOButtonListRA4Array) {
    }

    default public void responseUGDOButtonListRA5(UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo, UGDOButtonListRA5[] uGDOButtonListRA5Array) {
    }

    default public void responseUGDOButtonListRAF(UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo, int[] nArray) {
    }

    default public void updateRDKViewOptions(RDKViewOptions rDKViewOptions, int n) {
    }

    default public void updateRDKSystemOnOff(boolean bl, int n) {
    }

    default public void updateRDKTireSetupTireList(RDKTireInfo[] rDKTireInfoArray, int n) {
    }

    default public void updateRDKTireSetupSelectedTire(int n, int n2) {
    }

    default public void updateRDKTireDisplay(RDKTireDisplayData rDKTireDisplayData, int n) {
    }

    default public void updateRDKSpeedLimit(int n, int n2) {
    }

    default public void responseRDKTireChanged(int n) {
    }

    default public void responseRDKPressureChanged(int n) {
    }

    default public void responseRDKLifeMonitoring() {
    }

    default public void updateRDKPressureLevel(byte by, int n) {
    }

    default public void acknowledgeRDKSetFactoryDefault(boolean bl) {
    }

    default public void acknowledgeRDKPressureChanged(boolean bl) {
    }

    default public void updateMirrorViewOptions(MirrorViewOptions mirrorViewOptions, int n) {
    }

    default public void updateMirrorLowering(boolean bl, int n) {
    }

    default public void updateMirrorSyncAdjust(boolean bl, int n) {
    }

    default public void updateMirrorFolding(boolean bl, int n) {
    }

    default public void updateMirrorDimming(boolean bl, int n) {
    }

    default public void updateMirrorHeating(boolean bl, int n) {
    }

    default public void acknowledgeMirrorSetFactoryDefault(boolean bl) {
    }

    default public void updateBrakeViewOptions(BrakeViewOptions brakeViewOptions, int n) {
    }

    default public void updateBrakeElectricalParking(boolean bl, int n) {
    }

    default public void updateBrakeAutoHold(int n, int n2) {
    }

    default public void updateBrakeEscMode(int n, int n2) {
    }

    default public void updateBrakeHdcMode(boolean bl, int n) {
    }

    default public void updateRDKDifferentialPressure(RDKWheelPressures rDKWheelPressures, int n) {
    }

    default public void updateRDKResidualBatteryLifetime(RDKResidualBatteryLifetime rDKResidualBatteryLifetime, int n) {
    }

    default public void acknowledgeDoorLockingPrompt(int n) {
    }

    default public void requestDoorLockingPrompt(int n) {
    }

    default public void updateDoorLockingPromptContent(int n, int n2) {
    }

    default public void asyncException(int n, String string, int n2) {
    }

    default public void yyIndication(String string, String string2) {
    }
}

