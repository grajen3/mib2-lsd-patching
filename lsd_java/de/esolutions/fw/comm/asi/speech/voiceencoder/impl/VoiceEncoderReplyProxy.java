/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.speech.voiceencoder.impl;

import de.esolutions.fw.comm.asi.speech.voiceencoder.VoiceEncoderReply;
import de.esolutions.fw.comm.asi.speech.voiceencoder.impl.VoiceEncoderReplyProxy$1;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;

public class VoiceEncoderReplyProxy
implements VoiceEncoderReply,
IProxyFrontend {
    private static final CallContext context = CallContext.getContext("PROXY.asi.speech.voiceencoder.VoiceEncoder");
    private static final int INVALID_HANDLE;
    private Proxy proxy;

    public VoiceEncoderReplyProxy() {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("6cfdcd5d-a243-4e89-ac17-88fd405b152c", -1, "20498df5-80e6-5c41-b816-715e2be26dfe", "asi.speech.voiceencoder.VoiceEncoder");
        this.proxy = new Proxy(serviceInstanceID, context);
    }

    @Override
    public Proxy getProxy() {
        return this.proxy;
    }

    @Override
    public void voiceDataAvailable(int n, long l) {
        VoiceEncoderReplyProxy$1 voiceEncoderReplyProxy$1 = new VoiceEncoderReplyProxy$1(this, n, l);
        this.proxy.remoteCallMethod((short)2, voiceEncoderReplyProxy$1);
    }
}

