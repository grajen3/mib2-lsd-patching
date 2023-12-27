/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl;

import de.esolutions.fw.comm.asi.diagnosis.mmx2app.MMX2WlanDiagServiceReply;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2WlanDiagServiceReplyProxy$1;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2WlanDiagServiceReplyProxy$2;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2WlanDiagServiceReplyProxy$3;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2WlanDiagServiceReplyProxy$4;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;

public class MMX2WlanDiagServiceReplyProxy
implements MMX2WlanDiagServiceReply,
IProxyFrontend {
    private static final CallContext context = CallContext.getContext("PROXY.asi.diagnosis.mmx2app.MMX2WlanDiagService");
    private static final int INVALID_HANDLE;
    private Proxy proxy;

    public MMX2WlanDiagServiceReplyProxy() {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("989f8f89-44c6-4314-b598-2523e0a7fcbb", -1, "4c16b9b4-44a6-5f3a-8651-b5a02c1ed480", "asi.diagnosis.mmx2app.MMX2WlanDiagService");
        this.proxy = new Proxy(serviceInstanceID, context);
    }

    @Override
    public Proxy getProxy() {
        return this.proxy;
    }

    @Override
    public void requestWlanProperties(long l) {
        MMX2WlanDiagServiceReplyProxy$1 mMX2WlanDiagServiceReplyProxy$1 = new MMX2WlanDiagServiceReplyProxy$1(this, l);
        this.proxy.remoteCallMethod((short)1, mMX2WlanDiagServiceReplyProxy$1);
    }

    @Override
    public void requestSetWlanHotSpotActive(long l, boolean bl) {
        MMX2WlanDiagServiceReplyProxy$2 mMX2WlanDiagServiceReplyProxy$2 = new MMX2WlanDiagServiceReplyProxy$2(this, l, bl);
        this.proxy.remoteCallMethod((short)14, mMX2WlanDiagServiceReplyProxy$2);
    }

    @Override
    public void requestWlanHotSpotActive(long l) {
        MMX2WlanDiagServiceReplyProxy$3 mMX2WlanDiagServiceReplyProxy$3 = new MMX2WlanDiagServiceReplyProxy$3(this, l);
        this.proxy.remoteCallMethod((short)16, mMX2WlanDiagServiceReplyProxy$3);
    }

    @Override
    public void requestWlanConnectToAP(long l, boolean bl, String string, String string2, int n) {
        MMX2WlanDiagServiceReplyProxy$4 mMX2WlanDiagServiceReplyProxy$4 = new MMX2WlanDiagServiceReplyProxy$4(this, l, bl, string, string2, n);
        this.proxy.remoteCallMethod((short)21, mMX2WlanDiagServiceReplyProxy$4);
    }
}

