/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.audio.impl;

import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.audio.DSISoundReply;
import de.esolutions.fw.comm.dsi.audio.impl.AmplifierCapabilitiesSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.audio.AmplifierCapabilities;

public class DSISoundReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.dsi.audio.DSISound");
    private static int dynamicHandle = 0;
    private DSISoundReply p_DSISoundReply;

    public DSISoundReplyService(DSISoundReply dSISoundReply) {
        super(new ServiceInstanceID("781e4762-ef2b-5a94-972a-3c284bdb0fd4", DSISoundReplyService.nextDynamicHandle(), "e1e9715f-7c10-5394-b9b3-c506acbe5ba0", "dsi.audio.DSISound"));
        this.p_DSISoundReply = dSISoundReply;
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
                case 53: {
                    int n = iDeserializer.getInt32();
                    int n2 = iDeserializer.getInt32();
                    int n3 = iDeserializer.getInt32();
                    int n4 = iDeserializer.getInt32();
                    this.p_DSISoundReply.inputGainOffsetRange(n, n2, n3, n4);
                    break;
                }
                case 54: {
                    int n = iDeserializer.getInt32();
                    int n5 = iDeserializer.getInt32();
                    int n6 = iDeserializer.getInt32();
                    this.p_DSISoundReply.menuVolEntRange(n, n5, n6);
                    break;
                }
                case 55: {
                    int n = iDeserializer.getInt32();
                    int n7 = iDeserializer.getInt32();
                    int n8 = iDeserializer.getInt32();
                    int n9 = iDeserializer.getInt32();
                    this.p_DSISoundReply.menuVolumeRange(n, n7, n8, n9);
                    break;
                }
                case 153: {
                    int n = iDeserializer.getInt32();
                    int n10 = iDeserializer.getInt32();
                    int n11 = iDeserializer.getInt32();
                    int n12 = iDeserializer.getInt32();
                    int n13 = iDeserializer.getInt32();
                    this.p_DSISoundReply.volumeRange(n, n10, n11, n12, n13);
                    break;
                }
                case 143: {
                    int n = iDeserializer.getInt32();
                    int n14 = iDeserializer.getInt32();
                    boolean bl = iDeserializer.getBool();
                    int n15 = iDeserializer.getInt32();
                    this.p_DSISoundReply.updateSurroundOnOff(n, n14, bl, n15);
                    break;
                }
                case 80: {
                    int n = iDeserializer.getInt32();
                    int n16 = iDeserializer.getInt32();
                    short s2 = iDeserializer.getInt16();
                    int n17 = iDeserializer.getInt32();
                    this.p_DSISoundReply.updateBalance(n, n16, s2, n17);
                    break;
                }
                case 81: {
                    int n = iDeserializer.getInt32();
                    int n18 = iDeserializer.getInt32();
                    int n19 = iDeserializer.getInt32();
                    this.p_DSISoundReply.updateBalanceRange(n, n18, n19);
                    break;
                }
                case 82: {
                    int n = iDeserializer.getInt32();
                    int n20 = iDeserializer.getInt32();
                    short s3 = iDeserializer.getInt16();
                    int n21 = iDeserializer.getInt32();
                    this.p_DSISoundReply.updateBass(n, n20, s3, n21);
                    break;
                }
                case 83: {
                    int n = iDeserializer.getInt32();
                    int n22 = iDeserializer.getInt32();
                    int n23 = iDeserializer.getInt32();
                    this.p_DSISoundReply.updateBassRange(n, n22, n23);
                    break;
                }
                case 5: {
                    int n = iDeserializer.getInt32();
                    boolean bl = iDeserializer.getBool();
                    this.p_DSISoundReply.createExportFileResult(n, bl);
                    break;
                }
                case 87: {
                    int n = iDeserializer.getInt32();
                    int n24 = iDeserializer.getInt32();
                    short s4 = iDeserializer.getInt16();
                    int n25 = iDeserializer.getInt32();
                    this.p_DSISoundReply.updateFader(n, n24, s4, n25);
                    break;
                }
                case 88: {
                    int n = iDeserializer.getInt32();
                    int n26 = iDeserializer.getInt32();
                    int n27 = iDeserializer.getInt32();
                    this.p_DSISoundReply.updateFaderRange(n, n26, n27);
                    break;
                }
                case 38: {
                    int n = iDeserializer.getInt32();
                    boolean bl = iDeserializer.getBool();
                    this.p_DSISoundReply.importFileResponse(n, bl);
                    break;
                }
                case 90: {
                    int n = iDeserializer.getInt32();
                    int n28 = iDeserializer.getInt32();
                    short s5 = iDeserializer.getInt16();
                    int n29 = iDeserializer.getInt32();
                    this.p_DSISoundReply.updateInputGainOffset(n, n28, s5, n29);
                    break;
                }
                case 91: {
                    int n = iDeserializer.getInt32();
                    int n30 = iDeserializer.getInt32();
                    int n31 = iDeserializer.getInt32();
                    short s6 = iDeserializer.getInt16();
                    int n32 = iDeserializer.getInt32();
                    this.p_DSISoundReply.updateLoweringEntertainment(n, n30, n31, s6, n32);
                    break;
                }
                case 95: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSISoundReply.updateMutePinState(bl, n);
                    break;
                }
                case 101: {
                    int n = iDeserializer.getInt32();
                    int n33 = iDeserializer.getInt32();
                    short s7 = iDeserializer.getInt16();
                    int n34 = iDeserializer.getInt32();
                    this.p_DSISoundReply.updateSubwoofer(n, n33, s7, n34);
                    break;
                }
                case 102: {
                    int n = iDeserializer.getInt32();
                    int n35 = iDeserializer.getInt32();
                    int n36 = iDeserializer.getInt32();
                    this.p_DSISoundReply.updateSubwooferRange(n, n35, n36);
                    break;
                }
                case 103: {
                    int n = iDeserializer.getInt32();
                    int n37 = iDeserializer.getInt32();
                    int n38 = iDeserializer.getInt32();
                    this.p_DSISoundReply.updateSurrLevelRange(n, n37, n38);
                    break;
                }
                case 104: {
                    int n = iDeserializer.getInt32();
                    int n39 = iDeserializer.getInt32();
                    short s8 = iDeserializer.getInt16();
                    int n40 = iDeserializer.getInt32();
                    this.p_DSISoundReply.updateSurroundLevel(n, n39, s8, n40);
                    break;
                }
                case 105: {
                    int n = iDeserializer.getInt32();
                    int n41 = iDeserializer.getInt32();
                    short s9 = iDeserializer.getInt16();
                    int n42 = iDeserializer.getInt32();
                    this.p_DSISoundReply.updateTreble(n, n41, s9, n42);
                    break;
                }
                case 106: {
                    int n = iDeserializer.getInt32();
                    int n43 = iDeserializer.getInt32();
                    int n44 = iDeserializer.getInt32();
                    this.p_DSISoundReply.updateTrebleRange(n, n43, n44);
                    break;
                }
                case 108: {
                    int n = iDeserializer.getInt32();
                    int n45 = iDeserializer.getInt32();
                    short s10 = iDeserializer.getInt16();
                    int n46 = iDeserializer.getInt32();
                    this.p_DSISoundReply.updateVolume(n, n45, s10, n46);
                    break;
                }
                case 111: {
                    int n = iDeserializer.getInt32();
                    int n47 = iDeserializer.getInt32();
                    int n48 = iDeserializer.getInt32();
                    this.p_DSISoundReply.updateVolumeRange(n, n47, n48);
                    break;
                }
                case 93: {
                    int n = iDeserializer.getInt32();
                    int n49 = iDeserializer.getInt32();
                    short s11 = iDeserializer.getInt16();
                    int n50 = iDeserializer.getInt32();
                    this.p_DSISoundReply.updateMiddle(n, n49, s11, n50);
                    break;
                }
                case 94: {
                    int n = iDeserializer.getInt32();
                    int n51 = iDeserializer.getInt32();
                    int n52 = iDeserializer.getInt32();
                    this.p_DSISoundReply.updateMiddleRange(n, n51, n52);
                    break;
                }
                case 86: {
                    int n = iDeserializer.getInt32();
                    int n53 = iDeserializer.getInt32();
                    int[] nArray = iDeserializer.getOptionalInt32VarArray();
                    int n54 = iDeserializer.getInt32();
                    this.p_DSISoundReply.updateEqualizerRange(n, n53, nArray, n54);
                    break;
                }
                case 85: {
                    int[] nArray = iDeserializer.getOptionalInt32VarArray();
                    int[] nArray2 = iDeserializer.getOptionalInt32VarArray();
                    int n = iDeserializer.getInt32();
                    this.p_DSISoundReply.updateEqualizer(nArray, nArray2, n);
                    break;
                }
                case 97: {
                    int n = iDeserializer.getInt32();
                    int n55 = iDeserializer.getInt32();
                    this.p_DSISoundReply.updateOnVolumeLimit(n, n55);
                    break;
                }
                case 98: {
                    int n = iDeserializer.getInt32();
                    int n56 = iDeserializer.getInt32();
                    int n57 = iDeserializer.getInt32();
                    this.p_DSISoundReply.updateOnVolumeLimitRange(n, n56, n57);
                    break;
                }
                case 151: {
                    AmplifierCapabilities amplifierCapabilities = AmplifierCapabilitiesSerializer.getOptionalAmplifierCapabilities(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSISoundReply.updateActiveAmplifierCapabilities(amplifierCapabilities, n);
                    break;
                }
                case 96: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSISoundReply.updateMuteTheftProtection(bl, n);
                    break;
                }
                case 92: {
                    int n = iDeserializer.getInt32();
                    int n58 = iDeserializer.getInt32();
                    this.p_DSISoundReply.updateMicGainLevel(n, n58);
                    break;
                }
                case 109: {
                    int n = iDeserializer.getInt32();
                    int n59 = iDeserializer.getInt32();
                    int n60 = iDeserializer.getInt32();
                    this.p_DSISoundReply.updateVolumeFocus(n, n59, n60);
                    break;
                }
                case 148: {
                    int n = iDeserializer.getInt32();
                    int n61 = iDeserializer.getInt32();
                    short s12 = iDeserializer.getInt16();
                    int n62 = iDeserializer.getInt32();
                    this.p_DSISoundReply.updateNoiseCompensation(n, n61, s12, n62);
                    break;
                }
                case 130: {
                    int n = iDeserializer.getInt32();
                    int n63 = iDeserializer.getInt32();
                    int n64 = iDeserializer.getInt32();
                    this.p_DSISoundReply.updateNoiseCompensationRange(n, n63, n64);
                    break;
                }
                case 144: {
                    int n = iDeserializer.getInt32();
                    int n65 = iDeserializer.getInt32();
                    int n66 = iDeserializer.getInt32();
                    int n67 = iDeserializer.getInt32();
                    this.p_DSISoundReply.updateThreeDMode(n, n65, n66, n67);
                    break;
                }
                case 145: {
                    int n = iDeserializer.getInt32();
                    int n68 = iDeserializer.getInt32();
                    int n69 = iDeserializer.getInt32();
                    this.p_DSISoundReply.updateThreeDModeRange(n, n68, n69);
                    break;
                }
                case 133: {
                    int n = iDeserializer.getInt32();
                    int n70 = iDeserializer.getInt32();
                    int n71 = iDeserializer.getInt32();
                    int n72 = iDeserializer.getInt32();
                    this.p_DSISoundReply.updatePresetPosition(n, n70, n71, n72);
                    break;
                }
                case 134: {
                    int n = iDeserializer.getInt32();
                    int n73 = iDeserializer.getInt32();
                    this.p_DSISoundReply.updatePresetPositionList(n, n73);
                    break;
                }
                case 132: {
                    int n = iDeserializer.getInt32();
                    int n74 = iDeserializer.getInt32();
                    this.p_DSISoundReply.updatePresetEQList(n, n74);
                    break;
                }
                case 131: {
                    int n = iDeserializer.getInt32();
                    int n75 = iDeserializer.getInt32();
                    int n76 = iDeserializer.getInt32();
                    int n77 = iDeserializer.getInt32();
                    this.p_DSISoundReply.updatePresetEQ(n, n75, n76, n77);
                    break;
                }
                case 142: {
                    int n = iDeserializer.getInt32();
                    int n78 = iDeserializer.getInt32();
                    boolean bl = iDeserializer.getBool();
                    int n79 = iDeserializer.getInt32();
                    this.p_DSISoundReply.updateSubwooferActivity(n, n78, bl, n79);
                    break;
                }
                case 146: {
                    int n = iDeserializer.getInt32();
                    boolean bl = iDeserializer.getBool();
                    this.p_DSISoundReply.responseWidebandSpeech(n, bl);
                    break;
                }
                case 169: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSISoundReply.updateSoundShapeActive(bl, n);
                    break;
                }
                case 168: {
                    short s13 = iDeserializer.getInt16();
                    short s14 = iDeserializer.getInt16();
                    short s15 = iDeserializer.getInt16();
                    int n = iDeserializer.getInt32();
                    this.p_DSISoundReply.updateSoundShape(s13, s14, s15, n);
                    break;
                }
                case 170: {
                    int n = iDeserializer.getInt32();
                    int n80 = iDeserializer.getInt32();
                    int n81 = iDeserializer.getInt32();
                    int n82 = iDeserializer.getInt32();
                    int n83 = iDeserializer.getInt32();
                    int n84 = iDeserializer.getInt32();
                    int n85 = iDeserializer.getInt32();
                    this.p_DSISoundReply.updateSoundShapeRange(n, n80, n81, n82, n83, n84, n85);
                    break;
                }
                case 166: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    int n86 = iDeserializer.getInt32();
                    this.p_DSISoundReply.updateICCAvailable(bl, n, n86);
                    break;
                }
                case 167: {
                    int n = iDeserializer.getInt32();
                    int n87 = iDeserializer.getInt32();
                    int n88 = iDeserializer.getInt32();
                    this.p_DSISoundReply.updateProfileState(n, n87, n88);
                    break;
                }
                case 157: {
                    int n = iDeserializer.getInt32();
                    int n89 = iDeserializer.getInt32();
                    this.p_DSISoundReply.profileChanged(n, n89);
                    break;
                }
                case 158: {
                    int n = iDeserializer.getInt32();
                    int n90 = iDeserializer.getInt32();
                    int n91 = iDeserializer.getInt32();
                    this.p_DSISoundReply.profileCopied(n, n90, n91);
                    break;
                }
                case 161: {
                    int n = iDeserializer.getInt32();
                    int n92 = iDeserializer.getInt32();
                    this.p_DSISoundReply.profileReset(n, n92);
                    break;
                }
                case 163: {
                    int n = iDeserializer.getInt32();
                    this.p_DSISoundReply.profileResetAll(n);
                    break;
                }
                case 0: {
                    int n = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    int n93 = iDeserializer.getInt32();
                    this.p_DSISoundReply.asyncException(n, string, n93);
                    break;
                }
                case 112: {
                    String string = iDeserializer.getOptionalString();
                    String string2 = iDeserializer.getOptionalString();
                    this.p_DSISoundReply.yyIndication(string, string2);
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

