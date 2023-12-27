/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.speech.onlinesds.impl;

import de.esolutions.fw.comm.asi.speech.onlinesds.LanguageInfo;
import de.esolutions.fw.comm.asi.speech.onlinesds.OnlineSDS;
import de.esolutions.fw.comm.asi.speech.onlinesds.OnlineSDSC;
import de.esolutions.fw.comm.asi.speech.onlinesds.OnlineSDSReply;
import de.esolutions.fw.comm.asi.speech.onlinesds.impl.OnlineSDSProxy$1;
import de.esolutions.fw.comm.asi.speech.onlinesds.impl.OnlineSDSReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.adapter.GenericSerializable;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class OnlineSDSProxy
implements OnlineSDS,
OnlineSDSC {
    private static final CallContext context = CallContext.getContext("PROXY.asi.speech.onlinesds.OnlineSDS");
    private Proxy proxy;

    public OnlineSDSProxy(int n, OnlineSDSReply onlineSDSReply) {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("86a224ed-3f60-4694-8654-b506f378a69d", n, "1bb96d8d-568e-522f-a197-4a596ff51e1f", "asi.speech.onlinesds.OnlineSDS");
        OnlineSDSReplyService onlineSDSReplyService = new OnlineSDSReplyService(onlineSDSReply);
        this.proxy = new Proxy(serviceInstanceID, onlineSDSReplyService, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    @Override
    public void onlineCapabilities(LanguageInfo[] languageInfoArray) {
        OnlineSDSProxy$1 onlineSDSProxy$1 = new OnlineSDSProxy$1(this, languageInfoArray);
        this.proxy.remoteCallMethod((short)13, onlineSDSProxy$1);
    }

    @Override
    public void responseSetLanguage(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putEnum(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)18, genericSerializable);
    }

    @Override
    public void sendOnlineResult(int n, int n2, String string) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putUInt16(n);
            genericSerializable.putEnum(n2);
            genericSerializable.putOptionalString(string);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)19, genericSerializable);
    }

    @Override
    public void responseCancel(int n, int n2) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putUInt16(n);
            genericSerializable.putEnum(n2);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)17, genericSerializable);
    }
}

