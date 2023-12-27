/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.speech.onlinesds.impl;

import de.esolutions.fw.comm.asi.speech.onlinesds.LanguageInfo;
import de.esolutions.fw.comm.asi.speech.onlinesds.OnlineSDSS;
import de.esolutions.fw.comm.asi.speech.onlinesds.impl.LanguageInfoSerializer;
import de.esolutions.fw.comm.asi.speech.onlinesds.impl.OnlineSDSReplyProxy;
import de.esolutions.fw.comm.core.AbstractService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class OnlineSDSService
extends AbstractService {
    private static final CallContext context = CallContext.getContext("STUB.asi.speech.onlinesds.OnlineSDS");
    private OnlineSDSS p_OnlineSDS;

    public OnlineSDSService(int n, OnlineSDSS onlineSDSS) {
        super(new ServiceInstanceID("86a224ed-3f60-4694-8654-b506f378a69d", n, "1bb96d8d-568e-522f-a197-4a596ff51e1f", "asi.speech.onlinesds.OnlineSDS"));
        this.p_OnlineSDS = onlineSDSS;
    }

    @Override
    public IProxyFrontend createReplyProxy() {
        return new OnlineSDSReplyProxy();
    }

    @Override
    public CallContext getCallContext() {
        return context;
    }

    @Override
    public void handleCallMethod(short s, IDeserializer iDeserializer, IProxyFrontend iProxyFrontend) {
        try {
            switch (s) {
                case 13: {
                    LanguageInfo[] languageInfoArray = LanguageInfoSerializer.getOptionalLanguageInfoVarArray(iDeserializer);
                    this.p_OnlineSDS.onlineCapabilities(languageInfoArray, (OnlineSDSReplyProxy)iProxyFrontend);
                    break;
                }
                case 18: {
                    int n = iDeserializer.getEnum();
                    this.p_OnlineSDS.responseSetLanguage(n, (OnlineSDSReplyProxy)iProxyFrontend);
                    break;
                }
                case 19: {
                    int n = iDeserializer.getUInt16();
                    int n2 = iDeserializer.getEnum();
                    String string = iDeserializer.getOptionalString();
                    this.p_OnlineSDS.sendOnlineResult(n, n2, string, (OnlineSDSReplyProxy)iProxyFrontend);
                    break;
                }
                case 17: {
                    int n = iDeserializer.getUInt16();
                    int n3 = iDeserializer.getEnum();
                    this.p_OnlineSDS.responseCancel(n, n3, (OnlineSDSReplyProxy)iProxyFrontend);
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

