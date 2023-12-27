/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl;

import de.esolutions.fw.comm.asi.diagnosis.mmx2app.MMX2OlsDiagServiceReply;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2OlsDiagServiceReplyProxy$1;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2OlsDiagServiceReplyProxy$2;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;

public class MMX2OlsDiagServiceReplyProxy
implements MMX2OlsDiagServiceReply,
IProxyFrontend {
    private static final CallContext context = CallContext.getContext("PROXY.asi.diagnosis.mmx2app.MMX2OlsDiagService");
    private static final int INVALID_HANDLE;
    private Proxy proxy;

    public MMX2OlsDiagServiceReplyProxy() {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("415815e1-22dc-44f2-8c3e-cc8470ffeaf7", -1, "612a308a-aae1-5fc9-a4d8-fa53e3ea8080", "asi.diagnosis.mmx2app.MMX2OlsDiagService");
        this.proxy = new Proxy(serviceInstanceID, context);
    }

    @Override
    public Proxy getProxy() {
        return this.proxy;
    }

    @Override
    public void requestConnectionState(long l) {
        MMX2OlsDiagServiceReplyProxy$1 mMX2OlsDiagServiceReplyProxy$1 = new MMX2OlsDiagServiceReplyProxy$1(this, l);
        this.proxy.remoteCallMethod((short)1, mMX2OlsDiagServiceReplyProxy$1);
    }

    @Override
    public void requestActivationState(long l) {
        MMX2OlsDiagServiceReplyProxy$2 mMX2OlsDiagServiceReplyProxy$2 = new MMX2OlsDiagServiceReplyProxy$2(this, l);
        this.proxy.remoteCallMethod((short)0, mMX2OlsDiagServiceReplyProxy$2);
    }
}

