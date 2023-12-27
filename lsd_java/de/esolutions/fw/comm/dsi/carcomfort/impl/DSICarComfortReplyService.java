/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carcomfort.impl;

import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.carcomfort.DSICarComfortReply;
import de.esolutions.fw.comm.dsi.carcomfort.impl.BrakeViewOptionsSerializer;
import de.esolutions.fw.comm.dsi.carcomfort.impl.DoorLockingBootBlindStateSerializer;
import de.esolutions.fw.comm.dsi.carcomfort.impl.DoorLockingComfortOpenSettingsSerializer;
import de.esolutions.fw.comm.dsi.carcomfort.impl.DoorLockingLockStatusSerializer;
import de.esolutions.fw.comm.dsi.carcomfort.impl.DoorLockingMessageSerializer;
import de.esolutions.fw.comm.dsi.carcomfort.impl.DoorLockingRearBlindSerializer;
import de.esolutions.fw.comm.dsi.carcomfort.impl.DoorLockingTheftWarningSettingsSerializer;
import de.esolutions.fw.comm.dsi.carcomfort.impl.DoorLockingUserListRA1Serializer;
import de.esolutions.fw.comm.dsi.carcomfort.impl.DoorLockingUserListUpdateInfoSerializer;
import de.esolutions.fw.comm.dsi.carcomfort.impl.DoorLockingUserProfileOnOffSerializer;
import de.esolutions.fw.comm.dsi.carcomfort.impl.DoorLockingViewOptionsSerializer;
import de.esolutions.fw.comm.dsi.carcomfort.impl.DoorLockingWindowStatusSerializer;
import de.esolutions.fw.comm.dsi.carcomfort.impl.MirrorViewOptionsSerializer;
import de.esolutions.fw.comm.dsi.carcomfort.impl.RDKResidualBatteryLifetimeSerializer;
import de.esolutions.fw.comm.dsi.carcomfort.impl.RDKTireDisplayDataSerializer;
import de.esolutions.fw.comm.dsi.carcomfort.impl.RDKTireInfoSerializer;
import de.esolutions.fw.comm.dsi.carcomfort.impl.RDKViewOptionsSerializer;
import de.esolutions.fw.comm.dsi.carcomfort.impl.RDKWheelPressuresSerializer;
import de.esolutions.fw.comm.dsi.carcomfort.impl.RGSBeltPretensionDataSerializer;
import de.esolutions.fw.comm.dsi.carcomfort.impl.RGSLocalHazardDetectionSerializer;
import de.esolutions.fw.comm.dsi.carcomfort.impl.RGSViewOptionsSerializer;
import de.esolutions.fw.comm.dsi.carcomfort.impl.UGDOButtonListRA0Serializer;
import de.esolutions.fw.comm.dsi.carcomfort.impl.UGDOButtonListRA1Serializer;
import de.esolutions.fw.comm.dsi.carcomfort.impl.UGDOButtonListRA2Serializer;
import de.esolutions.fw.comm.dsi.carcomfort.impl.UGDOButtonListRA3Serializer;
import de.esolutions.fw.comm.dsi.carcomfort.impl.UGDOButtonListRA4Serializer;
import de.esolutions.fw.comm.dsi.carcomfort.impl.UGDOButtonListRA5Serializer;
import de.esolutions.fw.comm.dsi.carcomfort.impl.UGDOButtonListUpdateInfoSerializer;
import de.esolutions.fw.comm.dsi.carcomfort.impl.UGDOContentSerializer;
import de.esolutions.fw.comm.dsi.carcomfort.impl.UGDODestinationReachedSerializer;
import de.esolutions.fw.comm.dsi.carcomfort.impl.UGDOLearningDataSerializer;
import de.esolutions.fw.comm.dsi.carcomfort.impl.UGDOOpenDoorSerializer;
import de.esolutions.fw.comm.dsi.carcomfort.impl.UGDOSynchronisationSerializer;
import de.esolutions.fw.comm.dsi.carcomfort.impl.UGDOVersionDataSerializer;
import de.esolutions.fw.comm.dsi.carcomfort.impl.UGDOViewOptionsSerializer;
import de.esolutions.fw.comm.dsi.carcomfort.impl.WiperViewOptionsSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;
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

public class DSICarComfortReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.dsi.carcomfort.DSICarComfort");
    private static int dynamicHandle = 0;
    private DSICarComfortReply p_DSICarComfortReply;

    public DSICarComfortReplyService(DSICarComfortReply dSICarComfortReply) {
        super(new ServiceInstanceID("2e8af354-835e-5d86-ab41-fa96126e848b", DSICarComfortReplyService.nextDynamicHandle(), "f8c95cac-a9be-5705-a37f-990f77cfe57f", "dsi.carcomfort.DSICarComfort"));
        this.p_DSICarComfortReply = dSICarComfortReply;
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
                case 176: {
                    RGSViewOptions rGSViewOptions = RGSViewOptionsSerializer.getOptionalRGSViewOptions(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarComfortReply.updateRGSViewOptions(rGSViewOptions, n);
                    break;
                }
                case 96: {
                    RGSBeltPretensionData rGSBeltPretensionData = RGSBeltPretensionDataSerializer.getOptionalRGSBeltPretensionData(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarComfortReply.updateRGSBeltPretensionDataFront(rGSBeltPretensionData, n);
                    break;
                }
                case 97: {
                    RGSBeltPretensionData rGSBeltPretensionData = RGSBeltPretensionDataSerializer.getOptionalRGSBeltPretensionData(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarComfortReply.updateRGSBeltPretensionDataRear(rGSBeltPretensionData, n);
                    break;
                }
                case 98: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarComfortReply.updateRGSPreCrashSystem(bl, n);
                    break;
                }
                case 2: {
                    boolean bl = iDeserializer.getBool();
                    this.p_DSICarComfortReply.acknowledgeRgsSetFactoryDefault(bl);
                    break;
                }
                case 145: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarComfortReply.updateRGSPreSenseSystem(bl, n);
                    break;
                }
                case 175: {
                    int n = iDeserializer.getInt32();
                    int n2 = iDeserializer.getInt32();
                    this.p_DSICarComfortReply.updateRGSPreSenseWarning(n, n2);
                    break;
                }
                case 174: {
                    RGSLocalHazardDetection rGSLocalHazardDetection = RGSLocalHazardDetectionSerializer.getOptionalRGSLocalHazardDetection(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarComfortReply.updateRGSLocalHazardDetection(rGSLocalHazardDetection, n);
                    break;
                }
                case 260: {
                    DoorLockingViewOptions doorLockingViewOptions = DoorLockingViewOptionsSerializer.getOptionalDoorLockingViewOptions(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarComfortReply.updateDoorLockingViewOptions(doorLockingViewOptions, n);
                    break;
                }
                case 75: {
                    DoorLockingMessage doorLockingMessage = DoorLockingMessageSerializer.getOptionalDoorLockingMessage(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarComfortReply.updateDoorLockingMessage(doorLockingMessage, n);
                    break;
                }
                case 178: {
                    DoorLockingLockStatus doorLockingLockStatus = DoorLockingLockStatusSerializer.getOptionalDoorLockingLockStatus(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarComfortReply.updateDoorLockingLockStatus(doorLockingLockStatus, n);
                    break;
                }
                case 82: {
                    DoorLockingWindowStatus doorLockingWindowStatus = DoorLockingWindowStatusSerializer.getOptionalDoorLockingWindowStatus(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarComfortReply.updateDoorLockingWindowStatus(doorLockingWindowStatus, n);
                    break;
                }
                case 72: {
                    DoorLockingComfortOpenSettings doorLockingComfortOpenSettings = DoorLockingComfortOpenSettingsSerializer.getOptionalDoorLockingComfortOpenSettings(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarComfortReply.updateDoorLockingComfortOpenSettings(doorLockingComfortOpenSettings, n);
                    break;
                }
                case 79: {
                    DoorLockingTheftWarningSettings doorLockingTheftWarningSettings = DoorLockingTheftWarningSettingsSerializer.getOptionalDoorLockingTheftWarningSettings(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarComfortReply.updateDoorLockingTheftWarningSettings(doorLockingTheftWarningSettings, n);
                    break;
                }
                case 172: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarComfortReply.updateDoorLockingClBootOpen(bl, n);
                    break;
                }
                case 144: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarComfortReply.updateDoorLockingBootOpen(bl, n);
                    break;
                }
                case 170: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarComfortReply.updateDoorLockingBootClose(bl, n);
                    break;
                }
                case 80: {
                    int n = iDeserializer.getInt32();
                    int n3 = iDeserializer.getInt32();
                    this.p_DSICarComfortReply.updateDoorLockingUnlockingMode(n, n3);
                    break;
                }
                case 68: {
                    int n = iDeserializer.getInt32();
                    int n4 = iDeserializer.getInt32();
                    this.p_DSICarComfortReply.updateDoorLockingAutoLock(n, n4);
                    break;
                }
                case 69: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarComfortReply.updateDoorLockingAutoUnlock(bl, n);
                    break;
                }
                case 171: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarComfortReply.updateDoorLockingClBootLock(bl, n);
                    break;
                }
                case 76: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarComfortReply.updateDoorLockingMirrorProtection(bl, n);
                    break;
                }
                case 73: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarComfortReply.updateDoorLockingConfirmation(bl, n);
                    break;
                }
                case 77: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarComfortReply.updateDoorLockingRainClosing(bl, n);
                    break;
                }
                case 78: {
                    DoorLockingRearBlind doorLockingRearBlind = DoorLockingRearBlindSerializer.getOptionalDoorLockingRearBlind(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarComfortReply.updateDoorLockingRearBlind(doorLockingRearBlind, n);
                    break;
                }
                case 0: {
                    boolean bl = iDeserializer.getBool();
                    this.p_DSICarComfortReply.acknowledgeDoorLockingSetFactoryDefault(bl);
                    break;
                }
                case 157: {
                    String string = iDeserializer.getOptionalString();
                    boolean bl = iDeserializer.getBool();
                    this.p_DSICarComfortReply.acknowledgeDoorLockingRemoteLockUnlock(string, bl);
                    break;
                }
                case 155: {
                    boolean bl = iDeserializer.getBool();
                    this.p_DSICarComfortReply.acknowledgeDoorLockingRemoteBlinking(bl);
                    break;
                }
                case 156: {
                    boolean bl = iDeserializer.getBool();
                    this.p_DSICarComfortReply.acknowledgeDoorLockingRemoteHorn(bl);
                    break;
                }
                case 159: {
                    String string = iDeserializer.getOptionalString();
                    this.p_DSICarComfortReply.receivedDoorLockingRemoteLockUnlockSignatureVerification(string);
                    break;
                }
                case 158: {
                    String string = iDeserializer.getOptionalString();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarComfortReply.receivedDoorLockingRemoteLockUnlockAuthentification(string, n);
                    break;
                }
                case 213: {
                    DoorLockingUserListUpdateInfo doorLockingUserListUpdateInfo = DoorLockingUserListUpdateInfoSerializer.getOptionalDoorLockingUserListUpdateInfo(iDeserializer);
                    DoorLockingUserListRA1[] doorLockingUserListRA1Array = DoorLockingUserListRA1Serializer.getOptionalDoorLockingUserListRA1VarArray(iDeserializer);
                    this.p_DSICarComfortReply.responseDoorLockingUserListRA1(doorLockingUserListUpdateInfo, doorLockingUserListRA1Array);
                    break;
                }
                case 214: {
                    DoorLockingUserListUpdateInfo doorLockingUserListUpdateInfo = DoorLockingUserListUpdateInfoSerializer.getOptionalDoorLockingUserListUpdateInfo(iDeserializer);
                    int[] nArray = iDeserializer.getOptionalInt32VarArray();
                    this.p_DSICarComfortReply.responseDoorLockingUserListRAF(doorLockingUserListUpdateInfo, nArray);
                    break;
                }
                case 234: {
                    DoorLockingUserListUpdateInfo doorLockingUserListUpdateInfo = DoorLockingUserListUpdateInfoSerializer.getOptionalDoorLockingUserListUpdateInfo(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarComfortReply.updateDoorLockingUserListUpdateInfo(doorLockingUserListUpdateInfo, n);
                    break;
                }
                case 190: {
                    int n = iDeserializer.getInt32();
                    int n5 = iDeserializer.getInt32();
                    this.p_DSICarComfortReply.updateDoorLockingUserListTotalNumberOfElements(n, n5);
                    break;
                }
                case 189: {
                    int n = iDeserializer.getInt32();
                    int n6 = iDeserializer.getInt32();
                    this.p_DSICarComfortReply.updateDoorLockingActiveUser(n, n6);
                    break;
                }
                case 250: {
                    DoorLockingUserProfileOnOff doorLockingUserProfileOnOff = DoorLockingUserProfileOnOffSerializer.getOptionalDoorLockingUserProfileOnOff(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarComfortReply.updateDoorLockingUserProfileOnOff(doorLockingUserProfileOnOff, n);
                    break;
                }
                case 179: {
                    int n = iDeserializer.getInt32();
                    boolean bl = iDeserializer.getBool();
                    this.p_DSICarComfortReply.acknowledgeDoorLockingUserProfileControl(n, bl);
                    break;
                }
                case 249: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    boolean bl2 = iDeserializer.getBool();
                    int n7 = iDeserializer.getInt32();
                    this.p_DSICarComfortReply.updateDoorLockingUserProfileControlProcessing(bl, n, bl2, n7);
                    break;
                }
                case 206: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarComfortReply.updateDoorLockingWindowAutoClose(bl, n);
                    break;
                }
                case 233: {
                    int n = iDeserializer.getInt32();
                    int n8 = iDeserializer.getInt32();
                    this.p_DSICarComfortReply.updateDoorLockingBlindsControl(n, n8);
                    break;
                }
                case 256: {
                    DoorLockingBootBlindState doorLockingBootBlindState = DoorLockingBootBlindStateSerializer.getOptionalDoorLockingBootBlindState(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarComfortReply.updateDoorLockingBlindsControlExtended(doorLockingBootBlindState, n);
                    break;
                }
                case 258: {
                    int n = iDeserializer.getInt32();
                    int n9 = iDeserializer.getInt32();
                    this.p_DSICarComfortReply.updateDoorLockingLeftSideBlindControl(n, n9);
                    break;
                }
                case 259: {
                    int n = iDeserializer.getInt32();
                    int n10 = iDeserializer.getInt32();
                    this.p_DSICarComfortReply.updateDoorLockingRightSideBlindControl(n, n10);
                    break;
                }
                case 248: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarComfortReply.updateDoorLockingTurnIndRepeat(bl, n);
                    break;
                }
                case 257: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarComfortReply.updateDoorLockingKeyless(bl, n);
                    break;
                }
                case 109: {
                    WiperViewOptions wiperViewOptions = WiperViewOptionsSerializer.getOptionalWiperViewOptions(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarComfortReply.updateWiperViewOptions(wiperViewOptions, n);
                    break;
                }
                case 107: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarComfortReply.updateWiperServicePosition(bl, n);
                    break;
                }
                case 105: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarComfortReply.updateWiperRainSensorOnOff(bl, n);
                    break;
                }
                case 104: {
                    int n = iDeserializer.getInt32();
                    int n11 = iDeserializer.getInt32();
                    this.p_DSICarComfortReply.updateWiperRainSensorConfig(n, n11);
                    break;
                }
                case 106: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarComfortReply.updateWiperRearWiping(bl, n);
                    break;
                }
                case 108: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarComfortReply.updateWiperTearsWiping(bl, n);
                    break;
                }
                case 110: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarComfortReply.updateWiperWinterPosition(bl, n);
                    break;
                }
                case 83: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarComfortReply.updateEasyEntrySteeringColumn(bl, n);
                    break;
                }
                case 6: {
                    boolean bl = iDeserializer.getBool();
                    this.p_DSICarComfortReply.acknowledgeWiperSetFactoryDefault(bl);
                    break;
                }
                case 239: {
                    UGDOViewOptions uGDOViewOptions = UGDOViewOptionsSerializer.getOptionalUGDOViewOptions(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarComfortReply.updateUGDOViewOptions(uGDOViewOptions, n);
                    break;
                }
                case 101: {
                    UGDOLearningData uGDOLearningData = UGDOLearningDataSerializer.getOptionalUGDOLearningData(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarComfortReply.updateUGDOLearningData(uGDOLearningData, n);
                    break;
                }
                case 151: {
                    UGDODestinationReached uGDODestinationReached = UGDODestinationReachedSerializer.getOptionalUGDODestinationReached(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarComfortReply.updateUGDODestinationReached(uGDODestinationReached, n);
                    break;
                }
                case 152: {
                    UGDOOpenDoor uGDOOpenDoor = UGDOOpenDoorSerializer.getOptionalUGDOOpenDoor(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarComfortReply.updateUGDOOpenDoor(uGDOOpenDoor, n);
                    break;
                }
                case 150: {
                    UGDOContent uGDOContent = UGDOContentSerializer.getOptionalUGDOContent(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarComfortReply.updateUGDOContent(uGDOContent, n);
                    break;
                }
                case 102: {
                    UGDOVersionData uGDOVersionData = UGDOVersionDataSerializer.getOptionalUGDOVersionData(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarComfortReply.updateUGDOVersionData(uGDOVersionData, n);
                    break;
                }
                case 117: {
                    boolean bl = iDeserializer.getBool();
                    this.p_DSICarComfortReply.acknowledgeUGDOSetFactoryDefault(bl);
                    break;
                }
                case 238: {
                    UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo = UGDOButtonListUpdateInfoSerializer.getOptionalUGDOButtonListUpdateInfo(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarComfortReply.updateUGDOButtonListUpdateInfo(uGDOButtonListUpdateInfo, n);
                    break;
                }
                case 148: {
                    int n = iDeserializer.getInt32();
                    int n12 = iDeserializer.getInt32();
                    this.p_DSICarComfortReply.updateUGDOButtonListTotalNumberOfElements(n, n12);
                    break;
                }
                case 121: {
                    UGDOContent uGDOContent = UGDOContentSerializer.getOptionalUGDOContent(iDeserializer);
                    this.p_DSICarComfortReply.requestUGDOPopup(uGDOContent);
                    break;
                }
                case 116: {
                    UGDOContent uGDOContent = UGDOContentSerializer.getOptionalUGDOContent(iDeserializer);
                    this.p_DSICarComfortReply.acknowledgeUGDOPopup(uGDOContent);
                    break;
                }
                case 114: {
                    boolean bl = iDeserializer.getBool();
                    this.p_DSICarComfortReply.acknowledgeUGDODeleteButton(bl);
                    break;
                }
                case 118: {
                    UGDOSynchronisation uGDOSynchronisation = UGDOSynchronisationSerializer.getOptionalUGDOSynchronisation(iDeserializer);
                    this.p_DSICarComfortReply.acknowledgeUGDOSynchronisation(uGDOSynchronisation);
                    break;
                }
                case 180: {
                    int n = iDeserializer.getInt32();
                    int n13 = iDeserializer.getInt32();
                    this.p_DSICarComfortReply.acknowledgeUGDOLearning(n, n13);
                    break;
                }
                case 122: {
                    UGDOSynchronisation uGDOSynchronisation = UGDOSynchronisationSerializer.getOptionalUGDOSynchronisation(iDeserializer);
                    this.p_DSICarComfortReply.requestUGDOSynchronisation(uGDOSynchronisation);
                    break;
                }
                case 215: {
                    UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo = UGDOButtonListUpdateInfoSerializer.getOptionalUGDOButtonListUpdateInfo(iDeserializer);
                    UGDOButtonListRA0[] uGDOButtonListRA0Array = UGDOButtonListRA0Serializer.getOptionalUGDOButtonListRA0VarArray(iDeserializer);
                    this.p_DSICarComfortReply.responseUGDOButtonListRA0(uGDOButtonListUpdateInfo, uGDOButtonListRA0Array);
                    break;
                }
                case 216: {
                    UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo = UGDOButtonListUpdateInfoSerializer.getOptionalUGDOButtonListUpdateInfo(iDeserializer);
                    UGDOButtonListRA1[] uGDOButtonListRA1Array = UGDOButtonListRA1Serializer.getOptionalUGDOButtonListRA1VarArray(iDeserializer);
                    this.p_DSICarComfortReply.responseUGDOButtonListRA1(uGDOButtonListUpdateInfo, uGDOButtonListRA1Array);
                    break;
                }
                case 217: {
                    UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo = UGDOButtonListUpdateInfoSerializer.getOptionalUGDOButtonListUpdateInfo(iDeserializer);
                    UGDOButtonListRA2[] uGDOButtonListRA2Array = UGDOButtonListRA2Serializer.getOptionalUGDOButtonListRA2VarArray(iDeserializer);
                    this.p_DSICarComfortReply.responseUGDOButtonListRA2(uGDOButtonListUpdateInfo, uGDOButtonListRA2Array);
                    break;
                }
                case 218: {
                    UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo = UGDOButtonListUpdateInfoSerializer.getOptionalUGDOButtonListUpdateInfo(iDeserializer);
                    UGDOButtonListRA3[] uGDOButtonListRA3Array = UGDOButtonListRA3Serializer.getOptionalUGDOButtonListRA3VarArray(iDeserializer);
                    this.p_DSICarComfortReply.responseUGDOButtonListRA3(uGDOButtonListUpdateInfo, uGDOButtonListRA3Array);
                    break;
                }
                case 219: {
                    UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo = UGDOButtonListUpdateInfoSerializer.getOptionalUGDOButtonListUpdateInfo(iDeserializer);
                    UGDOButtonListRA4[] uGDOButtonListRA4Array = UGDOButtonListRA4Serializer.getOptionalUGDOButtonListRA4VarArray(iDeserializer);
                    this.p_DSICarComfortReply.responseUGDOButtonListRA4(uGDOButtonListUpdateInfo, uGDOButtonListRA4Array);
                    break;
                }
                case 220: {
                    UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo = UGDOButtonListUpdateInfoSerializer.getOptionalUGDOButtonListUpdateInfo(iDeserializer);
                    UGDOButtonListRA5[] uGDOButtonListRA5Array = UGDOButtonListRA5Serializer.getOptionalUGDOButtonListRA5VarArray(iDeserializer);
                    this.p_DSICarComfortReply.responseUGDOButtonListRA5(uGDOButtonListUpdateInfo, uGDOButtonListRA5Array);
                    break;
                }
                case 221: {
                    UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo = UGDOButtonListUpdateInfoSerializer.getOptionalUGDOButtonListUpdateInfo(iDeserializer);
                    int[] nArray = iDeserializer.getOptionalInt32VarArray();
                    this.p_DSICarComfortReply.responseUGDOButtonListRAF(uGDOButtonListUpdateInfo, nArray);
                    break;
                }
                case 237: {
                    RDKViewOptions rDKViewOptions = RDKViewOptionsSerializer.getOptionalRDKViewOptions(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarComfortReply.updateRDKViewOptions(rDKViewOptions, n);
                    break;
                }
                case 91: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarComfortReply.updateRDKSystemOnOff(bl, n);
                    break;
                }
                case 236: {
                    RDKTireInfo[] rDKTireInfoArray = RDKTireInfoSerializer.getOptionalRDKTireInfoVarArray(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarComfortReply.updateRDKTireSetupTireList(rDKTireInfoArray, n);
                    break;
                }
                case 93: {
                    int n = iDeserializer.getInt32();
                    int n14 = iDeserializer.getInt32();
                    this.p_DSICarComfortReply.updateRDKTireSetupSelectedTire(n, n14);
                    break;
                }
                case 92: {
                    RDKTireDisplayData rDKTireDisplayData = RDKTireDisplayDataSerializer.getOptionalRDKTireDisplayData(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarComfortReply.updateRDKTireDisplay(rDKTireDisplayData, n);
                    break;
                }
                case 90: {
                    int n = iDeserializer.getInt32();
                    int n15 = iDeserializer.getInt32();
                    this.p_DSICarComfortReply.updateRDKSpeedLimit(n, n15);
                    break;
                }
                case 17: {
                    int n = iDeserializer.getInt32();
                    this.p_DSICarComfortReply.responseRDKTireChanged(n);
                    break;
                }
                case 16: {
                    int n = iDeserializer.getInt32();
                    this.p_DSICarComfortReply.responseRDKPressureChanged(n);
                    break;
                }
                case 15: {
                    this.p_DSICarComfortReply.responseRDKLifeMonitoring();
                    break;
                }
                case 200: {
                    byte by = iDeserializer.getInt8();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarComfortReply.updateRDKPressureLevel(by, n);
                    break;
                }
                case 210: {
                    boolean bl = iDeserializer.getBool();
                    this.p_DSICarComfortReply.acknowledgeRDKSetFactoryDefault(bl);
                    break;
                }
                case 209: {
                    boolean bl = iDeserializer.getBool();
                    this.p_DSICarComfortReply.acknowledgeRDKPressureChanged(bl);
                    break;
                }
                case 89: {
                    MirrorViewOptions mirrorViewOptions = MirrorViewOptionsSerializer.getOptionalMirrorViewOptions(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarComfortReply.updateMirrorViewOptions(mirrorViewOptions, n);
                    break;
                }
                case 87: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarComfortReply.updateMirrorLowering(bl, n);
                    break;
                }
                case 88: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarComfortReply.updateMirrorSyncAdjust(bl, n);
                    break;
                }
                case 85: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarComfortReply.updateMirrorFolding(bl, n);
                    break;
                }
                case 84: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarComfortReply.updateMirrorDimming(bl, n);
                    break;
                }
                case 86: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarComfortReply.updateMirrorHeating(bl, n);
                    break;
                }
                case 1: {
                    boolean bl = iDeserializer.getBool();
                    this.p_DSICarComfortReply.acknowledgeMirrorSetFactoryDefault(bl);
                    break;
                }
                case 246: {
                    BrakeViewOptions brakeViewOptions = BrakeViewOptionsSerializer.getOptionalBrakeViewOptions(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarComfortReply.updateBrakeViewOptions(brakeViewOptions, n);
                    break;
                }
                case 64: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarComfortReply.updateBrakeElectricalParking(bl, n);
                    break;
                }
                case 63: {
                    int n = iDeserializer.getInt32();
                    int n16 = iDeserializer.getInt32();
                    this.p_DSICarComfortReply.updateBrakeAutoHold(n, n16);
                    break;
                }
                case 65: {
                    int n = iDeserializer.getInt32();
                    int n17 = iDeserializer.getInt32();
                    this.p_DSICarComfortReply.updateBrakeEscMode(n, n17);
                    break;
                }
                case 197: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarComfortReply.updateBrakeHdcMode(bl, n);
                    break;
                }
                case 199: {
                    RDKWheelPressures rDKWheelPressures = RDKWheelPressuresSerializer.getOptionalRDKWheelPressures(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarComfortReply.updateRDKDifferentialPressure(rDKWheelPressures, n);
                    break;
                }
                case 201: {
                    RDKResidualBatteryLifetime rDKResidualBatteryLifetime = RDKResidualBatteryLifetimeSerializer.getOptionalRDKResidualBatteryLifetime(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarComfortReply.updateRDKResidualBatteryLifetime(rDKResidualBatteryLifetime, n);
                    break;
                }
                case 240: {
                    int n = iDeserializer.getInt32();
                    this.p_DSICarComfortReply.acknowledgeDoorLockingPrompt(n);
                    break;
                }
                case 242: {
                    int n = iDeserializer.getInt32();
                    this.p_DSICarComfortReply.requestDoorLockingPrompt(n);
                    break;
                }
                case 247: {
                    int n = iDeserializer.getInt32();
                    int n18 = iDeserializer.getInt32();
                    this.p_DSICarComfortReply.updateDoorLockingPromptContent(n, n18);
                    break;
                }
                case 7: {
                    int n = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    int n19 = iDeserializer.getInt32();
                    this.p_DSICarComfortReply.asyncException(n, string, n19);
                    break;
                }
                case 111: {
                    String string = iDeserializer.getOptionalString();
                    String string2 = iDeserializer.getOptionalString();
                    this.p_DSICarComfortReply.yyIndication(string, string2);
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

