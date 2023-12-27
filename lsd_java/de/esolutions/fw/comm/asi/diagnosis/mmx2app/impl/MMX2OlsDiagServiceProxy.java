/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl;

import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sClientResponseError;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.MMX2OlsDiagService;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.MMX2OlsDiagServiceC;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.MMX2OlsDiagServiceReply;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2OlsDiagServiceProxy$1;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2OlsDiagServiceProxy$2;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2OlsDiagServiceProxy$3;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2OlsDiagServiceReplyService;
import de.esolutions.fw.comm.asi.diagnosis.ols.sActivationState;
import de.esolutions.fw.comm.asi.diagnosis.ols.sConnectionState;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;

public class MMX2OlsDiagServiceProxy
implements MMX2OlsDiagService,
MMX2OlsDiagServiceC {
    private static final CallContext context = CallContext.getContext("PROXY.asi.diagnosis.mmx2app.MMX2OlsDiagService");
    private Proxy proxy;

    public MMX2OlsDiagServiceProxy(int n, MMX2OlsDiagServiceReply mMX2OlsDiagServiceReply) {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("424a4ae2-a7c9-4146-810b-30406bca0fdc", n, "e8d46886-db30-5882-ad53-07b965ab808b", "asi.diagnosis.mmx2app.MMX2OlsDiagService");
        MMX2OlsDiagServiceReplyService mMX2OlsDiagServiceReplyService = new MMX2OlsDiagServiceReplyService(mMX2OlsDiagServiceReply);
        this.proxy = new Proxy(serviceInstanceID, mMX2OlsDiagServiceReplyService, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    @Override
    public void responseErrorOls(sClientResponseError sClientResponseError2) {
        MMX2OlsDiagServiceProxy$1 mMX2OlsDiagServiceProxy$1 = new MMX2OlsDiagServiceProxy$1(this, sClientResponseError2);
        this.proxy.remoteCallMethod((short)7, mMX2OlsDiagServiceProxy$1);
    }

    @Override
    public void responseConnectionState(sConnectionState sConnectionState2) {
        MMX2OlsDiagServiceProxy$2 mMX2OlsDiagServiceProxy$2 = new MMX2OlsDiagServiceProxy$2(this, sConnectionState2);
        this.proxy.remoteCallMethod((short)6, mMX2OlsDiagServiceProxy$2);
    }

    @Override
    public void responseActivationState(sActivationState sActivationState2) {
        MMX2OlsDiagServiceProxy$3 mMX2OlsDiagServiceProxy$3 = new MMX2OlsDiagServiceProxy$3(this, sActivationState2);
        this.proxy.remoteCallMethod((short)5, mMX2OlsDiagServiceProxy$3);
    }
}

