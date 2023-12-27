/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.speech.voiceencoder.impl;

import de.esolutions.fw.comm.asi.speech.voiceencoder.VoiceEncoder;
import de.esolutions.fw.comm.asi.speech.voiceencoder.VoiceEncoderC;
import de.esolutions.fw.comm.asi.speech.voiceencoder.VoiceEncoderReply;
import de.esolutions.fw.comm.asi.speech.voiceencoder.impl.VoiceEncoderReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.adapter.GenericSerializable;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class VoiceEncoderProxy
implements VoiceEncoder,
VoiceEncoderC {
    private static final CallContext context = CallContext.getContext("PROXY.asi.speech.voiceencoder.VoiceEncoder");
    private Proxy proxy;

    public VoiceEncoderProxy(int n, VoiceEncoderReply voiceEncoderReply) {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("2897fc85-6e2e-4482-b6fc-26536df6e757", n, "0a41f958-da71-51bb-a6df-53cfe429da78", "asi.speech.voiceencoder.VoiceEncoder");
        VoiceEncoderReplyService voiceEncoderReplyService = new VoiceEncoderReplyService(voiceEncoderReply);
        this.proxy = new Proxy(serviceInstanceID, voiceEncoderReplyService, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    @Override
    public void startEncode(int n, String string, String string2, long l) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putEnum(n);
            genericSerializable.putOptionalString(string);
            genericSerializable.putOptionalString(string2);
            genericSerializable.putUInt32(l);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)1, genericSerializable);
    }

    @Override
    public void cancel() {
        this.proxy.remoteCallMethod((short)0, null);
    }
}

