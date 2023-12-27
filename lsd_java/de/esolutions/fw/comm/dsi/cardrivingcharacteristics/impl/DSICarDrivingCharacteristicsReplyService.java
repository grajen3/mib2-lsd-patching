/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.cardrivingcharacteristics.impl;

import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.cardrivingcharacteristics.DSICarDrivingCharacteristicsReply;
import de.esolutions.fw.comm.dsi.cardrivingcharacteristics.impl.CharismaListUpdateInfoSerializer;
import de.esolutions.fw.comm.dsi.cardrivingcharacteristics.impl.CharismaProgButtonSerializer;
import de.esolutions.fw.comm.dsi.cardrivingcharacteristics.impl.CharismaSetupTableWithOptionMaskSerializer;
import de.esolutions.fw.comm.dsi.cardrivingcharacteristics.impl.CharismaSetupTableWithoutOptionMaskSerializer;
import de.esolutions.fw.comm.dsi.cardrivingcharacteristics.impl.CharismaViewOptionsSerializer;
import de.esolutions.fw.comm.dsi.cardrivingcharacteristics.impl.SoundViewOptionsSerializer;
import de.esolutions.fw.comm.dsi.cardrivingcharacteristics.impl.SpoilerStateSerializer;
import de.esolutions.fw.comm.dsi.cardrivingcharacteristics.impl.SpoilerViewOptionsSerializer;
import de.esolutions.fw.comm.dsi.cardrivingcharacteristics.impl.SuspensionControlActuatorInfoSerializer;
import de.esolutions.fw.comm.dsi.cardrivingcharacteristics.impl.SuspensionControlAirProfilesSerializer;
import de.esolutions.fw.comm.dsi.cardrivingcharacteristics.impl.SuspensionControlDRCProfilesSerializer;
import de.esolutions.fw.comm.dsi.cardrivingcharacteristics.impl.SuspensionControlHeightInfoSerializer;
import de.esolutions.fw.comm.dsi.cardrivingcharacteristics.impl.SuspensionControlOperationMessagesSerializer;
import de.esolutions.fw.comm.dsi.cardrivingcharacteristics.impl.SuspensionControlViewOptionsSerializer;
import de.esolutions.fw.comm.dsi.cardrivingcharacteristics.impl.SuspensionControleABCPreviewSerializer;
import de.esolutions.fw.comm.dsi.cardrivingcharacteristics.impl.TADVehicleInfoSerializer;
import de.esolutions.fw.comm.dsi.cardrivingcharacteristics.impl.TADViewOptionsSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.cardrivingcharacteristics.CharismaListUpdateInfo;
import org.dsi.ifc.cardrivingcharacteristics.CharismaProgButton;
import org.dsi.ifc.cardrivingcharacteristics.CharismaSetupTableWithOptionMask;
import org.dsi.ifc.cardrivingcharacteristics.CharismaSetupTableWithoutOptionMask;
import org.dsi.ifc.cardrivingcharacteristics.CharismaViewOptions;
import org.dsi.ifc.cardrivingcharacteristics.SoundViewOptions;
import org.dsi.ifc.cardrivingcharacteristics.SpoilerState;
import org.dsi.ifc.cardrivingcharacteristics.SpoilerViewOptions;
import org.dsi.ifc.cardrivingcharacteristics.SuspensionControlActuatorInfo;
import org.dsi.ifc.cardrivingcharacteristics.SuspensionControlAirProfiles;
import org.dsi.ifc.cardrivingcharacteristics.SuspensionControlDRCProfiles;
import org.dsi.ifc.cardrivingcharacteristics.SuspensionControlHeightInfo;
import org.dsi.ifc.cardrivingcharacteristics.SuspensionControlOperationMessages;
import org.dsi.ifc.cardrivingcharacteristics.SuspensionControlViewOptions;
import org.dsi.ifc.cardrivingcharacteristics.SuspensionControleABCPreview;
import org.dsi.ifc.cardrivingcharacteristics.TADVehicleInfo;
import org.dsi.ifc.cardrivingcharacteristics.TADViewOptions;

public class DSICarDrivingCharacteristicsReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.dsi.cardrivingcharacteristics.DSICarDrivingCharacteristics");
    private static int dynamicHandle = 0;
    private DSICarDrivingCharacteristicsReply p_DSICarDrivingCharacteristicsReply;

    public DSICarDrivingCharacteristicsReplyService(DSICarDrivingCharacteristicsReply dSICarDrivingCharacteristicsReply) {
        super(new ServiceInstanceID("d04dc275-b36e-5ae6-935e-37ff4b68bfa3", DSICarDrivingCharacteristicsReplyService.nextDynamicHandle(), "8130d570-107f-5bbf-b44d-3d2d3cf5bed8", "dsi.cardrivingcharacteristics.DSICarDrivingCharacteristics"));
        this.p_DSICarDrivingCharacteristicsReply = dSICarDrivingCharacteristicsReply;
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
                case 116: {
                    SuspensionControlViewOptions suspensionControlViewOptions = SuspensionControlViewOptionsSerializer.getOptionalSuspensionControlViewOptions(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarDrivingCharacteristicsReply.updateSuspensionControlViewOptions(suspensionControlViewOptions, n);
                    break;
                }
                case 47: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarDrivingCharacteristicsReply.updateSuspensionControlLiftMode(bl, n);
                    break;
                }
                case 45: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarDrivingCharacteristicsReply.updateSuspensionControlCarJackMode(bl, n);
                    break;
                }
                case 50: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarDrivingCharacteristicsReply.updateSuspensionControlTrailerMode(bl, n);
                    break;
                }
                case 48: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarDrivingCharacteristicsReply.updateSuspensionControlLoadingMode(bl, n);
                    break;
                }
                case 44: {
                    int n = iDeserializer.getInt32();
                    int n2 = iDeserializer.getInt32();
                    this.p_DSICarDrivingCharacteristicsReply.updateSuspensionControlActiveProfile(n, n2);
                    break;
                }
                case 42: {
                    SuspensionControlAirProfiles suspensionControlAirProfiles = SuspensionControlAirProfilesSerializer.getOptionalSuspensionControlAirProfiles(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarDrivingCharacteristicsReply.updateSuspensionControlAccessibleAirProfiles(suspensionControlAirProfiles, n);
                    break;
                }
                case 69: {
                    SuspensionControlDRCProfiles suspensionControlDRCProfiles = SuspensionControlDRCProfilesSerializer.getOptionalSuspensionControlDRCProfiles(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarDrivingCharacteristicsReply.updateSuspensionControlAccessibleDRCProfiles(suspensionControlDRCProfiles, n);
                    break;
                }
                case 51: {
                    int n = iDeserializer.getInt32();
                    int n3 = iDeserializer.getInt32();
                    this.p_DSICarDrivingCharacteristicsReply.updateSuspensionControlVehicleStatus(n, n3);
                    break;
                }
                case 70: {
                    int n = iDeserializer.getInt32();
                    int n4 = iDeserializer.getInt32();
                    this.p_DSICarDrivingCharacteristicsReply.updateSuspensionControlCurrentLevel(n, n4);
                    break;
                }
                case 73: {
                    int n = iDeserializer.getInt32();
                    int n5 = iDeserializer.getInt32();
                    this.p_DSICarDrivingCharacteristicsReply.updateSuspensionControlTargetLevel(n, n5);
                    break;
                }
                case 71: {
                    SuspensionControlHeightInfo suspensionControlHeightInfo = SuspensionControlHeightInfoSerializer.getOptionalSuspensionControlHeightInfo(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarDrivingCharacteristicsReply.updateSuspensionControlHeightInfo(suspensionControlHeightInfo, n);
                    break;
                }
                case 72: {
                    SuspensionControlOperationMessages suspensionControlOperationMessages = SuspensionControlOperationMessagesSerializer.getOptionalSuspensionControlOperationMessages(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarDrivingCharacteristicsReply.updateSuspensionControlOperationMessages(suspensionControlOperationMessages, n);
                    break;
                }
                case 90: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarDrivingCharacteristicsReply.updateSuspensionControlSnowChainMode(bl, n);
                    break;
                }
                case 91: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarDrivingCharacteristicsReply.updateSuspensionControlVehicleStateControl(bl, n);
                    break;
                }
                case 114: {
                    int n = iDeserializer.getInt32();
                    boolean bl = iDeserializer.getBool();
                    int n6 = iDeserializer.getInt32();
                    this.p_DSICarDrivingCharacteristicsReply.updateSuspensionControlActiveMode(n, bl, n6);
                    break;
                }
                case 117: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarDrivingCharacteristicsReply.updateeABCEasyEntry(bl, n);
                    break;
                }
                case 118: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarDrivingCharacteristicsReply.updateeABCPitchControl(bl, n);
                    break;
                }
                case 121: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarDrivingCharacteristicsReply.updateeABCSpecialPosition(bl, n);
                    break;
                }
                case 119: {
                    int n = iDeserializer.getInt32();
                    int n7 = iDeserializer.getInt32();
                    this.p_DSICarDrivingCharacteristicsReply.updateeABCPreview(n, n7);
                    break;
                }
                case 120: {
                    SuspensionControleABCPreview suspensionControleABCPreview = SuspensionControleABCPreviewSerializer.getOptionalSuspensionControleABCPreview(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarDrivingCharacteristicsReply.updateeABCPreviewState(suspensionControleABCPreview, n);
                    break;
                }
                case 115: {
                    SuspensionControlActuatorInfo suspensionControlActuatorInfo = SuspensionControlActuatorInfoSerializer.getOptionalSuspensionControlActuatorInfo(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarDrivingCharacteristicsReply.updateSuspensionControlActuatorInfo(suspensionControlActuatorInfo, n);
                    break;
                }
                case 109: {
                    CharismaViewOptions charismaViewOptions = CharismaViewOptionsSerializer.getOptionalCharismaViewOptions(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarDrivingCharacteristicsReply.updateCharismaViewOptions(charismaViewOptions, n);
                    break;
                }
                case 35: {
                    int n = iDeserializer.getInt32();
                    int n8 = iDeserializer.getInt32();
                    this.p_DSICarDrivingCharacteristicsReply.updateCharismaActiveProfile(n, n8);
                    break;
                }
                case 65: {
                    int n = iDeserializer.getInt32();
                    int n9 = iDeserializer.getInt32();
                    this.p_DSICarDrivingCharacteristicsReply.updateCharismaActiveOperationMode(n, n9);
                    break;
                }
                case 37: {
                    CharismaListUpdateInfo charismaListUpdateInfo = CharismaListUpdateInfoSerializer.getOptionalCharismaListUpdateInfo(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarDrivingCharacteristicsReply.updateCharismaListUpdateInfo(charismaListUpdateInfo, n);
                    break;
                }
                case 36: {
                    int n = iDeserializer.getInt32();
                    int n10 = iDeserializer.getInt32();
                    this.p_DSICarDrivingCharacteristicsReply.updateCharismaContent(n, n10);
                    break;
                }
                case 39: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarDrivingCharacteristicsReply.updateCharismaTrailerDetection(bl, n);
                    break;
                }
                case 40: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarDrivingCharacteristicsReply.updateCharismaTrailerSetting(bl, n);
                    break;
                }
                case 38: {
                    CharismaProgButton charismaProgButton = CharismaProgButtonSerializer.getOptionalCharismaProgButton(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarDrivingCharacteristicsReply.updateCharismaProgButton(charismaProgButton, n);
                    break;
                }
                case 96: {
                    int n = iDeserializer.getInt32();
                    int n11 = iDeserializer.getInt32();
                    int n12 = iDeserializer.getInt32();
                    CharismaSetupTableWithOptionMask[] charismaSetupTableWithOptionMaskArray = CharismaSetupTableWithOptionMaskSerializer.getOptionalCharismaSetupTableWithOptionMaskVarArray(iDeserializer);
                    this.p_DSICarDrivingCharacteristicsReply.responseCharismaListWithOptionMask(n, n11, n12, charismaSetupTableWithOptionMaskArray);
                    break;
                }
                case 97: {
                    int n = iDeserializer.getInt32();
                    int n13 = iDeserializer.getInt32();
                    int n14 = iDeserializer.getInt32();
                    CharismaSetupTableWithoutOptionMask[] charismaSetupTableWithoutOptionMaskArray = CharismaSetupTableWithoutOptionMaskSerializer.getOptionalCharismaSetupTableWithoutOptionMaskVarArray(iDeserializer);
                    this.p_DSICarDrivingCharacteristicsReply.responseCharismaListWithoutOptionMask(n, n13, n14, charismaSetupTableWithoutOptionMaskArray);
                    break;
                }
                case 13: {
                    int n = iDeserializer.getInt32();
                    this.p_DSICarDrivingCharacteristicsReply.requestCharismaPopup(n);
                    break;
                }
                case 0: {
                    int n = iDeserializer.getInt32();
                    this.p_DSICarDrivingCharacteristicsReply.acknowledgeCharismaPopup(n);
                    break;
                }
                case 1: {
                    boolean bl = iDeserializer.getBool();
                    this.p_DSICarDrivingCharacteristicsReply.acknowledgeCharismaSetFactoryDefault(bl);
                    break;
                }
                case 108: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarDrivingCharacteristicsReply.updateCharismaSound(bl, n);
                    break;
                }
                case 93: {
                    TADViewOptions tADViewOptions = TADViewOptionsSerializer.getOptionalTADViewOptions(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarDrivingCharacteristicsReply.updateTADViewOptions(tADViewOptions, n);
                    break;
                }
                case 53: {
                    int n = iDeserializer.getInt32();
                    int n15 = iDeserializer.getInt32();
                    this.p_DSICarDrivingCharacteristicsReply.updateTADContent(n, n15);
                    break;
                }
                case 15: {
                    int n = iDeserializer.getInt32();
                    this.p_DSICarDrivingCharacteristicsReply.requestTADPopup(n);
                    break;
                }
                case 4: {
                    int n = iDeserializer.getInt32();
                    this.p_DSICarDrivingCharacteristicsReply.acknowledgeTADPopup(n);
                    break;
                }
                case 5: {
                    boolean bl = iDeserializer.getBool();
                    this.p_DSICarDrivingCharacteristicsReply.acknowledgeTADSetFactoryDefault(bl);
                    break;
                }
                case 3: {
                    boolean bl = iDeserializer.getBool();
                    this.p_DSICarDrivingCharacteristicsReply.acknowledgeTADMaxMinAngleReset(bl);
                    break;
                }
                case 60: {
                    TADVehicleInfo tADVehicleInfo = TADVehicleInfoSerializer.getOptionalTADVehicleInfo(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarDrivingCharacteristicsReply.updateTADVehicleInfo(tADVehicleInfo, n);
                    break;
                }
                case 55: {
                    float f2 = iDeserializer.getFloat();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarDrivingCharacteristicsReply.updateTADCurrentRollAngle(f2, n);
                    break;
                }
                case 54: {
                    float f3 = iDeserializer.getFloat();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarDrivingCharacteristicsReply.updateTADCurrentPitchAngle(f3, n);
                    break;
                }
                case 59: {
                    float f4 = iDeserializer.getFloat();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarDrivingCharacteristicsReply.updateTADPosMaxRollAngle(f4, n);
                    break;
                }
                case 57: {
                    float f5 = iDeserializer.getFloat();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarDrivingCharacteristicsReply.updateTADNegMaxRollAngle(f5, n);
                    break;
                }
                case 58: {
                    float f6 = iDeserializer.getFloat();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarDrivingCharacteristicsReply.updateTADPosMaxPitchAngle(f6, n);
                    break;
                }
                case 56: {
                    float f7 = iDeserializer.getFloat();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarDrivingCharacteristicsReply.updateTADNegMaxPitchAngle(f7, n);
                    break;
                }
                case 89: {
                    SpoilerViewOptions spoilerViewOptions = SpoilerViewOptionsSerializer.getOptionalSpoilerViewOptions(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarDrivingCharacteristicsReply.updateSpoilerViewOptions(spoilerViewOptions, n);
                    break;
                }
                case 86: {
                    int n = iDeserializer.getInt32();
                    int n16 = iDeserializer.getInt32();
                    this.p_DSICarDrivingCharacteristicsReply.updateSpoilerPositionSelection(n, n16);
                    break;
                }
                case 87: {
                    SpoilerState spoilerState = SpoilerStateSerializer.getOptionalSpoilerState(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarDrivingCharacteristicsReply.updateSpoilerState(spoilerState, n);
                    break;
                }
                case 84: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarDrivingCharacteristicsReply.updateSpoilerActuation(bl, n);
                    break;
                }
                case 85: {
                    int n = iDeserializer.getInt32();
                    int n17 = iDeserializer.getInt32();
                    this.p_DSICarDrivingCharacteristicsReply.updateSpoilerMessages(n, n17);
                    break;
                }
                case 88: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarDrivingCharacteristicsReply.updateSpoilerSystemOnOff(bl, n);
                    break;
                }
                case 77: {
                    boolean bl = iDeserializer.getBool();
                    this.p_DSICarDrivingCharacteristicsReply.acknowledgeSpoilerSetFactoryDefault(bl);
                    break;
                }
                case 113: {
                    SoundViewOptions soundViewOptions = SoundViewOptionsSerializer.getOptionalSoundViewOptions(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarDrivingCharacteristicsReply.updateSoundViewOptions(soundViewOptions, n);
                    break;
                }
                case 111: {
                    int n = iDeserializer.getInt32();
                    int n18 = iDeserializer.getInt32();
                    this.p_DSICarDrivingCharacteristicsReply.updateSoundStyle(n, n18);
                    break;
                }
                case 112: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarDrivingCharacteristicsReply.updateSoundSystemOnOff(bl, n);
                    break;
                }
                case 110: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarDrivingCharacteristicsReply.updateSoundOnOff(bl, n);
                    break;
                }
                case 94: {
                    boolean bl = iDeserializer.getBool();
                    this.p_DSICarDrivingCharacteristicsReply.acknowledgeSoundSetFactoryDefault(bl);
                    break;
                }
                case 6: {
                    int n = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    int n19 = iDeserializer.getInt32();
                    this.p_DSICarDrivingCharacteristicsReply.asyncException(n, string, n19);
                    break;
                }
                case 62: {
                    String string = iDeserializer.getOptionalString();
                    String string2 = iDeserializer.getOptionalString();
                    this.p_DSICarDrivingCharacteristicsReply.yyIndication(string, string2);
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

