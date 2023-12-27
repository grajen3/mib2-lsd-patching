/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.sound.impl;

import de.esolutions.fw.comm.asi.hmisync.sound.ASIHMISyncSoundReply;
import de.esolutions.fw.comm.asi.hmisync.sound.SoundRange;
import de.esolutions.fw.comm.asi.hmisync.sound.impl.SoundRangeSerializer;
import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class ASIHMISyncSoundReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.asi.hmisync.sound.ASIHMISyncSound");
    private static int dynamicHandle = 0;
    private ASIHMISyncSoundReply p_ASIHMISyncSoundReply;

    public ASIHMISyncSoundReplyService(ASIHMISyncSoundReply aSIHMISyncSoundReply) {
        super(new ServiceInstanceID("7ba5c63b-4ccf-465c-abe4-f731a4967351", ASIHMISyncSoundReplyService.nextDynamicHandle(), "143510c1-02a3-544a-b01d-af15a58cbbc4", "asi.hmisync.sound.ASIHMISyncSound"));
        this.p_ASIHMISyncSoundReply = aSIHMISyncSoundReply;
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
                case 14: {
                    String string = iDeserializer.getOptionalString();
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncSoundReply.updateASIVersion(string, bl);
                    break;
                }
                case 27: {
                    short[] sArray = iDeserializer.getOptionalInt16VarArray();
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncSoundReply.updateRequestIDs(sArray, bl);
                    break;
                }
                case 26: {
                    short[] sArray = iDeserializer.getOptionalInt16VarArray();
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncSoundReply.updateReplyIDs(sArray, bl);
                    break;
                }
                case 28: {
                    int n = iDeserializer.getInt32();
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncSoundReply.updateSoundState(n, bl);
                    break;
                }
                case 15: {
                    int n = iDeserializer.getInt32();
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncSoundReply.updateAmplifier(n, bl);
                    break;
                }
                case 18: {
                    SoundRange soundRange = SoundRangeSerializer.getOptionalSoundRange(iDeserializer);
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncSoundReply.updateBassRange(soundRange, bl);
                    break;
                }
                case 19: {
                    int n = iDeserializer.getInt32();
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncSoundReply.updateBassValue(n, bl);
                    break;
                }
                case 33: {
                    SoundRange soundRange = SoundRangeSerializer.getOptionalSoundRange(iDeserializer);
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncSoundReply.updateTrebleRange(soundRange, bl);
                    break;
                }
                case 34: {
                    int n = iDeserializer.getInt32();
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncSoundReply.updateTrebleValue(n, bl);
                    break;
                }
                case 16: {
                    SoundRange soundRange = SoundRangeSerializer.getOptionalSoundRange(iDeserializer);
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncSoundReply.updateBalanceRange(soundRange, bl);
                    break;
                }
                case 17: {
                    int n = iDeserializer.getInt32();
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncSoundReply.updateBalanceValue(n, bl);
                    break;
                }
                case 20: {
                    SoundRange soundRange = SoundRangeSerializer.getOptionalSoundRange(iDeserializer);
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncSoundReply.updateFaderRange(soundRange, bl);
                    break;
                }
                case 21: {
                    int n = iDeserializer.getInt32();
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncSoundReply.updateFaderValue(n, bl);
                    break;
                }
                case 29: {
                    SoundRange soundRange = SoundRangeSerializer.getOptionalSoundRange(iDeserializer);
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncSoundReply.updateSubwooferRange(soundRange, bl);
                    break;
                }
                case 30: {
                    int n = iDeserializer.getInt32();
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncSoundReply.updateSubwooferValue(n, bl);
                    break;
                }
                case 31: {
                    SoundRange soundRange = SoundRangeSerializer.getOptionalSoundRange(iDeserializer);
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncSoundReply.updateSurroundRange(soundRange, bl);
                    break;
                }
                case 32: {
                    int n = iDeserializer.getInt32();
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncSoundReply.updateSurroundValue(n, bl);
                    break;
                }
                case 22: {
                    SoundRange soundRange = SoundRangeSerializer.getOptionalSoundRange(iDeserializer);
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncSoundReply.updateNoiseCompensationRange(soundRange, bl);
                    break;
                }
                case 23: {
                    int n = iDeserializer.getInt32();
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncSoundReply.updateNoiseCompensationValue(n, bl);
                    break;
                }
                case 39: {
                    SoundRange soundRange = SoundRangeSerializer.getOptionalSoundRange(iDeserializer);
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncSoundReply.updateThreeDModeRange(soundRange, bl);
                    break;
                }
                case 40: {
                    int n = iDeserializer.getInt32();
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncSoundReply.updateThreeDModeValue(n, bl);
                    break;
                }
                case 25: {
                    int n = iDeserializer.getInt32();
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncSoundReply.updatePresetPositionList(n, bl);
                    break;
                }
                case 24: {
                    int n = iDeserializer.getInt32();
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncSoundReply.updatePresetPosition(n, bl);
                    break;
                }
                case 38: {
                    int n = iDeserializer.getInt32();
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncSoundReply.updatePresetEQList(n, bl);
                    break;
                }
                case 37: {
                    int n = iDeserializer.getInt32();
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncSoundReply.updatePresetEQ(n, bl);
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

