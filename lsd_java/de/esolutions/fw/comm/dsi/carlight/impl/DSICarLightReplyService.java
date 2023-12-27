/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carlight.impl;

import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.carlight.DSICarLightReply;
import de.esolutions.fw.comm.dsi.carlight.impl.ExtLightLampErrorDetectionStateSerializer;
import de.esolutions.fw.comm.dsi.carlight.impl.ExtLightLampErrorDetectionStateTrailerSerializer;
import de.esolutions.fw.comm.dsi.carlight.impl.ExtLightSensorErrorDetectionStateSerializer;
import de.esolutions.fw.comm.dsi.carlight.impl.ExtLightViewOptionsSerializer;
import de.esolutions.fw.comm.dsi.carlight.impl.IntLightBrightnessSerializer;
import de.esolutions.fw.comm.dsi.carlight.impl.IntLightRGBColorListRA0Serializer;
import de.esolutions.fw.comm.dsi.carlight.impl.IntLightRGBColorListUpdateInfoSerializer;
import de.esolutions.fw.comm.dsi.carlight.impl.IntLightRGBValuesSerializer;
import de.esolutions.fw.comm.dsi.carlight.impl.IntLightViewOptionsSerializer;
import de.esolutions.fw.comm.dsi.carlight.impl.MotorwayBlinkingSettingsSerializer;
import de.esolutions.fw.comm.dsi.carlight.impl.TimeStateSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.carlight.ExtLightLampErrorDetectionState;
import org.dsi.ifc.carlight.ExtLightLampErrorDetectionStateTrailer;
import org.dsi.ifc.carlight.ExtLightSensorErrorDetectionState;
import org.dsi.ifc.carlight.ExtLightViewOptions;
import org.dsi.ifc.carlight.IntLightBrightness;
import org.dsi.ifc.carlight.IntLightRGBColorListRA0;
import org.dsi.ifc.carlight.IntLightRGBColorListUpdateInfo;
import org.dsi.ifc.carlight.IntLightRGBValues;
import org.dsi.ifc.carlight.IntLightViewOptions;
import org.dsi.ifc.carlight.MotorwayBlinkingSettings;
import org.dsi.ifc.carlight.TimeState;

public class DSICarLightReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.dsi.carlight.DSICarLight");
    private static int dynamicHandle = 0;
    private DSICarLightReply p_DSICarLightReply;

    public DSICarLightReplyService(DSICarLightReply dSICarLightReply) {
        super(new ServiceInstanceID("6fd298cf-7a4c-5cc0-9482-6d593f42abf7", DSICarLightReplyService.nextDynamicHandle(), "9fa84c8c-aed2-5cbc-9bde-ffca3b651341", "dsi.carlight.DSICarLight"));
        this.p_DSICarLightReply = dSICarLightReply;
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
                case 94: {
                    IntLightViewOptions intLightViewOptions = IntLightViewOptionsSerializer.getOptionalIntLightViewOptions(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarLightReply.updateIntLightViewOptions(intLightViewOptions, n);
                    break;
                }
                case 48: {
                    int n = iDeserializer.getInt32();
                    int n2 = iDeserializer.getInt32();
                    this.p_DSICarLightReply.updateIntLightIlluminationSet1(n, n2);
                    break;
                }
                case 49: {
                    int n = iDeserializer.getInt32();
                    int n3 = iDeserializer.getInt32();
                    this.p_DSICarLightReply.updateIntLightIlluminationSet2(n, n3);
                    break;
                }
                case 50: {
                    int n = iDeserializer.getInt32();
                    int n4 = iDeserializer.getInt32();
                    this.p_DSICarLightReply.updateIntLightIlluminationSet3(n, n4);
                    break;
                }
                case 51: {
                    int n = iDeserializer.getInt32();
                    int n5 = iDeserializer.getInt32();
                    this.p_DSICarLightReply.updateIntLightIlluminationSet4(n, n5);
                    break;
                }
                case 52: {
                    int n = iDeserializer.getInt32();
                    int n6 = iDeserializer.getInt32();
                    this.p_DSICarLightReply.updateIntLightIlluminationSet5(n, n6);
                    break;
                }
                case 53: {
                    int n = iDeserializer.getInt32();
                    int n7 = iDeserializer.getInt32();
                    this.p_DSICarLightReply.updateIntLightIlluminationSet6(n, n7);
                    break;
                }
                case 54: {
                    int n = iDeserializer.getInt32();
                    int n8 = iDeserializer.getInt32();
                    this.p_DSICarLightReply.updateIntLightIlluminationSet7(n, n8);
                    break;
                }
                case 55: {
                    int n = iDeserializer.getInt32();
                    int n9 = iDeserializer.getInt32();
                    this.p_DSICarLightReply.updateIntLightIlluminationSet8(n, n9);
                    break;
                }
                case 58: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarLightReply.updateIntLightTemperature(bl, n);
                    break;
                }
                case 46: {
                    int n = iDeserializer.getInt32();
                    int n10 = iDeserializer.getInt32();
                    this.p_DSICarLightReply.updateIntLightColour(n, n10);
                    break;
                }
                case 57: {
                    int n = iDeserializer.getInt32();
                    int n11 = iDeserializer.getInt32();
                    this.p_DSICarLightReply.updateIntLightState(n, n11);
                    break;
                }
                case 47: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarLightReply.updateIntLightEnvironment(bl, n);
                    break;
                }
                case 56: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarLightReply.updateIntLightSpeed(bl, n);
                    break;
                }
                case 86: {
                    IntLightBrightness intLightBrightness = IntLightBrightnessSerializer.getOptionalIntLightBrightness(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarLightReply.updateIntLightBrightness(intLightBrightness, n);
                    break;
                }
                case 75: {
                    int n = iDeserializer.getInt32();
                    int n12 = iDeserializer.getInt32();
                    this.p_DSICarLightReply.updateIntLightIlluminationProfile1(n, n12);
                    break;
                }
                case 76: {
                    int n = iDeserializer.getInt32();
                    int n13 = iDeserializer.getInt32();
                    this.p_DSICarLightReply.updateIntLightIlluminationProfile2(n, n13);
                    break;
                }
                case 77: {
                    int n = iDeserializer.getInt32();
                    int n14 = iDeserializer.getInt32();
                    this.p_DSICarLightReply.updateIntLightIlluminationProfile3(n, n14);
                    break;
                }
                case 78: {
                    int n = iDeserializer.getInt32();
                    int n15 = iDeserializer.getInt32();
                    this.p_DSICarLightReply.updateIntLightIlluminationProfile4(n, n15);
                    break;
                }
                case 79: {
                    int n = iDeserializer.getInt32();
                    int n16 = iDeserializer.getInt32();
                    this.p_DSICarLightReply.updateIntLightIlluminationProfile5(n, n16);
                    break;
                }
                case 80: {
                    int n = iDeserializer.getInt32();
                    int n17 = iDeserializer.getInt32();
                    this.p_DSICarLightReply.updateIntLightIlluminationProfile6(n, n17);
                    break;
                }
                case 81: {
                    int n = iDeserializer.getInt32();
                    int n18 = iDeserializer.getInt32();
                    this.p_DSICarLightReply.updateIntLightIlluminationProfile7(n, n18);
                    break;
                }
                case 82: {
                    int n = iDeserializer.getInt32();
                    int n19 = iDeserializer.getInt32();
                    this.p_DSICarLightReply.updateIntLightIlluminationProfile8(n, n19);
                    break;
                }
                case 71: {
                    int n = iDeserializer.getInt32();
                    int n20 = iDeserializer.getInt32();
                    this.p_DSICarLightReply.updateIntLightActiveProfile(n, n20);
                    break;
                }
                case 72: {
                    IntLightRGBValues intLightRGBValues = IntLightRGBValuesSerializer.getOptionalIntLightRGBValues(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarLightReply.updateIntLightAmbientLightColor(intLightRGBValues, n);
                    break;
                }
                case 73: {
                    IntLightRGBValues intLightRGBValues = IntLightRGBValuesSerializer.getOptionalIntLightRGBValues(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarLightReply.updateIntLightContourLightColor(intLightRGBValues, n);
                    break;
                }
                case 74: {
                    int n = iDeserializer.getInt32();
                    int n21 = iDeserializer.getInt32();
                    this.p_DSICarLightReply.updateIntLightFollowUpTime(n, n21);
                    break;
                }
                case 93: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarLightReply.updateIntLightDoorContact(bl, n);
                    break;
                }
                case 83: {
                    IntLightRGBColorListUpdateInfo intLightRGBColorListUpdateInfo = IntLightRGBColorListUpdateInfoSerializer.getOptionalIntLightRGBColorListUpdateInfo(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarLightReply.updateIntLightRGBColorListUpdateInfo(intLightRGBColorListUpdateInfo, n);
                    break;
                }
                case 87: {
                    int n = iDeserializer.getInt32();
                    int n22 = iDeserializer.getInt32();
                    this.p_DSICarLightReply.updateIntLightRGBColorListTotalNumberOfElements(n, n22);
                    break;
                }
                case 63: {
                    IntLightRGBColorListUpdateInfo intLightRGBColorListUpdateInfo = IntLightRGBColorListUpdateInfoSerializer.getOptionalIntLightRGBColorListUpdateInfo(iDeserializer);
                    IntLightRGBColorListRA0[] intLightRGBColorListRA0Array = IntLightRGBColorListRA0Serializer.getOptionalIntLightRGBColorListRA0VarArray(iDeserializer);
                    this.p_DSICarLightReply.responseIntLightRGBColorListRA0(intLightRGBColorListUpdateInfo, intLightRGBColorListRA0Array);
                    break;
                }
                case 64: {
                    IntLightRGBColorListUpdateInfo intLightRGBColorListUpdateInfo = IntLightRGBColorListUpdateInfoSerializer.getOptionalIntLightRGBColorListUpdateInfo(iDeserializer);
                    int[] nArray = iDeserializer.getOptionalInt32VarArray();
                    this.p_DSICarLightReply.responseIntLightRGBColorListRAF(intLightRGBColorListUpdateInfo, nArray);
                    break;
                }
                case 31: {
                    TimeState timeState = TimeStateSerializer.getOptionalTimeState(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarLightReply.updateExtLightComingHome(timeState, n);
                    break;
                }
                case 37: {
                    TimeState timeState = TimeStateSerializer.getOptionalTimeState(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarLightReply.updateExtLightLeavingHome(timeState, n);
                    break;
                }
                case 42: {
                    int n = iDeserializer.getInt32();
                    int n23 = iDeserializer.getInt32();
                    this.p_DSICarLightReply.updateExtLightSwitchOnSensitivity(n, n23);
                    break;
                }
                case 32: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarLightReply.updateExtLightDaylight(bl, n);
                    break;
                }
                case 43: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarLightReply.updateExtLightTourist(bl, n);
                    break;
                }
                case 29: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarLightReply.updateExtLightAdaptive(bl, n);
                    break;
                }
                case 34: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarLightReply.updateExtLightHeadLightSystem(bl, n);
                    break;
                }
                case 33: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarLightReply.updateExtLightGlidingSystem(bl, n);
                    break;
                }
                case 99: {
                    ExtLightViewOptions extLightViewOptions = ExtLightViewOptionsSerializer.getOptionalExtLightViewOptions(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarLightReply.updateExtLightViewOptions(extLightViewOptions, n);
                    break;
                }
                case 39: {
                    MotorwayBlinkingSettings motorwayBlinkingSettings = MotorwayBlinkingSettingsSerializer.getOptionalMotorwayBlinkingSettings(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarLightReply.updateExtLightMotorwayBlinking(motorwayBlinkingSettings, n);
                    break;
                }
                case 38: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarLightReply.updateExtLightMaskedHighBeam(bl, n);
                    break;
                }
                case 35: {
                    ExtLightLampErrorDetectionState[] extLightLampErrorDetectionStateArray = ExtLightLampErrorDetectionStateSerializer.getOptionalExtLightLampErrorDetectionStateVarArray(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarLightReply.updateExtLightLampErrorDetection(extLightLampErrorDetectionStateArray, n);
                    break;
                }
                case 36: {
                    ExtLightLampErrorDetectionStateTrailer[] extLightLampErrorDetectionStateTrailerArray = ExtLightLampErrorDetectionStateTrailerSerializer.getOptionalExtLightLampErrorDetectionStateTrailerVarArray(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarLightReply.updateExtLightLampErrorDetectionTrailer(extLightLampErrorDetectionStateTrailerArray, n);
                    break;
                }
                case 40: {
                    ExtLightSensorErrorDetectionState[] extLightSensorErrorDetectionStateArray = ExtLightSensorErrorDetectionStateSerializer.getOptionalExtLightSensorErrorDetectionStateVarArray(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarLightReply.updateExtLightSensorErrorDetection(extLightSensorErrorDetectionStateArray, n);
                    break;
                }
                case 30: {
                    boolean bl = iDeserializer.getBool();
                    boolean bl2 = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarLightReply.updateExtLightAutomaticLight(bl, bl2, n);
                    break;
                }
                case 1: {
                    boolean bl = iDeserializer.getBool();
                    this.p_DSICarLightReply.acknowledgeIntLightSetFactoryDefault(bl);
                    break;
                }
                case 0: {
                    boolean bl = iDeserializer.getBool();
                    this.p_DSICarLightReply.acknowledgeExtLightSetFactoryDefault(bl);
                    break;
                }
                case 90: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarLightReply.updateExtLightLaserLight(bl, n);
                    break;
                }
                case 98: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSICarLightReply.updateExtLightSignatureLight(bl, n);
                    break;
                }
                case 97: {
                    int n = iDeserializer.getInt32();
                    int n24 = iDeserializer.getInt32();
                    this.p_DSICarLightReply.updateExtLightHeadlightRange(n, n24);
                    break;
                }
                case 2: {
                    int n = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    int n25 = iDeserializer.getInt32();
                    this.p_DSICarLightReply.asyncException(n, string, n25);
                    break;
                }
                case 60: {
                    String string = iDeserializer.getOptionalString();
                    String string2 = iDeserializer.getOptionalString();
                    this.p_DSICarLightReply.yyIndication(string, string2);
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

