/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl;

import de.esolutions.fw.comm.asi.diagnosis.mmx2app.MMX2SpeechDiagServiceReply;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2SpeechDiagServiceReplyProxy$1;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2SpeechDiagServiceReplyProxy$2;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;

public class MMX2SpeechDiagServiceReplyProxy
implements MMX2SpeechDiagServiceReply,
IProxyFrontend {
    private static final CallContext context = CallContext.getContext("PROXY.asi.diagnosis.mmx2app.MMX2SpeechDiagService");
    private static final int INVALID_HANDLE;
    private Proxy proxy;

    public MMX2SpeechDiagServiceReplyProxy() {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("4f78da63-d498-4434-ab5e-fa9f885161d9", -1, "a2d49b2d-4c62-50ff-80c8-74891c1909b9", "asi.diagnosis.mmx2app.MMX2SpeechDiagService");
        this.proxy = new Proxy(serviceInstanceID, context);
    }

    @Override
    public Proxy getProxy() {
        return this.proxy;
    }

    @Override
    public void requestCommandSDS(long l) {
        MMX2SpeechDiagServiceReplyProxy$1 mMX2SpeechDiagServiceReplyProxy$1 = new MMX2SpeechDiagServiceReplyProxy$1(this, l);
        this.proxy.remoteCallMethod((short)0, mMX2SpeechDiagServiceReplyProxy$1);
    }

    @Override
    public void requestCountryRegionVersion(long l) {
        MMX2SpeechDiagServiceReplyProxy$2 mMX2SpeechDiagServiceReplyProxy$2 = new MMX2SpeechDiagServiceReplyProxy$2(this, l);
        this.proxy.remoteCallMethod((short)12, mMX2SpeechDiagServiceReplyProxy$2);
    }
}

