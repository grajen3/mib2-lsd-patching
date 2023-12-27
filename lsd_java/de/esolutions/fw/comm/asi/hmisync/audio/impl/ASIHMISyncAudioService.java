/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.audio.impl;

import de.esolutions.fw.comm.asi.hmisync.audio.ASIHMISyncAudioReply;
import de.esolutions.fw.comm.asi.hmisync.audio.ASIHMISyncAudioS;
import de.esolutions.fw.comm.asi.hmisync.audio.impl.ASIHMISyncAudioReplyProxy;
import de.esolutions.fw.comm.core.AbstractService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class ASIHMISyncAudioService
extends AbstractService {
    private static final CallContext context = CallContext.getContext("STUB.asi.hmisync.audio.ASIHMISyncAudio");
    private ASIHMISyncAudioS p_ASIHMISyncAudio;

    public ASIHMISyncAudioService(int n, ASIHMISyncAudioS aSIHMISyncAudioS) {
        super(new ServiceInstanceID("0f18f39e-8ba2-4652-9298-39ffbea5b9fe", n, "f10bdb8c-3351-5035-a073-26fb210dd987", "asi.hmisync.audio.ASIHMISyncAudio"));
        this.p_ASIHMISyncAudio = aSIHMISyncAudioS;
    }

    @Override
    public IProxyFrontend createReplyProxy() {
        return new ASIHMISyncAudioReplyProxy();
    }

    @Override
    public CallContext getCallContext() {
        return context;
    }

    @Override
    public void handleCallMethod(short s, IDeserializer iDeserializer, IProxyFrontend iProxyFrontend) {
        try {
            switch (s) {
                case 8: {
                    int n = iDeserializer.getInt32();
                    this.p_ASIHMISyncAudio.setAudioContext(n, (ASIHMISyncAudioReplyProxy)iProxyFrontend);
                    break;
                }
                case 21: {
                    int n = iDeserializer.getInt32();
                    this.p_ASIHMISyncAudio.forceFrontAudioContext(n, (ASIHMISyncAudioReplyProxy)iProxyFrontend);
                    break;
                }
                case 22: {
                    String string = iDeserializer.getOptionalString();
                    this.p_ASIHMISyncAudio.requestEnableA2LS(string, (ASIHMISyncAudioReplyProxy)iProxyFrontend);
                    break;
                }
                case 4: {
                    this.p_ASIHMISyncAudio.disableA2LS((ASIHMISyncAudioReplyProxy)iProxyFrontend);
                    break;
                }
                case 12: {
                    int n = iDeserializer.getInt32();
                    this.p_ASIHMISyncAudio.setVolume(n, (ASIHMISyncAudioReplyProxy)iProxyFrontend);
                    break;
                }
                case 6: {
                    int n = iDeserializer.getInt32();
                    this.p_ASIHMISyncAudio.increaseVolume(n, (ASIHMISyncAudioReplyProxy)iProxyFrontend);
                    break;
                }
                case 3: {
                    int n = iDeserializer.getInt32();
                    this.p_ASIHMISyncAudio.decreaseVolume(n, (ASIHMISyncAudioReplyProxy)iProxyFrontend);
                    break;
                }
                case 9: {
                    this.p_ASIHMISyncAudio.setNotification((ASIHMISyncAudioReplyProxy)iProxyFrontend);
                    break;
                }
                case 11: {
                    long l = iDeserializer.getUInt32();
                    this.p_ASIHMISyncAudio.setNotification(l, (ASIHMISyncAudioReply)((ASIHMISyncAudioReplyProxy)iProxyFrontend));
                    break;
                }
                case 10: {
                    long[] lArray = iDeserializer.getOptionalUInt32VarArray();
                    this.p_ASIHMISyncAudio.setNotification(lArray, (ASIHMISyncAudioReply)((ASIHMISyncAudioReplyProxy)iProxyFrontend));
                    break;
                }
                case 0: {
                    this.p_ASIHMISyncAudio.clearNotification((ASIHMISyncAudioReplyProxy)iProxyFrontend);
                    break;
                }
                case 2: {
                    long l = iDeserializer.getUInt32();
                    this.p_ASIHMISyncAudio.clearNotification(l, (ASIHMISyncAudioReply)((ASIHMISyncAudioReplyProxy)iProxyFrontend));
                    break;
                }
                case 1: {
                    long[] lArray = iDeserializer.getOptionalUInt32VarArray();
                    this.p_ASIHMISyncAudio.clearNotification(lArray, (ASIHMISyncAudioReply)((ASIHMISyncAudioReplyProxy)iProxyFrontend));
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

