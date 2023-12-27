/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.carcomfort;

import de.esolutions.fw.comm.agent.Agent;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.carcomfort.DSICarComfortReply;
import de.esolutions.fw.comm.dsi.carcomfort.impl.DSICarComfortProxy;
import de.esolutions.fw.dsi.base.AbstractProvider;
import de.esolutions.fw.dsi.base.IDispatcher;
import org.dsi.ifc.carcomfort.DSICarComfort;
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
import org.osgi.framework.BundleContext;

public class DSICarComfortProvider
extends AbstractProvider
implements DSICarComfort {
    private static final int[] attributeIDs = new int[]{1, 2, 3, 4, 53, 54, 55, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 56, 57, 58, 59, 60, 65, 66, 79, 80, 81, 82, 83, 84, 85, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 49, 50, 51, 52, 33, 34, 35, 36, 37, 38, 63, 64, 62, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 61};
    private DSICarComfortProxy proxy;
    static /* synthetic */ Class class$org$dsi$ifc$carcomfort$DSICarComfort;

    public DSICarComfortProvider(int n, BundleContext bundleContext, Agent agent, IDispatcher iDispatcher) {
        super(bundleContext, agent, iDispatcher, n);
        this.createNewProxy();
    }

    @Override
    protected int[] getAttributeIDs() {
        return attributeIDs;
    }

    @Override
    public String getName() {
        return (class$org$dsi$ifc$carcomfort$DSICarComfort == null ? (class$org$dsi$ifc$carcomfort$DSICarComfort = DSICarComfortProvider.class$("org.dsi.ifc.carcomfort.DSICarComfort")) : class$org$dsi$ifc$carcomfort$DSICarComfort).getName();
    }

    @Override
    protected Proxy getProxy() {
        return this.proxy.getProxy();
    }

    @Override
    protected Proxy createNewProxy() {
        this.proxy = new DSICarComfortProxy(this.instance, (DSICarComfortReply)((Object)this.dispatcher));
        return this.proxy.getProxy();
    }

    @Override
    public void setRGSBeltPretensionerDataFront(RGSBeltPretensionData rGSBeltPretensionData) {
        try {
            this.proxy.setRGSBeltPretensionerDataFront(rGSBeltPretensionData);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setRGSBeltPretensionerDataRear(RGSBeltPretensionData rGSBeltPretensionData) {
        try {
            this.proxy.setRGSBeltPretensionerDataRear(rGSBeltPretensionData);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setRGSPreCrashSystem(boolean bl) {
        try {
            this.proxy.setRGSPreCrashSystem(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setRgsSetFactoryDefault() {
        try {
            this.proxy.setRgsSetFactoryDefault();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setRGSPreSenseSystem(boolean bl) {
        try {
            this.proxy.setRGSPreSenseSystem(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setRGSPreSenseWarning(int n) {
        try {
            this.proxy.setRGSPreSenseWarning(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setRGSLocalHazardInformation(RGSLocalHazardInformation rGSLocalHazardInformation) {
        try {
            this.proxy.setRGSLocalHazardInformation(rGSLocalHazardInformation);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setDoorLockingComfortOpenSettings(DoorLockingComfortOpenSettings doorLockingComfortOpenSettings) {
        try {
            this.proxy.setDoorLockingComfortOpenSettings(doorLockingComfortOpenSettings);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setDoorLockingTheftWarningSettings(DoorLockingTheftWarningSettings doorLockingTheftWarningSettings) {
        try {
            this.proxy.setDoorLockingTheftWarningSettings(doorLockingTheftWarningSettings);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setDoorLockingClBootOpen(boolean bl) {
        try {
            this.proxy.setDoorLockingClBootOpen(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setDoorLockingBootOpen(boolean bl) {
        try {
            this.proxy.setDoorLockingBootOpen(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setDoorLockingBootClose(boolean bl) {
        try {
            this.proxy.setDoorLockingBootClose(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void startDoorLockingRemoteLockUnlock(String string) {
        try {
            this.proxy.startDoorLockingRemoteLockUnlock(string);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void abortDoorLockingRemoteLockUnlock() {
        try {
            this.proxy.abortDoorLockingRemoteLockUnlock();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void sendDoorLockingRemoteLockUnlockSignature(String string) {
        try {
            this.proxy.sendDoorLockingRemoteLockUnlockSignature(string);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void startDoorLockingRemoteBlinking(int n) {
        try {
            this.proxy.startDoorLockingRemoteBlinking(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void startDoorLockingRemoteHorn(int n) {
        try {
            this.proxy.startDoorLockingRemoteHorn(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setDoorLockingUnlockingMode(int n) {
        try {
            this.proxy.setDoorLockingUnlockingMode(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setDoorLockingAutoLock(int n) {
        try {
            this.proxy.setDoorLockingAutoLock(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setDoorLockingAutoUnlock(boolean bl) {
        try {
            this.proxy.setDoorLockingAutoUnlock(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setDoorLockingClBootLock(boolean bl) {
        try {
            this.proxy.setDoorLockingClBootLock(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setDoorLockingMirrorProtection(boolean bl) {
        try {
            this.proxy.setDoorLockingMirrorProtection(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setDoorLockingConfirmation(boolean bl) {
        try {
            this.proxy.setDoorLockingConfirmation(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setDoorLockingRainClosing(boolean bl) {
        try {
            this.proxy.setDoorLockingRainClosing(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setDoorLockingRearBlind(DoorLockingRearBlind doorLockingRearBlind) {
        try {
            this.proxy.setDoorLockingRearBlind(doorLockingRearBlind);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setDoorLockingSetFactoryDefault() {
        try {
            this.proxy.setDoorLockingSetFactoryDefault();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void requestDoorLockingUserList(DoorLockingUserListUpdateInfo doorLockingUserListUpdateInfo) {
        try {
            this.proxy.requestDoorLockingUserList(doorLockingUserListUpdateInfo);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setDoorLockingUserListRA1(DoorLockingUserListUpdateInfo doorLockingUserListUpdateInfo, DoorLockingUserListRA1[] doorLockingUserListRA1Array) {
        try {
            this.proxy.setDoorLockingUserListRA1(doorLockingUserListUpdateInfo, doorLockingUserListRA1Array);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setDoorLockingUserListRAF(DoorLockingUserListUpdateInfo doorLockingUserListUpdateInfo, int[] nArray) {
        try {
            this.proxy.setDoorLockingUserListRAF(doorLockingUserListUpdateInfo, nArray);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setDoorLockingActiveUser(int n) {
        try {
            this.proxy.setDoorLockingActiveUser(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setDoorLockingUserProfileOnOff(DoorLockingUserProfileOnOff doorLockingUserProfileOnOff) {
        try {
            this.proxy.setDoorLockingUserProfileOnOff(doorLockingUserProfileOnOff);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void startDoorLockingUserProfileControl(int n, int n2) {
        try {
            this.proxy.startDoorLockingUserProfileControl(n, n2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void abortDoorLockingUserProfileControl() {
        try {
            this.proxy.abortDoorLockingUserProfileControl();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setDoorLockingWindowAutoClose(boolean bl) {
        try {
            this.proxy.setDoorLockingWindowAutoClose(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setDoorlockingBlindsControl(int n) {
        try {
            this.proxy.setDoorlockingBlindsControl(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setDoorlockingBlindsControlExtended(int n) {
        try {
            this.proxy.setDoorlockingBlindsControlExtended(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setDoorLockingLeftSideBlindControl(int n) {
        try {
            this.proxy.setDoorLockingLeftSideBlindControl(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setDoorLockingRightSideBlindControl(int n) {
        try {
            this.proxy.setDoorLockingRightSideBlindControl(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setDoorLockingTurnIndRepeat(boolean bl) {
        try {
            this.proxy.setDoorLockingTurnIndRepeat(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setDoorLockingKeyless(boolean bl) {
        try {
            this.proxy.setDoorLockingKeyless(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setWiperServicePosition(boolean bl) {
        try {
            this.proxy.setWiperServicePosition(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setWiperRainSensorOnOff(boolean bl) {
        try {
            this.proxy.setWiperRainSensorOnOff(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setWiperRainSensorConfig(int n) {
        try {
            this.proxy.setWiperRainSensorConfig(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setWiperRearWiping(boolean bl) {
        try {
            this.proxy.setWiperRearWiping(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setWiperTearsWiping(boolean bl) {
        try {
            this.proxy.setWiperTearsWiping(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setWiperWinterPosition(boolean bl) {
        try {
            this.proxy.setWiperWinterPosition(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setEasyEntrySteeringColumn(boolean bl) {
        try {
            this.proxy.setEasyEntrySteeringColumn(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setWiperSetFactoryDefault() {
        try {
            this.proxy.setWiperSetFactoryDefault();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setUGDOLearningData(UGDOLearningData uGDOLearningData) {
        try {
            this.proxy.setUGDOLearningData(uGDOLearningData);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void showUGDOPopup(UGDOContent uGDOContent) {
        try {
            this.proxy.showUGDOPopup(uGDOContent);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void cancelUGDOPopup(UGDOContent uGDOContent) {
        try {
            this.proxy.cancelUGDOPopup(uGDOContent);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void deleteUGDOButton(UGDOSoftkeys uGDOSoftkeys) {
        try {
            this.proxy.deleteUGDOButton(uGDOSoftkeys);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setUGDOSetFactoryDefault() {
        try {
            this.proxy.setUGDOSetFactoryDefault();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setUGDODestinationReached(UGDODestinationReached uGDODestinationReached) {
        try {
            this.proxy.setUGDODestinationReached(uGDODestinationReached);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setUGDOOpenDoor(UGDOOpenDoor uGDOOpenDoor) {
        try {
            this.proxy.setUGDOOpenDoor(uGDOOpenDoor);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setUGDOSynchronisation(UGDOSynchronisation uGDOSynchronisation) {
        try {
            this.proxy.setUGDOSynchronisation(uGDOSynchronisation);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void responseUGDOSynchronisation(UGDOSynchronisation uGDOSynchronisation) {
        try {
            this.proxy.responseUGDOSynchronisation(uGDOSynchronisation);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void startUGDOLearning(int n, int n2) {
        try {
            this.proxy.startUGDOLearning(n, n2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void abortUGDOLearning() {
        try {
            this.proxy.abortUGDOLearning();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void requestUGDOButtonList(UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo) {
        try {
            this.proxy.requestUGDOButtonList(uGDOButtonListUpdateInfo);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setUGDOButtonListRA0(UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo, UGDOButtonListRA0[] uGDOButtonListRA0Array) {
        try {
            this.proxy.setUGDOButtonListRA0(uGDOButtonListUpdateInfo, uGDOButtonListRA0Array);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setUGDOButtonListRA1(UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo, UGDOButtonListRA1[] uGDOButtonListRA1Array) {
        try {
            this.proxy.setUGDOButtonListRA1(uGDOButtonListUpdateInfo, uGDOButtonListRA1Array);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setUGDOButtonListRA2(UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo, UGDOButtonListRA2[] uGDOButtonListRA2Array) {
        try {
            this.proxy.setUGDOButtonListRA2(uGDOButtonListUpdateInfo, uGDOButtonListRA2Array);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setUGDOButtonListRA3(UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo, UGDOButtonListRA3[] uGDOButtonListRA3Array) {
        try {
            this.proxy.setUGDOButtonListRA3(uGDOButtonListUpdateInfo, uGDOButtonListRA3Array);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setUGDOButtonListRA4(UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo, UGDOButtonListRA4[] uGDOButtonListRA4Array) {
        try {
            this.proxy.setUGDOButtonListRA4(uGDOButtonListUpdateInfo, uGDOButtonListRA4Array);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setUGDOButtonListRA5(UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo, UGDOButtonListRA5[] uGDOButtonListRA5Array) {
        try {
            this.proxy.setUGDOButtonListRA5(uGDOButtonListUpdateInfo, uGDOButtonListRA5Array);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setUGDOButtonListRAF(UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo, int[] nArray) {
        try {
            this.proxy.setUGDOButtonListRAF(uGDOButtonListUpdateInfo, nArray);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setRDKSystemOnOff(boolean bl) {
        try {
            this.proxy.setRDKSystemOnOff(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setRDKTireSetupSelectedTire(int n) {
        try {
            this.proxy.setRDKTireSetupSelectedTire(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setRDKSpeedLimit(int n) {
        try {
            this.proxy.setRDKSpeedLimit(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setRDKTireChanged() {
        try {
            this.proxy.setRDKTireChanged();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setRDKPressureChanged() {
        try {
            this.proxy.setRDKPressureChanged();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void requestRDKLifeMonitoring() {
        try {
            this.proxy.requestRDKLifeMonitoring();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setRDKPressureLevel(byte by) {
        try {
            this.proxy.setRDKPressureLevel(by);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setRDKSetFactoryDefault() {
        try {
            this.proxy.setRDKSetFactoryDefault();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setMirrorLowering(boolean bl) {
        try {
            this.proxy.setMirrorLowering(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setMirrorSyncAdjust(boolean bl) {
        try {
            this.proxy.setMirrorSyncAdjust(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setMirrorFolding(boolean bl) {
        try {
            this.proxy.setMirrorFolding(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setMirrorDimming(boolean bl) {
        try {
            this.proxy.setMirrorDimming(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setMirrorHeating(boolean bl) {
        try {
            this.proxy.setMirrorHeating(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setMirrorSetFactoryDefault() {
        try {
            this.proxy.setMirrorSetFactoryDefault();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setBrakeElectricalParking(boolean bl) {
        try {
            this.proxy.setBrakeElectricalParking(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setBrakeAutoHold(int n) {
        try {
            this.proxy.setBrakeAutoHold(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setBrakeEscMode(int n) {
        try {
            this.proxy.setBrakeEscMode(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setBrakeHdcMode(boolean bl) {
        try {
            this.proxy.setBrakeHdcMode(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setHMIIsReady(boolean bl) {
        try {
            this.proxy.setHMIIsReady(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void showDoorLockingPrompt(int n) {
        try {
            this.proxy.showDoorLockingPrompt(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void cancelDoorLockingPrompt(int n) {
        try {
            this.proxy.cancelDoorLockingPrompt(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setNotification(int[] nArray) {
        try {
            this.proxy.setNotification(nArray);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setNotification(int n) {
        try {
            this.proxy.setNotification(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setNotification() {
        try {
            this.proxy.setNotification();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void clearNotification(int[] nArray) {
        try {
            this.proxy.clearNotification(nArray);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void clearNotification(int n) {
        try {
            this.proxy.clearNotification(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void clearNotification() {
        try {
            this.proxy.clearNotification();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void yySet(String string, String string2) {
        try {
            this.proxy.yySet(string, string2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

