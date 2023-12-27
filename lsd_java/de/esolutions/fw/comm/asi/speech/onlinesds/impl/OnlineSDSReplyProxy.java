/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.speech.onlinesds.impl;

import de.esolutions.fw.comm.asi.speech.onlinesds.AudioData;
import de.esolutions.fw.comm.asi.speech.onlinesds.LanguageInfo;
import de.esolutions.fw.comm.asi.speech.onlinesds.OnlineSDSReply;
import de.esolutions.fw.comm.asi.speech.onlinesds.impl.OnlineSDSReplyProxy$1;
import de.esolutions.fw.comm.asi.speech.onlinesds.impl.OnlineSDSReplyProxy$2;
import de.esolutions.fw.comm.asi.speech.onlinesds.impl.OnlineSDSReplyProxy$3;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;

public class OnlineSDSReplyProxy
implements OnlineSDSReply,
IProxyFrontend {
    private static final CallContext context = CallContext.getContext("PROXY.asi.speech.onlinesds.OnlineSDS");
    private static final int INVALID_HANDLE;
    private Proxy proxy;

    public OnlineSDSReplyProxy() {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("8a66769b-5812-4288-95b1-6ebd66230a2d", -1, "05e2991f-3978-5b4f-8580-84236c6e9c67", "asi.speech.onlinesds.OnlineSDS");
        this.proxy = new Proxy(serviceInstanceID, context);
    }

    @Override
    public Proxy getProxy() {
        return this.proxy;
    }

    @Override
    public void setLanguage(LanguageInfo languageInfo) {
        OnlineSDSReplyProxy$1 onlineSDSReplyProxy$1 = new OnlineSDSReplyProxy$1(this, languageInfo);
        this.proxy.remoteCallMethod((short)20, onlineSDSReplyProxy$1);
    }

    @Override
    public void speechDataUpdate(int n, int n2, AudioData audioData) {
        OnlineSDSReplyProxy$2 onlineSDSReplyProxy$2 = new OnlineSDSReplyProxy$2(this, n, n2, audioData);
        this.proxy.remoteCallMethod((short)21, onlineSDSReplyProxy$2);
    }

    @Override
    public void cancel(int n) {
        OnlineSDSReplyProxy$3 onlineSDSReplyProxy$3 = new OnlineSDSReplyProxy$3(this, n);
        this.proxy.remoteCallMethod((short)16, onlineSDSReplyProxy$3);
    }
}

