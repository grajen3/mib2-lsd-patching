/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.speech.voiceencoder.impl;

import de.esolutions.fw.comm.asi.speech.voiceencoder.VoiceEncoderS;
import de.esolutions.fw.comm.asi.speech.voiceencoder.impl.VoiceEncoderReplyProxy;
import de.esolutions.fw.comm.core.AbstractService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class VoiceEncoderService
extends AbstractService {
    private static final CallContext context = CallContext.getContext("STUB.asi.speech.voiceencoder.VoiceEncoder");
    private VoiceEncoderS p_VoiceEncoder;

    public VoiceEncoderService(int n, VoiceEncoderS voiceEncoderS) {
        super(new ServiceInstanceID("2897fc85-6e2e-4482-b6fc-26536df6e757", n, "0a41f958-da71-51bb-a6df-53cfe429da78", "asi.speech.voiceencoder.VoiceEncoder"));
        this.p_VoiceEncoder = voiceEncoderS;
    }

    @Override
    public IProxyFrontend createReplyProxy() {
        return new VoiceEncoderReplyProxy();
    }

    @Override
    public CallContext getCallContext() {
        return context;
    }

    @Override
    public void handleCallMethod(short s, IDeserializer iDeserializer, IProxyFrontend iProxyFrontend) {
        try {
            switch (s) {
                case 1: {
                    int n = iDeserializer.getEnum();
                    String string = iDeserializer.getOptionalString();
                    String string2 = iDeserializer.getOptionalString();
                    long l = iDeserializer.getUInt32();
                    this.p_VoiceEncoder.startEncode(n, string, string2, l, (VoiceEncoderReplyProxy)iProxyFrontend);
                    break;
                }
                case 0: {
                    this.p_VoiceEncoder.cancel((VoiceEncoderReplyProxy)iProxyFrontend);
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

