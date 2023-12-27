/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl;

import de.esolutions.fw.comm.asi.diagnosis.mmx2app.MMX2AppDtcTestServiceReply;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2AppDtcTestServiceReplyProxy$1;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2AppDtcTestServiceReplyProxy$2;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2AppDtcTestServiceReplyProxy$3;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;

public class MMX2AppDtcTestServiceReplyProxy
implements MMX2AppDtcTestServiceReply,
IProxyFrontend {
    private static final CallContext context = CallContext.getContext("PROXY.asi.diagnosis.mmx2app.MMX2AppDtcTestService");
    private static final int INVALID_HANDLE;
    private Proxy proxy;

    public MMX2AppDtcTestServiceReplyProxy() {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("9e79c740-f61e-42bd-a575-c0c06d5f623b", -1, "48e93f98-718a-5f3c-9e06-ed7a0c0371b1", "asi.diagnosis.mmx2app.MMX2AppDtcTestService");
        this.proxy = new Proxy(serviceInstanceID, context);
    }

    @Override
    public Proxy getProxy() {
        return this.proxy;
    }

    @Override
    public void registerForDiagnosisAck(int n) {
        MMX2AppDtcTestServiceReplyProxy$1 mMX2AppDtcTestServiceReplyProxy$1 = new MMX2AppDtcTestServiceReplyProxy$1(this, n);
        this.proxy.remoteCallMethod((short)4, mMX2AppDtcTestServiceReplyProxy$1);
    }

    @Override
    public void performTest(long l) {
        MMX2AppDtcTestServiceReplyProxy$2 mMX2AppDtcTestServiceReplyProxy$2 = new MMX2AppDtcTestServiceReplyProxy$2(this, l);
        this.proxy.remoteCallMethod((short)2, mMX2AppDtcTestServiceReplyProxy$2);
    }

    @Override
    public void performAllTests() {
        MMX2AppDtcTestServiceReplyProxy$3 mMX2AppDtcTestServiceReplyProxy$3 = new MMX2AppDtcTestServiceReplyProxy$3(this);
        this.proxy.remoteCallMethod((short)1, mMX2AppDtcTestServiceReplyProxy$3);
    }
}

