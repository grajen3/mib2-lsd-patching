/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl;

import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sClientResponseError;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.MMX2SwdlDiagService;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.MMX2SwdlDiagServiceC;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.MMX2SwdlDiagServiceReply;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2SwdlDiagServiceProxy$1;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2SwdlDiagServiceProxy$2;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2SwdlDiagServiceReplyService;
import de.esolutions.fw.comm.asi.diagnosis.swdl.sModuleVersionNumbers;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;

public class MMX2SwdlDiagServiceProxy
implements MMX2SwdlDiagService,
MMX2SwdlDiagServiceC {
    private static final CallContext context = CallContext.getContext("PROXY.asi.diagnosis.mmx2app.MMX2SwdlDiagService");
    private Proxy proxy;

    public MMX2SwdlDiagServiceProxy(int n, MMX2SwdlDiagServiceReply mMX2SwdlDiagServiceReply) {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("229d40ff-d184-467e-b62b-7947f55cce40", n, "ff9a2a97-610f-5d16-aa8f-2c4cc52cde72", "asi.diagnosis.mmx2app.MMX2SwdlDiagService");
        MMX2SwdlDiagServiceReplyService mMX2SwdlDiagServiceReplyService = new MMX2SwdlDiagServiceReplyService(mMX2SwdlDiagServiceReply);
        this.proxy = new Proxy(serviceInstanceID, mMX2SwdlDiagServiceReplyService, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    @Override
    public void responseErrorSwdl(sClientResponseError sClientResponseError2) {
        MMX2SwdlDiagServiceProxy$1 mMX2SwdlDiagServiceProxy$1 = new MMX2SwdlDiagServiceProxy$1(this, sClientResponseError2);
        this.proxy.remoteCallMethod((short)8, mMX2SwdlDiagServiceProxy$1);
    }

    @Override
    public void responseModuleVersionNumbers(sModuleVersionNumbers sModuleVersionNumbers2) {
        MMX2SwdlDiagServiceProxy$2 mMX2SwdlDiagServiceProxy$2 = new MMX2SwdlDiagServiceProxy$2(this, sModuleVersionNumbers2);
        this.proxy.remoteCallMethod((short)2, mMX2SwdlDiagServiceProxy$2);
    }
}

