/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.audio.impl;

import de.esolutions.fw.comm.asi.hmisync.audio.A2LSState;
import de.esolutions.fw.comm.asi.hmisync.audio.ASIHMISyncAudioReply;
import de.esolutions.fw.comm.asi.hmisync.audio.AudioState;
import de.esolutions.fw.comm.asi.hmisync.audio.VolumeLockState;
import de.esolutions.fw.comm.asi.hmisync.audio.VolumeRange;
import de.esolutions.fw.comm.asi.hmisync.audio.impl.A2LSStateSerializer;
import de.esolutions.fw.comm.asi.hmisync.audio.impl.AudioStateSerializer;
import de.esolutions.fw.comm.asi.hmisync.audio.impl.VolumeLockStateSerializer;
import de.esolutions.fw.comm.asi.hmisync.audio.impl.VolumeRangeSerializer;
import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class ASIHMISyncAudioReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.asi.hmisync.audio.ASIHMISyncAudio");
    private static int dynamicHandle = 0;
    private ASIHMISyncAudioReply p_ASIHMISyncAudioReply;

    public ASIHMISyncAudioReplyService(ASIHMISyncAudioReply aSIHMISyncAudioReply) {
        super(new ServiceInstanceID("cd52f5cc-371d-43de-8bc4-c3df1c55f44a", ASIHMISyncAudioReplyService.nextDynamicHandle(), "0c5e00e4-2cbf-5dfc-acd3-5499fe013c7f", "asi.hmisync.audio.ASIHMISyncAudio"));
        this.p_ASIHMISyncAudioReply = aSIHMISyncAudioReply;
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
                case 7: {
                    int n = iDeserializer.getInt32();
                    this.p_ASIHMISyncAudioReply.responseEnableA2LS(n);
                    break;
                }
                case 13: {
                    String string = iDeserializer.getOptionalString();
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncAudioReply.updateASIVersion(string, bl);
                    break;
                }
                case 20: {
                    short[] sArray = iDeserializer.getOptionalInt16VarArray();
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncAudioReply.updateRequestIDs(sArray, bl);
                    break;
                }
                case 19: {
                    short[] sArray = iDeserializer.getOptionalInt16VarArray();
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncAudioReply.updateReplyIDs(sArray, bl);
                    break;
                }
                case 14: {
                    AudioState audioState = AudioStateSerializer.getOptionalAudioState(iDeserializer);
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncAudioReply.updateAudioContext(audioState, bl);
                    break;
                }
                case 15: {
                    AudioState audioState = AudioStateSerializer.getOptionalAudioState(iDeserializer);
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncAudioReply.updateFrontAudioContext(audioState, bl);
                    break;
                }
                case 25: {
                    VolumeLockState volumeLockState = VolumeLockStateSerializer.getOptionalVolumeLockState(iDeserializer);
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncAudioReply.updateVolumeLockState(volumeLockState, bl);
                    break;
                }
                case 23: {
                    A2LSState a2LSState = A2LSStateSerializer.getOptionalA2LSState(iDeserializer);
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncAudioReply.updateA2LSState(a2LSState, bl);
                    break;
                }
                case 18: {
                    VolumeRange volumeRange = VolumeRangeSerializer.getOptionalVolumeRange(iDeserializer);
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncAudioReply.updateVolumeRange(volumeRange, bl);
                    break;
                }
                case 17: {
                    int n = iDeserializer.getInt32();
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncAudioReply.updateVolume(n, bl);
                    break;
                }
                case 24: {
                    int n = iDeserializer.getInt32();
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncAudioReply.updateAudibleState(n, bl);
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

