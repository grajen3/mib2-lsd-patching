/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl;

import de.esolutions.fw.comm.asi.diagnosis.mmx2app.MMX2SSEDiagServiceReply;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2SSEDiagServiceReplyProxy$1;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;

public class MMX2SSEDiagServiceReplyProxy
implements MMX2SSEDiagServiceReply,
IProxyFrontend {
    private static final CallContext context = CallContext.getContext("PROXY.asi.diagnosis.mmx2app.MMX2SSEDiagService");
    private static final int INVALID_HANDLE;
    private Proxy proxy;

    public MMX2SSEDiagServiceReplyProxy() {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("24b0b774-1310-11e4-8dc2-17f19a7b4b74", -1, "d68f008c-dad8-5ab1-bd45-f09f0f019586", "asi.diagnosis.mmx2app.MMX2SSEDiagService");
        this.proxy = new Proxy(serviceInstanceID, context);
    }

    @Override
    public Proxy getProxy() {
        return this.proxy;
    }

    @Override
    public void requestClippingCounterMic1(long l) {
        MMX2SSEDiagServiceReplyProxy$1 mMX2SSEDiagServiceReplyProxy$1 = new MMX2SSEDiagServiceReplyProxy$1(this, l);
        this.proxy.remoteCallMethod((short)0, mMX2SSEDiagServiceReplyProxy$1);
    }
}

