/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.speech.voiceencoder.impl;

import de.esolutions.fw.comm.asi.speech.voiceencoder.VoiceEncoderReply;
import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class VoiceEncoderReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.asi.speech.voiceencoder.VoiceEncoder");
    private static int dynamicHandle = 0;
    private VoiceEncoderReply p_VoiceEncoderReply;

    public VoiceEncoderReplyService(VoiceEncoderReply voiceEncoderReply) {
        super(new ServiceInstanceID("6cfdcd5d-a243-4e89-ac17-88fd405b152c", VoiceEncoderReplyService.nextDynamicHandle(), "20498df5-80e6-5c41-b816-715e2be26dfe", "asi.speech.voiceencoder.VoiceEncoder"));
        this.p_VoiceEncoderReply = voiceEncoderReply;
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
                case 2: {
                    int n = iDeserializer.getEnum();
                    long l = iDeserializer.getUInt32();
                    this.p_VoiceEncoderReply.voiceDataAvailable(n, l);
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

