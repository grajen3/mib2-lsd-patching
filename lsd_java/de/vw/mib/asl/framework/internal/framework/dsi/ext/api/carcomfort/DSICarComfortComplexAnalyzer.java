/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.framework.dsi.ext.api.carcomfort;

import de.vw.mib.asl.framework.internal.framework.dsi.ext.api.ComplexAnalyzer;
import org.dsi.ifc.carcomfort.BrakeViewOptions;
import org.dsi.ifc.carcomfort.DSICarComfortListener;
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

public class DSICarComfortComplexAnalyzer
extends ComplexAnalyzer
implements DSICarComfortListener {
    @Override
    public void acknowledgeDoorLockingSetFactoryDefault(boolean bl) {
    }

    @Override
    public void acknowledgeMirrorSetFactoryDefault(boolean bl) {
    }

    @Override
    public void acknowledgeRgsSetFactoryDefault(boolean bl) {
    }

    public void acknowledgeUGDODeleteButton(int n, boolean bl) {
    }

    @Override
    public void acknowledgeUGDOPopup(UGDOContent uGDOContent) {
    }

    public void acknowledgeUgdoSetFactoryDefault(boolean bl) {
    }

    @Override
    public void acknowledgeWiperSetFactoryDefault(boolean bl) {
    }

    @Override
    public void requestUGDOPopup(UGDOContent uGDOContent) {
    }

    @Override
    public void responseRDKPressureChanged(int n) {
        if (n == 0 || n == 3 || n == 2) {
            this.finished = true;
        }
    }

    @Override
    public void responseRDKTireChanged(int n) {
    }

    @Override
    public void updateBrakeAutoHold(int n, int n2) {
    }

    @Override
    public void updateBrakeElectricalParking(boolean bl, int n) {
    }

    @Override
    public void updateBrakeEscMode(int n, int n2) {
    }

    @Override
    public void updateBrakeViewOptions(BrakeViewOptions brakeViewOptions, int n) {
    }

    public void updateDoorLockingAutoBootOpen(boolean bl, int n) {
    }

    @Override
    public void updateDoorLockingAutoLock(int n, int n2) {
    }

    @Override
    public void updateDoorLockingAutoUnlock(boolean bl, int n) {
    }

    public void updateDoorLockingBootLock(boolean bl, int n) {
    }

    public void updateDoorLockingBootOpen(int n, int n2) {
    }

    @Override
    public void updateDoorLockingComfortOpenSettings(DoorLockingComfortOpenSettings doorLockingComfortOpenSettings, int n) {
    }

    @Override
    public void updateDoorLockingConfirmation(boolean bl, int n) {
    }

    @Override
    public void updateDoorLockingLockStatus(DoorLockingLockStatus doorLockingLockStatus, int n) {
    }

    @Override
    public void updateDoorLockingMessage(DoorLockingMessage doorLockingMessage, int n) {
    }

    @Override
    public void updateDoorLockingMirrorProtection(boolean bl, int n) {
    }

    @Override
    public void updateDoorLockingRainClosing(boolean bl, int n) {
    }

    @Override
    public void updateDoorLockingRearBlind(DoorLockingRearBlind doorLockingRearBlind, int n) {
    }

    @Override
    public void updateDoorLockingTheftWarningSettings(DoorLockingTheftWarningSettings doorLockingTheftWarningSettings, int n) {
    }

    @Override
    public void updateDoorLockingUnlockingMode(int n, int n2) {
    }

    @Override
    public void updateDoorLockingViewOptions(DoorLockingViewOptions doorLockingViewOptions, int n) {
    }

    @Override
    public void updateDoorLockingWindowStatus(DoorLockingWindowStatus doorLockingWindowStatus, int n) {
    }

    @Override
    public void updateEasyEntrySteeringColumn(boolean bl, int n) {
    }

    @Override
    public void updateMirrorDimming(boolean bl, int n) {
    }

    @Override
    public void updateMirrorFolding(boolean bl, int n) {
    }

    @Override
    public void updateMirrorHeating(boolean bl, int n) {
    }

    @Override
    public void updateMirrorLowering(boolean bl, int n) {
    }

    @Override
    public void updateMirrorSyncAdjust(boolean bl, int n) {
    }

    @Override
    public void updateMirrorViewOptions(MirrorViewOptions mirrorViewOptions, int n) {
    }

    @Override
    public void updateRDKSpeedLimit(int n, int n2) {
    }

    @Override
    public void updateRDKSystemOnOff(boolean bl, int n) {
    }

    @Override
    public void updateRDKTireDisplay(RDKTireDisplayData rDKTireDisplayData, int n) {
    }

    @Override
    public void updateRDKTireSetupSelectedTire(int n, int n2) {
    }

    @Override
    public void updateRDKTireSetupTireList(RDKTireInfo[] rDKTireInfoArray, int n) {
    }

    @Override
    public void updateRDKViewOptions(RDKViewOptions rDKViewOptions, int n) {
    }

    @Override
    public void updateRGSBeltPretensionDataFront(RGSBeltPretensionData rGSBeltPretensionData, int n) {
    }

    @Override
    public void updateRGSBeltPretensionDataRear(RGSBeltPretensionData rGSBeltPretensionData, int n) {
    }

    @Override
    public void updateRGSPreCrashSystem(boolean bl, int n) {
    }

    @Override
    public void updateRGSViewOptions(RGSViewOptions rGSViewOptions, int n) {
    }

    @Override
    public void updateUGDOContent(UGDOContent uGDOContent, int n) {
    }

    @Override
    public void updateUGDOLearningData(UGDOLearningData uGDOLearningData, int n) {
    }

    @Override
    public void updateUGDOVersionData(UGDOVersionData uGDOVersionData, int n) {
    }

    @Override
    public void updateUGDOViewOptions(UGDOViewOptions uGDOViewOptions, int n) {
    }

    @Override
    public void updateWiperRainSensorConfig(int n, int n2) {
    }

    @Override
    public void updateWiperRainSensorOnOff(boolean bl, int n) {
    }

    @Override
    public void updateWiperRearWiping(boolean bl, int n) {
    }

    @Override
    public void updateWiperServicePosition(boolean bl, int n) {
    }

    @Override
    public void updateWiperTearsWiping(boolean bl, int n) {
    }

    @Override
    public void updateWiperViewOptions(WiperViewOptions wiperViewOptions, int n) {
    }

    @Override
    public void updateWiperWinterPosition(boolean bl, int n) {
    }

    @Override
    public void asyncException(int n, String string, int n2) {
    }

    @Override
    public void responseRDKLifeMonitoring() {
    }

    @Override
    public void updateRGSPreSenseSystem(boolean bl, int n) {
    }

    public void updateRGSPreSenseWarning(boolean bl, int n) {
    }

    @Override
    public void updateDoorLockingBootOpen(boolean bl, int n) {
    }

    @Override
    public void updateUGDODestinationReached(UGDODestinationReached uGDODestinationReached, int n) {
    }

    @Override
    public void updateUGDOOpenDoor(UGDOOpenDoor uGDOOpenDoor, int n) {
    }

    @Override
    public void acknowledgeUGDOSetFactoryDefault(boolean bl) {
    }

    @Override
    public void updateUGDOButtonListUpdateInfo(UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo, int n) {
    }

    @Override
    public void updateUGDOButtonListTotalNumberOfElements(int n, int n2) {
    }

    @Override
    public void acknowledgeUGDODeleteButton(boolean bl) {
    }

    @Override
    public void acknowledgeUGDOSynchronisation(UGDOSynchronisation uGDOSynchronisation) {
    }

    public void acknowledgeUGDOLearning(int n) {
    }

    @Override
    public void requestUGDOSynchronisation(UGDOSynchronisation uGDOSynchronisation) {
    }

    @Override
    public void responseUGDOButtonListRA0(UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo, UGDOButtonListRA0[] uGDOButtonListRA0Array) {
    }

    @Override
    public void responseUGDOButtonListRA1(UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo, UGDOButtonListRA1[] uGDOButtonListRA1Array) {
    }

    @Override
    public void responseUGDOButtonListRA2(UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo, UGDOButtonListRA2[] uGDOButtonListRA2Array) {
    }

    @Override
    public void responseUGDOButtonListRA3(UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo, UGDOButtonListRA3[] uGDOButtonListRA3Array) {
    }

    @Override
    public void responseUGDOButtonListRA4(UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo, UGDOButtonListRA4[] uGDOButtonListRA4Array) {
    }

    @Override
    public void responseUGDOButtonListRAF(UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo, int[] nArray) {
    }

    @Override
    public void updateRGSPreSenseWarning(int n, int n2) {
    }

    @Override
    public void updateRGSLocalHazardDetection(RGSLocalHazardDetection rGSLocalHazardDetection, int n) {
    }

    @Override
    public void updateDoorLockingClBootOpen(boolean bl, int n) {
    }

    @Override
    public void updateDoorLockingBootClose(boolean bl, int n) {
    }

    @Override
    public void updateDoorLockingClBootLock(boolean bl, int n) {
    }

    @Override
    public void acknowledgeDoorLockingRemoteLockUnlock(String string, boolean bl) {
    }

    @Override
    public void acknowledgeDoorLockingRemoteBlinking(boolean bl) {
    }

    @Override
    public void acknowledgeDoorLockingRemoteHorn(boolean bl) {
    }

    @Override
    public void receivedDoorLockingRemoteLockUnlockSignatureVerification(String string) {
    }

    @Override
    public void receivedDoorLockingRemoteLockUnlockAuthentification(String string, int n) {
    }

    @Override
    public void responseDoorLockingUserListRA1(DoorLockingUserListUpdateInfo doorLockingUserListUpdateInfo, DoorLockingUserListRA1[] doorLockingUserListRA1Array) {
    }

    @Override
    public void responseDoorLockingUserListRAF(DoorLockingUserListUpdateInfo doorLockingUserListUpdateInfo, int[] nArray) {
    }

    @Override
    public void updateDoorLockingUserListUpdateInfo(DoorLockingUserListUpdateInfo doorLockingUserListUpdateInfo, int n) {
    }

    @Override
    public void updateDoorLockingUserListTotalNumberOfElements(int n, int n2) {
    }

    @Override
    public void updateDoorLockingActiveUser(int n, int n2) {
    }

    public void updateDoorLockingUserProfileOnOff(boolean bl, int n) {
    }

    @Override
    public void acknowledgeDoorLockingUserProfileControl(int n, boolean bl) {
    }

    @Override
    public void acknowledgeUGDOLearning(int n, int n2) {
    }

    @Override
    public void updateRDKPressureLevel(byte by, int n) {
    }

    @Override
    public void updateBrakeHdcMode(boolean bl, int n) {
    }

    @Override
    public void updateRDKDifferentialPressure(RDKWheelPressures rDKWheelPressures, int n) {
    }

    @Override
    public void updateRDKResidualBatteryLifetime(RDKResidualBatteryLifetime rDKResidualBatteryLifetime, int n) {
    }

    @Override
    public void updateDoorLockingWindowAutoClose(boolean bl, int n) {
    }

    @Override
    public void updateDoorLockingUserProfileOnOff(DoorLockingUserProfileOnOff doorLockingUserProfileOnOff, int n) {
    }

    @Override
    public void updateDoorLockingBlindsControl(int n, int n2) {
    }

    @Override
    public void responseUGDOButtonListRA5(UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo, UGDOButtonListRA5[] uGDOButtonListRA5Array) {
    }

    @Override
    public void acknowledgeRDKSetFactoryDefault(boolean bl) {
    }

    @Override
    public void acknowledgeRDKPressureChanged(boolean bl) {
    }

    @Override
    public void updateDoorLockingUserProfileControlProcessing(boolean bl, int n, boolean bl2, int n2) {
    }

    @Override
    public void updateDoorLockingTurnIndRepeat(boolean bl, int n) {
    }

    @Override
    public void acknowledgeDoorLockingPrompt(int n) {
    }

    @Override
    public void requestDoorLockingPrompt(int n) {
    }

    @Override
    public void updateDoorLockingPromptContent(int n, int n2) {
    }

    @Override
    public void updateDoorLockingBlindsControlExtended(DoorLockingBootBlindState doorLockingBootBlindState, int n) {
    }

    @Override
    public void updateDoorLockingKeyless(boolean bl, int n) {
    }

    @Override
    public void updateDoorLockingLeftSideBlindControl(int n, int n2) {
    }

    @Override
    public void updateDoorLockingRightSideBlindControl(int n, int n2) {
    }
}

