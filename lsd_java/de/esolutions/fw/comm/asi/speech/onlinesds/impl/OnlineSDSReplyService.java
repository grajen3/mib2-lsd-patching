/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.speech.onlinesds.impl;

import de.esolutions.fw.comm.asi.speech.onlinesds.AudioData;
import de.esolutions.fw.comm.asi.speech.onlinesds.LanguageInfo;
import de.esolutions.fw.comm.asi.speech.onlinesds.OnlineSDSReply;
import de.esolutions.fw.comm.asi.speech.onlinesds.impl.AudioDataSerializer;
import de.esolutions.fw.comm.asi.speech.onlinesds.impl.LanguageInfoSerializer;
import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class OnlineSDSReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.asi.speech.onlinesds.OnlineSDS");
    private static int dynamicHandle = 0;
    private OnlineSDSReply p_OnlineSDSReply;

    public OnlineSDSReplyService(OnlineSDSReply onlineSDSReply) {
        super(new ServiceInstanceID("8a66769b-5812-4288-95b1-6ebd66230a2d", OnlineSDSReplyService.nextDynamicHandle(), "05e2991f-3978-5b4f-8580-84236c6e9c67", "asi.speech.onlinesds.OnlineSDS"));
        this.p_OnlineSDSReply = onlineSDSReply;
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
                case 20: {
                    LanguageInfo languageInfo = LanguageInfoSerializer.getOptionalLanguageInfo(iDeserializer);
                    this.p_OnlineSDSReply.setLanguage(languageInfo);
                    break;
                }
                case 21: {
                    int n = iDeserializer.getUInt16();
                    int n2 = iDeserializer.getEnum();
                    AudioData audioData = AudioDataSerializer.getOptionalAudioData(iDeserializer);
                    this.p_OnlineSDSReply.speechDataUpdate(n, n2, audioData);
                    break;
                }
                case 16: {
                    int n = iDeserializer.getUInt16();
                    this.p_OnlineSDSReply.cancel(n);
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

