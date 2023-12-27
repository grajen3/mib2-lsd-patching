/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl;

import de.esolutions.fw.comm.asi.diagnosis.mmx2app.MMX2DisplayManagerDiagServiceReply;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2DisplayManagerDiagServiceReplyProxy$1;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2DisplayManagerDiagServiceReplyProxy$2;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;

public class MMX2DisplayManagerDiagServiceReplyProxy
implements MMX2DisplayManagerDiagServiceReply,
IProxyFrontend {
    private static final CallContext context = CallContext.getContext("PROXY.asi.diagnosis.mmx2app.MMX2DisplayManagerDiagService");
    private static final int INVALID_HANDLE;
    private Proxy proxy;

    public MMX2DisplayManagerDiagServiceReplyProxy() {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("900f45af-5513-436c-bd60-0747c447c61f", -1, "e2f5022d-4f99-5bb8-b4a4-a30a4c93d62a", "asi.diagnosis.mmx2app.MMX2DisplayManagerDiagService");
        this.proxy = new Proxy(serviceInstanceID, context);
    }

    @Override
    public Proxy getProxy() {
        return this.proxy;
    }

    @Override
    public void requestVideoInputState(long l) {
        MMX2DisplayManagerDiagServiceReplyProxy$1 mMX2DisplayManagerDiagServiceReplyProxy$1 = new MMX2DisplayManagerDiagServiceReplyProxy$1(this, l);
        this.proxy.remoteCallMethod((short)1, mMX2DisplayManagerDiagServiceReplyProxy$1);
    }

    @Override
    public void requestTrunkOfferFBAS(long l, int n, int n2, short s) {
        MMX2DisplayManagerDiagServiceReplyProxy$2 mMX2DisplayManagerDiagServiceReplyProxy$2 = new MMX2DisplayManagerDiagServiceReplyProxy$2(this, l, n, n2, s);
        this.proxy.remoteCallMethod((short)15, mMX2DisplayManagerDiagServiceReplyProxy$2);
    }
}

