/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carcomfort.impl;

import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.carcomfort.DSICarComfort;
import de.esolutions.fw.comm.dsi.carcomfort.DSICarComfortC;
import de.esolutions.fw.comm.dsi.carcomfort.DSICarComfortReply;
import de.esolutions.fw.comm.dsi.carcomfort.impl.DSICarComfortProxy$1;
import de.esolutions.fw.comm.dsi.carcomfort.impl.DSICarComfortProxy$10;
import de.esolutions.fw.comm.dsi.carcomfort.impl.DSICarComfortProxy$11;
import de.esolutions.fw.comm.dsi.carcomfort.impl.DSICarComfortProxy$12;
import de.esolutions.fw.comm.dsi.carcomfort.impl.DSICarComfortProxy$13;
import de.esolutions.fw.comm.dsi.carcomfort.impl.DSICarComfortProxy$14;
import de.esolutions.fw.comm.dsi.carcomfort.impl.DSICarComfortProxy$15;
import de.esolutions.fw.comm.dsi.carcomfort.impl.DSICarComfortProxy$16;
import de.esolutions.fw.comm.dsi.carcomfort.impl.DSICarComfortProxy$17;
import de.esolutions.fw.comm.dsi.carcomfort.impl.DSICarComfortProxy$18;
import de.esolutions.fw.comm.dsi.carcomfort.impl.DSICarComfortProxy$19;
import de.esolutions.fw.comm.dsi.carcomfort.impl.DSICarComfortProxy$2;
import de.esolutions.fw.comm.dsi.carcomfort.impl.DSICarComfortProxy$20;
import de.esolutions.fw.comm.dsi.carcomfort.impl.DSICarComfortProxy$21;
import de.esolutions.fw.comm.dsi.carcomfort.impl.DSICarComfortProxy$22;
import de.esolutions.fw.comm.dsi.carcomfort.impl.DSICarComfortProxy$23;
import de.esolutions.fw.comm.dsi.carcomfort.impl.DSICarComfortProxy$24;
import de.esolutions.fw.comm.dsi.carcomfort.impl.DSICarComfortProxy$25;
import de.esolutions.fw.comm.dsi.carcomfort.impl.DSICarComfortProxy$26;
import de.esolutions.fw.comm.dsi.carcomfort.impl.DSICarComfortProxy$3;
import de.esolutions.fw.comm.dsi.carcomfort.impl.DSICarComfortProxy$4;
import de.esolutions.fw.comm.dsi.carcomfort.impl.DSICarComfortProxy$5;
import de.esolutions.fw.comm.dsi.carcomfort.impl.DSICarComfortProxy$6;
import de.esolutions.fw.comm.dsi.carcomfort.impl.DSICarComfortProxy$7;
import de.esolutions.fw.comm.dsi.carcomfort.impl.DSICarComfortProxy$8;
import de.esolutions.fw.comm.dsi.carcomfort.impl.DSICarComfortProxy$9;
import de.esolutions.fw.comm.dsi.carcomfort.impl.DSICarComfortReplyService;
import de.esolutions.fw.util.serializer.adapter.GenericSerializable;
import de.esolutions.fw.util.serializer.exception.SerializerException;
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

public class DSICarComfortProxy
implements DSICarComfort,
DSICarComfortC {
    private static final CallContext context = CallContext.getContext("PROXY.dsi.carcomfort.DSICarComfort");
    private Proxy proxy;

    public DSICarComfortProxy(int n, DSICarComfortReply dSICarComfortReply) {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("549029d4-de8f-5cec-a6b0-782619f5452c", n, "879d4c85-7041-5bfa-8883-9afe763eb728", "dsi.carcomfort.DSICarComfort");
        DSICarComfortReplyService dSICarComfortReplyService = new DSICarComfortReplyService(dSICarComfortReply);
        this.proxy = new Proxy(serviceInstanceID, dSICarComfortReplyService, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    @Override
    public void setRGSBeltPretensionerDataFront(RGSBeltPretensionData rGSBeltPretensionData) {
        DSICarComfortProxy$1 dSICarComfortProxy$1 = new DSICarComfortProxy$1(this, rGSBeltPretensionData);
        this.proxy.remoteCallMethod((short)49, dSICarComfortProxy$1);
    }

    @Override
    public void setRGSBeltPretensionerDataRear(RGSBeltPretensionData rGSBeltPretensionData) {
        DSICarComfortProxy$2 dSICarComfortProxy$2 = new DSICarComfortProxy$2(this, rGSBeltPretensionData);
        this.proxy.remoteCallMethod((short)50, dSICarComfortProxy$2);
    }

    @Override
    public void setRGSPreCrashSystem(boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)51, genericSerializable);
    }

    @Override
    public void setRgsSetFactoryDefault() {
        this.proxy.remoteCallMethod((short)52, null);
    }

    @Override
    public void setRGSPreSenseSystem(boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)130, genericSerializable);
    }

    @Override
    public void setRGSPreSenseWarning(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)166, genericSerializable);
    }

    @Override
    public void setRGSLocalHazardInformation(RGSLocalHazardInformation rGSLocalHazardInformation) {
        DSICarComfortProxy$3 dSICarComfortProxy$3 = new DSICarComfortProxy$3(this, rGSLocalHazardInformation);
        this.proxy.remoteCallMethod((short)165, dSICarComfortProxy$3);
    }

    @Override
    public void setDoorLockingComfortOpenSettings(DoorLockingComfortOpenSettings doorLockingComfortOpenSettings) {
        DSICarComfortProxy$4 dSICarComfortProxy$4 = new DSICarComfortProxy$4(this, doorLockingComfortOpenSettings);
        this.proxy.remoteCallMethod((short)26, dSICarComfortProxy$4);
    }

    @Override
    public void setDoorLockingTheftWarningSettings(DoorLockingTheftWarningSettings doorLockingTheftWarningSettings) {
        DSICarComfortProxy$5 dSICarComfortProxy$5 = new DSICarComfortProxy$5(this, doorLockingTheftWarningSettings);
        this.proxy.remoteCallMethod((short)32, dSICarComfortProxy$5);
    }

    @Override
    public void setDoorLockingClBootOpen(boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)163, genericSerializable);
    }

    @Override
    public void setDoorLockingBootOpen(boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)25, genericSerializable);
    }

    @Override
    public void setDoorLockingBootClose(boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)161, genericSerializable);
    }

    @Override
    public void startDoorLockingRemoteLockUnlock(String string) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalString(string);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)169, genericSerializable);
    }

    @Override
    public void abortDoorLockingRemoteLockUnlock() {
        this.proxy.remoteCallMethod((short)154, null);
    }

    @Override
    public void sendDoorLockingRemoteLockUnlockSignature(String string) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalString(string);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)160, genericSerializable);
    }

    @Override
    public void startDoorLockingRemoteBlinking(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)167, genericSerializable);
    }

    @Override
    public void startDoorLockingRemoteHorn(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)168, genericSerializable);
    }

    @Override
    public void setDoorLockingUnlockingMode(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)33, genericSerializable);
    }

    @Override
    public void setDoorLockingAutoLock(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)22, genericSerializable);
    }

    @Override
    public void setDoorLockingAutoUnlock(boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)23, genericSerializable);
    }

    @Override
    public void setDoorLockingClBootLock(boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)162, genericSerializable);
    }

    @Override
    public void setDoorLockingMirrorProtection(boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)28, genericSerializable);
    }

    @Override
    public void setDoorLockingConfirmation(boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)27, genericSerializable);
    }

    @Override
    public void setDoorLockingRainClosing(boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)29, genericSerializable);
    }

    @Override
    public void setDoorLockingRearBlind(DoorLockingRearBlind doorLockingRearBlind) {
        DSICarComfortProxy$6 dSICarComfortProxy$6 = new DSICarComfortProxy$6(this, doorLockingRearBlind);
        this.proxy.remoteCallMethod((short)30, dSICarComfortProxy$6);
    }

    @Override
    public void setDoorLockingSetFactoryDefault() {
        this.proxy.remoteCallMethod((short)31, null);
    }

    @Override
    public void requestDoorLockingUserList(DoorLockingUserListUpdateInfo doorLockingUserListUpdateInfo) {
        DSICarComfortProxy$7 dSICarComfortProxy$7 = new DSICarComfortProxy$7(this, doorLockingUserListUpdateInfo);
        this.proxy.remoteCallMethod((short)211, dSICarComfortProxy$7);
    }

    @Override
    public void setDoorLockingUserListRA1(DoorLockingUserListUpdateInfo doorLockingUserListUpdateInfo, DoorLockingUserListRA1[] doorLockingUserListRA1Array) {
        DSICarComfortProxy$8 dSICarComfortProxy$8 = new DSICarComfortProxy$8(this, doorLockingUserListUpdateInfo, doorLockingUserListRA1Array);
        this.proxy.remoteCallMethod((short)222, dSICarComfortProxy$8);
    }

    @Override
    public void setDoorLockingUserListRAF(DoorLockingUserListUpdateInfo doorLockingUserListUpdateInfo, int[] nArray) {
        DSICarComfortProxy$9 dSICarComfortProxy$9 = new DSICarComfortProxy$9(this, doorLockingUserListUpdateInfo, nArray);
        this.proxy.remoteCallMethod((short)223, dSICarComfortProxy$9);
    }

    @Override
    public void setDoorLockingActiveUser(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)184, genericSerializable);
    }

    @Override
    public void setDoorLockingUserProfileOnOff(DoorLockingUserProfileOnOff doorLockingUserProfileOnOff) {
        DSICarComfortProxy$10 dSICarComfortProxy$10 = new DSICarComfortProxy$10(this, doorLockingUserProfileOnOff);
        this.proxy.remoteCallMethod((short)244, dSICarComfortProxy$10);
    }

    @Override
    public void startDoorLockingUserProfileControl(int n, int n2) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putInt32(n2);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)188, genericSerializable);
    }

    @Override
    public void abortDoorLockingUserProfileControl() {
        this.proxy.remoteCallMethod((short)203, null);
    }

    @Override
    public void setDoorLockingWindowAutoClose(boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)204, genericSerializable);
    }

    @Override
    public void setDoorlockingBlindsControl(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)224, genericSerializable);
    }

    @Override
    public void setDoorlockingBlindsControlExtended(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)255, genericSerializable);
    }

    @Override
    public void setDoorLockingLeftSideBlindControl(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)253, genericSerializable);
    }

    @Override
    public void setDoorLockingRightSideBlindControl(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)254, genericSerializable);
    }

    @Override
    public void setDoorLockingTurnIndRepeat(boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)243, genericSerializable);
    }

    @Override
    public void setDoorLockingKeyless(boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)252, genericSerializable);
    }

    @Override
    public void setWiperServicePosition(boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)58, genericSerializable);
    }

    @Override
    public void setWiperRainSensorOnOff(boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)56, genericSerializable);
    }

    @Override
    public void setWiperRainSensorConfig(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)55, genericSerializable);
    }

    @Override
    public void setWiperRearWiping(boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)57, genericSerializable);
    }

    @Override
    public void setWiperTearsWiping(boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)60, genericSerializable);
    }

    @Override
    public void setWiperWinterPosition(boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)61, genericSerializable);
    }

    @Override
    public void setEasyEntrySteeringColumn(boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)34, genericSerializable);
    }

    @Override
    public void setWiperSetFactoryDefault() {
        this.proxy.remoteCallMethod((short)59, null);
    }

    @Override
    public void setUGDOLearningData(UGDOLearningData uGDOLearningData) {
        DSICarComfortProxy$11 dSICarComfortProxy$11 = new DSICarComfortProxy$11(this, uGDOLearningData);
        this.proxy.remoteCallMethod((short)53, dSICarComfortProxy$11);
    }

    @Override
    public void showUGDOPopup(UGDOContent uGDOContent) {
        DSICarComfortProxy$12 dSICarComfortProxy$12 = new DSICarComfortProxy$12(this, uGDOContent);
        this.proxy.remoteCallMethod((short)142, dSICarComfortProxy$12);
    }

    @Override
    public void cancelUGDOPopup(UGDOContent uGDOContent) {
        DSICarComfortProxy$13 dSICarComfortProxy$13 = new DSICarComfortProxy$13(this, uGDOContent);
        this.proxy.remoteCallMethod((short)119, dSICarComfortProxy$13);
    }

    @Override
    public void deleteUGDOButton(UGDOSoftkeys uGDOSoftkeys) {
        DSICarComfortProxy$14 dSICarComfortProxy$14 = new DSICarComfortProxy$14(this, uGDOSoftkeys);
        this.proxy.remoteCallMethod((short)177, dSICarComfortProxy$14);
    }

    @Override
    public void setUGDOSetFactoryDefault() {
        this.proxy.remoteCallMethod((short)140, null);
    }

    @Override
    public void setUGDODestinationReached(UGDODestinationReached uGDODestinationReached) {
        DSICarComfortProxy$15 dSICarComfortProxy$15 = new DSICarComfortProxy$15(this, uGDODestinationReached);
        this.proxy.remoteCallMethod((short)138, dSICarComfortProxy$15);
    }

    @Override
    public void setUGDOOpenDoor(UGDOOpenDoor uGDOOpenDoor) {
        DSICarComfortProxy$16 dSICarComfortProxy$16 = new DSICarComfortProxy$16(this, uGDOOpenDoor);
        this.proxy.remoteCallMethod((short)139, dSICarComfortProxy$16);
    }

    @Override
    public void setUGDOSynchronisation(UGDOSynchronisation uGDOSynchronisation) {
        DSICarComfortProxy$17 dSICarComfortProxy$17 = new DSICarComfortProxy$17(this, uGDOSynchronisation);
        this.proxy.remoteCallMethod((short)141, dSICarComfortProxy$17);
    }

    @Override
    public void responseUGDOSynchronisation(UGDOSynchronisation uGDOSynchronisation) {
        DSICarComfortProxy$18 dSICarComfortProxy$18 = new DSICarComfortProxy$18(this, uGDOSynchronisation);
        this.proxy.remoteCallMethod((short)129, dSICarComfortProxy$18);
    }

    @Override
    public void startUGDOLearning(int n, int n2) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putInt32(n2);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)143, genericSerializable);
    }

    @Override
    public void abortUGDOLearning() {
        this.proxy.remoteCallMethod((short)113, null);
    }

    @Override
    public void requestUGDOButtonList(UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo) {
        DSICarComfortProxy$19 dSICarComfortProxy$19 = new DSICarComfortProxy$19(this, uGDOButtonListUpdateInfo);
        this.proxy.remoteCallMethod((short)212, dSICarComfortProxy$19);
    }

    @Override
    public void setUGDOButtonListRA0(UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo, UGDOButtonListRA0[] uGDOButtonListRA0Array) {
        DSICarComfortProxy$20 dSICarComfortProxy$20 = new DSICarComfortProxy$20(this, uGDOButtonListUpdateInfo, uGDOButtonListRA0Array);
        this.proxy.remoteCallMethod((short)226, dSICarComfortProxy$20);
    }

    @Override
    public void setUGDOButtonListRA1(UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo, UGDOButtonListRA1[] uGDOButtonListRA1Array) {
        DSICarComfortProxy$21 dSICarComfortProxy$21 = new DSICarComfortProxy$21(this, uGDOButtonListUpdateInfo, uGDOButtonListRA1Array);
        this.proxy.remoteCallMethod((short)227, dSICarComfortProxy$21);
    }

    @Override
    public void setUGDOButtonListRA2(UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo, UGDOButtonListRA2[] uGDOButtonListRA2Array) {
        DSICarComfortProxy$22 dSICarComfortProxy$22 = new DSICarComfortProxy$22(this, uGDOButtonListUpdateInfo, uGDOButtonListRA2Array);
        this.proxy.remoteCallMethod((short)228, dSICarComfortProxy$22);
    }

    @Override
    public void setUGDOButtonListRA3(UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo, UGDOButtonListRA3[] uGDOButtonListRA3Array) {
        DSICarComfortProxy$23 dSICarComfortProxy$23 = new DSICarComfortProxy$23(this, uGDOButtonListUpdateInfo, uGDOButtonListRA3Array);
        this.proxy.remoteCallMethod((short)229, dSICarComfortProxy$23);
    }

    @Override
    public void setUGDOButtonListRA4(UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo, UGDOButtonListRA4[] uGDOButtonListRA4Array) {
        DSICarComfortProxy$24 dSICarComfortProxy$24 = new DSICarComfortProxy$24(this, uGDOButtonListUpdateInfo, uGDOButtonListRA4Array);
        this.proxy.remoteCallMethod((short)230, dSICarComfortProxy$24);
    }

    @Override
    public void setUGDOButtonListRA5(UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo, UGDOButtonListRA5[] uGDOButtonListRA5Array) {
        DSICarComfortProxy$25 dSICarComfortProxy$25 = new DSICarComfortProxy$25(this, uGDOButtonListUpdateInfo, uGDOButtonListRA5Array);
        this.proxy.remoteCallMethod((short)231, dSICarComfortProxy$25);
    }

    @Override
    public void setUGDOButtonListRAF(UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo, int[] nArray) {
        DSICarComfortProxy$26 dSICarComfortProxy$26 = new DSICarComfortProxy$26(this, uGDOButtonListUpdateInfo, nArray);
        this.proxy.remoteCallMethod((short)232, dSICarComfortProxy$26);
    }

    @Override
    public void setRDKSystemOnOff(boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)46, genericSerializable);
    }

    @Override
    public void setRDKTireSetupSelectedTire(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)48, genericSerializable);
    }

    @Override
    public void setRDKSpeedLimit(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)45, genericSerializable);
    }

    @Override
    public void setRDKTireChanged() {
        this.proxy.remoteCallMethod((short)47, null);
    }

    @Override
    public void setRDKPressureChanged() {
        this.proxy.remoteCallMethod((short)44, null);
    }

    @Override
    public void requestRDKLifeMonitoring() {
        this.proxy.remoteCallMethod((short)13, null);
    }

    @Override
    public void setRDKPressureLevel(byte by) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt8(by);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)196, genericSerializable);
    }

    @Override
    public void setRDKSetFactoryDefault() {
        this.proxy.remoteCallMethod((short)225, null);
    }

    @Override
    public void setMirrorLowering(boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)38, genericSerializable);
    }

    @Override
    public void setMirrorSyncAdjust(boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)40, genericSerializable);
    }

    @Override
    public void setMirrorFolding(boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)36, genericSerializable);
    }

    @Override
    public void setMirrorDimming(boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)35, genericSerializable);
    }

    @Override
    public void setMirrorHeating(boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)37, genericSerializable);
    }

    @Override
    public void setMirrorSetFactoryDefault() {
        this.proxy.remoteCallMethod((short)39, null);
    }

    @Override
    public void setBrakeElectricalParking(boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)19, genericSerializable);
    }

    @Override
    public void setBrakeAutoHold(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)18, genericSerializable);
    }

    @Override
    public void setBrakeEscMode(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)20, genericSerializable);
    }

    @Override
    public void setBrakeHdcMode(boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)195, genericSerializable);
    }

    @Override
    public void setHMIIsReady(boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)164, genericSerializable);
    }

    @Override
    public void showDoorLockingPrompt(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)245, genericSerializable);
    }

    @Override
    public void cancelDoorLockingPrompt(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)241, genericSerializable);
    }

    @Override
    public void setNotification(int[] nArray) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalInt32VarArray(nArray);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)42, genericSerializable);
    }

    @Override
    public void setNotification(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)43, genericSerializable);
    }

    @Override
    public void setNotification() {
        this.proxy.remoteCallMethod((short)41, null);
    }

    @Override
    public void clearNotification(int[] nArray) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalInt32VarArray(nArray);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)10, genericSerializable);
    }

    @Override
    public void clearNotification(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)11, genericSerializable);
    }

    @Override
    public void clearNotification() {
        this.proxy.remoteCallMethod((short)9, null);
    }

    @Override
    public void yySet(String string, String string2) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalString(string);
            genericSerializable.putOptionalString(string2);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)112, genericSerializable);
    }
}

